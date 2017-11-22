public abstract class AClass3 extends Node {

   static int myWorldPort;
   static Client clientInstance;
   protected static int anInt326;
   static byte clanChatRank;

   abstract void method643();

   public static void method644(IndexDataBase indexdatabase_0, String string_0, String string_1, int int_0, boolean bool_0) {
      int int_1 = indexdatabase_0.getFile(string_0);
      int int_2 = indexdatabase_0.getChild(int_1, string_1);
      Class71.method424(indexdatabase_0, int_1, int_2, int_0, bool_0);
   }

   static int method645(char char_0) {
      int int_0 = char_0 << 4;
      if (Character.isUpperCase(char_0) || Character.isTitleCase(char_0)) {
         char_0 = Character.toLowerCase(char_0);
         int_0 = (char_0 << 4) + 1;
      }

      return int_0;
   }

}
