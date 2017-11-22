public class BuildType {

   static final BuildType RC;
   static final BuildType WIP;
   static int[] anIntArray53;
   static final BuildType LIVE;
   static final BuildType BUILD_LIVE;
   static Class55 aClass55_1;
   static IndexedSprite[] mapscene;
   public final String identifier;
   final int ordinal;

   static {
      RC = new BuildType("LIVE", 0);
      WIP = new BuildType("BUILDLIVE", 3);
      LIVE = new BuildType("RC", 1);
      BUILD_LIVE = new BuildType("WIP", 2);
   }

   BuildType(String string_0, int int_0) {
      this.identifier = string_0;
      this.ordinal = int_0;
   }

}
