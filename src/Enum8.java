public enum Enum8 implements RSEnum {

   anEnum8_1(0, 0),
   anEnum8_2(2, 1),
   anEnum8_3(1, 2);

   public final int anInt389;
   final int anInt390;

   Enum8(int int_1, int int_2) {
      this.anInt389 = int_1;
      this.anInt390 = int_2;
   }

   public int rsOrdinal() {
      return this.anInt390;
   }

}
