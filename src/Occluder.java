public final class Occluder {

   int testDirection;
   int minX;
   int minZ;
   int type;
   int minNormalX;
   int minTileX;
   int maxZ;
   int maxNormalX;
   int minTileZ;
   int anInt158;
   int minY;
   int maxX;
   int minNormalY;
   int anInt159;
   int maxY;
   int maxNormalY;
   int maxTileZ;
   int maxTIleX;

   static int method392(IterableHashTable iterablehashtable_0, int int_0, int int_1) {
      if (iterablehashtable_0 == null) {
         return int_1;
      } else {
         IntegerNode integernode_0 = (IntegerNode) iterablehashtable_0.get((long)int_0);
         return integernode_0 == null ? int_1 : integernode_0.value;
      }
   }

}
