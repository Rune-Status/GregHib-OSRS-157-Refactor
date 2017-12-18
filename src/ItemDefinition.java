public class ItemDefinition extends CacheableNode {

   static NodeCache items;
   static NodeCache itemModelCache;
   public static IndexDataBase itemDefinitionIndex;
   public static IndexDataBase item_ref;
   public static NodeCache itemSpriteCache;
   public static int anInt503;
   public static Font aFont5;
   int maleDialogModel;
   int maleEquipModel;
   int modelId;
   int[] stackIds;
   int team;
   IterableHashTable parameters;
   int maleDialogHat;
   int maleArmsId;
   int maleEmblem;
   public String[] inventoryOptions;
   public String name;
   int femaleDialogModel;
   public int modelInventoryZoom;
   public int id;
   int femaleEquipModel;
   int femaleDialogHat;
   int[] stackAmounts;
   int femaleArmsId;
   int femaleEmblem;
   public int modelInventoryRotationY;
   int groundScaleX;
   public int modelInventoryRotationX;
   public int spriteTranslateX;
   public int isStackable;
   int groundScaleY;
   public int spriteTranslateY;
   public int diagonalRotation;
   public boolean isMembers;
   short[] colourToReplace;
   public int price;
   int groundScaleZ;
   short[] textureToReplace;
   int maleEquipOffset;
   int femaleEquipOffset;
   public int noteTemplateIndex;
   short[] colourToReplaceWith;
   public String[] groundOptions;
   short[] textureToReplaceWith;
   public boolean unnoted;
   public int lightModifier;
   int notedId;
   public int shadowModifier;
   public int noteIndex;
   public int teamIndex;
   public int anInt505;
   int unnotedId;
   public int anInt506;

   static {
      items = new NodeCache(64);
      itemModelCache = new NodeCache(50);
      itemSpriteCache = new NodeCache(200);
   }

   ItemDefinition() {
      this.name = "null";
      this.modelInventoryZoom = 2000;
      this.modelInventoryRotationY = 0;
      this.modelInventoryRotationX = 0;
      this.diagonalRotation = 0;
      this.spriteTranslateX = 0;
      this.spriteTranslateY = 0;
      this.isStackable = 0;
      this.price = 1;
      this.isMembers = false;
      this.groundOptions = new String[] {null, null, "Take", null, null};
      this.inventoryOptions = new String[] {null, null, null, null, "Drop"};
      this.team = -2;
      this.maleEquipModel = -1;
      this.maleArmsId = -1;
      this.maleEquipOffset = 0;
      this.femaleEquipModel = -1;
      this.femaleArmsId = -1;
      this.femaleEquipOffset = 0;
      this.maleEmblem = -1;
      this.femaleEmblem = -1;
      this.maleDialogModel = -1;
      this.maleDialogHat = -1;
      this.femaleDialogModel = -1;
      this.femaleDialogHat = -1;
      this.noteIndex = -1;
      this.noteTemplateIndex = -1;
      this.groundScaleX = 128;
      this.groundScaleY = 128;
      this.groundScaleZ = 128;
      this.lightModifier = 0;
      this.shadowModifier = 0;
      this.teamIndex = 0;
      this.unnoted = false;
      this.unnotedId = -1;
      this.notedId = -1;
      this.anInt506 = -1;
      this.anInt505 = -1;
   }

   public static ItemDefinition getDefinition(int id) {
      ItemDefinition definition = (ItemDefinition) items.get((long)id);
      if (definition != null) {
         return definition;
      } else {
         byte[] data = item_ref.getConfigData(10, id);
         definition = new ItemDefinition();
         definition.id = id;
         if (data != null) {
            definition.decode(new Buffer(data));
         }

         definition.post();
         if (definition.noteTemplateIndex != -1) {
            definition.toNote(getDefinition(definition.noteTemplateIndex), getDefinition(definition.noteIndex));
         }

         if (definition.notedId != -1) {
            definition.method938(getDefinition(definition.notedId), getDefinition(definition.unnotedId));
         }

         if (definition.anInt505 != -1) {
            definition.method939(getDefinition(definition.anInt505), getDefinition(definition.anInt506));
         }

         if (!Enum5.isMembersWorld && definition.isMembers) {
            definition.name = "Members object";
            definition.unnoted = false;
            definition.groundOptions = null;
            definition.inventoryOptions = null;
            definition.team = -1;
            definition.teamIndex = 0;
            if (definition.parameters != null) {
               boolean keep = false;

               for (Node head = definition.parameters.getHead(); head != null; head = definition.parameters.getTail()) {
                  CacheableNode_Sub5 node = PacketBuffer.method907((int)head.hash);
                  if (node.aBool65) {
                     head.unlink();
                  } else {
                     keep = true;
                  }
               }

               if (!keep) {
                  definition.parameters = null;
               }
            }
         }

         items.put(definition, (long)id);
         return definition;
      }
   }

   void decode(Buffer buffer, int opcode) {
      if (opcode == 1) {
         this.modelId = buffer.getUnsignedShort();
      } else if (opcode == 2) {
         this.name = buffer.readString();
      } else if (opcode == 4) {
         this.modelInventoryZoom = buffer.getUnsignedShort();
      } else if (opcode == 5) {
         this.modelInventoryRotationY = buffer.getUnsignedShort();
      } else if (opcode == 6) {
         this.modelInventoryRotationX = buffer.getUnsignedShort();
      } else if (opcode == 7) {
         this.spriteTranslateX = buffer.getUnsignedShort();
         if (this.spriteTranslateX > 32767) {
            this.spriteTranslateX -= 65536;
         }
      } else if (opcode == 8) {
         this.spriteTranslateY = buffer.getUnsignedShort();
         if (this.spriteTranslateY > 32767) {
            this.spriteTranslateY -= 65536;
         }
      } else if (opcode == 11) {
         this.isStackable = 1;
      } else if (opcode == 12) {
         this.price = buffer.readInt();
      } else if (opcode == 16) {
         this.isMembers = true;
      } else if (opcode == 23) {
         this.maleEquipModel = buffer.getUnsignedShort();
         this.maleEquipOffset = buffer.getUnsignedByte();
      } else if (opcode == 24) {
         this.maleArmsId = buffer.getUnsignedShort();
      } else if (opcode == 25) {
         this.femaleEquipModel = buffer.getUnsignedShort();
         this.femaleEquipOffset = buffer.getUnsignedByte();
      } else if (opcode == 26) {
         this.femaleArmsId = buffer.getUnsignedShort();
      } else if (opcode >= 30 && opcode < 35) {
         this.groundOptions[opcode - 30] = buffer.readString();
         if (this.groundOptions[opcode - 30].equalsIgnoreCase("Hidden")) {
            this.groundOptions[opcode - 30] = null;
         }
      } else if (opcode >= 35 && opcode < 40) {
         this.inventoryOptions[opcode - 35] = buffer.readString();
      } else {
         int size;
         int index;
         if (opcode == 40) {
            size = buffer.getUnsignedByte();
            this.colourToReplace = new short[size];
            this.colourToReplaceWith = new short[size];

            for (index = 0; index < size; index++) {
               this.colourToReplace[index] = (short)buffer.getUnsignedShort();
               this.colourToReplaceWith[index] = (short)buffer.getUnsignedShort();
            }
         } else if (opcode == 41) {
            size = buffer.getUnsignedByte();
            this.textureToReplace = new short[size];
            this.textureToReplaceWith = new short[size];

            for (index = 0; index < size; index++) {
               this.textureToReplace[index] = (short)buffer.getUnsignedShort();
               this.textureToReplaceWith[index] = (short)buffer.getUnsignedShort();
            }
         } else if (opcode == 42) {
            this.team = buffer.readByte();
         } else if (opcode == 65) {
            this.unnoted = true;
         } else if (opcode == 78) {
            this.maleEmblem = buffer.getUnsignedShort();
         } else if (opcode == 79) {
            this.femaleEmblem = buffer.getUnsignedShort();
         } else if (opcode == 90) {
            this.maleDialogModel = buffer.getUnsignedShort();
         } else if (opcode == 91) {
            this.femaleDialogModel = buffer.getUnsignedShort();
         } else if (opcode == 92) {
            this.maleDialogHat = buffer.getUnsignedShort();
         } else if (opcode == 93) {
            this.femaleDialogHat = buffer.getUnsignedShort();
         } else if (opcode == 95) {
            this.diagonalRotation = buffer.getUnsignedShort();
         } else if (opcode == 97) {
            this.noteIndex = buffer.getUnsignedShort();
         } else if (opcode == 98) {
            this.noteTemplateIndex = buffer.getUnsignedShort();
         } else if (opcode >= 100 && opcode < 110) {
            if (this.stackIds == null) {
               this.stackIds = new int[10];
               this.stackAmounts = new int[10];
            }

            this.stackIds[opcode - 100] = buffer.getUnsignedShort();
            this.stackAmounts[opcode - 100] = buffer.getUnsignedShort();
         } else if (opcode == 110) {
            this.groundScaleX = buffer.getUnsignedShort();
         } else if (opcode == 111) {
            this.groundScaleY = buffer.getUnsignedShort();
         } else if (opcode == 112) {
            this.groundScaleZ = buffer.getUnsignedShort();
         } else if (opcode == 113) {
            this.lightModifier = buffer.readByte();
         } else if (opcode == 114) {
            this.shadowModifier = buffer.readByte() * 5;
         } else if (opcode == 115) {
            this.teamIndex = buffer.getUnsignedByte();
         } else if (opcode == 139) {
            this.unnotedId = buffer.getUnsignedShort();
         } else if (opcode == 140) {
            this.notedId = buffer.getUnsignedShort();
         } else if (opcode == 148) {
            this.anInt506 = buffer.getUnsignedShort();
         } else if (opcode == 149) {
            this.anInt505 = buffer.getUnsignedShort();
         } else if (opcode == 249) {
            this.parameters = Tile.decodeParameters(buffer, this.parameters);
         }
      }

   }

   public Model getModel(int amount) {
      if (this.stackIds != null && amount > 1) {
         int stackedItemId = -1;

         for (int index = 0; index < 10; index++) {
            if (amount >= this.stackAmounts[index] && this.stackAmounts[index] != 0) {
               stackedItemId = this.stackIds[index];
            }
         }

         if (stackedItemId != -1) {
            return getDefinition(stackedItemId).getModel(1);
         }
      }

      Model itemModel = (Model) itemModelCache.get((long)this.id);
      if (itemModel != null) {
         return itemModel;
      } else {
         ModelHeader header = ModelHeader.getModel(itemDefinitionIndex, this.modelId, 0);
         if (header == null) {
            return null;
         } else {
            if (this.groundScaleX != 128 || this.groundScaleY != 128 || this.groundScaleZ != 128) {
               header.scaleTriangle(this.groundScaleX, this.groundScaleY, this.groundScaleZ);
            }

            int index;
            if (this.colourToReplace != null) {
               for (index = 0; index < this.colourToReplace.length; index++) {
                  header.recolor(this.colourToReplace[index], this.colourToReplaceWith[index]);
               }
            }

            if (this.textureToReplace != null) {
               for (index = 0; index < this.textureToReplace.length; index++) {
                  header.retexture(this.textureToReplace[index], this.textureToReplaceWith[index]);
               }
            }

            itemModel = header.applyLighting(this.lightModifier + 64, this.shadowModifier + 768, -50, -10, -50);
            itemModel.fitsOnSingleSquare = true;
            itemModelCache.put(itemModel, (long)this.id);
            return itemModel;
         }
      }
   }

   public ModelHeader getAmountModel(int amount) {
      int index;
      if (this.stackIds != null && amount > 1) {
         int stackedItemId = -1;

         for (index = 0; index < 10; index++) {
            if (amount >= this.stackAmounts[index] && this.stackAmounts[index] != 0) {
               stackedItemId = this.stackIds[index];
            }
         }

         if (stackedItemId != -1) {
            return getDefinition(stackedItemId).getAmountModel(1);
         }
      }

      ModelHeader header = ModelHeader.getModel(itemDefinitionIndex, this.modelId, 0);
      if (header == null) {
         return null;
      } else {
         if (this.groundScaleX != 128 || this.groundScaleY != 128 || this.groundScaleZ != 128) {
            header.scaleTriangle(this.groundScaleX, this.groundScaleY, this.groundScaleZ);
         }

         if (this.colourToReplace != null) {
            for (index = 0; index < this.colourToReplace.length; index++) {
               header.recolor(this.colourToReplace[index], this.colourToReplaceWith[index]);
            }
         }

         if (this.textureToReplace != null) {
            for (index = 0; index < this.textureToReplace.length; index++) {
               header.retexture(this.textureToReplace[index], this.textureToReplaceWith[index]);
            }
         }

         return header;
      }
   }

   void post() {
   }

   public boolean dialogueHeadExists(boolean female) {
      int modelIndex = this.maleDialogModel;
      int hatModelIndex = this.maleDialogHat;
      if (female) {
         modelIndex = this.femaleDialogModel;
         hatModelIndex = this.femaleDialogHat;
      }

      if (modelIndex == -1) {
         return true;
      } else {
         boolean exists = true;
         if (!itemDefinitionIndex.modelExists(modelIndex, 0)) {
            exists = false;
         }

         if (hatModelIndex != -1 && !itemDefinitionIndex.modelExists(hatModelIndex, 0)) {
            exists = false;
         }

         return exists;
      }
   }

   public ModelHeader getDialogueModelHeader(boolean female) {
      int equipModelId = this.maleDialogModel;
      int armsModelId = this.maleDialogHat;
      if (female) {
         equipModelId = this.femaleDialogModel;
         armsModelId = this.femaleDialogHat;
      }

      if (equipModelId == -1) {
         return null;
      } else {
         ModelHeader equipModel = ModelHeader.getModel(itemDefinitionIndex, equipModelId, 0);
         if (armsModelId != -1) {
            ModelHeader armsModel = ModelHeader.getModel(itemDefinitionIndex, armsModelId, 0);
            ModelHeader[] models = new ModelHeader[] {equipModel, armsModel};
            equipModel = new ModelHeader(models, 2);
         }

         int index;
         if (this.colourToReplace != null) {
            for (index = 0; index < this.colourToReplace.length; index++) {
               equipModel.recolor(this.colourToReplace[index], this.colourToReplaceWith[index]);
            }
         }

         if (this.textureToReplace != null) {
            for (index = 0; index < this.textureToReplace.length; index++) {
               equipModel.retexture(this.textureToReplace[index], this.textureToReplaceWith[index]);
            }
         }

         return equipModel;
      }
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

   public boolean equipModelExists(boolean gender) {
      int equipModelId = this.maleEquipModel;
      int armsModelId = this.maleArmsId;
      int emblemModelId = this.maleEmblem;
      if (gender) {
         equipModelId = this.femaleEquipModel;
         armsModelId = this.femaleArmsId;
         emblemModelId = this.femaleEmblem;
      }

      if (equipModelId == -1) {
         return true;
      } else {
         boolean exists = true;
         if (!itemDefinitionIndex.modelExists(equipModelId, 0)) {
            exists = false;
         }

         if (armsModelId != -1 && !itemDefinitionIndex.modelExists(armsModelId, 0)) {
            exists = false;
         }

         if (emblemModelId != -1 && !itemDefinitionIndex.modelExists(emblemModelId, 0)) {
            exists = false;
         }

         return exists;
      }
   }

   public ModelHeader getEquipModelHeader(boolean female) {
      int equipModelId = this.maleEquipModel;
      int armsModelId = this.maleArmsId;
      int emblemModelId = this.maleEmblem;
      if (female) {
         equipModelId = this.femaleEquipModel;
         armsModelId = this.femaleArmsId;
         emblemModelId = this.femaleEmblem;
      }

      if (equipModelId == -1) {
         return null;
      } else {
         ModelHeader equipModel = ModelHeader.getModel(itemDefinitionIndex, equipModelId, 0);
         if (armsModelId != -1) {
            ModelHeader armsModel = ModelHeader.getModel(itemDefinitionIndex, armsModelId, 0);
            if (emblemModelId != -1) {
               ModelHeader emblemModel = ModelHeader.getModel(itemDefinitionIndex, emblemModelId, 0);
               ModelHeader[] models = new ModelHeader[] {equipModel, armsModel, emblemModel};
               equipModel = new ModelHeader(models, 3);
            } else {
               ModelHeader[] models = new ModelHeader[] {equipModel, armsModel};
               equipModel = new ModelHeader(models, 2);
            }
         }

         if (!female && this.maleEquipOffset != 0) {
            equipModel.translate(0, this.maleEquipOffset, 0);
         }

         if (female && this.femaleEquipOffset != 0) {
            equipModel.translate(0, this.femaleEquipOffset, 0);
         }

         int index;
         if (this.colourToReplace != null) {
            for (index = 0; index < this.colourToReplace.length; index++) {
               equipModel.recolor(this.colourToReplace[index], this.colourToReplaceWith[index]);
            }
         }

         if (this.textureToReplace != null) {
            for (index = 0; index < this.textureToReplace.length; index++) {
               equipModel.retexture(this.textureToReplace[index], this.textureToReplaceWith[index]);
            }
         }

         return equipModel;
      }
   }

   void toNote(ItemDefinition definition, ItemDefinition definition2) {
      this.modelId = definition.modelId;
      this.modelInventoryZoom = definition.modelInventoryZoom;
      this.modelInventoryRotationY = definition.modelInventoryRotationY;
      this.modelInventoryRotationX = definition.modelInventoryRotationX;
      this.diagonalRotation = definition.diagonalRotation;
      this.spriteTranslateX = definition.spriteTranslateX;
      this.spriteTranslateY = definition.spriteTranslateY;
      this.colourToReplace = definition.colourToReplace;
      this.colourToReplaceWith = definition.colourToReplaceWith;
      this.textureToReplace = definition.textureToReplace;
      this.textureToReplaceWith = definition.textureToReplaceWith;
      this.name = definition2.name;
      this.isMembers = definition2.isMembers;
      this.price = definition2.price;
      this.isStackable = 1;
   }

   void method938(ItemDefinition itemcomposition_1, ItemDefinition itemcomposition_2) {
      this.modelId = itemcomposition_1.modelId;
      this.modelInventoryZoom = itemcomposition_1.modelInventoryZoom;
      this.modelInventoryRotationY = itemcomposition_1.modelInventoryRotationY;
      this.modelInventoryRotationX = itemcomposition_1.modelInventoryRotationX;
      this.diagonalRotation = itemcomposition_1.diagonalRotation;
      this.spriteTranslateX = itemcomposition_1.spriteTranslateX;
      this.spriteTranslateY = itemcomposition_1.spriteTranslateY;
      this.colourToReplace = itemcomposition_2.colourToReplace;
      this.colourToReplaceWith = itemcomposition_2.colourToReplaceWith;
      this.textureToReplace = itemcomposition_2.textureToReplace;
      this.textureToReplaceWith = itemcomposition_2.textureToReplaceWith;
      this.name = itemcomposition_2.name;
      this.isMembers = itemcomposition_2.isMembers;
      this.isStackable = itemcomposition_2.isStackable;
      this.maleEquipModel = itemcomposition_2.maleEquipModel;
      this.maleArmsId = itemcomposition_2.maleArmsId;
      this.maleEmblem = itemcomposition_2.maleEmblem;
      this.femaleEquipModel = itemcomposition_2.femaleEquipModel;
      this.femaleArmsId = itemcomposition_2.femaleArmsId;
      this.femaleEmblem = itemcomposition_2.femaleEmblem;
      this.maleDialogModel = itemcomposition_2.maleDialogModel;
      this.maleDialogHat = itemcomposition_2.maleDialogHat;
      this.femaleDialogModel = itemcomposition_2.femaleDialogModel;
      this.femaleDialogHat = itemcomposition_2.femaleDialogHat;
      this.teamIndex = itemcomposition_2.teamIndex;
      this.groundOptions = itemcomposition_2.groundOptions;
      this.inventoryOptions = new String[5];
      if (itemcomposition_2.inventoryOptions != null) {
         for (int int_0 = 0; int_0 < 4; int_0++) {
            this.inventoryOptions[int_0] = itemcomposition_2.inventoryOptions[int_0];
         }
      }

      this.inventoryOptions[4] = "Discard";
      this.price = 0;
   }

   void method939(ItemDefinition itemcomposition_1, ItemDefinition itemcomposition_2) {
      this.modelId = itemcomposition_1.modelId;
      this.modelInventoryZoom = itemcomposition_1.modelInventoryZoom;
      this.modelInventoryRotationY = itemcomposition_1.modelInventoryRotationY;
      this.modelInventoryRotationX = itemcomposition_1.modelInventoryRotationX;
      this.diagonalRotation = itemcomposition_1.diagonalRotation;
      this.spriteTranslateX = itemcomposition_1.spriteTranslateX;
      this.spriteTranslateY = itemcomposition_1.spriteTranslateY;
      this.colourToReplace = itemcomposition_1.colourToReplace;
      this.colourToReplaceWith = itemcomposition_1.colourToReplaceWith;
      this.textureToReplace = itemcomposition_1.textureToReplace;
      this.textureToReplaceWith = itemcomposition_1.textureToReplaceWith;
      this.isStackable = itemcomposition_1.isStackable;
      this.name = itemcomposition_2.name;
      this.price = 0;
      this.isMembers = false;
      this.unnoted = false;
   }

   public ItemDefinition getItemDefinition(int amount) {
      if (this.stackIds != null && amount > 1) {
         int amountItemId = -1;

         for (int index = 0; index < 10; index++) {
            if (amount >= this.stackAmounts[index] && this.stackAmounts[index] != 0) {
               amountItemId = this.stackIds[index];
            }
         }

         if (amountItemId != -1) {
            return getDefinition(amountItemId);
         }
      }

      return this;
   }

   public int method941(int int_0, int int_1) {
      return SceneCluster.method392(this.parameters, int_0, int_1);
   }

   public String method942(int int_0, String string_0) {
      return VertexNormal.method492(this.parameters, int_0, string_0);
   }

   public int method943() {
      return this.team != -1 && this.inventoryOptions != null ? (this.team >= 0 ? (this.inventoryOptions[this.team] != null ? this.team : -1) : ("Drop".equalsIgnoreCase(this.inventoryOptions[4]) ? 4 : -1)) : -1;
   }

   static World method944() {
      return World.anInt219 < World.worldCount ? Coordinates.worldList[++World.anInt219 - 1] : null;
   }

}
