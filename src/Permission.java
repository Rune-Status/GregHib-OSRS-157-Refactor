public enum Permission implements RSEnum {

   aPermission1(0, -1, true, false, true),
   aPermission2(1, 0, true, true, true),
   aPermission3(2, 1, true, true, false),
   aPermission4(3, 2, false, false, true),
   aPermission5(4, 3, false, false, true),
   aPermission6(5, 10, false, false, true);

   static int[] anIntArray67;
   final int anInt301;
   public final int anInt302;
   public final boolean aBool45;
   public final boolean aBool46;

   Permission(int int_1, int int_2, boolean bool_0, boolean bool_1, boolean bool_2) {
      this.anInt301 = int_1;
      this.anInt302 = int_2;
      this.aBool45 = bool_1;
      this.aBool46 = bool_2;
   }

   public int rsOrdinal() {
      return this.anInt301;
   }

   static void method599(boolean bool_0) {
      if (bool_0) {
         Client.anEnum3_5 = Class25.aBool12 ? Enum3.anEnum3_2 : Enum3.anEnum3_4;
      } else {
         Client.anEnum3_5 = Buffer.preferences.preferences.containsKey(Integer.valueOf(AClass6_Sub4.method867(Class25.username))) ? Enum3.anEnum3_1 : Enum3.anEnum3_3;
      }

   }

}
