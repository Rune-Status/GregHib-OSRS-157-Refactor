public class Class28 {

   public static final Class28 aClass28_2;
   public static final Class28 aClass28_3;
   public static final Class28 aClass28_4;
   static IndexedSprite[] anIndexedSpriteArray6;
   static int scriptStringStackSize;
   final int anInt91;
   final String aString5;
   final int anInt92;
   final int anInt93;

   static {
      aClass28_2 = new Class28("SMALL", 2, 0, 4);
      aClass28_3 = new Class28("MEDIUM", 1, 1, 2);
      aClass28_4 = new Class28("LARGE", 0, 2, 0);
   }

   Class28(String string_0, int int_0, int int_1, int int_2) {
      this.aString5 = string_0;
      this.anInt92 = int_0;
      this.anInt93 = int_1;
      this.anInt91 = int_2;
   }

   boolean method228(float float_0) {
      return float_0 >= (float)this.anInt91;
   }

   static Class28 method229(int int_0) {
      Class28[] class28s_0 = new Class28[] {aClass28_2, aClass28_3, aClass28_4};
      Class28[] class28s_1 = class28s_0;

      for (int int_1 = 0; int_1 < class28s_1.length; int_1++) {
         Class28 class28_0 = class28s_1[int_1];
         if (int_0 == class28_0.anInt93) {
            return class28_0;
         }
      }

      return null;
   }

   static String method230(String string_0, boolean bool_0) {
      String string_1 = bool_0 ? "https://" : "http://";
      if (Client.socketType == 1) {
         string_0 = string_0 + "-wtrc";
      } else if (Client.socketType == 2) {
         string_0 = string_0 + "-wtqa";
      } else if (Client.socketType == 3) {
         string_0 = string_0 + "-wtwip";
      } else if (Client.socketType == 5) {
         string_0 = string_0 + "-wti";
      } else if (Client.socketType == 4) {
         string_0 = "local";
      }

      String string_2 = "";
      if (Class16.sessionToken != null) {
         string_2 = "/p=" + Class16.sessionToken;
      }

      String string_3 = "runescape.com";
      return string_1 + string_0 + "." + string_3 + "/l=" + Client.languageId + "/a=" + Class10.anInt48 + string_2 + "/";
   }

   public static void method231(IndexDataBase indexdatabase_0) {
      Class49.varbit_ref = indexdatabase_0;
   }

   public static void method232(String[] strings_0, short[] shorts_0) {
      Class68_Sub1.method624(strings_0, shorts_0, 0, strings_0.length - 1);
   }

}
