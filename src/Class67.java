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

   static void method413(Player player, boolean bool_0) {
      if (player != null && player.hasConfig() && !player.hidden) {
         int int_0 = player.localPlayerIndex << 14;
         player.aBool82 = false;
         if ((Client.lowMemory && Class27.localPlayerIndexCount > 50 || Class27.localPlayerIndexCount > 200) && bool_0 && player.idlePoseAnimation == player.poseAnimation) {
            player.aBool82 = true;
         }

         int int_1 = player.x >> 7;
         int int_2 = player.y >> 7;
         if (int_1 >= 0 && int_1 < 104 && int_2 >= 0 && int_2 < 104) {
            if (player.playerModel != null && Client.gameCycle >= player.anInt594 && Client.gameCycle < player.anInt595) {
               player.aBool82 = false;
               player.anInt598 = Class18.getTileHeight(player.x, player.y, Ignore.plane);
               Class23.sceneGraph.method378(Ignore.plane, player.x, player.y, player.anInt598, 60, player, player.angle, int_0, player.anInt604, player.anInt605, player.anInt606, player.anInt607);
            } else {
               if ((player.x & 0x7F) == 64 && (player.y & 0x7F) == 64) {
                  if (Client.anIntArrayArray21[int_1][int_2] == Client.renderCycle) {
                     return;
                  }

                  Client.anIntArrayArray21[int_1][int_2] = Client.renderCycle;
               }

               player.anInt598 = Class18.getTileHeight(player.x, player.y, Ignore.plane);
               Class23.sceneGraph.method377(Ignore.plane, player.x, player.y, player.anInt598, 60, player, player.angle, int_0, player.aBool69);
            }
         }
      }

   }

   public static void method414() {
      Class54.aBool21 = false;
      Class54.anInt140 = 0;
   }

}
