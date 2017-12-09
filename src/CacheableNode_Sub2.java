public class CacheableNode_Sub2 extends CacheableNode {

   static NodeCache aNodeCache11;
   public boolean aBool63;

   static {
      aNodeCache11 = new NodeCache(64);
   }

   CacheableNode_Sub2() {
      this.aBool63 = false;
   }

   void method869(Buffer buffer_0, int int_0) {
      if (int_0 == 2) {
         this.aBool63 = true;
      }

   }

   void method870(Buffer buffer_0) {
      while (true) {
         int int_0 = buffer_0.getUnsignedByte();
         if (int_0 == 0) {
            return;
         }

         this.method869(buffer_0, int_0);
      }
   }

   public static IndexedSprite getSprite(IndexDataBase index, String archive, String name) {
      int file = index.getFile(archive);
      int child = index.getChild(file, name);
      IndexedSprite sprite;
      if (!TileStrategy.decodeIfExists(index, file, child)) {
         sprite = null;
      } else {
         sprite = Class9.loadSpriteData();
      }

      return sprite;
   }

}
