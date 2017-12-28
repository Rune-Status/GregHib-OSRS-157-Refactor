public class Class27 {

   static byte[] updateFlags;
   static byte[] aByteArray3;
   static Buffer[] playerSynchronizationBuffers;
   static int localPlayerIndexCount;
   static int[] localPlayerIndices;
   static int externalPlayerCount;
   static int[] externalPlayerIndices;
   static int[] locationHashes;
   static int[] orientations;
   static int[] interactions;
   static int playerCount;
   static int[] playersAwaitingUpdate;
   static Buffer chatBuffer;

   static {
      updateFlags = new byte[2048];
      aByteArray3 = new byte[2048];
      playerSynchronizationBuffers = new Buffer[2048];
      localPlayerIndexCount = 0;
      localPlayerIndices = new int[2048];
      externalPlayerCount = 0;
      externalPlayerIndices = new int[2048];
      locationHashes = new int[2048];
      orientations = new int[2048];
      interactions = new int[2048];
      playerCount = 0;
      playersAwaitingUpdate = new int[2048];
      chatBuffer = new Buffer(new byte[5000]);
   }

   static void method226(int int_0, int int_1, int int_2, int int_3) {
      for (AudioObject audioObject_0 = (AudioObject) AudioObject.aDeque3.getFront(); audioObject_0 != null; audioObject_0 = (AudioObject) AudioObject.aDeque3.getNext()) {
         if (audioObject_0.ambientSound != -1 || audioObject_0.anIntArray72 != null) {
            int int_4 = 0;
            if (int_1 > audioObject_0.anInt319) {
               int_4 += int_1 - audioObject_0.anInt319;
            } else if (int_1 < audioObject_0.x) {
               int_4 += audioObject_0.x - int_1;
            }

            if (int_2 > audioObject_0.anInt321) {
               int_4 += int_2 - audioObject_0.anInt321;
            } else if (int_2 < audioObject_0.y) {
               int_4 += audioObject_0.y - int_2;
            }

            if (int_4 - 64 <= audioObject_0.anInt316 && Client.anInt646 != 0 && int_0 == audioObject_0.plane) {
               int_4 -= 64;
               if (int_4 < 0) {
                  int_4 = 0;
               }

               int int_5 = (audioObject_0.anInt316 - int_4) * Client.anInt646 / audioObject_0.anInt316;
               if (audioObject_0.anAClass6_Sub2_1 == null) {
                  if (audioObject_0.ambientSound >= 0) {
                     SoundEffect soundeffect_0 = SoundEffect.getTrack(Tile.soundEffectsIndex, audioObject_0.ambientSound, 0);
                     if (soundeffect_0 != null) {
                        AClass4_Sub1 aclass4_sub1_0 = soundeffect_0.method421().method761(Class87.aClass51_1);
                        AClass6_Sub2 aclass6_sub2_0 = AClass6_Sub2.method804(aclass4_sub1_0, 100, int_5);
                        aclass6_sub2_0.method782(-1);
                        Class97.anAClass6_Sub1_1.method757(aclass6_sub2_0);
                        audioObject_0.anAClass6_Sub2_1 = aclass6_sub2_0;
                     }
                  }
               } else {
                  audioObject_0.anAClass6_Sub2_1.method784(int_5);
               }

               if (audioObject_0.anAClass6_Sub2_2 == null) {
                  if (audioObject_0.anIntArray72 != null && (audioObject_0.anInt324 -= int_3) <= 0) {
                     int int_6 = (int)(Math.random() * (double) audioObject_0.anIntArray72.length);
                     SoundEffect soundeffect_1 = SoundEffect.getTrack(Tile.soundEffectsIndex, audioObject_0.anIntArray72[int_6], 0);
                     if (soundeffect_1 != null) {
                        AClass4_Sub1 aclass4_sub1_1 = soundeffect_1.method421().method761(Class87.aClass51_1);
                        AClass6_Sub2 aclass6_sub2_1 = AClass6_Sub2.method804(aclass4_sub1_1, 100, int_5);
                        aclass6_sub2_1.method782(0);
                        Class97.anAClass6_Sub1_1.method757(aclass6_sub2_1);
                        audioObject_0.anAClass6_Sub2_2 = aclass6_sub2_1;
                        audioObject_0.anInt324 = audioObject_0.anInt317 + (int)(Math.random() * (double)(audioObject_0.anInt318 - audioObject_0.anInt317));
                     }
                  }
               } else {
                  audioObject_0.anAClass6_Sub2_2.method784(int_5);
                  if (!audioObject_0.anAClass6_Sub2_2.linked()) {
                     audioObject_0.anAClass6_Sub2_2 = null;
                  }
               }
            } else {
               if (audioObject_0.anAClass6_Sub2_1 != null) {
                  Class97.anAClass6_Sub1_1.method758(audioObject_0.anAClass6_Sub2_1);
                  audioObject_0.anAClass6_Sub2_1 = null;
               }

               if (audioObject_0.anAClass6_Sub2_2 != null) {
                  Class97.anAClass6_Sub1_1.method758(audioObject_0.anAClass6_Sub2_2);
                  audioObject_0.anAClass6_Sub2_2 = null;
               }
            }
         }
      }

   }

}
