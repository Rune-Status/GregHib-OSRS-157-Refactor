public class CacheableNode_Sub4 extends CacheableNode {

   static NodeCache aNodeCache13;
   static IndexDataBase anIndexDataBase23;
   public boolean aBool64;

   static {
      aNodeCache13 = new NodeCache(64);
   }

   CacheableNode_Sub4() {
      this.aBool64 = false;
   }

   void method881(Buffer buffer_0, int int_0) {
      if (int_0 == 2) {
         this.aBool64 = true;
      }

   }

   void method882(Buffer buffer_0) {
      while (true) {
         int int_0 = buffer_0.getUnsignedByte();
         if (int_0 == 0) {
            return;
         }

         this.method881(buffer_0, int_0);
      }
   }

}
