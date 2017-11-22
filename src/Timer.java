public abstract class Timer {

   public abstract int method584(int var1, int var2);

   public abstract void method585();

   static void method586(Widget[] widgets_0, int int_0, int int_1, int int_2, boolean bool_0) {
      for (int int_3 = 0; int_3 < widgets_0.length; int_3++) {
         Widget widget_0 = widgets_0[int_3];
         if (widget_0 != null && widget_0.parentId == int_0) {
            MilliTimer.method742(widget_0, int_1, int_2, bool_0);
            Class44.method269(widget_0, int_1, int_2);
            if (widget_0.scrollX > widget_0.scrollWidth - widget_0.width) {
               widget_0.scrollX = widget_0.scrollWidth - widget_0.width;
            }

            if (widget_0.scrollX < 0) {
               widget_0.scrollX = 0;
            }

            if (widget_0.scrollY > widget_0.scrollHeight - widget_0.height) {
               widget_0.scrollY = widget_0.scrollHeight - widget_0.height;
            }

            if (widget_0.scrollY < 0) {
               widget_0.scrollY = 0;
            }

            if (widget_0.type == 0) {
               AClass1_Sub2.method637(widgets_0, widget_0, bool_0);
            }
         }
      }

   }

   static int method587(IndexDataBase indexdatabase_0, IndexDataBase indexdatabase_1) {
      int int_0 = 0;
      if (indexdatabase_0.method429("title.jpg", "")) {
         ++int_0;
      }

      if (indexdatabase_1.method429("logo", "")) {
         ++int_0;
      }

      if (indexdatabase_1.method429("logo_deadman_mode", "")) {
         ++int_0;
      }

      if (indexdatabase_1.method429("titlebox", "")) {
         ++int_0;
      }

      if (indexdatabase_1.method429("titlebutton", "")) {
         ++int_0;
      }

      if (indexdatabase_1.method429("runes", "")) {
         ++int_0;
      }

      if (indexdatabase_1.method429("title_mute", "")) {
         ++int_0;
      }

      if (indexdatabase_1.method429("options_radio_buttons,0", "")) {
         ++int_0;
      }

      if (indexdatabase_1.method429("options_radio_buttons,2", "")) {
         ++int_0;
      }

      if (indexdatabase_1.method429("options_radio_buttons,4", "")) {
         ++int_0;
      }

      if (indexdatabase_1.method429("options_radio_buttons,6", "")) {
         ++int_0;
      }

      indexdatabase_1.method429("sl_back", "");
      indexdatabase_1.method429("sl_flags", "");
      indexdatabase_1.method429("sl_arrows", "");
      indexdatabase_1.method429("sl_stars", "");
      indexdatabase_1.method429("sl_button", "");
      return int_0;
   }

   static String method588(Widget widget_0) {
      return GraphicsObject.method957(Preferences.getWidgetConfig(widget_0)) == 0 ? null : (widget_0.selectedAction != null && widget_0.selectedAction.trim().length() != 0 ? widget_0.selectedAction : null);
   }

   public static boolean method589(int int_0) {
      return (int_0 >> 31 & 0x1) != 0;
   }

}
