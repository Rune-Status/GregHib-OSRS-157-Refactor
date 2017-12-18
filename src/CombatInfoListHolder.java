import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.lang.management.GarbageCollectorMXBean;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class CombatInfoListHolder extends Node {

   public static int anInt329;
   static SpritePixels[] aSpritePixelsArray2;
   static int[] anIntArray73;
   static GarbageCollectorMXBean aGarbageCollectorMXBean1;
   CombatInfoList combatInfo1;
   CombatInfo2 combatInfo2;

   CombatInfoListHolder(CombatInfo2 combatinfo2_0) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = combatinfo2_0;
   }

   void method648(int int_0, int int_1, int int_2, int int_3) {
      CombatInfo1 combatinfo1_0 = null;
      int int_4 = 0;

      for (CombatInfo1 combatinfo1_1 = (CombatInfo1) this.combatInfo1.method454(); combatinfo1_1 != null; combatinfo1_1 = (CombatInfo1) this.combatInfo1.method456()) {
         ++int_4;
         if (combatinfo1_1.anInt352 == int_0) {
            combatinfo1_1.method687(int_0, int_1, int_2, int_3);
            return;
         }

         if (combatinfo1_1.anInt352 <= int_0) {
            combatinfo1_0 = combatinfo1_1;
         }
      }

      if (combatinfo1_0 == null) {
         if (int_4 < 4) {
            this.combatInfo1.method457(new CombatInfo1(int_0, int_1, int_2, int_3));
         }

      } else {
         CombatInfoList.method459(new CombatInfo1(int_0, int_1, int_2, int_3), combatinfo1_0);
         if (int_4 >= 4) {
            this.combatInfo1.method454().unlink();
         }

      }
   }

   CombatInfo1 method649(int int_0) {
      CombatInfo1 combatinfo1_0 = (CombatInfo1) this.combatInfo1.method454();
      if (combatinfo1_0 != null && combatinfo1_0.anInt352 <= int_0) {
         for (CombatInfo1 combatinfo1_1 = (CombatInfo1) this.combatInfo1.method456(); combatinfo1_1 != null && combatinfo1_1.anInt352 <= int_0; combatinfo1_1 = (CombatInfo1) this.combatInfo1.method456()) {
            combatinfo1_0.unlink();
            combatinfo1_0 = combatinfo1_1;
         }

         if (this.combatInfo2.anInt457 + combatinfo1_0.anInt352 + combatinfo1_0.anInt353 > int_0) {
            return combatinfo1_0;
         } else {
            combatinfo1_0.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   boolean method650() {
      return this.combatInfo1.method452();
   }

   public static boolean loadWidget(int id) {
      if (AClass3_Sub1.validInterfaces[id]) {
         return true;
      } else if (!Class5.widgetIndex.containsFile(id)) {
         return false;
      } else {
         int int_1 = Class5.widgetIndex.fileCount(id);
         if (int_1 == 0) {
            AClass3_Sub1.validInterfaces[id] = true;
            return true;
         } else {
            if (Class91.widgets[id] == null) {
               Class91.widgets[id] = new Widget[int_1];
            }

            for (int int_2 = 0; int_2 < int_1; int_2++) {
               if (Class91.widgets[id][int_2] == null) {
                  byte[] bytes_0 = Class5.widgetIndex.getConfigData(id, int_2);
                  if (bytes_0 != null) {
                     Class91.widgets[id][int_2] = new Widget();
                     Class91.widgets[id][int_2].id = int_2 + (id << 16);
                     if (bytes_0[0] == -1) {
                        Class91.widgets[id][int_2].decodeActive(new Buffer(bytes_0));
                     } else {
                        Class91.widgets[id][int_2].decode(new Buffer(bytes_0));
                     }
                  }
               }
            }

            AClass3_Sub1.validInterfaces[id] = true;
            return true;
         }
      }
   }

   public static void method651() {
      Varbit.varbits.reset();
   }

   static void method652() {
      Class25.username = Class25.username.trim();
      if (Class25.username.length() == 0) {
         AClass3_Sub1.method750("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long long_0 = FaceNormal.method567();
         byte byte_0;
         if (long_0 == 0L) {
            byte_0 = 5;
         } else {
            String string_0 = Class25.username;
            Random random_0 = new Random();
            Buffer buffer_0 = new Buffer(128);
            Buffer buffer_1 = new Buffer(128);
            int[] ints_0 = new int[] {random_0.nextInt(), random_0.nextInt(), (int)(long_0 >> 32), (int)long_0};
            buffer_0.putByte(10);

            int int_0;
            for (int_0 = 0; int_0 < 4; int_0++) {
               buffer_0.putInt(random_0.nextInt());
            }

            buffer_0.putInt(ints_0[0]);
            buffer_0.putInt(ints_0[1]);
            buffer_0.putLong(long_0);
            buffer_0.putLong(0L);

            for (int_0 = 0; int_0 < 4; int_0++) {
               buffer_0.putInt(random_0.nextInt());
            }

            buffer_0.encryptRsa(Class32.aBigInteger3, Class32.aBigInteger4);
            buffer_1.putByte(10);

            for (int_0 = 0; int_0 < 3; int_0++) {
               buffer_1.putInt(random_0.nextInt());
            }

            buffer_1.putLong(random_0.nextLong());
            buffer_1.method730(random_0.nextLong());
            Node_Sub5.method695(buffer_1);
            buffer_1.putLong(random_0.nextLong());
            buffer_1.encryptRsa(Class32.aBigInteger3, Class32.aBigInteger4);
            int_0 = Projectile.getLength(string_0);
            if (int_0 % 8 != 0) {
               int_0 += 8 - int_0 % 8;
            }

            Buffer buffer_2 = new Buffer(int_0);
            buffer_2.putString(string_0);
            buffer_2.position = int_0;
            buffer_2.encryptXtea2(ints_0);
            Buffer buffer_3 = new Buffer(buffer_1.position + buffer_0.position + buffer_2.position + 5);
            buffer_3.putByte(2);
            buffer_3.putByte(buffer_0.position);
            buffer_3.putBytes(buffer_0.buffer, 0, buffer_0.position);
            buffer_3.putByte(buffer_1.position);
            buffer_3.putBytes(buffer_1.buffer, 0, buffer_1.position);
            buffer_3.putShort(buffer_2.position);
            buffer_3.putBytes(buffer_2.buffer, 0, buffer_2.position);
            byte[] bytes_0 = buffer_3.buffer;
            int int_1 = bytes_0.length;
            StringBuilder stringbuilder_0 = new StringBuilder();

            int int_4;
            for (int int_2 = 0; int_2 < int_1 + 0; int_2 += 3) {
               int int_3 = bytes_0[int_2] & 0xFF;
               stringbuilder_0.append(Class98.aCharArray2[int_3 >>> 2]);
               if (int_2 < int_1 - 1) {
                  int_4 = bytes_0[int_2 + 1] & 0xFF;
                  stringbuilder_0.append(Class98.aCharArray2[(int_3 & 0x3) << 4 | int_4 >>> 4]);
                  if (int_2 < int_1 - 2) {
                     int int_5 = bytes_0[int_2 + 2] & 0xFF;
                     stringbuilder_0.append(Class98.aCharArray2[(int_4 & 0xF) << 2 | int_5 >>> 6]).append(Class98.aCharArray2[int_5 & 0x3F]);
                  } else {
                     stringbuilder_0.append(Class98.aCharArray2[(int_4 & 0xF) << 2]).append("=");
                  }
               } else {
                  stringbuilder_0.append(Class98.aCharArray2[(int_3 & 0x3) << 4]).append("==");
               }
            }

            String string_1 = stringbuilder_0.toString();
            string_1 = string_1;

            byte byte_1;
            try {
               URL url_0 = new URL(Class28.method230("services", false) + "m=accountappeal/login.ws");
               URLConnection urlconnection_0 = url_0.openConnection();
               urlconnection_0.setDoInput(true);
               urlconnection_0.setDoOutput(true);
               urlconnection_0.setConnectTimeout(5000);
               OutputStreamWriter outputstreamwriter_0 = new OutputStreamWriter(urlconnection_0.getOutputStream());
               outputstreamwriter_0.write("data2=" + Class33.method242(string_1) + "&dest=" + Class33.method242("passwordchoice.ws"));
               outputstreamwriter_0.flush();
               InputStream inputstream_0 = urlconnection_0.getInputStream();
               buffer_3 = new Buffer(new byte[1000]);

               while (true) {
                  int_4 = inputstream_0.read(buffer_3.buffer, buffer_3.position, 1000 - buffer_3.position);
                  if (int_4 == -1) {
                     outputstreamwriter_0.close();
                     inputstream_0.close();
                     String string_2 = new String(buffer_3.buffer);
                     if (string_2.startsWith("OFFLINE")) {
                        byte_1 = 4;
                     } else if (string_2.startsWith("WRONG")) {
                        byte_1 = 7;
                     } else if (string_2.startsWith("RELOAD")) {
                        byte_1 = 3;
                     } else if (string_2.startsWith("Not permitted for social network accounts.")) {
                        byte_1 = 6;
                     } else {
                        buffer_3.decryptXtea(ints_0);

                        while (buffer_3.position > 0 && buffer_3.buffer[buffer_3.position - 1] == 0) {
                           --buffer_3.position;
                        }

                        string_2 = new String(buffer_3.buffer, 0, buffer_3.position);
                        if (Class6.method100(string_2)) {
                           Class53.method350(string_2, true, false);
                           byte_1 = 2;
                        } else {
                           byte_1 = 5;
                        }
                     }
                     break;
                  }

                  buffer_3.position += int_4;
                  if (buffer_3.position >= 1000) {
                     byte_1 = 5;
                     break;
                  }
               }
            } catch (Throwable throwable_0) {
               throwable_0.printStackTrace();
               byte_1 = 5;
            }

            byte_0 = byte_1;
         }

         switch(byte_0) {
         case 2:
            AClass3_Sub1.method750("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            Class25.loginIndex = 6;
            break;
         case 3:
            AClass3_Sub1.method750("", "Error connecting to server.", "");
            break;
         case 4:
            AClass3_Sub1.method750("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            AClass3_Sub1.method750("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            AClass3_Sub1.method750("", "Error connecting to server.", "");
            break;
         case 7:
            AClass3_Sub1.method750("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   static void method653() {
      for (Projectile projectile_0 = (Projectile) Client.projectiles.getFront(); projectile_0 != null; projectile_0 = (Projectile) Client.projectiles.getNext()) {
         if (projectile_0.floor == Ignore.plane && Client.gameCycle <= projectile_0.cycle) {
            if (Client.gameCycle >= projectile_0.startTime) {
               if (projectile_0.interacting > 0) {
                  NPC npc_0 = Client.cachedNPCs[projectile_0.interacting - 1];
                  if (npc_0 != null && npc_0.x >= 0 && npc_0.x < 13312 && npc_0.y >= 0 && npc_0.y < 13312) {
                     projectile_0.method1005(npc_0.x, npc_0.y, Class18.getTileHeight(npc_0.x, npc_0.y, projectile_0.floor) - projectile_0.endHeight, Client.gameCycle);
                  }
               }

               if (projectile_0.interacting < 0) {
                  int int_0 = -projectile_0.interacting - 1;
                  Player player_0;
                  if (int_0 == Client.localInteractingIndex) {
                     player_0 = Class4.localPlayer;
                  } else {
                     player_0 = Client.players[int_0];
                  }

                  if (player_0 != null && player_0.x >= 0 && player_0.x < 13312 && player_0.y >= 0 && player_0.y < 13312) {
                     projectile_0.method1005(player_0.x, player_0.y, Class18.getTileHeight(player_0.x, player_0.y, projectile_0.floor) - projectile_0.endHeight, Client.gameCycle);
                  }
               }

               projectile_0.method1006(Client.anInt625);
               Class23.sceneGraph.method377(Ignore.plane, (int)projectile_0.x, (int)projectile_0.velocityZ, (int)projectile_0.z, 60, projectile_0, projectile_0.rotationX, -1, false);
            }
         } else {
            projectile_0.unlink();
         }
      }

   }

}
