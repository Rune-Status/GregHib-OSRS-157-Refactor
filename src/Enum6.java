public enum Enum6 implements RSEnum {

   anEnum6_2("runescape", "RuneScape", 0),
   anEnum6_3("stellardawn", "Stellar Dawn", 1),
   anEnum6_4("game3", "Game 3", 2),
   anEnum6_5("game4", "Game 4", 3),
   anEnum6_6("game5", "Game 5", 4),
   anEnum6_7("oldscape", "RuneScape 2007", 5);

   static int anInt385;
   final int anInt386;
   public final String aString27;

   Enum6(String string_1, String string_2, int int_1) {
      this.aString27 = string_1;
      this.anInt386 = int_1;
   }

   public int rsOrdinal() {
      return this.anInt386;
   }

   public static int method702(boolean bool_0, boolean bool_1) {
      byte byte_0 = 0;
      int int_0 = byte_0 + Class95.anInt198 + Class95.anInt197;
      return int_0;
   }

}
