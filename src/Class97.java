public class Class97 {

   public static final Class97 aClass97_4;
   public static final Class97 aClass97_5;
   public static final Class97 aClass97_6;
   public static final Class97 aClass97_7;
   public static final Class97 aClass97_8;
   public static final Class97 aClass97_9;
   static AClass6_Sub1 anAClass6_Sub1_1;
   public static String osName;
   static String aString11;
   final String aString12;
   String aString13;

   static {
      aClass97_5 = new Class97("PLAIN11", "p11_full");
      aClass97_8 = new Class97("PLAIN12", "p12_full");
      aClass97_9 = new Class97("BOLD12", "b12_full");
      aClass97_4 = new Class97("VERDANA11", "verdana_11pt_regular");
      aClass97_6 = new Class97("VERDANA13", "verdana_13pt_regular");
      aClass97_7 = new Class97("VERDANA15", "verdana_15pt_regular");
   }

   Class97(String string_0, String string_1) {
      this.aString12 = string_0;
      this.aString13 = string_1;
   }

   public static synchronized long currentTimeMs() {
      long long_0 = System.currentTimeMillis();
      if (long_0 < Class71.aLong7) {
         Class71.aLong8 += Class71.aLong7 - long_0;
      }

      Class71.aLong7 = long_0;
      return long_0 + Class71.aLong8;
   }

   public static Class97[] method520() {
      return new Class97[] {aClass97_4, aClass97_7, aClass97_6, aClass97_9, aClass97_8, aClass97_5};
   }

   static void method521(String string_0) {
      if (string_0.equalsIgnoreCase("toggleroof")) {
         Buffer.preferences.hideRoofs = !Buffer.preferences.hideRoofs;
         Class59.method390();
         if (Buffer.preferences.hideRoofs) {
            Class34.sendGameMessage(99, "", "Roofs are now all hidden");
         } else {
            Class34.sendGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if (string_0.equalsIgnoreCase("displayfps")) {
         Client.displayFps = !Client.displayFps;
      }

      if (Client.rights >= 2) {
         if (string_0.equalsIgnoreCase("aabb")) {
            if (!Class37.aBool14) {
               Class37.aBool14 = true;
               Class37.aClass26_3 = Class26.aClass26_2;
            } else if (Class37.aClass26_3 == Class26.aClass26_2) {
               Class37.aBool14 = true;
               Class37.aClass26_3 = Class26.aClass26_1;
            } else {
               Class37.aBool14 = false;
            }
         }

         if (string_0.equalsIgnoreCase("fpson")) {
            Client.displayFps = true;
         }

         if (string_0.equalsIgnoreCase("fpsoff")) {
            Client.displayFps = false;
         }

         if (string_0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if (string_0.equalsIgnoreCase("clientdrop")) {
            WidgetNode.method684();
         }

         if (string_0.equalsIgnoreCase("errortest") && Client.socketType == 2) {
            throw new RuntimeException();
         }
      }

      PacketNode packetnode_0 = Actor.method953(ClientPacket.aClientPacket92, Client.aClass46_1.anISAACCipher1);
      packetnode_0.packetBuffer.putByte(string_0.length() + 1);
      packetnode_0.packetBuffer.putString(string_0);
      Client.aClass46_1.method282(packetnode_0);
   }

}
