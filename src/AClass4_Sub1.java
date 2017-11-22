public class AClass4_Sub1 extends AClass4 {

   public byte[] aByteArray18;
   public int anInt417;
   public boolean aBool57;
   public int anInt418;
   int anInt419;

   AClass4_Sub1(int int_0, byte[] bytes_0, int int_1, int int_2) {
      this.anInt417 = int_0;
      this.aByteArray18 = bytes_0;
      this.anInt418 = int_1;
      this.anInt419 = int_2;
   }

   AClass4_Sub1(int int_0, byte[] bytes_0, int int_1, int int_2, boolean bool_0) {
      this.anInt417 = int_0;
      this.aByteArray18 = bytes_0;
      this.anInt418 = int_1;
      this.anInt419 = int_2;
      this.aBool57 = bool_0;
   }

   public AClass4_Sub1 method761(Class51 class51_0) {
      this.aByteArray18 = class51_0.method325(this.aByteArray18);
      this.anInt417 = class51_0.method326(this.anInt417);
      if (this.anInt418 == this.anInt419) {
         this.anInt418 = this.anInt419 = class51_0.method327(this.anInt418);
      } else {
         this.anInt418 = class51_0.method327(this.anInt418);
         this.anInt419 = class51_0.method327(this.anInt419);
         if (this.anInt418 == this.anInt419) {
            --this.anInt418;
         }
      }

      return this;
   }

}
