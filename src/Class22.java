import java.applet.Applet;
import netscape.javascript.JSObject;

public class Class22 {

   public static Object method214(Applet applet_0, String string_0) throws Throwable {
      return JSObject.getWindow(applet_0).call(string_0, (Object[]) null);
   }

   static Object method215(Applet applet_0, String string_0, Object[] objects_0) throws Throwable {
      return JSObject.getWindow(applet_0).call(string_0, objects_0);
   }

}
