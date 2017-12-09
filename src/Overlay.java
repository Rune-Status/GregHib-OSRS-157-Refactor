public class Overlay extends CacheableNode {

   public static NodeCache overlays;
   static IndexDataBase overlay_ref;
   static int[] anIntArray81;
   public int otherRgbColor;
   public int color;
   public boolean isHidden;
   public int texture;
   public int hue;
   public int otherHue;
   public int saturation;
   public int otherSaturation;
   public int lightness;
   public int otherLightness;

   static {
      overlays = new NodeCache(64);
   }

   Overlay() {
      this.color = 0;
      this.texture = -1;
      this.isHidden = true;
      this.otherRgbColor = -1;
   }

   void readValues(Buffer buffer_0, int int_0) {
      if (int_0 == 1) {
         this.color = buffer_0.read24BitInt();
      } else if (int_0 == 2) {
         this.texture = buffer_0.getUnsignedByte();
      } else if (int_0 == 5) {
         this.isHidden = false;
      } else if (int_0 == 7) {
         this.otherRgbColor = buffer_0.read24BitInt();
      } else if (int_0 == 8) {
         ;
      }

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
      if (double_5 != double_4) {
         if (double_0 < 0.5D) {
            double_7 = (double_5 - double_4) / (double_4 + double_5);
         }

         if (double_0 >= 0.5D) {
            double_7 = (double_5 - double_4) / (2.0D - double_5 - double_4);
         }

         if (double_1 == double_5) {
            double_6 = (double_2 - double_3) / (double_5 - double_4);
         } else if (double_5 == double_2) {
            double_6 = (double_3 - double_1) / (double_5 - double_4) + 2.0D;
         } else if (double_5 == double_3) {
            double_6 = (double_1 - double_2) / (double_5 - double_4) + 4.0D;
         }
      }

      double_6 /= 6.0D;
      this.hue = (int)(double_6 * 256.0D);
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

   }

   void post() {
      if (this.otherRgbColor != -1) {
         this.setHSL(this.otherRgbColor);
         this.otherHue = this.hue;
         this.otherSaturation = this.saturation;
         this.otherLightness = this.lightness;
      }

      this.setHSL(this.color);
   }

   void decode(Buffer buffer) {
      while (true) {
         int opcode = buffer.getUnsignedByte();
         if (opcode == 0) {
            return;
         }

         this.readValues(buffer, opcode);
      }
   }

   static int skipPlayers(PacketBuffer buffer) {
      int type = buffer.getBits(2);

      int value;
      if (type == 0) {
         value = 0;
      } else if (type == 1) {
         value = buffer.getBits(5);
      } else if (type == 2) {
         value = buffer.getBits(8);
      } else {
         value = buffer.getBits(11);
      }

      return value;
   }

}
