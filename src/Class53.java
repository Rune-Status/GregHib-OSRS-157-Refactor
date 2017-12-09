import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;

public class Class53 {

   static int method349(int int_0, int int_1) {
      long long_0 = (long)((int_0 << 16) + int_1);
      return Class56.currentRequest != null && Class56.currentRequest.hash == long_0 ? DecorativeObject.aBuffer4.position * 99 / (DecorativeObject.aBuffer4.buffer.length - Class56.currentRequest.padding) + 1 : 0;
   }

   public static void method350(String string_0, boolean bool_0, boolean bool_1) {
      if (bool_0) {
         if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(string_0));
               return;
            } catch (Exception exception_0) {
               ;
            }
         }

         if (Class23.aString3.startsWith("win")) {
            Class9.method149(string_0, 0);
         } else if (Class23.aString3.startsWith("mac")) {
            World.method558(string_0, 1, "openjs");
         } else {
            Class9.method149(string_0, 2);
         }
      } else {
         Class9.method149(string_0, 3);
      }

   }

   public static void method351(IndexDataBase indexdatabase_0, IndexDataBase indexdatabase_1) {
      CombatInfo2.anIndexDataBase18 = indexdatabase_0;
      CombatInfo2.anIndexDataBase19 = indexdatabase_1;
   }

}
