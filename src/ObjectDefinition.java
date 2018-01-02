public class ObjectDefinition extends CacheableNode {

   public static boolean lowMemory;
   public static NodeCache objects;
   public static IndexDataBase modelIndex;
   public static IndexDataBase objects_ref;
   public static NodeCache objectDefinitionCache;
   public static NodeCache cachedModels;
   public static NodeCache modelCache;
   static ModelHeader[] models;
   IterableHashTable parameters;
   int varpId;
   public int hasOptions;
   int[] modelIds;
   int[] modelTypes;
   public int[] transformationIds;
   public int ambientSoundId;
   public int isSolid;
   int configId;
   public String name;
   public int id;
   public int[] anIntArray85;
   public int mapIconId;
   public int sizeX;
   public int interactType;
   boolean isRotated;
   public int sizeY;
   public boolean projectileClipped;
   public int anInt463;
   boolean nonFlatShading;
   int clipType;
   public int anInt464;
   public boolean needsCulling;
   int ambient;
   int contrast;
   public int anInt465;
   public String[] options;
   boolean unwalkableSolid;
   public int animationId;
   int modelSizeX;
   public int offsetMultiplier;
   int modelSizeY;
   short[] recolorToFind;
   public boolean hasModel;
   short[] textureToFind;
   short[] recolorToReplace;
   int modelSizeZ;
   short[] textureToReplace;
   int translateX;
   public int mapSceneId;
   int translateY;
   int translateZ;
   public boolean needsRedraw;

   static {
      lowMemory = false;
      objects = new NodeCache(4096);
      modelCache = new NodeCache(500);
      cachedModels = new NodeCache(30);
      objectDefinitionCache = new NodeCache(30);
      models = new ModelHeader[4];
   }

   ObjectDefinition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.interactType = 2;
      this.projectileClipped = true;
      this.hasOptions = -1;
      this.clipType = -1;
      this.nonFlatShading = false;
      this.needsCulling = false;
      this.animationId = -1;
      this.offsetMultiplier = 16;
      this.ambient = 0;
      this.contrast = 0;
      this.options = new String[5];
      this.mapIconId = -1;
      this.mapSceneId = -1;
      this.isRotated = false;
      this.hasModel = true;
      this.modelSizeX = 128;
      this.modelSizeY = 128;
      this.modelSizeZ = 128;
      this.translateX = 0;
      this.translateY = 0;
      this.translateZ = 0;
      this.needsRedraw = false;
      this.unwalkableSolid = false;
      this.isSolid = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.anInt463 = 0;
      this.anInt464 = 0;
      this.anInt465 = 0;
   }

   public static ObjectDefinition getDefinition(int id) {
      ObjectDefinition definition = (ObjectDefinition) objects.get((long)id);
      if (definition != null) {
         return definition;
      } else {
         byte[] data = objects_ref.getConfigData(6, id);
         definition = new ObjectDefinition();
         definition.id = id;
         if (data != null) {
            definition.decode(new Buffer(data));
         }

         definition.post();
         if (definition.unwalkableSolid) {
            definition.interactType = 0;
            definition.projectileClipped = false;
         }

         objects.put(definition, (long)id);
         return definition;
      }
   }

   public ObjectDefinition morph() {
      int morphIndex = -1;
      if (this.varpId != -1) {
         morphIndex = Varbit.getVarbit(this.varpId);
      } else if (this.configId != -1) {
         morphIndex = Settings.widgetSettings[this.configId];
      }

      int child;
      if (morphIndex >= 0 && morphIndex < this.transformationIds.length - 1) {
         child = this.transformationIds[morphIndex];
      } else {
         child = this.transformationIds[this.transformationIds.length - 1];
      }

      return child != -1 ? getDefinition(child) : null;
   }

   void decode(Buffer buffer, int opcode) {
      int count;
      int model;
      if (opcode == 1) {
         count = buffer.getUnsignedByte();
         if (count > 0) {
            if (this.modelIds != null && !lowMemory) {
               buffer.position += 3 * count;
            } else {
               this.modelTypes = new int[count];
               this.modelIds = new int[count];

               for (model = 0; model < count; model++) {
                  this.modelIds[model] = buffer.getUnsignedShort();
                  this.modelTypes[model] = buffer.getUnsignedByte();
               }
            }
         }
      } else if (opcode == 2) {
         this.name = buffer.readString();
      } else if (opcode == 5) {
         count = buffer.getUnsignedByte();
         if (count > 0) {
            if (this.modelIds != null && !lowMemory) {
               buffer.position += 2 * count;
            } else {
               this.modelTypes = null;
               this.modelIds = new int[count];

               for (model = 0; model < count; model++) {
                  this.modelIds[model] = buffer.getUnsignedShort();
               }
            }
         }
      } else if (opcode == 14) {
         this.sizeX = buffer.getUnsignedByte();
      } else if (opcode == 15) {
         this.sizeY = buffer.getUnsignedByte();
      } else if (opcode == 17) {
         this.interactType = 0;
         this.projectileClipped = false;
      } else if (opcode == 18) {
         this.projectileClipped = false;
      } else if (opcode == 19) {
         this.hasOptions = buffer.getUnsignedByte();
      } else if (opcode == 21) {
         this.clipType = 0;
      } else if (opcode == 22) {
         this.nonFlatShading = true;
      } else if (opcode == 23) {
         this.needsCulling = true;
      } else if (opcode == 24) {
         this.animationId = buffer.getUnsignedShort();
         if (this.animationId == 65535) {
            this.animationId = -1;
         }
      } else if (opcode == 27) {
         this.interactType = 1;
      } else if (opcode == 28) {
         this.offsetMultiplier = buffer.getUnsignedByte();
      } else if (opcode == 29) {
         this.ambient = buffer.readByte();
      } else if (opcode == 39) {
         this.contrast = buffer.readByte() * 25;
      } else if (opcode >= 30 && opcode < 35) {
         this.options[opcode - 30] = buffer.readString();
         if (this.options[opcode - 30].equalsIgnoreCase("Hidden")) {
            this.options[opcode - 30] = null;
         }
      } else if (opcode == 40) {
         count = buffer.getUnsignedByte();
         this.recolorToFind = new short[count];
         this.recolorToReplace = new short[count];

         for (model = 0; model < count; model++) {
            this.recolorToFind[model] = (short)buffer.getUnsignedShort();
            this.recolorToReplace[model] = (short)buffer.getUnsignedShort();
         }
      } else if (opcode == 41) {
         count = buffer.getUnsignedByte();
         this.textureToFind = new short[count];
         this.textureToReplace = new short[count];

         for (model = 0; model < count; model++) {
            this.textureToFind[model] = (short)buffer.getUnsignedShort();
            this.textureToReplace[model] = (short)buffer.getUnsignedShort();
         }
      } else if (opcode == 62) {
         this.isRotated = true;
      } else if (opcode == 64) {
         this.hasModel = false;
      } else if (opcode == 65) {
         this.modelSizeX = buffer.getUnsignedShort();
      } else if (opcode == 66) {
         this.modelSizeY = buffer.getUnsignedShort();
      } else if (opcode == 67) {
         this.modelSizeZ = buffer.getUnsignedShort();
      } else if (opcode == 68) {
         this.mapSceneId = buffer.getUnsignedShort();
      } else if (opcode == 69) {
         buffer.getUnsignedByte();//face
      } else if (opcode == 70) {
         this.translateX = buffer.readShort();
      } else if (opcode == 71) {
         this.translateY = buffer.readShort();
      } else if (opcode == 72) {
         this.translateZ = buffer.readShort();
      } else if (opcode == 73) {
         this.needsRedraw = true;
      } else if (opcode == 74) {
         this.unwalkableSolid = true;
      } else if (opcode == 75) {
         this.isSolid = buffer.getUnsignedByte();
      } else if (opcode != 77 && opcode != 92) {
         if (opcode == 78) {
            this.ambientSoundId = buffer.getUnsignedShort();
            this.anInt463 = buffer.getUnsignedByte();
         } else if (opcode == 79) {
            this.anInt464 = buffer.getUnsignedShort();
            this.anInt465 = buffer.getUnsignedShort();
            this.anInt463 = buffer.getUnsignedByte();
            count = buffer.getUnsignedByte();
            this.anIntArray85 = new int[count];

            for (model = 0; model < count; model++) {
               this.anIntArray85[model] = buffer.getUnsignedShort();
            }
         } else if (opcode == 81) {
            this.clipType = buffer.getUnsignedByte() * 256;
         } else if (opcode == 82) {
            this.mapIconId = buffer.getUnsignedShort();
         } else if (opcode == 249) {
            this.parameters = Tile.decodeParameters(buffer, this.parameters);
         }
      } else {
         this.varpId = buffer.getUnsignedShort();
         if (this.varpId == 65535) {
            this.varpId = -1;
         }

         this.configId = buffer.getUnsignedShort();
         if (this.configId == 65535) {
            this.configId = -1;
         }

         count = -1;
         if (opcode == 92) {
            count = buffer.getUnsignedShort();
            if (count == 65535) {
               count = -1;
            }
         }

         model = buffer.getUnsignedByte();
         this.transformationIds = new int[model + 2];

         for (int int_3 = 0; int_3 <= model; int_3++) {
            this.transformationIds[int_3] = buffer.getUnsignedShort();
            if (this.transformationIds[int_3] == 65535) {
               this.transformationIds[int_3] = -1;
            }
         }

         this.transformationIds[model + 1] = count;
      }

   }

   ModelHeader getModel(int type, int face) {
      ModelHeader subModel = null;
      boolean scale;
      int length;
      int modelId;
      if (this.modelTypes == null) {
         if (type != 10) {
            return null;
         }

         if (this.modelIds == null) {
            return null;
         }

         scale = this.isRotated;
         if (type == 2 && face > 3) {
            scale = !scale;
         }

         length = this.modelIds.length;

         for (int modelIndex = 0; modelIndex < length; modelIndex++) {
            modelId = this.modelIds[modelIndex];
            if (scale) {
               modelId += 65536;
            }

            subModel = (ModelHeader) modelCache.get((long)modelId);
            if (subModel == null) {
               subModel = ModelHeader.getModel(ObjectDefinition.modelIndex, modelId & 0xFFFF, 0);
               if (subModel == null) {
                  return null;
               }

               if (scale) {
                  subModel.mirror();
               }

               modelCache.put(subModel, (long)modelId);
            }

            if (length > 1) {
               models[modelIndex] = subModel;
            }
         }

         if (length > 1) {
            subModel = new ModelHeader(models, length);
         }
      } else {
         int modelType = -1;

         for (length = 0; length < this.modelTypes.length; length++) {
            if (this.modelTypes[length] == type) {
               modelType = length;
               break;
            }
         }

         if (modelType == -1) {
            return null;
         }

         length = this.modelIds[modelType];
         boolean mirror = this.isRotated ^ face > 3;
         if (mirror) {
            length += 65536;
         }

         subModel = (ModelHeader) modelCache.get((long)length);
         if (subModel == null) {
            subModel = ModelHeader.getModel(modelIndex, length & 0xFFFF, 0);
            if (subModel == null) {
               return null;
            }

            if (mirror) {
               subModel.mirror();
            }

            modelCache.put(subModel, (long)length);
         }
      }

      if (this.modelSizeX == 128 && this.modelSizeY == 128 && this.modelSizeZ == 128) {
         scale = false;
      } else {
         scale = true;
      }

      boolean needsTranslation;
      if (this.translateX == 0 && this.translateY == 0 && this.translateZ == 0) {
         needsTranslation = false;
      } else {
         needsTranslation = true;
      }

      ModelHeader animatedModel = new ModelHeader(subModel, face == 0 && !scale && !needsTranslation, this.recolorToFind == null, this.textureToFind == null, true);
      if (type == 4 && face > 3) {
         animatedModel.method1055(256);
         animatedModel.translate(45, 0, -45);
      }

      face &= 0x3;
      if (face == 1) {
         animatedModel.rotate90Degrees();
      } else if (face == 2) {
         animatedModel.rotateXZ();
      } else if (face == 3) {
         animatedModel.rotateZ();
      }

      if (this.recolorToFind != null) {
         for (modelId = 0; modelId < this.recolorToFind.length; modelId++) {
            animatedModel.recolor(this.recolorToFind[modelId], this.recolorToReplace[modelId]);
         }
      }

      if (this.textureToFind != null) {
         for (modelId = 0; modelId < this.textureToFind.length; modelId++) {
            animatedModel.retexture(this.textureToFind[modelId], this.textureToReplace[modelId]);
         }
      }

      if (scale) {
         animatedModel.scaleTriangle(this.modelSizeX, this.modelSizeY, this.modelSizeZ);
      }

      if (needsTranslation) {
         animatedModel.translate(this.translateX, this.translateY, this.translateZ);
      }

      return animatedModel;
   }

   void post() {
      if (this.hasOptions == -1) {
         this.hasOptions = 0;
         if (this.modelIds != null && (this.modelTypes == null || this.modelTypes[0] == 10)) {
            this.hasOptions = 1;
         }

         for (int index = 0; index < 5; index++) {
            if (this.options[index] != null) {
               this.hasOptions = 1;
            }
         }
      }

      if (this.isSolid == -1) {
         this.isSolid = this.interactType != 0 ? 1 : 0;
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

   public Model getModelAt(int type, int orientation, int[][] heights, int x, int mean, int y, Sequence sequence, int frame) {
      long key;
      if (this.modelTypes == null) {
         key = (long)(orientation + (this.id << 10));
      } else {
         key = (long)(orientation + (type << 3) + (this.id << 10));
      }

      Model model = (Model) objectDefinitionCache.get(key);
      if (model == null) {
         ModelHeader header = this.getModel(type, orientation);
         if (header == null) {
            return null;
         }

         model = header.applyLighting(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         objectDefinitionCache.put(model, key);
      }

      if (sequence == null && this.clipType == -1) {
         return model;
      } else {
         if (sequence != null) {
            model = sequence.applyFrame(model, frame, orientation);
         } else {
            model = model.replaceAlphaValues(true);
         }

         if (this.clipType >= 0) {
            model = model.adjustToTerrain(heights, x, mean, y, false, this.clipType);
         }

         return model;
      }
   }

   public boolean ready() {
      if (this.modelIds == null) {
         return true;
      } else {
         boolean ready = true;

         for (int index = 0; index < this.modelIds.length; index++) {
            ready &= modelIndex.modelExists(this.modelIds[index] & 0xFFFF, 0);
         }

         return ready;
      }
   }

   public boolean hasModelType(int modelType) {
      if (this.modelTypes != null) {
         for (int index = 0; index < this.modelTypes.length; index++) {
            if (this.modelTypes[index] == modelType) {
               return modelIndex.modelExists(this.modelIds[index] & 0xFFFF, 0);
            }
         }

         return true;
      } else if (this.modelIds == null) {
         return true;
      } else if (modelType != 10) {
         return true;
      } else {
         boolean exists = true;

         for (int index = 0; index < this.modelIds.length; index++) {
            exists &= modelIndex.modelExists(this.modelIds[index] & 0xFFFF, 0);
         }

         return exists;
      }
   }

   public Model getModelAt(int type, int face, int[][] heights, int vertexX, int mean, int vertexY) {
      long key;
      if (this.modelTypes == null) {
         key = (long)(face + (this.id << 10));
      } else {
         key = (long)(face + (type << 3) + (this.id << 10));
      }

      Model model = (Model) objectDefinitionCache.get(key);
      if (model == null) {
         ModelHeader header = this.getModel(type, face);
         if (header == null) {
            return null;
         }

         model = header.applyLighting(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         objectDefinitionCache.put(model, key);
      }

      if (this.clipType >= 0) {
         model = model.adjustToTerrain(heights, vertexX, mean, vertexY, true, this.clipType);
      }

      return model;
   }

   public String method826(int int_0, String string_0) {
      return VertexNormal.method492(this.parameters, int_0, string_0);
   }

   public int method827(int int_0, int int_1) {
      return SceneCluster.method392(this.parameters, int_0, int_1);
   }

   public boolean hasAmbientSound() {
      if (this.transformationIds == null) {
         return this.ambientSoundId != -1 || this.anIntArray85 != null;
      } else {
         for (int index = 0; index < this.transformationIds.length; index++) {
            if (this.transformationIds[index] != -1) {
               ObjectDefinition definition = getDefinition(this.transformationIds[index]);
               if (definition.ambientSoundId != -1 || definition.anIntArray85 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public Renderable getModel(int int_0, int int_1, int[][] ints_0, int int_2, int int_3, int int_4) {
      long long_0;
      if (this.modelTypes == null) {
         long_0 = (long)(int_1 + (this.id << 10));
      } else {
         long_0 = (long)(int_1 + (int_0 << 3) + (this.id << 10));
      }

      Object object_0 = (Renderable) cachedModels.get(long_0);
      if (object_0 == null) {
         ModelHeader modeldata_0 = this.getModel(int_0, int_1);
         if (modeldata_0 == null) {
            return null;
         }

         if (!this.nonFlatShading) {
            object_0 = modeldata_0.applyLighting(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         } else {
            modeldata_0.aShort2 = (short)(this.ambient + 64);
            modeldata_0.contrast = (short)(this.contrast + 768);
            modeldata_0.computeNormals();
            object_0 = modeldata_0;
         }

         cachedModels.put((CacheableNode) object_0, long_0);
      }

      if (this.nonFlatShading) {
         object_0 = ((ModelHeader) object_0).method1049();
      }

      if (this.clipType >= 0) {
         if (object_0 instanceof Model) {
            object_0 = ((Model) object_0).adjustToTerrain(ints_0, int_2, int_3, int_4, true, this.clipType);
         } else if (object_0 instanceof ModelHeader) {
            object_0 = ((ModelHeader) object_0).method1053(ints_0, int_2, int_3, int_4, true, this.clipType);
         }
      }

      return (Renderable) object_0;
   }

   static SpritePixels[] method829() {
      SpritePixels[] spritepixelss_0 = new SpritePixels[Class111.loadedSpriteSize];

      for (int int_0 = 0; int_0 < Class111.loadedSpriteSize; int_0++) {
         SpritePixels spritepixels_0 = spritepixelss_0[int_0] = new SpritePixels();
         spritepixels_0.maxWidth = Class111.loadedMaxWidth;
         spritepixels_0.maxHeight = Class111.loadedMaxHeight;
         spritepixels_0.offsetX = Class111.loadedHorizontalOffsets[int_0];
         spritepixels_0.offsetY = Class7.loadedVerticalOffsets[int_0];
         spritepixels_0.width = ItemContainer.loadedWidths[int_0];
         spritepixels_0.height = Class6.loadedHeights[int_0];
         int int_1 = spritepixels_0.height * spritepixels_0.width;
         byte[] bytes_0 = Class111.spritePixels[int_0];
         spritepixels_0.pixels = new int[int_1];

         for (int int_2 = 0; int_2 < int_1; int_2++) {
            spritepixels_0.pixels[int_2] = Class111.loadedPixels[bytes_0[int_2] & 0xFF];
         }
      }

      Class98.cleanPixelLoader();
      return spritepixelss_0;
   }

   public static String method830(String string_0) {
      int int_0 = string_0.length();
      char[] chars_0 = new char[int_0];
      byte byte_0 = 2;

      for (int int_1 = 0; int_1 < int_0; int_1++) {
         char char_0 = string_0.charAt(int_1);
         if (byte_0 == 0) {
            char_0 = Character.toLowerCase(char_0);
         } else if (byte_0 == 2 || Character.isUpperCase(char_0)) {
            char_0 = Class16.method197(char_0);
         }

         if (Character.isLetter(char_0)) {
            byte_0 = 0;
         } else if (char_0 != 46 && char_0 != 63 && char_0 != 33) {
            if (Character.isSpaceChar(char_0)) {
               if (byte_0 != 2) {
                  byte_0 = 1;
               }
            } else {
               byte_0 = 1;
            }
         } else {
            byte_0 = 2;
         }

         chars_0[int_1] = char_0;
      }

      return new String(chars_0);
   }

}
