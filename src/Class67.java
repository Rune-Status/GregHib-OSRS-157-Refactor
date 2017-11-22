public class Class67 {

   static void method412() {
      for (int int_0 = 0; int_0 < Client.menuOptionCount; int_0++) {
         int int_1 = Client.menuTypes[int_0];
         boolean bool_0 = int_1 == 57 || int_1 == 58 || int_1 == 1007 || int_1 == 25 || int_1 == 30;
         if (bool_0) {
            if (int_0 < Client.menuOptionCount - 1) {
               for (int int_2 = int_0; int_2 < Client.menuOptionCount - 1; int_2++) {
                  Client.menuOptions[int_2] = Client.menuOptions[int_2 + 1];
                  Client.menuTargets[int_2] = Client.menuTargets[int_2 + 1];
                  Client.menuTypes[int_2] = Client.menuTypes[int_2 + 1];
                  Client.menuIdentifiers[int_2] = Client.menuIdentifiers[int_2 + 1];
                  Client.menuActionParams0[int_2] = Client.menuActionParams0[int_2 + 1];
                  Client.menuActionParams1[int_2] = Client.menuActionParams1[int_2 + 1];
                  Client.aBoolArray9[int_2] = Client.aBoolArray9[int_2 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   static void method413(Player player_0, boolean bool_0) {
      if (player_0 != null && player_0.hasConfig() && !player_0.hidden) {
         int int_0 = player_0.anInt601 << 14;
         player_0.aBool82 = false;
         if ((Client.lowMemory && Class27.localPlayerIndexCount > 50 || Class27.localPlayerIndexCount > 200) && bool_0 && player_0.idlePoseAnimation == player_0.poseAnimation) {
            player_0.aBool82 = true;
         }

         int int_1 = player_0.x >> 7;
         int int_2 = player_0.y >> 7;
         if (int_1 >= 0 && int_1 < 104 && int_2 >= 0 && int_2 < 104) {
            if (player_0.model != null && Client.gameCycle >= player_0.anInt594 && Client.gameCycle < player_0.anInt595) {
               player_0.aBool82 = false;
               player_0.anInt598 = Class18.getTileHeight(player_0.x, player_0.y, Ignore.plane);
               Class23.region.method378(Ignore.plane, player_0.x, player_0.y, player_0.anInt598, 60, player_0, player_0.angle, int_0, player_0.anInt604, player_0.anInt605, player_0.anInt606, player_0.anInt607);
            } else {
               if ((player_0.x & 0x7F) == 64 && (player_0.y & 0x7F) == 64) {
                  if (Client.anIntArrayArray21[int_1][int_2] == Client.anInt664) {
                     return;
                  }

                  Client.anIntArrayArray21[int_1][int_2] = Client.anInt664;
               }

               player_0.anInt598 = Class18.getTileHeight(player_0.x, player_0.y, Ignore.plane);
               Class23.region.method377(Ignore.plane, player_0.x, player_0.y, player_0.anInt598, 60, player_0, player_0.angle, int_0, player_0.aBool69);
            }
         }
      }

   }

   public static void method414() {
      Class54.aBool21 = false;
      Class54.anInt140 = 0;
   }

}
