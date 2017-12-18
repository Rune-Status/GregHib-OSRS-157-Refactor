public final class Tile extends Node {

   public static int canvasWidth;
   static IndexData soundEffectsIndex;
   InteractiveObject[] objects;
   int[] entityFlags;
   ComplexTile paint;
   ItemLayer itemLayer;
   WallDecoration wallDecoration;
   Wall wall;
   int objectCount;
   FloorDecoration floorDecoration;
   int flags;
   SceneTileModel overlay;
   boolean visible;
   int plane;
   int physicalLevel;
   int x;
   int y;
   int renderLevel;
   Tile bridge;
   boolean draw;
   int wallCullDirection;
   boolean drawEntities;
   int wallUncullDirection;
   int wallDrawFlags;
   int wallCullOppositeDirection;

   Tile(int z, int x, int y) {
      this.objects = new InteractiveObject[5];
      this.entityFlags = new int[5];
      this.flags = 0;
      this.renderLevel = this.plane = z;
      this.x = x;
      this.y = y;
   }

   public static Enum7[] method681() {
      return new Enum7[] {Enum7.anEnum7_5, Enum7.anEnum7_3, Enum7.anEnum7_2, Enum7.anEnum7_4, Enum7.anEnum7_1, Enum7.anEnum7_8, Enum7.anEnum7_6, Enum7.anEnum7_7};
   }

   static IterableHashTable decodeParameters(Buffer buffer, IterableHashTable parameters) {
      int length = buffer.getUnsignedByte();
      int index;
      if (parameters == null) {
         index = Class58.method389(length);
         parameters = new IterableHashTable(index);
      }

      for (index = 0; index < length; index++) {
         boolean bool = buffer.getUnsignedByte() == 1;
         int id = buffer.read24BitInt();
         Object object;
         if (bool) {
            object = new ObjectNode(buffer.readString());
         } else {
            object = new IntegerNode(buffer.readInt());
         }

         parameters.put((Node) object, (long)id);
      }

      return parameters;
   }

   static void method683(Widget widget_0, int int_0, int int_1) {
      if (Client.aWidget9 == null && !Client.isMenuOpen) {
         if (widget_0 != null) {
            Widget widget_1 = widget_0;
            int int_2 = Preferences.getWidgetConfig(widget_0);
            int int_3 = int_2 >> 17 & 0x7;
            int int_4 = int_3;
            Widget widget_2;
            int int_6;
            if (int_3 == 0) {
               widget_2 = null;
            } else {
               int_6 = 0;

               while (true) {
                  if (int_6 >= int_4) {
                     widget_2 = widget_1;
                     break;
                  }

                  widget_1 = Client.getWidget(widget_1.parentId);
                  if (widget_1 == null) {
                     widget_2 = null;
                     break;
                  }

                  ++int_6;
               }
            }

            Widget widget_3 = widget_2;
            if (widget_2 == null) {
               widget_3 = widget_0.dragParent;
            }

            if (widget_3 != null) {
               Client.aWidget9 = widget_0;
               widget_1 = widget_0;
               int_2 = Preferences.getWidgetConfig(widget_0);
               int_3 = int_2 >> 17 & 0x7;
               int_4 = int_3;
               if (int_3 == 0) {
                  widget_2 = null;
               } else {
                  int_6 = 0;

                  while (true) {
                     if (int_6 >= int_4) {
                        widget_2 = widget_1;
                        break;
                     }

                     widget_1 = Client.getWidget(widget_1.parentId);
                     if (widget_1 == null) {
                        widget_2 = null;
                        break;
                     }

                     ++int_6;
                  }
               }

               widget_3 = widget_2;
               if (widget_2 == null) {
                  widget_3 = widget_0.dragParent;
               }

               Client.aWidget10 = widget_3;
               Client.anInt619 = int_0;
               Client.anInt620 = int_1;
               ScriptVarType.anInt175 = 0;
               Client.aBool93 = false;
               int int_5 = Client.menuOptionCount - 1;
               if (int_5 != -1) {
                  Class21.method212(int_5);
               }

               return;
            }
         }

      }
   }

   static boolean isIgnored(String name) {
      if (name == null) {
         return false;
      } else {
         String username = PacketBuffer.method908(name, Class24.aClass109_1);

         for (int int_0 = 0; int_0 < Client.ignoreCount; int_0++) {
            Ignore ignore = Client.ignores[int_0];
            if (username.equalsIgnoreCase(PacketBuffer.method908(ignore.name, Class24.aClass109_1))) {
               return true;
            }

            if (username.equalsIgnoreCase(PacketBuffer.method908(ignore.previousName, Class24.aClass109_1))) {
               return true;
            }
         }

         return false;
      }
   }

}
