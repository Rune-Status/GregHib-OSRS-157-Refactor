public abstract class Actor extends Renderable {

   int animation;
   int[] pathX;
   int queueSize;
   int[] hitsplatCycles;
   int anInt510;
   boolean aBool69;
   int anInt511;
   int[] pathY;
   byte aByte4;
   int actionAnimationDisable;
   CombatInfoList combatInfoList;
   int anInt512;
   int poseAnimation;
   int anInt513;
   int[] hitsplatTypes;
   int idlePoseAnimation;
   int actionFrame;
   int poseFrame;
   int turnAnimation;
   int anInt515;
   int walkingAnimation;
   byte[] aByteArray20;
   int halfTurnAnimation;
   int x;
   int[] anIntArray110;
   int quarterClockwiseTurnAnimation;
   int quarterAnticlockwiseTurnAnimation;
   int[] anIntArray111;
   int runAnimation;
   int anInt521;
   int y;
   int[] anIntArray112;
   String overhead;
   int graphic;
   boolean inSequence;
   int currentAnimation;
   int anInt523;
   int anInt524;
   int anInt525;
   int graphicHeight;
   int interacting;
   boolean aBool70;
   int orientation;
   int anInt527;
   int anInt528;
   int anInt529;
   int anInt530;
   int anInt531;
   int anInt532;
   int anInt533;
   int anInt534;
   int anInt535;
   int anInt536;
   int anInt537;
   int graphicDelay;
   int anInt538;
   int anInt539;
   int anInt540;
   int angle;
   boolean aBool71;

   Actor() {
      this.aBool69 = false;
      this.anInt513 = 1;
      this.idlePoseAnimation = -1;
      this.turnAnimation = -1;
      this.anInt515 = -1;
      this.walkingAnimation = -1;
      this.halfTurnAnimation = -1;
      this.quarterClockwiseTurnAnimation = -1;
      this.quarterAnticlockwiseTurnAnimation = -1;
      this.runAnimation = -1;
      this.overhead = null;
      this.inSequence = false;
      this.anInt523 = 100;
      this.anInt524 = 0;
      this.anInt525 = 0;
      this.aByte4 = 0;
      this.anIntArray110 = new int[4];
      this.hitsplatTypes = new int[4];
      this.hitsplatCycles = new int[4];
      this.anIntArray111 = new int[4];
      this.anIntArray112 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.aBool70 = false;
      this.anInt510 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.anInt527 = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.anInt528 = 0;
      this.actionAnimationDisable = 0;
      this.anInt529 = 0;
      this.graphic = -1;
      this.currentAnimation = 0;
      this.anInt530 = 0;
      this.anInt531 = 0;
      this.anInt521 = 200;
      this.anInt532 = 0;
      this.anInt533 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.aByteArray20 = new byte[10];
      this.anInt512 = 0;
      this.anInt511 = 0;
   }

   boolean hasConfig() {
      return false;
   }

   void method949(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      boolean bool_0 = true;
      boolean bool_1 = true;

      int int_6;
      for (int_6 = 0; int_6 < 4; int_6++) {
         if (this.hitsplatCycles[int_6] > int_4) {
            bool_0 = false;
         } else {
            bool_1 = false;
         }
      }

      int_6 = -1;
      int int_7 = -1;
      int int_8 = 0;
      if (int_0 >= 0) {
         CacheableNode_Sub6 cacheablenode_sub6_0 = AClass3_Sub2.method753(int_0);
         int_7 = cacheablenode_sub6_0.anInt482;
         int_8 = cacheablenode_sub6_0.anInt484;
      }

      int int_9;
      if (bool_1) {
         if (int_7 == -1) {
            return;
         }

         int_6 = 0;
         int_9 = 0;
         if (int_7 == 0) {
            int_9 = this.hitsplatCycles[0];
         } else if (int_7 == 1) {
            int_9 = this.hitsplatTypes[0];
         }

         for (int int_10 = 1; int_10 < 4; int_10++) {
            if (int_7 == 0) {
               if (this.hitsplatCycles[int_10] < int_9) {
                  int_6 = int_10;
                  int_9 = this.hitsplatCycles[int_10];
               }
            } else if (int_7 == 1 && this.hitsplatTypes[int_10] < int_9) {
               int_6 = int_10;
               int_9 = this.hitsplatTypes[int_10];
            }
         }

         if (int_7 == 1 && int_9 >= int_1) {
            return;
         }
      } else {
         if (bool_0) {
            this.aByte4 = 0;
         }

         for (int_9 = 0; int_9 < 4; int_9++) {
            byte byte_0 = this.aByte4;
            this.aByte4 = (byte)((this.aByte4 + 1) % 4);
            if (this.hitsplatCycles[byte_0] <= int_4) {
               int_6 = byte_0;
               break;
            }
         }
      }

      if (int_6 >= 0) {
         this.anIntArray110[int_6] = int_0;
         this.hitsplatTypes[int_6] = int_1;
         this.anIntArray111[int_6] = int_2;
         this.anIntArray112[int_6] = int_3;
         this.hitsplatCycles[int_6] = int_4 + int_8 + int_5;
      }
   }

   void method950() {
      this.queueSize = 0;
      this.anInt511 = 0;
   }

   void method951(int int_0) {
      CombatInfo2 combatinfo2_0 = (CombatInfo2) CombatInfo2.aNodeCache7.get((long)int_0);
      CombatInfo2 combatinfo2_1;
      if (combatinfo2_0 != null) {
         combatinfo2_1 = combatinfo2_0;
      } else {
         byte[] bytes_0 = CombatInfo2.anIndexDataBase18.getConfigData(33, int_0);
         combatinfo2_0 = new CombatInfo2();
         if (bytes_0 != null) {
            combatinfo2_0.method817(new Buffer(bytes_0));
         }

         CombatInfo2.aNodeCache7.put(combatinfo2_0, (long)int_0);
         combatinfo2_1 = combatinfo2_0;
      }

      combatinfo2_0 = combatinfo2_1;

      for (CombatInfoListHolder combatinfolistholder_0 = (CombatInfoListHolder) this.combatInfoList.method454(); combatinfolistholder_0 != null; combatinfolistholder_0 = (CombatInfoListHolder) this.combatInfoList.method456()) {
         if (combatinfo2_0 == combatinfolistholder_0.combatInfo2) {
            combatinfolistholder_0.unlink();
            return;
         }
      }

   }

   void method952(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      CombatInfo2 combatinfo2_0 = (CombatInfo2) CombatInfo2.aNodeCache7.get((long)int_0);
      CombatInfo2 combatinfo2_1;
      if (combatinfo2_0 != null) {
         combatinfo2_1 = combatinfo2_0;
      } else {
         byte[] bytes_0 = CombatInfo2.anIndexDataBase18.getConfigData(33, int_0);
         combatinfo2_0 = new CombatInfo2();
         if (bytes_0 != null) {
            combatinfo2_0.method817(new Buffer(bytes_0));
         }

         CombatInfo2.aNodeCache7.put(combatinfo2_0, (long)int_0);
         combatinfo2_1 = combatinfo2_0;
      }

      combatinfo2_0 = combatinfo2_1;
      CombatInfoListHolder combatinfolistholder_2 = null;
      CombatInfoListHolder combatinfolistholder_0 = null;
      int int_6 = combatinfo2_1.anInt456;
      int int_7 = 0;

      CombatInfoListHolder combatinfolistholder_1;
      for (combatinfolistholder_1 = (CombatInfoListHolder) this.combatInfoList.method454(); combatinfolistholder_1 != null; combatinfolistholder_1 = (CombatInfoListHolder) this.combatInfoList.method456()) {
         ++int_7;
         if (combatinfolistholder_1.combatInfo2.anInt459 == combatinfo2_0.anInt459) {
            combatinfolistholder_1.method648(int_1 + int_3, int_4, int_5, int_2);
            return;
         }

         if (combatinfolistholder_1.combatInfo2.anInt454 <= combatinfo2_0.anInt454) {
            combatinfolistholder_2 = combatinfolistholder_1;
         }

         if (combatinfolistholder_1.combatInfo2.anInt456 > int_6) {
            combatinfolistholder_0 = combatinfolistholder_1;
            int_6 = combatinfolistholder_1.combatInfo2.anInt456;
         }
      }

      if (combatinfolistholder_0 != null || int_7 < 4) {
         combatinfolistholder_1 = new CombatInfoListHolder(combatinfo2_0);
         if (combatinfolistholder_2 == null) {
            this.combatInfoList.method457(combatinfolistholder_1);
         } else {
            CombatInfoList.method459(combatinfolistholder_1, combatinfolistholder_2);
         }

         combatinfolistholder_1.method648(int_1 + int_3, int_4, int_5, int_2);
         if (int_7 >= 4) {
            combatinfolistholder_0.unlink();
         }

      }
   }

   public static PacketNode method953(ClientPacket clientpacket_0, IsaacCipher isaaccipher_0) {
      PacketNode packetnode_0 = Class26.method222();
      packetnode_0.clientPacket = clientpacket_0;
      packetnode_0.anInt350 = clientpacket_0.packetLength;
      if (packetnode_0.anInt350 == -1) {
         packetnode_0.packetBuffer = new PacketBuffer(260);
      } else if (packetnode_0.anInt350 == -2) {
         packetnode_0.packetBuffer = new PacketBuffer(10000);
      } else if (packetnode_0.anInt350 <= 18) {
         packetnode_0.packetBuffer = new PacketBuffer(20);
      } else if (packetnode_0.anInt350 <= 98) {
         packetnode_0.packetBuffer = new PacketBuffer(100);
      } else {
         packetnode_0.packetBuffer = new PacketBuffer(260);
      }

      packetnode_0.packetBuffer.method905(isaaccipher_0);
      packetnode_0.packetBuffer.putOpcode(packetnode_0.clientPacket.packetId);
      packetnode_0.anInt349 = 0;
      return packetnode_0;
   }

   public static boolean method954(char char_0) {
      return char_0 >= 48 && char_0 <= 57;
   }

}
