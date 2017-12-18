public class Class10 {

   static final Class10 aClass10_1;
   static final Class10 aClass10_2;
   static int anInt48;
   static SpritePixels mapedge;
   static byte[][] localRegionLandscapeData;
   final int anInt49;

   static {
      aClass10_2 = new Class10(0);
      aClass10_1 = new Class10(1);
   }

   Class10(int int_0) {
      this.anInt49 = int_0;
   }

   static void method153(int int_0, byte[] bytes_0, IndexFile indexfile_0) {
      FileSystem filesystem_0 = new FileSystem();
      filesystem_0.anInt341 = 0;
      filesystem_0.hash = (long)int_0;
      filesystem_0.aByteArray12 = bytes_0;
      filesystem_0.index = indexfile_0;
      Deque deque_0 = Class91.aDeque1;
      synchronized(deque_0) {
         Class91.aDeque1.addFront(filesystem_0);
      }

      Object object_0 = Class91.anObject2;
      synchronized(object_0) {
         if (Class91.anInt191 == 0) {
            Class91.aThread2 = new Thread(new Class91());
            Class91.aThread2.setDaemon(true);
            Class91.aThread2.start();
            Class91.aThread2.setPriority(5);
         }

         Class91.anInt191 = 600;
      }
   }

   static int method155(int int_0, Script script_0, boolean bool_0) {
      Widget widget_0;
      if (int_0 >= 2000) {
         int_0 -= 1000;
         widget_0 = Client.getWidget(Class39.intStack[--Class23.intStackSize]);
      } else {
         widget_0 = bool_0 ? Class106.aWidget4 : Friend.aWidget5;
      }

      WorldMapData.method305(widget_0);
      if (int_0 != 1200 && int_0 != 1205 && int_0 != 1212) {
         if (int_0 == 1201) {
            widget_0.disabledMediaType = 2;
            widget_0.disabledMediaId = Class39.intStack[--Class23.intStackSize];
            return 1;
         } else if (int_0 == 1202) {
            widget_0.disabledMediaType = 3;
            widget_0.disabledMediaId = Class4.localPlayer.composition.method507();
            return 1;
         } else {
            return 2;
         }
      } else {
         Class23.intStackSize -= 2;
         int int_1 = Class39.intStack[Class23.intStackSize];
         int int_2 = Class39.intStack[Class23.intStackSize + 1];
         widget_0.itemId = int_1;
         widget_0.itemQuantity = int_2;
         ItemDefinition itemcomposition_0 = ItemDefinition.getDefinition(int_1);
         widget_0.modelRotationX = itemcomposition_0.modelInventoryRotationY;
         widget_0.modelRotationZ = itemcomposition_0.modelInventoryRotationX;
         widget_0.rotationY = itemcomposition_0.diagonalRotation;
         widget_0.anInt293 = itemcomposition_0.spriteTranslateX;
         widget_0.anInt294 = itemcomposition_0.spriteTranslateY;
         widget_0.modelZoom = itemcomposition_0.modelInventoryZoom;
         if (int_0 == 1205) {
            widget_0.anInt296 = 0;
         } else if (int_0 == 1212 | itemcomposition_0.isStackable == 1) {
            widget_0.anInt296 = 1;
         } else {
            widget_0.anInt296 = 2;
         }

         if (widget_0.anInt295 > 0) {
            widget_0.modelZoom = widget_0.modelZoom * 32 / widget_0.anInt295;
         } else if (widget_0.originalWidth > 0) {
            widget_0.modelZoom = widget_0.modelZoom * 32 / widget_0.originalWidth;
         }

         return 1;
      }
   }

   static void method156(Widget widget_0, ItemDefinition itemcomposition_0, int int_0, int int_1, boolean bool_0) {
      String[] strings_0 = itemcomposition_0.inventoryOptions;
      byte byte_0 = -1;
      String string_0 = null;
      if (strings_0 != null && strings_0[int_1] != null) {
         if (int_1 == 0) {
            byte_0 = 33;
         } else if (int_1 == 1) {
            byte_0 = 34;
         } else if (int_1 == 2) {
            byte_0 = 35;
         } else if (int_1 == 3) {
            byte_0 = 36;
         } else {
            byte_0 = 37;
         }

         string_0 = strings_0[int_1];
      } else if (int_1 == 4) {
         byte_0 = 37;
         string_0 = "Drop";
      }

      if (byte_0 != -1 && string_0 != null) {
         Class73.method444(string_0, Wall.getColTags(16748608) + itemcomposition_0.name, byte_0, itemcomposition_0.id, int_0, widget_0.id, bool_0);
      }

   }

}
