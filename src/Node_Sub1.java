public final class Node_Sub1 extends Node {

   static Deque aDeque3;
   int anInt315;
   ObjectDefinition anObjectDefinition1;
   int anInt316;
   int anInt317;
   int anInt318;
   int[] anIntArray72;
   AClass6_Sub2 anAClass6_Sub2_1;
   int anInt319;
   int anInt320;
   int anInt321;
   int anInt322;
   int anInt323;
   AClass6_Sub2 anAClass6_Sub2_2;
   int anInt324;

   static {
      aDeque3 = new Deque();
   }

   void method632() {
      int int_0 = this.anInt315;
      ObjectDefinition objectcomposition_0 = this.anObjectDefinition1.morph();
      if (objectcomposition_0 != null) {
         this.anInt315 = objectcomposition_0.ambientSoundId;
         this.anInt316 = objectcomposition_0.anInt463 * 128;
         this.anInt317 = objectcomposition_0.anInt464;
         this.anInt318 = objectcomposition_0.anInt465;
         this.anIntArray72 = objectcomposition_0.anIntArray85;
      } else {
         this.anInt315 = -1;
         this.anInt316 = 0;
         this.anInt317 = 0;
         this.anInt318 = 0;
         this.anIntArray72 = null;
      }

      if (int_0 != this.anInt315 && this.anAClass6_Sub2_1 != null) {
         Class97.anAClass6_Sub1_1.method758(this.anAClass6_Sub2_1);
         this.anAClass6_Sub2_1 = null;
      }

   }

   static void method633(AClass6 aclass6_0) {
      aclass6_0.aBool50 = false;
      if (aclass6_0.anAClass4_1 != null) {
         aclass6_0.anAClass4_1.anInt330 = 0;
      }

      for (AClass6 aclass6_1 = aclass6_0.method660(); aclass6_1 != null; aclass6_1 = aclass6_0.method659()) {
         method633(aclass6_1);
      }

   }

   static IndexedSprite[] method634(IndexDataBase indexdatabase_0, int int_0, int int_1) {
      if (!TileStrategy.method628(indexdatabase_0, int_0, int_1)) {
         return null;
      } else {
         IndexedSprite[] indexedsprites_0 = new IndexedSprite[Class111.anInt216];

         for (int int_2 = 0; int_2 < Class111.anInt216; int_2++) {
            IndexedSprite indexedsprite_0 = indexedsprites_0[int_2] = new IndexedSprite();
            indexedsprite_0.width = Class111.anInt214;
            indexedsprite_0.originalHeight = Class111.anInt215;
            indexedsprite_0.offsetX = Class111.anIntArray54[int_2];
            indexedsprite_0.offsetY = Class7.offsetsY[int_2];
            indexedsprite_0.originalWidth = ItemContainer.anIntArray76[int_2];
            indexedsprite_0.height = Class6.anIntArray3[int_2];
            indexedsprite_0.palette = Class111.anIntArray55;
            indexedsprite_0.pixels = Class111.spritePixels[int_2];
         }

         Class98.method523();
         return indexedsprites_0;
      }
   }

}
