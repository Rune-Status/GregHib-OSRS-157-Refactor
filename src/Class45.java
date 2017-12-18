import java.util.Comparator;

final class Class45 implements Comparator {

   int method274(Class36 class36_0, Class36 class36_1) {
      return class36_0.aGrandExchangeOffer1.price < class36_1.aGrandExchangeOffer1.price ? -1 : (class36_1.aGrandExchangeOffer1.price == class36_0.aGrandExchangeOffer1.price ? 0 : 1);
   }

   public int compare(Object object_0, Object object_1) {
      return this.method274((Class36) object_0, (Class36) object_1);
   }

   public boolean equals(Object object_0) {
      return super.equals(object_0);
   }

   static IndexedSprite method275(boolean bool_0, boolean bool_1) {
      return bool_0 ? (bool_1 ? Class39.anIndexedSprite3 : Class107.anIndexedSprite6) : (bool_1 ? Preferences.anIndexedSprite5 : Wall.anIndexedSprite4);
   }

   static void method276(String string_0) {
      if (string_0 != null) {
         String string_1 = PacketBuffer.method908(string_0, Class24.aClass109_1);
         if (string_1 != null) {
            for (int int_0 = 0; int_0 < Client.ignoreCount; int_0++) {
               Ignore ignore_0 = Client.ignores[int_0];
               String string_2 = ignore_0.name;
               String string_3 = PacketBuffer.method908(string_2, Class24.aClass109_1);
               boolean bool_0;
               if (string_0 != null && string_2 != null) {
                  if (!string_0.startsWith("#") && !string_2.startsWith("#")) {
                     bool_0 = string_1.equals(string_3);
                  } else {
                     bool_0 = string_0.equals(string_2);
                  }
               } else {
                  bool_0 = false;
               }

               if (bool_0) {
                  --Client.ignoreCount;

                  for (int int_1 = int_0; int_1 < Client.ignoreCount; int_1++) {
                     Client.ignores[int_1] = Client.ignores[int_1 + 1];
                  }

                  Client.anInt658 = Client.cycleCntr;
                  PacketNode packetnode_0 = Actor.method953(ClientPacket.aClientPacket94, Client.aClass46_1.cipher);
                  packetnode_0.packetBuffer.putByte(Projectile.getLength(string_0));
                  packetnode_0.packetBuffer.putString(string_0);
                  Client.aClass46_1.method282(packetnode_0);
                  break;
               }
            }

         }
      }
   }

}
