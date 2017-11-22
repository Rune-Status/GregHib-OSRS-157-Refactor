import java.io.File;

public class WidgetNode extends Node {

   static File aFile3;
   boolean aBool54;
   int id;
   int owner;

   WidgetNode() {
      this.aBool54 = false;
   }

   static void method684() {
      if (Client.anInt609 > 0) {
         Class62.method396();
      } else {
         Client.aClass100_1.method526();
         Class110.setGameState(40);
         MessageNode.aRSSocket2 = Client.aClass46_1.createSocket();
         Client.aClass46_1.method279();
      }
   }

   public static int method685(int int_0, int int_1, int int_2) {
      int_2 &= 0x3;
      return int_2 == 0 ? int_0 : (int_2 == 1 ? int_1 : (int_2 == 2 ? 7 - int_0 : 7 - int_1));
   }

   public static Class method686(String string_0) throws ClassNotFoundException {
      return string_0.equals("B") ? Byte.TYPE : (string_0.equals("I") ? Integer.TYPE : (string_0.equals("S") ? Short.TYPE : (string_0.equals("J") ? Long.TYPE : (string_0.equals("Z") ? Boolean.TYPE : (string_0.equals("F") ? Float.TYPE : (string_0.equals("D") ? Double.TYPE : (string_0.equals("C") ? Character.TYPE : (string_0.equals("void") ? Void.TYPE : Class.forName(string_0)))))))));
   }

}
