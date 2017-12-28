public class Model extends Renderable {

   static boolean[] triangleRenderRules;
   static int[] anIntArray115;
   static int[] SINE;
   static Model aModel1;
   static byte[] moreTempTriangleAlphas;
   static Model aModel2;
   static int anInt551;
   static byte[] tempTriangleAlphas;
   static int[] COSINE;
   static int anInt552;
   static int anInt553;
   static int[] vertexMvZ;
   static boolean[] aBoolArray7;
   static int[] anIntArray119;
   public static int[] vertexScreenX;
   static int[] anIntArray121;
   public static int[] vertexScreenY;
   static int[] writtenScreenPixelsX;
   static int[] vertexMvX;
   static int[][] anIntArrayArray15;
   static int[] vertexScreenZ;
   static int[] vertexMvY;
   static int[] writtenScreenPixelsY;
   static int[] mvzDistances;
   static int[] writtenScreenPixelsHLSAColour;
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
   public int[] trianglePointsX;
   int shadowIntensity;
   int[] verticesX;
   int[] verticesZ;
   public int triangleCount;
   public int[] trianglePointsY;
   int[][] anIntArrayArray18;
   byte priorityOffset;
   int maxY;
   public int[] trianglePointsZ;
   int[] verticesY;
   int texturedTriangleCount;
   byte[] triangleAlphaValues;
   public int anInt562;
   int[] triangleHSLA;
   public int[] anIntArray132;
   public int anInt563;
   public boolean fitsOnSingleSquare;
   int[] anIntArray133;
   byte[] trianglePriorities;
   public int anInt564;
   int shadowIntensity3D;
   public int anInt566;
   short[] aShortArray12;
   byte[] texturePoints;
   int[] texturedTrianglePointsX;
   int[] texturedTrianglePointsY;
   int[] texturedTrianglePointsZ;

   static {
      aModel2 = new Model();
      tempTriangleAlphas = new byte[1];
      aModel1 = new Model();
      moreTempTriangleAlphas = new byte[1];
      aBoolArray7 = new boolean[4700];
      triangleRenderRules = new boolean[4700];
      vertexScreenX = new int[4700];
      vertexScreenY = new int[4700];
      vertexScreenZ = new int[4700];
      vertexMvX = new int[4700];
      vertexMvY = new int[4700];
      vertexMvZ = new int[4700];
      anIntArray115 = new int[1600];
      anIntArrayArray15 = new int[1600][512];
      anIntArray119 = new int[12];
      anIntArrayArray16 = new int[12][2000];
      anIntArray129 = new int[2000];
      anIntArray130 = new int[2000];
      anIntArray121 = new int[12];
      writtenScreenPixelsX = new int[10];
      writtenScreenPixelsY = new int[10];
      writtenScreenPixelsHLSAColour = new int[10];
      aBool74 = true;
      SINE = Rasterizer3D.SINE;
      COSINE = Rasterizer3D.COSINE;
      anIntArray128 = Rasterizer3D.colourPalette;
      mvzDistances = Rasterizer3D.anIntArray114;
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

            bool_1 |= model.triangleAlphaValues != null;
            bool_2 |= model.aShortArray12 != null;
            bool_3 |= model.texturePoints != null;
         }
      }

      this.verticesX = new int[this.vertexCount];
      this.verticesY = new int[this.vertexCount];
      this.verticesZ = new int[this.vertexCount];
      this.trianglePointsX = new int[this.triangleCount];
      this.trianglePointsY = new int[this.triangleCount];
      this.trianglePointsZ = new int[this.triangleCount];
      this.triangleHSLA = new int[this.triangleCount];
      this.anIntArray133 = new int[this.triangleCount];
      this.anIntArray132 = new int[this.triangleCount];
      if (hasTriangleProperties) {
         this.trianglePriorities = new byte[this.triangleCount];
      }

      if (bool_1) {
         this.triangleAlphaValues = new byte[this.triangleCount];
      }

      if (bool_2) {
         this.aShortArray12 = new short[this.triangleCount];
      }

      if (bool_3) {
         this.texturePoints = new byte[this.triangleCount];
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
               this.trianglePointsX[this.triangleCount] = this.vertexCount + model.trianglePointsX[vertex];
               this.trianglePointsY[this.triangleCount] = this.vertexCount + model.trianglePointsY[vertex];
               this.trianglePointsZ[this.triangleCount] = this.vertexCount + model.trianglePointsZ[vertex];
               this.triangleHSLA[this.triangleCount] = model.triangleHSLA[vertex];
               this.anIntArray133[this.triangleCount] = model.anIntArray133[vertex];
               this.anIntArray132[this.triangleCount] = model.anIntArray132[vertex];
               if (hasTriangleProperties) {
                  if (model.trianglePriorities != null) {
                     this.trianglePriorities[this.triangleCount] = model.trianglePriorities[vertex];
                  } else {
                     this.trianglePriorities[this.triangleCount] = model.priorityOffset;
                  }
               }

               if (bool_1 && model.triangleAlphaValues != null) {
                  this.triangleAlphaValues[this.triangleCount] = model.triangleAlphaValues[vertex];
               }

               if (bool_2) {
                  if (model.aShortArray12 != null) {
                     this.aShortArray12[this.triangleCount] = model.aShortArray12[vertex];
                  } else {
                     this.aShortArray12[this.triangleCount] = -1;
                  }
               }

               if (bool_3) {
                  if (model.texturePoints != null && model.texturePoints[vertex] != -1) {
                     this.texturePoints[this.triangleCount] = (byte)(this.texturedTriangleCount + model.texturePoints[vertex]);
                  } else {
                     this.texturePoints[this.triangleCount] = -1;
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

   public static void drawCube(Model model_0, int renderX, int renderZ, int renderY) {
      if (Class4.method82(model_0, renderX, renderZ, renderY)) {
         Class42.method264(model_0, renderX, renderZ, renderY, -65281);
      } else if (Class37.aClass26_3 == Class26.aClass26_2) {
         Class42.method264(model_0, renderX, renderZ, renderY, -16776961);
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

         this.reset();
      }
   }

   void reset() {
      this.anInt556 = 0;
      this.anInt555 = -1;
   }

   void rasterizeTriangle(int triangleIndex) {
      int screenX = Rasterizer3D.centerX;
      int screenY = Rasterizer3D.centerY;
      int pixelIndex = 0;
      int trianglePointX = this.trianglePointsX[triangleIndex];
      int trianglePointY = this.trianglePointsY[triangleIndex];
      int trianglePointZ = this.trianglePointsZ[triangleIndex];
      int mvzPointX = vertexMvZ[trianglePointX];
      int mvzPointY = vertexMvZ[trianglePointY];
      int mvzPointZ = vertexMvZ[trianglePointZ];
      if (this.triangleAlphaValues == null) {
         Rasterizer3D.alpha = 0;
      } else {
         Rasterizer3D.alpha = this.triangleAlphaValues[triangleIndex] & 0xFF;
      }

      int mvxPointX;
      int mvyPointX;
      int colour;
      int calc;
      if (mvzPointX >= 50) {
         writtenScreenPixelsX[pixelIndex] = vertexScreenX[trianglePointX];
         writtenScreenPixelsY[pixelIndex] = vertexScreenY[trianglePointX];
         writtenScreenPixelsHLSAColour[pixelIndex++] = this.triangleHSLA[triangleIndex];
      } else {
         mvxPointX = vertexMvX[trianglePointX];
         mvyPointX = vertexMvY[trianglePointX];
         colour = this.triangleHSLA[triangleIndex];
         if (mvzPointZ >= 50) {
            calc = mvzDistances[mvzPointZ - mvzPointX] * (50 - mvzPointX);
            writtenScreenPixelsX[pixelIndex] = screenX + Rasterizer3D.anInt543 * (mvxPointX + ((vertexMvX[trianglePointZ] - mvxPointX) * calc >> 16)) / 50;
            writtenScreenPixelsY[pixelIndex] = screenY + Rasterizer3D.anInt543 * (mvyPointX + ((vertexMvY[trianglePointZ] - mvyPointX) * calc >> 16)) / 50;
            writtenScreenPixelsHLSAColour[pixelIndex++] = colour + ((this.anIntArray132[triangleIndex] - colour) * calc >> 16);
         }

         if (mvzPointY >= 50) {
            calc = mvzDistances[mvzPointY - mvzPointX] * (50 - mvzPointX);
            writtenScreenPixelsX[pixelIndex] = screenX + Rasterizer3D.anInt543 * (mvxPointX + ((vertexMvX[trianglePointY] - mvxPointX) * calc >> 16)) / 50;
            writtenScreenPixelsY[pixelIndex] = screenY + Rasterizer3D.anInt543 * (mvyPointX + ((vertexMvY[trianglePointY] - mvyPointX) * calc >> 16)) / 50;
            writtenScreenPixelsHLSAColour[pixelIndex++] = colour + ((this.anIntArray133[triangleIndex] - colour) * calc >> 16);
         }
      }

      if (mvzPointY >= 50) {
         writtenScreenPixelsX[pixelIndex] = vertexScreenX[trianglePointY];
         writtenScreenPixelsY[pixelIndex] = vertexScreenY[trianglePointY];
         writtenScreenPixelsHLSAColour[pixelIndex++] = this.anIntArray133[triangleIndex];
      } else {
         mvxPointX = vertexMvX[trianglePointY];
         mvyPointX = vertexMvY[trianglePointY];
         colour = this.anIntArray133[triangleIndex];
         if (mvzPointX >= 50) {
            calc = mvzDistances[mvzPointX - mvzPointY] * (50 - mvzPointY);
            writtenScreenPixelsX[pixelIndex] = screenX + Rasterizer3D.anInt543 * (mvxPointX + ((vertexMvX[trianglePointX] - mvxPointX) * calc >> 16)) / 50;
            writtenScreenPixelsY[pixelIndex] = screenY + Rasterizer3D.anInt543 * (mvyPointX + ((vertexMvY[trianglePointX] - mvyPointX) * calc >> 16)) / 50;
            writtenScreenPixelsHLSAColour[pixelIndex++] = colour + ((this.triangleHSLA[triangleIndex] - colour) * calc >> 16);
         }

         if (mvzPointZ >= 50) {
            calc = mvzDistances[mvzPointZ - mvzPointY] * (50 - mvzPointY);
            writtenScreenPixelsX[pixelIndex] = screenX + Rasterizer3D.anInt543 * (mvxPointX + ((vertexMvX[trianglePointZ] - mvxPointX) * calc >> 16)) / 50;
            writtenScreenPixelsY[pixelIndex] = screenY + Rasterizer3D.anInt543 * (mvyPointX + ((vertexMvY[trianglePointZ] - mvyPointX) * calc >> 16)) / 50;
            writtenScreenPixelsHLSAColour[pixelIndex++] = colour + ((this.anIntArray132[triangleIndex] - colour) * calc >> 16);
         }
      }

      if (mvzPointZ >= 50) {
         writtenScreenPixelsX[pixelIndex] = vertexScreenX[trianglePointZ];
         writtenScreenPixelsY[pixelIndex] = vertexScreenY[trianglePointZ];
         writtenScreenPixelsHLSAColour[pixelIndex++] = this.anIntArray132[triangleIndex];
      } else {
         mvxPointX = vertexMvX[trianglePointZ];
         mvyPointX = vertexMvY[trianglePointZ];
         colour = this.anIntArray132[triangleIndex];
         if (mvzPointY >= 50) {
            calc = mvzDistances[mvzPointY - mvzPointZ] * (50 - mvzPointZ);
            writtenScreenPixelsX[pixelIndex] = screenX + Rasterizer3D.anInt543 * (mvxPointX + ((vertexMvX[trianglePointY] - mvxPointX) * calc >> 16)) / 50;
            writtenScreenPixelsY[pixelIndex] = screenY + Rasterizer3D.anInt543 * (mvyPointX + ((vertexMvY[trianglePointY] - mvyPointX) * calc >> 16)) / 50;
            writtenScreenPixelsHLSAColour[pixelIndex++] = colour + ((this.anIntArray133[triangleIndex] - colour) * calc >> 16);
         }

         if (mvzPointX >= 50) {
            calc = mvzDistances[mvzPointX - mvzPointZ] * (50 - mvzPointZ);
            writtenScreenPixelsX[pixelIndex] = screenX + Rasterizer3D.anInt543 * (mvxPointX + ((vertexMvX[trianglePointX] - mvxPointX) * calc >> 16)) / 50;
            writtenScreenPixelsY[pixelIndex] = screenY + Rasterizer3D.anInt543 * (mvyPointX + ((vertexMvY[trianglePointX] - mvyPointX) * calc >> 16)) / 50;
            writtenScreenPixelsHLSAColour[pixelIndex++] = colour + ((this.triangleHSLA[triangleIndex] - colour) * calc >> 16);
         }
      }

      mvxPointX = writtenScreenPixelsX[0];
      mvyPointX = writtenScreenPixelsX[1];
      colour = writtenScreenPixelsX[2];
      calc = writtenScreenPixelsY[0];
      int pixelY2 = writtenScreenPixelsY[1];
      int pixelY3 = writtenScreenPixelsY[2];
      Rasterizer3D.restrictEdges = false;
      int pointX;
      int pointIndex;
      int pointY;
      int pointZ;
      if (pixelIndex == 3) {
         if (mvxPointX < 0 || mvyPointX < 0 || colour < 0 || mvxPointX > Rasterizer3D.rasterClipX || mvyPointX > Rasterizer3D.rasterClipX || colour > Rasterizer3D.rasterClipX) {
            Rasterizer3D.restrictEdges = true;
         }

         if (this.aShortArray12 != null && this.aShortArray12[triangleIndex] != -1) {
            if (this.texturePoints != null && this.texturePoints[triangleIndex] != -1) {
               pointIndex = this.texturePoints[triangleIndex] & 0xFF;
               pointX = this.texturedTrianglePointsX[pointIndex];
               pointY = this.texturedTrianglePointsY[pointIndex];
               pointZ = this.texturedTrianglePointsZ[pointIndex];
            } else {
               pointX = trianglePointX;
               pointY = trianglePointY;
               pointZ = trianglePointZ;
            }

            if (this.anIntArray132[triangleIndex] == -1) {
               Rasterizer3D.drawTexturedTriangle(calc, pixelY2, pixelY3, mvxPointX, mvyPointX, colour, this.triangleHSLA[triangleIndex], this.triangleHSLA[triangleIndex], this.triangleHSLA[triangleIndex], vertexMvX[pointX], vertexMvX[pointY], vertexMvX[pointZ], vertexMvY[pointX], vertexMvY[pointY], vertexMvY[pointZ], vertexMvZ[pointX], vertexMvZ[pointY], vertexMvZ[pointZ], this.aShortArray12[triangleIndex]);
            } else {
               Rasterizer3D.drawTexturedTriangle(calc, pixelY2, pixelY3, mvxPointX, mvyPointX, colour, writtenScreenPixelsHLSAColour[0], writtenScreenPixelsHLSAColour[1], writtenScreenPixelsHLSAColour[2], vertexMvX[pointX], vertexMvX[pointY], vertexMvX[pointZ], vertexMvY[pointX], vertexMvY[pointY], vertexMvY[pointZ], vertexMvZ[pointX], vertexMvZ[pointY], vertexMvZ[pointZ], this.aShortArray12[triangleIndex]);
            }
         } else if (this.anIntArray132[triangleIndex] == -1) {
            Rasterizer3D.drawFlatTriangle(calc, pixelY2, pixelY3, mvxPointX, mvyPointX, colour, anIntArray128[this.triangleHSLA[triangleIndex]]);
         } else {
            Rasterizer3D.drawShadedTriangle(calc, pixelY2, pixelY3, mvxPointX, mvyPointX, colour, writtenScreenPixelsHLSAColour[0], writtenScreenPixelsHLSAColour[1], writtenScreenPixelsHLSAColour[2]);
         }
      }

      if (pixelIndex == 4) {
         if (mvxPointX < 0 || mvyPointX < 0 || colour < 0 || mvxPointX > Rasterizer3D.rasterClipX || mvyPointX > Rasterizer3D.rasterClipX || colour > Rasterizer3D.rasterClipX || writtenScreenPixelsX[3] < 0 || writtenScreenPixelsX[3] > Rasterizer3D.rasterClipX) {
            Rasterizer3D.restrictEdges = true;
         }

         if (this.aShortArray12 != null && this.aShortArray12[triangleIndex] != -1) {
            if (this.texturePoints != null && this.texturePoints[triangleIndex] != -1) {
               pointIndex = this.texturePoints[triangleIndex] & 0xFF;
               pointX = this.texturedTrianglePointsX[pointIndex];
               pointY = this.texturedTrianglePointsY[pointIndex];
               pointZ = this.texturedTrianglePointsZ[pointIndex];
            } else {
               pointX = trianglePointX;
               pointY = trianglePointY;
               pointZ = trianglePointZ;
            }

            short short_0 = this.aShortArray12[triangleIndex];
            if (this.anIntArray132[triangleIndex] == -1) {
               Rasterizer3D.drawTexturedTriangle(calc, pixelY2, pixelY3, mvxPointX, mvyPointX, colour, this.triangleHSLA[triangleIndex], this.triangleHSLA[triangleIndex], this.triangleHSLA[triangleIndex], vertexMvX[pointX], vertexMvX[pointY], vertexMvX[pointZ], vertexMvY[pointX], vertexMvY[pointY], vertexMvY[pointZ], vertexMvZ[pointX], vertexMvZ[pointY], vertexMvZ[pointZ], short_0);
               Rasterizer3D.drawTexturedTriangle(calc, pixelY3, writtenScreenPixelsY[3], mvxPointX, colour, writtenScreenPixelsX[3], this.triangleHSLA[triangleIndex], this.triangleHSLA[triangleIndex], this.triangleHSLA[triangleIndex], vertexMvX[pointX], vertexMvX[pointY], vertexMvX[pointZ], vertexMvY[pointX], vertexMvY[pointY], vertexMvY[pointZ], vertexMvZ[pointX], vertexMvZ[pointY], vertexMvZ[pointZ], short_0);
            } else {
               Rasterizer3D.drawTexturedTriangle(calc, pixelY2, pixelY3, mvxPointX, mvyPointX, colour, writtenScreenPixelsHLSAColour[0], writtenScreenPixelsHLSAColour[1], writtenScreenPixelsHLSAColour[2], vertexMvX[pointX], vertexMvX[pointY], vertexMvX[pointZ], vertexMvY[pointX], vertexMvY[pointY], vertexMvY[pointZ], vertexMvZ[pointX], vertexMvZ[pointY], vertexMvZ[pointZ], short_0);
               Rasterizer3D.drawTexturedTriangle(calc, pixelY3, writtenScreenPixelsY[3], mvxPointX, colour, writtenScreenPixelsX[3], writtenScreenPixelsHLSAColour[0], writtenScreenPixelsHLSAColour[2], writtenScreenPixelsHLSAColour[3], vertexMvX[pointX], vertexMvX[pointY], vertexMvX[pointZ], vertexMvY[pointX], vertexMvY[pointY], vertexMvY[pointZ], vertexMvZ[pointX], vertexMvZ[pointY], vertexMvZ[pointZ], short_0);
            }
         } else if (this.anIntArray132[triangleIndex] == -1) {
            pointX = anIntArray128[this.triangleHSLA[triangleIndex]];
            Rasterizer3D.drawFlatTriangle(calc, pixelY2, pixelY3, mvxPointX, mvyPointX, colour, pointX);
            Rasterizer3D.drawFlatTriangle(calc, pixelY3, writtenScreenPixelsY[3], mvxPointX, colour, writtenScreenPixelsX[3], pointX);
         } else {
            Rasterizer3D.drawShadedTriangle(calc, pixelY2, pixelY3, mvxPointX, mvyPointX, colour, writtenScreenPixelsHLSAColour[0], writtenScreenPixelsHLSAColour[1], writtenScreenPixelsHLSAColour[2]);
            Rasterizer3D.drawShadedTriangle(calc, pixelY3, writtenScreenPixelsY[3], mvxPointX, colour, writtenScreenPixelsX[3], writtenScreenPixelsHLSAColour[0], writtenScreenPixelsHLSAColour[2], writtenScreenPixelsHLSAColour[3]);
         }
      }

   }

   Model replaceAlphas(boolean replace, Model model, byte[] alphas) {
      model.vertexCount = this.vertexCount;
      model.triangleCount = this.triangleCount;
      model.texturedTriangleCount = this.texturedTriangleCount;
      if (model.verticesX == null || model.verticesX.length < this.vertexCount) {
         model.verticesX = new int[this.vertexCount + 100];
         model.verticesY = new int[this.vertexCount + 100];
         model.verticesZ = new int[this.vertexCount + 100];
      }

      int vertex;
      for (vertex = 0; vertex < this.vertexCount; vertex++) {
         model.verticesX[vertex] = this.verticesX[vertex];
         model.verticesY[vertex] = this.verticesY[vertex];
         model.verticesZ[vertex] = this.verticesZ[vertex];
      }

      if (replace) {
         model.triangleAlphaValues = this.triangleAlphaValues;
      } else {
         model.triangleAlphaValues = alphas;
         if (this.triangleAlphaValues == null) {
            for (vertex = 0; vertex < this.triangleCount; vertex++) {
               model.triangleAlphaValues[vertex] = 0;
            }
         } else {
            for (vertex = 0; vertex < this.triangleCount; vertex++) {
               model.triangleAlphaValues[vertex] = this.triangleAlphaValues[vertex];
            }
         }
      }

      model.trianglePointsX = this.trianglePointsX;
      model.trianglePointsY = this.trianglePointsY;
      model.trianglePointsZ = this.trianglePointsZ;
      model.triangleHSLA = this.triangleHSLA;
      model.anIntArray133 = this.anIntArray133;
      model.anIntArray132 = this.anIntArray132;
      model.trianglePriorities = this.trianglePriorities;
      model.texturePoints = this.texturePoints;
      model.aShortArray12 = this.aShortArray12;
      model.priorityOffset = this.priorityOffset;
      model.texturedTrianglePointsX = this.texturedTrianglePointsX;
      model.texturedTrianglePointsY = this.texturedTrianglePointsY;
      model.texturedTrianglePointsZ = this.texturedTrianglePointsZ;
      model.anIntArrayArray17 = this.anIntArrayArray17;
      model.anIntArrayArray18 = this.anIntArrayArray18;
      model.fitsOnSingleSquare = this.fitsOnSingleSquare;
      model.reset();
      return model;
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
            int int_10 = Rasterizer3D.method958(this.verticesX[int_9], this.verticesZ[int_9], cos, sine);
            int int_11 = this.verticesY[int_9];
            int int_12 = Rasterizer3D.method959(this.verticesX[int_9], this.verticesZ[int_9], cos, sine);
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

   public Model replaceAlphaValues(boolean replace) {
      if (!replace && tempTriangleAlphas.length < this.triangleCount) {
         tempTriangleAlphas = new byte[this.triangleCount + 100];
      }

      return this.replaceAlphas(replace, aModel2, tempTriangleAlphas);
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

   public Model replaceMoreAlphaValues(boolean replace) {
      if (!replace && moreTempTriangleAlphas.length < this.triangleCount) {
         moreTempTriangleAlphas = new byte[this.triangleCount + 100];
      }

      return this.replaceAlphas(replace, aModel1, moreTempTriangleAlphas);
   }

   public void method1016(int int_0) {
      int int_1 = SINE[int_0];
      int int_2 = COSINE[int_0];

      for (int int_3 = 0; int_3 < this.vertexCount; int_3++) {
         int int_4 = int_2 * this.verticesY[int_3] - int_1 * this.verticesZ[int_3] >> 16;
         this.verticesZ[int_3] = int_1 * this.verticesY[int_3] + int_2 * this.verticesZ[int_3] >> 16;
         this.verticesY[int_3] = int_4;
      }

      this.reset();
   }

   public Model adjustToTerrain(int[][] heights, int vertexX, int mean, int vertexY, boolean clone, int clipType) {
      this.calculateDiagonals();
      int shadowMinX = vertexX - this.shadowIntensity;
      int shadowMaxX = vertexX + this.shadowIntensity;
      int shadowMinY = vertexY - this.shadowIntensity;
      int shadowMaxY = vertexY + this.shadowIntensity;
      if (shadowMinX >= 0 && shadowMaxX + 128 >> 7 < heights.length && shadowMinY >= 0 && shadowMaxY + 128 >> 7 < heights[0].length) {
         shadowMinX >>= 7;
         shadowMaxX = shadowMaxX + 127 >> 7;
         shadowMinY >>= 7;
         shadowMaxY = shadowMaxY + 127 >> 7;
         if (mean == heights[shadowMinX][shadowMinY] && mean == heights[shadowMaxX][shadowMinY] && mean == heights[shadowMinX][shadowMaxY] && mean == heights[shadowMaxX][shadowMaxY]) {
            return this;
         } else {
            Model model;
            if (clone) {
               model = new Model();
               model.vertexCount = this.vertexCount;
               model.triangleCount = this.triangleCount;
               model.texturedTriangleCount = this.texturedTriangleCount;
               model.verticesX = this.verticesX;
               model.verticesZ = this.verticesZ;
               model.trianglePointsX = this.trianglePointsX;
               model.trianglePointsY = this.trianglePointsY;
               model.trianglePointsZ = this.trianglePointsZ;
               model.triangleHSLA = this.triangleHSLA;
               model.anIntArray133 = this.anIntArray133;
               model.anIntArray132 = this.anIntArray132;
               model.trianglePriorities = this.trianglePriorities;
               model.triangleAlphaValues = this.triangleAlphaValues;
               model.texturePoints = this.texturePoints;
               model.aShortArray12 = this.aShortArray12;
               model.priorityOffset = this.priorityOffset;
               model.texturedTrianglePointsX = this.texturedTrianglePointsX;
               model.texturedTrianglePointsY = this.texturedTrianglePointsY;
               model.texturedTrianglePointsZ = this.texturedTrianglePointsZ;
               model.anIntArrayArray17 = this.anIntArrayArray17;
               model.anIntArrayArray18 = this.anIntArrayArray18;
               model.fitsOnSingleSquare = this.fitsOnSingleSquare;
               model.verticesY = new int[model.vertexCount];
            } else {
               model = this;
            }

            int vertex;
            int int_9;
            int int_10;
            int int_11;
            int int_12;
            int int_13;
            int int_14;
            int int_15;
            int int_16;
            int int_17;
            if (clipType == 0) {
               for (vertex = 0; vertex < model.vertexCount; vertex++) {
                  int_9 = vertexX + this.verticesX[vertex];
                  int_10 = vertexY + this.verticesZ[vertex];
                  int_11 = int_9 & 0x7F;
                  int_12 = int_10 & 0x7F;
                  int_13 = int_9 >> 7;
                  int_14 = int_10 >> 7;
                  int_15 = heights[int_13][int_14] * (128 - int_11) + heights[int_13 + 1][int_14] * int_11 >> 7;
                  int_16 = heights[int_13][int_14 + 1] * (128 - int_11) + int_11 * heights[int_13 + 1][int_14 + 1] >> 7;
                  int_17 = int_15 * (128 - int_12) + int_16 * int_12 >> 7;
                  model.verticesY[vertex] = int_17 + this.verticesY[vertex] - mean;
               }
            } else {
               for (vertex = 0; vertex < model.vertexCount; vertex++) {
                  int_9 = (-this.verticesY[vertex] << 16) / super.modelHeight;
                  if (int_9 < clipType) {
                     int_10 = vertexX + this.verticesX[vertex];
                     int_11 = vertexY + this.verticesZ[vertex];
                     int_12 = int_10 & 0x7F;
                     int_13 = int_11 & 0x7F;
                     int_14 = int_10 >> 7;
                     int_15 = int_11 >> 7;
                     int_16 = heights[int_14][int_15] * (128 - int_12) + heights[int_14 + 1][int_15] * int_12 >> 7;
                     int_17 = heights[int_14][int_15 + 1] * (128 - int_12) + int_12 * heights[int_14 + 1][int_15 + 1] >> 7;
                     int int_18 = int_16 * (128 - int_13) + int_17 * int_13 >> 7;
                     model.verticesY[vertex] = (clipType - int_9) * (int_18 - mean) / clipType + this.verticesY[vertex];
                  }
               }
            }

            model.reset();
            return model;
         }
      } else {
         return this;
      }
   }

   void draw(int rotation, int yCurveSine, int yCurveCosine, int xCurveSine, int xCurveCosine, int renderX, int renderZ, int renderY, int hash) {
      anIntArray115[0] = -1;
      if (this.anInt556 != 1) {
         this.calculateDiagonals();
      }

      this.method1012(rotation);
      int int_9 = xCurveCosine * renderY - xCurveSine * renderX >> 16;
      int int_10 = yCurveSine * renderZ + yCurveCosine * int_9 >> 16;
      int int_11 = yCurveCosine * this.shadowIntensity >> 16;
      int int_12 = int_10 + int_11;
      if (int_12 > 50 && int_10 < 3500) {
         int int_13 = renderY * xCurveSine + xCurveCosine * renderX >> 16;
         int int_14 = (int_13 - this.shadowIntensity) * Rasterizer3D.anInt543;
         if (int_14 / int_12 < Rasterizer3D.anInt544) {
            int int_15 = (int_13 + this.shadowIntensity) * Rasterizer3D.anInt543;
            if (int_15 / int_12 > Rasterizer3D.anInt545) {
               int int_16 = yCurveCosine * renderZ - int_9 * yCurveSine >> 16;
               int int_17 = yCurveSine * this.shadowIntensity >> 16;
               int int_18 = (int_16 + int_17) * Rasterizer3D.anInt543;
               if (int_18 / int_12 > Rasterizer3D.anInt546) {
                  int int_19 = (yCurveCosine * super.modelHeight >> 16) + int_17;
                  int int_20 = (int_16 - int_19) * Rasterizer3D.anInt543;
                  if (int_20 / int_12 < Rasterizer3D.anInt547) {
                     int int_21 = int_11 + (yCurveSine * super.modelHeight >> 16);
                     boolean bool_0 = false;
                     boolean bool_1 = false;
                     if (int_10 - int_21 <= 50) {
                        bool_1 = true;
                     }

                     boolean bool_2 = bool_1 || this.texturedTriangleCount > 0;
                     int cursorX = Class54.anInt138;
                     int cursorY = WorldMapType1.method579();
                     boolean bool_3 = Class21.method211();
                     if (Class37.displayBoundingVolume && hash > 0) {
                        drawCube(this, renderX, renderZ, renderY);
                     }

                     int int_25;
                     int int_26;
                     int int_27;
                     int int_28;
                     int vertexScreenIndex;
                     int int_30;
                     int int_31;
                     if (Class37.aBool15 && hash > 0) {
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

                        vertexScreenIndex = -8355840;
                        int_30 = cursorX - Rasterizer3D.centerX;
                        int_31 = cursorY - Rasterizer3D.centerY;
                        if (int_30 > int_25 && int_30 < int_26 && int_31 > int_27 && int_31 < int_28) {
                           vertexScreenIndex = -256;
                        }

                        Class35.method566(int_25 + Rasterizer3D.centerX, int_27 + Rasterizer3D.centerY, int_26 + Rasterizer3D.centerX, int_28 + Rasterizer3D.centerY, vertexScreenIndex);
                     }

                     boolean bool_4 = false;
                     if (hash > 0 && bool_3) {
                        boolean bool_5 = false;
                        if (aBool74) {
                           bool_5 = Class4.method82(this, renderX, renderZ, renderY);
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

                           int_27 = cursorX - Rasterizer3D.centerX;
                           int_28 = cursorY - Rasterizer3D.centerY;
                           if (int_27 > int_14 && int_27 < int_15 && int_28 > int_20 && int_28 < int_18) {
                              bool_5 = true;
                           }
                        }

                        if (bool_5) {
                           if (this.fitsOnSingleSquare) {
                              Class54.anIntArray34[++Class54.anInt140 - 1] = hash;
                           } else {
                              bool_4 = true;
                           }
                        }
                     }

                     int_25 = Rasterizer3D.centerX;
                     int_26 = Rasterizer3D.centerY;
                     int_27 = 0;
                     int_28 = 0;
                     if (rotation != 0) {
                        int_27 = SINE[rotation];
                        int_28 = COSINE[rotation];
                     }

                     for (vertexScreenIndex = 0; vertexScreenIndex < this.vertexCount; vertexScreenIndex++) {
                        int_30 = this.verticesX[vertexScreenIndex];
                        int_31 = this.verticesY[vertexScreenIndex];
                        int int_32 = this.verticesZ[vertexScreenIndex];
                        int int_33;
                        if (rotation != 0) {
                           int_33 = int_32 * int_27 + int_30 * int_28 >> 16;
                           int_32 = int_32 * int_28 - int_30 * int_27 >> 16;
                           int_30 = int_33;
                        }

                        int_30 += renderX;
                        int_31 += renderZ;
                        int_32 += renderY;
                        int_33 = int_32 * xCurveSine + xCurveCosine * int_30 >> 16;
                        int_32 = xCurveCosine * int_32 - int_30 * xCurveSine >> 16;
                        int_30 = int_33;
                        int_33 = yCurveCosine * int_31 - int_32 * yCurveSine >> 16;
                        int_32 = int_31 * yCurveSine + yCurveCosine * int_32 >> 16;
                        vertexScreenZ[vertexScreenIndex] = int_32 - int_10;
                        if (int_32 >= 50) {
                           vertexScreenX[vertexScreenIndex] = int_30 * Rasterizer3D.anInt543 / int_32 + int_25;
                           vertexScreenY[vertexScreenIndex] = int_33 * Rasterizer3D.anInt543 / int_32 + int_26;
                        } else {
                           vertexScreenX[vertexScreenIndex] = -5000;
                           bool_0 = true;
                        }

                        if (bool_2) {
                           vertexMvX[vertexScreenIndex] = int_30;
                           vertexMvY[vertexScreenIndex] = int_33;
                           vertexMvZ[vertexScreenIndex] = int_32;
                        }
                     }

                     try {
                        this.method1025(bool_0, bool_4, this.fitsOnSingleSquare, hash);
                     } catch (Exception exception_0) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   public void rotate90AntiClockWise() {
      for (int vertex = 0; vertex < this.vertexCount; vertex++) {
         int z = this.verticesZ[vertex];
         this.verticesZ[vertex] = this.verticesX[vertex];
         this.verticesX[vertex] = -z;
      }

      this.reset();
   }

   public void scaleTriangle(int x, int y, int z) {
      for (int vertex = 0; vertex < this.vertexCount; vertex++) {
         this.verticesX[vertex] = this.verticesX[vertex] * x / 128;
         this.verticesY[vertex] = y * this.verticesY[vertex] / 128;
         this.verticesZ[vertex] = z * this.verticesZ[vertex] / 128;
      }

      this.reset();
   }

   public void rotate180Degrees() {
      for (int int_0 = 0; int_0 < this.vertexCount; int_0++) {
         this.verticesX[int_0] = -this.verticesX[int_0];
         this.verticesZ[int_0] = -this.verticesZ[int_0];
      }

      this.reset();
   }

   public void rotate90Degrees() {
      for (int vertex = 0; vertex < this.vertexCount; vertex++) {
         int x = this.verticesX[vertex];
         this.verticesX[vertex] = this.verticesZ[vertex];
         this.verticesZ[vertex] = -x;
      }

      this.reset();
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

            this.reset();
         } else {
            this.method1008(frames_0, int_0);
         }
      }
   }

   void rasterize(int triangle) {
      if (triangleRenderRules[triangle]) {
         this.rasterizeTriangle(triangle);
      } else {
         int trianglePointX = this.trianglePointsX[triangle];
         int trianglePointY = this.trianglePointsY[triangle];
         int trianglePointZ = this.trianglePointsZ[triangle];
         Rasterizer3D.restrictEdges = aBoolArray7[triangle];
         if (this.triangleAlphaValues == null) {
            Rasterizer3D.alpha = 0;
         } else {
            Rasterizer3D.alpha = this.triangleAlphaValues[triangle] & 0xFF;
         }

         if (this.aShortArray12 != null && this.aShortArray12[triangle] != -1) {
            int texturePointX;
            int texturePointY;
            int texturePointZ;
            if (this.texturePoints != null && this.texturePoints[triangle] != -1) {
               int texturePoint = this.texturePoints[triangle] & 0xFF;
               texturePointX = this.texturedTrianglePointsX[texturePoint];
               texturePointY = this.texturedTrianglePointsY[texturePoint];
               texturePointZ = this.texturedTrianglePointsZ[texturePoint];
            } else {
               texturePointX = trianglePointX;
               texturePointY = trianglePointY;
               texturePointZ = trianglePointZ;
            }

            if (this.anIntArray132[triangle] == -1) {
               Rasterizer3D.drawTexturedTriangle(vertexScreenY[trianglePointX], vertexScreenY[trianglePointY], vertexScreenY[trianglePointZ], vertexScreenX[trianglePointX], vertexScreenX[trianglePointY], vertexScreenX[trianglePointZ], this.triangleHSLA[triangle], this.triangleHSLA[triangle], this.triangleHSLA[triangle], vertexMvX[texturePointX], vertexMvX[texturePointY], vertexMvX[texturePointZ], vertexMvY[texturePointX], vertexMvY[texturePointY], vertexMvY[texturePointZ], vertexMvZ[texturePointX], vertexMvZ[texturePointY], vertexMvZ[texturePointZ], this.aShortArray12[triangle]);
            } else {
               Rasterizer3D.drawTexturedTriangle(vertexScreenY[trianglePointX], vertexScreenY[trianglePointY], vertexScreenY[trianglePointZ], vertexScreenX[trianglePointX], vertexScreenX[trianglePointY], vertexScreenX[trianglePointZ], this.triangleHSLA[triangle], this.anIntArray133[triangle], this.anIntArray132[triangle], vertexMvX[texturePointX], vertexMvX[texturePointY], vertexMvX[texturePointZ], vertexMvY[texturePointX], vertexMvY[texturePointY], vertexMvY[texturePointZ], vertexMvZ[texturePointX], vertexMvZ[texturePointY], vertexMvZ[texturePointZ], this.aShortArray12[triangle]);
            }
         } else if (this.anIntArray132[triangle] == -1) {
            Rasterizer3D.drawFlatTriangle(vertexScreenY[trianglePointX], vertexScreenY[trianglePointY], vertexScreenY[trianglePointZ], vertexScreenX[trianglePointX], vertexScreenX[trianglePointY], vertexScreenX[trianglePointZ], anIntArray128[this.triangleHSLA[triangle]]);
         } else {
            Rasterizer3D.drawShadedTriangle(vertexScreenY[trianglePointX], vertexScreenY[trianglePointY], vertexScreenY[trianglePointZ], vertexScreenX[trianglePointX], vertexScreenX[trianglePointY], vertexScreenX[trianglePointZ], this.triangleHSLA[triangle], this.anIntArray133[triangle], this.anIntArray132[triangle]);
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
            if (this.anIntArrayArray18 != null && this.triangleAlphaValues != null) {
               for (int_5 = 0; int_5 < int_4; int_5++) {
                  int_6 = ints_0[int_5];
                  if (int_6 < this.anIntArrayArray18.length) {
                     ints_2 = this.anIntArrayArray18[int_6];

                     for (int_10 = 0; int_10 < ints_2.length; int_10++) {
                        int_8 = ints_2[int_10];
                        int_9 = (this.triangleAlphaValues[int_8] & 0xFF) + int_1 * 8;
                        if (int_9 < 0) {
                           int_9 = 0;
                        } else if (int_9 > 255) {
                           int_9 = 255;
                        }

                        this.triangleAlphaValues[int_8] = (byte)int_9;
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
               int_3 = this.trianglePointsX[int_2];
               int_4 = this.trianglePointsY[int_2];
               int_5 = this.trianglePointsZ[int_2];
               int_6 = vertexScreenX[int_3];
               int_7 = vertexScreenX[int_4];
               int_8 = vertexScreenX[int_5];
               int int_9;
               if (!bool_0 || int_6 != -5000 && int_7 != -5000 && int_8 != -5000) {
                  if (bool_1 && WorldMapData_Sub1.method603(vertexScreenY[int_3], vertexScreenY[int_4], vertexScreenY[int_5], int_6, int_7, int_8, int_1)) {
                     Class54.anIntArray34[++Class54.anInt140 - 1] = int_0;
                     bool_1 = false;
                  }

                  if ((int_6 - int_7) * (vertexScreenY[int_5] - vertexScreenY[int_4]) - (int_8 - int_7) * (vertexScreenY[int_3] - vertexScreenY[int_4]) > 0) {
                     triangleRenderRules[int_2] = false;
                     if (int_6 >= 0 && int_7 >= 0 && int_8 >= 0 && int_6 <= Rasterizer3D.rasterClipX && int_7 <= Rasterizer3D.rasterClipX && int_8 <= Rasterizer3D.rasterClipX) {
                        aBoolArray7[int_2] = false;
                     } else {
                        aBoolArray7[int_2] = true;
                     }

                     int_9 = (vertexScreenZ[int_3] + vertexScreenZ[int_4] + vertexScreenZ[int_5]) / 3 + this.shadowIntensity3D;
                     anIntArrayArray15[int_9][anIntArray115[int_9]++] = int_2;
                  }
               } else {
                  int_9 = vertexMvX[int_3];
                  int_10 = vertexMvX[int_4];
                  int_11 = vertexMvX[int_5];
                  int int_12 = vertexMvY[int_3];
                  int_13 = vertexMvY[int_4];
                  int int_14 = vertexMvY[int_5];
                  int int_15 = vertexMvZ[int_3];
                  int int_16 = vertexMvZ[int_4];
                  int int_17 = vertexMvZ[int_5];
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
                     triangleRenderRules[int_2] = true;
                     int int_21 = (vertexScreenZ[int_3] + vertexScreenZ[int_4] + vertexScreenZ[int_5]) / 3 + this.shadowIntensity3D;
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
                     this.rasterize(ints_0[int_5]);
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
                  this.rasterize(ints_1[int_6++]);
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
                  this.rasterize(ints_1[int_6++]);
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
                  this.rasterize(ints_1[int_6++]);
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
                  this.rasterize(ints_3[int_13]);
               }
            }

            while (int_5 != -1000) {
               this.rasterize(ints_1[int_6++]);
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

   public void translate(int int_0, int int_1, int int_2) {
      for (int int_3 = 0; int_3 < this.vertexCount; int_3++) {
         this.verticesX[int_3] += int_0;
         this.verticesY[int_3] += int_1;
         this.verticesZ[int_3] += int_2;
      }

      this.reset();
   }

   public void method1027(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6) {
      anIntArray115[0] = -1;
      if (this.anInt556 != 2 && this.anInt556 != 1) {
         this.method1014();
      }

      int int_7 = Rasterizer3D.centerX;
      int int_8 = Rasterizer3D.centerY;
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
         vertexScreenZ[int_18] = int_21 - int_17;
         vertexScreenX[int_18] = int_19 * Rasterizer3D.anInt543 / int_21 + int_7;
         vertexScreenY[int_18] = int_22 * Rasterizer3D.anInt543 / int_21 + int_8;
         if (this.texturedTriangleCount > 0) {
            vertexMvX[int_18] = int_19;
            vertexMvY[int_18] = int_22;
            vertexMvZ[int_18] = int_21;
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

      int int_8 = Rasterizer3D.centerX;
      int int_9 = Rasterizer3D.centerY;
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
         vertexScreenZ[int_19] = int_22 - int_18;
         vertexScreenX[int_19] = int_8 + int_20 * Rasterizer3D.anInt543 / int_7;
         vertexScreenY[int_19] = int_9 + int_23 * Rasterizer3D.anInt543 / int_7;
         if (this.texturedTriangleCount > 0) {
            vertexMvX[int_19] = int_20;
            vertexMvY[int_19] = int_23;
            vertexMvZ[int_19] = int_22;
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
