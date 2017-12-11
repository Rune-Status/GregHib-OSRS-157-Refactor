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

   public static CacheableNode_Sub6 method753(int int_0) {
      CacheableNode_Sub6 cacheablenode_sub6_0 = (CacheableNode_Sub6) CacheableNode_Sub6.aNodeCache16.get((long)int_0);
      if (cacheablenode_sub6_0 != null) {
         return cacheablenode_sub6_0;
      } else {
         byte[] bytes_0 = CacheableNode_Sub6.anIndexDataBase25.getConfigData(32, int_0);
         cacheablenode_sub6_0 = new CacheableNode_Sub6();
         if (bytes_0 != null) {
            cacheablenode_sub6_0.method889(new Buffer(bytes_0));
         }

         CacheableNode_Sub6.aNodeCache16.put(cacheablenode_sub6_0, (long)int_0);
         return cacheablenode_sub6_0;
      }
   }

   static void setItemTableSlot(int int_0, int int_1, int int_2, int int_3) {
      ItemContainer itemcontainer_0 = (ItemContainer) ItemContainer.itemContainers.get((long)int_0);
      if (itemcontainer_0 == null) {
         itemcontainer_0 = new ItemContainer();
         ItemContainer.itemContainers.put(itemcontainer_0, (long)int_0);
      }

      if (itemcontainer_0.itemIds.length <= int_1) {
         int[] ints_0 = new int[int_1 + 1];
         int[] ints_1 = new int[int_1 + 1];

         int int_4;
         for (int_4 = 0; int_4 < itemcontainer_0.itemIds.length; int_4++) {
            ints_0[int_4] = itemcontainer_0.itemIds[int_4];
            ints_1[int_4] = itemcontainer_0.stackSizes[int_4];
         }

         for (int_4 = itemcontainer_0.itemIds.length; int_4 < int_1; int_4++) {
            ints_0[int_4] = -1;
            ints_1[int_4] = 0;
         }

         itemcontainer_0.itemIds = ints_0;
         itemcontainer_0.stackSizes = ints_1;
      }

      itemcontainer_0.itemIds[int_1] = int_2;
      itemcontainer_0.stackSizes[int_1] = int_3;
   }

   public static SpritePixels createSprite(int int_0, int int_1, int int_2, int int_3, int int_4, boolean bool_0) {
      if (int_1 == -1) {
         int_4 = 0;
      } else if (int_4 == 2 && int_1 != 1) {
         int_4 = 1;
      }

      long long_0 = (long)int_0 + ((long)int_1 << 16) + ((long)int_2 << 38) + ((long)int_4 << 40) + ((long)int_3 << 42);
      SpritePixels spritepixels_0;
      if (!bool_0) {
         spritepixels_0 = (SpritePixels) ItemDefinition.itemSpriteCache.get(long_0);
         if (spritepixels_0 != null) {
            return spritepixels_0;
         }
      }

      ItemDefinition itemcomposition_0 = ItemDefinition.getDefinition(int_0);
      if (int_1 > 1 && itemcomposition_0.stackIds != null) {
         int int_5 = -1;

         for (int int_6 = 0; int_6 < 10; int_6++) {
            if (int_1 >= itemcomposition_0.stackAmounts[int_6] && itemcomposition_0.stackAmounts[int_6] != 0) {
               int_5 = itemcomposition_0.stackIds[int_6];
            }
         }

         if (int_5 != -1) {
            itemcomposition_0 = ItemDefinition.getDefinition(int_5);
         }
      }

      Model model_0 = itemcomposition_0.getModel(1);
      if (model_0 == null) {
         return null;
      } else {
         SpritePixels spritepixels_1 = null;
         if (itemcomposition_0.noteTemplateIndex != -1) {
            spritepixels_1 = createSprite(itemcomposition_0.noteIndex, 10, 1, 0, 0, true);
            if (spritepixels_1 == null) {
               return null;
            }
         } else if (itemcomposition_0.notedId != -1) {
            spritepixels_1 = createSprite(itemcomposition_0.unnotedId, int_1, int_2, int_3, 0, false);
            if (spritepixels_1 == null) {
               return null;
            }
         } else if (itemcomposition_0.anInt505 != -1) {
            spritepixels_1 = createSprite(itemcomposition_0.anInt506, int_1, 0, 0, 0, false);
            if (spritepixels_1 == null) {
               return null;
            }
         }

         int[] ints_0 = Rasterizer2D.graphicsPixels;
         int int_7 = Rasterizer2D.graphicsPixelsWidth;
         int int_8 = Rasterizer2D.graphicsPixelsHeight;
         int[] ints_1 = new int[4];
         Rasterizer2D.copyDrawRegion(ints_1);
         spritepixels_0 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(spritepixels_0.pixels, 36, 32);
         Rasterizer2D.reset();
         Graphics3D.method960();
         Graphics3D.method970(16, 16);
         Graphics3D.rasterGouraudLowRes = false;
         if (itemcomposition_0.anInt505 != -1) {
            spritepixels_1.drawAt(0, 0);
         }

         int int_9 = itemcomposition_0.modelInventoryZoom;
         if (bool_0) {
            int_9 = (int)((double)int_9 * 1.5D);
         } else if (int_2 == 2) {
            int_9 = (int)(1.04D * (double)int_9);
         }

         int int_10 = int_9 * Graphics3D.SINE[itemcomposition_0.modelInventoryRotationY] >> 16;
         int int_11 = int_9 * Graphics3D.COSINE[itemcomposition_0.modelInventoryRotationY] >> 16;
         model_0.calculateDiagonals();
         model_0.method1027(0, itemcomposition_0.modelInventoryRotationX, itemcomposition_0.diagonalRotation, itemcomposition_0.modelInventoryRotationY, itemcomposition_0.spriteTranslateX, model_0.modelHeight / 2 + int_10 + itemcomposition_0.spriteTranslateY, int_11 + itemcomposition_0.spriteTranslateY);
         if (itemcomposition_0.notedId != -1) {
            spritepixels_1.drawAt(0, 0);
         }

         if (int_2 >= 1) {
            spritepixels_0.setTransparentPixel(1);
         }

         if (int_2 >= 2) {
            spritepixels_0.setTransparentPixel(16777215);
         }

         if (int_3 != 0) {
            spritepixels_0.setSecondarySprite(int_3);
         }

         Rasterizer2D.setRasterBuffer(spritepixels_0.pixels, 36, 32);
         if (itemcomposition_0.noteTemplateIndex != -1) {
            spritepixels_1.drawAt(0, 0);
         }

         if (int_4 == 1 || int_4 == 2 && itemcomposition_0.isStackable == 1) {
            Font font_0 = ItemDefinition.aFont5;
            String string_0;
            if (int_1 < 100000) {
               string_0 = "<col=ffff00>" + int_1 + "</col>";
            } else if (int_1 < 10000000) {
               string_0 = "<col=ffffff>" + int_1 / 1000 + "K" + "</col>";
            } else {
               string_0 = "<col=00ff80>" + int_1 / 1000000 + "M" + "</col>";
            }

            font_0.method1040(string_0, 0, 9, 16776960, 1);
         }

         if (!bool_0) {
            ItemDefinition.itemSpriteCache.put(spritepixels_0, long_0);
         }

         Rasterizer2D.setRasterBuffer(ints_0, int_7, int_8);
         Rasterizer2D.setDrawRegion(ints_1);
         Graphics3D.method960();
         Graphics3D.rasterGouraudLowRes = true;
         return spritepixels_0;
      }
   }

}
