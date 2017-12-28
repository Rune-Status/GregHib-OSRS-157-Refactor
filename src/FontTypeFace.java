import java.util.Random;

public abstract class FontTypeFace extends Rasterizer2D {

   static int strikethroughRGB;
   static String[] aStringArray5;
   static int underlineRGB;
   static Random aRandom1;
   static int anInt567;
   static int prevShadeRGB;
   static int prevColourRGB;
   static int colour;
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
      strikethroughRGB = -1;
      underlineRGB = -1;
      prevShadeRGB = -1;
      shadow = -1;
      prevColourRGB = 0;
      colour = 0;
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

   public static int getInteger(CharSequence sequence, int length) {
      return Enum5.parseInt(sequence, length);
   }

   public static int getInteger(CharSequence sequence) {
      return Enum5.parseInt(sequence, 10);
   }

   void setAttributes(int colour, int shadow) {
      strikethroughRGB = -1;
      underlineRGB = -1;
      prevShadeRGB = shadow;
      FontTypeFace.shadow = shadow;
      prevColourRGB = colour;
      FontTypeFace.colour = colour;
      anInt567 = 256;
      anInt568 = 0;
      anInt569 = 0;
   }

   public int getWidth(String string) {
      if (string == null) {
         return 0;
      } else {
         int tagStart = -1;
         int previousCharacter = -1;
         int width = 0;

         for (int index = 0; index < string.length(); index++) {
            char character = string.charAt(index);
            if (character == 60) {
               tagStart = index;
            } else {
               if (character == 62 && tagStart != -1) {
                  String tagText = string.substring(tagStart + 1, index);
                  tagStart = -1;
                  if (tagText.equals("lt")) {
                     character = 60;
                  } else {
                     if (!tagText.equals("gt")) {
                        if (tagText.startsWith("img=")) {
                           try {
                              int id = getInteger(tagText.substring(4));
                              width += modIcons[id].width;
                              previousCharacter = -1;
                           } catch (Exception exception_0) {
                              ;
                           }
                        }
                        continue;
                     }

                     character = 62;
                  }
               }

               if (character == 160) {
                  character = 32;
               }

               if (tagStart == -1) {
                  width += this.anIntArray137[(char)(Class99.convertCharacter(character) & 0xFF)];
                  if (this.aByteArray26 != null && previousCharacter != -1) {
                     width += this.aByteArray26[character + (previousCharacter << 8)];
                  }

                  previousCharacter = character;
               }
            }
         }

         return width;
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
                        int int_8 = getInteger(string_2.substring(4));
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

   void drawString(String string, int x, int y) {
      y -= this.verticalSpace;
      int tagStart = -1;
      int previousCharacter = -1;

      for (int index = 0; index < string.length(); index++) {
         if (string.charAt(index) != 0) {
            char character = (char)(Class99.convertCharacter(string.charAt(index)) & 0xFF);
            if (character == 60) {
               tagStart = index;
            } else {
               int iconId;
               if (character == 62 && tagStart != -1) {
                  String tagText = string.substring(tagStart + 1, index);
                  tagStart = -1;
                  if (tagText.equals("lt")) {
                     character = 60;
                  } else {
                     if (!tagText.equals("gt")) {
                        if (tagText.startsWith("img=")) {
                           try {
                              iconId = getInteger(tagText.substring(4));
                              IndexedSprite sprite = modIcons[iconId];
                              sprite.drawSprite(x, y + this.verticalSpace - sprite.originalHeight);
                              x += sprite.width;
                              previousCharacter = -1;
                           } catch (Exception exception_0) {
                              ;
                           }
                        } else {
                           this.setAttribute(tagText);
                        }
                        continue;
                     }

                     character = 62;
                  }
               }

               if (character == 160) {
                  character = 32;
               }

               if (tagStart == -1) {
                  if (this.aByteArray26 != null && previousCharacter != -1) {
                     x += this.aByteArray26[character + (previousCharacter << 8)];
                  }

                  int int_5 = this.gylphHeights[character];
                  iconId = this.glyphWidths[character];
                  if (character != 32) {
                     if (anInt567 == 256) {
                        if (shadow != -1) {
                           renderShadeRGB(this.gylphs[character], x + this.horizontalOffsets[character] + 1, y + this.verticalOffsets[character] + 1, int_5, iconId, shadow);
                        }

                        this.renderRGB(this.gylphs[character], x + this.horizontalOffsets[character], y + this.verticalOffsets[character], int_5, iconId, colour);
                     } else {
                        if (shadow != -1) {
                           renderShadeRGBA(this.gylphs[character], x + this.horizontalOffsets[character] + 1, y + this.verticalOffsets[character] + 1, int_5, iconId, shadow, anInt567);
                        }

                        this.renderRGBA(this.gylphs[character], x + this.horizontalOffsets[character], y + this.verticalOffsets[character], int_5, iconId, colour, anInt567);
                     }
                  } else if (anInt568 > 0) {
                     anInt569 += anInt568;
                     x += anInt569 >> 8;
                     anInt569 &= 0xFF;
                  }

                  int length = this.anIntArray137[character];
                  if (strikethroughRGB != -1) {
                     Rasterizer2D.drawHorizontal(x, y + (int)((double)this.verticalSpace * 0.7D), length, strikethroughRGB);
                  }

                  if (underlineRGB != -1) {
                     Rasterizer2D.drawHorizontal(x, y + this.verticalSpace + 1, length, underlineRGB);
                  }

                  x += length;
                  previousCharacter = character;
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

   void drawMouseoverText(String string, int x, int y, int[] widths, int[] heights) {
      y -= this.verticalSpace;
      int tagStart = -1;
      int previousCharacter = -1;
      int count = 0;

      for (int index = 0; index < string.length(); index++) {
         if (string.charAt(index) != 0) {
            char character = (char)(Class99.convertCharacter(string.charAt(index)) & 0xFF);
            if (character == 60) {
               tagStart = index;
            } else {
               int width;
               int height;
               int id;
               if (character == 62 && tagStart != -1) {
                  String tagText = string.substring(tagStart + 1, index);
                  tagStart = -1;
                  if (tagText.equals("lt")) {
                     character = 60;
                  } else {
                     if (!tagText.equals("gt")) {
                        if (tagText.startsWith("img=")) {
                           try {
                              if (widths != null) {
                                 width = widths[count];
                              } else {
                                 width = 0;
                              }

                              if (heights != null) {
                                 height = heights[count];
                              } else {
                                 height = 0;
                              }

                              ++count;
                              id = getInteger(tagText.substring(4));
                              IndexedSprite sprite = modIcons[id];
                              sprite.drawSprite(width + x, height + (y + this.verticalSpace - sprite.originalHeight));
                              x += sprite.width;
                              previousCharacter = -1;
                           } catch (Exception exception_0) {
                              ;
                           }
                        } else {
                           this.setAttribute(tagText);
                        }
                        continue;
                     }

                     character = 62;
                  }
               }

               if (character == 160) {
                  character = 32;
               }

               if (tagStart == -1) {
                  if (this.aByteArray26 != null && previousCharacter != -1) {
                     x += this.aByteArray26[character + (previousCharacter << 8)];
                  }

                  int int_6 = this.gylphHeights[character];
                  width = this.glyphWidths[character];
                  if (widths != null) {
                     height = widths[count];
                  } else {
                     height = 0;
                  }

                  if (heights != null) {
                     id = heights[count];
                  } else {
                     id = 0;
                  }

                  ++count;
                  if (character != 32) {
                     if (anInt567 == 256) {
                        if (shadow != -1) {
                           renderShadeRGB(this.gylphs[character], height + x + this.horizontalOffsets[character] + 1, y + id + this.verticalOffsets[character] + 1, int_6, width, shadow);
                        }

                        this.renderRGB(this.gylphs[character], height + x + this.horizontalOffsets[character], y + id + this.verticalOffsets[character], int_6, width, colour);
                     } else {
                        if (shadow != -1) {
                           renderShadeRGBA(this.gylphs[character], height + x + this.horizontalOffsets[character] + 1, y + id + this.verticalOffsets[character] + 1, int_6, width, shadow, anInt567);
                        }

                        this.renderRGBA(this.gylphs[character], height + x + this.horizontalOffsets[character], y + id + this.verticalOffsets[character], int_6, width, colour, anInt567);
                     }
                  } else if (anInt568 > 0) {
                     anInt569 += anInt568;
                     x += anInt569 >> 8;
                     anInt569 &= 0xFF;
                  }

                  int length = this.anIntArray137[character];
                  if (strikethroughRGB != -1) {
                     Rasterizer2D.drawHorizontal(x, y + (int)((double)this.verticalSpace * 0.7D), length, strikethroughRGB);
                  }

                  if (underlineRGB != -1) {
                     Rasterizer2D.drawHorizontal(x, y + this.verticalSpace, length, underlineRGB);
                  }

                  x += length;
                  previousCharacter = character;
               }
            }
         }
      }
   }

   int method1034(char char_0) {
      if (char_0 == 160) {
         char_0 = 32;
      }

      return this.anIntArray137[Class99.convertCharacter(char_0) & 0xFF];
   }

   public int method1035(String string_0, int int_0) {
      return this.method1031(string_0, new int[] {int_0}, aStringArray5);
   }

   void setAttribute(String tag) {
      try {
         if (tag.startsWith("col=")) {
            FontTypeFace.colour = getInteger(tag.substring(4), 16);
         } else if (tag.equals("/col")) {
            FontTypeFace.colour = prevColourRGB;
         } else if (tag.startsWith("str=")) {
            strikethroughRGB = getInteger(tag.substring(4), 16);
         } else if (tag.equals("str")) {
            strikethroughRGB = 8388608;
         } else if (tag.equals("/str")) {
            strikethroughRGB = -1;
         } else if (tag.startsWith("u=")) {
            underlineRGB = getInteger(tag.substring(2), 16);
         } else if (tag.equals("u")) {
            underlineRGB = 0;
         } else if (tag.equals("/u")) {
            underlineRGB = -1;
         } else if (tag.startsWith("shad=")) {
            shadow = getInteger(tag.substring(5), 16);
         } else if (tag.equals("shad")) {
            shadow = 0;
         } else if (tag.equals("/shad")) {
            shadow = prevShadeRGB;
         } else if (tag.equals("br")) {
            this.setAttributes(prevColourRGB, prevShadeRGB);
         }
      } catch (Exception exception_0) {
         ;
      }

   }

   public int method1036(String string_0, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8) {
      if (string_0 == null) {
         return 0;
      } else {
         this.setAttributes(int_4, int_5);
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
               this.drawString(aStringArray5[int_11], int_0, int_10);
            } else if (int_6 == 1) {
               this.drawString(aStringArray5[int_11], int_0 + (int_2 - this.getWidth(aStringArray5[int_11])) / 2, int_10);
            } else if (int_6 == 2) {
               this.drawString(aStringArray5[int_11], int_0 + int_2 - this.getWidth(aStringArray5[int_11]), int_10);
            } else if (int_11 == int_9 - 1) {
               this.drawString(aStringArray5[int_11], int_0, int_10);
            } else {
               this.method1037(aStringArray5[int_11], int_2);
               this.drawString(aStringArray5[int_11], int_0, int_10);
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
         anInt568 = (int_0 - this.getWidth(string_0) << 8) / int_1;
      }

   }

   abstract void renderRGB(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   abstract void renderRGBA(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   public int method1038(String string_0, int int_0) {
      int int_1 = this.method1031(string_0, new int[] {int_0}, aStringArray5);
      int int_2 = 0;

      for (int int_3 = 0; int_3 < int_1; int_3++) {
         int int_4 = this.getWidth(aStringArray5[int_3]);
         if (int_4 > int_2) {
            int_2 = int_4;
         }
      }

      return int_2;
   }

   public void drawRandomizedMouseoverText(String string_0, int int_0, int int_1, int int_2, int int_3, int int_4) {
      if (string_0 != null) {
         this.setAttributes(int_2, int_3);
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

   public void drawStringCentred(String string, int x, int y, int colour, int shadow) {
      if (string != null) {
         this.setAttributes(colour, shadow);
         this.drawString(string, x - this.getWidth(string) / 2, y);
      }
   }

   public void drawString(String string, int x, int y, int colour, int shadow) {
      if (string != null) {
         this.setAttributes(colour, shadow);
         this.drawString(string, x, y);
      }
   }

   public void drawStringRight(String string, int x, int y, int colour, int shadow) {
      if (string != null) {
         this.setAttributes(colour, shadow);
         this.drawString(string, x - this.getWidth(string), y);
      }
   }

   public void method1042(String string_0, int int_0, int int_1, int int_2, int int_3, int int_4) {
      if (string_0 != null) {
         this.setAttributes(int_2, int_3);
         int[] ints_0 = new int[string_0.length()];

         for (int int_5 = 0; int_5 < string_0.length(); int_5++) {
            ints_0[int_5] = (int)(Math.sin((double)int_5 / 2.0D + (double)int_4 / 5.0D) * 5.0D);
         }

         this.drawMouseoverText(string_0, int_0 - this.getWidth(string_0) / 2, int_1, (int[]) null, ints_0);
      }
   }

   public void drawWaveStringCentred(String string, int x, int y, int colour, int shadow, int wave) {
      if (string != null) {
         this.setAttributes(colour, shadow);
         int[] xOffset = new int[string.length()];
         int[] yOffset = new int[string.length()];

         for (int index = 0; index < string.length(); index++) {
            xOffset[index] = (int)(Math.sin((double)index / 5.0D + (double)wave / 5.0D) * 5.0D);
            yOffset[index] = (int)(Math.sin((double)index / 3.0D + (double)wave / 5.0D) * 5.0D);
         }

         this.drawMouseoverText(string, x - this.getWidth(string) / 2, y, xOffset, yOffset);
      }
   }

   public void method1044(String string_0, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      if (string_0 != null) {
         this.setAttributes(int_2, int_3);
         double double_0 = 7.0D - (double)int_5 / 8.0D;
         if (double_0 < 0.0D) {
            double_0 = 0.0D;
         }

         int[] ints_0 = new int[string_0.length()];

         for (int int_6 = 0; int_6 < string_0.length(); int_6++) {
            ints_0[int_6] = (int)(Math.sin((double)int_6 / 1.5D + (double)int_4 / 1.0D) * double_0);
         }

         this.drawMouseoverText(string_0, int_0 - this.getWidth(string_0) / 2, int_1, (int[]) null, ints_0);
      }
   }

   public void method1045(String string_0, int int_0, int int_1, int int_2, int int_3, int int_4) {
      if (string_0 != null) {
         this.setAttributes(int_2, int_3);
         anInt567 = int_4;
         this.drawString(string_0, int_0, int_1);
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
      if (int_1 < Rasterizer2D.topY) {
         int_9 = Rasterizer2D.topY - int_1;
         int_3 -= int_9;
         int_1 = Rasterizer2D.topY;
         int_8 += int_2 * int_9;
         int_5 += int_9 * Rasterizer2D.graphicsPixelsWidth;
      }

      if (int_1 + int_3 > Rasterizer2D.bottomY) {
         int_3 -= int_1 + int_3 - Rasterizer2D.bottomY;
      }

      if (int_0 < Rasterizer2D.topX) {
         int_9 = Rasterizer2D.topX - int_0;
         int_2 -= int_9;
         int_0 = Rasterizer2D.topX;
         int_8 += int_9;
         int_5 += int_9;
         int_7 += int_9;
         int_6 += int_9;
      }

      if (int_2 + int_0 > Rasterizer2D.bottomX) {
         int_9 = int_2 + int_0 - Rasterizer2D.bottomX;
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
      if (int_1 < Rasterizer2D.topY) {
         int_10 = Rasterizer2D.topY - int_1;
         int_3 -= int_10;
         int_1 = Rasterizer2D.topY;
         int_9 += int_2 * int_10;
         int_6 += int_10 * Rasterizer2D.graphicsPixelsWidth;
      }

      if (int_1 + int_3 > Rasterizer2D.bottomY) {
         int_3 -= int_1 + int_3 - Rasterizer2D.bottomY;
      }

      if (int_0 < Rasterizer2D.topX) {
         int_10 = Rasterizer2D.topX - int_0;
         int_2 -= int_10;
         int_0 = Rasterizer2D.topX;
         int_9 += int_10;
         int_6 += int_10;
         int_8 += int_10;
         int_7 += int_10;
      }

      if (int_2 + int_0 > Rasterizer2D.bottomX) {
         int_10 = int_2 + int_0 - Rasterizer2D.bottomX;
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
