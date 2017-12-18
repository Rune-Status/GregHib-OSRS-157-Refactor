public class Class91 implements Runnable {

   public static Deque aDeque1;
   public static Widget[][] widgets;
   public static Deque aDeque2;
   public static Object anObject2;
   public static int anInt191;
   static Thread aThread2;

   static {
      aDeque1 = new Deque();
      aDeque2 = new Deque();
      anInt191 = 0;
      anObject2 = new Object();
   }

   public void run() {
      try {
         while (true) {
            Deque deque_0 = aDeque1;
            FileSystem filesystem_0;
            synchronized(deque_0) {
               filesystem_0 = (FileSystem) aDeque1.getFront();
            }

            Object object_0;
            if (filesystem_0 != null) {
               if (filesystem_0.anInt341 == 0) {
                  filesystem_0.index.method71((int)filesystem_0.hash, filesystem_0.aByteArray12, filesystem_0.aByteArray12.length);
                  deque_0 = aDeque1;
                  synchronized(deque_0) {
                     filesystem_0.unlink();
                  }
               } else if (filesystem_0.anInt341 == 1) {
                  filesystem_0.aByteArray12 = filesystem_0.index.method72((int)filesystem_0.hash);
                  deque_0 = aDeque1;
                  synchronized(deque_0) {
                     aDeque2.addFront(filesystem_0);
                  }
               }

               object_0 = anObject2;
               synchronized(object_0) {
                  if (anInt191 <= 1) {
                     anInt191 = 0;
                     anObject2.notifyAll();
                     return;
                  }

                  anInt191 = 600;
               }
            } else {
               GameEngine.method204(100L);
               object_0 = anObject2;
               synchronized(object_0) {
                  if (anInt191 <= 1) {
                     anInt191 = 0;
                     anObject2.notifyAll();
                     return;
                  }

                  --anInt191;
               }
            }
         }
      } catch (Exception exception_0) {
         Class13.method168((String) null, exception_0);
      }
   }

   static void method501(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6) {
      int[] ints_0 = SceneGraph.method382(int_0, int_1, int_2);
      int[] ints_1 = SceneGraph.method382(int_3, int_4, int_5);
      Rasterizer2D.drawLine(ints_0[0], ints_0[1], ints_1[0], ints_1[1], int_6);
   }

}
