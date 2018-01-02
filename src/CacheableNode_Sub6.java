public class CacheableNode_Sub6 extends CacheableNode {

   public static NodeCache fontIndexCache;
   public static NodeCache aNodeCache16;
   public static NodeCache spritePixelsCache;
   static IndexDataBase configCacheIndex;
   static IndexDataBase anIndexDataBase26;
   static IndexDataBase anIndexDataBase27;
   String text;
   int anInt475;
   int sprite1;
   int sprite4;
   int cachedFontIndex;
   int sprite3;
   int sprite2;
   int anInt481;
   public int anInt482;
   public int colour;
   public int anInt484;
   public int[] anIntArray103;
   public int anInt485;
   public int anInt486;
   public int anInt487;
   public int anInt488;

   static {
      aNodeCache16 = new NodeCache(64);
      spritePixelsCache = new NodeCache(64);
      fontIndexCache = new NodeCache(20);
   }

   CacheableNode_Sub6() {
      this.cachedFontIndex = -1;
      this.colour = 16777215;
      this.anInt484 = 70;
      this.sprite1 = -1;
      this.sprite3 = -1;
      this.sprite2 = -1;
      this.sprite4 = -1;
      this.anInt485 = 0;
      this.anInt487 = 0;
      this.anInt486 = -1;
      this.text = "";
      this.anInt482 = -1;
      this.anInt488 = 0;
      this.anInt475 = -1;
      this.anInt481 = -1;
   }

   public static SpritePixels decodeSpritePixels(IndexDataBase indexDataBase, int archive, int file) {
      if (!TileStrategy.decodeIfExists(indexDataBase, archive, file)) {
         return null;
      } else {
         SpritePixels pixels = new SpritePixels();
         pixels.maxWidth = Class111.loadedMaxWidth;
         pixels.maxHeight = Class111.loadedMaxHeight;
         pixels.offsetX = Class111.loadedHorizontalOffsets[0];
         pixels.offsetY = Class7.loadedVerticalOffsets[0];
         pixels.width = ItemContainer.loadedWidths[0];
         pixels.height = Class6.loadedHeights[0];
         int area = pixels.height * pixels.width;
         byte[] pixelIndexes = Class111.spritePixels[0];
         pixels.pixels = new int[area];

         for (int index = 0; index < area; index++) {
            pixels.pixels[index] = Class111.loadedPixels[pixelIndexes[index] & 0xFF];
         }

         Class98.cleanPixelLoader();
         return pixels;
      }
   }

   void decode(Buffer buffer, int opcode) {
      if (opcode == 1) {
         this.cachedFontIndex = buffer.getBigSmart();
      } else if (opcode == 2) {
         this.colour = buffer.read24BitInt();
      } else if (opcode == 3) {
         this.sprite1 = buffer.getBigSmart();
      } else if (opcode == 4) {
         this.sprite2 = buffer.getBigSmart();
      } else if (opcode == 5) {
         this.sprite3 = buffer.getBigSmart();
      } else if (opcode == 6) {
         this.sprite4 = buffer.getBigSmart();
      } else if (opcode == 7) {
         this.anInt485 = buffer.readShort();
      } else if (opcode == 8) {
         this.text = buffer.getJagString();
      } else if (opcode == 9) {
         this.anInt484 = buffer.getUnsignedShort();
      } else if (opcode == 10) {
         this.anInt487 = buffer.readShort();
      } else if (opcode == 11) {
         this.anInt486 = 0;
      } else if (opcode == 12) {
         this.anInt482 = buffer.getUnsignedByte();
      } else if (opcode == 13) {
         this.anInt488 = buffer.readShort();
      } else if (opcode == 14) {
         this.anInt486 = buffer.getUnsignedShort();
      } else if (opcode == 17 || opcode == 18) {
         this.anInt475 = buffer.getUnsignedShort();
         if (this.anInt475 == 65535) {
            this.anInt475 = -1;
         }

         this.anInt481 = buffer.getUnsignedShort();
         if (this.anInt481 == 65535) {
            this.anInt481 = -1;
         }

         int int_1 = -1;
         if (opcode == 18) {
            int_1 = buffer.getUnsignedShort();
            if (int_1 == 65535) {
               int_1 = -1;
            }
         }

         int int_2 = buffer.getUnsignedByte();
         this.anIntArray103 = new int[int_2 + 2];

         for (int int_3 = 0; int_3 <= int_2; int_3++) {
            this.anIntArray103[int_3] = buffer.getUnsignedShort();
            if (this.anIntArray103[int_3] == 65535) {
               this.anIntArray103[int_3] = -1;
            }
         }

         this.anIntArray103[int_2 + 1] = int_1;
      }

   }

   void decode(Buffer buffer) {
      while (true) {
         int opcode = buffer.getUnsignedByte();
         if (opcode == 0) {
            return;
         }

         this.decode(buffer, opcode);
      }
   }

   public CacheableNode_Sub6 method890() {
      int int_0 = -1;
      if (this.anInt475 != -1) {
         int_0 = Varbit.getVarbit(this.anInt475);
      } else if (this.anInt481 != -1) {
         int_0 = Settings.widgetSettings[this.anInt481];
      }

      int int_1;
      if (int_0 >= 0 && int_0 < this.anIntArray103.length - 1) {
         int_1 = this.anIntArray103[int_0];
      } else {
         int_1 = this.anIntArray103[this.anIntArray103.length - 1];
      }

      return int_1 != -1 ? AClass3_Sub2.getCacheableNode_Sub6Definition(int_1) : null;
   }

   public SpritePixels method891() {
      if (this.sprite1 < 0) {
         return null;
      } else {
         SpritePixels pixels = (SpritePixels) spritePixelsCache.get((long)this.sprite1);
         if (pixels != null) {
            return pixels;
         } else {
            pixels = decodeSpritePixels(anIndexDataBase26, this.sprite1, 0);
            if (pixels != null) {
               spritePixelsCache.put(pixels, (long)this.sprite1);
            }

            return pixels;
         }
      }
   }

   public SpritePixels getCachedSprite() {
      if (this.sprite3 < 0) {
         return null;
      } else {
         SpritePixels pixels = (SpritePixels) spritePixelsCache.get((long)this.sprite3);
         if (pixels != null) {
            return pixels;
         } else {
            pixels = decodeSpritePixels(anIndexDataBase26, this.sprite3, 0);
            if (pixels != null) {
               spritePixelsCache.put(pixels, (long)this.sprite3);
            }

            return pixels;
         }
      }
   }

   public SpritePixels method893() {
      if (this.sprite2 < 0) {
         return null;
      } else {
         SpritePixels pixels = (SpritePixels) spritePixelsCache.get((long)this.sprite2);
         if (pixels != null) {
            return pixels;
         } else {
            pixels = decodeSpritePixels(anIndexDataBase26, this.sprite2, 0);
            if (pixels != null) {
               spritePixelsCache.put(pixels, (long)this.sprite2);
            }

            return pixels;
         }
      }
   }

   public SpritePixels method894() {
      if (this.sprite4 < 0) {
         return null;
      } else {
         SpritePixels pixels = (SpritePixels) spritePixelsCache.get((long)this.sprite4);
         if (pixels != null) {
            return pixels;
         } else {
            pixels = decodeSpritePixels(anIndexDataBase26, this.sprite4, 0);
            if (pixels != null) {
               spritePixelsCache.put(pixels, (long)this.sprite4);
            }

            return pixels;
         }
      }
   }

   public Font getCachedFont() {
      if (this.cachedFontIndex == -1) {
         return null;
      } else {
         Font font = (Font) fontIndexCache.get((long)this.cachedFontIndex);
         if (font != null) {
            return font;
         } else {
            font = Class89.decodeFont(anIndexDataBase26, anIndexDataBase27, this.cachedFontIndex, 0);
            if (font != null) {
               fontIndexCache.put(font, (long)this.cachedFontIndex);
            }

            return font;
         }
      }
   }

   public String getHitsplatString(int hitSplatType) {
      String string_0 = this.text;

      while (true) {
         int index = string_0.indexOf("%1");
         if (index < 0) {
            return string_0;
         }

         String prefix = string_0.substring(0, index);
         String string_2 = Integer.toString(hitSplatType);
         string_0 = prefix + string_2 + string_0.substring(index + 2);
      }
   }

}
