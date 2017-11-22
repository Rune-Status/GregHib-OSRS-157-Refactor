import java.io.IOException;

public class Node_Sub5 extends Node {

   int[] anIntArray79;
   AClass4_Sub1[] anAClass4_Sub1Array1;
   short[] aShortArray5;
   byte[] aByteArray14;
   byte[] aByteArray15;
   Class84[] aClass84Array1;
   byte[] aByteArray16;
   int anInt372;

   Node_Sub5(byte[] bytes_0) {
      this.anAClass4_Sub1Array1 = new AClass4_Sub1[128];
      this.aShortArray5 = new short[128];
      this.aByteArray14 = new byte[128];
      this.aByteArray15 = new byte[128];
      this.aClass84Array1 = new Class84[128];
      this.aByteArray16 = new byte[128];
      this.anIntArray79 = new int[128];
      Buffer buffer_0 = new Buffer(bytes_0);

      int int_0;
      for (int_0 = 0; buffer_0.payload[int_0 + buffer_0.offset] != 0; int_0++) {
         ;
      }

      byte[] bytes_1 = new byte[int_0];

      int int_1;
      for (int_1 = 0; int_1 < int_0; int_1++) {
         bytes_1[int_1] = buffer_0.readByte();
      }

      ++buffer_0.offset;
      ++int_0;
      int_1 = buffer_0.offset;
      buffer_0.offset += int_0;

      int int_2;
      for (int_2 = 0; buffer_0.payload[int_2 + buffer_0.offset] != 0; int_2++) {
         ;
      }

      byte[] bytes_2 = new byte[int_2];

      int int_3;
      for (int_3 = 0; int_3 < int_2; int_3++) {
         bytes_2[int_3] = buffer_0.readByte();
      }

      ++buffer_0.offset;
      ++int_2;
      int_3 = buffer_0.offset;
      buffer_0.offset += int_2;

      int int_4;
      for (int_4 = 0; buffer_0.payload[int_4 + buffer_0.offset] != 0; int_4++) {
         ;
      }

      byte[] bytes_3 = new byte[int_4];

      for (int int_5 = 0; int_5 < int_4; int_5++) {
         bytes_3[int_5] = buffer_0.readByte();
      }

      ++buffer_0.offset;
      ++int_4;
      byte[] bytes_4 = new byte[int_4];
      int int_7;
      int int_8;
      if (int_4 > 1) {
         bytes_4[1] = 1;
         int int_6 = 1;
         int_7 = 2;

         for (int_8 = 2; int_8 < int_4; int_8++) {
            int int_9 = buffer_0.readUnsignedByte();
            if (int_9 == 0) {
               int_6 = int_7++;
            } else {
               if (int_9 <= int_6) {
                  --int_9;
               }

               int_6 = int_9;
            }

            bytes_4[int_8] = (byte)int_6;
         }
      } else {
         int_7 = int_4;
      }

      Class84[] class84s_0 = new Class84[int_7];

      Class84 class84_0;
      for (int_8 = 0; int_8 < class84s_0.length; int_8++) {
         class84_0 = class84s_0[int_8] = new Class84();
         int int_10 = buffer_0.readUnsignedByte();
         if (int_10 > 0) {
            class84_0.aByteArray9 = new byte[int_10 * 2];
         }

         int_10 = buffer_0.readUnsignedByte();
         if (int_10 > 0) {
            class84_0.aByteArray10 = new byte[int_10 * 2 + 2];
            class84_0.aByteArray10[1] = 64;
         }
      }

      int_8 = buffer_0.readUnsignedByte();
      byte[] bytes_7 = int_8 > 0 ? new byte[int_8 * 2] : null;
      int_8 = buffer_0.readUnsignedByte();
      byte[] bytes_5 = int_8 > 0 ? new byte[int_8 * 2] : null;

      int int_11;
      for (int_11 = 0; buffer_0.payload[int_11 + buffer_0.offset] != 0; int_11++) {
         ;
      }

      byte[] bytes_6 = new byte[int_11];

      int int_12;
      for (int_12 = 0; int_12 < int_11; int_12++) {
         bytes_6[int_12] = buffer_0.readByte();
      }

      ++buffer_0.offset;
      ++int_11;
      int_12 = 0;

      int int_13;
      for (int_13 = 0; int_13 < 128; int_13++) {
         int_12 += buffer_0.readUnsignedByte();
         this.aShortArray5[int_13] = (short)int_12;
      }

      int_12 = 0;

      for (int_13 = 0; int_13 < 128; int_13++) {
         int_12 += buffer_0.readUnsignedByte();
         this.aShortArray5[int_13] = (short)(this.aShortArray5[int_13] + (int_12 << 8));
      }

      int_13 = 0;
      int int_14 = 0;
      int int_15 = 0;

      int int_16;
      for (int_16 = 0; int_16 < 128; int_16++) {
         if (int_13 == 0) {
            if (int_14 < bytes_6.length) {
               int_13 = bytes_6[int_14++];
            } else {
               int_13 = -1;
            }

            int_15 = buffer_0.readVarInt();
         }

         this.aShortArray5[int_16] = (short)(this.aShortArray5[int_16] + ((int_15 - 1 & 0x2) << 14));
         this.anIntArray79[int_16] = int_15;
         --int_13;
      }

      int_13 = 0;
      int_14 = 0;
      int_16 = 0;

      int int_17;
      for (int_17 = 0; int_17 < 128; int_17++) {
         if (this.anIntArray79[int_17] != 0) {
            if (int_13 == 0) {
               if (int_14 < bytes_1.length) {
                  int_13 = bytes_1[int_14++];
               } else {
                  int_13 = -1;
               }

               int_16 = buffer_0.payload[int_1++] - 1;
            }

            this.aByteArray16[int_17] = (byte)int_16;
            --int_13;
         }
      }

      int_13 = 0;
      int_14 = 0;
      int_17 = 0;

      for (int int_18 = 0; int_18 < 128; int_18++) {
         if (this.anIntArray79[int_18] != 0) {
            if (int_13 == 0) {
               if (int_14 < bytes_2.length) {
                  int_13 = bytes_2[int_14++];
               } else {
                  int_13 = -1;
               }

               int_17 = buffer_0.payload[int_3++] + 16 << 2;
            }

            this.aByteArray15[int_18] = (byte)int_17;
            --int_13;
         }
      }

      int_13 = 0;
      int_14 = 0;
      Class84 class84_1 = null;

      int int_19;
      for (int_19 = 0; int_19 < 128; int_19++) {
         if (this.anIntArray79[int_19] != 0) {
            if (int_13 == 0) {
               class84_1 = class84s_0[bytes_4[int_14]];
               if (int_14 < bytes_3.length) {
                  int_13 = bytes_3[int_14++];
               } else {
                  int_13 = -1;
               }
            }

            this.aClass84Array1[int_19] = class84_1;
            --int_13;
         }
      }

      int_13 = 0;
      int_14 = 0;
      int_19 = 0;

      int int_20;
      for (int_20 = 0; int_20 < 128; int_20++) {
         if (int_13 == 0) {
            if (int_14 < bytes_6.length) {
               int_13 = bytes_6[int_14++];
            } else {
               int_13 = -1;
            }

            if (this.anIntArray79[int_20] > 0) {
               int_19 = buffer_0.readUnsignedByte() + 1;
            }
         }

         this.aByteArray14[int_20] = (byte)int_19;
         --int_13;
      }

      this.anInt372 = buffer_0.readUnsignedByte() + 1;

      Class84 class84_2;
      int int_21;
      for (int_20 = 0; int_20 < int_7; int_20++) {
         class84_2 = class84s_0[int_20];
         if (class84_2.aByteArray9 != null) {
            for (int_21 = 1; int_21 < class84_2.aByteArray9.length; int_21 += 2) {
               class84_2.aByteArray9[int_21] = buffer_0.readByte();
            }
         }

         if (class84_2.aByteArray10 != null) {
            for (int_21 = 3; int_21 < class84_2.aByteArray10.length - 2; int_21 += 2) {
               class84_2.aByteArray10[int_21] = buffer_0.readByte();
            }
         }
      }

      if (bytes_7 != null) {
         for (int_20 = 1; int_20 < bytes_7.length; int_20 += 2) {
            bytes_7[int_20] = buffer_0.readByte();
         }
      }

      if (bytes_5 != null) {
         for (int_20 = 1; int_20 < bytes_5.length; int_20 += 2) {
            bytes_5[int_20] = buffer_0.readByte();
         }
      }

      for (int_20 = 0; int_20 < int_7; int_20++) {
         class84_2 = class84s_0[int_20];
         if (class84_2.aByteArray10 != null) {
            int_12 = 0;

            for (int_21 = 2; int_21 < class84_2.aByteArray10.length; int_21 += 2) {
               int_12 = int_12 + 1 + buffer_0.readUnsignedByte();
               class84_2.aByteArray10[int_21] = (byte)int_12;
            }
         }
      }

      for (int_20 = 0; int_20 < int_7; int_20++) {
         class84_2 = class84s_0[int_20];
         if (class84_2.aByteArray9 != null) {
            int_12 = 0;

            for (int_21 = 2; int_21 < class84_2.aByteArray9.length; int_21 += 2) {
               int_12 = int_12 + 1 + buffer_0.readUnsignedByte();
               class84_2.aByteArray9[int_21] = (byte)int_12;
            }
         }
      }

      byte byte_1;
      int int_22;
      int int_23;
      int int_24;
      int int_25;
      int int_26;
      int int_29;
      byte byte_3;
      if (bytes_7 != null) {
         int_12 = buffer_0.readUnsignedByte();
         bytes_7[0] = (byte)int_12;

         for (int_20 = 2; int_20 < bytes_7.length; int_20 += 2) {
            int_12 = 1 + int_12 + buffer_0.readUnsignedByte();
            bytes_7[int_20] = (byte)int_12;
         }

         byte_3 = bytes_7[0];
         byte byte_0 = bytes_7[1];

         for (int_21 = 0; int_21 < byte_3; int_21++) {
            this.aByteArray14[int_21] = (byte)(byte_0 * this.aByteArray14[int_21] + 32 >> 6);
         }

         for (int_21 = 2; int_21 < bytes_7.length; int_21 += 2) {
            byte_1 = bytes_7[int_21];
            byte byte_2 = bytes_7[int_21 + 1];
            int_22 = byte_0 * (byte_1 - byte_3) + (byte_1 - byte_3) / 2;

            for (int_23 = byte_3; int_23 < byte_1; int_23++) {
               int_24 = byte_1 - byte_3;
               int_25 = int_22 >>> 31;
               int_26 = (int_25 + int_22) / int_24 - int_25;
               this.aByteArray14[int_23] = (byte)(int_26 * this.aByteArray14[int_23] + 32 >> 6);
               int_22 += byte_2 - byte_0;
            }

            byte_3 = byte_1;
            byte_0 = byte_2;
         }

         for (int_29 = byte_3; int_29 < 128; int_29++) {
            this.aByteArray14[int_29] = (byte)(byte_0 * this.aByteArray14[int_29] + 32 >> 6);
         }

         class84_0 = null;
      }

      if (bytes_5 != null) {
         int_12 = buffer_0.readUnsignedByte();
         bytes_5[0] = (byte)int_12;

         for (int_20 = 2; int_20 < bytes_5.length; int_20 += 2) {
            int_12 = 1 + int_12 + buffer_0.readUnsignedByte();
            bytes_5[int_20] = (byte)int_12;
         }

         byte_3 = bytes_5[0];
         int int_28 = bytes_5[1] << 1;

         for (int_21 = 0; int_21 < byte_3; int_21++) {
            int_29 = int_28 + (this.aByteArray15[int_21] & 0xFF);
            if (int_29 < 0) {
               int_29 = 0;
            }

            if (int_29 > 128) {
               int_29 = 128;
            }

            this.aByteArray15[int_21] = (byte)int_29;
         }

         int int_30;
         for (int_21 = 2; int_21 < bytes_5.length; int_21 += 2) {
            byte_1 = bytes_5[int_21];
            int_30 = bytes_5[int_21 + 1] << 1;
            int_22 = int_28 * (byte_1 - byte_3) + (byte_1 - byte_3) / 2;

            for (int_23 = byte_3; int_23 < byte_1; int_23++) {
               int_24 = byte_1 - byte_3;
               int_25 = int_22 >>> 31;
               int_26 = (int_22 + int_25) / int_24 - int_25;
               int int_27 = int_26 + (this.aByteArray15[int_23] & 0xFF);
               if (int_27 < 0) {
                  int_27 = 0;
               }

               if (int_27 > 128) {
                  int_27 = 128;
               }

               this.aByteArray15[int_23] = (byte)int_27;
               int_22 += int_30 - int_28;
            }

            byte_3 = byte_1;
            int_28 = int_30;
         }

         for (int_29 = byte_3; int_29 < 128; int_29++) {
            int_30 = int_28 + (this.aByteArray15[int_29] & 0xFF);
            if (int_30 < 0) {
               int_30 = 0;
            }

            if (int_30 > 128) {
               int_30 = 128;
            }

            this.aByteArray15[int_29] = (byte)int_30;
         }

         Object object_0 = null;
      }

      for (int_20 = 0; int_20 < int_7; int_20++) {
         class84s_0[int_20].anInt183 = buffer_0.readUnsignedByte();
      }

      for (int_20 = 0; int_20 < int_7; int_20++) {
         class84_2 = class84s_0[int_20];
         if (class84_2.aByteArray9 != null) {
            class84_2.anInt187 = buffer_0.readUnsignedByte();
         }

         if (class84_2.aByteArray10 != null) {
            class84_2.anInt188 = buffer_0.readUnsignedByte();
         }

         if (class84_2.anInt183 > 0) {
            class84_2.anInt186 = buffer_0.readUnsignedByte();
         }
      }

      for (int_20 = 0; int_20 < int_7; int_20++) {
         class84s_0[int_20].anInt182 = buffer_0.readUnsignedByte();
      }

      for (int_20 = 0; int_20 < int_7; int_20++) {
         class84_2 = class84s_0[int_20];
         if (class84_2.anInt182 > 0) {
            class84_2.anInt184 = buffer_0.readUnsignedByte();
         }
      }

      for (int_20 = 0; int_20 < int_7; int_20++) {
         class84_2 = class84s_0[int_20];
         if (class84_2.anInt184 > 0) {
            class84_2.anInt185 = buffer_0.readUnsignedByte();
         }
      }

   }

   void method692() {
      this.anIntArray79 = null;
   }

   boolean method693(Class52 class52_0, byte[] bytes_0, int[] ints_0) {
      boolean bool_0 = true;
      int int_0 = 0;
      AClass4_Sub1 aclass4_sub1_0 = null;

      for (int int_1 = 0; int_1 < 128; int_1++) {
         if (bytes_0 == null || bytes_0[int_1] != 0) {
            int int_2 = this.anIntArray79[int_1];
            if (int_2 != 0) {
               if (int_0 != int_2) {
                  int_0 = int_2--;
                  if ((int_2 & 0x1) == 0) {
                     aclass4_sub1_0 = class52_0.method333(int_2 >> 2, ints_0);
                  } else {
                     aclass4_sub1_0 = class52_0.method334(int_2 >> 2, ints_0);
                  }

                  if (aclass4_sub1_0 == null) {
                     bool_0 = false;
                  }
               }

               if (aclass4_sub1_0 != null) {
                  this.anAClass4_Sub1Array1[int_1] = aclass4_sub1_0;
                  this.anIntArray79[int_1] = 0;
               }
            }
         }
      }

      return bool_0;
   }

   public static void method694() {
      KitDefinition.identKits.reset();
   }

   static void method695(Buffer buffer_0) {
      if (Client.aByteArray28 != null) {
         buffer_0.putBytes(Client.aByteArray28, 0, Client.aByteArray28.length);
      } else {
         byte[] bytes_0 = new byte[24];

         try {
            Class64.aCacheFile1.seek(0L);
            Class64.aCacheFile1.read(bytes_0);

            int int_0;
            for (int_0 = 0; int_0 < 24 && bytes_0[int_0] == 0; int_0++) {
               ;
            }

            if (int_0 >= 24) {
               throw new IOException();
            }
         } catch (Exception exception_0) {
            for (int int_1 = 0; int_1 < 24; int_1++) {
               bytes_0[int_1] = -1;
            }
         }

         buffer_0.putBytes(bytes_0, 0, bytes_0.length);
      }
   }

}
