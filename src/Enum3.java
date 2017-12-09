public enum Enum3 implements RSEnum {

   anEnum3_1(1, 0),
   anEnum3_2(0, 1),
   anEnum3_3(2, 2),
   anEnum3_4(3, 3);

   final int anInt342;
   public final int anInt343;

   Enum3(int int_1, int int_2) {
      this.anInt343 = int_1;
      this.anInt342 = int_2;
   }

   public int rsOrdinal() {
      return this.anInt342;
   }

   public static void method669(Model model_0, int int_0) {
      for (int int_1 = 0; int_1 < model_0.triangleCount; int_1++) {
         if (model_0.anIntArray132[int_1] != -2) {
            int int_2 = model_0.indices1[int_1];
            int int_3 = model_0.indices2[int_1];
            int int_4 = model_0.indices3[int_1];
            int int_5 = Model.anIntArray120[int_2];
            int int_6 = Model.anIntArray120[int_3];
            int int_7 = Model.anIntArray120[int_4];
            Class35.method244(Model.anIntArray122[int_2], Model.anIntArray122[int_3], Model.anIntArray122[int_4], int_5, int_6, int_7, int_0);
         }
      }

   }

   public static IndexedSprite[] method670(IndexDataBase indexdatabase_0, String string_0, String string_1) {
      int int_0 = indexdatabase_0.getFile(string_0);
      int int_1 = indexdatabase_0.getChild(int_0, string_1);
      return Node_Sub1.method634(indexdatabase_0, int_0, int_1);
   }

}
