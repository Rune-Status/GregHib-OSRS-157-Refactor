public class Class57 {

   public static CacheableNode_Sub4 method387(int int_0) {
      CacheableNode_Sub4 cacheablenode_sub4_0 = (CacheableNode_Sub4) CacheableNode_Sub4.aNodeCache13.get((long)int_0);
      if (cacheablenode_sub4_0 != null) {
         return cacheablenode_sub4_0;
      } else {
         byte[] bytes_0 = CacheableNode_Sub4.anIndexDataBase23.getConfigData(15, int_0);
         cacheablenode_sub4_0 = new CacheableNode_Sub4();
         if (bytes_0 != null) {
            cacheablenode_sub4_0.method882(new Buffer(bytes_0));
         }

         CacheableNode_Sub4.aNodeCache13.put(cacheablenode_sub4_0, (long)int_0);
         return cacheablenode_sub4_0;
      }
   }

   public static void method388(IndexDataBase indexdatabase_0, IndexDataBase indexdatabase_1) {
      Class42.anIndexDataBase2 = indexdatabase_0;
      Spotanim.anIndexDataBase14 = indexdatabase_1;
   }

}
