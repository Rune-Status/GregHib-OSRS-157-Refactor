public class Class68_Sub1 extends Class68 {

   public static BufferProvider aBufferProvider1;
   int anInt311;
   String aString17;
   short aShort1;

   Class68_Sub1(String string_0, int int_0) {
      this.anInt311 = (int)(Class97.currentTimeMs() / 1000L);
      this.aString17 = string_0;
      this.aShort1 = (short)int_0;
   }

   static void drawStatusBox(String string_0, boolean bool_0) {
      byte byte_0 = 4;
      int int_0 = byte_0 + 6;
      int int_1 = byte_0 + 6;
      int int_2 = Class4.font_p12full.method1038(string_0, 250);
      int int_3 = Class4.font_p12full.method1035(string_0, 250) * 13;
      Rasterizer2D.method919(int_0 - byte_0, int_1 - byte_0, byte_0 + int_2 + byte_0, byte_0 + int_3 + byte_0, 0);
      Rasterizer2D.drawRectangle(int_0 - byte_0, int_1 - byte_0, byte_0 + int_2 + byte_0, byte_0 + byte_0 + int_3, 16777215);
      Class4.font_p12full.method1036(string_0, int_0, int_1, int_2, int_3, 16777215, -1, 1, 1, 0);
      AClass1_Sub2.method636(int_0 - byte_0, int_1 - byte_0, byte_0 + byte_0 + int_2, byte_0 + int_3 + byte_0);
      if (bool_0) {
         aBufferProvider1.method499(0, 0);
      } else {
         Class71.method423(int_0, int_1, int_2, int_3);
      }

   }

   static void method623(World[] worlds_0, int int_0, int int_1, int[] ints_0, int[] ints_1) {
      if (int_0 < int_1) {
         int int_2 = int_0 - 1;
         int int_3 = int_1 + 1;
         int int_4 = (int_1 + int_0) / 2;
         World world_0 = worlds_0[int_4];
         worlds_0[int_4] = worlds_0[int_0];
         worlds_0[int_0] = world_0;

         while (int_2 < int_3) {
            boolean bool_0 = true;

            int int_5;
            int int_6;
            int int_7;
            do {
               --int_3;

               for (int_5 = 0; int_5 < 4; int_5++) {
                  if (ints_0[int_5] == 2) {
                     int_6 = worlds_0[int_3].index;
                     int_7 = world_0.index;
                  } else if (ints_0[int_5] == 1) {
                     int_6 = worlds_0[int_3].playerCount;
                     int_7 = world_0.playerCount;
                     if (int_6 == -1 && ints_1[int_5] == 1) {
                        int_6 = 2001;
                     }

                     if (int_7 == -1 && ints_1[int_5] == 1) {
                        int_7 = 2001;
                     }
                  } else if (ints_0[int_5] == 3) {
                     int_6 = worlds_0[int_3].method551() ? 1 : 0;
                     int_7 = world_0.method551() ? 1 : 0;
                  } else {
                     int_6 = worlds_0[int_3].id;
                     int_7 = world_0.id;
                  }

                  if (int_6 != int_7) {
                     if ((ints_1[int_5] != 1 || int_6 <= int_7) && (ints_1[int_5] != 0 || int_6 >= int_7)) {
                        bool_0 = false;
                     }
                     break;
                  }

                  if (int_5 == 3) {
                     bool_0 = false;
                  }
               }
            } while (bool_0);

            bool_0 = true;

            do {
               ++int_2;

               for (int_5 = 0; int_5 < 4; int_5++) {
                  if (ints_0[int_5] == 2) {
                     int_6 = worlds_0[int_2].index;
                     int_7 = world_0.index;
                  } else if (ints_0[int_5] == 1) {
                     int_6 = worlds_0[int_2].playerCount;
                     int_7 = world_0.playerCount;
                     if (int_6 == -1 && ints_1[int_5] == 1) {
                        int_6 = 2001;
                     }

                     if (int_7 == -1 && ints_1[int_5] == 1) {
                        int_7 = 2001;
                     }
                  } else if (ints_0[int_5] == 3) {
                     int_6 = worlds_0[int_2].method551() ? 1 : 0;
                     int_7 = world_0.method551() ? 1 : 0;
                  } else {
                     int_6 = worlds_0[int_2].id;
                     int_7 = world_0.id;
                  }

                  if (int_7 != int_6) {
                     if ((ints_1[int_5] != 1 || int_6 >= int_7) && (ints_1[int_5] != 0 || int_6 <= int_7)) {
                        bool_0 = false;
                     }
                     break;
                  }

                  if (int_5 == 3) {
                     bool_0 = false;
                  }
               }
            } while (bool_0);

            if (int_2 < int_3) {
               World world_1 = worlds_0[int_2];
               worlds_0[int_2] = worlds_0[int_3];
               worlds_0[int_3] = world_1;
            }
         }

         method623(worlds_0, int_0, int_3, ints_0, ints_1);
         method623(worlds_0, int_3 + 1, int_1, ints_0, ints_1);
      }

   }

   static void method624(String[] strings_0, short[] shorts_0, int int_0, int int_1) {
      if (int_0 < int_1) {
         int int_2 = (int_1 + int_0) / 2;
         int int_3 = int_0;
         String string_0 = strings_0[int_2];
         strings_0[int_2] = strings_0[int_1];
         strings_0[int_1] = string_0;
         short short_0 = shorts_0[int_2];
         shorts_0[int_2] = shorts_0[int_1];
         shorts_0[int_1] = short_0;

         for (int int_4 = int_0; int_4 < int_1; int_4++) {
            if (string_0 == null || strings_0[int_4] != null && strings_0[int_4].compareTo(string_0) < (int_4 & 0x1)) {
               String string_1 = strings_0[int_4];
               strings_0[int_4] = strings_0[int_3];
               strings_0[int_3] = string_1;
               short short_1 = shorts_0[int_4];
               shorts_0[int_4] = shorts_0[int_3];
               shorts_0[int_3++] = short_1;
            }
         }

         strings_0[int_1] = strings_0[int_3];
         strings_0[int_3] = string_0;
         shorts_0[int_1] = shorts_0[int_3];
         shorts_0[int_3] = short_0;
         method624(strings_0, shorts_0, int_0, int_3 - 1);
         method624(strings_0, shorts_0, int_3 + 1, int_1);
      }

   }

}
