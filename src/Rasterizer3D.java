public class Rasterizer3D extends Rasterizer2D {

   static boolean restrictEdges;
   static int centerX;
   static int centerY;
   static int alpha;
   static boolean aBool72;
   static boolean lowMem;
   public static boolean rasterGouraudLowRes;
   public static int[] SINE;
   public static int[] COSINE;
   public static int anInt543;
   static int[] rasterClipY;
   public static int[] colourPalette;
   static int[] anIntArray113;
   public static ITextureLoader textureLoader;
   static int[] anIntArray114;
   static int anInt544;
   static int anInt545;
   static int anInt546;
   static int rasterClipX;
   static int anInt547;
   static int graphicsPixelsBottomY;

   static {
      restrictEdges = false;
      aBool72 = false;
      lowMem = false;
      rasterGouraudLowRes = true;
      alpha = 0;
      anInt543 = 512;
      rasterClipY = new int[1024];
      colourPalette = new int[65536];
      anIntArray113 = new int[512];
      anIntArray114 = new int[2048];
      SINE = new int[2048];
      COSINE = new int[2048];

      int int_0;
      for (int_0 = 1; int_0 < 512; int_0++) {
         anIntArray113[int_0] = 32768 / int_0;
      }

      for (int_0 = 1; int_0 < 2048; int_0++) {
         anIntArray114[int_0] = 65536 / int_0;
      }

      for (int_0 = 0; int_0 < 2048; int_0++) {
         SINE[int_0] = (int)(65536.0D * Math.sin((double)int_0 * 0.0030679615D));
         COSINE[int_0] = (int)(65536.0D * Math.cos((double)int_0 * 0.0030679615D));
      }

   }

   static int method958(int int_0, int int_1, int int_2, int int_3) {
      return int_0 * int_2 + int_3 * int_1 >> 16;
   }

   static int method959(int int_0, int int_1, int int_2, int int_3) {
      return int_2 * int_1 - int_3 * int_0 >> 16;
   }

   static int adjustBrightness(int rgb, double intensity) {
      double r = (double)(rgb >> 16) / 256.0D;
      double g = (double)(rgb >> 8 & 0xFF) / 256.0D;
      double b = (double)(rgb & 0xFF) / 256.0D;
      r = Math.pow(r, intensity);
      g = Math.pow(g, intensity);
      b = Math.pow(b, intensity);
      int red = (int)(r * 256.0D);
      int green = (int)(g * 256.0D);
      int blue = (int)(b * 256.0D);
      return blue + (green << 8) + (red << 16);
   }

   public static void drawFlatTriangle(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6) {
      int int_7 = 0;
      if (int_0 != int_1) {
         int_7 = (int_4 - int_3 << 14) / (int_1 - int_0);
      }

      int int_8 = 0;
      if (int_2 != int_1) {
         int_8 = (int_5 - int_4 << 14) / (int_2 - int_1);
      }

      int int_9 = 0;
      if (int_0 != int_2) {
         int_9 = (int_3 - int_5 << 14) / (int_0 - int_2);
      }

      if (int_0 <= int_1 && int_0 <= int_2) {
         if (int_0 < graphicsPixelsBottomY) {
            if (int_1 > graphicsPixelsBottomY) {
               int_1 = graphicsPixelsBottomY;
            }

            if (int_2 > graphicsPixelsBottomY) {
               int_2 = graphicsPixelsBottomY;
            }

            if (int_1 < int_2) {
               int_5 = int_3 <<= 14;
               if (int_0 < 0) {
                  int_5 -= int_0 * int_9;
                  int_3 -= int_0 * int_7;
                  int_0 = 0;
               }

               int_4 <<= 14;
               if (int_1 < 0) {
                  int_4 -= int_8 * int_1;
                  int_1 = 0;
               }

               if (int_0 != int_1 && int_9 < int_7 || int_0 == int_1 && int_9 > int_8) {
                  int_2 -= int_1;
                  int_1 -= int_0;
                  int_0 = rasterClipY[int_0];

                  while (true) {
                     --int_1;
                     if (int_1 < 0) {
                        while (true) {
                           --int_2;
                           if (int_2 < 0) {
                              return;
                           }

                           method962(Rasterizer2D.graphicsPixels, int_0, int_6, 0, int_5 >> 14, int_4 >> 14);
                           int_5 += int_9;
                           int_4 += int_8;
                           int_0 += Rasterizer2D.graphicsPixelsWidth;
                        }
                     }

                     method962(Rasterizer2D.graphicsPixels, int_0, int_6, 0, int_5 >> 14, int_3 >> 14);
                     int_5 += int_9;
                     int_3 += int_7;
                     int_0 += Rasterizer2D.graphicsPixelsWidth;
                  }
               } else {
                  int_2 -= int_1;
                  int_1 -= int_0;
                  int_0 = rasterClipY[int_0];

                  while (true) {
                     --int_1;
                     if (int_1 < 0) {
                        while (true) {
                           --int_2;
                           if (int_2 < 0) {
                              return;
                           }

                           method962(Rasterizer2D.graphicsPixels, int_0, int_6, 0, int_4 >> 14, int_5 >> 14);
                           int_5 += int_9;
                           int_4 += int_8;
                           int_0 += Rasterizer2D.graphicsPixelsWidth;
                        }
                     }

                     method962(Rasterizer2D.graphicsPixels, int_0, int_6, 0, int_3 >> 14, int_5 >> 14);
                     int_5 += int_9;
                     int_3 += int_7;
                     int_0 += Rasterizer2D.graphicsPixelsWidth;
                  }
               }
            } else {
               int_4 = int_3 <<= 14;
               if (int_0 < 0) {
                  int_4 -= int_0 * int_9;
                  int_3 -= int_0 * int_7;
                  int_0 = 0;
               }

               int_5 <<= 14;
               if (int_2 < 0) {
                  int_5 -= int_8 * int_2;
                  int_2 = 0;
               }

               if ((int_0 == int_2 || int_9 >= int_7) && (int_0 != int_2 || int_8 <= int_7)) {
                  int_1 -= int_2;
                  int_2 -= int_0;
                  int_0 = rasterClipY[int_0];

                  while (true) {
                     --int_2;
                     if (int_2 < 0) {
                        while (true) {
                           --int_1;
                           if (int_1 < 0) {
                              return;
                           }

                           method962(Rasterizer2D.graphicsPixels, int_0, int_6, 0, int_3 >> 14, int_5 >> 14);
                           int_5 += int_8;
                           int_3 += int_7;
                           int_0 += Rasterizer2D.graphicsPixelsWidth;
                        }
                     }

                     method962(Rasterizer2D.graphicsPixels, int_0, int_6, 0, int_3 >> 14, int_4 >> 14);
                     int_4 += int_9;
                     int_3 += int_7;
                     int_0 += Rasterizer2D.graphicsPixelsWidth;
                  }
               } else {
                  int_1 -= int_2;
                  int_2 -= int_0;
                  int_0 = rasterClipY[int_0];

                  while (true) {
                     --int_2;
                     if (int_2 < 0) {
                        while (true) {
                           --int_1;
                           if (int_1 < 0) {
                              return;
                           }

                           method962(Rasterizer2D.graphicsPixels, int_0, int_6, 0, int_5 >> 14, int_3 >> 14);
                           int_5 += int_8;
                           int_3 += int_7;
                           int_0 += Rasterizer2D.graphicsPixelsWidth;
                        }
                     }

                     method962(Rasterizer2D.graphicsPixels, int_0, int_6, 0, int_4 >> 14, int_3 >> 14);
                     int_4 += int_9;
                     int_3 += int_7;
                     int_0 += Rasterizer2D.graphicsPixelsWidth;
                  }
               }
            }
         }
      } else if (int_1 <= int_2) {
         if (int_1 < graphicsPixelsBottomY) {
            if (int_2 > graphicsPixelsBottomY) {
               int_2 = graphicsPixelsBottomY;
            }

            if (int_0 > graphicsPixelsBottomY) {
               int_0 = graphicsPixelsBottomY;
            }

            if (int_2 < int_0) {
               int_3 = int_4 <<= 14;
               if (int_1 < 0) {
                  int_3 -= int_7 * int_1;
                  int_4 -= int_8 * int_1;
                  int_1 = 0;
               }

               int_5 <<= 14;
               if (int_2 < 0) {
                  int_5 -= int_9 * int_2;
                  int_2 = 0;
               }

               if (int_2 != int_1 && int_7 < int_8 || int_2 == int_1 && int_7 > int_9) {
                  int_0 -= int_2;
                  int_2 -= int_1;
                  int_1 = rasterClipY[int_1];

                  while (true) {
                     --int_2;
                     if (int_2 < 0) {
                        while (true) {
                           --int_0;
                           if (int_0 < 0) {
                              return;
                           }

                           method962(Rasterizer2D.graphicsPixels, int_1, int_6, 0, int_3 >> 14, int_5 >> 14);
                           int_3 += int_7;
                           int_5 += int_9;
                           int_1 += Rasterizer2D.graphicsPixelsWidth;
                        }
                     }

                     method962(Rasterizer2D.graphicsPixels, int_1, int_6, 0, int_3 >> 14, int_4 >> 14);
                     int_3 += int_7;
                     int_4 += int_8;
                     int_1 += Rasterizer2D.graphicsPixelsWidth;
                  }
               } else {
                  int_0 -= int_2;
                  int_2 -= int_1;
                  int_1 = rasterClipY[int_1];

                  while (true) {
                     --int_2;
                     if (int_2 < 0) {
                        while (true) {
                           --int_0;
                           if (int_0 < 0) {
                              return;
                           }

                           method962(Rasterizer2D.graphicsPixels, int_1, int_6, 0, int_5 >> 14, int_3 >> 14);
                           int_3 += int_7;
                           int_5 += int_9;
                           int_1 += Rasterizer2D.graphicsPixelsWidth;
                        }
                     }

                     method962(Rasterizer2D.graphicsPixels, int_1, int_6, 0, int_4 >> 14, int_3 >> 14);
                     int_3 += int_7;
                     int_4 += int_8;
                     int_1 += Rasterizer2D.graphicsPixelsWidth;
                  }
               }
            } else {
               int_5 = int_4 <<= 14;
               if (int_1 < 0) {
                  int_5 -= int_7 * int_1;
                  int_4 -= int_8 * int_1;
                  int_1 = 0;
               }

               int_3 <<= 14;
               if (int_0 < 0) {
                  int_3 -= int_0 * int_9;
                  int_0 = 0;
               }

               if (int_7 < int_8) {
                  int_2 -= int_0;
                  int_0 -= int_1;
                  int_1 = rasterClipY[int_1];

                  while (true) {
                     --int_0;
                     if (int_0 < 0) {
                        while (true) {
                           --int_2;
                           if (int_2 < 0) {
                              return;
                           }

                           method962(Rasterizer2D.graphicsPixels, int_1, int_6, 0, int_3 >> 14, int_4 >> 14);
                           int_3 += int_9;
                           int_4 += int_8;
                           int_1 += Rasterizer2D.graphicsPixelsWidth;
                        }
                     }

                     method962(Rasterizer2D.graphicsPixels, int_1, int_6, 0, int_5 >> 14, int_4 >> 14);
                     int_5 += int_7;
                     int_4 += int_8;
                     int_1 += Rasterizer2D.graphicsPixelsWidth;
                  }
               } else {
                  int_2 -= int_0;
                  int_0 -= int_1;
                  int_1 = rasterClipY[int_1];

                  while (true) {
                     --int_0;
                     if (int_0 < 0) {
                        while (true) {
                           --int_2;
                           if (int_2 < 0) {
                              return;
                           }

                           method962(Rasterizer2D.graphicsPixels, int_1, int_6, 0, int_4 >> 14, int_3 >> 14);
                           int_3 += int_9;
                           int_4 += int_8;
                           int_1 += Rasterizer2D.graphicsPixelsWidth;
                        }
                     }

                     method962(Rasterizer2D.graphicsPixels, int_1, int_6, 0, int_4 >> 14, int_5 >> 14);
                     int_5 += int_7;
                     int_4 += int_8;
                     int_1 += Rasterizer2D.graphicsPixelsWidth;
                  }
               }
            }
         }
      } else if (int_2 < graphicsPixelsBottomY) {
         if (int_0 > graphicsPixelsBottomY) {
            int_0 = graphicsPixelsBottomY;
         }

         if (int_1 > graphicsPixelsBottomY) {
            int_1 = graphicsPixelsBottomY;
         }

         if (int_0 < int_1) {
            int_4 = int_5 <<= 14;
            if (int_2 < 0) {
               int_4 -= int_8 * int_2;
               int_5 -= int_9 * int_2;
               int_2 = 0;
            }

            int_3 <<= 14;
            if (int_0 < 0) {
               int_3 -= int_0 * int_7;
               int_0 = 0;
            }

            if (int_8 < int_9) {
               int_1 -= int_0;
               int_0 -= int_2;
               int_2 = rasterClipY[int_2];

               while (true) {
                  --int_0;
                  if (int_0 < 0) {
                     while (true) {
                        --int_1;
                        if (int_1 < 0) {
                           return;
                        }

                        method962(Rasterizer2D.graphicsPixels, int_2, int_6, 0, int_4 >> 14, int_3 >> 14);
                        int_4 += int_8;
                        int_3 += int_7;
                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                     }
                  }

                  method962(Rasterizer2D.graphicsPixels, int_2, int_6, 0, int_4 >> 14, int_5 >> 14);
                  int_4 += int_8;
                  int_5 += int_9;
                  int_2 += Rasterizer2D.graphicsPixelsWidth;
               }
            } else {
               int_1 -= int_0;
               int_0 -= int_2;
               int_2 = rasterClipY[int_2];

               while (true) {
                  --int_0;
                  if (int_0 < 0) {
                     while (true) {
                        --int_1;
                        if (int_1 < 0) {
                           return;
                        }

                        method962(Rasterizer2D.graphicsPixels, int_2, int_6, 0, int_3 >> 14, int_4 >> 14);
                        int_4 += int_8;
                        int_3 += int_7;
                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                     }
                  }

                  method962(Rasterizer2D.graphicsPixels, int_2, int_6, 0, int_5 >> 14, int_4 >> 14);
                  int_4 += int_8;
                  int_5 += int_9;
                  int_2 += Rasterizer2D.graphicsPixelsWidth;
               }
            }
         } else {
            int_3 = int_5 <<= 14;
            if (int_2 < 0) {
               int_3 -= int_8 * int_2;
               int_5 -= int_9 * int_2;
               int_2 = 0;
            }

            int_4 <<= 14;
            if (int_1 < 0) {
               int_4 -= int_7 * int_1;
               int_1 = 0;
            }

            if (int_8 < int_9) {
               int_0 -= int_1;
               int_1 -= int_2;
               int_2 = rasterClipY[int_2];

               while (true) {
                  --int_1;
                  if (int_1 < 0) {
                     while (true) {
                        --int_0;
                        if (int_0 < 0) {
                           return;
                        }

                        method962(Rasterizer2D.graphicsPixels, int_2, int_6, 0, int_4 >> 14, int_5 >> 14);
                        int_4 += int_7;
                        int_5 += int_9;
                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                     }
                  }

                  method962(Rasterizer2D.graphicsPixels, int_2, int_6, 0, int_3 >> 14, int_5 >> 14);
                  int_3 += int_8;
                  int_5 += int_9;
                  int_2 += Rasterizer2D.graphicsPixelsWidth;
               }
            } else {
               int_0 -= int_1;
               int_1 -= int_2;
               int_2 = rasterClipY[int_2];

               while (true) {
                  --int_1;
                  if (int_1 < 0) {
                     while (true) {
                        --int_0;
                        if (int_0 < 0) {
                           return;
                        }

                        method962(Rasterizer2D.graphicsPixels, int_2, int_6, 0, int_5 >> 14, int_4 >> 14);
                        int_4 += int_7;
                        int_5 += int_9;
                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                     }
                  }

                  method962(Rasterizer2D.graphicsPixels, int_2, int_6, 0, int_5 >> 14, int_3 >> 14);
                  int_3 += int_8;
                  int_5 += int_9;
                  int_2 += Rasterizer2D.graphicsPixelsWidth;
               }
            }
         }
      }
   }

   static void drawShadedTriangle(int int_0, int triangleScreenY_A, int triangleScreenY_B, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8) {
      int int_9 = int_4 - int_3;
      int int_10 = triangleScreenY_A - int_0;
      int int_11 = int_5 - int_3;
      int int_12 = triangleScreenY_B - int_0;
      int int_13 = int_7 - int_6;
      int int_14 = int_8 - int_6;
      int z_a_off;
      if (triangleScreenY_B != triangleScreenY_A) {
         z_a_off = (int_5 - int_4 << 14) / (triangleScreenY_B - triangleScreenY_A);
      } else {
         z_a_off = 0;
      }

      int int_16;
      if (int_0 != triangleScreenY_A) {
         int_16 = (int_9 << 14) / int_10;
      } else {
         int_16 = 0;
      }

      int int_17;
      if (int_0 != triangleScreenY_B) {
         int_17 = (int_11 << 14) / int_12;
      } else {
         int_17 = 0;
      }

      int int_18 = int_9 * int_12 - int_11 * int_10;
      if (int_18 != 0) {
         int int_19 = (int_13 * int_12 - int_14 * int_10 << 8) / int_18;
         int int_20 = (int_14 * int_9 - int_13 * int_11 << 8) / int_18;
         if (int_0 <= triangleScreenY_A && int_0 <= triangleScreenY_B) {
            if (int_0 < graphicsPixelsBottomY) {
               if (triangleScreenY_A > graphicsPixelsBottomY) {
                  triangleScreenY_A = graphicsPixelsBottomY;
               }

               if (triangleScreenY_B > graphicsPixelsBottomY) {
                  triangleScreenY_B = graphicsPixelsBottomY;
               }

               int_6 = int_19 + ((int_6 << 8) - int_3 * int_19);
               if (triangleScreenY_A < triangleScreenY_B) {
                  int_5 = int_3 <<= 14;
                  if (int_0 < 0) {
                     int_5 -= int_0 * int_17;
                     int_3 -= int_0 * int_16;
                     int_6 -= int_0 * int_20;
                     int_0 = 0;
                  }

                  int_4 <<= 14;
                  if (triangleScreenY_A < 0) {
                     int_4 -= z_a_off * triangleScreenY_A;
                     triangleScreenY_A = 0;
                  }

                  if (int_0 != triangleScreenY_A && int_17 < int_16 || int_0 == triangleScreenY_A && int_17 > z_a_off) {
                     triangleScreenY_B -= triangleScreenY_A;
                     triangleScreenY_A -= int_0;
                     int_0 = rasterClipY[int_0];

                     while (true) {
                        --triangleScreenY_A;
                        if (triangleScreenY_A < 0) {
                           while (true) {
                              --triangleScreenY_B;
                              if (triangleScreenY_B < 0) {
                                 return;
                              }

                              drawShadedLine(Rasterizer2D.graphicsPixels, int_0, 0, 0, int_5 >> 14, int_4 >> 14, int_6, int_19);
                              int_5 += int_17;
                              int_4 += z_a_off;
                              int_6 += int_20;
                              int_0 += Rasterizer2D.graphicsPixelsWidth;
                           }
                        }

                        drawShadedLine(Rasterizer2D.graphicsPixels, int_0, 0, 0, int_5 >> 14, int_3 >> 14, int_6, int_19);
                        int_5 += int_17;
                        int_3 += int_16;
                        int_6 += int_20;
                        int_0 += Rasterizer2D.graphicsPixelsWidth;
                     }
                  } else {
                     triangleScreenY_B -= triangleScreenY_A;
                     triangleScreenY_A -= int_0;
                     int_0 = rasterClipY[int_0];

                     while (true) {
                        --triangleScreenY_A;
                        if (triangleScreenY_A < 0) {
                           while (true) {
                              --triangleScreenY_B;
                              if (triangleScreenY_B < 0) {
                                 return;
                              }

                              drawShadedLine(Rasterizer2D.graphicsPixels, int_0, 0, 0, int_4 >> 14, int_5 >> 14, int_6, int_19);
                              int_5 += int_17;
                              int_4 += z_a_off;
                              int_6 += int_20;
                              int_0 += Rasterizer2D.graphicsPixelsWidth;
                           }
                        }

                        drawShadedLine(Rasterizer2D.graphicsPixels, int_0, 0, 0, int_3 >> 14, int_5 >> 14, int_6, int_19);
                        int_5 += int_17;
                        int_3 += int_16;
                        int_6 += int_20;
                        int_0 += Rasterizer2D.graphicsPixelsWidth;
                     }
                  }
               } else {
                  int_4 = int_3 <<= 14;
                  if (int_0 < 0) {
                     int_4 -= int_0 * int_17;
                     int_3 -= int_0 * int_16;
                     int_6 -= int_0 * int_20;
                     int_0 = 0;
                  }

                  int_5 <<= 14;
                  if (triangleScreenY_B < 0) {
                     int_5 -= z_a_off * triangleScreenY_B;
                     triangleScreenY_B = 0;
                  }

                  if ((int_0 == triangleScreenY_B || int_17 >= int_16) && (int_0 != triangleScreenY_B || z_a_off <= int_16)) {
                     triangleScreenY_A -= triangleScreenY_B;
                     triangleScreenY_B -= int_0;
                     int_0 = rasterClipY[int_0];

                     while (true) {
                        --triangleScreenY_B;
                        if (triangleScreenY_B < 0) {
                           while (true) {
                              --triangleScreenY_A;
                              if (triangleScreenY_A < 0) {
                                 return;
                              }

                              drawShadedLine(Rasterizer2D.graphicsPixels, int_0, 0, 0, int_3 >> 14, int_5 >> 14, int_6, int_19);
                              int_5 += z_a_off;
                              int_3 += int_16;
                              int_6 += int_20;
                              int_0 += Rasterizer2D.graphicsPixelsWidth;
                           }
                        }

                        drawShadedLine(Rasterizer2D.graphicsPixels, int_0, 0, 0, int_3 >> 14, int_4 >> 14, int_6, int_19);
                        int_4 += int_17;
                        int_3 += int_16;
                        int_6 += int_20;
                        int_0 += Rasterizer2D.graphicsPixelsWidth;
                     }
                  } else {
                     triangleScreenY_A -= triangleScreenY_B;
                     triangleScreenY_B -= int_0;
                     int_0 = rasterClipY[int_0];

                     while (true) {
                        --triangleScreenY_B;
                        if (triangleScreenY_B < 0) {
                           while (true) {
                              --triangleScreenY_A;
                              if (triangleScreenY_A < 0) {
                                 return;
                              }

                              drawShadedLine(Rasterizer2D.graphicsPixels, int_0, 0, 0, int_5 >> 14, int_3 >> 14, int_6, int_19);
                              int_5 += z_a_off;
                              int_3 += int_16;
                              int_6 += int_20;
                              int_0 += Rasterizer2D.graphicsPixelsWidth;
                           }
                        }

                        drawShadedLine(Rasterizer2D.graphicsPixels, int_0, 0, 0, int_4 >> 14, int_3 >> 14, int_6, int_19);
                        int_4 += int_17;
                        int_3 += int_16;
                        int_6 += int_20;
                        int_0 += Rasterizer2D.graphicsPixelsWidth;
                     }
                  }
               }
            }
         } else if (triangleScreenY_A <= triangleScreenY_B) {
            if (triangleScreenY_A < graphicsPixelsBottomY) {
               if (triangleScreenY_B > graphicsPixelsBottomY) {
                  triangleScreenY_B = graphicsPixelsBottomY;
               }

               if (int_0 > graphicsPixelsBottomY) {
                  int_0 = graphicsPixelsBottomY;
               }

               int_7 = int_19 + ((int_7 << 8) - int_19 * int_4);
               if (triangleScreenY_B < int_0) {
                  int_3 = int_4 <<= 14;
                  if (triangleScreenY_A < 0) {
                     int_3 -= int_16 * triangleScreenY_A;
                     int_4 -= z_a_off * triangleScreenY_A;
                     int_7 -= int_20 * triangleScreenY_A;
                     triangleScreenY_A = 0;
                  }

                  int_5 <<= 14;
                  if (triangleScreenY_B < 0) {
                     int_5 -= int_17 * triangleScreenY_B;
                     triangleScreenY_B = 0;
                  }

                  if (triangleScreenY_B != triangleScreenY_A && int_16 < z_a_off || triangleScreenY_B == triangleScreenY_A && int_16 > int_17) {
                     int_0 -= triangleScreenY_B;
                     triangleScreenY_B -= triangleScreenY_A;
                     triangleScreenY_A = rasterClipY[triangleScreenY_A];

                     while (true) {
                        --triangleScreenY_B;
                        if (triangleScreenY_B < 0) {
                           while (true) {
                              --int_0;
                              if (int_0 < 0) {
                                 return;
                              }

                              drawShadedLine(Rasterizer2D.graphicsPixels, triangleScreenY_A, 0, 0, int_3 >> 14, int_5 >> 14, int_7, int_19);
                              int_3 += int_16;
                              int_5 += int_17;
                              int_7 += int_20;
                              triangleScreenY_A += Rasterizer2D.graphicsPixelsWidth;
                           }
                        }

                        drawShadedLine(Rasterizer2D.graphicsPixels, triangleScreenY_A, 0, 0, int_3 >> 14, int_4 >> 14, int_7, int_19);
                        int_3 += int_16;
                        int_4 += z_a_off;
                        int_7 += int_20;
                        triangleScreenY_A += Rasterizer2D.graphicsPixelsWidth;
                     }
                  } else {
                     int_0 -= triangleScreenY_B;
                     triangleScreenY_B -= triangleScreenY_A;
                     triangleScreenY_A = rasterClipY[triangleScreenY_A];

                     while (true) {
                        --triangleScreenY_B;
                        if (triangleScreenY_B < 0) {
                           while (true) {
                              --int_0;
                              if (int_0 < 0) {
                                 return;
                              }

                              drawShadedLine(Rasterizer2D.graphicsPixels, triangleScreenY_A, 0, 0, int_5 >> 14, int_3 >> 14, int_7, int_19);
                              int_3 += int_16;
                              int_5 += int_17;
                              int_7 += int_20;
                              triangleScreenY_A += Rasterizer2D.graphicsPixelsWidth;
                           }
                        }

                        drawShadedLine(Rasterizer2D.graphicsPixels, triangleScreenY_A, 0, 0, int_4 >> 14, int_3 >> 14, int_7, int_19);
                        int_3 += int_16;
                        int_4 += z_a_off;
                        int_7 += int_20;
                        triangleScreenY_A += Rasterizer2D.graphicsPixelsWidth;
                     }
                  }
               } else {
                  int_5 = int_4 <<= 14;
                  if (triangleScreenY_A < 0) {
                     int_5 -= int_16 * triangleScreenY_A;
                     int_4 -= z_a_off * triangleScreenY_A;
                     int_7 -= int_20 * triangleScreenY_A;
                     triangleScreenY_A = 0;
                  }

                  int_3 <<= 14;
                  if (int_0 < 0) {
                     int_3 -= int_0 * int_17;
                     int_0 = 0;
                  }

                  if (int_16 < z_a_off) {
                     triangleScreenY_B -= int_0;
                     int_0 -= triangleScreenY_A;
                     triangleScreenY_A = rasterClipY[triangleScreenY_A];

                     while (true) {
                        --int_0;
                        if (int_0 < 0) {
                           while (true) {
                              --triangleScreenY_B;
                              if (triangleScreenY_B < 0) {
                                 return;
                              }

                              drawShadedLine(Rasterizer2D.graphicsPixels, triangleScreenY_A, 0, 0, int_3 >> 14, int_4 >> 14, int_7, int_19);
                              int_3 += int_17;
                              int_4 += z_a_off;
                              int_7 += int_20;
                              triangleScreenY_A += Rasterizer2D.graphicsPixelsWidth;
                           }
                        }

                        drawShadedLine(Rasterizer2D.graphicsPixels, triangleScreenY_A, 0, 0, int_5 >> 14, int_4 >> 14, int_7, int_19);
                        int_5 += int_16;
                        int_4 += z_a_off;
                        int_7 += int_20;
                        triangleScreenY_A += Rasterizer2D.graphicsPixelsWidth;
                     }
                  } else {
                     triangleScreenY_B -= int_0;
                     int_0 -= triangleScreenY_A;
                     triangleScreenY_A = rasterClipY[triangleScreenY_A];

                     while (true) {
                        --int_0;
                        if (int_0 < 0) {
                           while (true) {
                              --triangleScreenY_B;
                              if (triangleScreenY_B < 0) {
                                 return;
                              }

                              drawShadedLine(Rasterizer2D.graphicsPixels, triangleScreenY_A, 0, 0, int_4 >> 14, int_3 >> 14, int_7, int_19);
                              int_3 += int_17;
                              int_4 += z_a_off;
                              int_7 += int_20;
                              triangleScreenY_A += Rasterizer2D.graphicsPixelsWidth;
                           }
                        }

                        drawShadedLine(Rasterizer2D.graphicsPixels, triangleScreenY_A, 0, 0, int_4 >> 14, int_5 >> 14, int_7, int_19);
                        int_5 += int_16;
                        int_4 += z_a_off;
                        int_7 += int_20;
                        triangleScreenY_A += Rasterizer2D.graphicsPixelsWidth;
                     }
                  }
               }
            }
         } else if (triangleScreenY_B < graphicsPixelsBottomY) {
            if (int_0 > graphicsPixelsBottomY) {
               int_0 = graphicsPixelsBottomY;
            }

            if (triangleScreenY_A > graphicsPixelsBottomY) {
               triangleScreenY_A = graphicsPixelsBottomY;
            }

            int_8 = int_19 + ((int_8 << 8) - int_5 * int_19);
            if (int_0 < triangleScreenY_A) {
               int_4 = int_5 <<= 14;
               if (triangleScreenY_B < 0) {
                  int_4 -= z_a_off * triangleScreenY_B;
                  int_5 -= int_17 * triangleScreenY_B;
                  int_8 -= int_20 * triangleScreenY_B;
                  triangleScreenY_B = 0;
               }

               int_3 <<= 14;
               if (int_0 < 0) {
                  int_3 -= int_0 * int_16;
                  int_0 = 0;
               }

               if (z_a_off < int_17) {
                  triangleScreenY_A -= int_0;
                  int_0 -= triangleScreenY_B;
                  triangleScreenY_B = rasterClipY[triangleScreenY_B];

                  while (true) {
                     --int_0;
                     if (int_0 < 0) {
                        while (true) {
                           --triangleScreenY_A;
                           if (triangleScreenY_A < 0) {
                              return;
                           }

                           drawShadedLine(Rasterizer2D.graphicsPixels, triangleScreenY_B, 0, 0, int_4 >> 14, int_3 >> 14, int_8, int_19);
                           int_4 += z_a_off;
                           int_3 += int_16;
                           int_8 += int_20;
                           triangleScreenY_B += Rasterizer2D.graphicsPixelsWidth;
                        }
                     }

                     drawShadedLine(Rasterizer2D.graphicsPixels, triangleScreenY_B, 0, 0, int_4 >> 14, int_5 >> 14, int_8, int_19);
                     int_4 += z_a_off;
                     int_5 += int_17;
                     int_8 += int_20;
                     triangleScreenY_B += Rasterizer2D.graphicsPixelsWidth;
                  }
               } else {
                  triangleScreenY_A -= int_0;
                  int_0 -= triangleScreenY_B;
                  triangleScreenY_B = rasterClipY[triangleScreenY_B];

                  while (true) {
                     --int_0;
                     if (int_0 < 0) {
                        while (true) {
                           --triangleScreenY_A;
                           if (triangleScreenY_A < 0) {
                              return;
                           }

                           drawShadedLine(Rasterizer2D.graphicsPixels, triangleScreenY_B, 0, 0, int_3 >> 14, int_4 >> 14, int_8, int_19);
                           int_4 += z_a_off;
                           int_3 += int_16;
                           int_8 += int_20;
                           triangleScreenY_B += Rasterizer2D.graphicsPixelsWidth;
                        }
                     }

                     drawShadedLine(Rasterizer2D.graphicsPixels, triangleScreenY_B, 0, 0, int_5 >> 14, int_4 >> 14, int_8, int_19);
                     int_4 += z_a_off;
                     int_5 += int_17;
                     int_8 += int_20;
                     triangleScreenY_B += Rasterizer2D.graphicsPixelsWidth;
                  }
               }
            } else {
               int_3 = int_5 <<= 14;
               if (triangleScreenY_B < 0) {
                  int_3 -= z_a_off * triangleScreenY_B;
                  int_5 -= int_17 * triangleScreenY_B;
                  int_8 -= int_20 * triangleScreenY_B;
                  triangleScreenY_B = 0;
               }

               int_4 <<= 14;
               if (triangleScreenY_A < 0) {
                  int_4 -= int_16 * triangleScreenY_A;
                  triangleScreenY_A = 0;
               }

               if (z_a_off < int_17) {
                  int_0 -= triangleScreenY_A;
                  triangleScreenY_A -= triangleScreenY_B;
                  triangleScreenY_B = rasterClipY[triangleScreenY_B];

                  while (true) {
                     --triangleScreenY_A;
                     if (triangleScreenY_A < 0) {
                        while (true) {
                           --int_0;
                           if (int_0 < 0) {
                              return;
                           }

                           drawShadedLine(Rasterizer2D.graphicsPixels, triangleScreenY_B, 0, 0, int_4 >> 14, int_5 >> 14, int_8, int_19);
                           int_4 += int_16;
                           int_5 += int_17;
                           int_8 += int_20;
                           triangleScreenY_B += Rasterizer2D.graphicsPixelsWidth;
                        }
                     }

                     drawShadedLine(Rasterizer2D.graphicsPixels, triangleScreenY_B, 0, 0, int_3 >> 14, int_5 >> 14, int_8, int_19);
                     int_3 += z_a_off;
                     int_5 += int_17;
                     int_8 += int_20;
                     triangleScreenY_B += Rasterizer2D.graphicsPixelsWidth;
                  }
               } else {
                  int_0 -= triangleScreenY_A;
                  triangleScreenY_A -= triangleScreenY_B;
                  triangleScreenY_B = rasterClipY[triangleScreenY_B];

                  while (true) {
                     --triangleScreenY_A;
                     if (triangleScreenY_A < 0) {
                        while (true) {
                           --int_0;
                           if (int_0 < 0) {
                              return;
                           }

                           drawShadedLine(Rasterizer2D.graphicsPixels, triangleScreenY_B, 0, 0, int_5 >> 14, int_4 >> 14, int_8, int_19);
                           int_4 += int_16;
                           int_5 += int_17;
                           int_8 += int_20;
                           triangleScreenY_B += Rasterizer2D.graphicsPixelsWidth;
                        }
                     }

                     drawShadedLine(Rasterizer2D.graphicsPixels, triangleScreenY_B, 0, 0, int_5 >> 14, int_3 >> 14, int_8, int_19);
                     int_3 += z_a_off;
                     int_5 += int_17;
                     int_8 += int_20;
                     triangleScreenY_B += Rasterizer2D.graphicsPixelsWidth;
                  }
               }
            }
         }
      }
   }

   public static void method960() {
      setRasterClipping(Rasterizer2D.topX, Rasterizer2D.topY, Rasterizer2D.bottomX, Rasterizer2D.bottomY);
   }

   static void setRasterClipping(int int_0, int int_1, int int_2, int int_3) {
      rasterClipX = int_2 - int_0;
      graphicsPixelsBottomY = int_3 - int_1;
      method961();
      if (rasterClipY.length < graphicsPixelsBottomY) {
         rasterClipY = new int[Class58.method389(graphicsPixelsBottomY)];
      }

      int int_4 = int_0 + Rasterizer2D.graphicsPixelsWidth * int_1;

      for (int int_5 = 0; int_5 < graphicsPixelsBottomY; int_5++) {
         rasterClipY[int_5] = int_4;
         int_4 += Rasterizer2D.graphicsPixelsWidth;
      }

   }

   public static void method961() {
      centerX = rasterClipX / 2;
      centerY = graphicsPixelsBottomY / 2;
      anInt545 = -centerX;
      anInt544 = rasterClipX - centerX;
      anInt546 = -centerY;
      anInt547 = graphicsPixelsBottomY - centerY;
   }

   static void drawTexturedTriangle(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8, int int_9, int int_10, int int_11, int int_12, int int_13, int int_14, int int_15, int int_16, int int_17, int textureId) {
      int[] texturePixels = textureLoader.load(textureId);
      int int_19;
      if (texturePixels == null) {
         int_19 = textureLoader.getAverageTextureRGB(textureId);
         drawShadedTriangle(int_0, int_1, int_2, int_3, int_4, int_5, method965(int_19, int_6), method965(int_19, int_7), method965(int_19, int_8));
      } else {
         lowMem = textureLoader.method1(textureId);
         aBool72 = textureLoader.method2(textureId);
         int_19 = int_4 - int_3;
         int int_20 = int_1 - int_0;
         int int_21 = int_5 - int_3;
         int int_22 = int_2 - int_0;
         int int_23 = int_7 - int_6;
         int int_24 = int_8 - int_6;
         int int_25 = 0;
         if (int_0 != int_1) {
            int_25 = (int_4 - int_3 << 14) / (int_1 - int_0);
         }

         int int_26 = 0;
         if (int_2 != int_1) {
            int_26 = (int_5 - int_4 << 14) / (int_2 - int_1);
         }

         int int_27 = 0;
         if (int_0 != int_2) {
            int_27 = (int_3 - int_5 << 14) / (int_0 - int_2);
         }

         int int_28 = int_19 * int_22 - int_21 * int_20;
         if (int_28 != 0) {
            int int_29 = (int_23 * int_22 - int_24 * int_20 << 9) / int_28;
            int int_30 = (int_24 * int_19 - int_23 * int_21 << 9) / int_28;
            int_10 = int_9 - int_10;
            int_13 = int_12 - int_13;
            int_16 = int_15 - int_16;
            int_11 -= int_9;
            int_14 -= int_12;
            int_17 -= int_15;
            int int_31 = int_11 * int_12 - int_9 * int_14 << 14;
            int int_32 = (int)(((long)(int_15 * int_14 - int_17 * int_12) << 3 << 14) / (long)anInt543);
            int int_33 = (int)(((long)(int_17 * int_9 - int_11 * int_15) << 14) / (long)anInt543);
            int int_34 = int_10 * int_12 - int_13 * int_9 << 14;
            int int_35 = (int)(((long)(int_13 * int_15 - int_16 * int_12) << 3 << 14) / (long)anInt543);
            int int_36 = (int)(((long)(int_16 * int_9 - int_10 * int_15) << 14) / (long)anInt543);
            int int_37 = int_13 * int_11 - int_10 * int_14 << 14;
            int int_38 = (int)(((long)(int_16 * int_14 - int_13 * int_17) << 3 << 14) / (long)anInt543);
            int int_39 = (int)(((long)(int_17 * int_10 - int_11 * int_16) << 14) / (long)anInt543);
            int int_40;
            if (int_0 <= int_1 && int_0 <= int_2) {
               if (int_0 < graphicsPixelsBottomY) {
                  if (int_1 > graphicsPixelsBottomY) {
                     int_1 = graphicsPixelsBottomY;
                  }

                  if (int_2 > graphicsPixelsBottomY) {
                     int_2 = graphicsPixelsBottomY;
                  }

                  int_6 = int_29 + ((int_6 << 9) - int_3 * int_29);
                  if (int_1 < int_2) {
                     int_5 = int_3 <<= 14;
                     if (int_0 < 0) {
                        int_5 -= int_0 * int_27;
                        int_3 -= int_0 * int_25;
                        int_6 -= int_0 * int_30;
                        int_0 = 0;
                     }

                     int_4 <<= 14;
                     if (int_1 < 0) {
                        int_4 -= int_26 * int_1;
                        int_1 = 0;
                     }

                     int_40 = int_0 - centerY;
                     int_31 += int_33 * int_40;
                     int_34 += int_36 * int_40;
                     int_37 += int_39 * int_40;
                     if (int_0 != int_1 && int_27 < int_25 || int_0 == int_1 && int_27 > int_26) {
                        int_2 -= int_1;
                        int_1 -= int_0;
                        int_0 = rasterClipY[int_0];

                        while (true) {
                           --int_1;
                           if (int_1 < 0) {
                              while (true) {
                                 --int_2;
                                 if (int_2 < 0) {
                                    return;
                                 }

                                 method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_0, int_5 >> 14, int_4 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                 int_5 += int_27;
                                 int_4 += int_26;
                                 int_6 += int_30;
                                 int_0 += Rasterizer2D.graphicsPixelsWidth;
                                 int_31 += int_33;
                                 int_34 += int_36;
                                 int_37 += int_39;
                              }
                           }

                           method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_0, int_5 >> 14, int_3 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                           int_5 += int_27;
                           int_3 += int_25;
                           int_6 += int_30;
                           int_0 += Rasterizer2D.graphicsPixelsWidth;
                           int_31 += int_33;
                           int_34 += int_36;
                           int_37 += int_39;
                        }
                     } else {
                        int_2 -= int_1;
                        int_1 -= int_0;
                        int_0 = rasterClipY[int_0];

                        while (true) {
                           --int_1;
                           if (int_1 < 0) {
                              while (true) {
                                 --int_2;
                                 if (int_2 < 0) {
                                    return;
                                 }

                                 method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_0, int_4 >> 14, int_5 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                 int_5 += int_27;
                                 int_4 += int_26;
                                 int_6 += int_30;
                                 int_0 += Rasterizer2D.graphicsPixelsWidth;
                                 int_31 += int_33;
                                 int_34 += int_36;
                                 int_37 += int_39;
                              }
                           }

                           method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_0, int_3 >> 14, int_5 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                           int_5 += int_27;
                           int_3 += int_25;
                           int_6 += int_30;
                           int_0 += Rasterizer2D.graphicsPixelsWidth;
                           int_31 += int_33;
                           int_34 += int_36;
                           int_37 += int_39;
                        }
                     }
                  } else {
                     int_4 = int_3 <<= 14;
                     if (int_0 < 0) {
                        int_4 -= int_0 * int_27;
                        int_3 -= int_0 * int_25;
                        int_6 -= int_0 * int_30;
                        int_0 = 0;
                     }

                     int_5 <<= 14;
                     if (int_2 < 0) {
                        int_5 -= int_26 * int_2;
                        int_2 = 0;
                     }

                     int_40 = int_0 - centerY;
                     int_31 += int_33 * int_40;
                     int_34 += int_36 * int_40;
                     int_37 += int_39 * int_40;
                     if (int_0 != int_2 && int_27 < int_25 || int_0 == int_2 && int_26 > int_25) {
                        int_1 -= int_2;
                        int_2 -= int_0;
                        int_0 = rasterClipY[int_0];

                        while (true) {
                           --int_2;
                           if (int_2 < 0) {
                              while (true) {
                                 --int_1;
                                 if (int_1 < 0) {
                                    return;
                                 }

                                 method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_0, int_5 >> 14, int_3 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                 int_5 += int_26;
                                 int_3 += int_25;
                                 int_6 += int_30;
                                 int_0 += Rasterizer2D.graphicsPixelsWidth;
                                 int_31 += int_33;
                                 int_34 += int_36;
                                 int_37 += int_39;
                              }
                           }

                           method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_0, int_4 >> 14, int_3 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                           int_4 += int_27;
                           int_3 += int_25;
                           int_6 += int_30;
                           int_0 += Rasterizer2D.graphicsPixelsWidth;
                           int_31 += int_33;
                           int_34 += int_36;
                           int_37 += int_39;
                        }
                     } else {
                        int_1 -= int_2;
                        int_2 -= int_0;
                        int_0 = rasterClipY[int_0];

                        while (true) {
                           --int_2;
                           if (int_2 < 0) {
                              while (true) {
                                 --int_1;
                                 if (int_1 < 0) {
                                    return;
                                 }

                                 method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_0, int_3 >> 14, int_5 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                 int_5 += int_26;
                                 int_3 += int_25;
                                 int_6 += int_30;
                                 int_0 += Rasterizer2D.graphicsPixelsWidth;
                                 int_31 += int_33;
                                 int_34 += int_36;
                                 int_37 += int_39;
                              }
                           }

                           method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_0, int_3 >> 14, int_4 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                           int_4 += int_27;
                           int_3 += int_25;
                           int_6 += int_30;
                           int_0 += Rasterizer2D.graphicsPixelsWidth;
                           int_31 += int_33;
                           int_34 += int_36;
                           int_37 += int_39;
                        }
                     }
                  }
               }
            } else if (int_1 <= int_2) {
               if (int_1 < graphicsPixelsBottomY) {
                  if (int_2 > graphicsPixelsBottomY) {
                     int_2 = graphicsPixelsBottomY;
                  }

                  if (int_0 > graphicsPixelsBottomY) {
                     int_0 = graphicsPixelsBottomY;
                  }

                  int_7 = int_29 + ((int_7 << 9) - int_29 * int_4);
                  if (int_2 < int_0) {
                     int_3 = int_4 <<= 14;
                     if (int_1 < 0) {
                        int_3 -= int_25 * int_1;
                        int_4 -= int_26 * int_1;
                        int_7 -= int_30 * int_1;
                        int_1 = 0;
                     }

                     int_5 <<= 14;
                     if (int_2 < 0) {
                        int_5 -= int_27 * int_2;
                        int_2 = 0;
                     }

                     int_40 = int_1 - centerY;
                     int_31 += int_33 * int_40;
                     int_34 += int_36 * int_40;
                     int_37 += int_39 * int_40;
                     if (int_2 != int_1 && int_25 < int_26 || int_2 == int_1 && int_25 > int_27) {
                        int_0 -= int_2;
                        int_2 -= int_1;
                        int_1 = rasterClipY[int_1];

                        while (true) {
                           --int_2;
                           if (int_2 < 0) {
                              while (true) {
                                 --int_0;
                                 if (int_0 < 0) {
                                    return;
                                 }

                                 method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_1, int_3 >> 14, int_5 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                 int_3 += int_25;
                                 int_5 += int_27;
                                 int_7 += int_30;
                                 int_1 += Rasterizer2D.graphicsPixelsWidth;
                                 int_31 += int_33;
                                 int_34 += int_36;
                                 int_37 += int_39;
                              }
                           }

                           method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_1, int_3 >> 14, int_4 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                           int_3 += int_25;
                           int_4 += int_26;
                           int_7 += int_30;
                           int_1 += Rasterizer2D.graphicsPixelsWidth;
                           int_31 += int_33;
                           int_34 += int_36;
                           int_37 += int_39;
                        }
                     } else {
                        int_0 -= int_2;
                        int_2 -= int_1;
                        int_1 = rasterClipY[int_1];

                        while (true) {
                           --int_2;
                           if (int_2 < 0) {
                              while (true) {
                                 --int_0;
                                 if (int_0 < 0) {
                                    return;
                                 }

                                 method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_1, int_5 >> 14, int_3 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                 int_3 += int_25;
                                 int_5 += int_27;
                                 int_7 += int_30;
                                 int_1 += Rasterizer2D.graphicsPixelsWidth;
                                 int_31 += int_33;
                                 int_34 += int_36;
                                 int_37 += int_39;
                              }
                           }

                           method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_1, int_4 >> 14, int_3 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                           int_3 += int_25;
                           int_4 += int_26;
                           int_7 += int_30;
                           int_1 += Rasterizer2D.graphicsPixelsWidth;
                           int_31 += int_33;
                           int_34 += int_36;
                           int_37 += int_39;
                        }
                     }
                  } else {
                     int_5 = int_4 <<= 14;
                     if (int_1 < 0) {
                        int_5 -= int_25 * int_1;
                        int_4 -= int_26 * int_1;
                        int_7 -= int_30 * int_1;
                        int_1 = 0;
                     }

                     int_3 <<= 14;
                     if (int_0 < 0) {
                        int_3 -= int_0 * int_27;
                        int_0 = 0;
                     }

                     int_40 = int_1 - centerY;
                     int_31 += int_33 * int_40;
                     int_34 += int_36 * int_40;
                     int_37 += int_39 * int_40;
                     if (int_25 < int_26) {
                        int_2 -= int_0;
                        int_0 -= int_1;
                        int_1 = rasterClipY[int_1];

                        while (true) {
                           --int_0;
                           if (int_0 < 0) {
                              while (true) {
                                 --int_2;
                                 if (int_2 < 0) {
                                    return;
                                 }

                                 method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_1, int_3 >> 14, int_4 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                 int_3 += int_27;
                                 int_4 += int_26;
                                 int_7 += int_30;
                                 int_1 += Rasterizer2D.graphicsPixelsWidth;
                                 int_31 += int_33;
                                 int_34 += int_36;
                                 int_37 += int_39;
                              }
                           }

                           method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_1, int_5 >> 14, int_4 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                           int_5 += int_25;
                           int_4 += int_26;
                           int_7 += int_30;
                           int_1 += Rasterizer2D.graphicsPixelsWidth;
                           int_31 += int_33;
                           int_34 += int_36;
                           int_37 += int_39;
                        }
                     } else {
                        int_2 -= int_0;
                        int_0 -= int_1;
                        int_1 = rasterClipY[int_1];

                        while (true) {
                           --int_0;
                           if (int_0 < 0) {
                              while (true) {
                                 --int_2;
                                 if (int_2 < 0) {
                                    return;
                                 }

                                 method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_1, int_4 >> 14, int_3 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                 int_3 += int_27;
                                 int_4 += int_26;
                                 int_7 += int_30;
                                 int_1 += Rasterizer2D.graphicsPixelsWidth;
                                 int_31 += int_33;
                                 int_34 += int_36;
                                 int_37 += int_39;
                              }
                           }

                           method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_1, int_4 >> 14, int_5 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                           int_5 += int_25;
                           int_4 += int_26;
                           int_7 += int_30;
                           int_1 += Rasterizer2D.graphicsPixelsWidth;
                           int_31 += int_33;
                           int_34 += int_36;
                           int_37 += int_39;
                        }
                     }
                  }
               }
            } else if (int_2 < graphicsPixelsBottomY) {
               if (int_0 > graphicsPixelsBottomY) {
                  int_0 = graphicsPixelsBottomY;
               }

               if (int_1 > graphicsPixelsBottomY) {
                  int_1 = graphicsPixelsBottomY;
               }

               int_8 = (int_8 << 9) - int_5 * int_29 + int_29;
               if (int_0 < int_1) {
                  int_4 = int_5 <<= 14;
                  if (int_2 < 0) {
                     int_4 -= int_26 * int_2;
                     int_5 -= int_27 * int_2;
                     int_8 -= int_30 * int_2;
                     int_2 = 0;
                  }

                  int_3 <<= 14;
                  if (int_0 < 0) {
                     int_3 -= int_0 * int_25;
                     int_0 = 0;
                  }

                  int_40 = int_2 - centerY;
                  int_31 += int_33 * int_40;
                  int_34 += int_36 * int_40;
                  int_37 += int_39 * int_40;
                  if (int_26 < int_27) {
                     int_1 -= int_0;
                     int_0 -= int_2;
                     int_2 = rasterClipY[int_2];

                     while (true) {
                        --int_0;
                        if (int_0 < 0) {
                           while (true) {
                              --int_1;
                              if (int_1 < 0) {
                                 return;
                              }

                              method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_2, int_4 >> 14, int_3 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                              int_4 += int_26;
                              int_3 += int_25;
                              int_8 += int_30;
                              int_2 += Rasterizer2D.graphicsPixelsWidth;
                              int_31 += int_33;
                              int_34 += int_36;
                              int_37 += int_39;
                           }
                        }

                        method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_2, int_4 >> 14, int_5 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                        int_4 += int_26;
                        int_5 += int_27;
                        int_8 += int_30;
                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                        int_31 += int_33;
                        int_34 += int_36;
                        int_37 += int_39;
                     }
                  } else {
                     int_1 -= int_0;
                     int_0 -= int_2;
                     int_2 = rasterClipY[int_2];

                     while (true) {
                        --int_0;
                        if (int_0 < 0) {
                           while (true) {
                              --int_1;
                              if (int_1 < 0) {
                                 return;
                              }

                              method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_2, int_3 >> 14, int_4 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                              int_4 += int_26;
                              int_3 += int_25;
                              int_8 += int_30;
                              int_2 += Rasterizer2D.graphicsPixelsWidth;
                              int_31 += int_33;
                              int_34 += int_36;
                              int_37 += int_39;
                           }
                        }

                        method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_2, int_5 >> 14, int_4 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                        int_4 += int_26;
                        int_5 += int_27;
                        int_8 += int_30;
                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                        int_31 += int_33;
                        int_34 += int_36;
                        int_37 += int_39;
                     }
                  }
               } else {
                  int_3 = int_5 <<= 14;
                  if (int_2 < 0) {
                     int_3 -= int_26 * int_2;
                     int_5 -= int_27 * int_2;
                     int_8 -= int_30 * int_2;
                     int_2 = 0;
                  }

                  int_4 <<= 14;
                  if (int_1 < 0) {
                     int_4 -= int_25 * int_1;
                     int_1 = 0;
                  }

                  int_40 = int_2 - centerY;
                  int_31 += int_33 * int_40;
                  int_34 += int_36 * int_40;
                  int_37 += int_39 * int_40;
                  if (int_26 < int_27) {
                     int_0 -= int_1;
                     int_1 -= int_2;
                     int_2 = rasterClipY[int_2];

                     while (true) {
                        --int_1;
                        if (int_1 < 0) {
                           while (true) {
                              --int_0;
                              if (int_0 < 0) {
                                 return;
                              }

                              method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_2, int_4 >> 14, int_5 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                              int_4 += int_25;
                              int_5 += int_27;
                              int_8 += int_30;
                              int_2 += Rasterizer2D.graphicsPixelsWidth;
                              int_31 += int_33;
                              int_34 += int_36;
                              int_37 += int_39;
                           }
                        }

                        method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_2, int_3 >> 14, int_5 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                        int_3 += int_26;
                        int_5 += int_27;
                        int_8 += int_30;
                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                        int_31 += int_33;
                        int_34 += int_36;
                        int_37 += int_39;
                     }
                  } else {
                     int_0 -= int_1;
                     int_1 -= int_2;
                     int_2 = rasterClipY[int_2];

                     while (true) {
                        --int_1;
                        if (int_1 < 0) {
                           while (true) {
                              --int_0;
                              if (int_0 < 0) {
                                 return;
                              }

                              method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_2, int_5 >> 14, int_4 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                              int_4 += int_25;
                              int_5 += int_27;
                              int_8 += int_30;
                              int_2 += Rasterizer2D.graphicsPixelsWidth;
                              int_31 += int_33;
                              int_34 += int_36;
                              int_37 += int_39;
                           }
                        }

                        method971(Rasterizer2D.graphicsPixels, texturePixels, 0, 0, int_2, int_5 >> 14, int_3 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                        int_3 += int_26;
                        int_5 += int_27;
                        int_8 += int_30;
                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                        int_31 += int_33;
                        int_34 += int_36;
                        int_37 += int_39;
                     }
                  }
               }
            }
         }
      }
   }

   public static void setBrightness(double value) {
      setBrightness(value, 0, 512);
   }

   static void method962(int[] ints_0, int int_0, int int_1, int int_2, int int_3, int int_4) {
      if (restrictEdges) {
         if (int_4 > rasterClipX) {
            int_4 = rasterClipX;
         }

         if (int_3 < 0) {
            int_3 = 0;
         }
      }

      if (int_3 < int_4) {
         int_0 += int_3;
         int_2 = int_4 - int_3 >> 2;
         if (alpha != 0) {
            if (alpha == 254) {
               while (true) {
                  --int_2;
                  if (int_2 < 0) {
                     int_2 = int_4 - int_3 & 0x3;

                     while (true) {
                        --int_2;
                        if (int_2 < 0) {
                           return;
                        }

                        ints_0[int_0++] = ints_0[int_0];
                     }
                  }

                  ints_0[int_0++] = ints_0[int_0];
                  ints_0[int_0++] = ints_0[int_0];
                  ints_0[int_0++] = ints_0[int_0];
                  ints_0[int_0++] = ints_0[int_0];
               }
            } else {
               int int_5 = alpha;
               int int_6 = 256 - alpha;
               int_1 = (int_6 * (int_1 & 0xFF00) >> 8 & 0xFF00) + (int_6 * (int_1 & 0xFF00FF) >> 8 & 0xFF00FF);

               while (true) {
                  --int_2;
                  int int_7;
                  if (int_2 < 0) {
                     int_2 = int_4 - int_3 & 0x3;

                     while (true) {
                        --int_2;
                        if (int_2 < 0) {
                           return;
                        }

                        int_7 = ints_0[int_0];
                        ints_0[int_0++] = ((int_7 & 0xFF00FF) * int_5 >> 8 & 0xFF00FF) + int_1 + (int_5 * (int_7 & 0xFF00) >> 8 & 0xFF00);
                     }
                  }

                  int_7 = ints_0[int_0];
                  ints_0[int_0++] = ((int_7 & 0xFF00FF) * int_5 >> 8 & 0xFF00FF) + int_1 + (int_5 * (int_7 & 0xFF00) >> 8 & 0xFF00);
                  int_7 = ints_0[int_0];
                  ints_0[int_0++] = ((int_7 & 0xFF00FF) * int_5 >> 8 & 0xFF00FF) + int_1 + (int_5 * (int_7 & 0xFF00) >> 8 & 0xFF00);
                  int_7 = ints_0[int_0];
                  ints_0[int_0++] = ((int_7 & 0xFF00FF) * int_5 >> 8 & 0xFF00FF) + int_1 + (int_5 * (int_7 & 0xFF00) >> 8 & 0xFF00);
                  int_7 = ints_0[int_0];
                  ints_0[int_0++] = ((int_7 & 0xFF00FF) * int_5 >> 8 & 0xFF00FF) + int_1 + (int_5 * (int_7 & 0xFF00) >> 8 & 0xFF00);
               }
            }
         } else {
            while (true) {
               --int_2;
               if (int_2 < 0) {
                  int_2 = int_4 - int_3 & 0x3;

                  while (true) {
                     --int_2;
                     if (int_2 < 0) {
                        return;
                     }

                     ints_0[int_0++] = int_1;
                  }
               }

               ints_0[int_0++] = int_1;
               ints_0[int_0++] = int_1;
               ints_0[int_0++] = int_1;
               ints_0[int_0++] = int_1;
            }
         }
      }
   }

   public static void setTextureLoader(ITextureLoader itextureloader_0) {
      textureLoader = itextureloader_0;
   }

   static void setBrightness(double brightness, int offset, int max) {
      int index = offset * 128;

      for (int i = offset; i < max; i++) {
         double double_1 = (double)(i >> 3) / 64.0D + 0.0078125D;
         double double_2 = (double)(i & 0x7) / 8.0D + 0.0625D;

         for (int int_5 = 0; int_5 < 128; int_5++) {
            double double_3 = (double)int_5 / 128.0D;
            double double_4 = double_3;
            double double_5 = double_3;
            double double_6 = double_3;
            if (double_2 != 0.0D) {
               double double_7;
               if (double_3 < 0.5D) {
                  double_7 = double_3 * (1.0D + double_2);
               } else {
                  double_7 = double_3 + double_2 - double_3 * double_2;
               }

               double double_8 = 2.0D * double_3 - double_7;
               double double_9 = double_1 + 0.3333333333333333D;
               if (double_9 > 1.0D) {
                  --double_9;
               }

               double double_10 = double_1 - 0.3333333333333333D;
               if (double_10 < 0.0D) {
                  ++double_10;
               }

               if (6.0D * double_9 < 1.0D) {
                  double_4 = double_8 + (double_7 - double_8) * 6.0D * double_9;
               } else if (2.0D * double_9 < 1.0D) {
                  double_4 = double_7;
               } else if (3.0D * double_9 < 2.0D) {
                  double_4 = double_8 + (double_7 - double_8) * (0.6666666666666666D - double_9) * 6.0D;
               } else {
                  double_4 = double_8;
               }

               if (6.0D * double_1 < 1.0D) {
                  double_5 = double_8 + (double_7 - double_8) * 6.0D * double_1;
               } else if (2.0D * double_1 < 1.0D) {
                  double_5 = double_7;
               } else if (3.0D * double_1 < 2.0D) {
                  double_5 = double_8 + (double_7 - double_8) * (0.6666666666666666D - double_1) * 6.0D;
               } else {
                  double_5 = double_8;
               }

               if (6.0D * double_10 < 1.0D) {
                  double_6 = double_8 + (double_7 - double_8) * 6.0D * double_10;
               } else if (2.0D * double_10 < 1.0D) {
                  double_6 = double_7;
               } else if (3.0D * double_10 < 2.0D) {
                  double_6 = double_8 + (double_7 - double_8) * (0.6666666666666666D - double_10) * 6.0D;
               } else {
                  double_6 = double_8;
               }
            }

            int red = (int)(double_4 * 256.0D);
            int green = (int)(double_5 * 256.0D);
            int blue = (int)(double_6 * 256.0D);
            int rgb = blue + (green << 8) + (red << 16);
            rgb = adjustBrightness(rgb, brightness);
            if (rgb == 0)
               rgb = 1;

            colourPalette[index++] = rgb;
         }
      }

   }

   static int method964(int int_0, int int_1, int int_2, int int_3) {
      return int_0 * int_2 + int_3 * int_1 >> 16;
   }

   static int method965(int int_0, int int_1) {
      int_1 = (int_0 & 0x7F) * int_1 >> 7;
      if (int_1 < 2) {
         int_1 = 2;
      } else if (int_1 > 126) {
         int_1 = 126;
      }

      return (int_0 & 0xFF80) + int_1;
   }

   static int method966(int int_0, int int_1, int int_2, int int_3) {
      return int_2 * int_1 - int_3 * int_0 >> 16;
   }

   static void rasterTexture(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8, int int_9, int int_10, int int_11, int int_12, int int_13, int int_14, int int_15, int int_16, int int_17, int int_18) {
      int[] ints_0 = textureLoader.load(int_18);
      int int_19;
      if (ints_0 == null) {
         int_19 = textureLoader.getAverageTextureRGB(int_18);
         drawShadedTriangle(int_0, int_1, int_2, int_3, int_4, int_5, method965(int_19, int_6), method965(int_19, int_7), method965(int_19, int_8));
      } else {
         lowMem = textureLoader.method1(int_18);
         aBool72 = textureLoader.method2(int_18);
         int_19 = int_4 - int_3;
         int int_20 = int_1 - int_0;
         int int_21 = int_5 - int_3;
         int int_22 = int_2 - int_0;
         int int_23 = int_7 - int_6;
         int int_24 = int_8 - int_6;
         int int_25 = 0;
         if (int_0 != int_1) {
            int_25 = (int_4 - int_3 << 14) / (int_1 - int_0);
         }

         int int_26 = 0;
         if (int_2 != int_1) {
            int_26 = (int_5 - int_4 << 14) / (int_2 - int_1);
         }

         int int_27 = 0;
         if (int_0 != int_2) {
            int_27 = (int_3 - int_5 << 14) / (int_0 - int_2);
         }

         int int_28 = int_19 * int_22 - int_21 * int_20;
         if (int_28 != 0) {
            int int_29 = (int_23 * int_22 - int_24 * int_20 << 9) / int_28;
            int int_30 = (int_24 * int_19 - int_23 * int_21 << 9) / int_28;
            int_10 = int_9 - int_10;
            int_13 = int_12 - int_13;
            int_16 = int_15 - int_16;
            int_11 -= int_9;
            int_14 -= int_12;
            int_17 -= int_15;
            int int_31 = int_11 * int_12 - int_9 * int_14 << 14;
            int int_32 = (int)(((long)(int_15 * int_14 - int_17 * int_12) << 14) / (long)anInt543);
            int int_33 = (int)(((long)(int_17 * int_9 - int_11 * int_15) << 14) / (long)anInt543);
            int int_34 = int_10 * int_12 - int_13 * int_9 << 14;
            int int_35 = (int)(((long)(int_13 * int_15 - int_16 * int_12) << 14) / (long)anInt543);
            int int_36 = (int)(((long)(int_16 * int_9 - int_10 * int_15) << 14) / (long)anInt543);
            int int_37 = int_13 * int_11 - int_10 * int_14 << 14;
            int int_38 = (int)(((long)(int_16 * int_14 - int_13 * int_17) << 14) / (long)anInt543);
            int int_39 = (int)(((long)(int_17 * int_10 - int_11 * int_16) << 14) / (long)anInt543);
            int int_40;
            if (int_0 <= int_1 && int_0 <= int_2) {
               if (int_0 < graphicsPixelsBottomY) {
                  if (int_1 > graphicsPixelsBottomY) {
                     int_1 = graphicsPixelsBottomY;
                  }

                  if (int_2 > graphicsPixelsBottomY) {
                     int_2 = graphicsPixelsBottomY;
                  }

                  int_6 = int_29 + ((int_6 << 9) - int_3 * int_29);
                  if (int_1 < int_2) {
                     int_5 = int_3 <<= 14;
                     if (int_0 < 0) {
                        int_5 -= int_0 * int_27;
                        int_3 -= int_0 * int_25;
                        int_6 -= int_0 * int_30;
                        int_0 = 0;
                     }

                     int_4 <<= 14;
                     if (int_1 < 0) {
                        int_4 -= int_26 * int_1;
                        int_1 = 0;
                     }

                     int_40 = int_0 - centerY;
                     int_31 += int_33 * int_40;
                     int_34 += int_36 * int_40;
                     int_37 += int_39 * int_40;
                     if (int_0 != int_1 && int_27 < int_25 || int_0 == int_1 && int_27 > int_26) {
                        int_2 -= int_1;
                        int_1 -= int_0;
                        int_0 = rasterClipY[int_0];

                        while (true) {
                           --int_1;
                           if (int_1 < 0) {
                              while (true) {
                                 --int_2;
                                 if (int_2 < 0) {
                                    return;
                                 }

                                 method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_5 >> 14, int_4 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                 int_5 += int_27;
                                 int_4 += int_26;
                                 int_6 += int_30;
                                 int_0 += Rasterizer2D.graphicsPixelsWidth;
                                 int_31 += int_33;
                                 int_34 += int_36;
                                 int_37 += int_39;
                              }
                           }

                           method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_5 >> 14, int_3 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                           int_5 += int_27;
                           int_3 += int_25;
                           int_6 += int_30;
                           int_0 += Rasterizer2D.graphicsPixelsWidth;
                           int_31 += int_33;
                           int_34 += int_36;
                           int_37 += int_39;
                        }
                     } else {
                        int_2 -= int_1;
                        int_1 -= int_0;
                        int_0 = rasterClipY[int_0];

                        while (true) {
                           --int_1;
                           if (int_1 < 0) {
                              while (true) {
                                 --int_2;
                                 if (int_2 < 0) {
                                    return;
                                 }

                                 method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_4 >> 14, int_5 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                 int_5 += int_27;
                                 int_4 += int_26;
                                 int_6 += int_30;
                                 int_0 += Rasterizer2D.graphicsPixelsWidth;
                                 int_31 += int_33;
                                 int_34 += int_36;
                                 int_37 += int_39;
                              }
                           }

                           method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_3 >> 14, int_5 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                           int_5 += int_27;
                           int_3 += int_25;
                           int_6 += int_30;
                           int_0 += Rasterizer2D.graphicsPixelsWidth;
                           int_31 += int_33;
                           int_34 += int_36;
                           int_37 += int_39;
                        }
                     }
                  } else {
                     int_4 = int_3 <<= 14;
                     if (int_0 < 0) {
                        int_4 -= int_0 * int_27;
                        int_3 -= int_0 * int_25;
                        int_6 -= int_0 * int_30;
                        int_0 = 0;
                     }

                     int_5 <<= 14;
                     if (int_2 < 0) {
                        int_5 -= int_26 * int_2;
                        int_2 = 0;
                     }

                     int_40 = int_0 - centerY;
                     int_31 += int_33 * int_40;
                     int_34 += int_36 * int_40;
                     int_37 += int_39 * int_40;
                     if ((int_0 == int_2 || int_27 >= int_25) && (int_0 != int_2 || int_26 <= int_25)) {
                        int_1 -= int_2;
                        int_2 -= int_0;
                        int_0 = rasterClipY[int_0];

                        while (true) {
                           --int_2;
                           if (int_2 < 0) {
                              while (true) {
                                 --int_1;
                                 if (int_1 < 0) {
                                    return;
                                 }

                                 method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_3 >> 14, int_5 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                 int_5 += int_26;
                                 int_3 += int_25;
                                 int_6 += int_30;
                                 int_0 += Rasterizer2D.graphicsPixelsWidth;
                                 int_31 += int_33;
                                 int_34 += int_36;
                                 int_37 += int_39;
                              }
                           }

                           method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_3 >> 14, int_4 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                           int_4 += int_27;
                           int_3 += int_25;
                           int_6 += int_30;
                           int_0 += Rasterizer2D.graphicsPixelsWidth;
                           int_31 += int_33;
                           int_34 += int_36;
                           int_37 += int_39;
                        }
                     } else {
                        int_1 -= int_2;
                        int_2 -= int_0;
                        int_0 = rasterClipY[int_0];

                        while (true) {
                           --int_2;
                           if (int_2 < 0) {
                              while (true) {
                                 --int_1;
                                 if (int_1 < 0) {
                                    return;
                                 }

                                 method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_5 >> 14, int_3 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                 int_5 += int_26;
                                 int_3 += int_25;
                                 int_6 += int_30;
                                 int_0 += Rasterizer2D.graphicsPixelsWidth;
                                 int_31 += int_33;
                                 int_34 += int_36;
                                 int_37 += int_39;
                              }
                           }

                           method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_4 >> 14, int_3 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                           int_4 += int_27;
                           int_3 += int_25;
                           int_6 += int_30;
                           int_0 += Rasterizer2D.graphicsPixelsWidth;
                           int_31 += int_33;
                           int_34 += int_36;
                           int_37 += int_39;
                        }
                     }
                  }
               }
            } else if (int_1 <= int_2) {
               if (int_1 < graphicsPixelsBottomY) {
                  if (int_2 > graphicsPixelsBottomY) {
                     int_2 = graphicsPixelsBottomY;
                  }

                  if (int_0 > graphicsPixelsBottomY) {
                     int_0 = graphicsPixelsBottomY;
                  }

                  int_7 = int_29 + ((int_7 << 9) - int_29 * int_4);
                  if (int_2 < int_0) {
                     int_3 = int_4 <<= 14;
                     if (int_1 < 0) {
                        int_3 -= int_25 * int_1;
                        int_4 -= int_26 * int_1;
                        int_7 -= int_30 * int_1;
                        int_1 = 0;
                     }

                     int_5 <<= 14;
                     if (int_2 < 0) {
                        int_5 -= int_27 * int_2;
                        int_2 = 0;
                     }

                     int_40 = int_1 - centerY;
                     int_31 += int_33 * int_40;
                     int_34 += int_36 * int_40;
                     int_37 += int_39 * int_40;
                     if (int_2 != int_1 && int_25 < int_26 || int_2 == int_1 && int_25 > int_27) {
                        int_0 -= int_2;
                        int_2 -= int_1;
                        int_1 = rasterClipY[int_1];

                        while (true) {
                           --int_2;
                           if (int_2 < 0) {
                              while (true) {
                                 --int_0;
                                 if (int_0 < 0) {
                                    return;
                                 }

                                 method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_3 >> 14, int_5 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                 int_3 += int_25;
                                 int_5 += int_27;
                                 int_7 += int_30;
                                 int_1 += Rasterizer2D.graphicsPixelsWidth;
                                 int_31 += int_33;
                                 int_34 += int_36;
                                 int_37 += int_39;
                              }
                           }

                           method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_3 >> 14, int_4 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                           int_3 += int_25;
                           int_4 += int_26;
                           int_7 += int_30;
                           int_1 += Rasterizer2D.graphicsPixelsWidth;
                           int_31 += int_33;
                           int_34 += int_36;
                           int_37 += int_39;
                        }
                     } else {
                        int_0 -= int_2;
                        int_2 -= int_1;
                        int_1 = rasterClipY[int_1];

                        while (true) {
                           --int_2;
                           if (int_2 < 0) {
                              while (true) {
                                 --int_0;
                                 if (int_0 < 0) {
                                    return;
                                 }

                                 method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_5 >> 14, int_3 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                 int_3 += int_25;
                                 int_5 += int_27;
                                 int_7 += int_30;
                                 int_1 += Rasterizer2D.graphicsPixelsWidth;
                                 int_31 += int_33;
                                 int_34 += int_36;
                                 int_37 += int_39;
                              }
                           }

                           method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_4 >> 14, int_3 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                           int_3 += int_25;
                           int_4 += int_26;
                           int_7 += int_30;
                           int_1 += Rasterizer2D.graphicsPixelsWidth;
                           int_31 += int_33;
                           int_34 += int_36;
                           int_37 += int_39;
                        }
                     }
                  } else {
                     int_5 = int_4 <<= 14;
                     if (int_1 < 0) {
                        int_5 -= int_25 * int_1;
                        int_4 -= int_26 * int_1;
                        int_7 -= int_30 * int_1;
                        int_1 = 0;
                     }

                     int_3 <<= 14;
                     if (int_0 < 0) {
                        int_3 -= int_0 * int_27;
                        int_0 = 0;
                     }

                     int_40 = int_1 - centerY;
                     int_31 += int_33 * int_40;
                     int_34 += int_36 * int_40;
                     int_37 += int_39 * int_40;
                     if (int_25 < int_26) {
                        int_2 -= int_0;
                        int_0 -= int_1;
                        int_1 = rasterClipY[int_1];

                        while (true) {
                           --int_0;
                           if (int_0 < 0) {
                              while (true) {
                                 --int_2;
                                 if (int_2 < 0) {
                                    return;
                                 }

                                 method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_3 >> 14, int_4 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                 int_3 += int_27;
                                 int_4 += int_26;
                                 int_7 += int_30;
                                 int_1 += Rasterizer2D.graphicsPixelsWidth;
                                 int_31 += int_33;
                                 int_34 += int_36;
                                 int_37 += int_39;
                              }
                           }

                           method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_5 >> 14, int_4 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                           int_5 += int_25;
                           int_4 += int_26;
                           int_7 += int_30;
                           int_1 += Rasterizer2D.graphicsPixelsWidth;
                           int_31 += int_33;
                           int_34 += int_36;
                           int_37 += int_39;
                        }
                     } else {
                        int_2 -= int_0;
                        int_0 -= int_1;
                        int_1 = rasterClipY[int_1];

                        while (true) {
                           --int_0;
                           if (int_0 < 0) {
                              while (true) {
                                 --int_2;
                                 if (int_2 < 0) {
                                    return;
                                 }

                                 method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_4 >> 14, int_3 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                 int_3 += int_27;
                                 int_4 += int_26;
                                 int_7 += int_30;
                                 int_1 += Rasterizer2D.graphicsPixelsWidth;
                                 int_31 += int_33;
                                 int_34 += int_36;
                                 int_37 += int_39;
                              }
                           }

                           method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_4 >> 14, int_5 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                           int_5 += int_25;
                           int_4 += int_26;
                           int_7 += int_30;
                           int_1 += Rasterizer2D.graphicsPixelsWidth;
                           int_31 += int_33;
                           int_34 += int_36;
                           int_37 += int_39;
                        }
                     }
                  }
               }
            } else if (int_2 < graphicsPixelsBottomY) {
               if (int_0 > graphicsPixelsBottomY) {
                  int_0 = graphicsPixelsBottomY;
               }

               if (int_1 > graphicsPixelsBottomY) {
                  int_1 = graphicsPixelsBottomY;
               }

               int_8 = (int_8 << 9) - int_5 * int_29 + int_29;
               if (int_0 < int_1) {
                  int_4 = int_5 <<= 14;
                  if (int_2 < 0) {
                     int_4 -= int_26 * int_2;
                     int_5 -= int_27 * int_2;
                     int_8 -= int_30 * int_2;
                     int_2 = 0;
                  }

                  int_3 <<= 14;
                  if (int_0 < 0) {
                     int_3 -= int_0 * int_25;
                     int_0 = 0;
                  }

                  int_40 = int_2 - centerY;
                  int_31 += int_33 * int_40;
                  int_34 += int_36 * int_40;
                  int_37 += int_39 * int_40;
                  if (int_26 < int_27) {
                     int_1 -= int_0;
                     int_0 -= int_2;
                     int_2 = rasterClipY[int_2];

                     while (true) {
                        --int_0;
                        if (int_0 < 0) {
                           while (true) {
                              --int_1;
                              if (int_1 < 0) {
                                 return;
                              }

                              method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_4 >> 14, int_3 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                              int_4 += int_26;
                              int_3 += int_25;
                              int_8 += int_30;
                              int_2 += Rasterizer2D.graphicsPixelsWidth;
                              int_31 += int_33;
                              int_34 += int_36;
                              int_37 += int_39;
                           }
                        }

                        method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_4 >> 14, int_5 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                        int_4 += int_26;
                        int_5 += int_27;
                        int_8 += int_30;
                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                        int_31 += int_33;
                        int_34 += int_36;
                        int_37 += int_39;
                     }
                  } else {
                     int_1 -= int_0;
                     int_0 -= int_2;
                     int_2 = rasterClipY[int_2];

                     while (true) {
                        --int_0;
                        if (int_0 < 0) {
                           while (true) {
                              --int_1;
                              if (int_1 < 0) {
                                 return;
                              }

                              method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_3 >> 14, int_4 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                              int_4 += int_26;
                              int_3 += int_25;
                              int_8 += int_30;
                              int_2 += Rasterizer2D.graphicsPixelsWidth;
                              int_31 += int_33;
                              int_34 += int_36;
                              int_37 += int_39;
                           }
                        }

                        method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_5 >> 14, int_4 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                        int_4 += int_26;
                        int_5 += int_27;
                        int_8 += int_30;
                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                        int_31 += int_33;
                        int_34 += int_36;
                        int_37 += int_39;
                     }
                  }
               } else {
                  int_3 = int_5 <<= 14;
                  if (int_2 < 0) {
                     int_3 -= int_26 * int_2;
                     int_5 -= int_27 * int_2;
                     int_8 -= int_30 * int_2;
                     int_2 = 0;
                  }

                  int_4 <<= 14;
                  if (int_1 < 0) {
                     int_4 -= int_25 * int_1;
                     int_1 = 0;
                  }

                  int_40 = int_2 - centerY;
                  int_31 += int_33 * int_40;
                  int_34 += int_36 * int_40;
                  int_37 += int_39 * int_40;
                  if (int_26 < int_27) {
                     int_0 -= int_1;
                     int_1 -= int_2;
                     int_2 = rasterClipY[int_2];

                     while (true) {
                        --int_1;
                        if (int_1 < 0) {
                           while (true) {
                              --int_0;
                              if (int_0 < 0) {
                                 return;
                              }

                              method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_4 >> 14, int_5 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                              int_4 += int_25;
                              int_5 += int_27;
                              int_8 += int_30;
                              int_2 += Rasterizer2D.graphicsPixelsWidth;
                              int_31 += int_33;
                              int_34 += int_36;
                              int_37 += int_39;
                           }
                        }

                        method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_3 >> 14, int_5 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                        int_3 += int_26;
                        int_5 += int_27;
                        int_8 += int_30;
                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                        int_31 += int_33;
                        int_34 += int_36;
                        int_37 += int_39;
                     }
                  } else {
                     int_0 -= int_1;
                     int_1 -= int_2;
                     int_2 = rasterClipY[int_2];

                     while (true) {
                        --int_1;
                        if (int_1 < 0) {
                           while (true) {
                              --int_0;
                              if (int_0 < 0) {
                                 return;
                              }

                              method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_5 >> 14, int_4 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                              int_4 += int_25;
                              int_5 += int_27;
                              int_8 += int_30;
                              int_2 += Rasterizer2D.graphicsPixelsWidth;
                              int_31 += int_33;
                              int_34 += int_36;
                              int_37 += int_39;
                           }
                        }

                        method972(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_5 >> 14, int_3 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                        int_3 += int_26;
                        int_5 += int_27;
                        int_8 += int_30;
                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                        int_31 += int_33;
                        int_34 += int_36;
                        int_37 += int_39;
                     }
                  }
               }
            }
         }
      }
   }

   static void drawShadedLine(int[] ints_0, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6) {
      if (restrictEdges) {
         if (int_4 > rasterClipX) {
            int_4 = rasterClipX;
         }

         if (int_3 < 0) {
            int_3 = 0;
         }
      }

      if (int_3 < int_4) {
         int_0 += int_3;
         int_5 += int_3 * int_6;
         int int_7;
         int int_8;
         int int_9;
         if (rasterGouraudLowRes) {
            int_2 = int_4 - int_3 >> 2;
            int_6 <<= 2;
            if (alpha == 0) {
               if (int_2 > 0) {
                  do {
                     int_1 = colourPalette[int_5 >> 8];
                     int_5 += int_6;
                     ints_0[int_0++] = int_1;
                     ints_0[int_0++] = int_1;
                     ints_0[int_0++] = int_1;
                     ints_0[int_0++] = int_1;
                     --int_2;
                  } while (int_2 > 0);
               }

               int_2 = int_4 - int_3 & 0x3;
               if (int_2 > 0) {
                  int_1 = colourPalette[int_5 >> 8];

                  do {
                     ints_0[int_0++] = int_1;
                     --int_2;
                  } while (int_2 > 0);
               }
            } else {
               int_7 = alpha;
               int_8 = 256 - alpha;
               if (int_2 > 0) {
                  do {
                     int_1 = colourPalette[int_5 >> 8];
                     int_5 += int_6;
                     int_1 = (int_8 * (int_1 & 0xFF00) >> 8 & 0xFF00) + (int_8 * (int_1 & 0xFF00FF) >> 8 & 0xFF00FF);
                     int_9 = ints_0[int_0];
                     ints_0[int_0++] = ((int_9 & 0xFF00FF) * int_7 >> 8 & 0xFF00FF) + int_1 + (int_7 * (int_9 & 0xFF00) >> 8 & 0xFF00);
                     int_9 = ints_0[int_0];
                     ints_0[int_0++] = ((int_9 & 0xFF00FF) * int_7 >> 8 & 0xFF00FF) + int_1 + (int_7 * (int_9 & 0xFF00) >> 8 & 0xFF00);
                     int_9 = ints_0[int_0];
                     ints_0[int_0++] = ((int_9 & 0xFF00FF) * int_7 >> 8 & 0xFF00FF) + int_1 + (int_7 * (int_9 & 0xFF00) >> 8 & 0xFF00);
                     int_9 = ints_0[int_0];
                     ints_0[int_0++] = ((int_9 & 0xFF00FF) * int_7 >> 8 & 0xFF00FF) + int_1 + (int_7 * (int_9 & 0xFF00) >> 8 & 0xFF00);
                     --int_2;
                  } while (int_2 > 0);
               }

               int_2 = int_4 - int_3 & 0x3;
               if (int_2 > 0) {
                  int_1 = colourPalette[int_5 >> 8];
                  int_1 = (int_8 * (int_1 & 0xFF00) >> 8 & 0xFF00) + (int_8 * (int_1 & 0xFF00FF) >> 8 & 0xFF00FF);

                  do {
                     int_9 = ints_0[int_0];
                     ints_0[int_0++] = ((int_9 & 0xFF00FF) * int_7 >> 8 & 0xFF00FF) + int_1 + (int_7 * (int_9 & 0xFF00) >> 8 & 0xFF00);
                     --int_2;
                  } while (int_2 > 0);
               }
            }

         } else {
            int_2 = int_4 - int_3;
            if (alpha == 0) {
               do {
                  ints_0[int_0++] = colourPalette[int_5 >> 8];
                  int_5 += int_6;
                  --int_2;
               } while (int_2 > 0);
            } else {
               int_7 = alpha;
               int_8 = 256 - alpha;

               do {
                  int_1 = colourPalette[int_5 >> 8];
                  int_5 += int_6;
                  int_1 = (int_8 * (int_1 & 0xFF00) >> 8 & 0xFF00) + (int_8 * (int_1 & 0xFF00FF) >> 8 & 0xFF00FF);
                  int_9 = ints_0[int_0];
                  ints_0[int_0++] = ((int_9 & 0xFF00FF) * int_7 >> 8 & 0xFF00FF) + int_1 + (int_7 * (int_9 & 0xFF00) >> 8 & 0xFF00);
                  --int_2;
               } while (int_2 > 0);
            }

         }
      }
   }

   static int method968(int int_0, int int_1, int int_2, int int_3) {
      return int_0 * int_2 - int_3 * int_1 >> 16;
   }

   static int method969(int int_0, int int_1, int int_2, int int_3) {
      return int_3 * int_0 + int_2 * int_1 >> 16;
   }

   public static void method970(int int_0, int int_1) {
      int int_2 = rasterClipY[0];
      int int_3 = int_2 / Rasterizer2D.graphicsPixelsWidth;
      int int_4 = int_2 - int_3 * Rasterizer2D.graphicsPixelsWidth;
      centerX = int_0 - int_4;
      centerY = int_1 - int_3;
      anInt545 = -centerX;
      anInt544 = rasterClipX - centerX;
      anInt546 = -centerY;
      anInt547 = graphicsPixelsBottomY - centerY;
   }

   static void method971(int[] ints_0, int[] ints_1, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8, int int_9, int int_10, int int_11, int int_12) {
      if (restrictEdges) {
         if (int_4 > rasterClipX) {
            int_4 = rasterClipX;
         }

         if (int_3 < 0) {
            int_3 = 0;
         }
      }

      if (int_3 < int_4) {
         int_2 += int_3;
         int_5 += int_3 * int_6;
         int int_13 = int_4 - int_3;
         int int_14;
         int int_15;
         int int_16;
         int int_17;
         int int_18;
         int int_19;
         int int_20;
         int int_21;
         int int_22;
         if (lowMem) {
            int_14 = int_3 - centerX;
            int_7 += int_14 * (int_10 >> 3);
            int_8 += (int_11 >> 3) * int_14;
            int_9 += int_14 * (int_12 >> 3);
            int_16 = int_9 >> 12;
            if (int_16 != 0) {
               int_17 = int_7 / int_16;
               int_18 = int_8 / int_16;
               if (int_17 < 0) {
                  int_17 = 0;
               } else if (int_17 > 4032) {
                  int_17 = 4032;
               }
            } else {
               int_17 = 0;
               int_18 = 0;
            }

            int_7 += int_10;
            int_8 += int_11;
            int_9 += int_12;
            int_16 = int_9 >> 12;
            if (int_16 != 0) {
               int_19 = int_7 / int_16;
               int_20 = int_8 / int_16;
               if (int_19 < 0) {
                  int_19 = 0;
               } else if (int_19 > 4032) {
                  int_19 = 4032;
               }
            } else {
               int_19 = 0;
               int_20 = 0;
            }

            int_0 = (int_17 << 20) + int_18;
            int_21 = (int_20 - int_18 >> 3) + (int_19 - int_17 >> 3 << 20);
            int_13 >>= 3;
            int_6 <<= 3;
            int_22 = int_5 >> 8;
            if (aBool72) {
               if (int_13 > 0) {
                  do {
                     int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                     ints_0[int_2++] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     int_0 += int_21;
                     int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                     ints_0[int_2++] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     int_0 += int_21;
                     int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                     ints_0[int_2++] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     int_0 += int_21;
                     int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                     ints_0[int_2++] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     int_0 += int_21;
                     int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                     ints_0[int_2++] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     int_0 += int_21;
                     int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                     ints_0[int_2++] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     int_0 += int_21;
                     int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                     ints_0[int_2++] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     int_0 += int_21;
                     int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                     ints_0[int_2++] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     int_15 = int_21 + int_0;
                     int_17 = int_19;
                     int_18 = int_20;
                     int_7 += int_10;
                     int_8 += int_11;
                     int_9 += int_12;
                     int_16 = int_9 >> 12;
                     if (int_16 != 0) {
                        int_19 = int_7 / int_16;
                        int_20 = int_8 / int_16;
                        if (int_19 < 0) {
                           int_19 = 0;
                        } else if (int_19 > 4032) {
                           int_19 = 4032;
                        }
                     } else {
                        int_19 = 0;
                        int_20 = 0;
                     }

                     int_0 = (int_17 << 20) + int_18;
                     int_21 = (int_20 - int_18 >> 3) + (int_19 - int_17 >> 3 << 20);
                     int_5 += int_6;
                     int_22 = int_5 >> 8;
                     --int_13;
                  } while (int_13 > 0);
               }

               int_13 = int_4 - int_3 & 0x7;
               if (int_13 > 0) {
                  do {
                     int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                     ints_0[int_2++] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     int_0 += int_21;
                     --int_13;
                  } while (int_13 > 0);
               }
            } else {
               if (int_13 > 0) {
                  do {
                     if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                        ints_0[int_2] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_21;
                     if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                        ints_0[int_2] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_21;
                     if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                        ints_0[int_2] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_21;
                     if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                        ints_0[int_2] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_21;
                     if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                        ints_0[int_2] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_21;
                     if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                        ints_0[int_2] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_21;
                     if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                        ints_0[int_2] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_21;
                     if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                        ints_0[int_2] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_15 = int_21 + int_0;
                     int_17 = int_19;
                     int_18 = int_20;
                     int_7 += int_10;
                     int_8 += int_11;
                     int_9 += int_12;
                     int_16 = int_9 >> 12;
                     if (int_16 != 0) {
                        int_19 = int_7 / int_16;
                        int_20 = int_8 / int_16;
                        if (int_19 < 0) {
                           int_19 = 0;
                        } else if (int_19 > 4032) {
                           int_19 = 4032;
                        }
                     } else {
                        int_19 = 0;
                        int_20 = 0;
                     }

                     int_0 = (int_17 << 20) + int_18;
                     int_21 = (int_20 - int_18 >> 3) + (int_19 - int_17 >> 3 << 20);
                     int_5 += int_6;
                     int_22 = int_5 >> 8;
                     --int_13;
                  } while (int_13 > 0);
               }

               int_13 = int_4 - int_3 & 0x7;
               if (int_13 > 0) {
                  do {
                     if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                        ints_0[int_2] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_21;
                     --int_13;
                  } while (int_13 > 0);
               }
            }
         } else {
            int_14 = int_3 - centerX;
            int_7 += int_14 * (int_10 >> 3);
            int_8 += (int_11 >> 3) * int_14;
            int_9 += int_14 * (int_12 >> 3);
            int_16 = int_9 >> 14;
            if (int_16 != 0) {
               int_17 = int_7 / int_16;
               int_18 = int_8 / int_16;
               if (int_17 < 0) {
                  int_17 = 0;
               } else if (int_17 > 16256) {
                  int_17 = 16256;
               }
            } else {
               int_17 = 0;
               int_18 = 0;
            }

            int_7 += int_10;
            int_8 += int_11;
            int_9 += int_12;
            int_16 = int_9 >> 14;
            if (int_16 != 0) {
               int_19 = int_7 / int_16;
               int_20 = int_8 / int_16;
               if (int_19 < 0) {
                  int_19 = 0;
               } else if (int_19 > 16256) {
                  int_19 = 16256;
               }
            } else {
               int_19 = 0;
               int_20 = 0;
            }

            int_0 = (int_17 << 18) + int_18;
            int_21 = (int_20 - int_18 >> 3) + (int_19 - int_17 >> 3 << 18);
            int_13 >>= 3;
            int_6 <<= 3;
            int_22 = int_5 >> 8;
            if (aBool72) {
               if (int_13 > 0) {
                  do {
                     int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                     ints_0[int_2++] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     int_0 += int_21;
                     int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                     ints_0[int_2++] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     int_0 += int_21;
                     int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                     ints_0[int_2++] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     int_0 += int_21;
                     int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                     ints_0[int_2++] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     int_0 += int_21;
                     int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                     ints_0[int_2++] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     int_0 += int_21;
                     int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                     ints_0[int_2++] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     int_0 += int_21;
                     int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                     ints_0[int_2++] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     int_0 += int_21;
                     int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                     ints_0[int_2++] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     int_15 = int_21 + int_0;
                     int_17 = int_19;
                     int_18 = int_20;
                     int_7 += int_10;
                     int_8 += int_11;
                     int_9 += int_12;
                     int_16 = int_9 >> 14;
                     if (int_16 != 0) {
                        int_19 = int_7 / int_16;
                        int_20 = int_8 / int_16;
                        if (int_19 < 0) {
                           int_19 = 0;
                        } else if (int_19 > 16256) {
                           int_19 = 16256;
                        }
                     } else {
                        int_19 = 0;
                        int_20 = 0;
                     }

                     int_0 = (int_17 << 18) + int_18;
                     int_21 = (int_20 - int_18 >> 3) + (int_19 - int_17 >> 3 << 18);
                     int_5 += int_6;
                     int_22 = int_5 >> 8;
                     --int_13;
                  } while (int_13 > 0);
               }

               int_13 = int_4 - int_3 & 0x7;
               if (int_13 > 0) {
                  do {
                     int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                     ints_0[int_2++] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     int_0 += int_21;
                     --int_13;
                  } while (int_13 > 0);
               }
            } else {
               if (int_13 > 0) {
                  do {
                     if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                        ints_0[int_2] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_21;
                     if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                        ints_0[int_2] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_21;
                     if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                        ints_0[int_2] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_21;
                     if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                        ints_0[int_2] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_21;
                     if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                        ints_0[int_2] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_21;
                     if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                        ints_0[int_2] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_21;
                     if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                        ints_0[int_2] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_21;
                     if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                        ints_0[int_2] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_15 = int_21 + int_0;
                     int_17 = int_19;
                     int_18 = int_20;
                     int_7 += int_10;
                     int_8 += int_11;
                     int_9 += int_12;
                     int_16 = int_9 >> 14;
                     if (int_16 != 0) {
                        int_19 = int_7 / int_16;
                        int_20 = int_8 / int_16;
                        if (int_19 < 0) {
                           int_19 = 0;
                        } else if (int_19 > 16256) {
                           int_19 = 16256;
                        }
                     } else {
                        int_19 = 0;
                        int_20 = 0;
                     }

                     int_0 = (int_17 << 18) + int_18;
                     int_21 = (int_20 - int_18 >> 3) + (int_19 - int_17 >> 3 << 18);
                     int_5 += int_6;
                     int_22 = int_5 >> 8;
                     --int_13;
                  } while (int_13 > 0);
               }

               int_13 = int_4 - int_3 & 0x7;
               if (int_13 > 0) {
                  do {
                     if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                        ints_0[int_2] = (int_22 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_22 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_21;
                     --int_13;
                  } while (int_13 > 0);
               }
            }
         }

      }
   }

   public static void setRasterClippingEnabled(int int_0, int int_1, int int_2) {
      restrictEdges = int_0 < 0 || int_0 > rasterClipX || int_1 < 0 || int_1 > rasterClipX || int_2 < 0 || int_2 > rasterClipX;
   }

   static void method972(int[] ints_0, int[] ints_1, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8, int int_9, int int_10, int int_11, int int_12) {
      if (restrictEdges) {
         if (int_4 > rasterClipX) {
            int_4 = rasterClipX;
         }

         if (int_3 < 0) {
            int_3 = 0;
         }
      }

      if (int_3 < int_4) {
         int_2 += int_3;
         int_5 += int_3 * int_6;
         int int_13 = int_4 - int_3;
         int int_14;
         int int_15;
         int int_16;
         int int_17;
         int int_18;
         int int_19;
         int int_20;
         int int_21;
         if (lowMem) {
            int_14 = int_3 - centerX;
            int_7 += int_14 * int_10;
            int_8 += int_11 * int_14;
            int_9 += int_14 * int_12;
            int_15 = int_9 >> 12;
            if (int_15 != 0) {
               int_16 = int_7 / int_15;
               int_17 = int_8 / int_15;
            } else {
               int_16 = 0;
               int_17 = 0;
            }

            int_7 += int_13 * int_10;
            int_8 += int_11 * int_13;
            int_9 += int_13 * int_12;
            int_15 = int_9 >> 12;
            if (int_15 != 0) {
               int_18 = int_7 / int_15;
               int_19 = int_8 / int_15;
            } else {
               int_18 = 0;
               int_19 = 0;
            }

            int_0 = (int_16 << 20) + int_17;
            int_20 = (int_19 - int_17) / int_13 + ((int_18 - int_16) / int_13 << 20);
            int_13 >>= 3;
            int_6 <<= 3;
            int_21 = int_5 >> 8;
            if (aBool72) {
               if (int_13 > 0) {
                  do {
                     int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                     ints_0[int_2++] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     int_0 += int_20;
                     int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                     ints_0[int_2++] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     int_0 += int_20;
                     int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                     ints_0[int_2++] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     int_0 += int_20;
                     int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                     ints_0[int_2++] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     int_0 += int_20;
                     int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                     ints_0[int_2++] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     int_0 += int_20;
                     int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                     ints_0[int_2++] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     int_0 += int_20;
                     int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                     ints_0[int_2++] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     int_0 += int_20;
                     int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                     ints_0[int_2++] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     int_0 += int_20;
                     int_5 += int_6;
                     int_21 = int_5 >> 8;
                     --int_13;
                  } while (int_13 > 0);
               }

               int_13 = int_4 - int_3 & 0x7;
               if (int_13 > 0) {
                  do {
                     int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                     ints_0[int_2++] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     int_0 += int_20;
                     --int_13;
                  } while (int_13 > 0);
               }
            } else {
               if (int_13 > 0) {
                  do {
                     if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                        ints_0[int_2] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_20;
                     if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                        ints_0[int_2] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_20;
                     if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                        ints_0[int_2] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_20;
                     if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                        ints_0[int_2] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_20;
                     if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                        ints_0[int_2] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_20;
                     if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                        ints_0[int_2] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_20;
                     if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                        ints_0[int_2] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_20;
                     if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                        ints_0[int_2] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_20;
                     int_5 += int_6;
                     int_21 = int_5 >> 8;
                     --int_13;
                  } while (int_13 > 0);
               }

               int_13 = int_4 - int_3 & 0x7;
               if (int_13 > 0) {
                  do {
                     if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                        ints_0[int_2] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_20;
                     --int_13;
                  } while (int_13 > 0);
               }
            }
         } else {
            int_14 = int_3 - centerX;
            int_7 += int_14 * int_10;
            int_8 += int_11 * int_14;
            int_9 += int_14 * int_12;
            int_15 = int_9 >> 14;
            if (int_15 != 0) {
               int_16 = int_7 / int_15;
               int_17 = int_8 / int_15;
            } else {
               int_16 = 0;
               int_17 = 0;
            }

            int_7 += int_13 * int_10;
            int_8 += int_11 * int_13;
            int_9 += int_13 * int_12;
            int_15 = int_9 >> 14;
            if (int_15 != 0) {
               int_18 = int_7 / int_15;
               int_19 = int_8 / int_15;
            } else {
               int_18 = 0;
               int_19 = 0;
            }

            int_0 = (int_16 << 18) + int_17;
            int_20 = (int_19 - int_17) / int_13 + ((int_18 - int_16) / int_13 << 18);
            int_13 >>= 3;
            int_6 <<= 3;
            int_21 = int_5 >> 8;
            if (aBool72) {
               if (int_13 > 0) {
                  do {
                     int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                     ints_0[int_2++] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     int_0 += int_20;
                     int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                     ints_0[int_2++] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     int_0 += int_20;
                     int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                     ints_0[int_2++] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     int_0 += int_20;
                     int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                     ints_0[int_2++] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     int_0 += int_20;
                     int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                     ints_0[int_2++] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     int_0 += int_20;
                     int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                     ints_0[int_2++] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     int_0 += int_20;
                     int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                     ints_0[int_2++] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     int_0 += int_20;
                     int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                     ints_0[int_2++] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     int_0 += int_20;
                     int_5 += int_6;
                     int_21 = int_5 >> 8;
                     --int_13;
                  } while (int_13 > 0);
               }

               int_13 = int_4 - int_3 & 0x7;
               if (int_13 > 0) {
                  do {
                     int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                     ints_0[int_2++] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     int_0 += int_20;
                     --int_13;
                  } while (int_13 > 0);
               }
            } else {
               if (int_13 > 0) {
                  do {
                     if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                        ints_0[int_2] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_20;
                     if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                        ints_0[int_2] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_20;
                     if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                        ints_0[int_2] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_20;
                     if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                        ints_0[int_2] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_20;
                     if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                        ints_0[int_2] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_20;
                     if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                        ints_0[int_2] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_20;
                     if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                        ints_0[int_2] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_20;
                     if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                        ints_0[int_2] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_20;
                     int_5 += int_6;
                     int_21 = int_5 >> 8;
                     --int_13;
                  } while (int_13 > 0);
               }

               int_13 = int_4 - int_3 & 0x7;
               if (int_13 > 0) {
                  do {
                     if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                        ints_0[int_2] = (int_21 * (int_1 & 0xFF00) & 0xFF0000) + ((int_1 & 0xFF00FF) * int_21 & 0xFF00FF00) >> 8;
                     }

                     ++int_2;
                     int_0 += int_20;
                     --int_13;
                  } while (int_13 > 0);
               }
            }
         }

      }
   }

}
