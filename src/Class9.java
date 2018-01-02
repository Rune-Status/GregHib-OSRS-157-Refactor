import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Class9 {

   static final Coordinates aCoordinates4;
   static int anInt42;
   static int[] anIntArray4;
   static int anInt43;
   int[][] anIntArrayArray5;
   SpritePixels aSpritePixels1;
   List aList2;
   LinkedList aLinkedList1;
   HashMap aHashMap3;
   AClass1_Sub2 anAClass1_Sub2_1;
   int anInt44;
   int anInt45;
   final HashMap aHashMap4;
   int anInt46;
   int anInt47;

   static {
      aCoordinates4 = new Coordinates();
   }

   Class9(int int_0, int int_1, int int_2, HashMap hashmap_0) {
      this.anInt44 = int_0;
      this.anInt46 = int_1;
      this.aLinkedList1 = new LinkedList();
      this.aList2 = new LinkedList();
      this.aHashMap3 = new HashMap();
      this.anInt47 = int_2 | 0xFF000000;
      this.aHashMap4 = hashmap_0;
   }

   boolean method106(int int_0) {
      if (this.aSpritePixels1 != null && this.anInt45 == int_0) {
         return false;
      } else {
         this.anInt45 = int_0;
         this.aSpritePixels1 = new SpritePixels(this.anInt45 * 64, this.anInt45 * 64);
         return true;
      }
   }

   void method107(int int_0, int int_1, AClass1 aclass1_0) {
      for (int int_2 = 0; int_2 < aclass1_0.anInt52; int_2++) {
         Class6[] class6s_0 = aclass1_0.aClass6ArrayArrayArrayArray1[int_2][int_0][int_1];
         if (class6s_0 != null && class6s_0.length != 0) {
            Class6[] class6s_1 = class6s_0;

            for (int int_3 = 0; int_3 < class6s_1.length; int_3++) {
               Class6 class6_0 = class6s_1[int_3];
               if (SoundTask.method320(class6_0.anInt38)) {
                  ObjectDefinition objectcomposition_0 = ObjectDefinition.getDefinition(class6_0.anInt37);
                  int int_4 = objectcomposition_0.hasOptions != 0 ? -3407872 : -3355444;
                  if (class6_0.anInt38 == Enum4.anEnum4_1.anInt382) {
                     this.method138(int_0, int_1, class6_0.anInt39, int_4);
                  }

                  if (class6_0.anInt38 == Enum4.anEnum4_3.anInt382) {
                     this.method138(int_0, int_1, class6_0.anInt39, -3355444);
                     this.method138(int_0, int_1, class6_0.anInt39 + 1, int_4);
                  }

                  if (class6_0.anInt38 == Enum4.anEnum4_4.anInt382) {
                     if (class6_0.anInt39 == 0) {
                        Rasterizer2D.drawHorizontal(this.anInt45 * int_0, this.anInt45 * (63 - int_1), 1, int_4);
                     }

                     if (class6_0.anInt39 == 1) {
                        Rasterizer2D.drawHorizontal(this.anInt45 * int_0 + this.anInt45 - 1, this.anInt45 * (63 - int_1), 1, int_4);
                     }

                     if (class6_0.anInt39 == 2) {
                        Rasterizer2D.drawHorizontal(this.anInt45 + this.anInt45 * int_0 - 1, this.anInt45 * (63 - int_1) + this.anInt45 - 1, 1, int_4);
                     }

                     if (class6_0.anInt39 == 3) {
                        Rasterizer2D.drawHorizontal(this.anInt45 * int_0, this.anInt45 * (63 - int_1) + this.anInt45 - 1, 1, int_4);
                     }
                  }

                  if (class6_0.anInt38 == Enum4.anEnum4_5.anInt382) {
                     int int_5 = class6_0.anInt39 % 2;
                     int int_6;
                     if (int_5 == 0) {
                        for (int_6 = 0; int_6 < this.anInt45; int_6++) {
                           Rasterizer2D.drawHorizontal(int_6 + this.anInt45 * int_0, (64 - int_1) * this.anInt45 - 1 - int_6, 1, int_4);
                        }
                     } else {
                        for (int_6 = 0; int_6 < this.anInt45; int_6++) {
                           Rasterizer2D.drawHorizontal(int_6 + this.anInt45 * int_0, int_6 + this.anInt45 * (63 - int_1), 1, int_4);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   void method108(int int_0, int int_1, HashSet hashset_0, int int_2) {
      float float_0 = (float)int_2 / 64.0F;
      float float_1 = float_0 / 2.0F;
      Iterator iterator_0 = this.aHashMap3.entrySet().iterator();

      while (iterator_0.hasNext()) {
         Entry map$entry_0 = (Entry) iterator_0.next();
         Coordinates coordinates_0 = (Coordinates) map$entry_0.getKey();
         int int_3 = (int)((float)int_0 + (float)coordinates_0.worldX * float_0 - float_1);
         int int_4 = (int)((float)(int_1 + int_2) - float_0 * (float)coordinates_0.worldY - float_1);
         Class15 class15_0 = (Class15) map$entry_0.getValue();
         if (class15_0 != null) {
            class15_0.anInt65 = int_3;
            class15_0.anInt67 = int_4;
            Area area_0 = Area.anAreaArray1[class15_0.anInt64];
            if (!hashset_0.contains(Integer.valueOf(area_0.method812()))) {
               this.method135(class15_0, int_3, int_4, float_0);
            }
         }
      }

   }

   void method109(int int_0, int int_1, AClass1 aclass1_0, IndexedSprite[] indexedsprites_0) {
      for (int int_2 = 0; int_2 < aclass1_0.anInt52; int_2++) {
         Class6[] class6s_0 = aclass1_0.aClass6ArrayArrayArrayArray1[int_2][int_0][int_1];
         if (class6s_0 != null && class6s_0.length != 0) {
            Class6[] class6s_1 = class6s_0;

            for (int int_3 = 0; int_3 < class6s_1.length; int_3++) {
               Class6 class6_0 = class6s_1[int_3];
               int int_4 = class6_0.anInt38;
               boolean bool_0 = int_4 >= Enum4.anEnum4_21.anInt382 && int_4 <= Enum4.anEnum4_22.anInt382;
               if (bool_0 || Class55.method354(class6_0.anInt38)) {
                  ObjectDefinition objectcomposition_0 = ObjectDefinition.getDefinition(class6_0.anInt37);
                  if (objectcomposition_0.mapSceneId != -1) {
                     if (objectcomposition_0.mapSceneId != 46 && objectcomposition_0.mapSceneId != 52) {
                        indexedsprites_0[objectcomposition_0.mapSceneId].method976(this.anInt45 * int_0, this.anInt45 * (63 - int_1), this.anInt45 * 2, this.anInt45 * 2);
                     } else {
                        indexedsprites_0[objectcomposition_0.mapSceneId].method976(this.anInt45 * int_0, this.anInt45 * (63 - int_1), this.anInt45 * 2 + 1, this.anInt45 * 2 + 1);
                     }
                  }
               }
            }
         }
      }

   }

   Class13 method110(Area area_0) {
      if (area_0.name != null && this.aHashMap4 != null && this.aHashMap4.get(Class28.aClass28_2) != null) {
         Class28 class28_0 = Class28.method229(area_0.anInt447);
         if (class28_0 == null) {
            return null;
         } else {
            Font font_0 = (Font) this.aHashMap4.get(class28_0);
            if (font_0 == null) {
               return null;
            } else {
               int int_0 = font_0.method1035(area_0.name, 1000000);
               String[] strings_0 = new String[int_0];
               font_0.getIndexOfLongestStringInArray(area_0.name, (int[]) null, strings_0);
               int int_1 = strings_0.length * font_0.verticalSpace / 2;
               int int_2 = 0;
               String[] strings_1 = strings_0;

               for (int int_3 = 0; int_3 < strings_1.length; int_3++) {
                  String string_0 = strings_1[int_3];
                  int int_4 = font_0.getWidth(string_0);
                  if (int_4 > int_2) {
                     int_2 = int_4;
                  }
               }

               return new Class13(area_0.name, int_2, int_1, class28_0);
            }
         }
      } else {
         return null;
      }
   }

   void method111(Area area_0, int int_0, int int_1) {
      SpritePixels spritepixels_0 = area_0.method809(false);
      if (spritepixels_0 != null) {
         int int_2 = this.method114(spritepixels_0, area_0.anEnum8_4);
         int int_3 = this.method124(spritepixels_0, area_0.anEnum5_4);
         spritepixels_0.drawAt(int_2 + int_0, int_1 + int_3);
      }

   }

   void method112(int int_0, int int_1, HashSet hashset_0, int int_2) {
      float float_0 = (float)int_2 / 64.0F;
      Iterator iterator_0 = this.aList2.iterator();

      while (iterator_0.hasNext()) {
         Class15 class15_0 = (Class15) iterator_0.next();
         int int_3 = class15_0.aCoordinates6.worldX % 64;
         int int_4 = class15_0.aCoordinates6.worldY % 64;
         class15_0.anInt65 = (int)(float_0 * (float)int_3 + (float)int_0);
         class15_0.anInt67 = (int)((float)int_1 + (float)(63 - int_4) * float_0);
         if (!hashset_0.contains(Integer.valueOf(class15_0.anInt64))) {
            this.method135(class15_0, class15_0.anInt65, class15_0.anInt67, float_0);
         }
      }

   }

   void method113(int int_0, int int_1, AClass1 aclass1_0, Class5 class5_0) {
      int int_2 = aclass1_0.aShortArrayArrayArray1[0][int_0][int_1] - 1;
      int int_3 = aclass1_0.aShortArrayArrayArray2[0][int_0][int_1] - 1;
      if (int_2 == -1 && int_3 == -1) {
         Rasterizer2D.fillRect(this.anInt45 * int_0, this.anInt45 * (63 - int_1), this.anInt45, this.anInt45, this.anInt47);
      }

      int int_4 = 16711935;
      if (int_3 != -1) {
         int_4 = TileStrategy.method629(int_3, this.anInt47);
      }

      if (int_3 > -1 && aclass1_0.aByteArrayArrayArray3[0][int_0][int_1] == 0) {
         Rasterizer2D.fillRect(this.anInt45 * int_0, this.anInt45 * (63 - int_1), this.anInt45, this.anInt45, int_4);
      } else {
         int int_5 = this.method130(int_0, int_1, aclass1_0);
         if (int_3 == -1) {
            Rasterizer2D.fillRect(this.anInt45 * int_0, this.anInt45 * (63 - int_1), this.anInt45, this.anInt45, int_5);
         } else {
            class5_0.method95(this.anInt45 * int_0, this.anInt45 * (63 - int_1), int_5, int_4, this.anInt45, this.anInt45, aclass1_0.aByteArrayArrayArray3[0][int_0][int_1], aclass1_0.aByteArrayArrayArray4[0][int_0][int_1]);
         }
      }
   }

   int method114(SpritePixels spritepixels_0, Enum8 enum8_0) {
      switch(enum8_0.anInt389) {
      case 0:
         return 0;
      case 2:
         return -spritepixels_0.width / 2;
      default:
         return -spritepixels_0.width;
      }
   }

   int method115(int int_0, int int_1) {
      if (this.anAClass1_Sub2_1 != null) {
         return this.anAClass1_Sub2_1.method157(int_0, int_1);
      } else {
         if (!this.aLinkedList1.isEmpty()) {
            Iterator iterator_0 = this.aLinkedList1.iterator();

            while (iterator_0.hasNext()) {
               AClass1_Sub1 aclass1_sub1_0 = (AClass1_Sub1) iterator_0.next();
               if (aclass1_sub1_0.method618(int_0, int_1)) {
                  return aclass1_sub1_0.method157(int_0, int_1);
               }
            }
         }

         return -1;
      }
   }

   void method116(int int_0, int int_1, AClass1 aclass1_0, Class5 class5_0, IndexedSprite[] indexedsprites_0) {
      this.method107(int_0, int_1, aclass1_0);
      this.method109(int_0, int_1, aclass1_0, indexedsprites_0);
   }

   void method117(HashSet hashset_0, int int_0, int int_1) {
      Iterator iterator_0 = this.aList2.iterator();

      while (iterator_0.hasNext()) {
         Class15 class15_0 = (Class15) iterator_0.next();
         Area area_0 = Area.anAreaArray1[class15_0.anInt64];
         if (area_0 != null && hashset_0.contains(Integer.valueOf(area_0.method812()))) {
            this.method132(area_0, class15_0.anInt65, class15_0.anInt67, int_0, int_1);
         }
      }

   }

   void method118(int int_0, int int_1, int int_2, int int_3, AClass1 aclass1_0) {
      for (int int_4 = int_0; int_4 < int_2 + int_0; int_4++) {
         label57:
         for (int int_5 = int_1; int_5 < int_1 + int_3; int_5++) {
            Coordinates coordinates_0 = new Coordinates(0, int_4, int_5);

            for (int int_6 = 0; int_6 < aclass1_0.anInt52; int_6++) {
               Class6[] class6s_0 = aclass1_0.aClass6ArrayArrayArrayArray1[int_6][int_4][int_5];
               if (class6s_0 != null && class6s_0.length != 0) {
                  Class6[] class6s_1 = class6s_0;

                  for (int int_7 = 0; int_7 < class6s_1.length; int_7++) {
                     Class6 class6_0 = class6s_1[int_7];
                     Area area_0 = this.method131(class6_0.anInt37);
                     if (area_0 != null) {
                        Coordinates coordinates_1 = new Coordinates(int_6, this.anInt44 * 64 + int_4, this.anInt46 * 64 + int_5);
                        Coordinates coordinates_2 = null;
                        if (this.anAClass1_Sub2_1 != null) {
                           coordinates_2 = new Coordinates(this.anAClass1_Sub2_1.anInt53 + int_6, int_4 + this.anAClass1_Sub2_1.anInt54 * 64, int_5 + this.anAClass1_Sub2_1.anInt55 * 64);
                        } else {
                           AClass1_Sub1 aclass1_sub1_0 = (AClass1_Sub1) aclass1_0;
                           coordinates_2 = new Coordinates(int_6 + aclass1_sub1_0.anInt53, int_4 + aclass1_sub1_0.anInt54 * 64 + aclass1_sub1_0.method621() * 8, int_5 + aclass1_sub1_0.anInt55 * 64 + aclass1_sub1_0.method622() * 8);
                        }

                        Class15 class15_0 = new Class15(area_0.anInt443, coordinates_2, coordinates_1, this.method110(area_0));
                        this.aHashMap3.put(coordinates_0, class15_0);
                        continue label57;
                     }
                  }
               }
            }
         }
      }

   }

   void method119(List list_0) {
      Iterator iterator_0 = list_0.iterator();

      while (iterator_0.hasNext()) {
         Class41 class41_0 = (Class41) iterator_0.next();
         if (class41_0.aCoordinates7.worldX >> 6 == this.anInt44 && class41_0.aCoordinates7.worldY >> 6 == this.anInt46) {
            Class15 class15_0 = new Class15(class41_0.anInt100, class41_0.aCoordinates7, class41_0.aCoordinates7, this.method134(class41_0.anInt100));
            this.aList2.add(class15_0);
         }
      }

   }

   void method120(int int_0, int int_1, AClass1 aclass1_0) {
      aCoordinates4.method514(0, int_0, int_1);

      for (int int_2 = 0; int_2 < aclass1_0.anInt52; int_2++) {
         Class6[] class6s_0 = aclass1_0.aClass6ArrayArrayArrayArray1[int_2][int_0][int_1];
         if (class6s_0 != null && class6s_0.length != 0) {
            Class6[] class6s_1 = class6s_0;

            for (int int_3 = 0; int_3 < class6s_1.length; int_3++) {
               Class6 class6_0 = class6s_1[int_3];
               Area area_0 = this.method131(class6_0.anInt37);
               if (area_0 != null) {
                  Class15 class15_0 = (Class15) this.aHashMap3.get(aCoordinates4);
                  if (class15_0 != null) {
                     if (area_0.anInt443 != class15_0.anInt64) {
                        Class15 class15_1 = new Class15(area_0.anInt443, class15_0.aCoordinates5, class15_0.aCoordinates6, this.method110(area_0));
                        this.aHashMap3.put(new Coordinates(aCoordinates4), class15_1);
                        class15_0 = class15_1;
                     }

                     int int_4 = class15_0.aCoordinates5.plane - class15_0.aCoordinates6.plane;
                     class15_0.aCoordinates6.plane = int_2;
                     class15_0.aCoordinates5.plane = int_2 + int_4;
                     return;
                  }

                  Coordinates coordinates_0 = new Coordinates(int_2, this.anInt44 * 64 + int_0, this.anInt46 * 64 + int_1);
                  Coordinates coordinates_1 = null;
                  if (this.anAClass1_Sub2_1 != null) {
                     coordinates_1 = new Coordinates(this.anAClass1_Sub2_1.anInt53 + int_2, this.anAClass1_Sub2_1.anInt54 * 64 + int_0, int_1 + this.anAClass1_Sub2_1.anInt55 * 64);
                  } else {
                     Iterator iterator_0 = this.aLinkedList1.iterator();

                     while (iterator_0.hasNext()) {
                        AClass1_Sub1 aclass1_sub1_0 = (AClass1_Sub1) iterator_0.next();
                        if (aclass1_sub1_0.method618(int_0, int_1)) {
                           coordinates_1 = new Coordinates(int_2 + aclass1_sub1_0.anInt53, int_0 + aclass1_sub1_0.anInt54 * 64 + aclass1_sub1_0.method621() * 8, int_1 + aclass1_sub1_0.anInt55 * 64 + aclass1_sub1_0.method622() * 8);
                           break;
                        }
                     }
                  }

                  if (coordinates_1 != null) {
                     class15_0 = new Class15(area_0.anInt443, coordinates_1, coordinates_0, this.method110(area_0));
                     this.aHashMap3.put(new Coordinates(aCoordinates4), class15_0);
                     return;
                  }
               }
            }
         }
      }

      this.aHashMap3.remove(aCoordinates4);
   }

   void method121(Class15 class15_0, Area area_0, int int_0, int int_1, float float_0) {
      if (class15_0.aClass13_1 != null) {
         if (class15_0.aClass13_1.aClass28_1.method228(float_0)) {
            Font font_0 = (Font) this.aHashMap4.get(class15_0.aClass13_1.aClass28_1);
            font_0.method1036(class15_0.aClass13_1.aString1, int_0 - class15_0.aClass13_1.anInt58 / 2, int_1, class15_0.aClass13_1.anInt58, class15_0.aClass13_1.anInt59, 0xFF000000 | area_0.anInt445, 0, 1, 0, font_0.verticalSpace / 2);
         }
      }
   }

   boolean method122(Class9[] class9s_0) {
      if (this.anIntArrayArray5 != null) {
         return false;
      } else {
         Class3 class3_0 = new Class3(64, 64);
         if (this.anAClass1_Sub2_1 != null) {
            this.method125(0, 0, 64, 64, this.anAClass1_Sub2_1, class3_0);
         } else {
            Iterator iterator_0 = this.aLinkedList1.iterator();

            while (iterator_0.hasNext()) {
               AClass1_Sub1 aclass1_sub1_0 = (AClass1_Sub1) iterator_0.next();
               this.method125(aclass1_sub1_0.method617() * 8, aclass1_sub1_0.method619() * 8, 8, 8, aclass1_sub1_0, class3_0);
            }
         }

         this.method126(class9s_0, class3_0);
         this.method127(class3_0);
         return true;
      }
   }

   void method123(int int_0, int int_1, AClass1 aclass1_0, Class5 class5_0) {
      for (int int_2 = 1; int_2 < aclass1_0.anInt52; int_2++) {
         int int_3 = aclass1_0.aShortArrayArrayArray2[int_2][int_0][int_1] - 1;
         if (int_3 > -1) {
            int int_4 = TileStrategy.method629(int_3, this.anInt47);
            if (aclass1_0.aByteArrayArrayArray3[int_2][int_0][int_1] == 0) {
               Rasterizer2D.fillRect(this.anInt45 * int_0, this.anInt45 * (63 - int_1), this.anInt45, this.anInt45, int_4);
            } else {
               class5_0.method95(this.anInt45 * int_0, this.anInt45 * (63 - int_1), 0, int_4, this.anInt45, this.anInt45, aclass1_0.aByteArrayArrayArray3[int_2][int_0][int_1], aclass1_0.aByteArrayArrayArray4[int_2][int_0][int_1]);
            }
         }
      }

   }

   int method124(SpritePixels spritepixels_0, Enum5 enum5_0) {
      switch(enum5_0.anInt383) {
      case 0:
         return 0;
      case 2:
         return -spritepixels_0.height / 2;
      default:
         return -spritepixels_0.height;
      }
   }

   void method125(int int_0, int int_1, int int_2, int int_3, AClass1 aclass1_0, Class3 class3_0) {
      for (int int_4 = int_0; int_4 < int_2 + int_0; int_4++) {
         for (int int_5 = int_1; int_5 < int_1 + int_3; int_5++) {
            int int_6 = aclass1_0.aShortArrayArrayArray1[0][int_4][int_5] - 1;
            if (int_6 != -1) {
               FloorUnderlayDefinition floorunderlaydefinition_0 = Class33.method240(int_6);
               class3_0.method80(int_4, int_5, 5, floorunderlaydefinition_0);
            }
         }
      }

   }

   void method126(Class9[] class9s_0, Class3 class3_0) {
      Enum7[] enum7s_0 = Tile.method681();
      Enum7[] enum7s_1 = enum7s_0;

      for (int int_0 = 0; int_0 < enum7s_1.length; int_0++) {
         Enum7 enum7_0 = enum7s_1[int_0];
         if (class9s_0[enum7_0.rsOrdinal()] != null) {
            byte byte_0 = 0;
            byte byte_1 = 0;
            byte byte_2 = 64;
            byte byte_3 = 64;
            byte byte_4 = 0;
            byte byte_5 = 0;
            switch(enum7_0.anInt388) {
            case 0:
               byte_1 = 59;
               byte_3 = 5;
               break;
            case 1:
               byte_4 = 59;
               byte_5 = 59;
               byte_2 = 5;
               byte_3 = 5;
               break;
            case 2:
               byte_1 = 59;
               byte_3 = 5;
               byte_0 = 59;
               byte_2 = 5;
               break;
            case 3:
               byte_5 = 59;
               byte_3 = 5;
               byte_0 = 59;
               byte_2 = 5;
               break;
            case 4:
               byte_5 = 59;
               byte_3 = 5;
               break;
            case 5:
               byte_0 = 59;
               byte_2 = 5;
               break;
            case 6:
               byte_4 = 59;
               byte_2 = 5;
               break;
            case 7:
               byte_1 = 59;
               byte_3 = 5;
               byte_4 = 59;
               byte_2 = 5;
            }

            this.method140(byte_4, byte_5, byte_0, byte_1, byte_2, byte_3, class9s_0[enum7_0.rsOrdinal()], class3_0);
         }
      }

   }

   void method127(Class3 class3_0) {
      this.anIntArrayArray5 = new int[64][64];

      for (int int_0 = 0; int_0 < 64; int_0++) {
         for (int int_1 = 0; int_1 < 64; int_1++) {
            this.anIntArrayArray5[int_0][int_1] = class3_0.method79(int_0, int_1) | 0xFF000000;
         }
      }

   }

   void method128(Class5 class5_0, IndexedSprite[] indexedsprites_0) {
      Iterator iterator_0 = this.aLinkedList1.iterator();

      AClass1_Sub1 aclass1_sub1_0;
      int int_0;
      int int_1;
      while (iterator_0.hasNext()) {
         aclass1_sub1_0 = (AClass1_Sub1) iterator_0.next();

         for (int_0 = aclass1_sub1_0.method617() * 8; int_0 < aclass1_sub1_0.method617() * 8 + 8; int_0++) {
            for (int_1 = aclass1_sub1_0.method619() * 8; int_1 < aclass1_sub1_0.method619() * 8 + 8; int_1++) {
               this.method113(int_0, int_1, aclass1_sub1_0, class5_0);
               this.method123(int_0, int_1, aclass1_sub1_0, class5_0);
            }
         }
      }

      iterator_0 = this.aLinkedList1.iterator();

      while (iterator_0.hasNext()) {
         aclass1_sub1_0 = (AClass1_Sub1) iterator_0.next();

         for (int_0 = aclass1_sub1_0.method617() * 8; int_0 < aclass1_sub1_0.method617() * 8 + 8; int_0++) {
            for (int_1 = aclass1_sub1_0.method619() * 8; int_1 < aclass1_sub1_0.method619() * 8 + 8; int_1++) {
               this.method116(int_0, int_1, aclass1_sub1_0, class5_0, indexedsprites_0);
            }
         }
      }

   }

   void method129(Class5 class5_0, Class9[] class9s_0, IndexedSprite[] indexedsprites_0) {
      int int_0;
      int int_1;
      for (int_0 = 0; int_0 < 64; int_0++) {
         for (int_1 = 0; int_1 < 64; int_1++) {
            this.method113(int_0, int_1, this.anAClass1_Sub2_1, class5_0);
            this.method123(int_0, int_1, this.anAClass1_Sub2_1, class5_0);
         }
      }

      for (int_0 = 0; int_0 < 64; int_0++) {
         for (int_1 = 0; int_1 < 64; int_1++) {
            this.method116(int_0, int_1, this.anAClass1_Sub2_1, class5_0, indexedsprites_0);
         }
      }

   }

   int method130(int int_0, int int_1, AClass1 aclass1_0) {
      return aclass1_0.aShortArrayArrayArray1[0][int_0][int_1] == 0 ? this.anInt47 : this.anIntArrayArray5[int_0][int_1];
   }

   Area method131(int int_0) {
      ObjectDefinition objectcomposition_0 = ObjectDefinition.getDefinition(int_0);
      if (objectcomposition_0.transformationIds != null) {
         objectcomposition_0 = objectcomposition_0.morph();
         if (objectcomposition_0 == null) {
            return null;
         }
      }

      return objectcomposition_0.mapIconId != -1 ? Area.anAreaArray1[objectcomposition_0.mapIconId] : null;
   }

   void method132(Area area_0, int int_0, int int_1, int int_2, int int_3) {
      SpritePixels spritepixels_0 = area_0.method809(false);
      if (spritepixels_0 != null) {
         spritepixels_0.drawAt(int_0 - spritepixels_0.width / 2, int_1 - spritepixels_0.height / 2);
         if (int_2 % int_3 < int_3 / 2) {
            Rasterizer2D.method921(int_0, int_1, 15, 16776960, 128);
            Rasterizer2D.method921(int_0, int_1, 7, 16777215, 256);
         }

      }
   }

   List method133() {
      LinkedList linkedlist_0 = new LinkedList();
      linkedlist_0.addAll(this.aList2);
      linkedlist_0.addAll(this.aHashMap3.values());
      return linkedlist_0;
   }

   Class13 method134(int int_0) {
      Area area_0 = Area.anAreaArray1[int_0];
      return this.method110(area_0);
   }

   void method135(Class15 class15_0, int int_0, int int_1, float float_0) {
      Area area_0 = Area.anAreaArray1[class15_0.anInt64];
      this.method111(area_0, int_0, int_1);
      this.method121(class15_0, area_0, int_0, int_1, float_0);
   }

   void method136() {
      if (this.anAClass1_Sub2_1 != null) {
         for (int int_0 = 0; int_0 < 64; int_0++) {
            for (int int_1 = 0; int_1 < 64; int_1++) {
               this.method120(int_0, int_1, this.anAClass1_Sub2_1);
            }
         }
      } else {
         Iterator iterator_0 = this.aLinkedList1.iterator();

         while (iterator_0.hasNext()) {
            AClass1_Sub1 aclass1_sub1_0 = (AClass1_Sub1) iterator_0.next();

            for (int int_2 = aclass1_sub1_0.method617() * 8; int_2 < aclass1_sub1_0.method617() * 8 + 8; int_2++) {
               for (int int_3 = aclass1_sub1_0.method619() * 8; int_3 < aclass1_sub1_0.method619() * 8 + 8; int_3++) {
                  this.method120(int_2, int_3, aclass1_sub1_0);
               }
            }
         }
      }

   }

   void method137(HashSet hashset_0, int int_0, int int_1) {
      Iterator iterator_0 = this.aHashMap3.values().iterator();

      while (iterator_0.hasNext()) {
         Class15 class15_0 = (Class15) iterator_0.next();
         if (hashset_0.contains(Integer.valueOf(class15_0.anInt64))) {
            Area area_0 = Area.anAreaArray1[class15_0.anInt64];
            this.method132(area_0, class15_0.anInt65, class15_0.anInt67, int_0, int_1);
         }
      }

      this.method117(hashset_0, int_0, int_1);
   }

   void method138(int int_0, int int_1, int int_2, int int_3) {
      int_2 %= 4;
      if (int_2 == 0) {
         Rasterizer2D.drawVerticalLine(this.anInt45 * int_0, this.anInt45 * (63 - int_1), this.anInt45, int_3);
      }

      if (int_2 == 1) {
         Rasterizer2D.drawHorizontal(this.anInt45 * int_0, this.anInt45 * (63 - int_1), this.anInt45, int_3);
      }

      if (int_2 == 2) {
         Rasterizer2D.drawVerticalLine(this.anInt45 + this.anInt45 * int_0 - 1, this.anInt45 * (63 - int_1), this.anInt45, int_3);
      }

      if (int_2 == 3) {
         Rasterizer2D.drawHorizontal(this.anInt45 * int_0, this.anInt45 * (63 - int_1) + this.anInt45 - 1, this.anInt45, int_3);
      }

   }

   void method139(int int_0, int int_1, int int_2, HashSet hashset_0) {
      if (hashset_0 == null) {
         hashset_0 = new HashSet();
      }

      this.method108(int_0, int_1, hashset_0, int_2);
      this.method112(int_0, int_1, hashset_0, int_2);
   }

   void method140(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, Class9 class9_1, Class3 class3_0) {
      for (int int_6 = 0; int_6 < int_4; int_6++) {
         for (int int_7 = 0; int_7 < int_5; int_7++) {
            int int_8 = class9_1.method115(int_6 + int_0, int_7 + int_1);
            if (int_8 != -1) {
               FloorUnderlayDefinition floorunderlaydefinition_0 = Class33.method240(int_8);
               class3_0.method80(int_2 + int_6, int_7 + int_3, 5, floorunderlaydefinition_0);
            }
         }
      }

   }

   List method141(int int_0, int int_1, int int_2, int int_3, int int_4) {
      LinkedList linkedlist_0 = new LinkedList();
      if (int_3 >= int_0 && int_4 >= int_1) {
         if (int_3 < int_2 + int_0 && int_4 < int_2 + int_1) {
            Iterator iterator_0 = this.aHashMap3.values().iterator();

            Class15 class15_0;
            while (iterator_0.hasNext()) {
               class15_0 = (Class15) iterator_0.next();
               if (class15_0.method194(int_3, int_4)) {
                  linkedlist_0.add(class15_0);
               }
            }

            iterator_0 = this.aList2.iterator();

            while (iterator_0.hasNext()) {
               class15_0 = (Class15) iterator_0.next();
               if (class15_0.method194(int_3, int_4)) {
                  linkedlist_0.add(class15_0);
               }
            }

            return linkedlist_0;
         } else {
            return linkedlist_0;
         }
      } else {
         return linkedlist_0;
      }
   }

   boolean method142(int int_0, Class5 class5_0, Class9[] class9s_0, IndexedSprite[] indexedsprites_0) {
      if (!this.method106(int_0)) {
         return false;
      } else if (this.anAClass1_Sub2_1 == null && this.aLinkedList1.isEmpty()) {
         return false;
      } else {
         this.method122(class9s_0);
         this.aSpritePixels1.method984();
         if (this.anAClass1_Sub2_1 != null) {
            this.method129(class5_0, class9s_0, indexedsprites_0);
         } else {
            this.method128(class5_0, indexedsprites_0);
         }

         return true;
      }
   }

   void method143(int int_0, int int_1, int int_2) {
      if (this.aSpritePixels1 != null) {
         if (int_2 == this.anInt45 * 64) {
            this.aSpritePixels1.drawImage(int_0, int_1);
         } else {
            this.aSpritePixels1.method982(int_0, int_1, int_2, int_2);
         }

      }
   }

   void method144(AClass1_Sub2 aclass1_sub2_0, List list_0) {
      this.aHashMap3.clear();
      this.anAClass1_Sub2_1 = aclass1_sub2_0;
      this.method118(0, 0, 64, 64, this.anAClass1_Sub2_1);
      this.method119(list_0);
   }

   void method145(HashSet hashset_0, List list_0) {
      this.aHashMap3.clear();
      Iterator iterator_0 = hashset_0.iterator();

      while (iterator_0.hasNext()) {
         AClass1_Sub1 aclass1_sub1_0 = (AClass1_Sub1) iterator_0.next();
         if (aclass1_sub1_0.method160() == this.anInt44 && aclass1_sub1_0.method161() == this.anInt46) {
            this.aLinkedList1.add(aclass1_sub1_0);
            this.method118(aclass1_sub1_0.method617() * 8, aclass1_sub1_0.method619() * 8, 8, 8, aclass1_sub1_0);
         }
      }

      this.method119(list_0);
   }

   static IndexedSprite loadSpriteData() {
      IndexedSprite sprite = new IndexedSprite();
      sprite.width = Class111.loadedMaxWidth;
      sprite.originalHeight = Class111.loadedMaxHeight;
      sprite.offsetX = Class111.loadedHorizontalOffsets[0];
      sprite.offsetY = Class7.loadedVerticalOffsets[0];
      sprite.originalWidth = ItemContainer.loadedWidths[0];
      sprite.height = Class6.loadedHeights[0];
      sprite.palette = Class111.loadedPixels;
      sprite.pixels = Class111.spritePixels[0];
      Class98.cleanPixelLoader();
      return sprite;
   }

   static void method147() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
   }

   public static CacheableNode_Sub2 method148(int int_0) {
      CacheableNode_Sub2 cacheablenode_sub2_0 = (CacheableNode_Sub2) CacheableNode_Sub2.aNodeCache11.get((long)int_0);
      if (cacheablenode_sub2_0 != null) {
         return cacheablenode_sub2_0;
      } else {
         byte[] bytes_0 = Class86.anIndexDataBase6.getConfigData(19, int_0);
         cacheablenode_sub2_0 = new CacheableNode_Sub2();
         if (bytes_0 != null) {
            cacheablenode_sub2_0.method870(new Buffer(bytes_0));
         }

         CacheableNode_Sub2.aNodeCache11.put(cacheablenode_sub2_0, (long)int_0);
         return cacheablenode_sub2_0;
      }
   }

   static boolean method149(String string_0, int int_0) {
      return World.method558(string_0, int_0, "openjs");
   }

   static void animate(Player player, int animation, int disabledAnimation) {
      if (player.animation == animation && animation != -1) {
         int int_2 = ItemLayer.getAnimation(animation).replyMode;
         if (int_2 == 1) {
            player.actionFrame = 0;
            player.anInt528 = 0;
            player.actionAnimationDisable = disabledAnimation;
            player.anInt529 = 0;
         }

         if (int_2 == 2) {
            player.anInt529 = 0;
         }
      } else if (animation == -1 || player.animation == -1 || ItemLayer.getAnimation(animation).forcedPriority >= ItemLayer.getAnimation(player.animation).forcedPriority) {
         player.animation = animation;
         player.actionFrame = 0;
         player.anInt528 = 0;
         player.actionAnimationDisable = disabledAnimation;
         player.anInt529 = 0;
         player.anInt511 = player.queueSize;
      }

   }

   static void method151(String string_0, boolean bool_0) {
      if (string_0 != null) {
         if ((Client.ignoreCount < 100 || Client.anInt678 == 1) && Client.ignoreCount < 400) {
            String string_1 = PacketBuffer.method908(string_0, Class24.aClass109_1);
            if (string_1 != null) {
               int int_0;
               String string_2;
               String string_3;
               for (int_0 = 0; int_0 < Client.ignoreCount; int_0++) {
                  Ignore ignore_0 = Client.ignores[int_0];
                  string_2 = PacketBuffer.method908(ignore_0.name, Class24.aClass109_1);
                  if (string_2 != null && string_2.equals(string_1)) {
                     Class34.sendGameMessage(31, "", string_0 + " is already on your ignore list");
                     return;
                  }

                  if (ignore_0.previousName != null) {
                     string_3 = PacketBuffer.method908(ignore_0.previousName, Class24.aClass109_1);
                     if (string_3 != null && string_3.equals(string_1)) {
                        Class34.sendGameMessage(31, "", string_0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for (int_0 = 0; int_0 < Client.friendCount; int_0++) {
                  Friend friend_0 = Client.friends[int_0];
                  string_2 = PacketBuffer.method908(friend_0.name, Class24.aClass109_1);
                  if (string_2 != null && string_2.equals(string_1)) {
                     Class34.sendGameMessage(31, "", "Please remove " + string_0 + " from your friend list first");
                     return;
                  }

                  if (friend_0.previousName != null) {
                     string_3 = PacketBuffer.method908(friend_0.previousName, Class24.aClass109_1);
                     if (string_3 != null && string_3.equals(string_1)) {
                        Class34.sendGameMessage(31, "", "Please remove " + string_0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if (PacketBuffer.method908(Class4.localPlayer.name, Class24.aClass109_1).equals(string_1)) {
                  Class34.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  PacketNode packetnode_0 = Actor.method953(ClientPacket.aClientPacket93, Client.aClass46_1.cipher);
                  packetnode_0.packetBuffer.putByte(Projectile.getLength(string_0));
                  packetnode_0.packetBuffer.putString(string_0);
                  Client.aClass46_1.method282(packetnode_0);
               }
            }
         } else {
            Class34.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }

   static synchronized void method152(byte[] bytes_0) {
      if (bytes_0.length == 100 && Class62.anInt164 < 1000) {
         Class62.aByteArrayArray4[++Class62.anInt164 - 1] = bytes_0;
      } else if (bytes_0.length == 5000 && Class62.anInt165 < 250) {
         Class62.aByteArrayArray5[++Class62.anInt165 - 1] = bytes_0;
      } else if (bytes_0.length == 30000 && Class62.anInt166 < 50) {
         Class62.aByteArrayArray6[++Class62.anInt166 - 1] = bytes_0;
      } else {
         if (AbstractByteBuffer.aByteArrayArrayArray8 != null) {
            for (int int_0 = 0; int_0 < BuildType.anIntArray53.length; int_0++) {
               if (bytes_0.length == BuildType.anIntArray53[int_0] && FaceNormal.anIntArray59[int_0] < AbstractByteBuffer.aByteArrayArrayArray8[int_0].length) {
                  AbstractByteBuffer.aByteArrayArrayArray8[int_0][FaceNormal.anIntArray59[int_0]++] = bytes_0;
                  return;
               }
            }
         }

      }
   }

}
