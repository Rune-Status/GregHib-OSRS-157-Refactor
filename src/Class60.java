public class Class60 implements Interface3 {

   public static final Class60 aClass60_1;
   static final Class60 aClass60_2;
   public static final Class60 aClass60_3;
   public static final Class60 aClass60_4;
   static final Class60[] aClass60Array1;
   public final int anInt157;

   static {
      aClass60_1 = new Class60(14, 0);
      aClass60_2 = new Class60(15, 4);
      aClass60_3 = new Class60(16, -2);
      aClass60_4 = new Class60(18, -2);
      aClass60Array1 = new Class60[32];
      Class60[] class60s_0 = new Class60[] {aClass60_1, aClass60_4, aClass60_3, aClass60_2};
      Class60[] class60s_1 = class60s_0;

      for (int int_0 = 0; int_0 < class60s_1.length; int_0++) {
         aClass60Array1[class60s_1[int_0].anInt157] = class60s_1[int_0];
      }

   }

   Class60(int int_0, int int_1) {
      this.anInt157 = int_0;
   }

   static boolean method391(Widget widget_0) {
      if (widget_0.tableActions == null) {
         return false;
      } else {
         for (int int_0 = 0; int_0 < widget_0.tableActions.length; int_0++) {
            int int_1 = Class49.method315(widget_0, int_0);
            int int_2 = widget_0.anIntArray65[int_0];
            if (widget_0.tableActions[int_0] == 2) {
               if (int_1 >= int_2) {
                  return false;
               }
            } else if (widget_0.tableActions[int_0] == 3) {
               if (int_1 <= int_2) {
                  return false;
               }
            } else if (widget_0.tableActions[int_0] == 4) {
               if (int_2 == int_1) {
                  return false;
               }
            } else if (int_1 != int_2) {
               return false;
            }
         }

         return true;
      }
   }

}
