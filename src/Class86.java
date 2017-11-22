public class Class86 {

    static IndexDataBase anIndexDataBase6;

    static void method494() {
        int localPlayerCount = Class27.localPlayerIndexCount;
        int[] playerIndices = Class27.localPlayerIndices;

        for (int index = 0; index < localPlayerCount; index++) {
            Player player = Client.players[playerIndices[index]];
            if (player != null)
                ServerPacket.method355(player);
        }
    }

}
