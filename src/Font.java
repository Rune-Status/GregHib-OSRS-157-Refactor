public final class Font extends FontTypeFace {

   public Font(byte[] bytes_0, int[] horizontalOffsets, int[] verticalOffsets, int[] gylphHeights, int[] glyphWidths, int[] ints_4, byte[][] pixels) {
      super(bytes_0, horizontalOffsets, verticalOffsets, gylphHeights, glyphWidths, ints_4, pixels);
   }

   public Font(byte[] bytes_0) {
      super(bytes_0);
   }

   static void renderRGBA(int[] raster, byte[] bytes_0, int colour, int glyphPosition, int rasterPosition, int width, int height, int rasterOffset, int glyphOffset, int alpha) {
      colour = ((colour & 0xFF00) * alpha & 0xFF0000) + (alpha * (colour & 0xFF00FF) & 0xFF00FF00) >> 8;
      alpha = 256 - alpha;

      for (int y = -height; y < 0; y++) {
         for (int x = -width; x < 0; x++) {
            if (bytes_0[glyphPosition++] != 0) {
               int rgba = raster[rasterPosition];
               raster[rasterPosition++] = (((rgba & 0xFF00) * alpha & 0xFF0000) + ((rgba & 0xFF00FF) * alpha & 0xFF00FF00) >> 8) + colour;
            } else {
               ++rasterPosition;
            }
         }

         rasterPosition += rasterOffset;
         glyphPosition += glyphOffset;
      }

   }

   void renderRGB(byte[] bytes_0, int x, int y, int width, int height, int int_4) {
      int rasterIndex = y * Rasterizer2D.graphicsPixelsWidth + x;
      int rasterClip = Rasterizer2D.graphicsPixelsWidth - width;
      int glyphClip = 0;
      int glyphIndex = 0;
      int temp;
      if (y < Rasterizer2D.topY) {
         temp = Rasterizer2D.topY - y;
         height -= temp;
         y = Rasterizer2D.topY;
         glyphIndex += temp * width;
         rasterIndex += temp * Rasterizer2D.graphicsPixelsWidth;
      }

      if (y + height > Rasterizer2D.bottomY) {
         height -= y + height - Rasterizer2D.bottomY;
      }

      if (x < Rasterizer2D.topX) {
         temp = Rasterizer2D.topX - x;
         width -= temp;
         x = Rasterizer2D.topX;
         glyphIndex += temp;
         rasterIndex += temp;
         glyphClip += temp;
         rasterClip += temp;
      }

      if (x + width > Rasterizer2D.bottomX) {
         temp = x + width - Rasterizer2D.bottomX;
         width -= temp;
         glyphClip += temp;
         rasterClip += temp;
      }

      if (width > 0 && height > 0) {
         FontTypeFace.render(Rasterizer2D.graphicsPixels, bytes_0, int_4, glyphIndex, rasterIndex, width, height, rasterClip, glyphClip);
      }
   }

   void renderRGBA(byte[] glyph, int x, int y, int width, int height, int int_4, int int_5) {
      int rasterIndex = y * Rasterizer2D.graphicsPixelsWidth + x;
      int rasterClip = Rasterizer2D.graphicsPixelsWidth - width;
      int glyphClip = 0;
      int glyphIndex = 0;
      int dy;
      if (y < Rasterizer2D.topY) {
         dy = Rasterizer2D.topY - y;
         height -= dy;
         y = Rasterizer2D.topY;
         glyphIndex += dy * width;
         rasterIndex += dy * Rasterizer2D.graphicsPixelsWidth;
      }

      if (y + height > Rasterizer2D.bottomY) {
         height -= y + height - Rasterizer2D.bottomY;
      }

      if (x < Rasterizer2D.topX) {
         dy = Rasterizer2D.topX - x;
         width -= dy;
         x = Rasterizer2D.topX;
         glyphIndex += dy;
         rasterIndex += dy;
         glyphClip += dy;
         rasterClip += dy;
      }

      if (x + width > Rasterizer2D.bottomX) {
         dy = x + width - Rasterizer2D.bottomX;
         width -= dy;
         glyphClip += dy;
         rasterClip += dy;
      }

      if (width > 0 && height > 0) {
         renderRGBA(Rasterizer2D.graphicsPixels, glyph, int_4, glyphIndex, rasterIndex, width, height, rasterClip, glyphClip, int_5);
      }
   }

}
