public class Class27 {

   static byte[] updateFlags;
   static byte[] aByteArray3;
   static Buffer[] aBufferArray1;
   static int localPlayerIndexCount;
   static int[] localPlayerIndices;
   static int externalPlayerCount;
   static int[] externalPlayerIndices;
   static int[] anIntArray18;
   static int[] anIntArray19;
   static int[] anIntArray20;
   static int playerCount;
   static int[] playerIndexes;
   static Buffer aBuffer2;

   static {
      updateFlags = new byte[2048];
      aByteArray3 = new byte[2048];
      aBufferArray1 = new Buffer[2048];
      localPlayerIndexCount = 0;
      localPlayerIndices = new int[2048];
      externalPlayerCount = 0;
      externalPlayerIndices = new int[2048];
      anIntArray18 = new int[2048];
      anIntArray19 = new int[2048];
      anIntArray20 = new int[2048];
      playerCount = 0;
      playerIndexes = new int[2048];
      aBuffer2 = new Buffer(new byte[5000]);
   }

   public static NPCComposition getNpcDefinition(int int_0) {
      NPCComposition npccomposition_0 = (NPCComposition) NPCComposition.npcs.get((long)int_0);
      if (npccomposition_0 != null) {
         return npccomposition_0;
      } else {
         byte[] bytes_0 = NPCComposition.anIndexDataBase29.getConfigData(9, int_0);
         npccomposition_0 = new NPCComposition();
         npccomposition_0.id = int_0;
         if (bytes_0 != null) {
            npccomposition_0.decode(new Buffer(bytes_0));
         }

         npccomposition_0.post();
         NPCComposition.npcs.put(npccomposition_0, (long)int_0);
         return npccomposition_0;
      }
   }

   public static int method225(CharSequence charsequence_0) {
      return Enum5.parseInt(charsequence_0, 10, true);
   }

   static void method226(int int_0, int int_1, int int_2, int int_3) {
      for (Node_Sub1 node_sub1_0 = (Node_Sub1) Node_Sub1.aDeque3.getFront(); node_sub1_0 != null; node_sub1_0 = (Node_Sub1) Node_Sub1.aDeque3.getNext()) {
         if (node_sub1_0.anInt315 != -1 || node_sub1_0.anIntArray72 != null) {
            int int_4 = 0;
            if (int_1 > node_sub1_0.anInt319) {
               int_4 += int_1 - node_sub1_0.anInt319;
            } else if (int_1 < node_sub1_0.anInt320) {
               int_4 += node_sub1_0.anInt320 - int_1;
            }

            if (int_2 > node_sub1_0.anInt321) {
               int_4 += int_2 - node_sub1_0.anInt321;
            } else if (int_2 < node_sub1_0.anInt322) {
               int_4 += node_sub1_0.anInt322 - int_2;
            }

            if (int_4 - 64 <= node_sub1_0.anInt316 && Client.anInt646 != 0 && int_0 == node_sub1_0.anInt323) {
               int_4 -= 64;
               if (int_4 < 0) {
                  int_4 = 0;
               }

               int int_5 = (node_sub1_0.anInt316 - int_4) * Client.anInt646 / node_sub1_0.anInt316;
               if (node_sub1_0.anAClass6_Sub2_1 == null) {
                  if (node_sub1_0.anInt315 >= 0) {
                     SoundEffect soundeffect_0 = SoundEffect.getTrack(Tile.anIndexData5, node_sub1_0.anInt315, 0);
                     if (soundeffect_0 != null) {
                        AClass4_Sub1 aclass4_sub1_0 = soundeffect_0.method421().method761(Class87.aClass51_1);
                        AClass6_Sub2 aclass6_sub2_0 = AClass6_Sub2.method804(aclass4_sub1_0, 100, int_5);
                        aclass6_sub2_0.method782(-1);
                        Class97.anAClass6_Sub1_1.method757(aclass6_sub2_0);
                        node_sub1_0.anAClass6_Sub2_1 = aclass6_sub2_0;
                     }
                  }
               } else {
                  node_sub1_0.anAClass6_Sub2_1.method784(int_5);
               }

               if (node_sub1_0.anAClass6_Sub2_2 == null) {
                  if (node_sub1_0.anIntArray72 != null && (node_sub1_0.anInt324 -= int_3) <= 0) {
                     int int_6 = (int)(Math.random() * (double)node_sub1_0.anIntArray72.length);
                     SoundEffect soundeffect_1 = SoundEffect.getTrack(Tile.anIndexData5, node_sub1_0.anIntArray72[int_6], 0);
                     if (soundeffect_1 != null) {
                        AClass4_Sub1 aclass4_sub1_1 = soundeffect_1.method421().method761(Class87.aClass51_1);
                        AClass6_Sub2 aclass6_sub2_1 = AClass6_Sub2.method804(aclass4_sub1_1, 100, int_5);
                        aclass6_sub2_1.method782(0);
                        Class97.anAClass6_Sub1_1.method757(aclass6_sub2_1);
                        node_sub1_0.anAClass6_Sub2_2 = aclass6_sub2_1;
                        node_sub1_0.anInt324 = node_sub1_0.anInt317 + (int)(Math.random() * (double)(node_sub1_0.anInt318 - node_sub1_0.anInt317));
                     }
                  }
               } else {
                  node_sub1_0.anAClass6_Sub2_2.method784(int_5);
                  if (!node_sub1_0.anAClass6_Sub2_2.linked()) {
                     node_sub1_0.anAClass6_Sub2_2 = null;
                  }
               }
            } else {
               if (node_sub1_0.anAClass6_Sub2_1 != null) {
                  Class97.anAClass6_Sub1_1.method758(node_sub1_0.anAClass6_Sub2_1);
                  node_sub1_0.anAClass6_Sub2_1 = null;
               }

               if (node_sub1_0.anAClass6_Sub2_2 != null) {
                  Class97.anAClass6_Sub1_1.method758(node_sub1_0.anAClass6_Sub2_2);
                  node_sub1_0.anAClass6_Sub2_2 = null;
               }
            }
         }
      }

   }

   static void method227(int int_0, int int_1, int int_2) {
      int int_3;
      for (int_3 = 0; int_3 < 8; int_3++) {
         for (int int_4 = 0; int_4 < 8; int_4++) {
            Class19.tileHeights[int_0][int_3 + int_1][int_4 + int_2] = 0;
         }
      }

      if (int_1 > 0) {
         for (int_3 = 1; int_3 < 8; int_3++) {
            Class19.tileHeights[int_0][int_1][int_3 + int_2] = Class19.tileHeights[int_0][int_1 - 1][int_3 + int_2];
         }
      }

      if (int_2 > 0) {
         for (int_3 = 1; int_3 < 8; int_3++) {
            Class19.tileHeights[int_0][int_3 + int_1][int_2] = Class19.tileHeights[int_0][int_3 + int_1][int_2 - 1];
         }
      }

      if (int_1 > 0 && Class19.tileHeights[int_0][int_1 - 1][int_2] != 0) {
         Class19.tileHeights[int_0][int_1][int_2] = Class19.tileHeights[int_0][int_1 - 1][int_2];
      } else if (int_2 > 0 && Class19.tileHeights[int_0][int_1][int_2 - 1] != 0) {
         Class19.tileHeights[int_0][int_1][int_2] = Class19.tileHeights[int_0][int_1][int_2 - 1];
      } else if (int_1 > 0 && int_2 > 0 && Class19.tileHeights[int_0][int_1 - 1][int_2 - 1] != 0) {
         Class19.tileHeights[int_0][int_1][int_2] = Class19.tileHeights[int_0][int_1 - 1][int_2 - 1];
      }

   }

}
