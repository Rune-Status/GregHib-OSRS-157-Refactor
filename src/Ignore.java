public class Ignore {

   static int plane;
   static SpritePixels[] mapMarkers;
   String name;
   String previousName;

   static void menuAction(int int_0, int int_1, int int_2, int int_3, String string_0, String string_1, int int_4, int int_5) {
      if (int_2 >= 2000) {
         int_2 -= 2000;
      }

      PacketNode packetnode_0;
      if (int_2 == 1) {
         Client.anInt641 = int_4;
         Client.anInt642 = int_5;
         Client.cursorState = 2;
         Client.anInt645 = 0;
         Client.destinationX = int_0;
         Client.destinationY = int_1;
         packetnode_0 = Actor.method953(ClientPacket.aClientPacket57, Client.aClass46_1.cipher);
         packetnode_0.packetBuffer.putShortS(int_3 >> 14 & 0x7FFF);
         packetnode_0.packetBuffer.putShort(GameEngine.selectedItemIndex);
         packetnode_0.packetBuffer.putShortS(ItemLayer.baseY + int_1);
         packetnode_0.packetBuffer.putInt(Class48.anInt111);
         packetnode_0.packetBuffer.putByteS(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
         packetnode_0.packetBuffer.method719(int_0 + ItemLayer.baseX);
         packetnode_0.packetBuffer.method719(KeyFocusListener.anInt128);
         Client.aClass46_1.method282(packetnode_0);
      } else if (int_2 == 2) {
         Client.anInt641 = int_4;
         Client.anInt642 = int_5;
         Client.cursorState = 2;
         Client.anInt645 = 0;
         Client.destinationX = int_0;
         Client.destinationY = int_1;
         packetnode_0 = Actor.method953(ClientPacket.aClientPacket51, Client.aClass46_1.cipher);
         packetnode_0.packetBuffer.putShort(int_0 + ItemLayer.baseX);
         packetnode_0.packetBuffer.putShortLEA(ItemLayer.baseY + int_1);
         packetnode_0.packetBuffer.putByte(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
         packetnode_0.packetBuffer.putShortLEA(int_3 >> 14 & 0x7FFF);
         packetnode_0.packetBuffer.putInt(Class26.anInt87);
         packetnode_0.packetBuffer.putShortLEA(Client.anInt656);
         Client.aClass46_1.method282(packetnode_0);
      } else if (int_2 == 3) {
         Client.anInt641 = int_4;
         Client.anInt642 = int_5;
         Client.cursorState = 2;
         Client.anInt645 = 0;
         Client.destinationX = int_0;
         Client.destinationY = int_1;
         packetnode_0 = Actor.method953(ClientPacket.aClientPacket60, Client.aClass46_1.cipher);
         packetnode_0.packetBuffer.putShortLEA(int_0 + ItemLayer.baseX);
         packetnode_0.packetBuffer.putShort(int_3 >> 14 & 0x7FFF);
         packetnode_0.packetBuffer.putShortLEA(ItemLayer.baseY + int_1);
         packetnode_0.packetBuffer.putByteInverse(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
         Client.aClass46_1.method282(packetnode_0);
      } else if (int_2 == 4) {
         Client.anInt641 = int_4;
         Client.anInt642 = int_5;
         Client.cursorState = 2;
         Client.anInt645 = 0;
         Client.destinationX = int_0;
         Client.destinationY = int_1;
         packetnode_0 = Actor.method953(ClientPacket.aClientPacket24, Client.aClass46_1.cipher);
         packetnode_0.packetBuffer.method719(int_0 + ItemLayer.baseX);
         packetnode_0.packetBuffer.method719(ItemLayer.baseY + int_1);
         packetnode_0.packetBuffer.putByte(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
         packetnode_0.packetBuffer.putShort(int_3 >> 14 & 0x7FFF);
         Client.aClass46_1.method282(packetnode_0);
      } else if (int_2 == 5) {
         Client.anInt641 = int_4;
         Client.anInt642 = int_5;
         Client.cursorState = 2;
         Client.anInt645 = 0;
         Client.destinationX = int_0;
         Client.destinationY = int_1;
         packetnode_0 = Actor.method953(ClientPacket.aClientPacket48, Client.aClass46_1.cipher);
         packetnode_0.packetBuffer.putShortLEA(int_3 >> 14 & 0x7FFF);
         packetnode_0.packetBuffer.putByteA(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
         packetnode_0.packetBuffer.putShortS(ItemLayer.baseY + int_1);
         packetnode_0.packetBuffer.putShortLEA(int_0 + ItemLayer.baseX);
         Client.aClass46_1.method282(packetnode_0);
      } else if (int_2 == 6) {
         Client.anInt641 = int_4;
         Client.anInt642 = int_5;
         Client.cursorState = 2;
         Client.anInt645 = 0;
         Client.destinationX = int_0;
         Client.destinationY = int_1;
         packetnode_0 = Actor.method953(ClientPacket.aClientPacket66, Client.aClass46_1.cipher);
         packetnode_0.packetBuffer.putShortLEA(ItemLayer.baseY + int_1);
         packetnode_0.packetBuffer.putShortLEA(int_3 >> 14 & 0x7FFF);
         packetnode_0.packetBuffer.method719(int_0 + ItemLayer.baseX);
         packetnode_0.packetBuffer.putByteInverse(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
         Client.aClass46_1.method282(packetnode_0);
      } else {
         PacketNode packetnode_1;
         NPC npc_0;
         if (int_2 == 7) {
            npc_0 = Client.cachedNPCs[int_3];
            if (npc_0 != null) {
               Client.anInt641 = int_4;
               Client.anInt642 = int_5;
               Client.cursorState = 2;
               Client.anInt645 = 0;
               Client.destinationX = int_0;
               Client.destinationY = int_1;
               packetnode_1 = Actor.method953(ClientPacket.aClientPacket68, Client.aClass46_1.cipher);
               packetnode_1.packetBuffer.putShort(GameEngine.selectedItemIndex);
               packetnode_1.packetBuffer.putShortS(KeyFocusListener.anInt128);
               packetnode_1.packetBuffer.putByteInverse(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
               packetnode_1.packetBuffer.putInt(Class48.anInt111);
               packetnode_1.packetBuffer.putShortS(int_3);
               Client.aClass46_1.method282(packetnode_1);
            }
         } else if (int_2 == 8) {
            npc_0 = Client.cachedNPCs[int_3];
            if (npc_0 != null) {
               Client.anInt641 = int_4;
               Client.anInt642 = int_5;
               Client.cursorState = 2;
               Client.anInt645 = 0;
               Client.destinationX = int_0;
               Client.destinationY = int_1;
               packetnode_1 = Actor.method953(ClientPacket.aClientPacket64, Client.aClass46_1.cipher);
               packetnode_1.packetBuffer.putShortS(int_3);
               packetnode_1.packetBuffer.method718(Class26.anInt87);
               packetnode_1.packetBuffer.putShortS(Client.anInt656);
               packetnode_1.packetBuffer.putByteA(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
               Client.aClass46_1.method282(packetnode_1);
            }
         } else if (int_2 == 9) {
            npc_0 = Client.cachedNPCs[int_3];
            if (npc_0 != null) {
               Client.anInt641 = int_4;
               Client.anInt642 = int_5;
               Client.cursorState = 2;
               Client.anInt645 = 0;
               Client.destinationX = int_0;
               Client.destinationY = int_1;
               packetnode_1 = Actor.method953(ClientPacket.aClientPacket54, Client.aClass46_1.cipher);
               packetnode_1.packetBuffer.putByteInverse(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
               packetnode_1.packetBuffer.putShortS(int_3);
               Client.aClass46_1.method282(packetnode_1);
            }
         } else if (int_2 == 10) {
            npc_0 = Client.cachedNPCs[int_3];
            if (npc_0 != null) {
               Client.anInt641 = int_4;
               Client.anInt642 = int_5;
               Client.cursorState = 2;
               Client.anInt645 = 0;
               Client.destinationX = int_0;
               Client.destinationY = int_1;
               packetnode_1 = Actor.method953(ClientPacket.aClientPacket42, Client.aClass46_1.cipher);
               packetnode_1.packetBuffer.putShortS(int_3);
               packetnode_1.packetBuffer.putByteS(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
               Client.aClass46_1.method282(packetnode_1);
            }
         } else if (int_2 == 11) {
            npc_0 = Client.cachedNPCs[int_3];
            if (npc_0 != null) {
               Client.anInt641 = int_4;
               Client.anInt642 = int_5;
               Client.cursorState = 2;
               Client.anInt645 = 0;
               Client.destinationX = int_0;
               Client.destinationY = int_1;
               packetnode_1 = Actor.method953(ClientPacket.aClientPacket56, Client.aClass46_1.cipher);
               packetnode_1.packetBuffer.putShortLEA(int_3);
               packetnode_1.packetBuffer.putByteA(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
               Client.aClass46_1.method282(packetnode_1);
            }
         } else if (int_2 == 12) {
            npc_0 = Client.cachedNPCs[int_3];
            if (npc_0 != null) {
               Client.anInt641 = int_4;
               Client.anInt642 = int_5;
               Client.cursorState = 2;
               Client.anInt645 = 0;
               Client.destinationX = int_0;
               Client.destinationY = int_1;
               packetnode_1 = Actor.method953(ClientPacket.aClientPacket59, Client.aClass46_1.cipher);
               packetnode_1.packetBuffer.putByteInverse(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
               packetnode_1.packetBuffer.putShort(int_3);
               Client.aClass46_1.method282(packetnode_1);
            }
         } else if (int_2 == 13) {
            npc_0 = Client.cachedNPCs[int_3];
            if (npc_0 != null) {
               Client.anInt641 = int_4;
               Client.anInt642 = int_5;
               Client.cursorState = 2;
               Client.anInt645 = 0;
               Client.destinationX = int_0;
               Client.destinationY = int_1;
               packetnode_1 = Actor.method953(ClientPacket.aClientPacket62, Client.aClass46_1.cipher);
               packetnode_1.packetBuffer.putByte(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
               packetnode_1.packetBuffer.putShortS(int_3);
               Client.aClass46_1.method282(packetnode_1);
            }
         } else {
            Player player_0;
            if (int_2 == 14) {
               player_0 = Client.players[int_3];
               if (player_0 != null) {
                  Client.anInt641 = int_4;
                  Client.anInt642 = int_5;
                  Client.cursorState = 2;
                  Client.anInt645 = 0;
                  Client.destinationX = int_0;
                  Client.destinationY = int_1;
                  packetnode_1 = Actor.method953(ClientPacket.aClientPacket61, Client.aClass46_1.cipher);
                  packetnode_1.packetBuffer.method719(KeyFocusListener.anInt128);
                  packetnode_1.packetBuffer.putShortLEA(int_3);
                  packetnode_1.packetBuffer.putShortS(GameEngine.selectedItemIndex);
                  packetnode_1.packetBuffer.method718(Class48.anInt111);
                  packetnode_1.packetBuffer.putByte(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
                  Client.aClass46_1.method282(packetnode_1);
               }
            } else if (int_2 == 15) {
               player_0 = Client.players[int_3];
               if (player_0 != null) {
                  Client.anInt641 = int_4;
                  Client.anInt642 = int_5;
                  Client.cursorState = 2;
                  Client.anInt645 = 0;
                  Client.destinationX = int_0;
                  Client.destinationY = int_1;
                  packetnode_1 = Actor.method953(ClientPacket.aClientPacket67, Client.aClass46_1.cipher);
                  packetnode_1.packetBuffer.method718(Class26.anInt87);
                  packetnode_1.packetBuffer.putByteInverse(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
                  packetnode_1.packetBuffer.putShort(int_3);
                  packetnode_1.packetBuffer.putShort(Client.anInt656);
                  Client.aClass46_1.method282(packetnode_1);
               }
            } else if (int_2 == 16) {
               Client.anInt641 = int_4;
               Client.anInt642 = int_5;
               Client.cursorState = 2;
               Client.anInt645 = 0;
               Client.destinationX = int_0;
               Client.destinationY = int_1;
               packetnode_0 = Actor.method953(ClientPacket.aClientPacket23, Client.aClass46_1.cipher);
               packetnode_0.packetBuffer.putByteA(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
               packetnode_0.packetBuffer.method718(Class48.anInt111);
               packetnode_0.packetBuffer.putShortS(int_0 + ItemLayer.baseX);
               packetnode_0.packetBuffer.putShortS(int_3);
               packetnode_0.packetBuffer.method719(ItemLayer.baseY + int_1);
               packetnode_0.packetBuffer.putShortS(GameEngine.selectedItemIndex);
               packetnode_0.packetBuffer.method719(KeyFocusListener.anInt128);
               Client.aClass46_1.method282(packetnode_0);
            } else if (int_2 == 17) {
               Client.anInt641 = int_4;
               Client.anInt642 = int_5;
               Client.cursorState = 2;
               Client.anInt645 = 0;
               Client.destinationX = int_0;
               Client.destinationY = int_1;
               packetnode_0 = Actor.method953(ClientPacket.aClientPacket50, Client.aClass46_1.cipher);
               packetnode_0.packetBuffer.putShortLEA(ItemLayer.baseY + int_1);
               packetnode_0.packetBuffer.putShortS(int_0 + ItemLayer.baseX);
               packetnode_0.packetBuffer.method719(Client.anInt656);
               packetnode_0.packetBuffer.method725(Class26.anInt87);
               packetnode_0.packetBuffer.putShort(int_3);
               packetnode_0.packetBuffer.putByteInverse(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
               Client.aClass46_1.method282(packetnode_0);
            } else if (int_2 == 18) {
               Client.anInt641 = int_4;
               Client.anInt642 = int_5;
               Client.cursorState = 2;
               Client.anInt645 = 0;
               Client.destinationX = int_0;
               Client.destinationY = int_1;
               packetnode_0 = Actor.method953(ClientPacket.aClientPacket33, Client.aClass46_1.cipher);
               packetnode_0.packetBuffer.putShortS(int_0 + ItemLayer.baseX);
               packetnode_0.packetBuffer.putShortLEA(ItemLayer.baseY + int_1);
               packetnode_0.packetBuffer.putByte(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
               packetnode_0.packetBuffer.method719(int_3);
               Client.aClass46_1.method282(packetnode_0);
            } else if (int_2 == 19) {
               Client.anInt641 = int_4;
               Client.anInt642 = int_5;
               Client.cursorState = 2;
               Client.anInt645 = 0;
               Client.destinationX = int_0;
               Client.destinationY = int_1;
               packetnode_0 = Actor.method953(ClientPacket.aClientPacket35, Client.aClass46_1.cipher);
               packetnode_0.packetBuffer.putShortS(int_3);
               packetnode_0.packetBuffer.method719(int_0 + ItemLayer.baseX);
               packetnode_0.packetBuffer.putByteInverse(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
               packetnode_0.packetBuffer.method719(ItemLayer.baseY + int_1);
               Client.aClass46_1.method282(packetnode_0);
            } else if (int_2 == 20) {
               Client.anInt641 = int_4;
               Client.anInt642 = int_5;
               Client.cursorState = 2;
               Client.anInt645 = 0;
               Client.destinationX = int_0;
               Client.destinationY = int_1;
               packetnode_0 = Actor.method953(ClientPacket.aClientPacket38, Client.aClass46_1.cipher);
               packetnode_0.packetBuffer.putShortLEA(ItemLayer.baseY + int_1);
               packetnode_0.packetBuffer.method719(int_0 + ItemLayer.baseX);
               packetnode_0.packetBuffer.method719(int_3);
               packetnode_0.packetBuffer.putByteInverse(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
               Client.aClass46_1.method282(packetnode_0);
            } else if (int_2 == 21) {
               Client.anInt641 = int_4;
               Client.anInt642 = int_5;
               Client.cursorState = 2;
               Client.anInt645 = 0;
               Client.destinationX = int_0;
               Client.destinationY = int_1;
               packetnode_0 = Actor.method953(ClientPacket.aClientPacket40, Client.aClass46_1.cipher);
               packetnode_0.packetBuffer.putByte(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
               packetnode_0.packetBuffer.putShortS(ItemLayer.baseY + int_1);
               packetnode_0.packetBuffer.putShort(int_0 + ItemLayer.baseX);
               packetnode_0.packetBuffer.method719(int_3);
               Client.aClass46_1.method282(packetnode_0);
            } else if (int_2 == 22) {
               Client.anInt641 = int_4;
               Client.anInt642 = int_5;
               Client.cursorState = 2;
               Client.anInt645 = 0;
               Client.destinationX = int_0;
               Client.destinationY = int_1;
               packetnode_0 = Actor.method953(ClientPacket.aClientPacket46, Client.aClass46_1.cipher);
               packetnode_0.packetBuffer.method719(int_3);
               packetnode_0.packetBuffer.putByteA(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
               packetnode_0.packetBuffer.putShortLEA(int_0 + ItemLayer.baseX);
               packetnode_0.packetBuffer.putShortS(ItemLayer.baseY + int_1);
               Client.aClass46_1.method282(packetnode_0);
            } else if (int_2 == 23) {
               if (Client.isMenuOpen) {
                  Class23.region.method371();
               } else {
                  Class23.region.method359(plane, int_0, int_1, true);
               }
            } else {
               PacketNode packetnode_2;
               Widget widget_2;
               if (int_2 == 24) {
                  widget_2 = PendingSpawn.method671(int_1);
                  boolean bool_0 = true;
                  if (widget_2.contentType > 0) {
                     bool_0 = method550(widget_2);
                  }

                  if (bool_0) {
                     packetnode_2 = Actor.method953(ClientPacket.aClientPacket34, Client.aClass46_1.cipher);
                     packetnode_2.packetBuffer.putInt(int_1);
                     Client.aClass46_1.method282(packetnode_2);
                  }
               } else {
                  int int_6;
                  if (int_2 == 25) {
                     widget_2 = Class74.method447(int_1, int_0);
                     if (widget_2 != null) {
                        Player.method1096();
                        int int_7 = GraphicsObject.method957(Preferences.getWidgetConfig(widget_2));
                        int_6 = widget_2.itemId;
                        Widget widget_0 = Class74.method447(int_1, int_0);
                        if (widget_0 != null && widget_0.anObjectArray9 != null) {
                           ScriptEvent scriptevent_0 = new ScriptEvent();
                           scriptevent_0.widget = widget_0;
                           scriptevent_0.anObjectArray22 = widget_0.anObjectArray9;
                           Class52.method335(scriptevent_0);
                        }

                        Client.anInt676 = int_6;
                        Client.spellSelected = true;
                        Class26.anInt87 = int_1;
                        Client.anInt656 = int_0;
                        Enum4.anInt381 = int_7;
                        WorldMapData.method305(widget_0);
                        Client.itemSelectionState = 0;
                        Client.aString34 = Timer.method588(widget_2);
                        if (Client.aString34 == null) {
                           Client.aString34 = "Null";
                        }

                        if (widget_2.hasScript) {
                           Client.aString36 = widget_2.name + WallObject.getColTags(16777215);
                        } else {
                           Client.aString36 = WallObject.getColTags(65280) + widget_2.aString16 + WallObject.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if (int_2 == 26) {
                     packetnode_0 = Actor.method953(ClientPacket.aClientPacket15, Client.aClass46_1.cipher);
                     Client.aClass46_1.method282(packetnode_0);

                     for (WidgetNode widgetnode_0 = (WidgetNode) Client.componentTable.method67(); widgetnode_0 != null; widgetnode_0 = (WidgetNode) Client.componentTable.method68()) {
                        if (widgetnode_0.owner == 0 || widgetnode_0.owner == 3) {
                           Frames.method873(widgetnode_0, true);
                        }
                     }

                     if (Client.aWidget12 != null) {
                        WorldMapData.method305(Client.aWidget12);
                        Client.aWidget12 = null;
                     }
                  } else {
                     Widget widget_1;
                     if (int_2 == 28) {
                        packetnode_0 = Actor.method953(ClientPacket.aClientPacket34, Client.aClass46_1.cipher);
                        packetnode_0.packetBuffer.putInt(int_1);
                        Client.aClass46_1.method282(packetnode_0);
                        widget_1 = PendingSpawn.method671(int_1);
                        if (widget_1.dynamicValues != null && widget_1.dynamicValues[0][0] == 5) {
                           int_6 = widget_1.dynamicValues[0][1];
                           Settings.widgetSettings[int_6] = 1 - Settings.widgetSettings[int_6];
                           DynamicObject.method1064(int_6);
                        }
                     } else if (int_2 == 29) {
                        packetnode_0 = Actor.method953(ClientPacket.aClientPacket34, Client.aClass46_1.cipher);
                        packetnode_0.packetBuffer.putInt(int_1);
                        Client.aClass46_1.method282(packetnode_0);
                        widget_1 = PendingSpawn.method671(int_1);
                        if (widget_1.dynamicValues != null && widget_1.dynamicValues[0][0] == 5) {
                           int_6 = widget_1.dynamicValues[0][1];
                           if (Settings.widgetSettings[int_6] != widget_1.anIntArray65[0]) {
                              Settings.widgetSettings[int_6] = widget_1.anIntArray65[0];
                              DynamicObject.method1064(int_6);
                           }
                        }
                     } else if (int_2 == 30) {
                        if (Client.aWidget12 == null) {
                           Class12.method167(int_1, int_0);
                           Client.aWidget12 = Class74.method447(int_1, int_0);
                           WorldMapData.method305(Client.aWidget12);
                        }
                     } else if (int_2 == 31) {
                        packetnode_0 = Actor.method953(ClientPacket.aClientPacket55, Client.aClass46_1.cipher);
                        packetnode_0.packetBuffer.putShort(int_0);
                        packetnode_0.packetBuffer.method719(int_3);
                        packetnode_0.packetBuffer.putShortLEA(KeyFocusListener.anInt128);
                        packetnode_0.packetBuffer.putShort(GameEngine.selectedItemIndex);
                        packetnode_0.packetBuffer.putInt(int_1);
                        packetnode_0.packetBuffer.method726(Class48.anInt111);
                        Client.aClass46_1.method282(packetnode_0);
                        Client.anInt651 = 0;
                        Class59.aWidget3 = PendingSpawn.method671(int_1);
                        Client.anInt653 = int_0;
                     } else if (int_2 == 32) {
                        packetnode_0 = Actor.method953(ClientPacket.aClientPacket17, Client.aClass46_1.cipher);
                        packetnode_0.packetBuffer.method718(Class26.anInt87);
                        packetnode_0.packetBuffer.method719(int_3);
                        packetnode_0.packetBuffer.putShortLEA(int_0);
                        packetnode_0.packetBuffer.putShort(Client.anInt656);
                        packetnode_0.packetBuffer.putInt(int_1);
                        Client.aClass46_1.method282(packetnode_0);
                        Client.anInt651 = 0;
                        Class59.aWidget3 = PendingSpawn.method671(int_1);
                        Client.anInt653 = int_0;
                     } else if (int_2 == 33) {
                        packetnode_0 = Actor.method953(ClientPacket.aClientPacket79, Client.aClass46_1.cipher);
                        packetnode_0.packetBuffer.putShortLEA(int_3);
                        packetnode_0.packetBuffer.method718(int_1);
                        packetnode_0.packetBuffer.putShortS(int_0);
                        Client.aClass46_1.method282(packetnode_0);
                        Client.anInt651 = 0;
                        Class59.aWidget3 = PendingSpawn.method671(int_1);
                        Client.anInt653 = int_0;
                     } else if (int_2 == 34) {
                        packetnode_0 = Actor.method953(ClientPacket.aClientPacket14, Client.aClass46_1.cipher);
                        packetnode_0.packetBuffer.putInt(int_1);
                        packetnode_0.packetBuffer.putShort(int_3);
                        packetnode_0.packetBuffer.putShort(int_0);
                        Client.aClass46_1.method282(packetnode_0);
                        Client.anInt651 = 0;
                        Class59.aWidget3 = PendingSpawn.method671(int_1);
                        Client.anInt653 = int_0;
                     } else if (int_2 == 35) {
                        packetnode_0 = Actor.method953(ClientPacket.aClientPacket43, Client.aClass46_1.cipher);
                        packetnode_0.packetBuffer.putShort(int_3);
                        packetnode_0.packetBuffer.method719(int_0);
                        packetnode_0.packetBuffer.method718(int_1);
                        Client.aClass46_1.method282(packetnode_0);
                        Client.anInt651 = 0;
                        Class59.aWidget3 = PendingSpawn.method671(int_1);
                        Client.anInt653 = int_0;
                     } else if (int_2 == 36) {
                        packetnode_0 = Actor.method953(ClientPacket.aClientPacket53, Client.aClass46_1.cipher);
                        packetnode_0.packetBuffer.method726(int_1);
                        packetnode_0.packetBuffer.method719(int_3);
                        packetnode_0.packetBuffer.putShortS(int_0);
                        Client.aClass46_1.method282(packetnode_0);
                        Client.anInt651 = 0;
                        Class59.aWidget3 = PendingSpawn.method671(int_1);
                        Client.anInt653 = int_0;
                     } else if (int_2 == 37) {
                        packetnode_0 = Actor.method953(ClientPacket.aClientPacket36, Client.aClass46_1.cipher);
                        packetnode_0.packetBuffer.putShortS(int_3);
                        packetnode_0.packetBuffer.method726(int_1);
                        packetnode_0.packetBuffer.putShortS(int_0);
                        Client.aClass46_1.method282(packetnode_0);
                        Client.anInt651 = 0;
                        Class59.aWidget3 = PendingSpawn.method671(int_1);
                        Client.anInt653 = int_0;
                     } else {
                        if (int_2 == 38) {
                           Player.method1096();
                           widget_2 = PendingSpawn.method671(int_1);
                           Client.itemSelectionState = 1;
                           GameEngine.selectedItemIndex = int_0;
                           Class48.anInt111 = int_1;
                           KeyFocusListener.anInt128 = int_3;
                           WorldMapData.method305(widget_2);
                           Client.aString35 = WallObject.getColTags(16748608) + ItemDefinition.getDefinition(int_3).name + WallObject.getColTags(16777215);
                           if (Client.aString35 == null) {
                              Client.aString35 = "null";
                           }

                           return;
                        }

                        if (int_2 == 39) {
                           packetnode_0 = Actor.method953(ClientPacket.aClientPacket80, Client.aClass46_1.cipher);
                           packetnode_0.packetBuffer.putShortS(int_3);
                           packetnode_0.packetBuffer.method719(int_0);
                           packetnode_0.packetBuffer.method726(int_1);
                           Client.aClass46_1.method282(packetnode_0);
                           Client.anInt651 = 0;
                           Class59.aWidget3 = PendingSpawn.method671(int_1);
                           Client.anInt653 = int_0;
                        } else if (int_2 == 40) {
                           packetnode_0 = Actor.method953(ClientPacket.aClientPacket32, Client.aClass46_1.cipher);
                           packetnode_0.packetBuffer.putShortLEA(int_0);
                           packetnode_0.packetBuffer.putInt(int_1);
                           packetnode_0.packetBuffer.putShortLEA(int_3);
                           Client.aClass46_1.method282(packetnode_0);
                           Client.anInt651 = 0;
                           Class59.aWidget3 = PendingSpawn.method671(int_1);
                           Client.anInt653 = int_0;
                        } else if (int_2 == 41) {
                           packetnode_0 = Actor.method953(ClientPacket.aClientPacket47, Client.aClass46_1.cipher);
                           packetnode_0.packetBuffer.putShortS(int_3);
                           packetnode_0.packetBuffer.putShort(int_0);
                           packetnode_0.packetBuffer.method718(int_1);
                           Client.aClass46_1.method282(packetnode_0);
                           Client.anInt651 = 0;
                           Class59.aWidget3 = PendingSpawn.method671(int_1);
                           Client.anInt653 = int_0;
                        } else if (int_2 == 42) {
                           packetnode_0 = Actor.method953(ClientPacket.aClientPacket83, Client.aClass46_1.cipher);
                           packetnode_0.packetBuffer.putShortLEA(int_3);
                           packetnode_0.packetBuffer.putShortLEA(int_0);
                           packetnode_0.packetBuffer.method718(int_1);
                           Client.aClass46_1.method282(packetnode_0);
                           Client.anInt651 = 0;
                           Class59.aWidget3 = PendingSpawn.method671(int_1);
                           Client.anInt653 = int_0;
                        } else if (int_2 == 43) {
                           packetnode_0 = Actor.method953(ClientPacket.aClientPacket44, Client.aClass46_1.cipher);
                           packetnode_0.packetBuffer.method718(int_1);
                           packetnode_0.packetBuffer.method719(int_3);
                           packetnode_0.packetBuffer.putShortLEA(int_0);
                           Client.aClass46_1.method282(packetnode_0);
                           Client.anInt651 = 0;
                           Class59.aWidget3 = PendingSpawn.method671(int_1);
                           Client.anInt653 = int_0;
                        } else if (int_2 == 44) {
                           player_0 = Client.players[int_3];
                           if (player_0 != null) {
                              Client.anInt641 = int_4;
                              Client.anInt642 = int_5;
                              Client.cursorState = 2;
                              Client.anInt645 = 0;
                              Client.destinationX = int_0;
                              Client.destinationY = int_1;
                              packetnode_1 = Actor.method953(ClientPacket.aClientPacket58, Client.aClass46_1.cipher);
                              packetnode_1.packetBuffer.putByteS(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
                              packetnode_1.packetBuffer.putShortLEA(int_3);
                              Client.aClass46_1.method282(packetnode_1);
                           }
                        } else if (int_2 == 45) {
                           player_0 = Client.players[int_3];
                           if (player_0 != null) {
                              Client.anInt641 = int_4;
                              Client.anInt642 = int_5;
                              Client.cursorState = 2;
                              Client.anInt645 = 0;
                              Client.destinationX = int_0;
                              Client.destinationY = int_1;
                              packetnode_1 = Actor.method953(ClientPacket.aClientPacket45, Client.aClass46_1.cipher);
                              packetnode_1.packetBuffer.method719(int_3);
                              packetnode_1.packetBuffer.putByteA(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
                              Client.aClass46_1.method282(packetnode_1);
                           }
                        } else if (int_2 == 46) {
                           player_0 = Client.players[int_3];
                           if (player_0 != null) {
                              Client.anInt641 = int_4;
                              Client.anInt642 = int_5;
                              Client.cursorState = 2;
                              Client.anInt645 = 0;
                              Client.destinationX = int_0;
                              Client.destinationY = int_1;
                              packetnode_1 = Actor.method953(ClientPacket.aClientPacket41, Client.aClass46_1.cipher);
                              packetnode_1.packetBuffer.putShort(int_3);
                              packetnode_1.packetBuffer.putByteS(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
                              Client.aClass46_1.method282(packetnode_1);
                           }
                        } else if (int_2 == 47) {
                           player_0 = Client.players[int_3];
                           if (player_0 != null) {
                              Client.anInt641 = int_4;
                              Client.anInt642 = int_5;
                              Client.cursorState = 2;
                              Client.anInt645 = 0;
                              Client.destinationX = int_0;
                              Client.destinationY = int_1;
                              packetnode_1 = Actor.method953(ClientPacket.aClientPacket70, Client.aClass46_1.cipher);
                              packetnode_1.packetBuffer.method719(int_3);
                              packetnode_1.packetBuffer.putByteInverse(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
                              Client.aClass46_1.method282(packetnode_1);
                           }
                        } else if (int_2 == 48) {
                           player_0 = Client.players[int_3];
                           if (player_0 != null) {
                              Client.anInt641 = int_4;
                              Client.anInt642 = int_5;
                              Client.cursorState = 2;
                              Client.anInt645 = 0;
                              Client.destinationX = int_0;
                              Client.destinationY = int_1;
                              packetnode_1 = Actor.method953(ClientPacket.aClientPacket63, Client.aClass46_1.cipher);
                              packetnode_1.packetBuffer.putByteS(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
                              packetnode_1.packetBuffer.putShortS(int_3);
                              Client.aClass46_1.method282(packetnode_1);
                           }
                        } else if (int_2 == 49) {
                           player_0 = Client.players[int_3];
                           if (player_0 != null) {
                              Client.anInt641 = int_4;
                              Client.anInt642 = int_5;
                              Client.cursorState = 2;
                              Client.anInt645 = 0;
                              Client.destinationX = int_0;
                              Client.destinationY = int_1;
                              packetnode_1 = Actor.method953(ClientPacket.aClientPacket22, Client.aClass46_1.cipher);
                              packetnode_1.packetBuffer.putByteInverse(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
                              packetnode_1.packetBuffer.method719(int_3);
                              Client.aClass46_1.method282(packetnode_1);
                           }
                        } else if (int_2 == 50) {
                           player_0 = Client.players[int_3];
                           if (player_0 != null) {
                              Client.anInt641 = int_4;
                              Client.anInt642 = int_5;
                              Client.cursorState = 2;
                              Client.anInt645 = 0;
                              Client.destinationX = int_0;
                              Client.destinationY = int_1;
                              packetnode_1 = Actor.method953(ClientPacket.aClientPacket65, Client.aClass46_1.cipher);
                              packetnode_1.packetBuffer.putByteA(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
                              packetnode_1.packetBuffer.putShortLEA(int_3);
                              Client.aClass46_1.method282(packetnode_1);
                           }
                        } else if (int_2 == 51) {
                           player_0 = Client.players[int_3];
                           if (player_0 != null) {
                              Client.anInt641 = int_4;
                              Client.anInt642 = int_5;
                              Client.cursorState = 2;
                              Client.anInt645 = 0;
                              Client.destinationX = int_0;
                              Client.destinationY = int_1;
                              packetnode_1 = Actor.method953(ClientPacket.aClientPacket76, Client.aClass46_1.cipher);
                              packetnode_1.packetBuffer.putByte(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
                              packetnode_1.packetBuffer.putShortS(int_3);
                              Client.aClass46_1.method282(packetnode_1);
                           }
                        } else {
                           label807: {
                              if (int_2 != 57) {
                                 if (int_2 == 58) {
                                    widget_2 = Class74.method447(int_1, int_0);
                                    if (widget_2 != null) {
                                       packetnode_1 = Actor.method953(ClientPacket.aClientPacket16, Client.aClass46_1.cipher);
                                       packetnode_1.packetBuffer.method718(Class26.anInt87);
                                       packetnode_1.packetBuffer.putShort(Client.anInt676);
                                       packetnode_1.packetBuffer.putShort(widget_2.itemId);
                                       packetnode_1.packetBuffer.putShortS(int_0);
                                       packetnode_1.packetBuffer.putShort(Client.anInt656);
                                       packetnode_1.packetBuffer.method725(int_1);
                                       Client.aClass46_1.method282(packetnode_1);
                                    }
                                    break label807;
                                 }

                                 if (int_2 == 1001) {
                                    Client.anInt641 = int_4;
                                    Client.anInt642 = int_5;
                                    Client.cursorState = 2;
                                    Client.anInt645 = 0;
                                    Client.destinationX = int_0;
                                    Client.destinationY = int_1;
                                    packetnode_0 = Actor.method953(ClientPacket.aClientPacket52, Client.aClass46_1.cipher);
                                    packetnode_0.packetBuffer.putShort(int_3 >> 14 & 0x7FFF);
                                    packetnode_0.packetBuffer.putByteInverse(KeyFocusListener.aBoolArray3[82] ? 1 : 0);
                                    packetnode_0.packetBuffer.putShort(int_0 + ItemLayer.baseX);
                                    packetnode_0.packetBuffer.method719(ItemLayer.baseY + int_1);
                                    Client.aClass46_1.method282(packetnode_0);
                                    break label807;
                                 }

                                 if (int_2 == 1002) {
                                    Client.anInt641 = int_4;
                                    Client.anInt642 = int_5;
                                    Client.cursorState = 2;
                                    Client.anInt645 = 0;
                                    packetnode_0 = Actor.method953(ClientPacket.aClientPacket90, Client.aClass46_1.cipher);
                                    packetnode_0.packetBuffer.putShortS(int_3 >> 14 & 0x7FFF);
                                    Client.aClass46_1.method282(packetnode_0);
                                    break label807;
                                 }

                                 if (int_2 == 1003) {
                                    Client.anInt641 = int_4;
                                    Client.anInt642 = int_5;
                                    Client.cursorState = 2;
                                    Client.anInt645 = 0;
                                    npc_0 = Client.cachedNPCs[int_3];
                                    if (npc_0 != null) {
                                       NPCDefinition npccomposition_0 = npc_0.composition;
                                       if (npccomposition_0.transformIds != null) {
                                          npccomposition_0 = npccomposition_0.transform();
                                       }

                                       if (npccomposition_0 != null) {
                                          packetnode_2 = Actor.method953(ClientPacket.aClientPacket49, Client.aClass46_1.cipher);
                                          packetnode_2.packetBuffer.putShortS(npccomposition_0.id);
                                          Client.aClass46_1.method282(packetnode_2);
                                       }
                                    }
                                    break label807;
                                 }

                                 if (int_2 == 1004) {
                                    Client.anInt641 = int_4;
                                    Client.anInt642 = int_5;
                                    Client.cursorState = 2;
                                    Client.anInt645 = 0;
                                    packetnode_0 = Actor.method953(ClientPacket.aClientPacket39, Client.aClass46_1.cipher);
                                    packetnode_0.packetBuffer.method719(int_3);
                                    Client.aClass46_1.method282(packetnode_0);
                                    break label807;
                                 }

                                 if (int_2 == 1005) {
                                    widget_2 = PendingSpawn.method671(int_1);
                                    if (widget_2 != null && widget_2.itemQuantities[int_0] >= 100000) {
                                       Class34.sendGameMessage(27, "", widget_2.itemQuantities[int_0] + " x " + ItemDefinition.getDefinition(int_3).name);
                                    } else {
                                       packetnode_1 = Actor.method953(ClientPacket.aClientPacket39, Client.aClass46_1.cipher);
                                       packetnode_1.packetBuffer.method719(int_3);
                                       Client.aClass46_1.method282(packetnode_1);
                                    }

                                    Client.anInt651 = 0;
                                    Class59.aWidget3 = PendingSpawn.method671(int_1);
                                    Client.anInt653 = int_0;
                                    break label807;
                                 }

                                 if (int_2 != 1007) {
                                    if (int_2 == 1008 || int_2 == 1011 || int_2 == 1010 || int_2 == 1009 || int_2 == 1012) {
                                       Client.renderOverview.method35(int_2, int_3, new Coordinates(int_0), new Coordinates(int_1));
                                    }
                                    break label807;
                                 }
                              }

                              widget_2 = Class74.method447(int_1, int_0);
                              if (widget_2 != null) {
                                 Enum1.method611(int_3, int_1, int_0, widget_2.itemId, string_1);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      if (Client.itemSelectionState != 0) {
         Client.itemSelectionState = 0;
         WorldMapData.method305(PendingSpawn.method671(Class48.anInt111));
      }

      if (Client.spellSelected) {
         Player.method1096();
      }

      if (Class59.aWidget3 != null && Client.anInt651 == 0) {
         WorldMapData.method305(Class59.aWidget3);
      }

   }

   static boolean method550(Widget widget_0) {
      int int_0 = widget_0.contentType;
      if (int_0 == 205) {
         Client.anInt609 = 250;
         return true;
      } else {
         int int_1;
         int int_2;
         if (int_0 >= 300 && int_0 <= 313) {
            int_1 = (int_0 - 300) / 2;
            int_2 = int_0 & 0x1;
            Client.aPlayerComposition1.method508(int_1, int_2 == 1);
         }

         if (int_0 >= 314 && int_0 <= 323) {
            int_1 = (int_0 - 314) / 2;
            int_2 = int_0 & 0x1;
            Client.aPlayerComposition1.method509(int_1, int_2 == 1);
         }

         if (int_0 == 324) {
            Client.aPlayerComposition1.method510(false);
         }

         if (int_0 == 325) {
            Client.aPlayerComposition1.method510(true);
         }

         if (int_0 == 326) {
            PacketNode packetnode_0 = Actor.method953(ClientPacket.aClientPacket69, Client.aClass46_1.cipher);
            Client.aPlayerComposition1.method511(packetnode_0.packetBuffer);
            Client.aClass46_1.method282(packetnode_0);
            return true;
         } else {
            return false;
         }
      }
   }

}
