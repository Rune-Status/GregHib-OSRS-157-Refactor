import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;

public final class RSCanvas extends Canvas {

   static int[] anIntArray82;
   static Widget[] aWidgetArray1;
   static IndexData indexWorldMap;
   Component component;

   RSCanvas(Component component_0) {
      this.component = component_0;
   }

   public void paint(Graphics graphics_0) {
      this.component.paint(graphics_0);
   }

   public void update(Graphics graphics_0) {
      this.component.update(graphics_0);
   }

   static int method747() {
      return ++Class34.anInt94 - 1;
   }

   static void method748() {
      if (Ignore.plane != Client.anInt652) {
         Client.anInt652 = Ignore.plane;
         int int_0 = Ignore.plane;
         int[] ints_0 = Class15.aSpritePixels3.pixels;
         int int_1 = ints_0.length;

         int int_2;
         for (int_2 = 0; int_2 < int_1; int_2++) {
            ints_0[int_2] = 0;
         }

         int int_3;
         int int_4;
         for (int_2 = 1; int_2 < 103; int_2++) {
            int_3 = (103 - int_2) * 2048 + 24628;

            for (int_4 = 1; int_4 < 103; int_4++) {
               if ((Class19.tileSettings[int_0][int_4][int_2] & 0x18) == 0) {
                  Class23.region.method362(ints_0, int_3, 512, int_0, int_4, int_2);
               }

               if (int_0 < 3 && (Class19.tileSettings[int_0 + 1][int_4][int_2] & 0x8) != 0) {
                  Class23.region.method362(ints_0, int_3, 512, int_0 + 1, int_4, int_2);
               }

               int_3 += 4;
            }
         }

         int_2 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
         int_3 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
         Class15.aSpritePixels3.method984();

         int int_5;
         for (int_4 = 1; int_4 < 103; int_4++) {
            for (int_5 = 1; int_5 < 103; int_5++) {
               if ((Class19.tileSettings[int_0][int_5][int_4] & 0x18) == 0) {
                  Class15.method195(int_0, int_5, int_4, int_2, int_3);
               }

               if (int_0 < 3 && (Class19.tileSettings[int_0 + 1][int_5][int_4] & 0x8) != 0) {
                  Class15.method195(int_0 + 1, int_5, int_4, int_2, int_3);
               }
            }
         }

         Client.anInt660 = 0;

         for (int_4 = 0; int_4 < 104; int_4++) {
            for (int_5 = 0; int_5 < 104; int_5++) {
               int int_6 = Class23.region.method367(Ignore.plane, int_4, int_5);
               if (int_6 != 0) {
                  int_6 = int_6 >> 14 & 0x7FFF;
                  int int_7 = ObjectDefinition.getDefinition(int_6).mapIconId;
                  if (int_7 >= 0) {
                     Client.mapIcons[Client.anInt660] = Area.anAreaArray1[int_7].method809(false);
                     Client.anIntArray155[Client.anInt660] = int_4;
                     Client.anIntArray156[Client.anInt660] = int_5;
                     ++Client.anInt660;
                  }
               }
            }
         }

         Class68_Sub1.aBufferProvider1.setRaster();
      }

   }

   public static int method749(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      if ((int_5 & 0x1) == 1) {
         int int_6 = int_3;
         int_3 = int_4;
         int_4 = int_6;
      }

      int_2 &= 0x3;
      return int_2 == 0 ? int_1 : (int_2 == 1 ? 7 - int_0 - (int_3 - 1) : (int_2 == 2 ? 7 - int_1 - (int_4 - 1) : int_0));
   }

}
