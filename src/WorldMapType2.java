public class WorldMapType2 implements WorldMapSectionBase {

   static IndexData vorbisIndex;
   int anInt226;
   int anInt227;
   int anInt228;
   int anInt229;
   int anInt230;
   int anInt231;

   public boolean method5(int int_0, int int_1) {
      return int_0 >> 6 == this.anInt227 && int_1 >> 6 == this.anInt228;
   }

   public boolean method6(int int_0, int int_1, int int_2) {
      return int_0 >= this.anInt226 && int_0 < this.anInt226 + this.anInt229 ? int_1 >> 6 == this.anInt230 && int_2 >> 6 == this.anInt231 : false;
   }

   public void method7(WorldMapData worldmapdata_0) {
      if (worldmapdata_0.anInt109 > this.anInt227) {
         worldmapdata_0.anInt109 = this.anInt227;
      }

      if (worldmapdata_0.anInt107 < this.anInt227) {
         worldmapdata_0.anInt107 = this.anInt227;
      }

      if (worldmapdata_0.anInt110 > this.anInt228) {
         worldmapdata_0.anInt110 = this.anInt228;
      }

      if (worldmapdata_0.anInt108 < this.anInt228) {
         worldmapdata_0.anInt108 = this.anInt228;
      }

   }

   public Coordinates method8(int int_0, int int_1) {
      if (!this.method5(int_0, int_1)) {
         return null;
      } else {
         int int_2 = this.anInt230 * 64 - this.anInt227 * 64 + int_0;
         int int_3 = this.anInt231 * 64 - this.anInt228 * 64 + int_1;
         return new Coordinates(this.anInt226, int_2, int_3);
      }
   }

   public int[] method9(int int_0, int int_1, int int_2) {
      if (!this.method6(int_0, int_1, int_2)) {
         return null;
      } else {
         int[] ints_0 = new int[] {this.anInt227 * 64 - this.anInt230 * 64 + int_1, int_2 + (this.anInt228 * 64 - this.anInt231 * 64)};
         return ints_0;
      }
   }

   void method572() {
   }

   public void method10(Buffer buffer_0) {
      this.anInt226 = buffer_0.getUnsignedByte();
      this.anInt229 = buffer_0.getUnsignedByte();
      this.anInt230 = buffer_0.getUnsignedShort();
      this.anInt231 = buffer_0.getUnsignedShort();
      this.anInt227 = buffer_0.getUnsignedShort();
      this.anInt228 = buffer_0.getUnsignedShort();
      this.method572();
   }

}
