public class Rasterizer2D extends CacheableNode {

   public static int topY;
   public static int topX;
   public static int[] graphicsPixels;
   public static int graphicsPixelsWidth;
   public static int graphicsPixelsHeight;
   public static int bottomY;
   protected static int bottomX;

   static {
      topY = 0;
      bottomY = 0;
      topX = 0;
      bottomX = 0;
   }

   public static void copyDrawRegion(int[] values) {
      values[0] = topX;
      values[1] = topY;
      values[2] = bottomX;
      values[3] = bottomY;
   }

   public static void setRasterBuffer(int[] pixels, int width, int height) {
      graphicsPixels = pixels;
      graphicsPixelsWidth = width;
      graphicsPixelsHeight = height;
      setDrawRegion(0, 0, width, height);
   }

   public static void drawVerticalLine(int x, int y, int length, int colour) {
      if (x >= topX && x < bottomX) {
         if (y < topY) {
            length -= topY - y;
            y = topY;
         }

         if (length + y > bottomY) {
            length = bottomY - y;
         }

         int pixelOffset = x + graphicsPixelsWidth * y;

         for (int lengthCounter = 0; lengthCounter < length; lengthCounter++) {
            graphicsPixels[pixelOffset + lengthCounter * graphicsPixelsWidth] = colour;
         }
      }
   }

   public static void fillRect(int x, int y, int width, int height, int colour) {
      if (x < topX) {
         width -= topX - x;
         x = topX;
      }

      if (y < topY) {
         height -= topY - y;
         y = topY;
      }

      if (x + width > bottomX) {
         width = bottomX - x;
      }

      if (height + y > bottomY) {
         height = bottomY - y;
      }

      int pixelOffset = graphicsPixelsWidth - width;
      int pixel = x + graphicsPixelsWidth * y;
      for (int heightCounter = -height; heightCounter < 0; heightCounter++) {
         for (int widthCounter = -width; widthCounter < 0; widthCounter++) {
            graphicsPixels[pixel++] = colour;
         }
         pixel += pixelOffset;
      }
   }

   public static void method920(int x, int y, int length, int colour) {
      if (y >= topY && y < bottomY) {
         if (x < topX) {
            length -= topX - x;
            x = topX;
         }

         if (x + length > bottomX) {
            length = bottomX - x;
         }

         int pixelOffset = x + graphicsPixelsWidth * y;

         for (int lengthOffset = 0; lengthOffset < length; lengthOffset++) {
            graphicsPixels[pixelOffset + lengthOffset] = colour;
         }
      }
   }

   public static void setDrawRegion(int x, int y, int width, int height) {
      if (x < 0) {
         x = 0;
      }

      if (y < 0) {
         y = 0;
      }

      if (width > graphicsPixelsWidth) {
         width = graphicsPixelsWidth;
      }

      if (height > graphicsPixelsHeight) {
         height = graphicsPixelsHeight;
      }

      topX = x;
      topY = y;
      bottomX = width;
      bottomY = height;
   }

   public static void method921(int int_0, int int_1, int int_2, int int_3, int int_4) {
      if (int_4 != 0) {
         if (int_4 == 256) {
            method923(int_0, int_1, int_2, int_3);
         } else {
            if (int_2 < 0) {
               int_2 = -int_2;
            }

            int int_5 = 256 - int_4;
            int int_6 = (int_3 >> 16 & 0xFF) * int_4;
            int int_7 = (int_3 >> 8 & 0xFF) * int_4;
            int int_8 = int_4 * (int_3 & 0xFF);
            int int_9 = int_1 - int_2;
            if (int_9 < topY) {
               int_9 = topY;
            }

            int int_10 = int_2 + int_1 + 1;
            if (int_10 > bottomY) {
               int_10 = bottomY;
            }

            int int_11 = int_9;
            int int_12 = int_2 * int_2;
            int int_13 = 0;
            int int_14 = int_1 - int_9;
            int int_15 = int_14 * int_14;
            int int_16 = int_15 - int_14;
            if (int_1 > int_10) {
               int_1 = int_10;
            }

            int int_17;
            int int_18;
            int int_19;
            int int_20;
            int int_21;
            int int_22;
            int int_23;
            int int_24;
            while (int_11 < int_1) {
               while (int_16 <= int_12 || int_15 <= int_12) {
                  int_15 = int_15 + int_13 + int_13;
                  int_16 += int_13++ + int_13;
               }

               int_17 = int_0 - int_13 + 1;
               if (int_17 < topX) {
                  int_17 = topX;
               }

               int_18 = int_0 + int_13;
               if (int_18 > bottomX) {
                  int_18 = bottomX;
               }

               int_19 = int_17 + int_11 * graphicsPixelsWidth;

               for (int_20 = int_17; int_20 < int_18; int_20++) {
                  int_21 = int_5 * (graphicsPixels[int_19] >> 16 & 0xFF);
                  int_22 = (graphicsPixels[int_19] >> 8 & 0xFF) * int_5;
                  int_23 = int_5 * (graphicsPixels[int_19] & 0xFF);
                  int_24 = (int_8 + int_23 >> 8) + (int_6 + int_21 >> 8 << 16) + (int_7 + int_22 >> 8 << 8);
                  graphicsPixels[int_19++] = int_24;
               }

               ++int_11;
               int_15 -= int_14-- + int_14;
               int_16 -= int_14 + int_14;
            }

            int_13 = int_2;
            int_14 = -int_14;
            int_16 = int_12 + int_14 * int_14;
            int_15 = int_16 - int_2;

            for (int_16 -= int_14; int_11 < int_10; int_15 += int_14++ + int_14) {
               while (int_16 > int_12 && int_15 > int_12) {
                  int_16 -= int_13-- + int_13;
                  int_15 -= int_13 + int_13;
               }

               int_17 = int_0 - int_13;
               if (int_17 < topX) {
                  int_17 = topX;
               }

               int_18 = int_0 + int_13;
               if (int_18 > bottomX - 1) {
                  int_18 = bottomX - 1;
               }

               int_19 = int_17 + int_11 * graphicsPixelsWidth;

               for (int_20 = int_17; int_20 <= int_18; int_20++) {
                  int_21 = int_5 * (graphicsPixels[int_19] >> 16 & 0xFF);
                  int_22 = (graphicsPixels[int_19] >> 8 & 0xFF) * int_5;
                  int_23 = int_5 * (graphicsPixels[int_19] & 0xFF);
                  int_24 = (int_8 + int_23 >> 8) + (int_6 + int_21 >> 8 << 16) + (int_7 + int_22 >> 8 << 8);
                  graphicsPixels[int_19++] = int_24;
               }

               ++int_11;
               int_16 = int_16 + int_14 + int_14;
            }

         }
      }
   }

   public static void drawRectangle(int int_0, int int_1, int int_2, int int_3, int int_4) {
      method920(int_0, int_1, int_2, int_4);
      method920(int_0, int_3 + int_1 - 1, int_2, int_4);
      drawVerticalLine(int_0, int_1, int_3, int_4);
      drawVerticalLine(int_0 + int_2 - 1, int_1, int_3, int_4);
   }

   public static void method922(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, byte[] bytes_0, int int_6) {
      if (int_0 + int_2 >= 0 && int_3 + int_1 >= 0) {
         if (int_0 < graphicsPixelsWidth && int_1 < graphicsPixelsHeight) {
            int int_7 = 0;
            int int_8 = 0;
            if (int_0 < 0) {
               int_7 -= int_0;
               int_2 += int_0;
            }

            if (int_1 < 0) {
               int_8 -= int_1;
               int_3 += int_1;
            }

            if (int_0 + int_2 > graphicsPixelsWidth) {
               int_2 = graphicsPixelsWidth - int_0;
            }

            if (int_3 + int_1 > graphicsPixelsHeight) {
               int_3 = graphicsPixelsHeight - int_1;
            }

            int int_9 = bytes_0.length / int_6;
            int int_10 = graphicsPixelsWidth - int_2;
            int int_11 = int_4 >>> 24;
            int int_12 = int_5 >>> 24;
            int int_13;
            int int_14;
            int int_15;
            int int_16;
            int int_17;
            if (int_11 == 255 && int_12 == 255) {
               int_13 = int_0 + int_7 + (int_8 + int_1) * graphicsPixelsWidth;

               for (int_14 = int_8 + int_1; int_14 < int_3 + int_8 + int_1; int_14++) {
                  for (int_15 = int_0 + int_7; int_15 < int_0 + int_7 + int_2; int_15++) {
                     int_16 = (int_14 - int_1) % int_9;
                     int_17 = (int_15 - int_0) % int_6;
                     if (bytes_0[int_17 + int_16 * int_6] != 0) {
                        graphicsPixels[int_13++] = int_5;
                     } else {
                        graphicsPixels[int_13++] = int_4;
                     }
                  }

                  int_13 += int_10;
               }
            } else {
               int_13 = int_0 + int_7 + (int_8 + int_1) * graphicsPixelsWidth;

               for (int_14 = int_8 + int_1; int_14 < int_3 + int_8 + int_1; int_14++) {
                  for (int_15 = int_0 + int_7; int_15 < int_0 + int_7 + int_2; int_15++) {
                     int_16 = (int_14 - int_1) % int_9;
                     int_17 = (int_15 - int_0) % int_6;
                     int int_18 = int_4;
                     if (bytes_0[int_17 + int_16 * int_6] != 0) {
                        int_18 = int_5;
                     }

                     int int_19 = int_18 >>> 24;
                     int int_20 = 255 - int_19;
                     int int_21 = graphicsPixels[int_13];
                     int int_22 = ((int_18 & 0xFF00FF) * int_19 + (int_21 & 0xFF00FF) * int_20 & 0xFF00FF00) + (int_19 * (int_18 & 0xFF00) + int_20 * (int_21 & 0xFF00) & 0xFF0000) >> 8;
                     graphicsPixels[int_13++] = int_22;
                  }

                  int_13 += int_10;
               }
            }

         }
      }
   }

   static void method923(int int_0, int int_1, int int_2, int int_3) {
      if (int_2 == 0) {
         method924(int_0, int_1, int_3);
      } else {
         if (int_2 < 0) {
            int_2 = -int_2;
         }

         int int_4 = int_1 - int_2;
         if (int_4 < topY) {
            int_4 = topY;
         }

         int int_5 = int_2 + int_1 + 1;
         if (int_5 > bottomY) {
            int_5 = bottomY;
         }

         int int_6 = int_4;
         int int_7 = int_2 * int_2;
         int int_8 = 0;
         int int_9 = int_1 - int_4;
         int int_10 = int_9 * int_9;
         int int_11 = int_10 - int_9;
         if (int_1 > int_5) {
            int_1 = int_5;
         }

         int int_12;
         int int_13;
         int int_14;
         int int_15;
         while (int_6 < int_1) {
            while (int_11 <= int_7 || int_10 <= int_7) {
               int_10 = int_10 + int_8 + int_8;
               int_11 += int_8++ + int_8;
            }

            int_12 = int_0 - int_8 + 1;
            if (int_12 < topX) {
               int_12 = topX;
            }

            int_13 = int_0 + int_8;
            if (int_13 > bottomX) {
               int_13 = bottomX;
            }

            int_14 = int_12 + int_6 * graphicsPixelsWidth;

            for (int_15 = int_12; int_15 < int_13; int_15++) {
               graphicsPixels[int_14++] = int_3;
            }

            ++int_6;
            int_10 -= int_9-- + int_9;
            int_11 -= int_9 + int_9;
         }

         int_8 = int_2;
         int_9 = int_6 - int_1;
         int_11 = int_7 + int_9 * int_9;
         int_10 = int_11 - int_2;

         for (int_11 -= int_9; int_6 < int_5; int_10 += int_9++ + int_9) {
            while (int_11 > int_7 && int_10 > int_7) {
               int_11 -= int_8-- + int_8;
               int_10 -= int_8 + int_8;
            }

            int_12 = int_0 - int_8;
            if (int_12 < topX) {
               int_12 = topX;
            }

            int_13 = int_0 + int_8;
            if (int_13 > bottomX - 1) {
               int_13 = bottomX - 1;
            }

            int_14 = int_12 + int_6 * graphicsPixelsWidth;

            for (int_15 = int_12; int_15 <= int_13; int_15++) {
               graphicsPixels[int_14++] = int_3;
            }

            ++int_6;
            int_11 = int_11 + int_9 + int_9;
         }

      }
   }

   public static void resetRegion() {
      topX = 0;
      topY = 0;
      bottomX = graphicsPixelsWidth;
      bottomY = graphicsPixelsHeight;
   }

   public static void drawLine(int int_0, int int_1, int int_2, int int_3, int int_4) {
      int_2 -= int_0;
      int_3 -= int_1;
      if (int_3 == 0) {
         if (int_2 >= 0) {
            method920(int_0, int_1, int_2 + 1, int_4);
         } else {
            method920(int_0 + int_2, int_1, -int_2 + 1, int_4);
         }

      } else if (int_2 == 0) {
         if (int_3 >= 0) {
            drawVerticalLine(int_0, int_1, int_3 + 1, int_4);
         } else {
            drawVerticalLine(int_0, int_3 + int_1, -int_3 + 1, int_4);
         }

      } else {
         if (int_3 + int_2 < 0) {
            int_0 += int_2;
            int_2 = -int_2;
            int_1 += int_3;
            int_3 = -int_3;
         }

         int int_5;
         int int_6;
         if (int_2 > int_3) {
            int_1 <<= 16;
            int_1 += 32768;
            int_3 <<= 16;
            int_5 = (int)Math.floor((double)int_3 / (double)int_2 + 0.5D);
            int_2 += int_0;
            if (int_0 < topX) {
               int_1 += int_5 * (topX - int_0);
               int_0 = topX;
            }

            if (int_2 >= bottomX) {
               int_2 = bottomX - 1;
            }

            while (int_0 <= int_2) {
               int_6 = int_1 >> 16;
               if (int_6 >= topY && int_6 < bottomY) {
                  graphicsPixels[int_0 + int_6 * graphicsPixelsWidth] = int_4;
               }

               int_1 += int_5;
               ++int_0;
            }
         } else {
            int_0 <<= 16;
            int_0 += 32768;
            int_2 <<= 16;
            int_5 = (int)Math.floor((double)int_2 / (double)int_3 + 0.5D);
            int_3 += int_1;
            if (int_1 < topY) {
               int_0 += (topY - int_1) * int_5;
               int_1 = topY;
            }

            if (int_3 >= bottomY) {
               int_3 = bottomY - 1;
            }

            while (int_1 <= int_3) {
               int_6 = int_0 >> 16;
               if (int_6 >= topX && int_6 < bottomX) {
                  graphicsPixels[int_6 + graphicsPixelsWidth * int_1] = int_4;
               }

               int_0 += int_5;
               ++int_1;
            }
         }

      }
   }

   public static void setDrawRegion(int[] values) {
      topX = values[0];
      topY = values[1];
      bottomX = values[2];
      bottomY = values[3];
   }

   static void method924(int x, int y, int colour) {
      if (x >= topX && y >= topY && x < bottomX && y < bottomY) {
         graphicsPixels[x + graphicsPixelsWidth * y] = colour;
      }
   }

   public static void fillRectangle(int int_0, int int_1, int int_2, int int_3, int int_4, int opacity) {
      if (int_0 < topX) {
         int_2 -= topX - int_0;
         int_0 = topX;
      }

      if (int_1 < topY) {
         int_3 -= topY - int_1;
         int_1 = topY;
      }

      if (int_0 + int_2 > bottomX) {
         int_2 = bottomX - int_0;
      }

      if (int_3 + int_1 > bottomY) {
         int_3 = bottomY - int_1;
      }

      int_4 = (opacity * (int_4 & 0xFF00FF) >> 8 & 0xFF00FF) + (opacity * (int_4 & 0xFF00) >> 8 & 0xFF00);
      int a = 256 - opacity;
      int int_7 = graphicsPixelsWidth - int_2;
      int int_8 = int_0 + graphicsPixelsWidth * int_1;

      for (int int_9 = 0; int_9 < int_3; int_9++) {
         for (int int_10 = -int_2; int_10 < 0; int_10++) {
            int int_11 = graphicsPixels[int_8];
            int_11 = ((int_11 & 0xFF00FF) * a >> 8 & 0xFF00FF) + (a * (int_11 & 0xFF00) >> 8 & 0xFF00);
            graphicsPixels[int_8++] = int_11 + int_4;
         }

         int_8 += int_7;
      }

   }

   public static void method925(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      int int_6 = 0;
      int int_7 = 65536 / int_3;
      if (int_0 < topX) {
         int_2 -= topX - int_0;
         int_0 = topX;
      }

      if (int_1 < topY) {
         int_6 += (topY - int_1) * int_7;
         int_3 -= topY - int_1;
         int_1 = topY;
      }

      if (int_0 + int_2 > bottomX) {
         int_2 = bottomX - int_0;
      }

      if (int_3 + int_1 > bottomY) {
         int_3 = bottomY - int_1;
      }

      int int_8 = graphicsPixelsWidth - int_2;
      int int_9 = int_0 + graphicsPixelsWidth * int_1;

      for (int int_10 = -int_3; int_10 < 0; int_10++) {
         int int_11 = 65536 - int_6 >> 8;
         int int_12 = int_6 >> 8;
         int int_13 = (int_12 * (int_5 & 0xFF00FF) + int_11 * (int_4 & 0xFF00FF) & 0xFF00FF00) + (int_12 * (int_5 & 0xFF00) + int_11 * (int_4 & 0xFF00) & 0xFF0000) >>> 8;

         for (int int_14 = -int_2; int_14 < 0; int_14++) {
            graphicsPixels[int_9++] = int_13;
         }

         int_9 += int_8;
         int_6 += int_7;
      }

   }

   public static void method926(int int_0, int x, int int_2, int[] pixels, int[] ints_1) {
      int pixelOffset = int_0 + graphicsPixelsWidth * x;

      for (x = 0; x < pixels.length; x++) {
         int int_4 = pixelOffset + pixels[x];

         for (int_0 = -ints_1[x]; int_0 < 0; int_0++) {
            graphicsPixels[int_4++] = int_2;
         }

         pixelOffset += graphicsPixelsWidth;
      }

   }

   public static void drawRect(int x, int y, int int_2, int height, int colour, int opacity) {
      drawHorizontalLine(x, y, int_2, colour, opacity);
      drawHorizontalLine(x, height + y - 1, int_2, colour, opacity);
      if (height >= 3) {
         drawVerticalLine(x, y + 1, height - 2, colour, opacity);
         drawVerticalLine(x + int_2 - 1, y + 1, height - 2, colour, opacity);
      }
   }

   static void drawHorizontalLine(int x, int y, int length, int colour, int opacity) {
      if (y >= topY && y < bottomY) {
         if (x < topX) {
            length -= topX - x;
            x = topX;
         }

         if (x + length > bottomX) {
            length = bottomX - x;
         }

         int a = 256 - opacity;
         int r = (colour >> 16 & 0xFF) * opacity;
         int g = (colour >> 8 & 0xFF) * opacity;
         int b = opacity * (colour & 0xFF);
         int pixel = x + graphicsPixelsWidth * y;

         for (int lengthCounter = 0; lengthCounter < length; lengthCounter++) {
            int ra = a * (graphicsPixels[pixel] >> 16 & 0xFF);
            int ga = (graphicsPixels[pixel] >> 8 & 0xFF) * a;
            int ba = a * (graphicsPixels[pixel] & 0xFF);
            int rgba = (b + ba >> 8) + (r + ra >> 8 << 16) + (g + ga >> 8 << 8);
            graphicsPixels[pixel++] = rgba;
         }
      }
   }

   public static void setInnerDrawRegion(int int_0, int int_1, int int_2, int int_3) {
      if (topX < int_0) {
         topX = int_0;
      }

      if (topY < int_1) {
         topY = int_1;
      }

      if (bottomX > int_2) {
         bottomX = int_2;
      }

      if (bottomY > int_3) {
         bottomY = int_3;
      }

   }

   public static void method929(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7) {
      int int_8 = 0;
      int int_9 = int_5 == int_4 && int_7 == int_6 ? -1 : 65536 / int_3;
      int int_10 = int_6;
      int int_11 = 256 - int_6;
      if (int_0 < topX) {
         int_2 -= topX - int_0;
         int_0 = topX;
      }

      if (int_1 < topY) {
         int_8 += (topY - int_1) * int_9;
         int_3 -= topY - int_1;
         int_1 = topY;
      }

      if (int_0 + int_2 > bottomX) {
         int_2 = bottomX - int_0;
      }

      if (int_3 + int_1 > bottomY) {
         int_3 = bottomY - int_1;
      }

      int int_12 = int_4 >> 16;
      int int_13 = (int_4 & 0xFF00) >> 8;
      int int_14 = int_4 & 0xFF;
      int int_15 = graphicsPixelsWidth - int_2;
      int int_16 = int_0 + graphicsPixelsWidth * int_1;

      for (int int_17 = 0; int_17 < int_3; int_17++) {
         int int_18;
         int int_19;
         int int_20;
         for (int_18 = -int_2; int_18 < 0; int_18++) {
            int_19 = graphicsPixels[int_16];
            int_20 = int_19 >> 16;
            int int_21 = (int_19 & 0xFF00) >> 8;
            int int_22 = int_19 & 0xFF;
            int int_23;
            int int_24;
            int int_25;
            if (int_11 == 0) {
               int_23 = int_20 < 127 ? int_12 * int_20 >> 7 : 255 - ((255 - int_12) * (255 - int_20) >> 7);
               int_24 = int_21 < 127 ? int_13 * int_21 >> 7 : 255 - ((255 - int_13) * (255 - int_21) >> 7);
               int_25 = int_22 < 127 ? int_14 * int_22 >> 7 : 255 - ((255 - int_14) * (255 - int_22) >> 7);
            } else {
               int_23 = int_20 < 127 ? int_20 * int_11 + (int_12 * int_20 * int_10 >> 7) >> 8 : int_10 * (255 - ((255 - int_12) * (255 - int_20) >> 7)) + int_20 * int_11 >> 8;
               int_24 = int_21 < 127 ? int_21 * int_11 + (int_13 * int_21 * int_10 >> 7) >> 8 : int_10 * (255 - ((255 - int_13) * (255 - int_21) >> 7)) + int_21 * int_11 >> 8;
               int_25 = int_22 < 127 ? int_22 * int_11 + (int_14 * int_22 * int_10 >> 7) >> 8 : int_10 * (255 - ((255 - int_14) * (255 - int_22) >> 7)) + int_22 * int_11 >> 8;
            }

            graphicsPixels[int_16++] = int_25 + (int_24 << 8) + (int_23 << 16);
         }

         if (int_9 > 0) {
            int_8 += int_9;
            int_18 = 65536 - int_8 >> 8;
            int_19 = int_8 >> 8;
            if (int_7 != int_6) {
               int_10 = (65536 - int_8) * int_6 + int_8 * int_7 >> 16;
               int_11 = 256 - int_10;
            }

            if (int_5 != int_4) {
               int_20 = (int_19 * (int_5 & 0xFF00FF) + int_18 * (int_4 & 0xFF00FF) & 0xFF00FF00) + (int_19 * (int_5 & 0xFF00) + int_18 * (int_4 & 0xFF00) & 0xFF0000) >>> 8;
               int_12 = int_20 >> 16;
               int_13 = (int_20 & 0xFF00) >> 8;
               int_14 = int_20 & 0xFF;
            }
         }

         int_16 += int_15;
      }

   }

   public static void method930(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7) {
      int int_8 = 0;
      int int_9 = 65536 / int_3;
      int int_10 = int_6;
      int int_11 = 256 - int_6;
      if (int_0 < topX) {
         int_2 -= topX - int_0;
         int_0 = topX;
      }

      if (int_1 < topY) {
         int_8 += (topY - int_1) * int_9;
         int_3 -= topY - int_1;
         int_1 = topY;
      }

      if (int_0 + int_2 > bottomX) {
         int_2 = bottomX - int_0;
      }

      if (int_3 + int_1 > bottomY) {
         int_3 = bottomY - int_1;
      }

      int int_12 = int_4 & 0xFF0000;
      int int_13 = int_4 & 0xFF00;
      int int_14 = int_4 & 0xFF;
      int int_15 = int_12 * int_6 >> 8;
      int int_16 = int_13 * int_6 >> 8;
      int int_17 = int_14 * int_6 >> 8;
      int int_18 = graphicsPixelsWidth - int_2;
      int int_19 = int_0 + graphicsPixelsWidth * int_1;

      for (int int_20 = 0; int_20 < int_3; int_20++) {
         int int_21;
         int int_22;
         int int_23;
         for (int_21 = -int_2; int_21 < 0; int_21++) {
            int_22 = graphicsPixels[int_19];
            int_23 = int_22 & 0xFF0000;
            int int_24 = int_23 <= int_12 ? int_23 : (int_11 == 0 ? int_12 : int_15 + (int_23 * int_11 >> 8) & 0xFF0000);
            int int_25 = int_22 & 0xFF00;
            int int_26 = int_25 <= int_13 ? int_25 : (int_11 == 0 ? int_13 : int_16 + (int_25 * int_11 >> 8) & 0xFF00);
            int int_27 = int_22 & 0xFF;
            int int_28 = int_27 <= int_14 ? int_27 : (int_11 == 0 ? int_14 : int_17 + (int_27 * int_11 >> 8));
            graphicsPixels[int_19++] = int_24 + int_26 + int_28;
         }

         if (int_9 > 0) {
            int_8 += int_9;
            int_21 = 65536 - int_8 >> 8;
            int_22 = int_8 >> 8;
            if (int_7 != int_6) {
               int_10 = (65536 - int_8) * int_6 + int_8 * int_7 >> 16;
               int_11 = 256 - int_10;
            }

            if (int_5 != int_4) {
               int_23 = (int_22 * (int_5 & 0xFF00FF) + int_21 * (int_4 & 0xFF00FF) & 0xFF00FF00) + (int_22 * (int_5 & 0xFF00) + int_21 * (int_4 & 0xFF00) & 0xFF0000) >>> 8;
               int_12 = int_23 & 0xFF0000;
               int_13 = int_23 & 0xFF00;
               int_14 = int_23 & 0xFF;
               int_15 = int_12 * int_10 >> 8;
               int_16 = int_13 * int_10 >> 8;
               int_17 = int_14 * int_10 >> 8;
            }
         }

         int_19 += int_18;
      }

   }

   public static void method931(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7) {
      int int_8 = 0;
      int int_9 = 65536 / int_3;
      int int_10 = int_6;
      int int_11 = 256 - int_6;
      if (int_0 < topX) {
         int_2 -= topX - int_0;
         int_0 = topX;
      }

      if (int_1 < topY) {
         int_8 += (topY - int_1) * int_9;
         int_3 -= topY - int_1;
         int_1 = topY;
      }

      if (int_0 + int_2 > bottomX) {
         int_2 = bottomX - int_0;
      }

      if (int_3 + int_1 > bottomY) {
         int_3 = bottomY - int_1;
      }

      int int_12 = int_4 & 0xFF0000;
      int int_13 = int_4 & 0xFF00;
      int int_14 = int_4 & 0xFF;
      int int_15 = int_12 * int_6 >> 8;
      int int_16 = int_13 * int_6 >> 8;
      int int_17 = int_14 * int_6 >> 8;
      int int_18 = graphicsPixelsWidth - int_2;
      int int_19 = int_0 + graphicsPixelsWidth * int_1;

      for (int int_20 = 0; int_20 < int_3; int_20++) {
         int int_21;
         int int_22;
         int int_23;
         for (int_21 = -int_2; int_21 < 0; int_21++) {
            int_22 = graphicsPixels[int_19];
            int_23 = int_22 & 0xFF0000;
            int int_24 = int_23 >= int_12 ? int_23 : (int_11 == 0 ? int_12 : int_15 + (int_23 * int_11 >> 8) & 0xFF0000);
            int int_25 = int_22 & 0xFF00;
            int int_26 = int_25 >= int_13 ? int_25 : (int_11 == 0 ? int_13 : int_16 + (int_25 * int_11 >> 8) & 0xFF00);
            int int_27 = int_22 & 0xFF;
            int int_28 = int_27 >= int_14 ? int_27 : (int_11 == 0 ? int_14 : int_17 + (int_27 * int_11 >> 8));
            graphicsPixels[int_19++] = int_24 + int_26 + int_28;
         }

         if (int_9 > 0) {
            int_8 += int_9;
            int_21 = 65536 - int_8 >> 8;
            int_22 = int_8 >> 8;
            if (int_7 != int_6) {
               int_10 = (65536 - int_8) * int_6 + int_8 * int_7 >> 16;
               int_11 = 256 - int_10;
            }

            if (int_5 != int_4) {
               int_23 = (int_22 * (int_5 & 0xFF00FF) + int_21 * (int_4 & 0xFF00FF) & 0xFF00FF00) + (int_22 * (int_5 & 0xFF00) + int_21 * (int_4 & 0xFF00) & 0xFF0000) >>> 8;
               int_12 = int_23 & 0xFF0000;
               int_13 = int_23 & 0xFF00;
               int_14 = int_23 & 0xFF;
               int_15 = int_12 * int_10 >> 8;
               int_16 = int_13 * int_10 >> 8;
               int_17 = int_14 * int_10 >> 8;
            }
         }

         int_19 += int_18;
      }

   }

   public static void method932(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7) {
      int int_8 = 0;
      int int_9 = int_5 == int_4 && int_7 == int_6 ? -1 : 65536 / int_3;
      int int_10 = int_6;
      int int_11 = 256 - int_6;
      int int_12 = int_4;
      if (int_0 < topX) {
         int_2 -= topX - int_0;
         int_0 = topX;
      }

      if (int_1 < topY) {
         int_8 += (topY - int_1) * int_9;
         int_3 -= topY - int_1;
         int_1 = topY;
      }

      if (int_0 + int_2 > bottomX) {
         int_2 = bottomX - int_0;
      }

      if (int_3 + int_1 > bottomY) {
         int_3 = bottomY - int_1;
      }

      int int_13 = graphicsPixelsWidth - int_2;
      int int_14 = int_0 + graphicsPixelsWidth * int_1;

      for (int int_15 = -int_3; int_15 < 0; int_15++) {
         int int_16;
         int int_17;
         for (int_16 = -int_2; int_16 < 0; int_16++) {
            int_17 = graphicsPixels[int_14];
            int int_18 = int_12 + int_17;
            int int_19 = (int_12 & 0xFF00FF) + (int_17 & 0xFF00FF);
            int int_20 = (int_19 & 0x1000100) + (int_18 - int_19 & 0x10000);
            if (int_11 == 0) {
               graphicsPixels[int_14++] = int_18 - int_20 | int_20 - (int_20 >>> 8);
            } else {
               int int_21 = int_18 - int_20 | int_20 - (int_20 >>> 8);
               graphicsPixels[int_14++] = ((int_21 & 0xFF00FF) * int_10 >> 8 & 0xFF00FF) + ((int_17 & 0xFF00FF) * int_11 >> 8 & 0xFF00FF) + (int_10 * (int_21 & 0xFF00) >> 8 & 0xFF00) + (int_11 * (int_17 & 0xFF00) >> 8 & 0xFF00);
            }
         }

         if (int_9 > 0) {
            int_8 += int_9;
            int_16 = 65536 - int_8 >> 8;
            int_17 = int_8 >> 8;
            if (int_7 != int_6) {
               int_10 = (65536 - int_8) * int_6 + int_8 * int_7 >> 16;
               int_11 = 256 - int_10;
            }

            if (int_5 != int_4) {
               int_12 = (int_17 * (int_5 & 0xFF00FF) + int_16 * (int_4 & 0xFF00FF) & 0xFF00FF00) + (int_17 * (int_5 & 0xFF00) + int_16 * (int_4 & 0xFF00) & 0xFF0000) >>> 8;
            }
         }

         int_14 += int_13;
      }

   }

   static void drawVerticalLine(int x, int y, int length, int colour, int opacity) {
      if (x >= topX && x < bottomX) {
         if (y < topY) {
            length -= topY - y;
            y = topY;
         }

         if (length + y > bottomY) {
            length = bottomY - y;
         }

         int a = 256 - opacity;
         int r = (colour >> 16 & 0xFF) * opacity;
         int g = (colour >> 8 & 0xFF) * opacity;
         int b = opacity * (colour & 0xFF);
         int pixel = x + graphicsPixelsWidth * y;

         for (int lengthCounter = 0; lengthCounter < length; lengthCounter++) {
            int ra = a * (graphicsPixels[pixel] >> 16 & 0xFF);
            int ga = (graphicsPixels[pixel] >> 8 & 0xFF) * a;
            int ba = a * (graphicsPixels[pixel] & 0xFF);
            int rgba = (b + ba >> 8) + (r + ra >> 8 << 16) + (g + ga >> 8 << 8);
            graphicsPixels[pixel] = rgba;
            pixel += graphicsPixelsWidth;
         }

      }
   }

   public static void reset() {
      int int_0 = 0;

      int int_1;
      for (int_1 = graphicsPixelsWidth * graphicsPixelsHeight - 7; int_0 < int_1; graphicsPixels[int_0++] = 0) {
         graphicsPixels[int_0++] = 0;
         graphicsPixels[int_0++] = 0;
         graphicsPixels[int_0++] = 0;
         graphicsPixels[int_0++] = 0;
         graphicsPixels[int_0++] = 0;
         graphicsPixels[int_0++] = 0;
         graphicsPixels[int_0++] = 0;
      }

      for (int_1 += 7; int_0 < int_1; graphicsPixels[int_0++] = 0) {
         ;
      }

   }

}
