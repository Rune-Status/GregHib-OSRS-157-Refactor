public final class InteractiveObject {

   static int localY;
   int relativeX;
   int offsetX;
   public int hash;
   int objectConfig;
   int relativeY;
   int offsetY;
   int plane;
   int x;
   int y;
   int height;
   public Renderable renderable;
   int orientation;
   int cycle;
   int drawPriority;

   InteractiveObject() {
      this.hash = 0;
      this.objectConfig = 0;
   }

   public static void method564(int[] ints_0, int[] ints_1) {
      if (ints_0 != null && ints_1 != null) {
         BuildType.anIntArray53 = ints_0;
         FaceNormal.anIntArray59 = new int[ints_0.length];
         AbstractByteBuffer.aByteArrayArrayArray8 = new byte[ints_0.length][][];

         for (int int_0 = 0; int_0 < BuildType.anIntArray53.length; int_0++) {
            AbstractByteBuffer.aByteArrayArrayArray8[int_0] = new byte[ints_1[int_0]][];
         }

      } else {
         BuildType.anIntArray53 = null;
         FaceNormal.anIntArray59 = null;
         AbstractByteBuffer.aByteArrayArrayArray8 = null;
      }
   }

   static Script method565(Class90 class90_0, int int_0, int int_1) {
      int int_2 = Class29.method234(int_0, class90_0);
      Script script_0 = Class14.method190(int_2, class90_0);
      if (script_0 != null) {
         return script_0;
      } else {
         int int_3 = class90_0.anInt190 + (int_1 + 40000 << 8);
         script_0 = Class14.method190(int_3, class90_0);
         return script_0 != null ? script_0 : null;
      }
   }

}
