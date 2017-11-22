public class TextureProvider implements ITextureLoader {

   static int anInt225;
   int width;
   double brightness;
   Texture[] textures;
   Deque deque;
   int size;
   int maxSize;
   IndexDataBase sprites;

   public TextureProvider(IndexDataBase indexdatabase_0, IndexDataBase indexdatabase_1, int int_0, double double_0, int int_1) {
      this.deque = new Deque();
      this.size = 0;
      this.brightness = 1.0D;
      this.width = 128;
      this.sprites = indexdatabase_1;
      this.maxSize = int_0;
      this.size = this.maxSize;
      this.brightness = double_0;
      this.width = int_1;
      int[] ints_0 = indexdatabase_0.getChilds(0);
      int int_2 = ints_0.length;
      this.textures = new Texture[indexdatabase_0.fileCount(0)];

      for (int int_3 = 0; int_3 < int_2; int_3++) {
         Buffer buffer_0 = new Buffer(indexdatabase_0.getConfigData(0, ints_0[int_3]));
         this.textures[ints_0[int_3]] = new Texture(buffer_0);
      }

   }

   public void reset() {
      for (int int_0 = 0; int_0 < this.textures.length; int_0++) {
         if (this.textures[int_0] != null) {
            this.textures[int_0].resetPixels();
         }
      }

      this.deque = new Deque();
      this.size = this.maxSize;
   }

   public int getAverageTextureRGB(int int_0) {
      return this.textures[int_0] != null ? this.textures[int_0].anInt313 : 0;
   }

   public void brightness(double double_0) {
      this.brightness = double_0;
      this.reset();
   }

   public int[] load(int int_0) {
      Texture texture_0 = this.textures[int_0];
      if (texture_0 != null) {
         if (texture_0.pixels != null) {
            this.deque.addTail(texture_0);
            texture_0.loaded = true;
            return texture_0.pixels;
         }

         boolean bool_0 = texture_0.method626(this.brightness, this.width, this.sprites);
         if (bool_0) {
            if (this.size == 0) {
               Texture texture_1 = (Texture) this.deque.popTail();
               texture_1.resetPixels();
            } else {
               --this.size;
            }

            this.deque.addTail(texture_0);
            texture_0.loaded = true;
            return texture_0.pixels;
         }
      }

      return null;
   }

   public boolean method1(int int_0) {
      return this.width == 64;
   }

   public boolean method2(int int_0) {
      return this.textures[int_0].aBool49;
   }

   public void method569(int int_0) {
      for (int int_1 = 0; int_1 < this.textures.length; int_1++) {
         Texture texture_0 = this.textures[int_1];
         if (texture_0 != null && texture_0.anInt312 != 0 && texture_0.loaded) {
            texture_0.method627(int_0);
            texture_0.loaded = false;
         }
      }

   }

   public static void method570(int int_0, int int_1) {
      Varbit varbit_0 = Coordinates.method517(int_0);
      int int_2 = varbit_0.configId;
      int int_3 = varbit_0.leastSignificantBit;
      int int_4 = varbit_0.mostSignificantBit;
      int int_5 = Class79.anIntArray40[int_4 - int_3];
      if (int_1 < 0 || int_1 > int_5) {
         int_1 = 0;
      }

      int_5 <<= int_3;
      Class79.widgetSettings[int_2] = Class79.widgetSettings[int_2] & ~int_5 | int_1 << int_3 & int_5;
   }

   static boolean method571(char char_0) {
      return char_0 == 160 || char_0 == 32 || char_0 == 95 || char_0 == 45;
   }

}
