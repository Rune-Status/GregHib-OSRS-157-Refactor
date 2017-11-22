public class MessageNode extends CacheableNode {

   static int anInt509;
   static RSSocket aRSSocket2;
   static int[] anIntArray109;
   int id;
   int tick;
   int type;
   String name;
   String sender;
   String value;

   MessageNode(int int_0, String string_0, String string_1, String string_2) {
      this.id = RSCanvas.method747();
      this.tick = Client.gameCycle;
      this.type = int_0;
      this.name = string_0;
      this.sender = string_1;
      this.value = string_2;
   }

   void setMessage(int int_0, String string_0, String string_1, String string_2) {
      this.id = RSCanvas.method747();
      this.tick = Client.gameCycle;
      this.type = int_0;
      this.name = string_0;
      this.sender = string_1;
      this.value = string_2;
   }

   static void method946(IndexDataBase indexdatabase_0, IndexDataBase indexdatabase_1, boolean bool_0, int int_0) {
      if (Class25.aBool13) {
         if (int_0 == 4) {
            Class25.loginIndex = 4;
         }

      } else {
         Class25.loginIndex = int_0;
         Rasterizer2D.reset();
         byte[] bytes_0 = indexdatabase_0.method436("title.jpg", "");
         Class25.aSpritePixels4 = Class80.method470(bytes_0);
         Class25.aSpritePixels5 = Class25.aSpritePixels4.method994();
         if ((Client.flags & 0x20000000) != 0) {
            Class25.logoSprite = CacheableNode_Sub2.getSprite(indexdatabase_1, "logo_deadman_mode", "");
         } else {
            Class25.logoSprite = CacheableNode_Sub2.getSprite(indexdatabase_1, "logo", "");
         }

         Class25.anIndexedSprite1 = CacheableNode_Sub2.getSprite(indexdatabase_1, "titlebox", "");
         Class25.anIndexedSprite2 = CacheableNode_Sub2.getSprite(indexdatabase_1, "titlebutton", "");
         Class25.anIndexedSpriteArray5 = Enum3.method670(indexdatabase_1, "runes", "");
         Class25.titlemuteSprite = Enum3.method670(indexdatabase_1, "title_mute", "");
         WallObject.anIndexedSprite4 = CacheableNode_Sub2.getSprite(indexdatabase_1, "options_radio_buttons,0", "");
         Preferences.anIndexedSprite5 = CacheableNode_Sub2.getSprite(indexdatabase_1, "options_radio_buttons,4", "");
         Class107.anIndexedSprite6 = CacheableNode_Sub2.getSprite(indexdatabase_1, "options_radio_buttons,2", "");
         Class39.anIndexedSprite3 = CacheableNode_Sub2.getSprite(indexdatabase_1, "options_radio_buttons,6", "");
         WorldMapData_Sub1.anInt303 = WallObject.anIndexedSprite4.originalWidth;
         Class25.anInt85 = WallObject.anIndexedSprite4.height;
         ClanMember.anIntArray77 = new int[256];

         int int_1;
         for (int_1 = 0; int_1 < 64; int_1++) {
            ClanMember.anIntArray77[int_1] = int_1 * 262144;
         }

         for (int_1 = 0; int_1 < 64; int_1++) {
            ClanMember.anIntArray77[int_1 + 64] = int_1 * 1024 + 16711680;
         }

         for (int_1 = 0; int_1 < 64; int_1++) {
            ClanMember.anIntArray77[int_1 + 128] = int_1 * 4 + 16776960;
         }

         for (int_1 = 0; int_1 < 64; int_1++) {
            ClanMember.anIntArray77[int_1 + 192] = 16777215;
         }

         ChatLineBuffer.anIntArray1 = new int[256];

         for (int_1 = 0; int_1 < 64; int_1++) {
            ChatLineBuffer.anIntArray1[int_1] = int_1 * 1024;
         }

         for (int_1 = 0; int_1 < 64; int_1++) {
            ChatLineBuffer.anIntArray1[int_1 + 64] = int_1 * 4 + 65280;
         }

         for (int_1 = 0; int_1 < 64; int_1++) {
            ChatLineBuffer.anIntArray1[int_1 + 128] = int_1 * 262144 + 65535;
         }

         for (int_1 = 0; int_1 < 64; int_1++) {
            ChatLineBuffer.anIntArray1[int_1 + 192] = 16777215;
         }

         anIntArray109 = new int[256];

         for (int_1 = 0; int_1 < 64; int_1++) {
            anIntArray109[int_1] = int_1 * 4;
         }

         for (int_1 = 0; int_1 < 64; int_1++) {
            anIntArray109[int_1 + 64] = int_1 * 262144 + 255;
         }

         for (int_1 = 0; int_1 < 64; int_1++) {
            anIntArray109[int_1 + 128] = int_1 * 1024 + 16711935;
         }

         for (int_1 = 0; int_1 < 64; int_1++) {
            anIntArray109[int_1 + 192] = 16777215;
         }

         Overlay.anIntArray81 = new int[256];
         Permission.anIntArray67 = new int[32768];
         Class9.anIntArray4 = new int[32768];
         Class17.method202((IndexedSprite) null);
         CombatInfoListHolder.anIntArray73 = new int[32768];
         Class47.anIntArray23 = new int[32768];
         if (bool_0) {
            Class25.username = "";
            Class25.password = "";
         }

         Class34.playerPin = 0;
         Class97.aString11 = "";
         Class25.aBool12 = true;
         Class25.worldSelectShown = false;
         if (!Buffer.preferences.muted) {
            IndexData indexdata_0 = Class38.indexTrack1;
            int int_2 = indexdata_0.getFile("scape main");
            int int_3 = indexdata_0.getChild(int_2, "");
            Class78.anInt172 = 1;
            Class70.anIndexDataBase3 = indexdata_0;
            Class78.anInt173 = int_2;
            Class78.anInt174 = int_3;
            Class7.anInt40 = 255;
            Class78.aBool29 = false;
            Class1.anInt16 = 2;
         } else {
            Class7.method102(2);
         }

         Class2.sendConInfo(false);
         Class25.aBool13 = true;
         Class25.anInt76 = (Tile.canvasWidth - 765) / 2;
         Class25.loginWindowX = Class25.anInt76 + 202;
         Class83.anInt181 = Class25.loginWindowX + 180;
         Class25.aSpritePixels4.method983(Class25.anInt76, 0);
         Class25.aSpritePixels5.method983(Class25.anInt76 + 382, 0);
         Class25.logoSprite.method975(Class25.anInt76 + 382 - Class25.logoSprite.originalWidth / 2, 18);
      }
   }

   static int method947(int int_0, Script script_0, boolean bool_0) {
      Widget widget_0;
      if (int_0 >= 2000) {
         int_0 -= 1000;
         widget_0 = PendingSpawn.method671(Class39.intStack[--Class23.intStackSize]);
      } else {
         widget_0 = bool_0 ? Class106.aWidget4 : Friend.aWidget5;
      }

      String string_0 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
      int[] ints_0 = null;
      if (string_0.length() > 0 && string_0.charAt(string_0.length() - 1) == 89) {
         int int_1 = Class39.intStack[--Class23.intStackSize];
         if (int_1 > 0) {
            for (ints_0 = new int[int_1]; int_1-- > 0; ints_0[int_1] = Class39.intStack[--Class23.intStackSize]) {
               ;
            }
         }

         string_0 = string_0.substring(0, string_0.length() - 1);
      }

      Object[] objects_0 = new Object[string_0.length() + 1];

      int int_2;
      for (int_2 = objects_0.length - 1; int_2 >= 1; --int_2) {
         if (string_0.charAt(int_2 - 1) == 115) {
            objects_0[int_2] = Class39.scriptStringStack[--Class28.scriptStringStackSize];
         } else {
            objects_0[int_2] = new Integer(Class39.intStack[--Class23.intStackSize]);
         }
      }

      int_2 = Class39.intStack[--Class23.intStackSize];
      if (int_2 != -1) {
         objects_0[0] = new Integer(int_2);
      } else {
         objects_0 = null;
      }

      if (int_0 == 1400) {
         widget_0.anObjectArray11 = objects_0;
      } else if (int_0 == 1401) {
         widget_0.anObjectArray12 = objects_0;
      } else if (int_0 == 1402) {
         widget_0.anObjectArray13 = objects_0;
      } else if (int_0 == 1403) {
         widget_0.mouseEnterListener = objects_0;
      } else if (int_0 == 1404) {
         widget_0.mouseExitListener = objects_0;
      } else if (int_0 == 1405) {
         widget_0.anObjectArray3 = objects_0;
      } else if (int_0 == 1406) {
         widget_0.anObjectArray8 = objects_0;
      } else if (int_0 == 1407) {
         widget_0.configListenerArgs = objects_0;
         widget_0.configTriggers = ints_0;
      } else if (int_0 == 1408) {
         widget_0.renderListener = objects_0;
      } else if (int_0 == 1409) {
         widget_0.anObjectArray10 = objects_0;
      } else if (int_0 == 1410) {
         widget_0.anObjectArray4 = objects_0;
      } else if (int_0 == 1411) {
         widget_0.anObjectArray14 = objects_0;
      } else if (int_0 == 1412) {
         widget_0.mouseHoverListener = objects_0;
      } else if (int_0 == 1414) {
         widget_0.tableListenerArgs = objects_0;
         widget_0.tableModTriggers = ints_0;
      } else if (int_0 == 1415) {
         widget_0.skillListenerArgs = objects_0;
         widget_0.skillTriggers = ints_0;
      } else if (int_0 == 1416) {
         widget_0.anObjectArray9 = objects_0;
      } else if (int_0 == 1417) {
         widget_0.scrollListener = objects_0;
      } else if (int_0 == 1418) {
         widget_0.anObjectArray15 = objects_0;
      } else if (int_0 == 1419) {
         widget_0.anObjectArray16 = objects_0;
      } else if (int_0 == 1420) {
         widget_0.anObjectArray17 = objects_0;
      } else if (int_0 == 1421) {
         widget_0.anObjectArray18 = objects_0;
      } else if (int_0 == 1422) {
         widget_0.anObjectArray19 = objects_0;
      } else if (int_0 == 1423) {
         widget_0.anObjectArray5 = objects_0;
      } else if (int_0 == 1424) {
         widget_0.anObjectArray7 = objects_0;
      } else if (int_0 == 1425) {
         widget_0.anObjectArray20 = objects_0;
      } else if (int_0 == 1426) {
         widget_0.anObjectArray21 = objects_0;
      } else {
         if (int_0 != 1427) {
            return 2;
         }

         widget_0.anObjectArray2 = objects_0;
      }

      widget_0.aBool35 = true;
      return 1;
   }

   static int method948(int int_0, int int_1) {
      ItemContainer itemcontainer_0 = (ItemContainer) ItemContainer.itemContainers.get((long)int_0);
      return itemcontainer_0 == null ? -1 : (int_1 >= 0 && int_1 < itemcontainer_0.itemIds.length ? itemcontainer_0.itemIds[int_1] : -1);
   }

}
