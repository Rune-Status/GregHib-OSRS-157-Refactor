public class Class4 implements WorldMapSectionBase {

   static Player localPlayer;
   static Font normalFont;
   static IndexData modelsIndex;
   static int anInt25;
   static Class1 aClass1_1;
   int anInt26;
   int anInt27;
   int anInt28;
   int anInt29;
   int anInt30;
   int anInt31;
   int anInt32;
   int anInt33;
   int anInt34;
   int anInt35;

   public boolean method5(int int_0, int int_1) {
      return int_0 >= (this.anInt28 << 6) + (this.anInt27 << 3) && int_0 <= (this.anInt28 << 6) + (this.anInt27 << 3) + 7 && int_1 >= (this.anInt33 << 6) + (this.anInt32 << 3) && int_1 <= (this.anInt33 << 6) + (this.anInt32 << 3) + 7;
   }

   public boolean method6(int int_0, int int_1, int int_2) {
      return int_0 >= this.anInt26 && int_0 < this.anInt29 + this.anInt26 ? int_1 >= (this.anInt31 << 6) + (this.anInt30 << 3) && int_1 <= (this.anInt31 << 6) + (this.anInt30 << 3) + 7 && int_2 >= (this.anInt34 << 6) + (this.anInt35 << 3) && int_2 <= (this.anInt34 << 6) + (this.anInt35 << 3) + 7 : false;
   }

   public void method7(WorldMapData worldmapdata_0) {
      if (worldmapdata_0.anInt109 > this.anInt28) {
         worldmapdata_0.anInt109 = this.anInt28;
      }

      if (worldmapdata_0.anInt107 < this.anInt28) {
         worldmapdata_0.anInt107 = this.anInt28;
      }

      if (worldmapdata_0.anInt110 > this.anInt33) {
         worldmapdata_0.anInt110 = this.anInt33;
      }

      if (worldmapdata_0.anInt108 < this.anInt33) {
         worldmapdata_0.anInt108 = this.anInt33;
      }

   }

   public Coordinates method8(int int_0, int int_1) {
      if (!this.method5(int_0, int_1)) {
         return null;
      } else {
         int int_2 = this.anInt31 * 64 - this.anInt28 * 64 + (this.anInt30 * 8 - this.anInt27 * 8) + int_0;
         int int_3 = this.anInt34 * 64 - this.anInt33 * 64 + int_1 + (this.anInt35 * 8 - this.anInt32 * 8);
         return new Coordinates(this.anInt26, int_2, int_3);
      }
   }

   public int[] method9(int int_0, int int_1, int int_2) {
      if (!this.method6(int_0, int_1, int_2)) {
         return null;
      } else {
         int[] ints_0 = new int[] {this.anInt28 * 64 - this.anInt31 * 64 + int_1 + (this.anInt27 * 8 - this.anInt30 * 8), int_2 + (this.anInt33 * 64 - this.anInt34 * 64) + (this.anInt32 * 8 - this.anInt35 * 8)};
         return ints_0;
      }
   }

   public void method10(Buffer buffer_0) {
      this.anInt26 = buffer_0.getUnsignedByte();
      this.anInt29 = buffer_0.getUnsignedByte();
      this.anInt31 = buffer_0.getUnsignedShort();
      this.anInt30 = buffer_0.getUnsignedByte();
      this.anInt34 = buffer_0.getUnsignedShort();
      this.anInt35 = buffer_0.getUnsignedByte();
      this.anInt28 = buffer_0.getUnsignedShort();
      this.anInt27 = buffer_0.getUnsignedByte();
      this.anInt33 = buffer_0.getUnsignedShort();
      this.anInt32 = buffer_0.getUnsignedByte();
      this.method81();
   }

   void method81() {
   }

   public static boolean method82(Model model_0, int int_0, int int_1, int int_2) {
      boolean bool_0 = Class54.aBool21;
      if (!bool_0) {
         return false;
      } else {
         Varcs.method543();
         int int_3 = model_0.anInt558 + int_0;
         int int_4 = int_1 + model_0.anInt562;
         int int_5 = int_2 + model_0.anInt564;
         int int_6 = model_0.anInt555;
         int int_7 = model_0.anInt563;
         int int_8 = model_0.anInt566;
         int int_9 = Class54.anInt141 - int_3;
         int int_10 = Class54.anInt142 - int_4;
         int int_11 = Class12.anInt56 - int_5;
         return Math.abs(int_9) > int_6 + Varcs.anInt209 ? false : (Math.abs(int_10) > int_7 + Class54.anInt143 ? false : (Math.abs(int_11) > int_8 + Enum6.anInt385 ? false : (Math.abs(int_11 * CacheableNode_Sub5.anInt473 - int_10 * Class54.anInt144) > int_7 * Enum6.anInt385 + int_8 * Class54.anInt143 ? false : (Math.abs(int_9 * Class54.anInt144 - int_11 * Class54.anInt145) > int_8 * Varcs.anInt209 + int_6 * Enum6.anInt385 ? false : Math.abs(int_10 * Class54.anInt145 - int_9 * CacheableNode_Sub5.anInt473) <= int_6 * Class54.anInt143 + int_7 * Varcs.anInt209))));
      }
   }

}
