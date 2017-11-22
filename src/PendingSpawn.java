public final class PendingSpawn extends Node {

   int delay;
   int hitpoints;
   int level;
   int x;
   int y;
   int type;
   int id;
   int anInt344;
   int orientation;
   int anInt345;
   int anInt346;
   int anInt347;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   public static Widget method671(int int_0) {
      int int_1 = int_0 >> 16;
      int int_2 = int_0 & 0xFFFF;
      if (Class91.widgets[int_1] == null || Class91.widgets[int_1][int_2] == null) {
         boolean bool_0 = CombatInfoListHolder.loadWidget(int_1);
         if (!bool_0) {
            return null;
         }
      }

      return Class91.widgets[int_1][int_2];
   }

   static void method672(Buffer buffer_0, long long_0) {
      long_0 /= 10L;
      if (long_0 < 0L) {
         long_0 = 0L;
      } else if (long_0 > 65535L) {
         long_0 = 65535L;
      }

      buffer_0.putShort((int)long_0);
   }

   static void method673() {
      PacketBuffer packetbuffer_0 = Client.aClass46_1.aPacketBuffer1;
      packetbuffer_0.bitAccess();
      int int_0 = packetbuffer_0.getBits(8);
      int int_1;
      if (int_0 < Client.npcIndexesCount) {
         for (int_1 = int_0; int_1 < Client.npcIndexesCount; int_1++) {
            Client.anIntArray157[++Client.anInt666 - 1] = Client.npcIndices[int_1];
         }
      }

      if (int_0 > Client.npcIndexesCount) {
         throw new RuntimeException("");
      } else {
         Client.npcIndexesCount = 0;

         for (int_1 = 0; int_1 < int_0; int_1++) {
            int int_2 = Client.npcIndices[int_1];
            NPC npc_0 = Client.cachedNPCs[int_2];
            int int_3 = packetbuffer_0.getBits(1);
            if (int_3 == 0) {
               Client.npcIndices[++Client.npcIndexesCount - 1] = int_2;
               npc_0.anInt531 = Client.gameCycle;
            } else {
               int int_4 = packetbuffer_0.getBits(2);
               if (int_4 == 0) {
                  Client.npcIndices[++Client.npcIndexesCount - 1] = int_2;
                  npc_0.anInt531 = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = int_2;
               } else {
                  int int_5;
                  int int_6;
                  if (int_4 == 1) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = int_2;
                     npc_0.anInt531 = Client.gameCycle;
                     int_5 = packetbuffer_0.getBits(3);
                     npc_0.method1066(int_5, (byte) 1);
                     int_6 = packetbuffer_0.getBits(1);
                     if (int_6 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = int_2;
                     }
                  } else if (int_4 == 2) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = int_2;
                     npc_0.anInt531 = Client.gameCycle;
                     int_5 = packetbuffer_0.getBits(3);
                     npc_0.method1066(int_5, (byte) 2);
                     int_6 = packetbuffer_0.getBits(3);
                     npc_0.method1066(int_6, (byte) 2);
                     int int_7 = packetbuffer_0.getBits(1);
                     if (int_7 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = int_2;
                     }
                  } else if (int_4 == 3) {
                     Client.anIntArray157[++Client.anInt666 - 1] = int_2;
                  }
               }
            }
         }

      }
   }

   static void method674(int int_0, int int_1, int int_2, int int_3) {
      for (int int_4 = int_1; int_4 <= int_3 + int_1; int_4++) {
         for (int int_5 = int_0; int_5 <= int_0 + int_2; int_5++) {
            if (int_5 >= 0 && int_5 < 104 && int_4 >= 0 && int_4 < 104) {
               Class19.aByteArrayArrayArray7[0][int_5][int_4] = 127;
               if (int_0 == int_5 && int_5 > 0) {
                  Class19.tileHeights[0][int_5][int_4] = Class19.tileHeights[0][int_5 - 1][int_4];
               }

               if (int_5 == int_0 + int_2 && int_5 < 103) {
                  Class19.tileHeights[0][int_5][int_4] = Class19.tileHeights[0][int_5 + 1][int_4];
               }

               if (int_4 == int_1 && int_4 > 0) {
                  Class19.tileHeights[0][int_5][int_4] = Class19.tileHeights[0][int_5][int_4 - 1];
               }

               if (int_3 + int_1 == int_4 && int_4 < 103) {
                  Class19.tileHeights[0][int_5][int_4] = Class19.tileHeights[0][int_5][int_4 + 1];
               }
            }
         }
      }

   }

}
