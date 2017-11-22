import java.util.Comparator;

final class Class49 implements Comparator {

   public static IndexDataBase varbit_ref;
   static IndexData indexTextures;

   int method313(Class36 class36_0, Class36 class36_1) {
      return class36_0.anInt96 < class36_1.anInt96 ? -1 : (class36_1.anInt96 == class36_0.anInt96 ? 0 : 1);
   }

   public boolean equals(Object object_0) {
      return super.equals(object_0);
   }

   public int compare(Object object_0, Object object_1) {
      return this.method313((Class36) object_0, (Class36) object_1);
   }

   static void method314(Widget[] widgets_0, int int_0) {
      for (int int_1 = 0; int_1 < widgets_0.length; int_1++) {
         Widget widget_0 = widgets_0[int_1];
         if (widget_0 != null && widget_0.parentId == int_0 && (!widget_0.hasScript || !CacheableNode_Sub5.method887(widget_0))) {
            int int_2;
            if (widget_0.type == 0) {
               if (!widget_0.hasScript && CacheableNode_Sub5.method887(widget_0) && widget_0 != ItemContainer.aWidget6) {
                  continue;
               }

               method314(widgets_0, widget_0.id);
               if (widget_0.children != null) {
                  method314(widget_0.children, widget_0.id);
               }

               WidgetNode widgetnode_0 = (WidgetNode) Client.componentTable.get((long)widget_0.id);
               if (widgetnode_0 != null) {
                  int_2 = widgetnode_0.id;
                  if (CombatInfoListHolder.loadWidget(int_2)) {
                     method314(Class91.widgets[int_2], -1);
                  }
               }
            }

            if (widget_0.type == 6) {
               if (widget_0.anInt277 != -1 || widget_0.anInt278 != -1) {
                  boolean bool_0 = Class60.method391(widget_0);
                  if (bool_0) {
                     int_2 = widget_0.anInt278;
                  } else {
                     int_2 = widget_0.anInt277;
                  }

                  if (int_2 != -1) {
                     Sequence sequence_0 = ItemLayer.getAnimation(int_2);

                     for (widget_0.anInt280 += Client.anInt625; widget_0.anInt280 > sequence_0.frameLenghts[widget_0.anInt281]; WorldMapData.method305(widget_0)) {
                        widget_0.anInt280 -= sequence_0.frameLenghts[widget_0.anInt281];
                        ++widget_0.anInt281;
                        if (widget_0.anInt281 >= sequence_0.frameIDs.length) {
                           widget_0.anInt281 -= sequence_0.frameStep;
                           if (widget_0.anInt281 < 0 || widget_0.anInt281 >= sequence_0.frameIDs.length) {
                              widget_0.anInt281 = 0;
                           }
                        }
                     }
                  }
               }

               if (widget_0.anInt279 != 0 && !widget_0.hasScript) {
                  int int_3 = widget_0.anInt279 >> 16;
                  int_2 = widget_0.anInt279 << 16 >> 16;
                  int_3 *= Client.anInt625;
                  int_2 *= Client.anInt625;
                  widget_0.rotationX = int_3 + widget_0.rotationX & 0x7FF;
                  widget_0.rotationZ = int_2 + widget_0.rotationZ & 0x7FF;
                  WorldMapData.method305(widget_0);
               }
            }
         }
      }

   }

   static int method315(Widget widget_0, int int_0) {
      if (widget_0.dynamicValues != null && int_0 < widget_0.dynamicValues.length) {
         try {
            int[] ints_0 = widget_0.dynamicValues[int_0];
            int int_1 = 0;
            int int_2 = 0;
            byte byte_0 = 0;

            while (true) {
               int int_3 = ints_0[int_2++];
               int int_4 = 0;
               byte byte_1 = 0;
               if (int_3 == 0) {
                  return int_1;
               }

               if (int_3 == 1) {
                  int_4 = Client.boostedSkillLevels[ints_0[int_2++]];
               }

               if (int_3 == 2) {
                  int_4 = Client.realSkillLevels[ints_0[int_2++]];
               }

               if (int_3 == 3) {
                  int_4 = Client.skillExperiences[ints_0[int_2++]];
               }

               int int_5;
               Widget widget_1;
               int int_6;
               int int_7;
               if (int_3 == 4) {
                  int_5 = ints_0[int_2++] << 16;
                  int_5 += ints_0[int_2++];
                  widget_1 = PendingSpawn.method671(int_5);
                  int_6 = ints_0[int_2++];
                  if (int_6 != -1 && (!CacheableNode_Sub2.getItemDefinition(int_6).isMembers || Client.isMembers)) {
                     for (int_7 = 0; int_7 < widget_1.itemIds.length; int_7++) {
                        if (int_6 + 1 == widget_1.itemIds[int_7]) {
                           int_4 += widget_1.itemQuantities[int_7];
                        }
                     }
                  }
               }

               if (int_3 == 5) {
                  int_4 = Class79.widgetSettings[ints_0[int_2++]];
               }

               if (int_3 == 6) {
                  int_4 = Class85.anIntArray45[Client.realSkillLevels[ints_0[int_2++]] - 1];
               }

               if (int_3 == 7) {
                  int_4 = Class79.widgetSettings[ints_0[int_2++]] * 100 / 46875;
               }

               if (int_3 == 8) {
                  int_4 = Class4.localPlayer.combatLevel;
               }

               if (int_3 == 9) {
                  for (int_5 = 0; int_5 < 25; int_5++) {
                     if (Class85.aBoolArray4[int_5]) {
                        int_4 += Client.realSkillLevels[int_5];
                     }
                  }
               }

               if (int_3 == 10) {
                  int_5 = ints_0[int_2++] << 16;
                  int_5 += ints_0[int_2++];
                  widget_1 = PendingSpawn.method671(int_5);
                  int_6 = ints_0[int_2++];
                  if (int_6 != -1 && (!CacheableNode_Sub2.getItemDefinition(int_6).isMembers || Client.isMembers)) {
                     for (int_7 = 0; int_7 < widget_1.itemIds.length; int_7++) {
                        if (int_6 + 1 == widget_1.itemIds[int_7]) {
                           int_4 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if (int_3 == 11) {
                  int_4 = Client.energy;
               }

               if (int_3 == 12) {
                  int_4 = Client.weight;
               }

               if (int_3 == 13) {
                  int_5 = Class79.widgetSettings[ints_0[int_2++]];
                  int int_8 = ints_0[int_2++];
                  int_4 = (int_5 & 1 << int_8) != 0 ? 1 : 0;
               }

               if (int_3 == 14) {
                  int_5 = ints_0[int_2++];
                  int_4 = Item.method973(int_5);
               }

               if (int_3 == 15) {
                  byte_1 = 1;
               }

               if (int_3 == 16) {
                  byte_1 = 2;
               }

               if (int_3 == 17) {
                  byte_1 = 3;
               }

               if (int_3 == 18) {
                  int_4 = (Class4.localPlayer.x >> 7) + ItemLayer.baseX;
               }

               if (int_3 == 19) {
                  int_4 = (Class4.localPlayer.y >> 7) + ItemLayer.baseY;
               }

               if (int_3 == 20) {
                  int_4 = ints_0[int_2++];
               }

               if (byte_1 == 0) {
                  if (byte_0 == 0) {
                     int_1 += int_4;
                  }

                  if (byte_0 == 1) {
                     int_1 -= int_4;
                  }

                  if (byte_0 == 2 && int_4 != 0) {
                     int_1 /= int_4;
                  }

                  if (byte_0 == 3) {
                     int_1 *= int_4;
                  }

                  byte_0 = 0;
               } else {
                  byte_0 = byte_1;
               }
            }
         } catch (Exception exception_0) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   public static int method316(int int_0, int int_1, int int_2, AClass2 aclass2_0, CollisionData collisiondata_0, boolean bool_0, int[] ints_0, int[] ints_1) {
      int int_4;
      for (int int_3 = 0; int_3 < 128; int_3++) {
         for (int_4 = 0; int_4 < 128; int_4++) {
            Class58.anIntArrayArray10[int_3][int_4] = 0;
            Class58.anIntArrayArray11[int_3][int_4] = 99999999;
         }
      }

      int int_5;
      int int_6;
      byte byte_0;
      byte byte_1;
      int int_7;
      int int_8;
      byte byte_2;
      int int_9;
      int[][] ints_2;
      int int_10;
      int int_11;
      int int_13;
      int int_14;
      boolean bool_1;
      boolean bool_2;
      int int_19;
      int int_20;
      int int_21;
      if (int_2 == 1) {
         int_5 = int_0;
         int_6 = int_1;
         byte_0 = 64;
         byte_1 = 64;
         int_7 = int_0 - byte_0;
         int_8 = int_1 - byte_1;
         Class58.anIntArrayArray10[byte_0][byte_1] = 99;
         Class58.anIntArrayArray11[byte_0][byte_1] = 0;
         byte_2 = 0;
         int_9 = 0;
         Class58.anIntArray37[byte_2] = int_0;
         int_21 = byte_2 + 1;
         Class58.anIntArray38[byte_2] = int_1;
         ints_2 = collisiondata_0.flags;

         while (true) {
            if (int_9 == int_21) {
               Class58.anInt155 = int_5;
               Class58.anInt156 = int_6;
               bool_2 = false;
               break;
            }

            int_5 = Class58.anIntArray37[int_9];
            int_6 = Class58.anIntArray38[int_9];
            int_9 = int_9 + 1 & 0xFFF;
            int_19 = int_5 - int_7;
            int_20 = int_6 - int_8;
            int_10 = int_5 - collisiondata_0.x;
            int_11 = int_6 - collisiondata_0.y;
            if (aclass2_0.method393(1, int_5, int_6, collisiondata_0)) {
               Class58.anInt155 = int_5;
               Class58.anInt156 = int_6;
               bool_2 = true;
               break;
            }

            int_13 = Class58.anIntArrayArray11[int_19][int_20] + 1;
            if (int_19 > 0 && Class58.anIntArrayArray10[int_19 - 1][int_20] == 0 && (ints_2[int_10 - 1][int_11] & 0x1240108) == 0) {
               Class58.anIntArray37[int_21] = int_5 - 1;
               Class58.anIntArray38[int_21] = int_6;
               int_21 = int_21 + 1 & 0xFFF;
               Class58.anIntArrayArray10[int_19 - 1][int_20] = 2;
               Class58.anIntArrayArray11[int_19 - 1][int_20] = int_13;
            }

            if (int_19 < 127 && Class58.anIntArrayArray10[int_19 + 1][int_20] == 0 && (ints_2[int_10 + 1][int_11] & 0x1240180) == 0) {
               Class58.anIntArray37[int_21] = int_5 + 1;
               Class58.anIntArray38[int_21] = int_6;
               int_21 = int_21 + 1 & 0xFFF;
               Class58.anIntArrayArray10[int_19 + 1][int_20] = 8;
               Class58.anIntArrayArray11[int_19 + 1][int_20] = int_13;
            }

            if (int_20 > 0 && Class58.anIntArrayArray10[int_19][int_20 - 1] == 0 && (ints_2[int_10][int_11 - 1] & 0x1240102) == 0) {
               Class58.anIntArray37[int_21] = int_5;
               Class58.anIntArray38[int_21] = int_6 - 1;
               int_21 = int_21 + 1 & 0xFFF;
               Class58.anIntArrayArray10[int_19][int_20 - 1] = 1;
               Class58.anIntArrayArray11[int_19][int_20 - 1] = int_13;
            }

            if (int_20 < 127 && Class58.anIntArrayArray10[int_19][int_20 + 1] == 0 && (ints_2[int_10][int_11 + 1] & 0x1240120) == 0) {
               Class58.anIntArray37[int_21] = int_5;
               Class58.anIntArray38[int_21] = int_6 + 1;
               int_21 = int_21 + 1 & 0xFFF;
               Class58.anIntArrayArray10[int_19][int_20 + 1] = 4;
               Class58.anIntArrayArray11[int_19][int_20 + 1] = int_13;
            }

            if (int_19 > 0 && int_20 > 0 && Class58.anIntArrayArray10[int_19 - 1][int_20 - 1] == 0 && (ints_2[int_10 - 1][int_11 - 1] & 0x124010E) == 0 && (ints_2[int_10 - 1][int_11] & 0x1240108) == 0 && (ints_2[int_10][int_11 - 1] & 0x1240102) == 0) {
               Class58.anIntArray37[int_21] = int_5 - 1;
               Class58.anIntArray38[int_21] = int_6 - 1;
               int_21 = int_21 + 1 & 0xFFF;
               Class58.anIntArrayArray10[int_19 - 1][int_20 - 1] = 3;
               Class58.anIntArrayArray11[int_19 - 1][int_20 - 1] = int_13;
            }

            if (int_19 < 127 && int_20 > 0 && Class58.anIntArrayArray10[int_19 + 1][int_20 - 1] == 0 && (ints_2[int_10 + 1][int_11 - 1] & 0x1240183) == 0 && (ints_2[int_10 + 1][int_11] & 0x1240180) == 0 && (ints_2[int_10][int_11 - 1] & 0x1240102) == 0) {
               Class58.anIntArray37[int_21] = int_5 + 1;
               Class58.anIntArray38[int_21] = int_6 - 1;
               int_21 = int_21 + 1 & 0xFFF;
               Class58.anIntArrayArray10[int_19 + 1][int_20 - 1] = 9;
               Class58.anIntArrayArray11[int_19 + 1][int_20 - 1] = int_13;
            }

            if (int_19 > 0 && int_20 < 127 && Class58.anIntArrayArray10[int_19 - 1][int_20 + 1] == 0 && (ints_2[int_10 - 1][int_11 + 1] & 0x1240138) == 0 && (ints_2[int_10 - 1][int_11] & 0x1240108) == 0 && (ints_2[int_10][int_11 + 1] & 0x1240120) == 0) {
               Class58.anIntArray37[int_21] = int_5 - 1;
               Class58.anIntArray38[int_21] = int_6 + 1;
               int_21 = int_21 + 1 & 0xFFF;
               Class58.anIntArrayArray10[int_19 - 1][int_20 + 1] = 6;
               Class58.anIntArrayArray11[int_19 - 1][int_20 + 1] = int_13;
            }

            if (int_19 < 127 && int_20 < 127 && Class58.anIntArrayArray10[int_19 + 1][int_20 + 1] == 0 && (ints_2[int_10 + 1][int_11 + 1] & 0x12401E0) == 0 && (ints_2[int_10 + 1][int_11] & 0x1240180) == 0 && (ints_2[int_10][int_11 + 1] & 0x1240120) == 0) {
               Class58.anIntArray37[int_21] = int_5 + 1;
               Class58.anIntArray38[int_21] = int_6 + 1;
               int_21 = int_21 + 1 & 0xFFF;
               Class58.anIntArrayArray10[int_19 + 1][int_20 + 1] = 12;
               Class58.anIntArrayArray11[int_19 + 1][int_20 + 1] = int_13;
            }
         }

         bool_1 = bool_2;
      } else if (int_2 == 2) {
         bool_1 = Class44.method271(int_0, int_1, aclass2_0, collisiondata_0);
      } else {
         int_5 = int_0;
         int_6 = int_1;
         byte_0 = 64;
         byte_1 = 64;
         int_7 = int_0 - byte_0;
         int_8 = int_1 - byte_1;
         Class58.anIntArrayArray10[byte_0][byte_1] = 99;
         Class58.anIntArrayArray11[byte_0][byte_1] = 0;
         byte_2 = 0;
         int_9 = 0;
         Class58.anIntArray37[byte_2] = int_0;
         int_21 = byte_2 + 1;
         Class58.anIntArray38[byte_2] = int_1;
         ints_2 = collisiondata_0.flags;

         label641:
         while (true) {
            label639:
            while (true) {
               do {
                  do {
                     do {
                        label616:
                        do {
                           if (int_21 == int_9) {
                              Class58.anInt155 = int_5;
                              Class58.anInt156 = int_6;
                              bool_2 = false;
                              break label641;
                           }

                           int_5 = Class58.anIntArray37[int_9];
                           int_6 = Class58.anIntArray38[int_9];
                           int_9 = int_9 + 1 & 0xFFF;
                           int_19 = int_5 - int_7;
                           int_20 = int_6 - int_8;
                           int_10 = int_5 - collisiondata_0.x;
                           int_11 = int_6 - collisiondata_0.y;
                           if (aclass2_0.method393(int_2, int_5, int_6, collisiondata_0)) {
                              Class58.anInt155 = int_5;
                              Class58.anInt156 = int_6;
                              bool_2 = true;
                              break label641;
                           }

                           int_13 = Class58.anIntArrayArray11[int_19][int_20] + 1;
                           if (int_19 > 0 && Class58.anIntArrayArray10[int_19 - 1][int_20] == 0 && (ints_2[int_10 - 1][int_11] & 0x124010E) == 0 && (ints_2[int_10 - 1][int_11 + int_2 - 1] & 0x1240138) == 0) {
                              int_14 = 1;

                              while (true) {
                                 if (int_14 >= int_2 - 1) {
                                    Class58.anIntArray37[int_21] = int_5 - 1;
                                    Class58.anIntArray38[int_21] = int_6;
                                    int_21 = int_21 + 1 & 0xFFF;
                                    Class58.anIntArrayArray10[int_19 - 1][int_20] = 2;
                                    Class58.anIntArrayArray11[int_19 - 1][int_20] = int_13;
                                    break;
                                 }

                                 if ((ints_2[int_10 - 1][int_11 + int_14] & 0x124013E) != 0) {
                                    break;
                                 }

                                 ++int_14;
                              }
                           }

                           if (int_19 < 128 - int_2 && Class58.anIntArrayArray10[int_19 + 1][int_20] == 0 && (ints_2[int_10 + int_2][int_11] & 0x1240183) == 0 && (ints_2[int_10 + int_2][int_11 + int_2 - 1] & 0x12401E0) == 0) {
                              int_14 = 1;

                              while (true) {
                                 if (int_14 >= int_2 - 1) {
                                    Class58.anIntArray37[int_21] = int_5 + 1;
                                    Class58.anIntArray38[int_21] = int_6;
                                    int_21 = int_21 + 1 & 0xFFF;
                                    Class58.anIntArrayArray10[int_19 + 1][int_20] = 8;
                                    Class58.anIntArrayArray11[int_19 + 1][int_20] = int_13;
                                    break;
                                 }

                                 if ((ints_2[int_10 + int_2][int_11 + int_14] & 0x12401E3) != 0) {
                                    break;
                                 }

                                 ++int_14;
                              }
                           }

                           if (int_20 > 0 && Class58.anIntArrayArray10[int_19][int_20 - 1] == 0 && (ints_2[int_10][int_11 - 1] & 0x124010E) == 0 && (ints_2[int_10 + int_2 - 1][int_11 - 1] & 0x1240183) == 0) {
                              int_14 = 1;

                              while (true) {
                                 if (int_14 >= int_2 - 1) {
                                    Class58.anIntArray37[int_21] = int_5;
                                    Class58.anIntArray38[int_21] = int_6 - 1;
                                    int_21 = int_21 + 1 & 0xFFF;
                                    Class58.anIntArrayArray10[int_19][int_20 - 1] = 1;
                                    Class58.anIntArrayArray11[int_19][int_20 - 1] = int_13;
                                    break;
                                 }

                                 if ((ints_2[int_14 + int_10][int_11 - 1] & 0x124018F) != 0) {
                                    break;
                                 }

                                 ++int_14;
                              }
                           }

                           if (int_20 < 128 - int_2 && Class58.anIntArrayArray10[int_19][int_20 + 1] == 0 && (ints_2[int_10][int_11 + int_2] & 0x1240138) == 0 && (ints_2[int_10 + int_2 - 1][int_11 + int_2] & 0x12401E0) == 0) {
                              int_14 = 1;

                              while (true) {
                                 if (int_14 >= int_2 - 1) {
                                    Class58.anIntArray37[int_21] = int_5;
                                    Class58.anIntArray38[int_21] = int_6 + 1;
                                    int_21 = int_21 + 1 & 0xFFF;
                                    Class58.anIntArrayArray10[int_19][int_20 + 1] = 4;
                                    Class58.anIntArrayArray11[int_19][int_20 + 1] = int_13;
                                    break;
                                 }

                                 if ((ints_2[int_14 + int_10][int_11 + int_2] & 0x12401F8) != 0) {
                                    break;
                                 }

                                 ++int_14;
                              }
                           }

                           if (int_19 > 0 && int_20 > 0 && Class58.anIntArrayArray10[int_19 - 1][int_20 - 1] == 0 && (ints_2[int_10 - 1][int_11 - 1] & 0x124010E) == 0) {
                              int_14 = 1;

                              while (true) {
                                 if (int_14 >= int_2) {
                                    Class58.anIntArray37[int_21] = int_5 - 1;
                                    Class58.anIntArray38[int_21] = int_6 - 1;
                                    int_21 = int_21 + 1 & 0xFFF;
                                    Class58.anIntArrayArray10[int_19 - 1][int_20 - 1] = 3;
                                    Class58.anIntArrayArray11[int_19 - 1][int_20 - 1] = int_13;
                                    break;
                                 }

                                 if ((ints_2[int_10 - 1][int_14 + (int_11 - 1)] & 0x124013E) != 0 || (ints_2[int_14 + (int_10 - 1)][int_11 - 1] & 0x124018F) != 0) {
                                    break;
                                 }

                                 ++int_14;
                              }
                           }

                           if (int_19 < 128 - int_2 && int_20 > 0 && Class58.anIntArrayArray10[int_19 + 1][int_20 - 1] == 0 && (ints_2[int_10 + int_2][int_11 - 1] & 0x1240183) == 0) {
                              int_14 = 1;

                              while (true) {
                                 if (int_14 >= int_2) {
                                    Class58.anIntArray37[int_21] = int_5 + 1;
                                    Class58.anIntArray38[int_21] = int_6 - 1;
                                    int_21 = int_21 + 1 & 0xFFF;
                                    Class58.anIntArrayArray10[int_19 + 1][int_20 - 1] = 9;
                                    Class58.anIntArrayArray11[int_19 + 1][int_20 - 1] = int_13;
                                    break;
                                 }

                                 if ((ints_2[int_10 + int_2][int_14 + (int_11 - 1)] & 0x12401E3) != 0 || (ints_2[int_10 + int_14][int_11 - 1] & 0x124018F) != 0) {
                                    break;
                                 }

                                 ++int_14;
                              }
                           }

                           if (int_19 > 0 && int_20 < 128 - int_2 && Class58.anIntArrayArray10[int_19 - 1][int_20 + 1] == 0 && (ints_2[int_10 - 1][int_11 + int_2] & 0x1240138) == 0) {
                              for (int_14 = 1; int_14 < int_2; int_14++) {
                                 if ((ints_2[int_10 - 1][int_11 + int_14] & 0x124013E) != 0 || (ints_2[int_14 + (int_10 - 1)][int_11 + int_2] & 0x12401F8) != 0) {
                                    continue label616;
                                 }
                              }

                              Class58.anIntArray37[int_21] = int_5 - 1;
                              Class58.anIntArray38[int_21] = int_6 + 1;
                              int_21 = int_21 + 1 & 0xFFF;
                              Class58.anIntArrayArray10[int_19 - 1][int_20 + 1] = 6;
                              Class58.anIntArrayArray11[int_19 - 1][int_20 + 1] = int_13;
                           }
                        } while (int_19 >= 128 - int_2);
                     } while (int_20 >= 128 - int_2);
                  } while (Class58.anIntArrayArray10[int_19 + 1][int_20 + 1] != 0);
               } while ((ints_2[int_10 + int_2][int_11 + int_2] & 0x12401E0) != 0);

               for (int_14 = 1; int_14 < int_2; int_14++) {
                  if ((ints_2[int_10 + int_14][int_11 + int_2] & 0x12401F8) != 0 || (ints_2[int_10 + int_2][int_14 + int_11] & 0x12401E3) != 0) {
                     continue label639;
                  }
               }

               Class58.anIntArray37[int_21] = int_5 + 1;
               Class58.anIntArray38[int_21] = int_6 + 1;
               int_21 = int_21 + 1 & 0xFFF;
               Class58.anIntArrayArray10[int_19 + 1][int_20 + 1] = 12;
               Class58.anIntArrayArray11[int_19 + 1][int_20 + 1] = int_13;
            }
         }

         bool_1 = bool_2;
      }

      int_4 = int_0 - 64;
      int_5 = int_1 - 64;
      int_6 = Class58.anInt155;
      int_19 = Class58.anInt156;
      if (!bool_1) {
         int_20 = Integer.MAX_VALUE;
         int_7 = Integer.MAX_VALUE;
         byte byte_3 = 10;
         int_21 = aclass2_0.anInt160;
         int_9 = aclass2_0.anInt161;
         int int_12 = aclass2_0.anInt162;
         int_10 = aclass2_0.anInt163;

         for (int_11 = int_21 - byte_3; int_11 <= byte_3 + int_21; int_11++) {
            for (int_13 = int_9 - byte_3; int_13 <= byte_3 + int_9; int_13++) {
               int_14 = int_11 - int_4;
               int int_15 = int_13 - int_5;
               if (int_14 >= 0 && int_15 >= 0 && int_14 < 128 && int_15 < 128 && Class58.anIntArrayArray11[int_14][int_15] < 100) {
                  int int_16 = 0;
                  if (int_11 < int_21) {
                     int_16 = int_21 - int_11;
                  } else if (int_11 > int_12 + int_21 - 1) {
                     int_16 = int_11 - (int_12 + int_21 - 1);
                  }

                  int int_17 = 0;
                  if (int_13 < int_9) {
                     int_17 = int_9 - int_13;
                  } else if (int_13 > int_9 + int_10 - 1) {
                     int_17 = int_13 - (int_10 + int_9 - 1);
                  }

                  int int_18 = int_17 * int_17 + int_16 * int_16;
                  if (int_18 < int_20 || int_20 == int_18 && Class58.anIntArrayArray11[int_14][int_15] < int_7) {
                     int_20 = int_18;
                     int_7 = Class58.anIntArrayArray11[int_14][int_15];
                     int_6 = int_11;
                     int_19 = int_13;
                  }
               }
            }
         }

         if (int_20 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if (int_0 == int_6 && int_19 == int_1) {
         return 0;
      } else {
         byte_1 = 0;
         Class58.anIntArray37[byte_1] = int_6;
         int_20 = byte_1 + 1;
         Class58.anIntArray38[byte_1] = int_19;

         for (int_7 = int_8 = Class58.anIntArrayArray10[int_6 - int_4][int_19 - int_5]; int_0 != int_6 || int_19 != int_1; int_7 = Class58.anIntArrayArray10[int_6 - int_4][int_19 - int_5]) {
            if (int_7 != int_8) {
               int_8 = int_7;
               Class58.anIntArray37[int_20] = int_6;
               Class58.anIntArray38[int_20++] = int_19;
            }

            if ((int_7 & 0x2) != 0) {
               ++int_6;
            } else if ((int_7 & 0x8) != 0) {
               --int_6;
            }

            if ((int_7 & 0x1) != 0) {
               ++int_19;
            } else if ((int_7 & 0x4) != 0) {
               --int_19;
            }
         }

         int_21 = 0;

         while (int_20-- > 0) {
            ints_0[int_21] = Class58.anIntArray37[int_20];
            ints_1[int_21++] = Class58.anIntArray38[int_20];
            if (int_21 >= ints_0.length) {
               break;
            }
         }

         return int_21;
      }
   }

}
