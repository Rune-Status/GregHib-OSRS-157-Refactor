import java.io.File;

public class Class50 {

   static Font aFont3;
   public static File aFile1;
   static int anInt112;

   static void method317(GameEngine gameengine_0) {
      if (MouseInput.anInt259 == 1 || !Item.aBool73 && MouseInput.anInt259 == 4) {
         int int_0 = Class25.anInt76 + 280;
         if (MouseInput.anInt264 >= int_0 && MouseInput.anInt264 <= int_0 + 14 && MouseInput.anInt265 >= 4 && MouseInput.anInt265 <= 18) {
            Class1.method74(0, 0);
            return;
         }

         if (MouseInput.anInt264 >= int_0 + 15 && MouseInput.anInt264 <= int_0 + 80 && MouseInput.anInt265 >= 4 && MouseInput.anInt265 <= 18) {
            Class1.method74(0, 1);
            return;
         }

         int int_1 = Class25.anInt76 + 390;
         if (MouseInput.anInt264 >= int_1 && MouseInput.anInt264 <= int_1 + 14 && MouseInput.anInt265 >= 4 && MouseInput.anInt265 <= 18) {
            Class1.method74(1, 0);
            return;
         }

         if (MouseInput.anInt264 >= int_1 + 15 && MouseInput.anInt264 <= int_1 + 80 && MouseInput.anInt265 >= 4 && MouseInput.anInt265 <= 18) {
            Class1.method74(1, 1);
            return;
         }

         int int_2 = Class25.anInt76 + 500;
         if (MouseInput.anInt264 >= int_2 && MouseInput.anInt264 <= int_2 + 14 && MouseInput.anInt265 >= 4 && MouseInput.anInt265 <= 18) {
            Class1.method74(2, 0);
            return;
         }

         if (MouseInput.anInt264 >= int_2 + 15 && MouseInput.anInt264 <= int_2 + 80 && MouseInput.anInt265 >= 4 && MouseInput.anInt265 <= 18) {
            Class1.method74(2, 1);
            return;
         }

         int int_3 = Class25.anInt76 + 610;
         if (MouseInput.anInt264 >= int_3 && MouseInput.anInt264 <= int_3 + 14 && MouseInput.anInt265 >= 4 && MouseInput.anInt265 <= 18) {
            Class1.method74(3, 0);
            return;
         }

         if (MouseInput.anInt264 >= int_3 + 15 && MouseInput.anInt264 <= int_3 + 80 && MouseInput.anInt265 >= 4 && MouseInput.anInt265 <= 18) {
            Class1.method74(3, 1);
            return;
         }

         if (MouseInput.anInt264 >= Class25.anInt76 + 708 && MouseInput.anInt265 >= 4 && MouseInput.anInt264 <= Class25.anInt76 + 708 + 50 && MouseInput.anInt265 <= 20) {
            Class25.worldSelectShown = false;
            Class25.aSpritePixels4.drawImage(Class25.anInt76, 0);
            Class25.aSpritePixels5.drawImage(Class25.anInt76 + 382, 0);
            Class25.logoSprite.drawSprite(Class25.anInt76 + 382 - Class25.logoSprite.originalWidth / 2, 18);
            return;
         }

         if (Class25.anInt84 != -1) {
            World world_0 = Coordinates.worldList[Class25.anInt84];
            Class20.method207(world_0);
            Class25.worldSelectShown = false;
            Class25.aSpritePixels4.drawImage(Class25.anInt76, 0);
            Class25.aSpritePixels5.drawImage(Class25.anInt76 + 382, 0);
            Class25.logoSprite.drawSprite(Class25.anInt76 + 382 - Class25.logoSprite.originalWidth / 2, 18);
            return;
         }
      }

   }

   static void method318(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      int int_6 = int_2 - int_0;
      int int_7 = int_3 - int_1;
      int int_8 = int_6 >= 0 ? int_6 : -int_6;
      int int_9 = int_7 >= 0 ? int_7 : -int_7;
      int int_10 = int_8;
      if (int_8 < int_9) {
         int_10 = int_9;
      }

      if (int_10 != 0) {
         int int_11 = (int_6 << 16) / int_10;
         int int_12 = (int_7 << 16) / int_10;
         if (int_12 <= int_11) {
            int_11 = -int_11;
         } else {
            int_12 = -int_12;
         }

         int int_13 = int_5 * int_12 >> 17;
         int int_14 = int_5 * int_12 + 1 >> 17;
         int int_15 = int_5 * int_11 >> 17;
         int int_16 = int_5 * int_11 + 1 >> 17;
         int_0 -= Rasterizer2D.topX;
         int_1 -= Rasterizer2D.topY;
         int int_17 = int_0 + int_13;
         int int_18 = int_0 - int_14;
         int int_19 = int_0 + int_6 - int_14;
         int int_20 = int_0 + int_6 + int_13;
         int int_21 = int_15 + int_1;
         int int_22 = int_1 - int_16;
         int int_23 = int_7 + int_1 - int_16;
         int int_24 = int_15 + int_7 + int_1;
         Graphics3D.setRasterClippingEnabled(int_17, int_18, int_19);
         Graphics3D.rasterFlat(int_21, int_22, int_23, int_17, int_18, int_19, int_4);
         Graphics3D.setRasterClippingEnabled(int_17, int_19, int_20);
         Graphics3D.rasterFlat(int_21, int_23, int_24, int_17, int_19, int_20, int_4);
      }
   }

   static void method319(String string_0, boolean bool_0) {
      string_0 = string_0.toLowerCase();
      short[] shorts_0 = new short[16];
      int int_0 = 0;

      for (int int_1 = 0; int_1 < ItemDefinition.anInt503; int_1++) {
         ItemDefinition itemcomposition_0 = ItemDefinition.getDefinition(int_1);
         if ((!bool_0 || itemcomposition_0.unnoted) && itemcomposition_0.noteTemplateIndex == -1 && itemcomposition_0.name.toLowerCase().indexOf(string_0) != -1) {
            if (int_0 >= 250) {
               Class3.anInt22 = -1;
               Class21.aShortArray1 = null;
               return;
            }

            if (int_0 >= shorts_0.length) {
               short[] shorts_1 = new short[shorts_0.length * 2];

               for (int int_3 = 0; int_3 < int_0; int_3++) {
                  shorts_1[int_3] = shorts_0[int_3];
               }

               shorts_0 = shorts_1;
            }

            shorts_0[int_0++] = (short)int_1;
         }
      }

      Class21.aShortArray1 = shorts_0;
      Player.anInt593 = 0;
      Class3.anInt22 = int_0;
      String[] strings_0 = new String[Class3.anInt22];

      for (int int_2 = 0; int_2 < Class3.anInt22; int_2++) {
         strings_0[int_2] = ItemDefinition.getDefinition(shorts_0[int_2]).name;
      }

      Class28.method232(strings_0, Class21.aShortArray1);
   }

}
