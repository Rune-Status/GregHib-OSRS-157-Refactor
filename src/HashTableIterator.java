import java.util.Iterator;

public class HashTableIterator implements Iterator {

   Node head;
   Node tail;
   IterableHashTable table;
   int index;

   HashTableIterator(IterableHashTable iterablehashtable_0) {
      this.head = null;
      this.table = iterablehashtable_0;
      this.reset();
   }

   void reset() {
      this.tail = this.table.buckets[0].next;
      this.index = 1;
      this.head = null;
   }

   public boolean hasNext() {
      if (this.table.buckets[this.index - 1] != this.tail) {
         return true;
      } else {
         while (this.index < this.table.size) {
            if (this.table.buckets[this.index++].next != this.table.buckets[this.index - 1]) {
               this.tail = this.table.buckets[this.index - 1].next;
               return true;
            }

            this.tail = this.table.buckets[this.index - 1];
         }

         return false;
      }
   }

   public void remove() {
      if (this.head == null) {
         throw new IllegalStateException();
      } else {
         this.head.unlink();
         this.head = null;
      }
   }

   public Object next() {
      Node node_0;
      if (this.table.buckets[this.index - 1] != this.tail) {
         node_0 = this.tail;
         this.tail = node_0.next;
         this.head = node_0;
         return node_0;
      } else {
         do {
            if (this.index >= this.table.size) {
               return null;
            }

            node_0 = this.table.buckets[this.index++].next;
         } while (node_0 == this.table.buckets[this.index - 1]);

         this.tail = node_0.next;
         this.head = node_0;
         return node_0;
      }
   }

}
