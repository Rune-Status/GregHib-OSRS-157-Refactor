import java.util.Iterator;

public class Class77 implements Iterable {

   public CacheableNode aCacheableNode3;

   public Class77() {
      this.aCacheableNode3 = new CacheableNode();
      this.aCacheableNode3.previous = this.aCacheableNode3;
      this.aCacheableNode3.next = this.aCacheableNode3;
   }

   public void method463() {
      while (this.aCacheableNode3.previous != this.aCacheableNode3) {
         this.aCacheableNode3.previous.unlinkDual();
      }

   }

   public void method464(CacheableNode cacheablenode_0) {
      if (cacheablenode_0.next != null) {
         cacheablenode_0.unlinkDual();
      }

      cacheablenode_0.next = this.aCacheableNode3.next;
      cacheablenode_0.previous = this.aCacheableNode3;
      cacheablenode_0.next.previous = cacheablenode_0;
      cacheablenode_0.previous.next = cacheablenode_0;
   }

   public Iterator iterator() {
      return new Class75(this);
   }

}
