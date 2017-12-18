public class GameObject extends Renderable {

   Sequence sequence;
   int id;
   int animationCycleDelay;
   int type;
   int orientation;
   int level;
   int animationFrame;
   int sceneX;
   int sceneY;

   GameObject(int id, int type, int orientation, int plane, int x, int y, int animation, boolean randomFrame, Renderable renderable) {
      this.id = id;
      this.type = type;
      this.orientation = orientation;
      this.level = plane;
      this.sceneX = x;
      this.sceneY = y;
      if (animation != -1) {
         this.sequence = ItemLayer.getAnimation(animation);
         this.animationFrame = 0;
         this.animationCycleDelay = Client.gameCycle - 1;
         if (this.sequence.replyMode == 0 && renderable != null && renderable instanceof GameObject) {
            GameObject object = (GameObject) renderable;
            if (object.sequence == this.sequence) {
               this.animationFrame = object.animationFrame;
               this.animationCycleDelay = object.animationCycleDelay;
               return;
            }
         }

         if (randomFrame && this.sequence.frameStep != -1) {
            this.animationFrame = (int)(Math.random() * (double)this.sequence.frameIDs.length);
            this.animationCycleDelay -= (int)(Math.random() * (double)this.sequence.frameLenghts[this.animationFrame]);
         }
      }

   }

   static int getRgbTableId(int hslBitmap, int lightIntensity) {
       if (hslBitmap == -1) {
          return 12345678;
       } else {
          lightIntensity = (hslBitmap & 0x7F) * lightIntensity / 128;
          if (lightIntensity < 2) {
             lightIntensity = 2;
          } else if (lightIntensity > 126) {
             lightIntensity = 126;
          }

          return (hslBitmap & 0xFF80) + lightIntensity;
       }
    }

    protected Model getRotatedModel() {
      if (this.sequence != null) {
         int step = Client.gameCycle - this.animationCycleDelay;
         if (step > 100 && this.sequence.frameStep > 0) {
            step = 100;
         }

         frameLoop: {
            do {
               do {
                  if (step <= this.sequence.frameLenghts[this.animationFrame]) {
                     break frameLoop;
                  }

                  step -= this.sequence.frameLenghts[this.animationFrame];
                  ++this.animationFrame;
               } while (this.animationFrame < this.sequence.frameIDs.length);

               this.animationFrame -= this.sequence.frameStep;
            } while (this.animationFrame >= 0 && this.animationFrame < this.sequence.frameIDs.length);

            this.sequence = null;
         }

         this.animationCycleDelay = Client.gameCycle - step;
      }

      ObjectDefinition definition = ObjectDefinition.getDefinition(this.id);
      if (definition.transformationIds != null) {
         definition = definition.morph();
      }

      if (definition == null) {
         return null;
      } else {
         int sizeX;
         int sizeY;
         if (this.orientation != 1 && this.orientation != 3) {
            sizeX = definition.sizeX;
            sizeY = definition.sizeY;
         } else {
            sizeX = definition.sizeY;
            sizeY = definition.sizeX;
         }

         int primaryX = (sizeX >> 1) + this.sceneX;
         int secondaryX = (sizeX + 1 >> 1) + this.sceneX;
         int primaryY = (sizeY >> 1) + this.sceneY;
         int secondaryY = (sizeY + 1 >> 1) + this.sceneY;
         int[][] heights = Class19.tileHeights[this.level];
         int mean = heights[secondaryX][secondaryY] + heights[primaryX][secondaryY] + heights[secondaryX][primaryY] + heights[primaryX][primaryY] >> 2;
         int x = (this.sceneX << 7) + (sizeX << 6);
         int y = (this.sceneY << 7) + (sizeY << 6);
         return definition.getModelAt(this.type, this.orientation, heights, x, mean, y, this.sequence, this.animationFrame);
      }
   }

}
