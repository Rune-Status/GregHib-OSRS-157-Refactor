public class CodeBook {

   float[][] valueVector;
   int entries;
   int[] anIntArray32;
   int[] entryLengths;
   int dimensions;
   int[] anIntArray33;

   CodeBook() {
      Node_Sub2.getInt(24);
      this.dimensions = Node_Sub2.getInt(16);
      this.entries = Node_Sub2.getInt(24);
      this.entryLengths = new int[this.entries];
      boolean bool_0 = Node_Sub2.getBit() != 0;
      int int_0;
      int int_1;
      int int_3;
      if (bool_0) {
         int_0 = 0;

         for (int_1 = Node_Sub2.getInt(5) + 1; int_0 < this.entries; int_1++) {
            int int_2 = Node_Sub2.getInt(Class15.ilog(this.entries - int_0));

            for (int_3 = 0; int_3 < int_2; int_3++) {
               this.entryLengths[int_0++] = int_1;
            }
         }
      } else {
         boolean bool_2 = Node_Sub2.getBit() != 0;

         for (int_1 = 0; int_1 < this.entries; int_1++) {
            if (bool_2 && Node_Sub2.getBit() == 0) {
               this.entryLengths[int_1] = 0;
            } else {
               this.entryLengths[int_1] = Node_Sub2.getInt(5) + 1;
            }
         }
      }

      this.createHuffmanTree();
      int_0 = Node_Sub2.getInt(4);
      if (int_0 > 0) {
         float float_2 = Node_Sub2.float32Unpack(Node_Sub2.getInt(32));
         float float_3 = Node_Sub2.float32Unpack(Node_Sub2.getInt(32));
         int_3 = Node_Sub2.getInt(4) + 1;
         boolean bool_1 = Node_Sub2.getBit() != 0;
         int int_4;
         if (int_0 == 1) {
            int_4 = method324(this.entries, this.dimensions);
         } else {
            int_4 = this.entries * this.dimensions;
         }

         this.anIntArray33 = new int[int_4];

         int int_5;
         for (int_5 = 0; int_5 < int_4; int_5++) {
            this.anIntArray33[int_5] = Node_Sub2.getInt(int_3);
         }

         this.valueVector = new float[this.entries][this.dimensions];
         float float_0;
         int int_6;
         int int_7;
         if (int_0 == 1) {
            for (int_5 = 0; int_5 < this.entries; int_5++) {
               float_0 = 0.0F;
               int_6 = 1;

               for (int_7 = 0; int_7 < this.dimensions; int_7++) {
                  int int_8 = int_5 / int_6 % int_4;
                  float float_1 = (float)this.anIntArray33[int_8] * float_3 + float_2 + float_0;
                  this.valueVector[int_5][int_7] = float_1;
                  if (bool_1) {
                     float_0 = float_1;
                  }

                  int_6 *= int_4;
               }
            }
         } else {
            for (int_5 = 0; int_5 < this.entries; int_5++) {
               float_0 = 0.0F;
               int_6 = int_5 * this.dimensions;

               for (int_7 = 0; int_7 < this.dimensions; int_7++) {
                  float float_4 = (float)this.anIntArray33[int_6] * float_3 + float_2 + float_0;
                  this.valueVector[int_5][int_7] = float_4;
                  if (bool_1) {
                     float_0 = float_4;
                  }

                  ++int_6;
               }
            }
         }
      }

   }

   int getHuffmanRoot() {
      int int_0;
      for (int_0 = 0; this.anIntArray32[int_0] >= 0; int_0 = Node_Sub2.getBit() != 0 ? this.anIntArray32[int_0] : int_0 + 1) {
         ;
      }

      return ~this.anIntArray32[int_0];
   }

   float[] method323() {
      return this.valueVector[this.getHuffmanRoot()];
   }

   void createHuffmanTree() {
      int[] ints_0 = new int[this.entries];
      int[] ints_1 = new int[33];

      int int_0;
      int int_1;
      int int_3;
      int int_4;
      int int_5;
      int int_6;
      int int_7;
      for (int_0 = 0; int_0 < this.entries; int_0++) {
         int_1 = this.entryLengths[int_0];
         if (int_1 != 0) {
            int_3 = 1 << 32 - int_1;
            int_4 = ints_1[int_1];
            ints_0[int_0] = int_4;
            int int_8;
            if ((int_4 & int_3) != 0) {
               int_5 = ints_1[int_1 - 1];
            } else {
               int_5 = int_4 | int_3;

               for (int_6 = int_1 - 1; int_6 >= 1; --int_6) {
                  int_8 = ints_1[int_6];
                  if (int_8 != int_4) {
                     break;
                  }

                  int_7 = 1 << 32 - int_6;
                  if ((int_8 & int_7) != 0) {
                     ints_1[int_6] = ints_1[int_6 - 1];
                     break;
                  }

                  ints_1[int_6] = int_8 | int_7;
               }
            }

            ints_1[int_1] = int_5;

            for (int_6 = int_1 + 1; int_6 <= 32; int_6++) {
               int_8 = ints_1[int_6];
               if (int_8 == int_4) {
                  ints_1[int_6] = int_5;
               }
            }
         }
      }

      this.anIntArray32 = new int[8];
      int int_2 = 0;

      for (int_0 = 0; int_0 < this.entries; int_0++) {
         int_1 = this.entryLengths[int_0];
         if (int_1 != 0) {
            int_3 = ints_0[int_0];
            int_4 = 0;

            for (int_5 = 0; int_5 < int_1; int_5++) {
               int_6 = Integer.MIN_VALUE >>> int_5;
               if ((int_3 & int_6) != 0) {
                  if (this.anIntArray32[int_4] == 0) {
                     this.anIntArray32[int_4] = int_2;
                  }

                  int_4 = this.anIntArray32[int_4];
               } else {
                  ++int_4;
               }

               if (int_4 >= this.anIntArray32.length) {
                  int[] ints_2 = new int[this.anIntArray32.length * 2];

                  for (int_7 = 0; int_7 < this.anIntArray32.length; int_7++) {
                     ints_2[int_7] = this.anIntArray32[int_7];
                  }

                  this.anIntArray32 = ints_2;
               }

               int_6 >>>= 1;
            }

            this.anIntArray32[int_4] = ~int_0;
            if (int_4 >= int_2) {
               int_2 = int_4 + 1;
            }
         }
      }

   }

   static int method324(int int_0, int int_1) {
      int int_2 = (int)Math.pow((double)int_0, 1.0D / (double)int_1) + 1;

      while (true) {
         int int_3 = int_2;
         int int_4 = int_1;

         int int_5;
         for (int_5 = 1; int_4 > 1; int_4 >>= 1) {
            if ((int_4 & 0x1) != 0) {
               int_5 *= int_3;
            }

            int_3 *= int_3;
         }

         int int_6;
         if (int_4 == 1) {
            int_6 = int_3 * int_5;
         } else {
            int_6 = int_5;
         }

         if (int_6 <= int_0) {
            return int_2;
         }

         --int_2;
      }
   }

}
