public final class Player extends Actor {

   static int cameraY;
   static int anInt593;
   PlayerComposition composition;
   int skullIcon;
   int overheadIcon;
   boolean aBool82;
   String[] actions;
   int combatLevel;
   int totalLevel;
   int team;
   int anInt594;
   int anInt595;
   boolean hidden;
   boolean needsPositionUpdate;
   Model model;
   int anInt596;
   int anInt597;
   int anInt598;
   int anInt599;
   int currentPlane;
   String name;
   int localPlayerIndex;
   int targetX;
   int targetY;
   int anInt604;
   int anInt605;
   int anInt606;
   int anInt607;

   Player() {
      this.skullIcon = -1;
      this.overheadIcon = -1;
      this.actions = new String[3];

      for (int int_0 = 0; int_0 < 3; int_0++) {
         this.actions[int_0] = "";
      }

      this.combatLevel = 0;
      this.totalLevel = 0;
      this.anInt594 = 0;
      this.anInt595 = 0;
      this.aBool82 = false;
      this.team = 0;
      this.hidden = false;
      this.needsPositionUpdate = false;
   }

   protected Model getModel() {
      if (this.composition == null) {
         return null;
      } else {
         Sequence sequence_0 = super.animation != -1 && super.actionAnimationDisable == 0 ? ItemLayer.getAnimation(super.animation) : null;
         Sequence sequence_1 = super.poseAnimation != -1 && !this.aBool82 && (super.idlePoseAnimation != super.poseAnimation || sequence_0 == null) ? ItemLayer.getAnimation(super.poseAnimation) : null;
         Model animatedModel = this.composition.method505(sequence_0, super.actionFrame, sequence_1, super.poseFrame);
         if (animatedModel == null) {
            return null;
         } else {
            animatedModel.calculateDiagonals();
            super.anInt521 = animatedModel.modelHeight;
            Model model_1;
            Model[] models_0;
            if (!this.aBool82 && super.graphic != -1 && super.currentAnimation != -1) {
               model_1 = Class106.getSpotAnimType(super.graphic).method763(super.currentAnimation);
               if (model_1 != null) {
                  model_1.method1026(0, -super.graphicHeight, 0);
                  models_0 = new Model[] {animatedModel, model_1};
                  animatedModel = new Model(models_0, 2);
               }
            }

            if (!this.aBool82 && this.model != null) {
               if (Client.gameCycle >= this.anInt595) {
                  this.model = null;
               }

               if (Client.gameCycle >= this.anInt594 && Client.gameCycle < this.anInt595) {
                  model_1 = this.model;
                  model_1.method1026(this.anInt596 - super.x, this.anInt597 - this.anInt598, this.anInt599 - super.y);
                  if (super.orientation == 512) {
                     model_1.method1021();
                     model_1.method1021();
                     model_1.method1021();
                  } else if (super.orientation == 1024) {
                     model_1.method1021();
                     model_1.method1021();
                  } else if (super.orientation == 1536) {
                     model_1.method1021();
                  }

                  models_0 = new Model[] {animatedModel, model_1};
                  animatedModel = new Model(models_0, 2);
                  if (super.orientation == 512) {
                     model_1.method1021();
                  } else if (super.orientation == 1024) {
                     model_1.method1021();
                     model_1.method1021();
                  } else if (super.orientation == 1536) {
                     model_1.method1021();
                     model_1.method1021();
                     model_1.method1021();
                  }

                  model_1.method1026(super.x - this.anInt596, this.anInt598 - this.anInt597, super.y - this.anInt599);
               }
            }

            animatedModel.fitsOnSingleSquare = true;
            return animatedModel;
         }
      }
   }

   void setFirstStep(int x, int y) {
      super.queueSize = 0;
      super.anInt511 = 0;
      super.anInt512 = 0;
      super.pathX[0] = x;
      super.pathY[0] = y;
      int size = this.getSize();
      super.x = super.pathX[0] * 128 + size * 64;
      super.y = size * 64 + super.pathY[0] * 128;
   }

   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1 ? Class27.getNpcDefinition(this.composition.transformedNpcId).anInt489 : 1;
   }

   void appendPath(int x, int y, byte type) {
      if (super.queueSize < 9) {
         ++super.queueSize;
      }

      for (int i = super.queueSize; i > 0; --i) {
         super.pathX[i] = super.pathX[i - 1];
         super.pathY[i] = super.pathY[i - 1];
         super.pathRun[i] = super.pathRun[i - 1];
      }

      super.pathX[0] = x;
      super.pathY[0] = y;
      super.pathRun[0] = type;
   }

   boolean hasConfig() {
      return this.composition != null;
   }

   void move(int x, int y, byte type) {
      if (super.animation != -1 && ItemLayer.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.nextStepOrientation = -1;
      if (x >= 0 && x < 104 && y >= 0 && y < 104) {
         if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if (type == 2) {
               Player player = this;
               int pathX = super.pathX[0];
               int pathY = super.pathY[0];
               int size = this.getSize();
               if (pathX >= size && pathX < 104 - size && pathY >= size && pathY < 104 - size && x >= size && x < 104 - size && y >= size && y < 104 - size) {
                  Client.routeStrategy.approxDestinationX = x;
                  Client.routeStrategy.approxDestinationY = y;
                  Client.routeStrategy.approxDestinationSizeX = 1;
                  Client.routeStrategy.approxDestinationSizeY = 1;
                  TileStrategy routeStrategy = Client.routeStrategy;
                  int steps = Class49.findPath(pathX, pathY, size, routeStrategy, Client.collisionMaps[this.currentPlane], Client.tileQueueX, Client.tileQueueY);
                  if (steps >= 1) {
                     for (int index = 0; index < steps - 1; index++) {
                        player.appendPath(Client.tileQueueX[index], Client.tileQueueY[index], (byte) 2);
                     }
                  }
               }
            }

            this.appendPath(x, y, type);
         } else {
            this.setFirstStep(x, y);
         }
      } else {
         this.setFirstStep(x, y);
      }

   }

   void decodeAppearance(Buffer buffer) {
      buffer.position = 0;
      int gender = buffer.getUnsignedByte();
      this.skullIcon = buffer.readByte();
      this.overheadIcon = buffer.readByte();
      int npcId = -1;
      this.team = 0;
      int[] appearanceModels = new int[12];

      for (int bodyPart = 0; bodyPart < 12; bodyPart++) {
         int reset = buffer.getUnsignedByte();
         if (reset == 0) {
            appearanceModels[bodyPart] = 0;
         } else {
            int id = buffer.getUnsignedByte();
            appearanceModels[bodyPart] = id + (reset << 8);
            if (bodyPart == 0 && appearanceModels[0] == 65535) {
               npcId = buffer.getUnsignedShort();
               break;
            }

            if (appearanceModels[bodyPart] >= 512) {
               int team = ItemDefinition.getDefinition(appearanceModels[bodyPart] - 512).teamIndex;
               if (team != 0) {
                  this.team = team;
               }
            }
         }
      }

      int[] appearanceColours = new int[5];

      for (int index = 0; index < 5; index++) {
         int colour = buffer.getUnsignedByte();
         if (colour < 0 || colour >= PlayerComposition.colorsToReplace[index].length) {
            colour = 0;
         }

         appearanceColours[index] = colour;
      }

      super.idlePoseAnimation = buffer.getUnsignedShort();
      if (super.idlePoseAnimation == 65535) {
         super.idlePoseAnimation = -1;
      }

      super.turnAnimation = buffer.getUnsignedShort();
      if (super.turnAnimation == 65535) {
         super.turnAnimation = -1;
      }

      super.anInt515 = super.turnAnimation;
      super.walkingAnimation = buffer.getUnsignedShort();
      if (super.walkingAnimation == 65535) {
         super.walkingAnimation = -1;
      }

      super.halfTurnAnimation = buffer.getUnsignedShort();
      if (super.halfTurnAnimation == 65535) {
         super.halfTurnAnimation = -1;
      }

      super.quarterClockwiseTurnAnimation = buffer.getUnsignedShort();
      if (super.quarterClockwiseTurnAnimation == 65535) {
         super.quarterClockwiseTurnAnimation = -1;
      }

      super.quarterAnticlockwiseTurnAnimation = buffer.getUnsignedShort();
      if (super.quarterAnticlockwiseTurnAnimation == 65535) {
         super.quarterAnticlockwiseTurnAnimation = -1;
      }

      super.runAnimation = buffer.getUnsignedShort();
      if (super.runAnimation == 65535) {
         super.runAnimation = -1;
      }

      this.name = buffer.readString();
      if (this == Class4.localPlayer) {
         RuntimeException_Sub1.localPlayerName = this.name;
      }

      this.combatLevel = buffer.getUnsignedByte();
      this.totalLevel = buffer.getUnsignedShort();
      this.hidden = buffer.getUnsignedByte() == 1;
      if (Client.socketType == 0 && Client.rights >= 2) {
         this.hidden = false;
      }

      if (this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.updateAppearance(appearanceModels, appearanceColours, gender == 1, npcId);
   }

   static void method1096() {
      if (Client.spellSelected) {
         Widget widget_0 = Class74.method447(Class26.anInt87, Client.anInt656);
         if (widget_0 != null && widget_0.anObjectArray8 != null) {
            ScriptEvent scriptevent_0 = new ScriptEvent();
            scriptevent_0.widget = widget_0;
            scriptevent_0.anObjectArray22 = widget_0.anObjectArray8;
            Class52.method335(scriptevent_0);
         }

         Client.spellSelected = false;
         WorldMapData.method305(widget_0);
      }
   }

}
