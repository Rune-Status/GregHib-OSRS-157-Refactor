public class Region {

   public static boolean lowMemory;
   static boolean viewportWalking;
   static int[] levelOccluderCount;
   static int anInt146;
   static Deque tileDeque;
   static int cameraX2;
   static int anInt147;
   static int MAX_OCCLUDER_LEVELS;
   public static int selectedRegionTileX;
   static int tileUpdateCount;
   static Occluder[] anOccluderArray1;
   static int cycle;
   static int cameraZ2;
   static Occluder[][] levelOccluders;
   static boolean checkClick;
   static GameObject[] entityBuffer;
   static int anInt148;
   static int cameraY2;
   static int pitchSin;
   static int mouseX2;
   static int yawSin;
   static int mouseY2;
   static int yawCos;
   static int pitchCos;
   static int screenCenterX;
   public static int selectedRegionTileY;
   static int screenCenterZ;
   static int minTileX;
   static boolean[][][][] visibilityMaps;
   static int maxTileX;
   static int minTileZ;
   static int maxTileZ;
   static boolean[][] renderArea;
   static final int[] anIntArray35;
   static final int[] anIntArray36;
   static final int[] TILE_WALL_DRAW_FLAGS_1;
   static final int[] WALL_UNCULL_FLAGS_0;
   static int anInt149;
   static int anInt150;
   static int anInt151;
   static int anInt152;
   static int anInt153;
   static final int[] WALL_UNCULL_FLAGS_1;
   static int anInt154;
   static final int[] WALL_UNCULL_FLAGS_2;
   static final int[] WALL_UNCULL_FLAGS_3;
   int minLevel;
   int entityCount;
   int[][][] tileCycles;
   int maxX;
   int maxY;
   Tile[][][] tiles;
   GameObject[] objects;
   int maxZ;
   int[][][] tileHeights;
   int[][] TILE_MASK_2D;
   int[][] TILE_ROTATION_2D;

   static {
      lowMemory = true;
      tileUpdateCount = 0;
      anInt147 = 0;
      entityBuffer = new GameObject[100];
      checkClick = false;
      anInt148 = 0;
      mouseX2 = 0;
      mouseY2 = 0;
      selectedRegionTileX = -1;
      selectedRegionTileY = -1;
      viewportWalking = false;
      MAX_OCCLUDER_LEVELS = 4;
      levelOccluderCount = new int[MAX_OCCLUDER_LEVELS];
      levelOccluders = new Occluder[MAX_OCCLUDER_LEVELS][500];
      anInt146 = 0;
      anOccluderArray1 = new Occluder[500];
      tileDeque = new Deque();
      anIntArray36 = new int[] {19, 55, 38, 155, 255, 110, 137, 205, 76};
      anIntArray35 = new int[] {160, 192, 80, 96, 0, 144, 80, 48, 160};
      TILE_WALL_DRAW_FLAGS_1 = new int[] {76, 8, 137, 4, 0, 1, 38, 2, 19};
      WALL_UNCULL_FLAGS_0 = new int[] {0, 0, 2, 0, 0, 2, 1, 1, 0};
      WALL_UNCULL_FLAGS_1 = new int[] {2, 0, 0, 2, 0, 0, 0, 4, 4};
      WALL_UNCULL_FLAGS_2 = new int[] {0, 4, 4, 8, 0, 0, 8, 0, 0};
      WALL_UNCULL_FLAGS_3 = new int[] {1, 1, 0, 0, 0, 8, 0, 0, 8};
      visibilityMaps = new boolean[8][32][51][51];
   }

   public Region(int int_0, int int_1, int int_2, int[][][] ints_0) {
      this.minLevel = 0;
      this.entityCount = 0;
      this.objects = new GameObject[5000];
      this.TILE_MASK_2D = new int[][] {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
      this.TILE_ROTATION_2D = new int[][] {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};
      this.maxY = int_0;
      this.maxX = int_1;
      this.maxZ = int_2;
      this.tiles = new Tile[int_0][int_1][int_2];
      this.tileCycles = new int[int_0][int_1 + 1][int_2 + 1];
      this.tileHeights = ints_0;
      this.reset();
   }

   boolean isTileOccluded(int int_0, int int_1, int int_2) {
      int int_3 = this.tileCycles[int_0][int_1][int_2];
      if (int_3 == -cycle) {
         return false;
      } else if (int_3 == cycle) {
         return true;
      } else {
         int int_4 = int_1 << 7;
         int int_5 = int_2 << 7;
         if (this.isOccluded(int_4 + 1, this.tileHeights[int_0][int_1][int_2], int_5 + 1) && this.isOccluded(int_4 + 128 - 1, this.tileHeights[int_0][int_1 + 1][int_2], int_5 + 1) && this.isOccluded(int_4 + 128 - 1, this.tileHeights[int_0][int_1 + 1][int_2 + 1], int_5 + 128 - 1) && this.isOccluded(int_4 + 1, this.tileHeights[int_0][int_1][int_2 + 1], int_5 + 128 - 1)) {
            this.tileCycles[int_0][int_1][int_2] = cycle;
            return true;
         } else {
            this.tileCycles[int_0][int_1][int_2] = -cycle;
            return false;
         }
      }
   }

   boolean addEntityMarker(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, Renderable renderable_0, int int_8, boolean bool_0, int int_9, int int_10) {
      int int_12;
      for (int int_11 = int_1; int_11 < int_1 + int_3; int_11++) {
         for (int_12 = int_2; int_12 < int_2 + int_4; int_12++) {
            if (int_11 < 0 || int_12 < 0 || int_11 >= this.maxX || int_12 >= this.maxZ) {
               return false;
            }

            Tile tile_0 = this.tiles[int_0][int_11][int_12];
            if (tile_0 != null && tile_0.entityCount >= 5) {
               return false;
            }
         }
      }

      GameObject gameobject_0 = new GameObject();
      gameobject_0.hash = int_9;
      gameobject_0.flags = int_10;
      gameobject_0.plane = int_0;
      gameobject_0.x = int_5;
      gameobject_0.y = int_6;
      gameobject_0.height = int_7;
      gameobject_0.renderable = renderable_0;
      gameobject_0.orientation = int_8;
      gameobject_0.relativeX = int_1;
      gameobject_0.relativeY = int_2;
      gameobject_0.offsetX = int_1 + int_3 - 1;
      gameobject_0.offsetY = int_2 + int_4 - 1;

      for (int_12 = int_1; int_12 < int_1 + int_3; int_12++) {
         for (int int_13 = int_2; int_13 < int_2 + int_4; int_13++) {
            int int_14 = 0;
            if (int_12 > int_1) {
               ++int_14;
            }

            if (int_12 < int_1 + int_3 - 1) {
               int_14 += 4;
            }

            if (int_13 > int_2) {
               int_14 += 8;
            }

            if (int_13 < int_2 + int_4 - 1) {
               int_14 += 2;
            }

            for (int int_15 = int_0; int_15 >= 0; --int_15) {
               if (this.tiles[int_15][int_12][int_13] == null) {
                  this.tiles[int_15][int_12][int_13] = new Tile(int_15, int_12, int_13);
               }
            }

            Tile tile_1 = this.tiles[int_0][int_12][int_13];
            tile_1.objects[tile_1.entityCount] = gameobject_0;
            tile_1.entityFlags[tile_1.entityCount] = int_14;
            tile_1.flags |= int_14;
            ++tile_1.entityCount;
         }
      }

      if (bool_0) {
         this.objects[this.entityCount++] = gameobject_0;
      }

      return true;
   }

   void removeEntity(GameObject gameobject_0) {
      for (int int_0 = gameobject_0.relativeX; int_0 <= gameobject_0.offsetX; int_0++) {
         for (int int_1 = gameobject_0.relativeY; int_1 <= gameobject_0.offsetY; int_1++) {
            Tile tile_0 = this.tiles[gameobject_0.plane][int_0][int_1];
            if (tile_0 != null) {
               int int_2;
               for (int_2 = 0; int_2 < tile_0.entityCount; int_2++) {
                  if (tile_0.objects[int_2] == gameobject_0) {
                     --tile_0.entityCount;

                     for (int int_3 = int_2; int_3 < tile_0.entityCount; int_3++) {
                        tile_0.objects[int_3] = tile_0.objects[int_3 + 1];
                        tile_0.entityFlags[int_3] = tile_0.entityFlags[int_3 + 1];
                     }

                     tile_0.objects[tile_0.entityCount] = null;
                     break;
                  }
               }

               tile_0.flags = 0;

               for (int_2 = 0; int_2 < tile_0.entityCount; int_2++) {
                  tile_0.flags |= tile_0.entityFlags[int_2];
               }
            }
         }
      }

   }

   boolean isOccluded(int int_0, int int_1, int int_2) {
      for (int int_3 = 0; int_3 < anInt146; int_3++) {
         Occluder occluder_0 = anOccluderArray1[int_3];
         int int_4;
         int int_5;
         int int_6;
         int int_7;
         int int_8;
         if (occluder_0.testDirection == 1) {
            int_4 = occluder_0.minX - int_0;
            if (int_4 > 0) {
               int_5 = (int_4 * occluder_0.minNormalX >> 8) + occluder_0.minZ;
               int_6 = (int_4 * occluder_0.maxNormalX >> 8) + occluder_0.maxZ;
               int_7 = (int_4 * occluder_0.minNormalY >> 8) + occluder_0.minY;
               int_8 = (int_4 * occluder_0.maxNormalY >> 8) + occluder_0.maxY;
               if (int_2 >= int_5 && int_2 <= int_6 && int_1 >= int_7 && int_1 <= int_8) {
                  return true;
               }
            }
         } else if (occluder_0.testDirection == 2) {
            int_4 = int_0 - occluder_0.minX;
            if (int_4 > 0) {
               int_5 = (int_4 * occluder_0.minNormalX >> 8) + occluder_0.minZ;
               int_6 = (int_4 * occluder_0.maxNormalX >> 8) + occluder_0.maxZ;
               int_7 = (int_4 * occluder_0.minNormalY >> 8) + occluder_0.minY;
               int_8 = (int_4 * occluder_0.maxNormalY >> 8) + occluder_0.maxY;
               if (int_2 >= int_5 && int_2 <= int_6 && int_1 >= int_7 && int_1 <= int_8) {
                  return true;
               }
            }
         } else if (occluder_0.testDirection == 3) {
            int_4 = occluder_0.minZ - int_2;
            if (int_4 > 0) {
               int_5 = (int_4 * occluder_0.anInt158 >> 8) + occluder_0.minX;
               int_6 = (int_4 * occluder_0.anInt159 >> 8) + occluder_0.maxX;
               int_7 = (int_4 * occluder_0.minNormalY >> 8) + occluder_0.minY;
               int_8 = (int_4 * occluder_0.maxNormalY >> 8) + occluder_0.maxY;
               if (int_0 >= int_5 && int_0 <= int_6 && int_1 >= int_7 && int_1 <= int_8) {
                  return true;
               }
            }
         } else if (occluder_0.testDirection == 4) {
            int_4 = int_2 - occluder_0.minZ;
            if (int_4 > 0) {
               int_5 = (int_4 * occluder_0.anInt158 >> 8) + occluder_0.minX;
               int_6 = (int_4 * occluder_0.anInt159 >> 8) + occluder_0.maxX;
               int_7 = (int_4 * occluder_0.minNormalY >> 8) + occluder_0.minY;
               int_8 = (int_4 * occluder_0.maxNormalY >> 8) + occluder_0.maxY;
               if (int_0 >= int_5 && int_0 <= int_6 && int_1 >= int_7 && int_1 <= int_8) {
                  return true;
               }
            }
         } else if (occluder_0.testDirection == 5) {
            int_4 = int_1 - occluder_0.minY;
            if (int_4 > 0) {
               int_5 = (int_4 * occluder_0.anInt158 >> 8) + occluder_0.minX;
               int_6 = (int_4 * occluder_0.anInt159 >> 8) + occluder_0.maxX;
               int_7 = (int_4 * occluder_0.minNormalX >> 8) + occluder_0.minZ;
               int_8 = (int_4 * occluder_0.maxNormalX >> 8) + occluder_0.maxZ;
               if (int_0 >= int_5 && int_0 <= int_6 && int_2 >= int_7 && int_2 <= int_8) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   void method358(ModelHeader modeldata_0, int int_0, int int_1, int int_2, int int_3, int int_4) {
      boolean bool_0 = true;
      int int_5 = int_1;
      int int_6 = int_1 + int_3;
      int int_7 = int_2 - 1;
      int int_8 = int_2 + int_4;

      for (int int_9 = int_0; int_9 <= int_0 + 1; int_9++) {
         if (int_9 != this.maxY) {
            for (int int_10 = int_5; int_10 <= int_6; int_10++) {
               if (int_10 >= 0 && int_10 < this.maxX) {
                  for (int int_11 = int_7; int_11 <= int_8; int_11++) {
                     if (int_11 >= 0 && int_11 < this.maxZ && (!bool_0 || int_10 >= int_6 || int_11 >= int_8 || int_11 < int_2 && int_1 != int_10)) {
                        Tile tile_0 = this.tiles[int_9][int_10][int_11];
                        if (tile_0 != null) {
                           int int_12 = (this.tileHeights[int_9][int_10 + 1][int_11] + this.tileHeights[int_9][int_10 + 1][int_11 + 1] + this.tileHeights[int_9][int_10][int_11] + this.tileHeights[int_9][int_10][int_11 + 1]) / 4 - (this.tileHeights[int_0][int_1 + 1][int_2] + this.tileHeights[int_0][int_1][int_2] + this.tileHeights[int_0][int_1 + 1][int_2 + 1] + this.tileHeights[int_0][int_1][int_2 + 1]) / 4;
                           WallObject wallobject_0 = tile_0.wallObject;
                           if (wallobject_0 != null) {
                              ModelHeader modeldata_1;
                              if (wallobject_0.renderable1 instanceof ModelHeader) {
                                 modeldata_1 = (ModelHeader) wallobject_0.renderable1;
                                 ModelHeader.method1061(modeldata_0, modeldata_1, (1 - int_3) * 64 + (int_10 - int_1) * 128, int_12, (int_11 - int_2) * 128 + (1 - int_4) * 64, bool_0);
                              }

                              if (wallobject_0.renderable2 instanceof ModelHeader) {
                                 modeldata_1 = (ModelHeader) wallobject_0.renderable2;
                                 ModelHeader.method1061(modeldata_0, modeldata_1, (1 - int_3) * 64 + (int_10 - int_1) * 128, int_12, (int_11 - int_2) * 128 + (1 - int_4) * 64, bool_0);
                              }
                           }

                           for (int int_13 = 0; int_13 < tile_0.entityCount; int_13++) {
                              GameObject gameobject_0 = tile_0.objects[int_13];
                              if (gameobject_0 != null && gameobject_0.renderable instanceof ModelHeader) {
                                 ModelHeader modeldata_2 = (ModelHeader) gameobject_0.renderable;
                                 int int_14 = gameobject_0.offsetX - gameobject_0.relativeX + 1;
                                 int int_15 = gameobject_0.offsetY - gameobject_0.relativeY + 1;
                                 ModelHeader.method1061(modeldata_0, modeldata_2, (int_14 - int_3) * 64 + (gameobject_0.relativeX - int_1) * 128, int_12, (gameobject_0.relativeY - int_2) * 128 + (int_15 - int_4) * 64, bool_0);
                              }
                           }
                        }
                     }
                  }
               }
            }

            --int_5;
            bool_0 = false;
         }
      }

   }

   public void method359(int int_0, int int_1, int int_2, boolean bool_0) {
      if (!method381() || bool_0) {
         checkClick = true;
         viewportWalking = bool_0;
         anInt148 = int_0;
         mouseX2 = int_1;
         mouseY2 = int_2;
         selectedRegionTileX = -1;
         selectedRegionTileY = -1;
      }
   }

   void drawTileUnderlay(SceneTilePaint scenetilepaint_0, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6) {
      int int_7;
      int int_8 = int_7 = (int_5 << 7) - cameraX2;
      int int_9;
      int int_10 = int_9 = (int_6 << 7) - cameraZ2;
      int int_11;
      int int_12 = int_11 = int_8 + 128;
      int int_13;
      int int_14 = int_13 = int_10 + 128;
      int int_15 = this.tileHeights[int_0][int_5][int_6] - cameraY2;
      int int_16 = this.tileHeights[int_0][int_5 + 1][int_6] - cameraY2;
      int int_17 = this.tileHeights[int_0][int_5 + 1][int_6 + 1] - cameraY2;
      int int_18 = this.tileHeights[int_0][int_5][int_6 + 1] - cameraY2;
      int int_19 = int_8 * int_4 + int_3 * int_10 >> 16;
      int_10 = int_10 * int_4 - int_3 * int_8 >> 16;
      int_8 = int_19;
      int_19 = int_15 * int_2 - int_1 * int_10 >> 16;
      int_10 = int_1 * int_15 + int_10 * int_2 >> 16;
      int_15 = int_19;
      if (int_10 >= 50) {
         int_19 = int_12 * int_4 + int_3 * int_9 >> 16;
         int_9 = int_9 * int_4 - int_3 * int_12 >> 16;
         int_12 = int_19;
         int_19 = int_16 * int_2 - int_1 * int_9 >> 16;
         int_9 = int_1 * int_16 + int_9 * int_2 >> 16;
         int_16 = int_19;
         if (int_9 >= 50) {
            int_19 = int_11 * int_4 + int_3 * int_14 >> 16;
            int_14 = int_14 * int_4 - int_3 * int_11 >> 16;
            int_11 = int_19;
            int_19 = int_17 * int_2 - int_1 * int_14 >> 16;
            int_14 = int_1 * int_17 + int_14 * int_2 >> 16;
            int_17 = int_19;
            if (int_14 >= 50) {
               int_19 = int_7 * int_4 + int_3 * int_13 >> 16;
               int_13 = int_13 * int_4 - int_3 * int_7 >> 16;
               int_7 = int_19;
               int_19 = int_18 * int_2 - int_1 * int_13 >> 16;
               int_13 = int_1 * int_18 + int_13 * int_2 >> 16;
               if (int_13 >= 50) {
                  int int_20 = int_8 * Graphics3D.anInt543 / int_10 + Graphics3D.centerX;
                  int int_21 = int_15 * Graphics3D.anInt543 / int_10 + Graphics3D.centerY;
                  int int_22 = int_12 * Graphics3D.anInt543 / int_9 + Graphics3D.centerX;
                  int int_23 = int_16 * Graphics3D.anInt543 / int_9 + Graphics3D.centerY;
                  int int_24 = int_11 * Graphics3D.anInt543 / int_14 + Graphics3D.centerX;
                  int int_25 = int_17 * Graphics3D.anInt543 / int_14 + Graphics3D.centerY;
                  int int_26 = int_7 * Graphics3D.anInt543 / int_13 + Graphics3D.centerX;
                  int int_27 = int_19 * Graphics3D.anInt543 / int_13 + Graphics3D.centerY;
                  Graphics3D.rasterAlpha = 0;
                  int int_28;
                  if ((int_24 - int_26) * (int_23 - int_27) - (int_25 - int_27) * (int_22 - int_26) > 0) {
                     Graphics3D.rasterClipEnable = false;
                     if (int_24 < 0 || int_26 < 0 || int_22 < 0 || int_24 > Graphics3D.rasterClipX || int_26 > Graphics3D.rasterClipX || int_22 > Graphics3D.rasterClipX) {
                        Graphics3D.rasterClipEnable = true;
                     }

                     if (checkClick && this.withinTriangle(mouseX2, mouseY2, int_25, int_27, int_23, int_24, int_26, int_22)) {
                        selectedRegionTileX = int_5;
                        selectedRegionTileY = int_6;
                     }

                     if (scenetilepaint_0.texture == -1) {
                        if (scenetilepaint_0.neColor != 12345678) {
                           Graphics3D.rasterGouraud(int_25, int_27, int_23, int_24, int_26, int_22, scenetilepaint_0.neColor, scenetilepaint_0.nwColor, scenetilepaint_0.seColor);
                        }
                     } else if (!lowMemory) {
                        if (scenetilepaint_0.flatShade) {
                           Graphics3D.rasterTexture(int_25, int_27, int_23, int_24, int_26, int_22, scenetilepaint_0.neColor, scenetilepaint_0.nwColor, scenetilepaint_0.seColor, int_8, int_12, int_7, int_15, int_16, int_19, int_10, int_9, int_13, scenetilepaint_0.texture);
                        } else {
                           Graphics3D.rasterTexture(int_25, int_27, int_23, int_24, int_26, int_22, scenetilepaint_0.neColor, scenetilepaint_0.nwColor, scenetilepaint_0.seColor, int_11, int_7, int_12, int_17, int_19, int_16, int_14, int_13, int_9, scenetilepaint_0.texture);
                        }
                     } else {
                        int_28 = Graphics3D.textureLoader.getAverageTextureRGB(scenetilepaint_0.texture);
                        Graphics3D.rasterGouraud(int_25, int_27, int_23, int_24, int_26, int_22, method384(int_28, scenetilepaint_0.neColor), method384(int_28, scenetilepaint_0.nwColor), method384(int_28, scenetilepaint_0.seColor));
                     }
                  }

                  if ((int_20 - int_22) * (int_27 - int_23) - (int_21 - int_23) * (int_26 - int_22) > 0) {
                     Graphics3D.rasterClipEnable = false;
                     if (int_20 < 0 || int_22 < 0 || int_26 < 0 || int_20 > Graphics3D.rasterClipX || int_22 > Graphics3D.rasterClipX || int_26 > Graphics3D.rasterClipX) {
                        Graphics3D.rasterClipEnable = true;
                     }

                     if (checkClick && this.withinTriangle(mouseX2, mouseY2, int_21, int_23, int_27, int_20, int_22, int_26)) {
                        selectedRegionTileX = int_5;
                        selectedRegionTileY = int_6;
                     }

                     if (scenetilepaint_0.texture == -1) {
                        if (scenetilepaint_0.swColor != 12345678) {
                           Graphics3D.rasterGouraud(int_21, int_23, int_27, int_20, int_22, int_26, scenetilepaint_0.swColor, scenetilepaint_0.seColor, scenetilepaint_0.nwColor);
                        }
                     } else if (!lowMemory) {
                        Graphics3D.rasterTexture(int_21, int_23, int_27, int_20, int_22, int_26, scenetilepaint_0.swColor, scenetilepaint_0.seColor, scenetilepaint_0.nwColor, int_8, int_12, int_7, int_15, int_16, int_19, int_10, int_9, int_13, scenetilepaint_0.texture);
                     } else {
                        int_28 = Graphics3D.textureLoader.getAverageTextureRGB(scenetilepaint_0.texture);
                        Graphics3D.rasterGouraud(int_21, int_23, int_27, int_20, int_22, int_26, method384(int_28, scenetilepaint_0.swColor), method384(int_28, scenetilepaint_0.seColor), method384(int_28, scenetilepaint_0.nwColor));
                     }
                  }

               }
            }
         }
      }
   }

   void drawTileOverlay(SceneTileModel scenetilemodel_0, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      int int_6 = scenetilemodel_0.vertexX.length;

      int int_7;
      int int_8;
      int int_9;
      int int_10;
      int int_11;
      for (int_7 = 0; int_7 < int_6; int_7++) {
         int_8 = scenetilemodel_0.vertexX[int_7] - cameraX2;
         int_9 = scenetilemodel_0.vertexY[int_7] - cameraY2;
         int_10 = scenetilemodel_0.vertexZ[int_7] - cameraZ2;
         int_11 = int_10 * int_2 + int_3 * int_8 >> 16;
         int_10 = int_3 * int_10 - int_8 * int_2 >> 16;
         int_8 = int_11;
         int_11 = int_1 * int_9 - int_10 * int_0 >> 16;
         int_10 = int_9 * int_0 + int_1 * int_10 >> 16;
         if (int_10 < 50) {
            return;
         }

         if (scenetilemodel_0.triangleTextureId != null) {
            SceneTileModel.vertexSceneX[int_7] = int_8;
            SceneTileModel.vertexSceneY[int_7] = int_11;
            SceneTileModel.vertexSceneZ[int_7] = int_10;
         }

         SceneTileModel.tmpScreenX[int_7] = int_8 * Graphics3D.anInt543 / int_10 + Graphics3D.centerX;
         SceneTileModel.tmpScreenY[int_7] = int_11 * Graphics3D.anInt543 / int_10 + Graphics3D.centerY;
      }

      Graphics3D.rasterAlpha = 0;
      int_6 = scenetilemodel_0.anIntArray60.length;

      for (int_7 = 0; int_7 < int_6; int_7++) {
         int_8 = scenetilemodel_0.anIntArray60[int_7];
         int_9 = scenetilemodel_0.anIntArray61[int_7];
         int_10 = scenetilemodel_0.anIntArray62[int_7];
         int_11 = SceneTileModel.tmpScreenX[int_8];
         int int_12 = SceneTileModel.tmpScreenX[int_9];
         int int_13 = SceneTileModel.tmpScreenX[int_10];
         int int_14 = SceneTileModel.tmpScreenY[int_8];
         int int_15 = SceneTileModel.tmpScreenY[int_9];
         int int_16 = SceneTileModel.tmpScreenY[int_10];
         if ((int_11 - int_12) * (int_16 - int_15) - (int_14 - int_15) * (int_13 - int_12) > 0) {
            Graphics3D.rasterClipEnable = false;
            if (int_11 < 0 || int_12 < 0 || int_13 < 0 || int_11 > Graphics3D.rasterClipX || int_12 > Graphics3D.rasterClipX || int_13 > Graphics3D.rasterClipX) {
               Graphics3D.rasterClipEnable = true;
            }

            if (checkClick && this.withinTriangle(mouseX2, mouseY2, int_14, int_15, int_16, int_11, int_12, int_13)) {
               selectedRegionTileX = int_4;
               selectedRegionTileY = int_5;
            }

            if (scenetilemodel_0.triangleTextureId != null && scenetilemodel_0.triangleTextureId[int_7] != -1) {
               if (!lowMemory) {
                  if (scenetilemodel_0.flatShade) {
                     Graphics3D.rasterTexture(int_14, int_15, int_16, int_11, int_12, int_13, scenetilemodel_0.triangleColorA[int_7], scenetilemodel_0.triangleColorB[int_7], scenetilemodel_0.triangleColorC[int_7], SceneTileModel.vertexSceneX[0], SceneTileModel.vertexSceneX[1], SceneTileModel.vertexSceneX[3], SceneTileModel.vertexSceneY[0], SceneTileModel.vertexSceneY[1], SceneTileModel.vertexSceneY[3], SceneTileModel.vertexSceneZ[0], SceneTileModel.vertexSceneZ[1], SceneTileModel.vertexSceneZ[3], scenetilemodel_0.triangleTextureId[int_7]);
                  } else {
                     Graphics3D.rasterTexture(int_14, int_15, int_16, int_11, int_12, int_13, scenetilemodel_0.triangleColorA[int_7], scenetilemodel_0.triangleColorB[int_7], scenetilemodel_0.triangleColorC[int_7], SceneTileModel.vertexSceneX[int_8], SceneTileModel.vertexSceneX[int_9], SceneTileModel.vertexSceneX[int_10], SceneTileModel.vertexSceneY[int_8], SceneTileModel.vertexSceneY[int_9], SceneTileModel.vertexSceneY[int_10], SceneTileModel.vertexSceneZ[int_8], SceneTileModel.vertexSceneZ[int_9], SceneTileModel.vertexSceneZ[int_10], scenetilemodel_0.triangleTextureId[int_7]);
                  }
               } else {
                  int int_17 = Graphics3D.textureLoader.getAverageTextureRGB(scenetilemodel_0.triangleTextureId[int_7]);
                  Graphics3D.rasterGouraud(int_14, int_15, int_16, int_11, int_12, int_13, method384(int_17, scenetilemodel_0.triangleColorA[int_7]), method384(int_17, scenetilemodel_0.triangleColorB[int_7]), method384(int_17, scenetilemodel_0.triangleColorC[int_7]));
               }
            } else if (scenetilemodel_0.triangleColorA[int_7] != 12345678) {
               Graphics3D.rasterGouraud(int_14, int_15, int_16, int_11, int_12, int_13, scenetilemodel_0.triangleColorA[int_7], scenetilemodel_0.triangleColorB[int_7], scenetilemodel_0.triangleColorC[int_7]);
            }
         }
      }

   }

   boolean isWallOccluded(int int_0, int int_1, int int_2, int int_3) {
      if (!this.isTileOccluded(int_0, int_1, int_2)) {
         return false;
      } else {
         int int_4 = int_1 << 7;
         int int_5 = int_2 << 7;
         int int_6 = this.tileHeights[int_0][int_1][int_2] - 1;
         int int_7 = int_6 - 120;
         int int_8 = int_6 - 230;
         int int_9 = int_6 - 238;
         if (int_3 < 16) {
            if (int_3 == 1) {
               if (int_4 > cameraX2) {
                  if (!this.isOccluded(int_4, int_6, int_5)) {
                     return false;
                  }

                  if (!this.isOccluded(int_4, int_6, int_5 + 128)) {
                     return false;
                  }
               }

               if (int_0 > 0) {
                  if (!this.isOccluded(int_4, int_7, int_5)) {
                     return false;
                  }

                  if (!this.isOccluded(int_4, int_7, int_5 + 128)) {
                     return false;
                  }
               }

               if (!this.isOccluded(int_4, int_8, int_5)) {
                  return false;
               }

               if (!this.isOccluded(int_4, int_8, int_5 + 128)) {
                  return false;
               }

               return true;
            }

            if (int_3 == 2) {
               if (int_5 < cameraZ2) {
                  if (!this.isOccluded(int_4, int_6, int_5 + 128)) {
                     return false;
                  }

                  if (!this.isOccluded(int_4 + 128, int_6, int_5 + 128)) {
                     return false;
                  }
               }

               if (int_0 > 0) {
                  if (!this.isOccluded(int_4, int_7, int_5 + 128)) {
                     return false;
                  }

                  if (!this.isOccluded(int_4 + 128, int_7, int_5 + 128)) {
                     return false;
                  }
               }

               if (!this.isOccluded(int_4, int_8, int_5 + 128)) {
                  return false;
               }

               if (!this.isOccluded(int_4 + 128, int_8, int_5 + 128)) {
                  return false;
               }

               return true;
            }

            if (int_3 == 4) {
               if (int_4 < cameraX2) {
                  if (!this.isOccluded(int_4 + 128, int_6, int_5)) {
                     return false;
                  }

                  if (!this.isOccluded(int_4 + 128, int_6, int_5 + 128)) {
                     return false;
                  }
               }

               if (int_0 > 0) {
                  if (!this.isOccluded(int_4 + 128, int_7, int_5)) {
                     return false;
                  }

                  if (!this.isOccluded(int_4 + 128, int_7, int_5 + 128)) {
                     return false;
                  }
               }

               if (!this.isOccluded(int_4 + 128, int_8, int_5)) {
                  return false;
               }

               if (!this.isOccluded(int_4 + 128, int_8, int_5 + 128)) {
                  return false;
               }

               return true;
            }

            if (int_3 == 8) {
               if (int_5 > cameraZ2) {
                  if (!this.isOccluded(int_4, int_6, int_5)) {
                     return false;
                  }

                  if (!this.isOccluded(int_4 + 128, int_6, int_5)) {
                     return false;
                  }
               }

               if (int_0 > 0) {
                  if (!this.isOccluded(int_4, int_7, int_5)) {
                     return false;
                  }

                  if (!this.isOccluded(int_4 + 128, int_7, int_5)) {
                     return false;
                  }
               }

               if (!this.isOccluded(int_4, int_8, int_5)) {
                  return false;
               }

               if (!this.isOccluded(int_4 + 128, int_8, int_5)) {
                  return false;
               }

               return true;
            }
         }

         return !this.isOccluded(int_4 + 64, int_9, int_5 + 64) ? false : (int_3 == 16 ? this.isOccluded(int_4, int_8, int_5 + 128) : (int_3 == 32 ? this.isOccluded(int_4 + 128, int_8, int_5 + 128) : (int_3 == 64 ? this.isOccluded(int_4 + 128, int_8, int_5) : (int_3 == 128 ? this.isOccluded(int_4, int_8, int_5) : true))));
      }
   }

   boolean withinTriangle(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7) {
      if (int_1 < int_2 && int_1 < int_3 && int_1 < int_4) {
         return false;
      } else if (int_1 > int_2 && int_1 > int_3 && int_1 > int_4) {
         return false;
      } else if (int_0 < int_5 && int_0 < int_6 && int_0 < int_7) {
         return false;
      } else if (int_0 > int_5 && int_0 > int_6 && int_0 > int_7) {
         return false;
      } else {
         int int_8 = (int_1 - int_2) * (int_6 - int_5) - (int_0 - int_5) * (int_3 - int_2);
         int int_9 = (int_5 - int_7) * (int_1 - int_4) - (int_0 - int_7) * (int_2 - int_4);
         int int_10 = (int_7 - int_6) * (int_1 - int_3) - (int_0 - int_6) * (int_4 - int_3);
         return int_8 * int_10 > 0 && int_10 * int_9 > 0;
      }
   }

   void method360(ModelHeader modeldata_0, int int_0, int int_1, int int_2) {
      Tile tile_0;
      ModelHeader modeldata_1;
      if (int_1 < this.maxX) {
         tile_0 = this.tiles[int_0][int_1 + 1][int_2];
         if (tile_0 != null && tile_0.groundObject != null && tile_0.groundObject.renderable instanceof ModelHeader) {
            modeldata_1 = (ModelHeader) tile_0.groundObject.renderable;
            ModelHeader.method1061(modeldata_0, modeldata_1, 128, 0, 0, true);
         }
      }

      if (int_2 < this.maxX) {
         tile_0 = this.tiles[int_0][int_1][int_2 + 1];
         if (tile_0 != null && tile_0.groundObject != null && tile_0.groundObject.renderable instanceof ModelHeader) {
            modeldata_1 = (ModelHeader) tile_0.groundObject.renderable;
            ModelHeader.method1061(modeldata_0, modeldata_1, 0, 0, 128, true);
         }
      }

      if (int_1 < this.maxX && int_2 < this.maxZ) {
         tile_0 = this.tiles[int_0][int_1 + 1][int_2 + 1];
         if (tile_0 != null && tile_0.groundObject != null && tile_0.groundObject.renderable instanceof ModelHeader) {
            modeldata_1 = (ModelHeader) tile_0.groundObject.renderable;
            ModelHeader.method1061(modeldata_0, modeldata_1, 128, 0, 128, true);
         }
      }

      if (int_1 < this.maxX && int_2 > 0) {
         tile_0 = this.tiles[int_0][int_1 + 1][int_2 - 1];
         if (tile_0 != null && tile_0.groundObject != null && tile_0.groundObject.renderable instanceof ModelHeader) {
            modeldata_1 = (ModelHeader) tile_0.groundObject.renderable;
            ModelHeader.method1061(modeldata_0, modeldata_1, 128, 0, -128, true);
         }
      }

   }

   public void reset() {
      int int_0;
      int int_1;
      for (int_0 = 0; int_0 < this.maxY; int_0++) {
         for (int_1 = 0; int_1 < this.maxX; int_1++) {
            for (int int_2 = 0; int_2 < this.maxZ; int_2++) {
               this.tiles[int_0][int_1][int_2] = null;
            }
         }
      }

      for (int_0 = 0; int_0 < MAX_OCCLUDER_LEVELS; int_0++) {
         for (int_1 = 0; int_1 < levelOccluderCount[int_0]; int_1++) {
            levelOccluders[int_0][int_1] = null;
         }

         levelOccluderCount[int_0] = 0;
      }

      for (int_0 = 0; int_0 < this.entityCount; int_0++) {
         this.objects[int_0] = null;
      }

      this.entityCount = 0;

      for (int_0 = 0; int_0 < entityBuffer.length; int_0++) {
         entityBuffer[int_0] = null;
      }

   }

   boolean isOccluded(int int_0, int int_1, int int_2, int int_3) {
      if (!this.isTileOccluded(int_0, int_1, int_2)) {
         return false;
      } else {
         int int_4 = int_1 << 7;
         int int_5 = int_2 << 7;
         return this.isOccluded(int_4 + 1, this.tileHeights[int_0][int_1][int_2] - int_3, int_5 + 1) && this.isOccluded(int_4 + 128 - 1, this.tileHeights[int_0][int_1 + 1][int_2] - int_3, int_5 + 1) && this.isOccluded(int_4 + 128 - 1, this.tileHeights[int_0][int_1 + 1][int_2 + 1] - int_3, int_5 + 128 - 1) && this.isOccluded(int_4 + 1, this.tileHeights[int_0][int_1][int_2 + 1] - int_3, int_5 + 128 - 1);
      }
   }

   boolean isAreaOccluded(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      int int_6;
      int int_7;
      if (int_2 == int_1 && int_4 == int_3) {
         if (!this.isTileOccluded(int_0, int_1, int_3)) {
            return false;
         } else {
            int_6 = int_1 << 7;
            int_7 = int_3 << 7;
            return this.isOccluded(int_6 + 1, this.tileHeights[int_0][int_1][int_3] - int_5, int_7 + 1) && this.isOccluded(int_6 + 128 - 1, this.tileHeights[int_0][int_1 + 1][int_3] - int_5, int_7 + 1) && this.isOccluded(int_6 + 128 - 1, this.tileHeights[int_0][int_1 + 1][int_3 + 1] - int_5, int_7 + 128 - 1) && this.isOccluded(int_6 + 1, this.tileHeights[int_0][int_1][int_3 + 1] - int_5, int_7 + 128 - 1);
         }
      } else {
         for (int_6 = int_1; int_6 <= int_2; int_6++) {
            for (int_7 = int_3; int_7 <= int_4; int_7++) {
               if (this.tileCycles[int_0][int_6][int_7] == -cycle) {
                  return false;
               }
            }
         }

         int_6 = (int_1 << 7) + 1;
         int_7 = (int_3 << 7) + 2;
         int int_8 = this.tileHeights[int_0][int_1][int_3] - int_5;
         if (!this.isOccluded(int_6, int_8, int_7)) {
            return false;
         } else {
            int int_9 = (int_2 << 7) - 1;
            if (!this.isOccluded(int_9, int_8, int_7)) {
               return false;
            } else {
               int int_10 = (int_4 << 7) - 1;
               if (!this.isOccluded(int_6, int_8, int_10)) {
                  return false;
               } else if (!this.isOccluded(int_9, int_8, int_10)) {
                  return false;
               } else {
                  return true;
               }
            }
         }
      }
   }

   void updateOccluders() {
      int int_0 = levelOccluderCount[anInt147];
      Occluder[] occluders_0 = levelOccluders[anInt147];
      anInt146 = 0;

      for (int int_1 = 0; int_1 < int_0; int_1++) {
         Occluder occluder_0 = occluders_0[int_1];
         int int_2;
         int int_3;
         int int_4;
         int int_6;
         boolean bool_1;
         if (occluder_0.type == 1) {
            int_2 = occluder_0.minTileX - screenCenterX + 25;
            if (int_2 >= 0 && int_2 <= 50) {
               int_3 = occluder_0.minTileZ - screenCenterZ + 25;
               if (int_3 < 0) {
                  int_3 = 0;
               }

               int_4 = occluder_0.maxTileZ - screenCenterZ + 25;
               if (int_4 > 50) {
                  int_4 = 50;
               }

               bool_1 = false;

               while (int_3 <= int_4) {
                  if (renderArea[int_2][int_3++]) {
                     bool_1 = true;
                     break;
                  }
               }

               if (bool_1) {
                  int_6 = cameraX2 - occluder_0.minX;
                  if (int_6 > 32) {
                     occluder_0.testDirection = 1;
                  } else {
                     if (int_6 >= -32) {
                        continue;
                     }

                     occluder_0.testDirection = 2;
                     int_6 = -int_6;
                  }

                  occluder_0.minNormalX = (occluder_0.minZ - cameraZ2 << 8) / int_6;
                  occluder_0.maxNormalX = (occluder_0.maxZ - cameraZ2 << 8) / int_6;
                  occluder_0.minNormalY = (occluder_0.minY - cameraY2 << 8) / int_6;
                  occluder_0.maxNormalY = (occluder_0.maxY - cameraY2 << 8) / int_6;
                  anOccluderArray1[anInt146++] = occluder_0;
               }
            }
         } else if (occluder_0.type == 2) {
            int_2 = occluder_0.minTileZ - screenCenterZ + 25;
            if (int_2 >= 0 && int_2 <= 50) {
               int_3 = occluder_0.minTileX - screenCenterX + 25;
               if (int_3 < 0) {
                  int_3 = 0;
               }

               int_4 = occluder_0.maxTIleX - screenCenterX + 25;
               if (int_4 > 50) {
                  int_4 = 50;
               }

               bool_1 = false;

               while (int_3 <= int_4) {
                  if (renderArea[int_3++][int_2]) {
                     bool_1 = true;
                     break;
                  }
               }

               if (bool_1) {
                  int_6 = cameraZ2 - occluder_0.minZ;
                  if (int_6 > 32) {
                     occluder_0.testDirection = 3;
                  } else {
                     if (int_6 >= -32) {
                        continue;
                     }

                     occluder_0.testDirection = 4;
                     int_6 = -int_6;
                  }

                  occluder_0.anInt158 = (occluder_0.minX - cameraX2 << 8) / int_6;
                  occluder_0.anInt159 = (occluder_0.maxX - cameraX2 << 8) / int_6;
                  occluder_0.minNormalY = (occluder_0.minY - cameraY2 << 8) / int_6;
                  occluder_0.maxNormalY = (occluder_0.maxY - cameraY2 << 8) / int_6;
                  anOccluderArray1[anInt146++] = occluder_0;
               }
            }
         } else if (occluder_0.type == 4) {
            int_2 = occluder_0.minY - cameraY2;
            if (int_2 > 128) {
               int_3 = occluder_0.minTileZ - screenCenterZ + 25;
               if (int_3 < 0) {
                  int_3 = 0;
               }

               int_4 = occluder_0.maxTileZ - screenCenterZ + 25;
               if (int_4 > 50) {
                  int_4 = 50;
               }

               if (int_3 <= int_4) {
                  int int_5 = occluder_0.minTileX - screenCenterX + 25;
                  if (int_5 < 0) {
                     int_5 = 0;
                  }

                  int_6 = occluder_0.maxTIleX - screenCenterX + 25;
                  if (int_6 > 50) {
                     int_6 = 50;
                  }

                  boolean bool_0 = false;

                  label144:
                  for (int int_7 = int_5; int_7 <= int_6; int_7++) {
                     for (int int_8 = int_3; int_8 <= int_4; int_8++) {
                        if (renderArea[int_7][int_8]) {
                           bool_0 = true;
                           break label144;
                        }
                     }
                  }

                  if (bool_0) {
                     occluder_0.testDirection = 5;
                     occluder_0.anInt158 = (occluder_0.minX - cameraX2 << 8) / int_2;
                     occluder_0.anInt159 = (occluder_0.maxX - cameraX2 << 8) / int_2;
                     occluder_0.minNormalX = (occluder_0.minZ - cameraZ2 << 8) / int_2;
                     occluder_0.maxNormalX = (occluder_0.maxZ - cameraZ2 << 8) / int_2;
                     anOccluderArray1[anInt146++] = occluder_0;
                  }
               }
            }
         }
      }

   }

   public WallObject method361(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      return tile_0 == null ? null : tile_0.wallObject;
   }

   public void method362(int[] ints_0, int int_0, int int_1, int int_2, int int_3, int int_4) {
      Tile tile_0 = this.tiles[int_2][int_3][int_4];
      if (tile_0 != null) {
         SceneTilePaint scenetilepaint_0 = tile_0.paint;
         int int_6;
         if (scenetilepaint_0 != null) {
            int int_5 = scenetilepaint_0.rgb;
            if (int_5 != 0) {
               for (int_6 = 0; int_6 < 4; int_6++) {
                  ints_0[int_0] = int_5;
                  ints_0[int_0 + 1] = int_5;
                  ints_0[int_0 + 2] = int_5;
                  ints_0[int_0 + 3] = int_5;
                  int_0 += int_1;
               }

            }
         } else {
            SceneTileModel scenetilemodel_0 = tile_0.overlay;
            if (scenetilemodel_0 != null) {
               int_6 = scenetilemodel_0.shape;
               int int_7 = scenetilemodel_0.rotation;
               int int_8 = scenetilemodel_0.underlay;
               int int_9 = scenetilemodel_0.overlay;
               int[] ints_1 = this.TILE_MASK_2D[int_6];
               int[] ints_2 = this.TILE_ROTATION_2D[int_7];
               int int_10 = 0;
               int int_11;
               if (int_8 != 0) {
                  for (int_11 = 0; int_11 < 4; int_11++) {
                     ints_0[int_0] = ints_1[ints_2[int_10++]] == 0 ? int_8 : int_9;
                     ints_0[int_0 + 1] = ints_1[ints_2[int_10++]] == 0 ? int_8 : int_9;
                     ints_0[int_0 + 2] = ints_1[ints_2[int_10++]] == 0 ? int_8 : int_9;
                     ints_0[int_0 + 3] = ints_1[ints_2[int_10++]] == 0 ? int_8 : int_9;
                     int_0 += int_1;
                  }
               } else {
                  for (int_11 = 0; int_11 < 4; int_11++) {
                     if (ints_1[ints_2[int_10++]] != 0) {
                        ints_0[int_0] = int_9;
                     }

                     if (ints_1[ints_2[int_10++]] != 0) {
                        ints_0[int_0 + 1] = int_9;
                     }

                     if (ints_1[ints_2[int_10++]] != 0) {
                        ints_0[int_0 + 2] = int_9;
                     }

                     if (ints_1[ints_2[int_10++]] != 0) {
                        ints_0[int_0 + 3] = int_9;
                     }

                     int_0 += int_1;
                  }
               }

            }
         }
      }
   }

   public DecorativeObject method363(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      return tile_0 == null ? null : tile_0.decorativeObject;
   }

   public void method364(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      if (tile_0 != null) {
         tile_0.itemLayer = null;
      }
   }

   public int getWallObjectUID(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      return tile_0 != null && tile_0.wallObject != null ? tile_0.wallObject.hash : 0;
   }

   public int getWallDecorationUID(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      return tile_0 != null && tile_0.decorativeObject != null ? tile_0.decorativeObject.hash : 0;
   }

   public int getGroundDecorationUID(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      return tile_0 != null && tile_0.groundObject != null ? tile_0.groundObject.hash : 0;
   }

   public int getObjectConfig(int int_0, int int_1, int int_2, int int_3) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      if (tile_0 == null) {
         return -1;
      } else if (tile_0.wallObject != null && tile_0.wallObject.hash == int_3) {
         return tile_0.wallObject.config & 0xFF;
      } else if (tile_0.decorativeObject != null && tile_0.decorativeObject.hash == int_3) {
         return tile_0.decorativeObject.renderInfoBitPacked & 0xFF;
      } else if (tile_0.groundObject != null && tile_0.groundObject.hash == int_3) {
         return tile_0.groundObject.renderInfoBitPacked & 0xFF;
      } else {
         for (int int_4 = 0; int_4 < tile_0.entityCount; int_4++) {
            if (int_3 == tile_0.objects[int_4].hash) {
               return tile_0.objects[int_4].flags & 0xFF;
            }
         }

         return -1;
      }
   }

   public int getInteractableObjectUID(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      if (tile_0 == null) {
         return 0;
      } else {
         for (int int_3 = 0; int_3 < tile_0.entityCount; int_3++) {
            GameObject gameobject_0 = tile_0.objects[int_3];
            if ((gameobject_0.hash >> 29 & 0x3) == 2 && int_1 == gameobject_0.relativeX && int_2 == gameobject_0.relativeY) {
               return gameobject_0.hash;
            }
         }

         return 0;
      }
   }

   public GameObject method370(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      if (tile_0 == null) {
         return null;
      } else {
         for (int int_3 = 0; int_3 < tile_0.entityCount; int_3++) {
            GameObject gameobject_0 = tile_0.objects[int_3];
            if ((gameobject_0.hash >> 29 & 0x3) == 2 && int_1 == gameobject_0.relativeX && int_2 == gameobject_0.relativeY) {
               return gameobject_0;
            }
         }

         return null;
      }
   }

   void draw(Tile tile_0, boolean bool_0) {
      tileDeque.addFront(tile_0);

      while (true) {
         Tile tile_1;
         int int_0;
         int int_1;
         int int_2;
         int int_3;
         Tile[][] tiles_0;
         Tile tile_2;
         int int_4;
         int int_6;
         int int_7;
         int int_8;
         int int_9;
         int int_10;
         do {
            do {
               do {
                  do {
                     do {
                        do {
                           while (true) {
                              WallObject wallobject_0;
                              GameObject gameobject_0;
                              boolean bool_1;
                              int int_5;
                              int int_11;
                              int int_12;
                              Tile tile_5;
                              while (true) {
                                 do {
                                    tile_1 = (Tile) tileDeque.popFront();
                                    if (tile_1 == null) {
                                       return;
                                    }
                                 } while (!tile_1.visible);

                                 int_0 = tile_1.x;
                                 int_1 = tile_1.y;
                                 int_2 = tile_1.plane;
                                 int_3 = tile_1.renderLevel;
                                 tiles_0 = this.tiles[int_2];
                                 if (!tile_1.draw) {
                                    break;
                                 }

                                 if (bool_0) {
                                    if (int_2 > 0) {
                                       tile_2 = this.tiles[int_2 - 1][int_0][int_1];
                                       if (tile_2 != null && tile_2.visible) {
                                          continue;
                                       }
                                    }

                                    if (int_0 <= screenCenterX && int_0 > minTileX) {
                                       tile_2 = tiles_0[int_0 - 1][int_1];
                                       if (tile_2 != null && tile_2.visible && (tile_2.draw || (tile_1.flags & 0x1) == 0)) {
                                          continue;
                                       }
                                    }

                                    if (int_0 >= screenCenterX && int_0 < maxTileX - 1) {
                                       tile_2 = tiles_0[int_0 + 1][int_1];
                                       if (tile_2 != null && tile_2.visible && (tile_2.draw || (tile_1.flags & 0x4) == 0)) {
                                          continue;
                                       }
                                    }

                                    if (int_1 <= screenCenterZ && int_1 > minTileZ) {
                                       tile_2 = tiles_0[int_0][int_1 - 1];
                                       if (tile_2 != null && tile_2.visible && (tile_2.draw || (tile_1.flags & 0x8) == 0)) {
                                          continue;
                                       }
                                    }

                                    if (int_1 >= screenCenterZ && int_1 < maxTileZ - 1) {
                                       tile_2 = tiles_0[int_0][int_1 + 1];
                                       if (tile_2 != null && tile_2.visible && (tile_2.draw || (tile_1.flags & 0x2) == 0)) {
                                          continue;
                                       }
                                    }
                                 } else {
                                    bool_0 = true;
                                 }

                                 tile_1.draw = false;
                                 if (tile_1.bridge != null) {
                                    tile_2 = tile_1.bridge;
                                    if (tile_2.paint != null) {
                                       if (!this.isTileOccluded(0, int_0, int_1)) {
                                          this.drawTileUnderlay(tile_2.paint, 0, pitchSin, pitchCos, yawSin, yawCos, int_0, int_1);
                                       }
                                    } else if (tile_2.overlay != null && !this.isTileOccluded(0, int_0, int_1)) {
                                       this.drawTileOverlay(tile_2.overlay, pitchSin, pitchCos, yawSin, yawCos, int_0, int_1);
                                    }

                                    wallobject_0 = tile_2.wallObject;
                                    if (wallobject_0 != null) {
                                       wallobject_0.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, wallobject_0.x - cameraX2, wallobject_0.floor - cameraY2, wallobject_0.y - cameraZ2, wallobject_0.hash);
                                    }

                                    for (int_4 = 0; int_4 < tile_2.entityCount; int_4++) {
                                       gameobject_0 = tile_2.objects[int_4];
                                       if (gameobject_0 != null) {
                                          gameobject_0.renderable.draw(gameobject_0.orientation, pitchSin, pitchCos, yawSin, yawCos, gameobject_0.x - cameraX2, gameobject_0.height - cameraY2, gameobject_0.y - cameraZ2, gameobject_0.hash);
                                       }
                                    }
                                 }

                                 bool_1 = false;
                                 if (tile_1.paint != null) {
                                    if (!this.isTileOccluded(int_3, int_0, int_1)) {
                                       bool_1 = true;
                                       if (tile_1.paint.neColor != 12345678 || checkClick && int_2 <= anInt148) {
                                          this.drawTileUnderlay(tile_1.paint, int_3, pitchSin, pitchCos, yawSin, yawCos, int_0, int_1);
                                       }
                                    }
                                 } else if (tile_1.overlay != null && !this.isTileOccluded(int_3, int_0, int_1)) {
                                    bool_1 = true;
                                    this.drawTileOverlay(tile_1.overlay, pitchSin, pitchCos, yawSin, yawCos, int_0, int_1);
                                 }

                                 int_5 = 0;
                                 int_4 = 0;
                                 WallObject wallobject_2 = tile_1.wallObject;
                                 DecorativeObject decorativeobject_0 = tile_1.decorativeObject;
                                 if (wallobject_2 != null || decorativeobject_0 != null) {
                                    if (int_0 == screenCenterX) {
                                       ++int_5;
                                    } else if (screenCenterX < int_0) {
                                       int_5 += 2;
                                    }

                                    if (int_1 == screenCenterZ) {
                                       int_5 += 3;
                                    } else if (screenCenterZ > int_1) {
                                       int_5 += 6;
                                    }

                                    int_4 = anIntArray36[int_5];
                                    tile_1.wallDrawFlags = TILE_WALL_DRAW_FLAGS_1[int_5];
                                 }

                                 if (wallobject_2 != null) {
                                    if ((wallobject_2.orientationA & anIntArray35[int_5]) != 0) {
                                       if (wallobject_2.orientationA == 16) {
                                          tile_1.wallCullDirection = 3;
                                          tile_1.wallUncullDirection = WALL_UNCULL_FLAGS_0[int_5];
                                          tile_1.wallCullOppositeDirection = 3 - tile_1.wallUncullDirection;
                                       } else if (wallobject_2.orientationA == 32) {
                                          tile_1.wallCullDirection = 6;
                                          tile_1.wallUncullDirection = WALL_UNCULL_FLAGS_1[int_5];
                                          tile_1.wallCullOppositeDirection = 6 - tile_1.wallUncullDirection;
                                       } else if (wallobject_2.orientationA == 64) {
                                          tile_1.wallCullDirection = 12;
                                          tile_1.wallUncullDirection = WALL_UNCULL_FLAGS_2[int_5];
                                          tile_1.wallCullOppositeDirection = 12 - tile_1.wallUncullDirection;
                                       } else {
                                          tile_1.wallCullDirection = 9;
                                          tile_1.wallUncullDirection = WALL_UNCULL_FLAGS_3[int_5];
                                          tile_1.wallCullOppositeDirection = 9 - tile_1.wallUncullDirection;
                                       }
                                    } else {
                                       tile_1.wallCullDirection = 0;
                                    }

                                    if ((wallobject_2.orientationA & int_4) != 0 && !this.isWallOccluded(int_3, int_0, int_1, wallobject_2.orientationA)) {
                                       wallobject_2.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, wallobject_2.x - cameraX2, wallobject_2.floor - cameraY2, wallobject_2.y - cameraZ2, wallobject_2.hash);
                                    }

                                    if ((wallobject_2.orientationB & int_4) != 0 && !this.isWallOccluded(int_3, int_0, int_1, wallobject_2.orientationB)) {
                                       wallobject_2.renderable2.draw(0, pitchSin, pitchCos, yawSin, yawCos, wallobject_2.x - cameraX2, wallobject_2.floor - cameraY2, wallobject_2.y - cameraZ2, wallobject_2.hash);
                                    }
                                 }

                                 if (decorativeobject_0 != null && !this.isOccluded(int_3, int_0, int_1, decorativeobject_0.renderable1.modelHeight)) {
                                    if ((decorativeobject_0.renderFlag & int_4) != 0) {
                                       decorativeobject_0.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, decorativeobject_0.x - cameraX2 + decorativeobject_0.offsetX, decorativeobject_0.floor - cameraY2, decorativeobject_0.y - cameraZ2 + decorativeobject_0.offsetY, decorativeobject_0.hash);
                                    } else if (decorativeobject_0.renderFlag == 256) {
                                       int_7 = decorativeobject_0.x - cameraX2;
                                       int_8 = decorativeobject_0.floor - cameraY2;
                                       int_9 = decorativeobject_0.y - cameraZ2;
                                       int_11 = decorativeobject_0.rotation;
                                       if (int_11 != 1 && int_11 != 2) {
                                          int_12 = int_7;
                                       } else {
                                          int_12 = -int_7;
                                       }

                                       int int_13;
                                       if (int_11 != 2 && int_11 != 3) {
                                          int_13 = int_9;
                                       } else {
                                          int_13 = -int_9;
                                       }

                                       if (int_13 < int_12) {
                                          decorativeobject_0.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, int_7 + decorativeobject_0.offsetX, int_8, int_9 + decorativeobject_0.offsetY, decorativeobject_0.hash);
                                       } else if (decorativeobject_0.renderable2 != null) {
                                          decorativeobject_0.renderable2.draw(0, pitchSin, pitchCos, yawSin, yawCos, int_7, int_8, int_9, decorativeobject_0.hash);
                                       }
                                    }
                                 }

                                 if (bool_1) {
                                    GroundObject groundobject_0 = tile_1.groundObject;
                                    if (groundobject_0 != null) {
                                       groundobject_0.renderable.draw(0, pitchSin, pitchCos, yawSin, yawCos, groundobject_0.x - cameraX2, groundobject_0.floor - cameraY2, groundobject_0.y - cameraZ2, groundobject_0.hash);
                                    }

                                    ItemLayer itemlayer_0 = tile_1.itemLayer;
                                    if (itemlayer_0 != null && itemlayer_0.height == 0) {
                                       if (itemlayer_0.middle != null) {
                                          itemlayer_0.middle.draw(0, pitchSin, pitchCos, yawSin, yawCos, itemlayer_0.x - cameraX2, itemlayer_0.hash - cameraY2, itemlayer_0.y - cameraZ2, itemlayer_0.flags);
                                       }

                                       if (itemlayer_0.top != null) {
                                          itemlayer_0.top.draw(0, pitchSin, pitchCos, yawSin, yawCos, itemlayer_0.x - cameraX2, itemlayer_0.hash - cameraY2, itemlayer_0.y - cameraZ2, itemlayer_0.flags);
                                       }

                                       if (itemlayer_0.bottom != null) {
                                          itemlayer_0.bottom.draw(0, pitchSin, pitchCos, yawSin, yawCos, itemlayer_0.x - cameraX2, itemlayer_0.hash - cameraY2, itemlayer_0.y - cameraZ2, itemlayer_0.flags);
                                       }
                                    }
                                 }

                                 int_7 = tile_1.flags;
                                 if (int_7 != 0) {
                                    if (int_0 < screenCenterX && (int_7 & 0x4) != 0) {
                                       tile_5 = tiles_0[int_0 + 1][int_1];
                                       if (tile_5 != null && tile_5.visible) {
                                          tileDeque.addFront(tile_5);
                                       }
                                    }

                                    if (int_1 < screenCenterZ && (int_7 & 0x2) != 0) {
                                       tile_5 = tiles_0[int_0][int_1 + 1];
                                       if (tile_5 != null && tile_5.visible) {
                                          tileDeque.addFront(tile_5);
                                       }
                                    }

                                    if (int_0 > screenCenterX && (int_7 & 0x1) != 0) {
                                       tile_5 = tiles_0[int_0 - 1][int_1];
                                       if (tile_5 != null && tile_5.visible) {
                                          tileDeque.addFront(tile_5);
                                       }
                                    }

                                    if (int_1 > screenCenterZ && (int_7 & 0x8) != 0) {
                                       tile_5 = tiles_0[int_0][int_1 - 1];
                                       if (tile_5 != null && tile_5.visible) {
                                          tileDeque.addFront(tile_5);
                                       }
                                    }
                                 }
                                 break;
                              }

                              if (tile_1.wallCullDirection != 0) {
                                 bool_1 = true;

                                 for (int_5 = 0; int_5 < tile_1.entityCount; int_5++) {
                                    if (tile_1.objects[int_5].cycle != cycle && (tile_1.entityFlags[int_5] & tile_1.wallCullDirection) == tile_1.wallUncullDirection) {
                                       bool_1 = false;
                                       break;
                                    }
                                 }

                                 if (bool_1) {
                                    wallobject_0 = tile_1.wallObject;
                                    if (!this.isWallOccluded(int_3, int_0, int_1, wallobject_0.orientationA)) {
                                       wallobject_0.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, wallobject_0.x - cameraX2, wallobject_0.floor - cameraY2, wallobject_0.y - cameraZ2, wallobject_0.hash);
                                    }

                                    tile_1.wallCullDirection = 0;
                                 }
                              }

                              if (!tile_1.drawEntities) {
                                 break;
                              }

                              try {
                                 int int_14 = tile_1.entityCount;
                                 tile_1.drawEntities = false;
                                 int_5 = 0;

                                 label583:
                                 for (int_4 = 0; int_4 < int_14; int_4++) {
                                    gameobject_0 = tile_1.objects[int_4];
                                    if (gameobject_0.cycle != cycle) {
                                       for (int_6 = gameobject_0.relativeX; int_6 <= gameobject_0.offsetX; int_6++) {
                                          for (int_7 = gameobject_0.relativeY; int_7 <= gameobject_0.offsetY; int_7++) {
                                             tile_5 = tiles_0[int_6][int_7];
                                             if (tile_5.draw) {
                                                tile_1.drawEntities = true;
                                                continue label583;
                                             }

                                             if (tile_5.wallCullDirection != 0) {
                                                int_9 = 0;
                                                if (int_6 > gameobject_0.relativeX) {
                                                   ++int_9;
                                                }

                                                if (int_6 < gameobject_0.offsetX) {
                                                   int_9 += 4;
                                                }

                                                if (int_7 > gameobject_0.relativeY) {
                                                   int_9 += 8;
                                                }

                                                if (int_7 < gameobject_0.offsetY) {
                                                   int_9 += 2;
                                                }

                                                if ((int_9 & tile_5.wallCullDirection) == tile_1.wallCullOppositeDirection) {
                                                   tile_1.drawEntities = true;
                                                   continue label583;
                                                }
                                             }
                                          }
                                       }

                                       entityBuffer[int_5++] = gameobject_0;
                                       int_6 = screenCenterX - gameobject_0.relativeX;
                                       int_7 = gameobject_0.offsetX - screenCenterX;
                                       if (int_7 > int_6) {
                                          int_6 = int_7;
                                       }

                                       int_8 = screenCenterZ - gameobject_0.relativeY;
                                       int_9 = gameobject_0.offsetY - screenCenterZ;
                                       if (int_9 > int_8) {
                                          gameobject_0.drawPriority = int_6 + int_9;
                                       } else {
                                          gameobject_0.drawPriority = int_6 + int_8;
                                       }
                                    }
                                 }

                                 while (int_5 > 0) {
                                    int_4 = -50;
                                    int_10 = -1;

                                    for (int_6 = 0; int_6 < int_5; int_6++) {
                                       GameObject gameobject_1 = entityBuffer[int_6];
                                       if (gameobject_1.cycle != cycle) {
                                          if (gameobject_1.drawPriority > int_4) {
                                             int_4 = gameobject_1.drawPriority;
                                             int_10 = int_6;
                                          } else if (int_4 == gameobject_1.drawPriority) {
                                             int_8 = gameobject_1.x - cameraX2;
                                             int_9 = gameobject_1.y - cameraZ2;
                                             int_11 = entityBuffer[int_10].x - cameraX2;
                                             int_12 = entityBuffer[int_10].y - cameraZ2;
                                             if (int_8 * int_8 + int_9 * int_9 > int_11 * int_11 + int_12 * int_12) {
                                                int_10 = int_6;
                                             }
                                          }
                                       }
                                    }

                                    if (int_10 == -1) {
                                       break;
                                    }

                                    GameObject gameobject_2 = entityBuffer[int_10];
                                    gameobject_2.cycle = cycle;
                                    if (!this.isAreaOccluded(int_3, gameobject_2.relativeX, gameobject_2.offsetX, gameobject_2.relativeY, gameobject_2.offsetY, gameobject_2.renderable.modelHeight)) {
                                       gameobject_2.renderable.draw(gameobject_2.orientation, pitchSin, pitchCos, yawSin, yawCos, gameobject_2.x - cameraX2, gameobject_2.height - cameraY2, gameobject_2.y - cameraZ2, gameobject_2.hash);
                                    }

                                    for (int_7 = gameobject_2.relativeX; int_7 <= gameobject_2.offsetX; int_7++) {
                                       for (int_8 = gameobject_2.relativeY; int_8 <= gameobject_2.offsetY; int_8++) {
                                          Tile tile_3 = tiles_0[int_7][int_8];
                                          if (tile_3.wallCullDirection != 0) {
                                             tileDeque.addFront(tile_3);
                                          } else if ((int_7 != int_0 || int_8 != int_1) && tile_3.visible) {
                                             tileDeque.addFront(tile_3);
                                          }
                                       }
                                    }
                                 }

                                 if (!tile_1.drawEntities) {
                                    break;
                                 }
                              } catch (Exception exception_0) {
                                 tile_1.drawEntities = false;
                                 break;
                              }
                           }
                        } while (!tile_1.visible);
                     } while (tile_1.wallCullDirection != 0);

                     if (int_0 > screenCenterX || int_0 <= minTileX) {
                        break;
                     }

                     tile_2 = tiles_0[int_0 - 1][int_1];
                  } while (tile_2 != null && tile_2.visible);

                  if (int_0 < screenCenterX || int_0 >= maxTileX - 1) {
                     break;
                  }

                  tile_2 = tiles_0[int_0 + 1][int_1];
               } while (tile_2 != null && tile_2.visible);

               if (int_1 > screenCenterZ || int_1 <= minTileZ) {
                  break;
               }

               tile_2 = tiles_0[int_0][int_1 - 1];
            } while (tile_2 != null && tile_2.visible);

            if (int_1 < screenCenterZ || int_1 >= maxTileZ - 1) {
               break;
            }

            tile_2 = tiles_0[int_0][int_1 + 1];
         } while (tile_2 != null && tile_2.visible);

         tile_1.visible = false;
         --tileUpdateCount;
         ItemLayer itemlayer_1 = tile_1.itemLayer;
         if (itemlayer_1 != null && itemlayer_1.height != 0) {
            if (itemlayer_1.middle != null) {
               itemlayer_1.middle.draw(0, pitchSin, pitchCos, yawSin, yawCos, itemlayer_1.x - cameraX2, itemlayer_1.hash - cameraY2 - itemlayer_1.height, itemlayer_1.y - cameraZ2, itemlayer_1.flags);
            }

            if (itemlayer_1.top != null) {
               itemlayer_1.top.draw(0, pitchSin, pitchCos, yawSin, yawCos, itemlayer_1.x - cameraX2, itemlayer_1.hash - cameraY2 - itemlayer_1.height, itemlayer_1.y - cameraZ2, itemlayer_1.flags);
            }

            if (itemlayer_1.bottom != null) {
               itemlayer_1.bottom.draw(0, pitchSin, pitchCos, yawSin, yawCos, itemlayer_1.x - cameraX2, itemlayer_1.hash - cameraY2 - itemlayer_1.height, itemlayer_1.y - cameraZ2, itemlayer_1.flags);
            }
         }

         if (tile_1.wallDrawFlags != 0) {
            DecorativeObject decorativeobject_1 = tile_1.decorativeObject;
            if (decorativeobject_1 != null && !this.isOccluded(int_3, int_0, int_1, decorativeobject_1.renderable1.modelHeight)) {
               if ((decorativeobject_1.renderFlag & tile_1.wallDrawFlags) != 0) {
                  decorativeobject_1.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, decorativeobject_1.x - cameraX2 + decorativeobject_1.offsetX, decorativeobject_1.floor - cameraY2, decorativeobject_1.y - cameraZ2 + decorativeobject_1.offsetY, decorativeobject_1.hash);
               } else if (decorativeobject_1.renderFlag == 256) {
                  int_4 = decorativeobject_1.x - cameraX2;
                  int_10 = decorativeobject_1.floor - cameraY2;
                  int_6 = decorativeobject_1.y - cameraZ2;
                  int_7 = decorativeobject_1.rotation;
                  if (int_7 != 1 && int_7 != 2) {
                     int_8 = int_4;
                  } else {
                     int_8 = -int_4;
                  }

                  if (int_7 != 2 && int_7 != 3) {
                     int_9 = int_6;
                  } else {
                     int_9 = -int_6;
                  }

                  if (int_9 >= int_8) {
                     decorativeobject_1.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, int_4 + decorativeobject_1.offsetX, int_10, int_6 + decorativeobject_1.offsetY, decorativeobject_1.hash);
                  } else if (decorativeobject_1.renderable2 != null) {
                     decorativeobject_1.renderable2.draw(0, pitchSin, pitchCos, yawSin, yawCos, int_4, int_10, int_6, decorativeobject_1.hash);
                  }
               }
            }

            WallObject wallobject_1 = tile_1.wallObject;
            if (wallobject_1 != null) {
               if ((wallobject_1.orientationB & tile_1.wallDrawFlags) != 0 && !this.isWallOccluded(int_3, int_0, int_1, wallobject_1.orientationB)) {
                  wallobject_1.renderable2.draw(0, pitchSin, pitchCos, yawSin, yawCos, wallobject_1.x - cameraX2, wallobject_1.floor - cameraY2, wallobject_1.y - cameraZ2, wallobject_1.hash);
               }

               if ((wallobject_1.orientationA & tile_1.wallDrawFlags) != 0 && !this.isWallOccluded(int_3, int_0, int_1, wallobject_1.orientationA)) {
                  wallobject_1.renderable1.draw(0, pitchSin, pitchCos, yawSin, yawCos, wallobject_1.x - cameraX2, wallobject_1.floor - cameraY2, wallobject_1.y - cameraZ2, wallobject_1.hash);
               }
            }
         }

         Tile tile_4;
         if (int_2 < this.maxY - 1) {
            tile_4 = this.tiles[int_2 + 1][int_0][int_1];
            if (tile_4 != null && tile_4.visible) {
               tileDeque.addFront(tile_4);
            }
         }

         if (int_0 < screenCenterX) {
            tile_4 = tiles_0[int_0 + 1][int_1];
            if (tile_4 != null && tile_4.visible) {
               tileDeque.addFront(tile_4);
            }
         }

         if (int_1 < screenCenterZ) {
            tile_4 = tiles_0[int_0][int_1 + 1];
            if (tile_4 != null && tile_4.visible) {
               tileDeque.addFront(tile_4);
            }
         }

         if (int_0 > screenCenterX) {
            tile_4 = tiles_0[int_0 - 1][int_1];
            if (tile_4 != null && tile_4.visible) {
               tileDeque.addFront(tile_4);
            }
         }

         if (int_1 > screenCenterZ) {
            tile_4 = tiles_0[int_0][int_1 - 1];
            if (tile_4 != null && tile_4.visible) {
               tileDeque.addFront(tile_4);
            }
         }
      }
   }

   public void addItemPile(int int_0, int int_1, int int_2, int int_3, Renderable renderable_0, int int_4, Renderable renderable_1, Renderable renderable_2) {
      ItemLayer itemlayer_0 = new ItemLayer();
      itemlayer_0.bottom = renderable_0;
      itemlayer_0.x = int_1 * 128 + 64;
      itemlayer_0.y = int_2 * 128 + 64;
      itemlayer_0.hash = int_3;
      itemlayer_0.flags = int_4;
      itemlayer_0.middle = renderable_1;
      itemlayer_0.top = renderable_2;
      int int_5 = 0;
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      if (tile_0 != null) {
         for (int int_6 = 0; int_6 < tile_0.entityCount; int_6++) {
            if ((tile_0.objects[int_6].flags & 0x100) == 256 && tile_0.objects[int_6].renderable instanceof Model) {
               Model model_0 = (Model) tile_0.objects[int_6].renderable;
               model_0.calculateDiagonals();
               if (model_0.modelHeight > int_5) {
                  int_5 = model_0.modelHeight;
               }
            }
         }
      }

      itemlayer_0.height = int_5;
      if (this.tiles[int_0][int_1][int_2] == null) {
         this.tiles[int_0][int_1][int_2] = new Tile(int_0, int_1, int_2);
      }

      this.tiles[int_0][int_1][int_2].itemLayer = itemlayer_0;
   }

   public void method371() {
      viewportWalking = true;
   }

   public GroundObject method372(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      return tile_0 != null && tile_0.groundObject != null ? tile_0.groundObject : null;
   }

   public void method373(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      if (tile_0 != null) {
         tile_0.wallObject = null;
      }
   }

   public void method374(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      if (tile_0 != null) {
         tile_0.decorativeObject = null;
      }
   }

   public void method375(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      if (tile_0 != null) {
         for (int int_3 = 0; int_3 < tile_0.entityCount; int_3++) {
            GameObject gameobject_0 = tile_0.objects[int_3];
            if ((gameobject_0.hash >> 29 & 0x3) == 2 && int_1 == gameobject_0.relativeX && int_2 == gameobject_0.relativeY) {
               this.removeEntity(gameobject_0);
               return;
            }
         }

      }
   }

   public void method376(int int_0, int int_1, int int_2) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      if (tile_0 != null) {
         tile_0.groundObject = null;
      }
   }

   public boolean method377(int int_0, int int_1, int int_2, int int_3, int int_4, Renderable renderable_0, int int_5, int int_6, boolean bool_0) {
      if (renderable_0 == null) {
         return true;
      } else {
         int int_7 = int_1 - int_4;
         int int_8 = int_2 - int_4;
         int int_9 = int_4 + int_1;
         int int_10 = int_2 + int_4;
         if (bool_0) {
            if (int_5 > 640 && int_5 < 1408) {
               int_10 += 128;
            }

            if (int_5 > 1152 && int_5 < 1920) {
               int_9 += 128;
            }

            if (int_5 > 1664 || int_5 < 384) {
               int_8 -= 128;
            }

            if (int_5 > 128 && int_5 < 896) {
               int_7 -= 128;
            }
         }

         int_7 /= 128;
         int_8 /= 128;
         int_9 /= 128;
         int_10 /= 128;
         return this.addEntityMarker(int_0, int_7, int_8, int_9 - int_7 + 1, int_10 - int_8 + 1, int_1, int_2, int_3, renderable_0, int_5, true, int_6, 0);
      }
   }

   public boolean method378(int int_0, int int_1, int int_2, int int_3, int int_4, Renderable renderable_0, int int_5, int int_6, int int_7, int int_8, int int_9, int int_10) {
      return renderable_0 == null ? true : this.addEntityMarker(int_0, int_7, int_8, int_9 - int_7 + 1, int_10 - int_8 + 1, int_1, int_2, int_3, renderable_0, int_5, true, int_6, 0);
   }

   public void groundObjectSpawned(int int_0, int int_1, int int_2, int int_3, Renderable renderable_0, int int_4, int int_5) {
      if (renderable_0 != null) {
         GroundObject groundobject_0 = new GroundObject();
         groundobject_0.renderable = renderable_0;
         groundobject_0.x = int_1 * 128 + 64;
         groundobject_0.y = int_2 * 128 + 64;
         groundobject_0.floor = int_3;
         groundobject_0.hash = int_4;
         groundobject_0.renderInfoBitPacked = int_5;
         if (this.tiles[int_0][int_1][int_2] == null) {
            this.tiles[int_0][int_1][int_2] = new Tile(int_0, int_1, int_2);
         }

         this.tiles[int_0][int_1][int_2].groundObject = groundobject_0;
      }
   }

   public boolean method379(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, Renderable renderable_0, int int_6, int int_7, int int_8) {
      if (renderable_0 == null) {
         return true;
      } else {
         int int_9 = int_4 * 64 + int_1 * 128;
         int int_10 = int_5 * 64 + int_2 * 128;
         return this.addEntityMarker(int_0, int_1, int_2, int_4, int_5, int_9, int_10, int_3, renderable_0, int_6, false, int_7, int_8);
      }
   }

   public void addBoundary(int int_0, int int_1, int int_2, int int_3, Renderable renderable_0, Renderable renderable_1, int int_4, int int_5, int int_6, int int_7) {
      if (renderable_0 != null || renderable_1 != null) {
         WallObject wallobject_0 = new WallObject();
         wallobject_0.hash = int_6;
         wallobject_0.config = int_7;
         wallobject_0.x = int_1 * 128 + 64;
         wallobject_0.y = int_2 * 128 + 64;
         wallobject_0.floor = int_3;
         wallobject_0.renderable1 = renderable_0;
         wallobject_0.renderable2 = renderable_1;
         wallobject_0.orientationA = int_4;
         wallobject_0.orientationB = int_5;

         for (int int_8 = int_0; int_8 >= 0; --int_8) {
            if (this.tiles[int_8][int_1][int_2] == null) {
               this.tiles[int_8][int_1][int_2] = new Tile(int_8, int_1, int_2);
            }
         }

         this.tiles[int_0][int_1][int_2].wallObject = wallobject_0;
      }
   }

   public void addBoundaryDecoration(int int_0, int int_1, int int_2, int int_3, Renderable renderable_0, Renderable renderable_1, int int_4, int int_5, int int_6, int int_7, int int_8, int int_9) {
      if (renderable_0 != null) {
         DecorativeObject decorativeobject_0 = new DecorativeObject();
         decorativeobject_0.hash = int_8;
         decorativeobject_0.renderInfoBitPacked = int_9;
         decorativeobject_0.x = int_1 * 128 + 64;
         decorativeobject_0.y = int_2 * 128 + 64;
         decorativeobject_0.floor = int_3;
         decorativeobject_0.renderable1 = renderable_0;
         decorativeobject_0.renderable2 = renderable_1;
         decorativeobject_0.renderFlag = int_4;
         decorativeobject_0.rotation = int_5;
         decorativeobject_0.offsetX = int_6;
         decorativeobject_0.offsetY = int_7;

         for (int int_10 = int_0; int_10 >= 0; --int_10) {
            if (this.tiles[int_10][int_1][int_2] == null) {
               this.tiles[int_10][int_1][int_2] = new Tile(int_10, int_1, int_2);
            }
         }

         this.tiles[int_0][int_1][int_2].decorativeObject = decorativeobject_0;
      }
   }

   public void draw(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      if (int_0 < 0) {
         int_0 = 0;
      } else if (int_0 >= this.maxX * 128) {
         int_0 = this.maxX * 128 - 1;
      }

      if (int_2 < 0) {
         int_2 = 0;
      } else if (int_2 >= this.maxZ * 128) {
         int_2 = this.maxZ * 128 - 1;
      }

      ++cycle;
      pitchSin = Graphics3D.SINE[int_3];
      pitchCos = Graphics3D.COSINE[int_3];
      yawSin = Graphics3D.SINE[int_4];
      yawCos = Graphics3D.COSINE[int_4];
      renderArea = visibilityMaps[(int_3 - 128) / 32][int_4 / 64];
      cameraX2 = int_0;
      cameraY2 = int_1;
      cameraZ2 = int_2;
      screenCenterX = int_0 / 128;
      screenCenterZ = int_2 / 128;
      anInt147 = int_5;
      minTileX = screenCenterX - 25;
      if (minTileX < 0) {
         minTileX = 0;
      }

      minTileZ = screenCenterZ - 25;
      if (minTileZ < 0) {
         minTileZ = 0;
      }

      maxTileX = screenCenterX + 25;
      if (maxTileX > this.maxX) {
         maxTileX = this.maxX;
      }

      maxTileZ = screenCenterZ + 25;
      if (maxTileZ > this.maxZ) {
         maxTileZ = this.maxZ;
      }

      this.updateOccluders();
      tileUpdateCount = 0;

      int int_6;
      Tile[][] tiles_0;
      int int_7;
      int int_8;
      for (int_6 = this.minLevel; int_6 < this.maxY; int_6++) {
         tiles_0 = this.tiles[int_6];

         for (int_7 = minTileX; int_7 < maxTileX; int_7++) {
            for (int_8 = minTileZ; int_8 < maxTileZ; int_8++) {
               Tile tile_0 = tiles_0[int_7][int_8];
               if (tile_0 != null) {
                  if (tile_0.physicalLevel > int_5 || !renderArea[int_7 - screenCenterX + 25][int_8 - screenCenterZ + 25] && this.tileHeights[int_6][int_7][int_8] - int_1 < 2000) {
                     tile_0.draw = false;
                     tile_0.visible = false;
                     tile_0.wallCullDirection = 0;
                  } else {
                     tile_0.draw = true;
                     tile_0.visible = true;
                     if (tile_0.entityCount > 0) {
                        tile_0.drawEntities = true;
                     } else {
                        tile_0.drawEntities = false;
                     }

                     ++tileUpdateCount;
                  }
               }
            }
         }
      }

      int int_9;
      int int_10;
      int int_11;
      int int_12;
      Tile tile_1;
      for (int_6 = this.minLevel; int_6 < this.maxY; int_6++) {
         tiles_0 = this.tiles[int_6];

         for (int_7 = -25; int_7 <= 0; int_7++) {
            int_8 = int_7 + screenCenterX;
            int_9 = screenCenterX - int_7;
            if (int_8 >= minTileX || int_9 < maxTileX) {
               for (int_10 = -25; int_10 <= 0; int_10++) {
                  int_11 = int_10 + screenCenterZ;
                  int_12 = screenCenterZ - int_10;
                  if (int_8 >= minTileX) {
                     if (int_11 >= minTileZ) {
                        tile_1 = tiles_0[int_8][int_11];
                        if (tile_1 != null && tile_1.draw) {
                           this.draw(tile_1, true);
                        }
                     }

                     if (int_12 < maxTileZ) {
                        tile_1 = tiles_0[int_8][int_12];
                        if (tile_1 != null && tile_1.draw) {
                           this.draw(tile_1, true);
                        }
                     }
                  }

                  if (int_9 < maxTileX) {
                     if (int_11 >= minTileZ) {
                        tile_1 = tiles_0[int_9][int_11];
                        if (tile_1 != null && tile_1.draw) {
                           this.draw(tile_1, true);
                        }
                     }

                     if (int_12 < maxTileZ) {
                        tile_1 = tiles_0[int_9][int_12];
                        if (tile_1 != null && tile_1.draw) {
                           this.draw(tile_1, true);
                        }
                     }
                  }

                  if (tileUpdateCount == 0) {
                     checkClick = false;
                     return;
                  }
               }
            }
         }
      }

      for (int_6 = this.minLevel; int_6 < this.maxY; int_6++) {
         tiles_0 = this.tiles[int_6];

         for (int_7 = -25; int_7 <= 0; int_7++) {
            int_8 = int_7 + screenCenterX;
            int_9 = screenCenterX - int_7;
            if (int_8 >= minTileX || int_9 < maxTileX) {
               for (int_10 = -25; int_10 <= 0; int_10++) {
                  int_11 = int_10 + screenCenterZ;
                  int_12 = screenCenterZ - int_10;
                  if (int_8 >= minTileX) {
                     if (int_11 >= minTileZ) {
                        tile_1 = tiles_0[int_8][int_11];
                        if (tile_1 != null && tile_1.draw) {
                           this.draw(tile_1, false);
                        }
                     }

                     if (int_12 < maxTileZ) {
                        tile_1 = tiles_0[int_8][int_12];
                        if (tile_1 != null && tile_1.draw) {
                           this.draw(tile_1, false);
                        }
                     }
                  }

                  if (int_9 < maxTileX) {
                     if (int_11 >= minTileZ) {
                        tile_1 = tiles_0[int_9][int_11];
                        if (tile_1 != null && tile_1.draw) {
                           this.draw(tile_1, false);
                        }
                     }

                     if (int_12 < maxTileZ) {
                        tile_1 = tiles_0[int_9][int_12];
                        if (tile_1 != null && tile_1.draw) {
                           this.draw(tile_1, false);
                        }
                     }
                  }

                  if (tileUpdateCount == 0) {
                     checkClick = false;
                     return;
                  }
               }
            }
         }
      }

      checkClick = false;
   }

   public void clearEntities() {
      for (int int_0 = 0; int_0 < this.entityCount; int_0++) {
         GameObject gameobject_0 = this.objects[int_0];
         this.removeEntity(gameobject_0);
         this.objects[int_0] = null;
      }

      this.entityCount = 0;
   }

   public void method380(int int_0, int int_1, int int_2, int int_3) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      if (tile_0 != null) {
         DecorativeObject decorativeobject_0 = tile_0.decorativeObject;
         if (decorativeobject_0 != null) {
            decorativeobject_0.offsetX = int_3 * decorativeobject_0.offsetX / 16;
            decorativeobject_0.offsetY = int_3 * decorativeobject_0.offsetY / 16;
         }
      }
   }

   public void applyLighting(int int_0, int int_1, int int_2) {
      for (int int_3 = 0; int_3 < this.maxY; int_3++) {
         for (int int_4 = 0; int_4 < this.maxX; int_4++) {
            for (int int_5 = 0; int_5 < this.maxZ; int_5++) {
               Tile tile_0 = this.tiles[int_3][int_4][int_5];
               if (tile_0 != null) {
                  WallObject wallobject_0 = tile_0.wallObject;
                  ModelHeader modeldata_1;
                  if (wallobject_0 != null && wallobject_0.renderable1 instanceof ModelHeader) {
                     ModelHeader modeldata_0 = (ModelHeader) wallobject_0.renderable1;
                     this.method358(modeldata_0, int_3, int_4, int_5, 1, 1);
                     if (wallobject_0.renderable2 instanceof ModelHeader) {
                        modeldata_1 = (ModelHeader) wallobject_0.renderable2;
                        this.method358(modeldata_1, int_3, int_4, int_5, 1, 1);
                        ModelHeader.method1061(modeldata_0, modeldata_1, 0, 0, 0, false);
                        wallobject_0.renderable2 = modeldata_1.applyLighting(modeldata_1.aShort2, modeldata_1.contrast, int_0, int_1, int_2);
                     }

                     wallobject_0.renderable1 = modeldata_0.applyLighting(modeldata_0.aShort2, modeldata_0.contrast, int_0, int_1, int_2);
                  }

                  for (int int_6 = 0; int_6 < tile_0.entityCount; int_6++) {
                     GameObject gameobject_0 = tile_0.objects[int_6];
                     if (gameobject_0 != null && gameobject_0.renderable instanceof ModelHeader) {
                        ModelHeader modeldata_2 = (ModelHeader) gameobject_0.renderable;
                        this.method358(modeldata_2, int_3, int_4, int_5, gameobject_0.offsetX - gameobject_0.relativeX + 1, gameobject_0.offsetY - gameobject_0.relativeY + 1);
                        gameobject_0.renderable = modeldata_2.applyLighting(modeldata_2.aShort2, modeldata_2.contrast, int_0, int_1, int_2);
                     }
                  }

                  GroundObject groundobject_0 = tile_0.groundObject;
                  if (groundobject_0 != null && groundobject_0.renderable instanceof ModelHeader) {
                     modeldata_1 = (ModelHeader) groundobject_0.renderable;
                     this.method360(modeldata_1, int_3, int_4, int_5);
                     groundobject_0.renderable = modeldata_1.applyLighting(modeldata_1.aShort2, modeldata_1.contrast, int_0, int_1, int_2);
                  }
               }
            }
         }
      }

   }

   public void setBridge(int int_0, int int_1) {
      Tile tile_0 = this.tiles[0][int_0][int_1];

      for (int int_2 = 0; int_2 < 3; int_2++) {
         Tile tile_1 = this.tiles[int_2][int_0][int_1] = this.tiles[int_2 + 1][int_0][int_1];
         if (tile_1 != null) {
            --tile_1.plane;

            for (int int_3 = 0; int_3 < tile_1.entityCount; int_3++) {
               GameObject gameobject_0 = tile_1.objects[int_3];
               if ((gameobject_0.hash >> 29 & 0x3) == 2 && gameobject_0.relativeX == int_0 && int_1 == gameobject_0.relativeY) {
                  --gameobject_0.plane;
               }
            }
         }
      }

      if (this.tiles[0][int_0][int_1] == null) {
         this.tiles[0][int_0][int_1] = new Tile(0, int_0, int_1);
      }

      this.tiles[0][int_0][int_1].bridge = tile_0;
      this.tiles[3][int_0][int_1] = null;
   }

   public void setPhysicalLevel(int int_0, int int_1, int int_2, int int_3) {
      Tile tile_0 = this.tiles[int_0][int_1][int_2];
      if (tile_0 != null) {
         this.tiles[int_0][int_1][int_2].physicalLevel = int_3;
      }
   }

   public void setup(int int_0) {
      this.minLevel = int_0;

      for (int int_1 = 0; int_1 < this.maxX; int_1++) {
         for (int int_2 = 0; int_2 < this.maxZ; int_2++) {
            if (this.tiles[int_0][int_1][int_2] == null) {
               this.tiles[int_0][int_1][int_2] = new Tile(int_0, int_1, int_2);
            }
         }
      }

   }

   public void addTile(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8, int int_9, int int_10, int int_11, int int_12, int int_13, int int_14, int int_15, int int_16, int int_17, int int_18, int int_19) {
      SceneTilePaint scenetilepaint_0;
      int int_20;
      if (int_3 == 0) {
         scenetilepaint_0 = new SceneTilePaint(int_10, int_11, int_12, int_13, -1, int_18, false);

         for (int_20 = int_0; int_20 >= 0; --int_20) {
            if (this.tiles[int_20][int_1][int_2] == null) {
               this.tiles[int_20][int_1][int_2] = new Tile(int_20, int_1, int_2);
            }
         }

         this.tiles[int_0][int_1][int_2].paint = scenetilepaint_0;
      } else if (int_3 != 1) {
         SceneTileModel scenetilemodel_0 = new SceneTileModel(int_3, int_4, int_5, int_1, int_2, int_6, int_7, int_8, int_9, int_10, int_11, int_12, int_13, int_14, int_15, int_16, int_17, int_18, int_19);

         for (int_20 = int_0; int_20 >= 0; --int_20) {
            if (this.tiles[int_20][int_1][int_2] == null) {
               this.tiles[int_20][int_1][int_2] = new Tile(int_20, int_1, int_2);
            }
         }

         this.tiles[int_0][int_1][int_2].overlay = scenetilemodel_0;
      } else {
         scenetilepaint_0 = new SceneTilePaint(int_14, int_15, int_16, int_17, int_5, int_19, int_7 == int_6 && int_6 == int_8 && int_9 == int_6);

         for (int_20 = int_0; int_20 >= 0; --int_20) {
            if (this.tiles[int_20][int_1][int_2] == null) {
               this.tiles[int_20][int_1][int_2] = new Tile(int_20, int_1, int_2);
            }
         }

         this.tiles[int_0][int_1][int_2].paint = scenetilepaint_0;
      }
   }

   public static boolean method381() {
      return viewportWalking && selectedRegionTileX != -1;
   }

   public static int[] method382(int int_0, int int_1, int int_2) {
      int int_3 = int_0 * yawCos + int_2 * yawSin >> 16;
      int_2 = int_2 * yawCos - int_0 * yawSin >> 16;
      int_0 = int_3;
      int_3 = pitchCos * int_1 - int_2 * pitchSin >> 16;
      int_2 = pitchSin * int_1 + int_2 * pitchCos >> 16;
      int_2 |= 0x1;
      int int_4 = int_0 * Graphics3D.anInt543 / int_2 + Graphics3D.centerX + Rasterizer2D.topX;
      int int_5 = Graphics3D.anInt543 * int_3 / int_2 + Graphics3D.centerY + Rasterizer2D.topY;
      return new int[] {int_4, int_5};
   }

   public static void method383(int[] ints_0, int int_0, int int_1, int int_2, int int_3) {
      anInt149 = 0;
      anInt150 = 0;
      anInt151 = int_2;
      anInt152 = int_3;
      anInt153 = int_2 / 2;
      anInt154 = int_3 / 2;
      boolean[][][][] bools_0 = new boolean[9][32][53][53];

      int int_4;
      int int_5;
      int int_6;
      int int_7;
      int int_9;
      int int_10;
      for (int_4 = 128; int_4 <= 384; int_4 += 32) {
         for (int_5 = 0; int_5 < 2048; int_5 += 64) {
            pitchSin = Graphics3D.SINE[int_4];
            pitchCos = Graphics3D.COSINE[int_4];
            yawSin = Graphics3D.SINE[int_5];
            yawCos = Graphics3D.COSINE[int_5];
            int_6 = (int_4 - 128) / 32;
            int_7 = int_5 / 64;

            for (int int_8 = -26; int_8 <= 26; int_8++) {
               for (int_9 = -26; int_9 <= 26; int_9++) {
                  int_10 = int_8 * 128;
                  int int_11 = int_9 * 128;
                  boolean bool_0 = false;

                  for (int int_12 = -int_0; int_12 <= int_1; int_12 += 128) {
                     if (method385(int_10, ints_0[int_6] + int_12, int_11)) {
                        bool_0 = true;
                        break;
                     }
                  }

                  bools_0[int_6][int_7][int_8 + 1 + 25][int_9 + 1 + 25] = bool_0;
               }
            }
         }
      }

      for (int_4 = 0; int_4 < 8; int_4++) {
         for (int_5 = 0; int_5 < 32; int_5++) {
            for (int_6 = -25; int_6 < 25; int_6++) {
               for (int_7 = -25; int_7 < 25; int_7++) {
                  boolean bool_1 = false;

                  label76:
                  for (int_9 = -1; int_9 <= 1; int_9++) {
                     for (int_10 = -1; int_10 <= 1; int_10++) {
                        if (bools_0[int_4][int_5][int_6 + int_9 + 1 + 25][int_7 + int_10 + 1 + 25]) {
                           bool_1 = true;
                           break label76;
                        }

                        if (bools_0[int_4][(int_5 + 1) % 31][int_6 + int_9 + 1 + 25][int_7 + int_10 + 1 + 25]) {
                           bool_1 = true;
                           break label76;
                        }

                        if (bools_0[int_4 + 1][int_5][int_6 + int_9 + 1 + 25][int_7 + int_10 + 1 + 25]) {
                           bool_1 = true;
                           break label76;
                        }

                        if (bools_0[int_4 + 1][(int_5 + 1) % 31][int_6 + int_9 + 1 + 25][int_7 + int_10 + 1 + 25]) {
                           bool_1 = true;
                           break label76;
                        }
                     }
                  }

                  visibilityMaps[int_4][int_5][int_6 + 25][int_7 + 25] = bool_1;
               }
            }
         }
      }

   }

   static int method384(int int_0, int int_1) {
      int_1 = (int_0 & 0x7F) * int_1 >> 7;
      if (int_1 < 2) {
         int_1 = 2;
      } else if (int_1 > 126) {
         int_1 = 126;
      }

      return (int_0 & 0xFF80) + int_1;
   }

   static boolean method385(int int_0, int int_1, int int_2) {
      int int_3 = int_0 * yawCos + int_2 * yawSin >> 16;
      int int_4 = int_2 * yawCos - int_0 * yawSin >> 16;
      int int_5 = int_4 * pitchCos + pitchSin * int_1 >> 16;
      int int_6 = pitchCos * int_1 - int_4 * pitchSin >> 16;
      if (int_5 >= 50 && int_5 <= 3500) {
         int int_7 = int_3 * 390 / int_5 + anInt153;
         int int_8 = int_6 * 390 / int_5 + anInt154;
         return int_7 >= anInt149 && int_7 <= anInt151 && int_8 >= anInt150 && int_8 <= anInt152;
      } else {
         return false;
      }
   }

   public static void method386() {
      selectedRegionTileX = -1;
      viewportWalking = false;
   }

   public static void addOcclude(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7) {
      Occluder occluder_0 = new Occluder();
      occluder_0.minTileX = int_2 / 128;
      occluder_0.maxTIleX = int_3 / 128;
      occluder_0.minTileZ = int_4 / 128;
      occluder_0.maxTileZ = int_5 / 128;
      occluder_0.type = int_1;
      occluder_0.minX = int_2;
      occluder_0.maxX = int_3;
      occluder_0.minZ = int_4;
      occluder_0.maxZ = int_5;
      occluder_0.minY = int_6;
      occluder_0.maxY = int_7;
      levelOccluders[int_0][levelOccluderCount[int_0]++] = occluder_0;
   }

}
