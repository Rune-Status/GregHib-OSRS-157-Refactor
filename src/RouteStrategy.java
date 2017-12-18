public abstract class RouteStrategy {

   public int approxDestinationX;
   public int approxDestinationY;
   public int approxDestinationSizeX;
   public int approxDestinationSizeY;

   protected abstract boolean canExit(int sizeXY, int currentX, int currentY, CollisionMap data);

   static void method394(int int_0) {
      if (int_0 >= 0) {
         int int_1 = Client.menuActionParams0[int_0];
         int int_2 = Client.menuActionParams1[int_0];
         int int_3 = Client.menuTypes[int_0];
         int int_4 = Client.menuIdentifiers[int_0];
         String string_0 = Client.menuOptions[int_0];
         String string_1 = Client.menuTargets[int_0];
         Ignore.menuAction(int_1, int_2, int_3, int_4, string_0, string_1, MouseInput.anInt264, MouseInput.anInt265);
      }
   }

}
