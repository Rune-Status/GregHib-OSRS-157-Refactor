import java.util.Iterator;

public class Class75 implements Iterator {

   CacheableNode aCacheableNode1;
   CacheableNode aCacheableNode2;
   Class77 aClass77_2;

   Class75(Class77 class77_0) {
      this.aCacheableNode2 = null;
      this.aClass77_2 = class77_0;
      this.aCacheableNode1 = this.aClass77_2.aCacheableNode3.previous;
      this.aCacheableNode2 = null;
   }

   public boolean hasNext() {
      return this.aClass77_2.aCacheableNode3 != this.aCacheableNode1;
   }

   public void remove() {
      if (this.aCacheableNode2 == null) {
         throw new IllegalStateException();
      } else {
         this.aCacheableNode2.unlinkDual();
         this.aCacheableNode2 = null;
      }
   }

   public Object next() {
      CacheableNode cacheablenode_0 = this.aCacheableNode1;
      if (cacheablenode_0 == this.aClass77_2.aCacheableNode3) {
         cacheablenode_0 = null;
         this.aCacheableNode1 = null;
      } else {
         this.aCacheableNode1 = cacheablenode_0.previous;
      }

      this.aCacheableNode2 = cacheablenode_0;
      return cacheablenode_0;
   }

}
