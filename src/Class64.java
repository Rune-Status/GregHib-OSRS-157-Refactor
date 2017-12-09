public class Class64 {

   public static CacheFile aCacheFile1;
   public static CacheFile aCacheFile2;
   public static CacheFile aCacheFile3;
   public static int anInt167;
   public static CacheFile[] aCacheFileArray1;
   public static String[] aStringArray2;

   static {
      aCacheFile1 = null;
      aCacheFile2 = null;
      aCacheFile3 = null;
   }

   static Script method401(byte[] bytes_0) {
      Script script_0 = new Script();
      Buffer buffer_0 = new Buffer(bytes_0);
      buffer_0.position = buffer_0.buffer.length - 2;
      int int_0 = buffer_0.getUnsignedShort();
      int int_1 = buffer_0.buffer.length - 2 - int_0 - 12;
      buffer_0.position = int_1;
      int int_2 = buffer_0.readInt();
      script_0.localIntCount = buffer_0.getUnsignedShort();
      script_0.localStringCount = buffer_0.getUnsignedShort();
      script_0.intStackCount = buffer_0.getUnsignedShort();
      script_0.stringStackCount = buffer_0.getUnsignedShort();
      int int_3 = buffer_0.getUnsignedByte();
      int int_4;
      int int_5;
      if (int_3 > 0) {
         script_0.switches = script_0.method909(int_3);

         for (int_4 = 0; int_4 < int_3; int_4++) {
            int_5 = buffer_0.getUnsignedShort();
            IterableHashTable iterablehashtable_0 = new IterableHashTable(Class58.method389(int_5));
            script_0.switches[int_4] = iterablehashtable_0;

            while (int_5-- > 0) {
               int int_6 = buffer_0.readInt();
               int int_7 = buffer_0.readInt();
               iterablehashtable_0.put(new IntegerNode(int_7), (long)int_6);
            }
         }
      }

      buffer_0.position = 0;
      buffer_0.getNullString();
      script_0.instructions = new int[int_2];
      script_0.intOperands = new int[int_2];
      script_0.stringOperands = new String[int_2];

      for (int_4 = 0; buffer_0.position < int_1; script_0.instructions[int_4++] = int_5) {
         int_5 = buffer_0.getUnsignedShort();
         if (int_5 == 3) {
            script_0.stringOperands[int_4] = buffer_0.readString();
         } else if (int_5 < 100 && int_5 != 21 && int_5 != 38 && int_5 != 39) {
            script_0.intOperands[int_4] = buffer_0.readInt();
         } else {
            script_0.intOperands[int_4] = buffer_0.getUnsignedByte();
         }
      }

      return script_0;
   }

}
