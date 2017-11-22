public final class Node2LinkedList {

   CacheableNode sentinel;

   public Node2LinkedList() {
      this.sentinel = new CacheableNode();
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   void clear() {
      while (true) {
         CacheableNode cacheablenode_0 = this.sentinel.previous;
         if (cacheablenode_0 == this.sentinel) {
            return;
         }

         cacheablenode_0.unlinkDual();
      }
   }

   CacheableNode pop() {
      CacheableNode cacheablenode_0 = this.sentinel.previous;
      if (cacheablenode_0 == this.sentinel) {
         return null;
      } else {
         cacheablenode_0.unlinkDual();
         return cacheablenode_0;
      }
   }

   public void push(CacheableNode cacheablenode_0) {
      if (cacheablenode_0.next != null) {
         cacheablenode_0.unlinkDual();
      }

      cacheablenode_0.next = this.sentinel.next;
      cacheablenode_0.previous = this.sentinel;
      cacheablenode_0.next.previous = cacheablenode_0;
      cacheablenode_0.previous.next = cacheablenode_0;
   }

   public void setHead(CacheableNode cacheablenode_0) {
      if (cacheablenode_0.next != null) {
         cacheablenode_0.unlinkDual();
      }

      cacheablenode_0.next = this.sentinel;
      cacheablenode_0.previous = this.sentinel.previous;
      cacheablenode_0.next.previous = cacheablenode_0;
      cacheablenode_0.previous.next = cacheablenode_0;
   }

   public CacheableNode peek() {
      CacheableNode cacheablenode_0 = this.sentinel.previous;
      return cacheablenode_0 == this.sentinel ? null : cacheablenode_0;
   }

}
