import java.util.concurrent.ScheduledExecutorService;

public class AbstractSoundSystem {

   static SoundTask task;
   public static int sampleRate;
   protected static boolean highMemory;
   static ScheduledExecutorService aScheduledExecutorService1;
   public static Interface2 anInterface2_1;
   static IndexData wordPackIndex;
   static int priority;
   AClass6[] anAClass6Array1;
   protected int[] samples;
   AClass6 anAClass6_1;
   int anInt131;
   boolean aBool20;
   int offset;
   int anInt132;
   AClass6[] anAClass6Array2;
   long aLong4;
   long aLong5;
   int anInt133;
   int anInt134;
   int anInt135;
   int anInt136;
   int anInt137;
   long aLong6;

   protected AbstractSoundSystem() {
      this.anInt132 = 32;
      this.aLong5 = Class97.currentTimeMs();
      this.aLong4 = 0L;
      this.anInt133 = 0;
      this.anInt135 = 0;
      this.anInt134 = 0;
      this.aLong6 = 0L;
      this.aBool20 = true;
      this.anInt131 = 0;
      this.anAClass6Array2 = new AClass6[8];
      this.anAClass6Array1 = new AClass6[8];
   }

   protected void method338() throws Exception {
   }

   protected void close() {
   }

   public synchronized void method339() {
      if (this.samples != null) {
         long long_0 = Class97.currentTimeMs();

         try {
            if (this.aLong4 != 0L) {
               if (long_0 < this.aLong4) {
                  return;
               }

               this.create(this.offset);
               this.aLong4 = 0L;
               this.aBool20 = true;
            }

            int int_0 = this.size();
            if (this.anInt134 - int_0 > this.anInt133) {
               this.anInt133 = this.anInt134 - int_0;
            }

            int int_1 = this.anInt136 + this.anInt137;
            if (int_1 + 256 > 16384) {
               int_1 = 16128;
            }

            if (int_1 + 256 > this.offset) {
               this.offset += 1024;
               if (this.offset > 16384) {
                  this.offset = 16384;
               }

               this.close();
               this.create(this.offset);
               int_0 = 0;
               this.aBool20 = true;
               if (int_1 + 256 > this.offset) {
                  int_1 = this.offset - 256;
                  this.anInt136 = int_1 - this.anInt137;
               }
            }

            while (int_0 < int_1) {
               this.method345(this.samples, 256);
               this.write();
               int_0 += 256;
            }

            if (long_0 > this.aLong6) {
               if (!this.aBool20) {
                  if (this.anInt133 == 0 && this.anInt135 == 0) {
                     this.close();
                     this.aLong4 = 2000L + long_0;
                     return;
                  }

                  this.anInt136 = Math.min(this.anInt135, this.anInt133);
                  this.anInt135 = this.anInt133;
               } else {
                  this.aBool20 = false;
               }

               this.anInt133 = 0;
               this.aLong6 = 2000L + long_0;
            }

            this.anInt134 = int_0;
         } catch (Exception exception_0) {
            this.close();
            this.aLong4 = 2000L + long_0;
         }

         try {
            if (long_0 > 500000L + this.aLong5) {
               long_0 = this.aLong5;
            }

            while (long_0 > this.aLong5 + 5000L) {
               this.method341(256);
               this.aLong5 += (long)(256000 / sampleRate);
            }
         } catch (Exception exception_1) {
            this.aLong5 = long_0;
         }

      }
   }

   protected int size() throws Exception {
      return this.offset;
   }

   protected void create(int int_0) throws Exception {
   }

   public synchronized void method340() {
      this.aBool20 = true;

      try {
         this.method338();
      } catch (Exception exception_0) {
         this.close();
         this.aLong4 = Class97.currentTimeMs() + 2000L;
      }

   }

   void method341(int int_0) {
      this.anInt131 -= int_0;
      if (this.anInt131 < 0) {
         this.anInt131 = 0;
      }

      if (this.anAClass6_1 != null) {
         this.anAClass6_1.method657(int_0);
      }

   }

   void method342(AClass6 aclass6_0, int int_0) {
      int int_1 = int_0 >> 5;
      AClass6 aclass6_1 = this.anAClass6Array1[int_1];
      if (aclass6_1 == null) {
         this.anAClass6Array2[int_1] = aclass6_0;
      } else {
         aclass6_1.anAClass6_2 = aclass6_0;
      }

      this.anAClass6Array1[int_1] = aclass6_0;
      aclass6_0.anInt332 = int_0;
   }

   public void method343() {
      this.aBool20 = true;
   }

   public synchronized void method344() {
      if (task != null) {
         boolean bool_0 = true;

         for (int int_0 = 0; int_0 < 2; int_0++) {
            if (this == task.systems[int_0]) {
               task.systems[int_0] = null;
            }

            if (task.systems[int_0] != null) {
               bool_0 = false;
            }
         }

         if (bool_0) {
            aScheduledExecutorService1.shutdownNow();
            aScheduledExecutorService1 = null;
            task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   void method345(int[] ints_0, int int_0) {
      int int_1 = int_0;
      if (highMemory) {
         int_1 = int_0 << 1;
      }

      Class76.method449(ints_0, 0, int_1);
      this.anInt131 -= int_0;
      if (this.anAClass6_1 != null && this.anInt131 <= 0) {
         this.anInt131 += sampleRate >> 4;
         AudioObject.method633(this.anAClass6_1);
         this.method342(this.anAClass6_1, this.anAClass6_1.method661());
         int int_2 = 0;
         int int_3 = 255;

         int int_4;
         AClass6 aclass6_1;
         label104:
         for (int_4 = 7; int_3 != 0; --int_4) {
            int int_5;
            int int_6;
            if (int_4 < 0) {
               int_5 = int_4 & 0x3;
               int_6 = -(int_4 >> 2);
            } else {
               int_5 = int_4;
               int_6 = 0;
            }

            for (int int_7 = int_3 >>> int_5 & 0x11111111; int_7 != 0; int_7 >>>= 4) {
               if ((int_7 & 0x1) != 0) {
                  int_3 &= ~(1 << int_5);
                  aclass6_1 = null;
                  AClass6 aclass6_2 = this.anAClass6Array2[int_5];

                  label98:
                  while (true) {
                     while (true) {
                        if (aclass6_2 == null) {
                           break label98;
                        }

                        AClass4 aclass4_0 = aclass6_2.anAClass4_1;
                        if (aclass4_0 != null && aclass4_0.anInt330 > int_6) {
                           int_3 |= 1 << int_5;
                           aclass6_1 = aclass6_2;
                           aclass6_2 = aclass6_2.anAClass6_2;
                        } else {
                           aclass6_2.aBool50 = true;
                           int int_8 = aclass6_2.method662();
                           int_2 += int_8;
                           if (aclass4_0 != null) {
                              aclass4_0.anInt330 += int_8;
                           }

                           if (int_2 >= this.anInt132) {
                              break label104;
                           }

                           AClass6 aclass6_3 = aclass6_2.method660();
                           if (aclass6_3 != null) {
                              for (int int_9 = aclass6_2.anInt332; aclass6_3 != null; aclass6_3 = aclass6_2.method659()) {
                                 this.method342(aclass6_3, int_9 * aclass6_3.method661() >> 8);
                              }
                           }

                           AClass6 aclass6_4 = aclass6_2.anAClass6_2;
                           aclass6_2.anAClass6_2 = null;
                           if (aclass6_1 == null) {
                              this.anAClass6Array2[int_5] = aclass6_4;
                           } else {
                              aclass6_1.anAClass6_2 = aclass6_4;
                           }

                           if (aclass6_4 == null) {
                              this.anAClass6Array1[int_5] = aclass6_1;
                           }

                           aclass6_2 = aclass6_4;
                        }
                     }
                  }
               }

               int_5 += 4;
               ++int_6;
            }
         }

         for (int_4 = 0; int_4 < 8; int_4++) {
            AClass6 aclass6_0 = this.anAClass6Array2[int_4];
            AClass6[] aclass6s_0 = this.anAClass6Array2;
            this.anAClass6Array1[int_4] = null;

            for (aclass6s_0[int_4] = null; aclass6_0 != null; aclass6_0 = aclass6_1) {
               aclass6_1 = aclass6_0.anAClass6_2;
               aclass6_0.anAClass6_2 = null;
            }
         }
      }

      if (this.anInt131 < 0) {
         this.anInt131 = 0;
      }

      if (this.anAClass6_1 != null) {
         this.anAClass6_1.method656(ints_0, 0, int_0);
      }

      this.aLong5 = Class97.currentTimeMs();
   }

   protected void write() throws Exception {
   }

   public synchronized void method346(AClass6 aclass6_0) {
      this.anAClass6_1 = aclass6_0;
   }

   protected void method347() throws Exception {
   }

   static String method348(char char_0, int int_0) {
      char[] chars_0 = new char[int_0];

      for (int int_1 = 0; int_1 < int_0; int_1++) {
         chars_0[int_1] = char_0;
      }

      return new String(chars_0);
   }

}
