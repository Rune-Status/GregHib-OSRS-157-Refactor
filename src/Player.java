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
   int anInt600;
   String name;
   int anInt601;
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
                  int int_6 = Class49.method316(int_2, int_3, int_5, aclass2_sub1_0, Client.collisionMaps[this.anInt600], true, Client.anIntArray146, Client.anIntArray147);
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

   void decodeApperance(Buffer buffer_0) {
      buffer_0.offset = 0;
      int int_0 = buffer_0.readUnsignedByte();
      this.skullIcon = buffer_0.readByte();
      this.overheadIcon = buffer_0.readByte();
      int int_1 = -1;
      this.team = 0;
      int[] ints_0 = new int[12];

      int int_3;
      int int_4;
      for (int int_2 = 0; int_2 < 12; int_2++) {
         int_3 = buffer_0.readUnsignedByte();
         if (int_3 == 0) {
            ints_0[int_2] = 0;
         } else {
            int_4 = buffer_0.readUnsignedByte();
            ints_0[int_2] = int_4 + (int_3 << 8);
            if (int_2 == 0 && ints_0[0] == 65535) {
               int_1 = buffer_0.readUnsignedShort();
               break;
            }

            if (ints_0[int_2] >= 512) {
               int int_5 = CacheableNode_Sub2.getItemDefinition(ints_0[int_2] - 512).anInt504;
               if (int_5 != 0) {
                  this.team = int_5;
               }
            }
         }
      }

      int[] ints_1 = new int[5];

      for (int_3 = 0; int_3 < 5; int_3++) {
         int_4 = buffer_0.readUnsignedByte();
         if (int_4 < 0 || int_4 >= PlayerComposition.colorsToReplace[int_3].length) {
            int_4 = 0;
         }

         ints_1[int_3] = int_4;
      }

      super.idlePoseAnimation = buffer_0.readUnsignedShort();
      if (super.idlePoseAnimation == 65535) {
         super.idlePoseAnimation = -1;
      }

      super.anInt514 = buffer_0.readUnsignedShort();
      if (super.anInt514 == 65535) {
         super.anInt514 = -1;
      }

      super.anInt515 = super.anInt514;
      super.anInt516 = buffer_0.readUnsignedShort();
      if (super.anInt516 == 65535) {
         super.anInt516 = -1;
      }

      super.anInt517 = buffer_0.readUnsignedShort();
      if (super.anInt517 == 65535) {
         super.anInt517 = -1;
      }

      super.anInt518 = buffer_0.readUnsignedShort();
      if (super.anInt518 == 65535) {
         super.anInt518 = -1;
      }

      super.anInt519 = buffer_0.readUnsignedShort();
      if (super.anInt519 == 65535) {
         super.anInt519 = -1;
      }

      super.anInt520 = buffer_0.readUnsignedShort();
      if (super.anInt520 == 65535) {
         super.anInt520 = -1;
      }

      this.name = buffer_0.readString();
      if (this == Class4.localPlayer) {
         RuntimeException_Sub1.aString32 = this.name;
      }

      this.combatLevel = buffer_0.readUnsignedByte();
      this.totalLevel = buffer_0.readUnsignedShort();
      this.hidden = buffer_0.readUnsignedByte() == 1;
      if (Client.socketType == 0 && Client.rights >= 2) {
         this.hidden = false;
      }

      if (this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method504(ints_0, ints_1, int_0 == 1, int_1);
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
