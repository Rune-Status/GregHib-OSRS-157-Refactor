public final class SceneTilePaint {

   boolean flatShade;
   int swColor;
   int seColor;
   int rgb;
   int neColor;
   int nwColor;
   int texture;

   SceneTilePaint(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, boolean bool_0) {
      this.flatShade = true;
      this.swColor = int_0;
      this.seColor = int_1;
      this.neColor = int_2;
      this.nwColor = int_3;
      this.texture = int_4;
      this.rgb = int_5;
      this.flatShade = bool_0;
   }

   public static String method330(int int_0) {
      return (int_0 >> 24 & 0xFF) + "." + (int_0 >> 16 & 0xFF) + "." + (int_0 >> 8 & 0xFF) + "." + (int_0 & 0xFF);
   }

}
