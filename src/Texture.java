public class Texture extends Node {

   static int[] anIntArray68;
   int[] fileIds;
   int[] pixels;
   boolean aBool49;
   boolean loaded;
   int anInt312;
   int anInt313;
   int anInt314;
   int[] anIntArray69;
   int[] anIntArray70;
   int[] anIntArray71;

   Texture(Buffer buffer_0) {
      this.loaded = false;
      this.anInt313 = buffer_0.readUnsignedShort();
      this.aBool49 = buffer_0.readUnsignedByte() == 1;
      int int_0 = buffer_0.readUnsignedByte();
      if (int_0 >= 1 && int_0 <= 4) {
         this.fileIds = new int[int_0];

         int int_1;
         for (int_1 = 0; int_1 < int_0; int_1++) {
            this.fileIds[int_1] = buffer_0.readUnsignedShort();
         }

         if (int_0 > 1) {
            this.anIntArray70 = new int[int_0 - 1];

            for (int_1 = 0; int_1 < int_0 - 1; int_1++) {
               this.anIntArray70[int_1] = buffer_0.readUnsignedByte();
            }
         }

         if (int_0 > 1) {
            this.anIntArray71 = new int[int_0 - 1];

            for (int_1 = 0; int_1 < int_0 - 1; int_1++) {
               this.anIntArray71[int_1] = buffer_0.readUnsignedByte();
            }
         }

         this.anIntArray69 = new int[int_0];

         for (int_1 = 0; int_1 < int_0; int_1++) {
            this.anIntArray69[int_1] = buffer_0.readInt();
         }

         this.anInt312 = buffer_0.readUnsignedByte();
         this.anInt314 = buffer_0.readUnsignedByte();
         this.pixels = null;
      } else {
         throw new RuntimeException();
      }
   }

   void resetPixels() {
      this.pixels = null;
   }

   boolean method626(double double_0, int int_0, IndexDataBase indexdatabase_0) {
      int int_1;
      for (int_1 = 0; int_1 < this.fileIds.length; int_1++) {
         if (indexdatabase_0.method426(this.fileIds[int_1]) == null) {
            return false;
         }
      }

      int_1 = int_0 * int_0;
      this.pixels = new int[int_1];

      for (int int_2 = 0; int_2 < this.fileIds.length; int_2++) {
         IndexedSprite indexedsprite_0 = Class62.method397(indexdatabase_0, this.fileIds[int_2]);
         indexedsprite_0.method974();
         byte[] bytes_0 = indexedsprite_0.pixels;
         int[] ints_0 = indexedsprite_0.palette;
         int int_3 = this.anIntArray69[int_2];
         if ((int_3 & 0xFF000000) == 16777216) {
            ;
         }

         if ((int_3 & 0xFF000000) == 33554432) {
            ;
         }

         int int_4;
         int int_5;
         int int_6;
         int int_7;
         if ((int_3 & 0xFF000000) == 50331648) {
            int_4 = int_3 & 0xFF00FF;
            int_5 = int_3 >> 8 & 0xFF;

            for (int_6 = 0; int_6 < ints_0.length; int_6++) {
               int_7 = ints_0[int_6];
               if (int_7 >> 8 == (int_7 & 0xFFFF)) {
                  int_7 &= 0xFF;
                  ints_0[int_6] = int_4 * int_7 >> 8 & 0xFF00FF | int_5 * int_7 & 0xFF00;
               }
            }
         }

         for (int_4 = 0; int_4 < ints_0.length; int_4++) {
            ints_0[int_4] = Graphics3D.adjustRGB(ints_0[int_4], double_0);
         }

         if (int_2 == 0) {
            int_4 = 0;
         } else {
            int_4 = this.anIntArray70[int_2 - 1];
         }

         if (int_4 == 0) {
            if (int_0 == indexedsprite_0.originalWidth) {
               for (int_5 = 0; int_5 < int_1; int_5++) {
                  this.pixels[int_5] = ints_0[bytes_0[int_5] & 0xFF];
               }
            } else if (indexedsprite_0.originalWidth == 64 && int_0 == 128) {
               int_5 = 0;

               for (int_6 = 0; int_6 < int_0; int_6++) {
                  for (int_7 = 0; int_7 < int_0; int_7++) {
                     this.pixels[int_5++] = ints_0[bytes_0[(int_6 >> 1 << 6) + (int_7 >> 1)] & 0xFF];
                  }
               }
            } else {
               if (indexedsprite_0.originalWidth != 128 || int_0 != 64) {
                  throw new RuntimeException();
               }

               int_5 = 0;

               for (int_6 = 0; int_6 < int_0; int_6++) {
                  for (int_7 = 0; int_7 < int_0; int_7++) {
                     this.pixels[int_5++] = ints_0[bytes_0[(int_7 << 1) + (int_6 << 1 << 7)] & 0xFF];
                  }
               }
            }
         }

         if (int_4 == 1) {
            ;
         }

         if (int_4 == 2) {
            ;
         }

         if (int_4 == 3) {
            ;
         }
      }

      return true;
   }

   void method627(int int_0) {
      if (this.pixels != null) {
         short short_0;
         int int_1;
         int int_2;
         int int_3;
         int int_4;
         int int_5;
         int[] ints_0;
         if (this.anInt312 == 1 || this.anInt312 == 3) {
            if (anIntArray68 == null || anIntArray68.length < this.pixels.length) {
               anIntArray68 = new int[this.pixels.length];
            }

            if (this.pixels.length == 4096) {
               short_0 = 64;
            } else {
               short_0 = 128;
            }

            int_1 = this.pixels.length;
            int_2 = short_0 * this.anInt314 * int_0;
            int_3 = int_1 - 1;
            if (this.anInt312 == 1) {
               int_2 = -int_2;
            }

            for (int_4 = 0; int_4 < int_1; int_4++) {
               int_5 = int_4 + int_2 & int_3;
               anIntArray68[int_4] = this.pixels[int_5];
            }

            ints_0 = this.pixels;
            this.pixels = anIntArray68;
            anIntArray68 = ints_0;
         }

         if (this.anInt312 == 2 || this.anInt312 == 4) {
            if (anIntArray68 == null || anIntArray68.length < this.pixels.length) {
               anIntArray68 = new int[this.pixels.length];
            }

            if (this.pixels.length == 4096) {
               short_0 = 64;
            } else {
               short_0 = 128;
            }

            int_1 = this.pixels.length;
            int_2 = this.anInt314 * int_0;
            int_3 = short_0 - 1;
            if (this.anInt312 == 2) {
               int_2 = -int_2;
            }

            for (int_4 = 0; int_4 < int_1; int_4 += short_0) {
               for (int_5 = 0; int_5 < short_0; int_5++) {
                  int int_6 = int_4 + int_5;
                  int int_7 = int_4 + (int_5 + int_2 & int_3);
                  anIntArray68[int_6] = this.pixels[int_7];
               }
            }

            ints_0 = this.pixels;
            this.pixels = anIntArray68;
            anIntArray68 = ints_0;
         }

      }
   }

}
