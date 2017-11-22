import java.util.Iterator;

public final class IterableHashTable implements Iterable {

   int size;
   Node[] buckets;
   int index;
   Node tail;
   Node head;

   public IterableHashTable(int int_0) {
      this.index = 0;
      this.size = int_0;
      this.buckets = new Node[int_0];

      for (int int_1 = 0; int_1 < int_0; int_1++) {
         Node node_0 = this.buckets[int_1] = new Node();
         node_0.next = node_0;
         node_0.previous = node_0;
      }

   }

   public Node get(long long_0) {
      Node node_0 = this.buckets[(int)(long_0 & (long)(this.size - 1))];

      for (this.head = node_0.next; node_0 != this.head; this.head = this.head.next) {
         if (this.head.hash == long_0) {
            Node node_1 = this.head;
            this.head = this.head.next;
            return node_1;
         }
      }

      this.head = null;
      return null;
   }

   public Node getTail() {
      Node node_0;
      if (this.index > 0 && this.buckets[this.index - 1] != this.tail) {
         node_0 = this.tail;
         this.tail = node_0.next;
         return node_0;
      } else {
         do {
            if (this.index >= this.size) {
               return null;
            }

            node_0 = this.buckets[this.index++].next;
         } while (node_0 == this.buckets[this.index - 1]);

         this.tail = node_0.next;
         return node_0;
      }
   }

   public void put(Node node_0, long long_0) {
      if (node_0.previous != null) {
         node_0.unlink();
      }

      Node node_1 = this.buckets[(int)(long_0 & (long)(this.size - 1))];
      node_0.previous = node_1.previous;
      node_0.next = node_1;
      node_0.previous.next = node_0;
      node_0.next.previous = node_0;
      node_0.hash = long_0;
   }

   public Node getHead() {
      this.index = 0;
      return this.getTail();
   }

   public void clear() {
      for (int int_0 = 0; int_0 < this.size; int_0++) {
         Node node_0 = this.buckets[int_0];

         while (true) {
            Node node_1 = node_0.next;
            if (node_1 == node_0) {
               break;
            }

            node_1.unlink();
         }
      }

      this.head = null;
      this.tail = null;
   }

   public Iterator iterator() {
      return new HashTableIterator(this);
   }

}
