import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;

public final class FileOnDisk {

   long position;
   RandomAccessFile file;
   long length;

   public FileOnDisk(File file_0, String string_0, long long_0) throws IOException {
      if (long_0 == -1L) {
         long_0 = Long.MAX_VALUE;
      }

      if (file_0.length() >= long_0) {
         file_0.delete();
      }

      this.file = new RandomAccessFile(file_0, string_0);
      this.length = long_0;
      this.position = 0L;
      int int_0 = this.file.read();
      if (int_0 != -1 && !string_0.equals("r")) {
         this.file.seek(0L);
         this.file.write(int_0);
      }

      this.file.seek(0L);
   }

   public void method76(boolean bool_0) throws IOException {
      if (this.file != null) {
         if (bool_0) {
            try {
               this.file.getFD().sync();
            } catch (SyncFailedException syncfailedexception_0) {
               ;
            }
         }

         this.file.close();
         this.file = null;
      }

   }

   public long length() throws IOException {
      return this.file.length();
   }

   public void close() throws IOException {
      this.method76(false);
   }

   public int read(byte[] bytes_0, int int_0, int int_1) throws IOException {
      int int_2 = this.file.read(bytes_0, int_0, int_1);
      if (int_2 > 0) {
         this.position += (long)int_2;
      }

      return int_2;
   }

   void seek(long long_0) throws IOException {
      this.file.seek(long_0);
      this.position = long_0;
   }

   public void write(byte[] bytes_0, int int_0, int int_1) throws IOException {
      if ((long)int_1 + this.position > this.length) {
         this.file.seek(1L + this.length);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(bytes_0, int_0, int_1);
         this.position += (long)int_1;
      }
   }

   protected void finalize() throws Throwable {
      if (this.file != null) {
         System.out.println("");
         this.close();
      }

   }

   static void drawLoginScreen(Font font_0, Font font_1, Font font_2, boolean bool_0) {
      if (bool_0) {
         Class25.anInt76 = (Tile.canvasWidth - 765) / 2;
         Class25.loginWindowX = Class25.anInt76 + 202;
         Class83.anInt181 = Class25.loginWindowX + 180;
      }

      if (Class25.worldSelectShown) {
         Class12.method166(font_0, font_1);
      } else {
         if (bool_0) {
            Class25.aSpritePixels4.drawImage(Class25.anInt76, 0);
            Class25.aSpritePixels5.drawImage(Class25.anInt76 + 382, 0);
            Class25.logoSprite.drawSprite(Class25.anInt76 + 382 - Class25.logoSprite.originalWidth / 2, 18);
         }

         int int_0;
         if (Client.gameState == 0 || Client.gameState == 5) {
            byte byte_0 = 20;
            font_0.method1039("RuneScape is loading - please wait...", Class25.loginWindowX + 180, 245 - byte_0, 16777215, -1);
            int_0 = 253 - byte_0;
            Rasterizer2D.drawRectangle(Class25.loginWindowX + 180 - 152, int_0, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(Class25.loginWindowX + 180 - 151, int_0 + 1, 302, 32, 0);
            Rasterizer2D.fillRect(Class25.loginWindowX + 180 - 150, int_0 + 2, Class25.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.fillRect(Class25.loadingBarPercentage * 3 + (Class25.loginWindowX + 180 - 150), int_0 + 2, 300 - Class25.loadingBarPercentage * 3, 30, 0);
            font_0.method1039(Class25.loadingText, Class25.loginWindowX + 180, 276 - byte_0, 16777215, -1);
         }

         String string_0;
         String string_1;
         short short_3;
         int int_6;
         short short_4;
         if (Client.gameState == 20) {
            Class25.anIndexedSprite1.drawSprite(Class25.loginWindowX + 180 - Class25.anIndexedSprite1.originalWidth / 2, 271 - Class25.anIndexedSprite1.height / 2);
            short_3 = 201;
            font_0.method1039(Class25.loginMessage1, Class25.loginWindowX + 180, short_3, 16776960, 0);
            int_6 = short_3 + 15;
            font_0.method1039(Class25.loginMessage2, Class25.loginWindowX + 180, int_6, 16776960, 0);
            int_6 += 15;
            font_0.method1039(Class25.loginMessage3, Class25.loginWindowX + 180, int_6, 16776960, 0);
            int_6 += 15;
            int_6 += 7;
            if (Class25.loginIndex != 4) {
               font_0.method1040("Login: ", Class25.loginWindowX + 180 - 110, int_6, 16777215, 0);
               short_4 = 200;
               string_0 = Buffer.preferences.aBool26 ? Class84.method493(Class25.username) : Class25.username;

               for (string_1 = string_0; font_0.method1030(string_1) > short_4; string_1 = string_1.substring(0, string_1.length() - 1)) {
                  ;
               }

               font_0.method1040(FontTypeFace.appendTags(string_1), Class25.loginWindowX + 180 - 70, int_6, 16777215, 0);
               int_6 += 15;
               font_0.method1040("Password: " + Class84.method493(Class25.password), Class25.loginWindowX + 180 - 108, int_6, 16777215, 0);
               int_6 += 15;
            }
         }

         int int_2;
         int int_3;
         int int_7;
         if (Client.gameState == 10 || Client.gameState == 11) {
            Class25.anIndexedSprite1.drawSprite(Class25.loginWindowX, 171);
            short short_0;
            if (Class25.loginIndex == 0) {
               short_3 = 251;
               font_0.method1039("Welcome to RuneScape", Class25.loginWindowX + 180, short_3, 16776960, 0);
               int_6 = short_3 + 30;
               int_0 = Class25.loginWindowX + 180 - 80;
               short_0 = 291;
               Class25.anIndexedSprite2.drawSprite(int_0 - 73, short_0 - 20);
               font_0.method1036("New User", int_0 - 73, short_0 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               int_0 = Class25.loginWindowX + 180 + 80;
               Class25.anIndexedSprite2.drawSprite(int_0 - 73, short_0 - 20);
               font_0.method1036("Existing User", int_0 - 73, short_0 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if (Class25.loginIndex == 1) {
               font_0.method1039(Class25.aString4, Class25.loginWindowX + 180, 201, 16776960, 0);
               short_3 = 236;
               font_0.method1039(Class25.loginMessage1, Class25.loginWindowX + 180, short_3, 16777215, 0);
               int_6 = short_3 + 15;
               font_0.method1039(Class25.loginMessage2, Class25.loginWindowX + 180, int_6, 16777215, 0);
               int_6 += 15;
               font_0.method1039(Class25.loginMessage3, Class25.loginWindowX + 180, int_6, 16777215, 0);
               int_6 += 15;
               int_0 = Class25.loginWindowX + 180 - 80;
               short_0 = 321;
               Class25.anIndexedSprite2.drawSprite(int_0 - 73, short_0 - 20);
               font_0.method1039("Continue", int_0, short_0 + 5, 16777215, 0);
               int_0 = Class25.loginWindowX + 180 + 80;
               Class25.anIndexedSprite2.drawSprite(int_0 - 73, short_0 - 20);
               font_0.method1039("Cancel", int_0, short_0 + 5, 16777215, 0);
            } else if (Class25.loginIndex == 2) {
               short_3 = 201;
               font_0.method1039(Class25.loginMessage1, Class83.anInt181, short_3, 16776960, 0);
               int_6 = short_3 + 15;
               font_0.method1039(Class25.loginMessage2, Class83.anInt181, int_6, 16776960, 0);
               int_6 += 15;
               font_0.method1039(Class25.loginMessage3, Class83.anInt181, int_6, 16776960, 0);
               int_6 += 15;
               int_6 += 7;
               font_0.method1040("Login: ", Class83.anInt181 - 110, int_6, 16777215, 0);
               short_4 = 200;
               string_0 = Buffer.preferences.aBool26 ? Class84.method493(Class25.username) : Class25.username;

               for (string_1 = string_0; font_0.method1030(string_1) > short_4; string_1 = string_1.substring(1)) {
                  ;
               }

               font_0.method1040(FontTypeFace.appendTags(string_1) + (Class25.anInt83 == 0 & Client.gameCycle % 40 < 20 ? Wall.getColTags(16776960) + "|" : ""), Class83.anInt181 - 70, int_6, 16777215, 0);
               int_6 += 15;
               font_0.method1040("Password: " + Class84.method493(Class25.password) + (Class25.anInt83 == 1 & Client.gameCycle % 40 < 20 ? Wall.getColTags(16776960) + "|" : ""), Class83.anInt181 - 108, int_6, 16777215, 0);
               int_6 += 15;
               short_3 = 277;
               int_2 = Class83.anInt181 + -117;
               IndexedSprite indexedsprite_0 = Class45.method275(Class25.aBool9, Class25.aBool10);
               indexedsprite_0.drawSprite(int_2, short_3);
               int_2 = int_2 + indexedsprite_0.originalWidth + 5;
               font_1.method1040("Remember username", int_2, short_3 + 13, 16776960, 0);
               int_2 = Class83.anInt181 + 24;
               indexedsprite_0 = Class45.method275(Buffer.preferences.aBool26, Class25.aBool11);
               indexedsprite_0.drawSprite(int_2, short_3);
               int_2 = int_2 + indexedsprite_0.originalWidth + 5;
               font_1.method1040("Hide username", int_2, short_3 + 13, 16776960, 0);
               int_6 = short_3 + 15;
               int_3 = Class83.anInt181 - 80;
               short short_2 = 321;
               Class25.anIndexedSprite2.drawSprite(int_3 - 73, short_2 - 20);
               font_0.method1039("Login", int_3, short_2 + 5, 16777215, 0);
               int_3 = Class83.anInt181 + 80;
               Class25.anIndexedSprite2.drawSprite(int_3 - 73, short_2 - 20);
               font_0.method1039("Cancel", int_3, short_2 + 5, 16777215, 0);
               short_3 = 357;
               font_1.method1039("Forgotten your password? <col=ffffff>Click here.", Class83.anInt181, short_3, 16776960, 0);
            } else if (Class25.loginIndex == 3) {
               short_3 = 201;
               font_0.method1039("Invalid username or password.", Class25.loginWindowX + 180, short_3, 16776960, 0);
               int_6 = short_3 + 20;
               font_1.method1039("For accounts created after 24th November 2010, please use your", Class25.loginWindowX + 180, int_6, 16776960, 0);
               int_6 += 15;
               font_1.method1039("email address to login. Otherwise please login with your username.", Class25.loginWindowX + 180, int_6, 16776960, 0);
               int_6 += 15;
               int_0 = Class25.loginWindowX + 180;
               short_0 = 276;
               Class25.anIndexedSprite2.drawSprite(int_0 - 73, short_0 - 20);
               font_2.method1039("Try again", int_0, short_0 + 5, 16777215, 0);
               int_0 = Class25.loginWindowX + 180;
               short_0 = 326;
               Class25.anIndexedSprite2.drawSprite(int_0 - 73, short_0 - 20);
               font_2.method1039("Forgotten password?", int_0, short_0 + 5, 16777215, 0);
            } else {
               short short_1;
               if (Class25.loginIndex == 4) {
                  font_0.method1039("Authenticator", Class25.loginWindowX + 180, 201, 16776960, 0);
                  short_3 = 236;
                  font_0.method1039(Class25.loginMessage1, Class25.loginWindowX + 180, short_3, 16777215, 0);
                  int_6 = short_3 + 15;
                  font_0.method1039(Class25.loginMessage2, Class25.loginWindowX + 180, int_6, 16777215, 0);
                  int_6 += 15;
                  font_0.method1039(Class25.loginMessage3, Class25.loginWindowX + 180, int_6, 16777215, 0);
                  int_6 += 15;
                  font_0.method1040("PIN: " + Class84.method493(Class97.aString11) + (Client.gameCycle % 40 < 20 ? Wall.getColTags(16776960) + "|" : ""), Class25.loginWindowX + 180 - 108, int_6, 16777215, 0);
                  int_6 -= 8;
                  font_0.method1040("Trust this computer", Class25.loginWindowX + 180 - 9, int_6, 16776960, 0);
                  int_6 += 15;
                  font_0.method1040("for 30 days: ", Class25.loginWindowX + 180 - 9, int_6, 16776960, 0);
                  int_0 = 180 + Class25.loginWindowX - 9 + font_0.method1030("for 30 days: ") + 15;
                  int_7 = int_6 - font_0.verticalSpace;
                  IndexedSprite indexedsprite_1;
                  if (Class25.aBool12) {
                     indexedsprite_1 = Class107.anIndexedSprite6;
                  } else {
                     indexedsprite_1 = Wall.anIndexedSprite4;
                  }

                  indexedsprite_1.drawSprite(int_0, int_7);
                  int_6 += 15;
                  int_2 = Class25.loginWindowX + 180 - 80;
                  short_1 = 321;
                  Class25.anIndexedSprite2.drawSprite(int_2 - 73, short_1 - 20);
                  font_0.method1039("Continue", int_2, short_1 + 5, 16777215, 0);
                  int_2 = Class25.loginWindowX + 180 + 80;
                  Class25.anIndexedSprite2.drawSprite(int_2 - 73, short_1 - 20);
                  font_0.method1039("Cancel", int_2, short_1 + 5, 16777215, 0);
                  font_1.method1039("<u=ff>Can\'t Log In?</u>", Class25.loginWindowX + 180, short_1 + 36, 255, 0);
               } else if (Class25.loginIndex == 5) {
                  font_0.method1039("Forgotten your password?", Class25.loginWindowX + 180, 201, 16776960, 0);
                  short_3 = 221;
                  font_2.method1039(Class25.loginMessage1, Class25.loginWindowX + 180, short_3, 16776960, 0);
                  int_6 = short_3 + 15;
                  font_2.method1039(Class25.loginMessage2, Class25.loginWindowX + 180, int_6, 16776960, 0);
                  int_6 += 15;
                  font_2.method1039(Class25.loginMessage3, Class25.loginWindowX + 180, int_6, 16776960, 0);
                  int_6 += 15;
                  int_6 += 14;
                  font_0.method1040("Username/email: ", Class25.loginWindowX + 180 - 145, int_6, 16777215, 0);
                  short_4 = 174;
                  string_0 = Buffer.preferences.aBool26 ? Class84.method493(Class25.username) : Class25.username;

                  for (string_1 = string_0; font_0.method1030(string_1) > short_4; string_1 = string_1.substring(1)) {
                     ;
                  }

                  font_0.method1040(FontTypeFace.appendTags(string_1) + (Client.gameCycle % 40 < 20 ? Wall.getColTags(16776960) + "|" : ""), Class25.loginWindowX + 180 - 34, int_6, 16777215, 0);
                  int_6 += 15;
                  int_2 = Class25.loginWindowX + 180 - 80;
                  short_1 = 321;
                  Class25.anIndexedSprite2.drawSprite(int_2 - 73, short_1 - 20);
                  font_0.method1039("Recover", int_2, short_1 + 5, 16777215, 0);
                  int_2 = Class25.loginWindowX + 180 + 80;
                  Class25.anIndexedSprite2.drawSprite(int_2 - 73, short_1 - 20);
                  font_0.method1039("Back", int_2, short_1 + 5, 16777215, 0);
               } else if (Class25.loginIndex == 6) {
                  short_3 = 201;
                  font_0.method1039(Class25.loginMessage1, Class25.loginWindowX + 180, short_3, 16776960, 0);
                  int_6 = short_3 + 15;
                  font_0.method1039(Class25.loginMessage2, Class25.loginWindowX + 180, int_6, 16776960, 0);
                  int_6 += 15;
                  font_0.method1039(Class25.loginMessage3, Class25.loginWindowX + 180, int_6, 16776960, 0);
                  int_6 += 15;
                  int_0 = Class25.loginWindowX + 180;
                  short_0 = 321;
                  Class25.anIndexedSprite2.drawSprite(int_0 - 73, short_0 - 20);
                  font_0.method1039("Back", int_0, short_0 + 5, 16777215, 0);
               }
            }
         }

         if (Class25.anInt81 > 0) {
            int_6 = Class25.anInt81;
            short_4 = 256;
            Class25.anInt79 += int_6 * 128;
            if (Class25.anInt79 > Permission.anIntArray67.length) {
               Class25.anInt79 -= Permission.anIntArray67.length;
               int_7 = (int)(Math.random() * 12.0D);
               Class17.method202(Class25.anIndexedSpriteArray5[int_7]);
            }

            int_7 = 0;
            int int_1 = int_6 * 128;
            int_2 = (short_4 - int_6) * 128;

            int int_8;
            for (int_8 = 0; int_8 < int_2; int_8++) {
               int_3 = CombatInfoListHolder.anIntArray73[int_1 + int_7] - Permission.anIntArray67[int_7 + Class25.anInt79 & Permission.anIntArray67.length - 1] * int_6 / 6;
               if (int_3 < 0) {
                  int_3 = 0;
               }

               CombatInfoListHolder.anIntArray73[int_7++] = int_3;
            }

            int int_4;
            int int_9;
            for (int_8 = short_4 - int_6; int_8 < short_4; int_8++) {
               int_3 = int_8 * 128;

               for (int_9 = 0; int_9 < 128; int_9++) {
                  int_4 = (int)(Math.random() * 100.0D);
                  if (int_4 < 50 && int_9 > 10 && int_9 < 118) {
                     CombatInfoListHolder.anIntArray73[int_3 + int_9] = 255;
                  } else {
                     CombatInfoListHolder.anIntArray73[int_3 + int_9] = 0;
                  }
               }
            }

            if (Class25.anInt77 > 0) {
               Class25.anInt77 -= int_6 * 4;
            }

            if (Class25.anInt78 > 0) {
               Class25.anInt78 -= int_6 * 4;
            }

            if (Class25.anInt77 == 0 && Class25.anInt78 == 0) {
               int_8 = (int)(Math.random() * (double)(2000 / int_6));
               if (int_8 == 0) {
                  Class25.anInt77 = 1024;
               }

               if (int_8 == 1) {
                  Class25.anInt78 = 1024;
               }
            }

            for (int_8 = 0; int_8 < short_4 - int_6; int_8++) {
               Class25.anIntArray16[int_8] = Class25.anIntArray16[int_8 + int_6];
            }

            for (int_8 = short_4 - int_6; int_8 < short_4; int_8++) {
               Class25.anIntArray16[int_8] = (int)(Math.sin((double)Class25.anInt82 / 14.0D) * 16.0D + Math.sin((double)Class25.anInt82 / 15.0D) * 14.0D + Math.sin((double)Class25.anInt82 / 16.0D) * 12.0D);
               ++Class25.anInt82;
            }

            Class25.anInt80 += int_6;
            int_8 = (int_6 + (Client.gameCycle & 0x1)) / 2;
            if (int_8 > 0) {
               for (int_3 = 0; int_3 < Class25.anInt80 * 100; int_3++) {
                  int_9 = (int)(Math.random() * 124.0D) + 2;
                  int_4 = (int)(Math.random() * 128.0D) + 128;
                  CombatInfoListHolder.anIntArray73[int_9 + (int_4 << 7)] = 192;
               }

               Class25.anInt80 = 0;
               int_3 = 0;

               label295:
               while (true) {
                  int int_5;
                  if (int_3 >= short_4) {
                     int_3 = 0;

                     while (true) {
                        if (int_3 >= 128) {
                           break label295;
                        }

                        int_9 = 0;

                        for (int_4 = -int_8; int_4 < short_4; int_4++) {
                           int_5 = int_4 * 128;
                           if (int_8 + int_4 < short_4) {
                              int_9 += Class47.anIntArray23[int_5 + int_3 + int_8 * 128];
                           }

                           if (int_4 - (int_8 + 1) >= 0) {
                              int_9 -= Class47.anIntArray23[int_5 + int_3 - (int_8 + 1) * 128];
                           }

                           if (int_4 >= 0) {
                              CombatInfoListHolder.anIntArray73[int_5 + int_3] = int_9 / (int_8 * 2 + 1);
                           }
                        }

                        ++int_3;
                     }
                  }

                  int_9 = 0;
                  int_4 = int_3 * 128;

                  for (int_5 = -int_8; int_5 < 128; int_5++) {
                     if (int_5 + int_8 < 128) {
                        int_9 += CombatInfoListHolder.anIntArray73[int_4 + int_5 + int_8];
                     }

                     if (int_5 - (int_8 + 1) >= 0) {
                        int_9 -= CombatInfoListHolder.anIntArray73[int_5 + int_4 - (int_8 + 1)];
                     }

                     if (int_5 >= 0) {
                        Class47.anIntArray23[int_4 + int_5] = int_9 / (int_8 * 2 + 1);
                     }
                  }

                  ++int_3;
               }
            }

            Class25.anInt81 = 0;
         }

         Settings.method466();
         Class25.titlemuteSprite[Buffer.preferences.muted ? 1 : 0].drawSprite(Class25.anInt76 + 765 - 40, 463);
         if (Client.gameState > 5 && Client.languageId == 0) {
            if (ItemContainer.anIndexedSprite7 != null) {
               int_6 = Class25.anInt76 + 5;
               short_4 = 463;
               byte byte_2 = 100;
               byte byte_1 = 35;
               ItemContainer.anIndexedSprite7.drawSprite(int_6, short_4);
               font_0.method1039("World" + " " + Client.world, byte_2 / 2 + int_6, byte_1 / 2 + short_4 - 2, 16777215, 0);
               if (TileStrategy.listFetcher != null) {
                  font_1.method1039("Loading...", byte_2 / 2 + int_6, byte_1 / 2 + short_4 + 12, 16777215, 0);
               } else {
                  font_1.method1039("Click to switch", byte_2 / 2 + int_6, byte_1 / 2 + short_4 + 12, 16777215, 0);
               }
            } else {
               ItemContainer.anIndexedSprite7 = CacheableNode_Sub2.getSprite(Class34.spritesIndex, "sl_button", "");
            }
         }

      }
   }

}
