public class Class78 {

   public static int anInt172;
   public static AClass6_Sub3 anAClass6_Sub3_1;
   public static Track1 aTrack1_1;
   public static int anInt173;
   public static IndexDataBase anIndexDataBase4;
   public static int anInt174;
   public static IndexDataBase anIndexDataBase5;
   public static boolean aBool29;

   static {
      anInt172 = 0;
   }

   static void method465() {
      int int_0 = Class4.localPlayer.x;
      int int_1 = Class4.localPlayer.y;
      if (WorldMapType3.anInt232 - int_0 < -500 || WorldMapType3.anInt232 - int_0 > 500 || Class9.anInt43 - int_1 < -500 || Class9.anInt43 - int_1 > 500) {
         WorldMapType3.anInt232 = int_0;
         Class9.anInt43 = int_1;
      }

      if (int_0 != WorldMapType3.anInt232) {
         WorldMapType3.anInt232 += (int_0 - WorldMapType3.anInt232) / 16;
      }

      if (int_1 != Class9.anInt43) {
         Class9.anInt43 += (int_1 - Class9.anInt43) / 16;
      }

      int int_2;
      int int_3;
      if (MouseInput.anInt263 == 4 && Item.aBool73) {
         int_2 = MouseInput.anInt262 - Client.anInt687;
         Client.anInt684 = int_2 * 2;
         Client.anInt687 = int_2 != -1 && int_2 != 1 ? (MouseInput.anInt262 + Client.anInt687) / 2 : MouseInput.anInt262;
         int_3 = Client.anInt685 - MouseInput.anInt260;
         Client.anInt681 = int_3 * 2;
         Client.anInt685 = int_3 != -1 && int_3 != 1 ? (Client.anInt685 + MouseInput.anInt260) / 2 : MouseInput.anInt260;
      } else {
         if (KeyFocusListener.aBoolArray3[96]) {
            Client.anInt681 += (-24 - Client.anInt681) / 2;
         } else if (KeyFocusListener.aBoolArray3[97]) {
            Client.anInt681 += (24 - Client.anInt681) / 2;
         } else {
            Client.anInt681 /= 2;
         }

         if (KeyFocusListener.aBoolArray3[98]) {
            Client.anInt684 += (12 - Client.anInt684) / 2;
         } else if (KeyFocusListener.aBoolArray3[99]) {
            Client.anInt684 += (-12 - Client.anInt684) / 2;
         } else {
            Client.anInt684 /= 2;
         }

         Client.anInt687 = MouseInput.anInt262;
         Client.anInt685 = MouseInput.anInt260;
      }

      Client.mapAngle = Client.anInt681 / 2 + Client.mapAngle & 0x7FF;
      Client.anInt661 += Client.anInt684 / 2;
      if (Client.anInt661 < 128) {
         Client.anInt661 = 128;
      }

      if (Client.anInt661 > 383) {
         Client.anInt661 = 383;
      }

      int_2 = WorldMapType3.anInt232 >> 7;
      int_3 = Class9.anInt43 >> 7;
      int int_4 = Class18.getTileHeight(WorldMapType3.anInt232, Class9.anInt43, Ignore.plane);
      int int_5 = 0;
      int int_6;
      if (int_2 > 3 && int_3 > 3 && int_2 < 100 && int_3 < 100) {
         for (int_6 = int_2 - 4; int_6 <= int_2 + 4; int_6++) {
            for (int int_7 = int_3 - 4; int_7 <= int_3 + 4; int_7++) {
               int int_8 = Ignore.plane;
               if (int_8 < 3 && (Region.renderRuleFlags[1][int_6][int_7] & 0x2) == 2) {
                  ++int_8;
               }

               int int_9 = int_4 - Region.tileHeightArray[int_8][int_6][int_7];
               if (int_9 > int_5) {
                  int_5 = int_9;
               }
            }
         }
      }

      int_6 = int_5 * 192;
      if (int_6 > 98048) {
         int_6 = 98048;
      }

      if (int_6 < 32768) {
         int_6 = 32768;
      }

      if (int_6 > Client.anInt690) {
         Client.anInt690 += (int_6 - Client.anInt690) / 24;
      } else if (int_6 < Client.anInt690) {
         Client.anInt690 += (int_6 - Client.anInt690) / 80;
      }

   }

}
