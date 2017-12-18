public class VarPlayerType extends CacheableNode {

   public static NodeCache varPlayerCache;
   public static int varPlayerCount;
   public int configType;

   static {
      varPlayerCache = new NodeCache(64);
   }

   VarPlayerType() {
      this.configType = 0;
   }

   public static VarPlayerType getVarPlayer(int id) {
      VarPlayerType playerType = (VarPlayerType) varPlayerCache.get((long)id);
      if (playerType != null) {
         return playerType;
      } else {
         byte[] data = Class11.varplayer_ref.getConfigData(16, id);
         playerType = new VarPlayerType();
         if (data != null) {
            playerType.decode(new Buffer(data));
         }

         varPlayerCache.put(playerType, (long)id);
         return playerType;
      }
   }

   void decode(Buffer buffer, int opcode) {
      if (opcode == 5) {
         this.configType = buffer.getUnsignedShort();
      }
   }

   void decode(Buffer buffer) {
      while (true) {
         int opcode = buffer.getUnsignedByte();
         if (opcode == 0) {
            return;
         }

         this.decode(buffer, opcode);
      }
   }

   public static Class106 method945(int size) {
      Class106[] class106s_0 = Class46.method284();

      for (int int_1 = 0; int_1 < class106s_0.length; int_1++) {
         Class106 class106_0 = class106s_0[int_1];
         if (size == class106_0.anInt207) {
            return class106_0;
         }
      }

      return null;
   }

}
