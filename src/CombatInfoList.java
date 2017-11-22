import java.util.Iterator;

public class CombatInfoList implements Iterable {

   Node aNode5;
   Node node;

   public CombatInfoList() {
      this.node = new Node();
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   Node method451(Node node_0) {
      Node node_1;
      if (node_0 == null) {
         node_1 = this.node.next;
      } else {
         node_1 = node_0;
      }

      if (node_1 == this.node) {
         this.aNode5 = null;
         return null;
      } else {
         this.aNode5 = node_1.next;
         return node_1;
      }
   }

   public boolean method452() {
      return this.node.next == this.node;
   }

   public void method453() {
      while (this.node.next != this.node) {
         this.node.next.unlink();
      }

   }

   public Node method454() {
      return this.method451((Node) null);
   }

   public void method455(Node node_0) {
      if (node_0.previous != null) {
         node_0.unlink();
      }

      node_0.previous = this.node.previous;
      node_0.next = this.node;
      node_0.previous.next = node_0;
      node_0.next.previous = node_0;
   }

   public Node method456() {
      Node node_0 = this.aNode5;
      if (node_0 == this.node) {
         this.aNode5 = null;
         return null;
      } else {
         this.aNode5 = node_0.next;
         return node_0;
      }
   }

   public void method457(Node node_0) {
      if (node_0.previous != null) {
         node_0.unlink();
      }

      node_0.previous = this.node;
      node_0.next = this.node.next;
      node_0.previous.next = node_0;
      node_0.next.previous = node_0;
   }

   public Node method458() {
      Node node_0 = this.node.next;
      if (node_0 == this.node) {
         return null;
      } else {
         node_0.unlink();
         return node_0;
      }
   }

   public Iterator iterator() {
      return new Class69(this);
   }

   public static void method459(Node node_0, Node node_1) {
      if (node_0.previous != null) {
         node_0.unlink();
      }

      node_0.previous = node_1;
      node_0.next = node_1.next;
      node_0.previous.next = node_0;
      node_0.next.previous = node_0;
   }

}
