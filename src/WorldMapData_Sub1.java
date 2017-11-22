import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WorldMapData_Sub1 extends WorldMapData {

   static ContextMenuRow topContextMenuRow;
   public static String[] cacheLocations;
   static int anInt303;
   List aList4;
   HashSet aHashSet7;
   HashSet aHashSet8;

   void method600(Buffer buffer_0, boolean bool_0) {
      this.aList4 = new LinkedList();
      int int_0 = buffer_0.readUnsignedShort();

      for (int int_1 = 0; int_1 < int_0; int_1++) {
         int int_2 = buffer_0.method703();
         Coordinates coordinates_0 = new Coordinates(buffer_0.readInt());
         boolean bool_1 = buffer_0.readUnsignedByte() == 1;
         if (bool_0 || !bool_1) {
            this.aList4.add(new Class41(int_2, coordinates_0));
         }
      }

   }

   void method601(Buffer buffer_0, Buffer buffer_1, Buffer buffer_2, int int_0, boolean bool_0) {
      this.loadMapData(buffer_0, int_0);
      int int_1 = buffer_2.readUnsignedShort();
      this.aHashSet7 = new HashSet(int_1);

      int int_2;
      for (int_2 = 0; int_2 < int_1; int_2++) {
         AClass1_Sub2 aclass1_sub2_0 = new AClass1_Sub2();

         try {
            aclass1_sub2_0.method635(buffer_1, buffer_2);
         } catch (IllegalStateException illegalstateexception_0) {
            continue;
         }

         this.aHashSet7.add(aclass1_sub2_0);
      }

      int_2 = buffer_2.readUnsignedShort();
      this.aHashSet8 = new HashSet(int_2);

      for (int int_3 = 0; int_3 < int_2; int_3++) {
         AClass1_Sub1 aclass1_sub1_0 = new AClass1_Sub1();

         try {
            aclass1_sub1_0.method620(buffer_1, buffer_2);
         } catch (IllegalStateException illegalstateexception_1) {
            continue;
         }

         this.aHashSet8.add(aclass1_sub1_0);
      }

      this.method600(buffer_1, bool_0);
   }

   public static boolean method602() {
      return Client.rights >= 2;
   }

   static boolean method603(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6) {
      int int_7 = Class54.anInt139 + int_6;
      if (int_7 < int_0 && int_7 < int_1 && int_7 < int_2) {
         return false;
      } else {
         int_7 = Class54.anInt139 - int_6;
         if (int_7 > int_0 && int_7 > int_1 && int_7 > int_2) {
            return false;
         } else {
            int_7 = Class54.anInt138 + int_6;
            if (int_7 < int_3 && int_7 < int_4 && int_7 < int_5) {
               return false;
            } else {
               int_7 = Class54.anInt138 - int_6;
               return int_7 <= int_3 || int_7 <= int_4 || int_7 <= int_5;
            }
         }
      }
   }

   public static void method604() {
      try {
         File file_0 = new File(Class51.userHome, "random.dat");
         int int_0;
         if (file_0.exists()) {
            Class64.aCacheFile1 = new CacheFile(new FileOnDisk(file_0, "rw", 25L), 24, 0);
         } else {
            label37:
            for (int int_1 = 0; int_1 < Class64.aStringArray2.length; int_1++) {
               for (int_0 = 0; int_0 < cacheLocations.length; int_0++) {
                  File file_1 = new File(cacheLocations[int_0] + Class64.aStringArray2[int_1] + File.separatorChar + "random.dat");
                  if (file_1.exists()) {
                     Class64.aCacheFile1 = new CacheFile(new FileOnDisk(file_1, "rw", 25L), 24, 0);
                     break label37;
                  }
               }
            }
         }

         if (Class64.aCacheFile1 == null) {
            RandomAccessFile randomaccessfile_0 = new RandomAccessFile(file_0, "rw");
            int_0 = randomaccessfile_0.read();
            randomaccessfile_0.seek(0L);
            randomaccessfile_0.write(int_0);
            randomaccessfile_0.seek(0L);
            randomaccessfile_0.close();
            Class64.aCacheFile1 = new CacheFile(new FileOnDisk(file_0, "rw", 25L), 24, 0);
         }
      } catch (IOException ioexception_0) {
         ;
      }

   }

   static void method605(Widget widget_0, int int_0, int int_1) {
      CacheableNode_Sub1 cacheablenode_sub1_0 = widget_0.method591(false);
      if (cacheablenode_sub1_0 != null) {
         if (Client.anInt650 < 3) {
            Class35.compass.method991(int_0, int_1, cacheablenode_sub1_0.anInt467, cacheablenode_sub1_0.anInt468, 25, 25, Client.mapAngle, 256, cacheablenode_sub1_0.anIntArray86, cacheablenode_sub1_0.anIntArray87);
         } else {
            Rasterizer2D.method926(int_0, int_1, 0, cacheablenode_sub1_0.anIntArray86, cacheablenode_sub1_0.anIntArray87);
         }

      }
   }

   static void method606(boolean bool_0) {
      for (int int_0 = 0; int_0 < Client.npcIndexesCount; int_0++) {
         NPC npc_0 = Client.cachedNPCs[Client.npcIndices[int_0]];
         int int_1 = (Client.npcIndices[int_0] << 14) + 536870912;
         if (npc_0 != null && npc_0.hasConfig() && npc_0.composition.isVisible == bool_0 && npc_0.composition.method900()) {
            int int_2 = npc_0.x >> 7;
            int int_3 = npc_0.y >> 7;
            if (int_2 >= 0 && int_2 < 104 && int_3 >= 0 && int_3 < 104) {
               if (npc_0.anInt513 == 1 && (npc_0.x & 0x7F) == 64 && (npc_0.y & 0x7F) == 64) {
                  if (Client.anIntArrayArray21[int_2][int_3] == Client.anInt664) {
                     continue;
                  }

                  Client.anIntArrayArray21[int_2][int_3] = Client.anInt664;
               }

               if (!npc_0.composition.aBool66) {
                  int_1 -= Integer.MIN_VALUE;
               }

               Class23.region.method377(Ignore.plane, npc_0.x, npc_0.y, Class18.getTileHeight(npc_0.anInt513 * 64 - 64 + npc_0.x, npc_0.anInt513 * 64 - 64 + npc_0.y, Ignore.plane), npc_0.anInt513 * 64 - 64 + 60, npc_0, npc_0.angle, int_1, npc_0.aBool69);
            }
         }
      }

   }

   static void parsePlayerSynchronizationMask(PacketBuffer buffer, int index, Player player, int mask) {
      byte byte_0 = -1;
      int info;
      if ((mask & 0x200) != 0) {
         player.graphic = buffer.method713();
         info = buffer.method706();
         player.graphicHeight = info >> 16;
         player.graphicDelay = (info & 0xFFFF) + Client.gameCycle;
         player.currentAnimation = 0;
         player.anInt530 = 0;
         if (player.graphicDelay > Client.gameCycle) {
            player.currentAnimation = -1;
         }

         if (player.graphic == 65535) {
            player.graphic = -1;
         }
      }

      if ((mask & 0x800) != 0) {
         Class27.aByteArray3[index] = buffer.method728();
      }

      if ((mask & 0x8) != 0) {
         player.overhead = buffer.readString();
         if (player.overhead.charAt(0) == 126) {
            player.overhead = player.overhead.substring(1);
            Class34.sendGameMessage(2, player.name, player.overhead);
         } else if (player == Class4.localPlayer) {
            Class34.sendGameMessage(2, player.name, player.overhead);
         }

         player.aBool71 = false;
         player.textColour = 0;
         player.textEffect = 0;
         player.textCycle = 150;
      }

      int int_4;
      int int_5;
      int type;
      if ((mask & 0x40) != 0) {
         info = buffer.readNegUByte();
         int int_6;
         int int_7;
         int int_8;
         if (info > 0) {
            for (int i = 0; i < info; i++) {
               int_4 = -1;
               int_5 = -1;
               int_6 = -1;
               int_7 = buffer.getUSmart();
               if (int_7 == 32767) {
                  int_7 = buffer.getUSmart();
                  int_5 = buffer.getUSmart();
                  int_4 = buffer.getUSmart();
                  int_6 = buffer.getUSmart();
               } else if (int_7 != 32766) {
                  int_5 = buffer.getUSmart();
               } else {
                  int_7 = -1;
               }

               int_8 = buffer.getUSmart();
               player.method949(int_7, int_5, int_4, int_6, Client.gameCycle, int_8);
            }
         }

         int length = buffer.method710();
         if (length > 0) {
            for (int_7 = 0; int_7 < length; int_7++) {
               int_4 = buffer.getUSmart();
               int_5 = buffer.getUSmart();
               if (int_5 != 32767) {
                  int_6 = buffer.getUSmart();
                  int_8 = buffer.method709();
                  type = int_5 > 0 ? buffer.method709() : int_8;
                  player.method952(int_4, Client.gameCycle, int_5, int_6, int_8, type);
               } else {
                  player.method951(int_4);
               }
            }
         }
      }

      if ((mask & 0x100) != 0) {
         byte_0 = buffer.readByte();
      }

      if ((mask & 0x4) != 0) {
         int textInfo = buffer.readUnsignedShort();
         Permission permission = (Permission) Class1.forOrdinal(Class44.method272(), buffer.readNegUByte());
         boolean bool_1 = buffer.method709() == 1;//Resizable?
         int length = buffer.readUnsignedByte();
         int offset = buffer.offset;
         if (player.name != null && player.composition != null) {
            boolean ignored = false;
            if (permission.aBool46 && Tile.isIgnored(player.name)) {
               ignored = true;
            }

            if (!ignored && Client.onTutorialIsland == 0 && !player.hidden) {
               Class27.chatBuffer.offset = 0;
               buffer.readReverseData(Class27.chatBuffer.payload, 0, length);
               Class27.chatBuffer.offset = 0;
               String text = FontTypeFace.appendTags(ObjectComposition.method830(IndexFile.method73(Class27.chatBuffer)));
               player.overhead = text.trim();
               player.textColour = textInfo >> 8;
               player.textEffect = textInfo & 0xFF;
               player.textCycle = 150;
               player.aBool71 = bool_1;
               player.inSequence = player != Class4.localPlayer && permission.aBool46 && "" != Client.aString37 && text.toLowerCase().indexOf(Client.aString37) == -1;
               if (permission.aBool45) {
                  type = bool_1 ? 91 : 1;
               } else {
                  type = bool_1 ? 90 : 2;
               }

               if (permission.iconSpriteId != -1) {
                  int spriteId = permission.iconSpriteId;
                  String icon = "<img=" + spriteId + ">";
                  Class34.sendGameMessage(type, icon + player.name, text);
               } else {
                  Class34.sendGameMessage(type, player.name, text);
               }
            }
         }

         buffer.offset = offset + length;
      }

      if ((mask & 0x80) != 0) {
         player.interacting = buffer.method713();
         if (player.interacting == 65535) {
            player.interacting = -1;
         }
      }

      if ((mask & 0x10) != 0) {
         int length = buffer.readNegUByte();
         byte[] data = new byte[length];
         Buffer appearanceBuffer = new Buffer(data);
         buffer.readData(data, 0, length);
         Class27.playerSynchronizationBuffers[index] = appearanceBuffer;
         player.decodeAppearance(appearanceBuffer);
      }

      if ((mask & 0x1000) != 0) {
         for (info = 0; info < 3; info++) {
            player.actions[info] = buffer.readString();
         }
      }

      if ((mask & 0x20) != 0) {
         int animationId = buffer.readUnsignedShortOb1();
         if (animationId == 65535)
            animationId = -1;

         int neg = buffer.readNegUByte();
         Class9.animate(player, animationId, neg);
      }

      if ((mask & 0x400) != 0) {
         player.anInt536 = buffer.method728();
         player.anInt537 = buffer.method728();
         player.anInt538 = buffer.method728();
         player.anInt539 = buffer.method728();
         player.anInt534 = buffer.readUnsignedShortOb1() + Client.gameCycle;
         player.anInt535 = buffer.method713() + Client.gameCycle;
         player.anInt540 = buffer.readUnsignedShortOb1();
         if (player.needsPositionUpdate) {
            player.anInt536 += player.targetX;
            player.anInt537 += player.targetY;
            player.anInt538 += player.targetX;
            player.anInt539 += player.targetY;
            player.queueSize = 0;
         } else {
            player.anInt536 += player.pathX[0];
            player.anInt537 += player.pathY[0];
            player.anInt538 += player.pathX[0];
            player.anInt539 += player.pathY[0];
            player.queueSize = 1;
         }

         player.anInt511 = 0;
      }

      if ((mask & 0x2) != 0) {
         player.nextStepOrientation = buffer.readUnsignedShortOb1();
         if (player.queueSize == 0) {
            player.orientation = player.nextStepOrientation;
            player.nextStepOrientation = -1;
         }
      }

      if (player.needsPositionUpdate) {
         if (byte_0 == 127) {
            player.setFirstStep(player.targetX, player.targetY);
         } else {
            byte byte_1;
            if (byte_0 != -1) {
               byte_1 = byte_0;
            } else {
               byte_1 = Class27.aByteArray3[index];
            }

            player.move(player.targetX, player.targetY, byte_1);
         }
      }

   }

   static void method608() {
      Class19.aByteArrayArrayArray5 = null;
      Class106.aByteArrayArrayArray9 = null;
      Class19.aByteArrayArrayArray6 = null;
      Class7.aByteArrayArrayArray2 = null;
      ItemLayer.anIntArrayArrayArray1 = null;
      Class19.aByteArrayArrayArray7 = null;
      Class79.anIntArrayArray12 = null;
      Class19.anIntArray8 = null;
      RSCanvas.anIntArray82 = null;
      Preferences.anIntArray39 = null;
      FloorUnderlayDefinition.anIntArray105 = null;
      Class19.anIntArray11 = null;
   }

   static int method609(int int_0, int int_1, int int_2) {
      if (int_2 > 179) {
         int_1 /= 2;
      }

      if (int_2 > 192) {
         int_1 /= 2;
      }

      if (int_2 > 217) {
         int_1 /= 2;
      }

      if (int_2 > 243) {
         int_1 /= 2;
      }

      int int_3 = (int_1 / 32 << 7) + (int_0 / 4 << 10) + int_2 / 2;
      return int_3;
   }

}
