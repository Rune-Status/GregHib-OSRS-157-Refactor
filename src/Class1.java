import java.util.Date;

public class Class1 {

   public static int anInt16;
   static Font aFont2;
   static int[] tt;
   static Class102 aClass102_1;
   public int anInt17;
   public Coordinates aCoordinates2;
   public Coordinates aCoordinates3;

   public Class1(int int_0, Coordinates coordinates_0, Coordinates coordinates_1) {
      this.anInt17 = int_0;
      this.aCoordinates2 = coordinates_0;
      this.aCoordinates3 = coordinates_1;
   }

   public static RSEnum forOrdinal(RSEnum[] rsenums_0, int int_0) {
      RSEnum[] rsenums_1 = rsenums_0;

      for (int int_1 = 0; int_1 < rsenums_1.length; int_1++) {
         RSEnum rsenum_0 = rsenums_1[int_1];
         if (int_0 == rsenum_0.rsOrdinal()) {
            return rsenum_0;
         }
      }

      return null;
   }

   static void method74(int int_0, int int_1) {
      int[] ints_0 = new int[4];
      int[] ints_1 = new int[4];
      ints_0[0] = int_0;
      ints_1[0] = int_1;
      int int_2 = 1;

      for (int int_3 = 0; int_3 < 4; int_3++) {
         if (World.anIntArray58[int_3] != int_0) {
            ints_0[int_2] = World.anIntArray58[int_3];
            ints_1[int_2] = World.anIntArray57[int_3];
            ++int_2;
         }
      }

      World.anIntArray58 = ints_0;
      World.anIntArray57 = ints_1;
      Class68_Sub1.method623(Coordinates.worldList, 0, Coordinates.worldList.length - 1, World.anIntArray58, World.anIntArray57);
   }

   public static String method75(long long_0) {
      Class74.aCalendar2.setTime(new Date(long_0));
      int int_0 = Class74.aCalendar2.get(7);
      int int_1 = Class74.aCalendar2.get(5);
      int int_2 = Class74.aCalendar2.get(2);
      int int_3 = Class74.aCalendar2.get(1);
      int int_4 = Class74.aCalendar2.get(11);
      int int_5 = Class74.aCalendar2.get(12);
      int int_6 = Class74.aCalendar2.get(13);
      return Class74.aStringArray3[int_0 - 1] + ", " + int_1 / 10 + int_1 % 10 + "-" + Class74.aStringArrayArray1[0][int_2] + "-" + int_3 + " " + int_4 / 10 + int_4 % 10 + ":" + int_5 / 10 + int_5 % 10 + ":" + int_6 / 10 + int_6 % 10 + " GMT";
   }

}
