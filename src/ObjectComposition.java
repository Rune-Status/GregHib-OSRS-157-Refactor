public class ObjectComposition extends CacheableNode {

   public static boolean aBool59;
   public static NodeCache objects;
   public static IndexDataBase anIndexDataBase20;
   public static IndexDataBase objects_ref;
   public static NodeCache aNodeCache8;
   public static NodeCache cachedModels;
   public static NodeCache aNodeCache9;
   static ModelData[] aModelDataArray1;
   IterableHashTable anIterableHashTable2;
   int varpId;
   public int anInt461;
   int[] objectModels;
   int[] objectTypes;
   public int[] impostorIds;
   public int ambientSoundId;
   public int anInt462;
   int configId;
   public String name;
   public int id;
   public int[] anIntArray85;
   public int mapIconId;
   public int sizeX;
   public int interactType;
   boolean isRotated;
   public int sizeY;
   public boolean aBool60;
   public int anInt463;
   boolean nonFlatShading;
   int clipType;
   public int anInt464;
   public boolean modelClipped;
   int ambient;
   int contrast;
   public int anInt465;
   public String[] actions;
   boolean isSolid;
   public int animationId;
   int modelSizeX;
   public int anInt466;
   int modelSizeHeight;
   short[] recolorToFind;
   public boolean clipped;
   short[] textureToFind;
   short[] recolorToReplace;
   int modelSizeY;
   short[] textureToReplace;
   int offsetX;
   public int mapSceneId;
   int offsetHeight;
   int offsetY;
   public boolean aBool61;

   static {
      aBool59 = false;
      objects = new NodeCache(4096);
      aNodeCache9 = new NodeCache(500);
      cachedModels = new NodeCache(30);
      aNodeCache8 = new NodeCache(30);
      aModelDataArray1 = new ModelData[4];
   }

   ObjectComposition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.interactType = 2;
      this.aBool60 = true;
      this.anInt461 = -1;
      this.clipType = -1;
      this.nonFlatShading = false;
      this.modelClipped = false;
      this.animationId = -1;
      this.anInt466 = 16;
      this.ambient = 0;
      this.contrast = 0;
      this.actions = new String[5];
      this.mapIconId = -1;
      this.mapSceneId = -1;
      this.isRotated = false;
      this.clipped = true;
      this.modelSizeX = 128;
      this.modelSizeHeight = 128;
      this.modelSizeY = 128;
      this.offsetX = 0;
      this.offsetHeight = 0;
      this.offsetY = 0;
      this.aBool61 = false;
      this.isSolid = false;
      this.anInt462 = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.anInt463 = 0;
      this.anInt464 = 0;
      this.anInt465 = 0;
   }

   public ObjectComposition getImpostor() {
      int int_0 = -1;
      if (this.varpId != -1) {
         int_0 = Item.method973(this.varpId);
      } else if (this.configId != -1) {
         int_0 = Class79.widgetSettings[this.configId];
      }

      int int_1;
      if (int_0 >= 0 && int_0 < this.impostorIds.length - 1) {
         int_1 = this.impostorIds[int_0];
      } else {
         int_1 = this.impostorIds[this.impostorIds.length - 1];
      }

      return int_1 != -1 ? Class28.getObjectDefinition(int_1) : null;
   }

   void loadData(Buffer buffer_0, int int_0) {
      int int_1;
      int int_2;
      if (int_0 == 1) {
         int_1 = buffer_0.getUnsignedByte();
         if (int_1 > 0) {
            if (this.objectModels != null && !aBool59) {
               buffer_0.position += 3 * int_1;
            } else {
               this.objectTypes = new int[int_1];
               this.objectModels = new int[int_1];

               for (int_2 = 0; int_2 < int_1; int_2++) {
                  this.objectModels[int_2] = buffer_0.getUnsignedShort();
                  this.objectTypes[int_2] = buffer_0.getUnsignedByte();
               }
            }
         }
      } else if (int_0 == 2) {
         this.name = buffer_0.readString();
      } else if (int_0 == 5) {
         int_1 = buffer_0.getUnsignedByte();
         if (int_1 > 0) {
            if (this.objectModels != null && !aBool59) {
               buffer_0.position += 2 * int_1;
            } else {
               this.objectTypes = null;
               this.objectModels = new int[int_1];

               for (int_2 = 0; int_2 < int_1; int_2++) {
                  this.objectModels[int_2] = buffer_0.getUnsignedShort();
               }
            }
         }
      } else if (int_0 == 14) {
         this.sizeX = buffer_0.getUnsignedByte();
      } else if (int_0 == 15) {
         this.sizeY = buffer_0.getUnsignedByte();
      } else if (int_0 == 17) {
         this.interactType = 0;
         this.aBool60 = false;
      } else if (int_0 == 18) {
         this.aBool60 = false;
      } else if (int_0 == 19) {
         this.anInt461 = buffer_0.getUnsignedByte();
      } else if (int_0 == 21) {
         this.clipType = 0;
      } else if (int_0 == 22) {
         this.nonFlatShading = true;
      } else if (int_0 == 23) {
         this.modelClipped = true;
      } else if (int_0 == 24) {
         this.animationId = buffer_0.getUnsignedShort();
         if (this.animationId == 65535) {
            this.animationId = -1;
         }
      } else if (int_0 == 27) {
         this.interactType = 1;
      } else if (int_0 == 28) {
         this.anInt466 = buffer_0.getUnsignedByte();
      } else if (int_0 == 29) {
         this.ambient = buffer_0.readByte();
      } else if (int_0 == 39) {
         this.contrast = buffer_0.readByte() * 25;
      } else if (int_0 >= 30 && int_0 < 35) {
         this.actions[int_0 - 30] = buffer_0.readString();
         if (this.actions[int_0 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[int_0 - 30] = null;
         }
      } else if (int_0 == 40) {
         int_1 = buffer_0.getUnsignedByte();
         this.recolorToFind = new short[int_1];
         this.recolorToReplace = new short[int_1];

         for (int_2 = 0; int_2 < int_1; int_2++) {
            this.recolorToFind[int_2] = (short)buffer_0.getUnsignedShort();
            this.recolorToReplace[int_2] = (short)buffer_0.getUnsignedShort();
         }
      } else if (int_0 == 41) {
         int_1 = buffer_0.getUnsignedByte();
         this.textureToFind = new short[int_1];
         this.textureToReplace = new short[int_1];

         for (int_2 = 0; int_2 < int_1; int_2++) {
            this.textureToFind[int_2] = (short)buffer_0.getUnsignedShort();
            this.textureToReplace[int_2] = (short)buffer_0.getUnsignedShort();
         }
      } else if (int_0 == 62) {
         this.isRotated = true;
      } else if (int_0 == 64) {
         this.clipped = false;
      } else if (int_0 == 65) {
         this.modelSizeX = buffer_0.getUnsignedShort();
      } else if (int_0 == 66) {
         this.modelSizeHeight = buffer_0.getUnsignedShort();
      } else if (int_0 == 67) {
         this.modelSizeY = buffer_0.getUnsignedShort();
      } else if (int_0 == 68) {
         this.mapSceneId = buffer_0.getUnsignedShort();
      } else if (int_0 == 69) {
         buffer_0.getUnsignedByte();
      } else if (int_0 == 70) {
         this.offsetX = buffer_0.readShort();
      } else if (int_0 == 71) {
         this.offsetHeight = buffer_0.readShort();
      } else if (int_0 == 72) {
         this.offsetY = buffer_0.readShort();
      } else if (int_0 == 73) {
         this.aBool61 = true;
      } else if (int_0 == 74) {
         this.isSolid = true;
      } else if (int_0 == 75) {
         this.anInt462 = buffer_0.getUnsignedByte();
      } else if (int_0 != 77 && int_0 != 92) {
         if (int_0 == 78) {
            this.ambientSoundId = buffer_0.getUnsignedShort();
            this.anInt463 = buffer_0.getUnsignedByte();
         } else if (int_0 == 79) {
            this.anInt464 = buffer_0.getUnsignedShort();
            this.anInt465 = buffer_0.getUnsignedShort();
            this.anInt463 = buffer_0.getUnsignedByte();
            int_1 = buffer_0.getUnsignedByte();
            this.anIntArray85 = new int[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
               this.anIntArray85[int_2] = buffer_0.getUnsignedShort();
            }
         } else if (int_0 == 81) {
            this.clipType = buffer_0.getUnsignedByte() * 256;
         } else if (int_0 == 82) {
            this.mapIconId = buffer_0.getUnsignedShort();
         } else if (int_0 == 249) {
            this.anIterableHashTable2 = Tile.method682(buffer_0, this.anIterableHashTable2);
         }
      } else {
         this.varpId = buffer_0.getUnsignedShort();
         if (this.varpId == 65535) {
            this.varpId = -1;
         }

         this.configId = buffer_0.getUnsignedShort();
         if (this.configId == 65535) {
            this.configId = -1;
         }

         int_1 = -1;
         if (int_0 == 92) {
            int_1 = buffer_0.getUnsignedShort();
            if (int_1 == 65535) {
               int_1 = -1;
            }
         }

         int_2 = buffer_0.getUnsignedByte();
         this.impostorIds = new int[int_2 + 2];

         for (int int_3 = 0; int_3 <= int_2; int_3++) {
            this.impostorIds[int_3] = buffer_0.getUnsignedShort();
            if (this.impostorIds[int_3] == 65535) {
               this.impostorIds[int_3] = -1;
            }
         }

         this.impostorIds[int_2 + 1] = int_1;
      }

   }

   ModelData getModel(int int_0, int int_1) {
      ModelData modeldata_0 = null;
      boolean bool_0;
      int int_2;
      int int_4;
      if (this.objectTypes == null) {
         if (int_0 != 10) {
            return null;
         }

         if (this.objectModels == null) {
            return null;
         }

         bool_0 = this.isRotated;
         if (int_0 == 2 && int_1 > 3) {
            bool_0 = !bool_0;
         }

         int_2 = this.objectModels.length;

         for (int int_3 = 0; int_3 < int_2; int_3++) {
            int_4 = this.objectModels[int_3];
            if (bool_0) {
               int_4 += 65536;
            }

            modeldata_0 = (ModelData) aNodeCache9.get((long)int_4);
            if (modeldata_0 == null) {
               modeldata_0 = ModelData.method1060(anIndexDataBase20, int_4 & 0xFFFF, 0);
               if (modeldata_0 == null) {
                  return null;
               }

               if (bool_0) {
                  modeldata_0.method1054();
               }

               aNodeCache9.put(modeldata_0, (long)int_4);
            }

            if (int_2 > 1) {
               aModelDataArray1[int_3] = modeldata_0;
            }
         }

         if (int_2 > 1) {
            modeldata_0 = new ModelData(aModelDataArray1, int_2);
         }
      } else {
         int int_5 = -1;

         for (int_2 = 0; int_2 < this.objectTypes.length; int_2++) {
            if (this.objectTypes[int_2] == int_0) {
               int_5 = int_2;
               break;
            }
         }

         if (int_5 == -1) {
            return null;
         }

         int_2 = this.objectModels[int_5];
         boolean bool_1 = this.isRotated ^ int_1 > 3;
         if (bool_1) {
            int_2 += 65536;
         }

         modeldata_0 = (ModelData) aNodeCache9.get((long)int_2);
         if (modeldata_0 == null) {
            modeldata_0 = ModelData.method1060(anIndexDataBase20, int_2 & 0xFFFF, 0);
            if (modeldata_0 == null) {
               return null;
            }

            if (bool_1) {
               modeldata_0.method1054();
            }

            aNodeCache9.put(modeldata_0, (long)int_2);
         }
      }

      if (this.modelSizeX == 128 && this.modelSizeHeight == 128 && this.modelSizeY == 128) {
         bool_0 = false;
      } else {
         bool_0 = true;
      }

      boolean bool_2;
      if (this.offsetX == 0 && this.offsetHeight == 0 && this.offsetY == 0) {
         bool_2 = false;
      } else {
         bool_2 = true;
      }

      ModelData modeldata_1 = new ModelData(modeldata_0, int_1 == 0 && !bool_0 && !bool_2, this.recolorToFind == null, this.textureToFind == null, true);
      if (int_0 == 4 && int_1 > 3) {
         modeldata_1.method1055(256);
         modeldata_1.method1052(45, 0, -45);
      }

      int_1 &= 0x3;
      if (int_1 == 1) {
         modeldata_1.method1056();
      } else if (int_1 == 2) {
         modeldata_1.method1057();
      } else if (int_1 == 3) {
         modeldata_1.method1058();
      }

      if (this.recolorToFind != null) {
         for (int_4 = 0; int_4 < this.recolorToFind.length; int_4++) {
            modeldata_1.recolor(this.recolorToFind[int_4], this.recolorToReplace[int_4]);
         }
      }

      if (this.textureToFind != null) {
         for (int_4 = 0; int_4 < this.textureToFind.length; int_4++) {
            modeldata_1.method1051(this.textureToFind[int_4], this.textureToReplace[int_4]);
         }
      }

      if (bool_0) {
         modeldata_1.method1050(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if (bool_2) {
         modeldata_1.method1052(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return modeldata_1;
   }

   void post() {
      if (this.anInt461 == -1) {
         this.anInt461 = 0;
         if (this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
            this.anInt461 = 1;
         }

         for (int int_0 = 0; int_0 < 5; int_0++) {
            if (this.actions[int_0] != null) {
               this.anInt461 = 1;
            }
         }
      }

      if (this.anInt462 == -1) {
         this.anInt462 = this.interactType != 0 ? 1 : 0;
      }

   }

   void decode(Buffer buffer_0) {
      while (true) {
         int int_0 = buffer_0.getUnsignedByte();
         if (int_0 == 0) {
            return;
         }

         this.loadData(buffer_0, int_0);
      }
   }

   public Model method822(int int_0, int int_1, int[][] ints_0, int int_2, int int_3, int int_4, Sequence sequence_0, int int_5) {
      long long_0;
      if (this.objectTypes == null) {
         long_0 = (long)(int_1 + (this.id << 10));
      } else {
         long_0 = (long)(int_1 + (int_0 << 3) + (this.id << 10));
      }

      Model model_0 = (Model) aNodeCache8.get(long_0);
      if (model_0 == null) {
         ModelData modeldata_0 = this.getModel(int_0, int_1);
         if (modeldata_0 == null) {
            return null;
         }

         model_0 = modeldata_0.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         aNodeCache8.put(model_0, long_0);
      }

      if (sequence_0 == null && this.clipType == -1) {
         return model_0;
      } else {
         if (sequence_0 != null) {
            model_0 = sequence_0.method915(model_0, int_5, int_1);
         } else {
            model_0 = model_0.method1013(true);
         }

         if (this.clipType >= 0) {
            model_0 = model_0.method1017(ints_0, int_2, int_3, int_4, false, this.clipType);
         }

         return model_0;
      }
   }

   public boolean method823() {
      if (this.objectModels == null) {
         return true;
      } else {
         boolean bool_0 = true;

         for (int int_0 = 0; int_0 < this.objectModels.length; int_0++) {
            bool_0 &= anIndexDataBase20.method431(this.objectModels[int_0] & 0xFFFF, 0);
         }

         return bool_0;
      }
   }

   public boolean method824(int int_0) {
      if (this.objectTypes != null) {
         for (int int_2 = 0; int_2 < this.objectTypes.length; int_2++) {
            if (this.objectTypes[int_2] == int_0) {
               return anIndexDataBase20.method431(this.objectModels[int_2] & 0xFFFF, 0);
            }
         }

         return true;
      } else if (this.objectModels == null) {
         return true;
      } else if (int_0 != 10) {
         return true;
      } else {
         boolean bool_0 = true;

         for (int int_1 = 0; int_1 < this.objectModels.length; int_1++) {
            bool_0 &= anIndexDataBase20.method431(this.objectModels[int_1] & 0xFFFF, 0);
         }

         return bool_0;
      }
   }

   public Model method825(int int_0, int int_1, int[][] ints_0, int int_2, int int_3, int int_4) {
      long long_0;
      if (this.objectTypes == null) {
         long_0 = (long)(int_1 + (this.id << 10));
      } else {
         long_0 = (long)(int_1 + (int_0 << 3) + (this.id << 10));
      }

      Model model_0 = (Model) aNodeCache8.get(long_0);
      if (model_0 == null) {
         ModelData modeldata_0 = this.getModel(int_0, int_1);
         if (modeldata_0 == null) {
            return null;
         }

         model_0 = modeldata_0.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         aNodeCache8.put(model_0, long_0);
      }

      if (this.clipType >= 0) {
         model_0 = model_0.method1017(ints_0, int_2, int_3, int_4, true, this.clipType);
      }

      return model_0;
   }

   public String method826(int int_0, String string_0) {
      return VertexNormal.method492(this.anIterableHashTable2, int_0, string_0);
   }

   public int method827(int int_0, int int_1) {
      return Occluder.method392(this.anIterableHashTable2, int_0, int_1);
   }

   public boolean method828() {
      if (this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.anIntArray85 != null;
      } else {
         for (int int_0 = 0; int_0 < this.impostorIds.length; int_0++) {
            if (this.impostorIds[int_0] != -1) {
               ObjectComposition objectcomposition_1 = Class28.getObjectDefinition(this.impostorIds[int_0]);
               if (objectcomposition_1.ambientSoundId != -1 || objectcomposition_1.anIntArray85 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public Renderable getModel(int int_0, int int_1, int[][] ints_0, int int_2, int int_3, int int_4) {
      long long_0;
      if (this.objectTypes == null) {
         long_0 = (long)(int_1 + (this.id << 10));
      } else {
         long_0 = (long)(int_1 + (int_0 << 3) + (this.id << 10));
      }

      Object object_0 = (Renderable) cachedModels.get(long_0);
      if (object_0 == null) {
         ModelData modeldata_0 = this.getModel(int_0, int_1);
         if (modeldata_0 == null) {
            return null;
         }

         if (!this.nonFlatShading) {
            object_0 = modeldata_0.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         } else {
            modeldata_0.aShort2 = (short)(this.ambient + 64);
            modeldata_0.contrast = (short)(this.contrast + 768);
            modeldata_0.computeNormals();
            object_0 = modeldata_0;
         }

         cachedModels.put((CacheableNode) object_0, long_0);
      }

      if (this.nonFlatShading) {
         object_0 = ((ModelData) object_0).method1049();
      }

      if (this.clipType >= 0) {
         if (object_0 instanceof Model) {
            object_0 = ((Model) object_0).method1017(ints_0, int_2, int_3, int_4, true, this.clipType);
         } else if (object_0 instanceof ModelData) {
            object_0 = ((ModelData) object_0).method1053(ints_0, int_2, int_3, int_4, true, this.clipType);
         }
      }

      return (Renderable) object_0;
   }

   static SpritePixels[] method829() {
      SpritePixels[] spritepixelss_0 = new SpritePixels[Class111.anInt216];

      for (int int_0 = 0; int_0 < Class111.anInt216; int_0++) {
         SpritePixels spritepixels_0 = spritepixelss_0[int_0] = new SpritePixels();
         spritepixels_0.maxWidth = Class111.anInt214;
         spritepixels_0.maxHeight = Class111.anInt215;
         spritepixels_0.offsetX = Class111.anIntArray54[int_0];
         spritepixels_0.offsetY = Class7.offsetsY[int_0];
         spritepixels_0.width = ItemContainer.anIntArray76[int_0];
         spritepixels_0.height = Class6.anIntArray3[int_0];
         int int_1 = spritepixels_0.height * spritepixels_0.width;
         byte[] bytes_0 = Class111.spritePixels[int_0];
         spritepixels_0.pixels = new int[int_1];

         for (int int_2 = 0; int_2 < int_1; int_2++) {
            spritepixels_0.pixels[int_2] = Class111.anIntArray55[bytes_0[int_2] & 0xFF];
         }
      }

      Class98.method523();
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
