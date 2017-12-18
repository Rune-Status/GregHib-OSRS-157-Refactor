public class Class107 {

   static IndexedSprite anIndexedSprite6;
   boolean aBool33;
   int anInt208;
   IndexDataBase anIndexDataBase9;
   String aString14;

   Class107(IndexDataBase indexdatabase_0) {
      this.anInt208 = 0;
      this.aBool33 = false;
      this.anIndexDataBase9 = indexdatabase_0;
   }

   int method538() {
      if (this.anInt208 < 25) {
         if (!this.anIndexDataBase9.method429(Class16.aClass16_2.aString2, this.aString14)) {
            return this.anInt208;
         }

         this.anInt208 = 25;
      }

      if (this.anInt208 == 25) {
         if (!this.anIndexDataBase9.method429(this.aString14, Class16.aClass16_3.aString2)) {
            return 25 + this.anIndexDataBase9.method434(this.aString14) * 25 / 100;
         }

         this.anInt208 = 50;
      }

      if (this.anInt208 == 50) {
         if (this.anIndexDataBase9.method433(Class16.aClass16_4.aString2, this.aString14) && !this.anIndexDataBase9.method429(Class16.aClass16_4.aString2, this.aString14)) {
            return 50;
         }

         this.anInt208 = 75;
      }

      if (this.anInt208 == 75) {
         if (!this.anIndexDataBase9.method429(this.aString14, Class16.aClass16_5.aString2)) {
            return 75;
         }

         this.anInt208 = 100;
         this.aBool33 = true;
      }

      return this.anInt208;
   }

   boolean method539() {
      return this.aBool33;
   }

   void method540(String string_0) {
      if (string_0 != null && !string_0.isEmpty()) {
         if (string_0 != this.aString14) {
            this.aString14 = string_0;
            this.anInt208 = 0;
            this.aBool33 = false;
            this.method538();
         }
      }
   }

   int method541() {
      return this.anInt208;
   }

}
