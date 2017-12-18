public class NanoTimer extends Timer {

   long nanoTime;

   public NanoTimer() {
      this.nanoTime = System.nanoTime();
   }

   public int method584(int int_0, int int_1) {
      long long_0 = (long)int_1 * 1000000L;
      long long_1 = this.nanoTime - System.nanoTime();
      if (long_1 < long_0) {
         long_1 = long_0;
      }

      GameEngine.method204(long_1 / 1000000L);
      long long_2 = System.nanoTime();

      int int_2;
      for (int_2 = 0; int_2 < 10 && (int_2 < 1 || this.nanoTime < long_2); this.nanoTime += 1000000L * (long)int_0) {
         ++int_2;
      }

      if (this.nanoTime < long_2) {
         this.nanoTime = long_2;
      }

      return int_2;
   }

   public void method585() {
      this.nanoTime = System.nanoTime();
   }

}
