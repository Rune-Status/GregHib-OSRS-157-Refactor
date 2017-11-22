public class CacheableNode_Sub1 extends CacheableNode {

   public final int[] anIntArray86;
   public final int anInt467;
   public final int anInt468;
   public final int[] anIntArray87;

   CacheableNode_Sub1(int int_0, int int_1, int[] ints_0, int[] ints_1, int int_2) {
      this.anInt467 = int_0;
      this.anInt468 = int_1;
      this.anIntArray87 = ints_0;
      this.anIntArray86 = ints_1;
   }

   public boolean method832(int int_0, int int_1) {
      if (int_1 >= 0 && int_1 < this.anIntArray86.length) {
         int int_2 = this.anIntArray86[int_1];
         if (int_0 >= int_2 && int_0 <= int_2 + this.anIntArray87[int_1]) {
            return true;
         }
      }

      return false;
   }

}
