public class Varbit extends CacheableNode {

   public static NodeCache varbits;
   static int[] landMapFileIds;
   static int[] landRegionFileIds;
   public int configId;
   public int leastSignificantBit;
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   void method821(Buffer buffer_0, int int_0) {
      if (int_0 == 1) {
         this.configId = buffer_0.readUnsignedShort();
         this.leastSignificantBit = buffer_0.readUnsignedByte();
         this.mostSignificantBit = buffer_0.readUnsignedByte();
      }

   }

   public void decode(Buffer buffer_0) {
      while (true) {
         int int_0 = buffer_0.readUnsignedByte();
         if (int_0 == 0) {
            return;
         }

         this.method821(buffer_0, int_0);
      }
   }

}
