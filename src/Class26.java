public class Class26 {

   public static final Class26 aClass26_1;
   public static final Class26 aClass26_2;
   public static short[] aShortArray2;
   static int anInt87;
   static int anInt88;

   static {
      aClass26_1 = new Class26();
      aClass26_2 = new Class26();
   }

   public static PacketNode method222() {
      return PacketNode.anInt348 == 0 ? new PacketNode() : PacketNode.aPacketNodeArray1[--PacketNode.anInt348];
   }

   static void method223(Widget widget_0, int int_0, int int_1, int int_2) {
      Enum2.method642();
      CachedSprite cacheablenode_sub1_0 = widget_0.method591(false);
      if (cacheablenode_sub1_0 != null) {
         Rasterizer2D.setDrawRegion(int_0, int_1, cacheablenode_sub1_0.width + int_0, int_1 + cacheablenode_sub1_0.height);
         if (Client.anInt650 != 2 && Client.anInt650 != 5) {
            int int_3 = Client.mapAngle & 0x7FF;
            int int_4 = Class4.localPlayer.x / 32 + 48;
            int int_5 = 464 - Class4.localPlayer.y / 32;
            Class15.aSpritePixels3.rotate(int_0, int_1, cacheablenode_sub1_0.width, cacheablenode_sub1_0.height, int_4, int_5, int_3, 256, cacheablenode_sub1_0.pixelsX, cacheablenode_sub1_0.pixelsY);

            int int_6;
            int int_7;
            int int_8;
            for (int_6 = 0; int_6 < Client.anInt660; int_6++) {
               int_7 = Client.anIntArray155[int_6] * 4 + 2 - Class4.localPlayer.x / 32;
               int_8 = Client.anIntArray156[int_6] * 4 + 2 - Class4.localPlayer.y / 32;
               Class23.drawDot(int_0, int_1, int_7, int_8, Client.mapIcons[int_6], cacheablenode_sub1_0);
            }

            int int_9;
            int int_10;
            for (int_6 = 0; int_6 < 104; int_6++) {
               for (int_7 = 0; int_7 < 104; int_7++) {
                  Deque deque_0 = Client.groundItemDeque[Ignore.plane][int_6][int_7];
                  if (deque_0 != null) {
                     int_9 = int_6 * 4 + 2 - Class4.localPlayer.x / 32;
                     int_10 = int_7 * 4 + 2 - Class4.localPlayer.y / 32;
                     Class23.drawDot(int_0, int_1, int_9, int_10, AClass3_Sub1.mapDots[0], cacheablenode_sub1_0);
                  }
               }
            }

            for (int_6 = 0; int_6 < Client.npcIndexesCount; int_6++) {
               NPC npc_0 = Client.cachedNPCs[Client.npcIndices[int_6]];
               if (npc_0 != null && npc_0.hasConfig()) {
                  NPCDefinition npccomposition_0 = npc_0.composition;
                  if (npccomposition_0 != null && npccomposition_0.transformIds != null) {
                     npccomposition_0 = npccomposition_0.transform();
                  }

                  if (npccomposition_0 != null && npccomposition_0.isMinimapVisible && npccomposition_0.aBool66) {
                     int_9 = npc_0.x / 32 - Class4.localPlayer.x / 32;
                     int_10 = npc_0.y / 32 - Class4.localPlayer.y / 32;
                     Class23.drawDot(int_0, int_1, int_9, int_10, AClass3_Sub1.mapDots[1], cacheablenode_sub1_0);
                  }
               }
            }

            int_6 = Class27.localPlayerIndexCount;
            int[] ints_0 = Class27.localPlayerIndices;

            for (int_8 = 0; int_8 < int_6; int_8++) {
               Player player_0 = Client.players[ints_0[int_8]];
               if (player_0 != null && player_0.hasConfig() && !player_0.hidden && player_0 != Class4.localPlayer) {
                  int_10 = player_0.x / 32 - Class4.localPlayer.x / 32;
                  int int_11 = player_0.y / 32 - Class4.localPlayer.y / 32;
                  boolean bool_0 = false;
                  if (Client.isFriended(player_0.name, true)) {
                     bool_0 = true;
                  }

                  boolean bool_1 = false;

                  for (int int_12 = 0; int_12 < Client.clanChatCount; int_12++) {
                     if (player_0.name.equals(Class20.clanMembers[int_12].username)) {
                        bool_1 = true;
                        break;
                     }
                  }

                  boolean bool_2 = false;
                  if (Class4.localPlayer.team != 0 && player_0.team != 0 && player_0.team == Class4.localPlayer.team) {
                     bool_2 = true;
                  }

                  if (bool_0) {
                     Class23.drawDot(int_0, int_1, int_10, int_11, AClass3_Sub1.mapDots[3], cacheablenode_sub1_0);
                  } else if (bool_2) {
                     Class23.drawDot(int_0, int_1, int_10, int_11, AClass3_Sub1.mapDots[4], cacheablenode_sub1_0);
                  } else if (bool_1) {
                     Class23.drawDot(int_0, int_1, int_10, int_11, AClass3_Sub1.mapDots[5], cacheablenode_sub1_0);
                  } else {
                     Class23.drawDot(int_0, int_1, int_10, int_11, AClass3_Sub1.mapDots[2], cacheablenode_sub1_0);
                  }
               }
            }

            if (Client.hintArrowTargetType != 0 && Client.gameCycle % 20 < 10) {
               if (Client.hintArrowTargetType == 1 && Client.hintArrowNpcTargetIdx >= 0 && Client.hintArrowNpcTargetIdx < Client.cachedNPCs.length) {
                  NPC npc_1 = Client.cachedNPCs[Client.hintArrowNpcTargetIdx];
                  if (npc_1 != null) {
                     int_9 = npc_1.x / 32 - Class4.localPlayer.x / 32;
                     int_10 = npc_1.y / 32 - Class4.localPlayer.y / 32;
                     Script.method910(int_0, int_1, int_9, int_10, Ignore.mapMarkers[1], cacheablenode_sub1_0);
                  }
               }

               if (Client.hintArrowTargetType == 2) {
                  int_8 = Client.hintArrowX * 4 - Client.regionBaseX * 4 + 2 - Class4.localPlayer.x / 32;
                  int_9 = Client.hintArrowY * 4 - Client.regionBaseY * 4 + 2 - Class4.localPlayer.y / 32;
                  Script.method910(int_0, int_1, int_8, int_9, Ignore.mapMarkers[1], cacheablenode_sub1_0);
               }

               if (Client.hintArrowTargetType == 10 && Client.hintArrowPlayerTargetIdx >= 0 && Client.hintArrowPlayerTargetIdx < Client.players.length) {
                  Player player_1 = Client.players[Client.hintArrowPlayerTargetIdx];
                  if (player_1 != null) {
                     int_9 = player_1.x / 32 - Class4.localPlayer.x / 32;
                     int_10 = player_1.y / 32 - Class4.localPlayer.y / 32;
                     Script.method910(int_0, int_1, int_9, int_10, Ignore.mapMarkers[1], cacheablenode_sub1_0);
                  }
               }
            }

            if (Client.destinationX != 0) {
               int_8 = Client.destinationX * 4 + 2 - Class4.localPlayer.x / 32;
               int_9 = Client.destinationY * 4 + 2 - Class4.localPlayer.y / 32;
               Class23.drawDot(int_0, int_1, int_8, int_9, Ignore.mapMarkers[0], cacheablenode_sub1_0);
            }

            if (!Class4.localPlayer.hidden) {
               Rasterizer2D.fillRect(cacheablenode_sub1_0.width / 2 + int_0 - 1, cacheablenode_sub1_0.height / 2 + int_1 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method926(int_0, int_1, 0, cacheablenode_sub1_0.pixelsX, cacheablenode_sub1_0.pixelsY);
         }

         Client.aBoolArray11[int_2] = true;
      }
   }

   static void method224(Actor actor_0, int int_0, int int_1, int int_2, int int_3, int int_4) {
      if (actor_0 != null && actor_0.hasConfig()) {
         if (actor_0 instanceof NPC) {
            NPCDefinition npccomposition_0 = ((NPC) actor_0).composition;
            if (npccomposition_0.transformIds != null) {
               npccomposition_0 = npccomposition_0.transform();
            }

            if (npccomposition_0 == null) {
               return;
            }
         }

         int int_5 = Class27.localPlayerIndexCount;
         int[] ints_0 = Class27.localPlayerIndices;
         int int_6 = 3;
         int int_8;
         int int_13;
         int int_14;
         if (!actor_0.combatInfoList.method452()) {
            WorldMapData.characterToScreen(actor_0, actor_0.anInt521 + 15);

            for (CombatInfoListHolder combatinfolistholder_0 = (CombatInfoListHolder) actor_0.combatInfoList.method454(); combatinfolistholder_0 != null; combatinfolistholder_0 = (CombatInfoListHolder) actor_0.combatInfoList.method456()) {
               CombatInfo1 combatinfo1_0 = combatinfolistholder_0.method649(Client.gameCycle);
               if (combatinfo1_0 == null) {
                  if (combatinfolistholder_0.method650()) {
                     combatinfolistholder_0.unlink();
                  }
               } else {
                  CombatInfo2 combatinfo2_0 = combatinfolistholder_0.combatInfo2;
                  SpritePixels spritepixels_0 = combatinfo2_0.method818();
                  SpritePixels spritepixels_1 = combatinfo2_0.method819();
                  int int_7 = 0;
                  if (spritepixels_0 != null && spritepixels_1 != null) {
                     if (combatinfo2_0.anInt460 * 2 < spritepixels_1.width) {
                        int_7 = combatinfo2_0.anInt460;
                     }

                     int_8 = spritepixels_1.width - int_7 * 2;
                  } else {
                     int_8 = combatinfo2_0.healthScale;
                  }

                  int int_9 = 255;
                  boolean bool_0 = true;
                  int int_10 = Client.gameCycle - combatinfo1_0.anInt352;
                  int int_11 = int_8 * combatinfo1_0.health / combatinfo2_0.healthScale;
                  int int_12;
                  int int_62;
                  if (combatinfo1_0.anInt353 > int_10) {
                     int_12 = combatinfo2_0.anInt458 == 0 ? 0 : combatinfo2_0.anInt458 * (int_10 / combatinfo2_0.anInt458);
                     int_13 = int_8 * combatinfo1_0.healthRatio / combatinfo2_0.healthScale;
                     int_62 = int_12 * (int_11 - int_13) / combatinfo1_0.anInt353 + int_13;
                  } else {
                     int_62 = int_11;
                     int_12 = combatinfo1_0.anInt353 + combatinfo2_0.anInt457 - int_10;
                     if (combatinfo2_0.anInt455 >= 0) {
                        int_9 = (int_12 << 8) / (combatinfo2_0.anInt457 - combatinfo2_0.anInt455);
                     }
                  }

                  if (combatinfo1_0.health > 0 && int_62 < 1) {
                     int_62 = 1;
                  }

                  int_12 = int_1 + Client.screenY - (int_8 >> 1);
                  int_13 = int_2 + Client.screenX - int_6;
                  if (spritepixels_0 != null && spritepixels_1 != null) {
                     int_12 -= int_7;
                     if (int_8 == int_62) {
                        int_62 += int_7 * 2;
                     } else {
                        int_62 += int_7;
                     }

                     int_14 = spritepixels_0.height;
                     int_6 += int_14;
                     if (int_9 >= 0 && int_9 < 255) {
                        spritepixels_0.drawImage(int_12, int_13, int_9);
                        Rasterizer2D.setInnerDrawRegion(int_12, int_13, int_12 + int_62, int_14 + int_13);
                        spritepixels_1.drawImage(int_12, int_13, int_9);
                     } else {
                        spritepixels_0.drawAt(int_12, int_13);
                        Rasterizer2D.setInnerDrawRegion(int_12, int_13, int_62 + int_12, int_13 + int_14);
                        spritepixels_1.drawAt(int_12, int_13);
                     }

                     Rasterizer2D.setDrawRegion(int_1, int_2, int_1 + int_3, int_2 + int_4);
                     int_6 += 2;
                  } else {
                     if (Client.screenY > -1) {
                        Rasterizer2D.fillRect(int_12, int_13, int_62, 5, 65280);
                        Rasterizer2D.fillRect(int_62 + int_12, int_13, int_8 - int_62, 5, 16711680);
                     }

                     int_6 += 7;
                  }
               }
            }
         }

         if (int_6 < 30) {
            int_6 = 30;
         }

         if (int_0 < int_5) {
            Player player_0 = (Player) actor_0;
            if (player_0.hidden) {
               return;
            }

            if (player_0.skullIcon != -1 || player_0.overheadIcon != -1) {
               WorldMapData.characterToScreen(actor_0, actor_0.anInt521 + 15);
               if (Client.screenY > -1) {
                  if (player_0.skullIcon != -1) {
                     CacheFile.headIconsPk[player_0.skullIcon].drawAt(int_1 + Client.screenY - 12, int_2 + Client.screenX - int_6);
                     int_6 += 25;
                  }

                  if (player_0.overheadIcon != -1) {
                     TileStrategy.headIconsPrayer[player_0.overheadIcon].drawAt(int_1 + Client.screenY - 12, int_2 + Client.screenX - int_6);
                     int_6 += 25;
                  }
               }
            }

            if (int_0 >= 0 && Client.hintArrowTargetType == 10 && ints_0[int_0] == Client.hintArrowPlayerTargetIdx) {
               WorldMapData.characterToScreen(actor_0, actor_0.anInt521 + 15);
               if (Client.screenY > -1) {
                  Class85.headIconsHint[1].drawAt(int_1 + Client.screenY - 12, int_2 + Client.screenX - int_6);
               }
            }
         } else {
            NPCDefinition npccomposition_1 = ((NPC) actor_0).composition;
            if (npccomposition_1.transformIds != null) {
               npccomposition_1 = npccomposition_1.transform();
            }

            if (npccomposition_1.headIcon >= 0 && npccomposition_1.headIcon < TileStrategy.headIconsPrayer.length) {
               WorldMapData.characterToScreen(actor_0, actor_0.anInt521 + 15);
               if (Client.screenY > -1) {
                  TileStrategy.headIconsPrayer[npccomposition_1.headIcon].drawAt(int_1 + Client.screenY - 12, int_2 + Client.screenX - 30);
               }
            }

            if (Client.hintArrowTargetType == 1 && Client.npcIndices[int_0 - int_5] == Client.hintArrowNpcTargetIdx && Client.gameCycle % 20 < 10) {
               WorldMapData.characterToScreen(actor_0, actor_0.anInt521 + 15);
               if (Client.screenY > -1) {
                  Class85.headIconsHint[0].drawAt(int_1 + Client.screenY - 12, int_2 + Client.screenX - 28);
               }
            }
         }

         if (actor_0.overhead != null && (int_0 >= int_5 || !actor_0.inSequence && (Client.anInt683 == 4 || !actor_0.aBool71 && (Client.anInt683 == 0 || Client.anInt683 == 3 || Client.anInt683 == 1 && Client.isFriended(((Player) actor_0).name, false))))) {
            WorldMapData.characterToScreen(actor_0, actor_0.anInt521);
            if (Client.screenY > -1 && Client.anInt691 < Client.anInt692) {
               Client.anIntArray162[Client.anInt691] = Class50.aFont3.method1030(actor_0.overhead) / 2;
               Client.anIntArray161[Client.anInt691] = Class50.aFont3.verticalSpace;
               Client.anIntArray159[Client.anInt691] = Client.screenY;
               Client.anIntArray160[Client.anInt691] = Client.screenX;
               Client.anIntArray163[Client.anInt691] = actor_0.textColour;
               Client.anIntArray165[Client.anInt691] = actor_0.textEffect;
               Client.anIntArray167[Client.anInt691] = actor_0.textCycle;
               Client.aStringArray6[Client.anInt691] = actor_0.overhead;
               ++Client.anInt691;
            }
         }

         for (int int_15 = 0; int_15 < 4; int_15++) {
            int int_16 = actor_0.hitsplatCycles[int_15];
            int int_17 = actor_0.anIntArray110[int_15];
            CacheableNode_Sub6 cacheablenode_sub6_1 = null;
            int int_18 = 0;
            if (int_17 >= 0) {
               if (int_16 <= Client.gameCycle) {
                  continue;
               }

               cacheablenode_sub6_1 = AClass3_Sub2.method753(actor_0.anIntArray110[int_15]);
               int_18 = cacheablenode_sub6_1.anInt484;
               if (cacheablenode_sub6_1 != null && cacheablenode_sub6_1.anIntArray103 != null) {
                  cacheablenode_sub6_1 = cacheablenode_sub6_1.method890();
                  if (cacheablenode_sub6_1 == null) {
                     actor_0.hitsplatCycles[int_15] = -1;
                     continue;
                  }
               }
            } else if (int_16 < 0) {
               continue;
            }

            int_8 = actor_0.anIntArray111[int_15];
            CacheableNode_Sub6 cacheablenode_sub6_0 = null;
            if (int_8 >= 0) {
               cacheablenode_sub6_0 = AClass3_Sub2.method753(int_8);
               if (cacheablenode_sub6_0 != null && cacheablenode_sub6_0.anIntArray103 != null) {
                  cacheablenode_sub6_0 = cacheablenode_sub6_0.method890();
               }
            }

            if (int_16 - int_18 <= Client.gameCycle) {
               if (cacheablenode_sub6_1 == null) {
                  actor_0.hitsplatCycles[int_15] = -1;
               } else {
                  WorldMapData.characterToScreen(actor_0, actor_0.anInt521 / 2);
                  if (Client.screenY > -1) {
                     if (int_15 == 1) {
                        Client.screenX -= 20;
                     }

                     if (int_15 == 2) {
                        Client.screenY -= 15;
                        Client.screenX -= 10;
                     }

                     if (int_15 == 3) {
                        Client.screenY += 15;
                        Client.screenX -= 10;
                     }

                     SpritePixels spritepixels_2 = null;
                     SpritePixels spritepixels_3 = null;
                     SpritePixels spritepixels_4 = null;
                     SpritePixels spritepixels_5 = null;
                     int_13 = 0;
                     int_14 = 0;
                     int int_19 = 0;
                     int int_20 = 0;
                     int int_21 = 0;
                     int int_22 = 0;
                     int int_23 = 0;
                     int int_24 = 0;
                     SpritePixels spritepixels_6 = null;
                     SpritePixels spritepixels_7 = null;
                     SpritePixels spritepixels_8 = null;
                     SpritePixels spritepixels_9 = null;
                     int int_25 = 0;
                     int int_26 = 0;
                     int int_27 = 0;
                     int int_28 = 0;
                     int int_29 = 0;
                     int int_30 = 0;
                     int int_31 = 0;
                     int int_32 = 0;
                     int int_33 = 0;
                     spritepixels_2 = cacheablenode_sub6_1.method891();
                     int int_34;
                     if (spritepixels_2 != null) {
                        int_13 = spritepixels_2.width;
                        int_34 = spritepixels_2.height;
                        if (int_34 > int_33) {
                           int_33 = int_34;
                        }

                        int_21 = spritepixels_2.offsetX;
                     }

                     spritepixels_3 = cacheablenode_sub6_1.method892();
                     if (spritepixels_3 != null) {
                        int_14 = spritepixels_3.width;
                        int_34 = spritepixels_3.height;
                        if (int_34 > int_33) {
                           int_33 = int_34;
                        }

                        int_22 = spritepixels_3.offsetX;
                     }

                     spritepixels_4 = cacheablenode_sub6_1.method893();
                     if (spritepixels_4 != null) {
                        int_19 = spritepixels_4.width;
                        int_34 = spritepixels_4.height;
                        if (int_34 > int_33) {
                           int_33 = int_34;
                        }

                        int_23 = spritepixels_4.offsetX;
                     }

                     spritepixels_5 = cacheablenode_sub6_1.method894();
                     if (spritepixels_5 != null) {
                        int_20 = spritepixels_5.width;
                        int_34 = spritepixels_5.height;
                        if (int_34 > int_33) {
                           int_33 = int_34;
                        }

                        int_24 = spritepixels_5.offsetX;
                     }

                     if (cacheablenode_sub6_0 != null) {
                        spritepixels_6 = cacheablenode_sub6_0.method891();
                        if (spritepixels_6 != null) {
                           int_25 = spritepixels_6.width;
                           int_34 = spritepixels_6.height;
                           if (int_34 > int_33) {
                              int_33 = int_34;
                           }

                           int_29 = spritepixels_6.offsetX;
                        }

                        spritepixels_7 = cacheablenode_sub6_0.method892();
                        if (spritepixels_7 != null) {
                           int_26 = spritepixels_7.width;
                           int_34 = spritepixels_7.height;
                           if (int_34 > int_33) {
                              int_33 = int_34;
                           }

                           int_30 = spritepixels_7.offsetX;
                        }

                        spritepixels_8 = cacheablenode_sub6_0.method893();
                        if (spritepixels_8 != null) {
                           int_27 = spritepixels_8.width;
                           int_34 = spritepixels_8.height;
                           if (int_34 > int_33) {
                              int_33 = int_34;
                           }

                           int_31 = spritepixels_8.offsetX;
                        }

                        spritepixels_9 = cacheablenode_sub6_0.method894();
                        if (spritepixels_9 != null) {
                           int_28 = spritepixels_9.width;
                           int_34 = spritepixels_9.height;
                           if (int_34 > int_33) {
                              int_33 = int_34;
                           }

                           int_32 = spritepixels_9.offsetX;
                        }
                     }

                     Font font_0 = cacheablenode_sub6_1.method895();
                     if (font_0 == null) {
                        font_0 = Class1.aFont2;
                     }

                     Font font_1;
                     if (cacheablenode_sub6_0 != null) {
                        font_1 = cacheablenode_sub6_0.method895();
                        if (font_1 == null) {
                           font_1 = Class1.aFont2;
                        }
                     } else {
                        font_1 = Class1.aFont2;
                     }

                     String string_0 = null;
                     String string_1 = null;
                     boolean bool_1 = false;
                     int int_35 = 0;
                     string_0 = cacheablenode_sub6_1.method896(actor_0.hitsplatTypes[int_15]);
                     int int_63 = font_0.method1030(string_0);
                     if (cacheablenode_sub6_0 != null) {
                        string_1 = cacheablenode_sub6_0.method896(actor_0.anIntArray112[int_15]);
                        int_35 = font_1.method1030(string_1);
                     }

                     int int_36 = 0;
                     int int_37 = 0;
                     if (int_14 > 0) {
                        if (spritepixels_4 == null && spritepixels_5 == null) {
                           int_36 = 1;
                        } else {
                           int_36 = int_63 / int_14 + 1;
                        }
                     }

                     if (cacheablenode_sub6_0 != null && int_26 > 0) {
                        if (spritepixels_8 == null && spritepixels_9 == null) {
                           int_37 = 1;
                        } else {
                           int_37 = int_35 / int_26 + 1;
                        }
                     }

                     int int_38 = 0;
                     int int_39 = int_38;
                     if (int_13 > 0) {
                        int_38 += int_13;
                     }

                     int_38 += 2;
                     int int_40 = int_38;
                     if (int_19 > 0) {
                        int_38 += int_19;
                     }

                     int int_41 = int_38;
                     int int_42 = int_38;
                     int int_43;
                     if (int_14 > 0) {
                        int_43 = int_36 * int_14;
                        int_38 += int_43;
                        int_42 += (int_43 - int_63) / 2;
                     } else {
                        int_38 += int_63;
                     }

                     int_43 = int_38;
                     if (int_20 > 0) {
                        int_38 += int_20;
                     }

                     int int_44 = 0;
                     int int_45 = 0;
                     int int_46 = 0;
                     int int_47 = 0;
                     int int_48 = 0;
                     int int_49;
                     if (cacheablenode_sub6_0 != null) {
                        int_38 += 2;
                        int_44 = int_38;
                        if (int_25 > 0) {
                           int_38 += int_25;
                        }

                        int_38 += 2;
                        int_45 = int_38;
                        if (int_27 > 0) {
                           int_38 += int_27;
                        }

                        int_46 = int_38;
                        int_48 = int_38;
                        if (int_26 > 0) {
                           int_49 = int_37 * int_26;
                           int_38 += int_49;
                           int_48 += (int_49 - int_35) / 2;
                        } else {
                           int_38 += int_35;
                        }

                        int_47 = int_38;
                        if (int_28 > 0) {
                           int_38 += int_28;
                        }
                     }

                     int_49 = actor_0.hitsplatCycles[int_15] - Client.gameCycle;
                     int int_50 = cacheablenode_sub6_1.anInt485 - int_49 * cacheablenode_sub6_1.anInt485 / cacheablenode_sub6_1.anInt484;
                     int int_51 = int_49 * cacheablenode_sub6_1.anInt487 / cacheablenode_sub6_1.anInt484 + -cacheablenode_sub6_1.anInt487;
                     int int_52 = int_50 + (int_1 + Client.screenY - (int_38 >> 1));
                     int int_53 = int_2 + Client.screenX - 12 + int_51;
                     int int_54 = int_53;
                     int int_55 = int_33 + int_53;
                     int int_56 = int_53 + cacheablenode_sub6_1.anInt488 + 15;
                     int int_57 = int_56 - font_0.minSpacing;
                     int int_58 = int_56 + font_0.maxSpacing;
                     if (int_57 < int_53) {
                        int_54 = int_57;
                     }

                     if (int_58 > int_55) {
                        int_55 = int_58;
                     }

                     int int_59 = 0;
                     int int_60;
                     int int_61;
                     if (cacheablenode_sub6_0 != null) {
                        int_59 = int_53 + cacheablenode_sub6_0.anInt488 + 15;
                        int_60 = int_59 - font_1.minSpacing;
                        int_61 = int_59 + font_1.maxSpacing;
                        if (int_60 < int_54) {
                           ;
                        }

                        if (int_61 > int_55) {
                           ;
                        }
                     }

                     int_60 = 255;
                     if (cacheablenode_sub6_1.anInt486 >= 0) {
                        int_60 = (int_49 << 8) / (cacheablenode_sub6_1.anInt484 - cacheablenode_sub6_1.anInt486);
                     }

                     if (int_60 >= 0 && int_60 < 255) {
                        if (spritepixels_2 != null) {
                           spritepixels_2.drawImage(int_52 + int_39 - int_21, int_53, int_60);
                        }

                        if (spritepixels_4 != null) {
                           spritepixels_4.drawImage(int_52 + int_40 - int_23, int_53, int_60);
                        }

                        if (spritepixels_3 != null) {
                           for (int_61 = 0; int_61 < int_36; int_61++) {
                              spritepixels_3.drawImage(int_14 * int_61 + (int_41 + int_52 - int_22), int_53, int_60);
                           }
                        }

                        if (spritepixels_5 != null) {
                           spritepixels_5.drawImage(int_43 + int_52 - int_24, int_53, int_60);
                        }

                        font_0.method1045(string_0, int_42 + int_52, int_56, cacheablenode_sub6_1.anInt483, 0, int_60);
                        if (cacheablenode_sub6_0 != null) {
                           if (spritepixels_6 != null) {
                              spritepixels_6.drawImage(int_52 + int_44 - int_29, int_53, int_60);
                           }

                           if (spritepixels_8 != null) {
                              spritepixels_8.drawImage(int_45 + int_52 - int_31, int_53, int_60);
                           }

                           if (spritepixels_7 != null) {
                              for (int_61 = 0; int_61 < int_37; int_61++) {
                                 spritepixels_7.drawImage(int_26 * int_61 + (int_52 + int_46 - int_30), int_53, int_60);
                              }
                           }

                           if (spritepixels_9 != null) {
                              spritepixels_9.drawImage(int_52 + int_47 - int_32, int_53, int_60);
                           }

                           font_1.method1045(string_1, int_52 + int_48, int_59, cacheablenode_sub6_0.anInt483, 0, int_60);
                        }
                     } else {
                        if (spritepixels_2 != null) {
                           spritepixels_2.drawAt(int_39 + int_52 - int_21, int_53);
                        }

                        if (spritepixels_4 != null) {
                           spritepixels_4.drawAt(int_40 + int_52 - int_23, int_53);
                        }

                        if (spritepixels_3 != null) {
                           for (int_61 = 0; int_61 < int_36; int_61++) {
                              spritepixels_3.drawAt(int_61 * int_14 + (int_52 + int_41 - int_22), int_53);
                           }
                        }

                        if (spritepixels_5 != null) {
                           spritepixels_5.drawAt(int_52 + int_43 - int_24, int_53);
                        }

                        font_0.method1040(string_0, int_42 + int_52, int_56, cacheablenode_sub6_1.anInt483 | 0xFF000000, 0);
                        if (cacheablenode_sub6_0 != null) {
                           if (spritepixels_6 != null) {
                              spritepixels_6.drawAt(int_44 + int_52 - int_29, int_53);
                           }

                           if (spritepixels_8 != null) {
                              spritepixels_8.drawAt(int_45 + int_52 - int_31, int_53);
                           }

                           if (spritepixels_7 != null) {
                              for (int_61 = 0; int_61 < int_37; int_61++) {
                                 spritepixels_7.drawAt(int_26 * int_61 + (int_46 + int_52 - int_30), int_53);
                              }
                           }

                           if (spritepixels_9 != null) {
                              spritepixels_9.drawAt(int_52 + int_47 - int_32, int_53);
                           }

                           font_1.method1040(string_1, int_52 + int_48, int_59, cacheablenode_sub6_0.anInt483 | 0xFF000000, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }

}
