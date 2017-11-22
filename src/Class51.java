public class Class51 {

   public static String userHome;
   int[][] anIntArrayArray9;
   int anInt129;
   int anInt130;

   public Class51(int int_0, int int_1) {
      if (int_1 != int_0) {
         int int_2 = MilliTimer.method741(int_0, int_1);
         int_0 /= int_2;
         int_1 /= int_2;
         this.anInt130 = int_0;
         this.anInt129 = int_1;
         this.anIntArrayArray9 = new int[int_0][14];

         for (int int_3 = 0; int_3 < int_0; int_3++) {
            int[] ints_0 = this.anIntArrayArray9[int_3];
            double double_0 = 6.0D + (double)int_3 / (double)int_0;
            int int_4 = (int)Math.floor(double_0 - 7.0D + 1.0D);
            if (int_4 < 0) {
               int_4 = 0;
            }

            int int_5 = (int)Math.ceil(7.0D + double_0);
            if (int_5 > 14) {
               int_5 = 14;
            }

            for (double double_1 = (double)int_1 / (double)int_0; int_4 < int_5; int_4++) {
               double double_2 = ((double)int_4 - double_0) * 3.141592653589793D;
               double double_3 = double_1;
               if (double_2 < -1.0E-4D || double_2 > 1.0E-4D) {
                  double_3 = double_1 * (Math.sin(double_2) / double_2);
               }

               double_3 *= 0.54D + 0.46D * Math.cos(((double)int_4 - double_0) * 0.2243994752564138D);
               ints_0[int_4] = (int)Math.floor(double_3 * 65536.0D + 0.5D);
            }
         }

      }
   }

   byte[] method325(byte[] bytes_0) {
      if (this.anIntArrayArray9 != null) {
         int int_0 = (int)((long)this.anInt129 * (long)bytes_0.length / (long)this.anInt130) + 14;
         int[] ints_0 = new int[int_0];
         int int_1 = 0;
         int int_2 = 0;

         int int_3;
         for (int_3 = 0; int_3 < bytes_0.length; int_3++) {
            byte byte_0 = bytes_0[int_3];
            int[] ints_1 = this.anIntArrayArray9[int_2];

            int int_4;
            for (int_4 = 0; int_4 < 14; int_4++) {
               ints_0[int_1 + int_4] += ints_1[int_4] * byte_0;
            }

            int_2 += this.anInt129;
            int_4 = int_2 / this.anInt130;
            int_1 += int_4;
            int_2 -= int_4 * this.anInt130;
         }

         bytes_0 = new byte[int_0];

         for (int_3 = 0; int_3 < int_0; int_3++) {
            int int_5 = ints_0[int_3] + 32768 >> 16;
            if (int_5 < -128) {
               bytes_0[int_3] = -128;
            } else if (int_5 > 127) {
               bytes_0[int_3] = 127;
            } else {
               bytes_0[int_3] = (byte)int_5;
            }
         }
      }

      return bytes_0;
   }

   int method326(int int_0) {
      if (this.anIntArrayArray9 != null) {
         int_0 = (int)((long)this.anInt129 * (long)int_0 / (long)this.anInt130);
      }

      return int_0;
   }

   int method327(int int_0) {
      if (this.anIntArrayArray9 != null) {
         int_0 = (int)((long)this.anInt129 * (long)int_0 / (long)this.anInt130) + 6;
      }

      return int_0;
   }

   static int method328(int int_0, int int_1, int int_2) {
      int int_3 = 256 - int_2;
      return ((int_1 & 0xFF00FF) * int_2 + int_3 * (int_0 & 0xFF00FF) & 0xFF00FF00) + ((int_0 & 0xFF00) * int_3 + (int_1 & 0xFF00) * int_2 & 0xFF0000) >> 8;
   }

   public static boolean method329(int int_0, int int_1) {
      return (int_0 >> int_1 + 1 & 0x1) != 0;
   }

}
