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

   void decode(Buffer buffer, int opcode) {
      if (opcode == 1) {
         this.configId = buffer.getUnsignedShort();
         this.leastSignificantBit = buffer.getUnsignedByte();
         this.mostSignificantBit = buffer.getUnsignedByte();
      }
   }

   public void decodeLoop(Buffer buffer) {
      while (true) {
         int opcode = buffer.getUnsignedByte();
         if (opcode == 0) {
            return;
         }

         this.decode(buffer, opcode);
      }
   }

}
