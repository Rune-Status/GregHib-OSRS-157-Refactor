public final class Item extends Renderable {

   static boolean aBool73;
   int id;
   int quantity;

   protected Model getModel() {
      return CacheableNode_Sub2.getItemDefinition(this.id).getModel(this.quantity);
   }

   public static int method973(int id) {
      Varbit cachedVarbit = (Varbit) Varbit.varbits.get((long)id);
      Varbit varbit;
      if (cachedVarbit != null) {
         varbit = cachedVarbit;
      } else {
         byte[] data = Class49.varbit_ref.getConfigData(14, id);
         cachedVarbit = new Varbit();
         if (data != null) {
            cachedVarbit.decodeLoop(new Buffer(data));
         }

         Varbit.varbits.put(cachedVarbit, (long)id);
         varbit = cachedVarbit;
      }

      int config = varbit.configId;
      int low = varbit.leastSignificantBit;
      int high = varbit.mostSignificantBit;
      int mask = Settings.BIT_MASKS[high - low];
      return Settings.widgetSettings[config] >> low & mask;
   }

}
