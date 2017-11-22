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
   boolean aBool83;
   Model model;
   int anInt596;
   int anInt597;
   int anInt598;
   int anInt599;
   int currentPlane;
   String name;
   int localPlayerIndex;
   int anInt602;
   int anInt603;
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
      this.aBool83 = false;
   }

   protected Model getModel() {
      if (this.composition == null) {
         return null;
      } else {
         Sequence sequence_0 = super.animation != -1 && super.actionAnimationDisable == 0 ? ItemLayer.getAnimation(super.animation) : null;
         Sequence sequence_1 = super.poseAnimation != -1 && !this.aBool82 && (super.idlePoseAnimation != super.poseAnimation || sequence_0 == null) ? ItemLayer.getAnimation(super.poseAnimation) : null;
         Model model_0 = this.composition.method505(sequence_0, super.actionFrame, sequence_1, super.poseFrame);
         if (model_0 == null) {
            return null;
         } else {
            model_0.method1007();
            super.anInt521 = model_0.modelHeight;
            Model model_1;
            Model[] models_0;
            if (!this.aBool82 && super.graphic != -1 && super.currentAnimation != -1) {
               model_1 = Class106.getSpotAnimType(super.graphic).method763(super.currentAnimation);
               if (model_1 != null) {
                  model_1.method1026(0, -super.graphicHeight, 0);
                  models_0 = new Model[] {model_0, model_1};
                  model_0 = new Model(models_0, 2);
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

                  models_0 = new Model[] {model_0, model_1};
                  model_0 = new Model(models_0, 2);
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

            model_0.aBool75 = true;
            return model_0;
         }
      }
   }

   void method1093(int int_0, int int_1) {
      super.queueSize = 0;
      super.anInt511 = 0;
      super.anInt512 = 0;
      super.pathX[0] = int_0;
      super.pathY[0] = int_1;
      int int_2 = this.getSize();
      super.x = super.pathX[0] * 128 + int_2 * 64;
      super.y = int_2 * 64 + super.pathY[0] * 128;
   }

   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1 ? Class27.getNpcDefinition(this.composition.transformedNpcId).anInt489 : 1;
   }

   void method1094(int int_0, int int_1, byte byte_0) {
      if (super.queueSize < 9) {
         ++super.queueSize;
      }

      for (int int_2 = super.queueSize; int_2 > 0; --int_2) {
         super.pathX[int_2] = super.pathX[int_2 - 1];
         super.pathY[int_2] = super.pathY[int_2 - 1];
         super.aByteArray20[int_2] = super.aByteArray20[int_2 - 1];
      }

      super.pathX[0] = int_0;
      super.pathY[0] = int_1;
      super.aByteArray20[0] = byte_0;
   }

   boolean hasConfig() {
      return this.composition != null;
   }

   void method1095(int int_0, int int_1, byte byte_0) {
      if (super.animation != -1 && ItemLayer.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.anInt510 = -1;
      if (int_0 >= 0 && int_0 < 104 && int_1 >= 0 && int_1 < 104) {
         if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if (byte_0 == 2) {
               Player player_1 = this;
               int int_2 = super.pathX[0];
               int int_3 = super.pathY[0];
               int int_4 = this.getSize();
               if (int_2 >= int_4 && int_2 < 104 - int_4 && int_3 >= int_4 && int_3 < 104 - int_4 && int_0 >= int_4 && int_0 < 104 - int_4 && int_1 >= int_4 && int_1 < 104 - int_4) {
                  int int_5 = this.getSize();
                  Client.anAClass2_Sub1_1.anInt160 = int_0;
                  Client.anAClass2_Sub1_1.anInt161 = int_1;
                  Client.anAClass2_Sub1_1.anInt162 = 1;
                  Client.anAClass2_Sub1_1.anInt163 = 1;
                  AClass2_Sub1 aclass2_sub1_0 = Client.anAClass2_Sub1_1;
                  int int_6 = Class49.method316(int_2, int_3, int_5, aclass2_sub1_0, Client.collisionMaps[this.currentPlane], true, Client.anIntArray146, Client.anIntArray147);
                  if (int_6 >= 1) {
                     for (int int_7 = 0; int_7 < int_6 - 1; int_7++) {
                        player_1.method1094(Client.anIntArray146[int_7], Client.anIntArray147[int_7], (byte) 2);
                     }
                  }
               }
            }

            this.method1094(int_0, int_1, byte_0);
         } else {
            this.method1093(int_0, int_1);
         }
      } else {
         this.method1093(int_0, int_1);
      }

   }

   void decodeAppearance(Buffer buffer) {
      buffer.offset = 0;
      int gender = buffer.readUnsignedByte();
      this.skullIcon = buffer.readByte();
      this.overheadIcon = buffer.readByte();
      int npcId = -1;
      this.team = 0;
      int[] appearanceModels = new int[12];

      for (int bodyPart = 0; bodyPart < 12; bodyPart++) {
         int reset = buffer.readUnsignedByte();
         if (reset == 0) {
            appearanceModels[bodyPart] = 0;
         } else {
            int id = buffer.readUnsignedByte();
            appearanceModels[bodyPart] = id + (reset << 8);
            if (bodyPart == 0 && appearanceModels[0] == 65535) {
               npcId = buffer.readUnsignedShort();
               break;
            }

            if (appearanceModels[bodyPart] >= 512) {
               int team = CacheableNode_Sub2.getItemDefinition(appearanceModels[bodyPart] - 512).anInt504;
               if (team != 0) {
                  this.team = team;
               }
            }
         }
      }

      int[] appearanceColours = new int[5];

      for (int index = 0; index < 5; index++) {
         int colour = buffer.readUnsignedByte();
         if (colour < 0 || colour >= PlayerComposition.colorsToReplace[index].length) {
            colour = 0;
         }

         appearanceColours[index] = colour;
      }

      super.idlePoseAnimation = buffer.readUnsignedShort();
      if (super.idlePoseAnimation == 65535) {
         super.idlePoseAnimation = -1;
      }

      super.turnAnimation = buffer.readUnsignedShort();
      if (super.turnAnimation == 65535) {
         super.turnAnimation = -1;
      }

      super.anInt515 = super.turnAnimation;
      super.walkingAnimation = buffer.readUnsignedShort();
      if (super.walkingAnimation == 65535) {
         super.walkingAnimation = -1;
      }

      super.halfTurnAnimation = buffer.readUnsignedShort();
      if (super.halfTurnAnimation == 65535) {
         super.halfTurnAnimation = -1;
      }

      super.quarterClockwiseTurnAnimation = buffer.readUnsignedShort();
      if (super.quarterClockwiseTurnAnimation == 65535) {
         super.quarterClockwiseTurnAnimation = -1;
      }

      super.quarterAnticlockwiseTurnAnimation = buffer.readUnsignedShort();
      if (super.quarterAnticlockwiseTurnAnimation == 65535) {
         super.quarterAnticlockwiseTurnAnimation = -1;
      }

      super.runAnimation = buffer.readUnsignedShort();
      if (super.runAnimation == 65535) {
         super.runAnimation = -1;
      }

      this.name = buffer.readString();
      if (this == Class4.localPlayer) {
         RuntimeException_Sub1.localPlayerName = this.name;
      }

      this.combatLevel = buffer.readUnsignedByte();
      this.totalLevel = buffer.readUnsignedShort();
      this.hidden = buffer.readUnsignedByte() == 1;
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
