public final class Class19 {

   static int anInt72;
   static int[][][] tileHeights;
   static byte[][][] aByteArrayArrayArray5;
   static byte[][][] tileSettings;
   static byte[][][] aByteArrayArrayArray6;
   static final int[] anIntArray7;
   static byte[][][] tileShadowIntensity;
   static int[] anIntArray8;
   static final int[] anIntArray9;
   static final int[] anIntArray10;
   static int[] anIntArray11;
   static final int[] anIntArray12;
   static final int[] anIntArray13;
   static final int[] anIntArray14;
   static int anInt73;
   static int anInt74;
   static long aLong1;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      anInt72 = 99;
      anIntArray7 = new int[] {1, 2, 4, 8};
      anIntArray9 = new int[] {16, 32, 64, 128};
      anIntArray10 = new int[] {1, 0, -1, 0};
      anIntArray12 = new int[] {0, -1, 0, 1};
      anIntArray13 = new int[] {1, -1, -1, 1};
      anIntArray14 = new int[] {-1, -1, 1, 1};
      anInt73 = (int)(Math.random() * 17.0D) - 8;
      anInt74 = (int)(Math.random() * 33.0D) - 16;
   }

   public static void method204(long long_0) {
      if (long_0 > 0L) {
         if (long_0 % 10L == 0L) {
            long long_1 = long_0 - 1L;

            try {
               Thread.sleep(long_1);
            } catch (InterruptedException interruptedexception_1) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException interruptedexception_2) {
               ;
            }
         } else {
            try {
               Thread.sleep(long_0);
            } catch (InterruptedException interruptedexception_0) {
               ;
            }
         }

      }
   }

   static int method205(Class109 class109_0) {
      if (class109_0 == null) {
         return 12;
      } else {
         switch(class109_0.anInt211) {
         case 1:
            return 20;
         default:
            return 12;
         }
      }
   }

}
