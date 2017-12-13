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

   public void drawSprite(int x, int y) {
      x += this.offsetX;
      y += this.offsetY;
      int graphicsOffset = x + y * Rasterizer2D.graphicsPixelsWidth;
      int pixelOffset = 0;
      int imgHeight = this.height;
      int imgWidth = this.originalWidth;
      int deviation = Rasterizer2D.graphicsPixelsWidth - imgWidth;
      int originalDeviation = 0;
      int offset;
      if (y < Rasterizer2D.topY) {
         offset = Rasterizer2D.topY - y;
         imgHeight -= offset;
         y = Rasterizer2D.topY;
         pixelOffset += offset * imgWidth;
         graphicsOffset += offset * Rasterizer2D.graphicsPixelsWidth;
      }

      if (imgHeight + y > Rasterizer2D.bottomY) {
         imgHeight -= imgHeight + y - Rasterizer2D.bottomY;
      }

      if (x < Rasterizer2D.topX) {
         offset = Rasterizer2D.topX - x;
         imgWidth -= offset;
         x = Rasterizer2D.topX;
         pixelOffset += offset;
         graphicsOffset += offset;
         originalDeviation += offset;
         deviation += offset;
      }

      if (imgWidth + x > Rasterizer2D.bottomX) {
         offset = imgWidth + x - Rasterizer2D.bottomX;
         imgWidth -= offset;
         originalDeviation += offset;
         deviation += offset;
      }

      if (imgWidth > 0 && imgHeight > 0) {
         copyPixelsRGB(Rasterizer2D.graphicsPixels, this.pixels, this.palette, pixelOffset, graphicsOffset, imgWidth, imgHeight, deviation, originalDeviation);
      }
   }

   public void method976(int int_0, int int_1, int int_2, int int_3) {
      int originalWidth = this.originalWidth;
      int height = this.height;
      int int_6 = 0;
      int int_7 = 0;
      int width = this.width;
      int originalHeight = this.originalHeight;
      int int_10 = (width << 16) / int_2;
      int int_11 = (originalHeight << 16) / int_3;
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

      if (originalWidth < width) {
         int_2 = (int_10 + ((originalWidth << 16) - int_6) - 1) / int_10;
      }

      if (height < originalHeight) {
         int_3 = (int_11 + ((height << 16) - int_7) - 1) / int_11;
      }

      int_12 = int_0 + int_1 * Rasterizer2D.graphicsPixelsWidth;
      int int_13 = Rasterizer2D.graphicsPixelsWidth - int_2;
      if (int_1 + int_3 > Rasterizer2D.bottomY) {
         int_3 -= int_1 + int_3 - Rasterizer2D.bottomY;
      }

      int int_14;
      if (int_1 < Rasterizer2D.topY) {
         int_14 = Rasterizer2D.topY - int_1;
         int_3 -= int_14;
         int_12 += int_14 * Rasterizer2D.graphicsPixelsWidth;
         int_7 += int_11 * int_14;
      }

      if (int_2 + int_0 > Rasterizer2D.bottomX) {
         int_14 = int_2 + int_0 - Rasterizer2D.bottomX;
         int_2 -= int_14;
         int_13 += int_14;
      }

      if (int_0 < Rasterizer2D.topX) {
         int_14 = Rasterizer2D.topX - int_0;
         int_2 -= int_14;
         int_12 += int_14;
         int_6 += int_10 * int_14;
         int_13 += int_14;
      }

      method979(Rasterizer2D.graphicsPixels, this.pixels, this.palette, int_6, int_7, int_12, int_13, int_2, int_3, int_10, int_11, originalWidth);
   }

   public void adjustRGB(int redOff, int greenOff, int blueOff) {
      for (int pixel = 0; pixel < this.palette.length; pixel++) {
         int red = this.palette[pixel] >> 16 & 0xFF;
         red += redOff;
         if (red < 0) {
            red = 0;
         } else if (red > 255) {
            red = 255;
         }

         int green = this.palette[pixel] >> 8 & 0xFF;
         green += greenOff;
         if (green < 0) {
            green = 0;
         } else if (green > 255) {
            green = 255;
         }

         int blue = this.palette[pixel] & 0xFF;
         blue += blueOff;
         if (blue < 0) {
            blue = 0;
         } else if (blue > 255) {
            blue = 255;
         }

         this.palette[pixel] = blue + (green << 8) + (red << 16);
      }

   }

   static void copyPixelsRGB(int[] pixels, byte[] graphicsPixels, int[] colours, int pixelOffset, int graphicsOffset, int imgWidth, int imgHeight, int deviation, int originalDeviation) {
      int newWidth = -(imgWidth >> 2);
      imgWidth = -(imgWidth & 0x3);

      for (int heightCounter = -imgHeight; heightCounter < 0; heightCounter++) {
         int widthCounter;
         byte colour;
         for (widthCounter = newWidth; widthCounter < 0; widthCounter++) {
            colour = graphicsPixels[pixelOffset++];
            if (colour != 0) {
               pixels[graphicsOffset++] = colours[colour & 0xFF];
            } else {
               ++graphicsOffset;
            }

            colour = graphicsPixels[pixelOffset++];
            if (colour != 0) {
               pixels[graphicsOffset++] = colours[colour & 0xFF];
            } else {
               ++graphicsOffset;
            }

            colour = graphicsPixels[pixelOffset++];
            if (colour != 0) {
               pixels[graphicsOffset++] = colours[colour & 0xFF];
            } else {
               ++graphicsOffset;
            }

            colour = graphicsPixels[pixelOffset++];
            if (colour != 0) {
               pixels[graphicsOffset++] = colours[colour & 0xFF];
            } else {
               ++graphicsOffset;
            }
         }

         for (widthCounter = imgWidth; widthCounter < 0; widthCounter++) {
            colour = graphicsPixels[pixelOffset++];
            if (colour != 0) {
               pixels[graphicsOffset++] = colours[colour & 0xFF];
            } else {
               ++graphicsOffset;
            }
         }

         graphicsOffset += deviation;
         pixelOffset += originalDeviation;
      }

   }

   static void method979(int[] pixels, byte[] graphicsPixels, int[] colours, int int_0, int int_1, int graphicsOffset, int int_3, int imgWidth, int imgHeight, int int_6, int int_7, int int_8) {
      int int_9 = int_0;

      for (int heightCounter = -imgHeight; heightCounter < 0; heightCounter++) {
         int int_11 = int_8 * (int_1 >> 16);

         for (int widthCounter = -imgWidth; widthCounter < 0; widthCounter++) {
            byte colour = graphicsPixels[(int_0 >> 16) + int_11];
            if (colour != 0) {
               pixels[graphicsOffset++] = colours[colour & 0xFF];
            } else {
               ++graphicsOffset;
            }

            int_0 += int_6;
         }

         int_1 += int_7;
         int_0 = int_9;
         graphicsOffset += int_3;
      }

   }

}
