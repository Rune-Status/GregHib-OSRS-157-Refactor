import java.util.Random;

public abstract class FontTypeFace extends Rasterizer2D {

   static int strikeRGB;
   static String[] aStringArray5;
   static int underlineRGB;
   static Random aRandom1;
   static int anInt567;
   static int prevShadeRGB;
   static int prevColorRGB;
   static int color;
   static int shadow;
   static int anInt568;
   static int anInt569;
   public static IndexedSprite[] modIcons;
   int[] anIntArray137;
   public int verticalSpace;
   byte[][] gylphs;
   public int minSpacing;
   public int maxSpacing;
   int[] horizontalOffsets;
   int[] verticalOffsets;
   byte[] aByteArray26;
   int[] gylphHeights;
   int[] glyphWidths;

   static {
      strikeRGB = -1;
      underlineRGB = -1;
      prevShadeRGB = -1;
      shadow = -1;
      prevColorRGB = 0;
      color = 0;
      anInt567 = 256;
      anInt568 = 0;
      anInt569 = 0;
      aRandom1 = new Random();
      aStringArray5 = new String[100];
   }

   FontTypeFace(byte[] bytes_0, int[] ints_0, int[] ints_1, int[] ints_2, int[] ints_3, int[] ints_4, byte[][] bytes_1) {
      this.gylphs = new byte[256][];
      this.verticalSpace = 0;
      this.horizontalOffsets = ints_0;
      this.verticalOffsets = ints_1;
      this.gylphHeights = ints_2;
      this.glyphWidths = ints_3;
      this.method1033(bytes_0);
      this.gylphs = bytes_1;
      int int_0 = Integer.MAX_VALUE;
      int int_1 = Integer.MIN_VALUE;

      for (int int_2 = 0; int_2 < 256; int_2++) {
         if (this.verticalOffsets[int_2] < int_0 && this.glyphWidths[int_2] != 0) {
            int_0 = this.verticalOffsets[int_2];
         }

         if (this.verticalOffsets[int_2] + this.glyphWidths[int_2] > int_1) {
            int_1 = this.verticalOffsets[int_2] + this.glyphWidths[int_2];
         }
      }

      this.minSpacing = this.verticalSpace - int_0;
      this.maxSpacing = int_1 - this.verticalSpace;
   }

   FontTypeFace(byte[] bytes_0) {
      this.gylphs = new byte[256][];
      this.verticalSpace = 0;
      this.method1033(bytes_0);
   }

   void setColor(int int_0, int int_1) {
      strikeRGB = -1;
      underlineRGB = -1;
      prevShadeRGB = int_1;
      shadow = int_1;
      prevColorRGB = int_0;
      color = int_0;
      anInt567 = 256;
      anInt568 = 0;
      anInt569 = 0;
   }

   public int method1030(String string_0) {
      if (string_0 == null) {
         return 0;
      } else {
         int int_0 = -1;
         int int_1 = -1;
         int int_2 = 0;

         for (int int_3 = 0; int_3 < string_0.length(); int_3++) {
            char char_0 = string_0.charAt(int_3);
            if (char_0 == 60) {
               int_0 = int_3;
            } else {
               if (char_0 == 62 && int_0 != -1) {
                  String string_1 = string_0.substring(int_0 + 1, int_3);
                  int_0 = -1;
                  if (string_1.equals("lt")) {
                     char_0 = 60;
                  } else {
                     if (!string_1.equals("gt")) {
                        if (string_1.startsWith("img=")) {
                           try {
                              int int_4 = Class27.method225(string_1.substring(4));
                              int_2 += modIcons[int_4].width;
                              int_1 = -1;
                           } catch (Exception exception_0) {
                              ;
                           }
                        }
                        continue;
                     }

                     char_0 = 62;
                  }
               }

               if (char_0 == 160) {
                  char_0 = 32;
               }

               if (int_0 == -1) {
                  int_2 += this.anIntArray137[(char)(Class99.method524(char_0) & 0xFF)];
                  if (this.aByteArray26 != null && int_1 != -1) {
                     int_2 += this.aByteArray26[char_0 + (int_1 << 8)];
                  }

                  int_1 = char_0;
               }
            }
         }

         return int_2;
      }
   }

   public int method1031(String string_0, int[] ints_0, String[] strings_0) {
      if (string_0 == null) {
         return 0;
      } else {
         int int_0 = 0;
         int int_1 = 0;
         StringBuilder stringbuilder_0 = new StringBuilder(100);
         int int_2 = -1;
         int int_3 = 0;
         byte byte_0 = 0;
         int int_4 = -1;
         char char_0 = 0;
         int int_5 = 0;
         int int_6 = string_0.length();

         for (int int_7 = 0; int_7 < int_6; int_7++) {
            char char_1 = string_0.charAt(int_7);
            if (char_1 == 60) {
               int_4 = int_7;
            } else {
               if (char_1 == 62 && int_4 != -1) {
                  String string_2 = string_0.substring(int_4 + 1, int_7);
                  int_4 = -1;
                  stringbuilder_0.append('<');
                  stringbuilder_0.append(string_2);
                  stringbuilder_0.append('>');
                  if (string_2.equals("br")) {
                     strings_0[int_5] = stringbuilder_0.toString().substring(int_1, stringbuilder_0.length());
                     ++int_5;
                     int_1 = stringbuilder_0.length();
                     int_0 = 0;
                     int_2 = -1;
                     char_0 = 0;
                  } else if (string_2.equals("lt")) {
                     int_0 += this.method1034('<');
                     if (this.aByteArray26 != null && char_0 != -1) {
                        int_0 += this.aByteArray26[(char_0 << 8) + 60];
                     }

                     char_0 = 60;
                  } else if (string_2.equals("gt")) {
                     int_0 += this.method1034('>');
                     if (this.aByteArray26 != null && char_0 != -1) {
                        int_0 += this.aByteArray26[(char_0 << 8) + 62];
                     }

                     char_0 = 62;
                  } else if (string_2.startsWith("img=")) {
                     try {
                        int int_8 = Class27.method225(string_2.substring(4));
                        int_0 += modIcons[int_8].width;
                        char_0 = 0;
                     } catch (Exception exception_0) {
                        ;
                     }
                  }

                  char_1 = 0;
               }

               if (int_4 == -1) {
                  if (char_1 != 0) {
                     stringbuilder_0.append(char_1);
                     int_0 += this.method1034(char_1);
                     if (this.aByteArray26 != null && char_0 != -1) {
                        int_0 += this.aByteArray26[char_1 + (char_0 << 8)];
                     }

                     char_0 = char_1;
                  }

                  if (char_1 == 32) {
                     int_2 = stringbuilder_0.length();
                     int_3 = int_0;
                     byte_0 = 1;
                  }

                  if (ints_0 != null && int_0 > ints_0[int_5 < ints_0.length ? int_5 : ints_0.length - 1] && int_2 >= 0) {
                     strings_0[int_5] = stringbuilder_0.toString().substring(int_1, int_2 - byte_0);
                     ++int_5;
                     int_1 = int_2;
                     int_2 = -1;
                     int_0 -= int_3;
                     char_0 = 0;
                  }

                  if (char_1 == 45) {
                     int_2 = stringbuilder_0.length();
                     int_3 = int_0;
                     byte_0 = 0;
                  }
               }
            }
         }

         String string_1 = stringbuilder_0.toString();
         if (string_1.length() > int_1) {
            strings_0[int_5++] = string_1.substring(int_1, string_1.length());
         }

         return int_5;
      }
   }

   void method1032(String string_0, int int_0, int int_1) {
      int_1 -= this.verticalSpace;
      int int_2 = -1;
      int int_3 = -1;

      for (int int_4 = 0; int_4 < string_0.length(); int_4++) {
         if (string_0.charAt(int_4) != 0) {
            char char_0 = (char)(Class99.method524(string_0.charAt(int_4)) & 0xFF);
            if (char_0 == 60) {
               int_2 = int_4;
            } else {
               int int_6;
               if (char_0 == 62 && int_2 != -1) {
                  String string_1 = string_0.substring(int_2 + 1, int_4);
                  int_2 = -1;
                  if (string_1.equals("lt")) {
                     char_0 = 60;
                  } else {
                     if (!string_1.equals("gt")) {
                        if (string_1.startsWith("img=")) {
                           try {
                              int_6 = Class27.method225(string_1.substring(4));
                              IndexedSprite indexedsprite_0 = modIcons[int_6];
                              indexedsprite_0.method975(int_0, int_1 + this.verticalSpace - indexedsprite_0.originalHeight);
                              int_0 += indexedsprite_0.width;
                              int_3 = -1;
                           } catch (Exception exception_0) {
                              ;
                           }
                        } else {
                           this.setRGB(string_1);
                        }
                        continue;
                     }

                     char_0 = 62;
                  }
               }

               if (char_0 == 160) {
                  char_0 = 32;
               }

               if (int_2 == -1) {
                  if (this.aByteArray26 != null && int_3 != -1) {
                     int_0 += this.aByteArray26[char_0 + (int_3 << 8)];
                  }

                  int int_5 = this.gylphHeights[char_0];
                  int_6 = this.glyphWidths[char_0];
                  if (char_0 != 32) {
                     if (anInt567 == 256) {
                        if (shadow != -1) {
                           renderShadeRGB(this.gylphs[char_0], int_0 + this.horizontalOffsets[char_0] + 1, int_1 + this.verticalOffsets[char_0] + 1, int_5, int_6, shadow);
                        }

                        this.renderRGB(this.gylphs[char_0], int_0 + this.horizontalOffsets[char_0], int_1 + this.verticalOffsets[char_0], int_5, int_6, color);
                     } else {
                        if (shadow != -1) {
                           renderShadeRGBA(this.gylphs[char_0], int_0 + this.horizontalOffsets[char_0] + 1, int_1 + this.verticalOffsets[char_0] + 1, int_5, int_6, shadow, anInt567);
                        }

                        this.renderRGBA(this.gylphs[char_0], int_0 + this.horizontalOffsets[char_0], int_1 + this.verticalOffsets[char_0], int_5, int_6, color, anInt567);
                     }
                  } else if (anInt568 > 0) {
                     anInt569 += anInt568;
                     int_0 += anInt569 >> 8;
                     anInt569 &= 0xFF;
                  }

                  int int_7 = this.anIntArray137[char_0];
                  if (strikeRGB != -1) {
                     Rasterizer2D.method920(int_0, int_1 + (int)((double)this.verticalSpace * 0.7D), int_7, strikeRGB);
                  }

                  if (underlineRGB != -1) {
                     Rasterizer2D.method920(int_0, int_1 + this.verticalSpace + 1, int_7, underlineRGB);
                  }

                  int_0 += int_7;
                  int_3 = char_0;
               }
            }
         }
      }

   }

   void method1033(byte[] bytes_0) {
      this.anIntArray137 = new int[256];
      int int_0;
      if (bytes_0.length == 257) {
         for (int_0 = 0; int_0 < this.anIntArray137.length; int_0++) {
            this.anIntArray137[int_0] = bytes_0[int_0] & 0xFF;
         }

         this.verticalSpace = bytes_0[256] & 0xFF;
      } else {
         int_0 = 0;

         for (int int_1 = 0; int_1 < 256; int_1++) {
            this.anIntArray137[int_1] = bytes_0[int_0++] & 0xFF;
         }

         int[] ints_0 = new int[256];
         int[] ints_1 = new int[256];

         int int_2;
         for (int_2 = 0; int_2 < 256; int_2++) {
            ints_0[int_2] = bytes_0[int_0++] & 0xFF;
         }

         for (int_2 = 0; int_2 < 256; int_2++) {
            ints_1[int_2] = bytes_0[int_0++] & 0xFF;
         }

         byte[][] bytes_1 = new byte[256][];

         int int_4;
         for (int int_3 = 0; int_3 < 256; int_3++) {
            bytes_1[int_3] = new byte[ints_0[int_3]];
            byte byte_0 = 0;

            for (int_4 = 0; int_4 < bytes_1[int_3].length; int_4++) {
               byte_0 += bytes_0[int_0++];
               bytes_1[int_3][int_4] = byte_0;
            }
         }

         byte[][] bytes_2 = new byte[256][];

         int int_6;
         for (int_6 = 0; int_6 < 256; int_6++) {
            bytes_2[int_6] = new byte[ints_0[int_6]];
            byte byte_1 = 0;

            for (int int_5 = 0; int_5 < bytes_2[int_6].length; int_5++) {
               byte_1 += bytes_0[int_0++];
               bytes_2[int_6][int_5] = byte_1;
            }
         }

         this.aByteArray26 = new byte[65536];

         for (int_6 = 0; int_6 < 256; int_6++) {
            if (int_6 != 32 && int_6 != 160) {
               for (int_4 = 0; int_4 < 256; int_4++) {
                  if (int_4 != 32 && int_4 != 160) {
                     this.aByteArray26[int_4 + (int_6 << 8)] = (byte)method1046(bytes_1, bytes_2, ints_1, this.anIntArray137, ints_0, int_6, int_4);
                  }
               }
            }
         }

         this.verticalSpace = ints_1[32] + ints_0[32];
      }

   }

   void drawMouseoverText(String string_0, int int_0, int int_1, int[] ints_0, int[] ints_1) {
      int_1 -= this.verticalSpace;
      int int_2 = -1;
      int int_3 = -1;
      int int_4 = 0;

      for (int int_5 = 0; int_5 < string_0.length(); int_5++) {
         if (string_0.charAt(int_5) != 0) {
            char char_0 = (char)(Class99.method524(string_0.charAt(int_5)) & 0xFF);
            if (char_0 == 60) {
               int_2 = int_5;
            } else {
               int int_7;
               int int_8;
               int int_9;
               if (char_0 == 62 && int_2 != -1) {
                  String string_1 = string_0.substring(int_2 + 1, int_5);
                  int_2 = -1;
                  if (string_1.equals("lt")) {
                     char_0 = 60;
                  } else {
                     if (!string_1.equals("gt")) {
                        if (string_1.startsWith("img=")) {
                           try {
                              if (ints_0 != null) {
                                 int_7 = ints_0[int_4];
                              } else {
                                 int_7 = 0;
                              }

                              if (ints_1 != null) {
                                 int_8 = ints_1[int_4];
                              } else {
                                 int_8 = 0;
                              }

                              ++int_4;
                              int_9 = Class27.method225(string_1.substring(4));
                              IndexedSprite indexedsprite_0 = modIcons[int_9];
                              indexedsprite_0.method975(int_7 + int_0, int_8 + (int_1 + this.verticalSpace - indexedsprite_0.originalHeight));
                              int_0 += indexedsprite_0.width;
                              int_3 = -1;
                           } catch (Exception exception_0) {
                              ;
                           }
                        } else {
                           this.setRGB(string_1);
                        }
                        continue;
                     }

                     char_0 = 62;
                  }
               }

               if (char_0 == 160) {
                  char_0 = 32;
               }

               if (int_2 == -1) {
                  if (this.aByteArray26 != null && int_3 != -1) {
                     int_0 += this.aByteArray26[char_0 + (int_3 << 8)];
                  }

                  int int_6 = this.gylphHeights[char_0];
                  int_7 = this.glyphWidths[char_0];
                  if (ints_0 != null) {
                     int_8 = ints_0[int_4];
                  } else {
                     int_8 = 0;
                  }

                  if (ints_1 != null) {
                     int_9 = ints_1[int_4];
                  } else {
                     int_9 = 0;
                  }

                  ++int_4;
                  if (char_0 != 32) {
                     if (anInt567 == 256) {
                        if (shadow != -1) {
                           renderShadeRGB(this.gylphs[char_0], int_8 + int_0 + this.horizontalOffsets[char_0] + 1, int_1 + int_9 + this.verticalOffsets[char_0] + 1, int_6, int_7, shadow);
                        }

                        this.renderRGB(this.gylphs[char_0], int_8 + int_0 + this.horizontalOffsets[char_0], int_1 + int_9 + this.verticalOffsets[char_0], int_6, int_7, color);
                     } else {
                        if (shadow != -1) {
                           renderShadeRGBA(this.gylphs[char_0], int_8 + int_0 + this.horizontalOffsets[char_0] + 1, int_1 + int_9 + this.verticalOffsets[char_0] + 1, int_6, int_7, shadow, anInt567);
                        }

                        this.renderRGBA(this.gylphs[char_0], int_8 + int_0 + this.horizontalOffsets[char_0], int_1 + int_9 + this.verticalOffsets[char_0], int_6, int_7, color, anInt567);
                     }
                  } else if (anInt568 > 0) {
                     anInt569 += anInt568;
                     int_0 += anInt569 >> 8;
                     anInt569 &= 0xFF;
                  }

                  int int_10 = this.anIntArray137[char_0];
                  if (strikeRGB != -1) {
                     Rasterizer2D.method920(int_0, int_1 + (int)((double)this.verticalSpace * 0.7D), int_10, strikeRGB);
                  }

                  if (underlineRGB != -1) {
                     Rasterizer2D.method920(int_0, int_1 + this.verticalSpace, int_10, underlineRGB);
                  }

                  int_0 += int_10;
                  int_3 = char_0;
               }
            }
         }
      }

   }

   int method1034(char char_0) {
      if (char_0 == 160) {
         char_0 = 32;
      }

      return this.anIntArray137[Class99.method524(char_0) & 0xFF];
   }

   public int method1035(String string_0, int int_0) {
      return this.method1031(string_0, new int[] {int_0}, aStringArray5);
   }

   void setRGB(String string_0) {
      try {
         if (string_0.startsWith("col=")) {
            color = Class98.method522(string_0.substring(4), 16);
         } else if (string_0.equals("/col")) {
            color = prevColorRGB;
         } else if (string_0.startsWith("str=")) {
            strikeRGB = Class98.method522(string_0.substring(4), 16);
         } else if (string_0.equals("str")) {
            strikeRGB = 8388608;
         } else if (string_0.equals("/str")) {
            strikeRGB = -1;
         } else if (string_0.startsWith("u=")) {
            underlineRGB = Class98.method522(string_0.substring(2), 16);
         } else if (string_0.equals("u")) {
            underlineRGB = 0;
         } else if (string_0.equals("/u")) {
            underlineRGB = -1;
         } else if (string_0.startsWith("shad=")) {
            shadow = Class98.method522(string_0.substring(5), 16);
         } else if (string_0.equals("shad")) {
            shadow = 0;
         } else if (string_0.equals("/shad")) {
            shadow = prevShadeRGB;
         } else if (string_0.equals("br")) {
            this.setColor(prevColorRGB, prevShadeRGB);
         }
      } catch (Exception exception_0) {
         ;
      }

   }

   public int method1036(String string_0, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8) {
      if (string_0 == null) {
         return 0;
      } else {
         this.setColor(int_4, int_5);
         if (int_8 == 0) {
            int_8 = this.verticalSpace;
         }

         int[] ints_0 = new int[] {int_2};
         if (int_3 < int_8 + this.minSpacing + this.maxSpacing && int_3 < int_8 + int_8) {
            ints_0 = null;
         }

         int int_9 = this.method1031(string_0, ints_0, aStringArray5);
         if (int_7 == 3 && int_9 == 1) {
            int_7 = 1;
         }

         int int_10;
         int int_11;
         if (int_7 == 0) {
            int_10 = int_1 + this.minSpacing;
         } else if (int_7 == 1) {
            int_10 = int_1 + (int_3 - this.minSpacing - this.maxSpacing - int_8 * (int_9 - 1)) / 2 + this.minSpacing;
         } else if (int_7 == 2) {
            int_10 = int_1 + int_3 - this.maxSpacing - int_8 * (int_9 - 1);
         } else {
            int_11 = (int_3 - this.minSpacing - this.maxSpacing - int_8 * (int_9 - 1)) / (int_9 + 1);
            if (int_11 < 0) {
               int_11 = 0;
            }

            int_10 = int_1 + int_11 + this.minSpacing;
            int_8 += int_11;
         }

         for (int_11 = 0; int_11 < int_9; int_11++) {
            if (int_6 == 0) {
               this.method1032(aStringArray5[int_11], int_0, int_10);
            } else if (int_6 == 1) {
               this.method1032(aStringArray5[int_11], int_0 + (int_2 - this.method1030(aStringArray5[int_11])) / 2, int_10);
            } else if (int_6 == 2) {
               this.method1032(aStringArray5[int_11], int_0 + int_2 - this.method1030(aStringArray5[int_11]), int_10);
            } else if (int_11 == int_9 - 1) {
               this.method1032(aStringArray5[int_11], int_0, int_10);
            } else {
               this.method1037(aStringArray5[int_11], int_2);
               this.method1032(aStringArray5[int_11], int_0, int_10);
               anInt568 = 0;
            }

            int_10 += int_8;
         }

         return int_9;
      }
   }

   void method1037(String string_0, int int_0) {
      int int_1 = 0;
      boolean bool_0 = false;

      for (int int_2 = 0; int_2 < string_0.length(); int_2++) {
         char char_0 = string_0.charAt(int_2);
         if (char_0 == 60) {
            bool_0 = true;
         } else if (char_0 == 62) {
            bool_0 = false;
         } else if (!bool_0 && char_0 == 32) {
            ++int_1;
         }
      }

      if (int_1 > 0) {
         anInt568 = (int_0 - this.method1030(string_0) << 8) / int_1;
      }

   }

   abstract void renderRGB(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   abstract void renderRGBA(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   public int method1038(String string_0, int int_0) {
      int int_1 = this.method1031(string_0, new int[] {int_0}, aStringArray5);
      int int_2 = 0;

      for (int int_3 = 0; int_3 < int_1; int_3++) {
         int int_4 = this.method1030(aStringArray5[int_3]);
         if (int_4 > int_2) {
            int_2 = int_4;
         }
      }

      return int_2;
   }

   public void drawRandomizedMouseoverText(String string_0, int int_0, int int_1, int int_2, int int_3, int int_4) {
      if (string_0 != null) {
         this.setColor(int_2, int_3);
         aRandom1.setSeed((long)int_4);
         anInt567 = 192 + (aRandom1.nextInt() & 0x1F);
         int[] ints_0 = new int[string_0.length()];
         int int_5 = 0;

         for (int int_6 = 0; int_6 < string_0.length(); int_6++) {
            ints_0[int_6] = int_5;
            if ((aRandom1.nextInt() & 0x3) == 0) {
               ++int_5;
            }
         }

         this.drawMouseoverText(string_0, int_0, int_1, ints_0, (int[]) null);
      }
   }

   public void method1039(String string_0, int int_0, int int_1, int int_2, int int_3) {
      if (string_0 != null) {
         this.setColor(int_2, int_3);
         this.method1032(string_0, int_0 - this.method1030(string_0) / 2, int_1);
      }
   }

   public void method1040(String string_0, int int_0, int int_1, int int_2, int int_3) {
      if (string_0 != null) {
         this.setColor(int_2, int_3);
         this.method1032(string_0, int_0, int_1);
      }
   }

   public void method1041(String string_0, int int_0, int int_1, int int_2, int int_3) {
      if (string_0 != null) {
         this.setColor(int_2, int_3);
         this.method1032(string_0, int_0 - this.method1030(string_0), int_1);
      }
   }

   public void method1042(String string_0, int int_0, int int_1, int int_2, int int_3, int int_4) {
      if (string_0 != null) {
         this.setColor(int_2, int_3);
         int[] ints_0 = new int[string_0.length()];

         for (int int_5 = 0; int_5 < string_0.length(); int_5++) {
            ints_0[int_5] = (int)(Math.sin((double)int_5 / 2.0D + (double)int_4 / 5.0D) * 5.0D);
         }

         this.drawMouseoverText(string_0, int_0 - this.method1030(string_0) / 2, int_1, (int[]) null, ints_0);
      }
   }

   public void method1043(String string_0, int int_0, int int_1, int int_2, int int_3, int int_4) {
      if (string_0 != null) {
         this.setColor(int_2, int_3);
         int[] ints_0 = new int[string_0.length()];
         int[] ints_1 = new int[string_0.length()];

         for (int int_5 = 0; int_5 < string_0.length(); int_5++) {
            ints_0[int_5] = (int)(Math.sin((double)int_5 / 5.0D + (double)int_4 / 5.0D) * 5.0D);
            ints_1[int_5] = (int)(Math.sin((double)int_5 / 3.0D + (double)int_4 / 5.0D) * 5.0D);
         }

         this.drawMouseoverText(string_0, int_0 - this.method1030(string_0) / 2, int_1, ints_0, ints_1);
      }
   }

   public void method1044(String string_0, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      if (string_0 != null) {
         this.setColor(int_2, int_3);
         double double_0 = 7.0D - (double)int_5 / 8.0D;
         if (double_0 < 0.0D) {
            double_0 = 0.0D;
         }

         int[] ints_0 = new int[string_0.length()];

         for (int int_6 = 0; int_6 < string_0.length(); int_6++) {
            ints_0[int_6] = (int)(Math.sin((double)int_6 / 1.5D + (double)int_4 / 1.0D) * double_0);
         }

         this.drawMouseoverText(string_0, int_0 - this.method1030(string_0) / 2, int_1, (int[]) null, ints_0);
      }
   }

   public void method1045(String string_0, int int_0, int int_1, int int_2, int int_3, int int_4) {
      if (string_0 != null) {
         this.setColor(int_2, int_3);
         anInt567 = int_4;
         this.method1032(string_0, int_0, int_1);
      }
   }

   static int method1046(byte[][] bytes_0, byte[][] bytes_1, int[] ints_0, int[] ints_1, int[] ints_2, int int_0, int int_1) {
      int int_2 = ints_0[int_0];
      int int_3 = int_2 + ints_2[int_0];
      int int_4 = ints_0[int_1];
      int int_5 = int_4 + ints_2[int_1];
      int int_6 = int_2;
      if (int_4 > int_2) {
         int_6 = int_4;
      }

      int int_7 = int_3;
      if (int_5 < int_3) {
         int_7 = int_5;
      }

      int int_8 = ints_1[int_0];
      if (ints_1[int_1] < int_8) {
         int_8 = ints_1[int_1];
      }

      byte[] bytes_2 = bytes_1[int_0];
      byte[] bytes_3 = bytes_0[int_1];
      int int_9 = int_6 - int_2;
      int int_10 = int_6 - int_4;

      for (int int_11 = int_6; int_11 < int_7; int_11++) {
         int int_12 = bytes_2[int_9++] + bytes_3[int_10++];
         if (int_12 < int_8) {
            int_8 = int_12;
         }
      }

      return -int_8;
   }

   static void renderShadeRGB(byte[] bytes_0, int int_0, int int_1, int int_2, int int_3, int int_4) {
      int int_5 = int_0 + int_1 * Rasterizer2D.graphicsPixelsWidth;
      int int_6 = Rasterizer2D.graphicsPixelsWidth - int_2;
      int int_7 = 0;
      int int_8 = 0;
      int int_9;
      if (int_1 < Rasterizer2D.drawingAreaTop) {
         int_9 = Rasterizer2D.drawingAreaTop - int_1;
         int_3 -= int_9;
         int_1 = Rasterizer2D.drawingAreaTop;
         int_8 += int_2 * int_9;
         int_5 += int_9 * Rasterizer2D.graphicsPixelsWidth;
      }

      if (int_1 + int_3 > Rasterizer2D.drawingAreaRight) {
         int_3 -= int_1 + int_3 - Rasterizer2D.drawingAreaRight;
      }

      if (int_0 < Rasterizer2D.draw_region_x) {
         int_9 = Rasterizer2D.draw_region_x - int_0;
         int_2 -= int_9;
         int_0 = Rasterizer2D.draw_region_x;
         int_8 += int_9;
         int_5 += int_9;
         int_7 += int_9;
         int_6 += int_9;
      }

      if (int_2 + int_0 > Rasterizer2D.drawingAreaBottom) {
         int_9 = int_2 + int_0 - Rasterizer2D.drawingAreaBottom;
         int_2 -= int_9;
         int_7 += int_9;
         int_6 += int_9;
      }

      if (int_2 > 0 && int_3 > 0) {
         render(Rasterizer2D.graphicsPixels, bytes_0, int_4, int_8, int_5, int_2, int_3, int_6, int_7);
      }
   }

   static void render(int[] ints_0, byte[] bytes_0, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6) {
      int int_7 = -(int_3 >> 2);
      int_3 = -(int_3 & 0x3);

      for (int int_8 = -int_4; int_8 < 0; int_8++) {
         int int_9;
         for (int_9 = int_7; int_9 < 0; int_9++) {
            if (bytes_0[int_1++] != 0) {
               ints_0[int_2++] = int_0;
            } else {
               ++int_2;
            }

            if (bytes_0[int_1++] != 0) {
               ints_0[int_2++] = int_0;
            } else {
               ++int_2;
            }

            if (bytes_0[int_1++] != 0) {
               ints_0[int_2++] = int_0;
            } else {
               ++int_2;
            }

            if (bytes_0[int_1++] != 0) {
               ints_0[int_2++] = int_0;
            } else {
               ++int_2;
            }
         }

         for (int_9 = int_3; int_9 < 0; int_9++) {
            if (bytes_0[int_1++] != 0) {
               ints_0[int_2++] = int_0;
            } else {
               ++int_2;
            }
         }

         int_2 += int_5;
         int_1 += int_6;
      }

   }

   static void renderRGBA(int[] ints_0, byte[] bytes_0, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7) {
      int_0 = ((int_0 & 0xFF00) * int_7 & 0xFF0000) + (int_7 * (int_0 & 0xFF00FF) & 0xFF00FF00) >> 8;
      int_7 = 256 - int_7;

      for (int int_8 = -int_4; int_8 < 0; int_8++) {
         for (int int_9 = -int_3; int_9 < 0; int_9++) {
            if (bytes_0[int_1++] != 0) {
               int int_10 = ints_0[int_2];
               ints_0[int_2++] = (((int_10 & 0xFF00) * int_7 & 0xFF0000) + ((int_10 & 0xFF00FF) * int_7 & 0xFF00FF00) >> 8) + int_0;
            } else {
               ++int_2;
            }
         }

         int_2 += int_5;
         int_1 += int_6;
      }

   }

   static void renderShadeRGBA(byte[] bytes_0, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      int int_6 = int_0 + int_1 * Rasterizer2D.graphicsPixelsWidth;
      int int_7 = Rasterizer2D.graphicsPixelsWidth - int_2;
      int int_8 = 0;
      int int_9 = 0;
      int int_10;
      if (int_1 < Rasterizer2D.drawingAreaTop) {
         int_10 = Rasterizer2D.drawingAreaTop - int_1;
         int_3 -= int_10;
         int_1 = Rasterizer2D.drawingAreaTop;
         int_9 += int_2 * int_10;
         int_6 += int_10 * Rasterizer2D.graphicsPixelsWidth;
      }

      if (int_1 + int_3 > Rasterizer2D.drawingAreaRight) {
         int_3 -= int_1 + int_3 - Rasterizer2D.drawingAreaRight;
      }

      if (int_0 < Rasterizer2D.draw_region_x) {
         int_10 = Rasterizer2D.draw_region_x - int_0;
         int_2 -= int_10;
         int_0 = Rasterizer2D.draw_region_x;
         int_9 += int_10;
         int_6 += int_10;
         int_8 += int_10;
         int_7 += int_10;
      }

      if (int_2 + int_0 > Rasterizer2D.drawingAreaBottom) {
         int_10 = int_2 + int_0 - Rasterizer2D.drawingAreaBottom;
         int_2 -= int_10;
         int_8 += int_10;
         int_7 += int_10;
      }

      if (int_2 > 0 && int_3 > 0) {
         renderRGBA(Rasterizer2D.graphicsPixels, bytes_0, int_4, int_9, int_6, int_2, int_3, int_7, int_8, int_5);
      }
   }

   public static String appendTags(String string_0) {
      int int_0 = string_0.length();
      int int_1 = 0;

      for (int int_2 = 0; int_2 < int_0; int_2++) {
         char char_0 = string_0.charAt(int_2);
         if (char_0 == 60 || char_0 == 62) {
            int_1 += 3;
         }
      }

      StringBuilder stringbuilder_0 = new StringBuilder(int_0 + int_1);

      for (int int_3 = 0; int_3 < int_0; int_3++) {
         char char_1 = string_0.charAt(int_3);
         if (char_1 == 60) {
            stringbuilder_0.append("<lt>");
         } else if (char_1 == 62) {
            stringbuilder_0.append("<gt>");
         } else {
            stringbuilder_0.append(char_1);
         }
      }

      return stringbuilder_0.toString();
   }

}
