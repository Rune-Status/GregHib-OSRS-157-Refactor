public enum Enum2 implements RSEnum {

   anEnum2_1(0),
   anEnum2_2(1),
   anEnum2_3(2),
   anEnum2_4(3);

   final int anInt325;

   Enum2(int int_1) {
      this.anInt325 = int_1;
   }

   public int rsOrdinal() {
      return this.anInt325;
   }

   static void reloadSound() {
      if (Class47.soundSystem1 != null) {
         Class47.soundSystem1.method339();
      }

      if (Class35.soundSystem0 != null) {
         Class35.soundSystem0.method339();
      }

   }

}
