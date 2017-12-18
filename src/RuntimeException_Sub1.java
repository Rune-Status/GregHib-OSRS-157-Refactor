import java.applet.Applet;

public class RuntimeException_Sub1 extends RuntimeException {

   public static int revision;
   public static Applet anApplet2;
   public static String localPlayerName;
   String aString33;
   Throwable aThrowable1;

   public static InvType method955(int int_0) {
      InvType invtype_0 = (InvType) InvType.inventoryCache.get((long)int_0);
      if (invtype_0 != null) {
         return invtype_0;
      } else {
         byte[] bytes_0 = InvType.anIndexDataBase16.getConfigData(5, int_0);
         invtype_0 = new InvType();
         if (bytes_0 != null) {
            invtype_0.decode(new Buffer(bytes_0));
         }

         InvType.inventoryCache.put(invtype_0, (long)int_0);
         return invtype_0;
      }
   }

}
