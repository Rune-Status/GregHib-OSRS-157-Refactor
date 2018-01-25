public enum GameType implements RSEnum {

   RUNESCAPE("runescape", "RuneScape", 0),
   STELLARDAWN("stellardawn", "Stellar Dawn", 1),
   GAME3("game3", "Game 3", 2),
   GAME4("game4", "Game 4", 3),
   GAME5("game5", "Game 5", 4),
   OSRS("oldscape", "RuneScape 2007", 5);

   static int anInt385;
   final int id;
   public final String name;

   GameType(String name, String string_2, int id) {
      this.name = name;
      this.id = id;
   }

   public int rsOrdinal() {
      return this.id;
   }

   public static int method702(boolean bool_0, boolean bool_1) {
      byte byte_0 = 0;
      int int_0 = byte_0 + Class95.anInt198 + Class95.anInt197;
      return int_0;
   }

}
