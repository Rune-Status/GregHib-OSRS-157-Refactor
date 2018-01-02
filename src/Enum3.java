public enum Enum3 implements RSEnum {

   anEnum3_1(1, 0),
   anEnum3_2(0, 1),
   anEnum3_3(2, 2),
   anEnum3_4(3, 3);

   final int anInt342;
   public final int anInt343;

   Enum3(int int_1, int int_2) {
      this.anInt343 = int_1;
      this.anInt342 = int_2;
   }

   static IndexedSprite[] method634(IndexDataBase indexdatabase_0, int int_0, int int_1) {
      if (!TileStrategy.decodeIfExists(indexdatabase_0, int_0, int_1)) {
         return null;
      } else {
         IndexedSprite[] indexedsprites_0 = new IndexedSprite[Class111.loadedSpriteSize];

         for (int int_2 = 0; int_2 < Class111.loadedSpriteSize; int_2++) {
            IndexedSprite indexedsprite_0 = indexedsprites_0[int_2] = new IndexedSprite();
            indexedsprite_0.width = Class111.loadedMaxWidth;
            indexedsprite_0.originalHeight = Class111.loadedMaxHeight;
            indexedsprite_0.offsetX = Class111.loadedHorizontalOffsets[int_2];
            indexedsprite_0.offsetY = Class7.loadedVerticalOffsets[int_2];
            indexedsprite_0.originalWidth = ItemContainer.loadedWidths[int_2];
            indexedsprite_0.height = Class6.loadedHeights[int_2];
            indexedsprite_0.palette = Class111.loadedPixels;
            indexedsprite_0.pixels = Class111.spritePixels[int_2];
         }

         Class98.cleanPixelLoader();
         return indexedsprites_0;
      }
   }

   public int rsOrdinal() {
      return this.anInt342;
   }

   public static void method669(Model model_0, int int_0) {
      for (int int_1 = 0; int_1 < model_0.triangleCount; int_1++) {
         if (model_0.anIntArray132[int_1] != -2) {
            int int_2 = model_0.trianglePointsX[int_1];
            int int_3 = model_0.trianglePointsY[int_1];
            int int_4 = model_0.trianglePointsZ[int_1];
            int int_5 = Model.vertexScreenX[int_2];
            int int_6 = Model.vertexScreenX[int_3];
            int int_7 = Model.vertexScreenX[int_4];
            Class35.method244(Model.vertexScreenY[int_2], Model.vertexScreenY[int_3], Model.vertexScreenY[int_4], int_5, int_6, int_7, int_0);
         }
      }

   }

   public static IndexedSprite[] method670(IndexDataBase indexdatabase_0, String string_0, String string_1) {
      int int_0 = indexdatabase_0.getFile(string_0);
      int int_1 = indexdatabase_0.getChild(int_0, string_1);
      return method634(indexdatabase_0, int_0, int_1);
   }

}
