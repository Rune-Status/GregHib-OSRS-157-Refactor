public final class SpritePixels extends Rasterizer2D {

   public int maxWidth;
   public int offsetX;
   public int height;
   public int[] pixels;
   public int width;
   public int maxHeight;
   int offsetY;

   public SpritePixels(int[] pixels, int width, int height) {
      this.pixels = pixels;
      this.width = this.maxWidth = width;
      this.height = this.maxHeight = height;
      this.offsetY = 0;
      this.offsetX = 0;
   }

   public SpritePixels(int width, int height) {
      this(new int[height * width], width, height);
   }

   SpritePixels() {
   }

   public void drawAt(int x, int y) {
      x += this.offsetX;
      y += this.offsetY;
      int graphicsPixel = x + y * Rasterizer2D.graphicsPixelsWidth;
      int pixelOffset = 0;
      int imageHeight = this.height;
      int imageWidth = this.width;
      int deviation = Rasterizer2D.graphicsPixelsWidth - imageWidth;
      int originalDeviation = 0;
      int yOffset;
      if (y < Rasterizer2D.drawingAreaTop) {
         yOffset = Rasterizer2D.drawingAreaTop - y;
         imageHeight -= yOffset;
         y = Rasterizer2D.drawingAreaTop;
         pixelOffset += yOffset * imageWidth;
         graphicsPixel += yOffset * Rasterizer2D.graphicsPixelsWidth;
      }

      if (imageHeight + y > Rasterizer2D.drawingAreaRight) {
         imageHeight -= imageHeight + y - Rasterizer2D.drawingAreaRight;
      }

      if (x < Rasterizer2D.draw_region_x) {
         yOffset = Rasterizer2D.draw_region_x - x;
         imageWidth -= yOffset;
         x = Rasterizer2D.draw_region_x;
         pixelOffset += yOffset;
         graphicsPixel += yOffset;
         originalDeviation += yOffset;
         deviation += yOffset;
      }

      if (imageWidth + x > Rasterizer2D.drawingAreaBottom) {
         yOffset = imageWidth + x - Rasterizer2D.drawingAreaBottom;
         imageWidth -= yOffset;
         originalDeviation += yOffset;
         deviation += yOffset;
      }

      if (imageWidth > 0 && imageHeight > 0) {
         shapeImageToPixels(Rasterizer2D.graphicsPixels, this.pixels, 0, pixelOffset, graphicsPixel, imageWidth, imageHeight, deviation, originalDeviation);
      }
   }

   void method980(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      if (int_5 != 0) {
         int_0 -= this.offsetX << 4;
         int_1 -= this.offsetY << 4;
         double double_0 = (double)(int_4 & 0xFFFF) * 9.587379924285257E-5D;
         int int_6 = (int)Math.floor(Math.sin(double_0) * (double)int_5 + 0.5D);
         int int_7 = (int)Math.floor(Math.cos(double_0) * (double)int_5 + 0.5D);
         int int_8 = int_7 * -int_0 + -int_1 * int_6;
         int int_9 = -int_1 * int_7 + int_6 * -(-int_0);
         int int_10 = int_7 * ((this.width << 4) - int_0) + -int_1 * int_6;
         int int_11 = int_6 * -((this.width << 4) - int_0) + -int_1 * int_7;
         int int_12 = ((this.height << 4) - int_1) * int_6 + int_7 * -int_0;
         int int_13 = ((this.height << 4) - int_1) * int_7 + int_6 * -(-int_0);
         int int_14 = ((this.height << 4) - int_1) * int_6 + int_7 * ((this.width << 4) - int_0);
         int int_15 = ((this.height << 4) - int_1) * int_7 + int_6 * -((this.width << 4) - int_0);
         int int_16;
         int int_17;
         if (int_8 < int_10) {
            int_16 = int_8;
            int_17 = int_10;
         } else {
            int_16 = int_10;
            int_17 = int_8;
         }

         if (int_12 < int_16) {
            int_16 = int_12;
         }

         if (int_14 < int_16) {
            int_16 = int_14;
         }

         if (int_12 > int_17) {
            int_17 = int_12;
         }

         if (int_14 > int_17) {
            int_17 = int_14;
         }

         int int_18;
         int int_19;
         if (int_9 < int_11) {
            int_18 = int_9;
            int_19 = int_11;
         } else {
            int_18 = int_11;
            int_19 = int_9;
         }

         if (int_13 < int_18) {
            int_18 = int_13;
         }

         if (int_15 < int_18) {
            int_18 = int_15;
         }

         if (int_13 > int_19) {
            int_19 = int_13;
         }

         if (int_15 > int_19) {
            int_19 = int_15;
         }

         int_16 >>= 12;
         int_17 = int_17 + 4095 >> 12;
         int_18 >>= 12;
         int_19 = int_19 + 4095 >> 12;
         int_16 += int_2;
         int_17 += int_2;
         int_18 += int_3;
         int_19 += int_3;
         int_16 >>= 4;
         int_17 = int_17 + 15 >> 4;
         int_18 >>= 4;
         int_19 = int_19 + 15 >> 4;
         if (int_16 < Rasterizer2D.draw_region_x) {
            int_16 = Rasterizer2D.draw_region_x;
         }

         if (int_17 > Rasterizer2D.drawingAreaBottom) {
            int_17 = Rasterizer2D.drawingAreaBottom;
         }

         if (int_18 < Rasterizer2D.drawingAreaTop) {
            int_18 = Rasterizer2D.drawingAreaTop;
         }

         if (int_19 > Rasterizer2D.drawingAreaRight) {
            int_19 = Rasterizer2D.drawingAreaRight;
         }

         int_17 = int_16 - int_17;
         if (int_17 < 0) {
            int_19 = int_18 - int_19;
            if (int_19 < 0) {
               int int_20 = int_16 + int_18 * Rasterizer2D.graphicsPixelsWidth;
               double double_1 = 1.6777216E7D / (double)int_5;
               int int_21 = (int)Math.floor(Math.sin(double_0) * double_1 + 0.5D);
               int int_22 = (int)Math.floor(Math.cos(double_0) * double_1 + 0.5D);
               int int_23 = (int_16 << 4) + 8 - int_2;
               int int_24 = (int_18 << 4) + 8 - int_3;
               int int_25 = (int_0 << 8) - (int_24 * int_21 >> 4);
               int int_26 = (int_24 * int_22 >> 4) + (int_1 << 8);
               int int_27;
               int int_28;
               int int_29;
               int int_30;
               int int_31;
               int int_32;
               int int_33;
               if (int_22 == 0) {
                  if (int_21 == 0) {
                     for (int_27 = int_19; int_27 < 0; int_20 += Rasterizer2D.graphicsPixelsWidth) {
                        int_28 = int_20;
                        int_29 = int_25;
                        int_30 = int_26;
                        int_31 = int_17;
                        if (int_25 >= 0 && int_26 >= 0 && int_25 - (this.width << 12) < 0 && int_26 - (this.height << 12) < 0) {
                           for (; int_31 < 0; int_31++) {
                              int_33 = this.pixels[(int_29 >> 12) + (int_30 >> 12) * this.width];
                              if (int_33 != 0) {
                                 Rasterizer2D.graphicsPixels[int_28++] = int_33;
                              } else {
                                 ++int_28;
                              }
                           }
                        }

                        ++int_27;
                     }
                  } else if (int_21 < 0) {
                     for (int_27 = int_19; int_27 < 0; int_20 += Rasterizer2D.graphicsPixelsWidth) {
                        int_28 = int_20;
                        int_29 = int_25;
                        int_30 = (int_23 * int_21 >> 4) + int_26;
                        int_31 = int_17;
                        if (int_25 >= 0 && int_25 - (this.width << 12) < 0) {
                           if ((int_32 = int_30 - (this.height << 12)) >= 0) {
                              int_32 = (int_21 - int_32) / int_21;
                              int_31 = int_17 + int_32;
                              int_30 += int_21 * int_32;
                              int_28 = int_20 + int_32;
                           }

                           if ((int_32 = (int_30 - int_21) / int_21) > int_31) {
                              int_31 = int_32;
                           }

                           while (int_31 < 0) {
                              int_33 = this.pixels[(int_29 >> 12) + (int_30 >> 12) * this.width];
                              if (int_33 != 0) {
                                 Rasterizer2D.graphicsPixels[int_28++] = int_33;
                              } else {
                                 ++int_28;
                              }

                              int_30 += int_21;
                              ++int_31;
                           }
                        }

                        ++int_27;
                        int_25 -= int_21;
                     }
                  } else {
                     for (int_27 = int_19; int_27 < 0; int_20 += Rasterizer2D.graphicsPixelsWidth) {
                        int_28 = int_20;
                        int_29 = int_25;
                        int_30 = (int_23 * int_21 >> 4) + int_26;
                        int_31 = int_17;
                        if (int_25 >= 0 && int_25 - (this.width << 12) < 0) {
                           if (int_30 < 0) {
                              int_32 = (int_21 - 1 - int_30) / int_21;
                              int_31 = int_17 + int_32;
                              int_30 += int_21 * int_32;
                              int_28 = int_20 + int_32;
                           }

                           if ((int_32 = (int_30 + 1 - (this.height << 12) - int_21) / int_21) > int_31) {
                              int_31 = int_32;
                           }

                           while (int_31 < 0) {
                              int_33 = this.pixels[(int_29 >> 12) + (int_30 >> 12) * this.width];
                              if (int_33 != 0) {
                                 Rasterizer2D.graphicsPixels[int_28++] = int_33;
                              } else {
                                 ++int_28;
                              }

                              int_30 += int_21;
                              ++int_31;
                           }
                        }

                        ++int_27;
                        int_25 -= int_21;
                     }
                  }
               } else if (int_22 < 0) {
                  if (int_21 == 0) {
                     for (int_27 = int_19; int_27 < 0; int_20 += Rasterizer2D.graphicsPixelsWidth) {
                        int_28 = int_20;
                        int_29 = (int_23 * int_22 >> 4) + int_25;
                        int_30 = int_26;
                        int_31 = int_17;
                        if (int_26 >= 0 && int_26 - (this.height << 12) < 0) {
                           if ((int_32 = int_29 - (this.width << 12)) >= 0) {
                              int_32 = (int_22 - int_32) / int_22;
                              int_31 = int_17 + int_32;
                              int_29 += int_22 * int_32;
                              int_28 = int_20 + int_32;
                           }

                           if ((int_32 = (int_29 - int_22) / int_22) > int_31) {
                              int_31 = int_32;
                           }

                           while (int_31 < 0) {
                              int_33 = this.pixels[(int_29 >> 12) + (int_30 >> 12) * this.width];
                              if (int_33 != 0) {
                                 Rasterizer2D.graphicsPixels[int_28++] = int_33;
                              } else {
                                 ++int_28;
                              }

                              int_29 += int_22;
                              ++int_31;
                           }
                        }

                        ++int_27;
                        int_26 += int_22;
                     }
                  } else if (int_21 < 0) {
                     for (int_27 = int_19; int_27 < 0; int_20 += Rasterizer2D.graphicsPixelsWidth) {
                        int_28 = int_20;
                        int_29 = (int_23 * int_22 >> 4) + int_25;
                        int_30 = (int_23 * int_21 >> 4) + int_26;
                        int_31 = int_17;
                        if ((int_32 = int_29 - (this.width << 12)) >= 0) {
                           int_32 = (int_22 - int_32) / int_22;
                           int_31 = int_17 + int_32;
                           int_29 += int_22 * int_32;
                           int_30 += int_21 * int_32;
                           int_28 = int_20 + int_32;
                        }

                        if ((int_32 = (int_29 - int_22) / int_22) > int_31) {
                           int_31 = int_32;
                        }

                        if ((int_32 = int_30 - (this.height << 12)) >= 0) {
                           int_32 = (int_21 - int_32) / int_21;
                           int_31 += int_32;
                           int_29 += int_22 * int_32;
                           int_30 += int_21 * int_32;
                           int_28 += int_32;
                        }

                        if ((int_32 = (int_30 - int_21) / int_21) > int_31) {
                           int_31 = int_32;
                        }

                        while (int_31 < 0) {
                           int_33 = this.pixels[(int_29 >> 12) + (int_30 >> 12) * this.width];
                           if (int_33 != 0) {
                              Rasterizer2D.graphicsPixels[int_28++] = int_33;
                           } else {
                              ++int_28;
                           }

                           int_29 += int_22;
                           int_30 += int_21;
                           ++int_31;
                        }

                        ++int_27;
                        int_25 -= int_21;
                        int_26 += int_22;
                     }
                  } else {
                     for (int_27 = int_19; int_27 < 0; int_20 += Rasterizer2D.graphicsPixelsWidth) {
                        int_28 = int_20;
                        int_29 = (int_23 * int_22 >> 4) + int_25;
                        int_30 = (int_23 * int_21 >> 4) + int_26;
                        int_31 = int_17;
                        if ((int_32 = int_29 - (this.width << 12)) >= 0) {
                           int_32 = (int_22 - int_32) / int_22;
                           int_31 = int_17 + int_32;
                           int_29 += int_22 * int_32;
                           int_30 += int_21 * int_32;
                           int_28 = int_20 + int_32;
                        }

                        if ((int_32 = (int_29 - int_22) / int_22) > int_31) {
                           int_31 = int_32;
                        }

                        if (int_30 < 0) {
                           int_32 = (int_21 - 1 - int_30) / int_21;
                           int_31 += int_32;
                           int_29 += int_22 * int_32;
                           int_30 += int_21 * int_32;
                           int_28 += int_32;
                        }

                        if ((int_32 = (int_30 + 1 - (this.height << 12) - int_21) / int_21) > int_31) {
                           int_31 = int_32;
                        }

                        while (int_31 < 0) {
                           int_33 = this.pixels[(int_29 >> 12) + (int_30 >> 12) * this.width];
                           if (int_33 != 0) {
                              Rasterizer2D.graphicsPixels[int_28++] = int_33;
                           } else {
                              ++int_28;
                           }

                           int_29 += int_22;
                           int_30 += int_21;
                           ++int_31;
                        }

                        ++int_27;
                        int_25 -= int_21;
                        int_26 += int_22;
                     }
                  }
               } else if (int_21 == 0) {
                  for (int_27 = int_19; int_27 < 0; int_20 += Rasterizer2D.graphicsPixelsWidth) {
                     int_28 = int_20;
                     int_29 = (int_23 * int_22 >> 4) + int_25;
                     int_30 = int_26;
                     int_31 = int_17;
                     if (int_26 >= 0 && int_26 - (this.height << 12) < 0) {
                        if (int_29 < 0) {
                           int_32 = (int_22 - 1 - int_29) / int_22;
                           int_31 = int_17 + int_32;
                           int_29 += int_22 * int_32;
                           int_28 = int_20 + int_32;
                        }

                        if ((int_32 = (int_29 + 1 - (this.width << 12) - int_22) / int_22) > int_31) {
                           int_31 = int_32;
                        }

                        while (int_31 < 0) {
                           int_33 = this.pixels[(int_29 >> 12) + (int_30 >> 12) * this.width];
                           if (int_33 != 0) {
                              Rasterizer2D.graphicsPixels[int_28++] = int_33;
                           } else {
                              ++int_28;
                           }

                           int_29 += int_22;
                           ++int_31;
                        }
                     }

                     ++int_27;
                     int_26 += int_22;
                  }
               } else if (int_21 < 0) {
                  for (int_27 = int_19; int_27 < 0; int_20 += Rasterizer2D.graphicsPixelsWidth) {
                     int_28 = int_20;
                     int_29 = (int_23 * int_22 >> 4) + int_25;
                     int_30 = (int_23 * int_21 >> 4) + int_26;
                     int_31 = int_17;
                     if (int_29 < 0) {
                        int_32 = (int_22 - 1 - int_29) / int_22;
                        int_31 = int_17 + int_32;
                        int_29 += int_22 * int_32;
                        int_30 += int_21 * int_32;
                        int_28 = int_20 + int_32;
                     }

                     if ((int_32 = (int_29 + 1 - (this.width << 12) - int_22) / int_22) > int_31) {
                        int_31 = int_32;
                     }

                     if ((int_32 = int_30 - (this.height << 12)) >= 0) {
                        int_32 = (int_21 - int_32) / int_21;
                        int_31 += int_32;
                        int_29 += int_22 * int_32;
                        int_30 += int_21 * int_32;
                        int_28 += int_32;
                     }

                     if ((int_32 = (int_30 - int_21) / int_21) > int_31) {
                        int_31 = int_32;
                     }

                     while (int_31 < 0) {
                        int_33 = this.pixels[(int_29 >> 12) + (int_30 >> 12) * this.width];
                        if (int_33 != 0) {
                           Rasterizer2D.graphicsPixels[int_28++] = int_33;
                        } else {
                           ++int_28;
                        }

                        int_29 += int_22;
                        int_30 += int_21;
                        ++int_31;
                     }

                     ++int_27;
                     int_25 -= int_21;
                     int_26 += int_22;
                  }
               } else {
                  for (int_27 = int_19; int_27 < 0; int_20 += Rasterizer2D.graphicsPixelsWidth) {
                     int_28 = int_20;
                     int_29 = (int_23 * int_22 >> 4) + int_25;
                     int_30 = (int_23 * int_21 >> 4) + int_26;
                     int_31 = int_17;
                     if (int_29 < 0) {
                        int_32 = (int_22 - 1 - int_29) / int_22;
                        int_31 = int_17 + int_32;
                        int_29 += int_22 * int_32;
                        int_30 += int_21 * int_32;
                        int_28 = int_20 + int_32;
                     }

                     if ((int_32 = (int_29 + 1 - (this.width << 12) - int_22) / int_22) > int_31) {
                        int_31 = int_32;
                     }

                     if (int_30 < 0) {
                        int_32 = (int_21 - 1 - int_30) / int_21;
                        int_31 += int_32;
                        int_29 += int_22 * int_32;
                        int_30 += int_21 * int_32;
                        int_28 += int_32;
                     }

                     if ((int_32 = (int_30 + 1 - (this.height << 12) - int_21) / int_21) > int_31) {
                        int_31 = int_32;
                     }

                     while (int_31 < 0) {
                        int_33 = this.pixels[(int_29 >> 12) + (int_30 >> 12) * this.width];
                        if (int_33 != 0) {
                           Rasterizer2D.graphicsPixels[int_28++] = int_33;
                        } else {
                           ++int_28;
                        }

                        int_29 += int_22;
                        int_30 += int_21;
                        ++int_31;
                     }

                     ++int_27;
                     int_25 -= int_21;
                     int_26 += int_22;
                  }
               }

            }
         }
      }
   }

   public void method981(int int_0, int int_1, int int_2, int int_3) {
      if (int_2 > 0 && int_3 > 0) {
         int int_4 = this.width;
         int int_5 = this.height;
         int int_6 = 0;
         int int_7 = 0;
         int int_8 = this.maxWidth;
         int int_9 = this.maxHeight;
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

         method1004(Rasterizer2D.graphicsPixels, this.pixels, 0, int_6, int_7, int_12, int_13, int_2, int_3, int_10, int_11, int_4);
      }
   }

   public void method982(int int_0, int int_1, int int_2, int int_3) {
      if (int_2 <= this.maxWidth && int_3 <= this.maxHeight) {
         int int_4 = int_2 * this.offsetX / this.maxWidth + int_0;
         int int_5 = (int_2 * (this.offsetX + this.width) + this.maxWidth - 1) / this.maxWidth + int_0;
         int int_6 = int_1 + int_3 * this.offsetY / this.maxHeight;
         int int_7 = int_1 + (this.maxHeight + (this.offsetY + this.height) * int_3 - 1) / this.maxHeight;
         if (int_4 < Rasterizer2D.draw_region_x) {
            int_4 = Rasterizer2D.draw_region_x;
         }

         if (int_5 > Rasterizer2D.drawingAreaBottom) {
            int_5 = Rasterizer2D.drawingAreaBottom;
         }

         if (int_6 < Rasterizer2D.drawingAreaTop) {
            int_6 = Rasterizer2D.drawingAreaTop;
         }

         if (int_7 > Rasterizer2D.drawingAreaRight) {
            int_7 = Rasterizer2D.drawingAreaRight;
         }

         if (int_4 < int_5 && int_6 < int_7) {
            int int_8 = int_4 + int_6 * Rasterizer2D.graphicsPixelsWidth;
            int int_9 = Rasterizer2D.graphicsPixelsWidth - (int_5 - int_4);
            if (int_8 < Rasterizer2D.graphicsPixels.length) {
               for (int int_10 = int_6; int_10 < int_7; int_10++) {
                  for (int int_11 = int_4; int_11 < int_5; int_11++) {
                     int int_12 = int_11 - int_0 << 4;
                     int int_13 = int_10 - int_1 << 4;
                     int int_14 = int_12 * this.maxWidth / int_2 - (this.offsetX << 4);
                     int int_15 = (int_12 + 16) * this.maxWidth / int_2 - (this.offsetX << 4);
                     int int_16 = int_13 * this.maxHeight / int_3 - (this.offsetY << 4);
                     int int_17 = (int_13 + 16) * this.maxHeight / int_3 - (this.offsetY << 4);
                     int int_18 = (int_15 - int_14) * (int_17 - int_16) >> 1;
                     if (int_18 != 0) {
                        if (int_14 < 0) {
                           int_14 = 0;
                        }

                        if (int_15 >= this.width << 4) {
                           int_15 = this.width << 4;
                        }

                        if (int_16 < 0) {
                           int_16 = 0;
                        }

                        if (int_17 >= this.height << 4) {
                           int_17 = this.height << 4;
                        }

                        --int_15;
                        --int_17;
                        int int_19 = 16 - (int_14 & 0xF);
                        int int_20 = (int_15 & 0xF) + 1;
                        int int_21 = 16 - (int_16 & 0xF);
                        int int_22 = (int_17 & 0xF) + 1;
                        int_14 >>= 4;
                        int_15 >>= 4;
                        int_16 >>= 4;
                        int_17 >>= 4;
                        int int_23 = 0;
                        int int_24 = 0;
                        int int_25 = 0;
                        int int_26 = 0;

                        int int_27;
                        for (int_27 = int_16; int_27 <= int_17; int_27++) {
                           int int_28 = 16;
                           if (int_27 == int_16) {
                              int_28 = int_21;
                           }

                           if (int_27 == int_17) {
                              int_28 = int_22;
                           }

                           for (int int_29 = int_14; int_29 <= int_15; int_29++) {
                              int int_30 = this.pixels[int_29 + int_27 * this.width];
                              if (int_30 != 0) {
                                 int int_31;
                                 if (int_29 == int_14) {
                                    int_31 = int_28 * int_19;
                                 } else if (int_29 == int_15) {
                                    int_31 = int_28 * int_20;
                                 } else {
                                    int_31 = int_28 << 4;
                                 }

                                 int_26 += int_31;
                                 int_23 += int_31 * (int_30 >> 16 & 0xFF);
                                 int_24 += int_31 * (int_30 >> 8 & 0xFF);
                                 int_25 += (int_30 & 0xFF) * int_31;
                              }
                           }
                        }

                        if (int_26 >= int_18) {
                           int_27 = int_25 / int_26 + (int_23 / int_26 << 16) + (int_24 / int_26 << 8);
                           if (int_27 == 0) {
                              int_27 = 1;
                           }

                           Rasterizer2D.graphicsPixels[int_8] = int_27;
                        }

                        ++int_8;
                     }
                  }

                  int_8 += int_9;
               }

            }
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   public void drawImage(int x, int y) {
      x += this.offsetX;
      y += this.offsetY;
      int graphicsOffset = x + y * Rasterizer2D.graphicsPixelsWidth;
      int pixelOffset = 0;
      int imgHeight = this.height;
      int imgWidth = this.width;
      int deviation = Rasterizer2D.graphicsPixelsWidth - imgWidth;
      int originalDeviation = 0;
      int offset;
      if (y < Rasterizer2D.drawingAreaTop) {
         offset = Rasterizer2D.drawingAreaTop - y;
         imgHeight -= offset;
         y = Rasterizer2D.drawingAreaTop;
         pixelOffset += offset * imgWidth;
         graphicsOffset += offset * Rasterizer2D.graphicsPixelsWidth;
      }

      if (imgHeight + y > Rasterizer2D.drawingAreaRight) {
         imgHeight -= imgHeight + y - Rasterizer2D.drawingAreaRight;
      }

      if (x < Rasterizer2D.draw_region_x) {
         offset = Rasterizer2D.draw_region_x - x;
         imgWidth -= offset;
         x = Rasterizer2D.draw_region_x;
         pixelOffset += offset;
         graphicsOffset += offset;
         originalDeviation += offset;
         deviation += offset;
      }

      if (imgWidth + x > Rasterizer2D.drawingAreaBottom) {
         offset = imgWidth + x - Rasterizer2D.drawingAreaBottom;
         imgWidth -= offset;
         originalDeviation += offset;
         deviation += offset;
      }

      if (imgWidth > 0 && imgHeight > 0) {
         copyPixels(Rasterizer2D.graphicsPixels, this.pixels, pixelOffset, graphicsOffset, imgWidth, imgHeight, deviation, originalDeviation);
      }
   }

   public void method984() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   public SpritePixels copy() {
      SpritePixels pixels = new SpritePixels(this.maxWidth, this.maxHeight);

      for (int y = 0; y < this.height; y++) {
         for (int x = 0; x < this.width; x++) {
            pixels.pixels[x + (y + this.offsetY) * this.maxWidth + this.offsetX] = this.pixels[x + y * this.width];
         }
      }

      return pixels;
   }

   public void flipVertical() {
      int[] pixels = new int[this.width * this.height];
      int index = 0;

      for (int y = this.height - 1; y >= 0; --y) {
         for (int x = 0; x < this.width; x++) {
            pixels[index++] = this.pixels[x + y * this.width];
         }
      }

      this.pixels = pixels;
      this.offsetY = this.maxHeight - this.height - this.offsetY;
   }

   public void flipHorizontal() {
      int[] pixels = new int[this.width * this.height];
      int index = 0;

      for (int y = 0; y < this.height; y++) {
         for (int x = this.width - 1; x >= 0; --x) {
            pixels[index++] = this.pixels[x + y * this.width];
         }
      }

      this.pixels = pixels;
      this.offsetX = this.maxWidth - this.width - this.offsetX;
   }

   public void setBorder(int thickness) {
      if (this.width != this.maxWidth || this.height != this.maxHeight) {
         int rightOffsetX = thickness;
         if (thickness > this.offsetX) {
            rightOffsetX = this.offsetX;
         }

         int leftOffsetX = thickness;
         if (thickness + this.offsetX + this.width > this.maxWidth) {
            leftOffsetX = this.maxWidth - this.offsetX - this.width;
         }

         int topOffsetY = thickness;
         if (thickness > this.offsetY) {
            topOffsetY = this.offsetY;
         }

         int bottomOffsetY = thickness;
         if (thickness + this.offsetY + this.height > this.maxHeight) {
            bottomOffsetY = this.maxHeight - this.offsetY - this.height;
         }

         int totalWidth = rightOffsetX + leftOffsetX + this.width;
         int totalHeight = topOffsetY + bottomOffsetY + this.height;
         int[] pixels = new int[totalWidth * totalHeight];

         for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
               pixels[totalWidth * (y + topOffsetY) + x + rightOffsetX] = this.pixels[x + y * this.width];
            }
         }

         this.pixels = pixels;
         this.width = totalWidth;
         this.height = totalHeight;
         this.offsetX -= rightOffsetX;
         this.offsetY -= topOffsetY;
      }
   }

   public void setTransparentPixel(int colour) {
      int[] pixels = new int[this.width * this.height];
      int index = 0;

      for (int y = 0; y < this.height; y++) {
         for (int x = 0; x < this.width; x++) {
            int pixel = this.pixels[index];
            if (pixel == 0) {
               if (x > 0 && this.pixels[index - 1] != 0) {
                  pixel = colour;
               } else if (y > 0 && this.pixels[index - this.width] != 0) {
                  pixel = colour;
               } else if (x < this.width - 1 && this.pixels[index + 1] != 0) {
                  pixel = colour;
               } else if (y < this.height - 1 && this.pixels[index + this.width] != 0) {
                  pixel = colour;
               }
            }

            pixels[index++] = pixel;
         }
      }

      this.pixels = pixels;
   }

   public void setSecondarySprite(int spriteId) {
      for (int int_1 = this.height - 1; int_1 > 0; --int_1) {
         int int_2 = int_1 * this.width;

         for (int int_3 = this.width - 1; int_3 > 0; --int_3) {
            if (this.pixels[int_3 + int_2] == 0 && this.pixels[int_3 + int_2 - 1 - this.width] != 0) {
               this.pixels[int_3 + int_2] = spriteId;
            }
         }
      }

   }

   public void refreshDimensions() {
      if (this.width != this.maxWidth || this.height != this.maxHeight) {
         int[] pixels = new int[this.maxWidth * this.maxHeight];

         for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
               pixels[x + (y + this.offsetY) * this.maxWidth + this.offsetX] = this.pixels[x + y * this.width];
            }
         }

         this.pixels = pixels;
         this.width = this.maxWidth;
         this.height = this.maxHeight;
         this.offsetX = 0;
         this.offsetY = 0;
      }
   }

   public void rotate(int x, int y, int imgWidth, int imgHeight, int centreX, int centreY, int angle, int hypotenuse, int[] heightMap, int[] widthMap) {
      try {
         int negCentreX = -imgWidth / 2;
         int negCentreY = -imgHeight / 2;
         int sine = (int)(Math.sin((double)angle / 326.11D) * 65536.0D);
         int cosine = (int)(Math.cos((double)angle / 326.11D) * 65536.0D);
         sine = sine * hypotenuse >> 8;
         cosine = cosine * hypotenuse >> 8;
         int offsetX = negCentreY * sine + negCentreX * cosine + (centreX << 16);
         int offsetY = negCentreY * cosine - negCentreX * sine + (centreY << 16);
         int baseOffset = x + y * Rasterizer2D.graphicsPixelsWidth;

         for (y = 0; y < imgHeight; y++) {
            int height = heightMap[y];
            int graphicsPixel = baseOffset + height;
            int dX = offsetX + cosine * height;
            int dY = offsetY - sine * height;

            for (x = -widthMap[y]; x < 0; x++) {
               Rasterizer2D.graphicsPixels[graphicsPixel++] = this.pixels[this.width * (dY >> 16) + (dX >> 16)];
               dX += cosine;
               dY -= sine;
            }

            offsetX += sine;
            offsetY += cosine;
            baseOffset += Rasterizer2D.graphicsPixelsWidth;
         }
      } catch (Exception e) {
         ;
      }

   }

   public void method992(int x, int y, int imgWidth, int imgHeight, int alpha) {
      if (imgWidth > 0 && imgHeight > 0) {
         int width = this.width;
         int height = this.height;
         int dX = 0;
         int dY = 0;
         int maxWidth = this.maxWidth;
         int maxHeight = this.maxHeight;
         int int_11 = (maxWidth << 16) / imgWidth;
         int int_12 = (maxHeight << 16) / imgHeight;
         int int_13;
         if (this.offsetX > 0) {
            int_13 = (int_11 + (this.offsetX << 16) - 1) / int_11;
            x += int_13;
            dX += int_13 * int_11 - (this.offsetX << 16);
         }

         if (this.offsetY > 0) {
            int_13 = (int_12 + (this.offsetY << 16) - 1) / int_12;
            y += int_13;
            dY += int_13 * int_12 - (this.offsetY << 16);
         }

         if (width < maxWidth) {
            imgWidth = (int_11 + ((width << 16) - dX) - 1) / int_11;
         }

         if (height < maxHeight) {
            imgHeight = (int_12 + ((height << 16) - dY) - 1) / int_12;
         }

         int_13 = x + y * Rasterizer2D.graphicsPixelsWidth;
         int int_14 = Rasterizer2D.graphicsPixelsWidth - imgWidth;
         if (y + imgHeight > Rasterizer2D.drawingAreaRight) {
            imgHeight -= y + imgHeight - Rasterizer2D.drawingAreaRight;
         }

         int int_15;
         if (y < Rasterizer2D.drawingAreaTop) {
            int_15 = Rasterizer2D.drawingAreaTop - y;
            imgHeight -= int_15;
            int_13 += int_15 * Rasterizer2D.graphicsPixelsWidth;
            dY += int_12 * int_15;
         }

         if (imgWidth + x > Rasterizer2D.drawingAreaBottom) {
            int_15 = imgWidth + x - Rasterizer2D.drawingAreaBottom;
            imgWidth -= int_15;
            int_14 += int_15;
         }

         if (x < Rasterizer2D.draw_region_x) {
            int_15 = Rasterizer2D.draw_region_x - x;
            imgWidth -= int_15;
            int_13 += int_15;
            dX += int_11 * int_15;
            int_14 += int_15;
         }

         method1003(Rasterizer2D.graphicsPixels, this.pixels, 0, dX, dY, int_13, int_14, imgWidth, imgHeight, int_11, int_12, width, alpha);
      }
   }

   public void method993(int int_0, int int_1, int int_2, int int_3) {
      this.method980(this.maxWidth << 3, this.maxHeight << 3, int_0 << 4, int_1 << 4, int_2, int_3);
   }

   public SpritePixels getPixels() {
      SpritePixels pixels = new SpritePixels(this.width, this.height);
      pixels.maxWidth = this.maxWidth;
      pixels.maxHeight = this.maxHeight;
      pixels.offsetX = this.maxWidth - this.width - this.offsetX;
      pixels.offsetY = this.offsetY;

      for (int x = 0; x < this.height; x++) {
         for (int y = 0; y < this.width; y++) {
            pixels.pixels[y + x * this.width] = this.pixels[x * this.width + this.width - 1 - y];
         }
      }

      return pixels;
   }

   public void drawImage(int x, int y, int alpha) {
      x += this.offsetX;
      y += this.offsetY;
      int graphicsOffset = x + y * Rasterizer2D.graphicsPixelsWidth;
      int pixelOffset = 0;
      int imageHeight = this.height;
      int imageWidth = this.width;
      int deviation = Rasterizer2D.graphicsPixelsWidth - imageWidth;
      int originalDeviation = 0;
      int offset;
      if (y < Rasterizer2D.drawingAreaTop) {
         offset = Rasterizer2D.drawingAreaTop - y;
         imageHeight -= offset;
         y = Rasterizer2D.drawingAreaTop;
         pixelOffset += offset * imageWidth;
         graphicsOffset += offset * Rasterizer2D.graphicsPixelsWidth;
      }

      if (imageHeight + y > Rasterizer2D.drawingAreaRight) {
         imageHeight -= imageHeight + y - Rasterizer2D.drawingAreaRight;
      }

      if (x < Rasterizer2D.draw_region_x) {
         offset = Rasterizer2D.draw_region_x - x;
         imageWidth -= offset;
         x = Rasterizer2D.draw_region_x;
         pixelOffset += offset;
         graphicsOffset += offset;
         originalDeviation += offset;
         deviation += offset;
      }

      if (imageWidth + x > Rasterizer2D.drawingAreaBottom) {
         offset = imageWidth + x - Rasterizer2D.drawingAreaBottom;
         imageWidth -= offset;
         originalDeviation += offset;
         deviation += offset;
      }

      if (imageWidth > 0 && imageHeight > 0) {
         copyPixelsAlpha(Rasterizer2D.graphicsPixels, this.pixels, 0, pixelOffset, graphicsOffset, imageWidth, imageHeight, deviation, originalDeviation, alpha);
      }
   }

   public void method996(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int[] ints_0, int[] ints_1) {
      int int_6 = int_1 < 0 ? -int_1 : 0;
      int int_7 = int_1 + this.height <= int_5 ? this.height : int_5 - int_1;
      int int_8 = int_0 < 0 ? -int_0 : 0;
      int int_13;
      if (this.width + int_0 <= int_4) {
         int_13 = this.width;
      } else {
         int_13 = int_4 - int_0;
      }

      int int_10 = int_2 + int_8 + (int_6 + int_1 + int_3) * Rasterizer2D.graphicsPixelsWidth + int_0;
      int int_11 = int_6 + int_1;

      for (int int_12 = int_6; int_12 < int_7; int_12++) {
         int int_14 = ints_0[int_11];
         int int_15 = ints_1[int_11++];
         int int_16 = int_10;
         int int_17;
         if (int_0 < int_14) {
            int_17 = int_14 - int_0;
            int_16 = int_10 + (int_17 - int_8);
         } else {
            int_17 = int_8;
         }

         int int_9;
         if (this.width + int_0 <= int_14 + int_15) {
            int_9 = this.width;
         } else {
            int_9 = int_14 + int_15 - int_0;
         }

         for (int int_18 = int_17; int_18 < int_9; int_18++) {
            int int_19 = this.pixels[int_18 + int_12 * this.width];
            if (int_19 != 0) {
               Rasterizer2D.graphicsPixels[int_16++] = int_19;
            } else {
               ++int_16;
            }
         }

         int_10 += Rasterizer2D.graphicsPixelsWidth;
      }
   }

   public void rotate(int x, int y, int imgWidth, int imgHeight, int centreX, int centreY, double angle, int hypotenuse) {
      try {
         int negCentreX = -imgWidth / 2;
         int negCenterY = -imgHeight / 2;
         int sine = (int)(Math.sin(angle) * 65536.0D);
         int cosine = (int)(Math.cos(angle) * 65536.0D);
         sine = sine * hypotenuse >> 8;
         cosine = cosine * hypotenuse >> 8;
         int cosine_2 = negCenterY * sine + negCentreX * cosine + (centreX << 16);
         int sine_2 = negCenterY * cosine - negCentreX * sine + (centreY << 16);
         int baseOffset = x + y * Rasterizer2D.graphicsPixelsWidth;

         for (y = 0; y < imgHeight; y++) {
            int offset = baseOffset;
            int dX = cosine_2;
            int dY = sine_2;

            for (x = -imgWidth; x < 0; x++) {
               int value = this.pixels[this.width * (dY >> 16) + (dX >> 16)];
               if (value != 0) {
                  Rasterizer2D.graphicsPixels[offset++] = value;
               } else {
                  ++offset;
               }

               dX += cosine;
               dY -= sine;
            }

            cosine_2 += sine;
            sine_2 += cosine;
            baseOffset += Rasterizer2D.graphicsPixelsWidth;
         }
      } catch (Exception exception_0) {
         ;
      }

   }

   public void drawImage(int x, int y, int alpha, int colour) {
      if (alpha == 256) {
         this.drawAt(x, y);
      } else {
         x += this.offsetX;
         y += this.offsetY;
         int graphicsPixel = x + y * Rasterizer2D.graphicsPixelsWidth;
         int pixelOffset = 0;
         int imageHeight = this.height;
         int imageWidth = this.width;
         int deviation = Rasterizer2D.graphicsPixelsWidth - imageWidth;
         int originalDeviation = 0;
         int offset;
         if (y < Rasterizer2D.drawingAreaTop) {
            offset = Rasterizer2D.drawingAreaTop - y;
            imageHeight -= offset;
            y = Rasterizer2D.drawingAreaTop;
            pixelOffset += offset * imageWidth;
            graphicsPixel += offset * Rasterizer2D.graphicsPixelsWidth;
         }

         if (imageHeight + y > Rasterizer2D.drawingAreaRight) {
            imageHeight -= imageHeight + y - Rasterizer2D.drawingAreaRight;
         }

         if (x < Rasterizer2D.draw_region_x) {
            offset = Rasterizer2D.draw_region_x - x;
            imageWidth -= offset;
            x = Rasterizer2D.draw_region_x;
            pixelOffset += offset;
            graphicsPixel += offset;
            originalDeviation += offset;
            deviation += offset;
         }

         if (imageWidth + x > Rasterizer2D.drawingAreaBottom) {
            offset = imageWidth + x - Rasterizer2D.drawingAreaBottom;
            imageWidth -= offset;
            originalDeviation += offset;
            deviation += offset;
         }

         if (imageWidth > 0 && imageHeight > 0) {
            copyPixelsAlphaRGB(Rasterizer2D.graphicsPixels, this.pixels, 0, pixelOffset, graphicsPixel, imageWidth, imageHeight, deviation, originalDeviation, alpha, colour);
         }
      }
   }

   static void copyPixels(int[] graphicsPixels, int[] pixels, int pixel, int graphicsPixel, int width, int height, int graphicsPixelOffset, int pixelOffset) {
      for (int heightCounter = -height; heightCounter < 0; heightCounter++) {
         int widthCounter;
         for (widthCounter = graphicsPixel + width - 3; graphicsPixel < widthCounter; graphicsPixels[graphicsPixel++] = pixels[pixel++]) {
            graphicsPixels[graphicsPixel++] = pixels[pixel++];
            graphicsPixels[graphicsPixel++] = pixels[pixel++];
            graphicsPixels[graphicsPixel++] = pixels[pixel++];
         }

         for (widthCounter += 3; graphicsPixel < widthCounter; graphicsPixels[graphicsPixel++] = pixels[pixel++]) {
            ;
         }

         graphicsPixel += graphicsPixelOffset;
         pixel += pixelOffset;
      }
   }

   static void copyPixelsAlpha(int[] graphicsPixels, int[] pixels, int colour, int pixelOffset, int graphicsOfset, int imgWidth, int imgHeight, int deviation, int originalDeviation, int alpha) {
      int alphaValue = 256 - alpha;

      for (int heightCounter = -imgHeight; heightCounter < 0; heightCounter++) {
         for (int widthCounter = -imgWidth; widthCounter < 0; widthCounter++) {
            colour = pixels[pixelOffset++];
            if (colour != 0) {
               int graphicsPixelColour = graphicsPixels[graphicsOfset];
               graphicsPixels[graphicsOfset++] = ((graphicsPixelColour & 0xFF00FF) * alphaValue + alpha * (colour & 0xFF00FF) & 0xFF00FF00) + ((colour & 0xFF00) * alpha + alphaValue * (graphicsPixelColour & 0xFF00) & 0xFF0000) >> 8;
            } else {
               ++graphicsOfset;
            }
         }

         graphicsOfset += deviation;
         pixelOffset += originalDeviation;
      }
   }

   static void shapeImageToPixels(int[] graphicsPixels, int[] pixels, int colour, int pixelOffset, int graphicsOffset, int imgWidth, int imageHeight, int deviation, int originalDeviation) {
      int newWidth = -(imgWidth >> 2);
      imgWidth = -(imgWidth & 0x3);

      for (int heightCounter = -imageHeight; heightCounter < 0; heightCounter++) {
         int widthCounter;
         for (widthCounter = newWidth; widthCounter < 0; widthCounter++) {
            colour = pixels[pixelOffset++];
            if (colour != 0) {
               graphicsPixels[graphicsOffset++] = colour;
            } else {
               ++graphicsOffset;
            }

            colour = pixels[pixelOffset++];
            if (colour != 0) {
               graphicsPixels[graphicsOffset++] = colour;
            } else {
               ++graphicsOffset;
            }

            colour = pixels[pixelOffset++];
            if (colour != 0) {
               graphicsPixels[graphicsOffset++] = colour;
            } else {
               ++graphicsOffset;
            }

            colour = pixels[pixelOffset++];
            if (colour != 0) {
               graphicsPixels[graphicsOffset++] = colour;
            } else {
               ++graphicsOffset;
            }
         }

         for (widthCounter = imgWidth; widthCounter < 0; widthCounter++) {
            colour = pixels[pixelOffset++];
            if (colour != 0) {
               graphicsPixels[graphicsOffset++] = colour;
            } else {
               ++graphicsOffset;
            }
         }

         graphicsOffset += deviation;
         pixelOffset += originalDeviation;
      }
   }

   static void copyPixelsAlphaRGB(int[] graphicsPixels, int[] pixels, int colour, int pixelOffset, int graphicsOffset, int imgWidth, int imgHeight, int deviation, int originalDeviation, int alpha, int newColour) {
      int alphaValue = 256 - alpha;
      int int_10 = (newColour & 0xFF00FF) * alphaValue & 0xFF00FF00;
      int int_11 = (newColour & 0xFF00) * alphaValue & 0xFF0000;
      newColour = (int_10 | int_11) >>> 8;

      for (int heightCounter = -imgHeight; heightCounter < 0; heightCounter++) {
         for (int widthCounter = -imgWidth; widthCounter < 0; widthCounter++) {
            colour = pixels[pixelOffset++];
            if (colour != 0) {
               int_10 = alpha * (colour & 0xFF00FF) & 0xFF00FF00;
               int_11 = (colour & 0xFF00) * alpha & 0xFF0000;
               graphicsPixels[graphicsOffset++] = newColour + ((int_10 | int_11) >>> 8);
            } else {
               ++graphicsOffset;
            }
         }

         graphicsOffset += deviation;
         pixelOffset += originalDeviation;
      }

   }

   static void method1003(int[] graphicsPixels, int[] pixels, int colour, int baseX, int baseY, int graphicsOffset, int int_4, int imgWidth, int imgHeight, int int_7, int int_8, int width, int alpha) {
      int alphaValue = 256 - alpha;
      int originalX = baseX;

      for (int heightCount = -imgHeight; heightCount < 0; heightCount++) {
         int y = width * (baseY >> 16);
         for (int widthCounter = -imgWidth; widthCounter < 0; widthCounter++) {
            colour = pixels[(baseX >> 16) + y];
            if (colour != 0) {
               int graphicsPixelColour = graphicsPixels[graphicsOffset];
               graphicsPixels[graphicsOffset++] = ((colour & 0xFF00) * alpha + alphaValue * (graphicsPixelColour & 0xFF00) & 0xFF0000) + ((graphicsPixelColour & 0xFF00FF) * alphaValue + alpha * (colour & 0xFF00FF) & 0xFF00FF00) >> 8;
            } else {
               ++graphicsOffset;
            }

            baseX += int_7;
         }

         baseY += int_8;
         baseX = originalX;
         graphicsOffset += int_4;
      }

   }

   static void method1004(int[] graphicsPixels, int[] pixels, int colour, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8, int int_9) {
      int int_10 = int_1;

      for (int int_11 = -int_6; int_11 < 0; int_11++) {
         int int_12 = int_9 * (int_2 >> 16);

         for (int int_13 = -int_5; int_13 < 0; int_13++) {
            colour = pixels[(int_1 >> 16) + int_12];
            if (colour != 0) {
               graphicsPixels[int_3++] = colour;
            } else {
               ++int_3;
            }

            int_1 += int_7;
         }

         int_2 += int_8;
         int_1 = int_10;
         int_3 += int_4;
      }

   }

}
