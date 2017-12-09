public class PlayerComposition {

   static final int[] anIntArray46;
   public static short[][] colorsToReplace;
   public static NodeCache aNodeCache1;
   public static short[] colorsToFind;
   public int transformedNpcId;
   int[] bodyPartColours;
   long hash;
   public boolean isFemale;
   int[] equipmentIds;
   long aLong10;

   static {
      anIntArray46 = new int[] {8, 11, 4, 6, 9, 7, 10};
      aNodeCache1 = new NodeCache(260);
   }

   public void updateAppearance(int[] models, int[] colours, boolean female, int npcId) {
      if (models == null) {
         models = new int[12];

         for (int part = 0; part < 7; part++) {
            for (int index = 0; index < KitDefinition.count; index++) {
               KitDefinition kit = Class70.getKitDefinition(index);
               if (kit != null && !kit.nonSelectable && kit.bodyPartId == part + (female ? 7 : 0)) {
                  models[anIntArray46[part]] = index + 256;
                  break;
               }
            }
         }
      }

      this.equipmentIds = models;
      this.bodyPartColours = colours;
      this.isFemale = female;
      this.transformedNpcId = npcId;
      this.setHash();
   }

   void setHash() {
      long long_0 = this.hash;
      int int_0 = this.equipmentIds[5];
      int int_1 = this.equipmentIds[9];
      this.equipmentIds[5] = int_1;
      this.equipmentIds[9] = int_0;
      this.hash = 0L;

      int int_2;
      for (int_2 = 0; int_2 < 12; int_2++) {
         this.hash <<= 4;
         if (this.equipmentIds[int_2] >= 256) {
            this.hash += (long)(this.equipmentIds[int_2] - 256);
         }
      }

      if (this.equipmentIds[0] >= 256) {
         this.hash += (long)(this.equipmentIds[0] - 256 >> 4);
      }

      if (this.equipmentIds[1] >= 256) {
         this.hash += (long)(this.equipmentIds[1] - 256 >> 8);
      }

      for (int_2 = 0; int_2 < 5; int_2++) {
         this.hash <<= 3;
         this.hash += (long)this.bodyPartColours[int_2];
      }

      this.hash <<= 1;
      this.hash += (long)(this.isFemale ? 1 : 0);
      this.equipmentIds[5] = int_0;
      this.equipmentIds[9] = int_1;
      if (long_0 != 0L && this.hash != long_0) {
         aNodeCache1.remove(long_0);
      }

   }

   public Model method505(Sequence sequence_0, int int_0, Sequence sequence_1, int int_1) {
      if (this.transformedNpcId != -1) {
         return Class27.getNpcDefinition(this.transformedNpcId).method898(sequence_0, int_0, sequence_1, int_1);
      } else {
         long long_0 = this.hash;
         int[] ints_0 = this.equipmentIds;
         if (sequence_0 != null && (sequence_0.leftHandItem >= 0 || sequence_0.rightHandItem >= 0)) {
            ints_0 = new int[12];

            for (int int_2 = 0; int_2 < 12; int_2++) {
               ints_0[int_2] = this.equipmentIds[int_2];
            }

            if (sequence_0.leftHandItem >= 0) {
               long_0 += (long)(sequence_0.leftHandItem - this.equipmentIds[5] << 8);
               ints_0[5] = sequence_0.leftHandItem;
            }

            if (sequence_0.rightHandItem >= 0) {
               long_0 += (long)(sequence_0.rightHandItem - this.equipmentIds[3] << 16);
               ints_0[3] = sequence_0.rightHandItem;
            }
         }

         Model model_0 = (Model) aNodeCache1.get(long_0);
         if (model_0 == null) {
            boolean bool_0 = false;

            int int_4;
            for (int int_3 = 0; int_3 < 12; int_3++) {
               int_4 = ints_0[int_3];
               if (int_4 >= 256 && int_4 < 512 && !Class70.getKitDefinition(int_4 - 256).ready()) {
                  bool_0 = true;
               }

               if (int_4 >= 512 && !CacheableNode_Sub2.getItemDefinition(int_4 - 512).readyWorn(this.isFemale)) {
                  bool_0 = true;
               }
            }

            if (bool_0) {
               if (this.aLong10 != -1L) {
                  model_0 = (Model) aNodeCache1.get(this.aLong10);
               }

               if (model_0 == null) {
                  return null;
               }
            }

            if (model_0 == null) {
               ModelHeader[] modeldatas_0 = new ModelHeader[12];
               int_4 = 0;

               int int_6;
               for (int int_5 = 0; int_5 < 12; int_5++) {
                  int_6 = ints_0[int_5];
                  ModelHeader modeldata_0;
                  if (int_6 >= 256 && int_6 < 512) {
                     modeldata_0 = Class70.getKitDefinition(int_6 - 256).getModelData();
                     if (modeldata_0 != null) {
                        modeldatas_0[int_4++] = modeldata_0;
                     }
                  }

                  if (int_6 >= 512) {
                     modeldata_0 = CacheableNode_Sub2.getItemDefinition(int_6 - 512).getWornModelData(this.isFemale);
                     if (modeldata_0 != null) {
                        modeldatas_0[int_4++] = modeldata_0;
                     }
                  }
               }

               ModelHeader modeldata_1 = new ModelHeader(modeldatas_0, int_4);

               for (int_6 = 0; int_6 < 5; int_6++) {
                  if (this.bodyPartColours[int_6] < colorsToReplace[int_6].length) {
                     modeldata_1.recolor(colorsToFind[int_6], colorsToReplace[int_6][this.bodyPartColours[int_6]]);
                  }

                  if (this.bodyPartColours[int_6] < Class104.aShortArrayArray3[int_6].length) {
                     modeldata_1.recolor(Class26.aShortArray2[int_6], Class104.aShortArrayArray3[int_6][this.bodyPartColours[int_6]]);
                  }
               }

               model_0 = modeldata_1.applyLighting(64, 850, -30, -50, -30);
               aNodeCache1.put(model_0, long_0);
               this.aLong10 = long_0;
            }
         }

         if (sequence_0 == null && sequence_1 == null) {
            return model_0;
         } else {
            Model model_1;
            if (sequence_0 != null && sequence_1 != null) {
               model_1 = sequence_0.method914(model_0, int_0, sequence_1, int_1);
            } else if (sequence_0 != null) {
               model_1 = sequence_0.method913(model_0, int_0);
            } else {
               model_1 = sequence_1.method913(model_0, int_1);
            }

            return model_1;
         }
      }
   }

   ModelHeader method506() {
      if (this.transformedNpcId != -1) {
         return Class27.getNpcDefinition(this.transformedNpcId).method899();
      } else {
         boolean bool_0 = false;

         int int_1;
         for (int int_0 = 0; int_0 < 12; int_0++) {
            int_1 = this.equipmentIds[int_0];
            if (int_1 >= 256 && int_1 < 512 && !Class70.getKitDefinition(int_1 - 256).method806()) {
               bool_0 = true;
            }

            if (int_1 >= 512 && !CacheableNode_Sub2.getItemDefinition(int_1 - 512).method935(this.isFemale)) {
               bool_0 = true;
            }
         }

         if (bool_0) {
            return null;
         } else {
            ModelHeader[] modeldatas_0 = new ModelHeader[12];
            int_1 = 0;

            int int_3;
            for (int int_2 = 0; int_2 < 12; int_2++) {
               int_3 = this.equipmentIds[int_2];
               ModelHeader modeldata_0;
               if (int_3 >= 256 && int_3 < 512) {
                  modeldata_0 = Class70.getKitDefinition(int_3 - 256).method807();
                  if (modeldata_0 != null) {
                     modeldatas_0[int_1++] = modeldata_0;
                  }
               }

               if (int_3 >= 512) {
                  modeldata_0 = CacheableNode_Sub2.getItemDefinition(int_3 - 512).method936(this.isFemale);
                  if (modeldata_0 != null) {
                     modeldatas_0[int_1++] = modeldata_0;
                  }
               }
            }

            ModelHeader modeldata_1 = new ModelHeader(modeldatas_0, int_1);

            for (int_3 = 0; int_3 < 5; int_3++) {
               if (this.bodyPartColours[int_3] < colorsToReplace[int_3].length) {
                  modeldata_1.recolor(colorsToFind[int_3], colorsToReplace[int_3][this.bodyPartColours[int_3]]);
               }

               if (this.bodyPartColours[int_3] < Class104.aShortArrayArray3[int_3].length) {
                  modeldata_1.recolor(Class26.aShortArray2[int_3], Class104.aShortArrayArray3[int_3][this.bodyPartColours[int_3]]);
               }
            }

            return modeldata_1;
         }
      }
   }

   public int method507() {
      return this.transformedNpcId == -1 ? (this.equipmentIds[0] << 15) + this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20) : 305419896 + Class27.getNpcDefinition(this.transformedNpcId).id;
   }

   public void method508(int int_0, boolean bool_0) {
      if (int_0 != 1 || !this.isFemale) {
         int int_1 = this.equipmentIds[anIntArray46[int_0]];
         if (int_1 != 0) {
            int_1 -= 256;

            KitDefinition kitdefinition_0;
            do {
               if (!bool_0) {
                  --int_1;
                  if (int_1 < 0) {
                     int_1 = KitDefinition.count - 1;
                  }
               } else {
                  ++int_1;
                  if (int_1 >= KitDefinition.count) {
                     int_1 = 0;
                  }
               }

               kitdefinition_0 = Class70.getKitDefinition(int_1);
            } while (kitdefinition_0 == null || kitdefinition_0.nonSelectable || kitdefinition_0.bodyPartId != int_0 + (this.isFemale ? 7 : 0));

            this.equipmentIds[anIntArray46[int_0]] = int_1 + 256;
            this.setHash();
         }
      }
   }

   public void method509(int int_0, boolean bool_0) {
      int int_1 = this.bodyPartColours[int_0];
      boolean bool_1;
      if (!bool_0) {
         do {
            --int_1;
            if (int_1 < 0) {
               int_1 = colorsToReplace[int_0].length - 1;
            }

            if (int_0 == 4 && int_1 >= 8) {
               bool_1 = false;
            } else {
               bool_1 = true;
            }
         } while (!bool_1);
      } else {
         do {
            ++int_1;
            if (int_1 >= colorsToReplace[int_0].length) {
               int_1 = 0;
            }

            if (int_0 == 4 && int_1 >= 8) {
               bool_1 = false;
            } else {
               bool_1 = true;
            }
         } while (!bool_1);
      }

      this.bodyPartColours[int_0] = int_1;
      this.setHash();
   }

   public void method510(boolean bool_0) {
      if (this.isFemale != bool_0) {
         this.updateAppearance((int[]) null, this.bodyPartColours, bool_0, -1);
      }
   }

   public void method511(Buffer buffer_0) {
      buffer_0.putByte(this.isFemale ? 1 : 0);

      int int_0;
      for (int_0 = 0; int_0 < 7; int_0++) {
         int int_1 = this.equipmentIds[anIntArray46[int_0]];
         if (int_1 == 0) {
            buffer_0.putByte(-1);
         } else {
            buffer_0.putByte(int_1 - 256);
         }
      }

      for (int_0 = 0; int_0 < 5; int_0++) {
         buffer_0.putByte(this.bodyPartColours[int_0]);
      }

   }

   static void method512(int int_0) {
      if (CombatInfoListHolder.loadWidget(int_0)) {
         Widget[] widgets_0 = Class91.widgets[int_0];

         for (int int_1 = 0; int_1 < widgets_0.length; int_1++) {
            Widget widget_0 = widgets_0[int_1];
            if (widget_0 != null) {
               widget_0.anInt281 = 0;
               widget_0.anInt280 = 0;
            }
         }

      }
   }

}
