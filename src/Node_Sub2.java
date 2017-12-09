public class Node_Sub2 extends Node {

   static boolean aBool51;
   static byte[] payload;
   static int position;
   static int bitPosition;
   static CodeBook[] codeBooks;
   static int blockSize1;
   static int[] modeMappings;
   static int blockSize0;
   static float[] aFloatArray2;
   static boolean[] modeBlockFlags;
   static float[] aFloatArray3;
   static float[] aFloatArray4;
   static float[] aFloatArray5;
   static float[] aFloatArray6;
   static float[] aFloatArray7;
   static float[] aFloatArray8;
   static Mapping[] mappings;
   static int[] anIntArray74;
   static int[] anIntArray75;
   static Floor1[] floors;
   static Residue[] residues;
   byte[][] aByteArrayArray7;
   byte[] aByteArray11;
   int anInt333;
   int anInt334;
   int anInt335;
   float[] aFloatArray9;
   int anInt336;
   int anInt337;
   int anInt338;
   int anInt339;
   boolean aBool52;
   boolean aBool53;
   int anInt340;

   static {
      aBool51 = false;
   }

   Node_Sub2(byte[] bytes_0) {
      this.method663(bytes_0);
   }

   void method663(byte[] bytes_0) {
      Buffer buffer_0 = new Buffer(bytes_0);
      this.anInt335 = buffer_0.readInt();
      this.anInt336 = buffer_0.readInt();
      this.anInt338 = buffer_0.readInt();
      this.anInt339 = buffer_0.readInt();
      if (this.anInt339 < 0) {
         this.anInt339 = ~this.anInt339;
         this.aBool52 = true;
      }

      int int_0 = buffer_0.readInt();
      this.aByteArrayArray7 = new byte[int_0][];

      for (int int_1 = 0; int_1 < int_0; int_1++) {
         int int_2 = 0;

         int int_3;
         do {
            int_3 = buffer_0.getUnsignedByte();
            int_2 += int_3;
         } while (int_3 >= 255);

         byte[] bytes_1 = new byte[int_2];
         buffer_0.readBytes(bytes_1, 0, int_2);
         this.aByteArrayArray7[int_1] = bytes_1;
      }

   }

   AClass4_Sub1 method664(int[] ints_0) {
      if (ints_0 != null && ints_0[0] <= 0) {
         return null;
      } else {
         if (this.aByteArray11 == null) {
            this.anInt333 = 0;
            this.aFloatArray9 = new float[blockSize1];
            this.aByteArray11 = new byte[this.anInt336];
            this.anInt337 = 0;
            this.anInt334 = 0;
         }

         for (; this.anInt334 < this.aByteArrayArray7.length; this.anInt334++) {
            if (ints_0 != null && ints_0[0] <= 0) {
               return null;
            }

            float[] floats_0 = this.method665(this.anInt334);
            if (floats_0 != null) {
               int int_0 = this.anInt337;
               int int_1 = floats_0.length;
               if (int_1 > this.anInt336 - int_0) {
                  int_1 = this.anInt336 - int_0;
               }

               for (int int_2 = 0; int_2 < int_1; int_2++) {
                  int int_3 = (int)(128.0F + floats_0[int_2] * 128.0F);
                  if ((int_3 & 0xFFFFFF00) != 0) {
                     int_3 = ~int_3 >> 31;
                  }

                  this.aByteArray11[int_0++] = (byte)(int_3 - 128);
               }

               if (ints_0 != null) {
                  ints_0[0] -= int_0 - this.anInt337;
               }

               this.anInt337 = int_0;
            }
         }

         this.aFloatArray9 = null;
         byte[] bytes_0 = this.aByteArray11;
         this.aByteArray11 = null;
         return new AClass4_Sub1(this.anInt335, bytes_0, this.anInt338, this.anInt339, this.aBool52);
      }
   }

   float[] method665(int int_0) {
      setBytes(this.aByteArrayArray7[int_0], 0);
      getBit();
      int int_1 = getInt(Class15.ilog(modeMappings.length - 1));
      boolean bool_0 = modeBlockFlags[int_1];
      int int_2 = bool_0 ? blockSize1 : blockSize0;
      boolean bool_1 = false;
      boolean bool_2 = false;
      if (bool_0) {
         bool_1 = getBit() != 0;
         bool_2 = getBit() != 0;
      }

      int int_3 = int_2 >> 1;
      int int_4;
      int int_5;
      int int_6;
      if (bool_0 && !bool_1) {
         int_4 = (int_2 >> 2) - (blockSize0 >> 2);
         int_5 = (blockSize0 >> 2) + (int_2 >> 2);
         int_6 = blockSize0 >> 1;
      } else {
         int_4 = 0;
         int_5 = int_3;
         int_6 = int_2 >> 1;
      }

      int int_7;
      int int_8;
      int int_9;
      if (bool_0 && !bool_2) {
         int_7 = int_2 - (int_2 >> 2) - (blockSize0 >> 2);
         int_8 = (blockSize0 >> 2) + (int_2 - (int_2 >> 2));
         int_9 = blockSize0 >> 1;
      } else {
         int_7 = int_3;
         int_8 = int_2;
         int_9 = int_2 >> 1;
      }

      Mapping mapping_0 = mappings[modeMappings[int_1]];
      int int_10 = mapping_0.mux;
      int int_11 = mapping_0.submapFloors[int_10];
      boolean bool_3 = !floors[int_11].decodedFloor();
      boolean bool_4 = bool_3;

      for (int_11 = 0; int_11 < mapping_0.anInt218; int_11++) {
         Residue residue_0 = residues[mapping_0.anIntArray56[int_11]];
         float[] floats_0 = aFloatArray2;
         residue_0.decodeResidue(floats_0, int_2 >> 1, bool_4);
      }

      int int_12;
      if (!bool_3) {
         int_11 = mapping_0.mux;
         int_12 = mapping_0.submapFloors[int_11];
         floors[int_12].computeFloor(aFloatArray2, int_2 >> 1);
      }

      int int_13;
      if (bool_3) {
         for (int_11 = int_2 >> 1; int_11 < int_2; int_11++) {
            aFloatArray2[int_11] = 0.0F;
         }
      } else {
         int_11 = int_2 >> 1;
         int_12 = int_2 >> 2;
         int_13 = int_2 >> 3;
         float[] floats_2 = aFloatArray2;

         int int_15;
         for (int_15 = 0; int_15 < int_11; int_15++) {
            floats_2[int_15] *= 0.5F;
         }

         for (int_15 = int_11; int_15 < int_2; int_15++) {
            floats_2[int_15] = -floats_2[int_2 - int_15 - 1];
         }

         float[] floats_3 = bool_0 ? aFloatArray4 : aFloatArray3;
         float[] floats_4 = bool_0 ? aFloatArray6 : aFloatArray5;
         float[] floats_5 = bool_0 ? aFloatArray8 : aFloatArray7;
         int[] ints_0 = bool_0 ? anIntArray75 : anIntArray74;

         int int_16;
         float float_0;
         float float_1;
         float float_2;
         float float_3;
         for (int_16 = 0; int_16 < int_12; int_16++) {
            float_0 = floats_2[int_16 * 4] - floats_2[int_2 - int_16 * 4 - 1];
            float_1 = floats_2[int_16 * 4 + 2] - floats_2[int_2 - int_16 * 4 - 3];
            float_2 = floats_3[int_16 * 2];
            float_3 = floats_3[int_16 * 2 + 1];
            floats_2[int_2 - int_16 * 4 - 1] = float_0 * float_2 - float_1 * float_3;
            floats_2[int_2 - int_16 * 4 - 3] = float_0 * float_3 + float_1 * float_2;
         }

         float float_4;
         float float_5;
         for (int_16 = 0; int_16 < int_13; int_16++) {
            float_0 = floats_2[int_11 + int_16 * 4 + 3];
            float_1 = floats_2[int_11 + int_16 * 4 + 1];
            float_2 = floats_2[int_16 * 4 + 3];
            float_3 = floats_2[int_16 * 4 + 1];
            floats_2[int_11 + int_16 * 4 + 3] = float_0 + float_2;
            floats_2[int_11 + int_16 * 4 + 1] = float_1 + float_3;
            float_4 = floats_3[int_11 - 4 - int_16 * 4];
            float_5 = floats_3[int_11 - 3 - int_16 * 4];
            floats_2[int_16 * 4 + 3] = (float_0 - float_2) * float_4 - (float_1 - float_3) * float_5;
            floats_2[int_16 * 4 + 1] = (float_1 - float_3) * float_4 + (float_0 - float_2) * float_5;
         }

         int_16 = Class15.ilog(int_2 - 1);

         int int_19;
         int int_20;
         int int_21;
         int int_22;
         for (int_19 = 0; int_19 < int_16 - 3; int_19++) {
            int_20 = int_2 >> int_19 + 2;
            int_21 = 8 << int_19;

            for (int_22 = 0; int_22 < 2 << int_19; int_22++) {
               int int_23 = int_2 - int_20 * int_22 * 2;
               int int_24 = int_2 - int_20 * (int_22 * 2 + 1);

               for (int int_17 = 0; int_17 < int_2 >> int_19 + 4; int_17++) {
                  int int_18 = int_17 * 4;
                  float float_6 = floats_2[int_23 - 1 - int_18];
                  float float_7 = floats_2[int_23 - 3 - int_18];
                  float float_8 = floats_2[int_24 - 1 - int_18];
                  float float_9 = floats_2[int_24 - 3 - int_18];
                  floats_2[int_23 - 1 - int_18] = float_6 + float_8;
                  floats_2[int_23 - 3 - int_18] = float_7 + float_9;
                  float float_10 = floats_3[int_17 * int_21];
                  float float_11 = floats_3[int_17 * int_21 + 1];
                  floats_2[int_24 - 1 - int_18] = (float_6 - float_8) * float_10 - (float_7 - float_9) * float_11;
                  floats_2[int_24 - 3 - int_18] = (float_7 - float_9) * float_10 + (float_6 - float_8) * float_11;
               }
            }
         }

         for (int_19 = 1; int_19 < int_13 - 1; int_19++) {
            int_20 = ints_0[int_19];
            if (int_19 < int_20) {
               int_21 = int_19 * 8;
               int_22 = int_20 * 8;
               float_4 = floats_2[int_21 + 1];
               floats_2[int_21 + 1] = floats_2[int_22 + 1];
               floats_2[int_22 + 1] = float_4;
               float_4 = floats_2[int_21 + 3];
               floats_2[int_21 + 3] = floats_2[int_22 + 3];
               floats_2[int_22 + 3] = float_4;
               float_4 = floats_2[int_21 + 5];
               floats_2[int_21 + 5] = floats_2[int_22 + 5];
               floats_2[int_22 + 5] = float_4;
               float_4 = floats_2[int_21 + 7];
               floats_2[int_21 + 7] = floats_2[int_22 + 7];
               floats_2[int_22 + 7] = float_4;
            }
         }

         for (int_19 = 0; int_19 < int_11; int_19++) {
            floats_2[int_19] = floats_2[int_19 * 2 + 1];
         }

         for (int_19 = 0; int_19 < int_13; int_19++) {
            floats_2[int_2 - 1 - int_19 * 2] = floats_2[int_19 * 4];
            floats_2[int_2 - 2 - int_19 * 2] = floats_2[int_19 * 4 + 1];
            floats_2[int_2 - int_12 - 1 - int_19 * 2] = floats_2[int_19 * 4 + 2];
            floats_2[int_2 - int_12 - 2 - int_19 * 2] = floats_2[int_19 * 4 + 3];
         }

         for (int_19 = 0; int_19 < int_13; int_19++) {
            float_1 = floats_5[int_19 * 2];
            float_2 = floats_5[int_19 * 2 + 1];
            float_3 = floats_2[int_11 + int_19 * 2];
            float_4 = floats_2[int_11 + int_19 * 2 + 1];
            float_5 = floats_2[int_2 - 2 - int_19 * 2];
            float float_12 = floats_2[int_2 - 1 - int_19 * 2];
            float float_13 = float_2 * (float_3 - float_5) + float_1 * (float_4 + float_12);
            floats_2[int_11 + int_19 * 2] = (float_3 + float_5 + float_13) * 0.5F;
            floats_2[int_2 - 2 - int_19 * 2] = (float_3 + float_5 - float_13) * 0.5F;
            float_13 = float_2 * (float_4 + float_12) - float_1 * (float_3 - float_5);
            floats_2[int_11 + int_19 * 2 + 1] = (float_4 - float_12 + float_13) * 0.5F;
            floats_2[int_2 - 1 - int_19 * 2] = (-float_4 + float_12 + float_13) * 0.5F;
         }

         for (int_19 = 0; int_19 < int_12; int_19++) {
            floats_2[int_19] = floats_2[int_11 + int_19 * 2] * floats_4[int_19 * 2] + floats_2[int_11 + int_19 * 2 + 1] * floats_4[int_19 * 2 + 1];
            floats_2[int_11 - 1 - int_19] = floats_2[int_11 + int_19 * 2] * floats_4[int_19 * 2 + 1] - floats_2[int_11 + int_19 * 2 + 1] * floats_4[int_19 * 2];
         }

         for (int_19 = 0; int_19 < int_12; int_19++) {
            floats_2[int_19 + (int_2 - int_12)] = -floats_2[int_19];
         }

         for (int_19 = 0; int_19 < int_12; int_19++) {
            floats_2[int_19] = floats_2[int_12 + int_19];
         }

         for (int_19 = 0; int_19 < int_12; int_19++) {
            floats_2[int_12 + int_19] = -floats_2[int_12 - int_19 - 1];
         }

         for (int_19 = 0; int_19 < int_12; int_19++) {
            floats_2[int_11 + int_19] = floats_2[int_2 - int_19 - 1];
         }

         for (int_19 = int_4; int_19 < int_5; int_19++) {
            float_1 = (float)Math.sin(((double)(int_19 - int_4) + 0.5D) / (double)int_6 * 0.5D * 3.141592653589793D);
            aFloatArray2[int_19] *= (float)Math.sin(1.5707963267948966D * (double)float_1 * (double)float_1);
         }

         for (int_19 = int_7; int_19 < int_8; int_19++) {
            float_1 = (float)Math.sin(((double)(int_19 - int_7) + 0.5D) / (double)int_9 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            aFloatArray2[int_19] *= (float)Math.sin(1.5707963267948966D * (double)float_1 * (double)float_1);
         }
      }

      float[] floats_1 = null;
      if (this.anInt333 > 0) {
         int_12 = int_2 + this.anInt333 >> 2;
         floats_1 = new float[int_12];
         int int_14;
         if (!this.aBool53) {
            for (int_13 = 0; int_13 < this.anInt340; int_13++) {
               int_14 = int_13 + (this.anInt333 >> 1);
               floats_1[int_13] += this.aFloatArray9[int_14];
            }
         }

         if (!bool_3) {
            for (int_13 = int_4; int_13 < int_2 >> 1; int_13++) {
               int_14 = floats_1.length - (int_2 >> 1) + int_13;
               floats_1[int_14] += aFloatArray2[int_13];
            }
         }
      }

      float[] floats_6 = this.aFloatArray9;
      this.aFloatArray9 = aFloatArray2;
      aFloatArray2 = floats_6;
      this.anInt333 = int_2;
      this.anInt340 = int_8 - (int_2 >> 1);
      this.aBool53 = bool_3;
      return floats_1;
   }

   static int getBit() {
      int int_0 = payload[position] >> bitPosition & 0x1;
      ++bitPosition;
      position += bitPosition >> 3;
      bitPosition &= 0x7;
      return int_0;
   }

   static int getInt(int int_0) {
      int int_1 = 0;

      int int_2;
      int int_3;
      for (int_2 = 0; int_0 >= 8 - bitPosition; int_0 -= int_3) {
         int_3 = 8 - bitPosition;
         int int_4 = (1 << int_3) - 1;
         int_1 += (payload[position] >> bitPosition & int_4) << int_2;
         bitPosition = 0;
         ++position;
         int_2 += int_3;
      }

      if (int_0 > 0) {
         int_3 = (1 << int_0) - 1;
         int_1 += (payload[position] >> bitPosition & int_3) << int_2;
         bitPosition += int_0;
      }

      return int_1;
   }

   static void setBytes(byte[] bytes_0, int int_0) {
      payload = bytes_0;
      position = int_0;
      bitPosition = 0;
   }

   static boolean method666(IndexDataBase indexdatabase_0) {
      if (!aBool51) {
         byte[] bytes_0 = indexdatabase_0.getConfigData(0, 0);
         if (bytes_0 == null) {
            return false;
         }

         method668(bytes_0);
         aBool51 = true;
      }

      return true;
   }

   static Node_Sub2 method667(IndexDataBase indexdatabase_0, int int_0, int int_1) {
      if (!method666(indexdatabase_0)) {
         indexdatabase_0.method431(int_0, int_1);
         return null;
      } else {
         byte[] bytes_0 = indexdatabase_0.getConfigData(int_0, int_1);
         return bytes_0 == null ? null : new Node_Sub2(bytes_0);
      }
   }

   static void method668(byte[] bytes_0) {
      setBytes(bytes_0, 0);
      blockSize0 = 1 << getInt(4);
      blockSize1 = 1 << getInt(4);
      aFloatArray2 = new float[blockSize1];

      int int_0;
      int int_1;
      int int_2;
      int int_3;
      int int_4;
      for (int_0 = 0; int_0 < 2; int_0++) {
         int_1 = int_0 != 0 ? blockSize1 : blockSize0;
         int_2 = int_1 >> 1;
         int_3 = int_1 >> 2;
         int_4 = int_1 >> 3;
         float[] floats_0 = new float[int_2];

         for (int int_5 = 0; int_5 < int_3; int_5++) {
            floats_0[int_5 * 2] = (float)Math.cos((double)(int_5 * 4) * 3.141592653589793D / (double)int_1);
            floats_0[int_5 * 2 + 1] = -((float)Math.sin((double)(int_5 * 4) * 3.141592653589793D / (double)int_1));
         }

         float[] floats_1 = new float[int_2];

         for (int int_6 = 0; int_6 < int_3; int_6++) {
            floats_1[int_6 * 2] = (float)Math.cos((double)(int_6 * 2 + 1) * 3.141592653589793D / (double)(int_1 * 2));
            floats_1[int_6 * 2 + 1] = (float)Math.sin((double)(int_6 * 2 + 1) * 3.141592653589793D / (double)(int_1 * 2));
         }

         float[] floats_2 = new float[int_3];

         for (int int_7 = 0; int_7 < int_4; int_7++) {
            floats_2[int_7 * 2] = (float)Math.cos((double)(int_7 * 4 + 2) * 3.141592653589793D / (double)int_1);
            floats_2[int_7 * 2 + 1] = -((float)Math.sin((double)(int_7 * 4 + 2) * 3.141592653589793D / (double)int_1));
         }

         int[] ints_0 = new int[int_4];
         int int_8 = Class15.ilog(int_4 - 1);

         for (int int_9 = 0; int_9 < int_4; int_9++) {
            int int_10 = int_9;
            int int_11 = int_8;

            int int_12;
            for (int_12 = 0; int_11 > 0; --int_11) {
               int_12 = int_12 << 1 | int_10 & 0x1;
               int_10 >>>= 1;
            }

            ints_0[int_9] = int_12;
         }

         if (int_0 != 0) {
            aFloatArray4 = floats_0;
            aFloatArray6 = floats_1;
            aFloatArray8 = floats_2;
            anIntArray75 = ints_0;
         } else {
            aFloatArray3 = floats_0;
            aFloatArray5 = floats_1;
            aFloatArray7 = floats_2;
            anIntArray74 = ints_0;
         }
      }

      int_0 = getInt(8) + 1;
      codeBooks = new CodeBook[int_0];

      for (int_1 = 0; int_1 < int_0; int_1++) {
         codeBooks[int_1] = new CodeBook();
      }

      int_1 = getInt(6) + 1;

      for (int_2 = 0; int_2 < int_1; int_2++) {
         getInt(16);
      }

      int_1 = getInt(6) + 1;
      floors = new Floor1[int_1];

      for (int_2 = 0; int_2 < int_1; int_2++) {
         floors[int_2] = new Floor1();
      }

      int_2 = getInt(6) + 1;
      residues = new Residue[int_2];

      for (int_3 = 0; int_3 < int_2; int_3++) {
         residues[int_3] = new Residue();
      }

      int_3 = getInt(6) + 1;
      mappings = new Mapping[int_3];

      for (int_4 = 0; int_4 < int_3; int_4++) {
         mappings[int_4] = new Mapping();
      }

      int_4 = getInt(6) + 1;
      modeBlockFlags = new boolean[int_4];
      modeMappings = new int[int_4];

      for (int int_13 = 0; int_13 < int_4; int_13++) {
         modeBlockFlags[int_13] = getBit() != 0;
         getInt(16);
         getInt(16);
         modeMappings[int_13] = getInt(8);
      }

   }

   static float float32Unpack(int int_0) {
      int int_1 = int_0 & 0x1FFFFF;
      int int_2 = int_0 & 0x80000000;
      int int_3 = (int_0 & 0x7FE00000) >> 21;
      if (int_2 != 0) {
         int_1 = -int_1;
      }

      return (float)((double)int_1 * Math.pow(2.0D, (double)(int_3 - 788)));
   }

}
