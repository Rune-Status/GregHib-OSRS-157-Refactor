public class Residue {

   int classBook;
   int end;
   int type;
   int begin;
   int partitionSize;
   int[] anIntArray63;
   int classification;

   Residue() {
      this.type = Node_Sub2.getInt(16);
      this.begin = Node_Sub2.getInt(24);
      this.end = Node_Sub2.getInt(24);
      this.partitionSize = Node_Sub2.getInt(24) + 1;
      this.classification = Node_Sub2.getInt(6) + 1;
      this.classBook = Node_Sub2.getInt(8);
      int[] ints_0 = new int[this.classification];

      int int_0;
      for (int_0 = 0; int_0 < this.classification; int_0++) {
         int int_1 = 0;
         int int_2 = Node_Sub2.getInt(3);
         boolean bool_0 = Node_Sub2.getBit() != 0;
         if (bool_0) {
            int_1 = Node_Sub2.getInt(5);
         }

         ints_0[int_0] = int_1 << 3 | int_2;
      }

      this.anIntArray63 = new int[this.classification * 8];

      for (int_0 = 0; int_0 < this.classification * 8; int_0++) {
         this.anIntArray63[int_0] = (ints_0[int_0 >> 3] & 1 << (int_0 & 0x7)) != 0 ? Node_Sub2.getInt(8) : -1;
      }

   }

   void decodeResidue(float[] floats_0, int int_0, boolean bool_0) {
      int int_1;
      for (int_1 = 0; int_1 < int_0; int_1++) {
         floats_0[int_1] = 0.0F;
      }

      if (!bool_0) {
         int_1 = Node_Sub2.codeBooks[this.classBook].dimensions;
         int int_2 = this.end - this.begin;
         int int_3 = int_2 / this.partitionSize;
         int[] ints_0 = new int[int_3];

         for (int int_4 = 0; int_4 < 8; int_4++) {
            int int_5 = 0;

            while (int_5 < int_3) {
               int int_6;
               int int_7;
               if (int_4 == 0) {
                  int_6 = Node_Sub2.codeBooks[this.classBook].getHuffmanRoot();

                  for (int_7 = int_1 - 1; int_7 >= 0; --int_7) {
                     if (int_5 + int_7 < int_3) {
                        ints_0[int_5 + int_7] = int_6 % this.classification;
                     }

                     int_6 /= this.classification;
                  }
               }

               for (int_6 = 0; int_6 < int_1; int_6++) {
                  int_7 = ints_0[int_5];
                  int int_8 = this.anIntArray63[int_4 + int_7 * 8];
                  if (int_8 >= 0) {
                     int int_9 = int_5 * this.partitionSize + this.begin;
                     CodeBook codebook_0 = Node_Sub2.codeBooks[int_8];
                     int int_10;
                     if (this.type == 0) {
                        int_10 = this.partitionSize / codebook_0.dimensions;

                        for (int int_11 = 0; int_11 < int_10; int_11++) {
                           float[] floats_1 = codebook_0.method323();

                           for (int int_12 = 0; int_12 < codebook_0.dimensions; int_12++) {
                              floats_0[int_9 + int_11 + int_12 * int_10] += floats_1[int_12];
                           }
                        }
                     } else {
                        int_10 = 0;

                        while (int_10 < this.partitionSize) {
                           float[] floats_2 = codebook_0.method323();

                           for (int int_13 = 0; int_13 < codebook_0.dimensions; int_13++) {
                              floats_0[int_9 + int_10] += floats_2[int_13];
                              ++int_10;
                           }
                        }
                     }
                  }

                  ++int_5;
                  if (int_5 >= int_3) {
                     break;
                  }
               }
            }
         }

      }
   }

}
