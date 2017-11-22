public class Class12 {

   static final Class12 aClass12_1;
   static final Class12 aClass12_2;
   protected static boolean aBool3;
   static int anInt56;
   final int anInt57;

   static {
      aClass12_1 = new Class12(0);
      aClass12_2 = new Class12(1);
   }

   Class12(int int_0) {
      this.anInt57 = int_0;
   }

   static void method165() {
      for (WidgetNode widgetnode_0 = (WidgetNode) Client.componentTable.method67(); widgetnode_0 != null; widgetnode_0 = (WidgetNode) Client.componentTable.method68()) {
         int int_0 = widgetnode_0.id;
         if (CombatInfoListHolder.loadWidget(int_0)) {
            boolean bool_0 = true;
            Widget[] widgets_0 = Class91.widgets[int_0];

            int int_1;
            for (int_1 = 0; int_1 < widgets_0.length; int_1++) {
               if (widgets_0[int_1] != null) {
                  bool_0 = widgets_0[int_1].hasScript;
                  break;
               }
            }

            if (!bool_0) {
               int_1 = (int)widgetnode_0.hash;
               Widget widget_0 = PendingSpawn.method671(int_1);
               if (widget_0 != null) {
                  WorldMapData.method305(widget_0);
               }
            }
         }
      }

   }

   static void method166(Font font_0, Font font_1) {
      if (Class2.aSpritePixelsArray1 == null) {
         Class2.aSpritePixelsArray1 = Buffer.method735(Class34.indexSprites, "sl_back", "");
      }

      if (Class93.anIndexedSpriteArray7 == null) {
         Class93.anIndexedSpriteArray7 = Enum3.method670(Class34.indexSprites, "sl_flags", "");
      }

      if (Class23.anIndexedSpriteArray4 == null) {
         Class23.anIndexedSpriteArray4 = Enum3.method670(Class34.indexSprites, "sl_arrows", "");
      }

      if (Class28.anIndexedSpriteArray6 == null) {
         Class28.anIndexedSpriteArray6 = Enum3.method670(Class34.indexSprites, "sl_stars", "");
      }

      Rasterizer2D.method919(Class25.anInt76, 23, 765, 480, 0);
      Rasterizer2D.method925(Class25.anInt76, 0, 125, 23, 12425273, 9135624);
      Rasterizer2D.method925(Class25.anInt76 + 125, 0, 640, 23, 5197647, 2697513);
      font_0.method1039("Select a world", Class25.anInt76 + 62, 15, 0, -1);
      if (Class28.anIndexedSpriteArray6 != null) {
         Class28.anIndexedSpriteArray6[1].method975(Class25.anInt76 + 140, 1);
         font_1.method1040("Members only world", Class25.anInt76 + 152, 10, 16777215, -1);
         Class28.anIndexedSpriteArray6[0].method975(Class25.anInt76 + 140, 12);
         font_1.method1040("Free world", Class25.anInt76 + 152, 21, 16777215, -1);
      }

      int int_2;
      int int_3;
      if (Class23.anIndexedSpriteArray4 != null) {
         int int_0 = Class25.anInt76 + 280;
         if (World.anIntArray58[0] == 0 && World.anIntArray57[0] == 0) {
            Class23.anIndexedSpriteArray4[2].method975(int_0, 4);
         } else {
            Class23.anIndexedSpriteArray4[0].method975(int_0, 4);
         }

         if (World.anIntArray58[0] == 0 && World.anIntArray57[0] == 1) {
            Class23.anIndexedSpriteArray4[3].method975(int_0 + 15, 4);
         } else {
            Class23.anIndexedSpriteArray4[1].method975(int_0 + 15, 4);
         }

         font_0.method1040("World", int_0 + 32, 17, 16777215, -1);
         int int_1 = Class25.anInt76 + 390;
         if (World.anIntArray58[0] == 1 && World.anIntArray57[0] == 0) {
            Class23.anIndexedSpriteArray4[2].method975(int_1, 4);
         } else {
            Class23.anIndexedSpriteArray4[0].method975(int_1, 4);
         }

         if (World.anIntArray58[0] == 1 && World.anIntArray57[0] == 1) {
            Class23.anIndexedSpriteArray4[3].method975(int_1 + 15, 4);
         } else {
            Class23.anIndexedSpriteArray4[1].method975(int_1 + 15, 4);
         }

         font_0.method1040("Players", int_1 + 32, 17, 16777215, -1);
         int_2 = Class25.anInt76 + 500;
         if (World.anIntArray58[0] == 2 && World.anIntArray57[0] == 0) {
            Class23.anIndexedSpriteArray4[2].method975(int_2, 4);
         } else {
            Class23.anIndexedSpriteArray4[0].method975(int_2, 4);
         }

         if (World.anIntArray58[0] == 2 && World.anIntArray57[0] == 1) {
            Class23.anIndexedSpriteArray4[3].method975(int_2 + 15, 4);
         } else {
            Class23.anIndexedSpriteArray4[1].method975(int_2 + 15, 4);
         }

         font_0.method1040("Location", int_2 + 32, 17, 16777215, -1);
         int_3 = Class25.anInt76 + 610;
         if (World.anIntArray58[0] == 3 && World.anIntArray57[0] == 0) {
            Class23.anIndexedSpriteArray4[2].method975(int_3, 4);
         } else {
            Class23.anIndexedSpriteArray4[0].method975(int_3, 4);
         }

         if (World.anIntArray58[0] == 3 && World.anIntArray57[0] == 1) {
            Class23.anIndexedSpriteArray4[3].method975(int_3 + 15, 4);
         } else {
            Class23.anIndexedSpriteArray4[1].method975(int_3 + 15, 4);
         }

         font_0.method1040("Type", int_3 + 32, 17, 16777215, -1);
      }

      Rasterizer2D.method919(Class25.anInt76 + 708, 4, 50, 16, 0);
      font_1.method1039("Cancel", Class25.anInt76 + 708 + 25, 16, 16777215, -1);
      Class25.anInt84 = -1;
      if (Class2.aSpritePixelsArray1 != null) {
         byte byte_1 = 88;
         byte byte_2 = 19;
         int_2 = 765 / (byte_1 + 1);
         int_3 = 480 / (byte_2 + 1);

         int int_4;
         int int_5;
         do {
            int_4 = int_3;
            int_5 = int_2;
            if (int_3 * (int_2 - 1) >= World.worldCount) {
               --int_2;
            }

            if (int_2 * (int_3 - 1) >= World.worldCount) {
               --int_3;
            }

            if (int_2 * (int_3 - 1) >= World.worldCount) {
               --int_3;
            }
         } while (int_3 != int_4 || int_2 != int_5);

         int_4 = (765 - byte_1 * int_2) / (int_2 + 1);
         if (int_4 > 5) {
            int_4 = 5;
         }

         int_5 = (480 - byte_2 * int_3) / (int_3 + 1);
         if (int_5 > 5) {
            int_5 = 5;
         }

         int int_6 = (765 - int_2 * byte_1 - int_4 * (int_2 - 1)) / 2;
         int int_7 = (480 - byte_2 * int_3 - int_5 * (int_3 - 1)) / 2;
         int int_8 = int_7 + 23;
         int int_9 = int_6 + Class25.anInt76;
         int int_10 = 0;
         boolean bool_0 = false;

         int int_11;
         for (int_11 = 0; int_11 < World.worldCount; int_11++) {
            World world_0 = Coordinates.worldList[int_11];
            boolean bool_1 = true;
            String string_0 = Integer.toString(world_0.playerCount);
            if (world_0.playerCount == -1) {
               string_0 = "OFF";
               bool_1 = false;
            } else if (world_0.playerCount > 1980) {
               string_0 = "FULL";
               bool_1 = false;
            }

            int int_12 = 0;
            byte byte_0;
            if (world_0.method552()) {
               if (world_0.method551()) {
                  byte_0 = 7;
               } else {
                  byte_0 = 6;
               }
            } else if (world_0.method553()) {
               int_12 = 16711680;
               if (world_0.method551()) {
                  byte_0 = 5;
               } else {
                  byte_0 = 4;
               }
            } else if (world_0.method554()) {
               if (world_0.method551()) {
                  byte_0 = 3;
               } else {
                  byte_0 = 2;
               }
            } else if (world_0.method551()) {
               byte_0 = 1;
            } else {
               byte_0 = 0;
            }

            if (MouseInput.anInt260 >= int_9 && MouseInput.anInt262 >= int_8 && MouseInput.anInt260 < byte_1 + int_9 && MouseInput.anInt262 < int_8 + byte_2 && bool_1) {
               Class25.anInt84 = int_11;
               Class2.aSpritePixelsArray1[byte_0].method998(int_9, int_8, 128, 16777215);
               bool_0 = true;
            } else {
               Class2.aSpritePixelsArray1[byte_0].method983(int_9, int_8);
            }

            if (Class93.anIndexedSpriteArray7 != null) {
               Class93.anIndexedSpriteArray7[(world_0.method551() ? 8 : 0) + world_0.location].method975(int_9 + 29, int_8);
            }

            font_0.method1039(Integer.toString(world_0.id), int_9 + 15, byte_2 / 2 + int_8 + 5, int_12, -1);
            font_1.method1039(string_0, int_9 + 60, byte_2 / 2 + int_8 + 5, 268435455, -1);
            int_8 = int_8 + int_5 + byte_2;
            ++int_10;
            if (int_10 >= int_3) {
               int_8 = int_7 + 23;
               int_9 = int_9 + int_4 + byte_1;
               int_10 = 0;
            }
         }

         if (bool_0) {
            int_11 = font_1.method1030(Coordinates.worldList[Class25.anInt84].activity) + 6;
            int int_13 = font_1.verticalSpace + 8;
            Rasterizer2D.method919(MouseInput.anInt260 - int_11 / 2, MouseInput.anInt262 + 20 + 5, int_11, int_13, 16777120);
            Rasterizer2D.drawRectangle(MouseInput.anInt260 - int_11 / 2, MouseInput.anInt262 + 20 + 5, int_11, int_13, 0);
            font_1.method1039(Coordinates.worldList[Class25.anInt84].activity, MouseInput.anInt260, MouseInput.anInt262 + font_1.verticalSpace + 20 + 5 + 4, 0, -1);
         }
      }

      Class68_Sub1.aBufferProvider1.method499(0, 0);
   }

   static void method167(int int_0, int int_1) {
      PacketNode packetnode_0 = Actor.method953(ClientPacket.aClientPacket37, Client.aClass46_1.anISAACCipher1);
      packetnode_0.packetBuffer.method725(int_0);
      packetnode_0.packetBuffer.method719(int_1);
      Client.aClass46_1.method282(packetnode_0);
   }

}
