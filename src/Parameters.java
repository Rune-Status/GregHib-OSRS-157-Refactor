public class Parameters {

   public static final Parameters aParameters1;
   public static final Parameters aParameters2;
   public static final Parameters aParameters3;
   public static final Parameters aParameters4;
   public static final Parameters aParameters5;
   public static final Parameters aParameters6;
   public static final Parameters aParameters7;
   public static final Parameters aParameters8;
   public static final Parameters aParameters9;
   public static final Parameters aParameters10;
   public static final Parameters aParameters11;
   public static final Parameters aParameters12;
   public static final Parameters aParameters13;
   public static final Parameters aParameters14;
   public static final Parameters aParameters15;
   public final String key;

   static {
      aParameters1 = new Parameters("11", "11");
      aParameters3 = new Parameters("2", "2");
      aParameters2 = new Parameters("15", "15");
      aParameters5 = new Parameters("6", "6");
      aParameters6 = new Parameters("5", "5");
      aParameters11 = new Parameters("12", "12");
      aParameters14 = new Parameters("1", "1");
      aParameters4 = new Parameters("8", "8");
      aParameters15 = new Parameters("4", "4");
      aParameters13 = new Parameters("9", "9");
      aParameters7 = new Parameters("7", "7");
      aParameters9 = new Parameters("3", "3");
      aParameters8 = new Parameters("13", "13");
      aParameters12 = new Parameters("14", "14");
      aParameters10 = new Parameters("10", "10");
   }

   Parameters(String string_0, String string_1) {
      this.key = string_1;
   }

   static int method83(int int_0, int int_1) {
      if (int_0 == -1) {
         return 12345678;
      } else {
         int_1 = (int_0 & 0x7F) * int_1 / 128;
         if (int_1 < 2) {
            int_1 = 2;
         } else if (int_1 > 126) {
            int_1 = 126;
         }

         return (int_0 & 0xFF80) + int_1;
      }
   }

}
