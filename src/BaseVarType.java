public enum BaseVarType implements RSEnum {

   INTEGER(2, 0, Integer.class, new Class33()),
   LONG(1, 1, Long.class, new Class35()),
   STRING(0, 2, String.class, new Class48());

   static Task aTask1;
   protected static String aString19;
   final int anInt327;
   final int anInt328;

   BaseVarType(int int_1, int int_2, Class class_0, Interface1 interface1_0) {
      this.anInt328 = int_1;
      this.anInt327 = int_2;
   }

   public int rsOrdinal() {
      return this.anInt327;
   }

   static boolean method646(char char_0) {
      if (Character.isISOControl(char_0)) {
         return false;
      } else {
         boolean bool_0 = char_0 >= 48 && char_0 <= 57 || char_0 >= 65 && char_0 <= 90 || char_0 >= 97 && char_0 <= 122;
         if (bool_0) {
            return true;
         } else {
            char[] chars_0 = Class101.aCharArray4;

            int int_0;
            char char_1;
            for (int_0 = 0; int_0 < chars_0.length; int_0++) {
               char_1 = chars_0[int_0];
               if (char_0 == char_1) {
                  return true;
               }
            }

            chars_0 = Class101.aCharArray5;

            for (int_0 = 0; int_0 < chars_0.length; int_0++) {
               char_1 = chars_0[int_0];
               if (char_0 == char_1) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   static RenderOverview method647() {
      return Client.renderOverview;
   }

}
