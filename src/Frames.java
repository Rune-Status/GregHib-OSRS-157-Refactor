public class Frames extends CacheableNode {

   Frame[] skeletons;

   public Frames(IndexDataBase indexdatabase_0, IndexDataBase indexdatabase_1, int int_0, boolean bool_0) {
      Deque deque_0 = new Deque();
      int int_1 = indexdatabase_0.fileCount(int_0);
      this.skeletons = new Frame[int_1];
      int[] ints_0 = indexdatabase_0.getChilds(int_0);

      for (int int_2 = 0; int_2 < ints_0.length; int_2++) {
         byte[] bytes_0 = indexdatabase_0.getConfigData(int_0, ints_0[int_2]);
         FrameMap framemap_0 = null;
         int int_3 = (bytes_0[0] & 0xFF) << 8 | bytes_0[1] & 0xFF;

         for (FrameMap framemap_1 = (FrameMap) deque_0.getFront(); framemap_1 != null; framemap_1 = (FrameMap) deque_0.getNext()) {
            if (int_3 == framemap_1.id) {
               framemap_0 = framemap_1;
               break;
            }
         }

         if (framemap_0 == null) {
            byte[] bytes_1 = indexdatabase_1.getChild(int_3, 0);
            framemap_0 = new FrameMap(int_3, bytes_1);
            deque_0.addFront(framemap_0);
         }

         this.skeletons[ints_0[int_2]] = new Frame(bytes_0, framemap_0);
      }

   }

   public boolean method871(int int_0) {
      return this.skeletons[int_0].showing;
   }

   static void method872(GameEngine gameengine_0) {
      if (Class25.worldSelectShown) {
         Class50.method317(gameengine_0);
      } else {
         if ((MouseInput.anInt259 == 1 || !Item.aBool73 && MouseInput.anInt259 == 4) && MouseInput.anInt264 >= Class25.anInt76 + 765 - 50 && MouseInput.anInt265 >= 453) {
            Buffer.preferences.muted = !Buffer.preferences.muted;
            Class59.method390();
            if (!Buffer.preferences.muted) {
               AClass3.method644(Class38.indexTrack1, "scape main", "", 255, false);
            } else {
               ItemLayer.method545();
            }
         }

         if (Client.gameState != 5) {
            ++Class25.anInt81;
            if (Client.gameState == 10 || Client.gameState == 11) {
               int int_0;
               if (Client.languageId == 0) {
                  if (MouseInput.anInt259 == 1 || !Item.aBool73 && MouseInput.anInt259 == 4) {
                     int_0 = Class25.anInt76 + 5;
                     short short_0 = 463;
                     byte byte_0 = 100;
                     byte byte_1 = 35;
                     if (MouseInput.anInt264 >= int_0 && MouseInput.anInt264 <= byte_0 + int_0 && MouseInput.anInt265 >= short_0 && MouseInput.anInt265 <= short_0 + byte_1) {
                        if (AClass3_Sub1.loadWorlds()) {
                           Class25.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if (AClass2_Sub1.listFetcher != null && AClass3_Sub1.loadWorlds()) {
                     Class25.worldSelectShown = true;
                  }
               }

               int_0 = MouseInput.anInt259;
               int int_3 = MouseInput.anInt264;
               int int_4 = MouseInput.anInt265;
               if (int_0 == 0) {
                  int_3 = MouseInput.anInt260;
                  int_4 = MouseInput.anInt262;
               }

               if (!Item.aBool73 && int_0 == 4) {
                  int_0 = 1;
               }

               int int_1;
               short short_1;
               if (Class25.loginIndex == 0) {
                  boolean bool_1 = false;

                  while (Class11.method163()) {
                     if (CombatInfoListHolder.anInt329 == 84) {
                        bool_1 = true;
                     }
                  }

                  int_1 = Class83.anInt181 - 80;
                  short_1 = 291;
                  if (int_0 == 1 && int_3 >= int_1 - 75 && int_3 <= int_1 + 75 && int_4 >= short_1 - 20 && int_4 <= short_1 + 20) {
                     Class53.method350(Class28.method230("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  int_1 = Class83.anInt181 + 80;
                  if (int_0 == 1 && int_3 >= int_1 - 75 && int_3 <= int_1 + 75 && int_4 >= short_1 - 20 && int_4 <= short_1 + 20 || bool_1) {
                     if ((Client.flags & 0x2000000) != 0) {
                        Class25.aString4 = "";
                        Class25.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        Class25.loginMessage2 = "Your normal account will not be affected.";
                        Class25.loginMessage3 = "";
                        Class25.loginIndex = 1;
                        AClass2_Sub1.method631();
                     } else if ((Client.flags & 0x4) != 0) {
                        if ((Client.flags & 0x400) != 0) {
                           Class25.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           Class25.loginMessage2 = "Players can attack each other almost everywhere";
                           Class25.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           Class25.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           Class25.loginMessage2 = "Players can attack each other";
                           Class25.loginMessage3 = "almost everywhere.";
                        }

                        Class25.aString4 = "Warning!";
                        Class25.loginIndex = 1;
                        AClass2_Sub1.method631();
                     } else if ((Client.flags & 0x400) != 0) {
                        Class25.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        Class25.loginMessage2 = "The Protect Item prayer will";
                        Class25.loginMessage3 = "not work on this world.";
                        Class25.aString4 = "Warning!";
                        Class25.loginIndex = 1;
                        AClass2_Sub1.method631();
                     } else {
                        WorldMapType1.method580(false);
                     }
                  }
               } else {
                  int int_5;
                  short short_3;
                  if (Class25.loginIndex != 1) {
                     short short_2;
                     if (Class25.loginIndex == 2) {
                        short_2 = 201;
                        int_5 = short_2 + 52;
                        if (int_0 == 1 && int_4 >= int_5 - 12 && int_4 < int_5 + 2) {
                           Class25.anInt83 = 0;
                        }

                        int_5 += 15;
                        if (int_0 == 1 && int_4 >= int_5 - 12 && int_4 < int_5 + 2) {
                           Class25.anInt83 = 1;
                        }

                        int_5 += 15;
                        short_2 = 361;
                        if (int_0 == 1 && int_4 >= short_2 - 15 && int_4 < short_2) {
                           AClass3_Sub1.method750("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           Class25.loginIndex = 5;
                           return;
                        }

                        int_1 = Class83.anInt181 - 80;
                        short_1 = 321;
                        if (int_0 == 1 && int_3 >= int_1 - 75 && int_3 <= int_1 + 75 && int_4 >= short_1 - 20 && int_4 <= short_1 + 20) {
                           Class25.username = Class25.username.trim();
                           if (Class25.username.length() == 0) {
                              AClass3_Sub1.method750("", "Please enter your username/email address.", "");
                              return;
                           }

                           if (Class25.password.length() == 0) {
                              AClass3_Sub1.method750("", "Please enter your password.", "");
                              return;
                           }

                           AClass3_Sub1.method750("", "Connecting to server...", "");
                           Permission.method599(false);
                           Class110.setGameState(20);
                           return;
                        }

                        int_1 = Class25.loginWindowX + 180 + 80;
                        if (int_0 == 1 && int_3 >= int_1 - 75 && int_3 <= int_1 + 75 && int_4 >= short_1 - 20 && int_4 <= short_1 + 20) {
                           Class25.loginIndex = 0;
                           Class25.username = "";
                           Class25.password = "";
                           Class34.playerPin = 0;
                           Class97.aString11 = "";
                           Class25.aBool12 = true;
                        }

                        int_1 = Class83.anInt181 + -117;
                        short_1 = 277;
                        Class25.aBool10 = int_3 >= int_1 && int_3 < int_1 + WorldMapData_Sub1.anInt303 && int_4 >= short_1 && int_4 < short_1 + Class25.anInt85;
                        if (int_0 == 1 && Class25.aBool10) {
                           Class25.aBool9 = !Class25.aBool9;
                           if (!Class25.aBool9 && Buffer.preferences.aString10 != null) {
                              Buffer.preferences.aString10 = null;
                              Class59.method390();
                           }
                        }

                        int_1 = Class83.anInt181 + 24;
                        short_1 = 277;
                        Class25.aBool11 = int_3 >= int_1 && int_3 < int_1 + WorldMapData_Sub1.anInt303 && int_4 >= short_1 && int_4 < short_1 + Class25.anInt85;
                        if (int_0 == 1 && Class25.aBool11) {
                           Buffer.preferences.aBool26 = !Buffer.preferences.aBool26;
                           if (!Buffer.preferences.aBool26) {
                              Class25.username = "";
                              Buffer.preferences.aString10 = null;
                              AClass2_Sub1.method631();
                           }

                           Class59.method390();
                        }

                        while (true) {
                           while (Class11.method163()) {
                              boolean bool_0 = false;

                              for (int int_2 = 0; int_2 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); int_2++) {
                                 if (Class106.aChar1 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(int_2)) {
                                    bool_0 = true;
                                    break;
                                 }
                              }

                              if (CombatInfoListHolder.anInt329 == 13) {
                                 Class25.loginIndex = 0;
                                 Class25.username = "";
                                 Class25.password = "";
                                 Class34.playerPin = 0;
                                 Class97.aString11 = "";
                                 Class25.aBool12 = true;
                              } else if (Class25.anInt83 == 0) {
                                 if (CombatInfoListHolder.anInt329 == 85 && Class25.username.length() > 0) {
                                    Class25.username = Class25.username.substring(0, Class25.username.length() - 1);
                                 }

                                 if (CombatInfoListHolder.anInt329 == 84 || CombatInfoListHolder.anInt329 == 80) {
                                    Class25.anInt83 = 1;
                                 }

                                 if (bool_0 && Class25.username.length() < 320) {
                                    Class25.username = Class25.username + Class106.aChar1;
                                 }
                              } else if (Class25.anInt83 == 1) {
                                 if (CombatInfoListHolder.anInt329 == 85 && Class25.password.length() > 0) {
                                    Class25.password = Class25.password.substring(0, Class25.password.length() - 1);
                                 }

                                 if (CombatInfoListHolder.anInt329 == 84 || CombatInfoListHolder.anInt329 == 80) {
                                    Class25.anInt83 = 0;
                                 }

                                 if (CombatInfoListHolder.anInt329 == 84) {
                                    Class25.username = Class25.username.trim();
                                    if (Class25.username.length() == 0) {
                                       AClass3_Sub1.method750("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if (Class25.password.length() == 0) {
                                       AClass3_Sub1.method750("", "Please enter your password.", "");
                                       return;
                                    }

                                    AClass3_Sub1.method750("", "Connecting to server...", "");
                                    Permission.method599(false);
                                    Class110.setGameState(20);
                                    return;
                                 }

                                 if (bool_0 && Class25.password.length() < 20) {
                                    Class25.password = Class25.password + Class106.aChar1;
                                 }
                              }
                           }

                           return;
                        }
                     } else if (Class25.loginIndex == 3) {
                        int_5 = Class25.loginWindowX + 180;
                        short_3 = 276;
                        if (int_0 == 1 && int_3 >= int_5 - 75 && int_3 <= int_5 + 75 && int_4 >= short_3 - 20 && int_4 <= short_3 + 20) {
                           WorldMapType1.method580(false);
                        }

                        int_5 = Class25.loginWindowX + 180;
                        short_3 = 326;
                        if (int_0 == 1 && int_3 >= int_5 - 75 && int_3 <= int_5 + 75 && int_4 >= short_3 - 20 && int_4 <= short_3 + 20) {
                           AClass3_Sub1.method750("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           Class25.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean bool_2;
                        int int_6;
                        if (Class25.loginIndex == 4) {
                           int_5 = Class25.loginWindowX + 180 - 80;
                           short_3 = 321;
                           if (int_0 == 1 && int_3 >= int_5 - 75 && int_3 <= int_5 + 75 && int_4 >= short_3 - 20 && int_4 <= short_3 + 20) {
                              Class97.aString11.trim();
                              if (Class97.aString11.length() != 6) {
                                 AClass3_Sub1.method750("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              Class34.playerPin = Integer.parseInt(Class97.aString11);
                              Class97.aString11 = "";
                              Permission.method599(true);
                              AClass3_Sub1.method750("", "Connecting to server...", "");
                              Class110.setGameState(20);
                              return;
                           }

                           if (int_0 == 1 && int_3 >= Class25.loginWindowX + 180 - 9 && int_3 <= Class25.loginWindowX + 180 + 130 && int_4 >= 263 && int_4 <= 296) {
                              Class25.aBool12 = !Class25.aBool12;
                           }

                           if (int_0 == 1 && int_3 >= Class25.loginWindowX + 180 - 34 && int_3 <= Class25.loginWindowX + 34 + 180 && int_4 >= 351 && int_4 <= 363) {
                              Class53.method350(Class28.method230("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           int_5 = Class25.loginWindowX + 180 + 80;
                           if (int_0 == 1 && int_3 >= int_5 - 75 && int_3 <= int_5 + 75 && int_4 >= short_3 - 20 && int_4 <= short_3 + 20) {
                              Class25.loginIndex = 0;
                              Class25.username = "";
                              Class25.password = "";
                              Class34.playerPin = 0;
                              Class97.aString11 = "";
                           }

                           while (Class11.method163()) {
                              bool_2 = false;

                              for (int_6 = 0; int_6 < "1234567890".length(); int_6++) {
                                 if (Class106.aChar1 == "1234567890".charAt(int_6)) {
                                    bool_2 = true;
                                    break;
                                 }
                              }

                              if (CombatInfoListHolder.anInt329 == 13) {
                                 Class25.loginIndex = 0;
                                 Class25.username = "";
                                 Class25.password = "";
                                 Class34.playerPin = 0;
                                 Class97.aString11 = "";
                              } else {
                                 if (CombatInfoListHolder.anInt329 == 85 && Class97.aString11.length() > 0) {
                                    Class97.aString11 = Class97.aString11.substring(0, Class97.aString11.length() - 1);
                                 }

                                 if (CombatInfoListHolder.anInt329 == 84) {
                                    Class97.aString11.trim();
                                    if (Class97.aString11.length() != 6) {
                                       AClass3_Sub1.method750("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    Class34.playerPin = Integer.parseInt(Class97.aString11);
                                    Class97.aString11 = "";
                                    Permission.method599(true);
                                    AClass3_Sub1.method750("", "Connecting to server...", "");
                                    Class110.setGameState(20);
                                    return;
                                 }

                                 if (bool_2 && Class97.aString11.length() < 6) {
                                    Class97.aString11 = Class97.aString11 + Class106.aChar1;
                                 }
                              }
                           }
                        } else if (Class25.loginIndex == 5) {
                           int_5 = Class25.loginWindowX + 180 - 80;
                           short_3 = 321;
                           if (int_0 == 1 && int_3 >= int_5 - 75 && int_3 <= int_5 + 75 && int_4 >= short_3 - 20 && int_4 <= short_3 + 20) {
                              CombatInfoListHolder.method652();
                              return;
                           }

                           int_5 = Class25.loginWindowX + 180 + 80;
                           if (int_0 == 1 && int_3 >= int_5 - 75 && int_3 <= int_5 + 75 && int_4 >= short_3 - 20 && int_4 <= short_3 + 20) {
                              WorldMapType1.method580(true);
                           }

                           while (Class11.method163()) {
                              bool_2 = false;

                              for (int_6 = 0; int_6 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); int_6++) {
                                 if (Class106.aChar1 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(int_6)) {
                                    bool_2 = true;
                                    break;
                                 }
                              }

                              if (CombatInfoListHolder.anInt329 == 13) {
                                 WorldMapType1.method580(true);
                              } else {
                                 if (CombatInfoListHolder.anInt329 == 85 && Class25.username.length() > 0) {
                                    Class25.username = Class25.username.substring(0, Class25.username.length() - 1);
                                 }

                                 if (CombatInfoListHolder.anInt329 == 84) {
                                    CombatInfoListHolder.method652();
                                    return;
                                 }

                                 if (bool_2 && Class25.username.length() < 320) {
                                    Class25.username = Class25.username + Class106.aChar1;
                                 }
                              }
                           }
                        } else if (Class25.loginIndex == 6) {
                           while (true) {
                              do {
                                 if (!Class11.method163()) {
                                    short_2 = 321;
                                    if (int_0 == 1 && int_4 >= short_2 - 20 && int_4 <= short_2 + 20) {
                                       WorldMapType1.method580(true);
                                    }

                                    return;
                                 }
                              } while (CombatInfoListHolder.anInt329 != 84 && CombatInfoListHolder.anInt329 != 13);

                              WorldMapType1.method580(true);
                           }
                        }
                     }
                  } else {
                     while (Class11.method163()) {
                        if (CombatInfoListHolder.anInt329 == 84) {
                           WorldMapType1.method580(false);
                        } else if (CombatInfoListHolder.anInt329 == 13) {
                           Class25.loginIndex = 0;
                        }
                     }

                     int_5 = Class83.anInt181 - 80;
                     short_3 = 321;
                     if (int_0 == 1 && int_3 >= int_5 - 75 && int_3 <= int_5 + 75 && int_4 >= short_3 - 20 && int_4 <= short_3 + 20) {
                        WorldMapType1.method580(false);
                     }

                     int_5 = Class83.anInt181 + 80;
                     if (int_0 == 1 && int_3 >= int_5 - 75 && int_3 <= int_5 + 75 && int_4 >= short_3 - 20 && int_4 <= short_3 + 20) {
                        Class25.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   static void method873(WidgetNode widgetnode_0, boolean bool_0) {
      int int_0 = widgetnode_0.id;
      int int_1 = (int)widgetnode_0.hash;
      widgetnode_0.unlink();
      int int_2;
      if (bool_0 && int_0 != -1 && AClass3_Sub1.validInterfaces[int_0]) {
         Class5.widgetIndex.method438(int_0);
         if (Class91.widgets[int_0] != null) {
            boolean bool_1 = true;

            for (int_2 = 0; int_2 < Class91.widgets[int_0].length; int_2++) {
               if (Class91.widgets[int_0][int_2] != null) {
                  if (Class91.widgets[int_0][int_2].type != 2) {
                     Class91.widgets[int_0][int_2] = null;
                  } else {
                     bool_1 = false;
                  }
               }
            }

            if (bool_1) {
               Class91.widgets[int_0] = null;
            }

            AClass3_Sub1.validInterfaces[int_0] = false;
         }
      }

      for (IntegerNode integernode_0 = (IntegerNode) Client.widgetFlags.method67(); integernode_0 != null; integernode_0 = (IntegerNode) Client.widgetFlags.method68()) {
         if ((long)int_0 == (integernode_0.hash >> 48 & 0xFFFFL)) {
            integernode_0.unlink();
         }
      }

      Widget widget_0 = PendingSpawn.method671(int_1);
      if (widget_0 != null) {
         WorldMapData.method305(widget_0);
      }

      Class67.method412();
      if (Client.widgetRoot != -1) {
         int_2 = Client.widgetRoot;
         if (CombatInfoListHolder.loadWidget(int_2)) {
            Class63.method399(Class91.widgets[int_2], 1);
         }
      }

   }

   static World method874() {
      World.anInt219 = 0;
      return ItemComposition.method944();
   }

}
