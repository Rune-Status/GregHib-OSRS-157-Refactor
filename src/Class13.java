public class Class13 {

   static boolean aBool4;
   String aString1;
   Class28 aClass28_1;
   int anInt58;
   int anInt59;

   Class13(String string_0, int int_0, int int_1, Class28 class28_0) {
      this.aString1 = string_0;
      this.anInt58 = int_0;
      this.anInt59 = int_1;
      this.aClass28_1 = class28_0;
   }

   public static void method168(String string_0, Throwable throwable_0) {
      throwable_0.printStackTrace();
   }

   public static String getString(byte[] bytes_0, int int_0, int int_1) {
      char[] chars_0 = new char[int_1];
      int int_2 = 0;

      for (int int_3 = 0; int_3 < int_1; int_3++) {
         int int_4 = bytes_0[int_3 + int_0] & 0xFF;
         if (int_4 != 0) {
            if (int_4 >= 128 && int_4 < 160) {
               char char_0 = Class103.aCharArray6[int_4 - 128];
               if (char_0 == 0) {
                  char_0 = 63;
               }

               int_4 = char_0;
            }

            chars_0[int_2++] = (char)int_4;
         }
      }

      return new String(chars_0, 0, int_2);
   }

   static int method169(int int_0, Script script_0, boolean bool_0) {
      Widget widget_0 = Junk.method671(Class39.intStack[--Class23.intStackSize]);
      if (int_0 == 2800) {
         Class39.intStack[++Class23.intStackSize - 1] = GraphicsObject.method957(Preferences.getWidgetConfig(widget_0));
         return 1;
      } else if (int_0 != 2801) {
         if (int_0 == 2802) {
            if (widget_0.name == null) {
               Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
            } else {
               Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = widget_0.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int int_1 = Class39.intStack[--Class23.intStackSize];
         --int_1;
         if (widget_0.actions != null && int_1 < widget_0.actions.length && widget_0.actions[int_1] != null) {
            Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = widget_0.actions[int_1];
         } else {
            Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }

}
