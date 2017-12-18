public class NPCDefinition extends CacheableNode {

   public static NodeCache npcModelCache;
   public static NodeCache npcs;
   public static IndexDataBase anIndexDataBase28;
   public static IndexDataBase npcCacheIndex;
   IterableHashTable parameters;
   int varpIndex;
   public int[] transformIds;
   public String name;
   int settingsId;
   int[] headModelIndices;
   int[] modelIds;
   public int id;
   public int boundaryDimension;
   public int standAnimationId;
   public int walkAnimationId;
   public int anInt492;
   public int anInt493;
   public String[] options;
   int sizeXZ;
   short[] colourToFind;
   public boolean isMinimapVisible;
   int sizeY;
   short[] textureToFind;
   short[] colourToReplace;
   public int turnAroundAnimationId;
   short[] textureToReplace;
   public int turnRightAnimationId;
   public int combatLevel;
   public boolean visible;
   public int turnLeftAnimationId;
   int brightness;
   int contrast;
   public int headIcon;
   public int degreesToTurn;
   public boolean aBool66;
   public boolean isClickable;
   public boolean aBool67;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCDefinition() {
      this.name = "null";
      this.boundaryDimension = 1;
      this.standAnimationId = -1;
      this.anInt492 = -1;
      this.anInt493 = -1;
      this.walkAnimationId = -1;
      this.turnAroundAnimationId = -1;
      this.turnRightAnimationId = -1;
      this.turnLeftAnimationId = -1;
      this.options = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.sizeXZ = 128;
      this.sizeY = 128;
      this.visible = false;
      this.brightness = 0;
      this.contrast = 0;
      this.headIcon = -1;
      this.degreesToTurn = 32;
      this.varpIndex = -1;
      this.settingsId = -1;
      this.aBool66 = true;
      this.isClickable = true;
      this.aBool67 = false;
   }

   public static NPCDefinition getNpcDefinition(int id) {
      NPCDefinition definition = (NPCDefinition) npcs.get((long)id);
      if (definition != null) {
         return definition;
      } else {
         byte[] data = npcCacheIndex.getConfigData(9, id);
         definition = new NPCDefinition();
         definition.id = id;
         if (data != null) {
            definition.decode(new Buffer(data));
         }

         definition.post();
         npcs.put(definition, (long)id);
         return definition;
      }
   }

   public NPCDefinition transform() {
      int varbitId = -1;
      if (this.varpIndex != -1) {
         varbitId = Varbit.getVarbit(this.varpIndex);
      } else if (this.settingsId != -1) {
         varbitId = Settings.widgetSettings[this.settingsId];
      }

      int childId;
      if (varbitId >= 0 && varbitId < this.transformIds.length - 1) {
         childId = this.transformIds[varbitId];
      } else {
         childId = this.transformIds[this.transformIds.length - 1];
      }

      return childId != -1 ? getNpcDefinition(childId) : null;
   }

   void decode(Buffer buffer, int opcode) {
      int size;
      int index;
      if (opcode == 1) {
         size = buffer.getUnsignedByte();
         this.modelIds = new int[size];

         for (index = 0; index < size; index++) {
            this.modelIds[index] = buffer.getUnsignedShort();
         }
      } else if (opcode == 2) {
         this.name = buffer.readString();
      } else if (opcode == 12) {
         this.boundaryDimension = buffer.getUnsignedByte();
      } else if (opcode == 13) {
         this.standAnimationId = buffer.getUnsignedShort();
      } else if (opcode == 14) {
         this.walkAnimationId = buffer.getUnsignedShort();
      } else if (opcode == 15) {
         this.anInt492 = buffer.getUnsignedShort();
      } else if (opcode == 16) {
         this.anInt493 = buffer.getUnsignedShort();
      } else if (opcode == 17) {
         this.walkAnimationId = buffer.getUnsignedShort();
         this.turnAroundAnimationId = buffer.getUnsignedShort();
         this.turnRightAnimationId = buffer.getUnsignedShort();
         this.turnLeftAnimationId = buffer.getUnsignedShort();
      } else if (opcode >= 30 && opcode < 35) {
         this.options[opcode - 30] = buffer.readString();
         if (this.options[opcode - 30].equalsIgnoreCase("Hidden")) {
            this.options[opcode - 30] = null;
         }
      } else if (opcode == 40) {
         size = buffer.getUnsignedByte();
         this.colourToFind = new short[size];
         this.colourToReplace = new short[size];

         for (index = 0; index < size; index++) {
            this.colourToFind[index] = (short)buffer.getUnsignedShort();
            this.colourToReplace[index] = (short)buffer.getUnsignedShort();
         }
      } else if (opcode == 41) {
         size = buffer.getUnsignedByte();
         this.textureToFind = new short[size];
         this.textureToReplace = new short[size];

         for (index = 0; index < size; index++) {
            this.textureToFind[index] = (short)buffer.getUnsignedShort();
            this.textureToReplace[index] = (short)buffer.getUnsignedShort();
         }
      } else if (opcode == 60) {
         size = buffer.getUnsignedByte();
         this.headModelIndices = new int[size];

         for (index = 0; index < size; index++) {
            this.headModelIndices[index] = buffer.getUnsignedShort();
         }
      } else if (opcode == 93) {
         this.isMinimapVisible = false;
      } else if (opcode == 95) {
         this.combatLevel = buffer.getUnsignedShort();
      } else if (opcode == 97) {
         this.sizeXZ = buffer.getUnsignedShort();
      } else if (opcode == 98) {
         this.sizeY = buffer.getUnsignedShort();
      } else if (opcode == 99) {
         this.visible = true;
      } else if (opcode == 100) {
         this.brightness = buffer.readByte();
      } else if (opcode == 101) {
         this.contrast = buffer.readByte() * 5;
      } else if (opcode == 102) {
         this.headIcon = buffer.getUnsignedShort();
      } else if (opcode == 103) {
         this.degreesToTurn = buffer.getUnsignedShort();
      } else if (opcode != 106 && opcode != 118) {
         if (opcode == 107) {
            this.aBool66 = false;
         } else if (opcode == 109) {
            this.isClickable = false;
         } else if (opcode == 111) {
            this.aBool67 = true;
         } else if (opcode == 249) {
            this.parameters = Tile.decodeParameters(buffer, this.parameters);
         }
      } else {
         this.varpIndex = buffer.getUnsignedShort();
         if (this.varpIndex == 65535) {
            this.varpIndex = -1;
         }

         this.settingsId = buffer.getUnsignedShort();
         if (this.settingsId == 65535) {
            this.settingsId = -1;
         }

         size = -1;
         if (opcode == 118) {
            size = buffer.getUnsignedShort();
            if (size == 65535) {
               size = -1;
            }
         }

         index = buffer.getUnsignedByte();
         this.transformIds = new int[index + 2];

         for (int int_3 = 0; int_3 <= index; int_3++) {
            this.transformIds[int_3] = buffer.getUnsignedShort();
            if (this.transformIds[int_3] == 65535) {
               this.transformIds[int_3] = -1;
            }
         }

         this.transformIds[index + 1] = size;
      }

   }

   public Model getChildModel(Sequence primarySequence, int primaryFrame, Sequence secondarySequence, int secondaryFrame) {
      if (this.transformIds != null) {
         NPCDefinition definition = this.transform();
         return definition == null ? null : definition.getChildModel(primarySequence, primaryFrame, secondarySequence, secondaryFrame);
      } else {
         Model childIdModel = (Model) npcModelCache.get((long)this.id);
         if (childIdModel == null) {
            boolean exists = false;

            for (int id = 0; id < this.modelIds.length; id++) {
               if (!anIndexDataBase28.modelExists(this.modelIds[id], 0)) {
                  exists = true;
               }
            }

            if (exists) {
               return null;
            }

            ModelHeader[] childModels = new ModelHeader[this.modelIds.length];

            int model;
            for (model = 0; model < this.modelIds.length; model++) {
               childModels[model] = ModelHeader.getModel(anIndexDataBase28, this.modelIds[model], 0);
            }

            ModelHeader header;
            if (childModels.length == 1) {
               header = childModels[0];
            } else {
               header = new ModelHeader(childModels, childModels.length);
            }

            if (this.colourToFind != null) {
               for (model = 0; model < this.colourToFind.length; model++) {
                  header.recolor(this.colourToFind[model], this.colourToReplace[model]);
               }
            }

            if (this.textureToFind != null) {
               for (model = 0; model < this.textureToFind.length; model++) {
                  header.retexture(this.textureToFind[model], this.textureToReplace[model]);
               }
            }

            childIdModel = header.applyLighting(this.brightness + 64, this.contrast + 850, -30, -50, -30);
            npcModelCache.put(childIdModel, (long)this.id);
         }

         Model childModel;
         if (primarySequence != null && secondarySequence != null) {
            childModel = primarySequence.method914(childIdModel, primaryFrame, secondarySequence, secondaryFrame);
         } else if (primarySequence != null) {
            childModel = primarySequence.method913(childIdModel, primaryFrame);
         } else if (secondarySequence != null) {
            childModel = secondarySequence.method913(childIdModel, secondaryFrame);
         } else {
            childModel = childIdModel.replaceAlphaValues(true);
         }

         if (this.sizeXZ != 128 || this.sizeY != 128) {
            childModel.scaleTriangle(this.sizeXZ, this.sizeY, this.sizeXZ);
         }

         return childModel;
      }
   }

   public ModelHeader getChildHeader() {
      if (this.transformIds != null) {
         NPCDefinition definition = this.transform();
         return definition == null ? null : definition.getChildHeader();
      } else if (this.headModelIndices == null) {
         return null;
      } else {
         boolean exists = false;

         for (int index = 0; index < this.headModelIndices.length; index++) {
            if (!anIndexDataBase28.modelExists(this.headModelIndices[index], 0)) {
               exists = true;
            }
         }

         if (exists) {
            return null;
         } else {
            ModelHeader[] headers = new ModelHeader[this.headModelIndices.length];

            for (int index = 0; index < this.headModelIndices.length; index++) {
               headers[index] = ModelHeader.getModel(anIndexDataBase28, this.headModelIndices[index], 0);
            }

            ModelHeader header;
            if (headers.length == 1) {
               header = headers[0];
            } else {
               header = new ModelHeader(headers, headers.length);
            }

            int colour;
            if (this.colourToFind != null) {
               for (colour = 0; colour < this.colourToFind.length; colour++) {
                  header.recolor(this.colourToFind[colour], this.colourToReplace[colour]);
               }
            }

            if (this.textureToFind != null) {
               for (colour = 0; colour < this.textureToFind.length; colour++) {
                  header.retexture(this.textureToFind[colour], this.textureToReplace[colour]);
               }
            }

            return header;
         }
      }
   }

   void post() {
   }

   void decode(Buffer buffer) {
      while (true) {
         int opcode = buffer.getUnsignedByte();
         if (opcode == 0) {
            return;
         }

         this.decode(buffer, opcode);
      }
   }

   public boolean childExists() {
      if (this.transformIds == null) {
         return true;
      } else {
         int childId = -1;
         if (this.varpIndex != -1) {
            childId = Varbit.getVarbit(this.varpIndex);
         } else if (this.settingsId != -1) {
            childId = Settings.widgetSettings[this.settingsId];
         }

         return childId >= 0 && childId < this.transformIds.length ? this.transformIds[childId] != -1 : this.transformIds[this.transformIds.length - 1] != -1;
      }
   }

   public String method901(int int_0, String string_0) {
      return VertexNormal.method492(this.parameters, int_0, string_0);
   }

   public int method902(int int_0, int int_1) {
      return Occluder.method392(this.parameters, int_0, int_1);
   }

   public static int method903(CharSequence charsequence_0, CharSequence charsequence_1, int int_0) {
      int int_1 = charsequence_0.length();
      int int_2 = charsequence_1.length();
      int int_3 = 0;
      int int_4 = 0;
      char char_0 = 0;
      char char_1 = 0;

      while (int_3 - char_0 < int_1 || int_4 - char_1 < int_2) {
         if (int_3 - char_0 >= int_1) {
            return -1;
         }

         if (int_4 - char_1 >= int_2) {
            return 1;
         }

         char char_2;
         if (char_0 != 0) {
            char_2 = char_0;
            boolean bool_0 = false;
         } else {
            char_2 = charsequence_0.charAt(int_3++);
         }

         char char_3;
         if (char_1 != 0) {
            char_3 = char_1;
            boolean bool_1 = false;
         } else {
            char_3 = charsequence_1.charAt(int_4++);
         }

         char_0 = Class70.method420(char_2);
         char_1 = Class70.method420(char_3);
         char_2 = AClass1_Sub2.method641(char_2);
         char_3 = AClass1_Sub2.method641(char_3);
         if (char_2 != char_3 && Character.toUpperCase(char_2) != Character.toUpperCase(char_3)) {
            char_2 = Character.toLowerCase(char_2);
            char_3 = Character.toLowerCase(char_3);
            if (char_3 != char_2) {
               return AClass3.method645(char_2) - AClass3.method645(char_3);
            }
         }
      }

      int int_5 = Math.min(int_1, int_2);

      char char_5;
      int int_6;
      for (int_6 = 0; int_6 < int_5; int_6++) {
         char char_4 = charsequence_0.charAt(int_6);
         char_5 = charsequence_1.charAt(int_6);
         if (char_5 != char_4 && Character.toUpperCase(char_4) != Character.toUpperCase(char_5)) {
            char_4 = Character.toLowerCase(char_4);
            char_5 = Character.toLowerCase(char_5);
            if (char_4 != char_5) {
               return AClass3.method645(char_4) - AClass3.method645(char_5);
            }
         }
      }

      int_6 = int_1 - int_2;
      if (int_6 != 0) {
         return int_6;
      } else {
         for (int int_7 = 0; int_7 < int_5; int_7++) {
            char_5 = charsequence_0.charAt(int_7);
            char char_6 = charsequence_1.charAt(int_7);
            if (char_6 != char_5) {
               return AClass3.method645(char_5) - AClass3.method645(char_6);
            }
         }

         return 0;
      }
   }

}
