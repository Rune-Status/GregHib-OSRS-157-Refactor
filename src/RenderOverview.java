import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RenderOverview {

   static final Class97 aClass97_1;
   static final Class97 aClass97_2;
   static final Class97 aClass97_3;
   IndexedSprite[] anIndexedSpriteArray1;
   boolean aBool1;
   HashSet aHashSet1;
   int anInt1;
   int anInt2;
   int anInt3;
   HashSet aHashSet2;
   int anInt4;
   boolean aBool2;
   IndexDataBase anIndexDataBase1;
   HashSet aHashSet3;
   HashSet aHashSet4;
   HashMap aHashMap1;
   Class107 aClass107_1;
   Iterator anIterator1;
   int anInt5;
   float aFloat1;
   float aFloat2;
   WorldMapData aWorldMapData1;
   WorldMapData aWorldMapData2;
   int anInt6;
   int anInt7;
   int anInt8;
   int anInt9;
   HashMap aHashMap2;
   int anInt10;
   WorldMapData aWorldMapData3;
   Font aFont1;
   int anInt11;
   Class14 aClass14_1;
   int anInt12;
   HashSet aHashSet5;
   Coordinates aCoordinates1;
   int anInt13;
   int anInt14;
   List aList1;
   final int[] anIntArray2;
   HashSet aHashSet6;
   int anInt15;

   static {
      aClass97_1 = Class97.aClass97_4;
      aClass97_2 = Class97.aClass97_6;
      aClass97_3 = Class97.aClass97_7;
   }

   public RenderOverview() {
      this.anInt5 = -1;
      this.anInt7 = -1;
      this.anInt2 = -1;
      this.anInt3 = -1;
      this.anInt13 = -1;
      this.anInt14 = -1;
      this.anInt1 = 3;
      this.anInt4 = 50;
      this.aBool1 = false;
      this.aHashSet4 = null;
      this.anInt10 = -1;
      this.anInt12 = -1;
      this.anInt6 = -1;
      this.anInt11 = -1;
      this.aHashSet2 = new HashSet();
      this.aHashSet1 = new HashSet();
      this.aHashSet5 = new HashSet();
      this.aHashSet3 = new HashSet();
      this.aBool2 = false;
      this.anInt15 = 0;
      this.anIntArray2 = new int[] {1008, 1009, 1010, 1011, 1012};
      this.aHashSet6 = new HashSet();
      this.aCoordinates1 = null;
   }

   void method14(int int_0, int int_1, boolean bool_0) {
      if (WorldMapData_Sub1.method602()) {
         if (this.aWorldMapData1 != null) {
            int int_2 = (int)((float)this.anInt9 + ((float)(int_0 - this.anInt13) - (float)this.method29() * this.aFloat2 / 2.0F) / this.aFloat2);
            int int_3 = (int)((float)this.anInt8 - ((float)(int_1 - this.anInt14) - (float)this.method30() * this.aFloat2 / 2.0F) / this.aFloat2);
            this.aCoordinates1 = this.aWorldMapData1.method292(int_2 + this.aWorldMapData1.method289() * 64, int_3 + this.aWorldMapData1.method290() * 64);
            if (this.aCoordinates1 != null && bool_0 && KeyFocusListener.aBoolArray3[82] && KeyFocusListener.aBoolArray3[81] && bool_0) {
               int int_4 = this.aCoordinates1.worldX;
               int int_5 = this.aCoordinates1.worldY;
               int int_6 = this.aCoordinates1.plane;
               PacketNode packetnode_0 = Actor.method953(ClientPacket.aClientPacket18, Client.aClass46_1.anISAACCipher1);
               packetnode_0.packetBuffer.putShort(int_5);
               packetnode_0.packetBuffer.method720(int_4);
               packetnode_0.packetBuffer.putByte(int_6);
               Client.aClass46_1.method282(packetnode_0);
            }
         } else {
            this.aCoordinates1 = null;
         }
      }

   }

   boolean method15() {
      return this.anInt5 != -1 && this.anInt7 != -1;
   }

   public WorldMapData method16(int int_0, int int_1, int int_2) {
      Iterator iterator_0 = this.aHashMap1.values().iterator();

      WorldMapData worldmapdata_0;
      do {
         if (!iterator_0.hasNext()) {
            return null;
         }

         worldmapdata_0 = (WorldMapData) iterator_0.next();
      } while (!worldmapdata_0.method291(int_0, int_1, int_2));

      return worldmapdata_0;
   }

   float method17(int int_0) {
      return int_0 == 25 ? 1.0F : (int_0 == 37 ? 1.5F : (int_0 == 50 ? 2.0F : (int_0 == 75 ? 3.0F : (int_0 == 100 ? 4.0F : 8.0F))));
   }

   public WorldMapData method18(int int_0) {
      Iterator iterator_0 = this.aHashMap1.values().iterator();

      WorldMapData worldmapdata_0;
      do {
         if (!iterator_0.hasNext()) {
            return null;
         }

         worldmapdata_0 = (WorldMapData) iterator_0.next();
      } while (worldmapdata_0.method288() != int_0);

      return worldmapdata_0;
   }

   void method19(WorldMapData worldmapdata_0) {
      this.aWorldMapData1 = worldmapdata_0;
      this.aClass14_1 = new Class14(this.anIndexedSpriteArray1, this.aHashMap2);
      this.aClass107_1.method540(this.aWorldMapData1.method285());
   }

   public int method20() {
      return this.aWorldMapData1 == null ? -1 : this.anInt9 + this.aWorldMapData1.method289() * 64;
   }

   void method21(WorldMapData worldmapdata_0) {
      if (this.aWorldMapData1 == null || worldmapdata_0 != this.aWorldMapData1) {
         this.method19(worldmapdata_0);
         this.method24(-1, -1, -1);
      }
   }

   void method22() {
      if (this.aFloat2 < this.aFloat1) {
         this.aFloat2 = Math.min(this.aFloat1, this.aFloat2 + this.aFloat2 / 30.0F);
      }

      if (this.aFloat2 > this.aFloat1) {
         this.aFloat2 = Math.max(this.aFloat1, this.aFloat2 - this.aFloat2 / 30.0F);
      }

   }

   void method23() {
      this.aHashSet3.clear();
      this.aHashSet3.addAll(this.aHashSet2);
      this.aHashSet3.addAll(this.aHashSet5);
   }

   void method24(int int_0, int int_1, int int_2) {
      if (this.aWorldMapData1 != null) {
         int[] ints_0 = this.aWorldMapData1.method287(int_0, int_1, int_2);
         if (ints_0 == null) {
            ints_0 = this.aWorldMapData1.method287(this.aWorldMapData1.method293(), this.aWorldMapData1.method294(), this.aWorldMapData1.method295());
         }

         this.anInt9 = ints_0[0] - this.aWorldMapData1.method289() * 64;
         this.anInt8 = ints_0[1] - this.aWorldMapData1.method290() * 64;
         this.anInt5 = -1;
         this.anInt7 = -1;
         this.aFloat2 = this.method17(this.aWorldMapData1.method296());
         this.aFloat1 = this.aFloat2;
         this.aList1 = null;
         this.anIterator1 = null;
         this.aClass14_1.method184();
      }
   }

   public int method25() {
      return this.aWorldMapData1 == null ? -1 : this.anInt8 + this.aWorldMapData1.method290() * 64;
   }

   void method26() {
      if (this.method15()) {
         int int_0 = this.anInt5 - this.anInt9;
         int int_1 = this.anInt7 - this.anInt8;
         if (int_0 != 0) {
            int_0 /= Math.min(8, Math.abs(int_0));
         }

         if (int_1 != 0) {
            int_1 /= Math.min(8, Math.abs(int_1));
         }

         this.anInt9 += int_0;
         this.anInt8 += int_1;
         if (this.anInt9 == this.anInt5 && this.anInt8 == this.anInt7) {
            this.anInt5 = -1;
            this.anInt7 = -1;
         }

      }
   }

   public void method27(int int_0, int int_1) {
      if (this.aWorldMapData1 != null) {
         this.anInt9 = int_0 - this.aWorldMapData1.method289() * 64;
         this.anInt8 = int_1 - this.aWorldMapData1.method290() * 64;
         this.anInt5 = -1;
         this.anInt7 = -1;
      }
   }

   public void method28(int int_0, int int_1) {
      if (this.aWorldMapData1 != null && this.aWorldMapData1.method286(int_0, int_1)) {
         this.anInt5 = int_0 - this.aWorldMapData1.method289() * 64;
         this.anInt7 = int_1 - this.aWorldMapData1.method290() * 64;
      }
   }

   public int method29() {
      return this.anInt2;
   }

   public int method30() {
      return this.anInt3;
   }

   public Class15 method31() {
      return this.anIterator1 == null ? null : (!this.anIterator1.hasNext() ? null : (Class15) this.anIterator1.next());
   }

   void method32(int int_0, int int_1, int int_2, int int_3, int int_4) {
      byte byte_0 = 20;
      int int_5 = int_2 / 2 + int_0;
      int int_6 = int_3 / 2 + int_1 - 18 - byte_0;
      Rasterizer2D.method919(int_0, int_1, int_2, int_3, -16777216);
      Rasterizer2D.drawRectangle(int_5 - 152, int_6, 304, 34, -65536);
      Rasterizer2D.method919(int_5 - 150, int_6 + 2, int_4 * 3, 30, -65536);
      this.aFont1.method1039("Loading...", int_5, int_6 + byte_0, -1, -1);
   }

   public int method33() {
      return this.anIndexDataBase1.method429(this.aWorldMapData2.method285(), Class16.aClass16_3.aString2) ? 100 : this.anIndexDataBase1.method434(this.aWorldMapData2.method285());
   }

   public void method34(IndexDataBase indexdatabase_0, Font font_0, HashMap hashmap_0, IndexedSprite[] indexedsprites_0) {
      this.anIndexedSpriteArray1 = indexedsprites_0;
      this.anIndexDataBase1 = indexdatabase_0;
      this.aFont1 = font_0;
      this.aHashMap2 = new HashMap();
      this.aHashMap2.put(Class28.aClass28_2, hashmap_0.get(aClass97_1));
      this.aHashMap2.put(Class28.aClass28_3, hashmap_0.get(aClass97_2));
      this.aHashMap2.put(Class28.aClass28_4, hashmap_0.get(aClass97_3));
      this.aClass107_1 = new Class107(indexdatabase_0);
      int int_0 = this.anIndexDataBase1.getFile(Class16.aClass16_1.aString2);
      int[] ints_0 = this.anIndexDataBase1.getChilds(int_0);
      this.aHashMap1 = new HashMap(ints_0.length);

      for (int int_1 = 0; int_1 < ints_0.length; int_1++) {
         Buffer buffer_0 = new Buffer(this.anIndexDataBase1.getConfigData(int_0, ints_0[int_1]));
         WorldMapData worldmapdata_0 = new WorldMapData();
         worldmapdata_0.loadMapData(buffer_0, ints_0[int_1]);
         this.aHashMap1.put(worldmapdata_0.method285(), worldmapdata_0);
         if (worldmapdata_0.method299()) {
            this.aWorldMapData2 = worldmapdata_0;
         }
      }

      this.method21(this.aWorldMapData2);
      this.aWorldMapData3 = null;
   }

   public void extractWorldmap(int int_0, int int_1, int int_2, int int_3, int int_4) {
      int[] ints_0 = new int[4];
      Rasterizer2D.copyDrawRegion(ints_0);
      Rasterizer2D.setDrawRegion(int_0, int_1, int_2 + int_0, int_1 + int_3);
      Rasterizer2D.method919(int_0, int_1, int_2, int_3, -16777216);
      int int_5 = this.aClass107_1.method541();
      if (int_5 < 100) {
         this.method32(int_0, int_1, int_2, int_3, int_5);
      } else {
         if (!this.aClass14_1.method178()) {
            this.aClass14_1.method181(this.anIndexDataBase1, this.aWorldMapData1.method285(), Client.isMembers);
            if (!this.aClass14_1.method178()) {
               return;
            }
         }

         if (this.aHashSet4 != null) {
            ++this.anInt12;
            if (this.anInt12 % this.anInt4 == 0) {
               this.anInt12 = 0;
               ++this.anInt10;
            }

            if (this.anInt10 >= this.anInt1 && !this.aBool1) {
               this.aHashSet4 = null;
            }
         }

         int int_6 = (int)Math.ceil((double)((float)int_2 / this.aFloat2));
         int int_7 = (int)Math.ceil((double)((float)int_3 / this.aFloat2));
         this.aClass14_1.method185(this.anInt9 - int_6 / 2, this.anInt8 - int_7 / 2, int_6 / 2 + this.anInt9, int_7 / 2 + this.anInt8, int_0, int_1, int_2 + int_0, int_1 + int_3);
         if (!this.aBool2) {
            boolean bool_0 = false;
            if (int_4 - this.anInt15 > 100) {
               this.anInt15 = int_4;
               bool_0 = true;
            }

            this.aClass14_1.method186(this.anInt9 - int_6 / 2, this.anInt8 - int_7 / 2, int_6 / 2 + this.anInt9, int_7 / 2 + this.anInt8, int_0, int_1, int_2 + int_0, int_1 + int_3, this.aHashSet3, this.aHashSet4, this.anInt12, this.anInt4, bool_0);
         }

         if (WorldMapData_Sub1.method602() && this.aCoordinates1 != null) {
            this.aFont1.method1040("Coord: " + this.aCoordinates1, Rasterizer2D.draw_region_x + 10, Rasterizer2D.drawingAreaTop + 20, 16776960, -1);
         }

         this.anInt2 = int_6;
         this.anInt3 = int_7;
         this.anInt13 = int_0;
         this.anInt14 = int_1;
         Rasterizer2D.setDrawRegion(ints_0);
      }
   }

   public void extractData(int int_0, int int_1, int int_2, int int_3) {
      if (this.aClass107_1.method539()) {
         if (!this.aClass14_1.method178()) {
            this.aClass14_1.method181(this.anIndexDataBase1, this.aWorldMapData1.method285(), Client.isMembers);
            if (!this.aClass14_1.method178()) {
               return;
            }
         }

         this.aClass14_1.method180(int_0, int_1, int_2, int_3, this.aHashSet4, this.anInt12, this.anInt4);
      }
   }

   public void method35(int int_0, int int_1, Coordinates coordinates_0, Coordinates coordinates_1) {
      ScriptEvent scriptevent_0 = new ScriptEvent();
      Class1 class1_0 = new Class1(int_1, coordinates_0, coordinates_1);
      scriptevent_0.method737(new Object[] {class1_0});
      switch(int_0) {
      case 1008:
         scriptevent_0.method738(Class90.aClass90_1);
         break;
      case 1009:
         scriptevent_0.method738(Class90.aClass90_3);
         break;
      case 1010:
         scriptevent_0.method738(Class90.aClass90_5);
         break;
      case 1011:
         scriptevent_0.method738(Class90.aClass90_4);
         break;
      case 1012:
         scriptevent_0.method738(Class90.aClass90_6);
      }

      Class52.method335(scriptevent_0);
   }

   public void method36(int int_0, int int_1, int int_2, boolean bool_0) {
      WorldMapData worldmapdata_0 = this.method16(int_0, int_1, int_2);
      if (worldmapdata_0 == null) {
         if (!bool_0) {
            return;
         }

         worldmapdata_0 = this.aWorldMapData2;
      }

      boolean bool_1 = false;
      if (worldmapdata_0 != this.aWorldMapData3 || bool_0) {
         this.aWorldMapData3 = worldmapdata_0;
         this.method21(worldmapdata_0);
         bool_1 = true;
      }

      if (bool_1 || bool_0) {
         this.method24(int_0, int_1, int_2);
      }

   }

   public void method37() {
      this.aClass107_1.method538();
   }

   public void method38(int int_0, int int_1, boolean bool_0, int int_2, int int_3, int int_4, int int_5) {
      if (this.aClass107_1.method539()) {
         this.method22();
         this.method26();
         if (bool_0) {
            int int_6 = (int)Math.ceil((double)((float)int_4 / this.aFloat2));
            int int_7 = (int)Math.ceil((double)((float)int_5 / this.aFloat2));
            List list_0 = this.aClass14_1.method182(this.anInt9 - int_6 / 2 - 1, this.anInt8 - int_7 / 2 - 1, int_6 / 2 + this.anInt9 + 1, int_7 / 2 + this.anInt8 + 1, int_2, int_3, int_4, int_5, int_0, int_1);
            HashSet hashset_0 = new HashSet();

            Iterator iterator_0;
            Class15 class15_0;
            ScriptEvent scriptevent_0;
            Class1 class1_0;
            for (iterator_0 = list_0.iterator(); iterator_0.hasNext(); Class52.method335(scriptevent_0)) {
               class15_0 = (Class15) iterator_0.next();
               hashset_0.add(class15_0);
               scriptevent_0 = new ScriptEvent();
               class1_0 = new Class1(class15_0.anInt64, class15_0.aCoordinates5, class15_0.aCoordinates6);
               scriptevent_0.method737(new Object[] {class1_0, Integer.valueOf(int_0), Integer.valueOf(int_1)});
               if (this.aHashSet6.contains(class15_0)) {
                  scriptevent_0.method738(Class90.aClass90_9);
               } else {
                  scriptevent_0.method738(Class90.aClass90_7);
               }
            }

            iterator_0 = this.aHashSet6.iterator();

            while (iterator_0.hasNext()) {
               class15_0 = (Class15) iterator_0.next();
               if (!hashset_0.contains(class15_0)) {
                  scriptevent_0 = new ScriptEvent();
                  class1_0 = new Class1(class15_0.anInt64, class15_0.aCoordinates5, class15_0.aCoordinates6);
                  scriptevent_0.method737(new Object[] {class1_0, Integer.valueOf(int_0), Integer.valueOf(int_1)});
                  scriptevent_0.method738(Class90.aClass90_8);
                  Class52.method335(scriptevent_0);
               }
            }

            this.aHashSet6 = hashset_0;
         }
      }
   }

   public void method39(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      if (this.aClass107_1.method539()) {
         int int_6 = (int)Math.ceil((double)((float)int_2 / this.aFloat2));
         int int_7 = (int)Math.ceil((double)((float)int_3 / this.aFloat2));
         List list_0 = this.aClass14_1.method182(this.anInt9 - int_6 / 2 - 1, this.anInt8 - int_7 / 2 - 1, int_6 / 2 + this.anInt9 + 1, int_7 / 2 + this.anInt8 + 1, int_0, int_1, int_2, int_3, int_4, int_5);
         if (!list_0.isEmpty()) {
            Iterator iterator_0 = list_0.iterator();

            boolean bool_0;
            do {
               if (!iterator_0.hasNext()) {
                  return;
               }

               Class15 class15_0 = (Class15) iterator_0.next();
               Area area_0 = Area.anAreaArray1[class15_0.anInt64];
               bool_0 = false;

               for (int int_8 = this.anIntArray2.length - 1; int_8 >= 0; --int_8) {
                  if (area_0.aStringArray4[int_8] != null) {
                     Class24.addMenuEntry(area_0.aStringArray4[int_8], area_0.aString29, this.anIntArray2[int_8], class15_0.anInt64, class15_0.aCoordinates5.method513(), class15_0.aCoordinates6.method513());
                     bool_0 = true;
                  }
               }
            } while (!bool_0);

         }
      }
   }

   public void method40(int int_0) {
      WorldMapData worldmapdata_0 = this.method18(int_0);
      if (worldmapdata_0 != null) {
         this.method21(worldmapdata_0);
      }

   }

   public int method41() {
      return (double)this.aFloat1 == 1.0D ? 25 : ((double)this.aFloat1 == 1.5D ? 37 : ((double)this.aFloat1 == 2.0D ? 50 : ((double)this.aFloat1 == 3.0D ? 75 : ((double)this.aFloat1 == 4.0D ? 100 : 200))));
   }

   public void method42(int int_0, int int_1, boolean bool_0, boolean bool_1) {
      this.method14(int_0, int_1, bool_1);
      if (this.anInt6 == -1) {
         this.anInt6 = int_0;
      }

      if (this.anInt11 == -1) {
         this.anInt11 = int_1;
      }

      int int_2 = int_0 - this.anInt6;
      int int_3 = int_1 - this.anInt11;
      this.anInt6 = int_0;
      this.anInt11 = int_1;
      if (bool_0 && !this.method15()) {
         this.anInt9 -= (int)((float)int_2 / this.aFloat1);
         this.anInt8 += (int)((float)int_3 / this.aFloat1);
      }

   }

   public void method43(int int_0) {
      this.aFloat1 = this.method17(int_0);
   }

   public boolean method44() {
      return this.aClass107_1.method539();
   }

   public Coordinates method45() {
      return this.aWorldMapData1 == null ? null : this.aWorldMapData1.method292(this.method20(), this.method25());
   }

   public void method46(int int_0, int int_1, int int_2) {
      if (this.aWorldMapData1 != null) {
         int[] ints_0 = this.aWorldMapData1.method287(int_0, int_1, int_2);
         if (ints_0 != null) {
            this.method28(ints_0[0], ints_0[1]);
         }

      }
   }

   public void method47(int int_0, int int_1, int int_2) {
      if (this.aWorldMapData1 != null) {
         int[] ints_0 = this.aWorldMapData1.method287(int_0, int_1, int_2);
         if (ints_0 != null) {
            this.method27(ints_0[0], ints_0[1]);
         }

      }
   }

   public int method48() {
      return this.aWorldMapData1 == null ? -1 : this.aWorldMapData1.method288();
   }

   public void method49() {
      this.anInt1 = 3;
   }

   public WorldMapData method50() {
      return this.aWorldMapData1;
   }

   public void method51() {
      this.anInt4 = 50;
   }

   public void method52(int int_0) {
      if (int_0 >= 1) {
         this.anInt1 = int_0;
      }

   }

   public void method53() {
      this.aHashSet4 = null;
   }

   public void method54(int int_0) {
      if (int_0 >= 1) {
         this.anInt4 = int_0;
      }

   }

   public void method55(int int_0) {
      this.aHashSet4 = new HashSet();
      this.aHashSet4.add(Integer.valueOf(int_0));
      this.anInt10 = 0;
      this.anInt12 = 0;
   }

   public void method56(boolean bool_0) {
      this.aBool1 = bool_0;
   }

   public void method57(int int_0) {
      this.aHashSet4 = new HashSet();
      this.anInt10 = 0;
      this.anInt12 = 0;

      for (int int_1 = 0; int_1 < Area.anAreaArray1.length; int_1++) {
         if (Area.anAreaArray1[int_1] != null && Area.anAreaArray1[int_1].anInt449 == int_0) {
            this.aHashSet4.add(Integer.valueOf(Area.anAreaArray1[int_1].anInt443));
         }
      }

   }

   public Class15 method58() {
      if (!this.aClass107_1.method539()) {
         return null;
      } else if (!this.aClass14_1.method178()) {
         return null;
      } else {
         HashMap hashmap_0 = this.aClass14_1.method179();
         this.aList1 = new LinkedList();
         Iterator iterator_0 = hashmap_0.values().iterator();

         while (iterator_0.hasNext()) {
            List list_0 = (List) iterator_0.next();
            this.aList1.addAll(list_0);
         }

         this.anIterator1 = this.aList1.iterator();
         return this.method31();
      }
   }

   public void method59(boolean bool_0) {
      this.aBool2 = !bool_0;
   }

   public boolean method60() {
      return !this.aBool2;
   }

   public void method61(int int_0, boolean bool_0) {
      if (!bool_0) {
         this.aHashSet2.add(Integer.valueOf(int_0));
      } else {
         this.aHashSet2.remove(Integer.valueOf(int_0));
      }

      this.method23();
   }

   public void method62(int int_0, boolean bool_0) {
      if (!bool_0) {
         this.aHashSet1.add(Integer.valueOf(int_0));
      } else {
         this.aHashSet1.remove(Integer.valueOf(int_0));
      }

      for (int int_1 = 0; int_1 < Area.anAreaArray1.length; int_1++) {
         if (Area.anAreaArray1[int_1] != null && Area.anAreaArray1[int_1].anInt449 == int_0) {
            int int_2 = Area.anAreaArray1[int_1].anInt443;
            if (!bool_0) {
               this.aHashSet5.add(Integer.valueOf(int_2));
            } else {
               this.aHashSet5.remove(Integer.valueOf(int_2));
            }
         }
      }

      this.method23();
   }

   public boolean method63(int int_0) {
      return !this.aHashSet2.contains(Integer.valueOf(int_0));
   }

   public void method64(WorldMapData worldmapdata_0, Coordinates coordinates_0, Coordinates coordinates_1, boolean bool_0) {
      if (worldmapdata_0 != null) {
         if (this.aWorldMapData1 == null || worldmapdata_0 != this.aWorldMapData1) {
            this.method19(worldmapdata_0);
         }

         if (!bool_0 && this.aWorldMapData1.method291(coordinates_0.plane, coordinates_0.worldX, coordinates_0.worldY)) {
            this.method24(coordinates_0.plane, coordinates_0.worldX, coordinates_0.worldY);
         } else {
            this.method24(coordinates_1.plane, coordinates_1.worldX, coordinates_1.worldY);
         }

      }
   }

   public boolean method65(int int_0) {
      return !this.aHashSet1.contains(Integer.valueOf(int_0));
   }

   public Coordinates method66(int int_0, Coordinates coordinates_0) {
      if (!this.aClass107_1.method539()) {
         return null;
      } else if (!this.aClass14_1.method178()) {
         return null;
      } else if (!this.aWorldMapData1.method286(coordinates_0.worldX, coordinates_0.worldY)) {
         return null;
      } else {
         HashMap hashmap_0 = this.aClass14_1.method179();
         List list_0 = (List) hashmap_0.get(Integer.valueOf(int_0));
         if (list_0 != null && !list_0.isEmpty()) {
            Class15 class15_0 = null;
            int int_1 = -1;
            Iterator iterator_0 = list_0.iterator();

            while (true) {
               Class15 class15_1;
               int int_4;
               do {
                  if (!iterator_0.hasNext()) {
                     return class15_0.aCoordinates6;
                  }

                  class15_1 = (Class15) iterator_0.next();
                  int int_2 = class15_1.aCoordinates6.worldX - coordinates_0.worldX;
                  int int_3 = class15_1.aCoordinates6.worldY - coordinates_0.worldY;
                  int_4 = int_2 * int_2 + int_3 * int_3;
                  if (int_4 == 0) {
                     return class15_1.aCoordinates6;
                  }
               } while (int_4 >= int_1 && class15_0 != null);

               class15_0 = class15_1;
               int_1 = int_4;
            }
         } else {
            return null;
         }
      }
   }

}
