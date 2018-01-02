public class Class71 {

   static long aLong7;
   static long aLong8;

   public static Object method422(byte[] bytes_0, boolean bool_0) {
      if (bytes_0 == null) {
         return null;
      } else {
         if (bytes_0.length > 136 && !AbstractByteBuffer.aBool17) {
            try {
               DirectByteBuffer directbytebuffer_0 = new DirectByteBuffer();
               directbytebuffer_0.put(bytes_0);
               return directbytebuffer_0;
            } catch (Throwable throwable_0) {
               AbstractByteBuffer.aBool17 = true;
            }
         }

         return bytes_0;
      }
   }

   static void method423(int x, int y, int width, int height) {
      for (int int_4 = 0; int_4 < Client.widgetIndexCount; int_4++) {
         if (Client.widgetPositionX[int_4] + Client.widgetBoundsWidth[int_4] > x && Client.widgetPositionX[int_4] < x + width && Client.widgetPositionY[int_4] + Client.widgetBoundsHeight[int_4] > y && Client.widgetPositionY[int_4] < height + y) {
            Client.drawRedFill[int_4] = true;
         }
      }

   }

   public static void method424(IndexDataBase indexdatabase_0, int int_0, int int_1, int int_2, boolean bool_0) {
      Class78.anInt172 = 1;
      Class70.anIndexDataBase3 = indexdatabase_0;
      Class78.anInt173 = int_0;
      Class78.anInt174 = int_1;
      Class7.anInt40 = int_2;
      Class78.aBool29 = bool_0;
      Class1.anInt16 = 10000;
   }

}
