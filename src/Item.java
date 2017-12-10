public final class Item extends Renderable {

   static boolean aBool73;
   int id;
   int quantity;

   protected Model getRotatedModel() {
      return ItemDefinition.getDefinition(this.id).getModel(this.quantity);
   }

}
