public class CacheableNode_Sub5 extends CacheableNode {

   public static NodeCache aNodeCache14;
   static int anInt473;
   public static IndexDataBase anIndexDataBase24;
   char aChar2;
   boolean aBool65;
   public int anInt474;
   public String aString30;

   static {
      aNodeCache14 = new NodeCache(64);
   }

   CacheableNode_Sub5() {
      this.aBool65 = true;
   }

   void method883(Buffer buffer_0, int int_0) {
      if (int_0 == 1) {
         byte byte_0 = buffer_0.readByte();
         int int_1 = byte_0 & 0xFF;
         if (int_1 == 0) {
            throw new IllegalArgumentException("");
         }

         if (int_1 >= 128 && int_1 < 160) {
            char char_0 = Class103.aCharArray6[int_1 - 128];
            if (char_0 == 0) {
               char_0 = 63;
            }

            int_1 = char_0;
         }

         char char_1 = (char)int_1;
         this.aChar2 = char_1;
      } else if (int_0 == 2) {
         this.anInt474 = buffer_0.readInt();
      } else if (int_0 == 4) {
         this.aBool65 = false;
      } else if (int_0 == 5) {
         this.aString30 = buffer_0.readString();
      }

   }

   public boolean method884() {
      return this.aChar2 == 115;
   }

   void method885() {
   }

   void method886(Buffer buffer_0) {
      while (true) {
         int int_0 = buffer_0.readUnsignedByte();
         if (int_0 == 0) {
            return;
         }

         this.method883(buffer_0, int_0);
      }
   }

   public static int djb2Hash(CharSequence charsequence_0) {
      int int_0 = charsequence_0.length();
      int int_1 = 0;

      for (int int_2 = 0; int_2 < int_0; int_2++) {
         int_1 = (int_1 << 5) - int_1 + Class99.method524(charsequence_0.charAt(int_2));
      }

      return int_1;
   }

   static boolean method887(Widget widget_0) {
      if (Client.aBool89) {
         if (Preferences.getWidgetConfig(widget_0) != 0) {
            return false;
         }

         if (widget_0.type == 0) {
            return false;
         }
      }

      return widget_0.isHidden;
   }

}
