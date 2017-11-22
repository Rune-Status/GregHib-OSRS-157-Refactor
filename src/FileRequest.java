public class FileRequest extends CacheableNode {

   byte padding;
   IndexData index;
   int crc;

   static int method815() {
      if (Buffer.preferences.hideRoofs) {
         return Ignore.plane;
      } else {
         int int_0 = Class18.getTileHeight(Class2.cameraX, Player.cameraY, Ignore.plane);
         return int_0 - Class18.cameraZ < 800 && (Class19.tileSettings[Ignore.plane][Class2.cameraX >> 7][Player.cameraY >> 7] & 0x4) != 0 ? Ignore.plane : 3;
      }
   }

}
