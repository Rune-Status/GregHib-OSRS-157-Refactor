import java.math.BigInteger;

public class Buffer extends Node {

   public static int[] crc32Table;
   static long[] crc64Table;
   static Preferences preferences;
   static IndexedSprite[] anIndexedSpriteArray8;
   public byte[] payload;
   public int offset;

   static {
      crc32Table = new int[256];

      int int_2;
      for (int int_0 = 0; int_0 < 256; int_0++) {
         int int_1 = int_0;

         for (int_2 = 0; int_2 < 8; int_2++) {
            if ((int_1 & 0x1) == 1) {
               int_1 = int_1 >>> 1 ^ 0xEDB88320;
            } else {
               int_1 >>>= 1;
            }
         }

         crc32Table[int_0] = int_1;
      }

      crc64Table = new long[256];

      for (int_2 = 0; int_2 < 256; int_2++) {
         long long_0 = (long)int_2;

         for (int int_3 = 0; int_3 < 8; int_3++) {
            if ((long_0 & 0x1L) == 1L) {
               long_0 = long_0 >>> 1 ^ 0xC96C5795D7870F42L;
            } else {
               long_0 >>>= 1;
            }
         }

         crc64Table[int_2] = long_0;
      }

   }

   public Buffer(int int_0) {
      this.payload = Class6.method98(int_0);
      this.offset = 0;
   }

   public Buffer(byte[] bytes_0) {
      this.payload = bytes_0;
      this.offset = 0;
   }

   public int readInt() {
      this.offset += 4;
      return ((this.payload[this.offset - 3] & 0xFF) << 16) + (this.payload[this.offset - 1] & 0xFF) + ((this.payload[this.offset - 2] & 0xFF) << 8) + ((this.payload[this.offset - 4] & 0xFF) << 24);
   }

   public void putByte(int int_0) {
      this.payload[this.offset++] = (byte)int_0;
   }

   public int readUnsignedByte() {
      return this.payload[this.offset++] & 0xFF;
   }

   public int method703() {
      if (this.payload[this.offset] < 0) {
         return this.readInt() & 0x7FFFFFFF;
      } else {
         int int_0 = this.readUnsignedShort();
         return int_0 == 32767 ? -1 : int_0;
      }
   }

   public int read24BitInt() {
      this.offset += 3;
      return ((this.payload[this.offset - 3] & 0xFF) << 16) + (this.payload[this.offset - 1] & 0xFF) + ((this.payload[this.offset - 2] & 0xFF) << 8);
   }

   public int readVarInt() {
      byte byte_0 = this.payload[this.offset++];

      int int_0;
      for (int_0 = 0; byte_0 < 0; byte_0 = this.payload[this.offset++]) {
         int_0 = (int_0 | byte_0 & 0x7F) << 7;
      }

      return int_0 | byte_0;
   }

   public byte readByte() {
      return this.payload[this.offset++];
   }

   public String readString() {
      int int_0 = this.offset;

      while (this.payload[this.offset++] != 0) {
         ;
      }

      int int_1 = this.offset - int_0 - 1;
      return int_1 == 0 ? "" : Class13.getString(this.payload, int_0, int_1);
   }

   public int readUnsignedShort() {
      this.offset += 2;
      return (this.payload[this.offset - 1] & 0xFF) + ((this.payload[this.offset - 2] & 0xFF) << 8);
   }

   public void readBytes(byte[] bytes_0, int int_0, int int_1) {
      for (int int_2 = int_0; int_2 < int_1 + int_0; int_2++) {
         bytes_0[int_2] = this.payload[this.offset++];
      }

   }

   public void putInt(int int_0) {
      this.payload[this.offset++] = (byte)(int_0 >> 24);
      this.payload[this.offset++] = (byte)(int_0 >> 16);
      this.payload[this.offset++] = (byte)(int_0 >> 8);
      this.payload[this.offset++] = (byte)int_0;
   }

   public void putShort(int int_0) {
      this.payload[this.offset++] = (byte)(int_0 >> 8);
      this.payload[this.offset++] = (byte)int_0;
   }

   public int readShort() {
      this.offset += 2;
      int int_0 = (this.payload[this.offset - 1] & 0xFF) + ((this.payload[this.offset - 2] & 0xFF) << 8);
      if (int_0 > 32767) {
         int_0 -= 65536;
      }

      return int_0;
   }

   public String getJagString() {
      byte byte_0 = this.payload[this.offset++];
      if (byte_0 != 0) {
         throw new IllegalStateException("");
      } else {
         int int_0 = this.offset;

         while (this.payload[this.offset++] != 0) {
            ;
         }

         int int_1 = this.offset - int_0 - 1;
         return int_1 == 0 ? "" : Class13.getString(this.payload, int_0, int_1);
      }
   }

   public void putVarInt(int int_0) {
      if ((int_0 & 0xFFFFFF80) != 0) {
         if ((int_0 & 0xFFFFC000) != 0) {
            if ((int_0 & 0xFFE00000) != 0) {
               if ((int_0 & 0xF0000000) != 0) {
                  this.putByte(int_0 >>> 28 | 0x80);
               }

               this.putByte(int_0 >>> 21 | 0x80);
            }

            this.putByte(int_0 >>> 14 | 0x80);
         }

         this.putByte(int_0 >>> 7 | 0x80);
      }

      this.putByte(int_0 & 0x7F);
   }

   public void putBytes(byte[] bytes_0, int int_0, int int_1) {
      for (int int_2 = int_0; int_2 < int_1 + int_0; int_2++) {
         this.payload[this.offset++] = bytes_0[int_2];
      }

   }

   public long readLong() {
      long long_0 = (long)this.readInt() & 0xFFFFFFFFL;
      long long_1 = (long)this.readInt() & 0xFFFFFFFFL;
      return (long_0 << 32) + long_1;
   }

   public int getLargeSmart() {
      return this.payload[this.offset] < 0 ? this.readInt() & 0x7FFFFFFF : this.readUnsignedShort();
   }

   public void decryptXtea(int[] ints_0, int int_0, int int_1) {
      int int_2 = this.offset;
      this.offset = int_0;
      int int_3 = (int_1 - int_0) / 8;

      for (int int_4 = 0; int_4 < int_3; int_4++) {
         int int_5 = this.readInt();
         int int_6 = this.readInt();
         int int_7 = -957401312;
         int int_8 = -1640531527;

         for (int int_9 = 32; int_9-- > 0; int_5 -= int_6 + (int_6 << 4 ^ int_6 >>> 5) ^ int_7 + ints_0[int_7 & 0x3]) {
            int_6 -= int_5 + (int_5 << 4 ^ int_5 >>> 5) ^ ints_0[int_7 >>> 11 & 0x3] + int_7;
            int_7 -= int_8;
         }

         this.offset -= 8;
         this.putInt(int_5);
         this.putInt(int_6);
      }

      this.offset = int_2;
   }

   public void putString(String string_0) {
      int int_0 = string_0.indexOf(0);
      if (int_0 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += KeyFocusListener.method321(string_0, 0, string_0.length(), this.payload, this.offset);
         this.payload[this.offset++] = 0;
      }
   }

   public void method704(boolean bool_0) {
      this.putByte(bool_0 ? 1 : 0);
   }

   public void put24bitInt(int int_0) {
      this.payload[this.offset++] = (byte)(int_0 >> 16);
      this.payload[this.offset++] = (byte)(int_0 >> 8);
      this.payload[this.offset++] = (byte)int_0;
   }

   public String getNullString() {
      if (this.payload[this.offset] == 0) {
         ++this.offset;
         return null;
      } else {
         return this.readString();
      }
   }

   public boolean method705() {
      return (this.readUnsignedByte() & 0x1) == 1;
   }

   public int readUnsignedShortOb1() {
      this.offset += 2;
      return (this.payload[this.offset - 1] - 128 & 0xFF) + ((this.payload[this.offset - 2] & 0xFF) << 8);
   }

   public int readShortSmart() {
      int int_0 = this.payload[this.offset] & 0xFF;
      return int_0 < 128 ? this.readUnsignedByte() - 64 : this.readUnsignedShort() - 49152;
   }

   public int method706() {
      this.offset += 4;
      return (this.payload[this.offset - 4] & 0xFF) + ((this.payload[this.offset - 3] & 0xFF) << 8) + ((this.payload[this.offset - 2] & 0xFF) << 16) + ((this.payload[this.offset - 1] & 0xFF) << 24);
   }

   public void putJagString(String string_0) {
      int int_0 = string_0.indexOf(0);
      if (int_0 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.payload[this.offset++] = 0;
         this.offset += KeyFocusListener.method321(string_0, 0, string_0.length(), this.payload, this.offset);
         this.payload[this.offset++] = 0;
      }
   }

   public int method707() {
      this.offset += 2;
      int int_0 = (this.payload[this.offset - 1] - 128 & 0xFF) + ((this.payload[this.offset - 2] & 0xFF) << 8);
      if (int_0 > 32767) {
         int_0 -= 65536;
      }

      return int_0;
   }

   public void method708(int int_0) {
      this.payload[this.offset - int_0 - 1] = (byte)int_0;
   }

   public int method709() {
      return 128 - this.payload[this.offset++] & 0xFF;
   }

   public int method710() {
      return 0 - this.payload[this.offset++] & 0xFF;
   }

   public int getUSmart() {
      int int_0 = this.payload[this.offset] & 0xFF;
      return int_0 < 128 ? this.readUnsignedByte() : this.readUnsignedShort() - 32768;
   }

   public int readNegUByte() {
      return this.payload[this.offset++] - 128 & 0xFF;
   }

   public int method712() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 0xFF) << 8) + (this.payload[this.offset - 2] - 128 & 0xFF);
   }

   public int method713() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 0xFF) << 8) + (this.payload[this.offset - 2] & 0xFF);
   }

   public int method714() {
      this.offset += 4;
      return ((this.payload[this.offset - 2] & 0xFF) << 24) + ((this.payload[this.offset - 4] & 0xFF) << 8) + (this.payload[this.offset - 3] & 0xFF) + ((this.payload[this.offset - 1] & 0xFF) << 16);
   }

   public int putCrc(int int_0) {
      byte[] bytes_0 = this.payload;
      int int_1 = this.offset;
      int int_2 = -1;

      for (int int_3 = int_0; int_3 < int_1; int_3++) {
         int_2 = int_2 >>> 8 ^ crc32Table[(int_2 ^ bytes_0[int_3]) & 0xFF];
      }

      int_2 = ~int_2;
      this.putInt(int_2);
      return int_2;
   }

   public byte method715() {
      return (byte)(this.payload[this.offset++] - 128);
   }

   public void method716(int int_0) {
      this.payload[this.offset++] = (byte)(0 - int_0);
   }

   public byte method717() {
      return (byte)(0 - this.payload[this.offset++]);
   }

   public void method718(int int_0) {
      this.payload[this.offset++] = (byte)(int_0 >> 8);
      this.payload[this.offset++] = (byte)int_0;
      this.payload[this.offset++] = (byte)(int_0 >> 24);
      this.payload[this.offset++] = (byte)(int_0 >> 16);
   }

   public void method719(int int_0) {
      this.payload[this.offset++] = (byte)int_0;
      this.payload[this.offset++] = (byte)(int_0 >> 8);
   }

   public void method720(int int_0) {
      this.payload[this.offset++] = (byte)(int_0 >> 8);
      this.payload[this.offset++] = (byte)(int_0 + 128);
   }

   public void putShortLE(int int_0) {
      this.payload[this.offset++] = (byte)(int_0 + 128);
      this.payload[this.offset++] = (byte)(int_0 >> 8);
   }

   public void putLong(long long_0) {
      this.payload[this.offset++] = (byte)((int)(long_0 >> 56));
      this.payload[this.offset++] = (byte)((int)(long_0 >> 48));
      this.payload[this.offset++] = (byte)((int)(long_0 >> 40));
      this.payload[this.offset++] = (byte)((int)(long_0 >> 32));
      this.payload[this.offset++] = (byte)((int)(long_0 >> 24));
      this.payload[this.offset++] = (byte)((int)(long_0 >> 16));
      this.payload[this.offset++] = (byte)((int)(long_0 >> 8));
      this.payload[this.offset++] = (byte)((int)long_0);
   }

   public void method721(int int_0) {
      this.payload[this.offset++] = (byte)(int_0 + 128);
   }

   public void method722(int int_0) {
      this.payload[this.offset - int_0 - 2] = (byte)(int_0 >> 8);
      this.payload[this.offset - int_0 - 1] = (byte)int_0;
   }

   public void method723(int int_0) {
      this.payload[this.offset++] = (byte)(int_0 >> 8);
      this.payload[this.offset++] = (byte)(int_0 >> 16);
      this.payload[this.offset++] = (byte)int_0;
   }

   public int method724() {
      this.offset += 2;
      int int_0 = ((this.payload[this.offset - 1] & 0xFF) << 8) + (this.payload[this.offset - 2] & 0xFF);
      if (int_0 > 32767) {
         int_0 -= 65536;
      }

      return int_0;
   }

   public void method725(int int_0) {
      this.payload[this.offset++] = (byte)(int_0 >> 16);
      this.payload[this.offset++] = (byte)(int_0 >> 24);
      this.payload[this.offset++] = (byte)int_0;
      this.payload[this.offset++] = (byte)(int_0 >> 8);
   }

   public void encryptRsa(BigInteger exponent, BigInteger modulus) {
      int length = this.offset;
      this.offset = 0;
      byte[] buffer = new byte[length];
      this.readBytes(buffer, 0, length);
      BigInteger bigInteger = new BigInteger(buffer);
      BigInteger rsa = bigInteger.modPow(exponent, modulus);
      byte[] data = rsa.toByteArray();
      this.offset = 0;
      this.putShort(data.length);
      this.putBytes(data, 0, data.length);
   }

   public void method726(int int_0) {
      this.payload[this.offset++] = (byte)int_0;
      this.payload[this.offset++] = (byte)(int_0 >> 8);
      this.payload[this.offset++] = (byte)(int_0 >> 16);
      this.payload[this.offset++] = (byte)(int_0 >> 24);
   }

   public int method727() {
      this.offset += 4;
      return ((this.payload[this.offset - 1] & 0xFF) << 8) + ((this.payload[this.offset - 4] & 0xFF) << 16) + (this.payload[this.offset - 2] & 0xFF) + ((this.payload[this.offset - 3] & 0xFF) << 24);
   }

   public byte method728() {
      return (byte)(128 - this.payload[this.offset++]);
   }

   public void method729(int int_0) {
      this.payload[this.offset++] = (byte)(128 - int_0);
   }

   public void method730(long long_0) {
      this.payload[this.offset++] = (byte)((int)(long_0 >> 40));
      this.payload[this.offset++] = (byte)((int)(long_0 >> 32));
      this.payload[this.offset++] = (byte)((int)(long_0 >> 24));
      this.payload[this.offset++] = (byte)((int)(long_0 >> 16));
      this.payload[this.offset++] = (byte)((int)(long_0 >> 8));
      this.payload[this.offset++] = (byte)((int)long_0);
   }

   public String getCESU8() {
      byte byte_0 = this.payload[this.offset++];
      if (byte_0 != 0) {
         throw new IllegalStateException("");
      } else {
         int int_0 = this.readVarInt();
         if (int_0 + this.offset > this.payload.length) {
            throw new IllegalStateException("");
         } else {
            byte[] bytes_0 = this.payload;
            int int_1 = this.offset;
            char[] chars_0 = new char[int_0];
            int int_2 = 0;
            int int_3 = int_1;

            int int_6;
            for (int int_4 = int_0 + int_1; int_3 < int_4; chars_0[int_2++] = (char)int_6) {
               int int_5 = bytes_0[int_3++] & 0xFF;
               if (int_5 < 128) {
                  if (int_5 == 0) {
                     int_6 = 65533;
                  } else {
                     int_6 = int_5;
                  }
               } else if (int_5 < 192) {
                  int_6 = 65533;
               } else if (int_5 < 224) {
                  if (int_3 < int_4 && (bytes_0[int_3] & 0xC0) == 128) {
                     int_6 = (int_5 & 0x1F) << 6 | bytes_0[int_3++] & 0x3F;
                     if (int_6 < 128) {
                        int_6 = 65533;
                     }
                  } else {
                     int_6 = 65533;
                  }
               } else if (int_5 < 240) {
                  if (int_3 + 1 < int_4 && (bytes_0[int_3] & 0xC0) == 128 && (bytes_0[int_3 + 1] & 0xC0) == 128) {
                     int_6 = (int_5 & 0xF) << 12 | (bytes_0[int_3++] & 0x3F) << 6 | bytes_0[int_3++] & 0x3F;
                     if (int_6 < 2048) {
                        int_6 = 65533;
                     }
                  } else {
                     int_6 = 65533;
                  }
               } else if (int_5 < 248) {
                  if (int_3 + 2 < int_4 && (bytes_0[int_3] & 0xC0) == 128 && (bytes_0[int_3 + 1] & 0xC0) == 128 && (bytes_0[int_3 + 2] & 0xC0) == 128) {
                     int_6 = (int_5 & 0x7) << 18 | (bytes_0[int_3++] & 0x3F) << 12 | (bytes_0[int_3++] & 0x3F) << 6 | bytes_0[int_3++] & 0x3F;
                     if (int_6 >= 65536 && int_6 <= 1114111) {
                        int_6 = 65533;
                     } else {
                        int_6 = 65533;
                     }
                  } else {
                     int_6 = 65533;
                  }
               } else {
                  int_6 = 65533;
               }
            }

            String string_0 = new String(chars_0, 0, int_2);
            this.offset += int_0;
            return string_0;
         }
      }
   }

   public void putCESU8(CharSequence charsequence_0) {
      int int_0 = charsequence_0.length();
      int int_1 = 0;

      int int_2;
      for (int_2 = 0; int_2 < int_0; int_2++) {
         char char_0 = charsequence_0.charAt(int_2);
         if (char_0 <= 127) {
            ++int_1;
         } else if (char_0 <= 2047) {
            int_1 += 2;
         } else {
            int_1 += 3;
         }
      }

      this.payload[this.offset++] = 0;
      this.putVarInt(int_1);
      int_1 = this.offset;
      byte[] bytes_0 = this.payload;
      int int_3 = this.offset;
      int int_4 = charsequence_0.length();
      int int_5 = int_3;

      for (int int_6 = 0; int_6 < int_4; int_6++) {
         char char_1 = charsequence_0.charAt(int_6);
         if (char_1 <= 127) {
            bytes_0[int_5++] = (byte)char_1;
         } else if (char_1 <= 2047) {
            bytes_0[int_5++] = (byte)(0xC0 | char_1 >> 6);
            bytes_0[int_5++] = (byte)(0x80 | char_1 & 0x3F);
         } else {
            bytes_0[int_5++] = (byte)(0xE0 | char_1 >> 12);
            bytes_0[int_5++] = (byte)(0x80 | char_1 >> 6 & 0x3F);
            bytes_0[int_5++] = (byte)(0x80 | char_1 & 0x3F);
         }
      }

      int_2 = int_5 - int_3;
      this.offset = int_1 + int_2;
   }

   public void encryptXtea2(int[] ints_0) {
      int int_0 = this.offset / 8;
      this.offset = 0;

      for (int int_1 = 0; int_1 < int_0; int_1++) {
         int int_2 = this.readInt();
         int int_3 = this.readInt();
         int int_4 = 0;
         int int_5 = -1640531527;

         for (int int_6 = 32; int_6-- > 0; int_3 += int_2 + (int_2 << 4 ^ int_2 >>> 5) ^ ints_0[int_4 >>> 11 & 0x3] + int_4) {
            int_2 += int_3 + (int_3 << 4 ^ int_3 >>> 5) ^ int_4 + ints_0[int_4 & 0x3];
            int_4 += int_5;
         }

         this.offset -= 8;
         this.putInt(int_2);
         this.putInt(int_3);
      }

   }

   public void putLengthInt(int int_0) {
      this.payload[this.offset - int_0 - 4] = (byte)(int_0 >> 24);
      this.payload[this.offset - int_0 - 3] = (byte)(int_0 >> 16);
      this.payload[this.offset - int_0 - 2] = (byte)(int_0 >> 8);
      this.payload[this.offset - int_0 - 1] = (byte)int_0;
   }

   public void readData(byte[] data, int offset, int length) {
      for (int i = length + offset - 1; i >= offset; --i) {
         data[i] = this.payload[this.offset++];
      }

   }

   public void readReverseData(byte[] data, int length, int offset) {
      for (int i = length; i < offset + length; i++) {
         data[i] = (byte)(this.payload[this.offset++] - 128);
      }
   }

   public boolean checkCrc() {
      this.offset -= 4;
      byte[] bytes_0 = this.payload;
      int int_0 = this.offset;
      int int_1 = -1;

      int int_2;
      for (int_2 = 0; int_2 < int_0; int_2++) {
         int_1 = int_1 >>> 8 ^ crc32Table[(int_1 ^ bytes_0[int_2]) & 0xFF];
      }

      int_1 = ~int_1;
      int_2 = this.readInt();
      return int_2 == int_1;
   }

   public void decryptXtea(int[] ints_0) {
      int int_0 = this.offset / 8;
      this.offset = 0;

      for (int int_1 = 0; int_1 < int_0; int_1++) {
         int int_2 = this.readInt();
         int int_3 = this.readInt();
         int int_4 = -957401312;
         int int_5 = -1640531527;

         for (int int_6 = 32; int_6-- > 0; int_2 -= int_3 + (int_3 << 4 ^ int_3 >>> 5) ^ int_4 + ints_0[int_4 & 0x3]) {
            int_3 -= int_2 + (int_2 << 4 ^ int_2 >>> 5) ^ ints_0[int_4 >>> 11 & 0x3] + int_4;
            int_4 -= int_5;
         }

         this.offset -= 8;
         this.putInt(int_2);
         this.putInt(int_3);
      }

   }

   public void encryptXtea(int[] ints_0, int int_0, int int_1) {
      int int_2 = this.offset;
      this.offset = int_0;
      int int_3 = (int_1 - int_0) / 8;

      for (int int_4 = 0; int_4 < int_3; int_4++) {
         int int_5 = this.readInt();
         int int_6 = this.readInt();
         int int_7 = 0;
         int int_8 = -1640531527;

         for (int int_9 = 32; int_9-- > 0; int_6 += int_5 + (int_5 << 4 ^ int_5 >>> 5) ^ ints_0[int_7 >>> 11 & 0x3] + int_7) {
            int_5 += int_6 + (int_6 << 4 ^ int_6 >>> 5) ^ int_7 + ints_0[int_7 & 0x3];
            int_7 += int_8;
         }

         this.offset -= 8;
         this.putInt(int_5);
         this.putInt(int_6);
      }

      this.offset = int_2;
   }

   public void putShortSmart(int int_0) {
      if (int_0 >= 0 && int_0 < 128) {
         this.putByte(int_0);
      } else if (int_0 >= 0 && int_0 < 32768) {
         this.putShort(int_0 + 32768);
      } else {
         throw new IllegalArgumentException();
      }
   }

   public void method733() {
      if (this.payload != null) {
         Class9.method152(this.payload);
      }

      this.payload = null;
   }

   static void method734() {
      Class19.anInt72 = -794026349 * -1409881871;
      Class19.aByteArrayArrayArray5 = new byte[4][104][104];
      Class106.aByteArrayArrayArray9 = new byte[4][104][104];
      Class19.aByteArrayArrayArray6 = new byte[4][104][104];
      Class7.aByteArrayArrayArray2 = new byte[4][104][104];
      ItemLayer.anIntArrayArrayArray1 = new int[4][105][105];
      Class19.aByteArrayArrayArray7 = new byte[4][105][105];
      Class79.anIntArrayArray12 = new int[105][105];
      Class19.anIntArray8 = new int[104];
      RSCanvas.anIntArray82 = new int[104];
      Preferences.anIntArray39 = new int[104];
      FloorUnderlayDefinition.anIntArray105 = new int[104];
      Class19.anIntArray11 = new int[104];
   }

   public static SpritePixels[] method735(IndexDataBase indexdatabase_0, String string_0, String string_1) {
      int int_0 = indexdatabase_0.getFile(string_0);
      int int_1 = indexdatabase_0.getChild(int_0, string_1);
      SpritePixels[] spritepixelss_0;
      if (!TileStrategy.method628(indexdatabase_0, int_0, int_1)) {
         spritepixelss_0 = null;
      } else {
         spritepixelss_0 = ObjectComposition.method829();
      }

      return spritepixelss_0;
   }

   public static boolean method736(CharSequence charsequence_0) {
      return KeyFocusListener.method322(charsequence_0, 10, true);
   }

}
