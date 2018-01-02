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
         this.anInt421 = buffer_0.getUnsignedShort();
      } else if (int_0 == 2) {
         this.anInt420 = buffer_0.getUnsignedShort();
      } else if (int_0 == 4) {
         this.anInt422 = buffer_0.getUnsignedShort();
      } else if (int_0 == 5) {
         this.anInt423 = buffer_0.getUnsignedShort();
      } else if (int_0 == 6) {
         this.anInt424 = buffer_0.getUnsignedShort();
      } else if (int_0 == 7) {
         this.anInt425 = buffer_0.getUnsignedByte();
      } else if (int_0 == 8) {
         this.anInt426 = buffer_0.getUnsignedByte();
      } else {
         int int_1;
         int int_2;
         if (int_0 == 40) {
            int_1 = buffer_0.getUnsignedByte();
            this.aShortArray6 = new short[int_1];
            this.aShortArray8 = new short[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
               this.aShortArray6[int_2] = (short)buffer_0.getUnsignedShort();
               this.aShortArray8[int_2] = (short)buffer_0.getUnsignedShort();
            }
         } else if (int_0 == 41) {
            int_1 = buffer_0.getUnsignedByte();
            this.aShortArray7 = new short[int_1];
            this.aShortArray9 = new short[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
               this.aShortArray7[int_2] = (short)buffer_0.getUnsignedShort();
               this.aShortArray9[int_2] = (short)buffer_0.getUnsignedShort();
            }
         }
      }

   }

   public Model method763(int int_0) {
      Model model_0 = (Model) aNodeCache6.get((long)this.id);
      if (model_0 == null) {
         ModelHeader modeldata_0 = ModelHeader.getModel(anIndexDataBase14, this.anInt421, 0);
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
               modeldata_0.retexture(this.aShortArray7[int_1], this.aShortArray9[int_1]);
            }
         }

         model_0 = modeldata_0.applyLighting(this.anInt425 + 64, this.anInt426 + 850, -30, -50, -30);
         aNodeCache6.put(model_0, (long)this.id);
      }

      Model model_1;
      if (this.anInt420 != -1 && int_0 != -1) {
         model_1 = ItemLayer.getAnimation(this.anInt420).method916(model_0, int_0);
      } else {
         model_1 = model_0.replaceMoreAlphaValues(true);
      }

      if (this.anInt422 != 128 || this.anInt423 != 128) {
         model_1.scaleTriangle(this.anInt422, this.anInt423, this.anInt422);
      }

      if (this.anInt424 != 0) {
         if (this.anInt424 == 90) {
            model_1.rotate90Degrees();
         }

         if (this.anInt424 == 180) {
            model_1.rotate90Degrees();
            model_1.rotate90Degrees();
         }

         if (this.anInt424 == 270) {
            model_1.rotate90Degrees();
            model_1.rotate90Degrees();
            model_1.rotate90Degrees();
         }
      }

      return model_1;
   }

   void decode(Buffer buffer_0) {
      while (true) {
         int int_0 = buffer_0.getUnsignedByte();
         if (int_0 == 0) {
            return;
         }

         this.method762(buffer_0, int_0);
      }
   }

   static void method764(int textDrawX, int textDrawY, int drawWidth, int drawHeight) {
      ++Client.renderCycle;
      if (Class4.localPlayer.x >> 7 == Client.destinationX && Class4.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

      Class67.method413(Class4.localPlayer, false);
      if (Client.someSelectedPlayerIndex >= 0 && Client.players[Client.someSelectedPlayerIndex] != null) {
         Class67.method413(Client.players[Client.someSelectedPlayerIndex], false);
      }

      WorldMapData_Sub1.method606(true);
      WorldMapType3.method575();
      WorldMapData_Sub1.method606(false);
      CombatInfoListHolder.method653();
      MouseInput.method583();
      Class65.method402(textDrawX, textDrawY, drawWidth, drawHeight, true);
      textDrawX = Client.anInt679;
      textDrawY = Client.anInt680;
      drawWidth = Client.viewportHeight;
      drawHeight = Client.viewportWidth;
      Rasterizer2D.setDrawRegion(textDrawX, textDrawY, textDrawX + drawWidth, drawHeight + textDrawY);
      Rasterizer3D.resetRasterClipping();
      int int_4;
      int camPosX;
      if (!Client.aBool94) {
         int_4 = Client.anInt661;
         if (Client.anInt690 / 256 > int_4) {
            int_4 = Client.anInt690 / 256;
         }

         if (Client.cameraAntibanAction[4] && Client.cameraAntibanAngleOffsets[4] + 128 > int_4) {
            int_4 = Client.cameraAntibanAngleOffsets[4] + 128;
         }

         camPosX = Client.mapAngle & 0x7FF;
         Class36.method251(WorldMapType3.anInt232, Class18.getTileHeight(Class4.localPlayer.x, Class4.localPlayer.y, Ignore.plane) - Client.anInt688, Class9.anInt43, int_4, camPosX, int_4 * 3 + 600);
      }

      int camPosZ;
      int camPosY;
      int camPitch;
      int camYaw;
      int type;
      int offset;
      int int_12;
      int int_13;
      int int_14;
      if (!Client.aBool94) {
         if (Buffer.preferences.hideRoofs) {
            camPosX = Ignore.plane;
         } else {
            label498: {
               camPosZ = 3;
               if (AClass1.cameraPitch < 310) {
                  camPosY = Class2.cameraX >> 7;
                  camPitch = Player.cameraY >> 7;
                  camYaw = Class4.localPlayer.x >> 7;
                  type = Class4.localPlayer.y >> 7;
                  if (camPosY < 0 || camPitch < 0 || camPosY >= 104 || camPitch >= 104) {
                     camPosX = Ignore.plane;
                     break label498;
                  }

                  if ((Region.renderRuleFlags[Ignore.plane][camPosY][camPitch] & 0x4) != 0) {
                     camPosZ = Ignore.plane;
                  }

                  if (camYaw > camPosY) {
                     offset = camYaw - camPosY;
                  } else {
                     offset = camPosY - camYaw;
                  }

                  if (type > camPitch) {
                     int_12 = type - camPitch;
                  } else {
                     int_12 = camPitch - type;
                  }

                  if (offset > int_12) {
                     int_13 = int_12 * 65536 / offset;
                     int_14 = 32768;

                     while (camYaw != camPosY) {
                        if (camPosY < camYaw) {
                           ++camPosY;
                        } else if (camPosY > camYaw) {
                           --camPosY;
                        }

                        if ((Region.renderRuleFlags[Ignore.plane][camPosY][camPitch] & 0x4) != 0) {
                           camPosZ = Ignore.plane;
                        }

                        int_14 += int_13;
                        if (int_14 >= 65536) {
                           int_14 -= 65536;
                           if (camPitch < type) {
                              ++camPitch;
                           } else if (camPitch > type) {
                              --camPitch;
                           }

                           if ((Region.renderRuleFlags[Ignore.plane][camPosY][camPitch] & 0x4) != 0) {
                              camPosZ = Ignore.plane;
                           }
                        }
                     }
                  } else {
                     int_13 = offset * 65536 / int_12;
                     int_14 = 32768;

                     while (type != camPitch) {
                        if (camPitch < type) {
                           ++camPitch;
                        } else if (camPitch > type) {
                           --camPitch;
                        }

                        if ((Region.renderRuleFlags[Ignore.plane][camPosY][camPitch] & 0x4) != 0) {
                           camPosZ = Ignore.plane;
                        }

                        int_14 += int_13;
                        if (int_14 >= 65536) {
                           int_14 -= 65536;
                           if (camPosY < camYaw) {
                              ++camPosY;
                           } else if (camPosY > camYaw) {
                              --camPosY;
                           }

                           if ((Region.renderRuleFlags[Ignore.plane][camPosY][camPitch] & 0x4) != 0) {
                              camPosZ = Ignore.plane;
                           }
                        }
                     }
                  }
               }

               if (Class4.localPlayer.x >= 0 && Class4.localPlayer.y >= 0 && Class4.localPlayer.x < 13312 && Class4.localPlayer.y < 13312) {
                  if ((Region.renderRuleFlags[Ignore.plane][Class4.localPlayer.x >> 7][Class4.localPlayer.y >> 7] & 0x4) != 0) {
                     camPosZ = Ignore.plane;
                  }

                  camPosX = camPosZ;
               } else {
                  camPosX = Ignore.plane;
               }
            }
         }

         int_4 = camPosX;
      } else {
         int_4 = FileRequest.method815();
      }

      camPosX = Class2.cameraX;
      camPosZ = Class18.cameraZ;
      camPosY = Player.cameraY;
      camPitch = AClass1.cameraPitch;
      camYaw = Enum4.cameraYaw;

      for (type = 0; type < 5; type++) {
         if (Client.cameraAntibanAction[type]) {
            offset = (int)(Math.random() * (double)(Client.cameraAntibanCurveXOffsets[type] * 2 + 1) - (double)Client.cameraAntibanCurveXOffsets[type] + Math.sin((double)Client.cameraAntibanAngleMultiplierOffsets[type] / 100.0D * (double)Client.cameraAntibanCurveYOffsets[type]) * (double)Client.cameraAntibanAngleOffsets[type]);
            if (type == 0) {
               Class2.cameraX += offset;
            }

            if (type == 1) {
               Class18.cameraZ += offset;
            }

            if (type == 2) {
               Player.cameraY += offset;
            }

            if (type == 3) {
               Enum4.cameraYaw = offset + Enum4.cameraYaw & 0x7FF;
            }

            if (type == 4) {
               AClass1.cameraPitch += offset;
               if (AClass1.cameraPitch < 128) {
                  AClass1.cameraPitch = 128;
               }

               if (AClass1.cameraPitch > 383) {
                  AClass1.cameraPitch = 383;
               }
            }
         }
      }

      type = MouseInput.mouseEventX;
      offset = MouseInput.mouseEventY;
      if (MouseInput.anInt259 != 0) {
         type = MouseInput.anInt264;
         offset = MouseInput.anInt265;
      }

      if (type >= textDrawX && type < textDrawX + drawWidth && offset >= textDrawY && offset < drawHeight + textDrawY) {
         int_12 = type - textDrawX;
         int_13 = offset - textDrawY;
         Class54.anInt138 = int_12;
         Class54.anInt139 = int_13;
         Class54.aBool21 = true;
         Class54.anInt140 = 0;
         Class54.aBool22 = false;
      } else {
         Class67.method414();
      }

      Enum2.reloadSound();
      Rasterizer2D.fillRect(textDrawX, textDrawY, drawWidth, drawHeight, 0);
      Enum2.reloadSound();
      int_12 = Rasterizer3D.anInt543;
      Rasterizer3D.anInt543 = Client.scale;
      Class23.sceneGraph.draw(Class2.cameraX, Class18.cameraZ, Player.cameraY, AClass1.cameraPitch, Enum4.cameraYaw, int_4);
      Class44.method273();
      Rasterizer3D.anInt543 = int_12;
      Enum2.reloadSound();
      Class23.sceneGraph.clearInteractiveObjectCache();
      Client.lastTextMessageIndex = 0;
      boolean playerFound = false;
      int_14 = -1;
      int playerCount = Class27.localPlayerIndexCount;
      int[] playerIndices = Class27.localPlayerIndices;

      int index;
      for (index = 0; index < playerCount + Client.npcIndexesCount; index++) {
         Object object_0;
         if (index < playerCount) {
            object_0 = Client.players[playerIndices[index]];
            if (playerIndices[index] == Client.someSelectedPlayerIndex) {
               playerFound = true;
               int_14 = index;
               continue;
            }
         } else {
            object_0 = Client.cachedNPCs[Client.npcIndices[index - playerCount]];
         }

         Class26.drawActorOverlays((Actor) object_0, index, textDrawX, textDrawY, drawWidth, drawHeight);
      }

      if (playerFound) {
         Class26.drawActorOverlays(Client.players[Client.someSelectedPlayerIndex], int_14, textDrawX, textDrawY, drawWidth, drawHeight);
      }

      for (index = 0; index < Client.lastTextMessageIndex; index++) {
         int x = Client.textRenderPointsX[index];
         int y = Client.textRenderPointsY[index];
         int width = Client.textWidths[index];
         int height = Client.textHeights[index];
         boolean needsWaveApplied = true;

         while (needsWaveApplied) {
            needsWaveApplied = false;

            for (int waveIndex = 0; waveIndex < index; waveIndex++) {
               if (y + 2 > Client.textRenderPointsY[waveIndex] - Client.textHeights[waveIndex] && y - height < Client.textRenderPointsY[waveIndex] + 2 && x - width < Client.textWidths[waveIndex] + Client.textRenderPointsX[waveIndex] && width + x > Client.textRenderPointsX[waveIndex] - Client.textWidths[waveIndex] && Client.textRenderPointsY[waveIndex] - Client.textHeights[waveIndex] < y) {
                  y = Client.textRenderPointsY[waveIndex] - Client.textHeights[waveIndex];
                  needsWaveApplied = true;
               }
            }
         }

         Client.screenY = Client.textRenderPointsX[index];
         Client.screenX = Client.textRenderPointsY[index] = y;
         String chatMessage = Client.textSpokenMessages[index];
         if (Client.iconSettingValue == 0) {
            int textColour = 16776960;
            if (Client.textColourEffect[index] < 6) {
               textColour = Client.anIntArray168[Client.textColourEffect[index]];
            }

            if (Client.textColourEffect[index] == 6) {
               textColour = Client.renderCycle % 20 < 10 ? 16711680 : 16776960;
            }

            if (Client.textColourEffect[index] == 7) {
               textColour = Client.renderCycle % 20 < 10 ? 255 : 65535;
            }

            if (Client.textColourEffect[index] == 8) {
               textColour = Client.renderCycle % 20 < 10 ? 45056 : 8454016;
            }

            int cycle;
            if (Client.textColourEffect[index] == 9) {
               cycle = 150 - Client.textCycles[index];
               if (cycle < 50) {
                  textColour = cycle * 1280 + 16711680;
               } else if (cycle < 100) {
                  textColour = 16776960 - (cycle - 50) * 327680;
               } else if (cycle < 150) {
                  textColour = (cycle - 100) * 5 + 65280;
               }
            }

            if (Client.textColourEffect[index] == 10) {
               cycle = 150 - Client.textCycles[index];
               if (cycle < 50) {
                  textColour = cycle * 5 + 16711680;
               } else if (cycle < 100) {
                  textColour = 16711935 - (cycle - 50) * 327680;
               } else if (cycle < 150) {
                  textColour = (cycle - 100) * 327680 + 255 - (cycle - 100) * 5;
               }
            }

            if (Client.textColourEffect[index] == 11) {
               cycle = 150 - Client.textCycles[index];
               if (cycle < 50) {
                  textColour = 16777215 - cycle * 327685;
               } else if (cycle < 100) {
                  textColour = (cycle - 50) * 327685 + 65280;
               } else if (cycle < 150) {
                  textColour = 16777215 - (cycle - 100) * 327680;
               }
            }

            if (Client.textEffects[index] == 0) {
               Class50.boldFont.drawStringCentred(chatMessage, textDrawX + Client.screenY, Client.screenX + textDrawY, textColour, 0);
            }

            if (Client.textEffects[index] == 1) {
               Class50.boldFont.drawHorizontalStringWave(chatMessage, textDrawX + Client.screenY, Client.screenX + textDrawY, textColour, 0, Client.renderCycle);
            }

            if (Client.textEffects[index] == 2) {
               Class50.boldFont.drawVerticalStringWave(chatMessage, textDrawX + Client.screenY, Client.screenX + textDrawY, textColour, 0, Client.renderCycle);
            }

            if (Client.textEffects[index] == 3) {
               Class50.boldFont.drawHorizonalStringMovingWave(chatMessage, textDrawX + Client.screenY, Client.screenX + textDrawY, textColour, 0, Client.renderCycle, 150 - Client.textCycles[index]);
            }

            if (Client.textEffects[index] == 4) {
               cycle = (150 - Client.textCycles[index]) * (Class50.boldFont.getWidth(chatMessage) + 100) / 150;
               Rasterizer2D.setInnerDrawRegion(textDrawX + Client.screenY - 50, textDrawY, textDrawX + Client.screenY + 50, drawHeight + textDrawY);
               Class50.boldFont.drawString(chatMessage, textDrawX + Client.screenY + 50 - cycle, Client.screenX + textDrawY, textColour, 0);
               Rasterizer2D.setDrawRegion(textDrawX, textDrawY, textDrawX + drawWidth, drawHeight + textDrawY);
            }

            if (Client.textEffects[index] == 5) {
               cycle = 150 - Client.textCycles[index];
               int int_24 = 0;
               if (cycle < 25) {
                  int_24 = cycle - 25;
               } else if (cycle > 125) {
                  int_24 = cycle - 125;
               }

               Rasterizer2D.setInnerDrawRegion(textDrawX, Client.screenX + textDrawY - Class50.boldFont.verticalSpace - 1, textDrawX + drawWidth, Client.screenX + textDrawY + 5);
               Class50.boldFont.drawStringCentred(chatMessage, textDrawX + Client.screenY, int_24 + Client.screenX + textDrawY, textColour, 0);
               Rasterizer2D.setDrawRegion(textDrawX, textDrawY, textDrawX + drawWidth, drawHeight + textDrawY);
            }
         } else {
            Class50.boldFont.drawStringCentred(chatMessage, textDrawX + Client.screenY, Client.screenX + textDrawY, 16776960, 0);
         }
      }

      if (Client.hintArrowTargetType == 2) {
         Class35.method245((Client.hintArrowX - Client.regionBaseX << 7) + Client.hintArrowOffsetX, (Client.hintArrowY - Client.regionBaseY << 7) + Client.hintArrowOffsetY, Client.hintArrowType * 2);
         if (Client.screenY > -1 && Client.gameCycle % 20 < 10) {
            Class85.headIconsHint[0].drawAt(textDrawX + Client.screenY - 12, Client.screenX + textDrawY - 28);
         }
      }

      ((TextureProvider) Rasterizer3D.textureLoader).method569(Client.anInt625);
      if (Client.cursorState == 1) {
         CombatInfoListHolder.aSpritePixelsArray2[Client.anInt645 / 100].drawAt(Client.anInt641 - 8, Client.anInt642 - 8);
      }

      if (Client.cursorState == 2) {
         CombatInfoListHolder.aSpritePixelsArray2[Client.anInt645 / 100 + 4].drawAt(Client.anInt641 - 8, Client.anInt642 - 8);
      }

      WorldMapData.isOnTutorialIsland();
      Class2.cameraX = camPosX;
      Class18.cameraZ = camPosZ;
      Player.cameraY = camPosY;
      AClass1.cameraPitch = camPitch;
      Enum4.cameraYaw = camYaw;
      if (Client.loginScreenShown && Enum6.method702(true, false) == 0) {
         Client.loginScreenShown = false;
      }

      if (Client.loginScreenShown) {
         Rasterizer2D.fillRect(textDrawX, textDrawY, drawWidth, drawHeight, 0);
         Client.drawStatusBox("Loading - please wait.", false);
      }
   }

}
