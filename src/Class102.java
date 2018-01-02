import java.util.HashMap;

public class Class102 {

   IndexDataBase anIndexDataBase7;
   IndexDataBase anIndexDataBase8;
   HashMap aHashMap8;

   public Class102(IndexDataBase indexdatabase_0, IndexDataBase indexdatabase_1) {
      this.anIndexDataBase7 = indexdatabase_0;
      this.anIndexDataBase8 = indexdatabase_1;
      this.aHashMap8 = new HashMap();
   }

   public HashMap method532(Class97[] class97s_0) {
      HashMap hashmap_0 = new HashMap();
      Class97[] class97s_1 = class97s_0;

      for (int int_0 = 0; int_0 < class97s_1.length; int_0++) {
         Class97 class97_0 = class97s_1[int_0];
         if (this.aHashMap8.containsKey(class97_0)) {
            hashmap_0.put(class97_0, this.aHashMap8.get(class97_0));
         } else {
            Font font_0 = Class104.loadFont(this.anIndexDataBase7, this.anIndexDataBase8, class97_0.aString13, "");
            if (font_0 != null) {
               this.aHashMap8.put(class97_0, font_0);
               hashmap_0.put(class97_0, font_0);
            }
         }
      }

      return hashmap_0;
   }

}
