public class Class7 {

    static byte[][][] overlayRotations;
    public static int anInt40;
    static int[] offsetsY;

    public static void method101() {
        try {
            if (Class78.anInt172 == 1) {
                int int_0 = Class78.anAClass6_Sub3_1.method848();
                if (int_0 > 0 && Class78.anAClass6_Sub3_1.method852()) {
                    int_0 -= Class1.anInt16;
                    if (int_0 < 0) {
                        int_0 = 0;
                    }

                    Class78.anAClass6_Sub3_1.method853(int_0);
                    return;
                }

                Class78.anAClass6_Sub3_1.method836();
                Class78.anAClass6_Sub3_1.method854();
                if (Class70.anIndexDataBase3 != null) {
                    Class78.anInt172 = 2;
                } else {
                    Class78.anInt172 = 0;
                }

                Class78.aTrack1_1 = null;
                Class3.aClass52_1 = null;
            }
        } catch (Exception exception_0) {
            exception_0.printStackTrace();
            Class78.anAClass6_Sub3_1.method836();
            Class78.anInt172 = 0;
            Class78.aTrack1_1 = null;
            Class3.aClass52_1 = null;
            Class70.anIndexDataBase3 = null;
        }

    }

    public static void method102(int int_0) {
        Class78.anInt172 = 1;
        Class70.anIndexDataBase3 = null;
        Class78.anInt173 = -1;
        Class78.anInt174 = -1;
        anInt40 = 0;
        Class78.aBool29 = false;
        Class1.anInt16 = int_0;
    }

    static boolean decodeRegionHash(PacketBuffer buffer, int index) {
        int int_1 = buffer.getBits(2);
        int int_2;
        int int_3;
        int int_5;
        int int_6;
        int int_7;
        int int_8;
        if (int_1 == 0) {
            if (buffer.getBits(1) != 0) {
                decodeRegionHash(buffer, index);
            }

            int_2 = buffer.getBits(13);
            int_3 = buffer.getBits(13);
            boolean bool_0 = buffer.getBits(1) == 1;
            if (bool_0) {
                Class27.playersAwaitingUpdate[++Class27.playerCount - 1] = index;
            }

            if (Client.players[index] != null) {
                throw new RuntimeException();
            } else {
                Player player_0 = Client.players[index] = new Player();
                player_0.localPlayerIndex = index;
                if (Class27.playerSynchronizationBuffers[index] != null) {
                    player_0.decodeAppearance(Class27.playerSynchronizationBuffers[index]);
                }

                player_0.orientation = Class27.orientations[index];
                player_0.interacting = Class27.interactions[index];
                int_5 = Class27.locationHashes[index];
                int_6 = int_5 >> 28;
                int_7 = int_5 >> 14 & 0xFF;
                int_8 = int_5 & 0xFF;
                player_0.pathRun[0] = Class27.aByteArray3[index];
                player_0.currentPlane = (byte) int_6;
                player_0.setFirstStep((int_7 << 13) + int_2 - Client.regionBaseX, (int_8 << 13) + int_3 - Client.regionBaseY);
                player_0.needsPositionUpdate = false;
                return true;
            }
        } else if (int_1 == 1) {
            int_2 = buffer.getBits(2);
            int_3 = Class27.locationHashes[index];
            Class27.locationHashes[index] = (((int_3 >> 28) + int_2 & 0x3) << 28) + (int_3 & 0xFFFFFFF);
            return false;
        } else {
            int int_4;
            int int_9;
            if (int_1 == 2) {
                int_2 = buffer.getBits(5);
                int_3 = int_2 >> 3;
                int_4 = int_2 & 0x7;
                int_9 = Class27.locationHashes[index];
                int_5 = (int_9 >> 28) + int_3 & 0x3;
                int_6 = int_9 >> 14 & 0xFF;
                int_7 = int_9 & 0xFF;
                if (int_4 == 0) {
                    --int_6;
                    --int_7;
                }

                if (int_4 == 1) {
                    --int_7;
                }

                if (int_4 == 2) {
                    ++int_6;
                    --int_7;
                }

                if (int_4 == 3) {
                    --int_6;
                }

                if (int_4 == 4) {
                    ++int_6;
                }

                if (int_4 == 5) {
                    --int_6;
                    ++int_7;
                }

                if (int_4 == 6) {
                    ++int_7;
                }

                if (int_4 == 7) {
                    ++int_6;
                    ++int_7;
                }

                Class27.locationHashes[index] = (int_6 << 14) + int_7 + (int_5 << 28);
                return false;
            } else {
                int_2 = buffer.getBits(18);
                int_3 = int_2 >> 16;
                int_4 = int_2 >> 8 & 0xFF;
                int_9 = int_2 & 0xFF;
                int_5 = Class27.locationHashes[index];
                int_6 = (int_5 >> 28) + int_3 & 0x3;
                int_7 = int_4 + (int_5 >> 14) & 0xFF;
                int_8 = int_5 + int_9 & 0xFF;
                Class27.locationHashes[index] = (int_7 << 14) + int_8 + (int_6 << 28);
                return false;
            }
        }
    }

    static void method103(int int_0) {
        ItemContainer itemcontainer_0 = (ItemContainer) ItemContainer.itemContainers.get((long) int_0);
        if (itemcontainer_0 != null) {
            for (int int_1 = 0; int_1 < itemcontainer_0.itemIds.length; int_1++) {
                itemcontainer_0.itemIds[int_1] = -1;
                itemcontainer_0.stackSizes[int_1] = 0;
            }

        }
    }

}
