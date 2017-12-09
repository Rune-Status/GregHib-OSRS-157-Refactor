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
      int int_0;
      if (Client.loadingStage == 0) {
         Class23.region = new Region(4, 104, 104, Class19.tileHeights);

         for (int_0 = 0; int_0 < 4; int_0++) {
            Client.collisionMaps[int_0] = new CollisionData(104, 104);
         }

         Class15.aSpritePixels3 = new SpritePixels(512, 512);
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
               int_4 = Graphics3D.SINE[int_2];
               ints_0[int_1] = int_3 * int_4 >> 16;
            }

            Region.method383(ints_0, 500, 800, 512, 334);
            Class25.loadingText = "Prepared visibility map";
            Class25.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         } else if (Client.loadingStage == 30) {
            Varcs.indexInterfaces = WallObject.openCacheIndex(0, false, true, true);
            Class6.indexSoundEffects = WallObject.openCacheIndex(1, false, true, true);
            GrandExchangeOffer.configsIndex = WallObject.openCacheIndex(2, true, false, true);
            Class56.anIndexData2 = WallObject.openCacheIndex(3, false, true, true);
            Tile.anIndexData5 = WallObject.openCacheIndex(4, false, true, true);
            Class23.indexMaps = WallObject.openCacheIndex(5, true, true, true);
            Class38.indexTrack1 = WallObject.openCacheIndex(6, true, true, false);
            Class4.indexModels = WallObject.openCacheIndex(7, false, true, true);
            Class34.indexSprites = WallObject.openCacheIndex(8, false, true, true);
            Class49.indexTextures = WallObject.openCacheIndex(9, false, true, true);
            AbstractSoundSystem.anIndexData1 = WallObject.openCacheIndex(10, false, true, true);
            Class92.indexTrack2 = WallObject.openCacheIndex(11, false, true, true);
            Class3.indexScripts = WallObject.openCacheIndex(12, false, true, true);
            Enum1.anIndexData4 = WallObject.openCacheIndex(13, true, false, true);
            WorldMapType2.vorbisIndex = WallObject.openCacheIndex(14, false, true, false);
            Class61.anIndexData3 = WallObject.openCacheIndex(15, false, true, true);
            RSCanvas.indexWorldMap = WallObject.openCacheIndex(16, false, true, false);
            Class25.loadingText = "Connecting to update server";
            Class25.loadingBarPercentage = 20;
            Client.loadingStage = 40;
         } else if (Client.loadingStage == 40) {
            byte byte_1 = 0;
            int_0 = byte_1 + Varcs.indexInterfaces.percentage() * 4 / 100;
            int_0 += Class6.indexSoundEffects.percentage() * 4 / 100;
            int_0 += GrandExchangeOffer.configsIndex.percentage() * 2 / 100;
            int_0 += Class56.anIndexData2.percentage() * 2 / 100;
            int_0 += Tile.anIndexData5.percentage() * 6 / 100;
            int_0 += Class23.indexMaps.percentage() * 4 / 100;
            int_0 += Class38.indexTrack1.percentage() * 2 / 100;
            int_0 += Class4.indexModels.percentage() * 58 / 100;
            int_0 += Class34.indexSprites.percentage() * 2 / 100;
            int_0 += Class49.indexTextures.percentage() * 2 / 100;
            int_0 += AbstractSoundSystem.anIndexData1.percentage() * 2 / 100;
            int_0 += Class92.indexTrack2.percentage() * 2 / 100;
            int_0 += Class3.indexScripts.percentage() * 2 / 100;
            int_0 += Enum1.anIndexData4.percentage() * 2 / 100;
            int_0 += WorldMapType2.vorbisIndex.percentage() * 2 / 100;
            int_0 += Class61.anIndexData3.percentage() * 2 / 100;
            int_0 += RSCanvas.indexWorldMap.percentage() * 2 / 100;
            if (int_0 != 100) {
               if (int_0 != 0) {
                  Class25.loadingText = "Checking for updates - " + int_0 + "%";
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
            Class41.method262(Class61.anIndexData3, WorldMapType2.vorbisIndex, Tile.anIndexData5, aclass6_sub3_0);
            Class47.soundSystem1 = FrameMap.method689(GameEngine.taskManager, 1, 2048);
            Class97.anAClass6_Sub1_1 = new AClass6_Sub1();
            Class47.soundSystem1.method346(Class97.anAClass6_Sub1_1);
            Class87.aClass51_1 = new Class51(22050, AbstractSoundSystem.sampleRate);
            Class25.loadingText = "Prepared sound engine";
            Class25.loadingBarPercentage = 35;
            Client.loadingStage = 50;
            Class1.aClass102_1 = new Class102(Class34.indexSprites, Enum1.anIndexData4);
         } else if (Client.loadingStage == 50) {
            int_0 = Class97.method520().length;
            Client.aHashMap9 = Class1.aClass102_1.method532(Class97.method520());
            if (Client.aHashMap9.size() < int_0) {
               Class25.loadingText = "Loading fonts - " + Client.aHashMap9.size() * 100 / int_0 + "%";
               Class25.loadingBarPercentage = 40;
            } else {
               Class1.aFont2 = (Font) Client.aHashMap9.get(Class97.aClass97_5);
               Class4.font_p12full = (Font) Client.aHashMap9.get(Class97.aClass97_8);
               Class50.aFont3 = (Font) Client.aHashMap9.get(Class97.aClass97_9);
               CombatInfo1.aMachineInfo1 = new MachineInfo(true);
               Class25.loadingText = "Loaded fonts";
               Class25.loadingBarPercentage = 40;
               Client.loadingStage = 60;
            }
         } else if (Client.loadingStage == 60) {
            int_0 = Timer.method587(AbstractSoundSystem.anIndexData1, Class34.indexSprites);
            byte byte_0 = 11;
            if (int_0 < byte_0) {
               Class25.loadingText = "Loading title screen - " + int_0 * 100 / byte_0 + "%";
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
               IndexData indexdata_1 = Class4.indexModels;
               KitDefinition.identKit_ref = indexdata_0;
               KitDefinition.anIndexDataBase15 = indexdata_1;
               KitDefinition.count = KitDefinition.identKit_ref.fileCount(3);
               IndexData indexdata_2 = GrandExchangeOffer.configsIndex;
               IndexData indexdata_3 = Class4.indexModels;
               boolean bool_0 = Client.lowMemory;
               ObjectDefinition.objects_ref = indexdata_2;
               ObjectDefinition.anIndexDataBase20 = indexdata_3;
               ObjectDefinition.lowMemory = bool_0;
               IndexData indexdata_4 = GrandExchangeOffer.configsIndex;
               IndexData indexdata_5 = Class4.indexModels;
               NPCComposition.anIndexDataBase29 = indexdata_4;
               NPCComposition.anIndexDataBase28 = indexdata_5;
               AClass1_Sub2.method638(GrandExchangeOffer.configsIndex);
               IndexData indexdata_6 = GrandExchangeOffer.configsIndex;
               IndexData indexdata_7 = Class4.indexModels;
               boolean bool_1 = Client.isMembers;
               Font font_0 = Class1.aFont2;
               ItemComposition.item_ref = indexdata_6;
               ItemComposition.anIndexDataBase30 = indexdata_7;
               Enum5.isMembersWorld = bool_1;
               ItemComposition.anInt503 = ItemComposition.item_ref.fileCount(10);
               ItemComposition.aFont5 = font_0;
               IndexData indexdata_8 = GrandExchangeOffer.configsIndex;
               IndexData indexdata_9 = Varcs.indexInterfaces;
               IndexData indexdata_10 = Class6.indexSoundEffects;
               Class35.seq_ref = indexdata_8;
               Sequence.skel_ref = indexdata_9;
               Sequence.skin_ref = indexdata_10;
               Class57.method388(GrandExchangeOffer.configsIndex, Class4.indexModels);
               Class28.method231(GrandExchangeOffer.configsIndex);
               IndexData indexdata_11 = GrandExchangeOffer.configsIndex;
               Class11.varplayer_ref = indexdata_11;
               VarPlayerType.anInt508 = Class11.varplayer_ref.fileCount(16);
               IndexData indexdata_12 = Class56.anIndexData2;
               IndexData indexdata_13 = Class4.indexModels;
               IndexData indexdata_14 = Class34.indexSprites;
               IndexData indexdata_15 = Enum1.anIndexData4;
               Class5.widgetIndex = indexdata_12;
               Widget.anIndexDataBase12 = indexdata_13;
               Enum1.anIndexDataBase13 = indexdata_14;
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
               Friend.method535(GrandExchangeOffer.configsIndex, Class34.indexSprites, Enum1.anIndexData4);
               Class53.method351(GrandExchangeOffer.configsIndex, Class34.indexSprites);
               IndexData indexdata_19 = GrandExchangeOffer.configsIndex;
               IndexData indexdata_20 = Class34.indexSprites;
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
            int_0 = 0;
            if (Class35.compass == null) {
               Class35.compass = Class81.method472(Class34.indexSprites, "compass", "");
            } else {
               ++int_0;
            }

            if (Class10.mapedge == null) {
               Class10.mapedge = Class81.method472(Class34.indexSprites, "mapedge", "");
            } else {
               ++int_0;
            }

            if (BuildType.mapscene == null) {
               BuildType.mapscene = Enum3.method670(Class34.indexSprites, "mapscene", "");
            } else {
               ++int_0;
            }

            if (CacheFile.headIconsPk == null) {
               CacheFile.headIconsPk = Buffer.method735(Class34.indexSprites, "headicons_pk", "");
            } else {
               ++int_0;
            }

            if (TileStrategy.headIconsPrayer == null) {
               TileStrategy.headIconsPrayer = Buffer.method735(Class34.indexSprites, "headicons_prayer", "");
            } else {
               ++int_0;
            }

            if (Class85.headIconsHint == null) {
               Class85.headIconsHint = Buffer.method735(Class34.indexSprites, "headicons_hint", "");
            } else {
               ++int_0;
            }

            if (Ignore.mapMarkers == null) {
               Ignore.mapMarkers = Buffer.method735(Class34.indexSprites, "mapmarker", "");
            } else {
               ++int_0;
            }

            if (CombatInfoListHolder.aSpritePixelsArray2 == null) {
               CombatInfoListHolder.aSpritePixelsArray2 = Buffer.method735(Class34.indexSprites, "cross", "");
            } else {
               ++int_0;
            }

            if (AClass3_Sub1.mapDots == null) {
               AClass3_Sub1.mapDots = Buffer.method735(Class34.indexSprites, "mapdots", "");
            } else {
               ++int_0;
            }

            if (Class11.anIndexedSpriteArray2 == null) {
               Class11.anIndexedSpriteArray2 = Enum3.method670(Class34.indexSprites, "scrollbar", "");
            } else {
               ++int_0;
            }

            if (Buffer.anIndexedSpriteArray8 == null) {
               Buffer.anIndexedSpriteArray8 = Enum3.method670(Class34.indexSprites, "mod_icons", "");
            } else {
               ++int_0;
            }

            if (int_0 < 11) {
               Class25.loadingText = "Loading sprites - " + int_0 * 100 / 12 + "%";
               Class25.loadingBarPercentage = 70;
            } else {
               FontTypeFace.modIcons = Buffer.anIndexedSpriteArray8;
               Class10.mapedge.method990();
               int_1 = (int)(Math.random() * 21.0D) - 10;
               int_2 = (int)(Math.random() * 21.0D) - 10;
               int_3 = (int)(Math.random() * 21.0D) - 10;
               int_4 = (int)(Math.random() * 41.0D) - 20;
               BuildType.mapscene[0].method977(int_4 + int_1, int_2 + int_4, int_4 + int_3);
               Class25.loadingText = "Loaded sprites";
               Class25.loadingBarPercentage = 70;
               Client.loadingStage = 90;
            }
         } else if (Client.loadingStage == 90) {
            if (!Class49.indexTextures.method437()) {
               Class25.loadingText = "Loading textures - " + Class49.indexTextures.method615() + "%";
               Class25.loadingBarPercentage = 90;
            } else {
               TextureProvider textureprovider_0 = new TextureProvider(Class49.indexTextures, Class34.indexSprites, 20, 0.8D, Client.lowMemory ? 64 : 128);
               Graphics3D.setTextureLoader(textureprovider_0);
               Graphics3D.setBrightness(0.8D);
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
            if (!AbstractSoundSystem.anIndexData1.method429("huffman", "")) {
               Class25.loadingText = "Loading wordpack - " + 0 + "%";
               Class25.loadingBarPercentage = 94;
            } else {
               Huffman huffman_0 = new Huffman(AbstractSoundSystem.anIndexData1.method436("huffman", ""));
               Class99.aHuffman1 = huffman_0;
               Class25.loadingText = "Loaded wordpack";
               Class25.loadingBarPercentage = 94;
               Client.loadingStage = 130;
            }
         } else if (Client.loadingStage == 130) {
            if (!Class56.anIndexData2.method437()) {
               Class25.loadingText = "Loading interfaces - " + Class56.anIndexData2.method615() * 4 / 5 + "%";
               Class25.loadingBarPercentage = 96;
            } else if (!Class3.indexScripts.method437()) {
               Class25.loadingText = "Loading interfaces - " + (80 + Class3.indexScripts.method615() / 6) + "%";
               Class25.loadingBarPercentage = 96;
            } else if (!Enum1.anIndexData4.method437()) {
               Class25.loadingText = "Loading interfaces - " + (96 + Enum1.anIndexData4.method615() / 50) + "%";
               Class25.loadingBarPercentage = 96;
            } else {
               Class25.loadingText = "Loaded interfaces";
               Class25.loadingBarPercentage = 98;
               Client.loadingStage = 140;
            }
         } else if (Client.loadingStage == 140) {
            Class25.loadingBarPercentage = 100;
            if (!RSCanvas.indexWorldMap.method439(Class16.aClass16_1.aString2)) {
               Class25.loadingText = "Loading world map - " + RSCanvas.indexWorldMap.method434(Class16.aClass16_1.aString2) / 10 + "%";
            } else {
               if (Client.renderOverview == null) {
                  Client.renderOverview = new RenderOverview();
                  Client.renderOverview.method34(RSCanvas.indexWorldMap, Class50.aFont3, Client.aHashMap9, BuildType.mapscene);
               }

               int_0 = Client.renderOverview.method33();
               if (int_0 < 100) {
                  Class25.loadingText = "Loading world map - " + (int_0 * 9 / 10 + 10) + "%";
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
