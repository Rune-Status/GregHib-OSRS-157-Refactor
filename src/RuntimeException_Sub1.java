import java.applet.Applet;

public class RuntimeException_Sub1 extends RuntimeException {

   public static int revision;
   public static Applet anApplet2;
   public static String aString32;
   String aString33;
   Throwable aThrowable1;

   public static InvType method955(int int_0) {
      InvType invtype_0 = (InvType) InvType.inventoryCache.get((long)int_0);
      if (invtype_0 != null) {
         return invtype_0;
      } else {
         byte[] bytes_0 = InvType.anIndexDataBase16.getConfigData(5, int_0);
         invtype_0 = new InvType();
         if (bytes_0 != null) {
            invtype_0.decode(new Buffer(bytes_0));
         }

         InvType.inventoryCache.put(invtype_0, (long)int_0);
         return invtype_0;
      }
   }

   static void addObject(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, Region region_0, CollisionData collisiondata_0) {
      if (!Client.lowMemory || (Class19.tileSettings[0][int_1][int_2] & 0x2) != 0 || (Class19.tileSettings[int_0][int_1][int_2] & 0x10) == 0) {
         if (int_0 < Class19.anInt72) {
            Class19.anInt72 = int_0;
         }

         ObjectComposition objectcomposition_0 = Class28.getObjectDefinition(int_3);
         int int_6;
         int int_7;
         if (int_4 != 1 && int_4 != 3) {
            int_6 = objectcomposition_0.sizeX;
            int_7 = objectcomposition_0.sizeY;
         } else {
            int_6 = objectcomposition_0.sizeY;
            int_7 = objectcomposition_0.sizeX;
         }

         int int_8;
         int int_9;
         if (int_6 + int_1 <= 104) {
            int_8 = (int_6 >> 1) + int_1;
            int_9 = (int_6 + 1 >> 1) + int_1;
         } else {
            int_8 = int_1;
            int_9 = int_1 + 1;
         }

         int int_10;
         int int_11;
         if (int_7 + int_2 <= 104) {
            int_10 = (int_7 >> 1) + int_2;
            int_11 = int_2 + (int_7 + 1 >> 1);
         } else {
            int_10 = int_2;
            int_11 = int_2 + 1;
         }

         int[][] ints_0 = Class19.tileHeights[int_0];
         int int_12 = ints_0[int_9][int_11] + ints_0[int_8][int_11] + ints_0[int_8][int_10] + ints_0[int_9][int_10] >> 2;
         int int_13 = (int_1 << 7) + (int_6 << 6);
         int int_14 = (int_2 << 7) + (int_7 << 6);
         int int_15 = (int_3 << 14) + (int_2 << 7) + int_1 + 1073741824;
         if (objectcomposition_0.anInt461 == 0) {
            int_15 -= Integer.MIN_VALUE;
         }

         int int_16 = int_5 + (int_4 << 6);
         if (objectcomposition_0.anInt462 == 1) {
            int_16 += 256;
         }

         if (objectcomposition_0.method828()) {
            CacheableNode_Sub3.method880(int_0, int_1, int_2, objectcomposition_0, int_4);
         }

         Object object_0;
         if (int_5 == 22) {
            if (!Client.lowMemory || objectcomposition_0.anInt461 != 0 || objectcomposition_0.interactType == 1 || objectcomposition_0.aBool61) {
               if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                  object_0 = objectcomposition_0.getModel(22, int_4, ints_0, int_13, int_12, int_14);
               } else {
                  object_0 = new DynamicObject(int_3, 22, int_4, int_0, int_1, int_2, objectcomposition_0.animationId, true, (Renderable) null);
               }

               region_0.groundObjectSpawned(int_0, int_1, int_2, int_12, (Renderable) object_0, int_15, int_16);
               if (objectcomposition_0.interactType == 1 && collisiondata_0 != null) {
                  collisiondata_0.block(int_1, int_2);
               }

            }
         } else {
            int int_17;
            if (int_5 != 10 && int_5 != 11) {
               if (int_5 >= 12) {
                  if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                     object_0 = objectcomposition_0.getModel(int_5, int_4, ints_0, int_13, int_12, int_14);
                  } else {
                     object_0 = new DynamicObject(int_3, int_5, int_4, int_0, int_1, int_2, objectcomposition_0.animationId, true, (Renderable) null);
                  }

                  region_0.method379(int_0, int_1, int_2, int_12, 1, 1, (Renderable) object_0, 0, int_15, int_16);
                  if (int_5 >= 12 && int_5 <= 17 && int_5 != 13 && int_0 > 0) {
                     ItemLayer.anIntArrayArrayArray1[int_0][int_1][int_2] |= 0x924;
                  }

                  if (objectcomposition_0.interactType != 0 && collisiondata_0 != null) {
                     collisiondata_0.addObject(int_1, int_2, int_6, int_7, objectcomposition_0.aBool60);
                  }

               } else if (int_5 == 0) {
                  if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                     object_0 = objectcomposition_0.getModel(0, int_4, ints_0, int_13, int_12, int_14);
                  } else {
                     object_0 = new DynamicObject(int_3, 0, int_4, int_0, int_1, int_2, objectcomposition_0.animationId, true, (Renderable) null);
                  }

                  region_0.addBoundary(int_0, int_1, int_2, int_12, (Renderable) object_0, (Renderable) null, Class19.anIntArray7[int_4], 0, int_15, int_16);
                  if (int_4 == 0) {
                     if (objectcomposition_0.clipped) {
                        Class19.aByteArrayArrayArray7[int_0][int_1][int_2] = 50;
                        Class19.aByteArrayArrayArray7[int_0][int_1][int_2 + 1] = 50;
                     }

                     if (objectcomposition_0.modelClipped) {
                        ItemLayer.anIntArrayArrayArray1[int_0][int_1][int_2] |= 0x249;
                     }
                  } else if (int_4 == 1) {
                     if (objectcomposition_0.clipped) {
                        Class19.aByteArrayArrayArray7[int_0][int_1][int_2 + 1] = 50;
                        Class19.aByteArrayArrayArray7[int_0][int_1 + 1][int_2 + 1] = 50;
                     }

                     if (objectcomposition_0.modelClipped) {
                        ItemLayer.anIntArrayArrayArray1[int_0][int_1][1 + int_2] |= 0x492;
                     }
                  } else if (int_4 == 2) {
                     if (objectcomposition_0.clipped) {
                        Class19.aByteArrayArrayArray7[int_0][int_1 + 1][int_2] = 50;
                        Class19.aByteArrayArrayArray7[int_0][int_1 + 1][int_2 + 1] = 50;
                     }

                     if (objectcomposition_0.modelClipped) {
                        ItemLayer.anIntArrayArrayArray1[int_0][int_1 + 1][int_2] |= 0x249;
                     }
                  } else if (int_4 == 3) {
                     if (objectcomposition_0.clipped) {
                        Class19.aByteArrayArrayArray7[int_0][int_1][int_2] = 50;
                        Class19.aByteArrayArrayArray7[int_0][int_1 + 1][int_2] = 50;
                     }

                     if (objectcomposition_0.modelClipped) {
                        ItemLayer.anIntArrayArrayArray1[int_0][int_1][int_2] |= 0x492;
                     }
                  }

                  if (objectcomposition_0.interactType != 0 && collisiondata_0 != null) {
                     collisiondata_0.addWall(int_1, int_2, int_5, int_4, objectcomposition_0.aBool60);
                  }

                  if (objectcomposition_0.anInt466 != 16) {
                     region_0.method380(int_0, int_1, int_2, objectcomposition_0.anInt466);
                  }

               } else if (int_5 == 1) {
                  if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                     object_0 = objectcomposition_0.getModel(1, int_4, ints_0, int_13, int_12, int_14);
                  } else {
                     object_0 = new DynamicObject(int_3, 1, int_4, int_0, int_1, int_2, objectcomposition_0.animationId, true, (Renderable) null);
                  }

                  region_0.addBoundary(int_0, int_1, int_2, int_12, (Renderable) object_0, (Renderable) null, Class19.anIntArray9[int_4], 0, int_15, int_16);
                  if (objectcomposition_0.clipped) {
                     if (int_4 == 0) {
                        Class19.aByteArrayArrayArray7[int_0][int_1][int_2 + 1] = 50;
                     } else if (int_4 == 1) {
                        Class19.aByteArrayArrayArray7[int_0][int_1 + 1][int_2 + 1] = 50;
                     } else if (int_4 == 2) {
                        Class19.aByteArrayArrayArray7[int_0][int_1 + 1][int_2] = 50;
                     } else if (int_4 == 3) {
                        Class19.aByteArrayArrayArray7[int_0][int_1][int_2] = 50;
                     }
                  }

                  if (objectcomposition_0.interactType != 0 && collisiondata_0 != null) {
                     collisiondata_0.addWall(int_1, int_2, int_5, int_4, objectcomposition_0.aBool60);
                  }

               } else {
                  int int_20;
                  Object object_2;
                  if (int_5 == 2) {
                     int_20 = int_4 + 1 & 0x3;
                     Object object_1;
                     if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                        object_1 = objectcomposition_0.getModel(2, int_4 + 4, ints_0, int_13, int_12, int_14);
                        object_2 = objectcomposition_0.getModel(2, int_20, ints_0, int_13, int_12, int_14);
                     } else {
                        object_1 = new DynamicObject(int_3, 2, int_4 + 4, int_0, int_1, int_2, objectcomposition_0.animationId, true, (Renderable) null);
                        object_2 = new DynamicObject(int_3, 2, int_20, int_0, int_1, int_2, objectcomposition_0.animationId, true, (Renderable) null);
                     }

                     region_0.addBoundary(int_0, int_1, int_2, int_12, (Renderable) object_1, (Renderable) object_2, Class19.anIntArray7[int_4], Class19.anIntArray7[int_20], int_15, int_16);
                     if (objectcomposition_0.modelClipped) {
                        if (int_4 == 0) {
                           ItemLayer.anIntArrayArrayArray1[int_0][int_1][int_2] |= 0x249;
                           ItemLayer.anIntArrayArrayArray1[int_0][int_1][int_2 + 1] |= 0x492;
                        } else if (int_4 == 1) {
                           ItemLayer.anIntArrayArrayArray1[int_0][int_1][1 + int_2] |= 0x492;
                           ItemLayer.anIntArrayArrayArray1[int_0][int_1 + 1][int_2] |= 0x249;
                        } else if (int_4 == 2) {
                           ItemLayer.anIntArrayArrayArray1[int_0][int_1 + 1][int_2] |= 0x249;
                           ItemLayer.anIntArrayArrayArray1[int_0][int_1][int_2] |= 0x492;
                        } else if (int_4 == 3) {
                           ItemLayer.anIntArrayArrayArray1[int_0][int_1][int_2] |= 0x492;
                           ItemLayer.anIntArrayArrayArray1[int_0][int_1][int_2] |= 0x249;
                        }
                     }

                     if (objectcomposition_0.interactType != 0 && collisiondata_0 != null) {
                        collisiondata_0.addWall(int_1, int_2, int_5, int_4, objectcomposition_0.aBool60);
                     }

                     if (objectcomposition_0.anInt466 != 16) {
                        region_0.method380(int_0, int_1, int_2, objectcomposition_0.anInt466);
                     }

                  } else if (int_5 == 3) {
                     if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                        object_0 = objectcomposition_0.getModel(3, int_4, ints_0, int_13, int_12, int_14);
                     } else {
                        object_0 = new DynamicObject(int_3, 3, int_4, int_0, int_1, int_2, objectcomposition_0.animationId, true, (Renderable) null);
                     }

                     region_0.addBoundary(int_0, int_1, int_2, int_12, (Renderable) object_0, (Renderable) null, Class19.anIntArray9[int_4], 0, int_15, int_16);
                     if (objectcomposition_0.clipped) {
                        if (int_4 == 0) {
                           Class19.aByteArrayArrayArray7[int_0][int_1][int_2 + 1] = 50;
                        } else if (int_4 == 1) {
                           Class19.aByteArrayArrayArray7[int_0][int_1 + 1][int_2 + 1] = 50;
                        } else if (int_4 == 2) {
                           Class19.aByteArrayArrayArray7[int_0][int_1 + 1][int_2] = 50;
                        } else if (int_4 == 3) {
                           Class19.aByteArrayArrayArray7[int_0][int_1][int_2] = 50;
                        }
                     }

                     if (objectcomposition_0.interactType != 0 && collisiondata_0 != null) {
                        collisiondata_0.addWall(int_1, int_2, int_5, int_4, objectcomposition_0.aBool60);
                     }

                  } else if (int_5 == 9) {
                     if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                        object_0 = objectcomposition_0.getModel(int_5, int_4, ints_0, int_13, int_12, int_14);
                     } else {
                        object_0 = new DynamicObject(int_3, int_5, int_4, int_0, int_1, int_2, objectcomposition_0.animationId, true, (Renderable) null);
                     }

                     region_0.method379(int_0, int_1, int_2, int_12, 1, 1, (Renderable) object_0, 0, int_15, int_16);
                     if (objectcomposition_0.interactType != 0 && collisiondata_0 != null) {
                        collisiondata_0.addObject(int_1, int_2, int_6, int_7, objectcomposition_0.aBool60);
                     }

                     if (objectcomposition_0.anInt466 != 16) {
                        region_0.method380(int_0, int_1, int_2, objectcomposition_0.anInt466);
                     }

                  } else if (int_5 == 4) {
                     if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                        object_0 = objectcomposition_0.getModel(4, int_4, ints_0, int_13, int_12, int_14);
                     } else {
                        object_0 = new DynamicObject(int_3, 4, int_4, int_0, int_1, int_2, objectcomposition_0.animationId, true, (Renderable) null);
                     }

                     region_0.addBoundaryDecoration(int_0, int_1, int_2, int_12, (Renderable) object_0, (Renderable) null, Class19.anIntArray7[int_4], 0, 0, 0, int_15, int_16);
                  } else if (int_5 == 5) {
                     int_20 = 16;
                     int_17 = region_0.method365(int_0, int_1, int_2);
                     if (int_17 != 0) {
                        int_20 = Class28.getObjectDefinition(int_17 >> 14 & 0x7FFF).anInt466;
                     }

                     if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                        object_2 = objectcomposition_0.getModel(4, int_4, ints_0, int_13, int_12, int_14);
                     } else {
                        object_2 = new DynamicObject(int_3, 4, int_4, int_0, int_1, int_2, objectcomposition_0.animationId, true, (Renderable) null);
                     }

                     region_0.addBoundaryDecoration(int_0, int_1, int_2, int_12, (Renderable) object_2, (Renderable) null, Class19.anIntArray7[int_4], 0, int_20 * Class19.anIntArray10[int_4], int_20 * Class19.anIntArray12[int_4], int_15, int_16);
                  } else if (int_5 == 6) {
                     int_20 = 8;
                     int_17 = region_0.method365(int_0, int_1, int_2);
                     if (int_17 != 0) {
                        int_20 = Class28.getObjectDefinition(int_17 >> 14 & 0x7FFF).anInt466 / 2;
                     }

                     if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                        object_2 = objectcomposition_0.getModel(4, int_4 + 4, ints_0, int_13, int_12, int_14);
                     } else {
                        object_2 = new DynamicObject(int_3, 4, int_4 + 4, int_0, int_1, int_2, objectcomposition_0.animationId, true, (Renderable) null);
                     }

                     region_0.addBoundaryDecoration(int_0, int_1, int_2, int_12, (Renderable) object_2, (Renderable) null, 256, int_4, int_20 * Class19.anIntArray13[int_4], int_20 * Class19.anIntArray14[int_4], int_15, int_16);
                  } else if (int_5 == 7) {
                     int_17 = int_4 + 2 & 0x3;
                     if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                        object_0 = objectcomposition_0.getModel(4, int_17 + 4, ints_0, int_13, int_12, int_14);
                     } else {
                        object_0 = new DynamicObject(int_3, 4, int_17 + 4, int_0, int_1, int_2, objectcomposition_0.animationId, true, (Renderable) null);
                     }

                     region_0.addBoundaryDecoration(int_0, int_1, int_2, int_12, (Renderable) object_0, (Renderable) null, 256, int_17, 0, 0, int_15, int_16);
                  } else if (int_5 == 8) {
                     int_20 = 8;
                     int_17 = region_0.method365(int_0, int_1, int_2);
                     if (int_17 != 0) {
                        int_20 = Class28.getObjectDefinition(int_17 >> 14 & 0x7FFF).anInt466 / 2;
                     }

                     int int_21 = int_4 + 2 & 0x3;
                     Object object_3;
                     if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                        object_2 = objectcomposition_0.getModel(4, int_4 + 4, ints_0, int_13, int_12, int_14);
                        object_3 = objectcomposition_0.getModel(4, int_21 + 4, ints_0, int_13, int_12, int_14);
                     } else {
                        object_2 = new DynamicObject(int_3, 4, int_4 + 4, int_0, int_1, int_2, objectcomposition_0.animationId, true, (Renderable) null);
                        object_3 = new DynamicObject(int_3, 4, int_21 + 4, int_0, int_1, int_2, objectcomposition_0.animationId, true, (Renderable) null);
                     }

                     region_0.addBoundaryDecoration(int_0, int_1, int_2, int_12, (Renderable) object_2, (Renderable) object_3, 256, int_4, int_20 * Class19.anIntArray13[int_4], int_20 * Class19.anIntArray14[int_4], int_15, int_16);
                  }
               }
            } else {
               if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
                  object_0 = objectcomposition_0.getModel(10, int_4, ints_0, int_13, int_12, int_14);
               } else {
                  object_0 = new DynamicObject(int_3, 10, int_4, int_0, int_1, int_2, objectcomposition_0.animationId, true, (Renderable) null);
               }

               if (object_0 != null && region_0.method379(int_0, int_1, int_2, int_12, int_6, int_7, (Renderable) object_0, int_5 == 11 ? 256 : 0, int_15, int_16) && objectcomposition_0.clipped) {
                  int_17 = 15;
                  if (object_0 instanceof Model) {
                     int_17 = ((Model) object_0).method1029() / 4;
                     if (int_17 > 30) {
                        int_17 = 30;
                     }
                  }

                  for (int int_18 = 0; int_18 <= int_6; int_18++) {
                     for (int int_19 = 0; int_19 <= int_7; int_19++) {
                        if (int_17 > Class19.aByteArrayArrayArray7[int_0][int_18 + int_1][int_19 + int_2]) {
                           Class19.aByteArrayArrayArray7[int_0][int_18 + int_1][int_19 + int_2] = (byte)int_17;
                        }
                     }
                  }
               }

               if (objectcomposition_0.interactType != 0 && collisiondata_0 != null) {
                  collisiondata_0.addObject(int_1, int_2, int_6, int_7, objectcomposition_0.aBool60);
               }

            }
         }
      }
   }

}
