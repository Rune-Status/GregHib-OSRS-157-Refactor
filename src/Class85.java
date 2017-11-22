public class Class85 {

   public static final boolean[] aBoolArray4;
   public static int[] anIntArray45;
   static SpritePixels[] headIconsHint;

   static {
      aBoolArray4 = new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      anIntArray45 = new int[99];
      int int_0 = 0;

      for (int int_1 = 0; int_1 < 99; int_1++) {
         int int_2 = int_1 + 1;
         int int_3 = (int)((double)int_2 + 300.0D * Math.pow(2.0D, (double)int_2 / 7.0D));
         int_0 += int_3;
         anIntArray45[int_1] = int_0 / 4;
      }

   }

   static void initializeGPI(PacketBuffer packetbuffer_0) {
      packetbuffer_0.bitAccess();
      int int_0 = Client.localInteractingIndex;
      Player player_0 = Class4.localPlayer = Client.cachedPlayers[int_0] = new Player();
      player_0.anInt601 = int_0;
      int int_1 = packetbuffer_0.getBits(30);
      byte byte_0 = (byte)(int_1 >> 28);
      int int_2 = int_1 >> 14 & 0x3FFF;
      int int_3 = int_1 & 0x3FFF;
      player_0.pathX[0] = int_2 - ItemLayer.baseX;
      player_0.x = (player_0.pathX[0] << 7) + (player_0.getSize() << 6);
      player_0.pathY[0] = int_3 - ItemLayer.baseY;
      player_0.y = (player_0.pathY[0] << 7) + (player_0.getSize() << 6);
      Ignore.plane = player_0.anInt600 = byte_0;
      if (Class27.aBufferArray1[int_0] != null) {
         player_0.decodeApperance(Class27.aBufferArray1[int_0]);
      }

      Class27.localPlayerIndexCount = 0;
      Class27.localPlayerIndices[++Class27.localPlayerIndexCount - 1] = int_0;
      Class27.updateFlags[int_0] = 0;
      Class27.externalPlayerCount = 0;

      for (int int_4 = 1; int_4 < 2048; int_4++) {
         if (int_0 != int_4) {
            int int_5 = packetbuffer_0.getBits(18);
            int int_6 = int_5 >> 16;
            int int_7 = int_5 >> 8 & 0x255;
            int int_8 = int_5 & 0x255;
            Class27.anIntArray18[int_4] = (int_7 << 14) + int_8 + (int_6 << 28);
            Class27.anIntArray19[int_4] = 0;
            Class27.anIntArray20[int_4] = -1;
            Class27.externalPlayerIndices[++Class27.externalPlayerCount - 1] = int_4;
            Class27.updateFlags[int_4] = 0;
         }
      }

      packetbuffer_0.byteAccess();
   }

}
