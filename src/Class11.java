public class Class11 implements Interface2 {

   public static IndexDataBase varplayer_ref;
   static IndexedSprite[] anIndexedSpriteArray2;

   public AbstractSoundSystem method3() {
      return new SourceDataSoundSystem();
   }

   public static boolean method163() {
      KeyFocusListener keyfocuslistener_0 = KeyFocusListener.keyboard;
      synchronized(keyfocuslistener_0) {
         if (KeyFocusListener.anInt125 == KeyFocusListener.anInt127) {
            return false;
         } else {
            CombatInfoListHolder.anInt329 = KeyFocusListener.anIntArray30[KeyFocusListener.anInt125];
            Class106.aChar1 = KeyFocusListener.aCharArray1[KeyFocusListener.anInt125];
            KeyFocusListener.anInt125 = KeyFocusListener.anInt125 + 1 & 0x7F;
            return true;
         }
      }
   }

   static void decodeMovement(PacketBuffer packetbuffer_0, int int_0) {
      boolean bool_0 = packetbuffer_0.getBits(1) == 1;
      if (bool_0) {
         Class27.playerIndexes[++Class27.playerCount - 1] = int_0;
      }

      int int_1 = packetbuffer_0.getBits(2);
      Player player_0 = Client.cachedPlayers[int_0];
      if (int_1 == 0) {
         if (bool_0) {
            player_0.aBool83 = false;
         } else if (Client.localInteractingIndex == int_0) {
            throw new RuntimeException();
         } else {
            Class27.anIntArray18[int_0] = (player_0.currentPlane << 28) + (ItemLayer.baseX + player_0.pathX[0] >> 13 << 14) + (ItemLayer.baseY + player_0.pathY[0] >> 13);
            if (player_0.anInt510 != -1) {
               Class27.anIntArray19[int_0] = player_0.anInt510;
            } else {
               Class27.anIntArray19[int_0] = player_0.orientation;
            }

            Class27.anIntArray20[int_0] = player_0.interacting;
            Client.cachedPlayers[int_0] = null;
            if (packetbuffer_0.getBits(1) != 0) {
               Class7.decodeRegionHash(packetbuffer_0, int_0);
            }

         }
      } else {
         int int_2;
         int int_3;
         int int_4;
         if (int_1 == 1) {
            int_2 = packetbuffer_0.getBits(3);
            int_3 = player_0.pathX[0];
            int_4 = player_0.pathY[0];
            if (int_2 == 0) {
               --int_3;
               --int_4;
            } else if (int_2 == 1) {
               --int_4;
            } else if (int_2 == 2) {
               ++int_3;
               --int_4;
            } else if (int_2 == 3) {
               --int_3;
            } else if (int_2 == 4) {
               ++int_3;
            } else if (int_2 == 5) {
               --int_3;
               ++int_4;
            } else if (int_2 == 6) {
               ++int_4;
            } else if (int_2 == 7) {
               ++int_3;
               ++int_4;
            }

            if (Client.localInteractingIndex == int_0 && (player_0.x < 1536 || player_0.y < 1536 || player_0.x >= 11776 || player_0.y >= 11776)) {
               player_0.method1093(int_3, int_4);
               player_0.aBool83 = false;
            } else if (bool_0) {
               player_0.aBool83 = true;
               player_0.anInt602 = int_3;
               player_0.anInt603 = int_4;
            } else {
               player_0.aBool83 = false;
               player_0.method1095(int_3, int_4, Class27.aByteArray3[int_0]);
            }

         } else if (int_1 == 2) {
            int_2 = packetbuffer_0.getBits(4);
            int_3 = player_0.pathX[0];
            int_4 = player_0.pathY[0];
            if (int_2 == 0) {
               int_3 -= 2;
               int_4 -= 2;
            } else if (int_2 == 1) {
               --int_3;
               int_4 -= 2;
            } else if (int_2 == 2) {
               int_4 -= 2;
            } else if (int_2 == 3) {
               ++int_3;
               int_4 -= 2;
            } else if (int_2 == 4) {
               int_3 += 2;
               int_4 -= 2;
            } else if (int_2 == 5) {
               int_3 -= 2;
               --int_4;
            } else if (int_2 == 6) {
               int_3 += 2;
               --int_4;
            } else if (int_2 == 7) {
               int_3 -= 2;
            } else if (int_2 == 8) {
               int_3 += 2;
            } else if (int_2 == 9) {
               int_3 -= 2;
               ++int_4;
            } else if (int_2 == 10) {
               int_3 += 2;
               ++int_4;
            } else if (int_2 == 11) {
               int_3 -= 2;
               int_4 += 2;
            } else if (int_2 == 12) {
               --int_3;
               int_4 += 2;
            } else if (int_2 == 13) {
               int_4 += 2;
            } else if (int_2 == 14) {
               ++int_3;
               int_4 += 2;
            } else if (int_2 == 15) {
               int_3 += 2;
               int_4 += 2;
            }

            if (Client.localInteractingIndex == int_0 && (player_0.x < 1536 || player_0.y < 1536 || player_0.x >= 11776 || player_0.y >= 11776)) {
               player_0.method1093(int_3, int_4);
               player_0.aBool83 = false;
            } else if (bool_0) {
               player_0.aBool83 = true;
               player_0.anInt602 = int_3;
               player_0.anInt603 = int_4;
            } else {
               player_0.aBool83 = false;
               player_0.method1095(int_3, int_4, Class27.aByteArray3[int_0]);
            }

         } else {
            int_2 = packetbuffer_0.getBits(1);
            int int_5;
            int int_6;
            int int_7;
            int int_8;
            if (int_2 == 0) {
               int_3 = packetbuffer_0.getBits(12);
               int_4 = int_3 >> 10;
               int_5 = int_3 >> 5 & 0x1F;
               if (int_5 > 15) {
                  int_5 -= 32;
               }

               int_6 = int_3 & 0x1F;
               if (int_6 > 15) {
                  int_6 -= 32;
               }

               int_7 = int_5 + player_0.pathX[0];
               int_8 = int_6 + player_0.pathY[0];
               if (Client.localInteractingIndex == int_0 && (player_0.x < 1536 || player_0.y < 1536 || player_0.x >= 11776 || player_0.y >= 11776)) {
                  player_0.method1093(int_7, int_8);
                  player_0.aBool83 = false;
               } else if (bool_0) {
                  player_0.aBool83 = true;
                  player_0.anInt602 = int_7;
                  player_0.anInt603 = int_8;
               } else {
                  player_0.aBool83 = false;
                  player_0.method1095(int_7, int_8, Class27.aByteArray3[int_0]);
               }

               player_0.currentPlane = (byte)(int_4 + player_0.currentPlane & 0x3);
               if (Client.localInteractingIndex == int_0) {
                  Ignore.plane = player_0.currentPlane;
               }

            } else {
               int_3 = packetbuffer_0.getBits(30);
               int_4 = int_3 >> 28;
               int_5 = int_3 >> 14 & 0x3FFF;
               int_6 = int_3 & 0x3FFF;
               int_7 = (int_5 + ItemLayer.baseX + player_0.pathX[0] & 0x3FFF) - ItemLayer.baseX;
               int_8 = (int_6 + ItemLayer.baseY + player_0.pathY[0] & 0x3FFF) - ItemLayer.baseY;
               if (Client.localInteractingIndex != int_0 || player_0.x >= 1536 && player_0.y >= 1536 && player_0.x < 11776 && player_0.y < 11776) {
                  if (bool_0) {
                     player_0.aBool83 = true;
                     player_0.anInt602 = int_7;
                     player_0.anInt603 = int_8;
                  } else {
                     player_0.aBool83 = false;
                     player_0.method1095(int_7, int_8, Class27.aByteArray3[int_0]);
                  }
               } else {
                  player_0.method1093(int_7, int_8);
                  player_0.aBool83 = false;
               }

               player_0.currentPlane = (byte)(int_4 + player_0.currentPlane & 0x3);
               if (Client.localInteractingIndex == int_0) {
                  Ignore.plane = player_0.currentPlane;
               }

            }
         }
      }
   }

   static int method164(int int_0, Script script_0, boolean bool_0) {
      if (int_0 == 6200) {
         Class23.intStackSize -= 2;
         Client.aShort4 = (short)Class39.intStack[Class23.intStackSize];
         if (Client.aShort4 <= 0) {
            Client.aShort4 = 256;
         }

         Client.aShort3 = (short)Class39.intStack[Class23.intStackSize + 1];
         if (Client.aShort3 <= 0) {
            Client.aShort3 = 205;
         }

         return 1;
      } else if (int_0 == 6201) {
         Class23.intStackSize -= 2;
         Client.aShort9 = (short)Class39.intStack[Class23.intStackSize];
         if (Client.aShort9 <= 0) {
            Client.aShort9 = 256;
         }

         Client.aShort8 = (short)Class39.intStack[Class23.intStackSize + 1];
         if (Client.aShort8 <= 0) {
            Client.aShort8 = 320;
         }

         return 1;
      } else if (int_0 == 6202) {
         Class23.intStackSize -= 4;
         Client.aShort10 = (short)Class39.intStack[Class23.intStackSize];
         if (Client.aShort10 <= 0) {
            Client.aShort10 = 1;
         }

         Client.aShort7 = (short)Class39.intStack[Class23.intStackSize + 1];
         if (Client.aShort7 <= 0) {
            Client.aShort7 = 32767;
         } else if (Client.aShort7 < Client.aShort10) {
            Client.aShort7 = Client.aShort10;
         }

         Client.aShort5 = (short)Class39.intStack[Class23.intStackSize + 2];
         if (Client.aShort5 <= 0) {
            Client.aShort5 = 1;
         }

         Client.aShort6 = (short)Class39.intStack[Class23.intStackSize + 3];
         if (Client.aShort6 <= 0) {
            Client.aShort6 = 32767;
         } else if (Client.aShort6 < Client.aShort5) {
            Client.aShort6 = Client.aShort5;
         }

         return 1;
      } else if (int_0 == 6203) {
         if (Client.aWidget11 != null) {
            Class65.method402(0, 0, Client.aWidget11.width, Client.aWidget11.height, false);
            Class39.intStack[++Class23.intStackSize - 1] = Client.viewportHeight;
            Class39.intStack[++Class23.intStackSize - 1] = Client.viewportWidth;
         } else {
            Class39.intStack[++Class23.intStackSize - 1] = -1;
            Class39.intStack[++Class23.intStackSize - 1] = -1;
         }

         return 1;
      } else if (int_0 == 6204) {
         Class39.intStack[++Class23.intStackSize - 1] = Client.aShort9;
         Class39.intStack[++Class23.intStackSize - 1] = Client.aShort8;
         return 1;
      } else if (int_0 == 6205) {
         Class39.intStack[++Class23.intStackSize - 1] = Client.aShort4;
         Class39.intStack[++Class23.intStackSize - 1] = Client.aShort3;
         return 1;
      } else {
         return 2;
      }
   }

}
