public class Class99 {

   public static Huffman aHuffman1;

   public static byte convertCharacter(char character) {
      byte value;
      if (character > 0 && character < 128 || character >= 160 && character <= 255) {
         value = (byte)character;
      } else if (character == 8364) {
         value = -128;
      } else if (character == 8218) {
         value = -126;
      } else if (character == 402) {
         value = -125;
      } else if (character == 8222) {
         value = -124;
      } else if (character == 8230) {
         value = -123;
      } else if (character == 8224) {
         value = -122;
      } else if (character == 8225) {
         value = -121;
      } else if (character == 710) {
         value = -120;
      } else if (character == 8240) {
         value = -119;
      } else if (character == 352) {
         value = -118;
      } else if (character == 8249) {
         value = -117;
      } else if (character == 338) {
         value = -116;
      } else if (character == 381) {
         value = -114;
      } else if (character == 8216) {
         value = -111;
      } else if (character == 8217) {
         value = -110;
      } else if (character == 8220) {
         value = -109;
      } else if (character == 8221) {
         value = -108;
      } else if (character == 8226) {
         value = -107;
      } else if (character == 8211) {
         value = -106;
      } else if (character == 8212) {
         value = -105;
      } else if (character == 732) {
         value = -104;
      } else if (character == 8482) {
         value = -103;
      } else if (character == 353) {
         value = -102;
      } else if (character == 8250) {
         value = -101;
      } else if (character == 339) {
         value = -100;
      } else if (character == 382) {
         value = -98;
      } else if (character == 376) {
         value = -97;
      } else {
         value = 63;
      }

      return value;
   }

}
