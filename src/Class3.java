public class Class3 {

   static Task socket;
   public static Class52 aClass52_1;
   static IndexData interfaceScriptDataIndex;
   static int anInt22;
   int anInt23;
   int anInt24;
   int[][] anIntArrayArray1;
   int[][] anIntArrayArray2;
   int[][] anIntArrayArray3;
   int[][] anIntArrayArray4;

   Class3(int int_0, int int_1) {
      this.anInt23 = int_0;
      this.anInt24 = int_1;
      this.anIntArrayArray1 = new int[int_0][int_1];
      this.anIntArrayArray3 = new int[int_0][int_1];
      this.anIntArrayArray2 = new int[int_0][int_1];
      this.anIntArrayArray4 = new int[int_0][int_1];
   }

   int method79(int int_0, int int_1) {
      if (int_0 >= 0 && int_1 >= 0 && int_0 < this.anInt23 && int_1 < this.anInt24) {
         if (this.anIntArrayArray2[int_0][int_1] == 0) {
            return 0;
         } else {
            int int_2 = this.anIntArrayArray1[int_0][int_1] / this.anIntArrayArray4[int_0][int_1];
            int int_3 = this.anIntArrayArray3[int_0][int_1] / this.anIntArrayArray4[int_0][int_1];
            int int_4 = this.anIntArrayArray2[int_0][int_1] / this.anIntArrayArray4[int_0][int_1];
            double double_0 = (double)int_2 / 256.0D;
            double double_1 = (double)int_3 / 256.0D;
            double double_2 = (double)int_4 / 256.0D;
            double double_3 = double_2;
            double double_4 = double_2;
            double double_5 = double_2;
            if (double_1 != 0.0D) {
               double double_6;
               if (double_2 < 0.5D) {
                  double_6 = (1.0D + double_1) * double_2;
               } else {
                  double_6 = double_1 + double_2 - double_2 * double_1;
               }

               double double_7 = double_2 * 2.0D - double_6;
               double double_8 = 0.3333333333333333D + double_0;
               if (double_8 > 1.0D) {
                  --double_8;
               }

               double double_9 = double_0 - 0.3333333333333333D;
               if (double_9 < 0.0D) {
                  ++double_9;
               }

               if (6.0D * double_8 < 1.0D) {
                  double_3 = double_7 + 6.0D * (double_6 - double_7) * double_8;
               } else if (double_8 * 2.0D < 1.0D) {
                  double_3 = double_6;
               } else if (double_8 * 3.0D < 2.0D) {
                  double_3 = double_7 + 6.0D * (0.6666666666666666D - double_8) * (double_6 - double_7);
               } else {
                  double_3 = double_7;
               }

               if (6.0D * double_0 < 1.0D) {
                  double_4 = 6.0D * (double_6 - double_7) * double_0 + double_7;
               } else if (double_0 * 2.0D < 1.0D) {
                  double_4 = double_6;
               } else if (3.0D * double_0 < 2.0D) {
                  double_4 = double_7 + (0.6666666666666666D - double_0) * (double_6 - double_7) * 6.0D;
               } else {
                  double_4 = double_7;
               }

               if (double_9 * 6.0D < 1.0D) {
                  double_5 = 6.0D * (double_6 - double_7) * double_9 + double_7;
               } else if (2.0D * double_9 < 1.0D) {
                  double_5 = double_6;
               } else if (3.0D * double_9 < 2.0D) {
                  double_5 = 6.0D * (double_6 - double_7) * (0.6666666666666666D - double_9) + double_7;
               } else {
                  double_5 = double_7;
               }
            }

            int int_5 = (int)(double_3 * 256.0D);
            int int_6 = (int)(double_4 * 256.0D);
            int int_7 = (int)(double_5 * 256.0D);
            int int_8 = int_7 + (int_6 << 8) + (int_5 << 16);
            return int_8;
         }
      } else {
         return 0;
      }
   }

   void method80(int int_0, int int_1, int int_2, FloorUnderlayDefinition floorunderlaydefinition_0) {
      if (floorunderlaydefinition_0 != null) {
         if (int_2 + int_0 >= 0 && int_2 + int_1 >= 0) {
            if (int_0 - int_2 <= this.anInt23 && int_1 - int_2 <= this.anInt24) {
               int int_3 = Math.max(0, int_0 - int_2);
               int int_4 = Math.min(this.anInt23, int_2 + int_0);
               int int_5 = Math.max(0, int_1 - int_2);
               int int_6 = Math.min(this.anInt24, int_2 + int_1);

               for (int int_7 = int_3; int_7 < int_4; int_7++) {
                  for (int int_8 = int_5; int_8 < int_6; int_8++) {
                     this.anIntArrayArray1[int_7][int_8] += floorunderlaydefinition_0.hue * 256 / floorunderlaydefinition_0.hueMultiplier;
                     this.anIntArrayArray3[int_7][int_8] += floorunderlaydefinition_0.saturation;
                     this.anIntArrayArray2[int_7][int_8] += floorunderlaydefinition_0.lightness;
                     ++this.anIntArrayArray4[int_7][int_8];
                  }
               }

            }
         }
      }
   }

}
