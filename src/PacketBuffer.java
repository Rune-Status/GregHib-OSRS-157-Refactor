public final class PacketBuffer extends Buffer {

   static final int[] anIntArray106;
   IsaacCipher cipher;
   int bitPosition;

   static {
      anIntArray106 = new int[] {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int int_0) {
      super(int_0);
   }

   public boolean method904() {
      //int int_0 = super.payload[super.offset] - this.cipher.method475() & 0xFF;
      int int_0 = super.payload[super.offset] & 0xFF;
      return int_0 >= 128;
   }

   public void method905(IsaacCipher isaaccipher_0) {
      this.cipher = isaaccipher_0;
   }

   public void putOpcode(int int_0) {
      //super.payload[super.offset++] = (byte)(int_0 + this.cipher.nextInt());
      super.payload[super.offset++] = (byte)(int_0);
   }

   public int readOpcode() {
      //return super.payload[super.offset++] - this.cipher.nextInt() & 0xFF;
      return super.payload[super.offset++] & 0xFF;
   }

   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   public int getBits(int int_0) {
      int int_1 = this.bitPosition >> 3;
      int int_2 = 8 - (this.bitPosition & 0x7);
      int int_3 = 0;

      for (this.bitPosition += int_0; int_0 > int_2; int_2 = 8) {
         int_3 += (super.payload[int_1++] & anIntArray106[int_2]) << int_0 - int_2;
         int_0 -= int_2;
      }

      if (int_2 == int_0) {
         int_3 += super.payload[int_1] & anIntArray106[int_2];
      } else {
         int_3 += super.payload[int_1] >> int_2 - int_0 & anIntArray106[int_0];
      }

      return int_3;
   }

   public int bitsAvail(int int_0) {
      return int_0 * 8 - this.bitPosition;
   }

   public int method906() {
      //int int_0 = super.payload[super.offset++] - this.cipher.nextInt() & 0xFF;
       int int_0 = super.payload[super.offset++] & 0xFF;
       return int_0 < 128 ? int_0 : (int_0 - 128 << 8) + (super.payload[super.offset++] & 0xFF);
      //return int_0 < 128 ? int_0 : (int_0 - 128 << 8) + (super.payload[super.offset++] - this.cipher.nextInt() & 0xFF);
   }

   public void seed(int[] ints_0) {
      this.cipher = new IsaacCipher(ints_0);
   }

   public static CacheableNode_Sub5 method907(int int_0) {
      CacheableNode_Sub5 cacheablenode_sub5_0 = (CacheableNode_Sub5) CacheableNode_Sub5.aNodeCache14.get((long)int_0);
      if (cacheablenode_sub5_0 != null) {
         return cacheablenode_sub5_0;
      } else {
         byte[] bytes_0 = CacheableNode_Sub5.anIndexDataBase24.getConfigData(11, int_0);
         cacheablenode_sub5_0 = new CacheableNode_Sub5();
         if (bytes_0 != null) {
            cacheablenode_sub5_0.method886(new Buffer(bytes_0));
         }

         cacheablenode_sub5_0.method885();
         CacheableNode_Sub5.aNodeCache14.put(cacheablenode_sub5_0, (long)int_0);
         return cacheablenode_sub5_0;
      }
   }

   public static String method908(CharSequence charsequence_0, Class109 class109_0) {
      if (charsequence_0 == null) {
         return null;
      } else {
         int int_0 = 0;

         int int_1;
         for (int_1 = charsequence_0.length(); int_0 < int_1 && TextureProvider.method571(charsequence_0.charAt(int_0)); int_0++) {
            ;
         }

         while (int_1 > int_0 && TextureProvider.method571(charsequence_0.charAt(int_1 - 1))) {
            --int_1;
         }

         int int_2 = int_1 - int_0;
         if (int_2 >= 1 && int_2 <= Class19.method205(class109_0)) {
            StringBuilder stringbuilder_0 = new StringBuilder(int_2);

            for (int int_3 = int_0; int_3 < int_1; int_3++) {
               char char_0 = charsequence_0.charAt(int_3);
               if (BaseVarType.method646(char_0)) {
                  char char_1 = MilliTimer.method743(char_0);
                  if (char_1 != 0) {
                     stringbuilder_0.append(char_1);
                  }
               }
            }

            if (stringbuilder_0.length() == 0) {
               return null;
            } else {
               return stringbuilder_0.toString();
            }
         } else {
            return null;
         }
      }
   }

}
