public class Class103 {

   public static final char[] aCharArray6;

   static {
      aCharArray6 = new char[] {'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
   }

   static Font loadFont(byte[] data) {
      if (data == null) {
         return null;
      } else {
         Font font = new Font(data, Class111.loadedHorizontalOffsets, Class7.loadedVerticalOffsets, ItemContainer.loadedWidths, Class6.loadedHeights, Class111.loadedPixels, Class111.spritePixels);
         Class98.cleanPixelLoader();
         return font;
      }
   }

}
