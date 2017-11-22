public class Class110 {

   public int anInt212;
   public int anInt213;

   Class110(int int_0, int int_1, int int_2, int int_3) {
      this.method547();
      this.method548(int_2, int_3);
   }

   public Class110(int int_0, int int_1) {
      this(0, 0, int_0, int_1);
   }

   void method547() {
   }

   void method548(int int_0, int int_1) {
      this.anInt212 = int_0;
      this.anInt213 = int_1;
   }

   static void setGameState(int int_0) {
      if (int_0 != Client.gameState) {
         if (Client.gameState == 0) {
            AClass3.clientInstance.method1076();
         }

         if (int_0 == 20 || int_0 == 40 || int_0 == 45) {
            Client.loginState = 0;
            Client.anInt618 = 0;
            Client.anInt614 = 0;
            Client.aClass100_1.method528(int_0);
            if (int_0 != 20) {
               Permission.method599(false);
            }
         }

         if (int_0 != 20 && int_0 != 40 && MessageNode.aRSSocket2 != null) {
            MessageNode.aRSSocket2.close();
            MessageNode.aRSSocket2 = null;
         }

         if (Client.gameState == 25) {
            Client.anInt630 = 0;
            Client.anInt631 = 0;
            Client.anInt632 = 1;
            Client.anInt633 = 0;
            Client.anInt634 = 1;
         }

         if (int_0 != 5 && int_0 != 10) {
            if (int_0 == 20) {
               MessageNode.method946(AbstractSoundSystem.anIndexData1, Class34.indexSprites, true, Client.gameState == 11 ? 4 : 0);
            } else if (int_0 == 11) {
               MessageNode.method946(AbstractSoundSystem.anIndexData1, Class34.indexSprites, false, 4);
            } else if (Class25.aBool13) {
               Class25.anIndexedSprite1 = null;
               Class25.anIndexedSprite2 = null;
               Class25.anIndexedSpriteArray5 = null;
               Class25.aSpritePixels4 = null;
               Class25.aSpritePixels5 = null;
               Class25.logoSprite = null;
               Class25.titlemuteSprite = null;
               WallObject.anIndexedSprite4 = null;
               Class107.anIndexedSprite6 = null;
               Class2.aSpritePixelsArray1 = null;
               Class93.anIndexedSpriteArray7 = null;
               Class23.anIndexedSpriteArray4 = null;
               Class28.anIndexedSpriteArray6 = null;
               ItemContainer.anIndexedSprite7 = null;
               ClanMember.anIntArray77 = null;
               ChatLineBuffer.anIntArray1 = null;
               MessageNode.anIntArray109 = null;
               Overlay.anIntArray81 = null;
               Permission.anIntArray67 = null;
               Class9.anIntArray4 = null;
               CombatInfoListHolder.anIntArray73 = null;
               Class47.anIntArray23 = null;
               Class7.method102(2);
               Class2.sendConInfo(true);
               Class25.aBool13 = false;
            }
         } else {
            MessageNode.method946(AbstractSoundSystem.anIndexData1, Class34.indexSprites, true, 0);
         }

         Client.gameState = int_0;
      }
   }

}
