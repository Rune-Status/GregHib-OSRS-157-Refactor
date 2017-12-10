import java.io.File;
import java.util.Hashtable;

public class Class63 {

   public static boolean aBool25;
   static Hashtable aHashtable1;
   public static File aFile2;

   static {
      aBool25 = false;
      aHashtable1 = new Hashtable(16);
   }

   static void method399(Widget[] widgets_0, int int_0) {
      for (int int_1 = 0; int_1 < widgets_0.length; int_1++) {
         Widget widget_0 = widgets_0[int_1];
         if (widget_0 != null) {
            if (widget_0.type == 0) {
               if (widget_0.children != null) {
                  method399(widget_0.children, int_0);
               }

               WidgetNode widgetnode_0 = (WidgetNode) Client.componentTable.get((long)widget_0.id);
               if (widgetnode_0 != null) {
                  int int_2 = widgetnode_0.id;
                  if (CombatInfoListHolder.loadWidget(int_2)) {
                     method399(Class91.widgets[int_2], int_0);
                  }
               }
            }

            ScriptEvent scriptevent_0;
            if (int_0 == 0 && widget_0.anObjectArray5 != null) {
               scriptevent_0 = new ScriptEvent();
               scriptevent_0.widget = widget_0;
               scriptevent_0.anObjectArray22 = widget_0.anObjectArray5;
               Class52.method335(scriptevent_0);
            }

            if (int_0 == 1 && widget_0.anObjectArray7 != null) {
               if (widget_0.index >= 0) {
                  Widget widget_1 = Junk.method671(widget_0.id);
                  if (widget_1 == null || widget_1.children == null || widget_0.index >= widget_1.children.length || widget_0 != widget_1.children[widget_0.index]) {
                     continue;
                  }
               }

               scriptevent_0 = new ScriptEvent();
               scriptevent_0.widget = widget_0;
               scriptevent_0.anObjectArray22 = widget_0.anObjectArray7;
               Class52.method335(scriptevent_0);
            }
         }
      }

   }

   static int method400(int int_0, int int_1, int int_2, int int_3) {
      int int_4 = 65536 - Graphics3D.COSINE[int_2 * 1024 / int_3] >> 1;
      return ((65536 - int_4) * int_0 >> 16) + (int_4 * int_1 >> 16);
   }

}
