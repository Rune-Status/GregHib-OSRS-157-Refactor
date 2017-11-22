import java.util.Comparator;

final class Class42 implements Comparator {

   static IndexDataBase anIndexDataBase2;
   static int menuHeight;
   static int anInt101;

   int method263(Class36 class36_0, Class36 class36_1) {
      return class36_0.method246().compareTo(class36_1.method246());
   }

   public boolean equals(Object object_0) {
      return super.equals(object_0);
   }

   public int compare(Object object_0, Object object_1) {
      return this.method263((Class36) object_0, (Class36) object_1);
   }

   static void method264(Model model_0, int int_0, int int_1, int int_2, int int_3) {
      Class37.aCombatInfoList1.method455(new AClass3_Sub2(model_0, int_0, int_1, int_2, int_3));
   }

   static void method265(String string_0) {
      if (!string_0.equals("")) {
         PacketNode packetnode_0 = Actor.method953(ClientPacket.aClientPacket86, Client.aClass46_1.anISAACCipher1);
         packetnode_0.packetBuffer.putByte(Projectile.getLength(string_0));
         packetnode_0.packetBuffer.putString(string_0);
         Client.aClass46_1.method282(packetnode_0);
      }
   }

}
