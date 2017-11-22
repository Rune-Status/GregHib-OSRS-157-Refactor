import java.util.LinkedList;

public abstract class AClass1 {

   static int cameraPitch;
   int anInt50;
   int anInt51;
   short[][][] aShortArrayArrayArray1;
   int anInt52;
   short[][][] aShortArrayArrayArray2;
   Class6[][][][] aClass6ArrayArrayArrayArray1;
   int anInt53;
   byte[][][] aByteArrayArrayArray3;
   int anInt54;
   int anInt55;
   byte[][][] aByteArrayArrayArray4;

   AClass1() {
      new LinkedList();
   }

   int method157(int int_0, int int_1) {
      return int_0 >= 0 && int_1 >= 0 ? (int_0 < 64 && int_1 < 64 ? this.aShortArrayArrayArray1[0][int_0][int_1] - 1 : -1) : -1;
   }

   void method158(int int_0, int int_1, Buffer buffer_0, int int_2) {
      boolean bool_0 = (int_2 & 0x2) != 0;
      if (bool_0) {
         this.aShortArrayArrayArray2[0][int_0][int_1] = (short)buffer_0.readUnsignedByte();
      }

      this.aShortArrayArrayArray1[0][int_0][int_1] = (short)buffer_0.readUnsignedByte();
   }

   void method159(int int_0, int int_1, Buffer buffer_0, int int_2) {
      int int_3 = ((int_2 & 0x18) >> 3) + 1;
      boolean bool_0 = (int_2 & 0x2) != 0;
      boolean bool_1 = (int_2 & 0x4) != 0;
      this.aShortArrayArrayArray1[0][int_0][int_1] = (short)buffer_0.readUnsignedByte();
      int int_4;
      int int_5;
      int int_7;
      if (bool_0) {
         int_4 = buffer_0.readUnsignedByte();

         for (int_5 = 0; int_5 < int_4; int_5++) {
            int int_6 = buffer_0.readUnsignedByte();
            if (int_6 != 0) {
               this.aShortArrayArrayArray2[int_5][int_0][int_1] = (short)int_6;
               int_7 = buffer_0.readUnsignedByte();
               this.aByteArrayArrayArray3[int_5][int_0][int_1] = (byte)(int_7 >> 2);
               this.aByteArrayArrayArray4[int_5][int_0][int_1] = (byte)(int_7 & 0x3);
            }
         }
      }

      if (bool_1) {
         for (int_4 = 0; int_4 < int_3; int_4++) {
            int_5 = buffer_0.readUnsignedByte();
            if (int_5 != 0) {
               Class6[] class6s_0 = this.aClass6ArrayArrayArrayArray1[int_4][int_0][int_1] = new Class6[int_5];

               for (int_7 = 0; int_7 < int_5; int_7++) {
                  int int_8 = buffer_0.method703();
                  int int_9 = buffer_0.readUnsignedByte();
                  class6s_0[int_7] = new Class6(int_8, int_9 >> 2, int_9 & 0x3);
               }
            }
         }
      }

   }

   int method160() {
      return this.anInt50;
   }

   int method161() {
      return this.anInt51;
   }

   void method162(int int_0, int int_1, Buffer buffer_0) {
      int int_2 = buffer_0.readUnsignedByte();
      if (int_2 != 0) {
         if ((int_2 & 0x1) != 0) {
            this.method158(int_0, int_1, buffer_0, int_2);
         } else {
            this.method159(int_0, int_1, buffer_0, int_2);
         }

      }
   }

}
