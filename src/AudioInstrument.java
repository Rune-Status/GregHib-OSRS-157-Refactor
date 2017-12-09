import java.util.Random;

public class AudioInstrument {

   static int[] NOISE;
   static int[] samples;
   static int[] SINE;
   static int[] phases;
   static int[] delays;
   static int[] volumeSteps;
   static int[] pitchSteps;
   static int[] pitchBaseSteps;
   AudioEnvelope pitch;
   int[] oscillatorVolume;
   int duration;
   int offset;
   AudioEnvelope volume;
   int[] oscillatorPitch;
   AudioEnvelope pitchModifier;
   AudioEnvelope volumeMultiplier;
   AudioEnvelope pitchModifierAmplitude;
   int[] oscillatorDelays;
   AudioEnvelope volumeMultiplierAmplitude;
   int delayTime;
   int delayDecay;
   AudioEnvelope release;
   AudioEnvelope anAudioEnvelope1;
   SoundEffect3 filter;
   AudioEnvelope filterEnvelope;

   static {
      NOISE = new int[32768];
      Random random_0 = new Random(0L);

      int int_0;
      for (int_0 = 0; int_0 < 32768; int_0++) {
         NOISE[int_0] = (random_0.nextInt() & 0x2) - 1;
      }

      SINE = new int[32768];

      for (int_0 = 0; int_0 < 32768; int_0++) {
         SINE[int_0] = (int)(Math.sin((double)int_0 / 5215.1903D) * 16384.0D);
      }

      samples = new int[220500];
      phases = new int[5];
      delays = new int[5];
      volumeSteps = new int[5];
      pitchSteps = new int[5];
      pitchBaseSteps = new int[5];
   }

   AudioInstrument() {
      this.oscillatorVolume = new int[] {0, 0, 0, 0, 0};
      this.oscillatorPitch = new int[] {0, 0, 0, 0, 0};
      this.oscillatorDelays = new int[] {0, 0, 0, 0, 0};
      this.delayTime = 0;
      this.delayDecay = 100;
      this.duration = 500;
      this.offset = 0;
   }

   void decode(Buffer buffer_0) {
      this.pitch = new AudioEnvelope();
      this.pitch.decode(buffer_0);
      this.volume = new AudioEnvelope();
      this.volume.decode(buffer_0);
      int int_0 = buffer_0.getUnsignedByte();
      if (int_0 != 0) {
         --buffer_0.position;
         this.pitchModifier = new AudioEnvelope();
         this.pitchModifier.decode(buffer_0);
         this.pitchModifierAmplitude = new AudioEnvelope();
         this.pitchModifierAmplitude.decode(buffer_0);
      }

      int_0 = buffer_0.getUnsignedByte();
      if (int_0 != 0) {
         --buffer_0.position;
         this.volumeMultiplier = new AudioEnvelope();
         this.volumeMultiplier.decode(buffer_0);
         this.volumeMultiplierAmplitude = new AudioEnvelope();
         this.volumeMultiplierAmplitude.decode(buffer_0);
      }

      int_0 = buffer_0.getUnsignedByte();
      if (int_0 != 0) {
         --buffer_0.position;
         this.release = new AudioEnvelope();
         this.release.decode(buffer_0);
         this.anAudioEnvelope1 = new AudioEnvelope();
         this.anAudioEnvelope1.decode(buffer_0);
      }

      for (int int_1 = 0; int_1 < 10; int_1++) {
         int int_2 = buffer_0.getUSmart();
         if (int_2 == 0) {
            break;
         }

         this.oscillatorVolume[int_1] = int_2;
         this.oscillatorPitch[int_1] = buffer_0.readShortSmart();
         this.oscillatorDelays[int_1] = buffer_0.getUSmart();
      }

      this.delayTime = buffer_0.getUSmart();
      this.delayDecay = buffer_0.getUSmart();
      this.duration = buffer_0.getUnsignedShort();
      this.offset = buffer_0.getUnsignedShort();
      this.filter = new SoundEffect3();
      this.filterEnvelope = new AudioEnvelope();
      this.filter.decode(buffer_0, this.filterEnvelope);
   }

   int[] synthesize(int int_0, int int_1) {
      Class76.method449(samples, 0, int_0);
      if (int_1 < 10) {
         return samples;
      } else {
         double double_0 = (double)int_0 / ((double)int_1 + 0.0D);
         this.pitch.reset();
         this.volume.reset();
         int int_2 = 0;
         int int_3 = 0;
         int int_4 = 0;
         if (this.pitchModifier != null) {
            this.pitchModifier.reset();
            this.pitchModifierAmplitude.reset();
            int_2 = (int)((double)(this.pitchModifier.end - this.pitchModifier.start) * 32.768D / double_0);
            int_3 = (int)((double)this.pitchModifier.start * 32.768D / double_0);
         }

         int int_5 = 0;
         int int_6 = 0;
         int int_7 = 0;
         if (this.volumeMultiplier != null) {
            this.volumeMultiplier.reset();
            this.volumeMultiplierAmplitude.reset();
            int_5 = (int)((double)(this.volumeMultiplier.end - this.volumeMultiplier.start) * 32.768D / double_0);
            int_6 = (int)((double)this.volumeMultiplier.start * 32.768D / double_0);
         }

         int int_8;
         for (int_8 = 0; int_8 < 5; int_8++) {
            if (this.oscillatorVolume[int_8] != 0) {
               phases[int_8] = 0;
               delays[int_8] = (int)((double)this.oscillatorDelays[int_8] * double_0);
               volumeSteps[int_8] = (this.oscillatorVolume[int_8] << 14) / 100;
               pitchSteps[int_8] = (int)((double)(this.pitch.end - this.pitch.start) * 32.768D * Math.pow(1.0057929410678534D, (double)this.oscillatorPitch[int_8]) / double_0);
               pitchBaseSteps[int_8] = (int)((double)this.pitch.start * 32.768D / double_0);
            }
         }

         int int_9;
         int int_10;
         int int_11;
         int int_12;
         for (int_8 = 0; int_8 < int_0; int_8++) {
            int_9 = this.pitch.step(int_0);
            int_10 = this.volume.step(int_0);
            if (this.pitchModifier != null) {
               int_11 = this.pitchModifier.step(int_0);
               int_12 = this.pitchModifierAmplitude.step(int_0);
               int_9 += this.evaluateWave(int_4, int_12, this.pitchModifier.form) >> 1;
               int_4 = int_4 + int_3 + (int_11 * int_2 >> 16);
            }

            if (this.volumeMultiplier != null) {
               int_11 = this.volumeMultiplier.step(int_0);
               int_12 = this.volumeMultiplierAmplitude.step(int_0);
               int_10 = int_10 * ((this.evaluateWave(int_7, int_12, this.volumeMultiplier.form) >> 1) + 32768) >> 15;
               int_7 = int_7 + int_6 + (int_11 * int_5 >> 16);
            }

            for (int_11 = 0; int_11 < 5; int_11++) {
               if (this.oscillatorVolume[int_11] != 0) {
                  int_12 = delays[int_11] + int_8;
                  if (int_12 < int_0) {
                     samples[int_12] += this.evaluateWave(phases[int_11], int_10 * volumeSteps[int_11] >> 15, this.pitch.form);
                     phases[int_11] += (int_9 * pitchSteps[int_11] >> 16) + pitchBaseSteps[int_11];
                  }
               }
            }
         }

         int int_13;
         if (this.release != null) {
            this.release.reset();
            this.anAudioEnvelope1.reset();
            int_8 = 0;
            boolean bool_0 = false;
            boolean bool_1 = true;

            for (int_11 = 0; int_11 < int_0; int_11++) {
               int_12 = this.release.step(int_0);
               int_13 = this.anAudioEnvelope1.step(int_0);
               if (bool_1) {
                  int_9 = (int_12 * (this.release.end - this.release.start) >> 8) + this.release.start;
               } else {
                  int_9 = (int_13 * (this.release.end - this.release.start) >> 8) + this.release.start;
               }

               int_8 += 256;
               if (int_8 >= int_9) {
                  int_8 = 0;
                  bool_1 = !bool_1;
               }

               if (bool_1) {
                  samples[int_11] = 0;
               }
            }
         }

         if (this.delayTime > 0 && this.delayDecay > 0) {
            int_8 = (int)((double)this.delayTime * double_0);

            for (int_9 = int_8; int_9 < int_0; int_9++) {
               samples[int_9] += samples[int_9 - int_8] * this.delayDecay / 100;
            }
         }

         if (this.filter.pairs[0] > 0 || this.filter.pairs[1] > 0) {
            this.filterEnvelope.reset();
            int_8 = this.filterEnvelope.step(int_0 + 1);
            int_9 = this.filter.compute(0, (float)int_8 / 65536.0F);
            int_10 = this.filter.compute(1, (float)int_8 / 65536.0F);
            if (int_0 >= int_9 + int_10) {
               int_11 = 0;
               int_12 = int_10;
               if (int_10 > int_0 - int_9) {
                  int_12 = int_0 - int_9;
               }

               int int_14;
               while (int_11 < int_12) {
                  int_13 = (int)((long)samples[int_11 + int_9] * (long)SoundEffect3.fowardMultiplier >> 16);

                  for (int_14 = 0; int_14 < int_9; int_14++) {
                     int_13 += (int)((long)samples[int_11 + int_9 - 1 - int_14] * (long)SoundEffect3.coefficients[0][int_14] >> 16);
                  }

                  for (int_14 = 0; int_14 < int_11; int_14++) {
                     int_13 -= (int)((long)samples[int_11 - 1 - int_14] * (long)SoundEffect3.coefficients[1][int_14] >> 16);
                  }

                  samples[int_11] = int_13;
                  int_8 = this.filterEnvelope.step(int_0 + 1);
                  ++int_11;
               }

               int_12 = 128;

               while (true) {
                  if (int_12 > int_0 - int_9) {
                     int_12 = int_0 - int_9;
                  }

                  int int_15;
                  while (int_11 < int_12) {
                     int_14 = (int)((long)samples[int_11 + int_9] * (long)SoundEffect3.fowardMultiplier >> 16);

                     for (int_15 = 0; int_15 < int_9; int_15++) {
                        int_14 += (int)((long)samples[int_11 + int_9 - 1 - int_15] * (long)SoundEffect3.coefficients[0][int_15] >> 16);
                     }

                     for (int_15 = 0; int_15 < int_10; int_15++) {
                        int_14 -= (int)((long)samples[int_11 - 1 - int_15] * (long)SoundEffect3.coefficients[1][int_15] >> 16);
                     }

                     samples[int_11] = int_14;
                     int_8 = this.filterEnvelope.step(int_0 + 1);
                     ++int_11;
                  }

                  if (int_11 >= int_0 - int_9) {
                     while (int_11 < int_0) {
                        int_14 = 0;

                        for (int_15 = int_11 + int_9 - int_0; int_15 < int_9; int_15++) {
                           int_14 += (int)((long)samples[int_11 + int_9 - 1 - int_15] * (long)SoundEffect3.coefficients[0][int_15] >> 16);
                        }

                        for (int_15 = 0; int_15 < int_10; int_15++) {
                           int_14 -= (int)((long)samples[int_11 - 1 - int_15] * (long)SoundEffect3.coefficients[1][int_15] >> 16);
                        }

                        samples[int_11] = int_14;
                        this.filterEnvelope.step(int_0 + 1);
                        ++int_11;
                     }
                     break;
                  }

                  int_9 = this.filter.compute(0, (float)int_8 / 65536.0F);
                  int_10 = this.filter.compute(1, (float)int_8 / 65536.0F);
                  int_12 += 128;
               }
            }
         }

         for (int_8 = 0; int_8 < int_0; int_8++) {
            if (samples[int_8] < -32768) {
               samples[int_8] = -32768;
            }

            if (samples[int_8] > 32767) {
               samples[int_8] = 32767;
            }
         }

         return samples;
      }
   }

   int evaluateWave(int int_0, int int_1, int int_2) {
      return int_2 == 1 ? ((int_0 & 0x7FFF) < 16384 ? int_1 : -int_1) : (int_2 == 2 ? SINE[int_0 & 0x7FFF] * int_1 >> 14 : (int_2 == 3 ? (int_1 * (int_0 & 0x7FFF) >> 14) - int_1 : (int_2 == 4 ? int_1 * NOISE[int_0 / 2607 & 0x7FFF] : 0)));
   }

}
