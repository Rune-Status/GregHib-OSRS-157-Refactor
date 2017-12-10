public class Class15 {

   static SpritePixels aSpritePixels3;
   final Class13 aClass13_1;
   public final int anInt64;
   int anInt65;
   public final Coordinates aCoordinates5;
   public final Coordinates aCoordinates6;
   final int anInt66;
   int anInt67;
   final int anInt68;

   Class15(int int_0, Coordinates coordinates_0, Coordinates coordinates_1, Class13 class13_0) {
      this.anInt64 = int_0;
      this.aCoordinates5 = coordinates_0;
      this.aCoordinates6 = coordinates_1;
      this.aClass13_1 = class13_0;
      Area area_0 = Area.anAreaArray1[this.anInt64];
      SpritePixels spritepixels_0 = area_0.method809(false);
      if (spritepixels_0 != null) {
         this.anInt66 = spritepixels_0.width;
         this.anInt68 = spritepixels_0.height;
      } else {
         this.anInt66 = 0;
         this.anInt68 = 0;
      }

   }

   boolean method192(int int_0, int int_1) {
      Area area_0 = Area.anAreaArray1[this.anInt64];
      switch(area_0.anEnum8_4.anInt389) {
      case 0:
         if (int_0 > this.anInt65 - this.anInt66 && int_0 <= this.anInt65) {
            break;
         }

         return false;
      case 1:
         if (int_0 >= this.anInt65 && int_0 < this.anInt65 + this.anInt66) {
            break;
         }

         return false;
      case 2:
         if (int_0 < this.anInt65 - this.anInt66 / 2 || int_0 > this.anInt66 / 2 + this.anInt65) {
            return false;
         }
      }

      switch(area_0.anEnum5_4.anInt383) {
      case 0:
         if (int_1 > this.anInt67 - this.anInt68 && int_1 <= this.anInt67) {
            break;
         }

         return false;
      case 1:
         if (int_1 < this.anInt67 || int_1 >= this.anInt67 + this.anInt68) {
            return false;
         }
         break;
      case 2:
         if (int_1 < this.anInt67 - this.anInt68 / 2 || int_1 > this.anInt68 / 2 + this.anInt67) {
            return false;
         }
      }

      return true;
   }

   boolean method193(int int_0, int int_1) {
      return this.aClass13_1 == null ? false : (int_0 >= this.anInt65 - this.aClass13_1.anInt58 / 2 && int_0 <= this.aClass13_1.anInt58 / 2 + this.anInt65 ? int_1 >= this.anInt67 && int_1 <= this.aClass13_1.anInt59 + this.anInt67 : false);
   }

   boolean method194(int int_0, int int_1) {
      return this.method192(int_0, int_1) ? true : this.method193(int_0, int_1);
   }

   public static int ilog(int int_0) {
      int int_1 = 0;
      if (int_0 < 0 || int_0 >= 65536) {
         int_0 >>>= 16;
         int_1 += 16;
      }

      if (int_0 >= 256) {
         int_0 >>>= 8;
         int_1 += 8;
      }

      if (int_0 >= 16) {
         int_0 >>>= 4;
         int_1 += 4;
      }

      if (int_0 >= 4) {
         int_0 >>>= 2;
         int_1 += 2;
      }

      if (int_0 >= 1) {
         int_0 >>>= 1;
         ++int_1;
      }

      return int_0 + int_1;
   }

   static void method195(int int_0, int int_1, int int_2, int int_3, int int_4) {
      int int_5 = Class23.region.getWallObjectUID(int_0, int_1, int_2);
      int int_6;
      int int_7;
      int int_8;
      int int_9;
      int int_10;
      int int_11;
      if (int_5 != 0) {
         int_6 = Class23.region.getObjectConfig(int_0, int_1, int_2, int_5);
         int_7 = int_6 >> 6 & 0x3;
         int_8 = int_6 & 0x1F;
         int_9 = int_3;
         if (int_5 > 0) {
            int_9 = int_4;
         }

         int[] ints_0 = aSpritePixels3.pixels;
         int_10 = int_1 * 4 + (103 - int_2) * 2048 + 24624;
         int_11 = int_5 >> 14 & 0x7FFF;
         ObjectDefinition objectcomposition_0 = ObjectDefinition.getDefinition(int_11);
         if (objectcomposition_0.mapSceneId != -1) {
            IndexedSprite indexedsprite_0 = BuildType.mapscene[objectcomposition_0.mapSceneId];
            if (indexedsprite_0 != null) {
               int int_12 = (objectcomposition_0.sizeX * 4 - indexedsprite_0.originalWidth) / 2;
               int int_13 = (objectcomposition_0.sizeY * 4 - indexedsprite_0.height) / 2;
               indexedsprite_0.method975(int_12 + int_1 * 4 + 48, int_13 + (104 - int_2 - objectcomposition_0.sizeY) * 4 + 48);
            }
         } else {
            if (int_8 == 0 || int_8 == 2) {
               if (int_7 == 0) {
                  ints_0[int_10] = int_9;
                  ints_0[int_10 + 512] = int_9;
                  ints_0[int_10 + 1024] = int_9;
                  ints_0[int_10 + 1536] = int_9;
               } else if (int_7 == 1) {
                  ints_0[int_10] = int_9;
                  ints_0[int_10 + 1] = int_9;
                  ints_0[int_10 + 2] = int_9;
                  ints_0[int_10 + 3] = int_9;
               } else if (int_7 == 2) {
                  ints_0[int_10 + 3] = int_9;
                  ints_0[int_10 + 512 + 3] = int_9;
                  ints_0[int_10 + 1024 + 3] = int_9;
                  ints_0[int_10 + 1536 + 3] = int_9;
               } else if (int_7 == 3) {
                  ints_0[int_10 + 1536] = int_9;
                  ints_0[int_10 + 1536 + 1] = int_9;
                  ints_0[int_10 + 1536 + 2] = int_9;
                  ints_0[int_10 + 1536 + 3] = int_9;
               }
            }

            if (int_8 == 3) {
               if (int_7 == 0) {
                  ints_0[int_10] = int_9;
               } else if (int_7 == 1) {
                  ints_0[int_10 + 3] = int_9;
               } else if (int_7 == 2) {
                  ints_0[int_10 + 1536 + 3] = int_9;
               } else if (int_7 == 3) {
                  ints_0[int_10 + 1536] = int_9;
               }
            }

            if (int_8 == 2) {
               if (int_7 == 3) {
                  ints_0[int_10] = int_9;
                  ints_0[int_10 + 512] = int_9;
                  ints_0[int_10 + 1024] = int_9;
                  ints_0[int_10 + 1536] = int_9;
               } else if (int_7 == 0) {
                  ints_0[int_10] = int_9;
                  ints_0[int_10 + 1] = int_9;
                  ints_0[int_10 + 2] = int_9;
                  ints_0[int_10 + 3] = int_9;
               } else if (int_7 == 1) {
                  ints_0[int_10 + 3] = int_9;
                  ints_0[int_10 + 512 + 3] = int_9;
                  ints_0[int_10 + 1024 + 3] = int_9;
                  ints_0[int_10 + 1536 + 3] = int_9;
               } else if (int_7 == 2) {
                  ints_0[int_10 + 1536] = int_9;
                  ints_0[int_10 + 1536 + 1] = int_9;
                  ints_0[int_10 + 1536 + 2] = int_9;
                  ints_0[int_10 + 1536 + 3] = int_9;
               }
            }
         }
      }

      int_5 = Class23.region.getInteractableObjectUID(int_0, int_1, int_2);
      if (int_5 != 0) {
         int_6 = Class23.region.getObjectConfig(int_0, int_1, int_2, int_5);
         int_7 = int_6 >> 6 & 0x3;
         int_8 = int_6 & 0x1F;
         int_9 = int_5 >> 14 & 0x7FFF;
         ObjectDefinition objectcomposition_2 = ObjectDefinition.getDefinition(int_9);
         int int_14;
         if (objectcomposition_2.mapSceneId != -1) {
            IndexedSprite indexedsprite_1 = BuildType.mapscene[objectcomposition_2.mapSceneId];
            if (indexedsprite_1 != null) {
               int_11 = (objectcomposition_2.sizeX * 4 - indexedsprite_1.originalWidth) / 2;
               int_14 = (objectcomposition_2.sizeY * 4 - indexedsprite_1.height) / 2;
               indexedsprite_1.method975(int_11 + int_1 * 4 + 48, (104 - int_2 - objectcomposition_2.sizeY) * 4 + int_14 + 48);
            }
         } else if (int_8 == 9) {
            int_10 = 15658734;
            if (int_5 > 0) {
               int_10 = 15597568;
            }

            int[] ints_1 = aSpritePixels3.pixels;
            int_14 = int_1 * 4 + (103 - int_2) * 2048 + 24624;
            if (int_7 != 0 && int_7 != 2) {
               ints_1[int_14] = int_10;
               ints_1[int_14 + 1 + 512] = int_10;
               ints_1[int_14 + 1024 + 2] = int_10;
               ints_1[int_14 + 1536 + 3] = int_10;
            } else {
               ints_1[int_14 + 1536] = int_10;
               ints_1[int_14 + 1 + 1024] = int_10;
               ints_1[int_14 + 512 + 2] = int_10;
               ints_1[int_14 + 3] = int_10;
            }
         }
      }

      int_5 = Class23.region.getGroundDecorationUID(int_0, int_1, int_2);
      if (int_5 != 0) {
         int_6 = int_5 >> 14 & 0x7FFF;
         ObjectDefinition objectcomposition_1 = ObjectDefinition.getDefinition(int_6);
         if (objectcomposition_1.mapSceneId != -1) {
            IndexedSprite indexedsprite_2 = BuildType.mapscene[objectcomposition_1.mapSceneId];
            if (indexedsprite_2 != null) {
               int_9 = (objectcomposition_1.sizeX * 4 - indexedsprite_2.originalWidth) / 2;
               int int_15 = (objectcomposition_1.sizeY * 4 - indexedsprite_2.height) / 2;
               indexedsprite_2.method975(int_1 * 4 + int_9 + 48, (104 - int_2 - objectcomposition_1.sizeY) * 4 + int_15 + 48);
            }
         }
      }

   }

   static void method196(byte[] bytes_0, int int_0, int int_1, Region region_0, CollisionData[] collisiondatas_0) {
      Buffer buffer_0 = new Buffer(bytes_0);
      int int_2 = -1;

      while (true) {
         int int_3 = buffer_0.getUSmart();
         if (int_3 == 0) {
            return;
         }

         int_2 += int_3;
         int int_4 = 0;

         while (true) {
            int int_5 = buffer_0.getUSmart();
            if (int_5 == 0) {
               break;
            }

            int_4 += int_5 - 1;
            int int_6 = int_4 & 0x3F;
            int int_7 = int_4 >> 6 & 0x3F;
            int int_8 = int_4 >> 12;
            int int_9 = buffer_0.getUnsignedByte();
            int int_10 = int_9 >> 2;
            int int_11 = int_9 & 0x3;
            int int_12 = int_7 + int_0;
            int int_13 = int_6 + int_1;
            if (int_12 > 0 && int_13 > 0 && int_12 < 103 && int_13 < 103) {
               int int_14 = int_8;
               if ((Class19.tileSettings[1][int_12][int_13] & 0x2) == 2) {
                  int_14 = int_8 - 1;
               }

               CollisionData collisiondata_0 = null;
               if (int_14 >= 0) {
                  collisiondata_0 = collisiondatas_0[int_14];
               }

               RuntimeException_Sub1.addObject(int_8, int_12, int_13, int_2, int_11, int_10, region_0, collisiondata_0);
            }
         }
      }
   }

}
