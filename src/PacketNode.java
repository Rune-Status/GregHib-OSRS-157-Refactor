public class PacketNode extends Node {

   static PacketNode[] aPacketNodeArray1;
   static int anInt348;
   public PacketBuffer packetBuffer;
   public int anInt349;
   public ClientPacket clientPacket;
   public int anInt350;

   static {
      aPacketNodeArray1 = new PacketNode[300];
      anInt348 = 0;
   }

   public void method678() {
      if (anInt348 < aPacketNodeArray1.length) {
         aPacketNodeArray1[++anInt348 - 1] = this;
      }
   }

   public static void method679() {
      if (KeyFocusListener.keyboard != null) {
         KeyFocusListener keyfocuslistener_0 = KeyFocusListener.keyboard;
         synchronized(keyfocuslistener_0) {
            KeyFocusListener.keyboard = null;
         }
      }

   }

   static int method680(int int_0, Script script_0, boolean bool_0) {
      Widget widget_0;
      if (int_0 >= 2000) {
         int_0 -= 1000;
         widget_0 = Junk.method671(Class39.intStack[--Class23.intStackSize]);
      } else {
         widget_0 = bool_0 ? Class106.aWidget4 : Friend.aWidget5;
      }

      int int_1;
      if (int_0 == 1300) {
         int_1 = Class39.intStack[--Class23.intStackSize] - 1;
         if (int_1 >= 0 && int_1 <= 9) {
            widget_0.insertAction(int_1, Class39.scriptStringStack[--Class28.scriptStringStackSize]);
            return 1;
         } else {
            --Class28.scriptStringStackSize;
            return 1;
         }
      } else if (int_0 == 1301) {
         Class23.intStackSize -= 2;
         int_1 = Class39.intStack[Class23.intStackSize];
         int int_2 = Class39.intStack[Class23.intStackSize + 1];
         widget_0.dragParent = Class74.method447(int_1, int_2);
         return 1;
      } else if (int_0 == 1302) {
         widget_0.aBool40 = Class39.intStack[--Class23.intStackSize] == 1;
         return 1;
      } else if (int_0 == 1303) {
         widget_0.anInt284 = Class39.intStack[--Class23.intStackSize];
         return 1;
      } else if (int_0 == 1304) {
         widget_0.anInt286 = Class39.intStack[--Class23.intStackSize];
         return 1;
      } else if (int_0 == 1305) {
         widget_0.name = Class39.scriptStringStack[--Class28.scriptStringStackSize];
         return 1;
      } else if (int_0 == 1306) {
         widget_0.selectedAction = Class39.scriptStringStack[--Class28.scriptStringStackSize];
         return 1;
      } else if (int_0 == 1307) {
         widget_0.actions = null;
         return 1;
      } else {
         return 2;
      }
   }

}
