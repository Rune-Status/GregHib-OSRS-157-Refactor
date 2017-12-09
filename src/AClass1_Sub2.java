public class AClass1_Sub2 extends AClass1 {

   void method635(Buffer buffer_0, Buffer buffer_1) {
      int int_0 = buffer_1.getUnsignedByte();
      if (int_0 != Class10.aClass10_2.anInt49) {
         throw new IllegalStateException("");
      } else {
         this.anInt53 = buffer_1.getUnsignedByte();
         this.anInt52 = buffer_1.getUnsignedByte();
         this.anInt54 = buffer_1.getUnsignedShort();
         this.anInt55 = buffer_1.getUnsignedShort();
         this.anInt50 = buffer_1.getUnsignedShort();
         this.anInt51 = buffer_1.getUnsignedShort();
         this.anInt52 = Math.min(this.anInt52, 4);
         this.aShortArrayArrayArray1 = new short[1][64][64];
         this.aShortArrayArrayArray2 = new short[this.anInt52][64][64];
         this.aByteArrayArrayArray3 = new byte[this.anInt52][64][64];
         this.aByteArrayArrayArray4 = new byte[this.anInt52][64][64];
         this.aClass6ArrayArrayArrayArray1 = new Class6[this.anInt52][64][64][];
         int_0 = buffer_0.getUnsignedByte();
         if (int_0 != Class12.aClass12_1.anInt57) {
            throw new IllegalStateException("");
         } else {
            int int_1 = buffer_0.getUnsignedByte();
            int int_2 = buffer_0.getUnsignedByte();
            if (int_1 == this.anInt50 && int_2 == this.anInt51) {
               for (int int_3 = 0; int_3 < 64; int_3++) {
                  for (int int_4 = 0; int_4 < 64; int_4++) {
                     this.method162(int_3, int_4, buffer_0);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public int hashCode() {
      return this.anInt50 | this.anInt51 << 8;
   }

   public boolean equals(Object object_0) {
      if (!(object_0 instanceof AClass1_Sub2)) {
         return false;
      } else {
         AClass1_Sub2 aclass1_sub2_1 = (AClass1_Sub2) object_0;
         return this.anInt50 == aclass1_sub2_1.anInt50 && aclass1_sub2_1.anInt51 == this.anInt51;
      }
   }

   static void method636(int int_0, int int_1, int int_2, int int_3) {
      for (int int_4 = 0; int_4 < Client.anInt610; int_4++) {
         if (Client.widgetPositionX[int_4] + Client.widgetBoundsWidth[int_4] > int_0 && Client.widgetPositionX[int_4] < int_0 + int_2 && Client.widgetBoundsHeight[int_4] + Client.widgetPositionY[int_4] > int_1 && Client.widgetPositionY[int_4] < int_3 + int_1) {
            Client.aBoolArray8[int_4] = true;
         }
      }

   }

   static void method637(Widget[] widgets_0, Widget widget_0, boolean bool_0) {
      int int_0 = widget_0.scrollWidth != 0 ? widget_0.scrollWidth : widget_0.width;
      int int_1 = widget_0.scrollHeight != 0 ? widget_0.scrollHeight : widget_0.height;
      Timer.method586(widgets_0, widget_0.id, int_0, int_1, bool_0);
      if (widget_0.children != null) {
         Timer.method586(widget_0.children, widget_0.id, int_0, int_1, bool_0);
      }

      WidgetNode widgetnode_0 = (WidgetNode) Client.componentTable.get((long)widget_0.id);
      if (widgetnode_0 != null) {
         int int_2 = widgetnode_0.id;
         if (CombatInfoListHolder.loadWidget(int_2)) {
            Timer.method586(Class91.widgets[int_2], -1, int_0, int_1, bool_0);
         }
      }

      if (widget_0.contentType == 1337) {
         ;
      }

   }

   public static void method638(IndexDataBase indexdatabase_0) {
      CacheableNode_Sub3.anIndexDataBase22 = indexdatabase_0;
   }

   static void method639() {
      int int_0 = Class73.anInt171 * 128 + 64;
      int int_1 = Class42.anInt101 * 128 + 64;
      int int_2 = Class18.getTileHeight(int_0, int_1, Ignore.plane) - Class26.anInt88;
      if (Class2.cameraX < int_0) {
         Class2.cameraX = (int_0 - Class2.cameraX) * Class50.anInt112 / 1000 + Class2.cameraX + Class41.anInt99;
         if (Class2.cameraX > int_0) {
            Class2.cameraX = int_0;
         }
      }

      if (Class2.cameraX > int_0) {
         Class2.cameraX -= Class50.anInt112 * (Class2.cameraX - int_0) / 1000 + Class41.anInt99;
         if (Class2.cameraX < int_0) {
            Class2.cameraX = int_0;
         }
      }

      if (Class18.cameraZ < int_2) {
         Class18.cameraZ = (int_2 - Class18.cameraZ) * Class50.anInt112 / 1000 + Class18.cameraZ + Class41.anInt99;
         if (Class18.cameraZ > int_2) {
            Class18.cameraZ = int_2;
         }
      }

      if (Class18.cameraZ > int_2) {
         Class18.cameraZ -= Class50.anInt112 * (Class18.cameraZ - int_2) / 1000 + Class41.anInt99;
         if (Class18.cameraZ < int_2) {
            Class18.cameraZ = int_2;
         }
      }

      if (Player.cameraY < int_1) {
         Player.cameraY = (int_1 - Player.cameraY) * Class50.anInt112 / 1000 + Player.cameraY + Class41.anInt99;
         if (Player.cameraY > int_1) {
            Player.cameraY = int_1;
         }
      }

      if (Player.cameraY > int_1) {
         Player.cameraY -= Class50.anInt112 * (Player.cameraY - int_1) / 1000 + Class41.anInt99;
         if (Player.cameraY < int_1) {
            Player.cameraY = int_1;
         }
      }

      int_0 = Class9.anInt42 * 128 + 64;
      int_1 = Class17.anInt69 * 128 + 64;
      int_2 = Class18.getTileHeight(int_0, int_1, Ignore.plane) - CombatInfo1.anInt351;
      int int_3 = int_0 - Class2.cameraX;
      int int_4 = int_2 - Class18.cameraZ;
      int int_5 = int_1 - Player.cameraY;
      int int_6 = (int)Math.sqrt((double)(int_5 * int_5 + int_3 * int_3));
      int int_7 = (int)(Math.atan2((double)int_4, (double)int_6) * 325.949D) & 0x7FF;
      int int_8 = (int)(Math.atan2((double)int_3, (double)int_5) * -325.949D) & 0x7FF;
      if (int_7 < 128) {
         int_7 = 128;
      }

      if (int_7 > 383) {
         int_7 = 383;
      }

      if (AClass1.cameraPitch < int_7) {
         AClass1.cameraPitch = (int_7 - AClass1.cameraPitch) * AClass3_Sub1.anInt402 / 1000 + AClass1.cameraPitch + TextureProvider.anInt225;
         if (AClass1.cameraPitch > int_7) {
            AClass1.cameraPitch = int_7;
         }
      }

      if (AClass1.cameraPitch > int_7) {
         AClass1.cameraPitch -= AClass3_Sub1.anInt402 * (AClass1.cameraPitch - int_7) / 1000 + TextureProvider.anInt225;
         if (AClass1.cameraPitch < int_7) {
            AClass1.cameraPitch = int_7;
         }
      }

      int int_9 = int_8 - Enum4.cameraYaw;
      if (int_9 > 1024) {
         int_9 -= 2048;
      }

      if (int_9 < -1024) {
         int_9 += 2048;
      }

      if (int_9 > 0) {
         Enum4.cameraYaw = Enum4.cameraYaw + TextureProvider.anInt225 + int_9 * AClass3_Sub1.anInt402 / 1000;
         Enum4.cameraYaw &= 0x7FF;
      }

      if (int_9 < 0) {
         Enum4.cameraYaw -= TextureProvider.anInt225 + -int_9 * AClass3_Sub1.anInt402 / 1000;
         Enum4.cameraYaw &= 0x7FF;
      }

      int int_10 = int_8 - Enum4.cameraYaw;
      if (int_10 > 1024) {
         int_10 -= 2048;
      }

      if (int_10 < -1024) {
         int_10 += 2048;
      }

      if (int_10 < 0 && int_9 > 0 || int_10 > 0 && int_9 < 0) {
         Enum4.cameraYaw = int_8;
      }

   }

   public static int method640() {
      return KeyFocusListener.keyboardIdleTicks;
   }

   static char method641(char char_0) {
      if (char_0 >= 192 && char_0 <= 255) {
         if (char_0 >= 192 && char_0 <= 198) {
            return 'A';
         }

         if (char_0 == 199) {
            return 'C';
         }

         if (char_0 >= 200 && char_0 <= 203) {
            return 'E';
         }

         if (char_0 >= 204 && char_0 <= 207) {
            return 'I';
         }

         if (char_0 >= 210 && char_0 <= 214) {
            return 'O';
         }

         if (char_0 >= 217 && char_0 <= 220) {
            return 'U';
         }

         if (char_0 == 221) {
            return 'Y';
         }

         if (char_0 == 223) {
            return 's';
         }

         if (char_0 >= 224 && char_0 <= 230) {
            return 'a';
         }

         if (char_0 == 231) {
            return 'c';
         }

         if (char_0 >= 232 && char_0 <= 235) {
            return 'e';
         }

         if (char_0 >= 236 && char_0 <= 239) {
            return 'i';
         }

         if (char_0 >= 242 && char_0 <= 246) {
            return 'o';
         }

         if (char_0 >= 249 && char_0 <= 252) {
            return 'u';
         }

         if (char_0 == 253 || char_0 == 255) {
            return 'y';
         }
      }

      return char_0 == 338 ? 'O' : (char_0 == 339 ? 'o' : (char_0 == 376 ? 'Y' : char_0));
   }

}
