public class AClass1_Sub1 extends AClass1 {

   static int menuY;
   int anInt307;
   int anInt308;
   int anInt309;
   int anInt310;

   int method617() {
      return this.anInt309;
   }

   boolean method618(int int_0, int int_1) {
      return int_0 < this.anInt309 * 8 ? false : (int_1 < this.anInt310 * 8 ? false : (int_0 >= this.anInt309 * 8 + 8 ? false : int_1 < this.anInt310 * 8 + 8));
   }

   int method619() {
      return this.anInt310;
   }

   void method620(Buffer buffer_0, Buffer buffer_1) {
      int int_0 = buffer_1.readUnsignedByte();
      if (int_0 != Class10.aClass10_1.anInt49) {
         throw new IllegalStateException("");
      } else {
         this.anInt53 = buffer_1.readUnsignedByte();
         this.anInt52 = buffer_1.readUnsignedByte();
         this.anInt54 = buffer_1.readUnsignedShort();
         this.anInt55 = buffer_1.readUnsignedShort();
         this.anInt307 = buffer_1.readUnsignedByte();
         this.anInt308 = buffer_1.readUnsignedByte();
         this.anInt50 = buffer_1.readUnsignedShort();
         this.anInt51 = buffer_1.readUnsignedShort();
         this.anInt309 = buffer_1.readUnsignedByte();
         this.anInt310 = buffer_1.readUnsignedByte();
         this.anInt52 = Math.min(this.anInt52, 4);
         this.aShortArrayArrayArray1 = new short[1][64][64];
         this.aShortArrayArrayArray2 = new short[this.anInt52][64][64];
         this.aByteArrayArrayArray3 = new byte[this.anInt52][64][64];
         this.aByteArrayArrayArray4 = new byte[this.anInt52][64][64];
         this.aClass6ArrayArrayArrayArray1 = new Class6[this.anInt52][64][64][];
         int_0 = buffer_0.readUnsignedByte();
         if (int_0 != Class12.aClass12_2.anInt57) {
            throw new IllegalStateException("");
         } else {
            int int_1 = buffer_0.readUnsignedByte();
            int int_2 = buffer_0.readUnsignedByte();
            int int_3 = buffer_0.readUnsignedByte();
            int int_4 = buffer_0.readUnsignedByte();
            if (int_1 == this.anInt50 && int_2 == this.anInt51 && int_3 == this.anInt309 && int_4 == this.anInt310) {
               for (int int_5 = 0; int_5 < 8; int_5++) {
                  for (int int_6 = 0; int_6 < 8; int_6++) {
                     this.method162(int_5 + this.anInt309 * 8, int_6 + this.anInt310 * 8, buffer_0);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   int method621() {
      return this.anInt307;
   }

   int method622() {
      return this.anInt308;
   }

   public boolean equals(Object object_0) {
      if (!(object_0 instanceof AClass1_Sub1)) {
         return false;
      } else {
         AClass1_Sub1 aclass1_sub1_1 = (AClass1_Sub1) object_0;
         return this.anInt50 == aclass1_sub1_1.anInt50 && this.anInt51 == aclass1_sub1_1.anInt51 ? aclass1_sub1_1.anInt309 == this.anInt309 && aclass1_sub1_1.anInt310 == this.anInt310 : false;
      }
   }

   public int hashCode() {
      return this.anInt50 | this.anInt51 << 8 | this.anInt309 << 16 | this.anInt310 << 24;
   }

}
