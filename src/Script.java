public class Script extends CacheableNode {

   static NodeCache aNodeCache18;
   static int[] mapRegions;
   int[] instructions;
   int[] intOperands;
   int localIntCount;
   int localStringCount;
   String[] stringOperands;
   int intStackCount;
   IterableHashTable[] switches;
   int stringStackCount;

   static {
      aNodeCache18 = new NodeCache(128);
   }

   IterableHashTable[] method909(int int_0) {
      return new IterableHashTable[int_0];
   }

   static void method910(int int_0, int int_1, int int_2, int int_3, SpritePixels spritepixels_0, CachedSprite cacheablenode_sub1_0) {
      int int_4 = int_3 * int_3 + int_2 * int_2;
      if (int_4 > 4225 && int_4 < 90000) {
         int int_5 = Client.mapAngle & 0x7FF;
         int int_6 = Graphics3D.SINE[int_5];
         int int_7 = Graphics3D.COSINE[int_5];
         int int_8 = int_7 * int_2 + int_3 * int_6 >> 16;
         int int_9 = int_3 * int_7 - int_6 * int_2 >> 16;
         double double_0 = Math.atan2((double)int_8, (double)int_9);
         int int_10 = cacheablenode_sub1_0.width / 2 - 25;
         int int_11 = (int)(Math.sin(double_0) * (double)int_10);
         int int_12 = (int)(Math.cos(double_0) * (double)int_10);
         byte byte_0 = 20;
         Class10.mapedge.rotate(int_11 + (int_0 + cacheablenode_sub1_0.width / 2 - byte_0 / 2), cacheablenode_sub1_0.height / 2 + int_1 - byte_0 / 2 - int_12 - 10, byte_0, byte_0, 15, 15, double_0, 256);
      } else {
         Class23.drawDot(int_0, int_1, int_2, int_3, spritepixels_0, cacheablenode_sub1_0);
      }

   }

   public static Class59[] method911() {
      return new Class59[] {Class59.aClass59_1, Class59.aClass59_2, Class59.aClass59_3, Class59.aClass59_4, Class59.aClass59_5, Class59.aClass59_6, Class59.aClass59_7, Class59.aClass59_8, Class59.aClass59_9, Class59.aClass59_10};
   }

}
