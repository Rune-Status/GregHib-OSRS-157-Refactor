public class CachedSprite extends CacheableNode {

   public final int[] pixelsX;
   public final int width;
   public final int height;
   public final int[] pixelsY;

   CachedSprite(int width, int height, int[] pixelsY, int[] pixelsX, int spriteId) {
      this.width = width;
      this.height = height;
      this.pixelsY = pixelsY;
      this.pixelsX = pixelsX;
   }

   public boolean indexIsInside(int length, int index) {
      if (index >= 0 && index < this.pixelsX.length) {
         int x = this.pixelsX[index];
         if (length >= x && length <= x + this.pixelsY[index]) {
            return true;
         }
      }

      return false;
   }

}
