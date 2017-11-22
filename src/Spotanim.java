public class Spotanim extends CacheableNode {

   public static NodeCache aNodeCache6;
   public static NodeCache spotanims;
   static IndexDataBase anIndexDataBase14;
   int id;
   public int anInt420;
   int anInt421;
   int anInt422;
   int anInt423;
   int anInt424;
   int anInt425;
   int anInt426;
   short[] aShortArray6;
   short[] aShortArray7;
   short[] aShortArray8;
   short[] aShortArray9;

   static {
      spotanims = new NodeCache(64);
      aNodeCache6 = new NodeCache(30);
   }

   Spotanim() {
      this.anInt420 = -1;
      this.anInt422 = 128;
      this.anInt423 = 128;
      this.anInt424 = 0;
      this.anInt425 = 0;
      this.anInt426 = 0;
   }

   void method762(Buffer buffer_0, int int_0) {
      if (int_0 == 1) {
         this.anInt421 = buffer_0.readUnsignedShort();
      } else if (int_0 == 2) {
         this.anInt420 = buffer_0.readUnsignedShort();
      } else if (int_0 == 4) {
         this.anInt422 = buffer_0.readUnsignedShort();
      } else if (int_0 == 5) {
         this.anInt423 = buffer_0.readUnsignedShort();
      } else if (int_0 == 6) {
         this.anInt424 = buffer_0.readUnsignedShort();
      } else if (int_0 == 7) {
         this.anInt425 = buffer_0.readUnsignedByte();
      } else if (int_0 == 8) {
         this.anInt426 = buffer_0.readUnsignedByte();
      } else {
         int int_1;
         int int_2;
         if (int_0 == 40) {
            int_1 = buffer_0.readUnsignedByte();
            this.aShortArray6 = new short[int_1];
            this.aShortArray8 = new short[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
               this.aShortArray6[int_2] = (short)buffer_0.readUnsignedShort();
               this.aShortArray8[int_2] = (short)buffer_0.readUnsignedShort();
            }
         } else if (int_0 == 41) {
            int_1 = buffer_0.readUnsignedByte();
            this.aShortArray7 = new short[int_1];
            this.aShortArray9 = new short[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
               this.aShortArray7[int_2] = (short)buffer_0.readUnsignedShort();
               this.aShortArray9[int_2] = (short)buffer_0.readUnsignedShort();
            }
         }
      }

   }

   public Model method763(int int_0) {
      Model model_0 = (Model) aNodeCache6.get((long)this.id);
      if (model_0 == null) {
         ModelData modeldata_0 = ModelData.method1060(anIndexDataBase14, this.anInt421, 0);
         if (modeldata_0 == null) {
            return null;
         }

         int int_1;
         if (this.aShortArray6 != null) {
            for (int_1 = 0; int_1 < this.aShortArray6.length; int_1++) {
               modeldata_0.recolor(this.aShortArray6[int_1], this.aShortArray8[int_1]);
            }
         }

         if (this.aShortArray7 != null) {
            for (int_1 = 0; int_1 < this.aShortArray7.length; int_1++) {
               modeldata_0.method1051(this.aShortArray7[int_1], this.aShortArray9[int_1]);
            }
         }

         model_0 = modeldata_0.light(this.anInt425 + 64, this.anInt426 + 850, -30, -50, -30);
         aNodeCache6.put(model_0, (long)this.id);
      }

      Model model_1;
      if (this.anInt420 != -1 && int_0 != -1) {
         model_1 = ItemLayer.getAnimation(this.anInt420).method916(model_0, int_0);
      } else {
         model_1 = model_0.method1015(true);
      }

      if (this.anInt422 != 128 || this.anInt423 != 128) {
         model_1.method1019(this.anInt422, this.anInt423, this.anInt422);
      }

      if (this.anInt424 != 0) {
         if (this.anInt424 == 90) {
            model_1.method1021();
         }

         if (this.anInt424 == 180) {
            model_1.method1021();
            model_1.method1021();
         }

         if (this.anInt424 == 270) {
            model_1.method1021();
            model_1.method1021();
            model_1.method1021();
         }
      }

      return model_1;
   }

   void decode(Buffer buffer_0) {
      while (true) {
         int int_0 = buffer_0.readUnsignedByte();
         if (int_0 == 0) {
            return;
         }

         this.method762(buffer_0, int_0);
      }
   }

   static void method764(int int_0, int int_1, int int_2, int int_3) {
      ++Client.anInt664;
      if (Class4.localPlayer.x >> 7 == Client.destinationX && Class4.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

      Class67.method413(Class4.localPlayer, false);
      if (Client.anInt667 >= 0 && Client.cachedPlayers[Client.anInt667] != null) {
         Class67.method413(Client.cachedPlayers[Client.anInt667], false);
      }

      WorldMapData_Sub1.method606(true);
      WorldMapType3.method575();
      WorldMapData_Sub1.method606(false);
      CombatInfoListHolder.method653();
      MouseInput.method583();
      Class65.method402(int_0, int_1, int_2, int_3, true);
      int_0 = Client.anInt679;
      int_1 = Client.anInt680;
      int_2 = Client.viewportHeight;
      int_3 = Client.viewportWidth;
      Rasterizer2D.setDrawRegion(int_0, int_1, int_0 + int_2, int_3 + int_1);
      Graphics3D.method960();
      int int_4;
      int int_5;
      if (!Client.aBool94) {
         int_4 = Client.anInt661;
         if (Client.anInt690 / 256 > int_4) {
            int_4 = Client.anInt690 / 256;
         }

         if (Client.aBoolArray12[4] && Client.anIntArray143[4] + 128 > int_4) {
            int_4 = Client.anIntArray143[4] + 128;
         }

         int_5 = Client.mapAngle & 0x7FF;
         Class36.method251(WorldMapType3.anInt232, Class18.getTileHeight(Class4.localPlayer.x, Class4.localPlayer.y, Ignore.plane) - Client.anInt688, Class9.anInt43, int_4, int_5, int_4 * 3 + 600);
      }

      int int_6;
      int int_7;
      int int_8;
      int int_9;
      int int_10;
      int int_11;
      int int_12;
      int int_13;
      int int_14;
      if (!Client.aBool94) {
         if (Buffer.preferences.hideRoofs) {
            int_5 = Ignore.plane;
         } else {
            label498: {
               int_6 = 3;
               if (AClass1.cameraPitch < 310) {
                  int_7 = Class2.cameraX >> 7;
                  int_8 = Player.cameraY >> 7;
                  int_9 = Class4.localPlayer.x >> 7;
                  int_10 = Class4.localPlayer.y >> 7;
                  if (int_7 < 0 || int_8 < 0 || int_7 >= 104 || int_8 >= 104) {
                     int_5 = Ignore.plane;
                     break label498;
                  }

                  if ((Class19.tileSettings[Ignore.plane][int_7][int_8] & 0x4) != 0) {
                     int_6 = Ignore.plane;
                  }

                  if (int_9 > int_7) {
                     int_11 = int_9 - int_7;
                  } else {
                     int_11 = int_7 - int_9;
                  }

                  if (int_10 > int_8) {
                     int_12 = int_10 - int_8;
                  } else {
                     int_12 = int_8 - int_10;
                  }

                  if (int_11 > int_12) {
                     int_13 = int_12 * 65536 / int_11;
                     int_14 = 32768;

                     while (int_9 != int_7) {
                        if (int_7 < int_9) {
                           ++int_7;
                        } else if (int_7 > int_9) {
                           --int_7;
                        }

                        if ((Class19.tileSettings[Ignore.plane][int_7][int_8] & 0x4) != 0) {
                           int_6 = Ignore.plane;
                        }

                        int_14 += int_13;
                        if (int_14 >= 65536) {
                           int_14 -= 65536;
                           if (int_8 < int_10) {
                              ++int_8;
                           } else if (int_8 > int_10) {
                              --int_8;
                           }

                           if ((Class19.tileSettings[Ignore.plane][int_7][int_8] & 0x4) != 0) {
                              int_6 = Ignore.plane;
                           }
                        }
                     }
                  } else {
                     int_13 = int_11 * 65536 / int_12;
                     int_14 = 32768;

                     while (int_10 != int_8) {
                        if (int_8 < int_10) {
                           ++int_8;
                        } else if (int_8 > int_10) {
                           --int_8;
                        }

                        if ((Class19.tileSettings[Ignore.plane][int_7][int_8] & 0x4) != 0) {
                           int_6 = Ignore.plane;
                        }

                        int_14 += int_13;
                        if (int_14 >= 65536) {
                           int_14 -= 65536;
                           if (int_7 < int_9) {
                              ++int_7;
                           } else if (int_7 > int_9) {
                              --int_7;
                           }

                           if ((Class19.tileSettings[Ignore.plane][int_7][int_8] & 0x4) != 0) {
                              int_6 = Ignore.plane;
                           }
                        }
                     }
                  }
               }

               if (Class4.localPlayer.x >= 0 && Class4.localPlayer.y >= 0 && Class4.localPlayer.x < 13312 && Class4.localPlayer.y < 13312) {
                  if ((Class19.tileSettings[Ignore.plane][Class4.localPlayer.x >> 7][Class4.localPlayer.y >> 7] & 0x4) != 0) {
                     int_6 = Ignore.plane;
                  }

                  int_5 = int_6;
               } else {
                  int_5 = Ignore.plane;
               }
            }
         }

         int_4 = int_5;
      } else {
         int_4 = FileRequest.method815();
      }

      int_5 = Class2.cameraX;
      int_6 = Class18.cameraZ;
      int_7 = Player.cameraY;
      int_8 = AClass1.cameraPitch;
      int_9 = Enum4.cameraYaw;

      for (int_10 = 0; int_10 < 5; int_10++) {
         if (Client.aBoolArray12[int_10]) {
            int_11 = (int)(Math.random() * (double)(Client.anIntArray142[int_10] * 2 + 1) - (double)Client.anIntArray142[int_10] + Math.sin((double)Client.anIntArray144[int_10] / 100.0D * (double)Client.anIntArray145[int_10]) * (double)Client.anIntArray143[int_10]);
            if (int_10 == 0) {
               Class2.cameraX += int_11;
            }

            if (int_10 == 1) {
               Class18.cameraZ += int_11;
            }

            if (int_10 == 2) {
               Player.cameraY += int_11;
            }

            if (int_10 == 3) {
               Enum4.cameraYaw = int_11 + Enum4.cameraYaw & 0x7FF;
            }

            if (int_10 == 4) {
               AClass1.cameraPitch += int_11;
               if (AClass1.cameraPitch < 128) {
                  AClass1.cameraPitch = 128;
               }

               if (AClass1.cameraPitch > 383) {
                  AClass1.cameraPitch = 383;
               }
            }
         }
      }

      int_10 = MouseInput.anInt260;
      int_11 = MouseInput.anInt262;
      if (MouseInput.anInt259 != 0) {
         int_10 = MouseInput.anInt264;
         int_11 = MouseInput.anInt265;
      }

      if (int_10 >= int_0 && int_10 < int_0 + int_2 && int_11 >= int_1 && int_11 < int_3 + int_1) {
         int_12 = int_10 - int_0;
         int_13 = int_11 - int_1;
         Class54.anInt138 = int_12;
         Class54.anInt139 = int_13;
         Class54.aBool21 = true;
         Class54.anInt140 = 0;
         Class54.aBool22 = false;
      } else {
         Class67.method414();
      }

      Enum2.method642();
      Rasterizer2D.method919(int_0, int_1, int_2, int_3, 0);
      Enum2.method642();
      int_12 = Graphics3D.anInt543;
      Graphics3D.anInt543 = Client.scale;
      Class23.region.draw(Class2.cameraX, Class18.cameraZ, Player.cameraY, AClass1.cameraPitch, Enum4.cameraYaw, int_4);
      Class44.method273();
      Graphics3D.anInt543 = int_12;
      Enum2.method642();
      Class23.region.clearEntities();
      Client.anInt691 = 0;
      boolean bool_1 = false;
      int_14 = -1;
      int int_15 = Class27.localPlayerIndexCount;
      int[] ints_0 = Class27.localPlayerIndices;

      int int_16;
      for (int_16 = 0; int_16 < int_15 + Client.npcIndexesCount; int_16++) {
         Object object_0;
         if (int_16 < int_15) {
            object_0 = Client.cachedPlayers[ints_0[int_16]];
            if (ints_0[int_16] == Client.anInt667) {
               bool_1 = true;
               int_14 = int_16;
               continue;
            }
         } else {
            object_0 = Client.cachedNPCs[Client.npcIndices[int_16 - int_15]];
         }

         Class26.method224((Actor) object_0, int_16, int_0, int_1, int_2, int_3);
      }

      if (bool_1) {
         Class26.method224(Client.cachedPlayers[Client.anInt667], int_14, int_0, int_1, int_2, int_3);
      }

      for (int_16 = 0; int_16 < Client.anInt691; int_16++) {
         int int_17 = Client.anIntArray159[int_16];
         int int_18 = Client.anIntArray160[int_16];
         int int_19 = Client.anIntArray162[int_16];
         int int_20 = Client.anIntArray161[int_16];
         boolean bool_0 = true;

         while (bool_0) {
            bool_0 = false;

            for (int int_21 = 0; int_21 < int_16; int_21++) {
               if (int_18 + 2 > Client.anIntArray160[int_21] - Client.anIntArray161[int_21] && int_18 - int_20 < Client.anIntArray160[int_21] + 2 && int_17 - int_19 < Client.anIntArray162[int_21] + Client.anIntArray159[int_21] && int_19 + int_17 > Client.anIntArray159[int_21] - Client.anIntArray162[int_21] && Client.anIntArray160[int_21] - Client.anIntArray161[int_21] < int_18) {
                  int_18 = Client.anIntArray160[int_21] - Client.anIntArray161[int_21];
                  bool_0 = true;
               }
            }
         }

         Client.screenY = Client.anIntArray159[int_16];
         Client.screenX = Client.anIntArray160[int_16] = int_18;
         String string_0 = Client.aStringArray6[int_16];
         if (Client.anInt665 == 0) {
            int int_22 = 16776960;
            if (Client.anIntArray163[int_16] < 6) {
               int_22 = Client.anIntArray168[Client.anIntArray163[int_16]];
            }

            if (Client.anIntArray163[int_16] == 6) {
               int_22 = Client.anInt664 % 20 < 10 ? 16711680 : 16776960;
            }

            if (Client.anIntArray163[int_16] == 7) {
               int_22 = Client.anInt664 % 20 < 10 ? 255 : 65535;
            }

            if (Client.anIntArray163[int_16] == 8) {
               int_22 = Client.anInt664 % 20 < 10 ? 45056 : 8454016;
            }

            int int_23;
            if (Client.anIntArray163[int_16] == 9) {
               int_23 = 150 - Client.anIntArray167[int_16];
               if (int_23 < 50) {
                  int_22 = int_23 * 1280 + 16711680;
               } else if (int_23 < 100) {
                  int_22 = 16776960 - (int_23 - 50) * 327680;
               } else if (int_23 < 150) {
                  int_22 = (int_23 - 100) * 5 + 65280;
               }
            }

            if (Client.anIntArray163[int_16] == 10) {
               int_23 = 150 - Client.anIntArray167[int_16];
               if (int_23 < 50) {
                  int_22 = int_23 * 5 + 16711680;
               } else if (int_23 < 100) {
                  int_22 = 16711935 - (int_23 - 50) * 327680;
               } else if (int_23 < 150) {
                  int_22 = (int_23 - 100) * 327680 + 255 - (int_23 - 100) * 5;
               }
            }

            if (Client.anIntArray163[int_16] == 11) {
               int_23 = 150 - Client.anIntArray167[int_16];
               if (int_23 < 50) {
                  int_22 = 16777215 - int_23 * 327685;
               } else if (int_23 < 100) {
                  int_22 = (int_23 - 50) * 327685 + 65280;
               } else if (int_23 < 150) {
                  int_22 = 16777215 - (int_23 - 100) * 327680;
               }
            }

            if (Client.anIntArray165[int_16] == 0) {
               Class50.aFont3.method1039(string_0, int_0 + Client.screenY, Client.screenX + int_1, int_22, 0);
            }

            if (Client.anIntArray165[int_16] == 1) {
               Class50.aFont3.method1042(string_0, int_0 + Client.screenY, Client.screenX + int_1, int_22, 0, Client.anInt664);
            }

            if (Client.anIntArray165[int_16] == 2) {
               Class50.aFont3.method1043(string_0, int_0 + Client.screenY, Client.screenX + int_1, int_22, 0, Client.anInt664);
            }

            if (Client.anIntArray165[int_16] == 3) {
               Class50.aFont3.method1044(string_0, int_0 + Client.screenY, Client.screenX + int_1, int_22, 0, Client.anInt664, 150 - Client.anIntArray167[int_16]);
            }

            if (Client.anIntArray165[int_16] == 4) {
               int_23 = (150 - Client.anIntArray167[int_16]) * (Class50.aFont3.method1030(string_0) + 100) / 150;
               Rasterizer2D.setInnerDrawRegion(int_0 + Client.screenY - 50, int_1, int_0 + Client.screenY + 50, int_3 + int_1);
               Class50.aFont3.method1040(string_0, int_0 + Client.screenY + 50 - int_23, Client.screenX + int_1, int_22, 0);
               Rasterizer2D.setDrawRegion(int_0, int_1, int_0 + int_2, int_3 + int_1);
            }

            if (Client.anIntArray165[int_16] == 5) {
               int_23 = 150 - Client.anIntArray167[int_16];
               int int_24 = 0;
               if (int_23 < 25) {
                  int_24 = int_23 - 25;
               } else if (int_23 > 125) {
                  int_24 = int_23 - 125;
               }

               Rasterizer2D.setInnerDrawRegion(int_0, Client.screenX + int_1 - Class50.aFont3.verticalSpace - 1, int_0 + int_2, Client.screenX + int_1 + 5);
               Class50.aFont3.method1039(string_0, int_0 + Client.screenY, int_24 + Client.screenX + int_1, int_22, 0);
               Rasterizer2D.setDrawRegion(int_0, int_1, int_0 + int_2, int_3 + int_1);
            }
         } else {
            Class50.aFont3.method1039(string_0, int_0 + Client.screenY, Client.screenX + int_1, 16776960, 0);
         }
      }

      if (Client.hintArrowTargetType == 2) {
         Class35.method245((Client.hintArrowX - ItemLayer.baseX << 7) + Client.hintArrowOffsetX, (Client.hintArrowY - ItemLayer.baseY << 7) + Client.hintArrowOffsetY, Client.hintArrowType * 2);
         if (Client.screenY > -1 && Client.gameCycle % 20 < 10) {
            Class85.headIconsHint[0].drawAt(int_0 + Client.screenY - 12, Client.screenX + int_1 - 28);
         }
      }

      ((TextureProvider) Graphics3D.textureLoader).method569(Client.anInt625);
      if (Client.cursorState == 1) {
         CombatInfoListHolder.aSpritePixelsArray2[Client.anInt645 / 100].drawAt(Client.anInt641 - 8, Client.anInt642 - 8);
      }

      if (Client.cursorState == 2) {
         CombatInfoListHolder.aSpritePixelsArray2[Client.anInt645 / 100 + 4].drawAt(Client.anInt641 - 8, Client.anInt642 - 8);
      }

      WorldMapData.method306();
      Class2.cameraX = int_5;
      Class18.cameraZ = int_6;
      Player.cameraY = int_7;
      AClass1.cameraPitch = int_8;
      Enum4.cameraYaw = int_9;
      if (Client.aBool88 && Enum6.method702(true, false) == 0) {
         Client.aBool88 = false;
      }

      if (Client.aBool88) {
         Rasterizer2D.method919(int_0, int_1, int_2, int_3, 0);
         Class68_Sub1.drawStatusBox("Loading - please wait.", false);
      }

   }

}
