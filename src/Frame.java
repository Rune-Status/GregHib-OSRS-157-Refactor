public class Frame {

   static int[] anIntArray48;
   static int[] anIntArray49;
   static int[] anIntArray50;
   static int[] anIntArray51;
   FrameMap skin;
   boolean showing;
   int anInt202;
   int[] anIntArray52;
   int[] translator_x;
   int[] translator_y;
   int[] translator_z;

   static {
      anIntArray48 = new int[500];
      anIntArray49 = new int[500];
      anIntArray50 = new int[500];
      anIntArray51 = new int[500];
   }

   Frame(byte[] bytes_0, FrameMap framemap_0) {
      this.skin = null;
      this.anInt202 = -1;
      this.showing = false;
      this.skin = framemap_0;
      Buffer buffer_0 = new Buffer(bytes_0);
      Buffer buffer_1 = new Buffer(bytes_0);
      buffer_0.offset = 2;
      int int_0 = buffer_0.readUnsignedByte();
      int int_1 = -1;
      int int_2 = 0;
      buffer_1.offset = int_0 + buffer_0.offset;

      int int_3;
      for (int_3 = 0; int_3 < int_0; int_3++) {
         int int_4 = buffer_0.readUnsignedByte();
         if (int_4 > 0) {
            if (this.skin.types[int_3] != 0) {
               for (int int_5 = int_3 - 1; int_5 > int_1; --int_5) {
                  if (this.skin.types[int_5] == 0) {
                     anIntArray48[int_2] = int_5;
                     anIntArray49[int_2] = 0;
                     anIntArray50[int_2] = 0;
                     anIntArray51[int_2] = 0;
                     ++int_2;
                     break;
                  }
               }
            }

            anIntArray48[int_2] = int_3;
            short short_0 = 0;
            if (this.skin.types[int_3] == 3) {
               short_0 = 128;
            }

            if ((int_4 & 0x1) != 0) {
               anIntArray49[int_2] = buffer_1.readShortSmart();
            } else {
               anIntArray49[int_2] = short_0;
            }

            if ((int_4 & 0x2) != 0) {
               anIntArray50[int_2] = buffer_1.readShortSmart();
            } else {
               anIntArray50[int_2] = short_0;
            }

            if ((int_4 & 0x4) != 0) {
               anIntArray51[int_2] = buffer_1.readShortSmart();
            } else {
               anIntArray51[int_2] = short_0;
            }

            int_1 = int_3;
            ++int_2;
            if (this.skin.types[int_3] == 5) {
               this.showing = true;
            }
         }
      }

      if (bytes_0.length != buffer_1.offset) {
         throw new RuntimeException();
      } else {
         this.anInt202 = int_2;
         this.anIntArray52 = new int[int_2];
         this.translator_x = new int[int_2];
         this.translator_y = new int[int_2];
         this.translator_z = new int[int_2];

         for (int_3 = 0; int_3 < int_2; int_3++) {
            this.anIntArray52[int_3] = anIntArray48[int_3];
            this.translator_x[int_3] = anIntArray49[int_3];
            this.translator_y[int_3] = anIntArray50[int_3];
            this.translator_z[int_3] = anIntArray51[int_3];
         }

      }
   }

}
