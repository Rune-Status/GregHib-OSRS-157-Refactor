import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;

public class Class6 {

   static int[] anIntArray3;
   static IndexData indexSoundEffects;
   final int anInt37;
   final int anInt38;
   final int anInt39;

   Class6(int int_0, int int_1, int int_2) {
      this.anInt37 = int_0;
      this.anInt38 = int_1;
      this.anInt39 = int_2;
   }

   static void method97(Component component_0) {
      component_0.addMouseListener(MouseInput.mouse);
      component_0.addMouseMotionListener(MouseInput.mouse);
      component_0.addFocusListener(MouseInput.mouse);
   }

   static synchronized byte[] method98(int int_0) {
      return Class62.method395(int_0, false);
   }

   static void method99(PacketBuffer buffer) {
      int skip = 0;
      buffer.bitAccess();

      int int_1;
      int int_2;
      int update;
      for (int_1 = 0; int_1 < Class27.localPlayerIndexCount; int_1++) {
         int_2 = Class27.localPlayerIndices[int_1];
         if ((Class27.updateFlags[int_2] & 0x1) == 0) {
            if (skip > 0) {
               --skip;
               Class27.updateFlags[int_2] = (byte)(Class27.updateFlags[int_2] | 0x2);
            } else {
               update = buffer.getBits(1);
               if (update == 0) {
                  skip = Overlay.skipPlayers(buffer);
                  Class27.updateFlags[int_2] = (byte)(Class27.updateFlags[int_2] | 0x2);
               } else {
                  Class11.decodeMovement(buffer, int_2);
               }
            }
         }
      }

      buffer.byteAccess();
      if (skip != 0) {
         throw new RuntimeException();
      } else {
         buffer.bitAccess();

         for (int_1 = 0; int_1 < Class27.localPlayerIndexCount; int_1++) {
            int_2 = Class27.localPlayerIndices[int_1];
            if ((Class27.updateFlags[int_2] & 0x1) != 0) {
               if (skip > 0) {
                  --skip;
                  Class27.updateFlags[int_2] = (byte)(Class27.updateFlags[int_2] | 0x2);
               } else {
                  update = buffer.getBits(1);
                  if (update == 0) {
                     skip = Overlay.skipPlayers(buffer);
                     Class27.updateFlags[int_2] = (byte)(Class27.updateFlags[int_2] | 0x2);
                  } else {
                     Class11.decodeMovement(buffer, int_2);
                  }
               }
            }
         }

         buffer.byteAccess();
         if (skip != 0) {
            throw new RuntimeException();
         } else {
            buffer.bitAccess();

            for (int_1 = 0; int_1 < Class27.externalPlayerCount; int_1++) {
               int_2 = Class27.externalPlayerIndices[int_1];
               if ((Class27.updateFlags[int_2] & 0x1) != 0) {
                  if (skip > 0) {
                     --skip;
                     Class27.updateFlags[int_2] = (byte)(Class27.updateFlags[int_2] | 0x2);
                  } else {
                     update = buffer.getBits(1);
                     if (update == 0) {
                        skip = Overlay.skipPlayers(buffer);
                        Class27.updateFlags[int_2] = (byte)(Class27.updateFlags[int_2] | 0x2);
                     } else if (Class7.decodeRegionHash(buffer, int_2)) {
                        Class27.updateFlags[int_2] = (byte)(Class27.updateFlags[int_2] | 0x2);
                     }
                  }
               }
            }

            buffer.byteAccess();
            if (skip != 0) {
               throw new RuntimeException();
            } else {
               buffer.bitAccess();

               for (int_1 = 0; int_1 < Class27.externalPlayerCount; int_1++) {
                  int_2 = Class27.externalPlayerIndices[int_1];
                  if ((Class27.updateFlags[int_2] & 0x1) == 0) {
                     if (skip > 0) {
                        --skip;
                        Class27.updateFlags[int_2] = (byte)(Class27.updateFlags[int_2] | 0x2);
                     } else {
                        update = buffer.getBits(1);
                        if (update == 0) {
                           skip = Overlay.skipPlayers(buffer);
                           Class27.updateFlags[int_2] = (byte)(Class27.updateFlags[int_2] | 0x2);
                        } else if (Class7.decodeRegionHash(buffer, int_2)) {
                           Class27.updateFlags[int_2] = (byte)(Class27.updateFlags[int_2] | 0x2);
                        }
                     }
                  }
               }

               buffer.byteAccess();
               if (skip != 0) {
                  throw new RuntimeException();
               } else {
                  Class27.localPlayerIndexCount = 0;
                  Class27.externalPlayerCount = 0;

                  for (int_1 = 1; int_1 < 2048; int_1++) {
                     Class27.updateFlags[int_1] = (byte)(Class27.updateFlags[int_1] >> 1);
                     Player player = Client.cachedPlayers[int_1];
                     if (player != null) {
                        Class27.localPlayerIndices[++Class27.localPlayerIndexCount - 1] = int_1;
                     } else {
                        Class27.externalPlayerIndices[++Class27.externalPlayerCount - 1] = int_1;
                     }
                  }

               }
            }
         }
      }
   }

   static int getSmoothNoise(int int_0, int int_1, int int_2) {
      int int_3 = int_0 / int_2;
      int int_4 = int_0 & int_2 - 1;
      int int_5 = int_1 / int_2;
      int int_6 = int_1 & int_2 - 1;
      int int_7 = Class21.getSmoothNoise2D(int_3, int_5);
      int int_8 = Class21.getSmoothNoise2D(int_3 + 1, int_5);
      int int_9 = Class21.getSmoothNoise2D(int_3, int_5 + 1);
      int int_10 = Class21.getSmoothNoise2D(int_3 + 1, int_5 + 1);
      int int_11 = Class63.method400(int_7, int_8, int_4, int_2);
      int int_12 = Class63.method400(int_9, int_10, int_4, int_2);
      return Class63.method400(int_11, int_12, int_6, int_2);
   }

   static boolean method100(String string_0) {
      if (string_0 == null) {
         return false;
      } else {
         try {
            new URL(string_0);
            return true;
         } catch (MalformedURLException malformedurlexception_0) {
            return false;
         }
      }
   }

}
