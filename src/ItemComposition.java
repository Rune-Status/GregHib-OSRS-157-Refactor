public class ItemComposition extends CacheableNode {

   static NodeCache items;
   static NodeCache itemModelCache;
   public static IndexDataBase anIndexDataBase30;
   public static IndexDataBase item_ref;
   public static NodeCache itemSpriteCache;
   public static int anInt503;
   public static Font aFont5;
   int maleHeadModel;
   int maleModel;
   int inventoryModel;
   int[] countObj;
   int team;
   IterableHashTable anIterableHashTable5;
   int maleHeadModel2;
   int maleModel1;
   int maleModel2;
   public String[] inventoryActions;
   public String name;
   int femaleHeadModel;
   public int zoom2d;
   public int id;
   int femaleModel;
   int femaleHeadModel2;
   int[] countCo;
   int femaleModel1;
   int femaleModel2;
   public int xan2d;
   int resizeX;
   public int yan2d;
   public int offsetX2d;
   public int isStackable;
   int resizeY;
   public int offsetY2d;
   public int zan2d;
   public boolean isMembers;
   short[] colourToReplace;
   public int price;
   int resizeZ;
   short[] textureToReplace;
   int maleOffset;
   int femaleOffset;
   public int notedTemplate;
   short[] colourToReplaceWith;
   public String[] groundActions;
   short[] textToReplaceWith;
   public boolean aBool68;
   public int ambient;
   int notedId;
   public int contrast;
   public int note;
   public int anInt504;
   public int anInt505;
   int unnotedId;
   public int anInt506;

   static {
      items = new NodeCache(64);
      itemModelCache = new NodeCache(50);
      itemSpriteCache = new NodeCache(200);
   }

   ItemComposition() {
      this.name = "null";
      this.zoom2d = 2000;
      this.xan2d = 0;
      this.yan2d = 0;
      this.zan2d = 0;
      this.offsetX2d = 0;
      this.offsetY2d = 0;
      this.isStackable = 0;
      this.price = 1;
      this.isMembers = false;
      this.groundActions = new String[] {null, null, "Take", null, null};
      this.inventoryActions = new String[] {null, null, null, null, "Drop"};
      this.team = -2;
      this.maleModel = -1;
      this.maleModel1 = -1;
      this.maleOffset = 0;
      this.femaleModel = -1;
      this.femaleModel1 = -1;
      this.femaleOffset = 0;
      this.maleModel2 = -1;
      this.femaleModel2 = -1;
      this.maleHeadModel = -1;
      this.maleHeadModel2 = -1;
      this.femaleHeadModel = -1;
      this.femaleHeadModel2 = -1;
      this.note = -1;
      this.notedTemplate = -1;
      this.resizeX = 128;
      this.resizeY = 128;
      this.resizeZ = 128;
      this.ambient = 0;
      this.contrast = 0;
      this.anInt504 = 0;
      this.aBool68 = false;
      this.unnotedId = -1;
      this.notedId = -1;
      this.anInt506 = -1;
      this.anInt505 = -1;
   }

   void populateFromBuffer(Buffer buffer_0, int int_0) {
      if (int_0 == 1) {
         this.inventoryModel = buffer_0.readUnsignedShort();
      } else if (int_0 == 2) {
         this.name = buffer_0.readString();
      } else if (int_0 == 4) {
         this.zoom2d = buffer_0.readUnsignedShort();
      } else if (int_0 == 5) {
         this.xan2d = buffer_0.readUnsignedShort();
      } else if (int_0 == 6) {
         this.yan2d = buffer_0.readUnsignedShort();
      } else if (int_0 == 7) {
         this.offsetX2d = buffer_0.readUnsignedShort();
         if (this.offsetX2d > 32767) {
            this.offsetX2d -= 65536;
         }
      } else if (int_0 == 8) {
         this.offsetY2d = buffer_0.readUnsignedShort();
         if (this.offsetY2d > 32767) {
            this.offsetY2d -= 65536;
         }
      } else if (int_0 == 11) {
         this.isStackable = 1;
      } else if (int_0 == 12) {
         this.price = buffer_0.readInt();
      } else if (int_0 == 16) {
         this.isMembers = true;
      } else if (int_0 == 23) {
         this.maleModel = buffer_0.readUnsignedShort();
         this.maleOffset = buffer_0.readUnsignedByte();
      } else if (int_0 == 24) {
         this.maleModel1 = buffer_0.readUnsignedShort();
      } else if (int_0 == 25) {
         this.femaleModel = buffer_0.readUnsignedShort();
         this.femaleOffset = buffer_0.readUnsignedByte();
      } else if (int_0 == 26) {
         this.femaleModel1 = buffer_0.readUnsignedShort();
      } else if (int_0 >= 30 && int_0 < 35) {
         this.groundActions[int_0 - 30] = buffer_0.readString();
         if (this.groundActions[int_0 - 30].equalsIgnoreCase("Hidden")) {
            this.groundActions[int_0 - 30] = null;
         }
      } else if (int_0 >= 35 && int_0 < 40) {
         this.inventoryActions[int_0 - 35] = buffer_0.readString();
      } else {
         int int_1;
         int int_2;
         if (int_0 == 40) {
            int_1 = buffer_0.readUnsignedByte();
            this.colourToReplace = new short[int_1];
            this.colourToReplaceWith = new short[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
               this.colourToReplace[int_2] = (short)buffer_0.readUnsignedShort();
               this.colourToReplaceWith[int_2] = (short)buffer_0.readUnsignedShort();
            }
         } else if (int_0 == 41) {
            int_1 = buffer_0.readUnsignedByte();
            this.textureToReplace = new short[int_1];
            this.textToReplaceWith = new short[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
               this.textureToReplace[int_2] = (short)buffer_0.readUnsignedShort();
               this.textToReplaceWith[int_2] = (short)buffer_0.readUnsignedShort();
            }
         } else if (int_0 == 42) {
            this.team = buffer_0.readByte();
         } else if (int_0 == 65) {
            this.aBool68 = true;
         } else if (int_0 == 78) {
            this.maleModel2 = buffer_0.readUnsignedShort();
         } else if (int_0 == 79) {
            this.femaleModel2 = buffer_0.readUnsignedShort();
         } else if (int_0 == 90) {
            this.maleHeadModel = buffer_0.readUnsignedShort();
         } else if (int_0 == 91) {
            this.femaleHeadModel = buffer_0.readUnsignedShort();
         } else if (int_0 == 92) {
            this.maleHeadModel2 = buffer_0.readUnsignedShort();
         } else if (int_0 == 93) {
            this.femaleHeadModel2 = buffer_0.readUnsignedShort();
         } else if (int_0 == 95) {
            this.zan2d = buffer_0.readUnsignedShort();
         } else if (int_0 == 97) {
            this.note = buffer_0.readUnsignedShort();
         } else if (int_0 == 98) {
            this.notedTemplate = buffer_0.readUnsignedShort();
         } else if (int_0 >= 100 && int_0 < 110) {
            if (this.countObj == null) {
               this.countObj = new int[10];
               this.countCo = new int[10];
            }

            this.countObj[int_0 - 100] = buffer_0.readUnsignedShort();
            this.countCo[int_0 - 100] = buffer_0.readUnsignedShort();
         } else if (int_0 == 110) {
            this.resizeX = buffer_0.readUnsignedShort();
         } else if (int_0 == 111) {
            this.resizeY = buffer_0.readUnsignedShort();
         } else if (int_0 == 112) {
            this.resizeZ = buffer_0.readUnsignedShort();
         } else if (int_0 == 113) {
            this.ambient = buffer_0.readByte();
         } else if (int_0 == 114) {
            this.contrast = buffer_0.readByte() * 5;
         } else if (int_0 == 115) {
            this.anInt504 = buffer_0.readUnsignedByte();
         } else if (int_0 == 139) {
            this.unnotedId = buffer_0.readUnsignedShort();
         } else if (int_0 == 140) {
            this.notedId = buffer_0.readUnsignedShort();
         } else if (int_0 == 148) {
            this.anInt506 = buffer_0.readUnsignedShort();
         } else if (int_0 == 149) {
            this.anInt505 = buffer_0.readUnsignedShort();
         } else if (int_0 == 249) {
            this.anIterableHashTable5 = Tile.method682(buffer_0, this.anIterableHashTable5);
         }
      }

   }

   public Model getModel(int int_0) {
      if (this.countObj != null && int_0 > 1) {
         int int_1 = -1;

         for (int int_2 = 0; int_2 < 10; int_2++) {
            if (int_0 >= this.countCo[int_2] && this.countCo[int_2] != 0) {
               int_1 = this.countObj[int_2];
            }
         }

         if (int_1 != -1) {
            return CacheableNode_Sub2.getItemDefinition(int_1).getModel(1);
         }
      }

      Model model_0 = (Model) itemModelCache.get((long)this.id);
      if (model_0 != null) {
         return model_0;
      } else {
         ModelData modeldata_0 = ModelData.method1060(anIndexDataBase30, this.inventoryModel, 0);
         if (modeldata_0 == null) {
            return null;
         } else {
            if (this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               modeldata_0.method1050(this.resizeX, this.resizeY, this.resizeZ);
            }

            int int_3;
            if (this.colourToReplace != null) {
               for (int_3 = 0; int_3 < this.colourToReplace.length; int_3++) {
                  modeldata_0.recolor(this.colourToReplace[int_3], this.colourToReplaceWith[int_3]);
               }
            }

            if (this.textureToReplace != null) {
               for (int_3 = 0; int_3 < this.textureToReplace.length; int_3++) {
                  modeldata_0.method1051(this.textureToReplace[int_3], this.textToReplaceWith[int_3]);
               }
            }

            model_0 = modeldata_0.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            model_0.aBool75 = true;
            itemModelCache.put(model_0, (long)this.id);
            return model_0;
         }
      }
   }

   public ModelData method934(int int_0) {
      int int_2;
      if (this.countObj != null && int_0 > 1) {
         int int_1 = -1;

         for (int_2 = 0; int_2 < 10; int_2++) {
            if (int_0 >= this.countCo[int_2] && this.countCo[int_2] != 0) {
               int_1 = this.countObj[int_2];
            }
         }

         if (int_1 != -1) {
            return CacheableNode_Sub2.getItemDefinition(int_1).method934(1);
         }
      }

      ModelData modeldata_0 = ModelData.method1060(anIndexDataBase30, this.inventoryModel, 0);
      if (modeldata_0 == null) {
         return null;
      } else {
         if (this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            modeldata_0.method1050(this.resizeX, this.resizeY, this.resizeZ);
         }

         if (this.colourToReplace != null) {
            for (int_2 = 0; int_2 < this.colourToReplace.length; int_2++) {
               modeldata_0.recolor(this.colourToReplace[int_2], this.colourToReplaceWith[int_2]);
            }
         }

         if (this.textureToReplace != null) {
            for (int_2 = 0; int_2 < this.textureToReplace.length; int_2++) {
               modeldata_0.method1051(this.textureToReplace[int_2], this.textToReplaceWith[int_2]);
            }
         }

         return modeldata_0;
      }
   }

   void post() {
   }

   public boolean method935(boolean bool_0) {
      int int_0 = this.maleHeadModel;
      int int_1 = this.maleHeadModel2;
      if (bool_0) {
         int_0 = this.femaleHeadModel;
         int_1 = this.femaleHeadModel2;
      }

      if (int_0 == -1) {
         return true;
      } else {
         boolean bool_1 = true;
         if (!anIndexDataBase30.method431(int_0, 0)) {
            bool_1 = false;
         }

         if (int_1 != -1 && !anIndexDataBase30.method431(int_1, 0)) {
            bool_1 = false;
         }

         return bool_1;
      }
   }

   public ModelData method936(boolean bool_0) {
      int int_0 = this.maleHeadModel;
      int int_1 = this.maleHeadModel2;
      if (bool_0) {
         int_0 = this.femaleHeadModel;
         int_1 = this.femaleHeadModel2;
      }

      if (int_0 == -1) {
         return null;
      } else {
         ModelData modeldata_0 = ModelData.method1060(anIndexDataBase30, int_0, 0);
         if (int_1 != -1) {
            ModelData modeldata_1 = ModelData.method1060(anIndexDataBase30, int_1, 0);
            ModelData[] modeldatas_0 = new ModelData[] {modeldata_0, modeldata_1};
            modeldata_0 = new ModelData(modeldatas_0, 2);
         }

         int int_2;
         if (this.colourToReplace != null) {
            for (int_2 = 0; int_2 < this.colourToReplace.length; int_2++) {
               modeldata_0.recolor(this.colourToReplace[int_2], this.colourToReplaceWith[int_2]);
            }
         }

         if (this.textureToReplace != null) {
            for (int_2 = 0; int_2 < this.textureToReplace.length; int_2++) {
               modeldata_0.method1051(this.textureToReplace[int_2], this.textToReplaceWith[int_2]);
            }
         }

         return modeldata_0;
      }
   }

   void loadBuffer(Buffer buffer_0) {
      while (true) {
         int int_0 = buffer_0.readUnsignedByte();
         if (int_0 == 0) {
            return;
         }

         this.populateFromBuffer(buffer_0, int_0);
      }
   }

   public boolean readyWorn(boolean bool_0) {
      int int_0 = this.maleModel;
      int int_1 = this.maleModel1;
      int int_2 = this.maleModel2;
      if (bool_0) {
         int_0 = this.femaleModel;
         int_1 = this.femaleModel1;
         int_2 = this.femaleModel2;
      }

      if (int_0 == -1) {
         return true;
      } else {
         boolean bool_1 = true;
         if (!anIndexDataBase30.method431(int_0, 0)) {
            bool_1 = false;
         }

         if (int_1 != -1 && !anIndexDataBase30.method431(int_1, 0)) {
            bool_1 = false;
         }

         if (int_2 != -1 && !anIndexDataBase30.method431(int_2, 0)) {
            bool_1 = false;
         }

         return bool_1;
      }
   }

   public ModelData getWornModelData(boolean bool_0) {
      int int_0 = this.maleModel;
      int int_1 = this.maleModel1;
      int int_2 = this.maleModel2;
      if (bool_0) {
         int_0 = this.femaleModel;
         int_1 = this.femaleModel1;
         int_2 = this.femaleModel2;
      }

      if (int_0 == -1) {
         return null;
      } else {
         ModelData modeldata_0 = ModelData.method1060(anIndexDataBase30, int_0, 0);
         if (int_1 != -1) {
            ModelData modeldata_1 = ModelData.method1060(anIndexDataBase30, int_1, 0);
            if (int_2 != -1) {
               ModelData modeldata_2 = ModelData.method1060(anIndexDataBase30, int_2, 0);
               ModelData[] modeldatas_0 = new ModelData[] {modeldata_0, modeldata_1, modeldata_2};
               modeldata_0 = new ModelData(modeldatas_0, 3);
            } else {
               ModelData[] modeldatas_1 = new ModelData[] {modeldata_0, modeldata_1};
               modeldata_0 = new ModelData(modeldatas_1, 2);
            }
         }

         if (!bool_0 && this.maleOffset != 0) {
            modeldata_0.method1052(0, this.maleOffset, 0);
         }

         if (bool_0 && this.femaleOffset != 0) {
            modeldata_0.method1052(0, this.femaleOffset, 0);
         }

         int int_3;
         if (this.colourToReplace != null) {
            for (int_3 = 0; int_3 < this.colourToReplace.length; int_3++) {
               modeldata_0.recolor(this.colourToReplace[int_3], this.colourToReplaceWith[int_3]);
            }
         }

         if (this.textureToReplace != null) {
            for (int_3 = 0; int_3 < this.textureToReplace.length; int_3++) {
               modeldata_0.method1051(this.textureToReplace[int_3], this.textToReplaceWith[int_3]);
            }
         }

         return modeldata_0;
      }
   }

   void method937(ItemComposition itemcomposition_1, ItemComposition itemcomposition_2) {
      this.inventoryModel = itemcomposition_1.inventoryModel;
      this.zoom2d = itemcomposition_1.zoom2d;
      this.xan2d = itemcomposition_1.xan2d;
      this.yan2d = itemcomposition_1.yan2d;
      this.zan2d = itemcomposition_1.zan2d;
      this.offsetX2d = itemcomposition_1.offsetX2d;
      this.offsetY2d = itemcomposition_1.offsetY2d;
      this.colourToReplace = itemcomposition_1.colourToReplace;
      this.colourToReplaceWith = itemcomposition_1.colourToReplaceWith;
      this.textureToReplace = itemcomposition_1.textureToReplace;
      this.textToReplaceWith = itemcomposition_1.textToReplaceWith;
      this.name = itemcomposition_2.name;
      this.isMembers = itemcomposition_2.isMembers;
      this.price = itemcomposition_2.price;
      this.isStackable = 1;
   }

   void method938(ItemComposition itemcomposition_1, ItemComposition itemcomposition_2) {
      this.inventoryModel = itemcomposition_1.inventoryModel;
      this.zoom2d = itemcomposition_1.zoom2d;
      this.xan2d = itemcomposition_1.xan2d;
      this.yan2d = itemcomposition_1.yan2d;
      this.zan2d = itemcomposition_1.zan2d;
      this.offsetX2d = itemcomposition_1.offsetX2d;
      this.offsetY2d = itemcomposition_1.offsetY2d;
      this.colourToReplace = itemcomposition_2.colourToReplace;
      this.colourToReplaceWith = itemcomposition_2.colourToReplaceWith;
      this.textureToReplace = itemcomposition_2.textureToReplace;
      this.textToReplaceWith = itemcomposition_2.textToReplaceWith;
      this.name = itemcomposition_2.name;
      this.isMembers = itemcomposition_2.isMembers;
      this.isStackable = itemcomposition_2.isStackable;
      this.maleModel = itemcomposition_2.maleModel;
      this.maleModel1 = itemcomposition_2.maleModel1;
      this.maleModel2 = itemcomposition_2.maleModel2;
      this.femaleModel = itemcomposition_2.femaleModel;
      this.femaleModel1 = itemcomposition_2.femaleModel1;
      this.femaleModel2 = itemcomposition_2.femaleModel2;
      this.maleHeadModel = itemcomposition_2.maleHeadModel;
      this.maleHeadModel2 = itemcomposition_2.maleHeadModel2;
      this.femaleHeadModel = itemcomposition_2.femaleHeadModel;
      this.femaleHeadModel2 = itemcomposition_2.femaleHeadModel2;
      this.anInt504 = itemcomposition_2.anInt504;
      this.groundActions = itemcomposition_2.groundActions;
      this.inventoryActions = new String[5];
      if (itemcomposition_2.inventoryActions != null) {
         for (int int_0 = 0; int_0 < 4; int_0++) {
            this.inventoryActions[int_0] = itemcomposition_2.inventoryActions[int_0];
         }
      }

      this.inventoryActions[4] = "Discard";
      this.price = 0;
   }

   void method939(ItemComposition itemcomposition_1, ItemComposition itemcomposition_2) {
      this.inventoryModel = itemcomposition_1.inventoryModel;
      this.zoom2d = itemcomposition_1.zoom2d;
      this.xan2d = itemcomposition_1.xan2d;
      this.yan2d = itemcomposition_1.yan2d;
      this.zan2d = itemcomposition_1.zan2d;
      this.offsetX2d = itemcomposition_1.offsetX2d;
      this.offsetY2d = itemcomposition_1.offsetY2d;
      this.colourToReplace = itemcomposition_1.colourToReplace;
      this.colourToReplaceWith = itemcomposition_1.colourToReplaceWith;
      this.textureToReplace = itemcomposition_1.textureToReplace;
      this.textToReplaceWith = itemcomposition_1.textToReplaceWith;
      this.isStackable = itemcomposition_1.isStackable;
      this.name = itemcomposition_2.name;
      this.price = 0;
      this.isMembers = false;
      this.aBool68 = false;
   }

   public ItemComposition method940(int int_0) {
      if (this.countObj != null && int_0 > 1) {
         int int_1 = -1;

         for (int int_2 = 0; int_2 < 10; int_2++) {
            if (int_0 >= this.countCo[int_2] && this.countCo[int_2] != 0) {
               int_1 = this.countObj[int_2];
            }
         }

         if (int_1 != -1) {
            return CacheableNode_Sub2.getItemDefinition(int_1);
         }
      }

      return this;
   }

   public int method941(int int_0, int int_1) {
      return Occluder.method392(this.anIterableHashTable5, int_0, int_1);
   }

   public String method942(int int_0, String string_0) {
      return VertexNormal.method492(this.anIterableHashTable5, int_0, string_0);
   }

   public int method943() {
      return this.team != -1 && this.inventoryActions != null ? (this.team >= 0 ? (this.inventoryActions[this.team] != null ? this.team : -1) : ("Drop".equalsIgnoreCase(this.inventoryActions[4]) ? 4 : -1)) : -1;
   }

   static World method944() {
      return World.anInt219 < World.worldCount ? Coordinates.worldList[++World.anInt219 - 1] : null;
   }

}
