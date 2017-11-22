public final class IndexedSprite extends Rasterizer2D {

   public int offsetX;
   public int[] palette;
   public int originalWidth;
   public int width;
   public int height;
   public int offsetY;
   public int originalHeight;
   public byte[] pixels;

   public void method974() {
      if (this.originalWidth != this.width || this.height != this.originalHeight) {
         byte[] bytes_0 = new byte[this.width * this.originalHeight];
         int int_0 = 0;

         for (int int_1 = 0; int_1 < this.height; int_1++) {
            for (int int_2 = 0; int_2 < this.originalWidth; int_2++) {
               bytes_0[int_2 + (int_1 + this.offsetY) * this.width + this.offsetX] = this.pixels[int_0++];
            }
         }

         this.pixels = bytes_0;
         this.originalWidth = this.width;
         this.height = this.originalHeight;
         this.offsetX = 0;
         this.offsetY = 0;
      }
   }

   public void method975(int int_0, int int_1) {
      int_0 += this.offsetX;
      int_1 += this.offsetY;
      int int_2 = int_0 + int_1 * Rasterizer2D.graphicsPixelsWidth;
      int int_3 = 0;
      int int_4 = this.height;
      int int_5 = this.originalWidth;
      int int_6 = Rasterizer2D.graphicsPixelsWidth - int_5;
      int int_7 = 0;
      int int_8;
      if (int_1 < Rasterizer2D.drawingAreaTop) {
         int_8 = Rasterizer2D.drawingAreaTop - int_1;
         int_4 -= int_8;
         int_1 = Rasterizer2D.drawingAreaTop;
         int_3 += int_8 * int_5;
         int_2 += int_8 * Rasterizer2D.graphicsPixelsWidth;
      }

      if (int_4 + int_1 > Rasterizer2D.drawingAreaRight) {
         int_4 -= int_4 + int_1 - Rasterizer2D.drawingAreaRight;
      }

      if (int_0 < Rasterizer2D.draw_region_x) {
         int_8 = Rasterizer2D.draw_region_x - int_0;
         int_5 -= int_8;
         int_0 = Rasterizer2D.draw_region_x;
         int_3 += int_8;
         int_2 += int_8;
         int_7 += int_8;
         int_6 += int_8;
      }

      if (int_5 + int_0 > Rasterizer2D.drawingAreaBottom) {
         int_8 = int_5 + int_0 - Rasterizer2D.drawingAreaBottom;
         int_5 -= int_8;
         int_7 += int_8;
         int_6 += int_8;
      }

      if (int_5 > 0 && int_4 > 0) {
         method978(Rasterizer2D.graphicsPixels, this.pixels, this.palette, int_3, int_2, int_5, int_4, int_6, int_7);
      }
   }

   public void method976(int int_0, int int_1, int int_2, int int_3) {
      int int_4 = this.originalWidth;
      int int_5 = this.height;
      int int_6 = 0;
      int int_7 = 0;
      int int_8 = this.width;
      int int_9 = this.originalHeight;
      int int_10 = (int_8 << 16) / int_2;
      int int_11 = (int_9 << 16) / int_3;
      int int_12;
      if (this.offsetX > 0) {
         int_12 = (int_10 + (this.offsetX << 16) - 1) / int_10;
         int_0 += int_12;
         int_6 += int_12 * int_10 - (this.offsetX << 16);
      }

      if (this.offsetY > 0) {
         int_12 = (int_11 + (this.offsetY << 16) - 1) / int_11;
         int_1 += int_12;
         int_7 += int_12 * int_11 - (this.offsetY << 16);
      }

      if (int_4 < int_8) {
         int_2 = (int_10 + ((int_4 << 16) - int_6) - 1) / int_10;
      }

      if (int_5 < int_9) {
         int_3 = (int_11 + ((int_5 << 16) - int_7) - 1) / int_11;
      }

      int_12 = int_0 + int_1 * Rasterizer2D.graphicsPixelsWidth;
      int int_13 = Rasterizer2D.graphicsPixelsWidth - int_2;
      if (int_1 + int_3 > Rasterizer2D.drawingAreaRight) {
         int_3 -= int_1 + int_3 - Rasterizer2D.drawingAreaRight;
      }

      int int_14;
      if (int_1 < Rasterizer2D.drawingAreaTop) {
         int_14 = Rasterizer2D.drawingAreaTop - int_1;
         int_3 -= int_14;
         int_12 += int_14 * Rasterizer2D.graphicsPixelsWidth;
         int_7 += int_11 * int_14;
      }

      if (int_2 + int_0 > Rasterizer2D.drawingAreaBottom) {
         int_14 = int_2 + int_0 - Rasterizer2D.drawingAreaBottom;
         int_2 -= int_14;
         int_13 += int_14;
      }

      if (int_0 < Rasterizer2D.draw_region_x) {
         int_14 = Rasterizer2D.draw_region_x - int_0;
         int_2 -= int_14;
         int_12 += int_14;
         int_6 += int_10 * int_14;
         int_13 += int_14;
      }

      method979(Rasterizer2D.graphicsPixels, this.pixels, this.palette, int_6, int_7, int_12, int_13, int_2, int_3, int_10, int_11, int_4);
   }

   public void method977(int int_0, int int_1, int int_2) {
      for (int int_3 = 0; int_3 < this.palette.length; int_3++) {
         int int_4 = this.palette[int_3] >> 16 & 0xFF;
         int_4 += int_0;
         if (int_4 < 0) {
            int_4 = 0;
         } else if (int_4 > 255) {
            int_4 = 255;
         }

         int int_5 = this.palette[int_3] >> 8 & 0xFF;
         int_5 += int_1;
         if (int_5 < 0) {
            int_5 = 0;
         } else if (int_5 > 255) {
            int_5 = 255;
         }

         int int_6 = this.palette[int_3] & 0xFF;
         int_6 += int_2;
         if (int_6 < 0) {
            int_6 = 0;
         } else if (int_6 > 255) {
            int_6 = 255;
         }

         this.palette[int_3] = int_6 + (int_5 << 8) + (int_4 << 16);
      }

   }

   static void method978(int[] ints_0, byte[] bytes_0, int[] ints_1, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      int int_6 = -(int_2 >> 2);
      int_2 = -(int_2 & 0x3);

      for (int int_7 = -int_3; int_7 < 0; int_7++) {
         int int_8;
         byte byte_0;
         for (int_8 = int_6; int_8 < 0; int_8++) {
            byte_0 = bytes_0[int_0++];
            if (byte_0 != 0) {
               ints_0[int_1++] = ints_1[byte_0 & 0xFF];
            } else {
               ++int_1;
            }

            byte_0 = bytes_0[int_0++];
            if (byte_0 != 0) {
               ints_0[int_1++] = ints_1[byte_0 & 0xFF];
            } else {
               ++int_1;
            }

            byte_0 = bytes_0[int_0++];
            if (byte_0 != 0) {
               ints_0[int_1++] = ints_1[byte_0 & 0xFF];
            } else {
               ++int_1;
            }

            byte_0 = bytes_0[int_0++];
            if (byte_0 != 0) {
               ints_0[int_1++] = ints_1[byte_0 & 0xFF];
            } else {
               ++int_1;
            }
         }

         for (int_8 = int_2; int_8 < 0; int_8++) {
            byte_0 = bytes_0[int_0++];
            if (byte_0 != 0) {
               ints_0[int_1++] = ints_1[byte_0 & 0xFF];
            } else {
               ++int_1;
            }
         }

         int_1 += int_4;
         int_0 += int_5;
      }

   }

   static void method979(int[] ints_0, byte[] bytes_0, int[] ints_1, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8) {
      int int_9 = int_0;

      for (int int_10 = -int_5; int_10 < 0; int_10++) {
         int int_11 = int_8 * (int_1 >> 16);

         for (int int_12 = -int_4; int_12 < 0; int_12++) {
            byte byte_0 = bytes_0[(int_0 >> 16) + int_11];
            if (byte_0 != 0) {
               ints_0[int_2++] = ints_1[byte_0 & 0xFF];
            } else {
               ++int_2;
            }

            int_0 += int_6;
         }

         int_1 += int_7;
         int_0 = int_9;
         int_2 += int_3;
      }

   }

}
