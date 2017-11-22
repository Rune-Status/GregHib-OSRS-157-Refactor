import java.io.IOException;

public class Class40 {

   static Varcs chatMessages;
   static final Class40 aClass40_1;
   static final Class40 aClass40_2;
   static final Class40 aClass40_3;
   static final Class40 aClass40_4;
   static final Class40 aClass40_5;
   static final Class40 aClass40_6;
   static final Class40 aClass40_7;
   final int anInt98;

   static {
      aClass40_1 = new Class40(4);
      aClass40_2 = new Class40(0);
      aClass40_3 = new Class40(6);
      aClass40_4 = new Class40(1);
      aClass40_5 = new Class40(3);
      aClass40_6 = new Class40(5);
      aClass40_7 = new Class40(2);
   }

   Class40(int int_0) {
      this.anInt98 = int_0;
   }

   public static boolean method258() {
      long long_0 = Class97.currentTimeMs();
      int int_0 = (int)(long_0 - Class95.aLong11);
      Class95.aLong11 = long_0;
      if (int_0 > 200) {
         int_0 = 200;
      }

      Class95.anInt195 += int_0;
      if (Class95.anInt200 == 0 && Class95.anInt198 == 0 && Class95.anInt199 == 0 && Class95.anInt197 == 0) {
         return true;
      } else if (Class95.aRSSocket1 == null) {
         return false;
      } else {
         try {
            if (Class95.anInt195 > 30000) {
               throw new IOException();
            } else {
               FileRequest filerequest_0;
               Buffer buffer_0;
               while (Class95.anInt198 < 20 && Class95.anInt197 > 0) {
                  filerequest_0 = (FileRequest) Class95.aHashTable4.method67();
                  buffer_0 = new Buffer(4);
                  buffer_0.putByte(1);
                  buffer_0.put24bitInt((int)filerequest_0.hash);
                  Class95.aRSSocket1.queueForWrite(buffer_0.payload, 0, 4);
                  Class95.aHashTable5.put(filerequest_0, filerequest_0.hash);
                  --Class95.anInt197;
                  ++Class95.anInt198;
               }

               while (Class95.anInt200 < 20 && Class95.anInt199 > 0) {
                  filerequest_0 = (FileRequest) Class95.aNode2LinkedList1.peek();
                  buffer_0 = new Buffer(4);
                  buffer_0.putByte(0);
                  buffer_0.put24bitInt((int)filerequest_0.hash);
                  Class95.aRSSocket1.queueForWrite(buffer_0.payload, 0, 4);
                  filerequest_0.unlinkDual();
                  Class95.aHashTable6.put(filerequest_0, filerequest_0.hash);
                  --Class95.anInt199;
                  ++Class95.anInt200;
               }

               for (int int_1 = 0; int_1 < 100; int_1++) {
                  int int_2 = Class95.aRSSocket1.available();
                  if (int_2 < 0) {
                     throw new IOException();
                  }

                  if (int_2 == 0) {
                     break;
                  }

                  Class95.anInt195 = 0;
                  byte byte_0 = 0;
                  if (Class56.currentRequest == null) {
                     byte_0 = 8;
                  } else if (Class95.anInt201 == 0) {
                     byte_0 = 1;
                  }

                  int int_3;
                  int int_4;
                  int int_5;
                  int int_7;
                  if (byte_0 > 0) {
                     int_3 = byte_0 - Class95.aBuffer6.offset;
                     if (int_3 > int_2) {
                        int_3 = int_2;
                     }

                     Class95.aRSSocket1.read(Class95.aBuffer6.payload, Class95.aBuffer6.offset, int_3);
                     if (Class95.aByte2 != 0) {
                        for (int_4 = 0; int_4 < int_3; int_4++) {
                           Class95.aBuffer6.payload[Class95.aBuffer6.offset + int_4] ^= Class95.aByte2;
                        }
                     }

                     Class95.aBuffer6.offset += int_3;
                     if (Class95.aBuffer6.offset < byte_0) {
                        break;
                     }

                     if (Class56.currentRequest == null) {
                        Class95.aBuffer6.offset = 0;
                        int_4 = Class95.aBuffer6.readUnsignedByte();
                        int_5 = Class95.aBuffer6.readUnsignedShort();
                        int int_6 = Class95.aBuffer6.readUnsignedByte();
                        int_7 = Class95.aBuffer6.readInt();
                        long long_1 = (long)(int_5 + (int_4 << 16));
                        FileRequest filerequest_1 = (FileRequest) Class95.aHashTable5.get(long_1);
                        Class13.aBool4 = true;
                        if (filerequest_1 == null) {
                           filerequest_1 = (FileRequest) Class95.aHashTable6.get(long_1);
                           Class13.aBool4 = false;
                        }

                        if (filerequest_1 == null) {
                           throw new IOException();
                        }

                        int int_9 = int_6 == 0 ? 5 : 9;
                        Class56.currentRequest = filerequest_1;
                        DecorativeObject.aBuffer4 = new Buffer(int_7 + int_9 + Class56.currentRequest.padding);
                        DecorativeObject.aBuffer4.putByte(int_6);
                        DecorativeObject.aBuffer4.putInt(int_7);
                        Class95.anInt201 = 8;
                        Class95.aBuffer6.offset = 0;
                     } else if (Class95.anInt201 == 0) {
                        if (Class95.aBuffer6.payload[0] == -1) {
                           Class95.anInt201 = 1;
                           Class95.aBuffer6.offset = 0;
                        } else {
                           Class56.currentRequest = null;
                        }
                     }
                  } else {
                     int_3 = DecorativeObject.aBuffer4.payload.length - Class56.currentRequest.padding;
                     int_4 = 512 - Class95.anInt201;
                     if (int_4 > int_3 - DecorativeObject.aBuffer4.offset) {
                        int_4 = int_3 - DecorativeObject.aBuffer4.offset;
                     }

                     if (int_4 > int_2) {
                        int_4 = int_2;
                     }

                     Class95.aRSSocket1.read(DecorativeObject.aBuffer4.payload, DecorativeObject.aBuffer4.offset, int_4);
                     if (Class95.aByte2 != 0) {
                        for (int_5 = 0; int_5 < int_4; int_5++) {
                           DecorativeObject.aBuffer4.payload[DecorativeObject.aBuffer4.offset + int_5] ^= Class95.aByte2;
                        }
                     }

                     DecorativeObject.aBuffer4.offset += int_4;
                     Class95.anInt201 += int_4;
                     if (int_3 == DecorativeObject.aBuffer4.offset) {
                        if (Class56.currentRequest.hash == 16711935L) {
                           Class23.aBuffer1 = DecorativeObject.aBuffer4;

                           for (int_5 = 0; int_5 < 256; int_5++) {
                              IndexData indexdata_0 = Class95.anIndexDataArray1[int_5];
                              if (indexdata_0 != null) {
                                 Class23.aBuffer1.offset = int_5 * 8 + 5;
                                 int_7 = Class23.aBuffer1.readInt();
                                 int int_8 = Class23.aBuffer1.readInt();
                                 indexdata_0.setInformation(int_7, int_8);
                              }
                           }
                        } else {
                           Class95.aCRC32_1.reset();
                           Class95.aCRC32_1.update(DecorativeObject.aBuffer4.payload, 0, int_3);
                           int_5 = (int)Class95.aCRC32_1.getValue();
                           if (int_5 != Class56.currentRequest.crc) {
                              try {
                                 Class95.aRSSocket1.close();
                              } catch (Exception exception_1) {
                                 ;
                              }

                              ++Class95.anInt194;
                              Class95.aRSSocket1 = null;
                              Class95.aByte2 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           Class95.anInt194 = 0;
                           Class95.anInt196 = 0;
                           Class56.currentRequest.index.method616((int)(Class56.currentRequest.hash & 0xFFFFL), DecorativeObject.aBuffer4.payload, (Class56.currentRequest.hash & 0xFF0000L) == 16711680L, Class13.aBool4);
                        }

                        Class56.currentRequest.unlink();
                        if (Class13.aBool4) {
                           --Class95.anInt198;
                        } else {
                           --Class95.anInt200;
                        }

                        Class95.anInt201 = 0;
                        Class56.currentRequest = null;
                        DecorativeObject.aBuffer4 = null;
                     } else {
                        if (Class95.anInt201 != 512) {
                           break;
                        }

                        Class95.anInt201 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException ioexception_0) {
            try {
               Class95.aRSSocket1.close();
            } catch (Exception exception_0) {
               ;
            }

            ++Class95.anInt196;
            Class95.aRSSocket1 = null;
            return false;
         }
      }
   }

   static void method259(int int_0, int int_1, boolean bool_0) {
      if (!bool_0 || int_0 != Class87.anInt189 || Class25.anInt86 != int_1) {
         Class87.anInt189 = int_0;
         Class25.anInt86 = int_1;
         Class110.setGameState(25);
         Class68_Sub1.drawStatusBox("Loading - please wait.", true);
         int int_2 = ItemLayer.baseX;
         int int_3 = ItemLayer.baseY;
         ItemLayer.baseX = (int_0 - 6) * 8;
         ItemLayer.baseY = (int_1 - 6) * 8;
         int int_4 = ItemLayer.baseX - int_2;
         int int_5 = ItemLayer.baseY - int_3;
         int_2 = ItemLayer.baseX;
         int_3 = ItemLayer.baseY;

         int int_6;
         int int_7;
         for (int_6 = 0; int_6 < 32768; int_6++) {
            NPC npc_0 = Client.cachedNPCs[int_6];
            if (npc_0 != null) {
               for (int_7 = 0; int_7 < 10; int_7++) {
                  npc_0.pathX[int_7] -= int_4;
                  npc_0.pathY[int_7] -= int_5;
               }

               npc_0.x -= int_4 * 128;
               npc_0.y -= int_5 * 128;
            }
         }

         for (int_6 = 0; int_6 < 2048; int_6++) {
            Player player_0 = Client.cachedPlayers[int_6];
            if (player_0 != null) {
               for (int_7 = 0; int_7 < 10; int_7++) {
                  player_0.pathX[int_7] -= int_4;
                  player_0.pathY[int_7] -= int_5;
               }

               player_0.x -= int_4 * 128;
               player_0.y -= int_5 * 128;
            }
         }

         byte byte_4 = 0;
         byte byte_0 = 104;
         byte byte_5 = 1;
         if (int_4 < 0) {
            byte_4 = 103;
            byte_0 = -1;
            byte_5 = -1;
         }

         byte byte_1 = 0;
         byte byte_2 = 104;
         byte byte_3 = 1;
         if (int_5 < 0) {
            byte_1 = 103;
            byte_2 = -1;
            byte_3 = -1;
         }

         int int_9;
         for (int int_8 = byte_4; int_8 != byte_0; int_8 += byte_5) {
            for (int_9 = byte_1; byte_2 != int_9; int_9 += byte_3) {
               int int_10 = int_4 + int_8;
               int int_11 = int_9 + int_5;

               for (int int_12 = 0; int_12 < 4; int_12++) {
                  if (int_10 >= 0 && int_11 >= 0 && int_10 < 104 && int_11 < 104) {
                     Client.groundItemDeque[int_12][int_8][int_9] = Client.groundItemDeque[int_12][int_10][int_11];
                  } else {
                     Client.groundItemDeque[int_12][int_8][int_9] = null;
                  }
               }
            }
         }

         for (PendingSpawn pendingspawn_0 = (PendingSpawn) Client.pendingSpawns.getFront(); pendingspawn_0 != null; pendingspawn_0 = (PendingSpawn) Client.pendingSpawns.getNext()) {
            pendingspawn_0.x -= int_4;
            pendingspawn_0.y -= int_5;
            if (pendingspawn_0.x < 0 || pendingspawn_0.y < 0 || pendingspawn_0.x >= 104 || pendingspawn_0.y >= 104) {
               pendingspawn_0.unlink();
            }
         }

         if (Client.destinationX != 0) {
            Client.destinationX -= int_4;
            Client.destinationY -= int_5;
         }

         Client.anInt647 = 0;
         Client.aBool94 = false;
         Client.anInt652 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for (int_9 = 0; int_9 < 4; int_9++) {
            Client.collisionMaps[int_9].reset();
         }

      }
   }

   static int method260(int int_0, int int_1) {
      int int_2 = int_1 * 57 + int_0;
      int_2 ^= int_2 << 13;
      int int_3 = (int_2 * int_2 * 15731 + 789221) * int_2 + 1376312589 & 0x7FFFFFFF;
      return int_3 >> 19 & 0xFF;
   }

}
