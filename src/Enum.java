public class Enum extends CacheableNode {

   public static NodeCache aNodeCache10;
   public static IndexDataBase anIndexDataBase21;
   public String defaultString;
   public char keyType;
   public char valType;
   public int size;
   public int defaultInt;
   public int[] keys;
   public String[] stringVals;
   public int[] intVals;

   static {
      aNodeCache10 = new NodeCache(64);
   }

   public Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   void method831(Buffer buffer_0, int int_0) {
      if (int_0 == 1) {
         this.keyType = (char)buffer_0.getUnsignedByte();
      } else if (int_0 == 2) {
         this.valType = (char)buffer_0.getUnsignedByte();
      } else if (int_0 == 3) {
         this.defaultString = buffer_0.readString();
      } else if (int_0 == 4) {
         this.defaultInt = buffer_0.readInt();
      } else {
         int int_1;
         if (int_0 == 5) {
            this.size = buffer_0.getUnsignedShort();
            this.keys = new int[this.size];
            this.stringVals = new String[this.size];

            for (int_1 = 0; int_1 < this.size; int_1++) {
               this.keys[int_1] = buffer_0.readInt();
               this.stringVals[int_1] = buffer_0.readString();
            }
         } else if (int_0 == 6) {
            this.size = buffer_0.getUnsignedShort();
            this.keys = new int[this.size];
            this.intVals = new int[this.size];

            for (int_1 = 0; int_1 < this.size; int_1++) {
               this.keys[int_1] = buffer_0.readInt();
               this.intVals[int_1] = buffer_0.readInt();
            }
         }
      }

   }

   public void decode(Buffer buffer_0) {
      while (true) {
         int int_0 = buffer_0.getUnsignedByte();
         if (int_0 == 0) {
            return;
         }

         this.method831(buffer_0, int_0);
      }
   }

}
