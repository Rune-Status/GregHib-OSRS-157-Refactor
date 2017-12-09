public class Class59 {

   public static final Class59 aClass59_1;
   public static final Class59 aClass59_2;
   public static final Class59 aClass59_3;
   public static final Class59 aClass59_4;
   public static final Class59 aClass59_5;
   public static final Class59 aClass59_6;
   public static final Class59 aClass59_7;
   public static final Class59 aClass59_8;
   public static final Class59 aClass59_9;
   public static final Class59 aClass59_10;
   static Widget aWidget3;

   static {
      aClass59_1 = new Class59(5);
      aClass59_2 = new Class59(7);
      aClass59_3 = new Class59(14);
      aClass59_4 = new Class59(6);
      aClass59_5 = new Class59(15);
      aClass59_6 = new Class59(3);
      aClass59_7 = new Class59(5);
      aClass59_8 = new Class59(4);
      aClass59_9 = new Class59(2);
      aClass59_10 = new Class59(4);
   }

   Class59(int int_0) {
   }

   static void method390() {
      FileOnDisk fileondisk_0 = null;

      try {
         fileondisk_0 = CollisionData.getPreferencesFile("", Class14.anEnum6_1.aString27, true);
         Buffer buffer_0 = Buffer.preferences.serialize();
         fileondisk_0.write(buffer_0.buffer, 0, buffer_0.position);
      } catch (Exception exception_0) {
         ;
      }

      try {
         if (fileondisk_0 != null) {
            fileondisk_0.method76(true);
         }
      } catch (Exception exception_1) {
         ;
      }

   }

}
