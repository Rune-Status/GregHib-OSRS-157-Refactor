public class Rasterizer2D extends CacheableNode {

   public static int drawingAreaTop;
   public static int draw_region_x;
   public static int[] graphicsPixels;
   public static int graphicsPixelsWidth;
   public static int graphicsPixelsHeight;
   public static int drawingAreaRight;
   protected static int drawingAreaBottom;

   static {
      drawingAreaTop = 0;
      drawingAreaRight = 0;
      draw_region_x = 0;
      drawingAreaBottom = 0;
   }

   public static void copyDrawRegion(int[] ints_0) {
      ints_0[0] = draw_region_x;
      ints_0[1] = drawingAreaTop;
      ints_0[2] = drawingAreaBottom;
      ints_0[3] = drawingAreaRight;
   }

   public static void setRasterBuffer(int[] ints_0, int int_0, int int_1) {
      graphicsPixels = ints_0;
      graphicsPixelsWidth = int_0;
      graphicsPixelsHeight = int_1;
      setDrawRegion(0, 0, int_0, int_1);
   }

   public static void method918(int int_0, int int_1, int int_2, int int_3) {
      if (int_0 >= draw_region_x && int_0 < drawingAreaBottom) {
         if (int_1 < drawingAreaTop) {
            int_2 -= drawingAreaTop - int_1;
            int_1 = drawingAreaTop;
         }

         if (int_2 + int_1 > drawingAreaRight) {
            int_2 = drawingAreaRight - int_1;
         }

         int int_4 = int_0 + graphicsPixelsWidth * int_1;

         for (int int_5 = 0; int_5 < int_2; int_5++) {
            graphicsPixels[int_4 + int_5 * graphicsPixelsWidth] = int_3;
         }

      }
   }

   public static void method919(int int_0, int int_1, int int_2, int int_3, int int_4) {
      if (int_0 < draw_region_x) {
         int_2 -= draw_region_x - int_0;
         int_0 = draw_region_x;
      }

      if (int_1 < drawingAreaTop) {
         int_3 -= drawingAreaTop - int_1;
         int_1 = drawingAreaTop;
      }

      if (int_0 + int_2 > drawingAreaBottom) {
         int_2 = drawingAreaBottom - int_0;
      }

      if (int_3 + int_1 > drawingAreaRight) {
         int_3 = drawingAreaRight - int_1;
      }

      int int_5 = graphicsPixelsWidth - int_2;
      int int_6 = int_0 + graphicsPixelsWidth * int_1;

      for (int int_7 = -int_3; int_7 < 0; int_7++) {
         for (int int_8 = -int_2; int_8 < 0; int_8++) {
            graphicsPixels[int_6++] = int_4;
         }

         int_6 += int_5;
      }

   }

   public static void method920(int int_0, int int_1, int int_2, int int_3) {
      if (int_1 >= drawingAreaTop && int_1 < drawingAreaRight) {
         if (int_0 < draw_region_x) {
            int_2 -= draw_region_x - int_0;
            int_0 = draw_region_x;
         }

         if (int_0 + int_2 > drawingAreaBottom) {
            int_2 = drawingAreaBottom - int_0;
         }

         int int_4 = int_0 + graphicsPixelsWidth * int_1;

         for (int int_5 = 0; int_5 < int_2; int_5++) {
            graphicsPixels[int_4 + int_5] = int_3;
         }

      }
   }

   public static void setDrawRegion(int int_0, int int_1, int int_2, int int_3) {
      if (int_0 < 0) {
         int_0 = 0;
      }

      if (int_1 < 0) {
         int_1 = 0;
      }

      if (int_2 > graphicsPixelsWidth) {
         int_2 = graphicsPixelsWidth;
      }

      if (int_3 > graphicsPixelsHeight) {
         int_3 = graphicsPixelsHeight;
      }

      draw_region_x = int_0;
      drawingAreaTop = int_1;
      drawingAreaBottom = int_2;
      drawingAreaRight = int_3;
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
            if (int_9 < drawingAreaTop) {
               int_9 = drawingAreaTop;
            }

            int int_10 = int_2 + int_1 + 1;
            if (int_10 > drawingAreaRight) {
               int_10 = drawingAreaRight;
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
               if (int_17 < draw_region_x) {
                  int_17 = draw_region_x;
               }

               int_18 = int_0 + int_13;
               if (int_18 > drawingAreaBottom) {
                  int_18 = drawingAreaBottom;
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
               if (int_17 < draw_region_x) {
                  int_17 = draw_region_x;
               }

               int_18 = int_0 + int_13;
               if (int_18 > drawingAreaBottom - 1) {
                  int_18 = drawingAreaBottom - 1;
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
      method918(int_0, int_1, int_3, int_4);
      method918(int_0 + int_2 - 1, int_1, int_3, int_4);
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
         if (int_4 < drawingAreaTop) {
            int_4 = drawingAreaTop;
         }

         int int_5 = int_2 + int_1 + 1;
         if (int_5 > drawingAreaRight) {
            int_5 = drawingAreaRight;
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
            if (int_12 < draw_region_x) {
               int_12 = draw_region_x;
            }

            int_13 = int_0 + int_8;
            if (int_13 > drawingAreaBottom) {
               int_13 = drawingAreaBottom;
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
            if (int_12 < draw_region_x) {
               int_12 = draw_region_x;
            }

            int_13 = int_0 + int_8;
            if (int_13 > drawingAreaBottom - 1) {
               int_13 = drawingAreaBottom - 1;
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

   public static void noClip() {
      draw_region_x = 0;
      drawingAreaTop = 0;
      drawingAreaBottom = graphicsPixelsWidth;
      drawingAreaRight = graphicsPixelsHeight;
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
            method918(int_0, int_1, int_3 + 1, int_4);
         } else {
            method918(int_0, int_3 + int_1, -int_3 + 1, int_4);
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
            if (int_0 < draw_region_x) {
               int_1 += int_5 * (draw_region_x - int_0);
               int_0 = draw_region_x;
            }

            if (int_2 >= drawingAreaBottom) {
               int_2 = drawingAreaBottom - 1;
            }

            while (int_0 <= int_2) {
               int_6 = int_1 >> 16;
               if (int_6 >= drawingAreaTop && int_6 < drawingAreaRight) {
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
            if (int_1 < drawingAreaTop) {
               int_0 += (drawingAreaTop - int_1) * int_5;
               int_1 = drawingAreaTop;
            }

            if (int_3 >= drawingAreaRight) {
               int_3 = drawingAreaRight - 1;
            }

            while (int_1 <= int_3) {
               int_6 = int_0 >> 16;
               if (int_6 >= draw_region_x && int_6 < drawingAreaBottom) {
                  graphicsPixels[int_6 + graphicsPixelsWidth * int_1] = int_4;
               }

               int_0 += int_5;
               ++int_1;
            }
         }

      }
   }

   public static void setDrawRegion(int[] ints_0) {
      draw_region_x = ints_0[0];
      drawingAreaTop = ints_0[1];
      drawingAreaBottom = ints_0[2];
      drawingAreaRight = ints_0[3];
   }

   static void method924(int int_0, int int_1, int int_2) {
      if (int_0 >= draw_region_x && int_1 >= drawingAreaTop && int_0 < drawingAreaBottom && int_1 < drawingAreaRight) {
         graphicsPixels[int_0 + graphicsPixelsWidth * int_1] = int_2;
      }
   }

   public static void fillRectangle(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      if (int_0 < draw_region_x) {
         int_2 -= draw_region_x - int_0;
         int_0 = draw_region_x;
      }

      if (int_1 < drawingAreaTop) {
         int_3 -= drawingAreaTop - int_1;
         int_1 = drawingAreaTop;
      }

      if (int_0 + int_2 > drawingAreaBottom) {
         int_2 = drawingAreaBottom - int_0;
      }

      if (int_3 + int_1 > drawingAreaRight) {
         int_3 = drawingAreaRight - int_1;
      }

      int_4 = (int_5 * (int_4 & 0xFF00FF) >> 8 & 0xFF00FF) + (int_5 * (int_4 & 0xFF00) >> 8 & 0xFF00);
      int int_6 = 256 - int_5;
      int int_7 = graphicsPixelsWidth - int_2;
      int int_8 = int_0 + graphicsPixelsWidth * int_1;

      for (int int_9 = 0; int_9 < int_3; int_9++) {
         for (int int_10 = -int_2; int_10 < 0; int_10++) {
            int int_11 = graphicsPixels[int_8];
            int_11 = ((int_11 & 0xFF00FF) * int_6 >> 8 & 0xFF00FF) + (int_6 * (int_11 & 0xFF00) >> 8 & 0xFF00);
            graphicsPixels[int_8++] = int_11 + int_4;
         }

         int_8 += int_7;
      }

   }

   public static void method925(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      int int_6 = 0;
      int int_7 = 65536 / int_3;
      if (int_0 < draw_region_x) {
         int_2 -= draw_region_x - int_0;
         int_0 = draw_region_x;
      }

      if (int_1 < drawingAreaTop) {
         int_6 += (drawingAreaTop - int_1) * int_7;
         int_3 -= drawingAreaTop - int_1;
         int_1 = drawingAreaTop;
      }

      if (int_0 + int_2 > drawingAreaBottom) {
         int_2 = drawingAreaBottom - int_0;
      }

      if (int_3 + int_1 > drawingAreaRight) {
         int_3 = drawingAreaRight - int_1;
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

   public static void method926(int int_0, int int_1, int int_2, int[] ints_0, int[] ints_1) {
      int int_3 = int_0 + graphicsPixelsWidth * int_1;

      for (int_1 = 0; int_1 < ints_0.length; int_1++) {
         int int_4 = int_3 + ints_0[int_1];

         for (int_0 = -ints_1[int_1]; int_0 < 0; int_0++) {
            graphicsPixels[int_4++] = int_2;
         }

         int_3 += graphicsPixelsWidth;
      }

   }

   public static void method927(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      method928(int_0, int_1, int_2, int_4, int_5);
      method928(int_0, int_3 + int_1 - 1, int_2, int_4, int_5);
      if (int_3 >= 3) {
         method933(int_0, int_1 + 1, int_3 - 2, int_4, int_5);
         method933(int_0 + int_2 - 1, int_1 + 1, int_3 - 2, int_4, int_5);
      }

   }

   static void method928(int int_0, int int_1, int int_2, int int_3, int int_4) {
      if (int_1 >= drawingAreaTop && int_1 < drawingAreaRight) {
         if (int_0 < draw_region_x) {
            int_2 -= draw_region_x - int_0;
            int_0 = draw_region_x;
         }

         if (int_0 + int_2 > drawingAreaBottom) {
            int_2 = drawingAreaBottom - int_0;
         }

         int int_5 = 256 - int_4;
         int int_6 = (int_3 >> 16 & 0xFF) * int_4;
         int int_7 = (int_3 >> 8 & 0xFF) * int_4;
         int int_8 = int_4 * (int_3 & 0xFF);
         int int_9 = int_0 + graphicsPixelsWidth * int_1;

         for (int int_10 = 0; int_10 < int_2; int_10++) {
            int int_11 = int_5 * (graphicsPixels[int_9] >> 16 & 0xFF);
            int int_12 = (graphicsPixels[int_9] >> 8 & 0xFF) * int_5;
            int int_13 = int_5 * (graphicsPixels[int_9] & 0xFF);
            int int_14 = (int_8 + int_13 >> 8) + (int_6 + int_11 >> 8 << 16) + (int_7 + int_12 >> 8 << 8);
            graphicsPixels[int_9++] = int_14;
         }

      }
   }

   public static void setInnerDrawRegion(int int_0, int int_1, int int_2, int int_3) {
      if (draw_region_x < int_0) {
         draw_region_x = int_0;
      }

      if (drawingAreaTop < int_1) {
         drawingAreaTop = int_1;
      }

      if (drawingAreaBottom > int_2) {
         drawingAreaBottom = int_2;
      }

      if (drawingAreaRight > int_3) {
         drawingAreaRight = int_3;
      }

   }

   public static void method929(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7) {
      int int_8 = 0;
      int int_9 = int_5 == int_4 && int_7 == int_6 ? -1 : 65536 / int_3;
      int int_10 = int_6;
      int int_11 = 256 - int_6;
      if (int_0 < draw_region_x) {
         int_2 -= draw_region_x - int_0;
         int_0 = draw_region_x;
      }

      if (int_1 < drawingAreaTop) {
         int_8 += (drawingAreaTop - int_1) * int_9;
         int_3 -= drawingAreaTop - int_1;
         int_1 = drawingAreaTop;
      }

      if (int_0 + int_2 > drawingAreaBottom) {
         int_2 = drawingAreaBottom - int_0;
      }

      if (int_3 + int_1 > drawingAreaRight) {
         int_3 = drawingAreaRight - int_1;
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
      if (int_0 < draw_region_x) {
         int_2 -= draw_region_x - int_0;
         int_0 = draw_region_x;
      }

      if (int_1 < drawingAreaTop) {
         int_8 += (drawingAreaTop - int_1) * int_9;
         int_3 -= drawingAreaTop - int_1;
         int_1 = drawingAreaTop;
      }

      if (int_0 + int_2 > drawingAreaBottom) {
         int_2 = drawingAreaBottom - int_0;
      }

      if (int_3 + int_1 > drawingAreaRight) {
         int_3 = drawingAreaRight - int_1;
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
      if (int_0 < draw_region_x) {
         int_2 -= draw_region_x - int_0;
         int_0 = draw_region_x;
      }

      if (int_1 < drawingAreaTop) {
         int_8 += (drawingAreaTop - int_1) * int_9;
         int_3 -= drawingAreaTop - int_1;
         int_1 = drawingAreaTop;
      }

      if (int_0 + int_2 > drawingAreaBottom) {
         int_2 = drawingAreaBottom - int_0;
      }

      if (int_3 + int_1 > drawingAreaRight) {
         int_3 = drawingAreaRight - int_1;
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
      if (int_0 < draw_region_x) {
         int_2 -= draw_region_x - int_0;
         int_0 = draw_region_x;
      }

      if (int_1 < drawingAreaTop) {
         int_8 += (drawingAreaTop - int_1) * int_9;
         int_3 -= drawingAreaTop - int_1;
         int_1 = drawingAreaTop;
      }

      if (int_0 + int_2 > drawingAreaBottom) {
         int_2 = drawingAreaBottom - int_0;
      }

      if (int_3 + int_1 > drawingAreaRight) {
         int_3 = drawingAreaRight - int_1;
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

   static void method933(int int_0, int int_1, int int_2, int int_3, int int_4) {
      if (int_0 >= draw_region_x && int_0 < drawingAreaBottom) {
         if (int_1 < drawingAreaTop) {
            int_2 -= drawingAreaTop - int_1;
            int_1 = drawingAreaTop;
         }

         if (int_2 + int_1 > drawingAreaRight) {
            int_2 = drawingAreaRight - int_1;
         }

         int int_5 = 256 - int_4;
         int int_6 = (int_3 >> 16 & 0xFF) * int_4;
         int int_7 = (int_3 >> 8 & 0xFF) * int_4;
         int int_8 = int_4 * (int_3 & 0xFF);
         int int_9 = int_0 + graphicsPixelsWidth * int_1;

         for (int int_10 = 0; int_10 < int_2; int_10++) {
            int int_11 = int_5 * (graphicsPixels[int_9] >> 16 & 0xFF);
            int int_12 = (graphicsPixels[int_9] >> 8 & 0xFF) * int_5;
            int int_13 = int_5 * (graphicsPixels[int_9] & 0xFF);
            int int_14 = (int_8 + int_13 >> 8) + (int_6 + int_11 >> 8 << 16) + (int_7 + int_12 >> 8 << 8);
            graphicsPixels[int_9] = int_14;
            int_9 += graphicsPixelsWidth;
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
