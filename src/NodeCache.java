public final class NodeCache {

   int anInt192;
   HashTable table;
   Node2LinkedList list;
   CacheableNode aCacheableNode4;
   int anInt193;

   public NodeCache(int int_0) {
      this.aCacheableNode4 = new CacheableNode();
      this.list = new Node2LinkedList();
      this.anInt193 = int_0;
      this.anInt192 = int_0;

      int int_1;
      for (int_1 = 1; int_1 + int_1 < int_0; int_1 += int_1) {
         ;
      }

      this.table = new HashTable(int_1);
   }

   public CacheableNode get(long long_0) {
      CacheableNode cacheablenode_0 = (CacheableNode) this.table.get(long_0);
      if (cacheablenode_0 != null) {
         this.list.push(cacheablenode_0);
      }

      return cacheablenode_0;
   }

   public void put(CacheableNode cacheablenode_0, long long_0) {
      if (this.anInt192 == 0) {
         CacheableNode cacheablenode_1 = this.list.pop();
         cacheablenode_1.unlink();
         cacheablenode_1.unlinkDual();
         if (cacheablenode_1 == this.aCacheableNode4) {
            cacheablenode_1 = this.list.pop();
            cacheablenode_1.unlink();
            cacheablenode_1.unlinkDual();
         }
      } else {
         --this.anInt192;
      }

      this.table.put(cacheablenode_0, long_0);
      this.list.push(cacheablenode_0);
   }

   public void reset() {
      this.list.clear();
      this.table.method69();
      this.aCacheableNode4 = new CacheableNode();
      this.anInt192 = this.anInt193;
   }

   public void remove(long long_0) {
      CacheableNode cacheablenode_0 = (CacheableNode) this.table.get(long_0);
      if (cacheablenode_0 != null) {
         cacheablenode_0.unlink();
         cacheablenode_0.unlinkDual();
         ++this.anInt192;
      }

   }

}
