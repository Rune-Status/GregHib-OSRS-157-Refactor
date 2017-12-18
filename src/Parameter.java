public class Parameter {

   public static final Parameter A_PARAMETER_1;
   public static final Parameter A_PARAMETER_2;
   public static final Parameter A_PARAMETER_3;
   public static final Parameter A_PARAMETER_4;
   public static final Parameter A_PARAMETER_5;
   public static final Parameter A_PARAMETER_6;
   public static final Parameter A_PARAMETER_7;
   public static final Parameter A_PARAMETER_8;
   public static final Parameter A_PARAMETER_9;
   public static final Parameter A_PARAMETER_10;
   public static final Parameter A_PARAMETER_11;
   public static final Parameter A_PARAMETER_12;
   public static final Parameter A_PARAMETER_13;
   public static final Parameter A_PARAMETER_14;
   public static final Parameter A_PARAMETER_15;
   public final String key;

   static {
      A_PARAMETER_1 = new Parameter("11", "11");
      A_PARAMETER_3 = new Parameter("2", "2");
      A_PARAMETER_2 = new Parameter("15", "15");
      A_PARAMETER_5 = new Parameter("6", "6");
      A_PARAMETER_6 = new Parameter("5", "5");
      A_PARAMETER_11 = new Parameter("12", "12");
      A_PARAMETER_14 = new Parameter("1", "1");
      A_PARAMETER_4 = new Parameter("8", "8");
      A_PARAMETER_15 = new Parameter("4", "4");
      A_PARAMETER_13 = new Parameter("9", "9");
      A_PARAMETER_7 = new Parameter("7", "7");
      A_PARAMETER_9 = new Parameter("3", "3");
      A_PARAMETER_8 = new Parameter("13", "13");
      A_PARAMETER_12 = new Parameter("14", "14");
      A_PARAMETER_10 = new Parameter("10", "10");
   }

   Parameter(String key, String value) {
      this.key = value;
   }

}
