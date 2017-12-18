public class CacheableNode_Sub3 extends CacheableNode {

   public static NodeCache aNodeCache12;
   public static IndexDataBase anIndexDataBase22;
   IterableHashTable anIterableHashTable3;

   static {
      aNodeCache12 = new NodeCache(64);
   }

   void method875(Buffer buffer_0, int int_0) {
      if (int_0 == 249) {
         this.anIterableHashTable3 = Tile.decodeParameters(buffer_0, this.anIterableHashTable3);
      }

   }

   public int method876(int int_0, int int_1) {
      return SceneCluster.method392(this.anIterableHashTable3, int_0, int_1);
   }

   public String method877(int int_0, String string_0) {
      return VertexNormal.method492(this.anIterableHashTable3, int_0, string_0);
   }

   public void method878() {
   }

   public void method879(Buffer buffer_0) {
      while (true) {
         int int_0 = buffer_0.getUnsignedByte();
         if (int_0 == 0) {
            return;
         }

         this.method875(buffer_0, int_0);
      }
   }

}
