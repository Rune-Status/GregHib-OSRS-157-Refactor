public class Class58 {

   static int[][] anIntArrayArray10;
   static int[][] anIntArrayArray11;
   static int[] anIntArray37;
   static int[] anIntArray38;
   static int anInt155;
   static int anInt156;

   static {
      anIntArrayArray10 = new int[128][128];
      anIntArrayArray11 = new int[128][128];
      anIntArray37 = new int[4096];
      anIntArray38 = new int[4096];
   }

   public static int method389(int int_0) {
      --int_0;
      int_0 |= int_0 >>> 1;
      int_0 |= int_0 >>> 2;
      int_0 |= int_0 >>> 4;
      int_0 |= int_0 >>> 8;
      int_0 |= int_0 >>> 16;
      return int_0 + 1;
   }

}
