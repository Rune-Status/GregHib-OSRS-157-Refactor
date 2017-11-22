public class InvType extends CacheableNode {

   static NodeCache inventoryCache;
   public static IndexDataBase anIndexDataBase16;
   public int size;

   static {
      inventoryCache = new NodeCache(64);
   }

   InvType() {
      this.size = 0;
   }

   void method808(Buffer buffer_0, int int_0) {
      if (int_0 == 2) {
         this.size = buffer_0.readUnsignedShort();
      }

   }

   void decode(Buffer buffer_0) {
      while (true) {
         int int_0 = buffer_0.readUnsignedByte();
         if (int_0 == 0) {
            return;
         }

         this.method808(buffer_0, int_0);
      }
   }

}
