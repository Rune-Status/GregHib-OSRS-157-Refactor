public class Class58 {

   static int[][] directions;
   static int[][] distances;
   static int[] tileQueueX;
   static int[] tileQueueY;
   static int exitX;
   static int exitY;

   static {
      directions = new int[128][128];
      distances = new int[128][128];
      tileQueueX = new int[4096];
      tileQueueY = new int[4096];
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
