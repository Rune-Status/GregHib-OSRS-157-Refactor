public class AClass2_Sub1 extends AClass2 {

   static String aString18;
   static Class56 listFetcher;
   static SpritePixels[] headIconsPrayer;

   protected boolean method393(int int_0, int int_1, int int_2, CollisionData collisiondata_0) {
      return int_1 == this.anInt160 && int_2 == this.anInt161;
   }

   static boolean method628(IndexDataBase indexdatabase_0, int int_0, int int_1) {
      byte[] bytes_0 = indexdatabase_0.getConfigData(int_0, int_1);
      if (bytes_0 == null) {
         return false;
      } else {
         DecorativeObject.decodeSprite(bytes_0);
         return true;
      }
   }

   static int method629(int int_0, int int_1) {
      Overlay overlay_0 = Class39.method255(int_0);
      if (overlay_0 == null) {
         return int_1;
      } else if (overlay_0.otherRgbColor >= 0) {
         return overlay_0.otherRgbColor | 0xFF000000;
      } else {
         int int_2;
         byte byte_0;
         int int_3;
         int int_4;
         if (overlay_0.texture >= 0) {
            int_2 = Graphics3D.textureLoader.getAverageTextureRGB(overlay_0.texture);
            byte_0 = 96;
            if (int_2 == -2) {
               int_3 = 12345678;
            } else if (int_2 == -1) {
               if (byte_0 < 0) {
                  byte_0 = 0;
               } else if (byte_0 > 127) {
                  byte_0 = 127;
               }

               int_4 = 127 - byte_0;
               int_3 = int_4;
            } else {
               int_4 = byte_0 * (int_2 & 0x7F) / 128;
               if (int_4 < 2) {
                  int_4 = 2;
               } else if (int_4 > 126) {
                  int_4 = 126;
               }

               int_3 = int_4 + (int_2 & 0xFF80);
            }

            return Graphics3D.colorPalette[int_3] | 0xFF000000;
         } else if (overlay_0.color == 16711935) {
            return int_1;
         } else {
            int_3 = Preferences.method417(overlay_0.hue, overlay_0.saturation, overlay_0.lightness);
            byte_0 = 96;
            if (int_3 == -2) {
               int_2 = 12345678;
            } else if (int_3 == -1) {
               if (byte_0 < 0) {
                  byte_0 = 0;
               } else if (byte_0 > 127) {
                  byte_0 = 127;
               }

               int_4 = 127 - byte_0;
               int_2 = int_4;
            } else {
               int_4 = byte_0 * (int_3 & 0x7F) / 128;
               if (int_4 < 2) {
                  int_4 = 2;
               } else if (int_4 > 126) {
                  int_4 = 126;
               }

               int_2 = int_4 + (int_3 & 0xFF80);
            }

            return Graphics3D.colorPalette[int_2] | 0xFF000000;
         }
      }
   }

   static void method630() {
      Region.lowMemory = false;
      Client.lowMemory = false;
   }

   static void method631() {
      if (Class25.aBool9 && Class25.username != null && Class25.username.length() > 0) {
         Class25.anInt83 = 1;
      } else {
         Class25.anInt83 = 0;
      }

   }

}