public class Class62 {

   static int anInt164;
   static int anInt165;
   static int anInt166;
   static byte[][] aByteArrayArray4;
   static byte[][] aByteArrayArray5;
   static byte[][] aByteArrayArray6;

   static {
      anInt164 = 0;
      anInt165 = 0;
      anInt166 = 0;
      aByteArrayArray4 = new byte[1000][];
      aByteArrayArray5 = new byte[250][];
      aByteArrayArray6 = new byte[50][];
   }

   static synchronized byte[] method395(int int_0, boolean bool_0) {
      byte[] bytes_0;
      if (int_0 != 100) {
         if (int_0 < 100) {
            ;
         }
      } else if (anInt164 > 0) {
         bytes_0 = aByteArrayArray4[--anInt164];
         aByteArrayArray4[anInt164] = null;
         return bytes_0;
      }

      if (int_0 != 5000) {
         if (int_0 < 5000) {
            ;
         }
      } else if (anInt165 > 0) {
         bytes_0 = aByteArrayArray5[--anInt165];
         aByteArrayArray5[anInt165] = null;
         return bytes_0;
      }

      if (int_0 != 30000) {
         if (int_0 < 30000) {
            ;
         }
      } else if (anInt166 > 0) {
         bytes_0 = aByteArrayArray6[--anInt166];
         aByteArrayArray6[anInt166] = null;
         return bytes_0;
      }

      if (AbstractByteBuffer.aByteArrayArrayArray8 != null) {
         for (int int_1 = 0; int_1 < BuildType.anIntArray53.length; int_1++) {
            if (BuildType.anIntArray53[int_1] != int_0) {
               if (int_0 < BuildType.anIntArray53[int_1]) {
                  ;
               }
            } else if (FaceNormal.anIntArray59[int_1] > 0) {
               byte[] bytes_1 = AbstractByteBuffer.aByteArrayArrayArray8[int_1][--FaceNormal.anIntArray59[int_1]];
               AbstractByteBuffer.aByteArrayArrayArray8[int_1][FaceNormal.anIntArray59[int_1]] = null;
               return bytes_1;
            }
         }
      }

      return new byte[int_0];
   }

   static void method396() {
      Client.aClass46_1.method278();
      World.method557();
      Class23.region.reset();

      for (int int_0 = 0; int_0 < 4; int_0++) {
         Client.collisionMaps[int_0].reset();
      }

      System.gc();
      Class7.method102(2);
      Client.anInt643 = -1;
      Client.aBool87 = false;
      CombatInfo2.method820();
      Class110.setGameState(10);
   }

   public static IndexedSprite method397(IndexDataBase indexdatabase_0, int int_0) {
      byte[] bytes_0 = indexdatabase_0.method432(int_0);
      boolean bool_0;
      if (bytes_0 == null) {
         bool_0 = false;
      } else {
         DecorativeObject.decodeSprite(bytes_0);
         bool_0 = true;
      }

      return !bool_0 ? null : Class9.method146();
   }

   public static void method398() {
      CacheableNode_Sub3.aNodeCache12.reset();
   }

}
