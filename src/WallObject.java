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

   static void xteaChanged(boolean bool_0, PacketBuffer packetbuffer_0) {
      Client.isDynamicRegion = bool_0;
      int int_1;
      int int_2;
      int int_3;
      int int_4;
      int int_5;
      int int_6;
      if (!Client.isDynamicRegion) {
         int int_0 = packetbuffer_0.method713();
         int_1 = packetbuffer_0.readUnsignedShortOb1();
         int_2 = packetbuffer_0.readUnsignedShort();
         Class38.xteaKeys = new int[int_2][4];

         for (int_3 = 0; int_3 < int_2; int_3++) {
            for (int_4 = 0; int_4 < 4; int_4++) {
               Class38.xteaKeys[int_3][int_4] = packetbuffer_0.readInt();
            }
         }

         Script.mapRegions = new int[int_2];
         Varbit.landMapFileIds = new int[int_2];
         Varbit.landRegionFileIds = new int[int_2];
         Class55.aByteArrayArray3 = new byte[int_2][];
         Class10.aByteArrayArray1 = new byte[int_2][];
         boolean bool_2 = false;
         if ((int_1 / 8 == 48 || int_1 / 8 == 49) && int_0 / 8 == 48) {
            bool_2 = true;
         }

         if (int_1 / 8 == 48 && int_0 / 8 == 148) {
            bool_2 = true;
         }

         int_2 = 0;

         for (int_4 = (int_1 - 6) / 8; int_4 <= (int_1 + 6) / 8; int_4++) {
            for (int_5 = (int_0 - 6) / 8; int_5 <= (int_0 + 6) / 8; int_5++) {
               int_6 = int_5 + (int_4 << 8);
               if (!bool_2 || int_5 != 49 && int_5 != 149 && int_5 != 147 && int_4 != 50 && (int_4 != 49 || int_5 != 47)) {
                  Script.mapRegions[int_2] = int_6;
                  Varbit.landMapFileIds[int_2] = Class23.indexMaps.getFile("m" + int_4 + "_" + int_5);
                  Varbit.landRegionFileIds[int_2] = Class23.indexMaps.getFile("l" + int_4 + "_" + int_5);
                  ++int_2;
               }
            }
         }

         Class40.method259(int_1, int_0, true);
      } else {
         boolean bool_1 = packetbuffer_0.method711() == 1;
         int_1 = packetbuffer_0.method713();
         int_2 = packetbuffer_0.method712();
         int_3 = packetbuffer_0.readUnsignedShort();
         packetbuffer_0.bitAccess();

         int int_7;
         for (int_4 = 0; int_4 < 4; int_4++) {
            for (int_5 = 0; int_5 < 13; int_5++) {
               for (int_6 = 0; int_6 < 13; int_6++) {
                  int_7 = packetbuffer_0.getBits(1);
                  if (int_7 == 1) {
                     Client.anIntArrayArrayArray2[int_4][int_5][int_6] = packetbuffer_0.getBits(26);
                  } else {
                     Client.anIntArrayArrayArray2[int_4][int_5][int_6] = -1;
                  }
               }
            }
         }

         packetbuffer_0.byteAccess();
         Class38.xteaKeys = new int[int_3][4];

         for (int_4 = 0; int_4 < int_3; int_4++) {
            for (int_5 = 0; int_5 < 4; int_5++) {
               Class38.xteaKeys[int_4][int_5] = packetbuffer_0.readInt();
            }
         }

         Script.mapRegions = new int[int_3];
         Varbit.landMapFileIds = new int[int_3];
         Varbit.landRegionFileIds = new int[int_3];
         Class55.aByteArrayArray3 = new byte[int_3][];
         Class10.aByteArrayArray1 = new byte[int_3][];
         int_3 = 0;

         for (int_4 = 0; int_4 < 4; int_4++) {
            for (int_5 = 0; int_5 < 13; int_5++) {
               for (int_6 = 0; int_6 < 13; int_6++) {
                  int_7 = Client.anIntArrayArrayArray2[int_4][int_5][int_6];
                  if (int_7 != -1) {
                     int int_8 = int_7 >> 14 & 0x3FF;
                     int int_9 = int_7 >> 3 & 0x7FF;
                     int int_10 = (int_8 / 8 << 8) + int_9 / 8;

                     int int_11;
                     for (int_11 = 0; int_11 < int_3; int_11++) {
                        if (Script.mapRegions[int_11] == int_10) {
                           int_10 = -1;
                           break;
                        }
                     }

                     if (int_10 != -1) {
                        Script.mapRegions[int_3] = int_10;
                        int_11 = int_10 >> 8 & 0xFF;
                        int int_12 = int_10 & 0xFF;
                        Varbit.landMapFileIds[int_3] = Class23.indexMaps.getFile("m" + int_11 + "_" + int_12);
                        Varbit.landRegionFileIds[int_3] = Class23.indexMaps.getFile("l" + int_11 + "_" + int_12);
                        ++int_3;
                     }
                  }
               }
            }
         }

         Class40.method259(int_2, int_1, !bool_1);
      }

   }

}
