public enum Enum5 implements RSEnum {

   anEnum5_1(0, 0),
   anEnum5_2(2, 1),
   anEnum5_3(1, 2);

   public static boolean isMembersWorld;
   public final int anInt383;
   final int anInt384;

   Enum5(int int_1, int int_2) {
      this.anInt383 = int_1;
      this.anInt384 = int_2;
   }

   public int rsOrdinal() {
      return this.anInt384;
   }

   static int parseInt(CharSequence charsequence_0, int int_0, boolean bool_0) {
      if (int_0 >= 2 && int_0 <= 36) {
         boolean bool_1 = false;
         boolean bool_2 = false;
         int int_1 = 0;
         int int_2 = charsequence_0.length();

         for (int int_3 = 0; int_3 < int_2; int_3++) {
            char char_0 = charsequence_0.charAt(int_3);
            if (int_3 == 0) {
               if (char_0 == 45) {
                  bool_1 = true;
                  continue;
               }

               if (char_0 == 43) {
                  continue;
               }
            }

            int int_5;
            if (char_0 >= 48 && char_0 <= 57) {
               int_5 = char_0 - 48;
            } else if (char_0 >= 65 && char_0 <= 90) {
               int_5 = char_0 - 55;
            } else {
               if (char_0 < 97 || char_0 > 122) {
                  throw new NumberFormatException();
               }

               int_5 = char_0 - 87;
            }

            if (int_5 >= int_0) {
               throw new NumberFormatException();
            }

            if (bool_1) {
               int_5 = -int_5;
            }

            int int_4 = int_1 * int_0 + int_5;
            if (int_4 / int_0 != int_1) {
               throw new NumberFormatException();
            }

            int_1 = int_4;
            bool_2 = true;
         }

         if (!bool_2) {
            throw new NumberFormatException();
         } else {
            return int_1;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   public static void method700(IndexDataBase indexdatabase_0) {
      Overlay.overlay_ref = indexdatabase_0;
   }

   static int method701(int int_0, Script script_0, boolean bool_0) {
      int int_1 = -1;
      Widget widget_0;
      if (int_0 >= 2000) {
         int_0 -= 1000;
         int_1 = Class39.intStack[--Class23.intStackSize];
         widget_0 = PendingSpawn.method671(int_1);
      } else {
         widget_0 = bool_0 ? Class106.aWidget4 : Friend.aWidget5;
      }

      if (int_0 == 1100) {
         Class23.intStackSize -= 2;
         widget_0.scrollX = Class39.intStack[Class23.intStackSize];
         if (widget_0.scrollX > widget_0.scrollWidth - widget_0.width) {
            widget_0.scrollX = widget_0.scrollWidth - widget_0.width;
         }

         if (widget_0.scrollX < 0) {
            widget_0.scrollX = 0;
         }

         widget_0.scrollY = Class39.intStack[Class23.intStackSize + 1];
         if (widget_0.scrollY > widget_0.scrollHeight - widget_0.height) {
            widget_0.scrollY = widget_0.scrollHeight - widget_0.height;
         }

         if (widget_0.scrollY < 0) {
            widget_0.scrollY = 0;
         }

         WorldMapData.method305(widget_0);
         return 1;
      } else if (int_0 == 1101) {
         widget_0.textColor = Class39.intStack[--Class23.intStackSize];
         WorldMapData.method305(widget_0);
         return 1;
      } else if (int_0 == 1102) {
         widget_0.aBool36 = Class39.intStack[--Class23.intStackSize] == 1;
         WorldMapData.method305(widget_0);
         return 1;
      } else if (int_0 == 1103) {
         widget_0.opacity = Class39.intStack[--Class23.intStackSize];
         WorldMapData.method305(widget_0);
         return 1;
      } else if (int_0 == 1104) {
         widget_0.anInt289 = Class39.intStack[--Class23.intStackSize];
         WorldMapData.method305(widget_0);
         return 1;
      } else if (int_0 == 1105) {
         widget_0.spriteId = Class39.intStack[--Class23.intStackSize];
         WorldMapData.method305(widget_0);
         return 1;
      } else if (int_0 == 1106) {
         widget_0.textureId = Class39.intStack[--Class23.intStackSize];
         WorldMapData.method305(widget_0);
         return 1;
      } else if (int_0 == 1107) {
         widget_0.aBool39 = Class39.intStack[--Class23.intStackSize] == 1;
         WorldMapData.method305(widget_0);
         return 1;
      } else if (int_0 == 1108) {
         widget_0.modelType = 1;
         widget_0.modelId = Class39.intStack[--Class23.intStackSize];
         WorldMapData.method305(widget_0);
         return 1;
      } else if (int_0 == 1109) {
         Class23.intStackSize -= 6;
         widget_0.anInt293 = Class39.intStack[Class23.intStackSize];
         widget_0.anInt294 = Class39.intStack[Class23.intStackSize + 1];
         widget_0.rotationX = Class39.intStack[Class23.intStackSize + 2];
         widget_0.rotationZ = Class39.intStack[Class23.intStackSize + 3];
         widget_0.rotationY = Class39.intStack[Class23.intStackSize + 4];
         widget_0.modelZoom = Class39.intStack[Class23.intStackSize + 5];
         WorldMapData.method305(widget_0);
         return 1;
      } else {
         int int_2;
         if (int_0 == 1110) {
            int_2 = Class39.intStack[--Class23.intStackSize];
            if (int_2 != widget_0.anInt277) {
               widget_0.anInt277 = int_2;
               widget_0.anInt281 = 0;
               widget_0.anInt280 = 0;
               WorldMapData.method305(widget_0);
            }

            return 1;
         } else if (int_0 == 1111) {
            widget_0.aBool41 = Class39.intStack[--Class23.intStackSize] == 1;
            WorldMapData.method305(widget_0);
            return 1;
         } else if (int_0 == 1112) {
            String string_0 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
            if (!string_0.equals(widget_0.text)) {
               widget_0.text = string_0;
               WorldMapData.method305(widget_0);
            }

            return 1;
         } else if (int_0 == 1113) {
            widget_0.fontId = Class39.intStack[--Class23.intStackSize];
            WorldMapData.method305(widget_0);
            return 1;
         } else if (int_0 == 1114) {
            Class23.intStackSize -= 3;
            widget_0.anInt290 = Class39.intStack[Class23.intStackSize];
            widget_0.anInt291 = Class39.intStack[Class23.intStackSize + 1];
            widget_0.anInt292 = Class39.intStack[Class23.intStackSize + 2];
            WorldMapData.method305(widget_0);
            return 1;
         } else if (int_0 == 1115) {
            widget_0.textShadowed = Class39.intStack[--Class23.intStackSize] == 1;
            WorldMapData.method305(widget_0);
            return 1;
         } else if (int_0 == 1116) {
            widget_0.borderThickness = Class39.intStack[--Class23.intStackSize];
            WorldMapData.method305(widget_0);
            return 1;
         } else if (int_0 == 1117) {
            widget_0.sprite2 = Class39.intStack[--Class23.intStackSize];
            WorldMapData.method305(widget_0);
            return 1;
         } else if (int_0 == 1118) {
            widget_0.flippedVertically = Class39.intStack[--Class23.intStackSize] == 1;
            WorldMapData.method305(widget_0);
            return 1;
         } else if (int_0 == 1119) {
            widget_0.flippedHorizontally = Class39.intStack[--Class23.intStackSize] == 1;
            WorldMapData.method305(widget_0);
            return 1;
         } else if (int_0 == 1120) {
            Class23.intStackSize -= 2;
            widget_0.scrollWidth = Class39.intStack[Class23.intStackSize];
            widget_0.scrollHeight = Class39.intStack[Class23.intStackSize + 1];
            WorldMapData.method305(widget_0);
            if (int_1 != -1 && widget_0.type == 0) {
               AClass1_Sub2.method637(Class91.widgets[int_1 >> 16], widget_0, false);
            }

            return 1;
         } else if (int_0 == 1121) {
            Class12.method167(widget_0.id, widget_0.index);
            Client.aWidget12 = widget_0;
            WorldMapData.method305(widget_0);
            return 1;
         } else if (int_0 == 1122) {
            widget_0.anInt267 = Class39.intStack[--Class23.intStackSize];
            WorldMapData.method305(widget_0);
            return 1;
         } else if (int_0 == 1123) {
            widget_0.anInt283 = Class39.intStack[--Class23.intStackSize];
            WorldMapData.method305(widget_0);
            return 1;
         } else if (int_0 == 1124) {
            widget_0.anInt288 = Class39.intStack[--Class23.intStackSize];
            WorldMapData.method305(widget_0);
            return 1;
         } else if (int_0 == 1125) {
            int_2 = Class39.intStack[--Class23.intStackSize];
            Enum9[] enum9s_0 = new Enum9[] {Enum9.anEnum9_4, Enum9.anEnum9_2, Enum9.anEnum9_5, Enum9.anEnum9_3, Enum9.anEnum9_6};
            Enum9 enum9_0 = (Enum9) Class1.forOrdinal(enum9s_0, int_2);
            if (enum9_0 != null) {
               widget_0.anEnum9_1 = enum9_0;
               WorldMapData.method305(widget_0);
            }

            return 1;
         } else if (int_0 == 1126) {
            boolean bool_1 = Class39.intStack[--Class23.intStackSize] == 1;
            widget_0.aBool37 = bool_1;
            return 1;
         } else {
            return 2;
         }
      }
   }

}
