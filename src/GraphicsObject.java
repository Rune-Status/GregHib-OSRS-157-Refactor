public final class GraphicsObject extends Renderable {

   int id;
   boolean finished;
   int anInt541;
   int anInt542;
   Sequence aSequence1;
   int level;
   int x;
   int y;
   int height;
   int startCycle;

   GraphicsObject(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6) {
      this.anInt542 = 0;
      this.anInt541 = 0;
      this.finished = false;
      this.id = int_0;
      this.level = int_1;
      this.x = int_2;
      this.y = int_3;
      this.height = int_4;
      this.startCycle = int_6 + int_5;
      int int_7 = Class106.getSpotAnimType(this.id).anInt420;
      if (int_7 != -1) {
         this.finished = false;
         this.aSequence1 = ItemLayer.getAnimation(int_7);
      } else {
         this.finished = true;
      }

   }

   protected Model getModel() {
      Spotanim spotanim_0 = Class106.getSpotAnimType(this.id);
      Model model_0;
      if (!this.finished) {
         model_0 = spotanim_0.method763(this.anInt542);
      } else {
         model_0 = spotanim_0.method763(-1);
      }

      return model_0 == null ? null : model_0;
   }

   void method956(int int_0) {
      if (!this.finished) {
         this.anInt541 += int_0;

         while (this.anInt541 > this.aSequence1.frameLenghts[this.anInt542]) {
            this.anInt541 -= this.aSequence1.frameLenghts[this.anInt542];
            ++this.anInt542;
            if (this.anInt542 >= this.aSequence1.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   public static int method957(int int_0) {
      return int_0 >> 11 & 0x3F;
   }

}
