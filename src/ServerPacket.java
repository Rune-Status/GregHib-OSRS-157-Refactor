public class ServerPacket {

   public static final ServerPacket regionUpdatePacket;
   public static final ServerPacket dynamicRegionPacket;
   public static final ServerPacket aServerPacket6;
   public static final ServerPacket aServerPacket7;
   public static final ServerPacket aServerPacket8;
   public static final ServerPacket aServerPacket9;
   public static final ServerPacket aServerPacket10;
   public static final ServerPacket aServerPacket11;
   public static final ServerPacket aServerPacket12;
   public static final ServerPacket aServerPacket13;
   public static final ServerPacket aServerPacket14;
   public static final ServerPacket aServerPacket15;
   public static final ServerPacket aServerPacket16;
   public static final ServerPacket aServerPacket17;
   public static final ServerPacket aServerPacket18;
   public static final ServerPacket aServerPacket19;
   public static final ServerPacket aServerPacket20;
   public static final ServerPacket aServerPacket21;
   public static final ServerPacket setWeightPacket;
   public static final ServerPacket aServerPacket23;
   public static final ServerPacket aServerPacket24;
   public static final ServerPacket aServerPacket25;
   public static final ServerPacket aServerPacket26;
   public static final ServerPacket aServerPacket27;
   public static final ServerPacket soundEffectPacket;
   public static final ServerPacket aServerPacket29;
   public static final ServerPacket itemOnInterfacePacket;
   public static final ServerPacket aServerPacket31;
   public static final ServerPacket aServerPacket32;
   public static final ServerPacket aServerPacket33;
   public static final ServerPacket aServerPacket34;
   public static final ServerPacket aServerPacket35;
   public static final ServerPacket resetVarpPacket;
   public static final ServerPacket rootInterfacePacket;
   public static final ServerPacket cs2ScriptPacket;
   public static final ServerPacket aServerPacket39;
   public static final ServerPacket interfaceSettingsPacket;
   public static final ServerPacket aServerPacket41;
   public static final ServerPacket aServerPacket42;
   public static final ServerPacket aServerPacket43;
   public static final ServerPacket skillLvlPacket;
   public static final ServerPacket aServerPacket45;
   public static final ServerPacket varpSmallPacket;
   public static final ServerPacket aServerPacket47;
   public static final ServerPacket aServerPacket48;
   public static final ServerPacket aServerPacket49;
   public static final ServerPacket aServerPacket50;
   public static final ServerPacket aServerPacket51;
   public static final ServerPacket aServerPacket52;
   public static final ServerPacket aServerPacket53;
   public static final ServerPacket aServerPacket54;
   public static final ServerPacket aServerPacket55;
   public static final ServerPacket aServerPacket56;
   public static final ServerPacket aServerPacket57;
   public static final ServerPacket addIgnorePacket;
   public static final ServerPacket aServerPacket59;
   public static final ServerPacket playerUpdatePacket;
   public static final ServerPacket aServerPacket61;
   public static final ServerPacket interfaceTextPacket;
   public static final ServerPacket aServerPacket63;
   public static final ServerPacket updateUidPacket;
   public static final ServerPacket resetCameraPacket;
   public static final ServerPacket aServerPacket66;
   public static final ServerPacket aServerPacket67;
   public static final ServerPacket addClanMemberPacket;
   public static final ServerPacket aServerPacket69;
   public static final ServerPacket aServerPacket70;
   public static final ServerPacket aServerPacket71;
   public static final ServerPacket npcUpdatePacket;
   public static final ServerPacket aServerPacket73;
   public static final ServerPacket aServerPacket74;
   public static final ServerPacket playerOptionsPacket;
   public static final ServerPacket aServerPacket76;
   public static final ServerPacket aServerPacket77;
   public static final ServerPacket playSongPacket;
   public static final ServerPacket energyPacket;
   public static final ServerPacket resetAnimationPacket;
   public static final ServerPacket aServerPacket81;
   public static final ServerPacket aServerPacket82;
   public static final ServerPacket aServerPacket83;
   public static final ServerPacket varpLargePacket;
   public static final ServerPacket aServerPacket85;
   public static final ServerPacket serverMessagePacket;
   public final int packetId;
   public final int packetLength;

   static {
      regionUpdatePacket = new ServerPacket(0, -2);
      dynamicRegionPacket = new ServerPacket(1, -2);
      aServerPacket6 = new ServerPacket(2, -1);
      aServerPacket7 = new ServerPacket(3, 0);
      aServerPacket8 = new ServerPacket(4, 2);
      aServerPacket9 = new ServerPacket(5, 4);
      aServerPacket10 = new ServerPacket(6, 8);
      aServerPacket11 = new ServerPacket(7, -2);
      aServerPacket12 = new ServerPacket(8, 5);
      aServerPacket13 = new ServerPacket(9, 7);
      aServerPacket15 = new ServerPacket(10, 14);
      aServerPacket16 = new ServerPacket(11, 6);
      aServerPacket18 = new ServerPacket(12, 15);
      aServerPacket20 = new ServerPacket(13, 3);
      aServerPacket21 = new ServerPacket(14, 5);
      aServerPacket23 = new ServerPacket(15, 4);
      aServerPacket25 = new ServerPacket(16, 2);
      aServerPacket26 = new ServerPacket(17, 4);
      aServerPacket27 = new ServerPacket(18, -2);
      aServerPacket29 = new ServerPacket(19, 2);
      aServerPacket31 = new ServerPacket(20, 2);
      aServerPacket32 = new ServerPacket(21, 8);
      aServerPacket34 = new ServerPacket(22, -2);
      aServerPacket35 = new ServerPacket(23, 4);
      aServerPacket33 = new ServerPacket(24, 7);
      rootInterfacePacket = new ServerPacket(25, 2);
      cs2ScriptPacket = new ServerPacket(26, -2);
      interfaceSettingsPacket = new ServerPacket(27, 12);
      aServerPacket41 = new ServerPacket(28, -2);
      aServerPacket43 = new ServerPacket(29, 8);
      aServerPacket45 = new ServerPacket(30, 10);
      aServerPacket14 = new ServerPacket(31, 6);
      aServerPacket47 = new ServerPacket(32, 8);
      aServerPacket49 = new ServerPacket(33, 4);
      aServerPacket50 = new ServerPacket(34, 10);
      aServerPacket51 = new ServerPacket(35, 20);
      aServerPacket42 = new ServerPacket(36, 5);
      aServerPacket53 = new ServerPacket(37, 6);
      aServerPacket55 = new ServerPacket(38, -2);
      aServerPacket57 = new ServerPacket(39, 4);
      aServerPacket59 = new ServerPacket(40, 6);
      aServerPacket19 = new ServerPacket(41, 6);
      aServerPacket61 = new ServerPacket(42, 6);
      interfaceTextPacket = new ServerPacket(43, -2);
      updateUidPacket = new ServerPacket(44, 28);
      resetCameraPacket = new ServerPacket(45, 0);
      aServerPacket17 = new ServerPacket(46, 4);
      aServerPacket48 = new ServerPacket(47, 6);
      aServerPacket67 = new ServerPacket(48, 6);
      aServerPacket54 = new ServerPacket(49, 0);
      addClanMemberPacket = new ServerPacket(50, -1);
      aServerPacket69 = new ServerPacket(51, -2);
      aServerPacket70 = new ServerPacket(52, -1);
      aServerPacket71 = new ServerPacket(53, -1);
      aServerPacket66 = new ServerPacket(54, 2);
      aServerPacket56 = new ServerPacket(55, -2);
      resetVarpPacket = new ServerPacket(56, 0);
      aServerPacket39 = new ServerPacket(57, 1);
      aServerPacket74 = new ServerPacket(58, 0);
      playerOptionsPacket = new ServerPacket(59, -1);
      itemOnInterfacePacket = new ServerPacket(60, 6);
      aServerPacket76 = new ServerPacket(61, 2);
      aServerPacket24 = new ServerPacket(62, 0);
      soundEffectPacket = new ServerPacket(63, 5);
      setWeightPacket = new ServerPacket(64, 2);
      energyPacket = new ServerPacket(65, 1);
      resetAnimationPacket = new ServerPacket(66, 0);
      addIgnorePacket = new ServerPacket(67, -2);
      aServerPacket81 = new ServerPacket(68, 2);
      aServerPacket82 = new ServerPacket(69, -2);
      aServerPacket83 = new ServerPacket(70, 1);
      playSongPacket = new ServerPacket(71, 5);
      aServerPacket77 = new ServerPacket(72, 2);
      varpLargePacket = new ServerPacket(73, 6);
      varpSmallPacket = new ServerPacket(74, 3);
      aServerPacket85 = new ServerPacket(75, -2);
      aServerPacket73 = new ServerPacket(76, -2);
      aServerPacket63 = new ServerPacket(77, -2);
      npcUpdatePacket = new ServerPacket(78, -2);
      skillLvlPacket = new ServerPacket(79, 6);
      aServerPacket52 = new ServerPacket(80, -2);
      serverMessagePacket = new ServerPacket(81, -1);
      playerUpdatePacket = new ServerPacket(82, -2);
   }

   ServerPacket(int id, int length) {
      this.packetId = id;
      this.packetLength = length;
   }

   static void method355(Actor actor) {
      int int_0;
      int int_1;
      int int_2;
      Sequence sequence;
      if (actor.anInt534 > Client.gameCycle) {
         int_0 = actor.anInt534 - Client.gameCycle;
         int_1 = actor.anInt536 * 128 + actor.anInt513 * 64;
         int_2 = actor.anInt537 * 128 + actor.anInt513 * 64;
         actor.x += (int_1 - actor.x) / int_0;
         actor.y += (int_2 - actor.y) / int_0;
         actor.anInt512 = 0;
         actor.orientation = actor.anInt540;
      } else if (actor.anInt535 >= Client.gameCycle) {
         Class2.method78(actor);
      } else {
         actor.poseAnimation = actor.idlePoseAnimation;
         if (actor.queueSize == 0) {
            actor.anInt512 = 0;
         } else {
            label573: {
               if (actor.animation != -1 && actor.actionAnimationDisable == 0) {
                  sequence = ItemLayer.getAnimation(actor.animation);
                  if (actor.anInt511 > 0 && sequence.precedenceAnimating == 0) {
                     ++actor.anInt512;
                     break label573;
                  }

                  if (actor.anInt511 <= 0 && sequence.priority == 0) {
                     ++actor.anInt512;
                     break label573;
                  }
               }

               int_0 = actor.x;
               int_1 = actor.y;
               int_2 = actor.pathX[actor.queueSize - 1] * 128 + actor.anInt513 * 64;
               int int_3 = actor.pathY[actor.queueSize - 1] * 128 + actor.anInt513 * 64;
               if (int_0 < int_2) {
                  if (int_1 < int_3) {
                     actor.orientation = 1280;
                  } else if (int_1 > int_3) {
                     actor.orientation = 1792;
                  } else {
                     actor.orientation = 1536;
                  }
               } else if (int_0 > int_2) {
                  if (int_1 < int_3) {
                     actor.orientation = 768;
                  } else if (int_1 > int_3) {
                     actor.orientation = 256;
                  } else {
                     actor.orientation = 512;
                  }
               } else if (int_1 < int_3) {
                  actor.orientation = 1024;
               } else if (int_1 > int_3) {
                  actor.orientation = 0;
               }

               byte byte_0 = actor.aByteArray20[actor.queueSize - 1];
               if (int_2 - int_0 <= 256 && int_2 - int_0 >= -256 && int_3 - int_1 <= 256 && int_3 - int_1 >= -256) {
                  int int_4 = actor.orientation - actor.angle & 0x7FF;
                  if (int_4 > 1024) {
                     int_4 -= 2048;
                  }

                  int int_5 = actor.halfTurnAnimation;
                  if (int_4 >= -256 && int_4 <= 256) {
                     int_5 = actor.walkingAnimation;
                  } else if (int_4 >= 256 && int_4 < 768) {
                     int_5 = actor.quarterAnticlockwiseTurnAnimation;
                  } else if (int_4 >= -768 && int_4 <= -256) {
                     int_5 = actor.quarterClockwiseTurnAnimation;
                  }

                  if (int_5 == -1) {
                     int_5 = actor.walkingAnimation;
                  }

                  actor.poseAnimation = int_5;
                  int int_6 = 4;
                  boolean click = true;
                  if (actor instanceof NPC) {
                     click = ((NPC) actor).composition.isClickable;
                  }

                  if (click) {
                     if (actor.angle != actor.orientation && actor.interacting == -1 && actor.anInt533 != 0) {
                        int_6 = 2;
                     }

                     if (actor.queueSize > 2) {
                        int_6 = 6;
                     }

                     if (actor.queueSize > 3) {
                        int_6 = 8;
                     }

                     if (actor.anInt512 > 0 && actor.queueSize > 1) {
                        int_6 = 8;
                        --actor.anInt512;
                     }
                  } else {
                     if (actor.queueSize > 1) {
                        int_6 = 6;
                     }

                     if (actor.queueSize > 2) {
                        int_6 = 8;
                     }

                     if (actor.anInt512 > 0 && actor.queueSize > 1) {
                        int_6 = 8;
                        --actor.anInt512;
                     }
                  }

                  if (byte_0 == 2) {
                     int_6 <<= 1;
                  }

                  if (int_6 >= 8 && actor.poseAnimation == actor.walkingAnimation && actor.runAnimation != -1) {
                     actor.poseAnimation = actor.runAnimation;
                  }

                  if (int_0 != int_2 || int_1 != int_3) {
                     if (int_0 < int_2) {
                        actor.x += int_6;
                        if (actor.x > int_2) {
                           actor.x = int_2;
                        }
                     } else if (int_0 > int_2) {
                        actor.x -= int_6;
                        if (actor.x < int_2) {
                           actor.x = int_2;
                        }
                     }

                     if (int_1 < int_3) {
                        actor.y += int_6;
                        if (actor.y > int_3) {
                           actor.y = int_3;
                        }
                     } else if (int_1 > int_3) {
                        actor.y -= int_6;
                        if (actor.y < int_3) {
                           actor.y = int_3;
                        }
                     }
                  }

                  if (int_2 == actor.x && int_3 == actor.y) {
                     --actor.queueSize;
                     if (actor.anInt511 > 0) {
                        --actor.anInt511;
                     }
                  }
               } else {
                  actor.x = int_2;
                  actor.y = int_3;
                  --actor.queueSize;
                  if (actor.anInt511 > 0) {
                     --actor.anInt511;
                  }
               }
            }
         }
      }

      if (actor.x < 128 || actor.y < 128 || actor.x >= 13184 || actor.y >= 13184) {
         actor.animation = -1;
         actor.graphic = -1;
         actor.anInt534 = 0;
         actor.anInt535 = 0;
         actor.x = actor.pathX[0] * 128 + actor.anInt513 * 64;
         actor.y = actor.pathY[0] * 128 + actor.anInt513 * 64;
         actor.method950();
      }

      if (Class4.localPlayer == actor && (actor.x < 1536 || actor.y < 1536 || actor.x >= 11776 || actor.y >= 11776)) {
         actor.animation = -1;
         actor.graphic = -1;
         actor.anInt534 = 0;
         actor.anInt535 = 0;
         actor.x = actor.pathX[0] * 128 + actor.anInt513 * 64;
         actor.y = actor.pathY[0] * 128 + actor.anInt513 * 64;
         actor.method950();
      }

      if (actor.anInt533 != 0) {
         if (actor.interacting != -1) {
            Object object_0 = null;
            if (actor.interacting < 32768) {
               object_0 = Client.cachedNPCs[actor.interacting];
            } else if (actor.interacting >= 32768) {
               object_0 = Client.cachedPlayers[actor.interacting - 32768];
            }

            if (object_0 != null) {
               int_1 = actor.x - ((Actor) object_0).x;
               int_2 = actor.y - ((Actor) object_0).y;
               if (int_1 != 0 || int_2 != 0) {
                  actor.orientation = (int)(Math.atan2((double)int_1, (double)int_2) * 325.949D) & 0x7FF;
               }
            } else if (actor.aBool70) {
               actor.interacting = -1;
               actor.aBool70 = false;
            }
         }

         if (actor.anInt510 != -1 && (actor.queueSize == 0 || actor.anInt512 > 0)) {
            actor.orientation = actor.anInt510;
            actor.anInt510 = -1;
         }

         int_0 = actor.orientation - actor.angle & 0x7FF;
         if (int_0 == 0 && actor.aBool70) {
            actor.interacting = -1;
            actor.aBool70 = false;
         }

         if (int_0 != 0) {
            ++actor.anInt532;
            boolean bool_1;
            if (int_0 > 1024) {
               actor.angle -= actor.anInt533;
               bool_1 = true;
               if (int_0 < actor.anInt533 || int_0 > 2048 - actor.anInt533) {
                  actor.angle = actor.orientation;
                  bool_1 = false;
               }

               if (actor.poseAnimation == actor.idlePoseAnimation && (actor.anInt532 > 25 || bool_1)) {
                  if (actor.turnAnimation != -1) {
                     actor.poseAnimation = actor.turnAnimation;
                  } else {
                     actor.poseAnimation = actor.walkingAnimation;
                  }
               }
            } else {
               actor.angle += actor.anInt533;
               bool_1 = true;
               if (int_0 < actor.anInt533 || int_0 > 2048 - actor.anInt533) {
                  actor.angle = actor.orientation;
                  bool_1 = false;
               }

               if (actor.idlePoseAnimation == actor.poseAnimation && (actor.anInt532 > 25 || bool_1)) {
                  if (actor.anInt515 != -1) {
                     actor.poseAnimation = actor.anInt515;
                  } else {
                     actor.poseAnimation = actor.walkingAnimation;
                  }
               }
            }

            actor.angle &= 0x7FF;
         } else {
            actor.anInt532 = 0;
         }
      }

      actor.aBool69 = false;
      if (actor.poseAnimation != -1) {
         sequence = ItemLayer.getAnimation(actor.poseAnimation);
         if (sequence != null && sequence.frameIDs != null) {
            ++actor.anInt527;
            if (actor.poseFrame < sequence.frameIDs.length && actor.anInt527 > sequence.frameLenghts[actor.poseFrame]) {
               actor.anInt527 = 1;
               ++actor.poseFrame;
               Class16.method199(sequence, actor.poseFrame, actor.x, actor.y);
            }

            if (actor.poseFrame >= sequence.frameIDs.length) {
               actor.anInt527 = 0;
               actor.poseFrame = 0;
               Class16.method199(sequence, actor.poseFrame, actor.x, actor.y);
            }
         } else {
            actor.poseAnimation = -1;
         }
      }

      if (actor.graphic != -1 && Client.gameCycle >= actor.graphicDelay) {
         if (actor.currentAnimation < 0) {
            actor.currentAnimation = 0;
         }

         int_0 = Class106.getSpotAnimType(actor.graphic).anInt420;
         if (int_0 != -1) {
            Sequence sequence_1 = ItemLayer.getAnimation(int_0);
            if (sequence_1 != null && sequence_1.frameIDs != null) {
               ++actor.anInt530;
               if (actor.currentAnimation < sequence_1.frameIDs.length && actor.anInt530 > sequence_1.frameLenghts[actor.currentAnimation]) {
                  actor.anInt530 = 1;
                  ++actor.currentAnimation;
                  Class16.method199(sequence_1, actor.currentAnimation, actor.x, actor.y);
               }

               if (actor.currentAnimation >= sequence_1.frameIDs.length && (actor.currentAnimation < 0 || actor.currentAnimation >= sequence_1.frameIDs.length)) {
                  actor.graphic = -1;
               }
            } else {
               actor.graphic = -1;
            }
         } else {
            actor.graphic = -1;
         }
      }

      if (actor.animation != -1 && actor.actionAnimationDisable <= 1) {
         sequence = ItemLayer.getAnimation(actor.animation);
         if (sequence.precedenceAnimating == 1 && actor.anInt511 > 0 && actor.anInt534 <= Client.gameCycle && actor.anInt535 < Client.gameCycle) {
            actor.actionAnimationDisable = 1;
            return;
         }
      }

      if (actor.animation != -1 && actor.actionAnimationDisable == 0) {
         sequence = ItemLayer.getAnimation(actor.animation);
         if (sequence != null && sequence.frameIDs != null) {
            ++actor.anInt528;
            if (actor.actionFrame < sequence.frameIDs.length && actor.anInt528 > sequence.frameLenghts[actor.actionFrame]) {
               actor.anInt528 = 1;
               ++actor.actionFrame;
               Class16.method199(sequence, actor.actionFrame, actor.x, actor.y);
            }

            if (actor.actionFrame >= sequence.frameIDs.length) {
               actor.actionFrame -= sequence.frameStep;
               ++actor.anInt529;
               if (actor.anInt529 >= sequence.maxLoops) {
                  actor.animation = -1;
               } else if (actor.actionFrame >= 0 && actor.actionFrame < sequence.frameIDs.length) {
                  Class16.method199(sequence, actor.actionFrame, actor.x, actor.y);
               } else {
                  actor.animation = -1;
               }
            }

            actor.aBool69 = sequence.stretches;
         } else {
            actor.animation = -1;
         }
      }

      if (actor.actionAnimationDisable > 0) {
         --actor.actionAnimationDisable;
      }
   }

}
