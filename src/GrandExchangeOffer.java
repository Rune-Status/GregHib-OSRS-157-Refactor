public class GrandExchangeOffer {

   static IndexData configsIndex;
   byte progress;
   public int totalQuantity;
   public int price;
   public int itemId;
   public int quantitySold;
   public int spent;

   public GrandExchangeOffer() {
   }

   public GrandExchangeOffer(Buffer buffer_0, boolean bool_0) {
      this.progress = buffer_0.readByte();
      this.itemId = buffer_0.getUnsignedShort();
      this.price = buffer_0.readInt();
      this.totalQuantity = buffer_0.readInt();
      this.quantitySold = buffer_0.readInt();
      this.spent = buffer_0.readInt();
   }

   void method170(int int_0) {
      this.progress &= 0xFFFFFFF8;
      this.progress = (byte)(this.progress | int_0 & 0x7);
   }

   void method171(int int_0) {
      this.progress &= 0xFFFFFFF7;
      if (int_0 == 1) {
         this.progress = (byte)(this.progress | 0x8);
      }

   }

   public int method172() {
      return (this.progress & 0x8) == 8 ? 1 : 0;
   }

   public int method173() {
      return this.progress & 0x7;
   }

   static int method174(int int_0, Script script_0, boolean bool_0) {
      Widget widget_0 = bool_0 ? Class106.aWidget4 : Friend.aWidget5;
      if (int_0 == 1700) {
         Class39.intStack[++Class23.intStackSize - 1] = widget_0.itemId;
         return 1;
      } else if (int_0 == 1701) {
         if (widget_0.itemId != -1) {
            Class39.intStack[++Class23.intStackSize - 1] = widget_0.itemQuantity;
         } else {
            Class39.intStack[++Class23.intStackSize - 1] = 0;
         }

         return 1;
      } else if (int_0 == 1702) {
         Class39.intStack[++Class23.intStackSize - 1] = widget_0.index;
         return 1;
      } else {
         return 2;
      }
   }

}
