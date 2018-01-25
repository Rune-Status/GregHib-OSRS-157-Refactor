final class Class35 implements Interface1 {

   public static IndexDataBase seq_ref;
   static AbstractSoundSystem soundSystem0;
   static SpritePixels compass;

   static void method244(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6) {
      int int_7 = Math.min(int_3, Math.min(int_4, int_5)) - int_6;
      int int_8 = Math.max(int_3, Math.max(int_4, int_5)) + int_6;
      int int_9 = Math.min(int_0, Math.min(int_1, int_2)) - int_6;
      int int_10 = Math.max(int_0, Math.max(int_1, int_2)) + int_6;
      method566(int_7, int_9, int_8, int_10, -49088);
   }

   static void method245(int int_0, int int_1, int int_2) {
      if (int_0 >= 128 && int_1 >= 128 && int_0 <= 13056 && int_1 <= 13056) {
         int int_3 = Class18.getTileHeight(int_0, int_1, Ignore.plane) - int_2;
         int_0 -= Class2.cameraX;
         int_3 -= Class18.cameraZ;
         int_1 -= Player.cameraY;
         int int_4 = Rasterizer3D.SINE[AClass1.cameraPitch];
         int int_5 = Rasterizer3D.COSINE[AClass1.cameraPitch];
         int int_6 = Rasterizer3D.SINE[Enum4.cameraYaw];
         int int_7 = Rasterizer3D.COSINE[Enum4.cameraYaw];
         int int_8 = int_6 * int_1 + int_0 * int_7 >> 16;
         int_1 = int_7 * int_1 - int_0 * int_6 >> 16;
         int_0 = int_8;
         int_8 = int_3 * int_5 - int_4 * int_1 >> 16;
         int_1 = int_5 * int_1 + int_4 * int_3 >> 16;
         if (int_1 >= 50) {
            Client.screenX = int_0 * Client.scale / int_1 + Client.viewportHeight / 2;
            Client.screenY = Client.viewportWidth / 2 + int_8 * Client.scale / int_1;
         } else {
            Client.screenX = -1;
            Client.screenY = -1;
         }

      } else {
         Client.screenX = -1;
         Client.screenY = -1;
      }
   }

    public static void method566(int int_0, int int_1, int int_2, int int_3, int int_4) {
       Class37.aCombatInfoList1.method455(new AClass3_Sub1(int_0, int_1, int_2, int_3, int_4));
    }
}
