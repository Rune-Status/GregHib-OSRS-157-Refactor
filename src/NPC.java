public final class NPC extends Actor {

   NPCDefinition composition;

   protected Model getModel() {
      if (this.composition == null) {
         return null;
      } else {
         Sequence sequence_0 = super.animation != -1 && super.actionAnimationDisable == 0 ? ItemLayer.getAnimation(super.animation) : null;
         Sequence sequence_1 = super.poseAnimation != -1 && (super.poseAnimation != super.idlePoseAnimation || sequence_0 == null) ? ItemLayer.getAnimation(super.poseAnimation) : null;
         Model model_0 = this.composition.getChildModel(sequence_0, super.actionFrame, sequence_1, super.poseFrame);
         if (model_0 == null) {
            return null;
         } else {
            model_0.calculateDiagonals();
            super.anInt521 = model_0.modelHeight;
            if (super.graphic != -1 && super.currentAnimation != -1) {
               Model model_1 = Class106.getSpotAnimType(super.graphic).method763(super.currentAnimation);
               if (model_1 != null) {
                  model_1.method1026(0, -super.graphicHeight, 0);
                  Model[] models_0 = new Model[] {model_0, model_1};
                  model_0 = new Model(models_0, 2);
               }
            }

            if (this.composition.boundaryDimension == 1) {
               model_0.fitsOnSingleSquare = true;
            }

            return model_0;
         }
      }
   }

   boolean hasConfig() {
      return this.composition != null;
   }

   void method1066(int int_0, byte byte_0) {
      int int_1 = super.pathX[0];
      int int_2 = super.pathY[0];
      if (int_0 == 0) {
         --int_1;
         ++int_2;
      }

      if (int_0 == 1) {
         ++int_2;
      }

      if (int_0 == 2) {
         ++int_1;
         ++int_2;
      }

      if (int_0 == 3) {
         --int_1;
      }

      if (int_0 == 4) {
         ++int_1;
      }

      if (int_0 == 5) {
         --int_1;
         --int_2;
      }

      if (int_0 == 6) {
         --int_2;
      }

      if (int_0 == 7) {
         ++int_1;
         --int_2;
      }

      if (super.animation != -1 && ItemLayer.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if (super.queueSize < 9) {
         ++super.queueSize;
      }

      for (int int_3 = super.queueSize; int_3 > 0; --int_3) {
         super.pathX[int_3] = super.pathX[int_3 - 1];
         super.pathY[int_3] = super.pathY[int_3 - 1];
         super.pathRun[int_3] = super.pathRun[int_3 - 1];
      }

      super.pathX[0] = int_1;
      super.pathY[0] = int_2;
      super.pathRun[0] = byte_0;
   }

   void method1067(int int_0, int int_1, boolean bool_0) {
      if (super.animation != -1 && ItemLayer.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if (!bool_0) {
         int int_2 = int_0 - super.pathX[0];
         int int_3 = int_1 - super.pathY[0];
         if (int_2 >= -8 && int_2 <= 8 && int_3 >= -8 && int_3 <= 8) {
            if (super.queueSize < 9) {
               ++super.queueSize;
            }

            for (int int_4 = super.queueSize; int_4 > 0; --int_4) {
               super.pathX[int_4] = super.pathX[int_4 - 1];
               super.pathY[int_4] = super.pathY[int_4 - 1];
               super.pathRun[int_4] = super.pathRun[int_4 - 1];
            }

            super.pathX[0] = int_0;
            super.pathY[0] = int_1;
            super.pathRun[0] = 1;
            return;
         }
      }

      super.queueSize = 0;
      super.anInt511 = 0;
      super.anInt512 = 0;
      super.pathX[0] = int_0;
      super.pathY[0] = int_1;
      super.x = super.anInt513 * 64 + super.pathX[0] * 128;
      super.y = super.anInt513 * 64 + super.pathY[0] * 128;
   }

}
