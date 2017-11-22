public class Class70 {

   public static IndexDataBase anIndexDataBase3;

   public static KitDefinition getKitDefinition(int int_0) {
      KitDefinition kitdefinition_0 = (KitDefinition) KitDefinition.identKits.get((long)int_0);
      if (kitdefinition_0 != null) {
         return kitdefinition_0;
      } else {
         byte[] bytes_0 = KitDefinition.identKit_ref.getConfigData(3, int_0);
         kitdefinition_0 = new KitDefinition();
         if (bytes_0 != null) {
            kitdefinition_0.decode(new Buffer(bytes_0));
         }

         KitDefinition.identKits.put(kitdefinition_0, (long)int_0);
         return kitdefinition_0;
      }
   }

   static char method420(char char_0) {
      return (char) (char_0 == 198 ? 'E' : (char_0 == 230 ? 'e' : (char_0 == 223 ? 's' : (char_0 == 338 ? 'E' : (char_0 == 339 ? 'e' : '\u0000'))))) ;
   }

}
