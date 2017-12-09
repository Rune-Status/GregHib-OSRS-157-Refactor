public class SoundEffect {

   int start;
   AudioInstrument[] instruments;
   int end;

   SoundEffect(Buffer buffer_0) {
      this.instruments = new AudioInstrument[10];

      for (int int_0 = 0; int_0 < 10; int_0++) {
         int int_1 = buffer_0.getUnsignedByte();
         if (int_1 != 0) {
            --buffer_0.position;
            this.instruments[int_0] = new AudioInstrument();
            this.instruments[int_0].decode(buffer_0);
         }
      }

      this.start = buffer_0.getUnsignedShort();
      this.end = buffer_0.getUnsignedShort();
   }

   byte[] mix() {
      int int_0 = 0;

      int int_1;
      for (int_1 = 0; int_1 < 10; int_1++) {
         if (this.instruments[int_1] != null && this.instruments[int_1].duration + this.instruments[int_1].offset > int_0) {
            int_0 = this.instruments[int_1].duration + this.instruments[int_1].offset;
         }
      }

      if (int_0 == 0) {
         return new byte[0];
      } else {
         int_1 = int_0 * 22050 / 1000;
         byte[] bytes_0 = new byte[int_1];

         for (int int_2 = 0; int_2 < 10; int_2++) {
            if (this.instruments[int_2] != null) {
               int int_3 = this.instruments[int_2].duration * 22050 / 1000;
               int int_4 = this.instruments[int_2].offset * 22050 / 1000;
               int[] ints_0 = this.instruments[int_2].synthesize(int_3, this.instruments[int_2].duration);

               for (int int_5 = 0; int_5 < int_3; int_5++) {
                  int int_6 = (ints_0[int_5] >> 8) + bytes_0[int_5 + int_4];
                  if ((int_6 + 128 & 0xFFFFFF00) != 0) {
                     int_6 = int_6 >> 31 ^ 0x7F;
                  }

                  bytes_0[int_5 + int_4] = (byte)int_6;
               }
            }
         }

         return bytes_0;
      }
   }

   public AClass4_Sub1 method421() {
      byte[] bytes_0 = this.mix();
      return new AClass4_Sub1(22050, bytes_0, this.start * 22050 / 1000, this.end * 22050 / 1000);
   }

   public int calculateDelay() {
      int int_0 = 9999999;

      int int_1;
      for (int_1 = 0; int_1 < 10; int_1++) {
         if (this.instruments[int_1] != null && this.instruments[int_1].offset / 20 < int_0) {
            int_0 = this.instruments[int_1].offset / 20;
         }
      }

      if (this.start < this.end && this.start / 20 < int_0) {
         int_0 = this.start / 20;
      }

      if (int_0 != 9999999 && int_0 != 0) {
         for (int_1 = 0; int_1 < 10; int_1++) {
            if (this.instruments[int_1] != null) {
               this.instruments[int_1].offset -= int_0 * 20;
            }
         }

         if (this.start < this.end) {
            this.start -= int_0 * 20;
            this.end -= int_0 * 20;
         }

         return int_0;
      } else {
         return 0;
      }
   }

   public static SoundEffect getTrack(IndexDataBase indexdatabase_0, int int_0, int int_1) {
      byte[] bytes_0 = indexdatabase_0.getConfigData(int_0, int_1);
      return bytes_0 == null ? null : new SoundEffect(new Buffer(bytes_0));
   }

}
