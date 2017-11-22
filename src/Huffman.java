public class Huffman {

   static Class106 aClass106_4;
   int[] masks;
   byte[] bits;
   int[] keys;

   public Huffman(byte[] bytes_0) {
      int int_0 = bytes_0.length;
      this.masks = new int[int_0];
      this.bits = bytes_0;
      int[] ints_0 = new int[33];
      this.keys = new int[8];
      int int_1 = 0;

      for (int int_2 = 0; int_2 < int_0; int_2++) {
         byte byte_0 = bytes_0[int_2];
         if (byte_0 != 0) {
            int int_3 = 1 << 32 - byte_0;
            int int_4 = ints_0[byte_0];
            this.masks[int_2] = int_4;
            int int_5;
            int int_6;
            int int_7;
            int int_8;
            if ((int_4 & int_3) != 0) {
               int_5 = ints_0[byte_0 - 1];
            } else {
               int_5 = int_4 | int_3;

               for (int_6 = byte_0 - 1; int_6 >= 1; --int_6) {
                  int_7 = ints_0[int_6];
                  if (int_7 != int_4) {
                     break;
                  }

                  int_8 = 1 << 32 - int_6;
                  if ((int_7 & int_8) != 0) {
                     ints_0[int_6] = ints_0[int_6 - 1];
                     break;
                  }

                  ints_0[int_6] = int_7 | int_8;
               }
            }

            ints_0[byte_0] = int_5;

            for (int_6 = byte_0 + 1; int_6 <= 32; int_6++) {
               if (int_4 == ints_0[int_6]) {
                  ints_0[int_6] = int_5;
               }
            }

            int_6 = 0;

            for (int_7 = 0; int_7 < byte_0; int_7++) {
               int_8 = Integer.MIN_VALUE >>> int_7;
               if ((int_4 & int_8) != 0) {
                  if (this.keys[int_6] == 0) {
                     this.keys[int_6] = int_1;
                  }

                  int_6 = this.keys[int_6];
               } else {
                  ++int_6;
               }

               if (int_6 >= this.keys.length) {
                  int[] ints_1 = new int[this.keys.length * 2];

                  for (int int_9 = 0; int_9 < this.keys.length; int_9++) {
                     ints_1[int_9] = this.keys[int_9];
                  }

                  this.keys = ints_1;
               }

               int_8 >>>= 1;
            }

            this.keys[int_6] = ~int_2;
            if (int_6 >= int_1) {
               int_1 = int_6 + 1;
            }
         }
      }

   }

   public int decompress(byte[] bytes_0, int int_0, byte[] bytes_1, int int_1, int int_2) {
      if (int_2 == 0) {
         return 0;
      } else {
         int int_3 = 0;
         int_2 += int_1;
         int int_4 = int_0;

         while (true) {
            byte byte_0 = bytes_0[int_4];
            if (byte_0 < 0) {
               int_3 = this.keys[int_3];
            } else {
               ++int_3;
            }

            int int_5;
            if ((int_5 = this.keys[int_3]) < 0) {
               bytes_1[int_1++] = (byte)(~int_5);
               if (int_1 >= int_2) {
                  break;
               }

               int_3 = 0;
            }

            if ((byte_0 & 0x40) != 0) {
               int_3 = this.keys[int_3];
            } else {
               ++int_3;
            }

            if ((int_5 = this.keys[int_3]) < 0) {
               bytes_1[int_1++] = (byte)(~int_5);
               if (int_1 >= int_2) {
                  break;
               }

               int_3 = 0;
            }

            if ((byte_0 & 0x20) != 0) {
               int_3 = this.keys[int_3];
            } else {
               ++int_3;
            }

            if ((int_5 = this.keys[int_3]) < 0) {
               bytes_1[int_1++] = (byte)(~int_5);
               if (int_1 >= int_2) {
                  break;
               }

               int_3 = 0;
            }

            if ((byte_0 & 0x10) != 0) {
               int_3 = this.keys[int_3];
            } else {
               ++int_3;
            }

            if ((int_5 = this.keys[int_3]) < 0) {
               bytes_1[int_1++] = (byte)(~int_5);
               if (int_1 >= int_2) {
                  break;
               }

               int_3 = 0;
            }

            if ((byte_0 & 0x8) != 0) {
               int_3 = this.keys[int_3];
            } else {
               ++int_3;
            }

            if ((int_5 = this.keys[int_3]) < 0) {
               bytes_1[int_1++] = (byte)(~int_5);
               if (int_1 >= int_2) {
                  break;
               }

               int_3 = 0;
            }

            if ((byte_0 & 0x4) != 0) {
               int_3 = this.keys[int_3];
            } else {
               ++int_3;
            }

            if ((int_5 = this.keys[int_3]) < 0) {
               bytes_1[int_1++] = (byte)(~int_5);
               if (int_1 >= int_2) {
                  break;
               }

               int_3 = 0;
            }

            if ((byte_0 & 0x2) != 0) {
               int_3 = this.keys[int_3];
            } else {
               ++int_3;
            }

            if ((int_5 = this.keys[int_3]) < 0) {
               bytes_1[int_1++] = (byte)(~int_5);
               if (int_1 >= int_2) {
                  break;
               }

               int_3 = 0;
            }

            if ((byte_0 & 0x1) != 0) {
               int_3 = this.keys[int_3];
            } else {
               ++int_3;
            }

            if ((int_5 = this.keys[int_3]) < 0) {
               bytes_1[int_1++] = (byte)(~int_5);
               if (int_1 >= int_2) {
                  break;
               }

               int_3 = 0;
            }

            ++int_4;
         }

         return int_4 + 1 - int_0;
      }
   }

   public int compress(byte[] bytes_0, int int_0, int int_1, byte[] bytes_1, int int_2) {
      int int_3 = 0;
      int int_4 = int_2 << 3;

      for (int_1 += int_0; int_0 < int_1; int_0++) {
         int int_5 = bytes_0[int_0] & 0xFF;
         int int_6 = this.masks[int_5];
         byte byte_0 = this.bits[int_5];
         if (byte_0 == 0) {
            throw new RuntimeException("");
         }

         int int_7 = int_4 >> 3;
         int int_8 = int_4 & 0x7;
         int_3 &= -int_8 >> 31;
         int int_9 = (int_8 + byte_0 - 1 >> 3) + int_7;
         int_8 += 24;
         bytes_1[int_7] = (byte)(int_3 |= int_6 >>> int_8);
         if (int_7 < int_9) {
            ++int_7;
            int_8 -= 8;
            bytes_1[int_7] = (byte)(int_3 = int_6 >>> int_8);
            if (int_7 < int_9) {
               ++int_7;
               int_8 -= 8;
               bytes_1[int_7] = (byte)(int_3 = int_6 >>> int_8);
               if (int_7 < int_9) {
                  ++int_7;
                  int_8 -= 8;
                  bytes_1[int_7] = (byte)(int_3 = int_6 >>> int_8);
                  if (int_7 < int_9) {
                     ++int_7;
                     int_8 -= 8;
                     bytes_1[int_7] = (byte)(int_3 = int_6 << -int_8);
                  }
               }
            }
         }

         int_4 += byte_0;
      }

      return (int_4 + 7 >> 3) - int_2;
   }

}
