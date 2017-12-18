public class Class107 {

   static IndexedSprite anIndexedSprite6;
   boolean aBool33;
   int anInt208;
   IndexDataBase anIndexDataBase9;
   String aString14;

   Class107(IndexDataBase indexdatabase_0) {
      this.anInt208 = 0;
      this.aBool33 = false;
      this.anIndexDataBase9 = indexdatabase_0;
   }

   int method538() {
      if (this.anInt208 < 25) {
         if (!this.anIndexDataBase9.method429(Class16.aClass16_2.aString2, this.aString14)) {
            return this.anInt208;
         }

         this.anInt208 = 25;
      }

      if (this.anInt208 == 25) {
         if (!this.anIndexDataBase9.method429(this.aString14, Class16.aClass16_3.aString2)) {
            return 25 + this.anIndexDataBase9.method434(this.aString14) * 25 / 100;
         }

         this.anInt208 = 50;
      }

      if (this.anInt208 == 50) {
         if (this.anIndexDataBase9.method433(Class16.aClass16_4.aString2, this.aString14) && !this.anIndexDataBase9.method429(Class16.aClass16_4.aString2, this.aString14)) {
            return 50;
         }

         this.anInt208 = 75;
      }

      if (this.anInt208 == 75) {
         if (!this.anIndexDataBase9.method429(this.aString14, Class16.aClass16_5.aString2)) {
            return 75;
         }

         this.anInt208 = 100;
         this.aBool33 = true;
      }

      return this.anInt208;
   }

   boolean method539() {
      return this.aBool33;
   }

   void method540(String string_0) {
      if (string_0 != null && !string_0.isEmpty()) {
         if (string_0 != this.aString14) {
            this.aString14 = string_0;
            this.anInt208 = 0;
            this.aBool33 = false;
            this.method538();
         }
      }
   }

   int method541() {
      return this.anInt208;
   }

   static void renderObject(int floorLevel, int plane, int regionX, int regionY, int objectId, int face, int type, Region region, CollisionData collisionData) {
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

      int[][] heights = Class19.tileHeights[plane];
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

         region.groundObjectSpawned(floorLevel, regionX, regionY, mean, (Renderable) renderable, hash, objectConfig);
         if (definition.interactType == 1) {
            collisionData.block(regionX, regionY);
         }

      } else if (type != 10 && type != 11) {
         if (type >= 12) {
            if (definition.animationId == -1 && definition.transformationIds == null) {
               renderable = definition.getModelAt(type, face, heights, vertexX, mean, vertexY);
            } else {
               renderable = new GameObject(objectId, type, face, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
            }

            region.method379(floorLevel, regionX, regionY, mean, 1, 1, (Renderable) renderable, 0, hash, objectConfig);
            if (definition.interactType != 0) {
               collisionData.addObject(regionX, regionY, sizeY, sizeX, definition.projectileClipped);
            }

         } else if (type == 0) {
            if (definition.animationId == -1 && definition.transformationIds == null) {
               renderable = definition.getModelAt(0, face, heights, vertexX, mean, vertexY);
            } else {
               renderable = new GameObject(objectId, 0, face, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
            }

            region.addBoundary(floorLevel, regionX, regionY, mean, (Renderable) renderable, (Renderable) null, Class19.anIntArray7[face], 0, hash, objectConfig);
            if (definition.interactType != 0) {
               collisionData.addWall(regionX, regionY, type, face, definition.projectileClipped);
            }

         } else if (type == 1) {
            if (definition.animationId == -1 && definition.transformationIds == null) {
               renderable = definition.getModelAt(1, face, heights, vertexX, mean, vertexY);
            } else {
               renderable = new GameObject(objectId, 1, face, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
            }

            region.addBoundary(floorLevel, regionX, regionY, mean, (Renderable) renderable, (Renderable) null, Class19.anIntArray9[face], 0, hash, objectConfig);
            if (definition.interactType != 0) {
               collisionData.addWall(regionX, regionY, type, face, definition.projectileClipped);
            }

         } else {
            int int_18;
            Object object_2;
            if (type == 2) {
               int_18 = face + 1 & 0x3;
               Object object_1;
               if (definition.animationId == -1 && definition.transformationIds == null) {
                  object_1 = definition.getModelAt(2, face + 4, heights, vertexX, mean, vertexY);
                  object_2 = definition.getModelAt(2, int_18, heights, vertexX, mean, vertexY);
               } else {
                  object_1 = new GameObject(objectId, 2, face + 4, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                  object_2 = new GameObject(objectId, 2, int_18, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
               }

               region.addBoundary(floorLevel, regionX, regionY, mean, (Renderable) object_1, (Renderable) object_2, Class19.anIntArray7[face], Class19.anIntArray7[int_18], hash, objectConfig);
               if (definition.interactType != 0) {
                  collisionData.addWall(regionX, regionY, type, face, definition.projectileClipped);
               }

            } else if (type == 3) {
               if (definition.animationId == -1 && definition.transformationIds == null) {
                  renderable = definition.getModelAt(3, face, heights, vertexX, mean, vertexY);
               } else {
                  renderable = new GameObject(objectId, 3, face, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
               }

               region.addBoundary(floorLevel, regionX, regionY, mean, (Renderable) renderable, (Renderable) null, Class19.anIntArray9[face], 0, hash, objectConfig);
               if (definition.interactType != 0) {
                  collisionData.addWall(regionX, regionY, type, face, definition.projectileClipped);
               }

            } else if (type == 9) {
               if (definition.animationId == -1 && definition.transformationIds == null) {
                  renderable = definition.getModelAt(type, face, heights, vertexX, mean, vertexY);
               } else {
                  renderable = new GameObject(objectId, type, face, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
               }

               region.method379(floorLevel, regionX, regionY, mean, 1, 1, (Renderable) renderable, 0, hash, objectConfig);
               if (definition.interactType != 0) {
                  collisionData.addObject(regionX, regionY, sizeY, sizeX, definition.projectileClipped);
               }

            } else if (type == 4) {
               if (definition.animationId == -1 && definition.transformationIds == null) {
                  renderable = definition.getModelAt(4, face, heights, vertexX, mean, vertexY);
               } else {
                  renderable = new GameObject(objectId, 4, face, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
               }

               region.addBoundaryDecoration(floorLevel, regionX, regionY, mean, (Renderable) renderable, (Renderable) null, Class19.anIntArray7[face], 0, 0, 0, hash, objectConfig);
            } else {
               int int_19;
               if (type == 5) {
                  int_18 = 16;
                  int_19 = region.getWallObjectUID(floorLevel, regionX, regionY);
                  if (int_19 != 0) {
                     int_18 = ObjectDefinition.getDefinition(int_19 >> 14 & 0x7FFF).offsetMultiplier;
                  }

                  if (definition.animationId == -1 && definition.transformationIds == null) {
                     object_2 = definition.getModelAt(4, face, heights, vertexX, mean, vertexY);
                  } else {
                     object_2 = new GameObject(objectId, 4, face, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                  }

                  region.addBoundaryDecoration(floorLevel, regionX, regionY, mean, (Renderable) object_2, (Renderable) null, Class19.anIntArray7[face], 0, int_18 * Class19.anIntArray10[face], int_18 * Class19.anIntArray12[face], hash, objectConfig);
               } else if (type == 6) {
                  int_18 = 8;
                  int_19 = region.getWallObjectUID(floorLevel, regionX, regionY);
                  if (int_19 != 0) {
                     int_18 = ObjectDefinition.getDefinition(int_19 >> 14 & 0x7FFF).offsetMultiplier / 2;
                  }

                  if (definition.animationId == -1 && definition.transformationIds == null) {
                     object_2 = definition.getModelAt(4, face + 4, heights, vertexX, mean, vertexY);
                  } else {
                     object_2 = new GameObject(objectId, 4, face + 4, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                  }

                  region.addBoundaryDecoration(floorLevel, regionX, regionY, mean, (Renderable) object_2, (Renderable) null, 256, face, int_18 * Class19.anIntArray13[face], int_18 * Class19.anIntArray14[face], hash, objectConfig);
               } else if (type == 7) {
                  int_19 = face + 2 & 0x3;
                  if (definition.animationId == -1 && definition.transformationIds == null) {
                     renderable = definition.getModelAt(4, int_19 + 4, heights, vertexX, mean, vertexY);
                  } else {
                     renderable = new GameObject(objectId, 4, int_19 + 4, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                  }

                  region.addBoundaryDecoration(floorLevel, regionX, regionY, mean, (Renderable) renderable, (Renderable) null, 256, int_19, 0, 0, hash, objectConfig);
               } else if (type == 8) {
                  int_18 = 8;
                  int_19 = region.getWallObjectUID(floorLevel, regionX, regionY);
                  if (int_19 != 0) {
                     int_18 = ObjectDefinition.getDefinition(int_19 >> 14 & 0x7FFF).offsetMultiplier / 2;
                  }

                  int int_20 = face + 2 & 0x3;
                  Object object_3;
                  if (definition.animationId == -1 && definition.transformationIds == null) {
                     object_2 = definition.getModelAt(4, face + 4, heights, vertexX, mean, vertexY);
                     object_3 = definition.getModelAt(4, int_20 + 4, heights, vertexX, mean, vertexY);
                  } else {
                     object_2 = new GameObject(objectId, 4, face + 4, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                     object_3 = new GameObject(objectId, 4, int_20 + 4, plane, regionX, regionY, definition.animationId, true, (Renderable) null);
                  }

                  region.addBoundaryDecoration(floorLevel, regionX, regionY, mean, (Renderable) object_2, (Renderable) object_3, 256, face, int_18 * Class19.anIntArray13[face], int_18 * Class19.anIntArray14[face], hash, objectConfig);
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
            region.method379(floorLevel, regionX, regionY, mean, sizeY, sizeX, (Renderable) renderable, type == 11 ? 256 : 0, hash, objectConfig);
         }

         if (definition.interactType != 0) {
            collisionData.addObject(regionX, regionY, sizeY, sizeX, definition.projectileClipped);
         }

      }
   }

}
