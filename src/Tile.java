public final class Tile extends Node {

   public static int canvasWidth;
   static IndexData anIndexData5;
   GameObject[] objects;
   int[] entityFlags;
   SceneTilePaint paint;
   ItemLayer itemLayer;
   DecorativeObject decorativeObject;
   WallObject wallObject;
   int entityCount;
   GroundObject groundObject;
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

   Tile(int int_0, int int_1, int int_2) {
      this.objects = new GameObject[5];
      this.entityFlags = new int[5];
      this.flags = 0;
      this.renderLevel = this.plane = int_0;
      this.x = int_1;
      this.y = int_2;
   }

   public static Enum7[] method681() {
      return new Enum7[] {Enum7.anEnum7_5, Enum7.anEnum7_3, Enum7.anEnum7_2, Enum7.anEnum7_4, Enum7.anEnum7_1, Enum7.anEnum7_8, Enum7.anEnum7_6, Enum7.anEnum7_7};
   }

   static IterableHashTable method682(Buffer buffer_0, IterableHashTable iterablehashtable_0) {
      int int_0 = buffer_0.readUnsignedByte();
      int int_1;
      if (iterablehashtable_0 == null) {
         int_1 = Class58.method389(int_0);
         iterablehashtable_0 = new IterableHashTable(int_1);
      }

      for (int_1 = 0; int_1 < int_0; int_1++) {
         boolean bool_0 = buffer_0.readUnsignedByte() == 1;
         int int_2 = buffer_0.read24BitInt();
         Object object_0;
         if (bool_0) {
            object_0 = new ObjectNode(buffer_0.readString());
         } else {
            object_0 = new IntegerNode(buffer_0.readInt());
         }

         iterablehashtable_0.put((Node) object_0, (long)int_2);
      }

      return iterablehashtable_0;
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

                  widget_1 = PendingSpawn.method671(widget_1.parentId);
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

                     widget_1 = PendingSpawn.method671(widget_1.parentId);
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
