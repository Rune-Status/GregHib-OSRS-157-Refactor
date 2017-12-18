public enum Enum1 implements RSEnum {

   anEnum1_1(3, (byte) 0),
   anEnum1_2(1, (byte) 1),
   anEnum1_3(2, (byte) 2),
   anEnum1_4(0, (byte) 3);

   public static IndexDataBase spriteCacheIndex;
   static IndexData fontConfigIndex;
   final byte aByte3;
   final int anInt304;

   Enum1(int int_1, byte byte_0) {
      this.anInt304 = int_1;
      this.aByte3 = byte_0;
   }

   public int rsOrdinal() {
      return this.aByte3;
   }

   static void method610(IndexData indexdata_0, int int_0) {
      if (Class23.aBuffer1 != null) {
         Class23.aBuffer1.position = int_0 * 8 + 5;
         int int_1 = Class23.aBuffer1.readInt();
         int int_2 = Class23.aBuffer1.readInt();
         indexdata_0.setInformation(int_1, int_2);
      } else {
         IndexData.method676((IndexData) null, 255, 255, 0, (byte) 0, true);
         Class95.anIndexDataArray1[int_0] = indexdata_0;
      }
   }

   static void method611(int int_0, int int_1, int int_2, int int_3, String string_0) {
      Widget widget_0 = Class74.method447(int_1, int_2);
      if (widget_0 != null) {
         if (widget_0.anObjectArray10 != null) {
            ScriptEvent scriptevent_0 = new ScriptEvent();
            scriptevent_0.widget = widget_0;
            scriptevent_0.anInt396 = int_0;
            scriptevent_0.aString28 = string_0;
            scriptevent_0.anObjectArray22 = widget_0.anObjectArray10;
            Class52.method335(scriptevent_0);
         }

         boolean bool_0 = true;
         if (widget_0.contentType > 0) {
            bool_0 = Ignore.method550(widget_0);
         }

         if (bool_0) {
            if (Class51.method329(Preferences.getWidgetConfig(widget_0), int_0 - 1)) {
               PacketNode packetnode_0;
               if (int_0 == 1) {
                  packetnode_0 = Actor.method953(ClientPacket.aClientPacket19, Client.aClass46_1.cipher);
                  packetnode_0.packetBuffer.putInt(int_1);
                  packetnode_0.packetBuffer.putShort(int_2);
                  packetnode_0.packetBuffer.putShort(int_3);
                  Client.aClass46_1.method282(packetnode_0);
               }

               if (int_0 == 2) {
                  packetnode_0 = Actor.method953(ClientPacket.aClientPacket20, Client.aClass46_1.cipher);
                  packetnode_0.packetBuffer.putInt(int_1);
                  packetnode_0.packetBuffer.putShort(int_2);
                  packetnode_0.packetBuffer.putShort(int_3);
                  Client.aClass46_1.method282(packetnode_0);
               }

               if (int_0 == 3) {
                  packetnode_0 = Actor.method953(ClientPacket.aClientPacket21, Client.aClass46_1.cipher);
                  packetnode_0.packetBuffer.putInt(int_1);
                  packetnode_0.packetBuffer.putShort(int_2);
                  packetnode_0.packetBuffer.putShort(int_3);
                  Client.aClass46_1.method282(packetnode_0);
               }

               if (int_0 == 4) {
                  packetnode_0 = Actor.method953(ClientPacket.aClientPacket25, Client.aClass46_1.cipher);
                  packetnode_0.packetBuffer.putInt(int_1);
                  packetnode_0.packetBuffer.putShort(int_2);
                  packetnode_0.packetBuffer.putShort(int_3);
                  Client.aClass46_1.method282(packetnode_0);
               }

               if (int_0 == 5) {
                  packetnode_0 = Actor.method953(ClientPacket.aClientPacket26, Client.aClass46_1.cipher);
                  packetnode_0.packetBuffer.putInt(int_1);
                  packetnode_0.packetBuffer.putShort(int_2);
                  packetnode_0.packetBuffer.putShort(int_3);
                  Client.aClass46_1.method282(packetnode_0);
               }

               if (int_0 == 6) {
                  packetnode_0 = Actor.method953(ClientPacket.aClientPacket27, Client.aClass46_1.cipher);
                  packetnode_0.packetBuffer.putInt(int_1);
                  packetnode_0.packetBuffer.putShort(int_2);
                  packetnode_0.packetBuffer.putShort(int_3);
                  Client.aClass46_1.method282(packetnode_0);
               }

               if (int_0 == 7) {
                  packetnode_0 = Actor.method953(ClientPacket.aClientPacket28, Client.aClass46_1.cipher);
                  packetnode_0.packetBuffer.putInt(int_1);
                  packetnode_0.packetBuffer.putShort(int_2);
                  packetnode_0.packetBuffer.putShort(int_3);
                  Client.aClass46_1.method282(packetnode_0);
               }

               if (int_0 == 8) {
                  packetnode_0 = Actor.method953(ClientPacket.aClientPacket29, Client.aClass46_1.cipher);
                  packetnode_0.packetBuffer.putInt(int_1);
                  packetnode_0.packetBuffer.putShort(int_2);
                  packetnode_0.packetBuffer.putShort(int_3);
                  Client.aClass46_1.method282(packetnode_0);
               }

               if (int_0 == 9) {
                  packetnode_0 = Actor.method953(ClientPacket.aClientPacket30, Client.aClass46_1.cipher);
                  packetnode_0.packetBuffer.putInt(int_1);
                  packetnode_0.packetBuffer.putShort(int_2);
                  packetnode_0.packetBuffer.putShort(int_3);
                  Client.aClass46_1.method282(packetnode_0);
               }

               if (int_0 == 10) {
                  packetnode_0 = Actor.method953(ClientPacket.aClientPacket31, Client.aClass46_1.cipher);
                  packetnode_0.packetBuffer.putInt(int_1);
                  packetnode_0.packetBuffer.putShort(int_2);
                  packetnode_0.packetBuffer.putShort(int_3);
                  Client.aClass46_1.method282(packetnode_0);
               }

            }
         }
      }
   }

   static void groundItemSpawned(int int_0, int int_1) {
      Deque deque_0 = Client.groundItemDeque[Ignore.plane][int_0][int_1];
      if (deque_0 == null) {
         Class23.sceneGraph.method364(Ignore.plane, int_0, int_1);
      } else {
         long long_0 = -99999999L;
         Item item_0 = null;

         Item item_1;
         for (item_1 = (Item) deque_0.getFront(); item_1 != null; item_1 = (Item) deque_0.getNext()) {
            ItemDefinition itemcomposition_0 = ItemDefinition.getDefinition(item_1.id);
            long long_1 = (long)itemcomposition_0.price;
            if (itemcomposition_0.isStackable == 1) {
               long_1 *= (long)(item_1.quantity + 1);
            }

            if (long_1 > long_0) {
               long_0 = long_1;
               item_0 = item_1;
            }
         }

         if (item_0 == null) {
            Class23.sceneGraph.method364(Ignore.plane, int_0, int_1);
         } else {
            deque_0.addTail(item_0);
            Item item_3 = null;
            Item item_2 = null;

            for (item_1 = (Item) deque_0.getFront(); item_1 != null; item_1 = (Item) deque_0.getNext()) {
               if (item_1.id != item_0.id) {
                  if (item_3 == null) {
                     item_3 = item_1;
                  }

                  if (item_3.id != item_1.id && item_2 == null) {
                     item_2 = item_1;
                  }
               }
            }

            int int_2 = int_0 + (int_1 << 7) + 1610612736;
            Class23.sceneGraph.addItemPile(Ignore.plane, int_0, int_1, Class18.getTileHeight(int_0 * 128 + 64, int_1 * 128 + 64, Ignore.plane), item_0, int_2, item_3, item_2);
         }
      }
   }

   static int method612(int int_0, Script script_0, boolean bool_0) {
      int int_1;
      int int_2;
      if (int_0 == 100) {
         Class23.intStackSize -= 3;
         int_1 = Class39.intStack[Class23.intStackSize];
         int_2 = Class39.intStack[Class23.intStackSize + 1];
         int int_3 = Class39.intStack[Class23.intStackSize + 2];
         if (int_2 == 0) {
            throw new RuntimeException();
         } else {
            Widget widget_2 = Client.getWidget(int_1);
            if (widget_2.children == null) {
               widget_2.children = new Widget[int_3 + 1];
            }

            if (widget_2.children.length <= int_3) {
               Widget[] widgets_0 = new Widget[int_3 + 1];

               for (int int_4 = 0; int_4 < widget_2.children.length; int_4++) {
                  widgets_0[int_4] = widget_2.children[int_4];
               }

               widget_2.children = widgets_0;
            }

            if (int_3 > 0 && widget_2.children[int_3 - 1] == null) {
               throw new RuntimeException("" + (int_3 - 1));
            } else {
               Widget widget_4 = new Widget();
               widget_4.type = int_2;
               widget_4.parentId = widget_4.id = widget_2.id;
               widget_4.index = int_3;
               widget_4.hasScript = true;
               widget_2.children[int_3] = widget_4;
               if (bool_0) {
                  Class106.aWidget4 = widget_4;
               } else {
                  Friend.aWidget5 = widget_4;
               }

               WorldMapData.method305(widget_2);
               return 1;
            }
         }
      } else {
         Widget widget_0;
         if (int_0 == 101) {
            widget_0 = bool_0 ? Class106.aWidget4 : Friend.aWidget5;
            Widget widget_1 = Client.getWidget(widget_0.id);
            widget_1.children[widget_0.index] = null;
            WorldMapData.method305(widget_1);
            return 1;
         } else if (int_0 == 102) {
            widget_0 = Client.getWidget(Class39.intStack[--Class23.intStackSize]);
            widget_0.children = null;
            WorldMapData.method305(widget_0);
            return 1;
         } else if (int_0 != 200) {
            if (int_0 == 201) {
               widget_0 = Client.getWidget(Class39.intStack[--Class23.intStackSize]);
               if (widget_0 != null) {
                  Class39.intStack[++Class23.intStackSize - 1] = 1;
                  if (bool_0) {
                     Class106.aWidget4 = widget_0;
                  } else {
                     Friend.aWidget5 = widget_0;
                  }
               } else {
                  Class39.intStack[++Class23.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            Class23.intStackSize -= 2;
            int_1 = Class39.intStack[Class23.intStackSize];
            int_2 = Class39.intStack[Class23.intStackSize + 1];
            Widget widget_3 = Class74.method447(int_1, int_2);
            if (widget_3 != null && int_2 != -1) {
               Class39.intStack[++Class23.intStackSize - 1] = 1;
               if (bool_0) {
                  Class106.aWidget4 = widget_3;
               } else {
                  Friend.aWidget5 = widget_3;
               }
            } else {
               Class39.intStack[++Class23.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

}
