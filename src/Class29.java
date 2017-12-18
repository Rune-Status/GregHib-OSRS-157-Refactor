import java.math.BigInteger;

public class Class29 {

   static final BigInteger RSA_EXPONENT;
   protected static int canvasHeight;
   static final BigInteger RSA_MODULUS;

   static {
      RSA_EXPONENT = new BigInteger("65537");
      RSA_MODULUS = new BigInteger(
              "130432457810679476904565393154427251594638947092754914384116769020036380667550262385684124753868605764278039166596436719051433495807085364990201594984763235100405852515826951420490095148946066976253977346137924586072721620091675779176616902350121341023526402639882943624264270364410054189753410336830705125431");
   }

   static byte[] method233(byte[] bytes_0) {
      int int_0 = bytes_0.length;
      byte[] bytes_1 = new byte[int_0];
      System.arraycopy(bytes_0, 0, bytes_1, 0, int_0);
      return bytes_1;
   }

   public static int method234(int int_0, Class90 class90_0) {
      return (int_0 << 8) + class90_0.anInt190;
   }

   static void method235(Player player_0, int int_0, int int_1, int int_2) {
      if (Class4.localPlayer != player_0) {
         if (Client.menuOptionCount < 400) {
            int int_3;
            String string_2;
            if (player_0.totalLevel == 0) {
               String string_0 = player_0.actions[0] + player_0.name + player_0.actions[1];
               int_3 = player_0.combatLevel;
               int int_4 = Class4.localPlayer.combatLevel;
               int int_5 = int_4 - int_3;
               String string_1;
               if (int_5 < -9) {
                  string_1 = Wall.getColTags(16711680);
               } else if (int_5 < -6) {
                  string_1 = Wall.getColTags(16723968);
               } else if (int_5 < -3) {
                  string_1 = Wall.getColTags(16740352);
               } else if (int_5 < 0) {
                  string_1 = Wall.getColTags(16756736);
               } else if (int_5 > 9) {
                  string_1 = Wall.getColTags(65280);
               } else if (int_5 > 6) {
                  string_1 = Wall.getColTags(4259584);
               } else if (int_5 > 3) {
                  string_1 = Wall.getColTags(8453888);
               } else if (int_5 > 0) {
                  string_1 = Wall.getColTags(12648192);
               } else {
                  string_1 = Wall.getColTags(16776960);
               }

               string_2 = string_0 + string_1 + " " + " (" + "level-" + player_0.combatLevel + ")" + player_0.actions[2];
            } else {
               string_2 = player_0.actions[0] + player_0.name + player_0.actions[1] + " " + " (" + "skill-" + player_0.totalLevel + ")" + player_0.actions[2];
            }

            int int_6;
            if (Client.itemSelectionState == 1) {
               Class24.addMenuEntry("Use", Client.aString35 + " " + "->" + " " + Wall.getColTags(16777215) + string_2, 14, int_0, int_1, int_2);
            } else if (Client.spellSelected) {
               if ((Enum4.anInt381 & 0x8) == 8) {
                  Class24.addMenuEntry(Client.aString34, Client.aString36 + " " + "->" + " " + Wall.getColTags(16777215) + string_2, 15, int_0, int_1, int_2);
               }
            } else {
               for (int_6 = 7; int_6 >= 0; --int_6) {
                  if (Client.playerOptions[int_6] != null) {
                     short short_0 = 0;
                     if (Client.playerOptions[int_6].equalsIgnoreCase("Attack")) {
                        if (Enum2.anEnum2_4 == Client.anEnum2_5) {
                           continue;
                        }

                        if (Client.anEnum2_5 == Enum2.anEnum2_2 || Client.anEnum2_5 == Enum2.anEnum2_1 && player_0.combatLevel > Class4.localPlayer.combatLevel) {
                           short_0 = 2000;
                        }

                        if (Class4.localPlayer.team != 0 && player_0.team != 0) {
                           if (player_0.team == Class4.localPlayer.team) {
                              short_0 = 2000;
                           } else {
                              short_0 = 0;
                           }
                        }
                     } else if (Client.playerOptionsPriorities[int_6]) {
                        short_0 = 2000;
                     }

                     boolean bool_0 = false;
                     int_3 = Client.playerMenuTypes[int_6] + short_0;
                     Class24.addMenuEntry(Client.playerOptions[int_6], Wall.getColTags(16777215) + string_2, int_3, int_0, int_1, int_2);
                  }
               }
            }

            for (int_6 = 0; int_6 < Client.menuOptionCount; int_6++) {
               if (Client.menuTypes[int_6] == 23) {
                  Client.menuTargets[int_6] = Wall.getColTags(16777215) + string_2;
                  break;
               }
            }

         }
      }
   }

}
