public class CacheableNode_Sub2 extends CacheableNode {

   static NodeCache aNodeCache11;
   public boolean aBool63;

   static {
      aNodeCache11 = new NodeCache(64);
   }

   CacheableNode_Sub2() {
      this.aBool63 = false;
   }

   void method869(Buffer buffer_0, int int_0) {
      if (int_0 == 2) {
         this.aBool63 = true;
      }

   }

   void method870(Buffer buffer_0) {
      while (true) {
         int int_0 = buffer_0.readUnsignedByte();
         if (int_0 == 0) {
            return;
         }

         this.method869(buffer_0, int_0);
      }
   }

   public static ItemComposition getItemDefinition(int int_0) {
      ItemComposition itemcomposition_0 = (ItemComposition) ItemComposition.items.get((long)int_0);
      if (itemcomposition_0 != null) {
         return itemcomposition_0;
      } else {
         byte[] bytes_0 = ItemComposition.item_ref.getConfigData(10, int_0);
         itemcomposition_0 = new ItemComposition();
         itemcomposition_0.id = int_0;
         if (bytes_0 != null) {
            itemcomposition_0.loadBuffer(new Buffer(bytes_0));
         }

         itemcomposition_0.post();
         if (itemcomposition_0.notedTemplate != -1) {
            itemcomposition_0.method937(getItemDefinition(itemcomposition_0.notedTemplate), getItemDefinition(itemcomposition_0.note));
         }

         if (itemcomposition_0.notedId != -1) {
            itemcomposition_0.method938(getItemDefinition(itemcomposition_0.notedId), getItemDefinition(itemcomposition_0.unnotedId));
         }

         if (itemcomposition_0.anInt505 != -1) {
            itemcomposition_0.method939(getItemDefinition(itemcomposition_0.anInt505), getItemDefinition(itemcomposition_0.anInt506));
         }

         if (!Enum5.isMembersWorld && itemcomposition_0.isMembers) {
            itemcomposition_0.name = "Members object";
            itemcomposition_0.aBool68 = false;
            itemcomposition_0.groundActions = null;
            itemcomposition_0.inventoryActions = null;
            itemcomposition_0.team = -1;
            itemcomposition_0.anInt504 = 0;
            if (itemcomposition_0.anIterableHashTable5 != null) {
               boolean bool_0 = false;

               for (Node node_0 = itemcomposition_0.anIterableHashTable5.getHead(); node_0 != null; node_0 = itemcomposition_0.anIterableHashTable5.getTail()) {
                  CacheableNode_Sub5 cacheablenode_sub5_0 = PacketBuffer.method907((int)node_0.hash);
                  if (cacheablenode_sub5_0.aBool65) {
                     node_0.unlink();
                  } else {
                     bool_0 = true;
                  }
               }

               if (!bool_0) {
                  itemcomposition_0.anIterableHashTable5 = null;
               }
            }
         }

         ItemComposition.items.put(itemcomposition_0, (long)int_0);
         return itemcomposition_0;
      }
   }

   public static IndexedSprite getSprite(IndexDataBase indexdatabase_0, String string_0, String string_1) {
      int int_0 = indexdatabase_0.getFile(string_0);
      int int_1 = indexdatabase_0.getChild(int_0, string_1);
      IndexedSprite indexedsprite_0;
      if (!TileStrategy.method628(indexdatabase_0, int_0, int_1)) {
         indexedsprite_0 = null;
      } else {
         indexedsprite_0 = Class9.method146();
      }

      return indexedsprite_0;
   }

}
