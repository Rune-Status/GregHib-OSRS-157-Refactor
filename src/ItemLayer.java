public final class ItemLayer {

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

}
