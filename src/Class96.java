public class Class96 {

   static void method519(int int_0, Coordinates coordinates_0, boolean bool_0) {
      WorldMapData worldmapdata_0 = BaseVarType.method647().method18(int_0);
      int int_1 = Class4.localPlayer.currentPlane;
      int int_2 = (Class4.localPlayer.x >> 7) + ItemLayer.baseX;
      int int_3 = (Class4.localPlayer.y >> 7) + ItemLayer.baseY;
      Coordinates coordinates_1 = new Coordinates(int_1, int_2, int_3);
      BaseVarType.method647().method64(worldmapdata_0, coordinates_1, coordinates_0, bool_0);
   }

}
