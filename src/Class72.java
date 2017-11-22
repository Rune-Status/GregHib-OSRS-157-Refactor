public class Class72 {

   Class68 aClass68_3;
   Class68 aClass68_4;

   public Class72() {
      this.aClass68_3 = new Class68();
      this.aClass68_3.aClass68_2 = this.aClass68_3;
      this.aClass68_3.aClass68_1 = this.aClass68_3;
   }

   public Class68 method441() {
      Class68 class68_0 = this.aClass68_3.aClass68_2;
      if (class68_0 == this.aClass68_3) {
         this.aClass68_4 = null;
         return null;
      } else {
         this.aClass68_4 = class68_0.aClass68_2;
         return class68_0;
      }
   }

   public void method442(Class68 class68_0) {
      if (class68_0.aClass68_1 != null) {
         class68_0.method415();
      }

      class68_0.aClass68_1 = this.aClass68_3.aClass68_1;
      class68_0.aClass68_2 = this.aClass68_3;
      class68_0.aClass68_1.aClass68_2 = class68_0;
      class68_0.aClass68_2.aClass68_1 = class68_0;
   }

   public Class68 method443() {
      Class68 class68_0 = this.aClass68_4;
      if (class68_0 == this.aClass68_3) {
         this.aClass68_4 = null;
         return null;
      } else {
         this.aClass68_4 = class68_0.aClass68_2;
         return class68_0;
      }
   }

}
