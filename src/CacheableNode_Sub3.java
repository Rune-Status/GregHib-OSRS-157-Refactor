public class CacheableNode_Sub3 extends CacheableNode {

   public static NodeCache aNodeCache12;
   public static IndexDataBase anIndexDataBase22;
   IterableHashTable anIterableHashTable3;

   static {
      aNodeCache12 = new NodeCache(64);
   }

   void method875(Buffer buffer_0, int int_0) {
      if (int_0 == 249) {
         this.anIterableHashTable3 = Tile.method682(buffer_0, this.anIterableHashTable3);
      }

   }

   public int method876(int int_0, int int_1) {
      return Occluder.method392(this.anIterableHashTable3, int_0, int_1);
   }

   public String method877(int int_0, String string_0) {
      return VertexNormal.method492(this.anIterableHashTable3, int_0, string_0);
   }

   public void method878() {
   }

   public void method879(Buffer buffer_0) {
      while (true) {
         int int_0 = buffer_0.readUnsignedByte();
         if (int_0 == 0) {
            return;
         }

         this.method875(buffer_0, int_0);
      }
   }

   static void method880(int int_0, int int_1, int int_2, ObjectComposition objectcomposition_0, int int_3) {
      Node_Sub1 node_sub1_0 = new Node_Sub1();
      node_sub1_0.anInt323 = int_0;
      node_sub1_0.anInt320 = int_1 * 128;
      node_sub1_0.anInt322 = int_2 * 128;
      int int_4 = objectcomposition_0.sizeX;
      int int_5 = objectcomposition_0.sizeY;
      if (int_3 == 1 || int_3 == 3) {
         int_4 = objectcomposition_0.sizeY;
         int_5 = objectcomposition_0.sizeX;
      }

      node_sub1_0.anInt319 = (int_4 + int_1) * 128;
      node_sub1_0.anInt321 = (int_5 + int_2) * 128;
      node_sub1_0.anInt315 = objectcomposition_0.ambientSoundId;
      node_sub1_0.anInt316 = objectcomposition_0.anInt463 * 128;
      node_sub1_0.anInt317 = objectcomposition_0.anInt464;
      node_sub1_0.anInt318 = objectcomposition_0.anInt465;
      node_sub1_0.anIntArray72 = objectcomposition_0.anIntArray85;
      if (objectcomposition_0.impostorIds != null) {
         node_sub1_0.anObjectComposition1 = objectcomposition_0;
         node_sub1_0.method632();
      }

      Node_Sub1.aDeque3.addFront(node_sub1_0);
      if (node_sub1_0.anIntArray72 != null) {
         node_sub1_0.anInt324 = node_sub1_0.anInt317 + (int)(Math.random() * (double)(node_sub1_0.anInt318 - node_sub1_0.anInt317));
      }

   }

}
