public class WorldMapType1 implements WorldMapSectionBase {

   int anInt247;
   int anInt248;
   int anInt249;
   int anInt250;
   int anInt251;
   int anInt252;
   int anInt253;
   int anInt254;
   int anInt255;
   int anInt256;

   public boolean method5(int int_0, int int_1) {
      return int_0 >> 6 >= this.anInt247 && int_0 >> 6 <= this.anInt249 && int_1 >> 6 >= this.anInt251 && int_1 >> 6 <= this.anInt253;
   }

   public boolean method6(int int_0, int int_1, int int_2) {
      return int_0 >= this.anInt248 && int_0 < this.anInt248 + this.anInt250 ? int_1 >> 6 >= this.anInt252 && int_1 >> 6 <= this.anInt254 && int_2 >> 6 >= this.anInt255 && int_2 >> 6 <= this.anInt256 : false;
   }

   public void method7(WorldMapData worldmapdata_0) {
      if (worldmapdata_0.anInt109 > this.anInt247) {
         worldmapdata_0.anInt109 = this.anInt247;
      }

      if (worldmapdata_0.anInt107 < this.anInt249) {
         worldmapdata_0.anInt107 = this.anInt249;
      }

      if (worldmapdata_0.anInt110 > this.anInt251) {
         worldmapdata_0.anInt110 = this.anInt251;
      }

      if (worldmapdata_0.anInt108 < this.anInt253) {
         worldmapdata_0.anInt108 = this.anInt253;
      }

   }

   public Coordinates method8(int int_0, int int_1) {
      if (!this.method5(int_0, int_1)) {
         return null;
      } else {
         int int_2 = this.anInt252 * 64 - this.anInt247 * 64 + int_0;
         int int_3 = this.anInt255 * 64 - this.anInt251 * 64 + int_1;
         return new Coordinates(this.anInt248, int_2, int_3);
      }
   }

   public int[] method9(int int_0, int int_1, int int_2) {
      if (!this.method6(int_0, int_1, int_2)) {
         return null;
      } else {
         int[] ints_0 = new int[] {this.anInt247 * 64 - this.anInt252 * 64 + int_1, int_2 + (this.anInt251 * 64 - this.anInt255 * 64)};
         return ints_0;
      }
   }

   public void method10(Buffer buffer_0) {
      this.anInt248 = buffer_0.readUnsignedByte();
      this.anInt250 = buffer_0.readUnsignedByte();
      this.anInt252 = buffer_0.readUnsignedShort();
      this.anInt255 = buffer_0.readUnsignedShort();
      this.anInt254 = buffer_0.readUnsignedShort();
      this.anInt256 = buffer_0.readUnsignedShort();
      this.anInt247 = buffer_0.readUnsignedShort();
      this.anInt251 = buffer_0.readUnsignedShort();
      this.anInt249 = buffer_0.readUnsignedShort();
      this.anInt253 = buffer_0.readUnsignedShort();
      this.method577();
   }

   void method577() {
   }

   static void method578(int int_0) {
      if (int_0 == -3) {
         AClass3_Sub1.method750("Connection timed out.", "Please try using a different world.", "");
      } else if (int_0 == -2) {
         AClass3_Sub1.method750("", "Error connecting to server.", "");
      } else if (int_0 == -1) {
         AClass3_Sub1.method750("No response from server.", "Please try using a different world.", "");
      } else if (int_0 == 3) {
         Class25.loginIndex = 3;
      } else if (int_0 == 4) {
         AClass3_Sub1.method750("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if (int_0 == 5) {
         AClass3_Sub1.method750("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if (int_0 == 6) {
         AClass3_Sub1.method750("RuneScape has been updated!", "Please reload this page.", "");
      } else if (int_0 == 7) {
         AClass3_Sub1.method750("This world is full.", "Please use a different world.", "");
      } else if (int_0 == 8) {
         AClass3_Sub1.method750("Unable to connect.", "Login server offline.", "");
      } else if (int_0 == 9) {
         AClass3_Sub1.method750("Login limit exceeded.", "Too many connections from your address.", "");
      } else if (int_0 == 10) {
         AClass3_Sub1.method750("Unable to connect.", "Bad session id.", "");
      } else if (int_0 == 11) {
         AClass3_Sub1.method750("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if (int_0 == 12) {
         AClass3_Sub1.method750("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if (int_0 == 13) {
         AClass3_Sub1.method750("Could not complete login.", "Please try using a different world.", "");
      } else if (int_0 == 14) {
         AClass3_Sub1.method750("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if (int_0 == 16) {
         AClass3_Sub1.method750("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if (int_0 == 17) {
         AClass3_Sub1.method750("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if (int_0 == 18) {
         AClass3_Sub1.method750("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if (int_0 == 19) {
         AClass3_Sub1.method750("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if (int_0 == 20) {
         AClass3_Sub1.method750("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if (int_0 == 22) {
         AClass3_Sub1.method750("Malformed login packet.", "Please try again.", "");
      } else if (int_0 == 23) {
         AClass3_Sub1.method750("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if (int_0 == 24) {
         AClass3_Sub1.method750("Error loading your profile.", "Please contact customer support.", "");
      } else if (int_0 == 25) {
         AClass3_Sub1.method750("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if (int_0 == 26) {
         AClass3_Sub1.method750("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if (int_0 == 27) {
         AClass3_Sub1.method750("", "Service unavailable.", "");
      } else if (int_0 == 31) {
         AClass3_Sub1.method750("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if (int_0 == 32) {
         AClass3_Sub1.method750("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if (int_0 == 37) {
         AClass3_Sub1.method750("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if (int_0 == 38) {
         AClass3_Sub1.method750("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if (int_0 == 55) {
         AClass3_Sub1.method750("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if (int_0 == 56) {
            AClass3_Sub1.method750("Enter the 6-digit code generated by your", "authenticator app.", "");
            Class110.setGameState(11);
            return;
         }

         if (int_0 == 57) {
            AClass3_Sub1.method750("The code you entered was incorrect.", "Please try again.", "");
            Class110.setGameState(11);
            return;
         }

         AClass3_Sub1.method750("Unexpected server response", "Please try using a different world.", "");
      }

      Class110.setGameState(10);
   }

   static int method579() {
      return Class54.anInt139;
   }

   static void method580(boolean bool_0) {
      Class25.loginMessage1 = "";
      Class25.loginMessage2 = "Enter your username/email & password.";
      Class25.loginMessage3 = "";
      Class25.loginIndex = 2;
      if (bool_0) {
         Class25.password = "";
      }

      Class43.method267();
      TileStrategy.method631();
   }

}
