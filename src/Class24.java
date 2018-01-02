public final class Class24 {

   static Class109 aClass109_1;

   public static void addMenuEntry(String string_0, String string_1, int int_0, int int_1, int int_2, int int_3) {
      Class73.method444(string_0, string_1, int_0, int_1, int_2, int_3, false);
   }

   static void method216() {
      for (int int_0 = 0; int_0 < Client.anInt647; int_0++) {
         --Client.anIntArray152[int_0];
         if (Client.anIntArray152[int_0] >= -10) {
            SoundEffect soundeffect_0 = Client.audioEffects[int_0];
            if (soundeffect_0 == null) {
               Object object_0 = null;
               soundeffect_0 = SoundEffect.getTrack(Tile.soundEffectsIndex, Client.anIntArray149[int_0], 0);
               if (soundeffect_0 == null) {
                  continue;
               }

               Client.anIntArray152[int_0] += soundeffect_0.calculateDelay();
               Client.audioEffects[int_0] = soundeffect_0;
            }

            if (Client.anIntArray152[int_0] < 0) {
               int int_8;
               if (Client.anIntArray153[int_0] != 0) {
                  int int_2 = (Client.anIntArray153[int_0] & 0xFF) * 128;
                  int int_3 = Client.anIntArray153[int_0] >> 16 & 0xFF;
                  int int_4 = int_3 * 128 + 64 - Class4.localPlayer.x;
                  if (int_4 < 0) {
                     int_4 = -int_4;
                  }

                  int int_5 = Client.anIntArray153[int_0] >> 8 & 0xFF;
                  int int_6 = int_5 * 128 + 64 - Class4.localPlayer.y;
                  if (int_6 < 0) {
                     int_6 = -int_6;
                  }

                  int int_7 = int_6 + int_4 - 128;
                  if (int_7 > int_2) {
                     Client.anIntArray152[int_0] = -100;
                     continue;
                  }

                  if (int_7 < 0) {
                     int_7 = 0;
                  }

                  int_8 = (int_2 - int_7) * Client.anInt646 / int_2;
               } else {
                  int_8 = Client.waveVolume;
               }

               if (int_8 > 0) {
                  AClass4_Sub1 aclass4_sub1_0 = soundeffect_0.method421().method761(Class87.aClass51_1);
                  AClass6_Sub2 aclass6_sub2_0 = AClass6_Sub2.method804(aclass4_sub1_0, 100, int_8);
                  aclass6_sub2_0.method782(Client.anIntArray150[int_0] - 1);
                  Class97.anAClass6_Sub1_1.method757(aclass6_sub2_0);
               }

               Client.anIntArray152[int_0] = -100;
            }
         } else {
            --Client.anInt647;

            for (int int_1 = int_0; int_1 < Client.anInt647; int_1++) {
               Client.anIntArray149[int_1] = Client.anIntArray149[int_1 + 1];
               Client.audioEffects[int_1] = Client.audioEffects[int_1 + 1];
               Client.anIntArray150[int_1] = Client.anIntArray150[int_1 + 1];
               Client.anIntArray152[int_1] = Client.anIntArray152[int_1 + 1];
               Client.anIntArray153[int_1] = Client.anIntArray153[int_1 + 1];
            }

            --int_0;
         }
      }

      if (Client.aBool87) {
         boolean bool_0;
         if (Class78.anInt172 != 0) {
            bool_0 = true;
         } else {
            bool_0 = Class78.anAClass6_Sub3_1.method852();
         }

         if (!bool_0) {
            if (Client.anInt662 != 0 && Client.anInt643 != -1) {
               Class71.method424(Class38.songsIndex, Client.anInt643, 0, Client.anInt662, false);
            }

            Client.aBool87 = false;
         }
      }

   }

}
