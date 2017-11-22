public class Class106 {

   static final Class106 aClass106_1;
   static byte[][][] aByteArrayArrayArray9;
   public static final Class106 aClass106_2;
   static final Class106 aClass106_3;
   public static char aChar1;
   static Widget aWidget4;
   public final int anInt207;

   static {
      aClass106_1 = new Class106(0);
      aClass106_2 = new Class106(1);
      aClass106_3 = new Class106(2);
   }

   Class106(int int_0) {
      this.anInt207 = int_0;
   }

   public static Spotanim getSpotAnimType(int int_0) {
      Spotanim spotanim_0 = (Spotanim) Spotanim.spotanims.get((long)int_0);
      if (spotanim_0 != null) {
         return spotanim_0;
      } else {
         byte[] bytes_0 = Class42.anIndexDataBase2.getConfigData(13, int_0);
         spotanim_0 = new Spotanim();
         spotanim_0.id = int_0;
         if (bytes_0 != null) {
            spotanim_0.decode(new Buffer(bytes_0));
         }

         Spotanim.spotanims.put(spotanim_0, (long)int_0);
         return spotanim_0;
      }
   }

}
