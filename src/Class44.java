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

   static boolean method271(int int_0, int int_1, AClass2 aclass2_0, CollisionData collisiondata_0) {
      int int_2 = int_0;
      int int_3 = int_1;
      byte byte_0 = 64;
      byte byte_1 = 64;
      int int_4 = int_0 - byte_0;
      int int_5 = int_1 - byte_1;
      Class58.anIntArrayArray10[byte_0][byte_1] = 99;
      Class58.anIntArrayArray11[byte_0][byte_1] = 0;
      byte byte_2 = 0;
      int int_6 = 0;
      Class58.anIntArray37[byte_2] = int_0;
      byte byte_3 = byte_2;
      int int_12 = byte_2 + 1;
      Class58.anIntArray38[byte_3] = int_1;
      int[][] ints_0 = collisiondata_0.flags;

      while (int_6 != int_12) {
         int_2 = Class58.anIntArray37[int_6];
         int_3 = Class58.anIntArray38[int_6];
         int_6 = int_6 + 1 & 0xFFF;
         int int_10 = int_2 - int_4;
         int int_11 = int_3 - int_5;
         int int_7 = int_2 - collisiondata_0.x;
         int int_8 = int_3 - collisiondata_0.y;
         if (aclass2_0.method393(2, int_2, int_3, collisiondata_0)) {
            Class58.anInt155 = int_2;
            Class58.anInt156 = int_3;
            return true;
         }

         int int_9 = Class58.anIntArrayArray11[int_10][int_11] + 1;
         if (int_10 > 0 && Class58.anIntArrayArray10[int_10 - 1][int_11] == 0 && (ints_0[int_7 - 1][int_8] & 0x124010E) == 0 && (ints_0[int_7 - 1][int_8 + 1] & 0x1240138) == 0) {
            Class58.anIntArray37[int_12] = int_2 - 1;
            Class58.anIntArray38[int_12] = int_3;
            int_12 = int_12 + 1 & 0xFFF;
            Class58.anIntArrayArray10[int_10 - 1][int_11] = 2;
            Class58.anIntArrayArray11[int_10 - 1][int_11] = int_9;
         }

         if (int_10 < 126 && Class58.anIntArrayArray10[int_10 + 1][int_11] == 0 && (ints_0[int_7 + 2][int_8] & 0x1240183) == 0 && (ints_0[int_7 + 2][int_8 + 1] & 0x12401E0) == 0) {
            Class58.anIntArray37[int_12] = int_2 + 1;
            Class58.anIntArray38[int_12] = int_3;
            int_12 = int_12 + 1 & 0xFFF;
            Class58.anIntArrayArray10[int_10 + 1][int_11] = 8;
            Class58.anIntArrayArray11[int_10 + 1][int_11] = int_9;
         }

         if (int_11 > 0 && Class58.anIntArrayArray10[int_10][int_11 - 1] == 0 && (ints_0[int_7][int_8 - 1] & 0x124010E) == 0 && (ints_0[int_7 + 1][int_8 - 1] & 0x1240183) == 0) {
            Class58.anIntArray37[int_12] = int_2;
            Class58.anIntArray38[int_12] = int_3 - 1;
            int_12 = int_12 + 1 & 0xFFF;
            Class58.anIntArrayArray10[int_10][int_11 - 1] = 1;
            Class58.anIntArrayArray11[int_10][int_11 - 1] = int_9;
         }

         if (int_11 < 126 && Class58.anIntArrayArray10[int_10][int_11 + 1] == 0 && (ints_0[int_7][int_8 + 2] & 0x1240138) == 0 && (ints_0[int_7 + 1][int_8 + 2] & 0x12401E0) == 0) {
            Class58.anIntArray37[int_12] = int_2;
            Class58.anIntArray38[int_12] = int_3 + 1;
            int_12 = int_12 + 1 & 0xFFF;
            Class58.anIntArrayArray10[int_10][int_11 + 1] = 4;
            Class58.anIntArrayArray11[int_10][int_11 + 1] = int_9;
         }

         if (int_10 > 0 && int_11 > 0 && Class58.anIntArrayArray10[int_10 - 1][int_11 - 1] == 0 && (ints_0[int_7 - 1][int_8] & 0x124013E) == 0 && (ints_0[int_7 - 1][int_8 - 1] & 0x124010E) == 0 && (ints_0[int_7][int_8 - 1] & 0x124018F) == 0) {
            Class58.anIntArray37[int_12] = int_2 - 1;
            Class58.anIntArray38[int_12] = int_3 - 1;
            int_12 = int_12 + 1 & 0xFFF;
            Class58.anIntArrayArray10[int_10 - 1][int_11 - 1] = 3;
            Class58.anIntArrayArray11[int_10 - 1][int_11 - 1] = int_9;
         }

         if (int_10 < 126 && int_11 > 0 && Class58.anIntArrayArray10[int_10 + 1][int_11 - 1] == 0 && (ints_0[int_7 + 1][int_8 - 1] & 0x124018F) == 0 && (ints_0[int_7 + 2][int_8 - 1] & 0x1240183) == 0 && (ints_0[int_7 + 2][int_8] & 0x12401E3) == 0) {
            Class58.anIntArray37[int_12] = int_2 + 1;
            Class58.anIntArray38[int_12] = int_3 - 1;
            int_12 = int_12 + 1 & 0xFFF;
            Class58.anIntArrayArray10[int_10 + 1][int_11 - 1] = 9;
            Class58.anIntArrayArray11[int_10 + 1][int_11 - 1] = int_9;
         }

         if (int_10 > 0 && int_11 < 126 && Class58.anIntArrayArray10[int_10 - 1][int_11 + 1] == 0 && (ints_0[int_7 - 1][int_8 + 1] & 0x124013E) == 0 && (ints_0[int_7 - 1][int_8 + 2] & 0x1240138) == 0 && (ints_0[int_7][int_8 + 2] & 0x12401F8) == 0) {
            Class58.anIntArray37[int_12] = int_2 - 1;
            Class58.anIntArray38[int_12] = int_3 + 1;
            int_12 = int_12 + 1 & 0xFFF;
            Class58.anIntArrayArray10[int_10 - 1][int_11 + 1] = 6;
            Class58.anIntArrayArray11[int_10 - 1][int_11 + 1] = int_9;
         }

         if (int_10 < 126 && int_11 < 126 && Class58.anIntArrayArray10[int_10 + 1][int_11 + 1] == 0 && (ints_0[int_7 + 1][int_8 + 2] & 0x12401F8) == 0 && (ints_0[int_7 + 2][int_8 + 2] & 0x12401E0) == 0 && (ints_0[int_7 + 2][int_8 + 1] & 0x12401E3) == 0) {
            Class58.anIntArray37[int_12] = int_2 + 1;
            Class58.anIntArray38[int_12] = int_3 + 1;
            int_12 = int_12 + 1 & 0xFFF;
            Class58.anIntArrayArray10[int_10 + 1][int_11 + 1] = 12;
            Class58.anIntArrayArray11[int_10 + 1][int_11 + 1] = int_9;
         }
      }

      Class58.anInt155 = int_2;
      Class58.anInt156 = int_3;
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
