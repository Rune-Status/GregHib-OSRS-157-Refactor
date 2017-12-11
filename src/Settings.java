public class Settings {

   static int[] BIT_MASKS;
   public static int[] settings;
   public static int[] widgetSettings;
   static int[][] tileHeightArray;

   static {
      BIT_MASKS = new int[32];
      int value = 2;

      for (int index = 0; index < 32; index++) {
         BIT_MASKS[index] = value - 1;
         value += value;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   static void method466() {
      short short_0 = 256;
      int int_0;
      if (Class25.anInt77 > 0) {
         for (int_0 = 0; int_0 < 256; int_0++) {
            if (Class25.anInt77 > 768) {
               Overlay.anIntArray81[int_0] = Class51.method328(ClanMember.anIntArray77[int_0], ChatLineBuffer.anIntArray1[int_0], 1024 - Class25.anInt77);
            } else if (Class25.anInt77 > 256) {
               Overlay.anIntArray81[int_0] = ChatLineBuffer.anIntArray1[int_0];
            } else {
               Overlay.anIntArray81[int_0] = Class51.method328(ChatLineBuffer.anIntArray1[int_0], ClanMember.anIntArray77[int_0], 256 - Class25.anInt77);
            }
         }
      } else if (Class25.anInt78 > 0) {
         for (int_0 = 0; int_0 < 256; int_0++) {
            if (Class25.anInt78 > 768) {
               Overlay.anIntArray81[int_0] = Class51.method328(ClanMember.anIntArray77[int_0], MessageNode.anIntArray109[int_0], 1024 - Class25.anInt78);
            } else if (Class25.anInt78 > 256) {
               Overlay.anIntArray81[int_0] = MessageNode.anIntArray109[int_0];
            } else {
               Overlay.anIntArray81[int_0] = Class51.method328(MessageNode.anIntArray109[int_0], ClanMember.anIntArray77[int_0], 256 - Class25.anInt78);
            }
         }
      } else {
         for (int_0 = 0; int_0 < 256; int_0++) {
            Overlay.anIntArray81[int_0] = ClanMember.anIntArray77[int_0];
         }
      }

      Rasterizer2D.setDrawRegion(Class25.anInt76, 9, Class25.anInt76 + 128, short_0 + 7);
      Class25.aSpritePixels4.drawImage(Class25.anInt76, 0);
      Rasterizer2D.noClip();
      int_0 = 0;
      int int_1 = Class68_Sub1.aBufferProvider1.width * 9 + Class25.anInt76;

      int int_2;
      int int_3;
      int int_4;
      int int_5;
      int int_6;
      int int_7;
      int int_8;
      int int_9;
      for (int_2 = 1; int_2 < short_0 - 1; int_2++) {
         int_3 = Class25.anIntArray16[int_2] * (short_0 - int_2) / short_0;
         int_4 = int_3 + 22;
         if (int_4 < 0) {
            int_4 = 0;
         }

         int_0 += int_4;

         for (int_5 = int_4; int_5 < 128; int_5++) {
            int_6 = CombatInfoListHolder.anIntArray73[int_0++];
            if (int_6 != 0) {
               int_7 = int_6;
               int_8 = 256 - int_6;
               int_6 = Overlay.anIntArray81[int_6];
               int_9 = Class68_Sub1.aBufferProvider1.pixels[int_1];
               Class68_Sub1.aBufferProvider1.pixels[int_1++] = (int_7 * (int_6 & 0xFF00) + int_8 * (int_9 & 0xFF00) & 0xFF0000) + ((int_6 & 0xFF00FF) * int_7 + (int_9 & 0xFF00FF) * int_8 & 0xFF00FF00) >> 8;
            } else {
               ++int_1;
            }
         }

         int_1 += int_4 + Class68_Sub1.aBufferProvider1.width - 128;
      }

      Rasterizer2D.setDrawRegion(Class25.anInt76 + 765 - 128, 9, Class25.anInt76 + 765, short_0 + 7);
      Class25.aSpritePixels5.drawImage(Class25.anInt76 + 382, 0);
      Rasterizer2D.noClip();
      int_0 = 0;
      int_1 = Class68_Sub1.aBufferProvider1.width * 9 + Class25.anInt76 + 637 + 24;

      for (int_2 = 1; int_2 < short_0 - 1; int_2++) {
         int_3 = Class25.anIntArray16[int_2] * (short_0 - int_2) / short_0;
         int_4 = 103 - int_3;
         int_1 += int_3;

         for (int_5 = 0; int_5 < int_4; int_5++) {
            int_6 = CombatInfoListHolder.anIntArray73[int_0++];
            if (int_6 != 0) {
               int_7 = int_6;
               int_8 = 256 - int_6;
               int_6 = Overlay.anIntArray81[int_6];
               int_9 = Class68_Sub1.aBufferProvider1.pixels[int_1];
               Class68_Sub1.aBufferProvider1.pixels[int_1++] = (int_7 * (int_6 & 0xFF00) + int_8 * (int_9 & 0xFF00) & 0xFF0000) + ((int_9 & 0xFF00FF) * int_8 + (int_6 & 0xFF00FF) * int_7 & 0xFF00FF00) >> 8;
            } else {
               ++int_1;
            }
         }

         int_0 += 128 - int_4;
         int_1 += Class68_Sub1.aBufferProvider1.width - int_4 - int_3;
      }

   }

}
