public class Class82 {

   static final byte[] aByteArray8;
   long aLong9;
   int[] anIntArray41;
   Buffer aBuffer5;
   int anInt179;
   int[] anIntArray42;
   int[] anIntArray43;
   int anInt180;
   int[] anIntArray44;

   static {
      aByteArray8 = new byte[] {(byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 0, (byte) 1, (byte) 2, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
   }

   Class82(byte[] bytes_0) {
      this.aBuffer5 = new Buffer((byte[]) null);
      this.method480(bytes_0);
   }

   Class82() {
      this.aBuffer5 = new Buffer((byte[]) null);
   }

   int method477(int int_0) {
      byte byte_0 = this.aBuffer5.payload[this.aBuffer5.offset];
      int int_3;
      if (byte_0 < 0) {
         int_3 = byte_0 & 0xFF;
         this.anIntArray44[int_0] = int_3;
         ++this.aBuffer5.offset;
      } else {
         int_3 = this.anIntArray44[int_0];
      }

      if (int_3 != 240 && int_3 != 247) {
         return this.method486(int_0, int_3);
      } else {
         int int_1 = this.aBuffer5.readVarInt();
         if (int_3 == 247 && int_1 > 0) {
            int int_2 = this.aBuffer5.payload[this.aBuffer5.offset] & 0xFF;
            if (int_2 >= 241 && int_2 <= 243 || int_2 == 246 || int_2 == 248 || int_2 >= 250 && int_2 <= 252 || int_2 == 254) {
               ++this.aBuffer5.offset;
               this.anIntArray44[int_0] = int_2;
               return this.method486(int_0, int_2);
            }
         }

         this.aBuffer5.offset += int_1;
         return 0;
      }
   }

   void method478() {
      this.aBuffer5.payload = null;
      this.anIntArray42 = null;
      this.anIntArray41 = null;
      this.anIntArray43 = null;
      this.anIntArray44 = null;
   }

   boolean method479() {
      return this.aBuffer5.payload != null;
   }

   void method480(byte[] bytes_0) {
      this.aBuffer5.payload = bytes_0;
      this.aBuffer5.offset = 10;
      int int_0 = this.aBuffer5.readUnsignedShort();
      this.anInt180 = this.aBuffer5.readUnsignedShort();
      this.anInt179 = 500000;
      this.anIntArray42 = new int[int_0];

      int int_1;
      int int_3;
      for (int_1 = 0; int_1 < int_0; this.aBuffer5.offset += int_3) {
         int int_2 = this.aBuffer5.readInt();
         int_3 = this.aBuffer5.readInt();
         if (int_2 == 1297379947) {
            this.anIntArray42[int_1] = this.aBuffer5.offset;
            ++int_1;
         }
      }

      this.aLong9 = 0L;
      this.anIntArray41 = new int[int_0];

      for (int_1 = 0; int_1 < int_0; int_1++) {
         this.anIntArray41[int_1] = this.anIntArray42[int_1];
      }

      this.anIntArray43 = new int[int_0];
      this.anIntArray44 = new int[int_0];
   }

   void method481(int int_0) {
      this.aBuffer5.offset = this.anIntArray41[int_0];
   }

   int method482() {
      int int_0 = this.anIntArray41.length;
      int int_1 = -1;
      int int_2 = Integer.MAX_VALUE;

      for (int int_3 = 0; int_3 < int_0; int_3++) {
         if (this.anIntArray41[int_3] >= 0 && this.anIntArray43[int_3] < int_2) {
            int_1 = int_3;
            int_2 = this.anIntArray43[int_3];
         }
      }

      return int_1;
   }

   int method483() {
      return this.anIntArray41.length;
   }

   int method484(int int_0) {
      int int_1 = this.method477(int_0);
      return int_1;
   }

   void method485(int int_0) {
      int int_1 = this.aBuffer5.readVarInt();
      this.anIntArray43[int_0] += int_1;
   }

   int method486(int int_0, int int_1) {
      int int_2;
      if (int_1 == 255) {
         int int_5 = this.aBuffer5.readUnsignedByte();
         int_2 = this.aBuffer5.readVarInt();
         if (int_5 == 47) {
            this.aBuffer5.offset += int_2;
            return 1;
         } else if (int_5 == 81) {
            int int_3 = this.aBuffer5.read24BitInt();
            int_2 -= 3;
            int int_4 = this.anIntArray43[int_0];
            this.aLong9 += (long)int_4 * (long)(this.anInt179 - int_3);
            this.anInt179 = int_3;
            this.aBuffer5.offset += int_2;
            return 2;
         } else {
            this.aBuffer5.offset += int_2;
            return 3;
         }
      } else {
         byte byte_0 = aByteArray8[int_1 - 128];
         int_2 = int_1;
         if (byte_0 >= 1) {
            int_2 = int_1 | this.aBuffer5.readUnsignedByte() << 8;
         }

         if (byte_0 >= 2) {
            int_2 |= this.aBuffer5.readUnsignedByte() << 16;
         }

         return int_2;
      }
   }

   long method487(int int_0) {
      return this.aLong9 + (long)int_0 * (long)this.anInt179;
   }

   void method488() {
      this.aBuffer5.offset = -1;
   }

   void method489(int int_0) {
      this.anIntArray41[int_0] = this.aBuffer5.offset;
   }

   boolean method490() {
      int int_0 = this.anIntArray41.length;

      for (int int_1 = 0; int_1 < int_0; int_1++) {
         if (this.anIntArray41[int_1] >= 0) {
            return false;
         }
      }

      return true;
   }

   void method491(long long_0) {
      this.aLong9 = long_0;
      int int_0 = this.anIntArray41.length;

      for (int int_1 = 0; int_1 < int_0; int_1++) {
         this.anIntArray43[int_1] = 0;
         this.anIntArray44[int_1] = 0;
         this.aBuffer5.offset = this.anIntArray42[int_1];
         this.method485(int_1);
         this.anIntArray41[int_1] = this.aBuffer5.offset;
      }

   }

}
