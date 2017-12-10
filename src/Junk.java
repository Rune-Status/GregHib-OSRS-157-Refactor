public class Junk {
    public static Widget method671(int int_0) {
       int int_1 = int_0 >> 16;
       int int_2 = int_0 & 0xFFFF;
       if (Class91.widgets[int_1] == null || Class91.widgets[int_1][int_2] == null) {
          boolean bool_0 = CombatInfoListHolder.loadWidget(int_1);
          if (!bool_0) {
             return null;
          }
       }

       return Class91.widgets[int_1][int_2];
    }
}
