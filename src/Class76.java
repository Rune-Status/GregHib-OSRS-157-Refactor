public class Class76 {

   public static void method449(int[] ints_0, int int_0, int int_1) {
      for (int_1 = int_1 + int_0 - 7; int_0 < int_1; ints_0[int_0++] = 0) {
         ints_0[int_0++] = 0;
         ints_0[int_0++] = 0;
         ints_0[int_0++] = 0;
         ints_0[int_0++] = 0;
         ints_0[int_0++] = 0;
         ints_0[int_0++] = 0;
         ints_0[int_0++] = 0;
      }

      for (int_1 += 7; int_0 < int_1; ints_0[int_0++] = 0) {
         ;
      }

   }

   public static void method450(byte[] bytes_0, int int_0, byte[] bytes_1, int int_1, int int_2) {
      if (bytes_1 == bytes_0) {
         if (int_1 == int_0) {
            return;
         }

         if (int_1 > int_0 && int_1 < int_2 + int_0) {
            --int_2;
            int_0 += int_2;
            int_1 += int_2;
            int_2 = int_0 - int_2;

            for (int_2 += 7; int_0 >= int_2; bytes_1[int_1--] = bytes_0[int_0--]) {
               bytes_1[int_1--] = bytes_0[int_0--];
               bytes_1[int_1--] = bytes_0[int_0--];
               bytes_1[int_1--] = bytes_0[int_0--];
               bytes_1[int_1--] = bytes_0[int_0--];
               bytes_1[int_1--] = bytes_0[int_0--];
               bytes_1[int_1--] = bytes_0[int_0--];
               bytes_1[int_1--] = bytes_0[int_0--];
            }

            for (int_2 -= 7; int_0 >= int_2; bytes_1[int_1--] = bytes_0[int_0--]) {
               ;
            }

            return;
         }
      }

      int_2 += int_0;

      for (int_2 -= 7; int_0 < int_2; bytes_1[int_1++] = bytes_0[int_0++]) {
         bytes_1[int_1++] = bytes_0[int_0++];
         bytes_1[int_1++] = bytes_0[int_0++];
         bytes_1[int_1++] = bytes_0[int_0++];
         bytes_1[int_1++] = bytes_0[int_0++];
         bytes_1[int_1++] = bytes_0[int_0++];
         bytes_1[int_1++] = bytes_0[int_0++];
         bytes_1[int_1++] = bytes_0[int_0++];
      }

      for (int_2 += 7; int_0 < int_2; bytes_1[int_1++] = bytes_0[int_0++]) {
         ;
      }

   }

}
