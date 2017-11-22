import java.util.Iterator;

public class Class69 implements Iterator {

   Node aNode3;
   Node aNode4;
   CombatInfoList aCombatInfoList3;

   Class69(CombatInfoList combatinfolist_0) {
      this.aNode4 = null;
      this.aCombatInfoList3 = combatinfolist_0;
      this.aNode3 = this.aCombatInfoList3.node.next;
      this.aNode4 = null;
   }

   public Object next() {
      Node node_0 = this.aNode3;
      if (node_0 == this.aCombatInfoList3.node) {
         node_0 = null;
         this.aNode3 = null;
      } else {
         this.aNode3 = node_0.next;
      }

      this.aNode4 = node_0;
      return node_0;
   }

   public boolean hasNext() {
      return this.aCombatInfoList3.node != this.aNode3;
   }

   public void remove() {
      if (this.aNode4 == null) {
         throw new IllegalStateException();
      } else {
         this.aNode4.unlink();
         this.aNode4 = null;
      }
   }

}
