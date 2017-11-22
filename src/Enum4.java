public enum Enum4 implements RSEnum {

   anEnum4_1(0, 0),
   anEnum4_2(1, 0),
   anEnum4_3(2, 0),
   anEnum4_4(3, 0),
   anEnum4_5(9, 2),
   anEnum4_6(4, 1),
   anEnum4_7(5, 1),
   anEnum4_8(6, 1),
   anEnum4_9(7, 1),
   anEnum4_10(8, 1),
   anEnum4_11(12, 2),
   anEnum4_12(13, 2),
   anEnum4_13(14, 2),
   anEnum4_14(15, 2),
   anEnum4_15(16, 2),
   anEnum4_16(17, 2),
   anEnum4_17(18, 2),
   anEnum4_18(19, 2),
   anEnum4_19(20, 2),
   anEnum4_20(21, 2),
   anEnum4_21(10, 2),
   anEnum4_22(11, 2),
   anEnum4_23(22, 3);

   static int cameraYaw;
   static int anInt381;
   public final int anInt382;

   Enum4(int int_1, int int_2) {
      this.anInt382 = int_1;
   }

   public int rsOrdinal() {
      return this.anInt382;
   }

   static void method699(int int_0, IndexFile indexfile_0, IndexData indexdata_0) {
      FileSystem filesystem_0 = new FileSystem();
      filesystem_0.anInt341 = 1;
      filesystem_0.hash = (long)int_0;
      filesystem_0.index = indexfile_0;
      filesystem_0.data = indexdata_0;
      Deque deque_0 = Class91.aDeque1;
      synchronized(deque_0) {
         Class91.aDeque1.addFront(filesystem_0);
      }

      Object object_0 = Class91.anObject2;
      synchronized(object_0) {
         if (Class91.anInt191 == 0) {
            Class91.aThread2 = new Thread(new Class91());
            Class91.aThread2.setDaemon(true);
            Class91.aThread2.start();
            Class91.aThread2.setPriority(5);
         }

         Class91.anInt191 = 600;
      }
   }

}
