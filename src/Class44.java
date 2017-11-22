import java.util.Comparator;

final class Class44 implements Comparator {

   static long aLong3;

   int method268(Class36 class36_0, Class36 class36_1) {
      return class36_0.aGrandExchangeOffer1.totalQuantity < class36_1.aGrandExchangeOffer1.totalQuantity ? -1 : (class36_1.aGrandExchangeOffer1.totalQuantity == class36_0.aGrandExchangeOffer1.totalQuantity ? 0 : 1);
   }

   public boolean equals(Object object_0) {
      return super.equals(object_0);
   }

   public int compare(Object object_0, Object object_1) {
      return this.method268((Class36) object_0, (Class36) object_1);
   }

   static void method269(Widget widget_0, int int_0, int int_1) {
      if (widget_0.anInt270 == 0) {
         widget_0.relativeX = widget_0.originalX;
      } else if (widget_0.anInt270 == 1) {
         widget_0.relativeX = widget_0.originalX + (int_0 - widget_0.width) / 2;
      } else if (widget_0.anInt270 == 2) {
         widget_0.relativeX = int_0 - widget_0.width - widget_0.originalX;
      } else if (widget_0.anInt270 == 3) {
         widget_0.relativeX = widget_0.originalX * int_0 >> 14;
      } else if (widget_0.anInt270 == 4) {
         widget_0.relativeX = (int_0 - widget_0.width) / 2 + (widget_0.originalX * int_0 >> 14);
      } else {
         widget_0.relativeX = int_0 - widget_0.width - (widget_0.originalX * int_0 >> 14);
      }

      if (widget_0.anInt273 == 0) {
         widget_0.relativeY = widget_0.originalY;
      } else if (widget_0.anInt273 == 1) {
         widget_0.relativeY = (int_1 - widget_0.height) / 2 + widget_0.originalY;
      } else if (widget_0.anInt273 == 2) {
         widget_0.relativeY = int_1 - widget_0.height - widget_0.originalY;
      } else if (widget_0.anInt273 == 3) {
         widget_0.relativeY = int_1 * widget_0.originalY >> 14;
      } else if (widget_0.anInt273 == 4) {
         widget_0.relativeY = (int_1 - widget_0.height) / 2 + (int_1 * widget_0.originalY >> 14);
      } else {
         widget_0.relativeY = int_1 - widget_0.height - (int_1 * widget_0.originalY >> 14);
      }

      if (Client.aBool89 && widget_0.type == 0) {
         if (widget_0.relativeX < 0) {
            widget_0.relativeX = 0;
         } else if (widget_0.width + widget_0.relativeX > int_0) {
            widget_0.relativeX = int_0 - widget_0.width;
         }

         if (widget_0.relativeY < 0) {
            widget_0.relativeY = 0;
         } else if (widget_0.height + widget_0.relativeY > int_1) {
            widget_0.relativeY = int_1 - widget_0.height;
         }
      }

   }

   public static void method270(int int_0, boolean bool_0, int int_1) {
      if (int_0 >= 8000 && int_0 <= 48000) {
         AbstractSoundSystem.sampleRate = int_0;
         AbstractSoundSystem.highMemory = bool_0;
         AbstractSoundSystem.priority = int_1;
      } else {
         throw new IllegalArgumentException();
      }
   }

   static boolean findAlternateRoute(int sourceX, int sourceY, RouteStrategy strategy, CollisionData collision) {
      int currentX = sourceX;
      int currentY = sourceY;
      byte graphSizeX = 64;
      byte graphSizeY = 64;
      int graphBaseX = sourceX - graphSizeX;
      int graphBaseY = sourceY - graphSizeY;
      Class58.directions[graphSizeX][graphSizeY] = 99;
      Class58.distances[graphSizeX][graphSizeY] = 0;
      byte byte_2 = 0;
      int read = 0;
      Class58.tileQueueX[byte_2] = sourceX;
      byte byte_3 = byte_2;
      int write = byte_2 + 1;
      Class58.tileQueueY[byte_3] = sourceY;
      int[][] masks = collision.flags;

      while (read != write) {
         currentX = Class58.tileQueueX[read];
         currentY = Class58.tileQueueY[read];
         read = read + 1 & 0xFFF;
         int currentGraphX = currentX - graphBaseX;
         int currentGraphY = currentY - graphBaseY;
         int maskX = currentX - collision.x;
         int maskY = currentY - collision.y;
         if (strategy.canExit(2, currentX, currentY, collision)) {
            Class58.exitX = currentX;
            Class58.exitY = currentY;
            return true;
         }

         int nextDistance = Class58.distances[currentGraphX][currentGraphY] + 1;
         if (currentGraphX > 0 && Class58.directions[currentGraphX - 1][currentGraphY] == 0 && (masks[maskX - 1][maskY] & 0x124010E) == 0 && (masks[maskX - 1][maskY + 1] & 0x1240138) == 0) {
            Class58.tileQueueX[write] = currentX - 1;
            Class58.tileQueueY[write] = currentY;
            write = write + 1 & 0xFFF;
            Class58.directions[currentGraphX - 1][currentGraphY] = 2;
            Class58.distances[currentGraphX - 1][currentGraphY] = nextDistance;
         }

         if (currentGraphX < 126 && Class58.directions[currentGraphX + 1][currentGraphY] == 0 && (masks[maskX + 2][maskY] & 0x1240183) == 0 && (masks[maskX + 2][maskY + 1] & 0x12401E0) == 0) {
            Class58.tileQueueX[write] = currentX + 1;
            Class58.tileQueueY[write] = currentY;
            write = write + 1 & 0xFFF;
            Class58.directions[currentGraphX + 1][currentGraphY] = 8;
            Class58.distances[currentGraphX + 1][currentGraphY] = nextDistance;
         }

         if (currentGraphY > 0 && Class58.directions[currentGraphX][currentGraphY - 1] == 0 && (masks[maskX][maskY - 1] & 0x124010E) == 0 && (masks[maskX + 1][maskY - 1] & 0x1240183) == 0) {
            Class58.tileQueueX[write] = currentX;
            Class58.tileQueueY[write] = currentY - 1;
            write = write + 1 & 0xFFF;
            Class58.directions[currentGraphX][currentGraphY - 1] = 1;
            Class58.distances[currentGraphX][currentGraphY - 1] = nextDistance;
         }

         if (currentGraphY < 126 && Class58.directions[currentGraphX][currentGraphY + 1] == 0 && (masks[maskX][maskY + 2] & 0x1240138) == 0 && (masks[maskX + 1][maskY + 2] & 0x12401E0) == 0) {
            Class58.tileQueueX[write] = currentX;
            Class58.tileQueueY[write] = currentY + 1;
            write = write + 1 & 0xFFF;
            Class58.directions[currentGraphX][currentGraphY + 1] = 4;
            Class58.distances[currentGraphX][currentGraphY + 1] = nextDistance;
         }

         if (currentGraphX > 0 && currentGraphY > 0 && Class58.directions[currentGraphX - 1][currentGraphY - 1] == 0 && (masks[maskX - 1][maskY] & 0x124013E) == 0 && (masks[maskX - 1][maskY - 1] & 0x124010E) == 0 && (masks[maskX][maskY - 1] & 0x124018F) == 0) {
            Class58.tileQueueX[write] = currentX - 1;
            Class58.tileQueueY[write] = currentY - 1;
            write = write + 1 & 0xFFF;
            Class58.directions[currentGraphX - 1][currentGraphY - 1] = 3;
            Class58.distances[currentGraphX - 1][currentGraphY - 1] = nextDistance;
         }

         if (currentGraphX < 126 && currentGraphY > 0 && Class58.directions[currentGraphX + 1][currentGraphY - 1] == 0 && (masks[maskX + 1][maskY - 1] & 0x124018F) == 0 && (masks[maskX + 2][maskY - 1] & 0x1240183) == 0 && (masks[maskX + 2][maskY] & 0x12401E3) == 0) {
            Class58.tileQueueX[write] = currentX + 1;
            Class58.tileQueueY[write] = currentY - 1;
            write = write + 1 & 0xFFF;
            Class58.directions[currentGraphX + 1][currentGraphY - 1] = 9;
            Class58.distances[currentGraphX + 1][currentGraphY - 1] = nextDistance;
         }

         if (currentGraphX > 0 && currentGraphY < 126 && Class58.directions[currentGraphX - 1][currentGraphY + 1] == 0 && (masks[maskX - 1][maskY + 1] & 0x124013E) == 0 && (masks[maskX - 1][maskY + 2] & 0x1240138) == 0 && (masks[maskX][maskY + 2] & 0x12401F8) == 0) {
            Class58.tileQueueX[write] = currentX - 1;
            Class58.tileQueueY[write] = currentY + 1;
            write = write + 1 & 0xFFF;
            Class58.directions[currentGraphX - 1][currentGraphY + 1] = 6;
            Class58.distances[currentGraphX - 1][currentGraphY + 1] = nextDistance;
         }

         if (currentGraphX < 126 && currentGraphY < 126 && Class58.directions[currentGraphX + 1][currentGraphY + 1] == 0 && (masks[maskX + 1][maskY + 2] & 0x12401F8) == 0 && (masks[maskX + 2][maskY + 2] & 0x12401E0) == 0 && (masks[maskX + 2][maskY + 1] & 0x12401E3) == 0) {
            Class58.tileQueueX[write] = currentX + 1;
            Class58.tileQueueY[write] = currentY + 1;
            write = write + 1 & 0xFFF;
            Class58.directions[currentGraphX + 1][currentGraphY + 1] = 12;
            Class58.distances[currentGraphX + 1][currentGraphY + 1] = nextDistance;
         }
      }

      Class58.exitX = currentX;
      Class58.exitY = currentY;
      return false;
   }

   public static Permission[] method272() {
      return new Permission[] {Permission.aPermission6, Permission.aPermission5, Permission.aPermission2, Permission.aPermission1, Permission.aPermission3, Permission.aPermission4};
   }

   public static void method273() {
      while (true) {
         AClass3 aclass3_0 = (AClass3) Class37.aCombatInfoList1.method458();
         if (aclass3_0 == null) {
            return;
         }

         aclass3_0.method643();
      }
   }

}
