public final class Item extends Renderable {

   static boolean aBool73;
   int id;
   int quantity;

   protected Model getModel() {
      return CacheableNode_Sub2.getItemDefinition(this.id).getModel(this.quantity);
   }

   public static int method973(int int_0) {
      Varbit varbit_0 = (Varbit) Varbit.varbits.get((long)int_0);
      Varbit varbit_1;
      if (varbit_0 != null) {
         varbit_1 = varbit_0;
      } else {
         byte[] bytes_0 = Class49.varbit_ref.getConfigData(14, int_0);
         varbit_0 = new Varbit();
         if (bytes_0 != null) {
            varbit_0.decode(new Buffer(bytes_0));
         }

         Varbit.varbits.put(varbit_0, (long)int_0);
         varbit_1 = varbit_0;
      }

      int int_1 = varbit_1.configId;
      int int_2 = varbit_1.leastSignificantBit;
      int int_3 = varbit_1.mostSignificantBit;
      int int_4 = Class79.anIntArray40[int_3 - int_2];
      return Class79.widgetSettings[int_1] >> int_2 & int_4;
   }

}
