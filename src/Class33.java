final class Class33 implements Interface1 {

   public static FloorUnderlayDefinition method240(int int_0) {
      FloorUnderlayDefinition floorunderlaydefinition_0 = (FloorUnderlayDefinition) FloorUnderlayDefinition.underlays.get((long)int_0);
      if (floorunderlaydefinition_0 != null) {
         return floorunderlaydefinition_0;
      } else {
         byte[] bytes_0 = FloorUnderlayDefinition.underlay_ref.getConfigData(1, int_0);
         floorunderlaydefinition_0 = new FloorUnderlayDefinition();
         if (bytes_0 != null) {
            floorunderlaydefinition_0.decode(new Buffer(bytes_0), int_0);
         }

         floorunderlaydefinition_0.post();
         FloorUnderlayDefinition.underlays.put(floorunderlaydefinition_0, (long)int_0);
         return floorunderlaydefinition_0;
      }
   }

   static WidgetNode method241(int int_0, int int_1, int int_2) {
      WidgetNode widgetnode_0 = new WidgetNode();
      widgetnode_0.id = int_1;
      widgetnode_0.owner = int_2;
      Client.widgetNodeTable.put(widgetnode_0, (long)int_0);
      PlayerComposition.method512(int_1);
      Widget widget_0 = Client.getWidget(int_0);
      WorldMapData.method305(widget_0);
      if (Client.aWidget12 != null) {
         WorldMapData.method305(Client.aWidget12);
         Client.aWidget12 = null;
      }

      Class67.method412();
      AClass1_Sub2.method637(Class91.widgets[int_0 >> 16], widget_0, false);
      Class2.method77(int_1);
      if (Client.widgetRoot != -1) {
         int int_3 = Client.widgetRoot;
         if (CombatInfoListHolder.loadWidget(int_3)) {
            Class63.method399(Class91.widgets[int_3], 1);
         }
      }

      return widgetnode_0;
   }

   public static String method242(CharSequence charsequence_0) {
      int int_0 = charsequence_0.length();
      StringBuilder stringbuilder_0 = new StringBuilder(int_0);

      for (int int_1 = 0; int_1 < int_0; int_1++) {
         char char_0 = charsequence_0.charAt(int_1);
         if ((char_0 < 97 || char_0 > 122) && (char_0 < 65 || char_0 > 90) && (char_0 < 48 || char_0 > 57) && char_0 != 46 && char_0 != 45 && char_0 != 42 && char_0 != 95) {
            if (char_0 == 32) {
               stringbuilder_0.append('+');
            } else {
               byte byte_0 = Class99.convertCharacter(char_0);
               stringbuilder_0.append('%');
               int int_2 = byte_0 >> 4 & 0xF;
               if (int_2 >= 10) {
                  stringbuilder_0.append((char)(int_2 + 55));
               } else {
                  stringbuilder_0.append((char)(int_2 + 48));
               }

               int_2 = byte_0 & 0xF;
               if (int_2 >= 10) {
                  stringbuilder_0.append((char)(int_2 + 55));
               } else {
                  stringbuilder_0.append((char)(int_2 + 48));
               }
            }
         } else {
            stringbuilder_0.append(char_0);
         }
      }

      return stringbuilder_0.toString();
   }

}
