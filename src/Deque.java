public class Deque {

   Node current;
   public Node head;

   public Deque() {
      this.head = new Node();
      this.head.next = this.head;
      this.head.previous = this.head;
   }

   public void addTail(Node node_0) {
      if (node_0.previous != null) {
         node_0.unlink();
      }

      node_0.previous = this.head;
      node_0.next = this.head.next;
      node_0.previous.next = node_0;
      node_0.next.previous = node_0;
   }

   public Node getFront() {
      Node node_0 = this.head.next;
      if (node_0 == this.head) {
         this.current = null;
         return null;
      } else {
         this.current = node_0.next;
         return node_0;
      }
   }

   public Node getNext() {
      Node node_0 = this.current;
      if (node_0 == this.head) {
         this.current = null;
         return null;
      } else {
         this.current = node_0.next;
         return node_0;
      }
   }

   public void addFront(Node node_0) {
      if (node_0.previous != null) {
         node_0.unlink();
      }

      node_0.previous = this.head.previous;
      node_0.next = this.head;
      node_0.previous.next = node_0;
      node_0.next.previous = node_0;
   }

   public Node popFront() {
      Node node_0 = this.head.next;
      if (node_0 == this.head) {
         return null;
      } else {
         node_0.unlink();
         return node_0;
      }
   }

   public Node getTail() {
      Node node_0 = this.head.previous;
      if (node_0 == this.head) {
         this.current = null;
         return null;
      } else {
         this.current = node_0.previous;
         return node_0;
      }
   }

   public Node popTail() {
      Node node_0 = this.head.previous;
      if (node_0 == this.head) {
         return null;
      } else {
         node_0.unlink();
         return node_0;
      }
   }

   public Node getPrevious() {
      Node node_0 = this.current;
      if (node_0 == this.head) {
         this.current = null;
         return null;
      } else {
         this.current = node_0.previous;
         return node_0;
      }
   }

   public void clear() {
      while (true) {
         Node node_0 = this.head.next;
         if (node_0 == this.head) {
            this.current = null;
            return;
         }

         node_0.unlink();
      }
   }

   public static void method549(Node node_0, Node node_1) {
      if (node_0.previous != null) {
         node_0.unlink();
      }

      node_0.previous = node_1.previous;
      node_0.next = node_1;
      node_0.previous.next = node_0;
      node_0.next.previous = node_0;
   }

}
