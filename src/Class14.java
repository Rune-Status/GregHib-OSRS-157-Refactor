import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class Class14 {

   static Enum6 anEnum6_1;
   boolean aBool5;
   SpritePixels aSpritePixels2;
   boolean aBool6;
   HashMap aHashMap5;
   Class9[][] aClass9ArrayArray1;
   int anInt60;
   int anInt61;
   HashMap aHashMap6;
   IndexedSprite[] anIndexedSpriteArray3;
   final HashMap aHashMap7;
   WorldMapData_Sub1 aWorldMapData_Sub1_1;
   int anInt62;
   int anInt63;

   public Class14(IndexedSprite[] indexedsprites_0, HashMap hashmap_0) {
      this.aBool6 = false;
      this.aBool5 = false;
      this.aHashMap6 = new HashMap();
      this.anIndexedSpriteArray3 = indexedsprites_0;
      this.aHashMap7 = hashmap_0;
   }

   void method175() {
      if (this.aHashMap5 == null) {
         this.aHashMap5 = new HashMap();
      }

      this.aHashMap5.clear();

      for (int int_0 = 0; int_0 < this.aClass9ArrayArray1.length; int_0++) {
         for (int int_1 = 0; int_1 < this.aClass9ArrayArray1[int_0].length; int_1++) {
            List list_0 = this.aClass9ArrayArray1[int_0][int_1].method133();
            Iterator iterator_0 = list_0.iterator();

            while (iterator_0.hasNext()) {
               Class15 class15_0 = (Class15) iterator_0.next();
               if (!this.aHashMap5.containsKey(Integer.valueOf(class15_0.anInt64))) {
                  LinkedList linkedlist_0 = new LinkedList();
                  linkedlist_0.add(class15_0);
                  this.aHashMap5.put(Integer.valueOf(class15_0.anInt64), linkedlist_0);
               } else {
                  List list_1 = (List) this.aHashMap5.get(Integer.valueOf(class15_0.anInt64));
                  list_1.add(class15_0);
               }
            }
         }
      }

   }

   Class2 method176(int int_0, int int_1, int int_2, int int_3) {
      Class2 class2_0 = new Class2(this);
      int int_4 = this.anInt60 + int_0;
      int int_5 = int_1 + this.anInt61;
      int int_6 = int_2 + this.anInt60;
      int int_7 = int_3 + this.anInt61;
      int int_8 = int_4 / 64;
      int int_9 = int_5 / 64;
      int int_10 = int_6 / 64;
      int int_11 = int_7 / 64;
      class2_0.anInt19 = int_10 - int_8 + 1;
      class2_0.anInt21 = int_11 - int_9 + 1;
      class2_0.anInt18 = int_8 - this.aWorldMapData_Sub1_1.method289();
      class2_0.anInt20 = int_9 - this.aWorldMapData_Sub1_1.method290();
      if (class2_0.anInt18 < 0) {
         class2_0.anInt19 += class2_0.anInt18;
         class2_0.anInt18 = 0;
      }

      if (class2_0.anInt18 > this.aClass9ArrayArray1.length - class2_0.anInt19) {
         class2_0.anInt19 = this.aClass9ArrayArray1.length - class2_0.anInt18;
      }

      if (class2_0.anInt20 < 0) {
         class2_0.anInt21 += class2_0.anInt20;
         class2_0.anInt20 = 0;
      }

      if (class2_0.anInt20 > this.aClass9ArrayArray1[0].length - class2_0.anInt21) {
         class2_0.anInt21 = this.aClass9ArrayArray1[0].length - class2_0.anInt20;
      }

      class2_0.anInt19 = Math.min(class2_0.anInt19, this.aClass9ArrayArray1.length);
      class2_0.anInt21 = Math.min(class2_0.anInt21, this.aClass9ArrayArray1[0].length);
      return class2_0;
   }

   float method177(int int_0, int int_1) {
      float float_0 = (float)int_0 / (float)int_1;
      if (float_0 > 8.0F) {
         return 8.0F;
      } else if (float_0 < 1.0F) {
         return 1.0F;
      } else {
         int int_2 = Math.round(float_0);
         return Math.abs((float)int_2 - float_0) < 0.05F ? (float)int_2 : float_0;
      }
   }

   public boolean method178() {
      return this.aBool6;
   }

   public HashMap method179() {
      this.method175();
      return this.aHashMap5;
   }

   public void method180(int int_0, int int_1, int int_2, int int_3, HashSet hashset_0, int int_4, int int_5) {
      if (this.aSpritePixels2 != null) {
         this.aSpritePixels2.method981(int_0, int_1, int_2, int_3);
         if (int_4 > 0 && int_4 % int_5 < int_5 / 2) {
            if (this.aHashMap5 == null) {
               this.method175();
            }

            Iterator iterator_0 = hashset_0.iterator();

            while (true) {
               List list_0;
               do {
                  if (!iterator_0.hasNext()) {
                     return;
                  }

                  int int_6 = ((Integer) iterator_0.next()).intValue();
                  list_0 = (List) this.aHashMap5.get(Integer.valueOf(int_6));
               } while (list_0 == null);

               Iterator iterator_1 = list_0.iterator();

               while (iterator_1.hasNext()) {
                  Class15 class15_0 = (Class15) iterator_1.next();
                  int int_7 = int_2 * (class15_0.aCoordinates6.worldX - this.anInt60) / this.anInt62;
                  int int_8 = int_3 - (class15_0.aCoordinates6.worldY - this.anInt61) * int_3 / this.anInt63;
                  Rasterizer2D.method921(int_7 + int_0, int_8 + int_1, 2, 16776960, 256);
               }
            }
         }
      }
   }

   public void method181(IndexDataBase indexdatabase_0, String string_0, boolean bool_0) {
      if (!this.aBool5) {
         this.aBool6 = false;
         this.aBool5 = true;
         System.nanoTime();
         int int_0 = indexdatabase_0.getFile(Class16.aClass16_1.aString2);
         int int_1 = indexdatabase_0.getChild(int_0, string_0);
         Buffer buffer_0 = new Buffer(indexdatabase_0.method436(Class16.aClass16_1.aString2, string_0));
         Buffer buffer_1 = new Buffer(indexdatabase_0.method436(Class16.aClass16_2.aString2, string_0));
         Buffer buffer_2 = new Buffer(indexdatabase_0.method436(string_0, Class16.aClass16_3.aString2));
         System.nanoTime();
         System.nanoTime();
         this.aWorldMapData_Sub1_1 = new WorldMapData_Sub1();

         try {
            this.aWorldMapData_Sub1_1.method601(buffer_0, buffer_2, buffer_1, int_1, bool_0);
         } catch (IllegalStateException illegalstateexception_0) {
            return;
         }

         this.aWorldMapData_Sub1_1.method294();
         this.aWorldMapData_Sub1_1.method293();
         this.aWorldMapData_Sub1_1.method295();
         this.anInt60 = this.aWorldMapData_Sub1_1.method289() * 64;
         this.anInt61 = this.aWorldMapData_Sub1_1.method290() * 64;
         this.anInt62 = (this.aWorldMapData_Sub1_1.method300() - this.aWorldMapData_Sub1_1.method289() + 1) * 64;
         this.anInt63 = (this.aWorldMapData_Sub1_1.method301() - this.aWorldMapData_Sub1_1.method290() + 1) * 64;
         int int_2 = this.aWorldMapData_Sub1_1.method300() - this.aWorldMapData_Sub1_1.method289() + 1;
         int int_3 = this.aWorldMapData_Sub1_1.method301() - this.aWorldMapData_Sub1_1.method290() + 1;
         System.nanoTime();
         System.nanoTime();
         this.aClass9ArrayArray1 = new Class9[int_2][int_3];
         Iterator iterator_0 = this.aWorldMapData_Sub1_1.aHashSet7.iterator();

         while (iterator_0.hasNext()) {
            AClass1_Sub2 aclass1_sub2_0 = (AClass1_Sub2) iterator_0.next();
            int int_4 = aclass1_sub2_0.anInt54;
            int int_5 = aclass1_sub2_0.anInt55;
            int int_6 = int_4 - this.aWorldMapData_Sub1_1.method289();
            int int_7 = int_5 - this.aWorldMapData_Sub1_1.method290();
            this.aClass9ArrayArray1[int_6][int_7] = new Class9(int_4, int_5, this.aWorldMapData_Sub1_1.method302(), this.aHashMap7);
            this.aClass9ArrayArray1[int_6][int_7].method144(aclass1_sub2_0, this.aWorldMapData_Sub1_1.aList4);
         }

         for (int int_8 = 0; int_8 < int_2; int_8++) {
            for (int int_9 = 0; int_9 < int_3; int_9++) {
               if (this.aClass9ArrayArray1[int_8][int_9] == null) {
                  this.aClass9ArrayArray1[int_8][int_9] = new Class9(this.aWorldMapData_Sub1_1.method289() + int_8, this.aWorldMapData_Sub1_1.method290() + int_9, this.aWorldMapData_Sub1_1.method302(), this.aHashMap7);
                  this.aClass9ArrayArray1[int_8][int_9].method145(this.aWorldMapData_Sub1_1.aHashSet8, this.aWorldMapData_Sub1_1.aList4);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if (indexdatabase_0.method433(Class16.aClass16_4.aString2, string_0)) {
            byte[] bytes_0 = indexdatabase_0.method436(Class16.aClass16_4.aString2, string_0);
            this.aSpritePixels2 = Class80.method470(bytes_0);
         }

         System.nanoTime();
         this.aBool6 = true;
      }
   }

   public List method182(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8, int int_9) {
      LinkedList linkedlist_0 = new LinkedList();
      if (!this.aBool6) {
         return linkedlist_0;
      } else {
         Class2 class2_0 = this.method176(int_0, int_1, int_2, int_3);
         float float_0 = this.method177(int_6, int_2 - int_0);
         int int_10 = (int)(64.0F * float_0);
         int int_11 = this.anInt60 + int_0;
         int int_12 = int_1 + this.anInt61;

         for (int int_13 = class2_0.anInt18; int_13 < class2_0.anInt19 + class2_0.anInt18; int_13++) {
            for (int int_14 = class2_0.anInt20; int_14 < class2_0.anInt20 + class2_0.anInt21; int_14++) {
               List list_0 = this.aClass9ArrayArray1[int_13][int_14].method141(int_4 + int_10 * (this.aClass9ArrayArray1[int_13][int_14].anInt44 * 64 - int_11) / 64, int_7 + int_5 - int_10 * (this.aClass9ArrayArray1[int_13][int_14].anInt46 * 64 - int_12 + 64) / 64, int_10, int_8, int_9);
               if (!list_0.isEmpty()) {
                  linkedlist_0.addAll(list_0);
               }
            }
         }

         return linkedlist_0;
      }
   }

   void method183(int int_0, int int_1, Class9[] class9s_0) {
      boolean bool_0 = int_0 <= 0;
      boolean bool_1 = int_0 >= this.aClass9ArrayArray1.length - 1;
      boolean bool_2 = int_1 <= 0;
      boolean bool_3 = int_1 >= this.aClass9ArrayArray1[0].length - 1;
      if (bool_3) {
         class9s_0[Enum7.anEnum7_1.rsOrdinal()] = null;
      } else {
         class9s_0[Enum7.anEnum7_1.rsOrdinal()] = this.aClass9ArrayArray1[int_0][int_1 + 1];
      }

      class9s_0[Enum7.anEnum7_2.rsOrdinal()] = !bool_3 && !bool_1 ? this.aClass9ArrayArray1[int_0 + 1][int_1 + 1] : null;
      class9s_0[Enum7.anEnum7_8.rsOrdinal()] = !bool_3 && !bool_0 ? this.aClass9ArrayArray1[int_0 - 1][int_1 + 1] : null;
      class9s_0[Enum7.anEnum7_3.rsOrdinal()] = bool_1 ? null : this.aClass9ArrayArray1[int_0 + 1][int_1];
      class9s_0[Enum7.anEnum7_7.rsOrdinal()] = bool_0 ? null : this.aClass9ArrayArray1[int_0 - 1][int_1];
      class9s_0[Enum7.anEnum7_5.rsOrdinal()] = bool_2 ? null : this.aClass9ArrayArray1[int_0][int_1 - 1];
      class9s_0[Enum7.anEnum7_4.rsOrdinal()] = !bool_2 && !bool_1 ? this.aClass9ArrayArray1[int_0 + 1][int_1 - 1] : null;
      class9s_0[Enum7.anEnum7_6.rsOrdinal()] = !bool_2 && !bool_0 ? this.aClass9ArrayArray1[int_0 - 1][int_1 - 1] : null;
   }

   public void method184() {
      this.aHashMap5 = null;
   }

   public void method185(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7) {
      int[] ints_0 = Rasterizer2D.graphicsPixels;
      int int_8 = Rasterizer2D.graphicsPixelsWidth;
      int int_9 = Rasterizer2D.graphicsPixelsHeight;
      int[] ints_1 = new int[4];
      Rasterizer2D.copyDrawRegion(ints_1);
      Class2 class2_0 = this.method176(int_0, int_1, int_2, int_3);
      float float_0 = this.method177(int_6 - int_4, int_2 - int_0);
      int int_10 = (int)Math.ceil((double)float_0);
      if (!this.aHashMap6.containsKey(Integer.valueOf(int_10))) {
         Class5 class5_0 = new Class5(int_10);
         class5_0.method94();
         this.aHashMap6.put(Integer.valueOf(int_10), class5_0);
      }

      Class9[] class9s_0 = new Class9[8];

      int int_11;
      int int_12;
      for (int_11 = class2_0.anInt18; int_11 < class2_0.anInt18 + class2_0.anInt19; int_11++) {
         for (int_12 = class2_0.anInt20; int_12 < class2_0.anInt20 + class2_0.anInt21; int_12++) {
            this.method183(int_11, int_12, class9s_0);
            this.aClass9ArrayArray1[int_11][int_12].method142(int_10, (Class5) this.aHashMap6.get(Integer.valueOf(int_10)), class9s_0, this.anIndexedSpriteArray3);
         }
      }

      Rasterizer2D.setRasterBuffer(ints_0, int_8, int_9);
      Rasterizer2D.setDrawRegion(ints_1);
      int_11 = (int)(float_0 * 64.0F);
      int_12 = this.anInt60 + int_0;
      int int_13 = int_1 + this.anInt61;

      for (int int_14 = class2_0.anInt18; int_14 < class2_0.anInt19 + class2_0.anInt18; int_14++) {
         for (int int_15 = class2_0.anInt20; int_15 < class2_0.anInt20 + class2_0.anInt21; int_15++) {
            this.aClass9ArrayArray1[int_14][int_15].method143(int_4 + int_11 * (this.aClass9ArrayArray1[int_14][int_15].anInt44 * 64 - int_12) / 64, int_7 - int_11 * (this.aClass9ArrayArray1[int_14][int_15].anInt46 * 64 - int_13 + 64) / 64, int_11);
         }
      }

   }

   public void method186(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, HashSet hashset_0, HashSet hashset_1, int int_8, int int_9, boolean bool_0) {
      Class2 class2_0 = this.method176(int_0, int_1, int_2, int_3);
      float float_0 = this.method177(int_6 - int_4, int_2 - int_0);
      int int_10 = (int)(64.0F * float_0);
      int int_11 = this.anInt60 + int_0;
      int int_12 = int_1 + this.anInt61;

      int int_13;
      int int_14;
      for (int_13 = class2_0.anInt18; int_13 < class2_0.anInt19 + class2_0.anInt18; int_13++) {
         for (int_14 = class2_0.anInt20; int_14 < class2_0.anInt20 + class2_0.anInt21; int_14++) {
            if (bool_0) {
               this.aClass9ArrayArray1[int_13][int_14].method136();
            }

            this.aClass9ArrayArray1[int_13][int_14].method139(int_4 + int_10 * (this.aClass9ArrayArray1[int_13][int_14].anInt44 * 64 - int_11) / 64, int_7 - int_10 * (this.aClass9ArrayArray1[int_13][int_14].anInt46 * 64 - int_12 + 64) / 64, int_10, hashset_0);
         }
      }

      if (hashset_1 != null && int_8 > 0) {
         for (int_13 = class2_0.anInt18; int_13 < class2_0.anInt19 + class2_0.anInt18; int_13++) {
            for (int_14 = class2_0.anInt20; int_14 < class2_0.anInt20 + class2_0.anInt21; int_14++) {
               this.aClass9ArrayArray1[int_13][int_14].method137(hashset_1, int_8, int_9);
            }
         }
      }

   }

   static void gameDraw(Widget[] widgets_0, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7) {
      Rasterizer2D.setDrawRegion(int_1, int_2, int_3, int_4);
      Graphics3D.method960();

      for (int int_8 = 0; int_8 < widgets_0.length; int_8++) {
         Widget widget_0 = widgets_0[int_8];
         if (widget_0 != null && (widget_0.parentId == int_0 || int_0 == -1412584499 && widget_0 == Client.aWidget9)) {
            int int_9;
            if (int_7 == -1) {
               Client.widgetPositionX[Client.anInt610] = widget_0.relativeX + int_5;
               Client.widgetPositionY[Client.anInt610] = int_6 + widget_0.relativeY;
               Client.widgetBoundsWidth[Client.anInt610] = widget_0.width;
               Client.widgetBoundsHeight[Client.anInt610] = widget_0.height;
               int_9 = ++Client.anInt610 - 1;
            } else {
               int_9 = int_7;
            }

            widget_0.boundsIndex = int_9;
            widget_0.loopCycle = Client.gameCycle;
            if (!widget_0.hasScript || !CacheableNode_Sub5.method887(widget_0)) {
               int int_10;
               if (widget_0.contentType > 0) {
                  int_10 = widget_0.contentType;
                  if (int_10 == 324) {
                     if (Client.anInt654 == -1) {
                        Client.anInt654 = widget_0.spriteId;
                        Client.anInt657 = widget_0.anInt267;
                     }

                     if (Client.aPlayerComposition1.isFemale) {
                        widget_0.spriteId = Client.anInt654;
                     } else {
                        widget_0.spriteId = Client.anInt657;
                     }
                  } else if (int_10 == 325) {
                     if (Client.anInt654 == -1) {
                        Client.anInt654 = widget_0.spriteId;
                        Client.anInt657 = widget_0.anInt267;
                     }

                     if (Client.aPlayerComposition1.isFemale) {
                        widget_0.spriteId = Client.anInt657;
                     } else {
                        widget_0.spriteId = Client.anInt654;
                     }
                  } else if (int_10 == 327) {
                     widget_0.rotationX = 150;
                     widget_0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 0x7FF;
                     widget_0.modelType = 5;
                     widget_0.modelId = 0;
                  } else if (int_10 == 328) {
                     widget_0.rotationX = 150;
                     widget_0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 0x7FF;
                     widget_0.modelType = 5;
                     widget_0.modelId = 1;
                  }
               }

               int_10 = widget_0.relativeX + int_5;
               int int_11 = int_6 + widget_0.relativeY;
               int int_12 = widget_0.opacity;
               int int_13;
               int int_14;
               if (widget_0 == Client.aWidget9) {
                  if (int_0 != -1412584499 && !widget_0.aBool40) {
                     RSCanvas.aWidgetArray1 = widgets_0;
                     Class18.anInt70 = int_5;
                     ItemLayer.anInt210 = int_6;
                     continue;
                  }

                  if (Client.aBool93 && Client.aBool86) {
                     int_13 = MouseInput.anInt260;
                     int_14 = MouseInput.anInt262;
                     int_13 -= Client.anInt619;
                     int_14 -= Client.anInt620;
                     if (int_13 < Client.anInt621) {
                        int_13 = Client.anInt621;
                     }

                     if (int_13 + widget_0.width > Client.anInt621 + Client.aWidget10.width) {
                        int_13 = Client.anInt621 + Client.aWidget10.width - widget_0.width;
                     }

                     if (int_14 < Client.anInt626) {
                        int_14 = Client.anInt626;
                     }

                     if (int_14 + widget_0.height > Client.anInt626 + Client.aWidget10.height) {
                        int_14 = Client.anInt626 + Client.aWidget10.height - widget_0.height;
                     }

                     int_10 = int_13;
                     int_11 = int_14;
                  }

                  if (!widget_0.aBool40) {
                     int_12 = 128;
                  }
               }

               int int_15;
               int int_16;
               int int_17;
               int int_18;
               int int_19;
               int int_20;
               if (widget_0.type == 2) {
                  int_13 = int_1;
                  int_14 = int_2;
                  int_15 = int_3;
                  int_16 = int_4;
               } else if (widget_0.type == 9) {
                  int_19 = int_10;
                  int_17 = int_11;
                  int_18 = int_10 + widget_0.width;
                  int_20 = int_11 + widget_0.height;
                  if (int_18 < int_10) {
                     int_19 = int_18;
                     int_18 = int_10;
                  }

                  if (int_20 < int_11) {
                     int_17 = int_20;
                     int_20 = int_11;
                  }

                  ++int_18;
                  ++int_20;
                  int_13 = int_19 > int_1 ? int_19 : int_1;
                  int_14 = int_17 > int_2 ? int_17 : int_2;
                  int_15 = int_18 < int_3 ? int_18 : int_3;
                  int_16 = int_20 < int_4 ? int_20 : int_4;
               } else {
                  int_19 = int_10 + widget_0.width;
                  int_17 = int_11 + widget_0.height;
                  int_13 = int_10 > int_1 ? int_10 : int_1;
                  int_14 = int_11 > int_2 ? int_11 : int_2;
                  int_15 = int_19 < int_3 ? int_19 : int_3;
                  int_16 = int_17 < int_4 ? int_17 : int_4;
               }

               if (!widget_0.hasScript || int_13 < int_15 && int_14 < int_16) {
                  if (widget_0.contentType != 0) {
                     if (widget_0.contentType == 1336) {
                        if (Client.displayFps) {
                           int_11 += 15;
                           Class4.font_p12full.method1041("Fps:" + GameEngine.FPS, int_10 + widget_0.width, int_11, 16776960, -1);
                           int_11 += 15;
                           Runtime runtime_0 = Runtime.getRuntime();
                           int_17 = (int)((runtime_0.totalMemory() - runtime_0.freeMemory()) / 1024L);
                           int_18 = 16776960;
                           if (int_17 > 32768 && Client.lowMemory) {
                              int_18 = 16711680;
                           }

                           if (int_17 > 65536 && !Client.lowMemory) {
                              int_18 = 16711680;
                           }

                           Class4.font_p12full.method1041("Mem:" + int_17 + "k", int_10 + widget_0.width, int_11, int_18, -1);
                           int_11 += 15;
                        }
                        continue;
                     }

                     if (widget_0.contentType == 1337) {
                        Client.anInt615 = int_10;
                        Client.anInt616 = int_11;
                        Spotanim.method764(int_10, int_11, widget_0.width, widget_0.height);
                        Client.aBoolArray8[widget_0.boundsIndex] = true;
                        Rasterizer2D.setDrawRegion(int_1, int_2, int_3, int_4);
                        continue;
                     }

                     if (widget_0.contentType == 1338) {
                        Class26.method223(widget_0, int_10, int_11, int_9);
                        Rasterizer2D.setDrawRegion(int_1, int_2, int_3, int_4);
                        continue;
                     }

                     if (widget_0.contentType == 1339) {
                        WorldMapData_Sub1.method605(widget_0, int_10, int_11);
                        Rasterizer2D.setDrawRegion(int_1, int_2, int_3, int_4);
                        continue;
                     }

                     if (widget_0.contentType == 1400) {
                        Client.renderOverview.extractWorldmap(int_10, int_11, widget_0.width, widget_0.height, Client.gameCycle);
                     }

                     if (widget_0.contentType == 1401) {
                        Client.renderOverview.extractData(int_10, int_11, widget_0.width, widget_0.height);
                     }
                  }

                  if (widget_0.type == 0) {
                     if (!widget_0.hasScript && CacheableNode_Sub5.method887(widget_0) && widget_0 != ItemContainer.aWidget6) {
                        continue;
                     }

                     if (!widget_0.hasScript) {
                        if (widget_0.scrollY > widget_0.scrollHeight - widget_0.height) {
                           widget_0.scrollY = widget_0.scrollHeight - widget_0.height;
                        }

                        if (widget_0.scrollY < 0) {
                           widget_0.scrollY = 0;
                        }
                     }

                     gameDraw(widgets_0, widget_0.id, int_13, int_14, int_15, int_16, int_10 - widget_0.scrollX, int_11 - widget_0.scrollY, int_9);
                     if (widget_0.children != null) {
                        gameDraw(widget_0.children, widget_0.id, int_13, int_14, int_15, int_16, int_10 - widget_0.scrollX, int_11 - widget_0.scrollY, int_9);
                     }

                     WidgetNode widgetnode_0 = (WidgetNode) Client.componentTable.get((long)widget_0.id);
                     if (widgetnode_0 != null) {
                        Class47.method309(widgetnode_0.id, int_13, int_14, int_15, int_16, int_10, int_11, int_9);
                     }

                     Rasterizer2D.setDrawRegion(int_1, int_2, int_3, int_4);
                     Graphics3D.method960();
                  }

                  if (Client.isResized || Client.aBoolArray10[int_9] || Client.gameDrawingMode > 1) {
                     if (widget_0.type == 0 && !widget_0.hasScript && widget_0.scrollHeight > widget_0.height) {
                        method189(int_10 + widget_0.width, int_11, widget_0.scrollY, widget_0.height, widget_0.scrollHeight);
                     }

                     if (widget_0.type != 1) {
                        int int_21;
                        int int_22;
                        int int_23;
                        int int_24;
                        if (widget_0.type == 2) {
                           int_19 = 0;

                           for (int_17 = 0; int_17 < widget_0.anInt274; int_17++) {
                              for (int_18 = 0; int_18 < widget_0.originalWidth; int_18++) {
                                 int_20 = int_10 + int_18 * (widget_0.paddingX + 32);
                                 int_21 = int_11 + int_17 * (widget_0.paddingY + 32);
                                 if (int_19 < 20) {
                                    int_20 += widget_0.xSprites[int_19];
                                    int_21 += widget_0.anIntArray66[int_19];
                                 }

                                 if (widget_0.itemIds[int_19] <= 0) {
                                    if (widget_0.anIntArray64 != null && int_19 < 20) {
                                       SpritePixels spritepixels_2 = widget_0.method594(int_19);
                                       if (spritepixels_2 != null) {
                                          spritepixels_2.drawAt(int_20, int_21);
                                       } else if (Widget.aBool34) {
                                          WorldMapData.method305(widget_0);
                                       }
                                    }
                                 } else {
                                    boolean bool_1 = false;
                                    boolean bool_2 = false;
                                    int_24 = widget_0.itemIds[int_19] - 1;
                                    if (int_20 + 32 > int_1 && int_20 < int_3 && int_21 + 32 > int_2 && int_21 < int_4 || widget_0 == ClanMember.aWidget7 && int_19 == Client.anInt635) {
                                       SpritePixels spritepixels_0;
                                       if (Client.itemSelectionState == 1 && int_19 == GameEngine.selectedItemIndex && widget_0.id == Class48.anInt111) {
                                          spritepixels_0 = AClass3_Sub2.createSprite(int_24, widget_0.itemQuantities[int_19], 2, 0, 2, false);
                                       } else {
                                          spritepixels_0 = AClass3_Sub2.createSprite(int_24, widget_0.itemQuantities[int_19], 1, 3153952, 2, false);
                                       }

                                       if (spritepixels_0 != null) {
                                          if (widget_0 == ClanMember.aWidget7 && int_19 == Client.anInt635) {
                                             int_22 = MouseInput.anInt260 - Client.anInt628;
                                             int_23 = MouseInput.anInt262 - Client.anInt629;
                                             if (int_22 < 5 && int_22 > -5) {
                                                int_22 = 0;
                                             }

                                             if (int_23 < 5 && int_23 > -5) {
                                                int_23 = 0;
                                             }

                                             if (Client.anInt627 < 5) {
                                                int_22 = 0;
                                                int_23 = 0;
                                             }

                                             spritepixels_0.method995(int_22 + int_20, int_23 + int_21, 128);
                                             if (int_0 != -1) {
                                                Widget widget_1 = widgets_0[int_0 & 0xFFFF];
                                                int int_25;
                                                if (int_21 + int_23 < Rasterizer2D.drawingAreaTop && widget_1.scrollY > 0) {
                                                   int_25 = (Rasterizer2D.drawingAreaTop - int_21 - int_23) * Client.anInt625 / 3;
                                                   if (int_25 > Client.anInt625 * 10) {
                                                      int_25 = Client.anInt625 * 10;
                                                   }

                                                   if (int_25 > widget_1.scrollY) {
                                                      int_25 = widget_1.scrollY;
                                                   }

                                                   widget_1.scrollY -= int_25;
                                                   Client.anInt629 += int_25;
                                                   WorldMapData.method305(widget_1);
                                                }

                                                if (int_21 + int_23 + 32 > Rasterizer2D.drawingAreaRight && widget_1.scrollY < widget_1.scrollHeight - widget_1.height) {
                                                   int_25 = (int_21 + int_23 + 32 - Rasterizer2D.drawingAreaRight) * Client.anInt625 / 3;
                                                   if (int_25 > Client.anInt625 * 10) {
                                                      int_25 = Client.anInt625 * 10;
                                                   }

                                                   if (int_25 > widget_1.scrollHeight - widget_1.height - widget_1.scrollY) {
                                                      int_25 = widget_1.scrollHeight - widget_1.height - widget_1.scrollY;
                                                   }

                                                   widget_1.scrollY += int_25;
                                                   Client.anInt629 -= int_25;
                                                   WorldMapData.method305(widget_1);
                                                }
                                             }
                                          } else if (widget_0 == Class59.aWidget3 && int_19 == Client.anInt653) {
                                             spritepixels_0.method995(int_20, int_21, 128);
                                          } else {
                                             spritepixels_0.drawAt(int_20, int_21);
                                          }
                                       } else {
                                          WorldMapData.method305(widget_0);
                                       }
                                    }
                                 }

                                 ++int_19;
                              }
                           }
                        } else if (widget_0.type == 3) {
                           if (Class60.method391(widget_0)) {
                              int_19 = widget_0.anInt283;
                              if (widget_0 == ItemContainer.aWidget6 && widget_0.anInt287 != 0) {
                                 int_19 = widget_0.anInt287;
                              }
                           } else {
                              int_19 = widget_0.textColor;
                              if (widget_0 == ItemContainer.aWidget6 && widget_0.anInt285 != 0) {
                                 int_19 = widget_0.anInt285;
                              }
                           }

                           if (widget_0.aBool36) {
                              switch(widget_0.anEnum9_1.anInt392) {
                              case 1:
                                 Rasterizer2D.method932(int_10, int_11, widget_0.width, widget_0.height, widget_0.textColor, widget_0.anInt283, 256 - (widget_0.opacity & 0xFF), 256 - (widget_0.anInt288 & 0xFF));
                                 break;
                              case 2:
                                 Rasterizer2D.method929(int_10, int_11, widget_0.width, widget_0.height, widget_0.textColor, widget_0.anInt283, 256 - (widget_0.opacity & 0xFF), 256 - (widget_0.anInt288 & 0xFF));
                                 break;
                              case 3:
                                 Rasterizer2D.method930(int_10, int_11, widget_0.width, widget_0.height, widget_0.textColor, widget_0.anInt283, 256 - (widget_0.opacity & 0xFF), 256 - (widget_0.anInt288 & 0xFF));
                                 break;
                              case 4:
                                 Rasterizer2D.method931(int_10, int_11, widget_0.width, widget_0.height, widget_0.textColor, widget_0.anInt283, 256 - (widget_0.opacity & 0xFF), 256 - (widget_0.anInt288 & 0xFF));
                                 break;
                              default:
                                 if (int_12 == 0) {
                                    Rasterizer2D.method919(int_10, int_11, widget_0.width, widget_0.height, int_19);
                                 } else {
                                    Rasterizer2D.fillRectangle(int_10, int_11, widget_0.width, widget_0.height, int_19, 256 - (int_12 & 0xFF));
                                 }
                              }
                           } else if (int_12 == 0) {
                              Rasterizer2D.drawRectangle(int_10, int_11, widget_0.width, widget_0.height, int_19);
                           } else {
                              Rasterizer2D.method927(int_10, int_11, widget_0.width, widget_0.height, int_19, 256 - (int_12 & 0xFF));
                           }
                        } else {
                           Font font_1;
                           if (widget_0.type == 4) {
                              font_1 = widget_0.method592();
                              if (font_1 == null) {
                                 if (Widget.aBool34) {
                                    WorldMapData.method305(widget_0);
                                 }
                              } else {
                                 String string_3 = widget_0.text;
                                 if (Class60.method391(widget_0)) {
                                    int_17 = widget_0.anInt283;
                                    if (widget_0 == ItemContainer.aWidget6 && widget_0.anInt287 != 0) {
                                       int_17 = widget_0.anInt287;
                                    }

                                    if (widget_0.aString15.length() > 0) {
                                       string_3 = widget_0.aString15;
                                    }
                                 } else {
                                    int_17 = widget_0.textColor;
                                    if (widget_0 == ItemContainer.aWidget6 && widget_0.anInt285 != 0) {
                                       int_17 = widget_0.anInt285;
                                    }
                                 }

                                 if (widget_0.hasScript && widget_0.itemId != -1) {
                                    ItemComposition itemcomposition_1 = CacheableNode_Sub2.getItemDefinition(widget_0.itemId);
                                    string_3 = itemcomposition_1.name;
                                    if (string_3 == null) {
                                       string_3 = "null";
                                    }

                                    if ((itemcomposition_1.isStackable == 1 || widget_0.itemQuantity != 1) && widget_0.itemQuantity != -1) {
                                       string_3 = WallObject.getColTags(16748608) + string_3 + "</col>" + " " + 'x' + Class90.method498(widget_0.itemQuantity);
                                    }
                                 }

                                 if (widget_0 == Client.aWidget12) {
                                    Object object_0 = null;
                                    string_3 = "Please wait...";
                                    int_17 = widget_0.textColor;
                                 }

                                 if (!widget_0.hasScript) {
                                    string_3 = Class52.method337(string_3, widget_0);
                                 }

                                 font_1.method1036(string_3, int_10, int_11, widget_0.width, widget_0.height, int_17, widget_0.textShadowed ? 0 : -1, widget_0.anInt290, widget_0.anInt291, widget_0.anInt292);
                              }
                           } else if (widget_0.type == 5) {
                              SpritePixels spritepixels_1;
                              if (!widget_0.hasScript) {
                                 spritepixels_1 = widget_0.method590(Class60.method391(widget_0));
                                 if (spritepixels_1 != null) {
                                    spritepixels_1.drawAt(int_10, int_11);
                                 } else if (Widget.aBool34) {
                                    WorldMapData.method305(widget_0);
                                 }
                              } else {
                                 if (widget_0.itemId != -1) {
                                    spritepixels_1 = AClass3_Sub2.createSprite(widget_0.itemId, widget_0.itemQuantity, widget_0.borderThickness, widget_0.sprite2, widget_0.anInt296, false);
                                 } else {
                                    spritepixels_1 = widget_0.method590(false);
                                 }

                                 if (spritepixels_1 == null) {
                                    if (Widget.aBool34) {
                                       WorldMapData.method305(widget_0);
                                    }
                                 } else {
                                    int_17 = spritepixels_1.maxWidth;
                                    int_18 = spritepixels_1.maxHeight;
                                    if (!widget_0.aBool39) {
                                       int_20 = widget_0.width * 4096 / int_17;
                                       if (widget_0.textureId != 0) {
                                          spritepixels_1.method993(widget_0.width / 2 + int_10, widget_0.height / 2 + int_11, widget_0.textureId, int_20);
                                       } else if (int_12 != 0) {
                                          spritepixels_1.method992(int_10, int_11, widget_0.width, widget_0.height, 256 - (int_12 & 0xFF));
                                       } else if (int_17 == widget_0.width && int_18 == widget_0.height) {
                                          spritepixels_1.drawAt(int_10, int_11);
                                       } else {
                                          spritepixels_1.method981(int_10, int_11, widget_0.width, widget_0.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(int_10, int_11, int_10 + widget_0.width, int_11 + widget_0.height);
                                       int_20 = (int_17 - 1 + widget_0.width) / int_17;
                                       int_21 = (int_18 - 1 + widget_0.height) / int_18;

                                       for (int_22 = 0; int_22 < int_20; int_22++) {
                                          for (int_23 = 0; int_23 < int_21; int_23++) {
                                             if (widget_0.textureId != 0) {
                                                spritepixels_1.method993(int_17 / 2 + int_10 + int_22 * int_17, int_18 / 2 + int_11 + int_18 * int_23, widget_0.textureId, 4096);
                                             } else if (int_12 != 0) {
                                                spritepixels_1.method995(int_10 + int_17 * int_22, int_11 + int_23 * int_18, 256 - (int_12 & 0xFF));
                                             } else {
                                                spritepixels_1.drawAt(int_10 + int_22 * int_17, int_11 + int_23 * int_18);
                                             }
                                          }
                                       }

                                       Rasterizer2D.setDrawRegion(int_1, int_2, int_3, int_4);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition itemcomposition_0;
                              if (widget_0.type == 6) {
                                 boolean bool_0 = Class60.method391(widget_0);
                                 if (bool_0) {
                                    int_17 = widget_0.anInt278;
                                 } else {
                                    int_17 = widget_0.anInt277;
                                 }

                                 Model model_0 = null;
                                 int_20 = 0;
                                 if (widget_0.itemId != -1) {
                                    itemcomposition_0 = CacheableNode_Sub2.getItemDefinition(widget_0.itemId);
                                    if (itemcomposition_0 != null) {
                                       itemcomposition_0 = itemcomposition_0.method940(widget_0.itemQuantity);
                                       model_0 = itemcomposition_0.getModel(1);
                                       if (model_0 != null) {
                                          model_0.method1007();
                                          int_20 = model_0.modelHeight / 2;
                                       } else {
                                          WorldMapData.method305(widget_0);
                                       }
                                    }
                                 } else if (widget_0.modelType == 5) {
                                    if (widget_0.modelId == 0) {
                                       model_0 = Client.aPlayerComposition1.method505((Sequence) null, -1, (Sequence) null, -1);
                                    } else {
                                       model_0 = Class4.localPlayer.getModel();
                                    }
                                 } else if (int_17 == -1) {
                                    model_0 = widget_0.method593((Sequence) null, -1, bool_0, Class4.localPlayer.composition);
                                    if (model_0 == null && Widget.aBool34) {
                                       WorldMapData.method305(widget_0);
                                    }
                                 } else {
                                    Sequence sequence_0 = ItemLayer.getAnimation(int_17);
                                    model_0 = widget_0.method593(sequence_0, widget_0.anInt281, bool_0, Class4.localPlayer.composition);
                                    if (model_0 == null && Widget.aBool34) {
                                       WorldMapData.method305(widget_0);
                                    }
                                 }

                                 Graphics3D.method970(widget_0.width / 2 + int_10, widget_0.height / 2 + int_11);
                                 int_21 = Graphics3D.SINE[widget_0.rotationX] * widget_0.modelZoom >> 16;
                                 int_22 = Graphics3D.COSINE[widget_0.rotationX] * widget_0.modelZoom >> 16;
                                 if (model_0 != null) {
                                    if (!widget_0.hasScript) {
                                       model_0.method1027(0, widget_0.rotationZ, 0, widget_0.rotationX, 0, int_21, int_22);
                                    } else {
                                       model_0.method1007();
                                       if (widget_0.aBool41) {
                                          model_0.method1028(0, widget_0.rotationZ, widget_0.rotationY, widget_0.rotationX, widget_0.anInt293, int_21 + int_20 + widget_0.anInt294, int_22 + widget_0.anInt294, widget_0.modelZoom);
                                       } else {
                                          model_0.method1027(0, widget_0.rotationZ, widget_0.rotationY, widget_0.rotationX, widget_0.anInt293, int_21 + int_20 + widget_0.anInt294, int_22 + widget_0.anInt294);
                                       }
                                    }
                                 }

                                 Graphics3D.method961();
                              } else {
                                 if (widget_0.type == 7) {
                                    font_1 = widget_0.method592();
                                    if (font_1 == null) {
                                       if (Widget.aBool34) {
                                          WorldMapData.method305(widget_0);
                                       }
                                       continue;
                                    }

                                    int_17 = 0;

                                    for (int_18 = 0; int_18 < widget_0.anInt274; int_18++) {
                                       for (int_20 = 0; int_20 < widget_0.originalWidth; int_20++) {
                                          if (widget_0.itemIds[int_17] > 0) {
                                             itemcomposition_0 = CacheableNode_Sub2.getItemDefinition(widget_0.itemIds[int_17] - 1);
                                             String string_0;
                                             if (itemcomposition_0.isStackable != 1 && widget_0.itemQuantities[int_17] == 1) {
                                                string_0 = WallObject.getColTags(16748608) + itemcomposition_0.name + "</col>";
                                             } else {
                                                string_0 = WallObject.getColTags(16748608) + itemcomposition_0.name + "</col>" + " " + 'x' + Class90.method498(widget_0.itemQuantities[int_17]);
                                             }

                                             int_23 = int_20 * (widget_0.paddingX + 115) + int_10;
                                             int_24 = int_11 + (widget_0.paddingY + 12) * int_18;
                                             if (widget_0.anInt290 == 0) {
                                                font_1.method1040(string_0, int_23, int_24, widget_0.textColor, widget_0.textShadowed ? 0 : -1);
                                             } else if (widget_0.anInt290 == 1) {
                                                font_1.method1039(string_0, widget_0.width / 2 + int_23, int_24, widget_0.textColor, widget_0.textShadowed ? 0 : -1);
                                             } else {
                                                font_1.method1041(string_0, int_23 + widget_0.width - 1, int_24, widget_0.textColor, widget_0.textShadowed ? 0 : -1);
                                             }
                                          }

                                          ++int_17;
                                       }
                                    }
                                 }

                                 if (widget_0.type == 8 && widget_0 == Class47.aWidget1 && Client.anInt668 == Client.anInt670) {
                                    int_19 = 0;
                                    int_17 = 0;
                                    Font font_0 = Class4.font_p12full;
                                    String string_1 = widget_0.text;

                                    String string_2;
                                    for (string_1 = Class52.method337(string_1, widget_0); string_1.length() > 0; int_17 = int_17 + font_0.verticalSpace + 1) {
                                       int_22 = string_1.indexOf("<br>");
                                       if (int_22 != -1) {
                                          string_2 = string_1.substring(0, int_22);
                                          string_1 = string_1.substring(int_22 + 4);
                                       } else {
                                          string_2 = string_1;
                                          string_1 = "";
                                       }

                                       int_23 = font_0.method1030(string_2);
                                       if (int_23 > int_19) {
                                          int_19 = int_23;
                                       }
                                    }

                                    int_19 += 6;
                                    int_17 += 7;
                                    int_22 = int_10 + widget_0.width - 5 - int_19;
                                    int_23 = int_11 + widget_0.height + 5;
                                    if (int_22 < int_10 + 5) {
                                       int_22 = int_10 + 5;
                                    }

                                    if (int_19 + int_22 > int_3) {
                                       int_22 = int_3 - int_19;
                                    }

                                    if (int_23 + int_17 > int_4) {
                                       int_23 = int_4 - int_17;
                                    }

                                    Rasterizer2D.method919(int_22, int_23, int_19, int_17, 16777120);
                                    Rasterizer2D.drawRectangle(int_22, int_23, int_19, int_17, 0);
                                    string_1 = widget_0.text;
                                    int_24 = int_23 + font_0.verticalSpace + 2;

                                    for (string_1 = Class52.method337(string_1, widget_0); string_1.length() > 0; int_24 = int_24 + font_0.verticalSpace + 1) {
                                       int int_26 = string_1.indexOf("<br>");
                                       if (int_26 != -1) {
                                          string_2 = string_1.substring(0, int_26);
                                          string_1 = string_1.substring(int_26 + 4);
                                       } else {
                                          string_2 = string_1;
                                          string_1 = "";
                                       }

                                       font_0.method1040(string_2, int_22 + 3, int_24, 0, -1);
                                    }
                                 }

                                 if (widget_0.type == 9) {
                                    if (widget_0.aBool37) {
                                       int_19 = int_10;
                                       int_17 = int_11 + widget_0.height;
                                       int_18 = int_10 + widget_0.width;
                                       int_20 = int_11;
                                    } else {
                                       int_19 = int_10;
                                       int_17 = int_11;
                                       int_18 = int_10 + widget_0.width;
                                       int_20 = int_11 + widget_0.height;
                                    }

                                    if (widget_0.anInt289 == 1) {
                                       Rasterizer2D.drawLine(int_19, int_17, int_18, int_20, widget_0.textColor);
                                    } else {
                                       Class50.method318(int_19, int_17, int_18, int_20, widget_0.textColor, widget_0.anInt289);
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public static void method187(Model model_0, int int_0, int int_1, int int_2) {
      if (Class4.method82(model_0, int_0, int_1, int_2)) {
         Class42.method264(model_0, int_0, int_1, int_2, -65281);
      } else if (Class37.aClass26_3 == Class26.aClass26_2) {
         Class42.method264(model_0, int_0, int_1, int_2, -16776961);
      }

   }

   static void method188(boolean bool_0, PacketBuffer packetbuffer_0) {
      Client.anInt666 = 0;
      Client.pendingNpcFlagsCount = 0;
      PendingSpawn.method673();

      int int_0;
      NPC npc_0;
      int int_1;
      int int_2;
      int int_3;
      int int_4;
      int int_7;
      while (packetbuffer_0.bitsAvail(Client.aClass46_1.packetLength) >= 27) {
         int_0 = packetbuffer_0.getBits(15);
         if (int_0 == 32767) {
            break;
         }

         boolean bool_1 = false;
         if (Client.cachedNPCs[int_0] == null) {
            Client.cachedNPCs[int_0] = new NPC();
            bool_1 = true;
         }

         npc_0 = Client.cachedNPCs[int_0];
         Client.npcIndices[++Client.npcIndexesCount - 1] = int_0;
         npc_0.anInt531 = Client.gameCycle;
         int_1 = Client.anIntArray158[packetbuffer_0.getBits(3)];
         if (bool_1) {
            npc_0.orientation = npc_0.angle = int_1;
         }

         int_2 = packetbuffer_0.getBits(1);
         if (int_2 == 1) {
            Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = int_0;
         }

         if (bool_0) {
            int_3 = packetbuffer_0.getBits(8);
            if (int_3 > 127) {
               int_3 -= 256;
            }
         } else {
            int_3 = packetbuffer_0.getBits(5);
            if (int_3 > 15) {
               int_3 -= 32;
            }
         }

         npc_0.composition = Class27.getNpcDefinition(packetbuffer_0.getBits(14));
         if (bool_0) {
            int_7 = packetbuffer_0.getBits(8);
            if (int_7 > 127) {
               int_7 -= 256;
            }
         } else {
            int_7 = packetbuffer_0.getBits(5);
            if (int_7 > 15) {
               int_7 -= 32;
            }
         }

         int_4 = packetbuffer_0.getBits(1);
         npc_0.anInt513 = npc_0.composition.anInt489;
         npc_0.anInt533 = npc_0.composition.anInt502;
         if (npc_0.anInt533 == 0) {
            npc_0.angle = 0;
         }

         npc_0.walkingAnimation = npc_0.composition.anInt491;
         npc_0.halfTurnAnimation = npc_0.composition.anInt496;
         npc_0.quarterClockwiseTurnAnimation = npc_0.composition.anInt497;
         npc_0.quarterAnticlockwiseTurnAnimation = npc_0.composition.anInt498;
         npc_0.idlePoseAnimation = npc_0.composition.anInt490;
         npc_0.turnAnimation = npc_0.composition.anInt492;
         npc_0.anInt515 = npc_0.composition.anInt493;
         npc_0.method1067(Class4.localPlayer.pathX[0] + int_3, Class4.localPlayer.pathY[0] + int_7, int_4 == 1);
      }

      packetbuffer_0.byteAccess();

      int int_10;
      for (int_0 = 0; int_0 < Client.pendingNpcFlagsCount; int_0++) {
         int_10 = Client.pendingNpcFlagsIndices[int_0];
         npc_0 = Client.cachedNPCs[int_10];
         int_1 = packetbuffer_0.readUnsignedByte();
         if ((int_1 & 0x8) != 0) {
            npc_0.overhead = packetbuffer_0.readString();
            npc_0.anInt523 = 100;
         }

         if ((int_1 & 0x2) != 0) {
            npc_0.graphic = packetbuffer_0.method712();
            int_2 = packetbuffer_0.method714();
            npc_0.graphicHeight = int_2 >> 16;
            npc_0.graphicDelay = (int_2 & 0xFFFF) + Client.gameCycle;
            npc_0.currentAnimation = 0;
            npc_0.anInt530 = 0;
            if (npc_0.graphicDelay > Client.gameCycle) {
               npc_0.currentAnimation = -1;
            }

            if (npc_0.graphic == 65535) {
               npc_0.graphic = -1;
            }
         }

         if ((int_1 & 0x4) != 0) {
            int_2 = packetbuffer_0.readNegUByte();
            int int_5;
            int int_6;
            int int_8;
            if (int_2 > 0) {
               for (int_3 = 0; int_3 < int_2; int_3++) {
                  int_4 = -1;
                  int_5 = -1;
                  int_6 = -1;
                  int_7 = packetbuffer_0.getUSmart();
                  if (int_7 == 32767) {
                     int_7 = packetbuffer_0.getUSmart();
                     int_5 = packetbuffer_0.getUSmart();
                     int_4 = packetbuffer_0.getUSmart();
                     int_6 = packetbuffer_0.getUSmart();
                  } else if (int_7 != 32766) {
                     int_5 = packetbuffer_0.getUSmart();
                  } else {
                     int_7 = -1;
                  }

                  int_8 = packetbuffer_0.getUSmart();
                  npc_0.method949(int_7, int_5, int_4, int_6, Client.gameCycle, int_8);
               }
            }

            int_3 = packetbuffer_0.method709();
            if (int_3 > 0) {
               for (int_7 = 0; int_7 < int_3; int_7++) {
                  int_4 = packetbuffer_0.getUSmart();
                  int_5 = packetbuffer_0.getUSmart();
                  if (int_5 != 32767) {
                     int_6 = packetbuffer_0.getUSmart();
                     int_8 = packetbuffer_0.method710();
                     int int_9 = int_5 > 0 ? packetbuffer_0.method710() : int_8;
                     npc_0.method952(int_4, Client.gameCycle, int_5, int_6, int_8, int_9);
                  } else {
                     npc_0.method951(int_4);
                  }
               }
            }
         }

         if ((int_1 & 0x10) != 0) {
            int_2 = packetbuffer_0.readUnsignedShortOb1();
            if (int_2 == 65535) {
               int_2 = -1;
            }

            int_3 = packetbuffer_0.method710();
            if (int_2 == npc_0.animation && int_2 != -1) {
               int_7 = ItemLayer.getAnimation(int_2).replyMode;
               if (int_7 == 1) {
                  npc_0.actionFrame = 0;
                  npc_0.anInt528 = 0;
                  npc_0.actionAnimationDisable = int_3;
                  npc_0.anInt529 = 0;
               }

               if (int_7 == 2) {
                  npc_0.anInt529 = 0;
               }
            } else if (int_2 == -1 || npc_0.animation == -1 || ItemLayer.getAnimation(int_2).forcedPriority >= ItemLayer.getAnimation(npc_0.animation).forcedPriority) {
               npc_0.animation = int_2;
               npc_0.actionFrame = 0;
               npc_0.anInt528 = 0;
               npc_0.actionAnimationDisable = int_3;
               npc_0.anInt529 = 0;
               npc_0.anInt511 = npc_0.queueSize;
            }
         }

         if ((int_1 & 0x40) != 0) {
            int_2 = packetbuffer_0.readUnsignedShort();
            int_3 = packetbuffer_0.readUnsignedShortOb1();
            int_7 = npc_0.x - (int_2 - ItemLayer.baseX - ItemLayer.baseX) * 64;
            int_4 = npc_0.y - (int_3 - ItemLayer.baseY - ItemLayer.baseY) * 64;
            if (int_7 != 0 || int_4 != 0) {
               npc_0.anInt510 = (int)(Math.atan2((double)int_7, (double)int_4) * 325.949D) & 0x7FF;
            }
         }

         if ((int_1 & 0x1) != 0) {
            npc_0.composition = Class27.getNpcDefinition(packetbuffer_0.method712());
            npc_0.anInt513 = npc_0.composition.anInt489;
            npc_0.anInt533 = npc_0.composition.anInt502;
            npc_0.walkingAnimation = npc_0.composition.anInt491;
            npc_0.halfTurnAnimation = npc_0.composition.anInt496;
            npc_0.quarterClockwiseTurnAnimation = npc_0.composition.anInt497;
            npc_0.quarterAnticlockwiseTurnAnimation = npc_0.composition.anInt498;
            npc_0.idlePoseAnimation = npc_0.composition.anInt490;
            npc_0.turnAnimation = npc_0.composition.anInt492;
            npc_0.anInt515 = npc_0.composition.anInt493;
         }

         if ((int_1 & 0x20) != 0) {
            npc_0.interacting = packetbuffer_0.readUnsignedShort();
            if (npc_0.interacting == 65535) {
               npc_0.interacting = -1;
            }
         }
      }

      for (int_0 = 0; int_0 < Client.anInt666; int_0++) {
         int_10 = Client.anIntArray157[int_0];
         if (Client.cachedNPCs[int_10].anInt531 != Client.gameCycle) {
            Client.cachedNPCs[int_10].composition = null;
            Client.cachedNPCs[int_10] = null;
         }
      }

      if (packetbuffer_0.offset != Client.aClass46_1.packetLength) {
         throw new RuntimeException(packetbuffer_0.offset + "," + Client.aClass46_1.packetLength);
      } else {
         for (int_0 = 0; int_0 < Client.npcIndexesCount; int_0++) {
            if (Client.cachedNPCs[Client.npcIndices[int_0]] == null) {
               throw new RuntimeException(int_0 + "," + Client.npcIndexesCount);
            }
         }

      }
   }

   static void method189(int int_0, int int_1, int int_2, int int_3, int int_4) {
      Class11.anIndexedSpriteArray2[0].method975(int_0, int_1);
      Class11.anIndexedSpriteArray2[1].method975(int_0, int_3 + int_1 - 16);
      Rasterizer2D.method919(int_0, int_1 + 16, 16, int_3 - 32, Client.anInt671);
      int int_5 = int_3 * (int_3 - 32) / int_4;
      if (int_5 < 8) {
         int_5 = 8;
      }

      int int_6 = (int_3 - 32 - int_5) * int_2 / (int_4 - int_3);
      Rasterizer2D.method919(int_0, int_6 + int_1 + 16, 16, int_5, Client.anInt673);
      Rasterizer2D.method918(int_0, int_6 + int_1 + 16, int_5, Client.anInt675);
      Rasterizer2D.method918(int_0 + 1, int_6 + int_1 + 16, int_5, Client.anInt675);
      Rasterizer2D.method920(int_0, int_6 + int_1 + 16, 16, Client.anInt675);
      Rasterizer2D.method920(int_0, int_6 + int_1 + 17, 16, Client.anInt675);
      Rasterizer2D.method918(int_0 + 15, int_6 + int_1 + 16, int_5, Client.anInt674);
      Rasterizer2D.method918(int_0 + 14, int_6 + int_1 + 17, int_5 - 1, Client.anInt674);
      Rasterizer2D.method920(int_0, int_5 + int_6 + int_1 + 15, 16, Client.anInt674);
      Rasterizer2D.method920(int_0 + 1, int_5 + int_6 + int_1 + 14, 15, Client.anInt674);
   }

   static Script method190(int int_0, Class90 class90_0) {
      Script script_0 = (Script) Script.aNodeCache18.get((long)(int_0 << 16));
      if (script_0 != null) {
         return script_0;
      } else {
         String string_0 = String.valueOf(int_0);
         int int_1 = Class3.indexScripts.getFile(string_0);
         if (int_1 == -1) {
            return null;
         } else {
            byte[] bytes_0 = Class3.indexScripts.method432(int_1);
            if (bytes_0 != null) {
               if (bytes_0.length <= 1) {
                  return null;
               }

               script_0 = Class64.method401(bytes_0);
               if (script_0 != null) {
                  Script.aNodeCache18.put(script_0, (long)(int_0 << 16));
                  return script_0;
               }
            }

            return null;
         }
      }
   }

   static void method191(NPCComposition npccomposition_0, int int_0, int int_1, int int_2) {
      if (Client.menuOptionCount < 400) {
         if (npccomposition_0.configs != null) {
            npccomposition_0 = npccomposition_0.transform();
         }

         if (npccomposition_0 != null) {
            if (npccomposition_0.aBool66) {
               if (!npccomposition_0.aBool67 || Client.anInt682 == int_0) {
                  String string_0 = npccomposition_0.name;
                  int int_3;
                  int int_4;
                  if (npccomposition_0.combatLevel != 0) {
                     int_3 = npccomposition_0.combatLevel;
                     int_4 = Class4.localPlayer.combatLevel;
                     int int_5 = int_4 - int_3;
                     String string_1;
                     if (int_5 < -9) {
                        string_1 = WallObject.getColTags(16711680);
                     } else if (int_5 < -6) {
                        string_1 = WallObject.getColTags(16723968);
                     } else if (int_5 < -3) {
                        string_1 = WallObject.getColTags(16740352);
                     } else if (int_5 < 0) {
                        string_1 = WallObject.getColTags(16756736);
                     } else if (int_5 > 9) {
                        string_1 = WallObject.getColTags(65280);
                     } else if (int_5 > 6) {
                        string_1 = WallObject.getColTags(4259584);
                     } else if (int_5 > 3) {
                        string_1 = WallObject.getColTags(8453888);
                     } else if (int_5 > 0) {
                        string_1 = WallObject.getColTags(12648192);
                     } else {
                        string_1 = WallObject.getColTags(16776960);
                     }

                     string_0 = string_0 + string_1 + " " + " (" + "level-" + npccomposition_0.combatLevel + ")";
                  }

                  if (npccomposition_0.aBool67 && Client.aBool98) {
                     Class24.addMenuEntry("Examine", WallObject.getColTags(16776960) + string_0, 1003, int_0, int_1, int_2);
                  }

                  if (Client.itemSelectionState == 1) {
                     Class24.addMenuEntry("Use", Client.aString35 + " " + "->" + " " + WallObject.getColTags(16776960) + string_0, 7, int_0, int_1, int_2);
                  } else if (Client.spellSelected) {
                     if ((Enum4.anInt381 & 0x2) == 2) {
                        Class24.addMenuEntry(Client.aString34, Client.aString36 + " " + "->" + " " + WallObject.getColTags(16776960) + string_0, 8, int_0, int_1, int_2);
                     }
                  } else {
                     int int_6 = npccomposition_0.aBool67 && Client.aBool98 ? 2000 : 0;
                     String[] strings_0 = npccomposition_0.actions;
                     if (Client.aBool99) {
                        strings_0 = Friend.method537(strings_0);
                     }

                     if (strings_0 != null) {
                        for (int_3 = 4; int_3 >= 0; --int_3) {
                           if (strings_0[int_3] != null && !strings_0[int_3].equalsIgnoreCase("Attack")) {
                              int_4 = 0;
                              if (int_3 == 0) {
                                 int_4 = int_6 + 9;
                              }

                              if (int_3 == 1) {
                                 int_4 = int_6 + 10;
                              }

                              if (int_3 == 2) {
                                 int_4 = int_6 + 11;
                              }

                              if (int_3 == 3) {
                                 int_4 = int_6 + 12;
                              }

                              if (int_3 == 4) {
                                 int_4 = int_6 + 13;
                              }

                              Class24.addMenuEntry(strings_0[int_3], WallObject.getColTags(16776960) + string_0, int_4, int_0, int_1, int_2);
                           }
                        }
                     }

                     if (strings_0 != null) {
                        for (int_3 = 4; int_3 >= 0; --int_3) {
                           if (strings_0[int_3] != null && strings_0[int_3].equalsIgnoreCase("Attack")) {
                              short short_0 = 0;
                              if (Client.anEnum2_6 != Enum2.anEnum2_4) {
                                 if (Client.anEnum2_6 == Enum2.anEnum2_2 || Enum2.anEnum2_1 == Client.anEnum2_6 && npccomposition_0.combatLevel > Class4.localPlayer.combatLevel) {
                                    short_0 = 2000;
                                 }

                                 int_4 = 0;
                                 if (int_3 == 0) {
                                    int_4 = short_0 + 9;
                                 }

                                 if (int_3 == 1) {
                                    int_4 = short_0 + 10;
                                 }

                                 if (int_3 == 2) {
                                    int_4 = short_0 + 11;
                                 }

                                 if (int_3 == 3) {
                                    int_4 = short_0 + 12;
                                 }

                                 if (int_3 == 4) {
                                    int_4 = short_0 + 13;
                                 }

                                 Class24.addMenuEntry(strings_0[int_3], WallObject.getColTags(16776960) + string_0, int_4, int_0, int_1, int_2);
                              }
                           }
                        }
                     }

                     if (!npccomposition_0.aBool67 || !Client.aBool98) {
                        Class24.addMenuEntry("Examine", WallObject.getColTags(16776960) + string_0, 1003, int_0, int_1, int_2);
                     }
                  }

               }
            }
         }
      }
   }

   static int adjustHSLListness0(int int_0, int int_1) {
      if (int_0 == -2) {
         return 12345678;
      } else if (int_0 == -1) {
         if (int_1 < 2) {
            int_1 = 2;
         } else if (int_1 > 126) {
            int_1 = 126;
         }

         return int_1;
      } else {
         int_1 = (int_0 & 0x7F) * int_1 / 128;
         if (int_1 < 2) {
            int_1 = 2;
         } else if (int_1 > 126) {
            int_1 = 126;
         }

         return (int_0 & 0xFF80) + int_1;
      }
   }

}
