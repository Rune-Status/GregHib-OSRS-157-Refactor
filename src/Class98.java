public class Class98 {

   public static char[] aCharArray2;
   static char[] aCharArray3;
   static int[] anIntArray47;

   static {
      aCharArray2 = new char[64];

      int int_0;
      for (int_0 = 0; int_0 < 26; int_0++) {
         aCharArray2[int_0] = (char)(int_0 + 65);
      }

      for (int_0 = 26; int_0 < 52; int_0++) {
         aCharArray2[int_0] = (char)(int_0 + 97 - 26);
      }

      for (int_0 = 52; int_0 < 62; int_0++) {
         aCharArray2[int_0] = (char)(int_0 + 48 - 52);
      }

      aCharArray2[62] = 43;
      aCharArray2[63] = 47;
      aCharArray3 = new char[64];

      for (int_0 = 0; int_0 < 26; int_0++) {
         aCharArray3[int_0] = (char)(int_0 + 65);
      }

      for (int_0 = 26; int_0 < 52; int_0++) {
         aCharArray3[int_0] = (char)(int_0 + 97 - 26);
      }

      for (int_0 = 52; int_0 < 62; int_0++) {
         aCharArray3[int_0] = (char)(int_0 + 48 - 52);
      }

      aCharArray3[62] = 42;
      aCharArray3[63] = 45;
      anIntArray47 = new int[128];

      for (int_0 = 0; int_0 < anIntArray47.length; int_0++) {
         anIntArray47[int_0] = -1;
      }

      for (int_0 = 65; int_0 <= 90; int_0++) {
         anIntArray47[int_0] = int_0 - 65;
      }

      for (int_0 = 97; int_0 <= 122; int_0++) {
         anIntArray47[int_0] = int_0 - 97 + 26;
      }

      for (int_0 = 48; int_0 <= 57; int_0++) {
         anIntArray47[int_0] = int_0 - 48 + 52;
      }

      int[] ints_0 = anIntArray47;
      anIntArray47[43] = 62;
      ints_0[42] = 62;
      int[] ints_1 = anIntArray47;
      anIntArray47[47] = 63;
      ints_1[45] = 63;
   }

   static void cleanPixelLoader() {
      Class111.loadedHorizontalOffsets = null;
      Class7.loadedVerticalOffsets = null;
      ItemContainer.loadedWidths = null;
      Class6.loadedHeights = null;
      Class111.loadedPixels = null;
      Class111.spritePixels = null;
   }

}
