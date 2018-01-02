import java.util.Random;

public abstract class FontTypeFace extends Rasterizer2D {

   static int strikeThroughRGB;
   static String[] multiLineText;
   static int underlineRGB;
   static Random random;
   static int minWidth;
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
      strikeThroughRGB = -1;
      underlineRGB = -1;
      prevShadeRGB = -1;
      shadow = -1;
      prevColourRGB = 0;
      colour = 0;
      minWidth = 256;
      anInt568 = 0;
      anInt569 = 0;
      random = new Random();
      multiLineText = new String[100];
   }

   FontTypeFace(byte[] bytes_0, int[] horizontalOffsets, int[] verticalOffsets, int[] gylphHeights, int[] glyphWidths, int[] ints_4, byte[][] pixels) {
      this.gylphs = new byte[256][];
      this.verticalSpace = 0;
      this.horizontalOffsets = horizontalOffsets;
      this.verticalOffsets = verticalOffsets;
      this.gylphHeights = gylphHeights;
      this.glyphWidths = glyphWidths;
      this.method1033(bytes_0);
      this.gylphs = pixels;
      int minWidth = Integer.MAX_VALUE;
      int maxWidth = Integer.MIN_VALUE;

      for (int character = 0; character < 256; character++) {
         if (this.verticalOffsets[character] < minWidth && this.glyphWidths[character] != 0) {
            minWidth = this.verticalOffsets[character];
         }

         if (this.verticalOffsets[character] + this.glyphWidths[character] > maxWidth) {
            maxWidth = this.verticalOffsets[character] + this.glyphWidths[character];
         }
      }

      this.minSpacing = this.verticalSpace - minWidth;
      this.maxSpacing = maxWidth - this.verticalSpace;
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
      strikeThroughRGB = -1;
      underlineRGB = -1;
      prevShadeRGB = shadow;
      FontTypeFace.shadow = shadow;
      prevColourRGB = colour;
      FontTypeFace.colour = colour;
      minWidth = 256;
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

   public int getIndexOfLongestStringInArray(String text, int[] widths, String[] strings) {
      if (text == null) {
         return 0;
      } else {
         int width = 0;
         int position = 0;
         StringBuilder builder = new StringBuilder(100);
         int lineLength = -1;
         int int_3 = 0;
         byte byte_0 = 0;
         int tagStart = -1;
         char secondaryCharacter = 0;
         int stringIndex = 0;
         int length = text.length();

         for (int index = 0; index < length; index++) {
            char character = text.charAt(index);
            if (character == 60) {
               tagStart = index;
            } else {
               if (character == 62 && tagStart != -1) {
                  String tagText = text.substring(tagStart + 1, index);
                  tagStart = -1;
                  builder.append('<');
                  builder.append(tagText);
                  builder.append('>');
                  if (tagText.equals("br")) {
                     strings[stringIndex] = builder.toString().substring(position, builder.length());
                     ++stringIndex;
                     position = builder.length();
                     width = 0;
                     lineLength = -1;
                     secondaryCharacter = 0;
                  } else if (tagText.equals("lt")) {
                     width += this.method1034('<');
                     if (this.aByteArray26 != null && secondaryCharacter != -1) {
                        width += this.aByteArray26[(secondaryCharacter << 8) + 60];
                     }

                     secondaryCharacter = 60;
                  } else if (tagText.equals("gt")) {
                     width += this.method1034('>');
                     if (this.aByteArray26 != null && secondaryCharacter != -1) {
                        width += this.aByteArray26[(secondaryCharacter << 8) + 62];
                     }

                     secondaryCharacter = 62;
                  } else if (tagText.startsWith("img=")) {
                     try {
                        int iconIndex = getInteger(tagText.substring(4));
                        width += modIcons[iconIndex].width;
                        secondaryCharacter = 0;
                     } catch (Exception exception_0) {
                        ;
                     }
                  }

                  character = 0;
               }

               if (tagStart == -1) {
                  if (character != 0) {
                     builder.append(character);
                     width += this.method1034(character);
                     if (this.aByteArray26 != null && secondaryCharacter != -1) {
                        width += this.aByteArray26[character + (secondaryCharacter << 8)];
                     }

                     secondaryCharacter = character;
                  }

                  if (character == 32) {
                     lineLength = builder.length();
                     int_3 = width;
                     byte_0 = 1;
                  }

                  if (widths != null && width > widths[stringIndex < widths.length ? stringIndex : widths.length - 1] && lineLength >= 0) {
                     strings[stringIndex] = builder.toString().substring(position, lineLength - byte_0);
                     ++stringIndex;
                     position = lineLength;
                     lineLength = -1;
                     width -= int_3;
                     secondaryCharacter = 0;
                  }

                  if (character == 45) {
                     lineLength = builder.length();
                     int_3 = width;
                     byte_0 = 0;
                  }
               }
            }
         }

         String builtString = builder.toString();
         if (builtString.length() > position) {
            strings[stringIndex++] = builtString.substring(position, builtString.length());
         }

         return stringIndex;
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
               int height;
               if (character == 62 && tagStart != -1) {
                  String tagText = string.substring(tagStart + 1, index);
                  tagStart = -1;
                  if (tagText.equals("lt")) {
                     character = 60;
                  } else {
                     if (!tagText.equals("gt")) {
                        if (tagText.startsWith("img=")) {
                           try {
                              height = getInteger(tagText.substring(4));
                              IndexedSprite sprite = modIcons[height];
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

                  int width = this.gylphHeights[character];
                  height = this.glyphWidths[character];
                  if (character != 32) {
                     if (minWidth == 256) {
                        if (shadow != -1) {
                           renderShadeRGB(this.gylphs[character], x + this.horizontalOffsets[character] + 1, y + this.verticalOffsets[character] + 1, width, height, shadow);
                        }

                        this.renderRGB(this.gylphs[character], x + this.horizontalOffsets[character], y + this.verticalOffsets[character], width, height, colour);
                     } else {
                        if (shadow != -1) {
                           renderShadeRGBA(this.gylphs[character], x + this.horizontalOffsets[character] + 1, y + this.verticalOffsets[character] + 1, width, height, shadow, minWidth);
                        }

                        this.renderRGBA(this.gylphs[character], x + this.horizontalOffsets[character], y + this.verticalOffsets[character], width, height, colour, minWidth);
                     }
                  } else if (anInt568 > 0) {
                     anInt569 += anInt568;
                     x += anInt569 >> 8;
                     anInt569 &= 0xFF;
                  }

                  int length = this.anIntArray137[character];
                  if (strikeThroughRGB != -1) {
                     Rasterizer2D.drawHorizontal(x, y + (int)((double)this.verticalSpace * 0.7D), length, strikeThroughRGB);
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

   void method1033(byte[] data) {
      this.anIntArray137 = new int[256];
      int int_0;
      if (data.length == 257) {
         for (int_0 = 0; int_0 < this.anIntArray137.length; int_0++) {
            this.anIntArray137[int_0] = data[int_0] & 0xFF;
         }

         this.verticalSpace = data[256] & 0xFF;
      } else {
         int_0 = 0;

         for (int int_1 = 0; int_1 < 256; int_1++) {
            this.anIntArray137[int_1] = data[int_0++] & 0xFF;
         }

         int[] ints_0 = new int[256];
         int[] ints_1 = new int[256];

         int int_2;
         for (int_2 = 0; int_2 < 256; int_2++) {
            ints_0[int_2] = data[int_0++] & 0xFF;
         }

         for (int_2 = 0; int_2 < 256; int_2++) {
            ints_1[int_2] = data[int_0++] & 0xFF;
         }

         byte[][] bytes_1 = new byte[256][];

         int int_4;
         for (int int_3 = 0; int_3 < 256; int_3++) {
            bytes_1[int_3] = new byte[ints_0[int_3]];
            byte byte_0 = 0;

            for (int_4 = 0; int_4 < bytes_1[int_3].length; int_4++) {
               byte_0 += data[int_0++];
               bytes_1[int_3][int_4] = byte_0;
            }
         }

         byte[][] bytes_2 = new byte[256][];

         int int_6;
         for (int_6 = 0; int_6 < 256; int_6++) {
            bytes_2[int_6] = new byte[ints_0[int_6]];
            byte byte_1 = 0;

            for (int int_5 = 0; int_5 < bytes_2[int_6].length; int_5++) {
               byte_1 += data[int_0++];
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
                     if (minWidth == 256) {
                        if (shadow != -1) {
                           renderShadeRGB(this.gylphs[character], height + x + this.horizontalOffsets[character] + 1, y + id + this.verticalOffsets[character] + 1, int_6, width, shadow);
                        }

                        this.renderRGB(this.gylphs[character], height + x + this.horizontalOffsets[character], y + id + this.verticalOffsets[character], int_6, width, colour);
                     } else {
                        if (shadow != -1) {
                           renderShadeRGBA(this.gylphs[character], height + x + this.horizontalOffsets[character] + 1, y + id + this.verticalOffsets[character] + 1, int_6, width, shadow, minWidth);
                        }

                        this.renderRGBA(this.gylphs[character], height + x + this.horizontalOffsets[character], y + id + this.verticalOffsets[character], int_6, width, colour, minWidth);
                     }
                  } else if (anInt568 > 0) {
                     anInt569 += anInt568;
                     x += anInt569 >> 8;
                     anInt569 &= 0xFF;
                  }

                  int length = this.anIntArray137[character];
                  if (strikeThroughRGB != -1) {
                     Rasterizer2D.drawHorizontal(x, y + (int)((double)this.verticalSpace * 0.7D), length, strikeThroughRGB);
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

   public int method1035(String string, int width) {
      return this.getIndexOfLongestStringInArray(string, new int[] {width}, multiLineText);
   }

   void setAttribute(String tag) {
      try {
         if (tag.startsWith("col=")) {
            FontTypeFace.colour = getInteger(tag.substring(4), 16);
         } else if (tag.equals("/col")) {
            FontTypeFace.colour = prevColourRGB;
         } else if (tag.startsWith("str=")) {
            strikeThroughRGB = getInteger(tag.substring(4), 16);
         } else if (tag.equals("str")) {
            strikeThroughRGB = 8388608;
         } else if (tag.equals("/str")) {
            strikeThroughRGB = -1;
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

   public int method1036(String string_0, int int_0, int int_1, int int_2, int int_3, int colour, int shadow, int int_6, int int_7, int int_8) {
      if (string_0 == null) {
         return 0;
      } else {
         this.setAttributes(colour, shadow);
         if (int_8 == 0) {
            int_8 = this.verticalSpace;
         }

         int[] ints_0 = new int[] {int_2};
         if (int_3 < int_8 + this.minSpacing + this.maxSpacing && int_3 < int_8 + int_8) {
            ints_0 = null;
         }

         int int_9 = this.getIndexOfLongestStringInArray(string_0, ints_0, multiLineText);
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
               this.drawString(multiLineText[int_11], int_0, int_10);
            } else if (int_6 == 1) {
               this.drawString(multiLineText[int_11], int_0 + (int_2 - this.getWidth(multiLineText[int_11])) / 2, int_10);
            } else if (int_6 == 2) {
               this.drawString(multiLineText[int_11], int_0 + int_2 - this.getWidth(multiLineText[int_11]), int_10);
            } else if (int_11 == int_9 - 1) {
               this.drawString(multiLineText[int_11], int_0, int_10);
            } else {
               this.setUntaggedCharacterCount(multiLineText[int_11], int_2);
               this.drawString(multiLineText[int_11], int_0, int_10);
               anInt568 = 0;
            }

            int_10 += int_8;
         }

         return int_9;
      }
   }

   void setUntaggedCharacterCount(String string, int int_0) {
      int characterCount = 0;
      boolean tag = false;

      for (int index = 0; index < string.length(); index++) {
         char character = string.charAt(index);
         if (character == 60) {
            tag = true;
         } else if (character == 62) {
            tag = false;
         } else if (!tag && character == 32) {
            ++characterCount;
         }
      }

      if (characterCount > 0) {
         anInt568 = (int_0 - this.getWidth(string) << 8) / characterCount;
      }

   }

   abstract void renderRGB(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   abstract void renderRGBA(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   public int getWidth(String string, int width) {
      int length = this.getIndexOfLongestStringInArray(string, new int[] {width}, multiLineText);
      int maxWidth = 0;

      for (int index = 0; index < length; index++) {
         int w = this.getWidth(multiLineText[index]);
         if (w > maxWidth) {
            maxWidth = w;
         }
      }

      return maxWidth;
   }

   public void drawShadowedSeededString(String string, int x, int y, int colour, int shadow, int seed) {
      if (string != null) {
         this.setAttributes(colour, shadow);
         random.setSeed((long)seed);
         minWidth = 192 + (random.nextInt() & 0x1F);
         int[] widths = new int[string.length()];
         int xPos = 0;

         for (int index = 0; index < string.length(); index++) {
            widths[index] = xPos;
            if ((random.nextInt() & 0x3) == 0) {
               ++xPos;
            }
         }

         this.drawMouseoverText(string, x, y, widths, (int[]) null);
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

   public void drawHorizontalStringWave(String string, int x, int y, int colour, int shadow, int wave) {
      if (string != null) {
         this.setAttributes(colour, shadow);
         int[] heights = new int[string.length()];

         for (int index = 0; index < string.length(); index++) {
            heights[index] = (int)(Math.sin((double)index / 2.0D + (double)wave / 5.0D) * 5.0D);
         }

         this.drawMouseoverText(string, x - this.getWidth(string) / 2, y, (int[]) null, heights);
      }
   }

   public void drawVerticalStringWave(String string, int x, int y, int colour, int shadow, int wave) {
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

   public void drawHorizonalStringMovingWave(String string, int x, int y, int colour, int shadow, int waveAmount, int waveSpeed) {
      if (string != null) {
         this.setAttributes(colour, shadow);
         double speed = 7.0D - (double)waveSpeed / 8.0D;
         if (speed < 0.0D) {
            speed = 0.0D;
         }

         int[] heights = new int[string.length()];

         for (int index = 0; index < string.length(); index++) {
            heights[index] = (int)(Math.sin((double)index / 1.5D + (double)waveAmount / 1.0D) * speed);
         }

         this.drawMouseoverText(string, x - this.getWidth(string) / 2, y, (int[]) null, heights);
      }
   }

   public void drawStringWidth(String string, int x, int y, int colour, int shadow, int minWidth) {
      if (string != null) {
         this.setAttributes(colour, shadow);
         FontTypeFace.minWidth = minWidth;
         this.drawString(string, x, y);
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

   static void renderShadeRGB(byte[] glyph, int x, int y, int width, int height, int colour) {
      int rasterIndex = x + y * Rasterizer2D.graphicsPixelsWidth;
      int rasterClip = Rasterizer2D.graphicsPixelsWidth - width;
      int glyphClip = 0;
      int glyphIndex = 0;
      int dy;
      if (y < Rasterizer2D.topY) {
         dy = Rasterizer2D.topY - y;
         height -= dy;
         y = Rasterizer2D.topY;
         glyphIndex += width * dy;
         rasterIndex += dy * Rasterizer2D.graphicsPixelsWidth;
      }

      if (y + height > Rasterizer2D.bottomY) {
         height -= y + height - Rasterizer2D.bottomY;
      }

      if (x < Rasterizer2D.topX) {
         dy = Rasterizer2D.topX - x;
         width -= dy;
         x = Rasterizer2D.topX;
         glyphIndex += dy;
         rasterIndex += dy;
         glyphClip += dy;
         rasterClip += dy;
      }

      if (width + x > Rasterizer2D.bottomX) {
         dy = width + x - Rasterizer2D.bottomX;
         width -= dy;
         glyphClip += dy;
         rasterClip += dy;
      }

      if (width > 0 && height > 0) {
         render(Rasterizer2D.graphicsPixels, glyph, colour, glyphIndex, rasterIndex, width, height, rasterClip, glyphClip);
      }
   }

   static void render(int[] raster, byte[] glyph, int colour, int glyphPosition, int rasterPosition, int width, int height, int rasterOffset, int glyphOffset) {
      int offsetX = -(width >> 2);
      width = -(width & 0x3);

      for (int y = -height; y < 0; y++) {
         int x;
         for (x = offsetX; x < 0; x++) {
            if (glyph[glyphPosition++] != 0) {
               raster[rasterPosition++] = colour;
            } else {
               ++rasterPosition;
            }

            if (glyph[glyphPosition++] != 0) {
               raster[rasterPosition++] = colour;
            } else {
               ++rasterPosition;
            }

            if (glyph[glyphPosition++] != 0) {
               raster[rasterPosition++] = colour;
            } else {
               ++rasterPosition;
            }

            if (glyph[glyphPosition++] != 0) {
               raster[rasterPosition++] = colour;
            } else {
               ++rasterPosition;
            }
         }

         for (x = width; x < 0; x++) {
            if (glyph[glyphPosition++] != 0) {
               raster[rasterPosition++] = colour;
            } else {
               ++rasterPosition;
            }
         }

         rasterPosition += rasterOffset;
         glyphPosition += glyphOffset;
      }

   }

   static void renderShadeRGBA(byte[] bytes_0, int x, int y, int width, int height, int int_4, int int_5) {
      int rasterIndex = x + y * Rasterizer2D.graphicsPixelsWidth;
      int rasterClip = Rasterizer2D.graphicsPixelsWidth - width;
      int glyphClip = 0;
      int glyphIndex = 0;
      int dy;
      if (y < Rasterizer2D.topY) {
         dy = Rasterizer2D.topY - y;
         height -= dy;
         y = Rasterizer2D.topY;
         glyphIndex += width * dy;
         rasterIndex += dy * Rasterizer2D.graphicsPixelsWidth;
      }

      if (y + height > Rasterizer2D.bottomY) {
         height -= y + height - Rasterizer2D.bottomY;
      }

      if (x < Rasterizer2D.topX) {
         dy = Rasterizer2D.topX - x;
         width -= dy;
         x = Rasterizer2D.topX;
         glyphIndex += dy;
         rasterIndex += dy;
         glyphClip += dy;
         rasterClip += dy;
      }

      if (width + x > Rasterizer2D.bottomX) {
         dy = width + x - Rasterizer2D.bottomX;
         width -= dy;
         glyphClip += dy;
         rasterClip += dy;
      }

      if (width > 0 && height > 0) {
         Font.renderRGBA(Rasterizer2D.graphicsPixels, bytes_0, int_4, glyphIndex, rasterIndex, width, height, rasterClip, glyphClip, int_5);
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
