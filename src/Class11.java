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

   static void decodeMovement(PacketBuffer buffer, int index) {
      boolean update = buffer.getBits(1) == 1;
      if (update)
         Class27.playersAwaitingUpdate[++Class27.playerCount - 1] = index;

      int type = buffer.getBits(2);
      Player player = Client.players[index];
      if (type == 0) {
         if (update) {
            player.needsPositionUpdate = false;
         } else if (Client.localInteractingIndex == index) {
            throw new RuntimeException();
         } else {
            Class27.locationHashes[index] = (player.currentPlane << 28) + (Client.regionBaseX + player.pathX[0] >> 13 << 14) + (Client.regionBaseY + player.pathY[0] >> 13);
            if (player.nextStepOrientation != -1) {
               Class27.orientations[index] = player.nextStepOrientation;
            } else {
               Class27.orientations[index] = player.orientation;
            }

            Class27.interactions[index] = player.interacting;
            Client.players[index] = null;
            if (buffer.getBits(1) != 0)
               Class7.decodeRegionHash(buffer, index);
         }
      } else {
         int direction;
         int x;
         int y;
         if (type == 1) {
            direction = buffer.getBits(3);
            x = player.pathX[0];
            y = player.pathY[0];
            if (direction == 0) {
               --x;
               --y;
            } else if (direction == 1) {
               --y;
            } else if (direction == 2) {
               ++x;
               --y;
            } else if (direction == 3) {
               --x;
            } else if (direction == 4) {
               ++x;
            } else if (direction == 5) {
               --x;
               ++y;
            } else if (direction == 6) {
               ++y;
            } else if (direction == 7) {
               ++x;
               ++y;
            }

            if (Client.localInteractingIndex == index && (player.x < 1536 || player.y < 1536 || player.x >= 11776 || player.y >= 11776)) {
               player.setFirstStep(x, y);
               player.needsPositionUpdate = false;
            } else if (update) {
               player.needsPositionUpdate = true;
               player.targetX = x;
               player.targetY = y;
            } else {
               player.needsPositionUpdate = false;
               player.move(x, y, Class27.aByteArray3[index]);
            }

         } else if (type == 2) {
            direction = buffer.getBits(4);
            x = player.pathX[0];
            y = player.pathY[0];
            if (direction == 0) {
               x -= 2;
               y -= 2;
            } else if (direction == 1) {
               --x;
               y -= 2;
            } else if (direction == 2) {
               y -= 2;
            } else if (direction == 3) {
               ++x;
               y -= 2;
            } else if (direction == 4) {
               x += 2;
               y -= 2;
            } else if (direction == 5) {
               x -= 2;
               --y;
            } else if (direction == 6) {
               x += 2;
               --y;
            } else if (direction == 7) {
               x -= 2;
            } else if (direction == 8) {
               x += 2;
            } else if (direction == 9) {
               x -= 2;
               ++y;
            } else if (direction == 10) {
               x += 2;
               ++y;
            } else if (direction == 11) {
               x -= 2;
               y += 2;
            } else if (direction == 12) {
               --x;
               y += 2;
            } else if (direction == 13) {
               y += 2;
            } else if (direction == 14) {
               ++x;
               y += 2;
            } else if (direction == 15) {
               x += 2;
               y += 2;
            }

            if (Client.localInteractingIndex == index && (player.x < 1536 || player.y < 1536 || player.x >= 11776 || player.y >= 11776)) {
               player.setFirstStep(x, y);
               player.needsPositionUpdate = false;
            } else if (update) {
               player.needsPositionUpdate = true;
               player.targetX = x;
               player.targetY = y;
            } else {
               player.needsPositionUpdate = false;
               player.move(x, y, Class27.aByteArray3[index]);
            }

         } else {
            direction = buffer.getBits(1);
            int baseX;
            int baseY;
            int stepX;
            int stepY;
            if (direction == 0) {
               x = buffer.getBits(12);
               y = x >> 10;
               baseX = x >> 5 & 0x1F;
               if (baseX > 15) {
                  baseX -= 32;
               }

               baseY = x & 0x1F;
               if (baseY > 15) {
                  baseY -= 32;
               }

               stepX = baseX + player.pathX[0];
               stepY = baseY + player.pathY[0];
               if (Client.localInteractingIndex == index && (player.x < 1536 || player.y < 1536 || player.x >= 11776 || player.y >= 11776)) {
                  player.setFirstStep(stepX, stepY);
                  player.needsPositionUpdate = false;
               } else if (update) {
                  player.needsPositionUpdate = true;
                  player.targetX = stepX;
                  player.targetY = stepY;
               } else {
                  player.needsPositionUpdate = false;
                  player.move(stepX, stepY, Class27.aByteArray3[index]);
               }

               player.currentPlane = (byte)(y + player.currentPlane & 0x3);
               if (Client.localInteractingIndex == index) {
                  Ignore.plane = player.currentPlane;
               }

            } else {
               x = buffer.getBits(30);
               y = x >> 28;
               baseX = x >> 14 & 0x3FFF;
               baseY = x & 0x3FFF;
               stepX = (baseX + Client.regionBaseX + player.pathX[0] & 0x3FFF) - Client.regionBaseX;
               stepY = (baseY + Client.regionBaseY + player.pathY[0] & 0x3FFF) - Client.regionBaseY;
               if (Client.localInteractingIndex != index || player.x >= 1536 && player.y >= 1536 && player.x < 11776 && player.y < 11776) {
                  if (update) {
                     player.needsPositionUpdate = true;
                     player.targetX = stepX;
                     player.targetY = stepY;
                  } else {
                     player.needsPositionUpdate = false;
                     player.move(stepX, stepY, Class27.aByteArray3[index]);
                  }
               } else {
                  player.setFirstStep(stepX, stepY);
                  player.needsPositionUpdate = false;
               }

               player.currentPlane = (byte)(y + player.currentPlane & 0x3);
               if (Client.localInteractingIndex == index) {
                  Ignore.plane = player.currentPlane;
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
