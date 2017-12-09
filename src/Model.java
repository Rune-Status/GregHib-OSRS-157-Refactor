public class Model extends Renderable {

   static boolean[] aBoolArray6;
   static int[] anIntArray115;
   static int[] SINE;
   static Model aModel1;
   static byte[] aByteArray21;
   static Model aModel2;
   static int anInt551;
   static byte[] aByteArray22;
   static int[] COSINE;
   static int anInt552;
   static int anInt553;
   static int[] anIntArray118;
   static boolean[] aBoolArray7;
   static int[] anIntArray119;
   public static int[] anIntArray120;
   static int[] anIntArray121;
   public static int[] anIntArray122;
   static int[] anIntArray123;
   static int[] yViewportBuffer;
   static int[][] anIntArrayArray15;
   static int[] anIntArray124;
   static int[] anIntArray125;
   static int[] anIntArray126;
   static int[] anIntArray127;
   static int[] xViewportBuffer;
   static int[][] anIntArrayArray16;
   static int[] anIntArray128;
   static int[] anIntArray129;
   static int[] anIntArray130;
   static boolean aBool74;
   int diagonal3D;
   public int anInt555;
   int anInt556;
   int[][] anIntArrayArray17;
   int vertexCount;
   public int anInt558;
   public int[] indices1;
   int shadowIntensity;
   int[] verticesX;
   int[] verticesZ;
   public int triangleCount;
   public int[] indices2;
   int[][] anIntArrayArray18;
   byte priorityOffset;
   int maxY;
   public int[] indices3;
   int[] verticesY;
   int texturedTriangleCount;
   byte[] aByteArray23;
   public int anInt562;
   int[] anIntArray131;
   public int[] anIntArray132;
   public int anInt563;
   public boolean fitsOnSingleSquare;
   int[] anIntArray133;
   byte[] trianglePriorities;
   public int anInt564;
   int shadowIntensity3D;
   public int anInt566;
   short[] aShortArray12;
   byte[] aByteArray25;
   int[] texturedTrianglePointsX;
   int[] texturedTrianglePointsY;
   int[] texturedTrianglePointsZ;

   static {
      aModel2 = new Model();
      aByteArray22 = new byte[1];
      aModel1 = new Model();
      aByteArray21 = new byte[1];
      aBoolArray7 = new boolean[4700];
      aBoolArray6 = new boolean[4700];
      anIntArray120 = new int[4700];
      anIntArray122 = new int[4700];
      anIntArray124 = new int[4700];
      yViewportBuffer = new int[4700];
      anIntArray125 = new int[4700];
      anIntArray118 = new int[4700];
      anIntArray115 = new int[1600];
      anIntArrayArray15 = new int[1600][512];
      anIntArray119 = new int[12];
      anIntArrayArray16 = new int[12][2000];
      anIntArray129 = new int[2000];
      anIntArray130 = new int[2000];
      anIntArray121 = new int[12];
      anIntArray123 = new int[10];
      anIntArray126 = new int[10];
      xViewportBuffer = new int[10];
      aBool74 = true;
      SINE = Graphics3D.SINE;
      COSINE = Graphics3D.COSINE;
      anIntArray128 = Graphics3D.colorPalette;
      anIntArray127 = Graphics3D.anIntArray114;
   }

   Model() {
      this.vertexCount = 0;
      this.triangleCount = 0;
      this.priorityOffset = 0;
      this.texturedTriangleCount = 0;
      this.fitsOnSingleSquare = false;
      this.anInt555 = -1;
      this.anInt563 = -1;
      this.anInt566 = -1;
   }

   public Model(Model[] models, int totalModels) {
      this.vertexCount = 0;
      this.triangleCount = 0;
      this.priorityOffset = 0;
      this.texturedTriangleCount = 0;
      this.fitsOnSingleSquare = false;
      this.anInt555 = -1;
      this.anInt563 = -1;
      this.anInt566 = -1;
      boolean hasTriangleProperties = false;
      boolean bool_1 = false;
      boolean bool_2 = false;
      boolean bool_3 = false;
      this.vertexCount = 0;
      this.triangleCount = 0;
      this.texturedTriangleCount = 0;
      this.priorityOffset = -1;

      int modelId;
      Model model;
      for (modelId = 0; modelId < totalModels; modelId++) {
         model = models[modelId];
         if (model != null) {
            this.vertexCount += model.vertexCount;
            this.triangleCount += model.triangleCount;
            this.texturedTriangleCount += model.texturedTriangleCount;
            if (model.trianglePriorities != null) {
               hasTriangleProperties = true;
            } else {
               if (this.priorityOffset == -1) {
                  this.priorityOffset = model.priorityOffset;
               }

               if (this.priorityOffset != model.priorityOffset) {
                  hasTriangleProperties = true;
               }
            }

            bool_1 |= model.aByteArray23 != null;
            bool_2 |= model.aShortArray12 != null;
            bool_3 |= model.aByteArray25 != null;
         }
      }

      this.verticesX = new int[this.vertexCount];
      this.verticesY = new int[this.vertexCount];
      this.verticesZ = new int[this.vertexCount];
      this.indices1 = new int[this.triangleCount];
      this.indices2 = new int[this.triangleCount];
      this.indices3 = new int[this.triangleCount];
      this.anIntArray131 = new int[this.triangleCount];
      this.anIntArray133 = new int[this.triangleCount];
      this.anIntArray132 = new int[this.triangleCount];
      if (hasTriangleProperties) {
         this.trianglePriorities = new byte[this.triangleCount];
      }

      if (bool_1) {
         this.aByteArray23 = new byte[this.triangleCount];
      }

      if (bool_2) {
         this.aShortArray12 = new short[this.triangleCount];
      }

      if (bool_3) {
         this.aByteArray25 = new byte[this.triangleCount];
      }

      if (this.texturedTriangleCount > 0) {
         this.texturedTrianglePointsX = new int[this.texturedTriangleCount];
         this.texturedTrianglePointsY = new int[this.texturedTriangleCount];
         this.texturedTrianglePointsZ = new int[this.texturedTriangleCount];
      }

      this.vertexCount = 0;
      this.triangleCount = 0;
      this.texturedTriangleCount = 0;

      for (modelId = 0; modelId < totalModels; modelId++) {
         model = models[modelId];
         if (model != null) {
            int vertex;
            for (vertex = 0; vertex < model.triangleCount; vertex++) {
               this.indices1[this.triangleCount] = this.vertexCount + model.indices1[vertex];
               this.indices2[this.triangleCount] = this.vertexCount + model.indices2[vertex];
               this.indices3[this.triangleCount] = this.vertexCount + model.indices3[vertex];
               this.anIntArray131[this.triangleCount] = model.anIntArray131[vertex];
               this.anIntArray133[this.triangleCount] = model.anIntArray133[vertex];
               this.anIntArray132[this.triangleCount] = model.anIntArray132[vertex];
               if (hasTriangleProperties) {
                  if (model.trianglePriorities != null) {
                     this.trianglePriorities[this.triangleCount] = model.trianglePriorities[vertex];
                  } else {
                     this.trianglePriorities[this.triangleCount] = model.priorityOffset;
                  }
               }

               if (bool_1 && model.aByteArray23 != null) {
                  this.aByteArray23[this.triangleCount] = model.aByteArray23[vertex];
               }

               if (bool_2) {
                  if (model.aShortArray12 != null) {
                     this.aShortArray12[this.triangleCount] = model.aShortArray12[vertex];
                  } else {
                     this.aShortArray12[this.triangleCount] = -1;
                  }
               }

               if (bool_3) {
                  if (model.aByteArray25 != null && model.aByteArray25[vertex] != -1) {
                     this.aByteArray25[this.triangleCount] = (byte)(this.texturedTriangleCount + model.aByteArray25[vertex]);
                  } else {
                     this.aByteArray25[this.triangleCount] = -1;
                  }
               }

               ++this.triangleCount;
            }

            for (vertex = 0; vertex < model.texturedTriangleCount; vertex++) {
               this.texturedTrianglePointsX[this.texturedTriangleCount] = this.vertexCount + model.texturedTrianglePointsX[vertex];
               this.texturedTrianglePointsY[this.texturedTriangleCount] = this.vertexCount + model.texturedTrianglePointsY[vertex];
               this.texturedTrianglePointsZ[this.texturedTriangleCount] = this.vertexCount + model.texturedTrianglePointsZ[vertex];
               ++this.texturedTriangleCount;
            }

            for (vertex = 0; vertex < model.vertexCount; vertex++) {
               this.verticesX[this.vertexCount] = model.verticesX[vertex];
               this.verticesY[this.vertexCount] = model.verticesY[vertex];
               this.verticesZ[this.vertexCount] = model.verticesZ[vertex];
               ++this.vertexCount;
            }
         }
      }

   }

   public void calculateDiagonals() {
      if (this.anInt556 != 1) {
         this.anInt556 = 1;
         super.modelHeight = 0;
         this.maxY = 0;
         this.shadowIntensity = 0;

         for (int vertex = 0; vertex < this.vertexCount; vertex++) {
            int vertexX = this.verticesX[vertex];
            int vertexY = this.verticesY[vertex];
            int vertexZ = this.verticesZ[vertex];
            if (-vertexY > super.modelHeight) {
               super.modelHeight = -vertexY;
            }

            if (vertexY > this.maxY) {
               this.maxY = vertexY;
            }

            int intensity = vertexX * vertexX + vertexZ * vertexZ;
            if (intensity > this.shadowIntensity) {
               this.shadowIntensity = intensity;
            }
         }

         this.shadowIntensity = (int)(Math.sqrt((double)this.shadowIntensity) + 0.99D);
         this.shadowIntensity3D = (int)(Math.sqrt((double)(this.shadowIntensity * this.shadowIntensity + super.modelHeight * super.modelHeight)) + 0.99D);
         this.diagonal3D = this.shadowIntensity3D + (int)(Math.sqrt((double)(this.shadowIntensity * this.shadowIntensity + this.maxY * this.maxY)) + 0.99D);
      }
   }

   public void method1008(Frames frames_0, int int_0) {
      if (this.anIntArrayArray17 != null) {
         Frame frame_0 = frames_0.skeletons[int_0];
         FrameMap framemap_0 = frame_0.skin;
         anInt551 = 0;
         anInt552 = 0;
         anInt553 = 0;

         for (int int_1 = 0; int_1 < frame_0.anInt202; int_1++) {
            int int_2 = frame_0.anIntArray52[int_1];
            this.method1024(framemap_0.types[int_2], framemap_0.list[int_2], frame_0.translator_x[int_1], frame_0.translator_y[int_1], frame_0.translator_z[int_1]);
         }

         this.method1009();
      }
   }

   void method1009() {
      this.anInt556 = 0;
      this.anInt555 = -1;
   }

   void method1010(int int_0) {
      int int_1 = Graphics3D.centerX;
      int int_2 = Graphics3D.centerY;
      int int_3 = 0;
      int int_4 = this.indices1[int_0];
      int int_5 = this.indices2[int_0];
      int int_6 = this.indices3[int_0];
      int int_7 = anIntArray118[int_4];
      int int_8 = anIntArray118[int_5];
      int int_9 = anIntArray118[int_6];
      if (this.aByteArray23 == null) {
         Graphics3D.rasterAlpha = 0;
      } else {
         Graphics3D.rasterAlpha = this.aByteArray23[int_0] & 0xFF;
      }

      int int_10;
      int int_11;
      int int_12;
      int int_13;
      if (int_7 >= 50) {
         anIntArray123[int_3] = anIntArray120[int_4];
         anIntArray126[int_3] = anIntArray122[int_4];
         xViewportBuffer[int_3++] = this.anIntArray131[int_0];
      } else {
         int_10 = yViewportBuffer[int_4];
         int_11 = anIntArray125[int_4];
         int_12 = this.anIntArray131[int_0];
         if (int_9 >= 50) {
            int_13 = anIntArray127[int_9 - int_7] * (50 - int_7);
            anIntArray123[int_3] = int_1 + Graphics3D.anInt543 * (int_10 + ((yViewportBuffer[int_6] - int_10) * int_13 >> 16)) / 50;
            anIntArray126[int_3] = int_2 + Graphics3D.anInt543 * (int_11 + ((anIntArray125[int_6] - int_11) * int_13 >> 16)) / 50;
            xViewportBuffer[int_3++] = int_12 + ((this.anIntArray132[int_0] - int_12) * int_13 >> 16);
         }

         if (int_8 >= 50) {
            int_13 = anIntArray127[int_8 - int_7] * (50 - int_7);
            anIntArray123[int_3] = int_1 + Graphics3D.anInt543 * (int_10 + ((yViewportBuffer[int_5] - int_10) * int_13 >> 16)) / 50;
            anIntArray126[int_3] = int_2 + Graphics3D.anInt543 * (int_11 + ((anIntArray125[int_5] - int_11) * int_13 >> 16)) / 50;
            xViewportBuffer[int_3++] = int_12 + ((this.anIntArray133[int_0] - int_12) * int_13 >> 16);
         }
      }

      if (int_8 >= 50) {
         anIntArray123[int_3] = anIntArray120[int_5];
         anIntArray126[int_3] = anIntArray122[int_5];
         xViewportBuffer[int_3++] = this.anIntArray133[int_0];
      } else {
         int_10 = yViewportBuffer[int_5];
         int_11 = anIntArray125[int_5];
         int_12 = this.anIntArray133[int_0];
         if (int_7 >= 50) {
            int_13 = anIntArray127[int_7 - int_8] * (50 - int_8);
            anIntArray123[int_3] = int_1 + Graphics3D.anInt543 * (int_10 + ((yViewportBuffer[int_4] - int_10) * int_13 >> 16)) / 50;
            anIntArray126[int_3] = int_2 + Graphics3D.anInt543 * (int_11 + ((anIntArray125[int_4] - int_11) * int_13 >> 16)) / 50;
            xViewportBuffer[int_3++] = int_12 + ((this.anIntArray131[int_0] - int_12) * int_13 >> 16);
         }

         if (int_9 >= 50) {
            int_13 = anIntArray127[int_9 - int_8] * (50 - int_8);
            anIntArray123[int_3] = int_1 + Graphics3D.anInt543 * (int_10 + ((yViewportBuffer[int_6] - int_10) * int_13 >> 16)) / 50;
            anIntArray126[int_3] = int_2 + Graphics3D.anInt543 * (int_11 + ((anIntArray125[int_6] - int_11) * int_13 >> 16)) / 50;
            xViewportBuffer[int_3++] = int_12 + ((this.anIntArray132[int_0] - int_12) * int_13 >> 16);
         }
      }

      if (int_9 >= 50) {
         anIntArray123[int_3] = anIntArray120[int_6];
         anIntArray126[int_3] = anIntArray122[int_6];
         xViewportBuffer[int_3++] = this.anIntArray132[int_0];
      } else {
         int_10 = yViewportBuffer[int_6];
         int_11 = anIntArray125[int_6];
         int_12 = this.anIntArray132[int_0];
         if (int_8 >= 50) {
            int_13 = anIntArray127[int_8 - int_9] * (50 - int_9);
            anIntArray123[int_3] = int_1 + Graphics3D.anInt543 * (int_10 + ((yViewportBuffer[int_5] - int_10) * int_13 >> 16)) / 50;
            anIntArray126[int_3] = int_2 + Graphics3D.anInt543 * (int_11 + ((anIntArray125[int_5] - int_11) * int_13 >> 16)) / 50;
            xViewportBuffer[int_3++] = int_12 + ((this.anIntArray133[int_0] - int_12) * int_13 >> 16);
         }

         if (int_7 >= 50) {
            int_13 = anIntArray127[int_7 - int_9] * (50 - int_9);
            anIntArray123[int_3] = int_1 + Graphics3D.anInt543 * (int_10 + ((yViewportBuffer[int_4] - int_10) * int_13 >> 16)) / 50;
            anIntArray126[int_3] = int_2 + Graphics3D.anInt543 * (int_11 + ((anIntArray125[int_4] - int_11) * int_13 >> 16)) / 50;
            xViewportBuffer[int_3++] = int_12 + ((this.anIntArray131[int_0] - int_12) * int_13 >> 16);
         }
      }

      int_10 = anIntArray123[0];
      int_11 = anIntArray123[1];
      int_12 = anIntArray123[2];
      int_13 = anIntArray126[0];
      int int_14 = anIntArray126[1];
      int int_15 = anIntArray126[2];
      Graphics3D.rasterClipEnable = false;
      int int_16;
      int int_17;
      int int_18;
      int int_19;
      if (int_3 == 3) {
         if (int_10 < 0 || int_11 < 0 || int_12 < 0 || int_10 > Graphics3D.rasterClipX || int_11 > Graphics3D.rasterClipX || int_12 > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if (this.aShortArray12 != null && this.aShortArray12[int_0] != -1) {
            if (this.aByteArray25 != null && this.aByteArray25[int_0] != -1) {
               int_17 = this.aByteArray25[int_0] & 0xFF;
               int_16 = this.texturedTrianglePointsX[int_17];
               int_18 = this.texturedTrianglePointsY[int_17];
               int_19 = this.texturedTrianglePointsZ[int_17];
            } else {
               int_16 = int_4;
               int_18 = int_5;
               int_19 = int_6;
            }

            if (this.anIntArray132[int_0] == -1) {
               Graphics3D.rasterTextureAffine(int_13, int_14, int_15, int_10, int_11, int_12, this.anIntArray131[int_0], this.anIntArray131[int_0], this.anIntArray131[int_0], yViewportBuffer[int_16], yViewportBuffer[int_18], yViewportBuffer[int_19], anIntArray125[int_16], anIntArray125[int_18], anIntArray125[int_19], anIntArray118[int_16], anIntArray118[int_18], anIntArray118[int_19], this.aShortArray12[int_0]);
            } else {
               Graphics3D.rasterTextureAffine(int_13, int_14, int_15, int_10, int_11, int_12, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[int_16], yViewportBuffer[int_18], yViewportBuffer[int_19], anIntArray125[int_16], anIntArray125[int_18], anIntArray125[int_19], anIntArray118[int_16], anIntArray118[int_18], anIntArray118[int_19], this.aShortArray12[int_0]);
            }
         } else if (this.anIntArray132[int_0] == -1) {
            Graphics3D.rasterFlat(int_13, int_14, int_15, int_10, int_11, int_12, anIntArray128[this.anIntArray131[int_0]]);
         } else {
            Graphics3D.rasterGouraud(int_13, int_14, int_15, int_10, int_11, int_12, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
         }
      }

      if (int_3 == 4) {
         if (int_10 < 0 || int_11 < 0 || int_12 < 0 || int_10 > Graphics3D.rasterClipX || int_11 > Graphics3D.rasterClipX || int_12 > Graphics3D.rasterClipX || anIntArray123[3] < 0 || anIntArray123[3] > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if (this.aShortArray12 != null && this.aShortArray12[int_0] != -1) {
            if (this.aByteArray25 != null && this.aByteArray25[int_0] != -1) {
               int_17 = this.aByteArray25[int_0] & 0xFF;
               int_16 = this.texturedTrianglePointsX[int_17];
               int_18 = this.texturedTrianglePointsY[int_17];
               int_19 = this.texturedTrianglePointsZ[int_17];
            } else {
               int_16 = int_4;
               int_18 = int_5;
               int_19 = int_6;
            }

            short short_0 = this.aShortArray12[int_0];
            if (this.anIntArray132[int_0] == -1) {
               Graphics3D.rasterTextureAffine(int_13, int_14, int_15, int_10, int_11, int_12, this.anIntArray131[int_0], this.anIntArray131[int_0], this.anIntArray131[int_0], yViewportBuffer[int_16], yViewportBuffer[int_18], yViewportBuffer[int_19], anIntArray125[int_16], anIntArray125[int_18], anIntArray125[int_19], anIntArray118[int_16], anIntArray118[int_18], anIntArray118[int_19], short_0);
               Graphics3D.rasterTextureAffine(int_13, int_15, anIntArray126[3], int_10, int_12, anIntArray123[3], this.anIntArray131[int_0], this.anIntArray131[int_0], this.anIntArray131[int_0], yViewportBuffer[int_16], yViewportBuffer[int_18], yViewportBuffer[int_19], anIntArray125[int_16], anIntArray125[int_18], anIntArray125[int_19], anIntArray118[int_16], anIntArray118[int_18], anIntArray118[int_19], short_0);
            } else {
               Graphics3D.rasterTextureAffine(int_13, int_14, int_15, int_10, int_11, int_12, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[int_16], yViewportBuffer[int_18], yViewportBuffer[int_19], anIntArray125[int_16], anIntArray125[int_18], anIntArray125[int_19], anIntArray118[int_16], anIntArray118[int_18], anIntArray118[int_19], short_0);
               Graphics3D.rasterTextureAffine(int_13, int_15, anIntArray126[3], int_10, int_12, anIntArray123[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[int_16], yViewportBuffer[int_18], yViewportBuffer[int_19], anIntArray125[int_16], anIntArray125[int_18], anIntArray125[int_19], anIntArray118[int_16], anIntArray118[int_18], anIntArray118[int_19], short_0);
            }
         } else if (this.anIntArray132[int_0] == -1) {
            int_16 = anIntArray128[this.anIntArray131[int_0]];
            Graphics3D.rasterFlat(int_13, int_14, int_15, int_10, int_11, int_12, int_16);
            Graphics3D.rasterFlat(int_13, int_15, anIntArray126[3], int_10, int_12, anIntArray123[3], int_16);
         } else {
            Graphics3D.rasterGouraud(int_13, int_14, int_15, int_10, int_11, int_12, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
            Graphics3D.rasterGouraud(int_13, int_15, anIntArray126[3], int_10, int_12, anIntArray123[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3]);
         }
      }

   }

   Model method1011(boolean bool_0, Model model_1, byte[] bytes_0) {
      model_1.vertexCount = this.vertexCount;
      model_1.triangleCount = this.triangleCount;
      model_1.texturedTriangleCount = this.texturedTriangleCount;
      if (model_1.verticesX == null || model_1.verticesX.length < this.vertexCount) {
         model_1.verticesX = new int[this.vertexCount + 100];
         model_1.verticesY = new int[this.vertexCount + 100];
         model_1.verticesZ = new int[this.vertexCount + 100];
      }

      int int_0;
      for (int_0 = 0; int_0 < this.vertexCount; int_0++) {
         model_1.verticesX[int_0] = this.verticesX[int_0];
         model_1.verticesY[int_0] = this.verticesY[int_0];
         model_1.verticesZ[int_0] = this.verticesZ[int_0];
      }

      if (bool_0) {
         model_1.aByteArray23 = this.aByteArray23;
      } else {
         model_1.aByteArray23 = bytes_0;
         if (this.aByteArray23 == null) {
            for (int_0 = 0; int_0 < this.triangleCount; int_0++) {
               model_1.aByteArray23[int_0] = 0;
            }
         } else {
            for (int_0 = 0; int_0 < this.triangleCount; int_0++) {
               model_1.aByteArray23[int_0] = this.aByteArray23[int_0];
            }
         }
      }

      model_1.indices1 = this.indices1;
      model_1.indices2 = this.indices2;
      model_1.indices3 = this.indices3;
      model_1.anIntArray131 = this.anIntArray131;
      model_1.anIntArray133 = this.anIntArray133;
      model_1.anIntArray132 = this.anIntArray132;
      model_1.trianglePriorities = this.trianglePriorities;
      model_1.aByteArray25 = this.aByteArray25;
      model_1.aShortArray12 = this.aShortArray12;
      model_1.priorityOffset = this.priorityOffset;
      model_1.texturedTrianglePointsX = this.texturedTrianglePointsX;
      model_1.texturedTrianglePointsY = this.texturedTrianglePointsY;
      model_1.texturedTrianglePointsZ = this.texturedTrianglePointsZ;
      model_1.anIntArrayArray17 = this.anIntArrayArray17;
      model_1.anIntArrayArray18 = this.anIntArrayArray18;
      model_1.fitsOnSingleSquare = this.fitsOnSingleSquare;
      model_1.method1009();
      return model_1;
   }

   void method1012(int rotation) {
      if (this.anInt555 == -1) {
         int int_1 = 0;
         int int_2 = 0;
         int int_3 = 0;
         int int_4 = 0;
         int int_5 = 0;
         int int_6 = 0;
         int cos = COSINE[rotation];
         int sine = SINE[rotation];

         for (int int_9 = 0; int_9 < this.vertexCount; int_9++) {
            int int_10 = Graphics3D.method958(this.verticesX[int_9], this.verticesZ[int_9], cos, sine);
            int int_11 = this.verticesY[int_9];
            int int_12 = Graphics3D.method959(this.verticesX[int_9], this.verticesZ[int_9], cos, sine);
            if (int_10 < int_1) {
               int_1 = int_10;
            }

            if (int_10 > int_4) {
               int_4 = int_10;
            }

            if (int_11 < int_2) {
               int_2 = int_11;
            }

            if (int_11 > int_5) {
               int_5 = int_11;
            }

            if (int_12 < int_3) {
               int_3 = int_12;
            }

            if (int_12 > int_6) {
               int_6 = int_12;
            }
         }

         this.anInt558 = (int_4 + int_1) / 2;
         this.anInt562 = (int_5 + int_2) / 2;
         this.anInt564 = (int_6 + int_3) / 2;
         this.anInt555 = (int_4 - int_1 + 1) / 2;
         this.anInt563 = (int_5 - int_2 + 1) / 2;
         this.anInt566 = (int_6 - int_3 + 1) / 2;
         if (this.anInt555 < 32) {
            this.anInt555 = 32;
         }

         if (this.anInt566 < 32) {
            this.anInt566 = 32;
         }

         if (this.fitsOnSingleSquare) {
            this.anInt555 += 8;
            this.anInt566 += 8;
         }

      }
   }

   public Model method1013(boolean bool_0) {
      if (!bool_0 && aByteArray22.length < this.triangleCount) {
         aByteArray22 = new byte[this.triangleCount + 100];
      }

      return this.method1011(bool_0, aModel2, aByteArray22);
   }

   void method1014() {
      if (this.anInt556 != 2) {
         this.anInt556 = 2;
         this.shadowIntensity = 0;

         for (int int_0 = 0; int_0 < this.vertexCount; int_0++) {
            int int_1 = this.verticesX[int_0];
            int int_2 = this.verticesY[int_0];
            int int_3 = this.verticesZ[int_0];
            int int_4 = int_1 * int_1 + int_3 * int_3 + int_2 * int_2;
            if (int_4 > this.shadowIntensity) {
               this.shadowIntensity = int_4;
            }
         }

         this.shadowIntensity = (int)(Math.sqrt((double)this.shadowIntensity) + 0.99D);
         this.shadowIntensity3D = this.shadowIntensity;
         this.diagonal3D = this.shadowIntensity + this.shadowIntensity;
      }
   }

   public Model method1015(boolean bool_0) {
      if (!bool_0 && aByteArray21.length < this.triangleCount) {
         aByteArray21 = new byte[this.triangleCount + 100];
      }

      return this.method1011(bool_0, aModel1, aByteArray21);
   }

   public void method1016(int int_0) {
      int int_1 = SINE[int_0];
      int int_2 = COSINE[int_0];

      for (int int_3 = 0; int_3 < this.vertexCount; int_3++) {
         int int_4 = int_2 * this.verticesY[int_3] - int_1 * this.verticesZ[int_3] >> 16;
         this.verticesZ[int_3] = int_1 * this.verticesY[int_3] + int_2 * this.verticesZ[int_3] >> 16;
         this.verticesY[int_3] = int_4;
      }

      this.method1009();
   }

   public Model method1017(int[][] ints_0, int int_0, int int_1, int int_2, boolean bool_0, int int_3) {
      this.calculateDiagonals();
      int int_4 = int_0 - this.shadowIntensity;
      int int_5 = int_0 + this.shadowIntensity;
      int int_6 = int_2 - this.shadowIntensity;
      int int_7 = int_2 + this.shadowIntensity;
      if (int_4 >= 0 && int_5 + 128 >> 7 < ints_0.length && int_6 >= 0 && int_7 + 128 >> 7 < ints_0[0].length) {
         int_4 >>= 7;
         int_5 = int_5 + 127 >> 7;
         int_6 >>= 7;
         int_7 = int_7 + 127 >> 7;
         if (int_1 == ints_0[int_4][int_6] && int_1 == ints_0[int_5][int_6] && int_1 == ints_0[int_4][int_7] && int_1 == ints_0[int_5][int_7]) {
            return this;
         } else {
            Model model_1;
            if (bool_0) {
               model_1 = new Model();
               model_1.vertexCount = this.vertexCount;
               model_1.triangleCount = this.triangleCount;
               model_1.texturedTriangleCount = this.texturedTriangleCount;
               model_1.verticesX = this.verticesX;
               model_1.verticesZ = this.verticesZ;
               model_1.indices1 = this.indices1;
               model_1.indices2 = this.indices2;
               model_1.indices3 = this.indices3;
               model_1.anIntArray131 = this.anIntArray131;
               model_1.anIntArray133 = this.anIntArray133;
               model_1.anIntArray132 = this.anIntArray132;
               model_1.trianglePriorities = this.trianglePriorities;
               model_1.aByteArray23 = this.aByteArray23;
               model_1.aByteArray25 = this.aByteArray25;
               model_1.aShortArray12 = this.aShortArray12;
               model_1.priorityOffset = this.priorityOffset;
               model_1.texturedTrianglePointsX = this.texturedTrianglePointsX;
               model_1.texturedTrianglePointsY = this.texturedTrianglePointsY;
               model_1.texturedTrianglePointsZ = this.texturedTrianglePointsZ;
               model_1.anIntArrayArray17 = this.anIntArrayArray17;
               model_1.anIntArrayArray18 = this.anIntArrayArray18;
               model_1.fitsOnSingleSquare = this.fitsOnSingleSquare;
               model_1.verticesY = new int[model_1.vertexCount];
            } else {
               model_1 = this;
            }

            int int_8;
            int int_9;
            int int_10;
            int int_11;
            int int_12;
            int int_13;
            int int_14;
            int int_15;
            int int_16;
            int int_17;
            if (int_3 == 0) {
               for (int_8 = 0; int_8 < model_1.vertexCount; int_8++) {
                  int_9 = int_0 + this.verticesX[int_8];
                  int_10 = int_2 + this.verticesZ[int_8];
                  int_11 = int_9 & 0x7F;
                  int_12 = int_10 & 0x7F;
                  int_13 = int_9 >> 7;
                  int_14 = int_10 >> 7;
                  int_15 = ints_0[int_13][int_14] * (128 - int_11) + ints_0[int_13 + 1][int_14] * int_11 >> 7;
                  int_16 = ints_0[int_13][int_14 + 1] * (128 - int_11) + int_11 * ints_0[int_13 + 1][int_14 + 1] >> 7;
                  int_17 = int_15 * (128 - int_12) + int_16 * int_12 >> 7;
                  model_1.verticesY[int_8] = int_17 + this.verticesY[int_8] - int_1;
               }
            } else {
               for (int_8 = 0; int_8 < model_1.vertexCount; int_8++) {
                  int_9 = (-this.verticesY[int_8] << 16) / super.modelHeight;
                  if (int_9 < int_3) {
                     int_10 = int_0 + this.verticesX[int_8];
                     int_11 = int_2 + this.verticesZ[int_8];
                     int_12 = int_10 & 0x7F;
                     int_13 = int_11 & 0x7F;
                     int_14 = int_10 >> 7;
                     int_15 = int_11 >> 7;
                     int_16 = ints_0[int_14][int_15] * (128 - int_12) + ints_0[int_14 + 1][int_15] * int_12 >> 7;
                     int_17 = ints_0[int_14][int_15 + 1] * (128 - int_12) + int_12 * ints_0[int_14 + 1][int_15 + 1] >> 7;
                     int int_18 = int_16 * (128 - int_13) + int_17 * int_13 >> 7;
                     model_1.verticesY[int_8] = (int_3 - int_9) * (int_18 - int_1) / int_3 + this.verticesY[int_8];
                  }
               }
            }

            model_1.method1009();
            return model_1;
         }
      } else {
         return this;
      }
   }

   void draw(int rotation, int int_1, int yCurveCosine, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8) {
      anIntArray115[0] = -1;
      if (this.anInt556 != 1) {
         this.calculateDiagonals();
      }

      this.method1012(rotation);
      int int_9 = int_4 * int_7 - int_3 * int_5 >> 16;
      int int_10 = int_1 * int_6 + yCurveCosine * int_9 >> 16;
      int int_11 = yCurveCosine * this.shadowIntensity >> 16;
      int int_12 = int_10 + int_11;
      if (int_12 > 50 && int_10 < 3500) {
         int int_13 = int_7 * int_3 + int_4 * int_5 >> 16;
         int int_14 = (int_13 - this.shadowIntensity) * Graphics3D.anInt543;
         if (int_14 / int_12 < Graphics3D.anInt544) {
            int int_15 = (int_13 + this.shadowIntensity) * Graphics3D.anInt543;
            if (int_15 / int_12 > Graphics3D.anInt545) {
               int int_16 = yCurveCosine * int_6 - int_9 * int_1 >> 16;
               int int_17 = int_1 * this.shadowIntensity >> 16;
               int int_18 = (int_16 + int_17) * Graphics3D.anInt543;
               if (int_18 / int_12 > Graphics3D.anInt546) {
                  int int_19 = (yCurveCosine * super.modelHeight >> 16) + int_17;
                  int int_20 = (int_16 - int_19) * Graphics3D.anInt543;
                  if (int_20 / int_12 < Graphics3D.anInt547) {
                     int int_21 = int_11 + (int_1 * super.modelHeight >> 16);
                     boolean bool_0 = false;
                     boolean bool_1 = false;
                     if (int_10 - int_21 <= 50) {
                        bool_1 = true;
                     }

                     boolean bool_2 = bool_1 || this.texturedTriangleCount > 0;
                     int cursorX = Class54.anInt138;
                     int cursorY = WorldMapType1.method579();
                     boolean bool_3 = Class21.method211();
                     if (Class37.fitsOnSingleSquare && int_8 > 0) {
                        Class14.method187(this, int_5, int_6, int_7);
                     }

                     int int_25;
                     int int_26;
                     int int_27;
                     int int_28;
                     int int_29;
                     int int_30;
                     int int_31;
                     if (Class37.aBool15 && int_8 > 0) {
                        int int_24 = int_10 - int_11;
                        if (int_24 <= 50) {
                           int_24 = 50;
                        }

                        if (int_13 > 0) {
                           int_25 = int_14 / int_12;
                           int_26 = int_15 / int_24;
                        } else {
                           int_26 = int_15 / int_12;
                           int_25 = int_14 / int_24;
                        }

                        if (int_16 > 0) {
                           int_27 = int_20 / int_12;
                           int_28 = int_18 / int_24;
                        } else {
                           int_28 = int_18 / int_12;
                           int_27 = int_20 / int_24;
                        }

                        int_29 = -8355840;
                        int_30 = cursorX - Graphics3D.centerX;
                        int_31 = cursorY - Graphics3D.centerY;
                        if (int_30 > int_25 && int_30 < int_26 && int_31 > int_27 && int_31 < int_28) {
                           int_29 = -256;
                        }

                        GroundObject.method566(int_25 + Graphics3D.centerX, int_27 + Graphics3D.centerY, int_26 + Graphics3D.centerX, int_28 + Graphics3D.centerY, int_29);
                     }

                     boolean bool_4 = false;
                     if (int_8 > 0 && bool_3) {
                        boolean bool_5 = false;
                        if (aBool74) {
                           bool_5 = Class4.method82(this, int_5, int_6, int_7);
                        } else {
                           int_26 = int_10 - int_11;
                           if (int_26 <= 50) {
                              int_26 = 50;
                           }

                           if (int_13 > 0) {
                              int_14 /= int_12;
                              int_15 /= int_26;
                           } else {
                              int_15 /= int_12;
                              int_14 /= int_26;
                           }

                           if (int_16 > 0) {
                              int_20 /= int_12;
                              int_18 /= int_26;
                           } else {
                              int_18 /= int_12;
                              int_20 /= int_26;
                           }

                           int_27 = cursorX - Graphics3D.centerX;
                           int_28 = cursorY - Graphics3D.centerY;
                           if (int_27 > int_14 && int_27 < int_15 && int_28 > int_20 && int_28 < int_18) {
                              bool_5 = true;
                           }
                        }

                        if (bool_5) {
                           if (this.fitsOnSingleSquare) {
                              Class54.anIntArray34[++Class54.anInt140 - 1] = int_8;
                           } else {
                              bool_4 = true;
                           }
                        }
                     }

                     int_25 = Graphics3D.centerX;
                     int_26 = Graphics3D.centerY;
                     int_27 = 0;
                     int_28 = 0;
                     if (rotation != 0) {
                        int_27 = SINE[rotation];
                        int_28 = COSINE[rotation];
                     }

                     for (int_29 = 0; int_29 < this.vertexCount; int_29++) {
                        int_30 = this.verticesX[int_29];
                        int_31 = this.verticesY[int_29];
                        int int_32 = this.verticesZ[int_29];
                        int int_33;
                        if (rotation != 0) {
                           int_33 = int_32 * int_27 + int_30 * int_28 >> 16;
                           int_32 = int_32 * int_28 - int_30 * int_27 >> 16;
                           int_30 = int_33;
                        }

                        int_30 += int_5;
                        int_31 += int_6;
                        int_32 += int_7;
                        int_33 = int_32 * int_3 + int_4 * int_30 >> 16;
                        int_32 = int_4 * int_32 - int_30 * int_3 >> 16;
                        int_30 = int_33;
                        int_33 = yCurveCosine * int_31 - int_32 * int_1 >> 16;
                        int_32 = int_31 * int_1 + yCurveCosine * int_32 >> 16;
                        anIntArray124[int_29] = int_32 - int_10;
                        if (int_32 >= 50) {
                           anIntArray120[int_29] = int_30 * Graphics3D.anInt543 / int_32 + int_25;
                           anIntArray122[int_29] = int_33 * Graphics3D.anInt543 / int_32 + int_26;
                        } else {
                           anIntArray120[int_29] = -5000;
                           bool_0 = true;
                        }

                        if (bool_2) {
                           yViewportBuffer[int_29] = int_30;
                           anIntArray125[int_29] = int_33;
                           anIntArray118[int_29] = int_32;
                        }
                     }

                     try {
                        this.method1025(bool_0, bool_4, this.fitsOnSingleSquare, int_8);
                     } catch (Exception exception_0) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   public void method1018() {
      for (int int_0 = 0; int_0 < this.vertexCount; int_0++) {
         int int_1 = this.verticesZ[int_0];
         this.verticesZ[int_0] = this.verticesX[int_0];
         this.verticesX[int_0] = -int_1;
      }

      this.method1009();
   }

   public void scaleTriangle(int x, int y, int z) {
      for (int vertex = 0; vertex < this.vertexCount; vertex++) {
         this.verticesX[vertex] = this.verticesX[vertex] * x / 128;
         this.verticesY[vertex] = y * this.verticesY[vertex] / 128;
         this.verticesZ[vertex] = z * this.verticesZ[vertex] / 128;
      }

      this.method1009();
   }

   public void method1020() {
      for (int int_0 = 0; int_0 < this.vertexCount; int_0++) {
         this.verticesX[int_0] = -this.verticesX[int_0];
         this.verticesZ[int_0] = -this.verticesZ[int_0];
      }

      this.method1009();
   }

   public void method1021() {
      for (int int_0 = 0; int_0 < this.vertexCount; int_0++) {
         int int_1 = this.verticesX[int_0];
         this.verticesX[int_0] = this.verticesZ[int_0];
         this.verticesZ[int_0] = -int_1;
      }

      this.method1009();
   }

   public void method1022(Frames frames_0, int int_0, Frames frames_1, int int_1, int[] ints_0) {
      if (int_0 != -1) {
         if (ints_0 != null && int_1 != -1) {
            Frame frame_0 = frames_0.skeletons[int_0];
            Frame frame_1 = frames_1.skeletons[int_1];
            FrameMap framemap_0 = frame_0.skin;
            anInt551 = 0;
            anInt552 = 0;
            anInt553 = 0;
            byte byte_0 = 0;
            int int_5 = byte_0 + 1;
            int int_2 = ints_0[byte_0];

            int int_3;
            int int_4;
            for (int_3 = 0; int_3 < frame_0.anInt202; int_3++) {
               for (int_4 = frame_0.anIntArray52[int_3]; int_4 > int_2; int_2 = ints_0[int_5++]) {
                  ;
               }

               if (int_4 != int_2 || framemap_0.types[int_4] == 0) {
                  this.method1024(framemap_0.types[int_4], framemap_0.list[int_4], frame_0.translator_x[int_3], frame_0.translator_y[int_3], frame_0.translator_z[int_3]);
               }
            }

            anInt551 = 0;
            anInt552 = 0;
            anInt553 = 0;
            byte_0 = 0;
            int_5 = byte_0 + 1;
            int_2 = ints_0[byte_0];

            for (int_3 = 0; int_3 < frame_1.anInt202; int_3++) {
               for (int_4 = frame_1.anIntArray52[int_3]; int_4 > int_2; int_2 = ints_0[int_5++]) {
                  ;
               }

               if (int_4 == int_2 || framemap_0.types[int_4] == 0) {
                  this.method1024(framemap_0.types[int_4], framemap_0.list[int_4], frame_1.translator_x[int_3], frame_1.translator_y[int_3], frame_1.translator_z[int_3]);
               }
            }

            this.method1009();
         } else {
            this.method1008(frames_0, int_0);
         }
      }
   }

   void method1023(int int_0) {
      if (aBoolArray6[int_0]) {
         this.method1010(int_0);
      } else {
         int int_1 = this.indices1[int_0];
         int int_2 = this.indices2[int_0];
         int int_3 = this.indices3[int_0];
         Graphics3D.rasterClipEnable = aBoolArray7[int_0];
         if (this.aByteArray23 == null) {
            Graphics3D.rasterAlpha = 0;
         } else {
            Graphics3D.rasterAlpha = this.aByteArray23[int_0] & 0xFF;
         }

         if (this.aShortArray12 != null && this.aShortArray12[int_0] != -1) {
            int int_5;
            int int_6;
            int int_7;
            if (this.aByteArray25 != null && this.aByteArray25[int_0] != -1) {
               int int_4 = this.aByteArray25[int_0] & 0xFF;
               int_5 = this.texturedTrianglePointsX[int_4];
               int_6 = this.texturedTrianglePointsY[int_4];
               int_7 = this.texturedTrianglePointsZ[int_4];
            } else {
               int_5 = int_1;
               int_6 = int_2;
               int_7 = int_3;
            }

            if (this.anIntArray132[int_0] == -1) {
               Graphics3D.rasterTextureAffine(anIntArray122[int_1], anIntArray122[int_2], anIntArray122[int_3], anIntArray120[int_1], anIntArray120[int_2], anIntArray120[int_3], this.anIntArray131[int_0], this.anIntArray131[int_0], this.anIntArray131[int_0], yViewportBuffer[int_5], yViewportBuffer[int_6], yViewportBuffer[int_7], anIntArray125[int_5], anIntArray125[int_6], anIntArray125[int_7], anIntArray118[int_5], anIntArray118[int_6], anIntArray118[int_7], this.aShortArray12[int_0]);
            } else {
               Graphics3D.rasterTextureAffine(anIntArray122[int_1], anIntArray122[int_2], anIntArray122[int_3], anIntArray120[int_1], anIntArray120[int_2], anIntArray120[int_3], this.anIntArray131[int_0], this.anIntArray133[int_0], this.anIntArray132[int_0], yViewportBuffer[int_5], yViewportBuffer[int_6], yViewportBuffer[int_7], anIntArray125[int_5], anIntArray125[int_6], anIntArray125[int_7], anIntArray118[int_5], anIntArray118[int_6], anIntArray118[int_7], this.aShortArray12[int_0]);
            }
         } else if (this.anIntArray132[int_0] == -1) {
            Graphics3D.rasterFlat(anIntArray122[int_1], anIntArray122[int_2], anIntArray122[int_3], anIntArray120[int_1], anIntArray120[int_2], anIntArray120[int_3], anIntArray128[this.anIntArray131[int_0]]);
         } else {
            Graphics3D.rasterGouraud(anIntArray122[int_1], anIntArray122[int_2], anIntArray122[int_3], anIntArray120[int_1], anIntArray120[int_2], anIntArray120[int_3], this.anIntArray131[int_0], this.anIntArray133[int_0], this.anIntArray132[int_0]);
         }

      }
   }

   void method1024(int int_0, int[] ints_0, int int_1, int int_2, int int_3) {
      int int_4 = ints_0.length;
      int int_5;
      int int_6;
      int int_8;
      int int_9;
      if (int_0 == 0) {
         int_5 = 0;
         anInt551 = 0;
         anInt552 = 0;
         anInt553 = 0;

         for (int_6 = 0; int_6 < int_4; int_6++) {
            int int_7 = ints_0[int_6];
            if (int_7 < this.anIntArrayArray17.length) {
               int[] ints_1 = this.anIntArrayArray17[int_7];

               for (int_8 = 0; int_8 < ints_1.length; int_8++) {
                  int_9 = ints_1[int_8];
                  anInt551 += this.verticesX[int_9];
                  anInt552 += this.verticesY[int_9];
                  anInt553 += this.verticesZ[int_9];
                  ++int_5;
               }
            }
         }

         if (int_5 > 0) {
            anInt551 = int_1 + anInt551 / int_5;
            anInt552 = int_2 + anInt552 / int_5;
            anInt553 = int_3 + anInt553 / int_5;
         } else {
            anInt551 = int_1;
            anInt552 = int_2;
            anInt553 = int_3;
         }

      } else {
         int[] ints_2;
         int int_10;
         if (int_0 == 1) {
            for (int_5 = 0; int_5 < int_4; int_5++) {
               int_6 = ints_0[int_5];
               if (int_6 < this.anIntArrayArray17.length) {
                  ints_2 = this.anIntArrayArray17[int_6];

                  for (int_10 = 0; int_10 < ints_2.length; int_10++) {
                     int_8 = ints_2[int_10];
                     this.verticesX[int_8] += int_1;
                     this.verticesY[int_8] += int_2;
                     this.verticesZ[int_8] += int_3;
                  }
               }
            }

         } else if (int_0 == 2) {
            for (int_5 = 0; int_5 < int_4; int_5++) {
               int_6 = ints_0[int_5];
               if (int_6 < this.anIntArrayArray17.length) {
                  ints_2 = this.anIntArrayArray17[int_6];

                  for (int_10 = 0; int_10 < ints_2.length; int_10++) {
                     int_8 = ints_2[int_10];
                     this.verticesX[int_8] -= anInt551;
                     this.verticesY[int_8] -= anInt552;
                     this.verticesZ[int_8] -= anInt553;
                     int_9 = (int_1 & 0xFF) * 8;
                     int int_11 = (int_2 & 0xFF) * 8;
                     int int_12 = (int_3 & 0xFF) * 8;
                     int int_13;
                     int int_14;
                     int int_15;
                     if (int_12 != 0) {
                        int_13 = SINE[int_12];
                        int_14 = COSINE[int_12];
                        int_15 = int_13 * this.verticesY[int_8] + int_14 * this.verticesX[int_8] >> 16;
                        this.verticesY[int_8] = int_14 * this.verticesY[int_8] - int_13 * this.verticesX[int_8] >> 16;
                        this.verticesX[int_8] = int_15;
                     }

                     if (int_9 != 0) {
                        int_13 = SINE[int_9];
                        int_14 = COSINE[int_9];
                        int_15 = int_14 * this.verticesY[int_8] - int_13 * this.verticesZ[int_8] >> 16;
                        this.verticesZ[int_8] = int_13 * this.verticesY[int_8] + int_14 * this.verticesZ[int_8] >> 16;
                        this.verticesY[int_8] = int_15;
                     }

                     if (int_11 != 0) {
                        int_13 = SINE[int_11];
                        int_14 = COSINE[int_11];
                        int_15 = int_13 * this.verticesZ[int_8] + int_14 * this.verticesX[int_8] >> 16;
                        this.verticesZ[int_8] = int_14 * this.verticesZ[int_8] - int_13 * this.verticesX[int_8] >> 16;
                        this.verticesX[int_8] = int_15;
                     }

                     this.verticesX[int_8] += anInt551;
                     this.verticesY[int_8] += anInt552;
                     this.verticesZ[int_8] += anInt553;
                  }
               }
            }

         } else if (int_0 == 3) {
            for (int_5 = 0; int_5 < int_4; int_5++) {
               int_6 = ints_0[int_5];
               if (int_6 < this.anIntArrayArray17.length) {
                  ints_2 = this.anIntArrayArray17[int_6];

                  for (int_10 = 0; int_10 < ints_2.length; int_10++) {
                     int_8 = ints_2[int_10];
                     this.verticesX[int_8] -= anInt551;
                     this.verticesY[int_8] -= anInt552;
                     this.verticesZ[int_8] -= anInt553;
                     this.verticesX[int_8] = int_1 * this.verticesX[int_8] / 128;
                     this.verticesY[int_8] = int_2 * this.verticesY[int_8] / 128;
                     this.verticesZ[int_8] = int_3 * this.verticesZ[int_8] / 128;
                     this.verticesX[int_8] += anInt551;
                     this.verticesY[int_8] += anInt552;
                     this.verticesZ[int_8] += anInt553;
                  }
               }
            }

         } else if (int_0 == 5) {
            if (this.anIntArrayArray18 != null && this.aByteArray23 != null) {
               for (int_5 = 0; int_5 < int_4; int_5++) {
                  int_6 = ints_0[int_5];
                  if (int_6 < this.anIntArrayArray18.length) {
                     ints_2 = this.anIntArrayArray18[int_6];

                     for (int_10 = 0; int_10 < ints_2.length; int_10++) {
                        int_8 = ints_2[int_10];
                        int_9 = (this.aByteArray23[int_8] & 0xFF) + int_1 * 8;
                        if (int_9 < 0) {
                           int_9 = 0;
                        } else if (int_9 > 255) {
                           int_9 = 255;
                        }

                        this.aByteArray23[int_8] = (byte)int_9;
                     }
                  }
               }
            }

         }
      }
   }

   void method1025(boolean bool_0, boolean bool_1, boolean bool_2, int int_0) {
      if (this.diagonal3D < 1600) {
         int int_1;
         for (int_1 = 0; int_1 < this.diagonal3D; int_1++) {
            anIntArray115[int_1] = 0;
         }

         int_1 = bool_2 ? 20 : 5;
         if (Class37.aBool16 && bool_1) {
            Enum3.method669(this, int_1);
         }

         int int_2;
         int int_3;
         int int_4;
         int int_5;
         int int_6;
         int int_7;
         int int_8;
         int int_10;
         int int_11;
         int int_13;
         for (int_2 = 0; int_2 < this.triangleCount; int_2++) {
            if (this.anIntArray132[int_2] != -2) {
               int_3 = this.indices1[int_2];
               int_4 = this.indices2[int_2];
               int_5 = this.indices3[int_2];
               int_6 = anIntArray120[int_3];
               int_7 = anIntArray120[int_4];
               int_8 = anIntArray120[int_5];
               int int_9;
               if (!bool_0 || int_6 != -5000 && int_7 != -5000 && int_8 != -5000) {
                  if (bool_1 && WorldMapData_Sub1.method603(anIntArray122[int_3], anIntArray122[int_4], anIntArray122[int_5], int_6, int_7, int_8, int_1)) {
                     Class54.anIntArray34[++Class54.anInt140 - 1] = int_0;
                     bool_1 = false;
                  }

                  if ((int_6 - int_7) * (anIntArray122[int_5] - anIntArray122[int_4]) - (int_8 - int_7) * (anIntArray122[int_3] - anIntArray122[int_4]) > 0) {
                     aBoolArray6[int_2] = false;
                     if (int_6 >= 0 && int_7 >= 0 && int_8 >= 0 && int_6 <= Graphics3D.rasterClipX && int_7 <= Graphics3D.rasterClipX && int_8 <= Graphics3D.rasterClipX) {
                        aBoolArray7[int_2] = false;
                     } else {
                        aBoolArray7[int_2] = true;
                     }

                     int_9 = (anIntArray124[int_3] + anIntArray124[int_4] + anIntArray124[int_5]) / 3 + this.shadowIntensity3D;
                     anIntArrayArray15[int_9][anIntArray115[int_9]++] = int_2;
                  }
               } else {
                  int_9 = yViewportBuffer[int_3];
                  int_10 = yViewportBuffer[int_4];
                  int_11 = yViewportBuffer[int_5];
                  int int_12 = anIntArray125[int_3];
                  int_13 = anIntArray125[int_4];
                  int int_14 = anIntArray125[int_5];
                  int int_15 = anIntArray118[int_3];
                  int int_16 = anIntArray118[int_4];
                  int int_17 = anIntArray118[int_5];
                  int_9 -= int_10;
                  int_11 -= int_10;
                  int_12 -= int_13;
                  int_14 -= int_13;
                  int_15 -= int_16;
                  int_17 -= int_16;
                  int int_18 = int_12 * int_17 - int_15 * int_14;
                  int int_19 = int_15 * int_11 - int_9 * int_17;
                  int int_20 = int_9 * int_14 - int_12 * int_11;
                  if (int_10 * int_18 + int_13 * int_19 + int_16 * int_20 > 0) {
                     aBoolArray6[int_2] = true;
                     int int_21 = (anIntArray124[int_3] + anIntArray124[int_4] + anIntArray124[int_5]) / 3 + this.shadowIntensity3D;
                     anIntArrayArray15[int_21][anIntArray115[int_21]++] = int_2;
                  }
               }
            }
         }

         int[] ints_0;
         if (this.trianglePriorities == null) {
            for (int_2 = this.diagonal3D - 1; int_2 >= 0; --int_2) {
               int_3 = anIntArray115[int_2];
               if (int_3 > 0) {
                  ints_0 = anIntArrayArray15[int_2];

                  for (int_5 = 0; int_5 < int_3; int_5++) {
                     this.method1023(ints_0[int_5]);
                  }
               }
            }

         } else {
            for (int_2 = 0; int_2 < 12; int_2++) {
               anIntArray119[int_2] = 0;
               anIntArray121[int_2] = 0;
            }

            for (int_2 = this.diagonal3D - 1; int_2 >= 0; --int_2) {
               int_3 = anIntArray115[int_2];
               if (int_3 > 0) {
                  ints_0 = anIntArrayArray15[int_2];

                  for (int_5 = 0; int_5 < int_3; int_5++) {
                     int_6 = ints_0[int_5];
                     byte byte_0 = this.trianglePriorities[int_6];
                     int_8 = anIntArray119[byte_0]++;
                     anIntArrayArray16[byte_0][int_8] = int_6;
                     if (byte_0 < 10) {
                        anIntArray121[byte_0] += int_2;
                     } else if (byte_0 == 10) {
                        anIntArray129[int_8] = int_2;
                     } else {
                        anIntArray130[int_8] = int_2;
                     }
                  }
               }
            }

            int_2 = 0;
            if (anIntArray119[1] > 0 || anIntArray119[2] > 0) {
               int_2 = (anIntArray121[1] + anIntArray121[2]) / (anIntArray119[1] + anIntArray119[2]);
            }

            int_3 = 0;
            if (anIntArray119[3] > 0 || anIntArray119[4] > 0) {
               int_3 = (anIntArray121[3] + anIntArray121[4]) / (anIntArray119[3] + anIntArray119[4]);
            }

            int_4 = 0;
            if (anIntArray119[6] > 0 || anIntArray119[8] > 0) {
               int_4 = (anIntArray121[8] + anIntArray121[6]) / (anIntArray119[8] + anIntArray119[6]);
            }

            int_6 = 0;
            int_7 = anIntArray119[10];
            int[] ints_1 = anIntArrayArray16[10];
            int[] ints_2 = anIntArray129;
            if (int_6 == int_7) {
               int_6 = 0;
               int_7 = anIntArray119[11];
               ints_1 = anIntArrayArray16[11];
               ints_2 = anIntArray130;
            }

            if (int_6 < int_7) {
               int_5 = ints_2[int_6];
            } else {
               int_5 = -1000;
            }

            for (int_10 = 0; int_10 < 10; int_10++) {
               while (int_10 == 0 && int_5 > int_2) {
                  this.method1023(ints_1[int_6++]);
                  if (int_6 == int_7 && ints_1 != anIntArrayArray16[11]) {
                     int_6 = 0;
                     int_7 = anIntArray119[11];
                     ints_1 = anIntArrayArray16[11];
                     ints_2 = anIntArray130;
                  }

                  if (int_6 < int_7) {
                     int_5 = ints_2[int_6];
                  } else {
                     int_5 = -1000;
                  }
               }

               while (int_10 == 3 && int_5 > int_3) {
                  this.method1023(ints_1[int_6++]);
                  if (int_6 == int_7 && ints_1 != anIntArrayArray16[11]) {
                     int_6 = 0;
                     int_7 = anIntArray119[11];
                     ints_1 = anIntArrayArray16[11];
                     ints_2 = anIntArray130;
                  }

                  if (int_6 < int_7) {
                     int_5 = ints_2[int_6];
                  } else {
                     int_5 = -1000;
                  }
               }

               while (int_10 == 5 && int_5 > int_4) {
                  this.method1023(ints_1[int_6++]);
                  if (int_6 == int_7 && ints_1 != anIntArrayArray16[11]) {
                     int_6 = 0;
                     int_7 = anIntArray119[11];
                     ints_1 = anIntArrayArray16[11];
                     ints_2 = anIntArray130;
                  }

                  if (int_6 < int_7) {
                     int_5 = ints_2[int_6];
                  } else {
                     int_5 = -1000;
                  }
               }

               int_11 = anIntArray119[int_10];
               int[] ints_3 = anIntArrayArray16[int_10];

               for (int_13 = 0; int_13 < int_11; int_13++) {
                  this.method1023(ints_3[int_13]);
               }
            }

            while (int_5 != -1000) {
               this.method1023(ints_1[int_6++]);
               if (int_6 == int_7 && ints_1 != anIntArrayArray16[11]) {
                  int_6 = 0;
                  ints_1 = anIntArrayArray16[11];
                  int_7 = anIntArray119[11];
                  ints_2 = anIntArray130;
               }

               if (int_6 < int_7) {
                  int_5 = ints_2[int_6];
               } else {
                  int_5 = -1000;
               }
            }

         }
      }
   }

   public void method1026(int int_0, int int_1, int int_2) {
      for (int int_3 = 0; int_3 < this.vertexCount; int_3++) {
         this.verticesX[int_3] += int_0;
         this.verticesY[int_3] += int_1;
         this.verticesZ[int_3] += int_2;
      }

      this.method1009();
   }

   public void method1027(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6) {
      anIntArray115[0] = -1;
      if (this.anInt556 != 2 && this.anInt556 != 1) {
         this.method1014();
      }

      int int_7 = Graphics3D.centerX;
      int int_8 = Graphics3D.centerY;
      int int_9 = SINE[int_0];
      int int_10 = COSINE[int_0];
      int int_11 = SINE[int_1];
      int int_12 = COSINE[int_1];
      int int_13 = SINE[int_2];
      int int_14 = COSINE[int_2];
      int int_15 = SINE[int_3];
      int int_16 = COSINE[int_3];
      int int_17 = int_15 * int_5 + int_16 * int_6 >> 16;

      for (int int_18 = 0; int_18 < this.vertexCount; int_18++) {
         int int_19 = this.verticesX[int_18];
         int int_20 = this.verticesY[int_18];
         int int_21 = this.verticesZ[int_18];
         int int_22;
         if (int_2 != 0) {
            int_22 = int_20 * int_13 + int_19 * int_14 >> 16;
            int_20 = int_20 * int_14 - int_19 * int_13 >> 16;
            int_19 = int_22;
         }

         if (int_0 != 0) {
            int_22 = int_20 * int_10 - int_21 * int_9 >> 16;
            int_21 = int_20 * int_9 + int_21 * int_10 >> 16;
            int_20 = int_22;
         }

         if (int_1 != 0) {
            int_22 = int_21 * int_11 + int_19 * int_12 >> 16;
            int_21 = int_21 * int_12 - int_19 * int_11 >> 16;
            int_19 = int_22;
         }

         int_19 += int_4;
         int_20 += int_5;
         int_21 += int_6;
         int_22 = int_20 * int_16 - int_21 * int_15 >> 16;
         int_21 = int_20 * int_15 + int_21 * int_16 >> 16;
         anIntArray124[int_18] = int_21 - int_17;
         anIntArray120[int_18] = int_19 * Graphics3D.anInt543 / int_21 + int_7;
         anIntArray122[int_18] = int_22 * Graphics3D.anInt543 / int_21 + int_8;
         if (this.texturedTriangleCount > 0) {
            yViewportBuffer[int_18] = int_19;
            anIntArray125[int_18] = int_22;
            anIntArray118[int_18] = int_21;
         }
      }

      try {
         this.method1025(false, false, false, 0);
      } catch (Exception exception_0) {
         ;
      }

   }

   public void method1028(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7) {
      anIntArray115[0] = -1;
      if (this.anInt556 != 2 && this.anInt556 != 1) {
         this.method1014();
      }

      int int_8 = Graphics3D.centerX;
      int int_9 = Graphics3D.centerY;
      int int_10 = SINE[int_0];
      int int_11 = COSINE[int_0];
      int int_12 = SINE[int_1];
      int int_13 = COSINE[int_1];
      int int_14 = SINE[int_2];
      int int_15 = COSINE[int_2];
      int int_16 = SINE[int_3];
      int int_17 = COSINE[int_3];
      int int_18 = int_16 * int_5 + int_17 * int_6 >> 16;

      for (int int_19 = 0; int_19 < this.vertexCount; int_19++) {
         int int_20 = this.verticesX[int_19];
         int int_21 = this.verticesY[int_19];
         int int_22 = this.verticesZ[int_19];
         int int_23;
         if (int_2 != 0) {
            int_23 = int_21 * int_14 + int_20 * int_15 >> 16;
            int_21 = int_21 * int_15 - int_20 * int_14 >> 16;
            int_20 = int_23;
         }

         if (int_0 != 0) {
            int_23 = int_21 * int_11 - int_22 * int_10 >> 16;
            int_22 = int_21 * int_10 + int_22 * int_11 >> 16;
            int_21 = int_23;
         }

         if (int_1 != 0) {
            int_23 = int_22 * int_12 + int_20 * int_13 >> 16;
            int_22 = int_22 * int_13 - int_20 * int_12 >> 16;
            int_20 = int_23;
         }

         int_20 += int_4;
         int_21 += int_5;
         int_22 += int_6;
         int_23 = int_21 * int_17 - int_22 * int_16 >> 16;
         int_22 = int_21 * int_16 + int_22 * int_17 >> 16;
         anIntArray124[int_19] = int_22 - int_18;
         anIntArray120[int_19] = int_8 + int_20 * Graphics3D.anInt543 / int_7;
         anIntArray122[int_19] = int_9 + int_23 * Graphics3D.anInt543 / int_7;
         if (this.texturedTriangleCount > 0) {
            yViewportBuffer[int_19] = int_20;
            anIntArray125[int_19] = int_23;
            anIntArray118[int_19] = int_22;
         }
      }

      try {
         this.method1025(false, false, false, 0);
      } catch (Exception exception_0) {
         ;
      }

   }

   public int getShadowIntensity() {
      this.calculateDiagonals();
      return this.shadowIntensity;
   }

}
