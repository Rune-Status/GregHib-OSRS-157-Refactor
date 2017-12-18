public final class AudioObject extends Node {

   static Deque aDeque3;
   int ambientSound;
   ObjectDefinition transformationDefinition;
   int anInt316;
   int anInt317;
   int anInt318;
   int[] anIntArray72;
   AClass6_Sub2 anAClass6_Sub2_1;
   int anInt319;
   int x;
   int anInt321;
   int y;
   int plane;
   AClass6_Sub2 anAClass6_Sub2_2;
   int anInt324;

   static {
      aDeque3 = new Deque();
   }

   void method632() {
      int int_0 = this.ambientSound;
      ObjectDefinition definition = this.transformationDefinition.morph();
      if (definition != null) {
         this.ambientSound = definition.ambientSoundId;
         this.anInt316 = definition.anInt463 * 128;
         this.anInt317 = definition.anInt464;
         this.anInt318 = definition.anInt465;
         this.anIntArray72 = definition.anIntArray85;
      } else {
         this.ambientSound = -1;
         this.anInt316 = 0;
         this.anInt317 = 0;
         this.anInt318 = 0;
         this.anIntArray72 = null;
      }

      if (int_0 != this.ambientSound && this.anAClass6_Sub2_1 != null) {
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

}
