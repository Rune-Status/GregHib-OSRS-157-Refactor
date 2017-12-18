public class SceneGraph {

   static final int[] anIntArray13;
   static final int[] anIntArray14;
   public static boolean lowMemory;
   static boolean viewportWalking;
   static int[] levelOccluderCount;
   static int processedCullingClustersPointer;
   static Deque tileDeque;
   static int cameraPositionX;
   static int anInt147;
   static int MAX_OCCLUDER_LEVELS;
   public static int clickedTileX;
   static int tileUpdateCount;
   static SceneCluster[] processedCullingClusters;
   static int RENDERABLE_RULE;
   static int cameraPositionY;
   static SceneCluster[][] levelSceneClusters;
   static boolean isClicked;
   static InteractiveObject[] entityBuffer;
   static int anInt148;
   static int cameraY2;
   static int pitchSin;
   static int clickX;
   static int yawSin;
   static int clickY;
   static int yawCos;
   static int pitchCos;
   static int screenCenterX;
   public static int clickedTileY;
   static int screenCenterZ;
   static int minTileX;
   static boolean[][][][] visibilityMaps;
   static int maxTileX;
   static int minTileZ;
   static int maxTileZ;
   static boolean[][] renderArea;
   static final int[] anIntArray35;
   static final int[] anIntArray36;
   static final int[] TILE_WALL_DRAW_FLAGS_1;
   static final int[] WALL_UNCULL_FLAGS_0;
   static int anInt149;
   static int anInt150;
   static int anInt151;
   static int anInt152;
   static int anInt153;
   static final int[] WALL_UNCULL_FLAGS_1;
   static int anInt154;
   static final int[] WALL_UNCULL_FLAGS_2;
   static final int[] WALL_UNCULL_FLAGS_3;
   static int[][][] tileCullingBitsets;
   static byte[][][] tileShadowIntensity;
   static int lowestPlane;
   int minLevel;
   int entityCount;
   int[][][] visibilityMap;
   int mapSizeX;
   int mapSizeZ;
   Tile[][][] tiles;
   InteractiveObject[] interactiveObjectCache;
   int mapSizeY;
   int[][][] tileHeights;
   int[][] TILE_MASK_2D;
   int[][] TILE_ROTATION_2D;

   static {
      anIntArray13 = new int[] {1, -1, -1, 1};
      anIntArray14 = new int[] {-1, -1, 1, 1};
      lowestPlane = 99;
      lowMemory = true;
      tileUpdateCount = 0;
      anInt147 = 0;
      entityBuffer = new InteractiveObject[100];
      isClicked = false;
      anInt148 = 0;
      clickX = 0;
      clickY = 0;
      clickedTileX = -1;
      clickedTileY = -1;
      viewportWalking = false;
      MAX_OCCLUDER_LEVELS = 4;
      levelOccluderCount = new int[MAX_OCCLUDER_LEVELS];
      levelSceneClusters = new SceneCluster[MAX_OCCLUDER_LEVELS][500];
      processedCullingClustersPointer = 0;
      processedCullingClusters = new SceneCluster[500];
      tileDeque = new Deque();
      anIntArray36 = new int[] {19, 55, 38, 155, 255, 110, 137, 205, 76};
      anIntArray35 = new int[] {160, 192, 80, 96, 0, 144, 80, 48, 160};
      TILE_WALL_DRAW_FLAGS_1 = new int[] {76, 8, 137, 4, 0, 1, 38, 2, 19};
      WALL_UNCULL_FLAGS_0 = new int[] {0, 0, 2, 0, 0, 2, 1, 1, 0};
      WALL_UNCULL_FLAGS_1 = new int[] {2, 0, 0, 2, 0, 0, 0, 4, 4};
      WALL_UNCULL_FLAGS_2 = new int[] {0, 4, 4, 8, 0, 0, 8, 0, 0};
      WALL_UNCULL_FLAGS_3 = new int[] {1, 1, 0, 0, 0, 8, 0, 0, 8};
      visibilityMaps = new boolean[8][32][51][51];
   }

   public SceneGraph(int height, int width, int length, int[][][] heightMap) {
      this.minLevel = 0;
      this.entityCount = 0;
      this.interactiveObjectCache = new InteractiveObject[5000];
      this.TILE_MASK_2D = new int[][] {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
      this.TILE_ROTATION_2D = new int[][] {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};
      this.mapSizeZ = height;
      this.mapSizeX = width;
      this.mapSizeY = length;
      this.tiles = new Tile[height][width][length];
      this.visibilityMap = new int[height][width + 1][length + 1];
      this.tileHeights = heightMap;
      this.reset();
   }

   static void addAudioObject(int plane, int regionX, int regionY, ObjectDefinition definition, int orientation) {
      AudioObject object = new AudioObject();
      object.plane = plane;
      object.x = regionX * 128;
      object.y = regionY * 128;
      int sizeX = definition.sizeX;
      int sizeY = definition.sizeY;
      if (orientation == 1 || orientation == 3) {
         sizeX = definition.sizeY;
         sizeY = definition.sizeX;
      }

      object.anInt319 = (sizeX + regionX) * 128;
      object.anInt321 = (sizeY + regionY) * 128;
      object.ambientSound = definition.ambientSoundId;
      object.anInt316 = definition.anInt463 * 128;
      object.anInt317 = definition.anInt464;
      object.anInt318 = definition.anInt465;
      object.anIntArray72 = definition.anIntArray85;
      if (definition.transformationIds != null) {
         object.transformationDefinition = definition;
         object.method632();
      }

      AudioObject.aDeque3.addFront(object);
      if (object.anIntArray72 != null) {
         object.anInt324 = object.anInt317 + (int)(Math.random() * (double)(object.anInt318 - object.anInt317));
      }

   }

   boolean tileRenderable(int y, int x, int z) {
      int currentVisibility = this.visibilityMap[y][x][z];
      if (currentVisibility == -RENDERABLE_RULE) {
         return false;
      } else if (currentVisibility == RENDERABLE_RULE) {
         return true;
      } else {
         int worldX = x << 7;
         int worldZ = z << 7;
         if (this.isTileRendered(worldX + 1, this.tileHeights[y][x][z], worldZ + 1) && this.isTileRendered(worldX + 128 - 1, this.tileHeights[y][x + 1][z], worldZ + 1) && this.isTileRendered(worldX + 128 - 1, this.tileHeights[y][x + 1][z + 1], worldZ + 128 - 1) && this.isTileRendered(worldX + 1, this.tileHeights[y][x][z + 1], worldZ + 128 - 1)) {
            this.visibilityMap[y][x][z] = RENDERABLE_RULE;
            return true;
         } else {
            this.visibilityMap[y][x][z] = -RENDERABLE_RULE;
            return false;
         }
      }
   }

   boolean addRenderable(int plane, int tileX, int tileY, int tileWidth, int tileHeight, int regionX, int regionY, int height, Renderable renderable, int orientation, boolean isDynamic, int hash, int configHash) {
      int y;
      for (int x = tileX; x < tileX + tileWidth; x++) {
         for (y = tileY; y < tileY + tileHeight; y++) {
            if (x < 0 || y < 0 || x >= this.mapSizeX || y >= this.mapSizeY) {
               return false;
            }

            Tile tile = this.tiles[plane][x][y];
            if (tile != null && tile.objectCount >= 5) {
               return false;
            }
         }
      }

      InteractiveObject object = new InteractiveObject();
      object.hash = hash;
      object.objectConfig = configHash;
      object.plane = plane;
      object.x = regionX;
      object.y = regionY;
      object.height = height;
      object.renderable = renderable;
      object.orientation = orientation;
      object.relativeX = tileX;
      object.relativeY = tileY;
      object.offsetX = tileX + tileWidth - 1;
      object.offsetY = tileY + tileHeight - 1;

      for (y = tileX; y < tileX + tileWidth; y++) {
         for (int localY = tileY; localY < tileY + tileHeight; localY++) {
            int count = 0;
            if (y > tileX) {
               ++count;
            }

            if (y < tileX + tileWidth - 1) {
               count += 4;
            }

            if (localY > tileY) {
               count += 8;
            }

            if (localY < tileY + tileHeight - 1) {
               count += 2;
            }

            for (int level = plane; level >= 0; --level) {
               if (this.tiles[level][y][localY] == null) {
                  this.tiles[level][y][localY] = new Tile(level, y, localY);
               }
            }

            Tile tile = this.tiles[plane][y][localY];
            tile.objects[tile.objectCount] = object;
            tile.entityFlags[tile.objectCount] = count;
            tile.flags |= count;
            ++tile.objectCount;
         }
      }

      if (isDynamic) {
         this.interactiveObjectCache[this.entityCount++] = object;
      }

      return true;
   }

   void removeInteractiveObject(InteractiveObject object) {
      for (int x = object.relativeX; x <= object.offsetX; x++) {
         for (int y = object.relativeY; y <= object.offsetY; y++) {
            Tile tile = this.tiles[object.plane][x][y];
            if (tile != null) {
               int count;
               for (count = 0; count < tile.objectCount; count++) {
                  if (tile.objects[count] == object) {
                     --tile.objectCount;

                     for (int index = count; index < tile.objectCount; index++) {
                        tile.objects[index] = tile.objects[index + 1];
                        tile.entityFlags[index] = tile.entityFlags[index + 1];
                     }

                     tile.objects[tile.objectCount] = null;
                     break;
                  }
               }

               tile.flags = 0;

               for (count = 0; count < tile.objectCount; count++) {
                  tile.flags |= tile.entityFlags[count];
               }
            }
         }
      }

   }

   boolean isTileRendered(int worldX, int tileHeight, int worldZ) {
      for (int point = 0; point < processedCullingClustersPointer; point++) {
         SceneCluster cluster = processedCullingClusters[point];
         int multiplier;
         int minZ;
         int maxZ;
         int minHeight;
         int maxHeight;
         if (cluster.tileDistanceEnum == 1) {
            multiplier = cluster.minX - worldX;
            if (multiplier > 0) {
               minZ = (multiplier * cluster.minNormalX >> 8) + cluster.minZ;
               maxZ = (multiplier * cluster.maxNormalX >> 8) + cluster.maxZ;
               minHeight = (multiplier * cluster.minNormalY >> 8) + cluster.minY;
               maxHeight = (multiplier * cluster.maxNormalY >> 8) + cluster.maxY;
               if (worldZ >= minZ && worldZ <= maxZ && tileHeight >= minHeight && tileHeight <= maxHeight) {
                  return true;
               }
            }
         } else if (cluster.tileDistanceEnum == 2) {
            multiplier = worldX - cluster.minX;
            if (multiplier > 0) {
               minZ = (multiplier * cluster.minNormalX >> 8) + cluster.minZ;
               maxZ = (multiplier * cluster.maxNormalX >> 8) + cluster.maxZ;
               minHeight = (multiplier * cluster.minNormalY >> 8) + cluster.minY;
               maxHeight = (multiplier * cluster.maxNormalY >> 8) + cluster.maxY;
               if (worldZ >= minZ && worldZ <= maxZ && tileHeight >= minHeight && tileHeight <= maxHeight) {
                  return true;
               }
            }
         } else if (cluster.tileDistanceEnum == 3) {
            multiplier = cluster.minZ - worldZ;
            if (multiplier > 0) {
               minZ = (multiplier * cluster.anInt158 >> 8) + cluster.minX;
               maxZ = (multiplier * cluster.anInt159 >> 8) + cluster.maxX;
               minHeight = (multiplier * cluster.minNormalY >> 8) + cluster.minY;
               maxHeight = (multiplier * cluster.maxNormalY >> 8) + cluster.maxY;
               if (worldX >= minZ && worldX <= maxZ && tileHeight >= minHeight && tileHeight <= maxHeight) {
                  return true;
               }
            }
         } else if (cluster.tileDistanceEnum == 4) {
            multiplier = worldZ - cluster.minZ;
            if (multiplier > 0) {
               minZ = (multiplier * cluster.anInt158 >> 8) + cluster.minX;
               maxZ = (multiplier * cluster.anInt159 >> 8) + cluster.maxX;
               minHeight = (multiplier * cluster.minNormalY >> 8) + cluster.minY;
               maxHeight = (multiplier * cluster.maxNormalY >> 8) + cluster.maxY;
               if (worldX >= minZ && worldX <= maxZ && tileHeight >= minHeight && tileHeight <= maxHeight) {
                  return true;
               }
            }
         } else if (cluster.tileDistanceEnum == 5) {
            multiplier = tileHeight - cluster.minY;
            if (multiplier > 0) {
               minZ = (multiplier * cluster.anInt158 >> 8) + cluster.minX;
               maxZ = (multiplier * cluster.anInt159 >> 8) + cluster.maxX;
               minHeight = (multiplier * cluster.minNormalX >> 8) + cluster.minZ;
               maxHeight = (multiplier * cluster.maxNormalX >> 8) + cluster.maxZ;
               if (worldX >= minZ && worldX <= maxZ && worldZ >= minHeight && worldZ <= maxHeight) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   void snapWallModels(ModelHeader model, int tileZ, int tileX, int tileY, int sizeX, int sizeY) {
      boolean currentFloor = true;
      int minX = tileX;
      int maxX = tileX + sizeX;
      int minY = tileY - 1;
      int maxY = tileY + sizeY;

      for (int z = tileZ; z <= tileZ + 1; z++) {
         if (z != this.mapSizeZ) {
            for (int x = minX; x <= maxX; x++) {
               if (x >= 0 && x < this.mapSizeX) {
                  for (int y = minY; y <= maxY; y++) {
                     if (y >= 0 && y < this.mapSizeY && (!currentFloor || x >= maxX || y >= maxY || y < tileY && tileX != x)) {
                        Tile tile = this.tiles[z][x][y];
                        if (tile != null) {
                           int heightOffset = (this.tileHeights[z][x + 1][y] + this.tileHeights[z][x + 1][y + 1] + this.tileHeights[z][x][y] + this.tileHeights[z][x][y + 1]) / 4 - (this.tileHeights[tileZ][tileX + 1][tileY] + this.tileHeights[tileZ][tileX][tileY] + this.tileHeights[tileZ][tileX + 1][tileY + 1] + this.tileHeights[tileZ][tileX][tileY + 1]) / 4;
                           Wall wall = tile.wall;
                           if (wall != null) {
                              ModelHeader header;
                              if (wall.primaryRenderable instanceof ModelHeader) {
                                 header = (ModelHeader) wall.primaryRenderable;
                                 ModelHeader.snapModelVertices(model, header, (1 - sizeX) * 64 + (x - tileX) * 128, heightOffset, (y - tileY) * 128 + (1 - sizeY) * 64, currentFloor);
                              }

                              if (wall.secondaryRenderable instanceof ModelHeader) {
                                 header = (ModelHeader) wall.secondaryRenderable;
                                 ModelHeader.snapModelVertices(model, header, (1 - sizeX) * 64 + (x - tileX) * 128, heightOffset, (y - tileY) * 128 + (1 - sizeY) * 64, currentFloor);
                              }
                           }

                           for (int count = 0; count < tile.objectCount; count++) {
                              InteractiveObject object = tile.objects[count];
                              if (object != null && object.renderable instanceof ModelHeader) {
                                 ModelHeader renderable = (ModelHeader) object.renderable;
                                 int xPos = object.offsetX - object.relativeX + 1;
                                 int yPos = object.offsetY - object.relativeY + 1;
                                 ModelHeader.snapModelVertices(model, renderable, (xPos - sizeX) * 64 + (object.relativeX - tileX) * 128, heightOffset, (object.relativeY - tileY) * 128 + (yPos - sizeY) * 64, currentFloor);
                              }
                           }
                        }
                     }
                  }
               }
            }

            --minX;
            currentFloor = false;
         }
      }

   }

   public void method359(int int_0, int int_1, int int_2, boolean bool_0) {
      if (!method381() || bool_0) {
         isClicked = true;
         viewportWalking = bool_0;
         anInt148 = int_0;
         clickX = int_1;
         clickY = int_2;
         clickedTileX = -1;
         clickedTileY = -1;
      }
   }

   void renderComplexTile(ComplexTile compexTile, int int_0, int int_1, int int_2, int int_3, int int_4, int tileX, int tileY) {
      int int_7;
      int int_8 = int_7 = (tileX << 7) - cameraPositionX;
      int int_9;
      int distZ = int_9 = (tileY << 7) - cameraPositionY;
      int int_11;
      int int_12 = int_11 = int_8 + 128;
      int int_13;
      int int_14 = int_13 = distZ + 128;
      int int_15 = this.tileHeights[int_0][tileX][tileY] - cameraY2;
      int int_16 = this.tileHeights[int_0][tileX + 1][tileY] - cameraY2;
      int int_17 = this.tileHeights[int_0][tileX + 1][tileY + 1] - cameraY2;
      int int_18 = this.tileHeights[int_0][tileX][tileY + 1] - cameraY2;
      int int_19 = int_8 * int_4 + int_3 * distZ >> 16;
      distZ = distZ * int_4 - int_3 * int_8 >> 16;
      int_8 = int_19;
      int_19 = int_15 * int_2 - int_1 * distZ >> 16;
      distZ = int_1 * int_15 + distZ * int_2 >> 16;
      int_15 = int_19;
      if (distZ >= 50) {
         int_19 = int_12 * int_4 + int_3 * int_9 >> 16;
         int_9 = int_9 * int_4 - int_3 * int_12 >> 16;
         int_12 = int_19;
         int_19 = int_16 * int_2 - int_1 * int_9 >> 16;
         int_9 = int_1 * int_16 + int_9 * int_2 >> 16;
         int_16 = int_19;
         if (int_9 >= 50) {
            int_19 = int_11 * int_4 + int_3 * int_14 >> 16;
            int_14 = int_14 * int_4 - int_3 * int_11 >> 16;
            int_11 = int_19;
            int_19 = int_17 * int_2 - int_1 * int_14 >> 16;
            int_14 = int_1 * int_17 + int_14 * int_2 >> 16;
            int_17 = int_19;
            if (int_14 >= 50) {
               int_19 = int_7 * int_4 + int_3 * int_13 >> 16;
               int_13 = int_13 * int_4 - int_3 * int_7 >> 16;
               int_7 = int_19;
               int_19 = int_18 * int_2 - int_1 * int_13 >> 16;
               int_13 = int_1 * int_18 + int_13 * int_2 >> 16;
               if (int_13 >= 50) {
                  int int_20 = int_8 * Graphics3D.anInt543 / distZ + Graphics3D.centerX;
                  int int_21 = int_15 * Graphics3D.anInt543 / distZ + Graphics3D.centerY;
                  int int_22 = int_12 * Graphics3D.anInt543 / int_9 + Graphics3D.centerX;
                  int int_23 = int_16 * Graphics3D.anInt543 / int_9 + Graphics3D.centerY;
                  int int_24 = int_11 * Graphics3D.anInt543 / int_14 + Graphics3D.centerX;
                  int int_25 = int_17 * Graphics3D.anInt543 / int_14 + Graphics3D.centerY;
                  int int_26 = int_7 * Graphics3D.anInt543 / int_13 + Graphics3D.centerX;
                  int int_27 = int_19 * Graphics3D.anInt543 / int_13 + Graphics3D.centerY;
                  Graphics3D.rasterAlpha = 0;
                  int int_28;
                  if ((int_24 - int_26) * (int_23 - int_27) - (int_25 - int_27) * (int_22 - int_26) > 0) {
                     Graphics3D.rasterClipEnable = false;
                     if (int_24 < 0 || int_26 < 0 || int_22 < 0 || int_24 > Graphics3D.rasterClipX || int_26 > Graphics3D.rasterClipX || int_22 > Graphics3D.rasterClipX) {
                        Graphics3D.rasterClipEnable = true;
                     }

                     if (isClicked && this.isMouseWithinTriangle(clickX, clickY, int_25, int_27, int_23, int_24, int_26, int_22)) {
                        clickedTileX = tileX;
                        clickedTileY = tileY;
                     }

                     if (compexTile.texture == -1) {
                        if (compexTile.neColour != 12345678) {
                           Graphics3D.rasterGouraud(int_25, int_27, int_23, int_24, int_26, int_22, compexTile.neColour, compexTile.nwColour, compexTile.seColour);
                        }
                     } else if (!lowMemory) {
                        if (compexTile.flatShade) {
                           Graphics3D.rasterTexture(int_25, int_27, int_23, int_24, int_26, int_22, compexTile.neColour, compexTile.nwColour, compexTile.seColour, int_8, int_12, int_7, int_15, int_16, int_19, distZ, int_9, int_13, compexTile.texture);
                        } else {
                           Graphics3D.rasterTexture(int_25, int_27, int_23, int_24, int_26, int_22, compexTile.neColour, compexTile.nwColour, compexTile.seColour, int_11, int_7, int_12, int_17, int_19, int_16, int_14, int_13, int_9, compexTile.texture);
                        }
                     } else {
                        int_28 = Graphics3D.textureLoader.getAverageTextureRGB(compexTile.texture);
                        Graphics3D.rasterGouraud(int_25, int_27, int_23, int_24, int_26, int_22, method384(int_28, compexTile.neColour), method384(int_28, compexTile.nwColour), method384(int_28, compexTile.seColour));
                     }
                  }

                  if ((int_20 - int_22) * (int_27 - int_23) - (int_21 - int_23) * (int_26 - int_22) > 0) {
                     Graphics3D.rasterClipEnable = false;
                     if (int_20 < 0 || int_22 < 0 || int_26 < 0 || int_20 > Graphics3D.rasterClipX || int_22 > Graphics3D.rasterClipX || int_26 > Graphics3D.rasterClipX) {
                        Graphics3D.rasterClipEnable = true;
                     }

                     if (isClicked && this.isMouseWithinTriangle(clickX, clickY, int_21, int_23, int_27, int_20, int_22, int_26)) {
                        clickedTileX = tileX;
                        clickedTileY = tileY;
                     }

                     if (compexTile.texture == -1) {
                        if (compexTile.swColour != 12345678) {
                           Graphics3D.rasterGouraud(int_21, int_23, int_27, int_20, int_22, int_26, compexTile.swColour, compexTile.seColour, compexTile.nwColour);
                        }
                     } else if (!lowMemory) {
                        Graphics3D.rasterTexture(int_21, int_23, int_27, int_20, int_22, int_26, compexTile.swColour, compexTile.seColour, compexTile.nwColour, int_8, int_12, int_7, int_15, int_16, int_19, distZ, int_9, int_13, compexTile.texture);
                     } else {
                        int_28 = Graphics3D.textureLoader.getAverageTextureRGB(compexTile.texture);
                        Graphics3D.rasterGouraud(int_21, int_23, int_27, int_20, int_22, int_26, method384(int_28, compexTile.swColour), method384(int_28, compexTile.seColour), method384(int_28, compexTile.nwColour));
                     }
                  }

               }
            }
         }
      }
   }

   void drawTileOverlay(SceneTileModel scenetilemodel_0, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      int int_6 = scenetilemodel_0.vertexX.length;

      int int_7;
      int int_8;
      int int_9;
      int int_10;
      int int_11;
      for (int_7 = 0; int_7 < int_6; int_7++) {
         int_8 = scenetilemodel_0.vertexX[int_7] - cameraPositionX;
         int_9 = scenetilemodel_0.vertexY[int_7] - cameraY2;
         int_10 = scenetilemodel_0.vertexZ[int_7] - cameraPositionY;
         int_11 = int_10 * int_2 + int_3 * int_8 >> 16;
         int_10 = int_3 * int_10 - int_8 * int_2 >> 16;
         int_8 = int_11;
         int_11 = int_1 * int_9 - int_10 * int_0 >> 16;
         int_10 = int_9 * int_0 + int_1 * int_10 >> 16;
         if (int_10 < 50) {
            return;
         }

         if (scenetilemodel_0.triangleTextureId != null) {
            SceneTileModel.vertexSceneX[int_7] = int_8;
            SceneTileModel.vertexSceneY[int_7] = int_11;
            SceneTileModel.vertexSceneZ[int_7] = int_10;
         }

         SceneTileModel.tmpScreenX[int_7] = int_8 * Graphics3D.anInt543 / int_10 + Graphics3D.centerX;
         SceneTileModel.tmpScreenY[int_7] = int_11 * Graphics3D.anInt543 / int_10 + Graphics3D.centerY;
      }

      Graphics3D.rasterAlpha = 0;
      int_6 = scenetilemodel_0.anIntArray60.length;

      for (int_7 = 0; int_7 < int_6; int_7++) {
         int_8 = scenetilemodel_0.anIntArray60[int_7];
         int_9 = scenetilemodel_0.anIntArray61[int_7];
         int_10 = scenetilemodel_0.anIntArray62[int_7];
         int_11 = SceneTileModel.tmpScreenX[int_8];
         int int_12 = SceneTileModel.tmpScreenX[int_9];
         int int_13 = SceneTileModel.tmpScreenX[int_10];
         int int_14 = SceneTileModel.tmpScreenY[int_8];
         int int_15 = SceneTileModel.tmpScreenY[int_9];
         int int_16 = SceneTileModel.tmpScreenY[int_10];
         if ((int_11 - int_12) * (int_16 - int_15) - (int_14 - int_15) * (int_13 - int_12) > 0) {
            Graphics3D.rasterClipEnable = false;
            if (int_11 < 0 || int_12 < 0 || int_13 < 0 || int_11 > Graphics3D.rasterClipX || int_12 > Graphics3D.rasterClipX || int_13 > Graphics3D.rasterClipX) {
               Graphics3D.rasterClipEnable = true;
            }

            if (isClicked && this.isMouseWithinTriangle(clickX, clickY, int_14, int_15, int_16, int_11, int_12, int_13)) {
               clickedTileX = int_4;
               clickedTileY = int_5;
            }

            if (scenetilemodel_0.triangleTextureId != null && scenetilemodel_0.triangleTextureId[int_7] != -1) {
               if (!lowMemory) {
                  if (scenetilemodel_0.flatShade) {
                     Graphics3D.rasterTexture(int_14, int_15, int_16, int_11, int_12, int_13, scenetilemodel_0.triangleColorA[int_7], scenetilemodel_0.triangleColorB[int_7], scenetilemodel_0.triangleColorC[int_7], SceneTileModel.vertexSceneX[0], SceneTileModel.vertexSceneX[1], SceneTileModel.vertexSceneX[3], SceneTileModel.vertexSceneY[0], SceneTileModel.vertexSceneY[1], SceneTileModel.vertexSceneY[3], SceneTileModel.vertexSceneZ[0], SceneTileModel.vertexSceneZ[1], SceneTileModel.vertexSceneZ[3], scenetilemodel_0.triangleTextureId[int_7]);
                  } else {
                     Graphics3D.rasterTexture(int_14, int_15, int_16, int_11, int_12, int_13, scenetilemodel_0.triangleColorA[int_7], scenetilemodel_0.triangleColorB[int_7], scenetilemodel_0.triangleColorC[int_7], SceneTileModel.vertexSceneX[int_8], SceneTileModel.vertexSceneX[int_9], SceneTileModel.vertexSceneX[int_10], SceneTileModel.vertexSceneY[int_8], SceneTileModel.vertexSceneY[int_9], SceneTileModel.vertexSceneY[int_10], SceneTileModel.vertexSceneZ[int_8], SceneTileModel.vertexSceneZ[int_9], SceneTileModel.vertexSceneZ[int_10], scenetilemodel_0.triangleTextureId[int_7]);
                  }
               } else {
                  int int_17 = Graphics3D.textureLoader.getAverageTextureRGB(scenetilemodel_0.triangleTextureId[int_7]);
                  Graphics3D.rasterGouraud(int_14, int_15, int_16, int_11, int_12, int_13, method384(int_17, scenetilemodel_0.triangleColorA[int_7]), method384(int_17, scenetilemodel_0.triangleColorB[int_7]), method384(int_17, scenetilemodel_0.triangleColorC[int_7]));
               }
            } else if (scenetilemodel_0.triangleColorA[int_7] != 12345678) {
               Graphics3D.rasterGouraud(int_14, int_15, int_16, int_11, int_12, int_13, scenetilemodel_0.triangleColorA[int_7], scenetilemodel_0.triangleColorB[int_7], scenetilemodel_0.triangleColorC[int_7]);
            }
         }
      }

   }

   boolean isOrientedWallRenderable(int y, int x, int z, int orientation) {
      if (!this.tileRenderable(y, x, z)) {
         return false;
      } else {
         int worldX = x << 7;
         int worldZ = z << 7;
         int worldHeight = this.tileHeights[y][x][z] - 1;
         int minHeight = worldHeight - 120;
         int secondaryHeight = worldHeight - 230;
         int maxHeight = worldHeight - 238;
         if (orientation < 16) {
            if (orientation == 1) {
               if (worldX > cameraPositionX) {
                  if (!this.isTileRendered(worldX, worldHeight, worldZ)) {
                     return false;
                  }

                  if (!this.isTileRendered(worldX, worldHeight, worldZ + 128)) {
                     return false;
                  }
               }

               if (y > 0) {
                  if (!this.isTileRendered(worldX, minHeight, worldZ)) {
                     return false;
                  }

                  if (!this.isTileRendered(worldX, minHeight, worldZ + 128)) {
                     return false;
                  }
               }

               if (!this.isTileRendered(worldX, secondaryHeight, worldZ)) {
                  return false;
               }

               if (!this.isTileRendered(worldX, secondaryHeight, worldZ + 128)) {
                  return false;
               }

               return true;
            }

            if (orientation == 2) {
               if (worldZ < cameraPositionY) {
                  if (!this.isTileRendered(worldX, worldHeight, worldZ + 128)) {
                     return false;
                  }

                  if (!this.isTileRendered(worldX + 128, worldHeight, worldZ + 128)) {
                     return false;
                  }
               }

               if (y > 0) {
                  if (!this.isTileRendered(worldX, minHeight, worldZ + 128)) {
                     return false;
                  }

                  if (!this.isTileRendered(worldX + 128, minHeight, worldZ + 128)) {
                     return false;
                  }
               }

               if (!this.isTileRendered(worldX, secondaryHeight, worldZ + 128)) {
                  return false;
               }

               if (!this.isTileRendered(worldX + 128, secondaryHeight, worldZ + 128)) {
                  return false;
               }

               return true;
            }

            if (orientation == 4) {
               if (worldX < cameraPositionX) {
                  if (!this.isTileRendered(worldX + 128, worldHeight, worldZ)) {
                     return false;
                  }

                  if (!this.isTileRendered(worldX + 128, worldHeight, worldZ + 128)) {
                     return false;
                  }
               }

               if (y > 0) {
                  if (!this.isTileRendered(worldX + 128, minHeight, worldZ)) {
                     return false;
                  }

                  if (!this.isTileRendered(worldX + 128, minHeight, worldZ + 128)) {
                     return false;
                  }
               }

               if (!this.isTileRendered(worldX + 128, secondaryHeight, worldZ)) {
                  return false;
               }

               if (!this.isTileRendered(worldX + 128, secondaryHeight, worldZ + 128)) {
                  return false;
               }

               return true;
            }

            if (orientation == 8) {
               if (worldZ > cameraPositionY) {
                  if (!this.isTileRendered(worldX, worldHeight, worldZ)) {
                     return false;
                  }

                  if (!this.isTileRendered(worldX + 128, worldHeight, worldZ)) {
                     return false;
                  }
               }

               if (y > 0) {
                  if (!this.isTileRendered(worldX, minHeight, worldZ)) {
                     return false;
                  }

                  if (!this.isTileRendered(worldX + 128, minHeight, worldZ)) {
                     return false;
                  }
               }

               if (!this.isTileRendered(worldX, secondaryHeight, worldZ)) {
                  return false;
               }

               if (!this.isTileRendered(worldX + 128, secondaryHeight, worldZ)) {
                  return false;
               }

               return true;
            }
         }

         return !this.isTileRendered(worldX + 64, maxHeight, worldZ + 64) ? false : (orientation == 16 ? this.isTileRendered(worldX, secondaryHeight, worldZ + 128) : (orientation == 32 ? this.isTileRendered(worldX + 128, secondaryHeight, worldZ + 128) : (orientation == 64 ? this.isTileRendered(worldX + 128, secondaryHeight, worldZ) : (orientation == 128 ? this.isTileRendered(worldX, secondaryHeight, worldZ) : true))));
      }
   }

   boolean isMouseWithinTriangle(int mouseX, int mouseY, int firstY, int secondY, int thirdY, int firstX, int secondX, int thirdX) {
      if (mouseY < firstY && mouseY < secondY && mouseY < thirdY) {
         return false;
      } else if (mouseY > firstY && mouseY > secondY && mouseY > thirdY) {
         return false;
      } else if (mouseX < firstX && mouseX < secondX && mouseX < thirdX) {
         return false;
      } else if (mouseX > firstX && mouseX > secondX && mouseX > thirdX) {
         return false;
      } else {
         int int_8 = (mouseY - firstY) * (secondX - firstX) - (mouseX - firstX) * (secondY - firstY);
         int int_9 = (firstX - thirdX) * (mouseY - thirdY) - (mouseX - thirdX) * (firstY - thirdY);
         int int_10 = (thirdX - secondX) * (mouseY - secondY) - (mouseX - secondX) * (thirdY - secondY);
         return int_8 * int_10 > 0 && int_10 * int_9 > 0;
      }
   }

   void snapGroundItemModels(ModelHeader header, int z, int x, int y) {
      Tile tile;
      ModelHeader renderableHeader;
      if (x < this.mapSizeX) {
         tile = this.tiles[z][x + 1][y];
         if (tile != null && tile.floorDecoration != null && tile.floorDecoration.renderable instanceof ModelHeader) {
            renderableHeader = (ModelHeader) tile.floorDecoration.renderable;
            ModelHeader.snapModelVertices(header, renderableHeader, 128, 0, 0, true);
         }
      }

      if (y < this.mapSizeX) {
         tile = this.tiles[z][x][y + 1];
         if (tile != null && tile.floorDecoration != null && tile.floorDecoration.renderable instanceof ModelHeader) {
            renderableHeader = (ModelHeader) tile.floorDecoration.renderable;
            ModelHeader.snapModelVertices(header, renderableHeader, 0, 0, 128, true);
         }
      }

      if (x < this.mapSizeX && y < this.mapSizeY) {
         tile = this.tiles[z][x + 1][y + 1];
         if (tile != null && tile.floorDecoration != null && tile.floorDecoration.renderable instanceof ModelHeader) {
            renderableHeader = (ModelHeader) tile.floorDecoration.renderable;
            ModelHeader.snapModelVertices(header, renderableHeader, 128, 0, 128, true);
         }
      }

      if (x < this.mapSizeX && y > 0) {
         tile = this.tiles[z][x + 1][y - 1];
         if (tile != null && tile.floorDecoration != null && tile.floorDecoration.renderable instanceof ModelHeader) {
            renderableHeader = (ModelHeader) tile.floorDecoration.renderable;
            ModelHeader.snapModelVertices(header, renderableHeader, 128, 0, -128, true);
         }
      }

   }

   public void reset() {
      int int_0;
      int int_1;
      for (int_0 = 0; int_0 < this.mapSizeZ; int_0++) {
         for (int_1 = 0; int_1 < this.mapSizeX; int_1++) {
            for (int int_2 = 0; int_2 < this.mapSizeY; int_2++) {
               this.tiles[int_0][int_1][int_2] = null;
            }
         }
      }

      for (int_0 = 0; int_0 < MAX_OCCLUDER_LEVELS; int_0++) {
         for (int_1 = 0; int_1 < levelOccluderCount[int_0]; int_1++) {
            levelSceneClusters[int_0][int_1] = null;
         }

         levelOccluderCount[int_0] = 0;
      }

      for (int_0 = 0; int_0 < this.entityCount; int_0++) {
         this.interactiveObjectCache[int_0] = null;
      }

      this.entityCount = 0;

      for (int_0 = 0; int_0 < entityBuffer.length; int_0++) {
         entityBuffer[int_0] = null;
      }

   }

   boolean isTileRendered(int int_0, int int_1, int int_2, int int_3) {
      if (!this.tileRenderable(int_0, int_1, int_2)) {
         return false;
      } else {
         int int_4 = int_1 << 7;
         int int_5 = int_2 << 7;
         return this.isTileRendered(int_4 + 1, this.tileHeights[int_0][int_1][int_2] - int_3, int_5 + 1) && this.isTileRendered(int_4 + 128 - 1, this.tileHeights[int_0][int_1 + 1][int_2] - int_3, int_5 + 1) && this.isTileRendered(int_4 + 128 - 1, this.tileHeights[int_0][int_1 + 1][int_2 + 1] - int_3, int_5 + 128 - 1) && this.isTileRendered(int_4 + 1, this.tileHeights[int_0][int_1][int_2 + 1] - int_3, int_5 + 128 - 1);
      }
   }

   boolean isAreaOccluded(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      int int_6;
      int int_7;
      if (int_2 == int_1 && int_4 == int_3) {
         if (!this.tileRenderable(int_0, int_1, int_3)) {
            return false;
         } else {
            int_6 = int_1 << 7;
            int_7 = int_3 << 7;
            return this.isTileRendered(int_6 + 1, this.tileHeights[int_0][int_1][int_3] - int_5, int_7 + 1) && this.isTileRendered(int_6 + 128 - 1, this.tileHeights[int_0][int_1 + 1][int_3] - int_5, int_7 + 1) && this.isTileRendered(int_6 + 128 - 1, this.tileHeights[int_0][int_1 + 1][int_3 + 1] - int_5, int_7 + 128 - 1) && this.isTileRendered(int_6 + 1, this.tileHeights[int_0][int_1][int_3 + 1] - int_5, int_7 + 128 - 1);
         }
      } else {
         for (int_6 = int_1; int_6 <= int_2; int_6++) {
            for (int_7 = int_3; int_7 <= int_4; int_7++) {
               if (this.visibilityMap[int_0][int_6][int_7] == -RENDERABLE_RULE) {
                  return false;
               }
            }
         }

         int_6 = (int_1 << 7) + 1;
         int_7 = (int_3 << 7) + 2;
         int int_8 = this.tileHeights[int_0][int_1][int_3] - int_5;
         if (!this.isTileRendered(int_6, int_8, int_7)) {
            return false;
         } else {
            int int_9 = (int_2 << 7) - 1;
            if (!this.isTileRendered(int_9, int_8, int_7)) {
               return false;
            } else {
               int int_10 = (int_4 << 7) - 1;
               if (!this.isTileRendered(int_6, int_8, int_10)) {
                  return false;
               } else if (!this.isTileRendered(int_9, int_8, int_10)) {
                  return false;
               } else {
                  return true;
               }
            }
         }
      }
   }

   void updateOccluders() {
      int int_0 = levelOccluderCount[anInt147];
      SceneCluster[] occluders_0 = levelSceneClusters[anInt147];
      processedCullingClustersPointer = 0;

      for (int int_1 = 0; int_1 < int_0; int_1++) {
         SceneCluster sceneCluster_0 = occluders_0[int_1];
         int int_2;
         int int_3;
         int int_4;
         int int_6;
         boolean bool_1;
         if (sceneCluster_0.type == 1) {
            int_2 = sceneCluster_0.minTileX - screenCenterX + 25;
            if (int_2 >= 0 && int_2 <= 50) {
               int_3 = sceneCluster_0.minTileZ - screenCenterZ + 25;
               if (int_3 < 0) {
                  int_3 = 0;
               }

               int_4 = sceneCluster_0.maxTileZ - screenCenterZ + 25;
               if (int_4 > 50) {
                  int_4 = 50;
               }

               bool_1 = false;

               while (int_3 <= int_4) {
                  if (renderArea[int_2][int_3++]) {
                     bool_1 = true;
                     break;
                  }
               }

               if (bool_1) {
                  int_6 = cameraPositionX - sceneCluster_0.minX;
                  if (int_6 > 32) {
                     sceneCluster_0.tileDistanceEnum = 1;
                  } else {
                     if (int_6 >= -32) {
                        continue;
                     }

                     sceneCluster_0.tileDistanceEnum = 2;
                     int_6 = -int_6;
                  }

                  sceneCluster_0.minNormalX = (sceneCluster_0.minZ - cameraPositionY << 8) / int_6;
                  sceneCluster_0.maxNormalX = (sceneCluster_0.maxZ - cameraPositionY << 8) / int_6;
                  sceneCluster_0.minNormalY = (sceneCluster_0.minY - cameraY2 << 8) / int_6;
                  sceneCluster_0.maxNormalY = (sceneCluster_0.maxY - cameraY2 << 8) / int_6;
                  processedCullingClusters[processedCullingClustersPointer++] = sceneCluster_0;
               }
            }
         } else if (sceneCluster_0.type == 2) {
            int_2 = sceneCluster_0.minTileZ - screenCenterZ + 25;
            if (int_2 >= 0 && int_2 <= 50) {
               int_3 = sceneCluster_0.minTileX - screenCenterX + 25;
               if (int_3 < 0) {
                  int_3 = 0;
               }

               int_4 = sceneCluster_0.maxTIleX - screenCenterX + 25;
               if (int_4 > 50) {
                  int_4 = 50;
               }

               bool_1 = false;

               while (int_3 <= int_4) {
                  if (renderArea[int_3++][int_2]) {
                     bool_1 = true;
                     break;
                  }
               }

               if (bool_1) {
                  int_6 = cameraPositionY - sceneCluster_0.minZ;
                  if (int_6 > 32) {
                     sceneCluster_0.tileDistanceEnum = 3;
                  } else {
                     if (int_6 >= -32) {
                        continue;
                     }

                     sceneCluster_0.tileDistanceEnum = 4;
                     int_6 = -int_6;
                  }

                  sceneCluster_0.anInt158 = (sceneCluster_0.minX - cameraPositionX << 8) / int_6;
                  sceneCluster_0.anInt159 = (sceneCluster_0.maxX - cameraPositionX << 8) / int_6;
                  sceneCluster_0.minNormalY = (sceneCluster_0.minY - cameraY2 << 8) / int_6;
                  sceneCluster_0.maxNormalY = (sceneCluster_0.maxY - cameraY2 << 8) / int_6;
                  processedCullingClusters[processedCullingClustersPointer++] = sceneCluster_0;
               }
            }
         } else if (sceneCluster_0.type == 4) {
            int_2 = sceneCluster_0.minY - cameraY2;
            if (int_2 > 128) {
               int_3 = sceneCluster_0.minTileZ - screenCenterZ + 25;
               if (int_3 < 0) {
                  int_3 = 0;
               }

               int_4 = sceneCluster_0.maxTileZ - screenCenterZ + 25;
               if (int_4 > 50) {
                  int_4 = 50;
               }

               if (int_3 <= int_4) {
                  int int_5 = sceneCluster_0.minTileX - screenCenterX + 25;
                  if (int_5 < 0) {
                     int_5 = 0;
                  }

                  int_6 = sceneCluster_0.maxTIleX - screenCenterX + 25;
                  if (int_6 > 50) {
                     int_6 = 50;
                  }

                  boolean bool_0 = false;

                  label144:
                  for (int int_7 = int_5; int_7 <= int_6; int_7++) {
                     for (int int_8 = int_3; int_8 <= int_4; int_8++) {
                        if (renderArea[int_7][int_8]) {
                           bool_0 = true;
                           break label144;
                        }
                     }
                  }

                  if (bool_0) {
                     sceneCluster_0.tileDistanceEnum = 5;
                     sceneCluster_0.anInt158 = (sceneCluster_0.minX - cameraPositionX << 8) / int_2;
                     sceneCluster_0.anInt159 = (sceneCluster_0.maxX - cameraPositionX << 8) / int_2;
                     sceneCluster_0.minNormalX = (sceneCluster_0.minZ - cameraPositionY << 8) / int_2;
                     sceneCluster_0.maxNormalX = (sceneCluster_0.maxZ - cameraPositionY << 8) / int_2;
                     processedCullingClusters[processedCullingClustersPointer++] = sceneCluster_0;
                  }
               }
            }
         }
      }

   }

   public Wall method361(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      return tile_0 == null ? null : tile_0.wall;
   }

   public void method362(int[] ints_0, int int_0, int int_1, int int_2, int int_3, int int_4) {
      Tile tile_0 = this.tiles[int_2][int_3][int_4];
      if (tile_0 != null) {
         ComplexTile scenetilepaint_0 = tile_0.paint;
         int int_6;
         if (scenetilepaint_0 != null) {
            int int_5 = scenetilepaint_0.rgb;
            if (int_5 != 0) {
               for (int_6 = 0; int_6 < 4; int_6++) {
                  ints_0[int_0] = int_5;
                  ints_0[int_0 + 1] = int_5;
                  ints_0[int_0 + 2] = int_5;
                  ints_0[int_0 + 3] = int_5;
                  int_0 += int_1;
               }

            }
         } else {
            SceneTileModel scenetilemodel_0 = tile_0.overlay;
            if (scenetilemodel_0 != null) {
               int_6 = scenetilemodel_0.shape;
               int int_7 = scenetilemodel_0.rotation;
               int int_8 = scenetilemodel_0.underlay;
               int int_9 = scenetilemodel_0.overlay;
               int[] ints_1 = this.TILE_MASK_2D[int_6];
               int[] ints_2 = this.TILE_ROTATION_2D[int_7];
               int int_10 = 0;
               int int_11;
               if (int_8 != 0) {
                  for (int_11 = 0; int_11 < 4; int_11++) {
                     ints_0[int_0] = ints_1[ints_2[int_10++]] == 0 ? int_8 : int_9;
                     ints_0[int_0 + 1] = ints_1[ints_2[int_10++]] == 0 ? int_8 : int_9;
                     ints_0[int_0 + 2] = ints_1[ints_2[int_10++]] == 0 ? int_8 : int_9;
                     ints_0[int_0 + 3] = ints_1[ints_2[int_10++]] == 0 ? int_8 : int_9;
                     int_0 += int_1;
                  }
               } else {
                  for (int_11 = 0; int_11 < 4; int_11++) {
                     if (ints_1[ints_2[int_10++]] != 0) {
                        ints_0[int_0] = int_9;
                     }

                     if (ints_1[ints_2[int_10++]] != 0) {
                        ints_0[int_0 + 1] = int_9;
                     }

                     if (ints_1[ints_2[int_10++]] != 0) {
                        ints_0[int_0 + 2] = int_9;
                     }

                     if (ints_1[ints_2[int_10++]] != 0) {
                        ints_0[int_0 + 3] = int_9;
                     }

                     int_0 += int_1;
                  }
               }

            }
         }
      }
   }

   public WallDecoration method363(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      return tile_0 == null ? null : tile_0.wallDecoration;
   }

   public void method364(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      if (tile_0 != null) {
         tile_0.itemLayer = null;
      }
   }

   public int getWallObjectUID(int z, int x, int y) {
      Tile tile = this.tiles[z][x][y];
      return tile != null && tile.wall != null ? tile.wall.hash : 0;
   }

   public int getWallDecorationUID(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      return tile_0 != null && tile_0.wallDecoration != null ? tile_0.wallDecoration.hash : 0;
   }

   public int getGroundDecorationUID(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      return tile_0 != null && tile_0.floorDecoration != null ? tile_0.floorDecoration.hash : 0;
   }

   public int getObjectConfig(int int_0, int int_1, int int_2, int int_3) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      if (tile_0 == null) {
         return -1;
      } else if (tile_0.wall != null && tile_0.wall.hash == int_3) {
         return tile_0.wall.objectConfig & 0xFF;
      } else if (tile_0.wallDecoration != null && tile_0.wallDecoration.hash == int_3) {
         return tile_0.wallDecoration.objectConfig & 0xFF;
      } else if (tile_0.floorDecoration != null && tile_0.floorDecoration.hash == int_3) {
         return tile_0.floorDecoration.objectConfig & 0xFF;
      } else {
         for (int int_4 = 0; int_4 < tile_0.objectCount; int_4++) {
            if (int_3 == tile_0.objects[int_4].hash) {
               return tile_0.objects[int_4].objectConfig & 0xFF;
            }
         }

         return -1;
      }
   }

   public int getInteractableObjectUID(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      if (tile_0 == null) {
         return 0;
      } else {
         for (int int_3 = 0; int_3 < tile_0.objectCount; int_3++) {
            InteractiveObject gameobject_0 = tile_0.objects[int_3];
            if ((gameobject_0.hash >> 29 & 0x3) == 2 && int_1 == gameobject_0.relativeX && int_2 == gameobject_0.relativeY) {
               return gameobject_0.hash;
            }
         }

         return 0;
      }
   }

   public InteractiveObject method370(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      if (tile_0 == null) {
         return null;
      } else {
         for (int int_3 = 0; int_3 < tile_0.objectCount; int_3++) {
            InteractiveObject gameobject_0 = tile_0.objects[int_3];
            if ((gameobject_0.hash >> 29 & 0x3) == 2 && int_1 == gameobject_0.relativeX && int_2 == gameobject_0.relativeY) {
               return gameobject_0;
            }
         }

         return null;
      }
   }

   void draw(Tile tile_0, boolean bool_0) {
      tileDeque.addFront(tile_0);

      while (true) {
         Tile tile;
         int int_0;
         int int_1;
         int int_2;
         int int_3;
         Tile[][] tiles_0;
         Tile tile_2;
         int int_4;
         int int_6;
         int int_7;
         int int_8;
         int int_9;
         int int_10;
         do {
            do {
               do {
                  do {
                     do {
                        do {
                           while (true) {
                              Wall wallobject_0;
                              InteractiveObject gameobject_0;
                              boolean bool_1;
                              int int_5;
                              int int_11;
                              int int_12;
                              Tile tile_5;
                              while (true) {
                                 do {
                                    tile = (Tile) tileDeque.popFront();
                                    if (tile == null) {
                                       return;
                                    }
                                 } while (!tile.visible);

                                 int_0 = tile.x;
                                 int_1 = tile.y;
                                 int_2 = tile.plane;
                                 int_3 = tile.renderLevel;
                                 tiles_0 = this.tiles[int_2];
                                 if (!tile.draw) {
                                    break;
                                 }

                                 if (bool_0) {
                                    if (int_2 > 0) {
                                       tile_2 = this.tiles[int_2 - 1][int_0][int_1];
                                       if (tile_2 != null && tile_2.visible) {
                                          continue;
                                       }
                                    }

                                    if (int_0 <= screenCenterX && int_0 > minTileX) {
                                       tile_2 = tiles_0[int_0 - 1][int_1];
                                       if (tile_2 != null && tile_2.visible && (tile_2.draw || (tile.flags & 0x1) == 0)) {
                                          continue;
                                       }
                                    }

                                    if (int_0 >= screenCenterX && int_0 < maxTileX - 1) {
                                       tile_2 = tiles_0[int_0 + 1][int_1];
                                       if (tile_2 != null && tile_2.visible && (tile_2.draw || (tile.flags & 0x4) == 0)) {
                                          continue;
                                       }
                                    }

                                    if (int_1 <= screenCenterZ && int_1 > minTileZ) {
                                       tile_2 = tiles_0[int_0][int_1 - 1];
                                       if (tile_2 != null && tile_2.visible && (tile_2.draw || (tile.flags & 0x8) == 0)) {
                                          continue;
                                       }
                                    }

                                    if (int_1 >= screenCenterZ && int_1 < maxTileZ - 1) {
                                       tile_2 = tiles_0[int_0][int_1 + 1];
                                       if (tile_2 != null && tile_2.visible && (tile_2.draw || (tile.flags & 0x2) == 0)) {
                                          continue;
                                       }
                                    }
                                 } else {
                                    bool_0 = true;
                                 }

                                 tile.draw = false;
                                 if (tile.bridge != null) {
                                    tile_2 = tile.bridge;
                                    if (tile_2.paint != null) {
                                       if (!this.tileRenderable(0, int_0, int_1)) {
                                          this.renderComplexTile(tile_2.paint, 0, pitchSin, pitchCos, yawSin, yawCos, int_0, int_1);
                                       }
                                    } else if (tile_2.overlay != null && !this.tileRenderable(0, int_0, int_1)) {
                                       this.drawTileOverlay(tile_2.overlay, pitchSin, pitchCos, yawSin, yawCos, int_0, int_1);
                                    }

                                    wallobject_0 = tile_2.wall;
                                    if (wallobject_0 != null) {
                                       wallobject_0.primaryRenderable.draw(0, pitchSin, pitchCos, yawSin, yawCos, wallobject_0.x - cameraPositionX, wallobject_0.floor - cameraY2, wallobject_0.y - cameraPositionY, wallobject_0.hash);
                                    }

                                    for (int_4 = 0; int_4 < tile_2.objectCount; int_4++) {
                                       gameobject_0 = tile_2.objects[int_4];
                                       if (gameobject_0 != null) {
                                          gameobject_0.renderable.draw(gameobject_0.orientation, pitchSin, pitchCos, yawSin, yawCos, gameobject_0.x - cameraPositionX, gameobject_0.height - cameraY2, gameobject_0.y - cameraPositionY, gameobject_0.hash);
                                       }
                                    }
                                 }

                                 bool_1 = false;
                                 if (tile.paint != null) {
                                    if (!this.tileRenderable(int_3, int_0, int_1)) {
                                       bool_1 = true;
                                       if (tile.paint.neColour != 12345678 || isClicked && int_2 <= anInt148) {
                                          this.renderComplexTile(tile.paint, int_3, pitchSin, pitchCos, yawSin, yawCos, int_0, int_1);
                                       }
                                    }
                                 } else if (tile.overlay != null && !this.tileRenderable(int_3, int_0, int_1)) {
                                    bool_1 = true;
                                    this.drawTileOverlay(tile.overlay, pitchSin, pitchCos, yawSin, yawCos, int_0, int_1);
                                 }

                                 int_5 = 0;
                                 int_4 = 0;
                                 Wall wallobject_2 = tile.wall;
                                 WallDecoration decorativeobject_0 = tile.wallDecoration;
                                 if (wallobject_2 != null || decorativeobject_0 != null) {
                                    if (int_0 == screenCenterX) {
                                       ++int_5;
                                    } else if (screenCenterX < int_0) {
                                       int_5 += 2;
                                    }

                                    if (int_1 == screenCenterZ) {
                                       int_5 += 3;
                                    } else if (screenCenterZ > int_1) {
                                       int_5 += 6;
                                    }

                                    int_4 = anIntArray36[int_5];
                                    tile.wallDrawFlags = TILE_WALL_DRAW_FLAGS_1[int_5];
                                 }

                                 if (wallobject_2 != null) {
                                    if ((wallobject_2.primaryOrientation & anIntArray35[int_5]) != 0) {
                                       if (wallobject_2.primaryOrientation == 16) {
                                          tile.wallCullDirection = 3;
                                          tile.wallUncullDirection = WALL_UNCULL_FLAGS_0[int_5];
                                          tile.wallCullOppositeDirection = 3 - tile.wallUncullDirection;
                                       } else if (wallobject_2.primaryOrientation == 32) {
                                          tile.wallCullDirection = 6;
                                          tile.wallUncullDirection = WALL_UNCULL_FLAGS_1[int_5];
                                          tile.wallCullOppositeDirection = 6 - tile.wallUncullDirection;
                                       } else if (wallobject_2.primaryOrientation == 64) {
                                          tile.wallCullDirection = 12;
                                          tile.wallUncullDirection = WALL_UNCULL_FLAGS_2[int_5];
                                          tile.wallCullOppositeDirection = 12 - tile.wallUncullDirection;
                                       } else {
                                          tile.wallCullDirection = 9;
                                          tile.wallUncullDirection = WALL_UNCULL_FLAGS_3[int_5];
                                          tile.wallCullOppositeDirection = 9 - tile.wallUncullDirection;
                                       }
                                    } else {
                                       tile.wallCullDirection = 0;
                                    }

                                    if ((wallobject_2.primaryOrientation & int_4) != 0 && !this.isOrientedWallRenderable(int_3, int_0, int_1, wallobject_2.primaryOrientation)) {
                                       wallobject_2.primaryRenderable.draw(0, pitchSin, pitchCos, yawSin, yawCos, wallobject_2.x - cameraPositionX, wallobject_2.floor - cameraY2, wallobject_2.y - cameraPositionY, wallobject_2.hash);
                                    }

                                    if ((wallobject_2.secondaryOrientation & int_4) != 0 && !this.isOrientedWallRenderable(int_3, int_0, int_1, wallobject_2.secondaryOrientation)) {
                                       wallobject_2.secondaryRenderable.draw(0, pitchSin, pitchCos, yawSin, yawCos, wallobject_2.x - cameraPositionX, wallobject_2.floor - cameraY2, wallobject_2.y - cameraPositionY, wallobject_2.hash);
                                    }
                                 }

                                 if (decorativeobject_0 != null && !this.isTileRendered(int_3, int_0, int_1, decorativeobject_0.primaryRenderable.modelHeight)) {
                                    if ((decorativeobject_0.primaryOrientation & int_4) != 0) {
                                       decorativeobject_0.primaryRenderable.draw(0, pitchSin, pitchCos, yawSin, yawCos, decorativeobject_0.x - cameraPositionX + decorativeobject_0.offsetX, decorativeobject_0.floor - cameraY2, decorativeobject_0.y - cameraPositionY + decorativeobject_0.offsetY, decorativeobject_0.hash);
                                    } else if (decorativeobject_0.primaryOrientation == 256) {
                                       int_7 = decorativeobject_0.x - cameraPositionX;
                                       int_8 = decorativeobject_0.floor - cameraY2;
                                       int_9 = decorativeobject_0.y - cameraPositionY;
                                       int_11 = decorativeobject_0.secondaryOrientation;
                                       if (int_11 != 1 && int_11 != 2) {
                                          int_12 = int_7;
                                       } else {
                                          int_12 = -int_7;
                                       }

                                       int int_13;
                                       if (int_11 != 2 && int_11 != 3) {
                                          int_13 = int_9;
                                       } else {
                                          int_13 = -int_9;
                                       }

                                       if (int_13 < int_12) {
                                          decorativeobject_0.primaryRenderable.draw(0, pitchSin, pitchCos, yawSin, yawCos, int_7 + decorativeobject_0.offsetX, int_8, int_9 + decorativeobject_0.offsetY, decorativeobject_0.hash);
                                       } else if (decorativeobject_0.secondaryRenderable != null) {
                                          decorativeobject_0.secondaryRenderable.draw(0, pitchSin, pitchCos, yawSin, yawCos, int_7, int_8, int_9, decorativeobject_0.hash);
                                       }
                                    }
                                 }

                                 if (bool_1) {
                                    FloorDecoration floor = tile.floorDecoration;
                                    if (floor != null) {
                                       floor.renderable.draw(0, pitchSin, pitchCos, yawSin, yawCos, floor.x - cameraPositionX, floor.z - cameraY2, floor.y - cameraPositionY, floor.hash);
                                    }

                                    ItemLayer itemlayer_0 = tile.itemLayer;
                                    if (itemlayer_0 != null && itemlayer_0.height == 0) {
                                       if (itemlayer_0.middle != null) {
                                          itemlayer_0.middle.draw(0, pitchSin, pitchCos, yawSin, yawCos, itemlayer_0.x - cameraPositionX, itemlayer_0.hash - cameraY2, itemlayer_0.y - cameraPositionY, itemlayer_0.flags);
                                       }

                                       if (itemlayer_0.top != null) {
                                          itemlayer_0.top.draw(0, pitchSin, pitchCos, yawSin, yawCos, itemlayer_0.x - cameraPositionX, itemlayer_0.hash - cameraY2, itemlayer_0.y - cameraPositionY, itemlayer_0.flags);
                                       }

                                       if (itemlayer_0.bottom != null) {
                                          itemlayer_0.bottom.draw(0, pitchSin, pitchCos, yawSin, yawCos, itemlayer_0.x - cameraPositionX, itemlayer_0.hash - cameraY2, itemlayer_0.y - cameraPositionY, itemlayer_0.flags);
                                       }
                                    }
                                 }

                                 int_7 = tile.flags;
                                 if (int_7 != 0) {
                                    if (int_0 < screenCenterX && (int_7 & 0x4) != 0) {
                                       tile_5 = tiles_0[int_0 + 1][int_1];
                                       if (tile_5 != null && tile_5.visible) {
                                          tileDeque.addFront(tile_5);
                                       }
                                    }

                                    if (int_1 < screenCenterZ && (int_7 & 0x2) != 0) {
                                       tile_5 = tiles_0[int_0][int_1 + 1];
                                       if (tile_5 != null && tile_5.visible) {
                                          tileDeque.addFront(tile_5);
                                       }
                                    }

                                    if (int_0 > screenCenterX && (int_7 & 0x1) != 0) {
                                       tile_5 = tiles_0[int_0 - 1][int_1];
                                       if (tile_5 != null && tile_5.visible) {
                                          tileDeque.addFront(tile_5);
                                       }
                                    }

                                    if (int_1 > screenCenterZ && (int_7 & 0x8) != 0) {
                                       tile_5 = tiles_0[int_0][int_1 - 1];
                                       if (tile_5 != null && tile_5.visible) {
                                          tileDeque.addFront(tile_5);
                                       }
                                    }
                                 }
                                 break;
                              }

                              if (tile.wallCullDirection != 0) {
                                 bool_1 = true;

                                 for (int_5 = 0; int_5 < tile.objectCount; int_5++) {
                                    if (tile.objects[int_5].cycle != RENDERABLE_RULE && (tile.entityFlags[int_5] & tile.wallCullDirection) == tile.wallUncullDirection) {
                                       bool_1 = false;
                                       break;
                                    }
                                 }

                                 if (bool_1) {
                                    wallobject_0 = tile.wall;
                                    if (!this.isOrientedWallRenderable(int_3, int_0, int_1, wallobject_0.primaryOrientation)) {
                                       wallobject_0.primaryRenderable.draw(0, pitchSin, pitchCos, yawSin, yawCos, wallobject_0.x - cameraPositionX, wallobject_0.floor - cameraY2, wallobject_0.y - cameraPositionY, wallobject_0.hash);
                                    }

                                    tile.wallCullDirection = 0;
                                 }
                              }

                              if (!tile.drawEntities) {
                                 break;
                              }

                              try {
                                 int int_14 = tile.objectCount;
                                 tile.drawEntities = false;
                                 int_5 = 0;

                                 label583:
                                 for (int_4 = 0; int_4 < int_14; int_4++) {
                                    gameobject_0 = tile.objects[int_4];
                                    if (gameobject_0.cycle != RENDERABLE_RULE) {
                                       for (int_6 = gameobject_0.relativeX; int_6 <= gameobject_0.offsetX; int_6++) {
                                          for (int_7 = gameobject_0.relativeY; int_7 <= gameobject_0.offsetY; int_7++) {
                                             tile_5 = tiles_0[int_6][int_7];
                                             if (tile_5.draw) {
                                                tile.drawEntities = true;
                                                continue label583;
                                             }

                                             if (tile_5.wallCullDirection != 0) {
                                                int_9 = 0;
                                                if (int_6 > gameobject_0.relativeX) {
                                                   ++int_9;
                                                }

                                                if (int_6 < gameobject_0.offsetX) {
                                                   int_9 += 4;
                                                }

                                                if (int_7 > gameobject_0.relativeY) {
                                                   int_9 += 8;
                                                }

                                                if (int_7 < gameobject_0.offsetY) {
                                                   int_9 += 2;
                                                }

                                                if ((int_9 & tile_5.wallCullDirection) == tile.wallCullOppositeDirection) {
                                                   tile.drawEntities = true;
                                                   continue label583;
                                                }
                                             }
                                          }
                                       }

                                       entityBuffer[int_5++] = gameobject_0;
                                       int_6 = screenCenterX - gameobject_0.relativeX;
                                       int_7 = gameobject_0.offsetX - screenCenterX;
                                       if (int_7 > int_6) {
                                          int_6 = int_7;
                                       }

                                       int_8 = screenCenterZ - gameobject_0.relativeY;
                                       int_9 = gameobject_0.offsetY - screenCenterZ;
                                       if (int_9 > int_8) {
                                          gameobject_0.drawPriority = int_6 + int_9;
                                       } else {
                                          gameobject_0.drawPriority = int_6 + int_8;
                                       }
                                    }
                                 }

                                 while (int_5 > 0) {
                                    int_4 = -50;
                                    int_10 = -1;

                                    for (int_6 = 0; int_6 < int_5; int_6++) {
                                       InteractiveObject gameobject_1 = entityBuffer[int_6];
                                       if (gameobject_1.cycle != RENDERABLE_RULE) {
                                          if (gameobject_1.drawPriority > int_4) {
                                             int_4 = gameobject_1.drawPriority;
                                             int_10 = int_6;
                                          } else if (int_4 == gameobject_1.drawPriority) {
                                             int_8 = gameobject_1.x - cameraPositionX;
                                             int_9 = gameobject_1.y - cameraPositionY;
                                             int_11 = entityBuffer[int_10].x - cameraPositionX;
                                             int_12 = entityBuffer[int_10].y - cameraPositionY;
                                             if (int_8 * int_8 + int_9 * int_9 > int_11 * int_11 + int_12 * int_12) {
                                                int_10 = int_6;
                                             }
                                          }
                                       }
                                    }

                                    if (int_10 == -1) {
                                       break;
                                    }

                                    InteractiveObject gameobject_2 = entityBuffer[int_10];
                                    gameobject_2.cycle = RENDERABLE_RULE;
                                    if (!this.isAreaOccluded(int_3, gameobject_2.relativeX, gameobject_2.offsetX, gameobject_2.relativeY, gameobject_2.offsetY, gameobject_2.renderable.modelHeight)) {
                                       gameobject_2.renderable.draw(gameobject_2.orientation, pitchSin, pitchCos, yawSin, yawCos, gameobject_2.x - cameraPositionX, gameobject_2.height - cameraY2, gameobject_2.y - cameraPositionY, gameobject_2.hash);
                                    }

                                    for (int_7 = gameobject_2.relativeX; int_7 <= gameobject_2.offsetX; int_7++) {
                                       for (int_8 = gameobject_2.relativeY; int_8 <= gameobject_2.offsetY; int_8++) {
                                          Tile tile_3 = tiles_0[int_7][int_8];
                                          if (tile_3.wallCullDirection != 0) {
                                             tileDeque.addFront(tile_3);
                                          } else if ((int_7 != int_0 || int_8 != int_1) && tile_3.visible) {
                                             tileDeque.addFront(tile_3);
                                          }
                                       }
                                    }
                                 }

                                 if (!tile.drawEntities) {
                                    break;
                                 }
                              } catch (Exception exception_0) {
                                 tile.drawEntities = false;
                                 break;
                              }
                           }
                        } while (!tile.visible);
                     } while (tile.wallCullDirection != 0);

                     if (int_0 > screenCenterX || int_0 <= minTileX) {
                        break;
                     }

                     tile_2 = tiles_0[int_0 - 1][int_1];
                  } while (tile_2 != null && tile_2.visible);

                  if (int_0 < screenCenterX || int_0 >= maxTileX - 1) {
                     break;
                  }

                  tile_2 = tiles_0[int_0 + 1][int_1];
               } while (tile_2 != null && tile_2.visible);

               if (int_1 > screenCenterZ || int_1 <= minTileZ) {
                  break;
               }

               tile_2 = tiles_0[int_0][int_1 - 1];
            } while (tile_2 != null && tile_2.visible);

            if (int_1 < screenCenterZ || int_1 >= maxTileZ - 1) {
               break;
            }

            tile_2 = tiles_0[int_0][int_1 + 1];
         } while (tile_2 != null && tile_2.visible);

         tile.visible = false;
         --tileUpdateCount;
         ItemLayer itemlayer_1 = tile.itemLayer;
         if (itemlayer_1 != null && itemlayer_1.height != 0) {
            if (itemlayer_1.middle != null) {
               itemlayer_1.middle.draw(0, pitchSin, pitchCos, yawSin, yawCos, itemlayer_1.x - cameraPositionX, itemlayer_1.hash - cameraY2 - itemlayer_1.height, itemlayer_1.y - cameraPositionY, itemlayer_1.flags);
            }

            if (itemlayer_1.top != null) {
               itemlayer_1.top.draw(0, pitchSin, pitchCos, yawSin, yawCos, itemlayer_1.x - cameraPositionX, itemlayer_1.hash - cameraY2 - itemlayer_1.height, itemlayer_1.y - cameraPositionY, itemlayer_1.flags);
            }

            if (itemlayer_1.bottom != null) {
               itemlayer_1.bottom.draw(0, pitchSin, pitchCos, yawSin, yawCos, itemlayer_1.x - cameraPositionX, itemlayer_1.hash - cameraY2 - itemlayer_1.height, itemlayer_1.y - cameraPositionY, itemlayer_1.flags);
            }
         }

         if (tile.wallDrawFlags != 0) {
            WallDecoration decorativeobject_1 = tile.wallDecoration;
            if (decorativeobject_1 != null && !this.isTileRendered(int_3, int_0, int_1, decorativeobject_1.primaryRenderable.modelHeight)) {
               if ((decorativeobject_1.primaryOrientation & tile.wallDrawFlags) != 0) {
                  decorativeobject_1.primaryRenderable.draw(0, pitchSin, pitchCos, yawSin, yawCos, decorativeobject_1.x - cameraPositionX + decorativeobject_1.offsetX, decorativeobject_1.floor - cameraY2, decorativeobject_1.y - cameraPositionY + decorativeobject_1.offsetY, decorativeobject_1.hash);
               } else if (decorativeobject_1.primaryOrientation == 256) {
                  int_4 = decorativeobject_1.x - cameraPositionX;
                  int_10 = decorativeobject_1.floor - cameraY2;
                  int_6 = decorativeobject_1.y - cameraPositionY;
                  int_7 = decorativeobject_1.secondaryOrientation;
                  if (int_7 != 1 && int_7 != 2) {
                     int_8 = int_4;
                  } else {
                     int_8 = -int_4;
                  }

                  if (int_7 != 2 && int_7 != 3) {
                     int_9 = int_6;
                  } else {
                     int_9 = -int_6;
                  }

                  if (int_9 >= int_8) {
                     decorativeobject_1.primaryRenderable.draw(0, pitchSin, pitchCos, yawSin, yawCos, int_4 + decorativeobject_1.offsetX, int_10, int_6 + decorativeobject_1.offsetY, decorativeobject_1.hash);
                  } else if (decorativeobject_1.secondaryRenderable != null) {
                     decorativeobject_1.secondaryRenderable.draw(0, pitchSin, pitchCos, yawSin, yawCos, int_4, int_10, int_6, decorativeobject_1.hash);
                  }
               }
            }

            Wall wallobject_1 = tile.wall;
            if (wallobject_1 != null) {
               if ((wallobject_1.secondaryOrientation & tile.wallDrawFlags) != 0 && !this.isOrientedWallRenderable(int_3, int_0, int_1, wallobject_1.secondaryOrientation)) {
                  wallobject_1.secondaryRenderable.draw(0, pitchSin, pitchCos, yawSin, yawCos, wallobject_1.x - cameraPositionX, wallobject_1.floor - cameraY2, wallobject_1.y - cameraPositionY, wallobject_1.hash);
               }

               if ((wallobject_1.primaryOrientation & tile.wallDrawFlags) != 0 && !this.isOrientedWallRenderable(int_3, int_0, int_1, wallobject_1.primaryOrientation)) {
                  wallobject_1.primaryRenderable.draw(0, pitchSin, pitchCos, yawSin, yawCos, wallobject_1.x - cameraPositionX, wallobject_1.floor - cameraY2, wallobject_1.y - cameraPositionY, wallobject_1.hash);
               }
            }
         }

         Tile tile_4;
         if (int_2 < this.mapSizeZ - 1) {
            tile_4 = this.tiles[int_2 + 1][int_0][int_1];
            if (tile_4 != null && tile_4.visible) {
               tileDeque.addFront(tile_4);
            }
         }

         if (int_0 < screenCenterX) {
            tile_4 = tiles_0[int_0 + 1][int_1];
            if (tile_4 != null && tile_4.visible) {
               tileDeque.addFront(tile_4);
            }
         }

         if (int_1 < screenCenterZ) {
            tile_4 = tiles_0[int_0][int_1 + 1];
            if (tile_4 != null && tile_4.visible) {
               tileDeque.addFront(tile_4);
            }
         }

         if (int_0 > screenCenterX) {
            tile_4 = tiles_0[int_0 - 1][int_1];
            if (tile_4 != null && tile_4.visible) {
               tileDeque.addFront(tile_4);
            }
         }

         if (int_1 > screenCenterZ) {
            tile_4 = tiles_0[int_0][int_1 - 1];
            if (tile_4 != null && tile_4.visible) {
               tileDeque.addFront(tile_4);
            }
         }
      }
   }

   public void addItemPile(int int_0, int int_1, int int_2, int int_3, Renderable renderable_0, int int_4, Renderable renderable_1, Renderable renderable_2) {
      ItemLayer itemlayer_0 = new ItemLayer();
      itemlayer_0.bottom = renderable_0;
      itemlayer_0.x = int_1 * 128 + 64;
      itemlayer_0.y = int_2 * 128 + 64;
      itemlayer_0.hash = int_3;
      itemlayer_0.flags = int_4;
      itemlayer_0.middle = renderable_1;
      itemlayer_0.top = renderable_2;
      int int_5 = 0;
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      if (tile_0 != null) {
         for (int int_6 = 0; int_6 < tile_0.objectCount; int_6++) {
            if ((tile_0.objects[int_6].objectConfig & 0x100) == 256 && tile_0.objects[int_6].renderable instanceof Model) {
               Model model_0 = (Model) tile_0.objects[int_6].renderable;
               model_0.calculateDiagonals();
               if (model_0.modelHeight > int_5) {
                  int_5 = model_0.modelHeight;
               }
            }
         }
      }

      itemlayer_0.height = int_5;
      if (this.tiles[int_0][int_1][int_2] == null) {
         this.tiles[int_0][int_1][int_2] = new Tile(int_0, int_1, int_2);
      }

      this.tiles[int_0][int_1][int_2].itemLayer = itemlayer_0;
   }

   public void method371() {
      viewportWalking = true;
   }

   public FloorDecoration getFloorDecoration(int z, int x, int y) {
      Tile tile = this.tiles[z][x][y];
      return tile != null && tile.floorDecoration != null ? tile.floorDecoration : null;
   }

   public void removeWallObjects(int z, int x, int y) {
      Tile tile = this.tiles[z][x][y];
      if (tile != null) {
         tile.wall = null;
      }
   }

   public void removeWallDecorations(int plane, int x, int y) {
      Tile tile = this.tiles[plane][x][y];
      if (tile != null) {
         tile.wallDecoration = null;
      }
   }

   public void removeInteractiveObjects(int plane, int x, int y) {
      Tile tile = this.tiles[plane][x][y];
      if (tile != null) {
         for (int count = 0; count < tile.objectCount; count++) {
            InteractiveObject object = tile.objects[count];
            if ((object.hash >> 29 & 0x3) == 2 && x == object.relativeX && y == object.relativeY) {
               this.removeInteractiveObject(object);
               return;
            }
         }

      }
   }

   public void removeFloorDecorations(int plane, int x, int y) {
      Tile tile = this.tiles[plane][x][y];
      if (tile != null) {
         tile.floorDecoration = null;
      }
   }

   public boolean method377(int int_0, int int_1, int int_2, int int_3, int int_4, Renderable renderable_0, int int_5, int int_6, boolean bool_0) {
      if (renderable_0 == null) {
         return true;
      } else {
         int int_7 = int_1 - int_4;
         int int_8 = int_2 - int_4;
         int int_9 = int_4 + int_1;
         int int_10 = int_2 + int_4;
         if (bool_0) {
            if (int_5 > 640 && int_5 < 1408) {
               int_10 += 128;
            }

            if (int_5 > 1152 && int_5 < 1920) {
               int_9 += 128;
            }

            if (int_5 > 1664 || int_5 < 384) {
               int_8 -= 128;
            }

            if (int_5 > 128 && int_5 < 896) {
               int_7 -= 128;
            }
         }

         int_7 /= 128;
         int_8 /= 128;
         int_9 /= 128;
         int_10 /= 128;
         return this.addRenderable(int_0, int_7, int_8, int_9 - int_7 + 1, int_10 - int_8 + 1, int_1, int_2, int_3, renderable_0, int_5, true, int_6, 0);
      }
   }

   public boolean method378(int int_0, int int_1, int int_2, int int_3, int int_4, Renderable renderable_0, int int_5, int int_6, int int_7, int int_8, int int_9, int int_10) {
      return renderable_0 == null ? true : this.addRenderable(int_0, int_7, int_8, int_9 - int_7 + 1, int_10 - int_8 + 1, int_1, int_2, int_3, renderable_0, int_5, true, int_6, 0);
   }

   public void addFloorDecoration(int z, int x, int y, int height, Renderable renderable, int key, int objectConfig) {
      if (renderable != null) {
         FloorDecoration decoration = new FloorDecoration();
         decoration.renderable = renderable;
         decoration.x = x * 128 + 64;
         decoration.y = y * 128 + 64;
         decoration.z = height;
         decoration.hash = key;
         decoration.objectConfig = objectConfig;
         if (this.tiles[z][x][y] == null) {
            this.tiles[z][x][y] = new Tile(z, x, y);
         }

         this.tiles[z][x][y].floorDecoration = decoration;
      }
   }

   public boolean addObject(int plane, int regionX, int regionY, int renderHeight, int width, int height, Renderable renderable, int yaw, int hash, int config) {
      if (renderable == null) {
         return true;
      } else {
         int centreX = width * 64 + regionX * 128;
         int centreY = height * 64 + regionY * 128;
         return this.addRenderable(plane, regionX, regionY, width, height, centreX, centreY, renderHeight, renderable, yaw, false, hash, config);
      }
   }

   public void addWall(int plane, int x, int y, int height, Renderable primaryRenderable, Renderable secondaryRenderable, int primaryOrientation, int secondaryOrientation, int hash, int config) {
      if (primaryRenderable != null || secondaryRenderable != null) {
         Wall wall = new Wall();
         wall.hash = hash;
         wall.objectConfig = config;
         wall.x = x * 128 + 64;
         wall.y = y * 128 + 64;
         wall.floor = height;
         wall.primaryRenderable = primaryRenderable;
         wall.secondaryRenderable = secondaryRenderable;
         wall.primaryOrientation = primaryOrientation;
         wall.secondaryOrientation = secondaryOrientation;

         for (int z = plane; z >= 0; --z) {
            if (this.tiles[z][x][y] == null) {
               this.tiles[z][x][y] = new Tile(z, x, y);
            }
         }

         this.tiles[plane][x][y].wall = wall;
      }
   }

   public void addWallDecoration(int plane, int x, int y, int height, Renderable primaryRenderable, Renderable secondaryRenderable, int primaryOrientation, int secondaryOrientation, int offsetX, int offsetY, int hash, int config) {
      if (primaryRenderable != null) {
         WallDecoration wall = new WallDecoration();
         wall.hash = hash;
         wall.objectConfig = config;
         wall.x = x * 128 + 64;
         wall.y = y * 128 + 64;
         wall.floor = height;
         wall.primaryRenderable = primaryRenderable;
         wall.secondaryRenderable = secondaryRenderable;
         wall.primaryOrientation = primaryOrientation;
         wall.secondaryOrientation = secondaryOrientation;
         wall.offsetX = offsetX;
         wall.offsetY = offsetY;

         for (int z = plane; z >= 0; --z) {
            if (this.tiles[z][x][y] == null) {
               this.tiles[z][x][y] = new Tile(z, x, y);
            }
         }

         this.tiles[plane][x][y].wallDecoration = wall;
      }
   }

   public void draw(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      if (int_0 < 0) {
         int_0 = 0;
      } else if (int_0 >= this.mapSizeX * 128) {
         int_0 = this.mapSizeX * 128 - 1;
      }

      if (int_2 < 0) {
         int_2 = 0;
      } else if (int_2 >= this.mapSizeY * 128) {
         int_2 = this.mapSizeY * 128 - 1;
      }

      ++RENDERABLE_RULE;
      pitchSin = Graphics3D.SINE[int_3];
      pitchCos = Graphics3D.COSINE[int_3];
      yawSin = Graphics3D.SINE[int_4];
      yawCos = Graphics3D.COSINE[int_4];
      renderArea = visibilityMaps[(int_3 - 128) / 32][int_4 / 64];
      cameraPositionX = int_0;
      cameraY2 = int_1;
      cameraPositionY = int_2;
      screenCenterX = int_0 / 128;
      screenCenterZ = int_2 / 128;
      anInt147 = int_5;
      minTileX = screenCenterX - 25;
      if (minTileX < 0) {
         minTileX = 0;
      }

      minTileZ = screenCenterZ - 25;
      if (minTileZ < 0) {
         minTileZ = 0;
      }

      maxTileX = screenCenterX + 25;
      if (maxTileX > this.mapSizeX) {
         maxTileX = this.mapSizeX;
      }

      maxTileZ = screenCenterZ + 25;
      if (maxTileZ > this.mapSizeY) {
         maxTileZ = this.mapSizeY;
      }

      this.updateOccluders();
      tileUpdateCount = 0;

      int int_6;
      Tile[][] tiles_0;
      int int_7;
      int int_8;
      for (int_6 = this.minLevel; int_6 < this.mapSizeZ; int_6++) {
         tiles_0 = this.tiles[int_6];

         for (int_7 = minTileX; int_7 < maxTileX; int_7++) {
            for (int_8 = minTileZ; int_8 < maxTileZ; int_8++) {
               Tile tile_0 = tiles_0[int_7][int_8];
               if (tile_0 != null) {
                  if (tile_0.physicalLevel > int_5 || !renderArea[int_7 - screenCenterX + 25][int_8 - screenCenterZ + 25] && this.tileHeights[int_6][int_7][int_8] - int_1 < 2000) {
                     tile_0.draw = false;
                     tile_0.visible = false;
                     tile_0.wallCullDirection = 0;
                  } else {
                     tile_0.draw = true;
                     tile_0.visible = true;
                     if (tile_0.objectCount > 0) {
                        tile_0.drawEntities = true;
                     } else {
                        tile_0.drawEntities = false;
                     }

                     ++tileUpdateCount;
                  }
               }
            }
         }
      }

      int int_9;
      int int_10;
      int int_11;
      int int_12;
      Tile tile_1;
      for (int_6 = this.minLevel; int_6 < this.mapSizeZ; int_6++) {
         tiles_0 = this.tiles[int_6];

         for (int_7 = -25; int_7 <= 0; int_7++) {
            int_8 = int_7 + screenCenterX;
            int_9 = screenCenterX - int_7;
            if (int_8 >= minTileX || int_9 < maxTileX) {
               for (int_10 = -25; int_10 <= 0; int_10++) {
                  int_11 = int_10 + screenCenterZ;
                  int_12 = screenCenterZ - int_10;
                  if (int_8 >= minTileX) {
                     if (int_11 >= minTileZ) {
                        tile_1 = tiles_0[int_8][int_11];
                        if (tile_1 != null && tile_1.draw) {
                           this.draw(tile_1, true);
                        }
                     }

                     if (int_12 < maxTileZ) {
                        tile_1 = tiles_0[int_8][int_12];
                        if (tile_1 != null && tile_1.draw) {
                           this.draw(tile_1, true);
                        }
                     }
                  }

                  if (int_9 < maxTileX) {
                     if (int_11 >= minTileZ) {
                        tile_1 = tiles_0[int_9][int_11];
                        if (tile_1 != null && tile_1.draw) {
                           this.draw(tile_1, true);
                        }
                     }

                     if (int_12 < maxTileZ) {
                        tile_1 = tiles_0[int_9][int_12];
                        if (tile_1 != null && tile_1.draw) {
                           this.draw(tile_1, true);
                        }
                     }
                  }

                  if (tileUpdateCount == 0) {
                     isClicked = false;
                     return;
                  }
               }
            }
         }
      }

      for (int_6 = this.minLevel; int_6 < this.mapSizeZ; int_6++) {
         tiles_0 = this.tiles[int_6];

         for (int_7 = -25; int_7 <= 0; int_7++) {
            int_8 = int_7 + screenCenterX;
            int_9 = screenCenterX - int_7;
            if (int_8 >= minTileX || int_9 < maxTileX) {
               for (int_10 = -25; int_10 <= 0; int_10++) {
                  int_11 = int_10 + screenCenterZ;
                  int_12 = screenCenterZ - int_10;
                  if (int_8 >= minTileX) {
                     if (int_11 >= minTileZ) {
                        tile_1 = tiles_0[int_8][int_11];
                        if (tile_1 != null && tile_1.draw) {
                           this.draw(tile_1, false);
                        }
                     }

                     if (int_12 < maxTileZ) {
                        tile_1 = tiles_0[int_8][int_12];
                        if (tile_1 != null && tile_1.draw) {
                           this.draw(tile_1, false);
                        }
                     }
                  }

                  if (int_9 < maxTileX) {
                     if (int_11 >= minTileZ) {
                        tile_1 = tiles_0[int_9][int_11];
                        if (tile_1 != null && tile_1.draw) {
                           this.draw(tile_1, false);
                        }
                     }

                     if (int_12 < maxTileZ) {
                        tile_1 = tiles_0[int_9][int_12];
                        if (tile_1 != null && tile_1.draw) {
                           this.draw(tile_1, false);
                        }
                     }
                  }

                  if (tileUpdateCount == 0) {
                     isClicked = false;
                     return;
                  }
               }
            }
         }
      }

      isClicked = false;
   }

   public void clearInteractiveObjectCache() {
      for (int index = 0; index < this.entityCount; index++) {
         InteractiveObject object = this.interactiveObjectCache[index];
         this.removeInteractiveObject(object);
         this.interactiveObjectCache[index] = null;
      }

      this.entityCount = 0;
   }

   public void offsetWallObject(int z, int x, int y, int offsetMultiplier) {
      Tile tile = this.tiles[z][x][y];
      if (tile != null) {
         WallDecoration wallDecoration = tile.wallDecoration;
         if (wallDecoration != null) {
            wallDecoration.offsetX = offsetMultiplier * wallDecoration.offsetX / 16;
            wallDecoration.offsetY = offsetMultiplier * wallDecoration.offsetY / 16;
         }
      }
   }

   public void shadeModels(int x, int y, int z) {
      for (int tileZ = 0; tileZ < this.mapSizeZ; tileZ++) {
         for (int tileX = 0; tileX < this.mapSizeX; tileX++) {
            for (int tileY = 0; tileY < this.mapSizeY; tileY++) {
               Tile tile = this.tiles[tileZ][tileX][tileY];
               if (tile != null) {
                  Wall wall = tile.wall;
                  ModelHeader header;
                  if (wall != null && wall.primaryRenderable instanceof ModelHeader) {
                     ModelHeader renderable = (ModelHeader) wall.primaryRenderable;
                     this.snapWallModels(renderable, tileZ, tileX, tileY, 1, 1);
                     if (wall.secondaryRenderable instanceof ModelHeader) {
                        header = (ModelHeader) wall.secondaryRenderable;
                        this.snapWallModels(header, tileZ, tileX, tileY, 1, 1);
                        ModelHeader.snapModelVertices(renderable, header, 0, 0, 0, false);
                        wall.secondaryRenderable = header.applyLighting(header.aShort2, header.contrast, x, y, z);
                     }

                     wall.primaryRenderable = renderable.applyLighting(renderable.aShort2, renderable.contrast, x, y, z);
                  }

                  for (int count = 0; count < tile.objectCount; count++) {
                     InteractiveObject object = tile.objects[count];
                     if (object != null && object.renderable instanceof ModelHeader) {
                        ModelHeader renderable = (ModelHeader) object.renderable;
                        this.snapWallModels(renderable, tileZ, tileX, tileY, object.offsetX - object.relativeX + 1, object.offsetY - object.relativeY + 1);
                        object.renderable = renderable.applyLighting(renderable.aShort2, renderable.contrast, x, y, z);
                     }
                  }

                  FloorDecoration floor = tile.floorDecoration;
                  if (floor != null && floor.renderable instanceof ModelHeader) {
                     header = (ModelHeader) floor.renderable;
                     this.snapGroundItemModels(header, tileZ, tileX, tileY);
                     floor.renderable = header.applyLighting(header.aShort2, header.contrast, x, y, z);
                  }
               }
            }
         }
      }

   }

   public void setBridge(int localX, int localY) {
      Tile bottomTile = this.tiles[0][localX][localY];

      for (int plane = 0; plane < 3; plane++) {
         Tile tile = this.tiles[plane][localX][localY] = this.tiles[plane + 1][localX][localY];
         if (tile != null) {
            --tile.plane;

            for (int index = 0; index < tile.objectCount; index++) {
               InteractiveObject object = tile.objects[index];
               if ((object.hash >> 29 & 0x3) == 2 && object.relativeX == localX && localY == object.relativeY) {
                  --object.plane;
               }
            }
         }
      }

      if (this.tiles[0][localX][localY] == null) {
         this.tiles[0][localX][localY] = new Tile(0, localX, localY);
      }

      this.tiles[0][localX][localY].bridge = bottomTile;
      this.tiles[3][localX][localY] = null;
   }

   public void setPhysicalLevel(int int_0, int int_1, int int_2, int int_3) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      if (tile_0 != null) {
         this.tiles[int_0][int_1][int_2].physicalLevel = int_3;
      }
   }

   public void setup(int int_0) {
      this.minLevel = int_0;

      for (int int_1 = 0; int_1 < this.mapSizeX; int_1++) {
         for (int int_2 = 0; int_2 < this.mapSizeY; int_2++) {
            if (this.tiles[int_0][int_1][int_2] == null) {
               this.tiles[int_0][int_1][int_2] = new Tile(int_0, int_1, int_2);
            }
         }
      }

   }

   public void addTile(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8, int int_9, int int_10, int int_11, int int_12, int int_13, int int_14, int int_15, int int_16, int int_17, int int_18, int int_19) {
      ComplexTile scenetilepaint_0;
      int int_20;
      if (int_3 == 0) {
         scenetilepaint_0 = new ComplexTile(int_10, int_11, int_12, int_13, -1, int_18, false);

         for (int_20 = int_0; int_20 >= 0; --int_20) {
            if (this.tiles[int_20][int_1][int_2] == null) {
               this.tiles[int_20][int_1][int_2] = new Tile(int_20, int_1, int_2);
            }
         }

         this.tiles[int_0][int_1][int_2].paint = scenetilepaint_0;
      } else if (int_3 != 1) {
         SceneTileModel scenetilemodel_0 = new SceneTileModel(int_3, int_4, int_5, int_1, int_2, int_6, int_7, int_8, int_9, int_10, int_11, int_12, int_13, int_14, int_15, int_16, int_17, int_18, int_19);

         for (int_20 = int_0; int_20 >= 0; --int_20) {
            if (this.tiles[int_20][int_1][int_2] == null) {
               this.tiles[int_20][int_1][int_2] = new Tile(int_20, int_1, int_2);
            }
         }

         this.tiles[int_0][int_1][int_2].overlay = scenetilemodel_0;
      } else {
         scenetilepaint_0 = new ComplexTile(int_14, int_15, int_16, int_17, int_5, int_19, int_7 == int_6 && int_6 == int_8 && int_9 == int_6);

         for (int_20 = int_0; int_20 >= 0; --int_20) {
            if (this.tiles[int_20][int_1][int_2] == null) {
               this.tiles[int_20][int_1][int_2] = new Tile(int_20, int_1, int_2);
            }
         }

         this.tiles[int_0][int_1][int_2].paint = scenetilepaint_0;
      }
   }

   public static boolean method381() {
      return viewportWalking && clickedTileX != -1;
   }

   public static int[] method382(int int_0, int int_1, int int_2) {
      int int_3 = int_0 * yawCos + int_2 * yawSin >> 16;
      int_2 = int_2 * yawCos - int_0 * yawSin >> 16;
      int_0 = int_3;
      int_3 = pitchCos * int_1 - int_2 * pitchSin >> 16;
      int_2 = pitchSin * int_1 + int_2 * pitchCos >> 16;
      int_2 |= 0x1;
      int int_4 = int_0 * Graphics3D.anInt543 / int_2 + Graphics3D.centerX + Rasterizer2D.topX;
      int int_5 = Graphics3D.anInt543 * int_3 / int_2 + Graphics3D.centerY + Rasterizer2D.topY;
      return new int[] {int_4, int_5};
   }

   public static void method383(int[] ints_0, int int_0, int int_1, int int_2, int int_3) {
      anInt149 = 0;
      anInt150 = 0;
      anInt151 = int_2;
      anInt152 = int_3;
      anInt153 = int_2 / 2;
      anInt154 = int_3 / 2;
      boolean[][][][] bools_0 = new boolean[9][32][53][53];

      int int_4;
      int int_5;
      int int_6;
      int int_7;
      int int_9;
      int int_10;
      for (int_4 = 128; int_4 <= 384; int_4 += 32) {
         for (int_5 = 0; int_5 < 2048; int_5 += 64) {
            pitchSin = Graphics3D.SINE[int_4];
            pitchCos = Graphics3D.COSINE[int_4];
            yawSin = Graphics3D.SINE[int_5];
            yawCos = Graphics3D.COSINE[int_5];
            int_6 = (int_4 - 128) / 32;
            int_7 = int_5 / 64;

            for (int int_8 = -26; int_8 <= 26; int_8++) {
               for (int_9 = -26; int_9 <= 26; int_9++) {
                  int_10 = int_8 * 128;
                  int int_11 = int_9 * 128;
                  boolean bool_0 = false;

                  for (int int_12 = -int_0; int_12 <= int_1; int_12 += 128) {
                     if (method385(int_10, ints_0[int_6] + int_12, int_11)) {
                        bool_0 = true;
                        break;
                     }
                  }

                  bools_0[int_6][int_7][int_8 + 1 + 25][int_9 + 1 + 25] = bool_0;
               }
            }
         }
      }

      for (int_4 = 0; int_4 < 8; int_4++) {
         for (int_5 = 0; int_5 < 32; int_5++) {
            for (int_6 = -25; int_6 < 25; int_6++) {
               for (int_7 = -25; int_7 < 25; int_7++) {
                  boolean bool_1 = false;

                  label76:
                  for (int_9 = -1; int_9 <= 1; int_9++) {
                     for (int_10 = -1; int_10 <= 1; int_10++) {
                        if (bools_0[int_4][int_5][int_6 + int_9 + 1 + 25][int_7 + int_10 + 1 + 25]) {
                           bool_1 = true;
                           break label76;
                        }

                        if (bools_0[int_4][(int_5 + 1) % 31][int_6 + int_9 + 1 + 25][int_7 + int_10 + 1 + 25]) {
                           bool_1 = true;
                           break label76;
                        }

                        if (bools_0[int_4 + 1][int_5][int_6 + int_9 + 1 + 25][int_7 + int_10 + 1 + 25]) {
                           bool_1 = true;
                           break label76;
                        }

                        if (bools_0[int_4 + 1][(int_5 + 1) % 31][int_6 + int_9 + 1 + 25][int_7 + int_10 + 1 + 25]) {
                           bool_1 = true;
                           break label76;
                        }
                     }
                  }

                  visibilityMaps[int_4][int_5][int_6 + 25][int_7 + 25] = bool_1;
               }
            }
         }
      }

   }

   static int method384(int int_0, int int_1) {
      int_1 = (int_0 & 0x7F) * int_1 >> 7;
      if (int_1 < 2) {
         int_1 = 2;
      } else if (int_1 > 126) {
         int_1 = 126;
      }

      return (int_0 & 0xFF80) + int_1;
   }

   static boolean method385(int int_0, int int_1, int int_2) {
      int int_3 = int_0 * yawCos + int_2 * yawSin >> 16;
      int int_4 = int_2 * yawCos - int_0 * yawSin >> 16;
      int int_5 = int_4 * pitchCos + pitchSin * int_1 >> 16;
      int int_6 = pitchCos * int_1 - int_4 * pitchSin >> 16;
      if (int_5 >= 50 && int_5 <= 3500) {
         int int_7 = int_3 * 390 / int_5 + anInt153;
         int int_8 = int_6 * 390 / int_5 + anInt154;
         return int_7 >= anInt149 && int_7 <= anInt151 && int_8 >= anInt150 && int_8 <= anInt152;
      } else {
         return false;
      }
   }

   public static void method386() {
      clickedTileX = -1;
      viewportWalking = false;
   }

   public static void addOcclude(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7) {
      SceneCluster sceneCluster_0 = new SceneCluster();
      sceneCluster_0.minTileX = int_2 / 128;
      sceneCluster_0.maxTIleX = int_3 / 128;
      sceneCluster_0.minTileZ = int_4 / 128;
      sceneCluster_0.maxTileZ = int_5 / 128;
      sceneCluster_0.type = int_1;
      sceneCluster_0.minX = int_2;
      sceneCluster_0.maxX = int_3;
      sceneCluster_0.minZ = int_4;
      sceneCluster_0.maxZ = int_5;
      sceneCluster_0.minY = int_6;
      sceneCluster_0.maxY = int_7;
      levelSceneClusters[int_0][levelOccluderCount[int_0]++] = sceneCluster_0;
   }

}
