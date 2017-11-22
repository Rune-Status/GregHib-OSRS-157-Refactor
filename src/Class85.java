public class Class85 {

    public static final boolean[] aBoolArray4;
    public static int[] anIntArray45;
    static SpritePixels[] headIconsHint;

    static {
        aBoolArray4 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
        anIntArray45 = new int[99];
        int int_0 = 0;

        for (int int_1 = 0; int_1 < 99; int_1++) {
            int int_2 = int_1 + 1;
            int int_3 = (int) ((double) int_2 + 300.0D * Math.pow(2.0D, (double) int_2 / 7.0D));
            int_0 += int_3;
            anIntArray45[int_1] = int_0 / 4;
        }

    }

    static void initializeGPI(PacketBuffer buffer) {
        buffer.bitAccess();
        int playerIndex = Client.localInteractingIndex;
        Player player = Class4.localPlayer = Client.cachedPlayers[playerIndex] = new Player();
        player.localPlayerIndex = playerIndex;
        int hash = buffer.getBits(30);
        byte plane = (byte) (hash >> 28);
        int x = hash >> 14 & 0x3FFF;
        int y = hash & 0x3FFF;
        player.pathX[0] = x - ItemLayer.baseX;
        player.x = (player.pathX[0] << 7) + (player.getSize() << 6);
        player.pathY[0] = y - ItemLayer.baseY;
        player.y = (player.pathY[0] << 7) + (player.getSize() << 6);
        Ignore.plane = player.currentPlane = plane;
        if (Class27.playerSynchronizationBuffers[playerIndex] != null) {
            player.decodeAppearance(Class27.playerSynchronizationBuffers[playerIndex]);
        }

        Class27.localPlayerIndexCount = 0;
        Class27.localPlayerIndices[++Class27.localPlayerIndexCount - 1] = playerIndex;
        Class27.updateFlags[playerIndex] = 0;
        Class27.externalPlayerCount = 0;

        for (int index = 1; index < 2048; index++) {
            if (playerIndex != index) {
                int info = buffer.getBits(18);
                int int_6 = info >> 16;
                int int_7 = info >> 8 & 0x255;
                int int_8 = info & 0x255;
                Class27.locationHashes[index] = (int_7 << 14) + int_8 + (int_6 << 28);
                Class27.anIntArray19[index] = 0;
                Class27.anIntArray20[index] = -1;
                Class27.externalPlayerIndices[++Class27.externalPlayerCount - 1] = index;
                Class27.updateFlags[index] = 0;
            }
        }

        buffer.byteAccess();
    }

}
