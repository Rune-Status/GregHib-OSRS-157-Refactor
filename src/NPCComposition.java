public class NPCComposition extends CacheableNode {

   public static NodeCache npcModelCache;
   public static NodeCache npcs;
   public static IndexDataBase anIndexDataBase28;
   public static IndexDataBase anIndexDataBase29;
   IterableHashTable anIterableHashTable4;
   int varpIndex;
   public int[] configs;
   public String name;
   int varp32Index;
   int[] anIntArray104;
   int[] models;
   public int id;
   public int anInt489;
   public int anInt490;
   public int anInt491;
   public int anInt492;
   public int anInt493;
   public String[] actions;
   int anInt494;
   short[] colors;
   public boolean isMinimapVisible;
   int anInt495;
   short[] aShortArray10;
   short[] modifiedColors;
   public int anInt496;
   short[] aShortArray11;
   public int anInt497;
   public int combatLevel;
   public boolean isVisible;
   public int anInt498;
   int anInt499;
   int anInt500;
   public int anInt501;
   public int anInt502;
   public boolean aBool66;
   public boolean isClickable;
   public boolean aBool67;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.anInt489 = 1;
      this.anInt490 = -1;
      this.anInt492 = -1;
      this.anInt493 = -1;
      this.anInt491 = -1;
      this.anInt496 = -1;
      this.anInt497 = -1;
      this.anInt498 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.anInt494 = 128;
      this.anInt495 = 128;
      this.isVisible = false;
      this.anInt499 = 0;
      this.anInt500 = 0;
      this.anInt501 = -1;
      this.anInt502 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.aBool66 = true;
      this.isClickable = true;
      this.aBool67 = false;
   }

   public NPCComposition transform() {
      int int_0 = -1;
      if (this.varpIndex != -1) {
         int_0 = Item.method973(this.varpIndex);
      } else if (this.varp32Index != -1) {
         int_0 = Class79.widgetSettings[this.varp32Index];
      }

      int int_1;
      if (int_0 >= 0 && int_0 < this.configs.length - 1) {
         int_1 = this.configs[int_0];
      } else {
         int_1 = this.configs[this.configs.length - 1];
      }

      return int_1 != -1 ? Class27.getNpcDefinition(int_1) : null;
   }

   void method897(Buffer buffer_0, int int_0) {
      int int_1;
      int int_2;
      if (int_0 == 1) {
         int_1 = buffer_0.getUnsignedByte();
         this.models = new int[int_1];

         for (int_2 = 0; int_2 < int_1; int_2++) {
            this.models[int_2] = buffer_0.getUnsignedShort();
         }
      } else if (int_0 == 2) {
         this.name = buffer_0.readString();
      } else if (int_0 == 12) {
         this.anInt489 = buffer_0.getUnsignedByte();
      } else if (int_0 == 13) {
         this.anInt490 = buffer_0.getUnsignedShort();
      } else if (int_0 == 14) {
         this.anInt491 = buffer_0.getUnsignedShort();
      } else if (int_0 == 15) {
         this.anInt492 = buffer_0.getUnsignedShort();
      } else if (int_0 == 16) {
         this.anInt493 = buffer_0.getUnsignedShort();
      } else if (int_0 == 17) {
         this.anInt491 = buffer_0.getUnsignedShort();
         this.anInt496 = buffer_0.getUnsignedShort();
         this.anInt497 = buffer_0.getUnsignedShort();
         this.anInt498 = buffer_0.getUnsignedShort();
      } else if (int_0 >= 30 && int_0 < 35) {
         this.actions[int_0 - 30] = buffer_0.readString();
         if (this.actions[int_0 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[int_0 - 30] = null;
         }
      } else if (int_0 == 40) {
         int_1 = buffer_0.getUnsignedByte();
         this.colors = new short[int_1];
         this.modifiedColors = new short[int_1];

         for (int_2 = 0; int_2 < int_1; int_2++) {
            this.colors[int_2] = (short)buffer_0.getUnsignedShort();
            this.modifiedColors[int_2] = (short)buffer_0.getUnsignedShort();
         }
      } else if (int_0 == 41) {
         int_1 = buffer_0.getUnsignedByte();
         this.aShortArray10 = new short[int_1];
         this.aShortArray11 = new short[int_1];

         for (int_2 = 0; int_2 < int_1; int_2++) {
            this.aShortArray10[int_2] = (short)buffer_0.getUnsignedShort();
            this.aShortArray11[int_2] = (short)buffer_0.getUnsignedShort();
         }
      } else if (int_0 == 60) {
         int_1 = buffer_0.getUnsignedByte();
         this.anIntArray104 = new int[int_1];

         for (int_2 = 0; int_2 < int_1; int_2++) {
            this.anIntArray104[int_2] = buffer_0.getUnsignedShort();
         }
      } else if (int_0 == 93) {
         this.isMinimapVisible = false;
      } else if (int_0 == 95) {
         this.combatLevel = buffer_0.getUnsignedShort();
      } else if (int_0 == 97) {
         this.anInt494 = buffer_0.getUnsignedShort();
      } else if (int_0 == 98) {
         this.anInt495 = buffer_0.getUnsignedShort();
      } else if (int_0 == 99) {
         this.isVisible = true;
      } else if (int_0 == 100) {
         this.anInt499 = buffer_0.readByte();
      } else if (int_0 == 101) {
         this.anInt500 = buffer_0.readByte() * 5;
      } else if (int_0 == 102) {
         this.anInt501 = buffer_0.getUnsignedShort();
      } else if (int_0 == 103) {
         this.anInt502 = buffer_0.getUnsignedShort();
      } else if (int_0 != 106 && int_0 != 118) {
         if (int_0 == 107) {
            this.aBool66 = false;
         } else if (int_0 == 109) {
            this.isClickable = false;
         } else if (int_0 == 111) {
            this.aBool67 = true;
         } else if (int_0 == 249) {
            this.anIterableHashTable4 = Tile.method682(buffer_0, this.anIterableHashTable4);
         }
      } else {
         this.varpIndex = buffer_0.getUnsignedShort();
         if (this.varpIndex == 65535) {
            this.varpIndex = -1;
         }

         this.varp32Index = buffer_0.getUnsignedShort();
         if (this.varp32Index == 65535) {
            this.varp32Index = -1;
         }

         int_1 = -1;
         if (int_0 == 118) {
            int_1 = buffer_0.getUnsignedShort();
            if (int_1 == 65535) {
               int_1 = -1;
            }
         }

         int_2 = buffer_0.getUnsignedByte();
         this.configs = new int[int_2 + 2];

         for (int int_3 = 0; int_3 <= int_2; int_3++) {
            this.configs[int_3] = buffer_0.getUnsignedShort();
            if (this.configs[int_3] == 65535) {
               this.configs[int_3] = -1;
            }
         }

         this.configs[int_2 + 1] = int_1;
      }

   }

   public Model method898(Sequence sequence_0, int int_0, Sequence sequence_1, int int_1) {
      if (this.configs != null) {
         NPCComposition npccomposition_1 = this.transform();
         return npccomposition_1 == null ? null : npccomposition_1.method898(sequence_0, int_0, sequence_1, int_1);
      } else {
         Model model_0 = (Model) npcModelCache.get((long)this.id);
         if (model_0 == null) {
            boolean bool_0 = false;

            for (int int_2 = 0; int_2 < this.models.length; int_2++) {
               if (!anIndexDataBase28.method431(this.models[int_2], 0)) {
                  bool_0 = true;
               }
            }

            if (bool_0) {
               return null;
            }

            ModelData[] modeldatas_0 = new ModelData[this.models.length];

            int int_3;
            for (int_3 = 0; int_3 < this.models.length; int_3++) {
               modeldatas_0[int_3] = ModelData.method1060(anIndexDataBase28, this.models[int_3], 0);
            }

            ModelData modeldata_0;
            if (modeldatas_0.length == 1) {
               modeldata_0 = modeldatas_0[0];
            } else {
               modeldata_0 = new ModelData(modeldatas_0, modeldatas_0.length);
            }

            if (this.colors != null) {
               for (int_3 = 0; int_3 < this.colors.length; int_3++) {
                  modeldata_0.recolor(this.colors[int_3], this.modifiedColors[int_3]);
               }
            }

            if (this.aShortArray10 != null) {
               for (int_3 = 0; int_3 < this.aShortArray10.length; int_3++) {
                  modeldata_0.method1051(this.aShortArray10[int_3], this.aShortArray11[int_3]);
               }
            }

            model_0 = modeldata_0.light(this.anInt499 + 64, this.anInt500 + 850, -30, -50, -30);
            npcModelCache.put(model_0, (long)this.id);
         }

         Model model_1;
         if (sequence_0 != null && sequence_1 != null) {
            model_1 = sequence_0.method914(model_0, int_0, sequence_1, int_1);
         } else if (sequence_0 != null) {
            model_1 = sequence_0.method913(model_0, int_0);
         } else if (sequence_1 != null) {
            model_1 = sequence_1.method913(model_0, int_1);
         } else {
            model_1 = model_0.method1013(true);
         }

         if (this.anInt494 != 128 || this.anInt495 != 128) {
            model_1.method1019(this.anInt494, this.anInt495, this.anInt494);
         }

         return model_1;
      }
   }

   public ModelData method899() {
      if (this.configs != null) {
         NPCComposition npccomposition_1 = this.transform();
         return npccomposition_1 == null ? null : npccomposition_1.method899();
      } else if (this.anIntArray104 == null) {
         return null;
      } else {
         boolean bool_0 = false;

         for (int int_0 = 0; int_0 < this.anIntArray104.length; int_0++) {
            if (!anIndexDataBase28.method431(this.anIntArray104[int_0], 0)) {
               bool_0 = true;
            }
         }

         if (bool_0) {
            return null;
         } else {
            ModelData[] modeldatas_0 = new ModelData[this.anIntArray104.length];

            for (int int_1 = 0; int_1 < this.anIntArray104.length; int_1++) {
               modeldatas_0[int_1] = ModelData.method1060(anIndexDataBase28, this.anIntArray104[int_1], 0);
            }

            ModelData modeldata_0;
            if (modeldatas_0.length == 1) {
               modeldata_0 = modeldatas_0[0];
            } else {
               modeldata_0 = new ModelData(modeldatas_0, modeldatas_0.length);
            }

            int int_2;
            if (this.colors != null) {
               for (int_2 = 0; int_2 < this.colors.length; int_2++) {
                  modeldata_0.recolor(this.colors[int_2], this.modifiedColors[int_2]);
               }
            }

            if (this.aShortArray10 != null) {
               for (int_2 = 0; int_2 < this.aShortArray10.length; int_2++) {
                  modeldata_0.method1051(this.aShortArray10[int_2], this.aShortArray11[int_2]);
               }
            }

            return modeldata_0;
         }
      }
   }

   void post() {
   }

   void decode(Buffer buffer_0) {
      while (true) {
         int int_0 = buffer_0.getUnsignedByte();
         if (int_0 == 0) {
            return;
         }

         this.method897(buffer_0, int_0);
      }
   }

   public boolean method900() {
      if (this.configs == null) {
         return true;
      } else {
         int int_0 = -1;
         if (this.varpIndex != -1) {
            int_0 = Item.method973(this.varpIndex);
         } else if (this.varp32Index != -1) {
            int_0 = Class79.widgetSettings[this.varp32Index];
         }

         return int_0 >= 0 && int_0 < this.configs.length ? this.configs[int_0] != -1 : this.configs[this.configs.length - 1] != -1;
      }
   }

   public String method901(int int_0, String string_0) {
      return VertexNormal.method492(this.anIterableHashTable4, int_0, string_0);
   }

   public int method902(int int_0, int int_1) {
      return Occluder.method392(this.anIterableHashTable4, int_0, int_1);
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
