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

    public static int getVarbit(int id) {
       Varbit cachedVarbit = (Varbit) varbits.get((long)id);
       Varbit varbit;
       if (cachedVarbit != null) {
          varbit = cachedVarbit;
       } else {
          byte[] data = Class49.varbit_ref.getConfigData(14, id);
          cachedVarbit = new Varbit();
          if (data != null) {
             cachedVarbit.decode(new Buffer(data));
          }

          varbits.put(cachedVarbit, (long)id);
          varbit = cachedVarbit;
       }

       int config = varbit.configId;
       int low = varbit.leastSignificantBit;
       int high = varbit.mostSignificantBit;
       int mask = Settings.BIT_MASKS[high - low];
       return Settings.widgetSettings[config] >> low & mask;
    }

    void decode(Buffer buffer, int opcode) {
      if (opcode == 1) {
         this.configId = buffer.getUnsignedShort();
         this.leastSignificantBit = buffer.getUnsignedByte();
         this.mostSignificantBit = buffer.getUnsignedByte();
      }
   }

   public void decode(Buffer buffer) {
      while (true) {
         int opcode = buffer.getUnsignedByte();
         if (opcode == 0) {
            return;
         }

         this.decode(buffer, opcode);
      }
   }

}
