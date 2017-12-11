public class Class89 {

   public static Font decodeFont(IndexDataBase primaryIndex, IndexDataBase secondaryIndex, int archive, int file) {
      return !TileStrategy.decodeIfExists(primaryIndex, archive, file) ? null : Class103.method533(secondaryIndex.getConfigData(archive, file));
   }

   static void method497(int int_0, int int_1, int int_2, boolean bool_0, int int_3, boolean bool_1) {
      if (int_0 < int_1) {
         int int_4 = (int_0 + int_1) / 2;
         int int_5 = int_0;
         World world_0 = Coordinates.worldList[int_4];
         Coordinates.worldList[int_4] = Coordinates.worldList[int_1];
         Coordinates.worldList[int_1] = world_0;

         for (int int_6 = int_0; int_6 < int_1; int_6++) {
            World world_1 = Coordinates.worldList[int_6];
            int int_7 = Class36.method252(world_1, world_0, int_2, bool_0);
            int int_8;
            if (int_7 != 0) {
               if (bool_0) {
                  int_8 = -int_7;
               } else {
                  int_8 = int_7;
               }
            } else if (int_3 == -1) {
               int_8 = 0;
            } else {
               int int_9 = Class36.method252(world_1, world_0, int_3, bool_1);
               if (bool_1) {
                  int_8 = -int_9;
               } else {
                  int_8 = int_9;
               }
            }

            if (int_8 <= 0) {
               World world_2 = Coordinates.worldList[int_6];
               Coordinates.worldList[int_6] = Coordinates.worldList[int_5];
               Coordinates.worldList[int_5++] = world_2;
            }
         }

         Coordinates.worldList[int_1] = Coordinates.worldList[int_5];
         Coordinates.worldList[int_5] = world_0;
         method497(int_0, int_5 - 1, int_2, bool_0, int_3, bool_1);
         method497(int_5 + 1, int_1, int_2, bool_0, int_3, bool_1);
      }

   }

}
