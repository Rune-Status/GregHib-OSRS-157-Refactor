public class TileUtilities {
    public static int getRotatedLandscapeChunkX(int x, int y, int rotation, int sizeX, int sizeY, int face) {
       if ((face & 0x1) == 1) {
          int off = sizeX;
          sizeX = sizeY;
          sizeY = off;
       }

       rotation &= 0x3;
       return rotation == 0 ? x : (rotation == 1 ? y : (rotation == 2 ? 7 - x - (sizeX - 1) : 7 - y - (sizeY - 1)));
    }

    public static int getRotatedLandscapeChunkY(int y, int x, int rotation, int sizeX, int sizeY, int face) {
       if ((face & 0x1) == 1) {
          int off = sizeX;
          sizeX = sizeY;
          sizeY = off;
       }

       rotation &= 0x3;
       return rotation == 0 ? x : (rotation == 1 ? 7 - y - (sizeX - 1) : (rotation == 2 ? 7 - x - (sizeY - 1) : y));
    }
}
