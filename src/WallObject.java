public final class WallObject {

   static IndexedSprite anIndexedSprite4;
   public int hash;
   int config;
   int x;
   int y;
   public Renderable renderable1;
   int floor;
   public Renderable renderable2;
   int orientationA;
   int orientationB;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }

   static String getColTags(int int_0) {
      return "<col=" + Integer.toHexString(int_0) + ">";
   }

   static IndexData openCacheIndex(int int_0, boolean bool_0, boolean bool_1, boolean bool_2) {
      IndexFile indexfile_0 = null;
      if (Class64.aCacheFile2 != null) {
         indexfile_0 = new IndexFile(int_0, Class64.aCacheFile2, Class64.aCacheFileArray1[int_0], 1000000);
      }

      return new IndexData(indexfile_0, MilliTimer.anIndexFile3, int_0, bool_0, bool_1, bool_2);
   }

   static void xteaChanged(boolean dynamic, PacketBuffer buffer) {
      Client.isDynamicRegion = dynamic;
      if (!Client.isDynamicRegion) {
         int regionY = buffer.getUnsignedShortInverse();
         int regionX = buffer.readUnsignedShortOb1();
         int mapCount = buffer.getUnsignedShort();
         Class38.xteaKeys = new int[mapCount][4];

         for (int map = 0; map < mapCount; map++) {
            for (int z = 0; z < 4; z++) {
               Class38.xteaKeys[map][z] = buffer.readInt();
            }
         }

         Script.mapRegions = new int[mapCount];
         Varbit.landMapFileIds = new int[mapCount];
         Varbit.landRegionFileIds = new int[mapCount];
         Class55.aByteArrayArray3 = new byte[mapCount][];
         Class10.aByteArrayArray1 = new byte[mapCount][];
         boolean inTutorialIsland = false;
         if ((regionX / 8 == 48 || regionX / 8 == 49) && regionY / 8 == 48) {
            inTutorialIsland = true;
         }

         if (regionX / 8 == 48 && regionY / 8 == 148) {
            inTutorialIsland = true;
         }

         mapCount = 0;

         for (int x = (regionX - 6) / 8; x <= (regionX + 6) / 8; x++) {
            for (int y = (regionY - 6) / 8; y <= (regionY + 6) / 8; y++) {
               int regionId = y + (x << 8);
               if (!inTutorialIsland || y != 49 && y != 149 && y != 147 && x != 50 && (x != 49 || y != 47)) {
                  Script.mapRegions[mapCount] = regionId;
                  Varbit.landMapFileIds[mapCount] = Class23.indexMaps.getFile("m" + x + "_" + y);
                  Varbit.landRegionFileIds[mapCount] = Class23.indexMaps.getFile("l" + x + "_" + y);
                  ++mapCount;
               }
            }
         }

         Class40.method259(regionX, regionY, true);
      } else {
         boolean bool_1 = buffer.readNegUByte() == 1;
         int regionY = buffer.getUnsignedShortInverse();
         int regionX = buffer.getUnsignedShortAInverse();
         int mapCount = buffer.getUnsignedShort();
         buffer.bitAccess();

         int visible;
         for (int z = 0; z < 4; z++) {
            for (int x = 0; x < 13; x++) {
               for (int y = 0; y < 13; y++) {
                  visible = buffer.getBits(1);
                  if (visible == 1) {
                     Client.localRegions[z][x][y] = buffer.getBits(26);
                  } else {
                     Client.localRegions[z][x][y] = -1;
                  }
               }
            }
         }

         buffer.byteAccess();
         Class38.xteaKeys = new int[mapCount][4];

         for (int x = 0; x < mapCount; x++) {
            for (int y = 0; y < 4; y++) {
               Class38.xteaKeys[x][y] = buffer.readInt();
            }
         }

         Script.mapRegions = new int[mapCount];
         Varbit.landMapFileIds = new int[mapCount];
         Varbit.landRegionFileIds = new int[mapCount];
         Class55.aByteArrayArray3 = new byte[mapCount][];
         Class10.aByteArrayArray1 = new byte[mapCount][];
         mapCount = 0;

         for (int z = 0; z < 4; z++) {
            for (int x = 0; x < 13; x++) {
               for (int y = 0; y < 13; y++) {
                  visible = Client.localRegions[z][x][y];
                  if (visible != -1) {
                     int constructedRegionX = visible >> 14 & 0x3FF;
                     int constructedRegionY = visible >> 3 & 0x7FF;
                     int regionId = (constructedRegionX / 8 << 8) + constructedRegionY / 8;

                     int map;
                     for (map = 0; map < mapCount; map++) {
                        if (Script.mapRegions[map] == regionId) {
                           regionId = -1;
                           break;
                        }
                     }

                     if (regionId != -1) {
                        Script.mapRegions[mapCount] = regionId;
                        int mapX = regionId >> 8 & 0xFF;
                        int mapY = regionId & 0xFF;
                        Varbit.landMapFileIds[mapCount] = Class23.indexMaps.getFile("m" + mapX + "_" + mapY);
                        Varbit.landRegionFileIds[mapCount] = Class23.indexMaps.getFile("l" + mapX + "_" + mapY);
                        ++mapCount;
                     }
                  }
               }
            }
         }

         Class40.method259(regionX, regionY, !bool_1);
      }

   }

}
