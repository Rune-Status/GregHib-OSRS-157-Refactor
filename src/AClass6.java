public abstract class AClass6 extends Node {

   volatile boolean aBool50;
   AClass4 anAClass4_1;
   AClass6 anAClass6_2;
   int anInt332;

   protected AClass6() {
      this.aBool50 = true;
   }

   protected abstract void method656(int[] var1, int var2, int var3);

   protected abstract void method657(int var1);

   void method658(int[] ints_0, int int_0, int int_1) {
      if (this.aBool50) {
         this.method656(ints_0, int_0, int_1);
      } else {
         this.method657(int_1);
      }

   }

   protected abstract AClass6 method659();

   protected abstract AClass6 method660();

   int method661() {
      return 255;
   }

   protected abstract int method662();

}
