public class SoundEffect3 {

   static float[][] minimisedCoefficients;
   static int[][] coefficients;
   static float fowardMinimisedCoefficientMultiplier;
   static int fowardMultiplier;
   int[][][] phases;
   int[][][] magnitudes;
   int[] unity;
   int[] pairs;

   static {
      minimisedCoefficients = new float[2][8];
      coefficients = new int[2][8];
   }

   SoundEffect3() {
      this.pairs = new int[2];
      this.phases = new int[2][2][4];
      this.magnitudes = new int[2][2][4];
      this.unity = new int[2];
   }

   float interpolateMagniture(int int_0, int int_1, float float_0) {
      float float_1 = (float)this.magnitudes[int_0][0][int_1] + float_0 * (float)(this.magnitudes[int_0][1][int_1] - this.magnitudes[int_0][0][int_1]);
      float_1 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-float_1 / 20.0F));
   }

   float interpolatePhase(int int_0, int int_1, float float_0) {
      float float_1 = (float)this.phases[int_0][0][int_1] + float_0 * (float)(this.phases[int_0][1][int_1] - this.phases[int_0][0][int_1]);
      float_1 *= 1.2207031E-4F;
      return normalise(float_1);
   }

   int compute(int int_0, float float_0) {
      float float_1;
      if (int_0 == 0) {
         float_1 = (float)this.unity[0] + (float)(this.unity[1] - this.unity[0]) * float_0;
         float_1 *= 0.0030517578F;
         fowardMinimisedCoefficientMultiplier = (float)Math.pow(0.1D, (double)(float_1 / 20.0F));
         fowardMultiplier = (int)(fowardMinimisedCoefficientMultiplier * 65536.0F);
      }

      if (this.pairs[int_0] == 0) {
         return 0;
      } else {
         float_1 = this.interpolateMagniture(int_0, 0, float_0);
         minimisedCoefficients[int_0][0] = -2.0F * float_1 * (float)Math.cos((double)this.interpolatePhase(int_0, 0, float_0));
         minimisedCoefficients[int_0][1] = float_1 * float_1;

         int int_1;
         for (int_1 = 1; int_1 < this.pairs[int_0]; int_1++) {
            float_1 = this.interpolateMagniture(int_0, int_1, float_0);
            float float_2 = -2.0F * float_1 * (float)Math.cos((double)this.interpolatePhase(int_0, int_1, float_0));
            float float_3 = float_1 * float_1;
            minimisedCoefficients[int_0][int_1 * 2 + 1] = minimisedCoefficients[int_0][int_1 * 2 - 1] * float_3;
            minimisedCoefficients[int_0][int_1 * 2] = minimisedCoefficients[int_0][int_1 * 2 - 1] * float_2 + minimisedCoefficients[int_0][int_1 * 2 - 2] * float_3;

            for (int int_2 = int_1 * 2 - 1; int_2 >= 2; --int_2) {
               minimisedCoefficients[int_0][int_2] += minimisedCoefficients[int_0][int_2 - 1] * float_2 + minimisedCoefficients[int_0][int_2 - 2] * float_3;
            }

            minimisedCoefficients[int_0][1] += minimisedCoefficients[int_0][0] * float_2 + float_3;
            minimisedCoefficients[int_0][0] += float_2;
         }

         if (int_0 == 0) {
            for (int_1 = 0; int_1 < this.pairs[0] * 2; int_1++) {
               minimisedCoefficients[0][int_1] *= fowardMinimisedCoefficientMultiplier;
            }
         }

         for (int_1 = 0; int_1 < this.pairs[int_0] * 2; int_1++) {
            coefficients[int_0][int_1] = (int)(minimisedCoefficients[int_0][int_1] * 65536.0F);
         }

         return this.pairs[int_0] * 2;
      }
   }

   void decode(Buffer buffer_0, AudioEnvelope audioenvelope_0) {
      int int_0 = buffer_0.readUnsignedByte();
      this.pairs[0] = int_0 >> 4;
      this.pairs[1] = int_0 & 0xF;
      if (int_0 != 0) {
         this.unity[0] = buffer_0.readUnsignedShort();
         this.unity[1] = buffer_0.readUnsignedShort();
         int int_1 = buffer_0.readUnsignedByte();

         int int_2;
         int int_3;
         for (int_2 = 0; int_2 < 2; int_2++) {
            for (int_3 = 0; int_3 < this.pairs[int_2]; int_3++) {
               this.phases[int_2][0][int_3] = buffer_0.readUnsignedShort();
               this.magnitudes[int_2][0][int_3] = buffer_0.readUnsignedShort();
            }
         }

         for (int_2 = 0; int_2 < 2; int_2++) {
            for (int_3 = 0; int_3 < this.pairs[int_2]; int_3++) {
               if ((int_1 & 1 << int_2 * 4 << int_3) != 0) {
                  this.phases[int_2][1][int_3] = buffer_0.readUnsignedShort();
                  this.magnitudes[int_2][1][int_3] = buffer_0.readUnsignedShort();
               } else {
                  this.phases[int_2][1][int_3] = this.phases[int_2][0][int_3];
                  this.magnitudes[int_2][1][int_3] = this.magnitudes[int_2][0][int_3];
               }
            }
         }

         if (int_1 != 0 || this.unity[1] != this.unity[0]) {
            audioenvelope_0.decodeSegments(buffer_0);
         }
      } else {
         int[] ints_0 = this.unity;
         this.unity[1] = 0;
         ints_0[0] = 0;
      }

   }

   static float normalise(float float_0) {
      float float_1 = 32.703197F * (float)Math.pow(2.0D, (double)float_0);
      return float_1 * 3.1415927F / 11025.0F;
   }

}
