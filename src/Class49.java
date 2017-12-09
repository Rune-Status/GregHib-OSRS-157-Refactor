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
                  if (int_6 != -1 && (!ItemDefinition.getDefinition(int_6).isMembers || Client.isMembers)) {
                     for (int_7 = 0; int_7 < widget_1.itemIds.length; int_7++) {
                        if (int_6 + 1 == widget_1.itemIds[int_7]) {
                           int_4 += widget_1.itemQuantities[int_7];
                        }
                     }
                  }
               }

               if (int_3 == 5) {
                  int_4 = Settings.widgetSettings[ints_0[int_2++]];
               }

               if (int_3 == 6) {
                  int_4 = Class85.anIntArray45[Client.realSkillLevels[ints_0[int_2++]] - 1];
               }

               if (int_3 == 7) {
                  int_4 = Settings.widgetSettings[ints_0[int_2++]] * 100 / 46875;
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
                  if (int_6 != -1 && (!ItemDefinition.getDefinition(int_6).isMembers || Client.isMembers)) {
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
                  int_5 = Settings.widgetSettings[ints_0[int_2++]];
                  int int_8 = ints_0[int_2++];
                  int_4 = (int_5 & 1 << int_8) != 0 ? 1 : 0;
               }

               if (int_3 == 14) {
                  int_5 = ints_0[int_2++];
                  int_4 = Varbit.getVarbit(int_5);
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

   public static int findPath(int sourceX, int sourceY, int size, RouteStrategy strategy, CollisionData collision, int[] tileQueueX, int[] tileQueueY) {
      for (int x = 0; x < 128; x++) {
         for (int y = 0; y < 128; y++) {
            Class58.directions[x][y] = 0;
            Class58.distances[x][y] = 99999999;
         }
      }

      boolean alternate;
      if (size == 1) {
         int currentX = sourceX;
         int currentY = sourceY;
         int graphSizeX = 64;
         int graphSizeY = 64;
         int graphBaseX = sourceX - graphSizeX;
         int graphBaseY = sourceY - graphSizeY;
         Class58.directions[graphSizeX][graphSizeY] = 99;
         Class58.distances[graphSizeX][graphSizeY] = 0;
         byte byte_2 = 0;
         int read = 0;
         Class58.tileQueueX[byte_2] = sourceX;
         int write = byte_2 + 1;
         Class58.tileQueueY[byte_2] = sourceY;
         int[][] mask = collision.flags;
         int maskX;
         int maskY;
         boolean found;
         int currentGraphX;
         int currentGraphY;

         while (true) {
            if (read == write) {
               Class58.exitX = currentX;
               Class58.exitY = currentY;
               found = false;
               break;
            }

            currentX = Class58.tileQueueX[read];
            currentY = Class58.tileQueueY[read];
            read = read + 1 & 0xFFF;
            currentGraphX = currentX - graphBaseX;
            currentGraphY = currentY - graphBaseY;
            maskX = currentX - collision.x;
            maskY = currentY - collision.y;
            if (strategy.canExit(1, currentX, currentY, collision)) {
               Class58.exitX = currentX;
               Class58.exitY = currentY;
               found = true;
               break;
            }

            int nextDistance = Class58.distances[currentGraphX][currentGraphY] + 1;
            if (currentGraphX > 0 && Class58.directions[currentGraphX - 1][currentGraphY] == 0 && (mask[maskX - 1][maskY] & 0x1240108) == 0) {
               Class58.tileQueueX[write] = currentX - 1;
               Class58.tileQueueY[write] = currentY;
               write = write + 1 & 0xFFF;
               Class58.directions[currentGraphX - 1][currentGraphY] = 2;
               Class58.distances[currentGraphX - 1][currentGraphY] = nextDistance;
            }

            if (currentGraphX < 127 && Class58.directions[currentGraphX + 1][currentGraphY] == 0 && (mask[maskX + 1][maskY] & 0x1240180) == 0) {
               Class58.tileQueueX[write] = currentX + 1;
               Class58.tileQueueY[write] = currentY;
               write = write + 1 & 0xFFF;
               Class58.directions[currentGraphX + 1][currentGraphY] = 8;
               Class58.distances[currentGraphX + 1][currentGraphY] = nextDistance;
            }

            if (currentGraphY > 0 && Class58.directions[currentGraphX][currentGraphY - 1] == 0 && (mask[maskX][maskY - 1] & 0x1240102) == 0) {
               Class58.tileQueueX[write] = currentX;
               Class58.tileQueueY[write] = currentY - 1;
               write = write + 1 & 0xFFF;
               Class58.directions[currentGraphX][currentGraphY - 1] = 1;
               Class58.distances[currentGraphX][currentGraphY - 1] = nextDistance;
            }

            if (currentGraphY < 127 && Class58.directions[currentGraphX][currentGraphY + 1] == 0 && (mask[maskX][maskY + 1] & 0x1240120) == 0) {
               Class58.tileQueueX[write] = currentX;
               Class58.tileQueueY[write] = currentY + 1;
               write = write + 1 & 0xFFF;
               Class58.directions[currentGraphX][currentGraphY + 1] = 4;
               Class58.distances[currentGraphX][currentGraphY + 1] = nextDistance;
            }

            if (currentGraphX > 0 && currentGraphY > 0 && Class58.directions[currentGraphX - 1][currentGraphY - 1] == 0 && (mask[maskX - 1][maskY - 1] & 0x124010E) == 0 && (mask[maskX - 1][maskY] & 0x1240108) == 0 && (mask[maskX][maskY - 1] & 0x1240102) == 0) {
               Class58.tileQueueX[write] = currentX - 1;
               Class58.tileQueueY[write] = currentY - 1;
               write = write + 1 & 0xFFF;
               Class58.directions[currentGraphX - 1][currentGraphY - 1] = 3;
               Class58.distances[currentGraphX - 1][currentGraphY - 1] = nextDistance;
            }

            if (currentGraphX < 127 && currentGraphY > 0 && Class58.directions[currentGraphX + 1][currentGraphY - 1] == 0 && (mask[maskX + 1][maskY - 1] & 0x1240183) == 0 && (mask[maskX + 1][maskY] & 0x1240180) == 0 && (mask[maskX][maskY - 1] & 0x1240102) == 0) {
               Class58.tileQueueX[write] = currentX + 1;
               Class58.tileQueueY[write] = currentY - 1;
               write = write + 1 & 0xFFF;
               Class58.directions[currentGraphX + 1][currentGraphY - 1] = 9;
               Class58.distances[currentGraphX + 1][currentGraphY - 1] = nextDistance;
            }

            if (currentGraphX > 0 && currentGraphY < 127 && Class58.directions[currentGraphX - 1][currentGraphY + 1] == 0 && (mask[maskX - 1][maskY + 1] & 0x1240138) == 0 && (mask[maskX - 1][maskY] & 0x1240108) == 0 && (mask[maskX][maskY + 1] & 0x1240120) == 0) {
               Class58.tileQueueX[write] = currentX - 1;
               Class58.tileQueueY[write] = currentY + 1;
               write = write + 1 & 0xFFF;
               Class58.directions[currentGraphX - 1][currentGraphY + 1] = 6;
               Class58.distances[currentGraphX - 1][currentGraphY + 1] = nextDistance;
            }

            if (currentGraphX < 127 && currentGraphY < 127 && Class58.directions[currentGraphX + 1][currentGraphY + 1] == 0 && (mask[maskX + 1][maskY + 1] & 0x12401E0) == 0 && (mask[maskX + 1][maskY] & 0x1240180) == 0 && (mask[maskX][maskY + 1] & 0x1240120) == 0) {
               Class58.tileQueueX[write] = currentX + 1;
               Class58.tileQueueY[write] = currentY + 1;
               write = write + 1 & 0xFFF;
               Class58.directions[currentGraphX + 1][currentGraphY + 1] = 12;
               Class58.distances[currentGraphX + 1][currentGraphY + 1] = nextDistance;
            }
         }

         alternate = found;
      } else if (size == 2) {
         alternate = Class44.findAlternateRoute(sourceX, sourceY, strategy, collision);
      } else {
         int currentX = sourceX;
         int currentY = sourceY;
         int graphSizeX = 64;
         int graphSizeY = 64;
         int graphBaseX = sourceX - graphSizeX;
         int graphBaseY = sourceY - graphSizeY;
         Class58.directions[graphSizeX][graphSizeY] = 99;
         Class58.distances[graphSizeX][graphSizeY] = 0;
         byte byte_2 = 0;
         int read = 0;
         Class58.tileQueueX[byte_2] = sourceX;
         int write = byte_2 + 1;
         Class58.tileQueueY[byte_2] = sourceY;
         int[][] mask = collision.flags;
         int nextDistance;
         int maskX;
         int maskY;
         int index;
         boolean found;
         int currentGraphX;
         int currentGraphY;

         label641:
         while (true) {
            label639:
            while (true) {
               do {
                  do {
                     do {
                        loopX:
                        do {
                           if (write == read) {
                              Class58.exitX = currentX;
                              Class58.exitY = currentY;
                              found = false;
                              break label641;
                           }

                           currentX = Class58.tileQueueX[read];
                           currentY = Class58.tileQueueY[read];
                           read = read + 1 & 0xFFF;
                           currentGraphX = currentX - graphBaseX;
                           currentGraphY = currentY - graphBaseY;
                           maskX = currentX - collision.x;
                           maskY = currentY - collision.y;
                           if (strategy.canExit(size, currentX, currentY, collision)) {
                              Class58.exitX = currentX;
                              Class58.exitY = currentY;
                              found = true;
                              break label641;
                           }

                           nextDistance = Class58.distances[currentGraphX][currentGraphY] + 1;
                           if (currentGraphX > 0 && Class58.directions[currentGraphX - 1][currentGraphY] == 0 && (mask[maskX - 1][maskY] & 0x124010E) == 0 && (mask[maskX - 1][maskY + size - 1] & 0x1240138) == 0) {
                              int y = 1;

                              while (true) {
                                 if (y >= size - 1) {
                                    Class58.tileQueueX[write] = currentX - 1;
                                    Class58.tileQueueY[write] = currentY;
                                    write = write + 1 & 0xFFF;
                                    Class58.directions[currentGraphX - 1][currentGraphY] = 2;
                                    Class58.distances[currentGraphX - 1][currentGraphY] = nextDistance;
                                    break;
                                 }

                                 if ((mask[maskX - 1][maskY + y] & 0x124013E) != 0) {
                                    break;
                                 }

                                 ++y;
                              }
                           }

                           if (currentGraphX < 128 - size && Class58.directions[currentGraphX + 1][currentGraphY] == 0 && (mask[maskX + size][maskY] & 0x1240183) == 0 && (mask[maskX + size][maskY + size - 1] & 0x12401E0) == 0) {
                              int y = 1;

                              while (true) {
                                 if (y >= size - 1) {
                                    Class58.tileQueueX[write] = currentX + 1;
                                    Class58.tileQueueY[write] = currentY;
                                    write = write + 1 & 0xFFF;
                                    Class58.directions[currentGraphX + 1][currentGraphY] = 8;
                                    Class58.distances[currentGraphX + 1][currentGraphY] = nextDistance;
                                    break;
                                 }

                                 if ((mask[maskX + size][maskY + y] & 0x12401E3) != 0) {
                                    break;
                                 }

                                 ++y;
                              }
                           }

                           if (currentGraphY > 0 && Class58.directions[currentGraphX][currentGraphY - 1] == 0 && (mask[maskX][maskY - 1] & 0x124010E) == 0 && (mask[maskX + size - 1][maskY - 1] & 0x1240183) == 0) {
                              int x = 1;

                              while (true) {
                                 if (x >= size - 1) {
                                    Class58.tileQueueX[write] = currentX;
                                    Class58.tileQueueY[write] = currentY - 1;
                                    write = write + 1 & 0xFFF;
                                    Class58.directions[currentGraphX][currentGraphY - 1] = 1;
                                    Class58.distances[currentGraphX][currentGraphY - 1] = nextDistance;
                                    break;
                                 }

                                 if ((mask[x + maskX][maskY - 1] & 0x124018F) != 0) {
                                    break;
                                 }

                                 ++x;
                              }
                           }

                           if (currentGraphY < 128 - size && Class58.directions[currentGraphX][currentGraphY + 1] == 0 && (mask[maskX][maskY + size] & 0x1240138) == 0 && (mask[maskX + size - 1][maskY + size] & 0x12401E0) == 0) {
                              int x = 1;

                              while (true) {
                                 if (x >= size - 1) {
                                    Class58.tileQueueX[write] = currentX;
                                    Class58.tileQueueY[write] = currentY + 1;
                                    write = write + 1 & 0xFFF;
                                    Class58.directions[currentGraphX][currentGraphY + 1] = 4;
                                    Class58.distances[currentGraphX][currentGraphY + 1] = nextDistance;
                                    break;
                                 }

                                 if ((mask[x + maskX][maskY + size] & 0x12401F8) != 0) {
                                    break;
                                 }

                                 ++x;
                              }
                           }

                           if (currentGraphX > 0 && currentGraphY > 0 && Class58.directions[currentGraphX - 1][currentGraphY - 1] == 0 && (mask[maskX - 1][maskY - 1] & 0x124010E) == 0) {
                              int y = 1;

                              while (true) {
                                 if (y >= size) {
                                    Class58.tileQueueX[write] = currentX - 1;
                                    Class58.tileQueueY[write] = currentY - 1;
                                    write = write + 1 & 0xFFF;
                                    Class58.directions[currentGraphX - 1][currentGraphY - 1] = 3;
                                    Class58.distances[currentGraphX - 1][currentGraphY - 1] = nextDistance;
                                    break;
                                 }

                                 if ((mask[maskX - 1][y + (maskY - 1)] & 0x124013E) != 0 || (mask[y + (maskX - 1)][maskY - 1] & 0x124018F) != 0) {
                                    break;
                                 }

                                 ++y;
                              }
                           }

                           if (currentGraphX < 128 - size && currentGraphY > 0 && Class58.directions[currentGraphX + 1][currentGraphY - 1] == 0 && (mask[maskX + size][maskY - 1] & 0x1240183) == 0) {
                              int y = 1;

                              while (true) {
                                 if (y >= size) {
                                    Class58.tileQueueX[write] = currentX + 1;
                                    Class58.tileQueueY[write] = currentY - 1;
                                    write = write + 1 & 0xFFF;
                                    Class58.directions[currentGraphX + 1][currentGraphY - 1] = 9;
                                    Class58.distances[currentGraphX + 1][currentGraphY - 1] = nextDistance;
                                    break;
                                 }

                                 if ((mask[maskX + size][y + (maskY - 1)] & 0x12401E3) != 0 || (mask[maskX + y][maskY - 1] & 0x124018F) != 0) {
                                    break;
                                 }

                                 ++y;
                              }
                           }

                           if (currentGraphX > 0 && currentGraphY < 128 - size && Class58.directions[currentGraphX - 1][currentGraphY + 1] == 0 && (mask[maskX - 1][maskY + size] & 0x1240138) == 0) {
                              for (index = 1; index < size; index++) {
                                 if ((mask[maskX - 1][maskY + index] & 0x124013E) != 0 || (mask[index + (maskX - 1)][maskY + size] & 0x12401F8) != 0) {
                                    continue loopX;
                                 }
                              }

                              Class58.tileQueueX[write] = currentX - 1;
                              Class58.tileQueueY[write] = currentY + 1;
                              write = write + 1 & 0xFFF;
                              Class58.directions[currentGraphX - 1][currentGraphY + 1] = 6;
                              Class58.distances[currentGraphX - 1][currentGraphY + 1] = nextDistance;
                           }
                        } while (currentGraphX >= 128 - size);
                     } while (currentGraphY >= 128 - size);
                  } while (Class58.directions[currentGraphX + 1][currentGraphY + 1] != 0);
               } while ((mask[maskX + size][maskY + size] & 0x12401E0) != 0);

               for (index = 1; index < size; index++) {
                  if ((mask[maskX + index][maskY + size] & 0x12401F8) != 0 || (mask[maskX + size][index + maskY] & 0x12401E3) != 0) {
                     continue label639;
                  }
               }

               Class58.tileQueueX[write] = currentX + 1;
               Class58.tileQueueY[write] = currentY + 1;
               write = write + 1 & 0xFFF;
               Class58.directions[currentGraphX + 1][currentGraphY + 1] = 12;
               Class58.distances[currentGraphX + 1][currentGraphY + 1] = nextDistance;
            }
         }

         alternate = found;
      }

      int targetX = sourceX - 64;
      int targetY = sourceY - 64;
      int exitX = Class58.exitX;
      int exitY = Class58.exitY;
      int currentGraphY;
      if (!alternate) {
         int lowestCost = Integer.MAX_VALUE;
         int lowestDistance = Integer.MAX_VALUE;
         byte routeRange = 10;
         int approxDestX = strategy.approxDestinationX;
         int approxDestY = strategy.approxDestinationY;
         int approxDestSizeX = strategy.approxDestinationSizeX;
         int approxDestSizeY = strategy.approxDestinationSizeY;
         int checkX;
         int graphX;

         for (checkX = approxDestX - routeRange; checkX <= routeRange + approxDestX; checkX++) {
            for (int checkY = approxDestY - routeRange; checkY <= routeRange + approxDestY; checkY++) {
               graphX = checkX - targetX;
               int graphY = checkY - targetY;
               if (graphX >= 0 && graphY >= 0 && graphX < 128 && graphY < 128 && Class58.distances[graphX][graphY] < 100) {
                  int deltaY = 0;
                  if (checkX < approxDestX) {
                     deltaY = approxDestX - checkX;
                  } else if (checkX > approxDestSizeX + approxDestX - 1) {
                     deltaY = checkX - (approxDestSizeX + approxDestX - 1);
                  }

                  int deltaX = 0;
                  if (checkY < approxDestY) {
                     deltaX = approxDestY - checkY;
                  } else if (checkY > approxDestY + approxDestSizeY - 1) {
                     deltaX = checkY - (approxDestSizeY + approxDestY - 1);
                  }

                  int cost = deltaX * deltaX + deltaY * deltaY;
                  if (cost < lowestCost || lowestCost == cost && Class58.distances[graphX][graphY] < lowestDistance) {
                     lowestCost = cost;
                     lowestDistance = Class58.distances[graphX][graphY];
                     exitX = checkX;
                     exitY = checkY;
                  }
               }
            }
         }

         if (lowestCost == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if (sourceX == exitX && exitY == sourceY) {
         return 0;
      } else {
         int graphSizeY = 0;
         Class58.tileQueueX[graphSizeY] = exitX;
         currentGraphY = graphSizeY + 1;
         Class58.tileQueueY[graphSizeY] = exitY;
         int direction;
         int lastWritten;

         for (direction = lastWritten = Class58.directions[exitX - targetX][exitY - targetY]; sourceX != exitX || exitY != sourceY; direction = Class58.directions[exitX - targetX][exitY - targetY]) {
            if (direction != lastWritten) {
               lastWritten = direction;
               Class58.tileQueueX[currentGraphY] = exitX;
               Class58.tileQueueY[currentGraphY++] = exitY;
            }

            if ((direction & 0x2) != 0) {
               ++exitX;
            } else if ((direction & 0x8) != 0) {
               --exitX;
            }

            if ((direction & 0x1) != 0) {
               ++exitY;
            } else if ((direction & 0x4) != 0) {
               --exitY;
            }
         }

         int steps = 0;

         while (currentGraphY-- > 0) {
            tileQueueX[steps] = Class58.tileQueueX[currentGraphY];
            tileQueueY[steps++] = Class58.tileQueueY[currentGraphY];
            if (steps >= tileQueueX.length) {
               break;
            }
         }

         return steps;
      }
   }

}
