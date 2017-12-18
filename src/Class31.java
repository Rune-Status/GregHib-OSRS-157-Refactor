public class Class31 {

   public static String osNameLC;

   static int method237(int int_0, Script script_0, boolean bool_0) {
      int int_1 = -1;
      Widget widget_0;
      if (int_0 >= 2000) {
         int_0 -= 1000;
         int_1 = Class39.intStack[--Class23.intStackSize];
         widget_0 = Client.getWidget(int_1);
      } else {
         widget_0 = bool_0 ? Class106.aWidget4 : Friend.aWidget5;
      }

      if (int_0 == 1000) {
         Class23.intStackSize -= 4;
         widget_0.originalX = Class39.intStack[Class23.intStackSize];
         widget_0.originalY = Class39.intStack[Class23.intStackSize + 1];
         widget_0.anInt270 = Class39.intStack[Class23.intStackSize + 2];
         widget_0.anInt273 = Class39.intStack[Class23.intStackSize + 3];
         WorldMapData.method305(widget_0);
         AClass3.clientInstance.method1106(widget_0);
         if (int_1 != -1 && widget_0.type == 0) {
            AClass1_Sub2.method637(Class91.widgets[int_1 >> 16], widget_0, false);
         }

         return 1;
      } else if (int_0 == 1001) {
         Class23.intStackSize -= 4;
         widget_0.originalWidth = Class39.intStack[Class23.intStackSize];
         widget_0.anInt274 = Class39.intStack[Class23.intStackSize + 1];
         widget_0.anInt271 = Class39.intStack[Class23.intStackSize + 2];
         widget_0.buttonType = Class39.intStack[Class23.intStackSize + 3];
         WorldMapData.method305(widget_0);
         AClass3.clientInstance.method1106(widget_0);
         if (int_1 != -1 && widget_0.type == 0) {
            AClass1_Sub2.method637(Class91.widgets[int_1 >> 16], widget_0, false);
         }

         return 1;
      } else if (int_0 == 1003) {
         boolean bool_1 = Class39.intStack[--Class23.intStackSize] == 1;
         if (bool_1 != widget_0.isHidden) {
            widget_0.isHidden = bool_1;
            WorldMapData.method305(widget_0);
         }

         return 1;
      } else if (int_0 == 1005) {
         widget_0.aBool38 = Class39.intStack[--Class23.intStackSize] == 1;
         return 1;
      } else if (int_0 == 1006) {
         widget_0.aBool44 = Class39.intStack[--Class23.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

}
