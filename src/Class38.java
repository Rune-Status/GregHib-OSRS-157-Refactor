public class Class38 {

   static IndexData indexTrack1;
   static int[][] xteaKeys;

   static String method253(int int_0) {
      return int_0 < 0 ? "" : (Client.menuTargets[int_0].length() > 0 ? Client.menuOptions[int_0] + " " + Client.menuTargets[int_0] : Client.menuOptions[int_0]);
   }

   public static SpritePixels decodeSpritePixels(IndexDataBase indexDataBase, int archive, int file) {
      if (!TileStrategy.decodeIfExists(indexDataBase, archive, file)) {
         return null;
      } else {
         SpritePixels pixels = new SpritePixels();
         pixels.maxWidth = Class111.anInt214;
         pixels.maxHeight = Class111.anInt215;
         pixels.offsetX = Class111.anIntArray54[0];
         pixels.offsetY = Class7.offsetsY[0];
         pixels.width = ItemContainer.anIntArray76[0];
         pixels.height = Class6.anIntArray3[0];
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

}
