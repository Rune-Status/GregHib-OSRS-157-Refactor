public class FloorUnderlayDefinition extends CacheableNode {

   static NodeCache underlays;
   public static IndexDataBase underlay_ref;
   static int[] anIntArray105;
   int rgbColor;
   public int saturation;
   public int hue;
   public int lightness;
   public int hueMultiplier;

   static {
      underlays = new NodeCache(64);
   }

   FloorUnderlayDefinition() {
      this.rgbColor = 0;
   }

   void setHSL(int int_0) {
      double double_1 = (double)(int_0 >> 16 & 0xFF) / 256.0D;
      double double_2 = (double)(int_0 >> 8 & 0xFF) / 256.0D;
      double double_3 = (double)(int_0 & 0xFF) / 256.0D;
      double double_4 = double_1;
      if (double_2 < double_1) {
         double_4 = double_2;
      }

      if (double_3 < double_4) {
         double_4 = double_3;
      }

      double double_5 = double_1;
      if (double_2 > double_1) {
         double_5 = double_2;
      }

      if (double_3 > double_5) {
         double_5 = double_3;
      }

      double double_6 = 0.0D;
      double double_7 = 0.0D;
      double double_0 = (double_5 + double_4) / 2.0D;
      if (double_4 != double_5) {
         if (double_0 < 0.5D) {
            double_7 = (double_5 - double_4) / (double_4 + double_5);
         }

         if (double_0 >= 0.5D) {
            double_7 = (double_5 - double_4) / (2.0D - double_5 - double_4);
         }

         if (double_5 == double_1) {
            double_6 = (double_2 - double_3) / (double_5 - double_4);
         } else if (double_2 == double_5) {
            double_6 = 2.0D + (double_3 - double_1) / (double_5 - double_4);
         } else if (double_5 == double_3) {
            double_6 = 4.0D + (double_1 - double_2) / (double_5 - double_4);
         }
      }

      double_6 /= 6.0D;
      this.saturation = (int)(256.0D * double_7);
      this.lightness = (int)(double_0 * 256.0D);
      if (this.saturation < 0) {
         this.saturation = 0;
      } else if (this.saturation > 255) {
         this.saturation = 255;
      }

      if (this.lightness < 0) {
         this.lightness = 0;
      } else if (this.lightness > 255) {
         this.lightness = 255;
      }

      if (double_0 > 0.5D) {
         this.hueMultiplier = (int)(double_7 * (1.0D - double_0) * 512.0D);
      } else {
         this.hueMultiplier = (int)(double_0 * double_7 * 512.0D);
      }

      if (this.hueMultiplier < 1) {
         this.hueMultiplier = 1;
      }

      this.hue = (int)((double)this.hueMultiplier * double_6);
   }

   void decode(Buffer buffer_0, int int_0, int int_1) {
      if (int_0 == 1) {
         this.rgbColor = buffer_0.read24BitInt();
      }

   }

   void post() {
      this.setHSL(this.rgbColor);
   }

   void decode(Buffer buffer_0, int int_0) {
      while (true) {
         int int_1 = buffer_0.getUnsignedByte();
         if (int_1 == 0) {
            return;
         }

         this.decode(buffer_0, int_1, int_0);
      }
   }

}
