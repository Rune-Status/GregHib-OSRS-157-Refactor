public final class ISAACCipher {

   int valuesRemaining;
   int anInt176;
   int anInt177;
   int[] mm;
   int[] randResult;
   int anInt178;

   public ISAACCipher(int[] ints_0) {
      this.mm = new int[256];
      this.randResult = new int[256];

      for (int int_0 = 0; int_0 < ints_0.length; int_0++) {
         this.randResult[int_0] = ints_0[int_0];
      }

      this.method476();
   }

   void generateMoreResults() {
      this.anInt176 += ++this.anInt177;

      for (int int_0 = 0; int_0 < 256; int_0++) {
         int int_1 = this.mm[int_0];
         if ((int_0 & 0x2) == 0) {
            if ((int_0 & 0x1) == 0) {
               this.anInt178 ^= this.anInt178 << 13;
            } else {
               this.anInt178 ^= this.anInt178 >>> 6;
            }
         } else if ((int_0 & 0x1) == 0) {
            this.anInt178 ^= this.anInt178 << 2;
         } else {
            this.anInt178 ^= this.anInt178 >>> 16;
         }

         this.anInt178 += this.mm[int_0 + 128 & 0xFF];
         int int_2;
         this.mm[int_0] = int_2 = this.mm[(int_1 & 0x3FC) >> 2] + this.anInt178 + this.anInt176;
         this.randResult[int_0] = this.anInt176 = this.mm[(int_2 >> 8 & 0x3FC) >> 2] + int_1;
      }

   }

   int method475() {
      if (this.valuesRemaining == 0) {
         this.generateMoreResults();
         this.valuesRemaining = 256;
      }

      return this.randResult[this.valuesRemaining - 1];
   }

   void method476() {
      int int_0 = -1640531527;
      int int_1 = -1640531527;
      int int_2 = -1640531527;
      int int_3 = -1640531527;
      int int_4 = -1640531527;
      int int_5 = -1640531527;
      int int_6 = -1640531527;
      int int_7 = -1640531527;

      int int_8;
      for (int_8 = 0; int_8 < 4; int_8++) {
         int_7 ^= int_6 << 11;
         int_4 += int_7;
         int_6 += int_5;
         int_6 ^= int_5 >>> 2;
         int_3 += int_6;
         int_5 += int_4;
         int_5 ^= int_4 << 8;
         int_2 += int_5;
         int_4 += int_3;
         int_4 ^= int_3 >>> 16;
         int_1 += int_4;
         int_3 += int_2;
         int_3 ^= int_2 << 10;
         int_0 += int_3;
         int_2 += int_1;
         int_2 ^= int_1 >>> 4;
         int_7 += int_2;
         int_1 += int_0;
         int_1 ^= int_0 << 8;
         int_6 += int_1;
         int_0 += int_7;
         int_0 ^= int_7 >>> 9;
         int_5 += int_0;
         int_7 += int_6;
      }

      for (int_8 = 0; int_8 < 256; int_8 += 8) {
         int_7 += this.randResult[int_8];
         int_6 += this.randResult[int_8 + 1];
         int_5 += this.randResult[int_8 + 2];
         int_4 += this.randResult[int_8 + 3];
         int_3 += this.randResult[int_8 + 4];
         int_2 += this.randResult[int_8 + 5];
         int_1 += this.randResult[int_8 + 6];
         int_0 += this.randResult[int_8 + 7];
         int_7 ^= int_6 << 11;
         int_4 += int_7;
         int_6 += int_5;
         int_6 ^= int_5 >>> 2;
         int_3 += int_6;
         int_5 += int_4;
         int_5 ^= int_4 << 8;
         int_2 += int_5;
         int_4 += int_3;
         int_4 ^= int_3 >>> 16;
         int_1 += int_4;
         int_3 += int_2;
         int_3 ^= int_2 << 10;
         int_0 += int_3;
         int_2 += int_1;
         int_2 ^= int_1 >>> 4;
         int_7 += int_2;
         int_1 += int_0;
         int_1 ^= int_0 << 8;
         int_6 += int_1;
         int_0 += int_7;
         int_0 ^= int_7 >>> 9;
         int_5 += int_0;
         int_7 += int_6;
         this.mm[int_8] = int_7;
         this.mm[int_8 + 1] = int_6;
         this.mm[int_8 + 2] = int_5;
         this.mm[int_8 + 3] = int_4;
         this.mm[int_8 + 4] = int_3;
         this.mm[int_8 + 5] = int_2;
         this.mm[int_8 + 6] = int_1;
         this.mm[int_8 + 7] = int_0;
      }

      for (int_8 = 0; int_8 < 256; int_8 += 8) {
         int_7 += this.mm[int_8];
         int_6 += this.mm[int_8 + 1];
         int_5 += this.mm[int_8 + 2];
         int_4 += this.mm[int_8 + 3];
         int_3 += this.mm[int_8 + 4];
         int_2 += this.mm[int_8 + 5];
         int_1 += this.mm[int_8 + 6];
         int_0 += this.mm[int_8 + 7];
         int_7 ^= int_6 << 11;
         int_4 += int_7;
         int_6 += int_5;
         int_6 ^= int_5 >>> 2;
         int_3 += int_6;
         int_5 += int_4;
         int_5 ^= int_4 << 8;
         int_2 += int_5;
         int_4 += int_3;
         int_4 ^= int_3 >>> 16;
         int_1 += int_4;
         int_3 += int_2;
         int_3 ^= int_2 << 10;
         int_0 += int_3;
         int_2 += int_1;
         int_2 ^= int_1 >>> 4;
         int_7 += int_2;
         int_1 += int_0;
         int_1 ^= int_0 << 8;
         int_6 += int_1;
         int_0 += int_7;
         int_0 ^= int_7 >>> 9;
         int_5 += int_0;
         int_7 += int_6;
         this.mm[int_8] = int_7;
         this.mm[int_8 + 1] = int_6;
         this.mm[int_8 + 2] = int_5;
         this.mm[int_8 + 3] = int_4;
         this.mm[int_8 + 4] = int_3;
         this.mm[int_8 + 5] = int_2;
         this.mm[int_8 + 6] = int_1;
         this.mm[int_8 + 7] = int_0;
      }

      this.generateMoreResults();
      this.valuesRemaining = 256;
   }

   int nextInt() {
      if (--this.valuesRemaining + 1 == 0) {
         this.generateMoreResults();
         this.valuesRemaining = 255;
      }

      return this.randResult[this.valuesRemaining];
   }

}
