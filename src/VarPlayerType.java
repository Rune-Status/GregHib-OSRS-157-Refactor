public class VarPlayerType extends CacheableNode {

   public static NodeCache varplayers;
   public static int anInt507;
   public static int anInt508;
   public int configType;

   static {
      varplayers = new NodeCache(64);
   }

   VarPlayerType() {
      this.configType = 0;
   }

   void decode(Buffer buffer_0, int int_0) {
      if (int_0 == 5) {
         this.configType = buffer_0.getUnsignedShort();
      }

   }

   void decode(Buffer buffer_0) {
      while (true) {
         int int_0 = buffer_0.getUnsignedByte();
         if (int_0 == 0) {
            return;
         }

         this.decode(buffer_0, int_0);
      }
   }

   public static Class106 method945(int int_0) {
      Class106[] class106s_0 = Class46.method284();

      for (int int_1 = 0; int_1 < class106s_0.length; int_1++) {
         Class106 class106_0 = class106s_0[int_1];
         if (int_0 == class106_0.anInt207) {
            return class106_0;
         }
      }

      return null;
   }

}
