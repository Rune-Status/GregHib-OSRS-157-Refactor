import java.applet.Applet;

public class Class23 {

   public static Applet anApplet1;
   public static String aString3;
   static Buffer aBuffer1;
   static Interface4 anInterface4_1;
   static Region region;
   static IndexedSprite[] anIndexedSpriteArray4;
   static int anInt75;
   static IndexData indexMaps;
   static int intStackSize;

   static {
      anApplet1 = null;
      aString3 = null;
   }

   static void drawDot(int int_0, int int_1, int int_2, int int_3, SpritePixels spritepixels_0, CacheableNode_Sub1 cacheablenode_sub1_0) {
      if (spritepixels_0 != null) {
         int int_4 = Client.mapAngle & 0x7FF;
         int int_5 = int_3 * int_3 + int_2 * int_2;
         if (int_5 <= 6400) {
            int int_6 = Graphics3D.SINE[int_4];
            int int_7 = Graphics3D.COSINE[int_4];
            int int_8 = int_7 * int_2 + int_3 * int_6 >> 16;
            int int_9 = int_3 * int_7 - int_6 * int_2 >> 16;
            if (int_5 > 2500) {
               spritepixels_0.method996(int_8 + cacheablenode_sub1_0.anInt467 / 2 - spritepixels_0.maxWidth / 2, cacheablenode_sub1_0.anInt468 / 2 - int_9 - spritepixels_0.maxHeight / 2, int_0, int_1, cacheablenode_sub1_0.anInt467, cacheablenode_sub1_0.anInt468, cacheablenode_sub1_0.anIntArray86, cacheablenode_sub1_0.anIntArray87);
            } else {
               spritepixels_0.drawAt(int_0 + int_8 + cacheablenode_sub1_0.anInt467 / 2 - spritepixels_0.maxWidth / 2, cacheablenode_sub1_0.anInt468 / 2 + int_1 - int_9 - spritepixels_0.maxHeight / 2);
            }

         }
      }
   }

}
