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

   static void method542(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, Region region_0, CollisionData collisiondata_0) {
      ObjectComposition objectcomposition_0 = Class28.getObjectDefinition(int_4);
      int int_7;
      int int_8;
      if (int_5 != 1 && int_5 != 3) {
         int_7 = objectcomposition_0.sizeX;
         int_8 = objectcomposition_0.sizeY;
      } else {
         int_7 = objectcomposition_0.sizeY;
         int_8 = objectcomposition_0.sizeX;
      }

      int int_9;
      int int_10;
      if (int_7 + int_2 <= 104) {
         int_9 = (int_7 >> 1) + int_2;
         int_10 = int_2 + (int_7 + 1 >> 1);
      } else {
         int_9 = int_2;
         int_10 = int_2 + 1;
      }

      int int_11;
      int int_12;
      if (int_3 + int_8 <= 104) {
         int_11 = int_3 + (int_8 >> 1);
         int_12 = int_3 + (int_8 + 1 >> 1);
      } else {
         int_11 = int_3;
         int_12 = int_3 + 1;
      }

      int[][] ints_0 = Class19.tileHeights[int_1];
      int int_13 = ints_0[int_10][int_11] + ints_0[int_9][int_11] + ints_0[int_9][int_12] + ints_0[int_10][int_12] >> 2;
      int int_14 = (int_2 << 7) + (int_7 << 6);
      int int_15 = (int_3 << 7) + (int_8 << 6);
      int int_16 = (int_3 << 7) + int_2 + (int_4 << 14) + 1073741824;
      if (objectcomposition_0.anInt461 == 0) {
         int_16 -= Integer.MIN_VALUE;
      }

      int int_17 = (int_5 << 6) + int_6;
      if (objectcomposition_0.anInt462 == 1) {
         int_17 += 256;
      }

      Object object_0;
      if (int_6 == 22) {
         if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
            object_0 = objectcomposition_0.method825(22, int_5, ints_0, int_14, int_13, int_15);
         } else {
            object_0 = new DynamicObject(int_4, 22, int_5, int_1, int_2, int_3, objectcomposition_0.animationId, true, (Renderable) null);
         }

         region_0.groundObjectSpawned(int_0, int_2, int_3, int_13, (Renderable) object_0, int_16, int_17);
         if (objectcomposition_0.interactType == 1) {
            collisiondata_0.block(int_2, int_3);
         }

      } else if (int_6 != 10 && int_6 != 11) {
         if (int_6 >= 12) {
            if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
               object_0 = objectcomposition_0.method825(int_6, int_5, ints_0, int_14, int_13, int_15);
            } else {
               object_0 = new DynamicObject(int_4, int_6, int_5, int_1, int_2, int_3, objectcomposition_0.animationId, true, (Renderable) null);
            }

            region_0.method379(int_0, int_2, int_3, int_13, 1, 1, (Renderable) object_0, 0, int_16, int_17);
            if (objectcomposition_0.interactType != 0) {
               collisiondata_0.addObject(int_2, int_3, int_7, int_8, objectcomposition_0.aBool60);
            }

         } else if (int_6 == 0) {
            if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
               object_0 = objectcomposition_0.method825(0, int_5, ints_0, int_14, int_13, int_15);
            } else {
               object_0 = new DynamicObject(int_4, 0, int_5, int_1, int_2, int_3, objectcomposition_0.animationId, true, (Renderable) null);
            }

            region_0.addBoundary(int_0, int_2, int_3, int_13, (Renderable) object_0, (Renderable) null, Class19.anIntArray7[int_5], 0, int_16, int_17);
            if (objectcomposition_0.interactType != 0) {
               collisiondata_0.addWall(int_2, int_3, int_6, int_5, objectcomposition_0.aBool60);
            }

         } else if (int_6 == 1) {
            if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
               object_0 = objectcomposition_0.method825(1, int_5, ints_0, int_14, int_13, int_15);
            } else {
               object_0 = new DynamicObject(int_4, 1, int_5, int_1, int_2, int_3, objectcomposition_0.animationId, true, (Renderable) null);
            }

            region_0.addBoundary(int_0, int_2, int_3, int_13, (Renderable) object_0, (Renderable) null, Class19.anIntArray9[int_5], 0, int_16, int_17);
            if (objectcomposition_0.interactType != 0) {
               collisiondata_0.addWall(int_2, int_3, int_6, int_5, objectcomposition_0.aBool60);
            }

         } else {
            int int_18;
            Object object_2;
            if (int_6 == 2) {
               int_18 = int_5 + 1 & 0x3;
               Object object_1;
               if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                  object_1 = objectcomposition_0.method825(2, int_5 + 4, ints_0, int_14, int_13, int_15);
                  object_2 = objectcomposition_0.method825(2, int_18, ints_0, int_14, int_13, int_15);
               } else {
                  object_1 = new DynamicObject(int_4, 2, int_5 + 4, int_1, int_2, int_3, objectcomposition_0.animationId, true, (Renderable) null);
                  object_2 = new DynamicObject(int_4, 2, int_18, int_1, int_2, int_3, objectcomposition_0.animationId, true, (Renderable) null);
               }

               region_0.addBoundary(int_0, int_2, int_3, int_13, (Renderable) object_1, (Renderable) object_2, Class19.anIntArray7[int_5], Class19.anIntArray7[int_18], int_16, int_17);
               if (objectcomposition_0.interactType != 0) {
                  collisiondata_0.addWall(int_2, int_3, int_6, int_5, objectcomposition_0.aBool60);
               }

            } else if (int_6 == 3) {
               if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                  object_0 = objectcomposition_0.method825(3, int_5, ints_0, int_14, int_13, int_15);
               } else {
                  object_0 = new DynamicObject(int_4, 3, int_5, int_1, int_2, int_3, objectcomposition_0.animationId, true, (Renderable) null);
               }

               region_0.addBoundary(int_0, int_2, int_3, int_13, (Renderable) object_0, (Renderable) null, Class19.anIntArray9[int_5], 0, int_16, int_17);
               if (objectcomposition_0.interactType != 0) {
                  collisiondata_0.addWall(int_2, int_3, int_6, int_5, objectcomposition_0.aBool60);
               }

            } else if (int_6 == 9) {
               if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                  object_0 = objectcomposition_0.method825(int_6, int_5, ints_0, int_14, int_13, int_15);
               } else {
                  object_0 = new DynamicObject(int_4, int_6, int_5, int_1, int_2, int_3, objectcomposition_0.animationId, true, (Renderable) null);
               }

               region_0.method379(int_0, int_2, int_3, int_13, 1, 1, (Renderable) object_0, 0, int_16, int_17);
               if (objectcomposition_0.interactType != 0) {
                  collisiondata_0.addObject(int_2, int_3, int_7, int_8, objectcomposition_0.aBool60);
               }

            } else if (int_6 == 4) {
               if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                  object_0 = objectcomposition_0.method825(4, int_5, ints_0, int_14, int_13, int_15);
               } else {
                  object_0 = new DynamicObject(int_4, 4, int_5, int_1, int_2, int_3, objectcomposition_0.animationId, true, (Renderable) null);
               }

               region_0.addBoundaryDecoration(int_0, int_2, int_3, int_13, (Renderable) object_0, (Renderable) null, Class19.anIntArray7[int_5], 0, 0, 0, int_16, int_17);
            } else {
               int int_19;
               if (int_6 == 5) {
                  int_18 = 16;
                  int_19 = region_0.method365(int_0, int_2, int_3);
                  if (int_19 != 0) {
                     int_18 = Class28.getObjectDefinition(int_19 >> 14 & 0x7FFF).anInt466;
                  }

                  if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                     object_2 = objectcomposition_0.method825(4, int_5, ints_0, int_14, int_13, int_15);
                  } else {
                     object_2 = new DynamicObject(int_4, 4, int_5, int_1, int_2, int_3, objectcomposition_0.animationId, true, (Renderable) null);
                  }

                  region_0.addBoundaryDecoration(int_0, int_2, int_3, int_13, (Renderable) object_2, (Renderable) null, Class19.anIntArray7[int_5], 0, int_18 * Class19.anIntArray10[int_5], int_18 * Class19.anIntArray12[int_5], int_16, int_17);
               } else if (int_6 == 6) {
                  int_18 = 8;
                  int_19 = region_0.method365(int_0, int_2, int_3);
                  if (int_19 != 0) {
                     int_18 = Class28.getObjectDefinition(int_19 >> 14 & 0x7FFF).anInt466 / 2;
                  }

                  if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                     object_2 = objectcomposition_0.method825(4, int_5 + 4, ints_0, int_14, int_13, int_15);
                  } else {
                     object_2 = new DynamicObject(int_4, 4, int_5 + 4, int_1, int_2, int_3, objectcomposition_0.animationId, true, (Renderable) null);
                  }

                  region_0.addBoundaryDecoration(int_0, int_2, int_3, int_13, (Renderable) object_2, (Renderable) null, 256, int_5, int_18 * Class19.anIntArray13[int_5], int_18 * Class19.anIntArray14[int_5], int_16, int_17);
               } else if (int_6 == 7) {
                  int_19 = int_5 + 2 & 0x3;
                  if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                     object_0 = objectcomposition_0.method825(4, int_19 + 4, ints_0, int_14, int_13, int_15);
                  } else {
                     object_0 = new DynamicObject(int_4, 4, int_19 + 4, int_1, int_2, int_3, objectcomposition_0.animationId, true, (Renderable) null);
                  }

                  region_0.addBoundaryDecoration(int_0, int_2, int_3, int_13, (Renderable) object_0, (Renderable) null, 256, int_19, 0, 0, int_16, int_17);
               } else if (int_6 == 8) {
                  int_18 = 8;
                  int_19 = region_0.method365(int_0, int_2, int_3);
                  if (int_19 != 0) {
                     int_18 = Class28.getObjectDefinition(int_19 >> 14 & 0x7FFF).anInt466 / 2;
                  }

                  int int_20 = int_5 + 2 & 0x3;
                  Object object_3;
                  if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                     object_2 = objectcomposition_0.method825(4, int_5 + 4, ints_0, int_14, int_13, int_15);
                     object_3 = objectcomposition_0.method825(4, int_20 + 4, ints_0, int_14, int_13, int_15);
                  } else {
                     object_2 = new DynamicObject(int_4, 4, int_5 + 4, int_1, int_2, int_3, objectcomposition_0.animationId, true, (Renderable) null);
                     object_3 = new DynamicObject(int_4, 4, int_20 + 4, int_1, int_2, int_3, objectcomposition_0.animationId, true, (Renderable) null);
                  }

                  region_0.addBoundaryDecoration(int_0, int_2, int_3, int_13, (Renderable) object_2, (Renderable) object_3, 256, int_5, int_18 * Class19.anIntArray13[int_5], int_18 * Class19.anIntArray14[int_5], int_16, int_17);
               }
            }
         }
      } else {
         if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
            object_0 = objectcomposition_0.method825(10, int_5, ints_0, int_14, int_13, int_15);
         } else {
            object_0 = new DynamicObject(int_4, 10, int_5, int_1, int_2, int_3, objectcomposition_0.animationId, true, (Renderable) null);
         }

         if (object_0 != null) {
            region_0.method379(int_0, int_2, int_3, int_13, int_7, int_8, (Renderable) object_0, int_6 == 11 ? 256 : 0, int_16, int_17);
         }

         if (objectcomposition_0.interactType != 0) {
            collisiondata_0.addObject(int_2, int_3, int_7, int_8, objectcomposition_0.aBool60);
         }

      }
   }

}
