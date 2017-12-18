import java.io.File;

public class WidgetNode extends Node {

   static File aFile3;
   boolean aBool54;
   int id;
   int owner;

   WidgetNode() {
      this.aBool54 = false;
   }

   public static Class method686(String string_0) throws ClassNotFoundException {
      return string_0.equals("B") ? Byte.TYPE : (string_0.equals("I") ? Integer.TYPE : (string_0.equals("S") ? Short.TYPE : (string_0.equals("J") ? Long.TYPE : (string_0.equals("Z") ? Boolean.TYPE : (string_0.equals("F") ? Float.TYPE : (string_0.equals("D") ? Double.TYPE : (string_0.equals("C") ? Character.TYPE : (string_0.equals("void") ? Void.TYPE : Class.forName(string_0)))))))));
   }

}
