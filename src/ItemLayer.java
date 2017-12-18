public final class ItemLayer {

   static int[][][] anIntArrayArrayArray1;
   static int anInt210;
   Renderable bottom;
   int x;
   int y;
   int hash;
   int flags;
   Renderable middle;
   Renderable top;
   int height;

   public static Sequence getAnimation(int int_0) {
      Sequence sequence_0 = (Sequence) Sequence.sequences.get((long)int_0);
      if (sequence_0 != null) {
         return sequence_0;
      } else {
         byte[] bytes_0 = Class35.seq_ref.getConfigData(12, int_0);
         sequence_0 = new Sequence();
         if (bytes_0 != null) {
            sequence_0.decode(new Buffer(bytes_0));
         }

         sequence_0.post();
         Sequence.sequences.put(sequence_0, (long)int_0);
         return sequence_0;
      }
   }

   public static void method545() {
      Class78.anAClass6_Sub3_1.method836();
      Class78.anInt172 = 1;
      Class70.anIndexDataBase3 = null;
   }

   static void method546(byte[] bytes_0, int int_0, int int_1, int int_2, int int_3, CollisionData[] collisionData) {
      int int_5;
      int int_6;
      for (int int_4 = 0; int_4 < 4; int_4++) {
         for (int_5 = 0; int_5 < 64; int_5++) {
            for (int_6 = 0; int_6 < 64; int_6++) {
               if (int_5 + int_0 > 0 && int_5 + int_0 < 103 && int_6 + int_1 > 0 && int_6 + int_1 < 103) {
                  collisionData[int_4].adjacency[int_5 + int_0][int_6 + int_1] &= 0xFEFFFFFF;
               }
            }
         }
      }

      Buffer buffer_0 = new Buffer(bytes_0);

      for (int_5 = 0; int_5 < 4; int_5++) {
         for (int_6 = 0; int_6 < 64; int_6++) {
            for (int int_7 = 0; int_7 < 64; int_7++) {
               CombatInfoListHolder.loadTerrain(buffer_0, int_5, int_6 + int_0, int_7 + int_1, int_2, int_3, 0);
            }
         }
      }

   }

}
