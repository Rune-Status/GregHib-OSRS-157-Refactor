public final class AClass3_Sub2 extends AClass3 {

   final int anInt408;
   final int anInt409;
   final int anInt410;
   final int anInt411;
   final int anInt412;
   final int anInt413;
   final int anInt414;

   AClass3_Sub2(Model model_0, int int_0, int int_1, int int_2, int int_3) {
      this.anInt408 = int_0 + model_0.anInt558 - model_0.anInt555;
      this.anInt410 = int_1 + model_0.anInt562 - model_0.anInt563;
      this.anInt412 = int_2 + model_0.anInt564 - model_0.anInt566;
      this.anInt409 = int_0 + model_0.anInt555 + model_0.anInt558;
      this.anInt411 = int_1 + model_0.anInt563 + model_0.anInt562;
      this.anInt413 = int_2 + model_0.anInt564 + model_0.anInt566;
      this.anInt414 = int_3;
   }

   void method643() {
      for (int int_0 = 0; int_0 < 8; int_0++) {
         int int_1 = (int_0 & 0x1) == 0 ? this.anInt408 : this.anInt409;
         int int_2 = (int_0 & 0x2) == 0 ? this.anInt410 : this.anInt411;
         int int_3 = (int_0 & 0x4) == 0 ? this.anInt412 : this.anInt413;
         if ((int_0 & 0x1) == 0) {
            Class91.method501(int_1, int_2, int_3, this.anInt409, int_2, int_3, this.anInt414);
         }

         if ((int_0 & 0x2) == 0) {
            Class91.method501(int_1, int_2, int_3, int_1, this.anInt411, int_3, this.anInt414);
         }

         if ((int_0 & 0x4) == 0) {
            Class91.method501(int_1, int_2, int_3, int_1, int_2, this.anInt413, this.anInt414);
         }
      }

   }

   public static CacheableNode_Sub6 getCacheableNode_Sub6Definition(int id) {
      CacheableNode_Sub6 node = (CacheableNode_Sub6) CacheableNode_Sub6.aNodeCache16.get((long)id);
      if (node != null) {
         return node;
      } else {
         byte[] data = CacheableNode_Sub6.configCacheIndex.getConfigData(32, id);
         node = new CacheableNode_Sub6();
         if (data != null) {
            node.decode(new Buffer(data));
         }

         CacheableNode_Sub6.aNodeCache16.put(node, (long)id);
         return node;
      }
   }

   static void setItemTableSlot(int key, int size, int itemId, int stackSize) {
      ItemContainer container = (ItemContainer) ItemContainer.itemContainers.get((long)key);
      if (container == null) {
         container = new ItemContainer();
         ItemContainer.itemContainers.put(container, (long)key);
      }

      if (container.itemIds.length <= size) {
         int[] items = new int[size + 1];
         int[] sizes = new int[size + 1];

         int index;
         for (index = 0; index < container.itemIds.length; index++) {
            items[index] = container.itemIds[index];
            sizes[index] = container.stackSizes[index];
         }

         for (index = container.itemIds.length; index < size; index++) {
            items[index] = -1;
            sizes[index] = 0;
         }

         container.itemIds = items;
         container.stackSizes = sizes;
      }

      container.itemIds[size] = itemId;
      container.stackSizes[size] = stackSize;
   }

   public static SpritePixels createSprite(int itemId, int stackSize, int backgroundType, int outlineColour, int stackType, boolean transparentBackground) {
      if (stackSize == -1) {
         stackType = 0;
      } else if (stackType == 2 && stackSize != 1) {
         stackType = 1;
      }

      long hash = (long)itemId + ((long)stackSize << 16) + ((long)backgroundType << 38) + ((long)stackType << 40) + ((long)outlineColour << 42);
      SpritePixels pixels;
      if (!transparentBackground) {
         pixels = (SpritePixels) ItemDefinition.itemSpriteCache.get(hash);
         if (pixels != null) {
            return pixels;
         }
      }

      ItemDefinition definition = ItemDefinition.getDefinition(itemId);
      if (stackSize > 1 && definition.stackIds != null) {
         int stackId = -1;

         for (int index = 0; index < 10; index++) {
            if (stackSize >= definition.stackAmounts[index] && definition.stackAmounts[index] != 0) {
               stackId = definition.stackIds[index];
            }
         }

         if (stackId != -1) {
            definition = ItemDefinition.getDefinition(stackId);
         }
      }

      Model model = definition.getModel(1);
      if (model == null) {
         return null;
      } else {
         SpritePixels drawSprite = null;
         if (definition.noteTemplateIndex != -1) {
            drawSprite = createSprite(definition.noteIndex, 10, 1, 0, 0, true);
            if (drawSprite == null) {
               return null;
            }
         } else if (definition.notedId != -1) {
            drawSprite = createSprite(definition.unnotedId, stackSize, backgroundType, outlineColour, 0, false);
            if (drawSprite == null) {
               return null;
            }
         } else if (definition.anInt505 != -1) {
            drawSprite = createSprite(definition.anInt506, stackSize, 0, 0, 0, false);
            if (drawSprite == null) {
               return null;
            }
         }

         int[] graphicsPixels = Rasterizer2D.graphicsPixels;
         int pixelsWidth = Rasterizer2D.graphicsPixelsWidth;
         int pixelsHeight = Rasterizer2D.graphicsPixelsHeight;
         int[] values = new int[4];
         Rasterizer2D.copyDrawRegion(values);
         pixels = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(pixels.pixels, 36, 32);
         Rasterizer2D.reset();
         Rasterizer3D.resetRasterClipping();
         Rasterizer3D.setRasterSize(16, 16);
         Rasterizer3D.rasterGouraudLowRes = false;
         if (definition.anInt505 != -1) {
            drawSprite.drawAt(0, 0);
         }

         int scale = definition.modelInventoryZoom;
         if (transparentBackground) {
            scale = (int)((double)scale * 1.5D);
         } else if (backgroundType == 2) {
            scale = (int)(1.04D * (double)scale);
         }

         int sine = scale * Rasterizer3D.SINE[definition.modelInventoryRotationY] >> 16;
         int cos = scale * Rasterizer3D.COSINE[definition.modelInventoryRotationY] >> 16;
         model.calculateDiagonals();
         model.render(0, definition.modelInventoryRotationX, definition.diagonalRotation, definition.modelInventoryRotationY, definition.spriteTranslateX, model.modelHeight / 2 + sine + definition.spriteTranslateY, cos + definition.spriteTranslateY);
         if (definition.notedId != -1) {
            drawSprite.drawAt(0, 0);
         }

         if (backgroundType >= 1) {
            pixels.setTransparentPixel(1);
         }

         if (backgroundType >= 2) {
            pixels.setTransparentPixel(16777215);
         }

         if (outlineColour != 0) {
            pixels.setBorderPixels(outlineColour);
         }

         Rasterizer2D.setRasterBuffer(pixels.pixels, 36, 32);
         if (definition.noteTemplateIndex != -1) {
            drawSprite.drawAt(0, 0);
         }

         if (stackType == 1 || stackType == 2 && definition.isStackable == 1) {
            Font font = ItemDefinition.aFont5;
            String stackText;
            if (stackSize < 100000) {
               stackText = "<col=ffff00>" + stackSize + "</col>";
            } else if (stackSize < 10000000) {
               stackText = "<col=ffffff>" + stackSize / 1000 + "K" + "</col>";
            } else {
               stackText = "<col=00ff80>" + stackSize / 1000000 + "M" + "</col>";
            }

            font.drawString(stackText, 0, 9, 16776960, 1);
         }

         if (!transparentBackground) {
            ItemDefinition.itemSpriteCache.put(pixels, hash);
         }

         Rasterizer2D.setRasterBuffer(graphicsPixels, pixelsWidth, pixelsHeight);
         Rasterizer2D.setDrawRegion(values);
         Rasterizer3D.resetRasterClipping();
         Rasterizer3D.rasterGouraudLowRes = true;
         return pixels;
      }
   }

}
