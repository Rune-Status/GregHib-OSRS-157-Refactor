public final class Projectile extends Renderable {

   int id;
   boolean isMoving;
   int x1;
   int cycle;
   double x;
   double aDouble1;
   int anInt549;
   int y1;
   int anInt550;
   int rotationY;
   double velocityZ;
   int start;
   double scalar;
   int floor;
   double z;
   double velocityX;
   double heightOffset;
   int height;
   int startTime;
   double velocityY;
   int slope;
   int interacting;
   int endHeight;
   int rotationX;
   Sequence animationSequence;

   Projectile(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8, int int_9, int int_10) {
      this.isMoving = false;
      this.anInt549 = 0;
      this.anInt550 = 0;
      this.id = int_0;
      this.floor = int_1;
      this.x1 = int_2;
      this.y1 = int_3;
      this.height = int_4;
      this.startTime = int_5;
      this.cycle = int_6;
      this.slope = int_7;
      this.start = int_8;
      this.interacting = int_9;
      this.endHeight = int_10;
      this.isMoving = false;
      int int_11 = Class106.getSpotAnimType(this.id).anInt420;
      if (int_11 != -1) {
         this.animationSequence = ItemLayer.getAnimation(int_11);
      } else {
         this.animationSequence = null;
      }

   }

   protected Model getRotatedModel() {
      Spotanim spotanim_0 = Class106.getSpotAnimType(this.id);
      Model model_0 = spotanim_0.method763(this.anInt549);
      if (model_0 == null) {
         return null;
      } else {
         model_0.method1016(this.rotationY);
         return model_0;
      }
   }

   void method1005(int int_0, int int_1, int int_2, int int_3) {
      double double_0;
      if (!this.isMoving) {
         double_0 = (double)(int_0 - this.x1);
         double double_1 = (double)(int_1 - this.y1);
         double double_2 = Math.sqrt(double_1 * double_1 + double_0 * double_0);
         this.x = (double)this.start * double_0 / double_2 + (double)this.x1;
         this.velocityZ = double_1 * (double)this.start / double_2 + (double)this.y1;
         this.z = (double)this.height;
      }

      double_0 = (double)(this.cycle + 1 - int_3);
      this.aDouble1 = ((double)int_0 - this.x) / double_0;
      this.scalar = ((double)int_1 - this.velocityZ) / double_0;
      this.velocityY = Math.sqrt(this.aDouble1 * this.aDouble1 + this.scalar * this.scalar);
      if (!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan(0.02454369D * (double)this.slope);
      }

      this.heightOffset = ((double)int_2 - this.z - this.velocityX * double_0) * 2.0D / (double_0 * double_0);
   }

   void method1006(int int_0) {
      this.isMoving = true;
      this.x += this.aDouble1 * (double)int_0;
      this.velocityZ += (double)int_0 * this.scalar;
      this.z += this.velocityX * (double)int_0 + 0.5D * this.heightOffset * (double)int_0 * (double)int_0;
      this.velocityX += (double)int_0 * this.heightOffset;
      this.rotationX = (int)(Math.atan2(this.aDouble1, this.scalar) * 325.949D) + 1024 & 0x7FF;
      this.rotationY = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 0x7FF;
      if (this.animationSequence != null) {
         this.anInt550 += int_0;

         while (true) {
            do {
               do {
                  if (this.anInt550 <= this.animationSequence.frameLenghts[this.anInt549]) {
                     return;
                  }

                  this.anInt550 -= this.animationSequence.frameLenghts[this.anInt549];
                  ++this.anInt549;
               } while (this.anInt549 < this.animationSequence.frameIDs.length);

               this.anInt549 -= this.animationSequence.frameStep;
            } while (this.anInt549 >= 0 && this.anInt549 < this.animationSequence.frameIDs.length);

            this.anInt549 = 0;
         }
      }
   }

   public static int getLength(String string_0) {
      return string_0.length() + 1;
   }

}
