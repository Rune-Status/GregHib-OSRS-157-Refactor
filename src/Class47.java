import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import netscape.javascript.JSObject;

public class Class47 {

   public static Comparator aComparator1;
   public static Comparator aComparator2;
   public static Comparator aComparator3;
   public static Comparator aComparator4;
   static AbstractSoundSystem soundSystem1;
   static int[] anIntArray23;
   static Widget aWidget1;
   public final List aList3;

   static {
      aComparator1 = new Class30();
      new Class49();
      aComparator2 = new Class45();
      aComparator3 = new Class42();
      aComparator4 = new Class44();
   }

   public Class47(Buffer buffer_0, boolean bool_0) {
      int int_0 = buffer_0.getUnsignedShort();
      boolean bool_1 = buffer_0.getUnsignedByte() == 1;
      byte byte_0;
      if (bool_1) {
         byte_0 = 1;
      } else {
         byte_0 = 0;
      }

      int int_1 = buffer_0.getUnsignedShort();
      this.aList3 = new ArrayList(int_1);

      for (int int_2 = 0; int_2 < int_1; int_2++) {
         this.aList3.add(new Class36(buffer_0, byte_0, int_0));
      }

   }

   public void method307(Comparator comparator_0, boolean bool_0) {
      if (bool_0) {
         Collections.sort(this.aList3, comparator_0);
      } else {
         Collections.sort(this.aList3, Collections.reverseOrder(comparator_0));
      }

   }

   public static int method308(String string_0) {
      return string_0.length() + 2;
   }

   static void method309(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7) {
      if (CombatInfoListHolder.loadWidget(int_0)) {
         RSCanvas.aWidgetArray1 = null;
         Class14.gameDraw(Class91.widgets[int_0], -1, int_1, int_2, int_3, int_4, int_5, int_6, int_7);
         if (RSCanvas.aWidgetArray1 != null) {
            Class14.gameDraw(RSCanvas.aWidgetArray1, -1412584499, int_1, int_2, int_3, int_4, Class18.anInt70, ItemLayer.anInt210, int_7);
            RSCanvas.aWidgetArray1 = null;
         }

      } else {
         if (int_7 != -1) {
            Client.aBoolArray8[int_7] = true;
         } else {
            for (int int_8 = 0; int_8 < 100; int_8++) {
               Client.aBoolArray8[int_8] = true;
            }
         }

      }
   }

   static void method310(int int_0) {
      if (int_0 == -1 && !Client.aBool87) {
         ItemLayer.method545();
      } else if (int_0 != -1 && int_0 != Client.anInt643 && Client.anInt662 != 0 && !Client.aBool87) {
         IndexData indexdata_0 = Class38.indexTrack1;
         int int_1 = Client.anInt662;
         Class78.anInt172 = 1;
         Class70.anIndexDataBase3 = indexdata_0;
         Class78.anInt173 = int_0;
         Class78.anInt174 = 0;
         Class7.anInt40 = int_1;
         Class78.aBool29 = false;
         Class1.anInt16 = 2;
      }

      Client.anInt643 = int_0;
   }

   static int method311(int int_0, Script script_0, boolean bool_0) {
      Widget widget_0 = Junk.method671(Class39.intStack[--Class23.intStackSize]);
      if (int_0 == 2500) {
         Class39.intStack[++Class23.intStackSize - 1] = widget_0.relativeX;
         return 1;
      } else if (int_0 == 2501) {
         Class39.intStack[++Class23.intStackSize - 1] = widget_0.relativeY;
         return 1;
      } else if (int_0 == 2502) {
         Class39.intStack[++Class23.intStackSize - 1] = widget_0.width;
         return 1;
      } else if (int_0 == 2503) {
         Class39.intStack[++Class23.intStackSize - 1] = widget_0.height;
         return 1;
      } else if (int_0 == 2504) {
         Class39.intStack[++Class23.intStackSize - 1] = widget_0.isHidden ? 1 : 0;
         return 1;
      } else if (int_0 == 2505) {
         Class39.intStack[++Class23.intStackSize - 1] = widget_0.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   static void method312(String string_0) {
      Class16.sessionToken = string_0;

      try {
         String string_1 = AClass3.clientInstance.getParameter(Parameters.aParameters8.key);
         String string_2 = AClass3.clientInstance.getParameter(Parameters.aParameters12.key);
         String string_3 = string_1 + "settings=" + string_0 + "; version=1; path=/; domain=" + string_2;
         if (string_0.length() == 0) {
            string_3 = string_3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            string_3 = string_3 + "; Expires=" + Class1.method75(Class97.currentTimeMs() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         Client client_0 = AClass3.clientInstance;
         String string_4 = "document.cookie=\"" + string_3 + "\"";
         JSObject.getWindow(client_0).eval(string_4);
      } catch (Throwable throwable_0) {
         ;
      }

   }

}
