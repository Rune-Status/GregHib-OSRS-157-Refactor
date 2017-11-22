public class Mapping {

   int anInt218;
   int mux;
   int[] submapFloors;
   int[] anIntArray56;

   Mapping() {
      Node_Sub2.getInt(16);
      this.anInt218 = Node_Sub2.getBit() != 0 ? Node_Sub2.getInt(4) + 1 : 1;
      if (Node_Sub2.getBit() != 0) {
         Node_Sub2.getInt(8);
      }

      Node_Sub2.getInt(2);
      if (this.anInt218 > 1) {
         this.mux = Node_Sub2.getInt(4);
      }

      this.submapFloors = new int[this.anInt218];
      this.anIntArray56 = new int[this.anInt218];

      for (int int_0 = 0; int_0 < this.anInt218; int_0++) {
         Node_Sub2.getInt(8);
         this.submapFloors[int_0] = Node_Sub2.getInt(8);
         this.anIntArray56[int_0] = Node_Sub2.getInt(8);
      }

   }

}
