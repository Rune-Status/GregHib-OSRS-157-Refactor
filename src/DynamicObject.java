public class DynamicObject extends Renderable {

   static int anInt577;
   static ClanMember[] clanMembers;
   Sequence aSequence2;
   int id;
   int anInt578;
   int type;
   int orientation;
   int level;
   int anInt579;
   int sceneX;
   int sceneY;

   DynamicObject(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, boolean bool_0, Renderable renderable_0) {
      this.id = int_0;
      this.type = int_1;
      this.orientation = int_2;
      this.level = int_3;
      this.sceneX = int_4;
      this.sceneY = int_5;
      if (int_6 != -1) {
         this.aSequence2 = ItemLayer.getAnimation(int_6);
         this.anInt579 = 0;
         this.anInt578 = Client.gameCycle - 1;
         if (this.aSequence2.replyMode == 0 && renderable_0 != null && renderable_0 instanceof DynamicObject) {
            DynamicObject dynamicobject_1 = (DynamicObject) renderable_0;
            if (dynamicobject_1.aSequence2 == this.aSequence2) {
               this.anInt579 = dynamicobject_1.anInt579;
               this.anInt578 = dynamicobject_1.anInt578;
               return;
            }
         }

         if (bool_0 && this.aSequence2.frameStep != -1) {
            this.anInt579 = (int)(Math.random() * (double)this.aSequence2.frameIDs.length);
            this.anInt578 -= (int)(Math.random() * (double)this.aSequence2.frameLenghts[this.anInt579]);
         }
      }

   }

   protected Model getModel() {
      if (this.aSequence2 != null) {
         int int_0 = Client.gameCycle - this.anInt578;
         if (int_0 > 100 && this.aSequence2.frameStep > 0) {
            int_0 = 100;
         }

         label52: {
            do {
               do {
                  if (int_0 <= this.aSequence2.frameLenghts[this.anInt579]) {
                     break label52;
                  }

                  int_0 -= this.aSequence2.frameLenghts[this.anInt579];
                  ++this.anInt579;
               } while (this.anInt579 < this.aSequence2.frameIDs.length);

               this.anInt579 -= this.aSequence2.frameStep;
            } while (this.anInt579 >= 0 && this.anInt579 < this.aSequence2.frameIDs.length);

            this.aSequence2 = null;
         }

         this.anInt578 = Client.gameCycle - int_0;
      }

      ObjectComposition objectcomposition_0 = Class28.getObjectDefinition(this.id);
      if (objectcomposition_0.impostorIds != null) {
         objectcomposition_0 = objectcomposition_0.getImpostor();
      }

      if (objectcomposition_0 == null) {
         return null;
      } else {
         int int_1;
         int int_2;
         if (this.orientation != 1 && this.orientation != 3) {
            int_1 = objectcomposition_0.sizeX;
            int_2 = objectcomposition_0.sizeY;
         } else {
            int_1 = objectcomposition_0.sizeY;
            int_2 = objectcomposition_0.sizeX;
         }

         int int_3 = (int_1 >> 1) + this.sceneX;
         int int_4 = (int_1 + 1 >> 1) + this.sceneX;
         int int_5 = (int_2 >> 1) + this.sceneY;
         int int_6 = (int_2 + 1 >> 1) + this.sceneY;
         int[][] ints_0 = Class19.tileHeights[this.level];
         int int_7 = ints_0[int_4][int_6] + ints_0[int_3][int_6] + ints_0[int_4][int_5] + ints_0[int_3][int_5] >> 2;
         int int_8 = (this.sceneX << 7) + (int_1 << 6);
         int int_9 = (this.sceneY << 7) + (int_2 << 6);
         return objectcomposition_0.method822(this.type, this.orientation, ints_0, int_8, int_7, int_9, this.aSequence2, this.anInt579);
      }
   }

   static byte[] decodeContainer(byte[] bytes_0) {
      Buffer buffer_0 = new Buffer(bytes_0);
      int int_0 = buffer_0.readUnsignedByte();
      int int_1 = buffer_0.readInt();
      if (int_1 < 0 || IndexDataBase.anInt170 != 0 && int_1 > IndexDataBase.anInt170) {
         throw new RuntimeException();
      } else if (int_0 == 0) {
         byte[] bytes_1 = new byte[int_1];
         buffer_0.readBytes(bytes_1, 0, int_1);
         return bytes_1;
      } else {
         int int_2 = buffer_0.readInt();
         if (int_2 >= 0 && (IndexDataBase.anInt170 == 0 || int_2 <= IndexDataBase.anInt170)) {
            byte[] bytes_2 = new byte[int_2];
            if (int_0 == 1) {
               Class66.method404(bytes_2, int_2, bytes_0, int_1, 9);
            } else {
               IndexDataBase.gzip.decompress(buffer_0, bytes_2);
            }

            return bytes_2;
         } else {
            throw new RuntimeException();
         }
      }
   }

   static void method1064(int int_0) {
      Class12.method165();

      for (Node_Sub1 node_sub1_0 = (Node_Sub1) Node_Sub1.aDeque3.getFront(); node_sub1_0 != null; node_sub1_0 = (Node_Sub1) Node_Sub1.aDeque3.getNext()) {
         if (node_sub1_0.anObjectComposition1 != null) {
            node_sub1_0.method632();
         }
      }

      int int_1 = ClanMember.method677(int_0).configType;
      if (int_1 != 0) {
         int int_2 = Class79.widgetSettings[int_0];
         if (int_1 == 1) {
            if (int_2 == 1) {
               Graphics3D.setBrightness(0.9D);
               ((TextureProvider) Graphics3D.textureLoader).brightness(0.9D);
            }

            if (int_2 == 2) {
               Graphics3D.setBrightness(0.8D);
               ((TextureProvider) Graphics3D.textureLoader).brightness(0.8D);
            }

            if (int_2 == 3) {
               Graphics3D.setBrightness(0.7D);
               ((TextureProvider) Graphics3D.textureLoader).brightness(0.7D);
            }

            if (int_2 == 4) {
               Graphics3D.setBrightness(0.6D);
               ((TextureProvider) Graphics3D.textureLoader).brightness(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if (int_1 == 3) {
            short short_0 = 0;
            if (int_2 == 0) {
               short_0 = 255;
            }

            if (int_2 == 1) {
               short_0 = 192;
            }

            if (int_2 == 2) {
               short_0 = 128;
            }

            if (int_2 == 3) {
               short_0 = 64;
            }

            if (int_2 == 4) {
               short_0 = 0;
            }

            if (short_0 != Client.anInt662) {
               if (Client.anInt662 == 0 && Client.anInt643 != -1) {
                  Class71.method424(Class38.indexTrack1, Client.anInt643, 0, short_0, false);
                  Client.aBool87 = false;
               } else if (short_0 == 0) {
                  ItemLayer.method545();
                  Client.aBool87 = false;
               } else if (Class78.anInt172 != 0) {
                  Class7.anInt40 = short_0;
               } else {
                  Class78.anAClass6_Sub3_1.method853(short_0);
               }

               Client.anInt662 = short_0;
            }
         }

         if (int_1 == 4) {
            if (int_2 == 0) {
               Client.anInt644 = 127;
            }

            if (int_2 == 1) {
               Client.anInt644 = 96;
            }

            if (int_2 == 2) {
               Client.anInt644 = 64;
            }

            if (int_2 == 3) {
               Client.anInt644 = 32;
            }

            if (int_2 == 4) {
               Client.anInt644 = 0;
            }
         }

         if (int_1 == 5) {
            Client.anInt613 = int_2;
         }

         if (int_1 == 6) {
            Client.anInt665 = int_2;
         }

         if (int_1 == 9) {
            Client.anInt672 = int_2;
         }

         if (int_1 == 10) {
            if (int_2 == 0) {
               Client.anInt646 = 127;
            }

            if (int_2 == 1) {
               Client.anInt646 = 96;
            }

            if (int_2 == 2) {
               Client.anInt646 = 64;
            }

            if (int_2 == 3) {
               Client.anInt646 = 32;
            }

            if (int_2 == 4) {
               Client.anInt646 = 0;
            }
         }

         if (int_1 == 17) {
            Client.anInt682 = int_2 & 0xFFFF;
         }

         Enum2[] enum2s_0;
         if (int_1 == 18) {
            enum2s_0 = new Enum2[] {Enum2.anEnum2_4, Enum2.anEnum2_3, Enum2.anEnum2_2, Enum2.anEnum2_1};
            Client.anEnum2_5 = (Enum2) Class1.forOrdinal(enum2s_0, int_2);
            if (Client.anEnum2_5 == null) {
               Client.anEnum2_5 = Enum2.anEnum2_1;
            }
         }

         if (int_1 == 19) {
            if (int_2 == -1) {
               Client.anInt667 = -1;
            } else {
               Client.anInt667 = int_2 & 0x7FF;
            }
         }

         if (int_1 == 22) {
            enum2s_0 = new Enum2[] {Enum2.anEnum2_4, Enum2.anEnum2_3, Enum2.anEnum2_2, Enum2.anEnum2_1};
            Client.anEnum2_6 = (Enum2) Class1.forOrdinal(enum2s_0, int_2);
            if (Client.anEnum2_6 == null) {
               Client.anEnum2_6 = Enum2.anEnum2_1;
            }
         }

      }
   }

   static void method1065() {
      Class101.flush(false);
      Client.anInt631 = 0;
      boolean bool_0 = true;

      int int_0;
      for (int_0 = 0; int_0 < Class55.aByteArrayArray3.length; int_0++) {
         if (Varbit.landMapFileIds[int_0] != -1 && Class55.aByteArrayArray3[int_0] == null) {
            Class55.aByteArrayArray3[int_0] = Class23.indexMaps.getConfigData(Varbit.landMapFileIds[int_0], 0);
            if (Class55.aByteArrayArray3[int_0] == null) {
               bool_0 = false;
               ++Client.anInt631;
            }
         }

         if (Varbit.landRegionFileIds[int_0] != -1 && Class10.aByteArrayArray1[int_0] == null) {
            Class10.aByteArrayArray1[int_0] = Class23.indexMaps.getConfigData(Varbit.landRegionFileIds[int_0], 0, Class38.xteaKeys[int_0]);
            if (Class10.aByteArrayArray1[int_0] == null) {
               bool_0 = false;
               ++Client.anInt631;
            }
         }
      }

      if (!bool_0) {
         Client.anInt630 = 1;
      } else {
         Client.anInt633 = 0;
         bool_0 = true;

         int int_1;
         int int_2;
         int int_4;
         int int_5;
         int int_7;
         int int_8;
         int int_10;
         int int_11;
         int int_12;
         int int_13;
         int int_14;
         for (int_0 = 0; int_0 < Class55.aByteArrayArray3.length; int_0++) {
            byte[] bytes_0 = Class10.aByteArrayArray1[int_0];
            if (bytes_0 != null) {
               int_1 = (Script.mapRegions[int_0] >> 8) * 64 - ItemLayer.baseX;
               int_2 = (Script.mapRegions[int_0] & 0xFF) * 64 - ItemLayer.baseY;
               if (Client.isDynamicRegion) {
                  int_1 = 10;
                  int_2 = 10;
               }

               boolean bool_1 = true;
               Buffer buffer_0 = new Buffer(bytes_0);
               int_4 = -1;

               label1275:
               while (true) {
                  int_5 = buffer_0.getUSmart();
                  if (int_5 == 0) {
                     bool_0 &= bool_1;
                     break;
                  }

                  int_4 += int_5;
                  int_7 = 0;
                  boolean bool_2 = false;

                  while (true) {
                     while (!bool_2) {
                        int_8 = buffer_0.getUSmart();
                        if (int_8 == 0) {
                           continue label1275;
                        }

                        int_7 += int_8 - 1;
                        int_10 = int_7 & 0x3F;
                        int_11 = int_7 >> 6 & 0x3F;
                        int_12 = buffer_0.readUnsignedByte() >> 2;
                        int_13 = int_1 + int_11;
                        int_14 = int_2 + int_10;
                        if (int_13 > 0 && int_14 > 0 && int_13 < 103 && int_14 < 103) {
                           ObjectComposition objectcomposition_0 = Class28.getObjectDefinition(int_4);
                           if (int_12 != 22 || !Client.lowMemory || objectcomposition_0.anInt461 != 0 || objectcomposition_0.interactType == 1 || objectcomposition_0.aBool61) {
                              if (!objectcomposition_0.method823()) {
                                 ++Client.anInt633;
                                 bool_1 = false;
                              }

                              bool_2 = true;
                           }
                        }
                     }

                     int_8 = buffer_0.getUSmart();
                     if (int_8 == 0) {
                        break;
                     }

                     buffer_0.readUnsignedByte();
                  }
               }
            }
         }

         if (!bool_0) {
            Client.anInt630 = 2;
         } else {
            if (Client.anInt630 != 0) {
               Class68_Sub1.drawStatusBox("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            Enum2.method642();
            World.method557();
            Enum2.method642();
            Class23.region.reset();
            Enum2.method642();
            System.gc();

            for (int_0 = 0; int_0 < 4; int_0++) {
               Client.collisionMaps[int_0].reset();
            }

            int int_9;
            for (int_0 = 0; int_0 < 4; int_0++) {
               for (int_9 = 0; int_9 < 104; int_9++) {
                  for (int_1 = 0; int_1 < 104; int_1++) {
                     Class19.tileSettings[int_0][int_9][int_1] = 0;
                  }
               }
            }

            Enum2.method642();
            Buffer.method734();
            int_0 = Class55.aByteArrayArray3.length;
            CombatInfo2.method820();
            Class101.flush(true);
            int int_3;
            if (!Client.isDynamicRegion) {
               byte[] bytes_1;
               for (int_9 = 0; int_9 < int_0; int_9++) {
                  int_1 = (Script.mapRegions[int_9] >> 8) * 64 - ItemLayer.baseX;
                  int_2 = (Script.mapRegions[int_9] & 0xFF) * 64 - ItemLayer.baseY;
                  bytes_1 = Class55.aByteArrayArray3[int_9];
                  if (bytes_1 != null) {
                     Enum2.method642();
                     ItemLayer.method546(bytes_1, int_1, int_2, Class87.anInt189 * 8 - 48, Class25.anInt86 * 8 - 48, Client.collisionMaps);
                  }
               }

               for (int_9 = 0; int_9 < int_0; int_9++) {
                  int_1 = (Script.mapRegions[int_9] >> 8) * 64 - ItemLayer.baseX;
                  int_2 = (Script.mapRegions[int_9] & 0xFF) * 64 - ItemLayer.baseY;
                  bytes_1 = Class55.aByteArrayArray3[int_9];
                  if (bytes_1 == null && Class25.anInt86 < 800) {
                     Enum2.method642();
                     PendingSpawn.method674(int_1, int_2, 64, 64);
                  }
               }

               Class101.flush(true);

               for (int_9 = 0; int_9 < int_0; int_9++) {
                  byte[] bytes_2 = Class10.aByteArrayArray1[int_9];
                  if (bytes_2 != null) {
                     int_2 = (Script.mapRegions[int_9] >> 8) * 64 - ItemLayer.baseX;
                     int_3 = (Script.mapRegions[int_9] & 0xFF) * 64 - ItemLayer.baseY;
                     Enum2.method642();
                     Class15.method196(bytes_2, int_2, int_3, Class23.region, Client.collisionMaps);
                  }
               }
            }

            int int_6;
            int int_15;
            int int_17;
            int int_18;
            int int_19;
            int int_20;
            int int_21;
            int int_22;
            int int_23;
            int int_24;
            int int_25;
            int int_26;
            int int_27;
            int int_28;
            int int_29;
            int int_40;
            int int_41;
            if (Client.isDynamicRegion) {
               for (int_9 = 0; int_9 < 4; int_9++) {
                  Enum2.method642();

                  for (int_1 = 0; int_1 < 13; int_1++) {
                     for (int_2 = 0; int_2 < 13; int_2++) {
                        boolean bool_3 = false;
                        int_6 = Client.anIntArrayArrayArray2[int_9][int_1][int_2];
                        if (int_6 != -1) {
                           int_40 = int_6 >> 24 & 0x3;
                           int_15 = int_6 >> 1 & 0x3;
                           int_4 = int_6 >> 14 & 0x3FF;
                           int_5 = int_6 >> 3 & 0x7FF;
                           int_7 = (int_4 / 8 << 8) + int_5 / 8;

                           for (int_41 = 0; int_41 < Script.mapRegions.length; int_41++) {
                              if (Script.mapRegions[int_41] == int_7 && Class55.aByteArrayArray3[int_41] != null) {
                                 Client.method1111(Class55.aByteArrayArray3[int_41], int_9, int_1 * 8, int_2 * 8, int_40, (int_4 & 0x7) * 8, (int_5 & 0x7) * 8, int_15, Client.collisionMaps);
                                 bool_3 = true;
                                 break;
                              }
                           }
                        }

                        if (!bool_3) {
                           Class27.method227(int_9, int_1 * 8, int_2 * 8);
                        }
                     }
                  }
               }

               for (int_9 = 0; int_9 < 13; int_9++) {
                  for (int_1 = 0; int_1 < 13; int_1++) {
                     int_2 = Client.anIntArrayArrayArray2[0][int_9][int_1];
                     if (int_2 == -1) {
                        PendingSpawn.method674(int_9 * 8, int_1 * 8, 8, 8);
                     }
                  }
               }

               Class101.flush(true);

               for (int_9 = 0; int_9 < 4; int_9++) {
                  Enum2.method642();

                  for (int_1 = 0; int_1 < 13; int_1++) {
                     label1150:
                     for (int_2 = 0; int_2 < 13; int_2++) {
                        int_3 = Client.anIntArrayArrayArray2[int_9][int_1][int_2];
                        if (int_3 != -1) {
                           int_6 = int_3 >> 24 & 0x3;
                           int_40 = int_3 >> 1 & 0x3;
                           int_15 = int_3 >> 14 & 0x3FF;
                           int_4 = int_3 >> 3 & 0x7FF;
                           int_5 = (int_15 / 8 << 8) + int_4 / 8;

                           for (int_7 = 0; int_7 < Script.mapRegions.length; int_7++) {
                              if (Script.mapRegions[int_7] == int_5 && Class10.aByteArrayArray1[int_7] != null) {
                                 byte[] bytes_3 = Class10.aByteArrayArray1[int_7];
                                 int_8 = int_1 * 8;
                                 int_10 = int_2 * 8;
                                 int_11 = (int_15 & 0x7) * 8;
                                 int_12 = (int_4 & 0x7) * 8;
                                 Region region_0 = Class23.region;
                                 CollisionData[] collisiondatas_0 = Client.collisionMaps;
                                 Buffer buffer_1 = new Buffer(bytes_3);
                                 int_17 = -1;

                                 while (true) {
                                    int_18 = buffer_1.getUSmart();
                                    if (int_18 == 0) {
                                       continue label1150;
                                    }

                                    int_17 += int_18;
                                    int_19 = 0;

                                    while (true) {
                                       int_20 = buffer_1.getUSmart();
                                       if (int_20 == 0) {
                                          break;
                                       }

                                       int_19 += int_20 - 1;
                                       int_21 = int_19 & 0x3F;
                                       int_22 = int_19 >> 6 & 0x3F;
                                       int_23 = int_19 >> 12;
                                       int_24 = buffer_1.readUnsignedByte();
                                       int_25 = int_24 >> 2;
                                       int_26 = int_24 & 0x3;
                                       if (int_6 == int_23 && int_22 >= int_11 && int_22 < int_11 + 8 && int_21 >= int_12 && int_21 < int_12 + 8) {
                                          ObjectComposition objectcomposition_1 = Class28.getObjectDefinition(int_17);
                                          int_27 = int_8 + Class20.method209(int_22 & 0x7, int_21 & 0x7, int_40, objectcomposition_1.sizeX, objectcomposition_1.sizeY, int_26);
                                          int_28 = int_10 + RSCanvas.method749(int_22 & 0x7, int_21 & 0x7, int_40, objectcomposition_1.sizeX, objectcomposition_1.sizeY, int_26);
                                          if (int_27 > 0 && int_28 > 0 && int_27 < 103 && int_28 < 103) {
                                             int_29 = int_9;
                                             if ((Class19.tileSettings[1][int_27][int_28] & 0x2) == 2) {
                                                int_29 = int_9 - 1;
                                             }

                                             CollisionData collisiondata_0 = null;
                                             if (int_29 >= 0) {
                                                collisiondata_0 = collisiondatas_0[int_29];
                                             }

                                             RuntimeException_Sub1.addObject(int_9, int_27, int_28, int_17, int_26 + int_40 & 0x3, int_25, region_0, collisiondata_0);
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            Class101.flush(true);
            World.method557();
            Enum2.method642();
            Region region_1 = Class23.region;
            CollisionData[] collisiondatas_1 = Client.collisionMaps;

            for (int_2 = 0; int_2 < 4; int_2++) {
               for (int_3 = 0; int_3 < 104; int_3++) {
                  for (int_6 = 0; int_6 < 104; int_6++) {
                     if ((Class19.tileSettings[int_2][int_3][int_6] & 0x1) == 1) {
                        int_40 = int_2;
                        if ((Class19.tileSettings[1][int_3][int_6] & 0x2) == 2) {
                           int_40 = int_2 - 1;
                        }

                        if (int_40 >= 0) {
                           collisiondatas_1[int_40].method581(int_3, int_6);
                        }
                     }
                  }
               }
            }

            Class19.anInt73 += (int)(Math.random() * 5.0D) - 2;
            if (Class19.anInt73 < -8) {
               Class19.anInt73 = -8;
            }

            if (Class19.anInt73 > 8) {
               Class19.anInt73 = 8;
            }

            Class19.anInt74 += (int)(Math.random() * 5.0D) - 2;
            if (Class19.anInt74 < -16) {
               Class19.anInt74 = -16;
            }

            if (Class19.anInt74 > 16) {
               Class19.anInt74 = 16;
            }

            int int_16;
            for (int_2 = 0; int_2 < 4; int_2++) {
               byte[][] bytes_4 = Class19.aByteArrayArrayArray7[int_2];
               int_7 = (int)Math.sqrt(5100.0D);
               int_41 = int_7 * 768 >> 8;

               for (int_8 = 1; int_8 < 103; int_8++) {
                  for (int_10 = 1; int_10 < 103; int_10++) {
                     int_11 = Class19.tileHeights[int_2][int_10 + 1][int_8] - Class19.tileHeights[int_2][int_10 - 1][int_8];
                     int_12 = Class19.tileHeights[int_2][int_10][int_8 + 1] - Class19.tileHeights[int_2][int_10][int_8 - 1];
                     int_13 = (int)Math.sqrt((double)(int_12 * int_12 + int_11 * int_11 + 65536));
                     int_14 = (int_11 << 8) / int_13;
                     int_16 = 65536 / int_13;
                     int_17 = (int_12 << 8) / int_13;
                     int_18 = (int_17 * -50 + int_14 * -50 + int_16 * -10) / int_41 + 96;
                     int_19 = (bytes_4[int_10][int_8 + 1] >> 3) + (bytes_4[int_10 - 1][int_8] >> 2) + (bytes_4[int_10][int_8 - 1] >> 2) + (bytes_4[int_10 + 1][int_8] >> 3) + (bytes_4[int_10][int_8] >> 1);
                     Class79.anIntArrayArray12[int_10][int_8] = int_18 - int_19;
                  }
               }

               for (int_8 = 0; int_8 < 104; int_8++) {
                  Class19.anIntArray8[int_8] = 0;
                  RSCanvas.anIntArray82[int_8] = 0;
                  Preferences.anIntArray39[int_8] = 0;
                  FloorUnderlayDefinition.anIntArray105[int_8] = 0;
                  Class19.anIntArray11[int_8] = 0;
               }

               for (int_8 = -5; int_8 < 109; int_8++) {
                  for (int_10 = 0; int_10 < 104; int_10++) {
                     int_11 = int_8 + 5;
                     if (int_11 >= 0 && int_11 < 104) {
                        int_12 = Class19.aByteArrayArrayArray5[int_2][int_11][int_10] & 0xFF;
                        if (int_12 > 0) {
                           FloorUnderlayDefinition floorunderlaydefinition_0 = Class33.method240(int_12 - 1);
                           Class19.anIntArray8[int_10] += floorunderlaydefinition_0.hue;
                           RSCanvas.anIntArray82[int_10] += floorunderlaydefinition_0.saturation;
                           Preferences.anIntArray39[int_10] += floorunderlaydefinition_0.lightness;
                           FloorUnderlayDefinition.anIntArray105[int_10] += floorunderlaydefinition_0.hueMultiplier;
                           ++Class19.anIntArray11[int_10];
                        }
                     }

                     int_12 = int_8 - 5;
                     if (int_12 >= 0 && int_12 < 104) {
                        int_13 = Class19.aByteArrayArrayArray5[int_2][int_12][int_10] & 0xFF;
                        if (int_13 > 0) {
                           FloorUnderlayDefinition floorunderlaydefinition_1 = Class33.method240(int_13 - 1);
                           Class19.anIntArray8[int_10] -= floorunderlaydefinition_1.hue;
                           RSCanvas.anIntArray82[int_10] -= floorunderlaydefinition_1.saturation;
                           Preferences.anIntArray39[int_10] -= floorunderlaydefinition_1.lightness;
                           FloorUnderlayDefinition.anIntArray105[int_10] -= floorunderlaydefinition_1.hueMultiplier;
                           --Class19.anIntArray11[int_10];
                        }
                     }
                  }

                  if (int_8 >= 1 && int_8 < 103) {
                     int_10 = 0;
                     int_11 = 0;
                     int_12 = 0;
                     int_13 = 0;
                     int_14 = 0;

                     for (int_16 = -5; int_16 < 109; int_16++) {
                        int_17 = int_16 + 5;
                        if (int_17 >= 0 && int_17 < 104) {
                           int_10 += Class19.anIntArray8[int_17];
                           int_11 += RSCanvas.anIntArray82[int_17];
                           int_12 += Preferences.anIntArray39[int_17];
                           int_13 += FloorUnderlayDefinition.anIntArray105[int_17];
                           int_14 += Class19.anIntArray11[int_17];
                        }

                        int_18 = int_16 - 5;
                        if (int_18 >= 0 && int_18 < 104) {
                           int_10 -= Class19.anIntArray8[int_18];
                           int_11 -= RSCanvas.anIntArray82[int_18];
                           int_12 -= Preferences.anIntArray39[int_18];
                           int_13 -= FloorUnderlayDefinition.anIntArray105[int_18];
                           int_14 -= Class19.anIntArray11[int_18];
                        }

                        if (int_16 >= 1 && int_16 < 103 && (!Client.lowMemory || (Class19.tileSettings[0][int_8][int_16] & 0x2) != 0 || (Class19.tileSettings[int_2][int_8][int_16] & 0x10) == 0)) {
                           if (int_2 < Class19.anInt72) {
                              Class19.anInt72 = int_2;
                           }

                           int_19 = Class19.aByteArrayArrayArray5[int_2][int_8][int_16] & 0xFF;
                           int_20 = Class106.aByteArrayArrayArray9[int_2][int_8][int_16] & 0xFF;
                           if (int_19 > 0 || int_20 > 0) {
                              int_21 = Class19.tileHeights[int_2][int_8][int_16];
                              int_22 = Class19.tileHeights[int_2][int_8 + 1][int_16];
                              int_23 = Class19.tileHeights[int_2][int_8 + 1][int_16 + 1];
                              int_24 = Class19.tileHeights[int_2][int_8][int_16 + 1];
                              int_25 = Class79.anIntArrayArray12[int_8][int_16];
                              int_26 = Class79.anIntArrayArray12[int_8 + 1][int_16];
                              int int_30 = Class79.anIntArrayArray12[int_8 + 1][int_16 + 1];
                              int_27 = Class79.anIntArrayArray12[int_8][int_16 + 1];
                              int_28 = -1;
                              int_29 = -1;
                              int int_31;
                              int int_32;
                              if (int_19 > 0) {
                                 int_31 = int_10 * 256 / int_13;
                                 int_32 = int_11 / int_14;
                                 int int_33 = int_12 / int_14;
                                 int_28 = WorldMapData_Sub1.method609(int_31, int_32, int_33);
                                 int_31 = int_31 + Class19.anInt73 & 0xFF;
                                 int_33 += Class19.anInt74;
                                 if (int_33 < 0) {
                                    int_33 = 0;
                                 } else if (int_33 > 255) {
                                    int_33 = 255;
                                 }

                                 int_29 = WorldMapData_Sub1.method609(int_31, int_32, int_33);
                              }

                              if (int_2 > 0) {
                                 boolean bool_4 = true;
                                 if (int_19 == 0 && Class19.aByteArrayArrayArray6[int_2][int_8][int_16] != 0) {
                                    bool_4 = false;
                                 }

                                 if (int_20 > 0 && !Class39.method255(int_20 - 1).isHidden) {
                                    bool_4 = false;
                                 }

                                 if (bool_4 && int_22 == int_21 && int_23 == int_21 && int_21 == int_24) {
                                    ItemLayer.anIntArrayArrayArray1[int_2][int_8][int_16] |= 0x924;
                                 }
                              }

                              int_31 = 0;
                              if (int_29 != -1) {
                                 int_31 = Graphics3D.colorPalette[Parameters.method83(int_29, 96)];
                              }

                              if (int_20 == 0) {
                                 region_1.addTile(int_2, int_8, int_16, 0, 0, -1, int_21, int_22, int_23, int_24, Parameters.method83(int_28, int_25), Parameters.method83(int_28, int_26), Parameters.method83(int_28, int_30), Parameters.method83(int_28, int_27), 0, 0, 0, 0, int_31, 0);
                              } else {
                                 int_32 = Class19.aByteArrayArrayArray6[int_2][int_8][int_16] + 1;
                                 byte byte_0 = Class7.aByteArrayArrayArray2[int_2][int_8][int_16];
                                 Overlay overlay_0 = Class39.method255(int_20 - 1);
                                 int int_34 = overlay_0.texture;
                                 int int_35;
                                 int int_36;
                                 int int_37;
                                 int int_38;
                                 if (int_34 >= 0) {
                                    int_35 = Graphics3D.textureLoader.getAverageTextureRGB(int_34);
                                    int_36 = -1;
                                 } else if (overlay_0.color == 16711935) {
                                    int_36 = -2;
                                    int_34 = -1;
                                    int_35 = -2;
                                 } else {
                                    int_36 = WorldMapData_Sub1.method609(overlay_0.hue, overlay_0.saturation, overlay_0.lightness);
                                    int_37 = overlay_0.hue + Class19.anInt73 & 0xFF;
                                    int_38 = overlay_0.lightness + Class19.anInt74;
                                    if (int_38 < 0) {
                                       int_38 = 0;
                                    } else if (int_38 > 255) {
                                       int_38 = 255;
                                    }

                                    int_35 = WorldMapData_Sub1.method609(int_37, overlay_0.saturation, int_38);
                                 }

                                 int_37 = 0;
                                 if (int_35 != -2) {
                                    int_37 = Graphics3D.colorPalette[Class14.adjustHSLListness0(int_35, 96)];
                                 }

                                 if (overlay_0.otherRgbColor != -1) {
                                    int_38 = overlay_0.otherHue + Class19.anInt73 & 0xFF;
                                    int int_39 = overlay_0.otherLightness + Class19.anInt74;
                                    if (int_39 < 0) {
                                       int_39 = 0;
                                    } else if (int_39 > 255) {
                                       int_39 = 255;
                                    }

                                    int_35 = WorldMapData_Sub1.method609(int_38, overlay_0.otherSaturation, int_39);
                                    int_37 = Graphics3D.colorPalette[Class14.adjustHSLListness0(int_35, 96)];
                                 }

                                 region_1.addTile(int_2, int_8, int_16, int_32, byte_0, int_34, int_21, int_22, int_23, int_24, Parameters.method83(int_28, int_25), Parameters.method83(int_28, int_26), Parameters.method83(int_28, int_30), Parameters.method83(int_28, int_27), Class14.adjustHSLListness0(int_36, int_25), Class14.adjustHSLListness0(int_36, int_26), Class14.adjustHSLListness0(int_36, int_30), Class14.adjustHSLListness0(int_36, int_27), int_31, int_37);
                              }
                           }
                        }
                     }
                  }
               }

               for (int_8 = 1; int_8 < 103; int_8++) {
                  for (int_10 = 1; int_10 < 103; int_10++) {
                     if ((Class19.tileSettings[int_2][int_10][int_8] & 0x8) != 0) {
                        int_16 = 0;
                     } else if (int_2 > 0 && (Class19.tileSettings[1][int_10][int_8] & 0x2) != 0) {
                        int_16 = int_2 - 1;
                     } else {
                        int_16 = int_2;
                     }

                     region_1.setPhysicalLevel(int_2, int_10, int_8, int_16);
                  }
               }

               Class19.aByteArrayArrayArray5[int_2] = null;
               Class106.aByteArrayArrayArray9[int_2] = null;
               Class19.aByteArrayArrayArray6[int_2] = null;
               Class7.aByteArrayArrayArray2[int_2] = null;
               Class19.aByteArrayArrayArray7[int_2] = null;
            }

            region_1.applyLighting(-50, -10, -50);

            for (int_2 = 0; int_2 < 104; int_2++) {
               for (int_3 = 0; int_3 < 104; int_3++) {
                  if ((Class19.tileSettings[1][int_2][int_3] & 0x2) == 2) {
                     region_1.setBridge(int_2, int_3);
                  }
               }
            }

            int_2 = 1;
            int_3 = 2;
            int_6 = 4;

            for (int_40 = 0; int_40 < 4; int_40++) {
               if (int_40 > 0) {
                  int_2 <<= 3;
                  int_3 <<= 3;
                  int_6 <<= 3;
               }

               for (int_15 = 0; int_15 <= int_40; int_15++) {
                  for (int_4 = 0; int_4 <= 104; int_4++) {
                     for (int_5 = 0; int_5 <= 104; int_5++) {
                        short short_0;
                        if ((ItemLayer.anIntArrayArrayArray1[int_15][int_5][int_4] & int_2) != 0) {
                           int_7 = int_4;
                           int_41 = int_4;
                           int_8 = int_15;

                           for (int_10 = int_15; int_7 > 0 && (ItemLayer.anIntArrayArrayArray1[int_15][int_5][int_7 - 1] & int_2) != 0; --int_7) {
                              ;
                           }

                           while (int_41 < 104 && (ItemLayer.anIntArrayArrayArray1[int_15][int_5][int_41 + 1] & int_2) != 0) {
                              ++int_41;
                           }

                           label878:
                           while (int_8 > 0) {
                              for (int_11 = int_7; int_11 <= int_41; int_11++) {
                                 if ((ItemLayer.anIntArrayArrayArray1[int_8 - 1][int_5][int_11] & int_2) == 0) {
                                    break label878;
                                 }
                              }

                              --int_8;
                           }

                           label867:
                           while (int_10 < int_40) {
                              for (int_11 = int_7; int_11 <= int_41; int_11++) {
                                 if ((ItemLayer.anIntArrayArrayArray1[int_10 + 1][int_5][int_11] & int_2) == 0) {
                                    break label867;
                                 }
                              }

                              ++int_10;
                           }

                           int_11 = (int_41 - int_7 + 1) * (int_10 + 1 - int_8);
                           if (int_11 >= 8) {
                              short_0 = 240;
                              int_13 = Class19.tileHeights[int_10][int_5][int_7] - short_0;
                              int_14 = Class19.tileHeights[int_8][int_5][int_7];
                              Region.addOcclude(int_40, 1, int_5 * 128, int_5 * 128, int_7 * 128, int_41 * 128 + 128, int_13, int_14);

                              for (int_16 = int_8; int_16 <= int_10; int_16++) {
                                 for (int_17 = int_7; int_17 <= int_41; int_17++) {
                                    ItemLayer.anIntArrayArrayArray1[int_16][int_5][int_17] &= ~int_2;
                                 }
                              }
                           }
                        }

                        if ((ItemLayer.anIntArrayArrayArray1[int_15][int_5][int_4] & int_3) != 0) {
                           int_7 = int_5;
                           int_41 = int_5;
                           int_8 = int_15;

                           for (int_10 = int_15; int_7 > 0 && (ItemLayer.anIntArrayArrayArray1[int_15][int_7 - 1][int_4] & int_3) != 0; --int_7) {
                              ;
                           }

                           while (int_41 < 104 && (ItemLayer.anIntArrayArrayArray1[int_15][int_41 + 1][int_4] & int_3) != 0) {
                              ++int_41;
                           }

                           label931:
                           while (int_8 > 0) {
                              for (int_11 = int_7; int_11 <= int_41; int_11++) {
                                 if ((ItemLayer.anIntArrayArrayArray1[int_8 - 1][int_11][int_4] & int_3) == 0) {
                                    break label931;
                                 }
                              }

                              --int_8;
                           }

                           label920:
                           while (int_10 < int_40) {
                              for (int_11 = int_7; int_11 <= int_41; int_11++) {
                                 if ((ItemLayer.anIntArrayArrayArray1[int_10 + 1][int_11][int_4] & int_3) == 0) {
                                    break label920;
                                 }
                              }

                              ++int_10;
                           }

                           int_11 = (int_10 + 1 - int_8) * (int_41 - int_7 + 1);
                           if (int_11 >= 8) {
                              short_0 = 240;
                              int_13 = Class19.tileHeights[int_10][int_7][int_4] - short_0;
                              int_14 = Class19.tileHeights[int_8][int_7][int_4];
                              Region.addOcclude(int_40, 2, int_7 * 128, int_41 * 128 + 128, int_4 * 128, int_4 * 128, int_13, int_14);

                              for (int_16 = int_8; int_16 <= int_10; int_16++) {
                                 for (int_17 = int_7; int_17 <= int_41; int_17++) {
                                    ItemLayer.anIntArrayArrayArray1[int_16][int_17][int_4] &= ~int_3;
                                 }
                              }
                           }
                        }

                        if ((ItemLayer.anIntArrayArrayArray1[int_15][int_5][int_4] & int_6) != 0) {
                           int_7 = int_5;
                           int_41 = int_5;
                           int_8 = int_4;

                           for (int_10 = int_4; int_8 > 0 && (ItemLayer.anIntArrayArrayArray1[int_15][int_5][int_8 - 1] & int_6) != 0; --int_8) {
                              ;
                           }

                           while (int_10 < 104 && (ItemLayer.anIntArrayArrayArray1[int_15][int_5][int_10 + 1] & int_6) != 0) {
                              ++int_10;
                           }

                           label984:
                           while (int_7 > 0) {
                              for (int_11 = int_8; int_11 <= int_10; int_11++) {
                                 if ((ItemLayer.anIntArrayArrayArray1[int_15][int_7 - 1][int_11] & int_6) == 0) {
                                    break label984;
                                 }
                              }

                              --int_7;
                           }

                           label973:
                           while (int_41 < 104) {
                              for (int_11 = int_8; int_11 <= int_10; int_11++) {
                                 if ((ItemLayer.anIntArrayArrayArray1[int_15][int_41 + 1][int_11] & int_6) == 0) {
                                    break label973;
                                 }
                              }

                              ++int_41;
                           }

                           if ((int_41 - int_7 + 1) * (int_10 - int_8 + 1) >= 4) {
                              int_11 = Class19.tileHeights[int_15][int_7][int_8];
                              Region.addOcclude(int_40, 4, int_7 * 128, int_41 * 128 + 128, int_8 * 128, int_10 * 128 + 128, int_11, int_11);

                              for (int_12 = int_7; int_12 <= int_41; int_12++) {
                                 for (int_13 = int_8; int_13 <= int_10; int_13++) {
                                    ItemLayer.anIntArrayArrayArray1[int_15][int_12][int_13] &= ~int_6;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            Class101.flush(true);
            int_2 = Class19.anInt72;
            if (int_2 > Ignore.plane) {
               int_2 = Ignore.plane;
            }

            if (int_2 < Ignore.plane - 1) {
               int_2 = Ignore.plane - 1;
            }

            if (Client.lowMemory) {
               Class23.region.setup(Class19.anInt72);
            } else {
               Class23.region.setup(0);
            }

            for (int_3 = 0; int_3 < 104; int_3++) {
               for (int_6 = 0; int_6 < 104; int_6++) {
                  Enum1.groundItemSpawned(int_3, int_6);
               }
            }

            Enum2.method642();

            for (PendingSpawn pendingspawn_0 = (PendingSpawn) Client.pendingSpawns.getFront(); pendingspawn_0 != null; pendingspawn_0 = (PendingSpawn) Client.pendingSpawns.getNext()) {
               if (pendingspawn_0.hitpoints == -1) {
                  pendingspawn_0.delay = 0;
                  Coordinates.method516(pendingspawn_0);
               } else {
                  pendingspawn_0.unlink();
               }
            }

            ObjectComposition.aNodeCache9.reset();
            PacketNode packetnode_0;
            if (AClass3.clientInstance.method1091()) {
               packetnode_0 = Actor.method953(ClientPacket.aClientPacket9, Client.aClass46_1.anISAACCipher1);
               packetnode_0.packetBuffer.putInt(1057001181);
               Client.aClass46_1.method282(packetnode_0);
            }

            if (!Client.isDynamicRegion) {
               int_3 = (Class87.anInt189 - 6) / 8;
               int_6 = (Class87.anInt189 + 6) / 8;
               int_40 = (Class25.anInt86 - 6) / 8;
               int_15 = (Class25.anInt86 + 6) / 8;

               for (int_4 = int_3 - 1; int_4 <= int_6 + 1; int_4++) {
                  for (int_5 = int_40 - 1; int_5 <= int_15 + 1; int_5++) {
                     if (int_4 < int_3 || int_4 > int_6 || int_5 < int_40 || int_5 > int_15) {
                        Class23.indexMaps.method440("m" + int_4 + "_" + int_5);
                        Class23.indexMaps.method440("l" + int_4 + "_" + int_5);
                     }
                  }
               }
            }

            Class110.setGameState(30);
            Enum2.method642();
            WorldMapData_Sub1.method608();
            packetnode_0 = Actor.method953(ClientPacket.aClientPacket96, Client.aClass46_1.anISAACCipher1);
            Client.aClass46_1.method282(packetnode_0);
            GameEngine.timer.method585();

            for (int_6 = 0; int_6 < 32; int_6++) {
               GameEngine.aLongArray3[int_6] = 0L;
            }

            for (int_6 = 0; int_6 < 32; int_6++) {
               GameEngine.aLongArray2[int_6] = 0L;
            }

            AClass3.anInt326 = 0;
         }
      }
   }

   static void addChatMessage(int int_0, String string_0, String string_1, String string_2) {
      ChatLineBuffer chatlinebuffer_0 = (ChatLineBuffer) Class34.chatLineMap.get(Integer.valueOf(int_0));
      if (chatlinebuffer_0 == null) {
         chatlinebuffer_0 = new ChatLineBuffer();
         Class34.chatLineMap.put(Integer.valueOf(int_0), chatlinebuffer_0);
      }

      MessageNode messagenode_0 = chatlinebuffer_0.addMessage(int_0, string_0, string_1, string_2);
      Class34.anIterableHashTable1.put(messagenode_0, (long)messagenode_0.id);
      Class34.aClass77_1.method464(messagenode_0);
      Client.chatCycle = Client.cycleCntr;
   }

}
