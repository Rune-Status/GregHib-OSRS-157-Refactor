public class AClass6_Sub1 extends AClass6 {

   Deque aDeque4;
   Deque aDeque5;
   int anInt415;
   int anInt416;

   public AClass6_Sub1() {
      this.aDeque4 = new Deque();
      this.aDeque5 = new Deque();
      this.anInt416 = 0;
      this.anInt415 = -1;
   }

   void method754(int[] ints_0, int int_0, int int_1) {
      for (AClass6 aclass6_0 = (AClass6) this.aDeque4.getFront(); aclass6_0 != null; aclass6_0 = (AClass6) this.aDeque4.getNext()) {
         aclass6_0.method658(ints_0, int_0, int_1);
      }

   }

   void method755(int int_0) {
      for (AClass6 aclass6_0 = (AClass6) this.aDeque4.getFront(); aclass6_0 != null; aclass6_0 = (AClass6) this.aDeque4.getNext()) {
         aclass6_0.method657(int_0);
      }

   }

   public synchronized void method656(int[] ints_0, int int_0, int int_1) {
      do {
         if (this.anInt415 < 0) {
            this.method754(ints_0, int_0, int_1);
            return;
         }

         if (int_1 + this.anInt416 < this.anInt415) {
            this.anInt416 += int_1;
            this.method754(ints_0, int_0, int_1);
            return;
         }

         int int_2 = this.anInt415 - this.anInt416;
         this.method754(ints_0, int_0, int_2);
         int_0 += int_2;
         int_1 -= int_2;
         this.anInt416 += int_2;
         this.method756();
         AClass5 aclass5_0 = (AClass5) this.aDeque5.getFront();
         synchronized(aclass5_0) {
            int int_3 = aclass5_0.method655(this);
            if (int_3 < 0) {
               aclass5_0.anInt331 = 0;
               this.method759(aclass5_0);
            } else {
               aclass5_0.anInt331 = int_3;
               this.method760(aclass5_0.next, aclass5_0);
            }
         }
      } while (int_1 != 0);

   }

   public synchronized void method657(int int_0) {
      do {
         if (this.anInt415 < 0) {
            this.method755(int_0);
            return;
         }

         if (this.anInt416 + int_0 < this.anInt415) {
            this.anInt416 += int_0;
            this.method755(int_0);
            return;
         }

         int int_1 = this.anInt415 - this.anInt416;
         this.method755(int_1);
         int_0 -= int_1;
         this.anInt416 += int_1;
         this.method756();
         AClass5 aclass5_0 = (AClass5) this.aDeque5.getFront();
         synchronized(aclass5_0) {
            int int_2 = aclass5_0.method655(this);
            if (int_2 < 0) {
               aclass5_0.anInt331 = 0;
               this.method759(aclass5_0);
            } else {
               aclass5_0.anInt331 = int_2;
               this.method760(aclass5_0.next, aclass5_0);
            }
         }
      } while (int_0 != 0);

   }

   protected AClass6 method659() {
      return (AClass6) this.aDeque4.getNext();
   }

   void method756() {
      if (this.anInt416 > 0) {
         for (AClass5 aclass5_0 = (AClass5) this.aDeque5.getFront(); aclass5_0 != null; aclass5_0 = (AClass5) this.aDeque5.getNext()) {
            aclass5_0.anInt331 -= this.anInt416;
         }

         this.anInt415 -= this.anInt416;
         this.anInt416 = 0;
      }

   }

   public synchronized void method757(AClass6 aclass6_0) {
      this.aDeque4.addTail(aclass6_0);
   }

   protected AClass6 method660() {
      return (AClass6) this.aDeque4.getFront();
   }

   public synchronized void method758(AClass6 aclass6_0) {
      aclass6_0.unlink();
   }

   void method759(AClass5 aclass5_0) {
      aclass5_0.unlink();
      aclass5_0.method654();
      Node node_0 = this.aDeque5.head.next;
      if (node_0 == this.aDeque5.head) {
         this.anInt415 = -1;
      } else {
         this.anInt415 = ((AClass5) node_0).anInt331;
      }

   }

   void method760(Node node_0, AClass5 aclass5_0) {
      while (this.aDeque5.head != node_0 && ((AClass5) node_0).anInt331 <= aclass5_0.anInt331) {
         node_0 = node_0.next;
      }

      Deque.method549(aclass5_0, node_0);
      this.anInt415 = ((AClass5) this.aDeque5.head.next).anInt331;
   }

   protected int method662() {
      return 0;
   }

}
