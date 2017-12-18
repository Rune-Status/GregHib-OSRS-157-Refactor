public final class ComplexTile {

   boolean flatShade;
   int swColour;
   int seColour;
   int rgb;
   int neColour;
   int nwColour;
   int texture;

   ComplexTile(int swColour, int seColour, int neColour, int nwColour, int texture, int Rgb, boolean flatShade) {
      this.flatShade = true;
      this.swColour = swColour;
      this.seColour = seColour;
      this.neColour = neColour;
      this.nwColour = nwColour;
      this.texture = texture;
      this.rgb = Rgb;
      this.flatShade = flatShade;
   }

}
