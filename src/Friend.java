public class Friend {

   static Widget aWidget5;
   int world;
   boolean aBool31;
   String name;
   boolean aBool32;
   String previousName;
   int rank;

   public static void method535(IndexDataBase indexdatabase_0, IndexDataBase indexdatabase_1, IndexDataBase indexdatabase_2) {
      CacheableNode_Sub6.configCacheIndex = indexdatabase_0;
      CacheableNode_Sub6.anIndexDataBase26 = indexdatabase_1;
      CacheableNode_Sub6.anIndexDataBase27 = indexdatabase_2;
   }

   public static int method536(int int_0) {
      return int_0 > 0 ? 1 : (int_0 < 0 ? -1 : 0);
   }

   static String[] method537(String[] strings_0) {
      String[] strings_1 = new String[5];

      for (int int_0 = 0; int_0 < 5; int_0++) {
         strings_1[int_0] = int_0 + ": ";
         if (strings_0 != null && strings_0[int_0] != null) {
            strings_1[int_0] = strings_1[int_0] + strings_0[int_0];
         }
      }

      return strings_1;
   }

}
