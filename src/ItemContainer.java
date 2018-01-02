public class ItemContainer extends Node {

   static HashTable itemContainers;
   static int[] loadedWidths;
   static Widget aWidget6;
   static IndexedSprite anIndexedSprite7;
   int[] itemIds;
   int[] stackSizes;

   static {
      itemContainers = new HashTable(32);
   }

   ItemContainer() {
      this.itemIds = new int[] {-1};
      this.stackSizes = new int[] {0};
   }

   static void method675(Widget[] widgets_0, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6) {
      for (int int_7 = 0; int_7 < widgets_0.length; int_7++) {
         Widget widget_0 = widgets_0[int_7];
         if (widget_0 != null && (!widget_0.hasScript || widget_0.type == 0 || widget_0.parametersLoaded || Preferences.getWidgetConfig(widget_0) != 0 || widget_0 == Client.aWidget10 || widget_0.contentType == 1338) && widget_0.parentId == int_0 && (!widget_0.hasScript || !CacheableNode_Sub5.method887(widget_0))) {
            int int_8 = widget_0.relativeX + int_5;
            int int_9 = int_6 + widget_0.relativeY;
            int int_10;
            int int_11;
            int int_12;
            int int_13;
            int int_14;
            int int_15;
            int int_17;
            if (widget_0.type == 2) {
               int_10 = int_1;
               int_11 = int_2;
               int_12 = int_3;
               int_13 = int_4;
            } else if (widget_0.type == 9) {
               int_14 = int_8;
               int_15 = int_9;
               int int_16 = int_8 + widget_0.width;
               int_17 = int_9 + widget_0.height;
               if (int_16 < int_8) {
                  int_14 = int_16;
                  int_16 = int_8;
               }

               if (int_17 < int_9) {
                  int_15 = int_17;
                  int_17 = int_9;
               }

               ++int_16;
               ++int_17;
               int_10 = int_14 > int_1 ? int_14 : int_1;
               int_11 = int_15 > int_2 ? int_15 : int_2;
               int_12 = int_16 < int_3 ? int_16 : int_3;
               int_13 = int_17 < int_4 ? int_17 : int_4;
            } else {
               int_14 = int_8 + widget_0.width;
               int_15 = int_9 + widget_0.height;
               int_10 = int_8 > int_1 ? int_8 : int_1;
               int_11 = int_9 > int_2 ? int_9 : int_2;
               int_12 = int_14 < int_3 ? int_14 : int_3;
               int_13 = int_15 < int_4 ? int_15 : int_4;
            }

            if (widget_0 == Client.aWidget9) {
               Client.aBool85 = true;
               Client.anInt638 = int_8;
               Client.anInt639 = int_9;
            }

            if (!widget_0.hasScript || int_10 < int_12 && int_11 < int_13) {
               int_14 = MouseInput.mouseEventX;
               int_15 = MouseInput.mouseEventY;
               if (MouseInput.anInt259 != 0) {
                  int_14 = MouseInput.anInt264;
                  int_15 = MouseInput.anInt265;
               }

               boolean bool_2 = int_14 >= int_10 && int_15 >= int_11 && int_14 < int_12 && int_15 < int_13;
               int int_18;
               int int_19;
               int int_20;
               int int_21;
               int int_22;
               int int_23;
               int int_24;
               int int_25;
               int int_26;
               int int_27;
               if (widget_0.contentType == 1337) {
                  if (!Client.loginScreenShown && !Client.isMenuOpen && bool_2) {
                     if (Client.itemSelectionState == 0 && !Client.spellSelected) {
                        Class24.addMenuEntry("Walk here", "", 23, 0, int_14 - int_10, int_15 - int_11);
                     }

                     int_17 = -1;
                     int_18 = -1;

                     for (int_19 = 0; int_19 < Class54.anInt140; int_19++) {
                        int_20 = Class54.anIntArray34[int_19];
                        int_21 = int_20 & 0x7F;
                        int_22 = int_20 >> 7 & 0x7F;
                        int_23 = int_20 >> 29 & 0x3;
                        int_24 = int_20 >> 14 & 0x7FFF;
                        if (int_18 != int_20) {
                           int_18 = int_20;
                           if (int_23 == 2 && Class23.sceneGraph.getObjectConfig(Ignore.plane, int_21, int_22, int_20) >= 0) {
                              ObjectDefinition objectcomposition_0 = ObjectDefinition.getDefinition(int_24);
                              if (objectcomposition_0.transformationIds != null) {
                                 objectcomposition_0 = objectcomposition_0.morph();
                              }

                              if (objectcomposition_0 == null) {
                                 continue;
                              }

                              if (Client.itemSelectionState == 1) {
                                 Class24.addMenuEntry("Use", Client.selectedItemName + " " + "->" + " " + Wall.getColTags(65535) + objectcomposition_0.name, 1, int_20, int_21, int_22);
                              } else if (Client.spellSelected) {
                                 if ((Enum4.anInt381 & 0x4) == 4) {
                                    Class24.addMenuEntry(Client.aString34, Client.aString36 + " " + "->" + " " + Wall.getColTags(65535) + objectcomposition_0.name, 2, int_20, int_21, int_22);
                                 }
                              } else {
                                 String[] strings_1 = objectcomposition_0.options;
                                 if (Client.aBool99) {
                                    strings_1 = Friend.method537(strings_1);
                                 }

                                 if (strings_1 != null) {
                                    for (int int_31 = 4; int_31 >= 0; --int_31) {
                                       if (strings_1[int_31] != null) {
                                          short short_0 = 0;
                                          if (int_31 == 0) {
                                             short_0 = 3;
                                          }

                                          if (int_31 == 1) {
                                             short_0 = 4;
                                          }

                                          if (int_31 == 2) {
                                             short_0 = 5;
                                          }

                                          if (int_31 == 3) {
                                             short_0 = 6;
                                          }

                                          if (int_31 == 4) {
                                             short_0 = 1001;
                                          }

                                          Class24.addMenuEntry(strings_1[int_31], Wall.getColTags(65535) + objectcomposition_0.name, short_0, int_20, int_21, int_22);
                                       }
                                    }
                                 }

                                 Class24.addMenuEntry("Examine", Wall.getColTags(65535) + objectcomposition_0.name, 1002, objectcomposition_0.id << 14, int_21, int_22);
                              }
                           }

                           Player player_0;
                           NPC npc_0;
                           int[] ints_0;
                           if (int_23 == 1) {
                              NPC npc_1 = Client.cachedNPCs[int_24];
                              if (npc_1 == null) {
                                 continue;
                              }

                              if (npc_1.composition.boundaryDimension == 1 && (npc_1.x & 0x7F) == 64 && (npc_1.y & 0x7F) == 64) {
                                 for (int_25 = 0; int_25 < Client.npcIndexesCount; int_25++) {
                                    npc_0 = Client.cachedNPCs[Client.npcIndices[int_25]];
                                    if (npc_0 != null && npc_1 != npc_0 && npc_0.composition.boundaryDimension == 1 && npc_0.x == npc_1.x && npc_1.y == npc_0.y) {
                                       Class14.method191(npc_0.composition, Client.npcIndices[int_25], int_21, int_22);
                                    }
                                 }

                                 int_25 = Class27.localPlayerIndexCount;
                                 ints_0 = Class27.localPlayerIndices;

                                 for (int_26 = 0; int_26 < int_25; int_26++) {
                                    player_0 = Client.players[ints_0[int_26]];
                                    if (player_0 != null && player_0.x == npc_1.x && npc_1.y == player_0.y) {
                                       Class29.method235(player_0, ints_0[int_26], int_21, int_22);
                                    }
                                 }
                              }

                              Class14.method191(npc_1.composition, int_24, int_21, int_22);
                           }

                           if (int_23 == 0) {
                              Player player_2 = Client.players[int_24];
                              if (player_2 == null) {
                                 continue;
                              }

                              if ((player_2.x & 0x7F) == 64 && (player_2.y & 0x7F) == 64) {
                                 for (int_25 = 0; int_25 < Client.npcIndexesCount; int_25++) {
                                    npc_0 = Client.cachedNPCs[Client.npcIndices[int_25]];
                                    if (npc_0 != null && npc_0.composition.boundaryDimension == 1 && player_2.x == npc_0.x && npc_0.y == player_2.y) {
                                       Class14.method191(npc_0.composition, Client.npcIndices[int_25], int_21, int_22);
                                    }
                                 }

                                 int_25 = Class27.localPlayerIndexCount;
                                 ints_0 = Class27.localPlayerIndices;

                                 for (int_26 = 0; int_26 < int_25; int_26++) {
                                    player_0 = Client.players[ints_0[int_26]];
                                    if (player_0 != null && player_2 != player_0 && player_0.x == player_2.x && player_0.y == player_2.y) {
                                       Class29.method235(player_0, ints_0[int_26], int_21, int_22);
                                    }
                                 }
                              }

                              if (int_24 != Client.someSelectedPlayerIndex) {
                                 Class29.method235(player_2, int_24, int_21, int_22);
                              } else {
                                 int_17 = int_20;
                              }
                           }

                           if (int_23 == 3) {
                              Deque deque_0 = Client.groundItemDeque[Ignore.plane][int_21][int_22];
                              if (deque_0 != null) {
                                 for (Item item_0 = (Item) deque_0.getTail(); item_0 != null; item_0 = (Item) deque_0.getPrevious()) {
                                    ItemDefinition itemcomposition_1 = ItemDefinition.getDefinition(item_0.id);
                                    if (Client.itemSelectionState == 1) {
                                       Class24.addMenuEntry("Use", Client.selectedItemName + " " + "->" + " " + Wall.getColTags(16748608) + itemcomposition_1.name, 16, item_0.id, int_21, int_22);
                                    } else if (Client.spellSelected) {
                                       if ((Enum4.anInt381 & 0x1) == 1) {
                                          Class24.addMenuEntry(Client.aString34, Client.aString36 + " " + "->" + " " + Wall.getColTags(16748608) + itemcomposition_1.name, 17, item_0.id, int_21, int_22);
                                       }
                                    } else {
                                       String[] strings_2 = itemcomposition_1.groundOptions;
                                       if (Client.aBool99) {
                                          strings_2 = Friend.method537(strings_2);
                                       }

                                       for (int_27 = 4; int_27 >= 0; --int_27) {
                                          if (strings_2 != null && strings_2[int_27] != null) {
                                             byte byte_1 = 0;
                                             if (int_27 == 0) {
                                                byte_1 = 18;
                                             }

                                             if (int_27 == 1) {
                                                byte_1 = 19;
                                             }

                                             if (int_27 == 2) {
                                                byte_1 = 20;
                                             }

                                             if (int_27 == 3) {
                                                byte_1 = 21;
                                             }

                                             if (int_27 == 4) {
                                                byte_1 = 22;
                                             }

                                             Class24.addMenuEntry(strings_2[int_27], Wall.getColTags(16748608) + itemcomposition_1.name, byte_1, item_0.id, int_21, int_22);
                                          } else if (int_27 == 2) {
                                             Class24.addMenuEntry("Take", Wall.getColTags(16748608) + itemcomposition_1.name, 20, item_0.id, int_21, int_22);
                                          }
                                       }

                                       Class24.addMenuEntry("Examine", Wall.getColTags(16748608) + itemcomposition_1.name, 1004, item_0.id, int_21, int_22);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if (int_17 != -1) {
                        int_19 = int_17 & 0x7F;
                        int_20 = int_17 >> 7 & 0x7F;
                        Player player_1 = Client.players[Client.someSelectedPlayerIndex];
                        Class29.method235(player_1, Client.someSelectedPlayerIndex, int_19, int_20);
                     }
                  }
               } else if (widget_0.contentType == 1338) {
                  if ((Client.anInt650 == 0 || Client.anInt650 == 3) && (MouseInput.anInt259 == 1 || !Item.aBool73 && MouseInput.anInt259 == 4)) {
                     CachedSprite cacheablenode_sub1_0 = widget_0.method591(true);
                     if (cacheablenode_sub1_0 != null) {
                        int_18 = MouseInput.anInt264 - int_8;
                        int_19 = MouseInput.anInt265 - int_9;
                        if (cacheablenode_sub1_0.indexIsInside(int_18, int_19)) {
                           int_18 -= cacheablenode_sub1_0.width / 2;
                           int_19 -= cacheablenode_sub1_0.height / 2;
                           int_20 = Client.mapAngle & 0x7FF;
                           int_21 = Rasterizer3D.SINE[int_20];
                           int_22 = Rasterizer3D.COSINE[int_20];
                           int_23 = int_22 * int_18 + int_19 * int_21 >> 11;
                           int_24 = int_19 * int_22 - int_18 * int_21 >> 11;
                           int int_30 = int_23 + Class4.localPlayer.x >> 7;
                           int_25 = Class4.localPlayer.y - int_24 >> 7;
                           PacketNode packetnode_0 = Actor.method953(ClientPacket.aClientPacket85, Client.aClass46_1.cipher);
                           packetnode_0.packetBuffer.putByte(18);
                           packetnode_0.packetBuffer.putShortS(int_25 + Client.regionBaseY);
                           packetnode_0.packetBuffer.putShortS(int_30 + Client.regionBaseX);
                           packetnode_0.packetBuffer.putByteA(KeyFocusListener.aBoolArray3[82] ? (KeyFocusListener.aBoolArray3[81] ? 2 : 1) : 0);
                           packetnode_0.packetBuffer.putByte(int_18);
                           packetnode_0.packetBuffer.putByte(int_19);
                           packetnode_0.packetBuffer.putShort(Client.mapAngle);
                           packetnode_0.packetBuffer.putByte(57);
                           packetnode_0.packetBuffer.putByte(0);
                           packetnode_0.packetBuffer.putByte(0);
                           packetnode_0.packetBuffer.putByte(89);
                           packetnode_0.packetBuffer.putShort(Class4.localPlayer.x);
                           packetnode_0.packetBuffer.putShort(Class4.localPlayer.y);
                           packetnode_0.packetBuffer.putByte(63);
                           Client.aClass46_1.method282(packetnode_0);
                           Client.destinationX = int_30;
                           Client.destinationY = int_25;
                        }
                     }
                  }
               } else {
                  if (widget_0.contentType == 1400) {
                     Client.renderOverview.method38(MouseInput.mouseEventX, MouseInput.mouseEventY, bool_2, int_8, int_9, widget_0.width, widget_0.height);
                  }

                  if (!Client.isMenuOpen && bool_2) {
                     if (widget_0.contentType == 1400) {
                        Client.renderOverview.method39(int_8, int_9, widget_0.width, widget_0.height, int_14, int_15);
                     } else {
                        int_17 = int_14 - int_8;
                        int_18 = int_15 - int_9;
                        if (widget_0.actionType == 1) {
                           Class24.addMenuEntry(widget_0.tooltip, "", 24, 0, 0, widget_0.id);
                        }

                        String string_0;
                        if (widget_0.actionType == 2 && !Client.spellSelected) {
                           if (GraphicsObject.method957(Preferences.getWidgetConfig(widget_0)) == 0) {
                              string_0 = null;
                           } else if (widget_0.selectedAction != null && widget_0.selectedAction.trim().length() != 0) {
                              string_0 = widget_0.selectedAction;
                           } else {
                              string_0 = null;
                           }

                           if (string_0 != null) {
                              Class24.addMenuEntry(string_0, Wall.getColTags(65280) + widget_0.spellName, 25, 0, -1, widget_0.id);
                           }
                        }

                        if (widget_0.actionType == 3) {
                           Class24.addMenuEntry("Close", "", 26, 0, 0, widget_0.id);
                        }

                        if (widget_0.actionType == 4) {
                           Class24.addMenuEntry(widget_0.tooltip, "", 28, 0, 0, widget_0.id);
                        }

                        if (widget_0.actionType == 5) {
                           Class24.addMenuEntry(widget_0.tooltip, "", 29, 0, 0, widget_0.id);
                        }

                        if (widget_0.actionType == 6 && Client.aWidget12 == null) {
                           Class24.addMenuEntry(widget_0.tooltip, "", 30, 0, -1, widget_0.id);
                        }

                        if (widget_0.type == 2) {
                           int_19 = 0;

                           for (int_20 = 0; int_20 < widget_0.height; int_20++) {
                              for (int_21 = 0; int_21 < widget_0.width; int_21++) {
                                 int_22 = int_21 * (widget_0.paddingX + 32);
                                 int_23 = int_20 * (widget_0.paddingY + 32);
                                 if (int_19 < 20) {
                                    int_22 += widget_0.imageX[int_19];
                                    int_23 += widget_0.imageY[int_19];
                                 }

                                 if (int_17 >= int_22 && int_18 >= int_23 && int_17 < int_22 + 32 && int_18 < int_23 + 32) {
                                    Client.anInt693 = int_19;
                                    Class52.aWidget2 = widget_0;
                                    if (widget_0.itemIds[int_19] > 0) {
                                       label1900: {
                                          ItemDefinition itemcomposition_0 = ItemDefinition.getDefinition(widget_0.itemIds[int_19] - 1);
                                          boolean bool_0;
                                          if (Client.itemSelectionState == 1) {
                                             int_25 = Preferences.getWidgetConfig(widget_0);
                                             bool_0 = (int_25 >> 30 & 0x1) != 0;
                                             if (bool_0) {
                                                if (widget_0.id != Class48.anInt111 || int_19 != GameEngine.selectedItemIndex) {
                                                   Class24.addMenuEntry("Use", Client.selectedItemName + " " + "->" + " " + Wall.getColTags(16748608) + itemcomposition_0.name, 31, itemcomposition_0.id, int_19, widget_0.id);
                                                }
                                                break label1900;
                                             }
                                          }

                                          if (Client.spellSelected) {
                                             int_25 = Preferences.getWidgetConfig(widget_0);
                                             bool_0 = (int_25 >> 30 & 0x1) != 0;
                                             if (bool_0) {
                                                if ((Enum4.anInt381 & 0x10) == 16) {
                                                   Class24.addMenuEntry(Client.aString34, Client.aString36 + " " + "->" + " " + Wall.getColTags(16748608) + itemcomposition_0.name, 32, itemcomposition_0.id, int_19, widget_0.id);
                                                }
                                                break label1900;
                                             }
                                          }

                                          String[] strings_0 = itemcomposition_0.inventoryOptions;
                                          if (Client.aBool99) {
                                             strings_0 = Friend.method537(strings_0);
                                          }

                                          int_25 = -1;
                                          if (Client.aBool97 && KeyFocusListener.aBoolArray3[81]) {
                                             int_25 = itemcomposition_0.method943();
                                          }

                                          int_26 = Preferences.getWidgetConfig(widget_0);
                                          boolean bool_1 = (int_26 >> 30 & 0x1) != 0;
                                          if (bool_1) {
                                             for (int_27 = 4; int_27 >= 3; --int_27) {
                                                if (int_27 != int_25) {
                                                   Class10.method156(widget_0, itemcomposition_0, int_19, int_27, false);
                                                }
                                             }
                                          }

                                          Object object_0 = null;
                                          if (Timer.method589(Preferences.getWidgetConfig(widget_0))) {
                                             Class24.addMenuEntry("Use", Wall.getColTags(16748608) + itemcomposition_0.name, 38, itemcomposition_0.id, int_19, widget_0.id);
                                          }

                                          int int_28 = Preferences.getWidgetConfig(widget_0);
                                          boolean bool_6 = (int_28 >> 30 & 0x1) != 0;
                                          int int_29;
                                          if (bool_6) {
                                             for (int_29 = 2; int_29 >= 0; --int_29) {
                                                if (int_29 != int_25) {
                                                   Class10.method156(widget_0, itemcomposition_0, int_19, int_29, false);
                                                }
                                             }

                                             if (int_25 >= 0) {
                                                Class10.method156(widget_0, itemcomposition_0, int_19, int_25, true);
                                             }
                                          }

                                          strings_0 = widget_0.configActions;
                                          if (Client.aBool99) {
                                             strings_0 = Friend.method537(strings_0);
                                          }

                                          if (strings_0 != null) {
                                             for (int_29 = 4; int_29 >= 0; --int_29) {
                                                if (strings_0[int_29] != null) {
                                                   byte byte_0 = 0;
                                                   if (int_29 == 0) {
                                                      byte_0 = 39;
                                                   }

                                                   if (int_29 == 1) {
                                                      byte_0 = 40;
                                                   }

                                                   if (int_29 == 2) {
                                                      byte_0 = 41;
                                                   }

                                                   if (int_29 == 3) {
                                                      byte_0 = 42;
                                                   }

                                                   if (int_29 == 4) {
                                                      byte_0 = 43;
                                                   }

                                                   Class24.addMenuEntry(strings_0[int_29], Wall.getColTags(16748608) + itemcomposition_0.name, byte_0, itemcomposition_0.id, int_19, widget_0.id);
                                                }
                                             }
                                          }

                                          Class24.addMenuEntry("Examine", Wall.getColTags(16748608) + itemcomposition_0.name, 1005, itemcomposition_0.id, int_19, widget_0.id);
                                       }
                                    }
                                 }

                                 ++int_19;
                              }
                           }
                        }

                        if (widget_0.hasScript) {
                           if (Client.spellSelected) {
                              int_20 = Preferences.getWidgetConfig(widget_0);
                              boolean bool_5 = (int_20 >> 21 & 0x1) != 0;
                              if (bool_5 && (Enum4.anInt381 & 0x20) == 32) {
                                 Class24.addMenuEntry(Client.aString34, Client.aString36 + " " + "->" + " " + widget_0.name, 58, 0, widget_0.index, widget_0.id);
                              }
                           } else {
                              for (int_19 = 9; int_19 >= 5; --int_19) {
                                 String string_1;
                                 if (!Class51.method329(Preferences.getWidgetConfig(widget_0), int_19) && widget_0.anObjectArray10 == null) {
                                    string_1 = null;
                                 } else if (widget_0.actions != null && widget_0.actions.length > int_19 && widget_0.actions[int_19] != null && widget_0.actions[int_19].trim().length() != 0) {
                                    string_1 = widget_0.actions[int_19];
                                 } else {
                                    string_1 = null;
                                 }

                                 if (string_1 != null) {
                                    Class24.addMenuEntry(string_1, widget_0.name, 1007, int_19 + 1, widget_0.index, widget_0.id);
                                 }
                              }

                              string_0 = Timer.method588(widget_0);
                              if (string_0 != null) {
                                 Class24.addMenuEntry(string_0, widget_0.name, 25, 0, widget_0.index, widget_0.id);
                              }

                              for (int_20 = 4; int_20 >= 0; --int_20) {
                                 String string_2;
                                 if (!Class51.method329(Preferences.getWidgetConfig(widget_0), int_20) && widget_0.anObjectArray10 == null) {
                                    string_2 = null;
                                 } else if (widget_0.actions != null && widget_0.actions.length > int_20 && widget_0.actions[int_20] != null && widget_0.actions[int_20].trim().length() != 0) {
                                    string_2 = widget_0.actions[int_20];
                                 } else {
                                    string_2 = null;
                                 }

                                 if (string_2 != null) {
                                    Class24.addMenuEntry(string_2, widget_0.name, 57, int_20 + 1, widget_0.index, widget_0.id);
                                 }
                              }

                              if (ChatLineBuffer.method13(Preferences.getWidgetConfig(widget_0))) {
                                 Class24.addMenuEntry("Continue", "", 30, 0, widget_0.index, widget_0.id);
                              }
                           }
                        }
                     }
                  }

                  if (widget_0.type == 0) {
                     if (!widget_0.hasScript && CacheableNode_Sub5.method887(widget_0) && widget_0 != aWidget6) {
                        continue;
                     }

                     method675(widgets_0, widget_0.id, int_10, int_11, int_12, int_13, int_8 - widget_0.scrollX, int_9 - widget_0.scrollY);
                     if (widget_0.children != null) {
                        method675(widget_0.children, widget_0.id, int_10, int_11, int_12, int_13, int_8 - widget_0.scrollX, int_9 - widget_0.scrollY);
                     }

                     WidgetNode widgetnode_0 = (WidgetNode) Client.widgetNodeTable.get((long)widget_0.id);
                     if (widgetnode_0 != null) {
                        if (widgetnode_0.owner == 0 && MouseInput.mouseEventX >= int_10 && MouseInput.mouseEventY >= int_11 && MouseInput.mouseEventX < int_12 && MouseInput.mouseEventY < int_13 && !Client.isMenuOpen && !Client.aBool89) {
                           for (ScriptEvent scriptevent_0 = (ScriptEvent) Client.aDeque7.getFront(); scriptevent_0 != null; scriptevent_0 = (ScriptEvent) Client.aDeque7.getNext()) {
                              if (scriptevent_0.aBool56) {
                                 scriptevent_0.unlink();
                                 scriptevent_0.widget.aBool42 = false;
                              }
                           }

                           if (ScriptVarType.anInt175 == 0) {
                              Client.aWidget9 = null;
                              Client.aWidget10 = null;
                           }

                           if (!Client.isMenuOpen) {
                              Class9.method147();
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.aBoolArray9[0] = false;
                              Client.menuOptionCount = 1;
                           }
                        }

                        GameEngine.method1092(widgetnode_0.id, int_10, int_11, int_12, int_13, int_8, int_9);
                     }
                  }

                  if (widget_0.hasScript) {
                     ScriptEvent scriptevent_2;
                     if (!widget_0.aBool38) {
                        if (widget_0.aBool44 && MouseInput.mouseEventX >= int_10 && MouseInput.mouseEventY >= int_11 && MouseInput.mouseEventX < int_12 && MouseInput.mouseEventY < int_13) {
                           for (scriptevent_2 = (ScriptEvent) Client.aDeque7.getFront(); scriptevent_2 != null; scriptevent_2 = (ScriptEvent) Client.aDeque7.getNext()) {
                              if (scriptevent_2.aBool56 && scriptevent_2.widget.scrollListener == scriptevent_2.anObjectArray22) {
                                 scriptevent_2.unlink();
                              }
                           }
                        }
                     } else if (MouseInput.mouseEventX >= int_10 && MouseInput.mouseEventY >= int_11 && MouseInput.mouseEventX < int_12 && MouseInput.mouseEventY < int_13) {
                        for (scriptevent_2 = (ScriptEvent) Client.aDeque7.getFront(); scriptevent_2 != null; scriptevent_2 = (ScriptEvent) Client.aDeque7.getNext()) {
                           if (scriptevent_2.aBool56) {
                              scriptevent_2.unlink();
                              scriptevent_2.widget.aBool42 = false;
                           }
                        }

                        if (ScriptVarType.anInt175 == 0) {
                           Client.aWidget9 = null;
                           Client.aWidget10 = null;
                        }

                        if (!Client.isMenuOpen) {
                           Class9.method147();
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.aBoolArray9[0] = false;
                           Client.menuOptionCount = 1;
                        }
                     }

                     if (MouseInput.mouseEventX >= int_10 && MouseInput.mouseEventY >= int_11 && MouseInput.mouseEventX < int_12 && MouseInput.mouseEventY < int_13) {
                        bool_2 = true;
                     } else {
                        bool_2 = false;
                     }

                     boolean bool_4 = false;
                     if ((MouseInput.anInt263 == 1 || !Item.aBool73 && MouseInput.anInt263 == 4) && bool_2) {
                        bool_4 = true;
                     }

                     boolean bool_3 = false;
                     if ((MouseInput.anInt259 == 1 || !Item.aBool73 && MouseInput.anInt259 == 4) && MouseInput.anInt264 >= int_10 && MouseInput.anInt265 >= int_11 && MouseInput.anInt264 < int_12 && MouseInput.anInt265 < int_13) {
                        bool_3 = true;
                     }

                     if (bool_3) {
                        Tile.method683(widget_0, MouseInput.anInt264 - int_8, MouseInput.anInt265 - int_9);
                     }

                     if (widget_0.contentType == 1400) {
                        Client.renderOverview.method42(MouseInput.mouseEventX, MouseInput.mouseEventY, bool_2 & bool_4, bool_2 & bool_3);
                     }

                     if (Client.aWidget9 != null && widget_0 != Client.aWidget9 && bool_2 && FrameMap.method691(Preferences.getWidgetConfig(widget_0))) {
                        Client.aWidget13 = widget_0;
                     }

                     if (widget_0 == Client.aWidget10) {
                        Client.aBool86 = true;
                        Client.anInt621 = int_8;
                        Client.anInt626 = int_9;
                     }

                     if (widget_0.parametersLoaded) {
                        ScriptEvent scriptevent_3;
                        if (bool_2 && Client.anInt636 != 0 && widget_0.scrollListener != null) {
                           scriptevent_3 = new ScriptEvent();
                           scriptevent_3.aBool56 = true;
                           scriptevent_3.widget = widget_0;
                           scriptevent_3.anInt394 = Client.anInt636;
                           scriptevent_3.anObjectArray22 = widget_0.scrollListener;
                           Client.aDeque7.addFront(scriptevent_3);
                        }

                        if (Client.aWidget9 != null || ClanMember.aWidget7 != null || Client.isMenuOpen) {
                           bool_3 = false;
                           bool_4 = false;
                           bool_2 = false;
                        }

                        if (!widget_0.aBool43 && bool_3) {
                           widget_0.aBool43 = true;
                           if (widget_0.anObjectArray11 != null) {
                              scriptevent_3 = new ScriptEvent();
                              scriptevent_3.aBool56 = true;
                              scriptevent_3.widget = widget_0;
                              scriptevent_3.anInt393 = MouseInput.anInt264 - int_8;
                              scriptevent_3.anInt394 = MouseInput.anInt265 - int_9;
                              scriptevent_3.anObjectArray22 = widget_0.anObjectArray11;
                              Client.aDeque7.addFront(scriptevent_3);
                           }
                        }

                        if (widget_0.aBool43 && bool_4 && widget_0.anObjectArray14 != null) {
                           scriptevent_3 = new ScriptEvent();
                           scriptevent_3.aBool56 = true;
                           scriptevent_3.widget = widget_0;
                           scriptevent_3.anInt393 = MouseInput.mouseEventX - int_8;
                           scriptevent_3.anInt394 = MouseInput.mouseEventY - int_9;
                           scriptevent_3.anObjectArray22 = widget_0.anObjectArray14;
                           Client.aDeque7.addFront(scriptevent_3);
                        }

                        if (widget_0.aBool43 && !bool_4) {
                           widget_0.aBool43 = false;
                           if (widget_0.anObjectArray13 != null) {
                              scriptevent_3 = new ScriptEvent();
                              scriptevent_3.aBool56 = true;
                              scriptevent_3.widget = widget_0;
                              scriptevent_3.anInt393 = MouseInput.mouseEventX - int_8;
                              scriptevent_3.anInt394 = MouseInput.mouseEventY - int_9;
                              scriptevent_3.anObjectArray22 = widget_0.anObjectArray13;
                              Client.aDeque9.addFront(scriptevent_3);
                           }
                        }

                        if (bool_4 && widget_0.anObjectArray12 != null) {
                           scriptevent_3 = new ScriptEvent();
                           scriptevent_3.aBool56 = true;
                           scriptevent_3.widget = widget_0;
                           scriptevent_3.anInt393 = MouseInput.mouseEventX - int_8;
                           scriptevent_3.anInt394 = MouseInput.mouseEventY - int_9;
                           scriptevent_3.anObjectArray22 = widget_0.anObjectArray12;
                           Client.aDeque7.addFront(scriptevent_3);
                        }

                        if (!widget_0.aBool42 && bool_2) {
                           widget_0.aBool42 = true;
                           if (widget_0.mouseEnterListener != null) {
                              scriptevent_3 = new ScriptEvent();
                              scriptevent_3.aBool56 = true;
                              scriptevent_3.widget = widget_0;
                              scriptevent_3.anInt393 = MouseInput.mouseEventX - int_8;
                              scriptevent_3.anInt394 = MouseInput.mouseEventY - int_9;
                              scriptevent_3.anObjectArray22 = widget_0.mouseEnterListener;
                              Client.aDeque7.addFront(scriptevent_3);
                           }
                        }

                        if (widget_0.aBool42 && bool_2 && widget_0.mouseHoverListener != null) {
                           scriptevent_3 = new ScriptEvent();
                           scriptevent_3.aBool56 = true;
                           scriptevent_3.widget = widget_0;
                           scriptevent_3.anInt393 = MouseInput.mouseEventX - int_8;
                           scriptevent_3.anInt394 = MouseInput.mouseEventY - int_9;
                           scriptevent_3.anObjectArray22 = widget_0.mouseHoverListener;
                           Client.aDeque7.addFront(scriptevent_3);
                        }

                        if (widget_0.aBool42 && !bool_2) {
                           widget_0.aBool42 = false;
                           if (widget_0.mouseExitListener != null) {
                              scriptevent_3 = new ScriptEvent();
                              scriptevent_3.aBool56 = true;
                              scriptevent_3.widget = widget_0;
                              scriptevent_3.anInt393 = MouseInput.mouseEventX - int_8;
                              scriptevent_3.anInt394 = MouseInput.mouseEventY - int_9;
                              scriptevent_3.anObjectArray22 = widget_0.mouseExitListener;
                              Client.aDeque9.addFront(scriptevent_3);
                           }
                        }

                        if (widget_0.renderListener != null) {
                           scriptevent_3 = new ScriptEvent();
                           scriptevent_3.widget = widget_0;
                           scriptevent_3.anObjectArray22 = widget_0.renderListener;
                           Client.aDeque8.addFront(scriptevent_3);
                        }

                        ScriptEvent scriptevent_1;
                        if (widget_0.configListenerArgs != null && Client.anInt649 > widget_0.anInt298) {
                           if (widget_0.configTriggers != null && Client.anInt649 - widget_0.anInt298 <= 32) {
                              label1534:
                              for (int_19 = widget_0.anInt298; int_19 < Client.anInt649; int_19++) {
                                 int_20 = Client.anIntArray151[int_19 & 0x1F];

                                 for (int_21 = 0; int_21 < widget_0.configTriggers.length; int_21++) {
                                    if (int_20 == widget_0.configTriggers[int_21]) {
                                       scriptevent_1 = new ScriptEvent();
                                       scriptevent_1.widget = widget_0;
                                       scriptevent_1.anObjectArray22 = widget_0.configListenerArgs;
                                       Client.aDeque7.addFront(scriptevent_1);
                                       break label1534;
                                    }
                                 }
                              }
                           } else {
                              scriptevent_3 = new ScriptEvent();
                              scriptevent_3.widget = widget_0;
                              scriptevent_3.anObjectArray22 = widget_0.configListenerArgs;
                              Client.aDeque7.addFront(scriptevent_3);
                           }

                           widget_0.anInt298 = Client.anInt649;
                        }

                        if (widget_0.tableListenerArgs != null && Client.anInt663 > widget_0.anInt299) {
                           if (widget_0.tableModTriggers != null && Client.anInt663 - widget_0.anInt299 <= 32) {
                              label1510:
                              for (int_19 = widget_0.anInt299; int_19 < Client.anInt663; int_19++) {
                                 int_20 = Client.interfaceItemTriggers[int_19 & 0x1F];

                                 for (int_21 = 0; int_21 < widget_0.tableModTriggers.length; int_21++) {
                                    if (int_20 == widget_0.tableModTriggers[int_21]) {
                                       scriptevent_1 = new ScriptEvent();
                                       scriptevent_1.widget = widget_0;
                                       scriptevent_1.anObjectArray22 = widget_0.tableListenerArgs;
                                       Client.aDeque7.addFront(scriptevent_1);
                                       break label1510;
                                    }
                                 }
                              }
                           } else {
                              scriptevent_3 = new ScriptEvent();
                              scriptevent_3.widget = widget_0;
                              scriptevent_3.anObjectArray22 = widget_0.tableListenerArgs;
                              Client.aDeque7.addFront(scriptevent_3);
                           }

                           widget_0.anInt299 = Client.anInt663;
                        }

                        if (widget_0.skillListenerArgs != null && Client.anInt659 > widget_0.anInt300) {
                           if (widget_0.skillTriggers != null && Client.anInt659 - widget_0.anInt300 <= 32) {
                              label1486:
                              for (int_19 = widget_0.anInt300; int_19 < Client.anInt659; int_19++) {
                                 int_20 = Client.anIntArray154[int_19 & 0x1F];

                                 for (int_21 = 0; int_21 < widget_0.skillTriggers.length; int_21++) {
                                    if (int_20 == widget_0.skillTriggers[int_21]) {
                                       scriptevent_1 = new ScriptEvent();
                                       scriptevent_1.widget = widget_0;
                                       scriptevent_1.anObjectArray22 = widget_0.skillListenerArgs;
                                       Client.aDeque7.addFront(scriptevent_1);
                                       break label1486;
                                    }
                                 }
                              }
                           } else {
                              scriptevent_3 = new ScriptEvent();
                              scriptevent_3.widget = widget_0;
                              scriptevent_3.anObjectArray22 = widget_0.skillListenerArgs;
                              Client.aDeque7.addFront(scriptevent_3);
                           }

                           widget_0.anInt300 = Client.anInt659;
                        }

                        if (Client.chatCycle > widget_0.anInt297 && widget_0.anObjectArray15 != null) {
                           scriptevent_3 = new ScriptEvent();
                           scriptevent_3.widget = widget_0;
                           scriptevent_3.anObjectArray22 = widget_0.anObjectArray15;
                           Client.aDeque7.addFront(scriptevent_3);
                        }

                        if (Client.anInt658 > widget_0.anInt297 && widget_0.anObjectArray17 != null) {
                           scriptevent_3 = new ScriptEvent();
                           scriptevent_3.widget = widget_0;
                           scriptevent_3.anObjectArray22 = widget_0.anObjectArray17;
                           Client.aDeque7.addFront(scriptevent_3);
                        }

                        if (Client.anInt697 > widget_0.anInt297 && widget_0.anObjectArray18 != null) {
                           scriptevent_3 = new ScriptEvent();
                           scriptevent_3.widget = widget_0;
                           scriptevent_3.anObjectArray22 = widget_0.anObjectArray18;
                           Client.aDeque7.addFront(scriptevent_3);
                        }

                        if (Client.anInt669 > widget_0.anInt297 && widget_0.anObjectArray20 != null) {
                           scriptevent_3 = new ScriptEvent();
                           scriptevent_3.widget = widget_0;
                           scriptevent_3.anObjectArray22 = widget_0.anObjectArray20;
                           Client.aDeque7.addFront(scriptevent_3);
                        }

                        if (Client.anInt695 > widget_0.anInt297 && widget_0.anObjectArray21 != null) {
                           scriptevent_3 = new ScriptEvent();
                           scriptevent_3.widget = widget_0;
                           scriptevent_3.anObjectArray22 = widget_0.anObjectArray21;
                           Client.aDeque7.addFront(scriptevent_3);
                        }

                        if (Client.anInt640 > widget_0.anInt297 && widget_0.anObjectArray19 != null) {
                           scriptevent_3 = new ScriptEvent();
                           scriptevent_3.widget = widget_0;
                           scriptevent_3.anObjectArray22 = widget_0.anObjectArray19;
                           Client.aDeque7.addFront(scriptevent_3);
                        }

                        widget_0.anInt297 = Client.cycleCntr;
                        if (widget_0.anObjectArray16 != null) {
                           for (int_19 = 0; int_19 < Client.anInt689; int_19++) {
                              ScriptEvent scriptevent_4 = new ScriptEvent();
                              scriptevent_4.widget = widget_0;
                              scriptevent_4.anInt397 = Client.anIntArray164[int_19];
                              scriptevent_4.anInt398 = Client.anIntArray166[int_19];
                              scriptevent_4.anObjectArray22 = widget_0.anObjectArray16;
                              Client.aDeque7.addFront(scriptevent_4);
                           }
                        }
                     }
                  }

                  if (!widget_0.hasScript && Client.aWidget9 == null && ClanMember.aWidget7 == null && !Client.isMenuOpen) {
                     if ((widget_0.anInt282 >= 0 || widget_0.disabledHoverColour != 0) && MouseInput.mouseEventX >= int_10 && MouseInput.mouseEventY >= int_11 && MouseInput.mouseEventX < int_12 && MouseInput.mouseEventY < int_13) {
                        if (widget_0.anInt282 >= 0) {
                           aWidget6 = widgets_0[widget_0.anInt282];
                        } else {
                           aWidget6 = widget_0;
                        }
                     }

                     if (widget_0.type == 8 && MouseInput.mouseEventX >= int_10 && MouseInput.mouseEventY >= int_11 && MouseInput.mouseEventX < int_12 && MouseInput.mouseEventY < int_13) {
                        Class47.aWidget1 = widget_0;
                     }

                     if (widget_0.scrollHeight > widget_0.height) {
                        int_17 = int_8 + widget_0.width;
                        int_18 = widget_0.height;
                        int_19 = widget_0.scrollHeight;
                        int_20 = MouseInput.mouseEventX;
                        int_21 = MouseInput.mouseEventY;
                        if (Client.aBool96) {
                           Client.anInt677 = 32;
                        } else {
                           Client.anInt677 = 0;
                        }

                        Client.aBool96 = false;
                        if (MouseInput.anInt263 == 1 || !Item.aBool73 && MouseInput.anInt263 == 4) {
                           if (int_20 >= int_17 && int_20 < int_17 + 16 && int_21 >= int_9 && int_21 < int_9 + 16) {
                              widget_0.scrollY -= 4;
                              WorldMapData.method305(widget_0);
                           } else if (int_20 >= int_17 && int_20 < int_17 + 16 && int_21 >= int_9 + int_18 - 16 && int_21 < int_9 + int_18) {
                              widget_0.scrollY += 4;
                              WorldMapData.method305(widget_0);
                           } else if (int_20 >= int_17 - Client.anInt677 && int_20 < int_17 + Client.anInt677 + 16 && int_21 >= int_9 + 16 && int_21 < int_18 + int_9 - 16) {
                              int_22 = int_18 * (int_18 - 32) / int_19;
                              if (int_22 < 8) {
                                 int_22 = 8;
                              }

                              int_23 = int_21 - int_9 - 16 - int_22 / 2;
                              int_24 = int_18 - 32 - int_22;
                              widget_0.scrollY = int_23 * (int_19 - int_18) / int_24;
                              WorldMapData.method305(widget_0);
                              Client.aBool96 = true;
                           }
                        }

                        if (Client.anInt636 != 0) {
                           int_22 = widget_0.width;
                           if (int_20 >= int_17 - int_22 && int_21 >= int_9 && int_20 < int_17 + 16 && int_21 <= int_9 + int_18) {
                              widget_0.scrollY += Client.anInt636 * 45;
                              WorldMapData.method305(widget_0);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

}
