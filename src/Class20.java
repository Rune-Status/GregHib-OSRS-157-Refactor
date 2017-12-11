import java.util.Comparator;
import java.util.Date;

public class Class20 implements Comparator {

   boolean aBool8;

   int method206(Class36 class36_0, Class36 class36_1) {
      if (class36_1.anInt96 == class36_0.anInt96) {
         return 0;
      } else {
         if (this.aBool8) {
            if (Client.world == class36_0.anInt96) {
               return -1;
            }

            if (class36_1.anInt96 == Client.world) {
               return 1;
            }
         }

         return class36_0.anInt96 < class36_1.anInt96 ? -1 : 1;
      }
   }

   public boolean equals(Object object_0) {
      return super.equals(object_0);
   }

   public int compare(Object object_0, Object object_1) {
      return this.method206((Class36) object_0, (Class36) object_1);
   }

   static void method207(World world_0) {
      if (world_0.method551() != Client.isMembers) {
         Client.isMembers = world_0.method551();
         boolean bool_0 = world_0.method551();
         if (bool_0 != Enum5.isMembersWorld) {
            Client.method1109();
            Enum5.isMembersWorld = bool_0;
         }
      }

      MilliTimer.host = world_0.address;
      Client.world = world_0.id;
      Client.flags = world_0.mask;
      DynamicObject.anInt577 = Client.socketType == 0 ? 43594 : world_0.id + 40000;
      MessageNode.anInt509 = Client.socketType == 0 ? 443 : world_0.id + 50000;
      AClass3.myWorldPort = DynamicObject.anInt577;
   }

   static int method208(int int_0, Script script_0, boolean bool_0) {
      if (int_0 < 1000) {
         return Enum1.method612(int_0, script_0, bool_0);
      } else if (int_0 < 1100) {
         return Class31.method237(int_0, script_0, bool_0);
      } else if (int_0 < 1200) {
         return Enum5.method701(int_0, script_0, bool_0);
      } else if (int_0 < 1300) {
         return Class10.method155(int_0, script_0, bool_0);
      } else if (int_0 < 1400) {
         return PacketNode.method680(int_0, script_0, bool_0);
      } else if (int_0 < 1500) {
         return MessageNode.method947(int_0, script_0, bool_0);
      } else {
         byte byte_0;
         Widget widget_0;
         if (int_0 < 1600) {
            widget_0 = bool_0 ? Class106.aWidget4 : Friend.aWidget5;
            if (int_0 == 1500) {
               Class39.intStack[++Class23.intStackSize - 1] = widget_0.relativeX;
               byte_0 = 1;
            } else if (int_0 == 1501) {
               Class39.intStack[++Class23.intStackSize - 1] = widget_0.relativeY;
               byte_0 = 1;
            } else if (int_0 == 1502) {
               Class39.intStack[++Class23.intStackSize - 1] = widget_0.width;
               byte_0 = 1;
            } else if (int_0 == 1503) {
               Class39.intStack[++Class23.intStackSize - 1] = widget_0.height;
               byte_0 = 1;
            } else if (int_0 == 1504) {
               Class39.intStack[++Class23.intStackSize - 1] = widget_0.isHidden ? 1 : 0;
               byte_0 = 1;
            } else if (int_0 == 1505) {
               Class39.intStack[++Class23.intStackSize - 1] = widget_0.parentId;
               byte_0 = 1;
            } else {
               byte_0 = 2;
            }

            return byte_0;
         } else {
            Widget widget_2;
            if (int_0 < 1700) {
               widget_2 = bool_0 ? Class106.aWidget4 : Friend.aWidget5;
               if (int_0 == 1600) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.scrollX;
                  byte_0 = 1;
               } else if (int_0 == 1601) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.scrollY;
                  byte_0 = 1;
               } else if (int_0 == 1602) {
                  Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = widget_2.disabledText;
                  byte_0 = 1;
               } else if (int_0 == 1603) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.scrollWidth;
                  byte_0 = 1;
               } else if (int_0 == 1604) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.scrollHeight;
                  byte_0 = 1;
               } else if (int_0 == 1605) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.modelZoom;
                  byte_0 = 1;
               } else if (int_0 == 1606) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.modelRotationX;
                  byte_0 = 1;
               } else if (int_0 == 1607) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.rotationY;
                  byte_0 = 1;
               } else if (int_0 == 1608) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.modelRotationZ;
                  byte_0 = 1;
               } else if (int_0 == 1609) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.opacity;
                  byte_0 = 1;
               } else if (int_0 == 1610) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.anInt288;
                  byte_0 = 1;
               } else if (int_0 == 1611) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.disabledColour;
                  byte_0 = 1;
               } else if (int_0 == 1612) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.enabledColour;
                  byte_0 = 1;
               } else if (int_0 == 1613) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.anEnum9_1.rsOrdinal();
                  byte_0 = 1;
               } else {
                  byte_0 = 2;
               }

               return byte_0;
            } else if (int_0 < 1800) {
               return GrandExchangeOffer.method174(int_0, script_0, bool_0);
            } else if (int_0 < 1900) {
               return FrameMap.method690(int_0, script_0, bool_0);
            } else if (int_0 < 2000) {
               return AClass6_Sub4.method868(int_0, script_0, bool_0);
            } else if (int_0 < 2100) {
               return Class31.method237(int_0, script_0, bool_0);
            } else if (int_0 < 2200) {
               return Enum5.method701(int_0, script_0, bool_0);
            } else if (int_0 < 2300) {
               return Class10.method155(int_0, script_0, bool_0);
            } else if (int_0 < 2400) {
               return PacketNode.method680(int_0, script_0, bool_0);
            } else if (int_0 < 2500) {
               return MessageNode.method947(int_0, script_0, bool_0);
            } else if (int_0 < 2600) {
               return Class47.method311(int_0, script_0, bool_0);
            } else if (int_0 < 2700) {
               widget_2 = Junk.method671(Class39.intStack[--Class23.intStackSize]);
               if (int_0 == 2600) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.scrollX;
                  byte_0 = 1;
               } else if (int_0 == 2601) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.scrollY;
                  byte_0 = 1;
               } else if (int_0 == 2602) {
                  Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = widget_2.disabledText;
                  byte_0 = 1;
               } else if (int_0 == 2603) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.scrollWidth;
                  byte_0 = 1;
               } else if (int_0 == 2604) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.scrollHeight;
                  byte_0 = 1;
               } else if (int_0 == 2605) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.modelZoom;
                  byte_0 = 1;
               } else if (int_0 == 2606) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.modelRotationX;
                  byte_0 = 1;
               } else if (int_0 == 2607) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.rotationY;
                  byte_0 = 1;
               } else if (int_0 == 2608) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.modelRotationZ;
                  byte_0 = 1;
               } else if (int_0 == 2609) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.opacity;
                  byte_0 = 1;
               } else if (int_0 == 2610) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.anInt288;
                  byte_0 = 1;
               } else if (int_0 == 2611) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.disabledColour;
                  byte_0 = 1;
               } else if (int_0 == 2612) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.enabledColour;
                  byte_0 = 1;
               } else if (int_0 == 2613) {
                  Class39.intStack[++Class23.intStackSize - 1] = widget_2.anEnum9_1.rsOrdinal();
                  byte_0 = 1;
               } else {
                  byte_0 = 2;
               }

               return byte_0;
            } else {
               int int_1;
               WidgetNode widgetnode_0;
               if (int_0 < 2800) {
                  if (int_0 == 2700) {
                     widget_2 = Junk.method671(Class39.intStack[--Class23.intStackSize]);
                     Class39.intStack[++Class23.intStackSize - 1] = widget_2.itemId;
                     byte_0 = 1;
                  } else if (int_0 == 2701) {
                     widget_2 = Junk.method671(Class39.intStack[--Class23.intStackSize]);
                     if (widget_2.itemId != -1) {
                        Class39.intStack[++Class23.intStackSize - 1] = widget_2.itemQuantity;
                     } else {
                        Class39.intStack[++Class23.intStackSize - 1] = 0;
                     }

                     byte_0 = 1;
                  } else if (int_0 == 2702) {
                     int_1 = Class39.intStack[--Class23.intStackSize];
                     widgetnode_0 = (WidgetNode) Client.componentTable.get((long)int_1);
                     if (widgetnode_0 != null) {
                        Class39.intStack[++Class23.intStackSize - 1] = 1;
                     } else {
                        Class39.intStack[++Class23.intStackSize - 1] = 0;
                     }

                     byte_0 = 1;
                  } else if (int_0 == 2706) {
                     Class39.intStack[++Class23.intStackSize - 1] = Client.widgetRoot;
                     byte_0 = 1;
                  } else {
                     byte_0 = 2;
                  }

                  return byte_0;
               } else if (int_0 < 2900) {
                  return Class13.method169(int_0, script_0, bool_0);
               } else if (int_0 < 3000) {
                  return AClass6_Sub4.method868(int_0, script_0, bool_0);
               } else {
                  int int_2;
                  boolean bool_1;
                  int int_4;
                  int[] ints_0;
                  String string_0;
                  String string_2;
                  int int_9;
                  PacketNode packetnode_1;
                  String string_3;
                  PacketNode packetnode_3;
                  if (int_0 < 3200) {
                     if (int_0 == 3100) {
                        string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                        Class34.sendGameMessage(0, "", string_2);
                        byte_0 = 1;
                     } else if (int_0 == 3101) {
                        Class23.intStackSize -= 2;
                        Class9.animate(Class4.localPlayer, Class39.intStack[Class23.intStackSize], Class39.intStack[Class23.intStackSize + 1]);
                        byte_0 = 1;
                     } else if (int_0 == 3103) {
                        PacketNode packetnode_4 = Actor.method953(ClientPacket.aClientPacket15, Client.aClass46_1.cipher);
                        Client.aClass46_1.method282(packetnode_4);

                        for (widgetnode_0 = (WidgetNode) Client.componentTable.method67(); widgetnode_0 != null; widgetnode_0 = (WidgetNode) Client.componentTable.method68()) {
                           if (widgetnode_0.owner == 0 || widgetnode_0.owner == 3) {
                              Frames.method873(widgetnode_0, true);
                           }
                        }

                        if (Client.aWidget12 != null) {
                           WorldMapData.method305(Client.aWidget12);
                           Client.aWidget12 = null;
                        }

                        byte_0 = 1;
                     } else if (int_0 == 3104) {
                        string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                        int_9 = 0;
                        if (Buffer.method736(string_2)) {
                           int_9 = Class27.method225(string_2);
                        }

                        packetnode_1 = Actor.method953(ClientPacket.aClientPacket73, Client.aClass46_1.cipher);
                        packetnode_1.packetBuffer.putInt(int_9);
                        Client.aClass46_1.method282(packetnode_1);
                        byte_0 = 1;
                     } else {
                        PacketNode packetnode_2;
                        if (int_0 == 3105) {
                           string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                           packetnode_2 = Actor.method953(ClientPacket.aClientPacket71, Client.aClass46_1.cipher);
                           packetnode_2.packetBuffer.putByte(string_2.length() + 1);
                           packetnode_2.packetBuffer.putString(string_2);
                           Client.aClass46_1.method282(packetnode_2);
                           byte_0 = 1;
                        } else if (int_0 == 3106) {
                           string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                           packetnode_2 = Actor.method953(ClientPacket.aClientPacket72, Client.aClass46_1.cipher);
                           packetnode_2.packetBuffer.putByte(string_2.length() + 1);
                           packetnode_2.packetBuffer.putString(string_2);
                           Client.aClass46_1.method282(packetnode_2);
                           byte_0 = 1;
                        } else if (int_0 == 3107) {
                           int_1 = Class39.intStack[--Class23.intStackSize];
                           string_0 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                           int_2 = Class27.localPlayerIndexCount;
                           ints_0 = Class27.localPlayerIndices;
                           boolean bool_6 = false;

                           for (int_4 = 0; int_4 < int_2; int_4++) {
                              Player player_0 = Client.players[ints_0[int_4]];
                              if (player_0 != null && player_0 != Class4.localPlayer && player_0.name != null && player_0.name.equalsIgnoreCase(string_0)) {
                                 if (int_1 == 1) {
                                    packetnode_3 = Actor.method953(ClientPacket.aClientPacket58, Client.aClass46_1.cipher);
                                    packetnode_3.packetBuffer.putByteS(0);
                                    packetnode_3.packetBuffer.putShortLEA(ints_0[int_4]);
                                    Client.aClass46_1.method282(packetnode_3);
                                 } else if (int_1 == 4) {
                                    packetnode_3 = Actor.method953(ClientPacket.aClientPacket70, Client.aClass46_1.cipher);
                                    packetnode_3.packetBuffer.method719(ints_0[int_4]);
                                    packetnode_3.packetBuffer.putByteInverse(0);
                                    Client.aClass46_1.method282(packetnode_3);
                                 } else if (int_1 == 6) {
                                    packetnode_3 = Actor.method953(ClientPacket.aClientPacket22, Client.aClass46_1.cipher);
                                    packetnode_3.packetBuffer.putByteInverse(0);
                                    packetnode_3.packetBuffer.method719(ints_0[int_4]);
                                    Client.aClass46_1.method282(packetnode_3);
                                 } else if (int_1 == 7) {
                                    packetnode_3 = Actor.method953(ClientPacket.aClientPacket65, Client.aClass46_1.cipher);
                                    packetnode_3.packetBuffer.putByteA(0);
                                    packetnode_3.packetBuffer.putShortLEA(ints_0[int_4]);
                                    Client.aClass46_1.method282(packetnode_3);
                                 }

                                 bool_6 = true;
                                 break;
                              }
                           }

                           if (!bool_6) {
                              Class34.sendGameMessage(4, "", "Unable to find " + string_0);
                           }

                           byte_0 = 1;
                        } else if (int_0 == 3108) {
                           Class23.intStackSize -= 3;
                           int_1 = Class39.intStack[Class23.intStackSize];
                           int_9 = Class39.intStack[Class23.intStackSize + 1];
                           int_2 = Class39.intStack[Class23.intStackSize + 2];
                           widget_0 = Junk.method671(int_2);
                           Tile.method683(widget_0, int_1, int_9);
                           byte_0 = 1;
                        } else if (int_0 == 3109) {
                           Class23.intStackSize -= 2;
                           int_1 = Class39.intStack[Class23.intStackSize];
                           int_9 = Class39.intStack[Class23.intStackSize + 1];
                           Widget widget_1 = bool_0 ? Class106.aWidget4 : Friend.aWidget5;
                           Tile.method683(widget_1, int_1, int_9);
                           byte_0 = 1;
                        } else if (int_0 == 3110) {
                           Item.aBool73 = Class39.intStack[--Class23.intStackSize] == 1;
                           byte_0 = 1;
                        } else if (int_0 == 3111) {
                           Class39.intStack[++Class23.intStackSize - 1] = Buffer.preferences.hideRoofs ? 1 : 0;
                           byte_0 = 1;
                        } else if (int_0 == 3112) {
                           Buffer.preferences.hideRoofs = Class39.intStack[--Class23.intStackSize] == 1;
                           Class59.method390();
                           byte_0 = 1;
                        } else if (int_0 == 3113) {
                           string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                           bool_1 = Class39.intStack[--Class23.intStackSize] == 1;
                           Class53.method350(string_2, bool_1, false);
                           byte_0 = 1;
                        } else if (int_0 == 3115) {
                           int_1 = Class39.intStack[--Class23.intStackSize];
                           packetnode_2 = Actor.method953(ClientPacket.aClientPacket74, Client.aClass46_1.cipher);
                           packetnode_2.packetBuffer.putShort(int_1);
                           Client.aClass46_1.method282(packetnode_2);
                           byte_0 = 1;
                        } else if (int_0 == 3116) {
                           int_1 = Class39.intStack[--Class23.intStackSize];
                           Class28.scriptStringStackSize -= 2;
                           string_0 = Class39.scriptStringStack[Class28.scriptStringStackSize];
                           string_3 = Class39.scriptStringStack[Class28.scriptStringStackSize + 1];
                           if (string_0.length() > 500) {
                              byte_0 = 1;
                           } else if (string_3.length() > 500) {
                              byte_0 = 1;
                           } else {
                              PacketNode packetnode_0 = Actor.method953(ClientPacket.aClientPacket77, Client.aClass46_1.cipher);
                              packetnode_0.packetBuffer.putShort(1 + Projectile.getLength(string_0) + Projectile.getLength(string_3));
                              packetnode_0.packetBuffer.putByte(int_1);
                              packetnode_0.packetBuffer.putString(string_0);
                              packetnode_0.packetBuffer.putString(string_3);
                              Client.aClass46_1.method282(packetnode_0);
                              byte_0 = 1;
                           }
                        } else if (int_0 == 3117) {
                           Client.aBool97 = Class39.intStack[--Class23.intStackSize] == 1;
                           byte_0 = 1;
                        } else {
                           byte_0 = 2;
                        }
                     }

                     return byte_0;
                  } else if (int_0 < 3300) {
                     if (int_0 == 3200) {
                        Class23.intStackSize -= 3;
                        int_1 = Class39.intStack[Class23.intStackSize];
                        int_9 = Class39.intStack[Class23.intStackSize + 1];
                        int_2 = Class39.intStack[Class23.intStackSize + 2];
                        if (Client.anInt644 != 0 && int_9 != 0 && Client.anInt647 < 50) {
                           Client.anIntArray149[Client.anInt647] = int_1;
                           Client.anIntArray150[Client.anInt647] = int_9;
                           Client.anIntArray152[Client.anInt647] = int_2;
                           Client.audioEffects[Client.anInt647] = null;
                           Client.anIntArray153[Client.anInt647] = 0;
                           ++Client.anInt647;
                        }

                        byte_0 = 1;
                     } else if (int_0 == 3201) {
                        Class47.method310(Class39.intStack[--Class23.intStackSize]);
                        byte_0 = 1;
                     } else if (int_0 == 3202) {
                        Class23.intStackSize -= 2;
                        int_1 = Class39.intStack[Class23.intStackSize];
                        int_9 = Class39.intStack[Class23.intStackSize + 1];
                        if (Client.anInt662 != 0 && int_1 != -1) {
                           Class71.method424(Class92.indexTrack2, int_1, 0, Client.anInt662, false);
                           Client.aBool87 = true;
                        }

                        byte_0 = 1;
                     } else {
                        byte_0 = 2;
                     }

                     return byte_0;
                  } else {
                     int int_3;
                     int int_5;
                     int int_6;
                     int int_10;
                     if (int_0 < 3400) {
                        if (int_0 == 3300) {
                           Class39.intStack[++Class23.intStackSize - 1] = Client.gameCycle;
                           byte_0 = 1;
                        } else if (int_0 == 3301) {
                           Class23.intStackSize -= 2;
                           int_1 = Class39.intStack[Class23.intStackSize];
                           int_9 = Class39.intStack[Class23.intStackSize + 1];
                           Class39.intStack[++Class23.intStackSize - 1] = MessageNode.method948(int_1, int_9);
                           byte_0 = 1;
                        } else {
                           int[] ints_3;
                           ItemContainer itemcontainer_0;
                           if (int_0 == 3302) {
                              Class23.intStackSize -= 2;
                              int_1 = Class39.intStack[Class23.intStackSize];
                              int_9 = Class39.intStack[Class23.intStackSize + 1];
                              ints_3 = Class39.intStack;
                              int_10 = ++Class23.intStackSize - 1;
                              itemcontainer_0 = (ItemContainer) ItemContainer.itemContainers.get((long)int_1);
                              if (itemcontainer_0 == null) {
                                 int_3 = 0;
                              } else if (int_9 >= 0 && int_9 < itemcontainer_0.stackSizes.length) {
                                 int_3 = itemcontainer_0.stackSizes[int_9];
                              } else {
                                 int_3 = 0;
                              }

                              ints_3[int_10] = int_3;
                              byte_0 = 1;
                           } else if (int_0 == 3303) {
                              Class23.intStackSize -= 2;
                              int_1 = Class39.intStack[Class23.intStackSize];
                              int_9 = Class39.intStack[Class23.intStackSize + 1];
                              ints_3 = Class39.intStack;
                              int_10 = ++Class23.intStackSize - 1;
                              itemcontainer_0 = (ItemContainer) ItemContainer.itemContainers.get((long)int_1);
                              if (itemcontainer_0 == null) {
                                 int_3 = 0;
                              } else if (int_9 == -1) {
                                 int_3 = 0;
                              } else {
                                 int_5 = 0;

                                 for (int_6 = 0; int_6 < itemcontainer_0.stackSizes.length; int_6++) {
                                    if (int_9 == itemcontainer_0.itemIds[int_6]) {
                                       int_5 += itemcontainer_0.stackSizes[int_6];
                                    }
                                 }

                                 int_3 = int_5;
                              }

                              ints_3[int_10] = int_3;
                              byte_0 = 1;
                           } else if (int_0 == 3304) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              Class39.intStack[++Class23.intStackSize - 1] = RuntimeException_Sub1.method955(int_1).size;
                              byte_0 = 1;
                           } else if (int_0 == 3305) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              Class39.intStack[++Class23.intStackSize - 1] = Client.boostedSkillLevels[int_1];
                              byte_0 = 1;
                           } else if (int_0 == 3306) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              Class39.intStack[++Class23.intStackSize - 1] = Client.realSkillLevels[int_1];
                              byte_0 = 1;
                           } else if (int_0 == 3307) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              Class39.intStack[++Class23.intStackSize - 1] = Client.skillExperiences[int_1];
                              byte_0 = 1;
                           } else if (int_0 == 3308) {
                              int_1 = Ignore.plane;
                              int_9 = (Class4.localPlayer.x >> 7) + ItemLayer.baseX;
                              int_2 = (Class4.localPlayer.y >> 7) + ItemLayer.baseY;
                              Class39.intStack[++Class23.intStackSize - 1] = (int_9 << 14) + int_2 + (int_1 << 28);
                              byte_0 = 1;
                           } else if (int_0 == 3309) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              Class39.intStack[++Class23.intStackSize - 1] = int_1 >> 14 & 0x3FFF;
                              byte_0 = 1;
                           } else if (int_0 == 3310) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              Class39.intStack[++Class23.intStackSize - 1] = int_1 >> 28;
                              byte_0 = 1;
                           } else if (int_0 == 3311) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              Class39.intStack[++Class23.intStackSize - 1] = int_1 & 0x3FFF;
                              byte_0 = 1;
                           } else if (int_0 == 3312) {
                              Class39.intStack[++Class23.intStackSize - 1] = Client.isMembers ? 1 : 0;
                              byte_0 = 1;
                           } else if (int_0 == 3313) {
                              Class23.intStackSize -= 2;
                              int_1 = Class39.intStack[Class23.intStackSize] + 32768;
                              int_9 = Class39.intStack[Class23.intStackSize + 1];
                              Class39.intStack[++Class23.intStackSize - 1] = MessageNode.method948(int_1, int_9);
                              byte_0 = 1;
                           } else if (int_0 == 3314) {
                              Class23.intStackSize -= 2;
                              int_1 = Class39.intStack[Class23.intStackSize] + 32768;
                              int_9 = Class39.intStack[Class23.intStackSize + 1];
                              ints_3 = Class39.intStack;
                              int_10 = ++Class23.intStackSize - 1;
                              itemcontainer_0 = (ItemContainer) ItemContainer.itemContainers.get((long)int_1);
                              if (itemcontainer_0 == null) {
                                 int_3 = 0;
                              } else if (int_9 >= 0 && int_9 < itemcontainer_0.stackSizes.length) {
                                 int_3 = itemcontainer_0.stackSizes[int_9];
                              } else {
                                 int_3 = 0;
                              }

                              ints_3[int_10] = int_3;
                              byte_0 = 1;
                           } else if (int_0 == 3315) {
                              Class23.intStackSize -= 2;
                              int_1 = Class39.intStack[Class23.intStackSize] + 32768;
                              int_9 = Class39.intStack[Class23.intStackSize + 1];
                              ints_3 = Class39.intStack;
                              int_10 = ++Class23.intStackSize - 1;
                              itemcontainer_0 = (ItemContainer) ItemContainer.itemContainers.get((long)int_1);
                              if (itemcontainer_0 == null) {
                                 int_3 = 0;
                              } else if (int_9 == -1) {
                                 int_3 = 0;
                              } else {
                                 int_5 = 0;

                                 for (int_6 = 0; int_6 < itemcontainer_0.stackSizes.length; int_6++) {
                                    if (int_9 == itemcontainer_0.itemIds[int_6]) {
                                       int_5 += itemcontainer_0.stackSizes[int_6];
                                    }
                                 }

                                 int_3 = int_5;
                              }

                              ints_3[int_10] = int_3;
                              byte_0 = 1;
                           } else if (int_0 == 3316) {
                              if (Client.rights >= 2) {
                                 Class39.intStack[++Class23.intStackSize - 1] = Client.rights;
                              } else {
                                 Class39.intStack[++Class23.intStackSize - 1] = 0;
                              }

                              byte_0 = 1;
                           } else if (int_0 == 3317) {
                              Class39.intStack[++Class23.intStackSize - 1] = Client.anInt608;
                              byte_0 = 1;
                           } else if (int_0 == 3318) {
                              Class39.intStack[++Class23.intStackSize - 1] = Client.world;
                              byte_0 = 1;
                           } else if (int_0 == 3321) {
                              Class39.intStack[++Class23.intStackSize - 1] = Client.energy;
                              byte_0 = 1;
                           } else if (int_0 == 3322) {
                              Class39.intStack[++Class23.intStackSize - 1] = Client.weight;
                              byte_0 = 1;
                           } else if (int_0 == 3323) {
                              if (Client.aBool95) {
                                 Class39.intStack[++Class23.intStackSize - 1] = 1;
                              } else {
                                 Class39.intStack[++Class23.intStackSize - 1] = 0;
                              }

                              byte_0 = 1;
                           } else if (int_0 == 3324) {
                              Class39.intStack[++Class23.intStackSize - 1] = Client.flags;
                              byte_0 = 1;
                           } else if (int_0 == 3325) {
                              Class23.intStackSize -= 4;
                              int_1 = Class39.intStack[Class23.intStackSize];
                              int_9 = Class39.intStack[Class23.intStackSize + 1];
                              int_2 = Class39.intStack[Class23.intStackSize + 2];
                              int_10 = Class39.intStack[Class23.intStackSize + 3];
                              int_1 += int_9 << 14;
                              int_1 += int_2 << 28;
                              int_1 += int_10;
                              Class39.intStack[++Class23.intStackSize - 1] = int_1;
                              byte_0 = 1;
                           } else {
                              byte_0 = 2;
                           }
                        }

                        return byte_0;
                     } else if (int_0 < 3500) {
                        if (int_0 == 3400) {
                           Class23.intStackSize -= 2;
                           int_1 = Class39.intStack[Class23.intStackSize];
                           int_9 = Class39.intStack[Class23.intStackSize + 1];
                           Enum enum_0 = (Enum) Enum.aNodeCache10.get((long)int_1);
                           Enum enum_1;
                           if (enum_0 != null) {
                              enum_1 = enum_0;
                           } else {
                              byte[] bytes_3 = Enum.anIndexDataBase21.getConfigData(8, int_1);
                              enum_0 = new Enum();
                              if (bytes_3 != null) {
                                 enum_0.decode(new Buffer(bytes_3));
                              }

                              Enum.aNodeCache10.put(enum_0, (long)int_1);
                              enum_1 = enum_0;
                           }

                           enum_0 = enum_1;
                           if (enum_1.valType != 115) {
                              ;
                           }

                           for (int_3 = 0; int_3 < enum_0.size; int_3++) {
                              if (int_9 == enum_0.keys[int_3]) {
                                 Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = enum_0.stringVals[int_3];
                                 enum_0 = null;
                                 break;
                              }
                           }

                           if (enum_0 != null) {
                              Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = enum_0.defaultString;
                           }

                           byte_0 = 1;
                        } else if (int_0 == 3408) {
                           Class23.intStackSize -= 4;
                           int_1 = Class39.intStack[Class23.intStackSize];
                           int_9 = Class39.intStack[Class23.intStackSize + 1];
                           int_2 = Class39.intStack[Class23.intStackSize + 2];
                           int_10 = Class39.intStack[Class23.intStackSize + 3];
                           Enum enum_3 = (Enum) Enum.aNodeCache10.get((long)int_2);
                           Enum enum_2;
                           if (enum_3 != null) {
                              enum_2 = enum_3;
                           } else {
                              byte[] bytes_2 = Enum.anIndexDataBase21.getConfigData(8, int_2);
                              enum_3 = new Enum();
                              if (bytes_2 != null) {
                                 enum_3.decode(new Buffer(bytes_2));
                              }

                              Enum.aNodeCache10.put(enum_3, (long)int_2);
                              enum_2 = enum_3;
                           }

                           enum_3 = enum_2;
                           if (int_1 == enum_2.keyType && int_9 == enum_2.valType) {
                              for (int_5 = 0; int_5 < enum_3.size; int_5++) {
                                 if (int_10 == enum_3.keys[int_5]) {
                                    if (int_9 == 115) {
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = enum_3.stringVals[int_5];
                                    } else {
                                       Class39.intStack[++Class23.intStackSize - 1] = enum_3.intVals[int_5];
                                    }

                                    enum_3 = null;
                                    break;
                                 }
                              }

                              if (enum_3 != null) {
                                 if (int_9 == 115) {
                                    Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = enum_3.defaultString;
                                 } else {
                                    Class39.intStack[++Class23.intStackSize - 1] = enum_3.defaultInt;
                                 }
                              }

                              byte_0 = 1;
                           } else {
                              if (int_9 == 115) {
                                 Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "null";
                              } else {
                                 Class39.intStack[++Class23.intStackSize - 1] = 0;
                              }

                              byte_0 = 1;
                           }
                        } else {
                           byte_0 = 2;
                        }

                        return byte_0;
                     } else {
                        String string_7;
                        if (int_0 < 3700) {
                           if (int_0 == 3600) {
                              if (Client.anInt655 == 0) {
                                 Class39.intStack[++Class23.intStackSize - 1] = -2;
                              } else if (Client.anInt655 == 1) {
                                 Class39.intStack[++Class23.intStackSize - 1] = -1;
                              } else {
                                 Class39.intStack[++Class23.intStackSize - 1] = Client.friendCount;
                              }

                              byte_0 = 1;
                           } else if (int_0 == 3601) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              if (Client.anInt655 == 2 && int_1 < Client.friendCount) {
                                 Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = Client.friends[int_1].name;
                                 Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = Client.friends[int_1].previousName;
                              } else {
                                 Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                                 Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                              }

                              byte_0 = 1;
                           } else if (int_0 == 3602) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              if (Client.anInt655 == 2 && int_1 < Client.friendCount) {
                                 Class39.intStack[++Class23.intStackSize - 1] = Client.friends[int_1].world;
                              } else {
                                 Class39.intStack[++Class23.intStackSize - 1] = 0;
                              }

                              byte_0 = 1;
                           } else if (int_0 == 3603) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              if (Client.anInt655 == 2 && int_1 < Client.friendCount) {
                                 Class39.intStack[++Class23.intStackSize - 1] = Client.friends[int_1].rank;
                              } else {
                                 Class39.intStack[++Class23.intStackSize - 1] = 0;
                              }

                              byte_0 = 1;
                           } else if (int_0 == 3604) {
                              string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                              int_9 = Class39.intStack[--Class23.intStackSize];
                              packetnode_1 = Actor.method953(ClientPacket.aClientPacket75, Client.aClass46_1.cipher);
                              packetnode_1.packetBuffer.putByte(Projectile.getLength(string_2) + 1);
                              packetnode_1.packetBuffer.putByteA(int_9);
                              packetnode_1.packetBuffer.putString(string_2);
                              Client.aClass46_1.method282(packetnode_1);
                              byte_0 = 1;
                           } else {
                              Friend friend_0;
                              String string_6;
                              if (int_0 == 3605) {
                                 string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                 if (string_2 != null) {
                                    if ((Client.friendCount < 200 || Client.anInt678 == 1) && Client.friendCount < 400) {
                                       string_0 = PacketBuffer.method908(string_2, Class24.aClass109_1);
                                       if (string_0 != null) {
                                          int_2 = 0;

                                          label2006:
                                          while (true) {
                                             if (int_2 >= Client.friendCount) {
                                                for (int_2 = 0; int_2 < Client.ignoreCount; int_2++) {
                                                   Ignore ignore_0 = Client.ignores[int_2];
                                                   string_6 = PacketBuffer.method908(ignore_0.name, Class24.aClass109_1);
                                                   if (string_6 != null && string_6.equals(string_0)) {
                                                      Class34.sendGameMessage(30, "", "Please remove " + string_2 + " from your ignore list first");
                                                      break label2006;
                                                   }

                                                   if (ignore_0.previousName != null) {
                                                      string_7 = PacketBuffer.method908(ignore_0.previousName, Class24.aClass109_1);
                                                      if (string_7 != null && string_7.equals(string_0)) {
                                                         Class34.sendGameMessage(30, "", "Please remove " + string_2 + " from your ignore list first");
                                                         break label2006;
                                                      }
                                                   }
                                                }

                                                if (PacketBuffer.method908(Class4.localPlayer.name, Class24.aClass109_1).equals(string_0)) {
                                                   Class34.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                                } else {
                                                   packetnode_1 = Actor.method953(ClientPacket.aClientPacket78, Client.aClass46_1.cipher);
                                                   packetnode_1.packetBuffer.putByte(Projectile.getLength(string_2));
                                                   packetnode_1.packetBuffer.putString(string_2);
                                                   Client.aClass46_1.method282(packetnode_1);
                                                }
                                                break;
                                             }

                                             friend_0 = Client.friends[int_2];
                                             string_6 = PacketBuffer.method908(friend_0.name, Class24.aClass109_1);
                                             if (string_6 != null && string_6.equals(string_0)) {
                                                Class34.sendGameMessage(30, "", string_2 + " is already on your friend list");
                                                break;
                                             }

                                             if (friend_0.previousName != null) {
                                                string_7 = PacketBuffer.method908(friend_0.previousName, Class24.aClass109_1);
                                                if (string_7 != null && string_7.equals(string_0)) {
                                                   Class34.sendGameMessage(30, "", string_2 + " is already on your friend list");
                                                   break;
                                                }
                                             }

                                             ++int_2;
                                          }
                                       }
                                    } else {
                                       Class34.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                                    }
                                 }

                                 byte_0 = 1;
                              } else if (int_0 == 3606) {
                                 string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                 if (string_2 != null) {
                                    string_0 = PacketBuffer.method908(string_2, Class24.aClass109_1);
                                    if (string_0 != null) {
                                       for (int_2 = 0; int_2 < Client.friendCount; int_2++) {
                                          friend_0 = Client.friends[int_2];
                                          string_6 = friend_0.name;
                                          string_7 = PacketBuffer.method908(string_6, Class24.aClass109_1);
                                          boolean bool_5;
                                          if (string_2 != null && string_6 != null) {
                                             if (!string_2.startsWith("#") && !string_6.startsWith("#")) {
                                                bool_5 = string_0.equals(string_7);
                                             } else {
                                                bool_5 = string_2.equals(string_6);
                                             }
                                          } else {
                                             bool_5 = false;
                                          }

                                          if (bool_5) {
                                             --Client.friendCount;

                                             for (int_6 = int_2; int_6 < Client.friendCount; int_6++) {
                                                Client.friends[int_6] = Client.friends[int_6 + 1];
                                             }

                                             Client.anInt658 = Client.cycleCntr;
                                             packetnode_3 = Actor.method953(ClientPacket.aClientPacket81, Client.aClass46_1.cipher);
                                             packetnode_3.packetBuffer.putByte(Projectile.getLength(string_2));
                                             packetnode_3.packetBuffer.putString(string_2);
                                             Client.aClass46_1.method282(packetnode_3);
                                             break;
                                          }
                                       }
                                    }
                                 }

                                 byte_0 = 1;
                              } else if (int_0 == 3607) {
                                 string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                 Class9.method151(string_2, false);
                                 byte_0 = 1;
                              } else if (int_0 == 3608) {
                                 string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                 Class45.method276(string_2);
                                 byte_0 = 1;
                              } else if (int_0 == 3609) {
                                 string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                 Permission[] permissions_0 = Class44.method272();

                                 for (int_2 = 0; int_2 < permissions_0.length; int_2++) {
                                    Permission permission_0 = permissions_0[int_2];
                                    if (permission_0.iconSpriteId != -1) {
                                       int_5 = permission_0.iconSpriteId;
                                       string_7 = "<img=" + int_5 + ">";
                                       if (string_2.startsWith(string_7)) {
                                          string_2 = string_2.substring(6 + Integer.toString(permission_0.iconSpriteId).length());
                                          break;
                                       }
                                    }
                                 }

                                 Class39.intStack[++Class23.intStackSize - 1] = Client.isFriended(string_2, false) ? 1 : 0;
                                 byte_0 = 1;
                              } else {
                                 long long_1;
                                 int int_7;
                                 int int_8;
                                 char char_0;
                                 String string_1;
                                 String string_4;
                                 String[] strings_2;
                                 if (int_0 == 3611) {
                                    if (Client.clanChatOwner == null) {
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                                    } else {
                                       strings_2 = Class39.scriptStringStack;
                                       int_9 = ++Class28.scriptStringStackSize - 1;
                                       string_1 = Client.clanChatOwner;
                                       long_1 = 0L;
                                       int_7 = string_1.length();

                                       for (int_8 = 0; int_8 < int_7; int_8++) {
                                          long_1 *= 37L;
                                          char_0 = string_1.charAt(int_8);
                                          if (char_0 >= 65 && char_0 <= 90) {
                                             long_1 += (long)(char_0 + 1 - 65);
                                          } else if (char_0 >= 97 && char_0 <= 122) {
                                             long_1 += (long)(char_0 + 1 - 97);
                                          } else if (char_0 >= 48 && char_0 <= 57) {
                                             long_1 += (long)(char_0 + 27 - 48);
                                          }

                                          if (long_1 >= 177917621779460413L) {
                                             break;
                                          }
                                       }

                                       while (long_1 % 37L == 0L && long_1 != 0L) {
                                          long_1 /= 37L;
                                       }

                                       string_4 = Preferences.method419(long_1);
                                       if (string_4 == null) {
                                          string_4 = "";
                                       }

                                       strings_2[int_9] = string_4;
                                    }

                                    byte_0 = 1;
                                 } else if (int_0 == 3612) {
                                    if (Client.clanChatOwner != null) {
                                       Class39.intStack[++Class23.intStackSize - 1] = Client.clanChatCount;
                                    } else {
                                       Class39.intStack[++Class23.intStackSize - 1] = 0;
                                    }

                                    byte_0 = 1;
                                 } else if (int_0 == 3613) {
                                    int_1 = Class39.intStack[--Class23.intStackSize];
                                    if (Client.clanChatOwner != null && int_1 < Client.clanChatCount) {
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = DynamicObject.clanMembers[int_1].username;
                                    } else {
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                                    }

                                    byte_0 = 1;
                                 } else if (int_0 == 3614) {
                                    int_1 = Class39.intStack[--Class23.intStackSize];
                                    if (Client.clanChatOwner != null && int_1 < Client.clanChatCount) {
                                       Class39.intStack[++Class23.intStackSize - 1] = DynamicObject.clanMembers[int_1].world;
                                    } else {
                                       Class39.intStack[++Class23.intStackSize - 1] = 0;
                                    }

                                    byte_0 = 1;
                                 } else if (int_0 == 3615) {
                                    int_1 = Class39.intStack[--Class23.intStackSize];
                                    if (Client.clanChatOwner != null && int_1 < Client.clanChatCount) {
                                       Class39.intStack[++Class23.intStackSize - 1] = DynamicObject.clanMembers[int_1].rank;
                                    } else {
                                       Class39.intStack[++Class23.intStackSize - 1] = 0;
                                    }

                                    byte_0 = 1;
                                 } else if (int_0 == 3616) {
                                    Class39.intStack[++Class23.intStackSize - 1] = Class18.aByte1;
                                    byte_0 = 1;
                                 } else if (int_0 == 3617) {
                                    string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                    AClass3_Sub1.method752(string_2);
                                    byte_0 = 1;
                                 } else if (int_0 == 3618) {
                                    Class39.intStack[++Class23.intStackSize - 1] = AClass3.clanChatRank;
                                    byte_0 = 1;
                                 } else if (int_0 == 3619) {
                                    string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                    Class42.method265(string_2);
                                    byte_0 = 1;
                                 } else if (int_0 == 3620) {
                                    Varcs.method544();
                                    byte_0 = 1;
                                 } else if (int_0 == 3621) {
                                    if (Client.anInt655 == 0) {
                                       Class39.intStack[++Class23.intStackSize - 1] = -1;
                                    } else {
                                       Class39.intStack[++Class23.intStackSize - 1] = Client.ignoreCount;
                                    }

                                    byte_0 = 1;
                                 } else if (int_0 == 3622) {
                                    int_1 = Class39.intStack[--Class23.intStackSize];
                                    if (Client.anInt655 != 0 && int_1 < Client.ignoreCount) {
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = Client.ignores[int_1].name;
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = Client.ignores[int_1].previousName;
                                    } else {
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                                    }

                                    byte_0 = 1;
                                 } else if (int_0 == 3623) {
                                    label1856: {
                                       string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                       string_3 = "<img=0>";
                                       if (!string_2.startsWith(string_3)) {
                                          string_6 = "<img=1>";
                                          if (!string_2.startsWith(string_6)) {
                                             break label1856;
                                          }
                                       }

                                       string_2 = string_2.substring(7);
                                    }

                                    Class39.intStack[++Class23.intStackSize - 1] = Tile.isIgnored(string_2) ? 1 : 0;
                                    byte_0 = 1;
                                 } else if (int_0 == 3624) {
                                    int_1 = Class39.intStack[--Class23.intStackSize];
                                    if (DynamicObject.clanMembers != null && int_1 < Client.clanChatCount && DynamicObject.clanMembers[int_1].username.equalsIgnoreCase(Class4.localPlayer.name)) {
                                       Class39.intStack[++Class23.intStackSize - 1] = 1;
                                    } else {
                                       Class39.intStack[++Class23.intStackSize - 1] = 0;
                                    }

                                    byte_0 = 1;
                                 } else if (int_0 == 3625) {
                                    if (Client.clanChatName == null) {
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                                    } else {
                                       strings_2 = Class39.scriptStringStack;
                                       int_9 = ++Class28.scriptStringStackSize - 1;
                                       string_1 = Client.clanChatName;
                                       long_1 = 0L;
                                       int_7 = string_1.length();

                                       for (int_8 = 0; int_8 < int_7; int_8++) {
                                          long_1 *= 37L;
                                          char_0 = string_1.charAt(int_8);
                                          if (char_0 >= 65 && char_0 <= 90) {
                                             long_1 += (long)(char_0 + 1 - 65);
                                          } else if (char_0 >= 97 && char_0 <= 122) {
                                             long_1 += (long)(char_0 + 1 - 97);
                                          } else if (char_0 >= 48 && char_0 <= 57) {
                                             long_1 += (long)(char_0 + 27 - 48);
                                          }

                                          if (long_1 >= 177917621779460413L) {
                                             break;
                                          }
                                       }

                                       while (long_1 % 37L == 0L && long_1 != 0L) {
                                          long_1 /= 37L;
                                       }

                                       string_4 = Preferences.method419(long_1);
                                       if (string_4 == null) {
                                          string_4 = "";
                                       }

                                       strings_2[int_9] = string_4;
                                    }

                                    byte_0 = 1;
                                 } else {
                                    byte_0 = 2;
                                 }
                              }
                           }

                           return byte_0;
                        } else if (int_0 < 4000) {
                           if (int_0 == 3903) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              Class39.intStack[++Class23.intStackSize - 1] = Client.grandExchangeOffers[int_1].method172();
                              byte_0 = 1;
                           } else if (int_0 == 3904) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              Class39.intStack[++Class23.intStackSize - 1] = Client.grandExchangeOffers[int_1].itemId;
                              byte_0 = 1;
                           } else if (int_0 == 3905) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              Class39.intStack[++Class23.intStackSize - 1] = Client.grandExchangeOffers[int_1].price;
                              byte_0 = 1;
                           } else if (int_0 == 3906) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              Class39.intStack[++Class23.intStackSize - 1] = Client.grandExchangeOffers[int_1].totalQuantity;
                              byte_0 = 1;
                           } else if (int_0 == 3907) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              Class39.intStack[++Class23.intStackSize - 1] = Client.grandExchangeOffers[int_1].quantitySold;
                              byte_0 = 1;
                           } else if (int_0 == 3908) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              Class39.intStack[++Class23.intStackSize - 1] = Client.grandExchangeOffers[int_1].spent;
                              byte_0 = 1;
                           } else if (int_0 == 3910) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              int_9 = Client.grandExchangeOffers[int_1].method173();
                              Class39.intStack[++Class23.intStackSize - 1] = int_9 == 0 ? 1 : 0;
                              byte_0 = 1;
                           } else if (int_0 == 3911) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              int_9 = Client.grandExchangeOffers[int_1].method173();
                              Class39.intStack[++Class23.intStackSize - 1] = int_9 == 2 ? 1 : 0;
                              byte_0 = 1;
                           } else if (int_0 == 3912) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              int_9 = Client.grandExchangeOffers[int_1].method173();
                              Class39.intStack[++Class23.intStackSize - 1] = int_9 == 5 ? 1 : 0;
                              byte_0 = 1;
                           } else if (int_0 == 3913) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              int_9 = Client.grandExchangeOffers[int_1].method173();
                              Class39.intStack[++Class23.intStackSize - 1] = int_9 == 1 ? 1 : 0;
                              byte_0 = 1;
                           } else {
                              boolean bool_4;
                              if (int_0 == 3914) {
                                 bool_4 = Class39.intStack[--Class23.intStackSize] == 1;
                                 if (Class65.aClass47_1 != null) {
                                    Class65.aClass47_1.method307(Class47.aComparator3, bool_4);
                                 }

                                 byte_0 = 1;
                              } else if (int_0 == 3915) {
                                 bool_4 = Class39.intStack[--Class23.intStackSize] == 1;
                                 if (Class65.aClass47_1 != null) {
                                    Class65.aClass47_1.method307(Class47.aComparator2, bool_4);
                                 }

                                 byte_0 = 1;
                              } else if (int_0 == 3916) {
                                 Class23.intStackSize -= 2;
                                 bool_4 = Class39.intStack[Class23.intStackSize] == 1;
                                 bool_1 = Class39.intStack[Class23.intStackSize + 1] == 1;
                                 if (Class65.aClass47_1 != null) {
                                    Client.aClass20_1.aBool8 = bool_1;
                                    Class65.aClass47_1.method307(Client.aClass20_1, bool_4);
                                 }

                                 byte_0 = 1;
                              } else if (int_0 == 3917) {
                                 bool_4 = Class39.intStack[--Class23.intStackSize] == 1;
                                 if (Class65.aClass47_1 != null) {
                                    Class65.aClass47_1.method307(Class47.aComparator1, bool_4);
                                 }

                                 byte_0 = 1;
                              } else if (int_0 == 3918) {
                                 bool_4 = Class39.intStack[--Class23.intStackSize] == 1;
                                 if (Class65.aClass47_1 != null) {
                                    Class65.aClass47_1.method307(Class47.aComparator4, bool_4);
                                 }

                                 byte_0 = 1;
                              } else if (int_0 == 3919) {
                                 Class39.intStack[++Class23.intStackSize - 1] = Class65.aClass47_1 == null ? 0 : Class65.aClass47_1.aList3.size();
                                 byte_0 = 1;
                              } else {
                                 Class36 class36_0;
                                 if (int_0 == 3920) {
                                    int_1 = Class39.intStack[--Class23.intStackSize];
                                    class36_0 = (Class36) Class65.aClass47_1.aList3.get(int_1);
                                    Class39.intStack[++Class23.intStackSize - 1] = class36_0.anInt96;
                                    byte_0 = 1;
                                 } else if (int_0 == 3921) {
                                    int_1 = Class39.intStack[--Class23.intStackSize];
                                    class36_0 = (Class36) Class65.aClass47_1.aList3.get(int_1);
                                    Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = class36_0.method246();
                                    byte_0 = 1;
                                 } else if (int_0 == 3922) {
                                    int_1 = Class39.intStack[--Class23.intStackSize];
                                    class36_0 = (Class36) Class65.aClass47_1.aList3.get(int_1);
                                    Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = class36_0.method247();
                                    byte_0 = 1;
                                 } else if (int_0 == 3923) {
                                    int_1 = Class39.intStack[--Class23.intStackSize];
                                    class36_0 = (Class36) Class65.aClass47_1.aList3.get(int_1);
                                    long long_2 = Class97.currentTimeMs() - Class19.aLong1 - class36_0.aLong2;
                                    int_3 = (int)(long_2 / 3600000L);
                                    int_4 = (int)((long_2 - (long)(int_3 * 3600000)) / 60000L);
                                    int_5 = (int)((long_2 - (long)(int_3 * 3600000) - (long)(int_4 * 60000)) / 1000L);
                                    String string_5 = int_3 + ":" + int_4 / 10 + int_4 % 10 + ":" + int_5 / 10 + int_5 % 10;
                                    Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = string_5;
                                    byte_0 = 1;
                                 } else if (int_0 == 3924) {
                                    int_1 = Class39.intStack[--Class23.intStackSize];
                                    class36_0 = (Class36) Class65.aClass47_1.aList3.get(int_1);
                                    Class39.intStack[++Class23.intStackSize - 1] = class36_0.aGrandExchangeOffer1.totalQuantity;
                                    byte_0 = 1;
                                 } else if (int_0 == 3925) {
                                    int_1 = Class39.intStack[--Class23.intStackSize];
                                    class36_0 = (Class36) Class65.aClass47_1.aList3.get(int_1);
                                    Class39.intStack[++Class23.intStackSize - 1] = class36_0.aGrandExchangeOffer1.price;
                                    byte_0 = 1;
                                 } else if (int_0 == 3926) {
                                    int_1 = Class39.intStack[--Class23.intStackSize];
                                    class36_0 = (Class36) Class65.aClass47_1.aList3.get(int_1);
                                    Class39.intStack[++Class23.intStackSize - 1] = class36_0.aGrandExchangeOffer1.itemId;
                                    byte_0 = 1;
                                 } else {
                                    byte_0 = 2;
                                 }
                              }
                           }

                           return byte_0;
                        } else if (int_0 < 4100) {
                           return Class74.method448(int_0, script_0, bool_0);
                        } else {
                           boolean bool_2;
                           if (int_0 < 4200) {
                              if (int_0 == 4100) {
                                 string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                 int_9 = Class39.intStack[--Class23.intStackSize];
                                 Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = string_2 + int_9;
                                 byte_0 = 1;
                              } else if (int_0 == 4101) {
                                 Class28.scriptStringStackSize -= 2;
                                 string_2 = Class39.scriptStringStack[Class28.scriptStringStackSize];
                                 string_0 = Class39.scriptStringStack[Class28.scriptStringStackSize + 1];
                                 Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = string_2 + string_0;
                                 byte_0 = 1;
                              } else if (int_0 == 4102) {
                                 string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                 int_9 = Class39.intStack[--Class23.intStackSize];
                                 String[] strings_1 = Class39.scriptStringStack;
                                 int_10 = ++Class28.scriptStringStackSize - 1;
                                 if (int_9 < 0) {
                                    string_7 = Integer.toString(int_9);
                                 } else {
                                    string_7 = Class81.method474(int_9, 10, true);
                                 }

                                 strings_1[int_10] = string_2 + string_7;
                                 byte_0 = 1;
                              } else if (int_0 == 4103) {
                                 string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                 Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = string_2.toLowerCase();
                                 byte_0 = 1;
                              } else if (int_0 == 4104) {
                                 int_1 = Class39.intStack[--Class23.intStackSize];
                                 long long_0 = 86400000L * (11745L + (long)int_1);
                                 Class39.aCalendar1.setTime(new Date(long_0));
                                 int_10 = Class39.aCalendar1.get(5);
                                 int_3 = Class39.aCalendar1.get(2);
                                 int_4 = Class39.aCalendar1.get(1);
                                 Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = int_10 + "-" + Class39.aStringArray1[int_3] + "-" + int_4;
                                 byte_0 = 1;
                              } else if (int_0 == 4105) {
                                 Class28.scriptStringStackSize -= 2;
                                 string_2 = Class39.scriptStringStack[Class28.scriptStringStackSize];
                                 string_0 = Class39.scriptStringStack[Class28.scriptStringStackSize + 1];
                                 if (Class4.localPlayer.composition != null && Class4.localPlayer.composition.isFemale) {
                                    Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = string_0;
                                 } else {
                                    Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = string_2;
                                 }

                                 byte_0 = 1;
                              } else if (int_0 == 4106) {
                                 int_1 = Class39.intStack[--Class23.intStackSize];
                                 Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = Integer.toString(int_1);
                                 byte_0 = 1;
                              } else if (int_0 == 4107) {
                                 Class28.scriptStringStackSize -= 2;
                                 Class39.intStack[++Class23.intStackSize - 1] = Friend.method536(NPCDefinition.method903(Class39.scriptStringStack[Class28.scriptStringStackSize], Class39.scriptStringStack[Class28.scriptStringStackSize + 1], Client.languageId));
                                 byte_0 = 1;
                              } else {
                                 Font font_0;
                                 byte[] bytes_1;
                                 if (int_0 == 4108) {
                                    string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                    Class23.intStackSize -= 2;
                                    int_9 = Class39.intStack[Class23.intStackSize];
                                    int_2 = Class39.intStack[Class23.intStackSize + 1];
                                    bytes_1 = Enum1.anIndexData4.getConfigData(int_2, 0);
                                    font_0 = new Font(bytes_1);
                                    Class39.intStack[++Class23.intStackSize - 1] = font_0.method1035(string_2, int_9);
                                    byte_0 = 1;
                                 } else if (int_0 == 4109) {
                                    string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                    Class23.intStackSize -= 2;
                                    int_9 = Class39.intStack[Class23.intStackSize];
                                    int_2 = Class39.intStack[Class23.intStackSize + 1];
                                    bytes_1 = Enum1.anIndexData4.getConfigData(int_2, 0);
                                    font_0 = new Font(bytes_1);
                                    Class39.intStack[++Class23.intStackSize - 1] = font_0.method1038(string_2, int_9);
                                    byte_0 = 1;
                                 } else if (int_0 == 4110) {
                                    Class28.scriptStringStackSize -= 2;
                                    string_2 = Class39.scriptStringStack[Class28.scriptStringStackSize];
                                    string_0 = Class39.scriptStringStack[Class28.scriptStringStackSize + 1];
                                    if (Class39.intStack[--Class23.intStackSize] == 1) {
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = string_2;
                                    } else {
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = string_0;
                                    }

                                    byte_0 = 1;
                                 } else if (int_0 == 4111) {
                                    string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                    Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = FontTypeFace.appendTags(string_2);
                                    byte_0 = 1;
                                 } else if (int_0 == 4112) {
                                    string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                    int_9 = Class39.intStack[--Class23.intStackSize];
                                    Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = string_2 + (char)int_9;
                                    byte_0 = 1;
                                 } else if (int_0 == 4113) {
                                    int_1 = Class39.intStack[--Class23.intStackSize];
                                    Class39.intStack[++Class23.intStackSize - 1] = Class16.method198((char)int_1) ? 1 : 0;
                                    byte_0 = 1;
                                 } else {
                                    int[] ints_1;
                                    char char_1;
                                    if (int_0 == 4114) {
                                       int_1 = Class39.intStack[--Class23.intStackSize];
                                       ints_1 = Class39.intStack;
                                       int_2 = ++Class23.intStackSize - 1;
                                       char_1 = (char)int_1;
                                       bool_2 = char_1 >= 48 && char_1 <= 57 || char_1 >= 65 && char_1 <= 90 || char_1 >= 97 && char_1 <= 122;
                                       ints_1[int_2] = bool_2 ? 1 : 0;
                                       byte_0 = 1;
                                    } else if (int_0 == 4115) {
                                       int_1 = Class39.intStack[--Class23.intStackSize];
                                       ints_1 = Class39.intStack;
                                       int_2 = ++Class23.intStackSize - 1;
                                       char_1 = (char)int_1;
                                       bool_2 = char_1 >= 65 && char_1 <= 90 || char_1 >= 97 && char_1 <= 122;
                                       ints_1[int_2] = bool_2 ? 1 : 0;
                                       byte_0 = 1;
                                    } else if (int_0 == 4116) {
                                       int_1 = Class39.intStack[--Class23.intStackSize];
                                       ints_1 = Class39.intStack;
                                       int_2 = ++Class23.intStackSize - 1;
                                       char_1 = (char)int_1;
                                       bool_2 = char_1 >= 48 && char_1 <= 57;
                                       ints_1[int_2] = bool_2 ? 1 : 0;
                                       byte_0 = 1;
                                    } else if (int_0 == 4117) {
                                       string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                       if (string_2 != null) {
                                          Class39.intStack[++Class23.intStackSize - 1] = string_2.length();
                                       } else {
                                          Class39.intStack[++Class23.intStackSize - 1] = 0;
                                       }

                                       byte_0 = 1;
                                    } else if (int_0 == 4118) {
                                       string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                       Class23.intStackSize -= 2;
                                       int_9 = Class39.intStack[Class23.intStackSize];
                                       int_2 = Class39.intStack[Class23.intStackSize + 1];
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = string_2.substring(int_9, int_2);
                                       byte_0 = 1;
                                    } else if (int_0 == 4119) {
                                       string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                       StringBuilder stringbuilder_0 = new StringBuilder(string_2.length());
                                       boolean bool_3 = false;

                                       for (int_10 = 0; int_10 < string_2.length(); int_10++) {
                                          char_1 = string_2.charAt(int_10);
                                          if (char_1 == 60) {
                                             bool_3 = true;
                                          } else if (char_1 == 62) {
                                             bool_3 = false;
                                          } else if (!bool_3) {
                                             stringbuilder_0.append(char_1);
                                          }
                                       }

                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = stringbuilder_0.toString();
                                       byte_0 = 1;
                                    } else if (int_0 == 4120) {
                                       string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                       int_9 = Class39.intStack[--Class23.intStackSize];
                                       Class39.intStack[++Class23.intStackSize - 1] = string_2.indexOf(int_9);
                                       byte_0 = 1;
                                    } else if (int_0 == 4121) {
                                       Class28.scriptStringStackSize -= 2;
                                       string_2 = Class39.scriptStringStack[Class28.scriptStringStackSize];
                                       string_0 = Class39.scriptStringStack[Class28.scriptStringStackSize + 1];
                                       int_2 = Class39.intStack[--Class23.intStackSize];
                                       Class39.intStack[++Class23.intStackSize - 1] = string_2.indexOf(string_0, int_2);
                                       byte_0 = 1;
                                    } else {
                                       byte_0 = 2;
                                    }
                                 }
                              }

                              return byte_0;
                           } else if (int_0 < 4300) {
                              if (int_0 == 4200) {
                                 int_1 = Class39.intStack[--Class23.intStackSize];
                                 Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = ItemDefinition.getDefinition(int_1).name;
                                 byte_0 = 1;
                              } else {
                                 ItemDefinition itemcomposition_1;
                                 if (int_0 == 4201) {
                                    Class23.intStackSize -= 2;
                                    int_1 = Class39.intStack[Class23.intStackSize];
                                    int_9 = Class39.intStack[Class23.intStackSize + 1];
                                    itemcomposition_1 = ItemDefinition.getDefinition(int_1);
                                    if (int_9 >= 1 && int_9 <= 5 && itemcomposition_1.groundOptions[int_9 - 1] != null) {
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = itemcomposition_1.groundOptions[int_9 - 1];
                                    } else {
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                                    }

                                    byte_0 = 1;
                                 } else if (int_0 == 4202) {
                                    Class23.intStackSize -= 2;
                                    int_1 = Class39.intStack[Class23.intStackSize];
                                    int_9 = Class39.intStack[Class23.intStackSize + 1];
                                    itemcomposition_1 = ItemDefinition.getDefinition(int_1);
                                    if (int_9 >= 1 && int_9 <= 5 && itemcomposition_1.inventoryOptions[int_9 - 1] != null) {
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = itemcomposition_1.inventoryOptions[int_9 - 1];
                                    } else {
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                                    }

                                    byte_0 = 1;
                                 } else if (int_0 == 4203) {
                                    int_1 = Class39.intStack[--Class23.intStackSize];
                                    Class39.intStack[++Class23.intStackSize - 1] = ItemDefinition.getDefinition(int_1).price;
                                    byte_0 = 1;
                                 } else if (int_0 == 4204) {
                                    int_1 = Class39.intStack[--Class23.intStackSize];
                                    Class39.intStack[++Class23.intStackSize - 1] = ItemDefinition.getDefinition(int_1).isStackable == 1 ? 1 : 0;
                                    byte_0 = 1;
                                 } else {
                                    ItemDefinition itemcomposition_0;
                                    if (int_0 == 4205) {
                                       int_1 = Class39.intStack[--Class23.intStackSize];
                                       itemcomposition_0 = ItemDefinition.getDefinition(int_1);
                                       if (itemcomposition_0.noteTemplateIndex == -1 && itemcomposition_0.noteIndex >= 0) {
                                          Class39.intStack[++Class23.intStackSize - 1] = itemcomposition_0.noteIndex;
                                       } else {
                                          Class39.intStack[++Class23.intStackSize - 1] = int_1;
                                       }

                                       byte_0 = 1;
                                    } else if (int_0 == 4206) {
                                       int_1 = Class39.intStack[--Class23.intStackSize];
                                       itemcomposition_0 = ItemDefinition.getDefinition(int_1);
                                       if (itemcomposition_0.noteTemplateIndex >= 0 && itemcomposition_0.noteIndex >= 0) {
                                          Class39.intStack[++Class23.intStackSize - 1] = itemcomposition_0.noteIndex;
                                       } else {
                                          Class39.intStack[++Class23.intStackSize - 1] = int_1;
                                       }

                                       byte_0 = 1;
                                    } else if (int_0 == 4207) {
                                       int_1 = Class39.intStack[--Class23.intStackSize];
                                       Class39.intStack[++Class23.intStackSize - 1] = ItemDefinition.getDefinition(int_1).isMembers ? 1 : 0;
                                       byte_0 = 1;
                                    } else if (int_0 == 4208) {
                                       int_1 = Class39.intStack[--Class23.intStackSize];
                                       itemcomposition_0 = ItemDefinition.getDefinition(int_1);
                                       if (itemcomposition_0.anInt505 == -1 && itemcomposition_0.anInt506 >= 0) {
                                          Class39.intStack[++Class23.intStackSize - 1] = itemcomposition_0.anInt506;
                                       } else {
                                          Class39.intStack[++Class23.intStackSize - 1] = int_1;
                                       }

                                       byte_0 = 1;
                                    } else if (int_0 == 4209) {
                                       int_1 = Class39.intStack[--Class23.intStackSize];
                                       itemcomposition_0 = ItemDefinition.getDefinition(int_1);
                                       if (itemcomposition_0.anInt505 >= 0 && itemcomposition_0.anInt506 >= 0) {
                                          Class39.intStack[++Class23.intStackSize - 1] = itemcomposition_0.anInt506;
                                       } else {
                                          Class39.intStack[++Class23.intStackSize - 1] = int_1;
                                       }

                                       byte_0 = 1;
                                    } else if (int_0 == 4210) {
                                       string_2 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                       int_9 = Class39.intStack[--Class23.intStackSize];
                                       Class50.method319(string_2, int_9 == 1);
                                       Class39.intStack[++Class23.intStackSize - 1] = Class3.anInt22;
                                       byte_0 = 1;
                                    } else if (int_0 == 4211) {
                                       if (Class21.aShortArray1 != null && Player.anInt593 < Class3.anInt22) {
                                          Class39.intStack[++Class23.intStackSize - 1] = Class21.aShortArray1[++Player.anInt593 - 1] & 0xFFFF;
                                       } else {
                                          Class39.intStack[++Class23.intStackSize - 1] = -1;
                                       }

                                       byte_0 = 1;
                                    } else if (int_0 == 4212) {
                                       Player.anInt593 = 0;
                                       byte_0 = 1;
                                    } else {
                                       byte_0 = 2;
                                    }
                                 }
                              }

                              return byte_0;
                           } else if (int_0 < 5100) {
                              return AClass3_Sub1.method751(int_0, script_0, bool_0);
                           } else if (int_0 < 5400) {
                              if (int_0 == 5306) {
                                 int[] ints_2 = Class39.intStack;
                                 int_9 = ++Class23.intStackSize - 1;
                                 int_2 = Client.isResized ? 2 : 1;
                                 ints_2[int_9] = int_2;
                                 byte_0 = 1;
                              } else if (int_0 == 5307) {
                                 int_1 = Class39.intStack[--Class23.intStackSize];
                                 if (int_1 == 1 || int_1 == 2) {
                                    Class43.method266(int_1);
                                 }

                                 byte_0 = 1;
                              } else if (int_0 == 5308) {
                                 Class39.intStack[++Class23.intStackSize - 1] = Buffer.preferences.screenType;
                                 byte_0 = 1;
                              } else if (int_0 == 5309) {
                                 int_1 = Class39.intStack[--Class23.intStackSize];
                                 if (int_1 == 1 || int_1 == 2) {
                                    Buffer.preferences.screenType = int_1;
                                    Class59.method390();
                                 }

                                 byte_0 = 1;
                              } else {
                                 byte_0 = 2;
                              }

                              return byte_0;
                           } else if (int_0 < 5600) {
                              if (int_0 == 5504) {
                                 Class23.intStackSize -= 2;
                                 int_10 = Class39.intStack[Class23.intStackSize];
                                 int_3 = Class39.intStack[Class23.intStackSize + 1];
                                 if (!Client.aBool94) {
                                    Client.anInt661 = int_10;
                                    Client.mapAngle = int_3;
                                 }

                                 byte_0 = 1;
                              } else if (int_0 == 5505) {
                                 Class39.intStack[++Class23.intStackSize - 1] = Client.anInt661;
                                 byte_0 = 1;
                              } else if (int_0 == 5506) {
                                 Class39.intStack[++Class23.intStackSize - 1] = Client.mapAngle;
                                 byte_0 = 1;
                              } else if (int_0 == 5530) {
                                 int_10 = Class39.intStack[--Class23.intStackSize];
                                 if (int_10 < 0) {
                                    int_10 = 0;
                                 }

                                 Client.anInt688 = int_10;
                                 byte_0 = 1;
                              } else if (int_0 == 5531) {
                                 Class39.intStack[++Class23.intStackSize - 1] = Client.anInt688;
                                 byte_0 = 1;
                              } else {
                                 byte_0 = 2;
                              }

                              return byte_0;
                           } else if (int_0 < 5700) {
                              if (int_0 == 5630) {
                                 Client.anInt609 = 250;
                                 byte_0 = 1;
                              } else {
                                 byte_0 = 2;
                              }

                              return byte_0;
                           } else if (int_0 < 6300) {
                              return Class11.method164(int_0, script_0, bool_0);
                           } else if (int_0 >= 6600) {
                              return int_0 < 6700 ? Class36.method250(int_0, script_0, bool_0) : 2;
                           } else {
                              if (int_0 == 6500) {
                                 Class39.intStack[++Class23.intStackSize - 1] = AClass3_Sub1.loadWorlds() ? 1 : 0;
                                 byte_0 = 1;
                              } else {
                                 World world_1;
                                 if (int_0 == 6501) {
                                    world_1 = Frames.method874();
                                    if (world_1 != null) {
                                       Class39.intStack[++Class23.intStackSize - 1] = world_1.id;
                                       Class39.intStack[++Class23.intStackSize - 1] = world_1.mask;
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = world_1.activity;
                                       Class39.intStack[++Class23.intStackSize - 1] = world_1.location;
                                       Class39.intStack[++Class23.intStackSize - 1] = world_1.playerCount;
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = world_1.address;
                                    } else {
                                       Class39.intStack[++Class23.intStackSize - 1] = -1;
                                       Class39.intStack[++Class23.intStackSize - 1] = 0;
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                                       Class39.intStack[++Class23.intStackSize - 1] = 0;
                                       Class39.intStack[++Class23.intStackSize - 1] = 0;
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                                    }

                                    byte_0 = 1;
                                 } else if (int_0 == 6502) {
                                    world_1 = ItemDefinition.method944();
                                    if (world_1 != null) {
                                       Class39.intStack[++Class23.intStackSize - 1] = world_1.id;
                                       Class39.intStack[++Class23.intStackSize - 1] = world_1.mask;
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = world_1.activity;
                                       Class39.intStack[++Class23.intStackSize - 1] = world_1.location;
                                       Class39.intStack[++Class23.intStackSize - 1] = world_1.playerCount;
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = world_1.address;
                                    } else {
                                       Class39.intStack[++Class23.intStackSize - 1] = -1;
                                       Class39.intStack[++Class23.intStackSize - 1] = 0;
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                                       Class39.intStack[++Class23.intStackSize - 1] = 0;
                                       Class39.intStack[++Class23.intStackSize - 1] = 0;
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                                    }

                                    byte_0 = 1;
                                 } else {
                                    World world_0;
                                    if (int_0 == 6506) {
                                       int_1 = Class39.intStack[--Class23.intStackSize];
                                       world_0 = null;

                                       for (int_2 = 0; int_2 < World.worldCount; int_2++) {
                                          if (int_1 == Coordinates.worldList[int_2].id) {
                                             world_0 = Coordinates.worldList[int_2];
                                             break;
                                          }
                                       }

                                       if (world_0 != null) {
                                          Class39.intStack[++Class23.intStackSize - 1] = world_0.id;
                                          Class39.intStack[++Class23.intStackSize - 1] = world_0.mask;
                                          Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = world_0.activity;
                                          Class39.intStack[++Class23.intStackSize - 1] = world_0.location;
                                          Class39.intStack[++Class23.intStackSize - 1] = world_0.playerCount;
                                          Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = world_0.address;
                                       } else {
                                          Class39.intStack[++Class23.intStackSize - 1] = -1;
                                          Class39.intStack[++Class23.intStackSize - 1] = 0;
                                          Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                                          Class39.intStack[++Class23.intStackSize - 1] = 0;
                                          Class39.intStack[++Class23.intStackSize - 1] = 0;
                                          Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                                       }

                                       byte_0 = 1;
                                    } else if (int_0 == 6507) {
                                       Class23.intStackSize -= 4;
                                       int_1 = Class39.intStack[Class23.intStackSize];
                                       bool_1 = Class39.intStack[Class23.intStackSize + 1] == 1;
                                       int_2 = Class39.intStack[Class23.intStackSize + 2];
                                       bool_2 = Class39.intStack[Class23.intStackSize + 3] == 1;
                                       if (Coordinates.worldList != null) {
                                          Class89.method497(0, Coordinates.worldList.length - 1, int_1, bool_1, int_2, bool_2);
                                       }

                                       byte_0 = 1;
                                    } else if (int_0 == 6511) {
                                       int_1 = Class39.intStack[--Class23.intStackSize];
                                       if (int_1 >= 0 && int_1 < World.worldCount) {
                                          world_0 = Coordinates.worldList[int_1];
                                          Class39.intStack[++Class23.intStackSize - 1] = world_0.id;
                                          Class39.intStack[++Class23.intStackSize - 1] = world_0.mask;
                                          Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = world_0.activity;
                                          Class39.intStack[++Class23.intStackSize - 1] = world_0.location;
                                          Class39.intStack[++Class23.intStackSize - 1] = world_0.playerCount;
                                          Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = world_0.address;
                                       } else {
                                          Class39.intStack[++Class23.intStackSize - 1] = -1;
                                          Class39.intStack[++Class23.intStackSize - 1] = 0;
                                          Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                                          Class39.intStack[++Class23.intStackSize - 1] = 0;
                                          Class39.intStack[++Class23.intStackSize - 1] = 0;
                                          Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                                       }

                                       byte_0 = 1;
                                    } else if (int_0 == 6512) {
                                       Client.aBool98 = Class39.intStack[--Class23.intStackSize] == 1;
                                       byte_0 = 1;
                                    } else {
                                       CacheableNode_Sub5 cacheablenode_sub5_0;
                                       if (int_0 == 6513) {
                                          Class23.intStackSize -= 2;
                                          int_1 = Class39.intStack[Class23.intStackSize];
                                          int_9 = Class39.intStack[Class23.intStackSize + 1];
                                          cacheablenode_sub5_0 = PacketBuffer.method907(int_9);
                                          if (cacheablenode_sub5_0.method884()) {
                                             Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = NPCDefinition.getNpcDefinition(int_1).method901(int_9, cacheablenode_sub5_0.aString30);
                                          } else {
                                             Class39.intStack[++Class23.intStackSize - 1] = NPCDefinition.getNpcDefinition(int_1).method902(int_9, cacheablenode_sub5_0.anInt474);
                                          }

                                          byte_0 = 1;
                                       } else if (int_0 == 6514) {
                                          Class23.intStackSize -= 2;
                                          int_1 = Class39.intStack[Class23.intStackSize];
                                          int_9 = Class39.intStack[Class23.intStackSize + 1];
                                          cacheablenode_sub5_0 = PacketBuffer.method907(int_9);
                                          if (cacheablenode_sub5_0.method884()) {
                                             Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = ObjectDefinition.getDefinition(int_1).method826(int_9, cacheablenode_sub5_0.aString30);
                                          } else {
                                             Class39.intStack[++Class23.intStackSize - 1] = ObjectDefinition.getDefinition(int_1).method827(int_9, cacheablenode_sub5_0.anInt474);
                                          }

                                          byte_0 = 1;
                                       } else if (int_0 == 6515) {
                                          Class23.intStackSize -= 2;
                                          int_1 = Class39.intStack[Class23.intStackSize];
                                          int_9 = Class39.intStack[Class23.intStackSize + 1];
                                          cacheablenode_sub5_0 = PacketBuffer.method907(int_9);
                                          if (cacheablenode_sub5_0.method884()) {
                                             Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = ItemDefinition.getDefinition(int_1).method942(int_9, cacheablenode_sub5_0.aString30);
                                          } else {
                                             Class39.intStack[++Class23.intStackSize - 1] = ItemDefinition.getDefinition(int_1).method941(int_9, cacheablenode_sub5_0.anInt474);
                                          }

                                          byte_0 = 1;
                                       } else if (int_0 == 6516) {
                                          Class23.intStackSize -= 2;
                                          int_1 = Class39.intStack[Class23.intStackSize];
                                          int_9 = Class39.intStack[Class23.intStackSize + 1];
                                          cacheablenode_sub5_0 = PacketBuffer.method907(int_9);
                                          CacheableNode_Sub3 cacheablenode_sub3_0;
                                          byte[] bytes_0;
                                          CacheableNode_Sub3 cacheablenode_sub3_1;
                                          if (cacheablenode_sub5_0.method884()) {
                                             String[] strings_0 = Class39.scriptStringStack;
                                             int_3 = ++Class28.scriptStringStackSize - 1;
                                             cacheablenode_sub3_0 = (CacheableNode_Sub3) CacheableNode_Sub3.aNodeCache12.get((long)int_1);
                                             if (cacheablenode_sub3_0 != null) {
                                                cacheablenode_sub3_1 = cacheablenode_sub3_0;
                                             } else {
                                                bytes_0 = CacheableNode_Sub3.anIndexDataBase22.getConfigData(34, int_1);
                                                cacheablenode_sub3_0 = new CacheableNode_Sub3();
                                                if (bytes_0 != null) {
                                                   cacheablenode_sub3_0.method879(new Buffer(bytes_0));
                                                }

                                                cacheablenode_sub3_0.method878();
                                                CacheableNode_Sub3.aNodeCache12.put(cacheablenode_sub3_0, (long)int_1);
                                                cacheablenode_sub3_1 = cacheablenode_sub3_0;
                                             }

                                             strings_0[int_3] = cacheablenode_sub3_1.method877(int_9, cacheablenode_sub5_0.aString30);
                                          } else {
                                             ints_0 = Class39.intStack;
                                             int_3 = ++Class23.intStackSize - 1;
                                             cacheablenode_sub3_0 = (CacheableNode_Sub3) CacheableNode_Sub3.aNodeCache12.get((long)int_1);
                                             if (cacheablenode_sub3_0 != null) {
                                                cacheablenode_sub3_1 = cacheablenode_sub3_0;
                                             } else {
                                                bytes_0 = CacheableNode_Sub3.anIndexDataBase22.getConfigData(34, int_1);
                                                cacheablenode_sub3_0 = new CacheableNode_Sub3();
                                                if (bytes_0 != null) {
                                                   cacheablenode_sub3_0.method879(new Buffer(bytes_0));
                                                }

                                                cacheablenode_sub3_0.method878();
                                                CacheableNode_Sub3.aNodeCache12.put(cacheablenode_sub3_0, (long)int_1);
                                                cacheablenode_sub3_1 = cacheablenode_sub3_0;
                                             }

                                             ints_0[int_3] = cacheablenode_sub3_1.method876(int_9, cacheablenode_sub5_0.anInt474);
                                          }

                                          byte_0 = 1;
                                       } else if (int_0 == 6518) {
                                          Class39.intStack[++Class23.intStackSize - 1] = 0;
                                          byte_0 = 1;
                                       } else if (int_0 == 6520) {
                                          byte_0 = 1;
                                       } else if (int_0 == 6521) {
                                          byte_0 = 1;
                                       } else {
                                          byte_0 = 2;
                                       }
                                    }
                                 }
                              }

                              return byte_0;
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   public static int method209(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      if ((int_5 & 0x1) == 1) {
         int int_6 = int_3;
         int_3 = int_4;
         int_4 = int_6;
      }

      int_2 &= 0x3;
      return int_2 == 0 ? int_0 : (int_2 == 1 ? int_1 : (int_2 == 2 ? 7 - int_0 - (int_3 - 1) : 7 - int_1 - (int_4 - 1)));
   }

}
