import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;

public class Class6 {

   static int[] anIntArray3;
   static IndexData skinsIndex;
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

   static void synchronizePlayers(PacketBuffer buffer) {
      int skip = 0;
      buffer.bitAccess();

      int update;
      for (int index = 0; index < Class27.localPlayerIndexCount; index++) {
         int playerIndex = Class27.localPlayerIndices[index];
         if ((Class27.updateFlags[playerIndex] & 0x1) == 0) {
            if (skip > 0) {
               --skip;
               Class27.updateFlags[playerIndex] = (byte)(Class27.updateFlags[playerIndex] | 0x2);
            } else {
               update = buffer.getBits(1);
               if (update == 0) {
                  skip = Overlay.skipPlayers(buffer);
                  Class27.updateFlags[playerIndex] = (byte)(Class27.updateFlags[playerIndex] | 0x2);
               } else {
                  Class11.decodeMovement(buffer, playerIndex);
               }
            }
         }
      }

      buffer.byteAccess();
      if (skip != 0) {
         throw new RuntimeException();
      } else {
         buffer.bitAccess();

         for (int index = 0; index < Class27.localPlayerIndexCount; index++) {
            int playerIndex = Class27.localPlayerIndices[index];
            if ((Class27.updateFlags[playerIndex] & 0x1) != 0) {
               if (skip > 0) {
                  --skip;
                  Class27.updateFlags[playerIndex] = (byte)(Class27.updateFlags[playerIndex] | 0x2);
               } else {
                  update = buffer.getBits(1);
                  if (update == 0) {
                     skip = Overlay.skipPlayers(buffer);
                     Class27.updateFlags[playerIndex] = (byte)(Class27.updateFlags[playerIndex] | 0x2);
                  } else {
                     Class11.decodeMovement(buffer, playerIndex);
                  }
               }
            }
         }

         buffer.byteAccess();
         if (skip != 0) {
            throw new RuntimeException();
         } else {
            buffer.bitAccess();

            for (int index = 0; index < Class27.externalPlayerCount; index++) {
               int playerIndex = Class27.externalPlayerIndices[index];
               if ((Class27.updateFlags[playerIndex] & 0x1) != 0) {
                  if (skip > 0) {
                     --skip;
                     Class27.updateFlags[playerIndex] = (byte)(Class27.updateFlags[playerIndex] | 0x2);
                  } else {
                     update = buffer.getBits(1);
                     if (update == 0) {
                        skip = Overlay.skipPlayers(buffer);
                        Class27.updateFlags[playerIndex] = (byte)(Class27.updateFlags[playerIndex] | 0x2);
                     } else if (Class7.decodeRegionHash(buffer, playerIndex)) {
                        Class27.updateFlags[playerIndex] = (byte)(Class27.updateFlags[playerIndex] | 0x2);
                     }
                  }
               }
            }

            buffer.byteAccess();
            if (skip != 0) {
               throw new RuntimeException();
            } else {
               buffer.bitAccess();

               for (int index = 0; index < Class27.externalPlayerCount; index++) {
                  int playerIndex = Class27.externalPlayerIndices[index];
                  if ((Class27.updateFlags[playerIndex] & 0x1) == 0) {
                     if (skip > 0) {
                        --skip;
                        Class27.updateFlags[playerIndex] = (byte)(Class27.updateFlags[playerIndex] | 0x2);
                     } else {
                        update = buffer.getBits(1);
                        if (update == 0) {
                           skip = Overlay.skipPlayers(buffer);
                           Class27.updateFlags[playerIndex] = (byte)(Class27.updateFlags[playerIndex] | 0x2);
                        } else if (Class7.decodeRegionHash(buffer, playerIndex)) {
                           Class27.updateFlags[playerIndex] = (byte)(Class27.updateFlags[playerIndex] | 0x2);
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

                  for (int index = 1; index < 2048; index++) {
                     Class27.updateFlags[index] = (byte)(Class27.updateFlags[index] >> 1);
                     Player player = Client.players[index];
                     if (player != null) {
                        Class27.localPlayerIndices[++Class27.localPlayerIndexCount - 1] = index;
                     } else {
                        Class27.externalPlayerIndices[++Class27.externalPlayerCount - 1] = index;
                     }
                  }

               }
            }
         }
      }
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
