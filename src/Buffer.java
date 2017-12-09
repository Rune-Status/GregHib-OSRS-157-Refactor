import java.math.BigInteger;

public class Buffer extends Node {

    public static int[] crc32Table;
    static long[] crc64Table;
    static Preferences preferences;
    static IndexedSprite[] anIndexedSpriteArray8;
    public byte[] buffer;
    public int position;

    static {
        crc32Table = new int[256];

        int int_2;
        for (int value = 0; value < 256; value++) {
            int int_1 = value;

            for (int_2 = 0; int_2 < 8; int_2++) {
                if ((int_1 & 0x1) == 1) {
                    int_1 = int_1 >>> 1 ^ 0xEDB88320;
                } else {
                    int_1 >>>= 1;
                }
            }

            crc32Table[value] = int_1;
        }

        crc64Table = new long[256];

        for (int_2 = 0; int_2 < 256; int_2++) {
            long long_0 = (long) int_2;

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

    public Buffer(int value) {
        buffer = Class6.method98(value);
        position = 0;
    }

    public Buffer(byte[] bytes_0) {
        buffer = bytes_0;
        position = 0;
    }

    public int readInt() {
        position += 4;
        return ((buffer[position - 3] & 0xFF) << 16) + (buffer[position - 1] & 0xFF) + ((buffer[position - 2] & 0xFF) << 8) + ((buffer[position - 4] & 0xFF) << 24);
    }

    public void putByte(int value) {
        buffer[position++] = (byte) value;
    }

    public int getUnsignedByte() {
        return buffer[position++] & 0xFF;
    }

    public int getBigSmart() {
        if (buffer[position] < 0) {
            return this.readInt() & 0x7FFFFFFF;
        } else {
            int value = this.getUnsignedShort();
            return value == 32767 ? -1 : value;
        }
    }

    public int read24BitInt() {
        position += 3;
        return ((buffer[position - 3] & 0xFF) << 16) + (buffer[position - 1] & 0xFF) + ((buffer[position - 2] & 0xFF) << 8);
    }

    public int readVarInt() {
        byte byte_0 = buffer[position++];

        int value;
        for (value = 0; byte_0 < 0; byte_0 = buffer[position++]) {
            value = (value | byte_0 & 0x7F) << 7;
        }

        return value | byte_0;
    }

    public byte readByte() {
        return buffer[position++];
    }

    public String readString() {
        int value = position;

        while (buffer[position++] != 0) {
            ;
        }

        int int_1 = position - value - 1;
        return int_1 == 0 ? "" : Class13.getString(buffer, value, int_1);
    }

    public int getUnsignedShort() {
        position += 2;
        return (buffer[position - 1] & 0xFF) + ((buffer[position - 2] & 0xFF) << 8);
    }

    public void readBytes(byte[] bytes_0, int value, int int_1) {
        for (int int_2 = value; int_2 < int_1 + value; int_2++) {
            bytes_0[int_2] = buffer[position++];
        }

    }

    public void putInt(int value) {
        buffer[position++] = (byte) (value >> 24);
        buffer[position++] = (byte) (value >> 16);
        buffer[position++] = (byte) (value >> 8);
        buffer[position++] = (byte) value;
    }

    public void putShort(int value) {
        buffer[position++] = (byte) (value >> 8);
        buffer[position++] = (byte) value;
    }

    public int readShort() {
        position += 2;
        int value = (buffer[position - 1] & 0xFF) + ((buffer[position - 2] & 0xFF) << 8);
        if (value > 32767) {
            value -= 65536;
        }

        return value;
    }

    public String getJagString() {
        byte byte_0 = buffer[position++];
        if (byte_0 != 0) {
            throw new IllegalStateException("");
        } else {
            int value = position;

            while (buffer[position++] != 0) {
                ;
            }

            int int_1 = position - value - 1;
            return int_1 == 0 ? "" : Class13.getString(buffer, value, int_1);
        }
    }

    public void putVarInt(int value) {
        if ((value & 0xFFFFFF80) != 0) {
            if ((value & 0xFFFFC000) != 0) {
                if ((value & 0xFFE00000) != 0) {
                    if ((value & 0xF0000000) != 0) {
                        this.putByte(value >>> 28 | 0x80);
                    }

                    this.putByte(value >>> 21 | 0x80);
                }

                this.putByte(value >>> 14 | 0x80);
            }

            this.putByte(value >>> 7 | 0x80);
        }

        this.putByte(value & 0x7F);
    }

    public void putBytes(byte[] bytes_0, int value, int int_1) {
        for (int int_2 = value; int_2 < int_1 + value; int_2++) {
            buffer[position++] = bytes_0[int_2];
        }

    }

    public long readLong() {
        long long_0 = (long) this.readInt() & 0xFFFFFFFFL;
        long long_1 = (long) this.readInt() & 0xFFFFFFFFL;
        return (long_0 << 32) + long_1;
    }

    public int getLargeSmart() {
        return buffer[position] < 0 ? this.readInt() & 0x7FFFFFFF : this.getUnsignedShort();
    }

    public void decryptXtea(int[] ints_0, int value, int int_1) {
        int int_2 = position;
        position = value;
        int int_3 = (int_1 - value) / 8;

        for (int int_4 = 0; int_4 < int_3; int_4++) {
            int int_5 = this.readInt();
            int int_6 = this.readInt();
            int int_7 = -957401312;
            int int_8 = -1640531527;

            for (int int_9 = 32; int_9-- > 0; int_5 -= int_6 + (int_6 << 4 ^ int_6 >>> 5) ^ int_7 + ints_0[int_7 & 0x3]) {
                int_6 -= int_5 + (int_5 << 4 ^ int_5 >>> 5) ^ ints_0[int_7 >>> 11 & 0x3] + int_7;
                int_7 -= int_8;
            }

            position -= 8;
            this.putInt(int_5);
            this.putInt(int_6);
        }

        position = int_2;
    }

    public void putString(String string_0) {
        int value = string_0.indexOf(0);
        if (value >= 0) {
            throw new IllegalArgumentException("");
        } else {
            position += KeyFocusListener.method321(string_0, 0, string_0.length(), buffer, position);
            buffer[position++] = 0;
        }
    }

    public void method704(boolean bool_0) {
        this.putByte(bool_0 ? 1 : 0);
    }

    public void put24bitInt(int value) {
        buffer[position++] = (byte) (value >> 16);
        buffer[position++] = (byte) (value >> 8);
        buffer[position++] = (byte) value;
    }

    public String getNullString() {
        if (buffer[position] == 0) {
            ++position;
            return null;
        } else {
            return this.readString();
        }
    }

    public boolean method705() {
        return (this.getUnsignedByte() & 0x1) == 1;
    }

    public int readUnsignedShortOb1() {
        position += 2;
        return (buffer[position - 1] - 128 & 0xFF) + ((buffer[position - 2] & 0xFF) << 8);
    }

    public int readShortSmart() {
        int value = buffer[position] & 0xFF;
        return value < 128 ? this.getUnsignedByte() - 64 : this.getUnsignedShort() - 49152;
    }

    public int method706() {
        position += 4;
        return (buffer[position - 4] & 0xFF) + ((buffer[position - 3] & 0xFF) << 8) + ((buffer[position - 2] & 0xFF) << 16) + ((buffer[position - 1] & 0xFF) << 24);
    }

    public void putJagString(String string_0) {
        int value = string_0.indexOf(0);
        if (value >= 0) {
            throw new IllegalArgumentException("");
        } else {
            buffer[position++] = 0;
            position += KeyFocusListener.method321(string_0, 0, string_0.length(), buffer, position);
            buffer[position++] = 0;
        }
    }

    public int method707() {
        position += 2;
        int value = (buffer[position - 1] - 128 & 0xFF) + ((buffer[position - 2] & 0xFF) << 8);
        if (value > 32767) {
            value -= 65536;
        }

        return value;
    }

    public void method708(int value) {
        buffer[position - value - 1] = (byte) value;
    }

    public int getUnsignedByteS() {
        return 128 - buffer[position++] & 0xFF;
    }

    public int getUnsignedByteC() {
        return 0 - buffer[position++] & 0xFF;
    }

    public int getUSmart() {
        int value = buffer[position] & 0xFF;
        return value < 128 ? getUnsignedByte() : getUnsignedShort() - 32768;
    }

    public int readNegUByte() {
        return buffer[position++] - 128 & 0xFF;
    }

    public int getUnsignedShortAInverse() {
        position += 2;
        return ((buffer[position - 1] & 0xFF) << 8) + (buffer[position - 2] - 128 & 0xFF);
    }

    public int getUnsignedShortInverse() {
        position += 2;
        return ((buffer[position - 1] & 0xFF) << 8) + (buffer[position - 2] & 0xFF);
    }

    public int method714() {
        position += 4;
        return ((buffer[position - 2] & 0xFF) << 24) + ((buffer[position - 4] & 0xFF) << 8) + (buffer[position - 3] & 0xFF) + ((buffer[position - 1] & 0xFF) << 16);
    }

    public int putCrc(int value) {
        byte[] bytes_0 = buffer;
        int int_1 = position;
        int int_2 = -1;

        for (int int_3 = value; int_3 < int_1; int_3++) {
            int_2 = int_2 >>> 8 ^ crc32Table[(int_2 ^ bytes_0[int_3]) & 0xFF];
        }

        int_2 = ~int_2;
        this.putInt(int_2);
        return int_2;
    }

    public byte getByteA() {
        return (byte) (buffer[position++] - 128);
    }

    public void putByteInverse(int value) {
        buffer[position++] = (byte) (0 - value);
    }

    public byte method717() {
        return (byte) (0 - buffer[position++]);
    }

    public void method718(int value) {
        buffer[position++] = (byte) (value >> 8);
        buffer[position++] = (byte) value;
        buffer[position++] = (byte) (value >> 24);
        buffer[position++] = (byte) (value >> 16);
    }

    public void method719(int value) {
        buffer[position++] = (byte) value;
        buffer[position++] = (byte) (value >> 8);
    }

    public void putShortS(int value) {
        buffer[position++] = (byte) (value >> 8);
        buffer[position++] = (byte) (value + 128);
    }

    public void putShortLEA(int value) {
        buffer[position++] = (byte) (value + 128);
        buffer[position++] = (byte) (value >> 8);
    }

    public void putLong(long value) {
        buffer[position++] = (byte) (int) (value >> 56);
        buffer[position++] = (byte) (int) (value >> 48);
        buffer[position++] = (byte) (int) (value >> 40);
        buffer[position++] = (byte) (int) (value >> 32);
        buffer[position++] = (byte) (int) (value >> 24);
        buffer[position++] = (byte) (int) (value >> 16);
        buffer[position++] = (byte) (int) (value >> 8);
        buffer[position++] = (byte) (int) value;
    }

    public void putByteA(int value) {
        buffer[position++] = (byte) (value + 128);
    }

    public void method722(int value) {
        buffer[position - value - 2] = (byte) (value >> 8);
        buffer[position - value - 1] = (byte) value;
    }

    public void method723(int value) {
        buffer[position++] = (byte) (value >> 8);
        buffer[position++] = (byte) (value >> 16);
        buffer[position++] = (byte) value;
    }

    public int method724() {
        position += 2;
        int value = ((buffer[position - 1] & 0xFF) << 8) + (buffer[position - 2] & 0xFF);
        if (value > 32767) {
            value -= 65536;
        }

        return value;
    }

    public void method725(int value) {
        buffer[position++] = (byte) (value >> 16);
        buffer[position++] = (byte) (value >> 24);
        buffer[position++] = (byte) value;
        buffer[position++] = (byte) (value >> 8);
    }

    public void encryptRsa(BigInteger exponent, BigInteger modulus) {
        int length = position;
        position = 0;
        byte[] buffer = new byte[length];
        this.readBytes(buffer, 0, length);
        BigInteger bigInteger = new BigInteger(buffer);
        BigInteger rsa = bigInteger.modPow(exponent, modulus);
        byte[] data = rsa.toByteArray();
        position = 0;
        this.putShort(data.length);
        this.putBytes(data, 0, data.length);
    }

    public void method726(int value) {
        buffer[position++] = (byte) value;
        buffer[position++] = (byte) (value >> 8);
        buffer[position++] = (byte) (value >> 16);
        buffer[position++] = (byte) (value >> 24);
    }

    public int method727() {
        position += 4;
        return ((buffer[position - 1] & 0xFF) << 8) + ((buffer[position - 4] & 0xFF) << 16) + (buffer[position - 2] & 0xFF) + ((buffer[position - 3] & 0xFF) << 24);
    }

    public byte getByteS() {
        return (byte) (128 - buffer[position++]);
    }

    public void putByteS(int value) {
        buffer[position++] = (byte) (128 - value);
    }

    public void method730(long value) {
        buffer[position++] = (byte) ((int) (value >> 40));
        buffer[position++] = (byte) ((int) (value >> 32));
        buffer[position++] = (byte) ((int) (value >> 24));
        buffer[position++] = (byte) ((int) (value >> 16));
        buffer[position++] = (byte) ((int) (value >> 8));
        buffer[position++] = (byte) ((int) value);
    }

    public String getCESU8() {
        byte byte_0 = buffer[position++];
        if (byte_0 != 0) {
            throw new IllegalStateException("");
        } else {
            int value = this.readVarInt();
            if (value + position > buffer.length) {
                throw new IllegalStateException("");
            } else {
                byte[] bytes_0 = buffer;
                int int_1 = position;
                char[] chars_0 = new char[value];
                int int_2 = 0;
                int int_3 = int_1;

                int int_6;
                for (int int_4 = value + int_1; int_3 < int_4; chars_0[int_2++] = (char) int_6) {
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
                position += value;
                return string_0;
            }
        }
    }

    public void putCESU8(CharSequence charsequence_0) {
        int value = charsequence_0.length();
        int int_1 = 0;

        int int_2;
        for (int_2 = 0; int_2 < value; int_2++) {
            char char_0 = charsequence_0.charAt(int_2);
            if (char_0 <= 127) {
                ++int_1;
            } else if (char_0 <= 2047) {
                int_1 += 2;
            } else {
                int_1 += 3;
            }
        }

        buffer[position++] = 0;
        this.putVarInt(int_1);
        int_1 = position;
        byte[] bytes_0 = buffer;
        int int_3 = position;
        int int_4 = charsequence_0.length();
        int int_5 = int_3;

        for (int int_6 = 0; int_6 < int_4; int_6++) {
            char char_1 = charsequence_0.charAt(int_6);
            if (char_1 <= 127) {
                bytes_0[int_5++] = (byte) char_1;
            } else if (char_1 <= 2047) {
                bytes_0[int_5++] = (byte) (0xC0 | char_1 >> 6);
                bytes_0[int_5++] = (byte) (0x80 | char_1 & 0x3F);
            } else {
                bytes_0[int_5++] = (byte) (0xE0 | char_1 >> 12);
                bytes_0[int_5++] = (byte) (0x80 | char_1 >> 6 & 0x3F);
                bytes_0[int_5++] = (byte) (0x80 | char_1 & 0x3F);
            }
        }

        int_2 = int_5 - int_3;
        position = int_1 + int_2;
    }

    public void encryptXtea2(int[] ints_0) {
        int value = position / 8;
        position = 0;

        for (int int_1 = 0; int_1 < value; int_1++) {
            int int_2 = this.readInt();
            int int_3 = this.readInt();
            int int_4 = 0;
            int int_5 = -1640531527;

            for (int int_6 = 32; int_6-- > 0; int_3 += int_2 + (int_2 << 4 ^ int_2 >>> 5) ^ ints_0[int_4 >>> 11 & 0x3] + int_4) {
                int_2 += int_3 + (int_3 << 4 ^ int_3 >>> 5) ^ int_4 + ints_0[int_4 & 0x3];
                int_4 += int_5;
            }

            position -= 8;
            this.putInt(int_2);
            this.putInt(int_3);
        }

    }

    public void putLengthInt(int value) {
        buffer[position - value - 4] = (byte) (value >> 24);
        buffer[position - value - 3] = (byte) (value >> 16);
        buffer[position - value - 2] = (byte) (value >> 8);
        buffer[position - value - 1] = (byte) value;
    }

    public void readData(byte[] data, int offset, int length) {
        for (int i = length + offset - 1; i >= offset; --i) {
            data[i] = buffer[position++];
        }

    }

    public void readReverseData(byte[] data, int length, int offset) {
        for (int i = length; i < offset + length; i++) {
            data[i] = (byte) (buffer[position++] - 128);
        }
    }

    public boolean checkCrc() {
        position -= 4;
        byte[] bytes_0 = buffer;
        int value = position;
        int int_1 = -1;

        int int_2;
        for (int_2 = 0; int_2 < value; int_2++) {
            int_1 = int_1 >>> 8 ^ crc32Table[(int_1 ^ bytes_0[int_2]) & 0xFF];
        }

        int_1 = ~int_1;
        int_2 = this.readInt();
        return int_2 == int_1;
    }

    public void decryptXtea(int[] keys) {
        int value = position / 8;
        position = 0;

        for (int int_1 = 0; int_1 < value; int_1++) {
            int int_2 = this.readInt();
            int int_3 = this.readInt();
            int int_4 = -957401312;
            int int_5 = -1640531527;

            for (int int_6 = 32; int_6-- > 0; int_2 -= int_3 + (int_3 << 4 ^ int_3 >>> 5) ^ int_4 + keys[int_4 & 0x3]) {
                int_3 -= int_2 + (int_2 << 4 ^ int_2 >>> 5) ^ keys[int_4 >>> 11 & 0x3] + int_4;
                int_4 -= int_5;
            }

            position -= 8;
            this.putInt(int_2);
            this.putInt(int_3);
        }

    }

    public void encryptXtea(int[] ints_0, int value, int int_1) {
        int int_2 = position;
        position = value;
        int int_3 = (int_1 - value) / 8;

        for (int int_4 = 0; int_4 < int_3; int_4++) {
            int int_5 = this.readInt();
            int int_6 = this.readInt();
            int int_7 = 0;
            int int_8 = -1640531527;

            for (int int_9 = 32; int_9-- > 0; int_6 += int_5 + (int_5 << 4 ^ int_5 >>> 5) ^ ints_0[int_7 >>> 11 & 0x3] + int_7) {
                int_5 += int_6 + (int_6 << 4 ^ int_6 >>> 5) ^ int_7 + ints_0[int_7 & 0x3];
                int_7 += int_8;
            }

            position -= 8;
            this.putInt(int_5);
            this.putInt(int_6);
        }

        position = int_2;
    }

    public void putShortSmart(int value) {
        if (value >= 0 && value < 128) {
            this.putByte(value);
        } else if (value >= 0 && value < 32768) {
            this.putShort(value + 32768);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void method733() {
        if (buffer != null) {
            Class9.method152(buffer);
        }

        buffer = null;
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
        int value = indexdatabase_0.getFile(string_0);
        int int_1 = indexdatabase_0.getChild(value, string_1);
        SpritePixels[] spritepixelss_0;
        if (!TileStrategy.method628(indexdatabase_0, value, int_1)) {
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
