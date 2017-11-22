public class Class5 {

   public static IndexDataBase widgetIndex;
   byte[][][] aByteArrayArrayArray1;
   int anInt36;

   Class5(int int_0) {
      this.anInt36 = int_0;
   }

   void method84() {
      byte[] bytes_0 = new byte[this.anInt36 * this.anInt36];
      int int_0 = 0;

      int int_1;
      int int_2;
      for (int_1 = 0; int_1 < this.anInt36; int_1++) {
         for (int_2 = 0; int_2 < this.anInt36; int_2++) {
            if (int_2 <= int_1) {
               bytes_0[int_0] = -1;
            }

            ++int_0;
         }
      }

      this.aByteArrayArrayArray1[0][0] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_0 = 0;

      for (int_1 = this.anInt36 - 1; int_1 >= 0; --int_1) {
         for (int_2 = 0; int_2 < this.anInt36; int_2++) {
            if (int_2 <= int_1) {
               bytes_0[int_0] = -1;
            }

            ++int_0;
         }
      }

      this.aByteArrayArrayArray1[0][1] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_0 = 0;

      for (int_1 = 0; int_1 < this.anInt36; int_1++) {
         for (int_2 = 0; int_2 < this.anInt36; int_2++) {
            if (int_2 >= int_1) {
               bytes_0[int_0] = -1;
            }

            ++int_0;
         }
      }

      this.aByteArrayArrayArray1[0][2] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_0 = 0;

      for (int_1 = this.anInt36 - 1; int_1 >= 0; --int_1) {
         for (int_2 = 0; int_2 < this.anInt36; int_2++) {
            if (int_2 >= int_1) {
               bytes_0[int_0] = -1;
            }

            ++int_0;
         }
      }

      this.aByteArrayArrayArray1[0][3] = bytes_0;
   }

   int method85(int int_0, int int_1) {
      if (int_1 == 9) {
         int_0 = int_0 + 1 & 0x3;
      }

      if (int_1 == 10) {
         int_0 = int_0 + 3 & 0x3;
      }

      if (int_1 == 11) {
         int_0 = int_0 + 3 & 0x3;
      }

      return int_0;
   }

   void method86() {
      byte[] bytes_0 = new byte[this.anInt36 * this.anInt36];
      int int_0 = 0;

      int int_1;
      int int_2;
      for (int_1 = this.anInt36 - 1; int_1 >= 0; --int_1) {
         for (int_2 = 0; int_2 < this.anInt36; int_2++) {
            if (int_2 <= int_1 >> 1) {
               bytes_0[int_0] = -1;
            }

            ++int_0;
         }
      }

      this.aByteArrayArrayArray1[1][0] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_0 = 0;

      for (int_1 = 0; int_1 < this.anInt36; int_1++) {
         for (int_2 = 0; int_2 < this.anInt36; int_2++) {
            if (int_0 >= 0 && int_0 < bytes_0.length) {
               if (int_2 >= int_1 << 1) {
                  bytes_0[int_0] = -1;
               }

               ++int_0;
            } else {
               ++int_0;
            }
         }
      }

      this.aByteArrayArrayArray1[1][1] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_0 = 0;

      for (int_1 = 0; int_1 < this.anInt36; int_1++) {
         for (int_2 = this.anInt36 - 1; int_2 >= 0; --int_2) {
            if (int_2 <= int_1 >> 1) {
               bytes_0[int_0] = -1;
            }

            ++int_0;
         }
      }

      this.aByteArrayArrayArray1[1][2] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_0 = 0;

      for (int_1 = this.anInt36 - 1; int_1 >= 0; --int_1) {
         for (int_2 = this.anInt36 - 1; int_2 >= 0; --int_2) {
            if (int_2 >= int_1 << 1) {
               bytes_0[int_0] = -1;
            }

            ++int_0;
         }
      }

      this.aByteArrayArrayArray1[1][3] = bytes_0;
   }

   int method87(int int_0) {
      return int_0 != 9 && int_0 != 10 ? (int_0 == 11 ? 8 : int_0) : 1;
   }

   void method88() {
      byte[] bytes_0 = new byte[this.anInt36 * this.anInt36];
      int int_0 = 0;

      int int_1;
      int int_2;
      for (int_1 = this.anInt36 - 1; int_1 >= 0; --int_1) {
         for (int_2 = this.anInt36 - 1; int_2 >= 0; --int_2) {
            if (int_2 <= int_1 >> 1) {
               bytes_0[int_0] = -1;
            }

            ++int_0;
         }
      }

      this.aByteArrayArrayArray1[2][0] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_0 = 0;

      for (int_1 = this.anInt36 - 1; int_1 >= 0; --int_1) {
         for (int_2 = 0; int_2 < this.anInt36; int_2++) {
            if (int_2 >= int_1 << 1) {
               bytes_0[int_0] = -1;
            }

            ++int_0;
         }
      }

      this.aByteArrayArrayArray1[2][1] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_0 = 0;

      for (int_1 = 0; int_1 < this.anInt36; int_1++) {
         for (int_2 = 0; int_2 < this.anInt36; int_2++) {
            if (int_2 <= int_1 >> 1) {
               bytes_0[int_0] = -1;
            }

            ++int_0;
         }
      }

      this.aByteArrayArrayArray1[2][2] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_0 = 0;

      for (int_1 = 0; int_1 < this.anInt36; int_1++) {
         for (int_2 = this.anInt36 - 1; int_2 >= 0; --int_2) {
            if (int_2 >= int_1 << 1) {
               bytes_0[int_0] = -1;
            }

            ++int_0;
         }
      }

      this.aByteArrayArrayArray1[2][3] = bytes_0;
   }

   void method89() {
      byte[] bytes_0 = new byte[this.anInt36 * this.anInt36];
      int int_0 = 0;

      int int_1;
      int int_2;
      for (int_1 = this.anInt36 - 1; int_1 >= 0; --int_1) {
         for (int_2 = 0; int_2 < this.anInt36; int_2++) {
            if (int_2 >= int_1 >> 1) {
               bytes_0[int_0] = -1;
            }

            ++int_0;
         }
      }

      this.aByteArrayArrayArray1[3][0] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_0 = 0;

      for (int_1 = 0; int_1 < this.anInt36; int_1++) {
         for (int_2 = 0; int_2 < this.anInt36; int_2++) {
            if (int_2 <= int_1 << 1) {
               bytes_0[int_0] = -1;
            }

            ++int_0;
         }
      }

      this.aByteArrayArrayArray1[3][1] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_0 = 0;

      for (int_1 = 0; int_1 < this.anInt36; int_1++) {
         for (int_2 = this.anInt36 - 1; int_2 >= 0; --int_2) {
            if (int_2 >= int_1 >> 1) {
               bytes_0[int_0] = -1;
            }

            ++int_0;
         }
      }

      this.aByteArrayArrayArray1[3][2] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_0 = 0;

      for (int_1 = this.anInt36 - 1; int_1 >= 0; --int_1) {
         for (int_2 = this.anInt36 - 1; int_2 >= 0; --int_2) {
            if (int_2 <= int_1 << 1) {
               bytes_0[int_0] = -1;
            }

            ++int_0;
         }
      }

      this.aByteArrayArrayArray1[3][3] = bytes_0;
   }

   void method90() {
      byte[] bytes_0 = new byte[this.anInt36 * this.anInt36];
      int int_0 = 0;

      int int_1;
      int int_2;
      for (int_1 = this.anInt36 - 1; int_1 >= 0; --int_1) {
         for (int_2 = this.anInt36 - 1; int_2 >= 0; --int_2) {
            if (int_2 >= int_1 >> 1) {
               bytes_0[int_0] = -1;
            }

            ++int_0;
         }
      }

      this.aByteArrayArrayArray1[4][0] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_0 = 0;

      for (int_1 = this.anInt36 - 1; int_1 >= 0; --int_1) {
         for (int_2 = 0; int_2 < this.anInt36; int_2++) {
            if (int_2 <= int_1 << 1) {
               bytes_0[int_0] = -1;
            }

            ++int_0;
         }
      }

      this.aByteArrayArrayArray1[4][1] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_0 = 0;

      for (int_1 = 0; int_1 < this.anInt36; int_1++) {
         for (int_2 = 0; int_2 < this.anInt36; int_2++) {
            if (int_2 >= int_1 >> 1) {
               bytes_0[int_0] = -1;
            }

            ++int_0;
         }
      }

      this.aByteArrayArrayArray1[4][2] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_0 = 0;

      for (int_1 = 0; int_1 < this.anInt36; int_1++) {
         for (int_2 = this.anInt36 - 1; int_2 >= 0; --int_2) {
            if (int_2 <= int_1 << 1) {
               bytes_0[int_0] = -1;
            }

            ++int_0;
         }
      }

      this.aByteArrayArrayArray1[4][3] = bytes_0;
   }

   void method91() {
      byte[] bytes_0 = new byte[this.anInt36 * this.anInt36];
      boolean bool_0 = false;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int int_2 = 0;

      int int_0;
      int int_1;
      for (int_0 = 0; int_0 < this.anInt36; int_0++) {
         for (int_1 = 0; int_1 < this.anInt36; int_1++) {
            if (int_1 <= this.anInt36 / 2) {
               bytes_0[int_2] = -1;
            }

            ++int_2;
         }
      }

      this.aByteArrayArrayArray1[5][0] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_2 = 0;

      for (int_0 = 0; int_0 < this.anInt36; int_0++) {
         for (int_1 = 0; int_1 < this.anInt36; int_1++) {
            if (int_0 <= this.anInt36 / 2) {
               bytes_0[int_2] = -1;
            }

            ++int_2;
         }
      }

      this.aByteArrayArrayArray1[5][1] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_2 = 0;

      for (int_0 = 0; int_0 < this.anInt36; int_0++) {
         for (int_1 = 0; int_1 < this.anInt36; int_1++) {
            if (int_1 >= this.anInt36 / 2) {
               bytes_0[int_2] = -1;
            }

            ++int_2;
         }
      }

      this.aByteArrayArrayArray1[5][2] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_2 = 0;

      for (int_0 = 0; int_0 < this.anInt36; int_0++) {
         for (int_1 = 0; int_1 < this.anInt36; int_1++) {
            if (int_0 >= this.anInt36 / 2) {
               bytes_0[int_2] = -1;
            }

            ++int_2;
         }
      }

      this.aByteArrayArrayArray1[5][3] = bytes_0;
   }

   void method92() {
      byte[] bytes_0 = new byte[this.anInt36 * this.anInt36];
      boolean bool_0 = false;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int int_2 = 0;

      int int_0;
      int int_1;
      for (int_0 = 0; int_0 < this.anInt36; int_0++) {
         for (int_1 = 0; int_1 < this.anInt36; int_1++) {
            if (int_1 <= int_0 - this.anInt36 / 2) {
               bytes_0[int_2] = -1;
            }

            ++int_2;
         }
      }

      this.aByteArrayArrayArray1[6][0] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_2 = 0;

      for (int_0 = this.anInt36 - 1; int_0 >= 0; --int_0) {
         for (int_1 = 0; int_1 < this.anInt36; int_1++) {
            if (int_1 <= int_0 - this.anInt36 / 2) {
               bytes_0[int_2] = -1;
            }

            ++int_2;
         }
      }

      this.aByteArrayArrayArray1[6][1] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_2 = 0;

      for (int_0 = this.anInt36 - 1; int_0 >= 0; --int_0) {
         for (int_1 = this.anInt36 - 1; int_1 >= 0; --int_1) {
            if (int_1 <= int_0 - this.anInt36 / 2) {
               bytes_0[int_2] = -1;
            }

            ++int_2;
         }
      }

      this.aByteArrayArrayArray1[6][2] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_2 = 0;

      for (int_0 = 0; int_0 < this.anInt36; int_0++) {
         for (int_1 = this.anInt36 - 1; int_1 >= 0; --int_1) {
            if (int_1 <= int_0 - this.anInt36 / 2) {
               bytes_0[int_2] = -1;
            }

            ++int_2;
         }
      }

      this.aByteArrayArrayArray1[6][3] = bytes_0;
   }

   void method93() {
      byte[] bytes_0 = new byte[this.anInt36 * this.anInt36];
      boolean bool_0 = false;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int int_2 = 0;

      int int_0;
      int int_1;
      for (int_0 = 0; int_0 < this.anInt36; int_0++) {
         for (int_1 = 0; int_1 < this.anInt36; int_1++) {
            if (int_1 >= int_0 - this.anInt36 / 2) {
               bytes_0[int_2] = -1;
            }

            ++int_2;
         }
      }

      this.aByteArrayArrayArray1[7][0] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_2 = 0;

      for (int_0 = this.anInt36 - 1; int_0 >= 0; --int_0) {
         for (int_1 = 0; int_1 < this.anInt36; int_1++) {
            if (int_1 >= int_0 - this.anInt36 / 2) {
               bytes_0[int_2] = -1;
            }

            ++int_2;
         }
      }

      this.aByteArrayArrayArray1[7][1] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_2 = 0;

      for (int_0 = this.anInt36 - 1; int_0 >= 0; --int_0) {
         for (int_1 = this.anInt36 - 1; int_1 >= 0; --int_1) {
            if (int_1 >= int_0 - this.anInt36 / 2) {
               bytes_0[int_2] = -1;
            }

            ++int_2;
         }
      }

      this.aByteArrayArrayArray1[7][2] = bytes_0;
      bytes_0 = new byte[this.anInt36 * this.anInt36];
      int_2 = 0;

      for (int_0 = 0; int_0 < this.anInt36; int_0++) {
         for (int_1 = this.anInt36 - 1; int_1 >= 0; --int_1) {
            if (int_1 >= int_0 - this.anInt36 / 2) {
               bytes_0[int_2] = -1;
            }

            ++int_2;
         }
      }

      this.aByteArrayArrayArray1[7][3] = bytes_0;
   }

   void method94() {
      if (this.aByteArrayArrayArray1 == null) {
         this.aByteArrayArrayArray1 = new byte[8][4][];
         this.method84();
         this.method86();
         this.method88();
         this.method89();
         this.method90();
         this.method91();
         this.method92();
         this.method93();
      }
   }

   void method95(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7) {
      if (int_6 != 0 && this.anInt36 != 0 && this.aByteArrayArrayArray1 != null) {
         int_7 = this.method85(int_7, int_6);
         int_6 = this.method87(int_6);
         Rasterizer2D.method922(int_0, int_1, int_4, int_5, int_2, int_3, this.aByteArrayArrayArray1[int_6 - 1][int_7], this.anInt36);
      }
   }

   public static void method96() {
      KeyFocusListener keyfocuslistener_0 = KeyFocusListener.keyboard;
      synchronized(keyfocuslistener_0) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.anInt125 = KeyFocusListener.anInt127;
         KeyFocusListener.anInt126 = 0;
         int int_0;
         if (KeyFocusListener.anInt122 < 0) {
            for (int_0 = 0; int_0 < 112; int_0++) {
               KeyFocusListener.aBoolArray3[int_0] = false;
            }

            KeyFocusListener.anInt122 = KeyFocusListener.anInt123;
         } else {
            while (KeyFocusListener.anInt123 != KeyFocusListener.anInt122) {
               int_0 = KeyFocusListener.anIntArray29[KeyFocusListener.anInt123];
               KeyFocusListener.anInt123 = KeyFocusListener.anInt123 + 1 & 0x7F;
               if (int_0 < 0) {
                  KeyFocusListener.aBoolArray3[~int_0] = false;
               } else {
                  if (!KeyFocusListener.aBoolArray3[int_0] && KeyFocusListener.anInt126 < KeyFocusListener.anIntArray31.length - 1) {
                     KeyFocusListener.anIntArray31[++KeyFocusListener.anInt126 - 1] = int_0;
                  }

                  KeyFocusListener.aBoolArray3[int_0] = true;
               }
            }
         }

         if (KeyFocusListener.anInt126 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.anInt127 = KeyFocusListener.anInt124;
      }
   }

}
