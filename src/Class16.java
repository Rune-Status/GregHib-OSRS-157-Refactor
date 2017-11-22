public class Class16 {

   public static final Class16 aClass16_1;
   public static final Class16 aClass16_2;
   public static final Class16 aClass16_3;
   public static final Class16 aClass16_4;
   public static final Class16 aClass16_5;
   static String sessionToken;
   public final String aString2;

   static {
      aClass16_1 = new Class16("details");
      aClass16_2 = new Class16("compositemap");
      aClass16_4 = new Class16("compositetexture");
      aClass16_3 = new Class16("area");
      aClass16_5 = new Class16("labels");
   }

   Class16(String string_0) {
      this.aString2 = string_0;
   }

   static char method197(char char_0) {
      return char_0 != 181 && char_0 != 131 ? Character.toTitleCase(char_0) : char_0;
   }

   public static boolean method198(char char_0) {
      return char_0 >= 32 && char_0 <= 126 ? true : (char_0 >= 160 && char_0 <= 255 ? true : char_0 == 8364 || char_0 == 338 || char_0 == 8212 || char_0 == 339 || char_0 == 376);
   }

   static void method199(Sequence sequence_0, int int_0, int int_1, int int_2) {
      if (Client.anInt647 < 50 && Client.anInt646 != 0) {
         if (sequence_0.anIntArray108 != null && int_0 < sequence_0.anIntArray108.length) {
            int int_3 = sequence_0.anIntArray108[int_0];
            if (int_3 != 0) {
               int int_4 = int_3 >> 8;
               int int_5 = int_3 >> 4 & 0x7;
               int int_6 = int_3 & 0xF;
               Client.anIntArray149[Client.anInt647] = int_4;
               Client.anIntArray150[Client.anInt647] = int_5;
               Client.anIntArray152[Client.anInt647] = 0;
               Client.audioEffects[Client.anInt647] = null;
               int int_7 = (int_1 - 64) / 128;
               int int_8 = (int_2 - 64) / 128;
               Client.anIntArray153[Client.anInt647] = int_6 + (int_8 << 8) + (int_7 << 16);
               ++Client.anInt647;
            }
         }
      }
   }

}
