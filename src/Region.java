public final class Region {

   static byte[][][] underlayFloorIds;
   static byte[][][] overlayClippingPaths;
   static final int[] ROTATION_VALUES;
   static final int[] ORIENTATION_VALUES;
   static final int[] orientationXOffsets;
   static final int[] orientationYOffsets;
   static int minRandom;
   static int maxRandom;
   static int[][][] tileHeightArray;
   static byte[][][] renderRuleFlags;
   static byte[][][] overlayFloorIds;

   static {
      tileHeightArray = new int[4][105][105];
      renderRuleFlags = new byte[4][104][104];
      ROTATION_VALUES = new int[] {1, 2, 4, 8};
      ORIENTATION_VALUES = new int[] {16, 32, 64, 128};
      orientationXOffsets = new int[] {1, 0, -1, 0};
      orientationYOffsets = new int[] {0, -1, 0, 1};
      minRandom = (int)(Math.random() * 17.0D) - 8;
      maxRandom = (int)(Math.random() * 33.0D) - 16;
   }

   static void decodeLocalRegion(byte[] data, int localX, int localY, int regionX, int regionY, CollisionMap[] collisionMaps) {
      int baseX;
      int baseY;
      for (int plane = 0; plane < 4; plane++) {
         for (baseX = 0; baseX < 64; baseX++) {
            for (baseY = 0; baseY < 64; baseY++) {
               if (baseX + localX > 0 && baseX + localX < 103 && baseY + localY > 0 && baseY + localY < 103) {
                  collisionMaps[plane].adjacency[baseX + localX][baseY + localY] &= 0xFEFFFFFF;
               }
            }
         }
      }

      Buffer buffer = new Buffer(data);
      for (baseX = 0; baseX < 4; baseX++) {
         for (baseY = 0; baseY < 64; baseY++) {
            for (int actualBaseY = 0; actualBaseY < 64; actualBaseY++) {
               readTileData(buffer, baseX, baseY + localX, actualBaseY + localY, regionX, regionY, 0);
            }
         }
      }
   }

   static void readTileData(Buffer buffer, int plane, int localX, int localY, int regionX, int regionY, int rotationOffset) {
      int opcode;
      if (localX >= 0 && localX < 104 && localY >= 0 && localY < 104) {
         renderRuleFlags[plane][localX][localY] = 0;

         while (true) {
            opcode = buffer.getUnsignedByte();
            if (opcode == 0) {
               if (plane == 0) {
                  int[] heights = tileHeightArray[0][localX];
                  int tileX = localX + regionX + 932731;
                  int tileY = localY + regionY + 556238;
                  int mapHeight = getTileHeight(45365 + tileX, tileY + 91923, 4) - 128 + (getTileHeight(tileX + 10294, 37821 + tileY, 2) - 128 >> 1) + (getTileHeight(tileX, tileY, 1) - 128 >> 2);
                  mapHeight = (int)((double)mapHeight * 0.3D) + 35;
                  if (mapHeight < 10) {
                     mapHeight = 10;
                  } else if (mapHeight > 60) {
                     mapHeight = 60;
                  }

                  heights[localY] = -mapHeight * 8;
               } else {
                  tileHeightArray[plane][localX][localY] = tileHeightArray[plane - 1][localX][localY] - 240;
               }
               break;
            }

            if (opcode == 1) {
               int heightOffset = buffer.getUnsignedByte();
               if (heightOffset == 1) {
                  heightOffset = 0;
               }

               if (plane == 0) {
                  tileHeightArray[0][localX][localY] = -heightOffset * 8;
               } else {
                  tileHeightArray[plane][localX][localY] = tileHeightArray[plane - 1][localX][localY] - heightOffset * 8;
               }
               break;
            }

            if (opcode <= 49) {
               overlayFloorIds[plane][localX][localY] = buffer.readByte();
               overlayClippingPaths[plane][localX][localY] = (byte)((opcode - 2) / 4);
               Class7.overlayRotations[plane][localX][localY] = (byte)(opcode - 2 + rotationOffset & 0x3);
            } else if (opcode <= 81) {
               renderRuleFlags[plane][localX][localY] = (byte)(opcode - 49);
            } else {
               underlayFloorIds[plane][localX][localY] = (byte)(opcode - 81);
            }
         }
      } else {
         while (true) {
            opcode = buffer.getUnsignedByte();
            if (opcode == 0) {
               break;
            }

            if (opcode == 1) {
               buffer.getUnsignedByte();
               break;
            }

            if (opcode <= 49) {
               buffer.getUnsignedByte();
            }
         }
      }
   }

   static int getTileHeight(int tileX, int tileY, int divider) {
      int x1 = tileX / divider;
      int x2 = tileX & divider - 1;
      int y1 = tileY / divider;
      int y2 = tileY & divider - 1;
      int height = calculateTileHeightFromSurrounding(x1, y1);
      int heightEast = calculateTileHeightFromSurrounding(x1 + 1, y1);
      int heightNorth = calculateTileHeightFromSurrounding(x1, y1 + 1);
      int heightNorthEast = calculateTileHeightFromSurrounding(x1 + 1, y1 + 1);
      int rotatedHeight1 = interpolate(height, heightEast, x2, divider);
      int rotatedHeight2 = interpolate(heightNorth, heightNorthEast, x2, divider);
      return interpolate(rotatedHeight1, rotatedHeight2, y2, divider);
   }

   static int calculateNoise(int regionX, int regionY) {
      int regionTileHash = regionY * 57 + regionX;
      regionTileHash ^= regionTileHash << 13;
      int noise = (regionTileHash * regionTileHash * 15731 + 789221) * regionTileHash + 1376312589 & 0x7FFFFFFF;
      return noise >> 19 & 0xFF;
   }

   static int calculateTileHeightFromSurrounding(int regionX, int regionY) {
      int cornerHeight = calculateNoise(regionX - 1, regionY - 1) + calculateNoise(1 + regionX, regionY - 1) + calculateNoise(regionX - 1, regionY + 1) + calculateNoise(1 + regionX, 1 + regionY);
      int sideHeight = calculateNoise(regionX - 1, regionY) + calculateNoise(1 + regionX, regionY) + calculateNoise(regionX, regionY - 1) + calculateNoise(regionX, 1 + regionY);
      int centreHeight = calculateNoise(regionX, regionY);
      return cornerHeight / 16 + sideHeight / 8 + centreHeight / 4;
   }

   static int interpolate(int a, int b, int angle, int frequencyReciprocal) {
      int cosine = 65536 - Graphics3D.COSINE[angle * 1024 / frequencyReciprocal] >> 1;
      return ((65536 - cosine) * a >> 16) + (cosine * b >> 16);
   }

   static void decodeLandscapeTile(byte[] landscapeData, int plane, int baseX, int baseY, int height, int localX, int localY, int orientation, CollisionMap[] collisionMaps) {
       int yOffset;
       for (int xOffset = 0; xOffset < 8; xOffset++) {
           for (yOffset = 0; yOffset < 8; yOffset++) {
               if (xOffset + baseX > 0 && xOffset + baseX < 103 && baseY + yOffset > 0 && baseY + yOffset < 103) {
                   collisionMaps[plane].adjacency[xOffset + baseX][baseY + yOffset] &= 0xFEFFFFFF;
               }
           }
       }

       Buffer buffer = new Buffer(landscapeData);

       for (yOffset = 0; yOffset < 4; yOffset++) {
           for (int x = 0; x < 64; x++) {
               for (int y = 0; y < 64; y++) {
                   if (yOffset == height && x >= localX && x < localX + 8 && y >= localY && y < localY + 8) {
                       int rotatedX = baseX + Client.getRotatedMapChunk(x & 0x7, y & 0x7, orientation);
                       int rotationX = x & 0x7;
                       int rotationY = y & 0x7;
                       int rotation = orientation & 0x3;
                       int rotationOffset;
                       if (rotation == 0) {
                           rotationOffset = rotationY;
                       } else if (rotation == 1) {
                           rotationOffset = 7 - rotationX;
                       } else if (rotation == 2) {
                           rotationOffset = 7 - rotationY;
                       } else {
                           rotationOffset = rotationX;
                       }

                       readTileData(buffer, plane, rotatedX, baseY + rotationOffset, 0, 0, orientation);
                   } else {
                       readTileData(buffer, 0, -1, -1, 0, 0, 0);
                   }
               }
           }
       }

   }

   static void shiftVertexHeights(int plane, int localX, int localY) {
      int x;
      for (x = 0; x < 8; x++) {
         for (int y = 0; y < 8; y++) {
            tileHeightArray[plane][x + localX][y + localY] = 0;
         }
      }

      if (localX > 0) {
         for (x = 1; x < 8; x++) {
            tileHeightArray[plane][localX][x + localY] = tileHeightArray[plane][localX - 1][x + localY];
         }
      }

      if (localY > 0) {
         for (x = 1; x < 8; x++) {
            tileHeightArray[plane][x + localX][localY] = tileHeightArray[plane][x + localX][localY - 1];
         }
      }

      if (localX > 0 && tileHeightArray[plane][localX - 1][localY] != 0) {
         tileHeightArray[plane][localX][localY] = tileHeightArray[plane][localX - 1][localY];
      } else if (localY > 0 && tileHeightArray[plane][localX][localY - 1] != 0) {
         tileHeightArray[plane][localX][localY] = tileHeightArray[plane][localX][localY - 1];
      } else if (localX > 0 && localY > 0 && tileHeightArray[plane][localX - 1][localY - 1] != 0) {
         tileHeightArray[plane][localX][localY] = tileHeightArray[plane][localX - 1][localY - 1];
      }

   }

   static void decodeLandscapes(byte[] data, int absX, int absY, SceneGraph sceneGraph, CollisionMap[] map) {
      Buffer buffer = new Buffer(data);
      int objectId = -1;

      while (true) {
         int objectIdOffset = buffer.getUSmart();
         if (objectIdOffset == 0) {
            return;
         }

         objectId += objectIdOffset;
         int locationInfo = 0;

         while (true) {
            int locationOffset = buffer.getUSmart();
            if (locationOffset == 0) {
               break;
            }

            locationInfo += locationOffset - 1;
            int localY = locationInfo & 0x3F;
            int localX = locationInfo >> 6 & 0x3F;
            int plane = locationInfo >> 12;
            int objectData = buffer.getUnsignedByte();
            int type = objectData >> 2;
            int rotation = objectData & 0x3;
            int objectX = localX + absX;
            int objectY = localY + absY;
            if (objectX > 0 && objectY > 0 && objectX < 103 && objectY < 103) {
               int height = plane;
               if ((renderRuleFlags[1][objectX][objectY] & 0x2) == 2) {
                  height = plane - 1;
               }

               CollisionMap collisionMap = null;
               if (height >= 0) {
                  collisionMap = map[height];
               }

               addObject(plane, objectX, objectY, objectId, rotation, type, sceneGraph, collisionMap);
            }
         }
      }
   }

   static void addObject(int plane, int regionX, int regionY, int objectId, int orientation, int type, SceneGraph sceneGraph, CollisionMap collisionMap) {
      if (!Client.lowMemory || (renderRuleFlags[0][regionX][regionY] & 0x2) != 0 || (renderRuleFlags[plane][regionX][regionY] & 0x10) == 0) {
         if (plane < SceneGraph.lowestPlane) {
            SceneGraph.lowestPlane = plane;
         }

         ObjectDefinition definition = ObjectDefinition.getDefinition(objectId);
         int sizeX;
         int sizeY;
         if (orientation != 1 && orientation != 3) {
            sizeX = definition.sizeX;
            sizeY = definition.sizeY;
         } else {
            sizeX = definition.sizeY;
            sizeY = definition.sizeX;
         }

         int modX;
         int modX1;
         if (sizeX + regionX <= 104) {
            modX = (sizeX >> 1) + regionX;
            modX1 = (sizeX + 1 >> 1) + regionX;
         } else {
            modX = regionX;
            modX1 = regionX + 1;
         }

         int modY;
         int modY1;
         if (sizeY + regionY <= 104) {
            modY = (sizeY >> 1) + regionY;
            modY1 = regionY + (sizeY + 1 >> 1);
         } else {
            modY = regionY;
            modY1 = regionY + 1;
         }

         int[][] heights = tileHeightArray[plane];
         int mean = heights[modX1][modY1] + heights[modX][modY1] + heights[modX][modY] + heights[modX1][modY] >> 2;
         int vertexX = (regionX << 7) + (sizeX << 6);
         int vertexY = (regionY << 7) + (sizeY << 6);
         int hash = (objectId << 14) + (regionY << 7) + regionX + 1073741824;
         if (definition.hasOptions == 0) {
            hash -= Integer.MIN_VALUE;
         }

         int objectConfig = type + (orientation << 6);
         if (definition.isSolid == 1) {
            objectConfig += 256;
         }

         if (definition.hasAmbientSound()) {
            SceneGraph.addAudioObject(plane, regionX, regionY, definition, orientation);
         }

         Object renderable;
         if (type == 22) {
            if (!Client.lowMemory || definition.hasOptions != 0 || definition.interactType == 1 || definition.needsRedraw) {
               if (definition.animationId == -1 && definition.transformationIds == null) {
                  renderable = definition.getModel(22, orientation, heights, vertexX, mean, vertexY);
               } else {
                  renderable = new GameObject(objectId, 22, orientation, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
               }

               sceneGraph.addFloorDecoration(plane, regionX, regionY, mean, (Renderable) renderable, hash, objectConfig);
               if (definition.interactType == 1 && collisionMap != null) {
                  collisionMap.block(regionX, regionY);
               }

            }
         } else {
            int uid;
            if (type != 10 && type != 11) {
               if (type >= 12) {
                  if (definition.animationId == -1 && definition.transformationIds == null) {
                     renderable = definition.getModel(type, orientation, heights, vertexX, mean, vertexY);
                  } else {
                     renderable = new GameObject(objectId, type, orientation, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                  }

                  sceneGraph.addObject(plane, regionX, regionY, mean, 1, 1, (Renderable) renderable, 0, hash, objectConfig);
                  if (type >= 12 && type <= 17 && type != 13 && plane > 0) {
                     SceneGraph.tileCullingBitsets[plane][regionX][regionY] |= 0x924;
                  }

                  if (definition.interactType != 0 && collisionMap != null) {
                     collisionMap.addObject(regionX, regionY, sizeX, sizeY, definition.projectileClipped);
                  }

               } else if (type == 0) {
                  if (definition.animationId == -1 && definition.transformationIds == null) {
                     renderable = definition.getModel(0, orientation, heights, vertexX, mean, vertexY);
                  } else {
                     renderable = new GameObject(objectId, 0, orientation, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                  }

                  sceneGraph.addWall(plane, regionX, regionY, mean, (Renderable) renderable, (Renderable) null, ROTATION_VALUES[orientation], 0, hash, objectConfig);
                  if (orientation == 0) {
                     if (definition.hasModel) {
                        SceneGraph.tileShadowIntensity[plane][regionX][regionY] = 50;
                        SceneGraph.tileShadowIntensity[plane][regionX][regionY + 1] = 50;
                     }

                     if (definition.needsCulling) {
                        SceneGraph.tileCullingBitsets[plane][regionX][regionY] |= 0x249;
                     }
                  } else if (orientation == 1) {
                     if (definition.hasModel) {
                        SceneGraph.tileShadowIntensity[plane][regionX][regionY + 1] = 50;
                        SceneGraph.tileShadowIntensity[plane][regionX + 1][regionY + 1] = 50;
                     }

                     if (definition.needsCulling) {
                        SceneGraph.tileCullingBitsets[plane][regionX][1 + regionY] |= 0x492;
                     }
                  } else if (orientation == 2) {
                     if (definition.hasModel) {
                        SceneGraph.tileShadowIntensity[plane][regionX + 1][regionY] = 50;
                        SceneGraph.tileShadowIntensity[plane][regionX + 1][regionY + 1] = 50;
                     }

                     if (definition.needsCulling) {
                        SceneGraph.tileCullingBitsets[plane][regionX + 1][regionY] |= 0x249;
                     }
                  } else if (orientation == 3) {
                     if (definition.hasModel) {
                        SceneGraph.tileShadowIntensity[plane][regionX][regionY] = 50;
                        SceneGraph.tileShadowIntensity[plane][regionX + 1][regionY] = 50;
                     }

                     if (definition.needsCulling) {
                        SceneGraph.tileCullingBitsets[plane][regionX][regionY] |= 0x492;
                     }
                  }

                  if (definition.interactType != 0 && collisionMap != null) {
                     collisionMap.addWall(regionX, regionY, type, orientation, definition.projectileClipped);
                  }

                  if (definition.offsetMultiplier != 16) {
                     sceneGraph.offsetWallObject(plane, regionX, regionY, definition.offsetMultiplier);
                  }

               } else if (type == 1) {
                  if (definition.animationId == -1 && definition.transformationIds == null) {
                     renderable = definition.getModel(1, orientation, heights, vertexX, mean, vertexY);
                  } else {
                     renderable = new GameObject(objectId, 1, orientation, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                  }

                  sceneGraph.addWall(plane, regionX, regionY, mean, (Renderable) renderable, (Renderable) null, ORIENTATION_VALUES[orientation], 0, hash, objectConfig);
                  if (definition.hasModel) {
                     if (orientation == 0) {
                        SceneGraph.tileShadowIntensity[plane][regionX][regionY + 1] = 50;
                     } else if (orientation == 1) {
                        SceneGraph.tileShadowIntensity[plane][regionX + 1][regionY + 1] = 50;
                     } else if (orientation == 2) {
                        SceneGraph.tileShadowIntensity[plane][regionX + 1][regionY] = 50;
                     } else if (orientation == 3) {
                        SceneGraph.tileShadowIntensity[plane][regionX][regionY] = 50;
                     }
                  }

                  if (definition.interactType != 0 && collisionMap != null) {
                     collisionMap.addWall(regionX, regionY, type, orientation, definition.projectileClipped);
                  }

               } else {
                  int offsetMultiplier;
                  Object secondaryRenderable;
                  if (type == 2) {
                     offsetMultiplier = orientation + 1 & 0x3;
                     Object primaryRenderable;
                     if (definition.animationId == -1 && definition.transformationIds == null) {
                        primaryRenderable = definition.getModel(2, orientation + 4, heights, vertexX, mean, vertexY);
                        secondaryRenderable = definition.getModel(2, offsetMultiplier, heights, vertexX, mean, vertexY);
                     } else {
                        primaryRenderable = new GameObject(objectId, 2, orientation + 4, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                        secondaryRenderable = new GameObject(objectId, 2, offsetMultiplier, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                     }

                     sceneGraph.addWall(plane, regionX, regionY, mean, (Renderable) primaryRenderable, (Renderable) secondaryRenderable, ROTATION_VALUES[orientation], ROTATION_VALUES[offsetMultiplier], hash, objectConfig);
                     if (definition.needsCulling) {
                        if (orientation == 0) {
                           SceneGraph.tileCullingBitsets[plane][regionX][regionY] |= 0x249;
                           SceneGraph.tileCullingBitsets[plane][regionX][regionY + 1] |= 0x492;
                        } else if (orientation == 1) {
                           SceneGraph.tileCullingBitsets[plane][regionX][1 + regionY] |= 0x492;
                           SceneGraph.tileCullingBitsets[plane][regionX + 1][regionY] |= 0x249;
                        } else if (orientation == 2) {
                           SceneGraph.tileCullingBitsets[plane][regionX + 1][regionY] |= 0x249;
                           SceneGraph.tileCullingBitsets[plane][regionX][regionY] |= 0x492;
                        } else if (orientation == 3) {
                           SceneGraph.tileCullingBitsets[plane][regionX][regionY] |= 0x492;
                           SceneGraph.tileCullingBitsets[plane][regionX][regionY] |= 0x249;
                        }
                     }

                     if (definition.interactType != 0 && collisionMap != null) {
                        collisionMap.addWall(regionX, regionY, type, orientation, definition.projectileClipped);
                     }

                     if (definition.offsetMultiplier != 16) {
                        sceneGraph.offsetWallObject(plane, regionX, regionY, definition.offsetMultiplier);
                     }

                  } else if (type == 3) {
                     if (definition.animationId == -1 && definition.transformationIds == null) {
                        renderable = definition.getModel(3, orientation, heights, vertexX, mean, vertexY);
                     } else {
                        renderable = new GameObject(objectId, 3, orientation, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                     }

                     sceneGraph.addWall(plane, regionX, regionY, mean, (Renderable) renderable, (Renderable) null, ORIENTATION_VALUES[orientation], 0, hash, objectConfig);
                     if (definition.hasModel) {
                        if (orientation == 0) {
                           SceneGraph.tileShadowIntensity[plane][regionX][regionY + 1] = 50;
                        } else if (orientation == 1) {
                           SceneGraph.tileShadowIntensity[plane][regionX + 1][regionY + 1] = 50;
                        } else if (orientation == 2) {
                           SceneGraph.tileShadowIntensity[plane][regionX + 1][regionY] = 50;
                        } else if (orientation == 3) {
                           SceneGraph.tileShadowIntensity[plane][regionX][regionY] = 50;
                        }
                     }

                     if (definition.interactType != 0 && collisionMap != null) {
                        collisionMap.addWall(regionX, regionY, type, orientation, definition.projectileClipped);
                     }

                  } else if (type == 9) {
                     if (definition.animationId == -1 && definition.transformationIds == null) {
                        renderable = definition.getModel(type, orientation, heights, vertexX, mean, vertexY);
                     } else {
                        renderable = new GameObject(objectId, type, orientation, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                     }

                     sceneGraph.addObject(plane, regionX, regionY, mean, 1, 1, (Renderable) renderable, 0, hash, objectConfig);
                     if (definition.interactType != 0 && collisionMap != null) {
                        collisionMap.addObject(regionX, regionY, sizeX, sizeY, definition.projectileClipped);
                     }

                     if (definition.offsetMultiplier != 16) {
                        sceneGraph.offsetWallObject(plane, regionX, regionY, definition.offsetMultiplier);
                     }

                  } else if (type == 4) {
                     if (definition.animationId == -1 && definition.transformationIds == null) {
                        renderable = definition.getModel(4, orientation, heights, vertexX, mean, vertexY);
                     } else {
                        renderable = new GameObject(objectId, 4, orientation, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                     }

                     sceneGraph.addWallDecoration(plane, regionX, regionY, mean, (Renderable) renderable, (Renderable) null, ROTATION_VALUES[orientation], 0, 0, 0, hash, objectConfig);
                  } else if (type == 5) {
                     offsetMultiplier = 16;
                     uid = sceneGraph.getWallObjectUID(plane, regionX, regionY);
                     if (uid != 0) {
                        offsetMultiplier = ObjectDefinition.getDefinition(uid >> 14 & 0x7FFF).offsetMultiplier;
                     }

                     if (definition.animationId == -1 && definition.transformationIds == null) {
                        secondaryRenderable = definition.getModel(4, orientation, heights, vertexX, mean, vertexY);
                     } else {
                        secondaryRenderable = new GameObject(objectId, 4, orientation, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                     }

                     sceneGraph.addWallDecoration(plane, regionX, regionY, mean, (Renderable) secondaryRenderable, (Renderable) null, ROTATION_VALUES[orientation], 0, offsetMultiplier * orientationXOffsets[orientation], offsetMultiplier * orientationYOffsets[orientation], hash, objectConfig);
                  } else if (type == 6) {
                     offsetMultiplier = 8;
                     uid = sceneGraph.getWallObjectUID(plane, regionX, regionY);
                     if (uid != 0) {
                        offsetMultiplier = ObjectDefinition.getDefinition(uid >> 14 & 0x7FFF).offsetMultiplier / 2;
                     }

                     if (definition.animationId == -1 && definition.transformationIds == null) {
                        secondaryRenderable = definition.getModel(4, orientation + 4, heights, vertexX, mean, vertexY);
                     } else {
                        secondaryRenderable = new GameObject(objectId, 4, orientation + 4, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                     }

                     sceneGraph.addWallDecoration(plane, regionX, regionY, mean, (Renderable) secondaryRenderable, (Renderable) null, 256, orientation, offsetMultiplier * SceneGraph.anIntArray13[orientation], offsetMultiplier * SceneGraph.anIntArray14[orientation], hash, objectConfig);
                  } else if (type == 7) {
                     uid = orientation + 2 & 0x3;
                     if (definition.animationId == -1 && definition.transformationIds == null) {
                        renderable = definition.getModel(4, uid + 4, heights, vertexX, mean, vertexY);
                     } else {
                        renderable = new GameObject(objectId, 4, uid + 4, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                     }

                     sceneGraph.addWallDecoration(plane, regionX, regionY, mean, (Renderable) renderable, (Renderable) null, 256, uid, 0, 0, hash, objectConfig);
                  } else if (type == 8) {
                     offsetMultiplier = 8;
                     uid = sceneGraph.getWallObjectUID(plane, regionX, regionY);
                     if (uid != 0) {
                        offsetMultiplier = ObjectDefinition.getDefinition(uid >> 14 & 0x7FFF).offsetMultiplier / 2;
                     }

                     int faceHash = orientation + 2 & 0x3;
                     Object tertiaryRenderable;
                     if (definition.animationId == -1 && definition.transformationIds == null) {
                        secondaryRenderable = definition.getModel(4, orientation + 4, heights, vertexX, mean, vertexY);
                        tertiaryRenderable = definition.getModel(4, faceHash + 4, heights, vertexX, mean, vertexY);
                     } else {
                        secondaryRenderable = new GameObject(objectId, 4, orientation + 4, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                        tertiaryRenderable = new GameObject(objectId, 4, faceHash + 4, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                     }

                     sceneGraph.addWallDecoration(plane, regionX, regionY, mean, (Renderable) secondaryRenderable, (Renderable) tertiaryRenderable, 256, orientation, offsetMultiplier * SceneGraph.anIntArray13[orientation], offsetMultiplier * SceneGraph.anIntArray14[orientation], hash, objectConfig);
                  }
               }
            } else {
               if (definition.animationId == -1 && definition.transformationIds == null) {
                  renderable = definition.getModel(10, orientation, heights, vertexX, mean, vertexY);
               } else {
                  renderable = new GameObject(objectId, 10, orientation, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
               }

               if (renderable != null && sceneGraph.addObject(plane, regionX, regionY, mean, sizeX, sizeY, (Renderable) renderable, type == 11 ? 256 : 0, hash, objectConfig) && definition.hasModel) {
                  uid = 15;
                  if (renderable instanceof Model) {
                     uid = ((Model) renderable).getShadowIntensity() / 4;
                     if (uid > 30) {
                        uid = 30;
                     }
                  }

                  for (int x = 0; x <= sizeX; x++) {
                     for (int y = 0; y <= sizeY; y++) {
                        if (uid > SceneGraph.tileShadowIntensity[plane][x + regionX][y + regionY]) {
                           SceneGraph.tileShadowIntensity[plane][x + regionX][y + regionY] = (byte)uid;
                        }
                     }
                  }
               }

               if (definition.interactType != 0 && collisionMap != null) {
                  collisionMap.addObject(regionX, regionY, sizeX, sizeY, definition.projectileClipped);
               }
            }
         }
      }
   }

   static void spawnObject(int floorLevel, int spawnType, int x, int y, int objId, int orientation, int objType) {
      if (x >= 1 && y >= 1 && x <= 102 && y <= 102) {
         if (Client.lowMemory && floorLevel != Ignore.plane) {
            return;
         }

         int hash = 0;
         boolean bool_0 = true;
         boolean bool_1 = false;
         boolean bool_2 = false;
         if (spawnType == 0) {
            hash = Class23.sceneGraph.getWallObjectUID(floorLevel, x, y);
         }

         if (spawnType == 1) {
            hash = Class23.sceneGraph.getWallDecorationUID(floorLevel, x, y);
         }

         if (spawnType == 2) {
            hash = Class23.sceneGraph.getInteractableObjectUID(floorLevel, x, y);
         }

         if (spawnType == 3) {
            hash = Class23.sceneGraph.getGroundDecorationUID(floorLevel, x, y);
         }

         int config;
         if (hash != 0) {
            config = Class23.sceneGraph.getObjectConfig(floorLevel, x, y, hash);
            int objectType = hash >> 14 & 0x7FFF;
            int position = config & 0x1F;
            int face = config >> 6 & 0x3;
            ObjectDefinition definition;
            if (spawnType == 0) {
               Class23.sceneGraph.removeWallObjects(floorLevel, x, y);
               definition = ObjectDefinition.getDefinition(objectType);
               if (definition.interactType != 0) {
                  Client.collisionMaps[floorLevel].removeWall(x, y, position, face, definition.projectileClipped);
               }
            }

            if (spawnType == 1) {
               Class23.sceneGraph.removeWallDecorations(floorLevel, x, y);
            }

            if (spawnType == 2) {
               Class23.sceneGraph.removeInteractiveObjects(floorLevel, x, y);
               definition = ObjectDefinition.getDefinition(objectType);
               if (x + definition.sizeX > 103 || y + definition.sizeX > 103 || x + definition.sizeY > 103 || y + definition.sizeY > 103) {
                  return;
               }

               if (definition.interactType != 0) {
                  Client.collisionMaps[floorLevel].removeObject(x, y, definition.sizeX, definition.sizeY, face, definition.projectileClipped);
               }
            }

            if (spawnType == 3) {
               Class23.sceneGraph.removeFloorDecorations(floorLevel, x, y);
               definition = ObjectDefinition.getDefinition(objectType);
               if (definition.interactType == 1) {
                  Client.collisionMaps[floorLevel].unblock(x, y);
               }
            }
         }

         if (objId >= 0) {
            config = floorLevel;
            if (floorLevel < 3 && (renderRuleFlags[1][x][y] & 0x2) == 2) {
               config = floorLevel + 1;
            }

            renderObject(floorLevel, config, x, y, objId, orientation, objType, Class23.sceneGraph, Client.collisionMaps[floorLevel]);
         }
      }

   }

   static void renderObject(int floorLevel, int plane, int regionX, int regionY, int objectId, int face, int type, SceneGraph sceneGraph, CollisionMap collisionMap) {
      ObjectDefinition definition = ObjectDefinition.getDefinition(objectId);
      int sizeY;
      int sizeX;
      if (face != 1 && face != 3) {
         sizeY = definition.sizeX;
         sizeX = definition.sizeY;
      } else {
         sizeY = definition.sizeY;
         sizeX = definition.sizeX;
      }

      int modX;
      int modX1;
      if (sizeY + regionX <= 104) {
         modX = (sizeY >> 1) + regionX;
         modX1 = regionX + (sizeY + 1 >> 1);
      } else {
         modX = regionX;
         modX1 = regionX + 1;
      }

      int modY;
      int modY1;
      if (regionY + sizeX <= 104) {
         modY = regionY + (sizeX >> 1);
         modY1 = regionY + (sizeX + 1 >> 1);
      } else {
         modY = regionY;
         modY1 = regionY + 1;
      }

      int[][] heights = tileHeightArray[plane];
      int mean = heights[modX1][modY] + heights[modX][modY] + heights[modX][modY1] + heights[modX1][modY1] >> 2;
      int vertexX = (regionX << 7) + (sizeY << 6);
      int vertexY = (regionY << 7) + (sizeX << 6);
      int hash = (regionY << 7) + regionX + (objectId << 14) + 1073741824;
      if (definition.hasOptions == 0) {
         hash -= Integer.MIN_VALUE;
      }

      int objectConfig = (face << 6) + type;
      if (definition.isSolid == 1) {
         objectConfig += 256;
      }

      Object renderable;
      if (type == 22) {
         if (definition.animationId == -1 && definition.transformationIds == null) {
            renderable = definition.getModelAt(22, face, heights, vertexX, mean, vertexY);
         } else {
            renderable = new GameObject(objectId, 22, face, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
         }

         sceneGraph.addFloorDecoration(floorLevel, regionX, regionY, mean, (Renderable) renderable, hash, objectConfig);
         if (definition.interactType == 1) {
            collisionMap.block(regionX, regionY);
         }

      } else if (type != 10 && type != 11) {
         if (type >= 12) {
            if (definition.animationId == -1 && definition.transformationIds == null) {
               renderable = definition.getModelAt(type, face, heights, vertexX, mean, vertexY);
            } else {
               renderable = new GameObject(objectId, type, face, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
            }

            sceneGraph.addObject(floorLevel, regionX, regionY, mean, 1, 1, (Renderable) renderable, 0, hash, objectConfig);
            if (definition.interactType != 0) {
               collisionMap.addObject(regionX, regionY, sizeY, sizeX, definition.projectileClipped);
            }

         } else if (type == 0) {
            if (definition.animationId == -1 && definition.transformationIds == null) {
               renderable = definition.getModelAt(0, face, heights, vertexX, mean, vertexY);
            } else {
               renderable = new GameObject(objectId, 0, face, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
            }

            sceneGraph.addWall(floorLevel, regionX, regionY, mean, (Renderable) renderable, (Renderable) null, ROTATION_VALUES[face], 0, hash, objectConfig);
            if (definition.interactType != 0) {
               collisionMap.addWall(regionX, regionY, type, face, definition.projectileClipped);
            }

         } else if (type == 1) {
            if (definition.animationId == -1 && definition.transformationIds == null) {
               renderable = definition.getModelAt(1, face, heights, vertexX, mean, vertexY);
            } else {
               renderable = new GameObject(objectId, 1, face, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
            }

            sceneGraph.addWall(floorLevel, regionX, regionY, mean, (Renderable) renderable, (Renderable) null, ORIENTATION_VALUES[face], 0, hash, objectConfig);
            if (definition.interactType != 0) {
               collisionMap.addWall(regionX, regionY, type, face, definition.projectileClipped);
            }

         } else {
            int faceHash;
            Object secondaryRenderable;
            if (type == 2) {
               faceHash = face + 1 & 0x3;
               Object primaryRenderable;
               if (definition.animationId == -1 && definition.transformationIds == null) {
                  primaryRenderable = definition.getModelAt(2, face + 4, heights, vertexX, mean, vertexY);
                  secondaryRenderable = definition.getModelAt(2, faceHash, heights, vertexX, mean, vertexY);
               } else {
                  primaryRenderable = new GameObject(objectId, 2, face + 4, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                  secondaryRenderable = new GameObject(objectId, 2, faceHash, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
               }

               sceneGraph.addWall(floorLevel, regionX, regionY, mean, (Renderable) primaryRenderable, (Renderable) secondaryRenderable, ROTATION_VALUES[face], ROTATION_VALUES[faceHash], hash, objectConfig);
               if (definition.interactType != 0) {
                  collisionMap.addWall(regionX, regionY, type, face, definition.projectileClipped);
               }

            } else if (type == 3) {
               if (definition.animationId == -1 && definition.transformationIds == null) {
                  renderable = definition.getModelAt(3, face, heights, vertexX, mean, vertexY);
               } else {
                  renderable = new GameObject(objectId, 3, face, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
               }

               sceneGraph.addWall(floorLevel, regionX, regionY, mean, (Renderable) renderable, (Renderable) null, ORIENTATION_VALUES[face], 0, hash, objectConfig);
               if (definition.interactType != 0) {
                  collisionMap.addWall(regionX, regionY, type, face, definition.projectileClipped);
               }

            } else if (type == 9) {
               if (definition.animationId == -1 && definition.transformationIds == null) {
                  renderable = definition.getModelAt(type, face, heights, vertexX, mean, vertexY);
               } else {
                  renderable = new GameObject(objectId, type, face, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
               }

               sceneGraph.addObject(floorLevel, regionX, regionY, mean, 1, 1, (Renderable) renderable, 0, hash, objectConfig);
               if (definition.interactType != 0) {
                  collisionMap.addObject(regionX, regionY, sizeY, sizeX, definition.projectileClipped);
               }

            } else if (type == 4) {
               if (definition.animationId == -1 && definition.transformationIds == null) {
                  renderable = definition.getModelAt(4, face, heights, vertexX, mean, vertexY);
               } else {
                  renderable = new GameObject(objectId, 4, face, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
               }

               sceneGraph.addWallDecoration(floorLevel, regionX, regionY, mean, (Renderable) renderable, (Renderable) null, ROTATION_VALUES[face], 0, 0, 0, hash, objectConfig);
            } else {
               int uid;
               if (type == 5) {
                  faceHash = 16;
                  uid = sceneGraph.getWallObjectUID(floorLevel, regionX, regionY);
                  if (uid != 0) {
                     faceHash = ObjectDefinition.getDefinition(uid >> 14 & 0x7FFF).offsetMultiplier;
                  }

                  if (definition.animationId == -1 && definition.transformationIds == null) {
                     secondaryRenderable = definition.getModelAt(4, face, heights, vertexX, mean, vertexY);
                  } else {
                     secondaryRenderable = new GameObject(objectId, 4, face, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                  }

                  sceneGraph.addWallDecoration(floorLevel, regionX, regionY, mean, (Renderable) secondaryRenderable, (Renderable) null, ROTATION_VALUES[face], 0, faceHash * orientationXOffsets[face], faceHash * orientationYOffsets[face], hash, objectConfig);
               } else if (type == 6) {
                  faceHash = 8;
                  uid = sceneGraph.getWallObjectUID(floorLevel, regionX, regionY);
                  if (uid != 0) {
                     faceHash = ObjectDefinition.getDefinition(uid >> 14 & 0x7FFF).offsetMultiplier / 2;
                  }

                  if (definition.animationId == -1 && definition.transformationIds == null) {
                     secondaryRenderable = definition.getModelAt(4, face + 4, heights, vertexX, mean, vertexY);
                  } else {
                     secondaryRenderable = new GameObject(objectId, 4, face + 4, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                  }

                  sceneGraph.addWallDecoration(floorLevel, regionX, regionY, mean, (Renderable) secondaryRenderable, (Renderable) null, 256, face, faceHash * SceneGraph.anIntArray13[face], faceHash * SceneGraph.anIntArray14[face], hash, objectConfig);
               } else if (type == 7) {
                  uid = face + 2 & 0x3;
                  if (definition.animationId == -1 && definition.transformationIds == null) {
                     renderable = definition.getModelAt(4, uid + 4, heights, vertexX, mean, vertexY);
                  } else {
                     renderable = new GameObject(objectId, 4, uid + 4, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                  }

                  sceneGraph.addWallDecoration(floorLevel, regionX, regionY, mean, (Renderable) renderable, (Renderable) null, 256, uid, 0, 0, hash, objectConfig);
               } else if (type == 8) {
                  faceHash = 8;
                  uid = sceneGraph.getWallObjectUID(floorLevel, regionX, regionY);
                  if (uid != 0) {
                     faceHash = ObjectDefinition.getDefinition(uid >> 14 & 0x7FFF).offsetMultiplier / 2;
                  }

                  int rotationHash = face + 2 & 0x3;
                  Object tertiaryRenderable;
                  if (definition.animationId == -1 && definition.transformationIds == null) {
                     secondaryRenderable = definition.getModelAt(4, face + 4, heights, vertexX, mean, vertexY);
                     tertiaryRenderable = definition.getModelAt(4, rotationHash + 4, heights, vertexX, mean, vertexY);
                  } else {
                     secondaryRenderable = new GameObject(objectId, 4, face + 4, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                     tertiaryRenderable = new GameObject(objectId, 4, rotationHash + 4, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                  }

                  sceneGraph.addWallDecoration(floorLevel, regionX, regionY, mean, (Renderable) secondaryRenderable, (Renderable) tertiaryRenderable, 256, face, faceHash * SceneGraph.anIntArray13[face], faceHash * SceneGraph.anIntArray14[face], hash, objectConfig);
               }
            }
         }
      } else {
         if (definition.animationId == -1 && definition.transformationIds == null) {
            renderable = definition.getModelAt(10, face, heights, vertexX, mean, vertexY);
         } else {
            renderable = new GameObject(objectId, 10, face, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
         }

         if (renderable != null) {
            sceneGraph.addObject(floorLevel, regionX, regionY, mean, sizeY, sizeX, (Renderable) renderable, type == 11 ? 256 : 0, hash, objectConfig);
         }

         if (definition.interactType != 0) {
            collisionMap.addObject(regionX, regionY, sizeY, sizeX, definition.projectileClipped);
         }

      }
   }
}
