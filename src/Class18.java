public class Class18 implements Runnable {

   static int anInt70;
   static int cameraZ;
   static byte aByte1;
   boolean aBool7;
   Object anObject1;
   int anInt71;
   int[] anIntArray5;
   int[] anIntArray6;

   Class18() {
      this.aBool7 = true;
      this.anObject1 = new Object();
      this.anInt71 = 0;
      this.anIntArray5 = new int[500];
      this.anIntArray6 = new int[500];
   }

   public void run() {
      for (; this.aBool7; GameEngine.method204(50L)) {
         Object object_0 = this.anObject1;
         synchronized(object_0) {
            if (this.anInt71 < 500) {
               this.anIntArray5[this.anInt71] = MouseInput.anInt260;
               this.anIntArray6[this.anInt71] = MouseInput.anInt262;
               ++this.anInt71;
            }
         }
      }

   }

   static int getTileHeight(int int_0, int int_1, int int_2) {
      int int_3 = int_0 >> 7;
      int int_4 = int_1 >> 7;
      if (int_3 >= 0 && int_4 >= 0 && int_3 <= 103 && int_4 <= 103) {
         int int_5 = int_2;
         if (int_2 < 3 && (Region.renderRuleFlags[1][int_3][int_4] & 0x2) == 2) {
            int_5 = int_2 + 1;
         }

         int int_6 = int_0 & 0x7F;
         int int_7 = int_1 & 0x7F;
         int int_8 = (128 - int_6) * Region.tileHeightArray[int_5][int_3][int_4] + int_6 * Region.tileHeightArray[int_5][int_3 + 1][int_4] >> 7;
         int int_9 = int_6 * Region.tileHeightArray[int_5][int_3 + 1][int_4 + 1] + Region.tileHeightArray[int_5][int_3][int_4 + 1] * (128 - int_6) >> 7;
         return int_9 * int_7 + int_8 * (128 - int_7) >> 7;
      } else {
         return 0;
      }
   }

}
