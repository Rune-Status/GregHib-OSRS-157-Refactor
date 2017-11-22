import java.io.IOException;

public class Class101 {

   static final char[] aCharArray4;
   static final char[] aCharArray5;

   static {
      aCharArray4 = new char[] {' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
      aCharArray5 = new char[] {'[', ']', '#'};
   }

   static void flush(boolean bool_0) {
      Enum2.method642();
      ++Client.aClass46_1.anInt104;
      if (Client.aClass46_1.anInt104 >= 50 || bool_0) {
         Client.aClass46_1.anInt104 = 0;
         if (!Client.socketError && Client.aClass46_1.method277() != null) {
            PacketNode packetnode_0 = Actor.method953(ClientPacket.aClientPacket1, Client.aClass46_1.anISAACCipher1);
            Client.aClass46_1.method282(packetnode_0);

            try {
               Client.aClass46_1.method283();
            } catch (IOException ioexception_0) {
               Client.socketError = true;
            }
         }

      }
   }

}
