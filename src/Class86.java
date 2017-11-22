public class Class86 {

   static IndexDataBase anIndexDataBase6;

   static void method494() {
      int int_0 = Class27.localPlayerIndexCount;
      int[] ints_0 = Class27.localPlayerIndices;

      for (int int_1 = 0; int_1 < int_0; int_1++) {
         Player player_0 = Client.cachedPlayers[ints_0[int_1]];
         if (player_0 != null) {
            ServerPacket.method355(player_0);
         }
      }

   }

}
