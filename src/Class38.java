public class Class38 {

   static IndexData indexTrack1;
   static int[][] xteaKeys;

   static String method253(int int_0) {
      return int_0 < 0 ? "" : (Client.menuTargets[int_0].length() > 0 ? Client.menuOptions[int_0] + " " + Client.menuTargets[int_0] : Client.menuOptions[int_0]);
   }

   public static SpritePixels method254(IndexDataBase indexdatabase_0, int int_0, int int_1) {
      if (!TileStrategy.method628(indexdatabase_0, int_0, int_1)) {
         return null;
      } else {
         SpritePixels spritepixels_0 = new SpritePixels();
         spritepixels_0.maxWidth = Class111.anInt214;
         spritepixels_0.maxHeight = Class111.anInt215;
         spritepixels_0.offsetX = Class111.anIntArray54[0];
         spritepixels_0.offsetY = Class7.offsetsY[0];
         spritepixels_0.width = ItemContainer.anIntArray76[0];
         spritepixels_0.height = Class6.anIntArray3[0];
         int int_2 = spritepixels_0.height * spritepixels_0.width;
         byte[] bytes_0 = Class111.spritePixels[0];
         spritepixels_0.pixels = new int[int_2];

         for (int int_3 = 0; int_3 < int_2; int_3++) {
            spritepixels_0.pixels[int_3] = Class111.anIntArray55[bytes_0[int_3] & 0xFF];
         }

         Class98.method523();
         return spritepixels_0;
      }
   }

}
