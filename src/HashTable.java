public final class HashTable {

   int size;
   Node[] buckets;
   int index;
   Node aNode1;
   Node aNode2;

   public HashTable(int int_0) {
      this.index = 0;
      this.size = int_0;
      this.buckets = new Node[int_0];

      for (int int_1 = 0; int_1 < int_0; int_1++) {
         Node node_0 = this.buckets[int_1] = new Node();
         node_0.next = node_0;
         node_0.previous = node_0;
      }

   }

   public Node method67() {
      this.index = 0;
      return this.method68();
   }

   public Node get(long long_0) {
      Node node_0 = this.buckets[(int)(long_0 & (long)(this.size - 1))];

      for (this.aNode2 = node_0.next; node_0 != this.aNode2; this.aNode2 = this.aNode2.next) {
         if (this.aNode2.hash == long_0) {
            Node node_1 = this.aNode2;
            this.aNode2 = this.aNode2.next;
            return node_1;
         }
      }

      this.aNode2 = null;
      return null;
   }

   public Node method68() {
      Node node_0;
      if (this.index > 0 && this.buckets[this.index - 1] != this.aNode1) {
         node_0 = this.aNode1;
         this.aNode1 = node_0.next;
         return node_0;
      } else {
         do {
            if (this.index >= this.size) {
               return null;
            }

            node_0 = this.buckets[this.index++].next;
         } while (node_0 == this.buckets[this.index - 1]);

         this.aNode1 = node_0.next;
         return node_0;
      }
   }

   void method69() {
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

      this.aNode2 = null;
      this.aNode1 = null;
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

}
