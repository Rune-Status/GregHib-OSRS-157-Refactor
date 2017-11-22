public class Class109 {

   public static final Class109 aClass109_2;
   static final Class109 aClass109_3;
   static final Class109 aClass109_4;
   static final Class109 aClass109_5;
   static final Class109 aClass109_6;
   static final Class109 aClass109_7;
   static final Class109 aClass109_8;
   static final Class109 aClass109_9;
   public static final Class109 aClass109_10;
   final String identifier;
   public final int anInt211;

   static {
      aClass109_2 = new Class109(8, 0, "", "");
      aClass109_3 = new Class109(2, 1, "", "");
      aClass109_4 = new Class109(4, 2, "", "");
      aClass109_5 = new Class109(7, 3, "", "");
      aClass109_6 = new Class109(5, 4, "", "");
      aClass109_7 = new Class109(1, 5, "", "");
      aClass109_8 = new Class109(3, 6, "", "");
      aClass109_9 = new Class109(0, 7, "", "");
      aClass109_10 = new Class109(6, -1, "", "", true, new Class109[] {aClass109_2, aClass109_3, aClass109_4, aClass109_6, aClass109_5});
   }

   Class109(int int_0, int int_1, String string_0, String string_1) {
      this.anInt211 = int_0;
      this.identifier = string_1;
   }

   Class109(int int_0, int int_1, String string_0, String string_1, boolean bool_0, Class109[] class109s_0) {
      this.anInt211 = int_0;
      this.identifier = string_1;
   }

   public String toString() {
      return this.identifier;
   }

}
