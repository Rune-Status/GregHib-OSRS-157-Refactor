public class Class103 {

   public static final char[] aCharArray6;

   static {
      aCharArray6 = new char[] {'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
   }

   static Font method533(byte[] bytes_0) {
      if (bytes_0 == null) {
         return null;
      } else {
         Font font_0 = new Font(bytes_0, Class111.anIntArray54, Class7.offsetsY, ItemContainer.anIntArray76, Class6.anIntArray3, Class111.anIntArray55, Class111.spritePixels);
         Class98.method523();
         return font_0;
      }
   }

}
