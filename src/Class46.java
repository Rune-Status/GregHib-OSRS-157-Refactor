import java.io.IOException;

public class Class46 {

   RSSocket rssocket;
   CombatInfoList aCombatInfoList2;
   PacketBuffer aPacketBuffer1;
   int anInt102;
   Buffer aBuffer3;
   ServerPacket serverPacket;
   boolean aBool18;
   int packetLength;
   ServerPacket aServerPacket1;
   int anInt103;
   ServerPacket aServerPacket2;
   int anInt104;
   ServerPacket aServerPacket3;
   public IsaacCipher cipher;

   Class46() {
      this.aCombatInfoList2 = new CombatInfoList();
      this.anInt102 = 0;
      this.aBuffer3 = new Buffer(5000);
      this.aPacketBuffer1 = new PacketBuffer(40000);
      this.serverPacket = null;
      this.packetLength = 0;
      this.aBool18 = true;
      this.anInt103 = 0;
      this.anInt104 = 0;
   }

   static IndexData openCacheIndex(int id, boolean bool_0, boolean bool_1, boolean bool_2) {
      IndexFile indexFile = null;
      if (Class64.aCacheFile2 != null) {
         indexFile = new IndexFile(id, Class64.aCacheFile2, Class64.aCacheFileArray1[id], 1000000);
      }

      return new IndexData(indexFile, MilliTimer.anIndexFile3, id, bool_0, bool_1, bool_2);
   }

   RSSocket createSocket() {
      return this.rssocket;
   }

   void method278() {
      if (this.rssocket != null) {
         this.rssocket.close();
         this.rssocket = null;
      }

   }

   void method279() {
      this.rssocket = null;
   }

   void method280() {
      this.aCombatInfoList2.method453();
      this.anInt102 = 0;
   }

   void method281(RSSocket rssocket_0) {
      this.rssocket = rssocket_0;
   }

   public void method282(PacketNode packet) {
      this.aCombatInfoList2.method455(packet);
      packet.anInt349 = packet.packetBuffer.position;
      packet.packetBuffer.position = 0;
      this.anInt102 += packet.anInt349;
   }

   void method283() throws IOException {
      if (this.rssocket != null && this.anInt102 > 0) {
         this.aBuffer3.position = 0;

         while (true) {
            PacketNode packetnode_0 = (PacketNode) this.aCombatInfoList2.method454();
            if (packetnode_0 == null || packetnode_0.anInt349 > this.aBuffer3.buffer.length - this.aBuffer3.position) {
               this.rssocket.queueForWrite(this.aBuffer3.buffer, 0, this.aBuffer3.position);
               this.anInt104 = 0;
               break;
            }

            this.aBuffer3.putBytes(packetnode_0.packetBuffer.buffer, 0, packetnode_0.anInt349);
            this.anInt102 -= packetnode_0.anInt349;
            packetnode_0.unlink();
            packetnode_0.packetBuffer.method733();
            packetnode_0.method678();
         }
      }

   }

   static void load() {
      int index;
      if (Client.loadingStage == 0) {
         Class23.sceneGraph = new SceneGraph(4, 104, 104, Region.tileHeightArray);

         for (index = 0; index < 4; index++) {
            Client.collisionMaps[index] = new CollisionMap(104, 104);
         }

         Class15.spritePixels = new SpritePixels(512, 512);
         Class25.loadingText = "Starting game engine...";
         Class25.loadingBarPercentage = 5;
         Client.loadingStage = 20;
      } else {
         int int_1;
         int int_2;
         int int_3;
         int int_4;
         if (Client.loadingStage == 20) {
            int[] ints_0 = new int[9];

            for (int_1 = 0; int_1 < 9; int_1++) {
               int_2 = int_1 * 32 + 15 + 128;
               int_3 = int_2 * 3 + 600;
               int_4 = Rasterizer3D.SINE[int_2];
               ints_0[int_1] = int_3 * int_4 >> 16;
            }

            SceneGraph.method383(ints_0, 500, 800, 512, 334);
            Class25.loadingText = "Prepared visibility map";
            Class25.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         } else if (Client.loadingStage == 30) {
            Varcs.interfacesIndex = openCacheIndex(0, false, true, true);
            Class6.skinsIndex = openCacheIndex(1, false, true, true);
            GrandExchangeOffer.configsIndex = openCacheIndex(2, true, false, true);
            Class56.interfaceDataIndex = openCacheIndex(3, false, true, true);
            Tile.soundEffectsIndex = openCacheIndex(4, false, true, true);
            Class23.mapsIndex = openCacheIndex(5, true, true, true);
            Class38.songsIndex = openCacheIndex(6, true, true, false);
            Class4.modelsIndex = openCacheIndex(7, false, true, true);
            Class34.spritesIndex = openCacheIndex(8, false, true, true);
            Class49.texturesIndex = openCacheIndex(9, false, true, true);
            AbstractSoundSystem.wordPackIndex = openCacheIndex(10, false, true, true);
            Class92.musicConfigIndex = openCacheIndex(11, false, true, true);
            Class3.interfaceScriptDataIndex = openCacheIndex(12, false, true, true);
            Enum1.fontConfigIndex = openCacheIndex(13, true, false, true);
            WorldMapType2.vorbisIndex = openCacheIndex(14, false, true, false);
            Class61.trackIndex = openCacheIndex(15, false, true, true);
            RSCanvas.worldMapIndex = openCacheIndex(16, false, true, false);
            Class25.loadingText = "Connecting to update server";
            Class25.loadingBarPercentage = 20;
            Client.loadingStage = 40;
         } else if (Client.loadingStage == 40) {
            byte byte_1 = 0;
            index = byte_1 + Varcs.interfacesIndex.percentage() * 4 / 100;
            index += Class6.skinsIndex.percentage() * 4 / 100;
            index += GrandExchangeOffer.configsIndex.percentage() * 2 / 100;
            index += Class56.interfaceDataIndex.percentage() * 2 / 100;
            index += Tile.soundEffectsIndex.percentage() * 6 / 100;
            index += Class23.mapsIndex.percentage() * 4 / 100;
            index += Class38.songsIndex.percentage() * 2 / 100;
            index += Class4.modelsIndex.percentage() * 58 / 100;
            index += Class34.spritesIndex.percentage() * 2 / 100;
            index += Class49.texturesIndex.percentage() * 2 / 100;
            index += AbstractSoundSystem.wordPackIndex.percentage() * 2 / 100;
            index += Class92.musicConfigIndex.percentage() * 2 / 100;
            index += Class3.interfaceScriptDataIndex.percentage() * 2 / 100;
            index += Enum1.fontConfigIndex.percentage() * 2 / 100;
            index += WorldMapType2.vorbisIndex.percentage() * 2 / 100;
            index += Class61.trackIndex.percentage() * 2 / 100;
            index += RSCanvas.worldMapIndex.percentage() * 2 / 100;
            if (index != 100) {
               if (index != 0) {
                  Class25.loadingText = "Checking for updates - " + index + "%";
               }

               Class25.loadingBarPercentage = 30;
            } else {
               Class25.loadingText = "Loaded update list";
               Class25.loadingBarPercentage = 30;
               Client.loadingStage = 45;
            }
         } else if (Client.loadingStage == 45) {
            Class44.method270(22050, !Client.lowMemory, 2);
            AClass6_Sub3 aclass6_sub3_0 = new AClass6_Sub3();
            aclass6_sub3_0.method862(9, 128);
            Class35.soundSystem0 = FrameMap.method689(GameEngine.taskManager, 0, 22050);
            Class35.soundSystem0.method346(aclass6_sub3_0);
            Class41.method262(Class61.trackIndex, WorldMapType2.vorbisIndex, Tile.soundEffectsIndex, aclass6_sub3_0);
            Class47.soundSystem1 = FrameMap.method689(GameEngine.taskManager, 1, 2048);
            Class97.anAClass6_Sub1_1 = new AClass6_Sub1();
            Class47.soundSystem1.method346(Class97.anAClass6_Sub1_1);
            Class87.aClass51_1 = new Class51(22050, AbstractSoundSystem.sampleRate);
            Class25.loadingText = "Prepared sound engine";
            Class25.loadingBarPercentage = 35;
            Client.loadingStage = 50;
            Class1.aClass102_1 = new Class102(Class34.spritesIndex, Enum1.fontConfigIndex);
         } else if (Client.loadingStage == 50) {
            index = Class97.method520().length;
            Client.aHashMap9 = Class1.aClass102_1.method532(Class97.method520());
            if (Client.aHashMap9.size() < index) {
               Class25.loadingText = "Loading fonts - " + Client.aHashMap9.size() * 100 / index + "%";
               Class25.loadingBarPercentage = 40;
            } else {
               Class1.aFont2 = (Font) Client.aHashMap9.get(Class97.aClass97_5);
               Class4.normalFont = (Font) Client.aHashMap9.get(Class97.aClass97_8);
               Class50.boldFont = (Font) Client.aHashMap9.get(Class97.aClass97_9);
               CombatInfo1.aMachineInfo1 = new MachineInfo(true);
               Class25.loadingText = "Loaded fonts";
               Class25.loadingBarPercentage = 40;
               Client.loadingStage = 60;
            }
         } else if (Client.loadingStage == 60) {
            index = Timer.method587(AbstractSoundSystem.wordPackIndex, Class34.spritesIndex);
            byte byte_0 = 11;
            if (index < byte_0) {
               Class25.loadingText = "Loading title screen - " + index * 100 / byte_0 + "%";
               Class25.loadingBarPercentage = 50;
            } else {
               Class25.loadingText = "Loaded title screen";
               Class25.loadingBarPercentage = 50;
               Class110.setGameState(5);
               Client.loadingStage = 70;
            }
         } else if (Client.loadingStage == 70) {
            if (!GrandExchangeOffer.configsIndex.method437()) {
               Class25.loadingText = "Loading config - " + GrandExchangeOffer.configsIndex.method615() + "%";
               Class25.loadingBarPercentage = 60;
            } else {
               Enum5.method700(GrandExchangeOffer.configsIndex);
               IndexData indexdata_21 = GrandExchangeOffer.configsIndex;
               FloorUnderlayDefinition.underlay_ref = indexdata_21;
               IndexData indexdata_0 = GrandExchangeOffer.configsIndex;
               IndexData indexdata_1 = Class4.modelsIndex;
               IdentityKitDefinition.identityKitCacheIndex = indexdata_0;
               IdentityKitDefinition.identityKitModelCacheIndex = indexdata_1;
               IdentityKitDefinition.count = IdentityKitDefinition.identityKitCacheIndex.fileCount(3);
               IndexData indexdata_2 = GrandExchangeOffer.configsIndex;
               IndexData indexdata_3 = Class4.modelsIndex;
               boolean bool_0 = Client.lowMemory;
               ObjectDefinition.objects_ref = indexdata_2;
               ObjectDefinition.modelIndex = indexdata_3;
               ObjectDefinition.lowMemory = bool_0;
               IndexData indexdata_4 = GrandExchangeOffer.configsIndex;
               IndexData indexdata_5 = Class4.modelsIndex;
               NPCDefinition.npcCacheIndex = indexdata_4;
               NPCDefinition.anIndexDataBase28 = indexdata_5;
               AClass1_Sub2.method638(GrandExchangeOffer.configsIndex);
               IndexData indexdata_6 = GrandExchangeOffer.configsIndex;
               IndexData indexdata_7 = Class4.modelsIndex;
               boolean bool_1 = Client.isMembers;
               Font font_0 = Class1.aFont2;
               ItemDefinition.item_ref = indexdata_6;
               ItemDefinition.itemDefinitionIndex = indexdata_7;
               Enum5.isMembersWorld = bool_1;
               ItemDefinition.anInt503 = ItemDefinition.item_ref.fileCount(10);
               ItemDefinition.aFont5 = font_0;
               IndexData indexdata_8 = GrandExchangeOffer.configsIndex;
               IndexData indexdata_9 = Varcs.interfacesIndex;
               IndexData indexdata_10 = Class6.skinsIndex;
               Class35.seq_ref = indexdata_8;
               Sequence.skel_ref = indexdata_9;
               Sequence.skin_ref = indexdata_10;
               Class57.method388(GrandExchangeOffer.configsIndex, Class4.modelsIndex);
               Class28.method231(GrandExchangeOffer.configsIndex);
               IndexData indexdata_11 = GrandExchangeOffer.configsIndex;
               Class11.varplayer_ref = indexdata_11;
               VarPlayerType.varPlayerCount = Class11.varplayer_ref.fileCount(16);
               IndexData indexdata_12 = Class56.interfaceDataIndex;
               IndexData models = Class4.modelsIndex;
               IndexData sprites = Class34.spritesIndex;
               IndexData indexdata_15 = Enum1.fontConfigIndex;
               Class5.widgetIndex = indexdata_12;
               Widget.modelCacheIndex = models;
               Enum1.spriteCacheIndex = sprites;
               Widget.anIndexDataBase11 = indexdata_15;
               Class91.widgets = new Widget[Class5.widgetIndex.size()][];
               AClass3_Sub1.validInterfaces = new boolean[Class5.widgetIndex.size()];
               IndexData indexdata_16 = GrandExchangeOffer.configsIndex;
               InvType.anIndexDataBase16 = indexdata_16;
               IndexData indexdata_17 = GrandExchangeOffer.configsIndex;
               Enum.anIndexDataBase21 = indexdata_17;
               Class80.method471(GrandExchangeOffer.configsIndex);
               Class65.method403(GrandExchangeOffer.configsIndex);
               IndexData indexdata_18 = GrandExchangeOffer.configsIndex;
               CacheableNode_Sub5.anIndexDataBase24 = indexdata_18;
               Class40.chatMessages = new Varcs();
               Friend.method535(GrandExchangeOffer.configsIndex, Class34.spritesIndex, Enum1.fontConfigIndex);
               Class53.method351(GrandExchangeOffer.configsIndex, Class34.spritesIndex);
               IndexData indexdata_19 = GrandExchangeOffer.configsIndex;
               IndexData indexdata_20 = Class34.spritesIndex;
               Area.anIndexDataBase17 = indexdata_20;
               if (indexdata_19.method437()) {
                  Area.anInt442 = indexdata_19.fileCount(35);
                  Area.anAreaArray1 = new Area[Area.anInt442];

                  for (int int_5 = 0; int_5 < Area.anInt442; int_5++) {
                     byte[] bytes_0 = indexdata_19.getConfigData(35, int_5);
                     if (bytes_0 != null) {
                        Area.anAreaArray1[int_5] = new Area(int_5);
                        Area.anAreaArray1[int_5].method813(new Buffer(bytes_0));
                        Area.anAreaArray1[int_5].method814();
                     }
                  }
               }

               Class25.loadingText = "Loaded config";
               Class25.loadingBarPercentage = 60;
               Client.loadingStage = 80;
            }
         } else if (Client.loadingStage == 80) {
            index = 0;
            if (Class35.compass == null) {
               Class35.compass = Class81.method472(Class34.spritesIndex, "compass", "");
            } else {
               ++index;
            }

            if (Class10.mapedge == null) {
               Class10.mapedge = Class81.method472(Class34.spritesIndex, "mapedge", "");
            } else {
               ++index;
            }

            if (BuildType.mapscene == null) {
               BuildType.mapscene = Enum3.method670(Class34.spritesIndex, "mapscene", "");
            } else {
               ++index;
            }

            if (CacheFile.headIconsPk == null) {
               CacheFile.headIconsPk = Buffer.method735(Class34.spritesIndex, "headicons_pk", "");
            } else {
               ++index;
            }

            if (TileStrategy.headIconsPrayer == null) {
               TileStrategy.headIconsPrayer = Buffer.method735(Class34.spritesIndex, "headicons_prayer", "");
            } else {
               ++index;
            }

            if (Class85.headIconsHint == null) {
               Class85.headIconsHint = Buffer.method735(Class34.spritesIndex, "headicons_hint", "");
            } else {
               ++index;
            }

            if (Ignore.mapMarkers == null) {
               Ignore.mapMarkers = Buffer.method735(Class34.spritesIndex, "mapmarker", "");
            } else {
               ++index;
            }

            if (CombatInfoListHolder.aSpritePixelsArray2 == null) {
               CombatInfoListHolder.aSpritePixelsArray2 = Buffer.method735(Class34.spritesIndex, "cross", "");
            } else {
               ++index;
            }

            if (AClass3_Sub1.mapDots == null) {
               AClass3_Sub1.mapDots = Buffer.method735(Class34.spritesIndex, "mapdots", "");
            } else {
               ++index;
            }

            if (Class11.anIndexedSpriteArray2 == null) {
               Class11.anIndexedSpriteArray2 = Enum3.method670(Class34.spritesIndex, "scrollbar", "");
            } else {
               ++index;
            }

            if (Buffer.anIndexedSpriteArray8 == null) {
               Buffer.anIndexedSpriteArray8 = Enum3.method670(Class34.spritesIndex, "mod_icons", "");
            } else {
               ++index;
            }

            if (index < 11) {
               Class25.loadingText = "Loading sprites - " + index * 100 / 12 + "%";
               Class25.loadingBarPercentage = 70;
            } else {
               FontTypeFace.modIcons = Buffer.anIndexedSpriteArray8;
               Class10.mapedge.refreshDimensions();
               int_1 = (int)(Math.random() * 21.0D) - 10;
               int_2 = (int)(Math.random() * 21.0D) - 10;
               int_3 = (int)(Math.random() * 21.0D) - 10;
               int_4 = (int)(Math.random() * 41.0D) - 20;
               BuildType.mapscene[0].adjustRGB(int_4 + int_1, int_2 + int_4, int_4 + int_3);
               Class25.loadingText = "Loaded sprites";
               Class25.loadingBarPercentage = 70;
               Client.loadingStage = 90;
            }
         } else if (Client.loadingStage == 90) {
            if (!Class49.texturesIndex.method437()) {
               Class25.loadingText = "Loading textures - " + Class49.texturesIndex.method615() + "%";
               Class25.loadingBarPercentage = 90;
            } else {
               TextureProvider textureprovider_0 = new TextureProvider(Class49.texturesIndex, Class34.spritesIndex, 20, 0.8D, Client.lowMemory ? 64 : 128);
               Rasterizer3D.setTextureLoader(textureprovider_0);
               Rasterizer3D.setBrightness(0.8D);
               Class25.loadingText = "Loaded textures";
               Class25.loadingBarPercentage = 90;
               Client.loadingStage = 110;
            }
         } else if (Client.loadingStage == 110) {
            Class48.aClass18_1 = new Class18();
            GameEngine.taskManager.createRunnable(Class48.aClass18_1, 10);
            Class25.loadingText = "Loaded input handler";
            Class25.loadingBarPercentage = 92;
            Client.loadingStage = 120;
         } else if (Client.loadingStage == 120) {
            if (!AbstractSoundSystem.wordPackIndex.method429("huffman", "")) {
               Class25.loadingText = "Loading wordpack - " + 0 + "%";
               Class25.loadingBarPercentage = 94;
            } else {
               Huffman huffman_0 = new Huffman(AbstractSoundSystem.wordPackIndex.method436("huffman", ""));
               Class99.aHuffman1 = huffman_0;
               Class25.loadingText = "Loaded wordpack";
               Class25.loadingBarPercentage = 94;
               Client.loadingStage = 130;
            }
         } else if (Client.loadingStage == 130) {
            if (!Class56.interfaceDataIndex.method437()) {
               Class25.loadingText = "Loading interfaces - " + Class56.interfaceDataIndex.method615() * 4 / 5 + "%";
               Class25.loadingBarPercentage = 96;
            } else if (!Class3.interfaceScriptDataIndex.method437()) {
               Class25.loadingText = "Loading interfaces - " + (80 + Class3.interfaceScriptDataIndex.method615() / 6) + "%";
               Class25.loadingBarPercentage = 96;
            } else if (!Enum1.fontConfigIndex.method437()) {
               Class25.loadingText = "Loading interfaces - " + (96 + Enum1.fontConfigIndex.method615() / 50) + "%";
               Class25.loadingBarPercentage = 96;
            } else {
               Class25.loadingText = "Loaded interfaces";
               Class25.loadingBarPercentage = 98;
               Client.loadingStage = 140;
            }
         } else if (Client.loadingStage == 140) {
            Class25.loadingBarPercentage = 100;
            if (!RSCanvas.worldMapIndex.method439(Class16.aClass16_1.aString2)) {
               Class25.loadingText = "Loading world map - " + RSCanvas.worldMapIndex.method434(Class16.aClass16_1.aString2) / 10 + "%";
            } else {
               if (Client.renderOverview == null) {
                  Client.renderOverview = new RenderOverview();
                  Client.renderOverview.method34(RSCanvas.worldMapIndex, Class50.boldFont, Client.aHashMap9, BuildType.mapscene);
               }

               index = Client.renderOverview.method33();
               if (index < 100) {
                  Class25.loadingText = "Loading world map - " + (index * 9 / 10 + 10) + "%";
               } else {
                  Class25.loadingText = "Loaded world map";
                  Client.loadingStage = 150;
               }
            }
         } else if (Client.loadingStage == 150) {
            Class110.setGameState(10);
         }
      }
   }

   static Class106[] method284() {
      return new Class106[] {Class106.aClass106_2, Class106.aClass106_1, Class106.aClass106_3};
   }

}
