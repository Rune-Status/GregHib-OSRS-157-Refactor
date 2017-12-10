public class Class100 {

   long aLong12;
   long aLong13;
   public boolean aBool30;
   long aLong14;
   int anInt203;
   int anInt204;
   long aLong15;
   long aLong16;
   int anInt205;
   int anInt206;

   public Class100() {
      this.aLong13 = -1L;
      this.aLong14 = -1L;
      this.aBool30 = false;
      this.aLong15 = 0L;
      this.aLong12 = 0L;
      this.aLong16 = 0L;
      this.anInt205 = 0;
      this.anInt203 = 0;
      this.anInt204 = 0;
      this.anInt206 = 0;
   }

   static void method672(Buffer buffer_0, long long_0) {
      long_0 /= 10L;
      if (long_0 < 0L) {
         long_0 = 0L;
      } else if (long_0 > 65535L) {
         long_0 = 65535L;
      }

      buffer_0.putShort((int)long_0);
   }

   public void method525() {
      if (this.aLong14 != -1L) {
         this.aLong15 = Class97.currentTimeMs() - this.aLong14;
         this.aLong14 = -1L;
      }

      ++this.anInt204;
      this.aBool30 = true;
   }

   public void method526() {
      if (this.aLong13 != -1L) {
         this.aLong12 = Class97.currentTimeMs() - this.aLong13;
         this.aLong13 = -1L;
      }

   }

   public void method527() {
      this.aLong13 = Class97.currentTimeMs();
   }

   public void method528(int int_0) {
      this.aLong14 = Class97.currentTimeMs();
      this.anInt205 = int_0;
   }

   public void method529(Buffer buffer_0) {
      long long_0 = this.aLong12;
      long_0 /= 10L;
      if (long_0 < 0L) {
         long_0 = 0L;
      } else if (long_0 > 65535L) {
         long_0 = 65535L;
      }

      buffer_0.putShort((int)long_0);
      long long_1 = this.aLong15;
      long_1 /= 10L;
      if (long_1 < 0L) {
         long_1 = 0L;
      } else if (long_1 > 65535L) {
         long_1 = 65535L;
      }

      buffer_0.putShort((int)long_1);
      method672(buffer_0, this.aLong16);
      buffer_0.putShort(this.anInt205);
      buffer_0.putShort(this.anInt203);
      buffer_0.putShort(this.anInt204);
      buffer_0.putShort(this.anInt206);
   }

   public void method530() {
      this.aBool30 = false;
      this.anInt203 = 0;
   }

   public void method531() {
      this.method525();
   }

}
