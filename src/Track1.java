public class Track1 extends Node {

   HashTable aHashTable7;
   byte[] aByteArray17;

   Track1(Buffer buffer_0) {
      buffer_0.position = buffer_0.buffer.length - 3;
      int int_0 = buffer_0.getUnsignedByte();
      int int_1 = buffer_0.getUnsignedShort();
      int int_2 = int_0 * 10 + 14;
      buffer_0.position = 0;
      int int_3 = 0;
      int int_4 = 0;
      int int_5 = 0;
      int int_6 = 0;
      int int_7 = 0;
      int int_8 = 0;
      int int_9 = 0;
      int int_10 = 0;

      int int_11;
      int int_12;
      int int_13;
      for (int_11 = 0; int_11 < int_0; int_11++) {
         int_12 = -1;

         while (true) {
            int_13 = buffer_0.getUnsignedByte();
            if (int_13 != int_12) {
               ++int_2;
            }

            int_12 = int_13 & 0xF;
            if (int_13 == 7) {
               break;
            }

            if (int_13 == 23) {
               ++int_3;
            } else if (int_12 == 0) {
               ++int_5;
            } else if (int_12 == 1) {
               ++int_6;
            } else if (int_12 == 2) {
               ++int_4;
            } else if (int_12 == 3) {
               ++int_7;
            } else if (int_12 == 4) {
               ++int_8;
            } else if (int_12 == 5) {
               ++int_9;
            } else {
               if (int_12 != 6) {
                  throw new RuntimeException();
               }

               ++int_10;
            }
         }
      }

      int_2 += int_3 * 5;
      int_2 += (int_5 + int_6 + int_4 + int_7 + int_9) * 2;
      int_2 = int_2 + int_8 + int_10;
      int_11 = buffer_0.position;
      int_12 = int_0 + int_3 + int_4 + int_5 + int_6 + int_7 + int_8 + int_9 + int_10;

      for (int_13 = 0; int_13 < int_12; int_13++) {
         buffer_0.readVarInt();
      }

      int_2 += buffer_0.position - int_11;
      int_13 = buffer_0.position;
      int int_14 = 0;
      int int_15 = 0;
      int int_16 = 0;
      int int_17 = 0;
      int int_18 = 0;
      int int_19 = 0;
      int int_20 = 0;
      int int_21 = 0;
      int int_22 = 0;
      int int_23 = 0;
      int int_24 = 0;
      int int_25 = 0;
      int int_26 = 0;

      int int_27;
      for (int_27 = 0; int_27 < int_4; int_27++) {
         int_26 = int_26 + buffer_0.getUnsignedByte() & 0x7F;
         if (int_26 != 0 && int_26 != 32) {
            if (int_26 == 1) {
               ++int_14;
            } else if (int_26 == 33) {
               ++int_15;
            } else if (int_26 == 7) {
               ++int_16;
            } else if (int_26 == 39) {
               ++int_17;
            } else if (int_26 == 10) {
               ++int_18;
            } else if (int_26 == 42) {
               ++int_19;
            } else if (int_26 == 99) {
               ++int_20;
            } else if (int_26 == 98) {
               ++int_21;
            } else if (int_26 == 101) {
               ++int_22;
            } else if (int_26 == 100) {
               ++int_23;
            } else if (int_26 != 64 && int_26 != 65 && int_26 != 120 && int_26 != 121 && int_26 != 123) {
               ++int_25;
            } else {
               ++int_24;
            }
         } else {
            ++int_10;
         }
      }

      int_27 = 0;
      int int_28 = buffer_0.position;
      buffer_0.position += int_24;
      int int_29 = buffer_0.position;
      buffer_0.position += int_9;
      int int_30 = buffer_0.position;
      buffer_0.position += int_8;
      int int_31 = buffer_0.position;
      buffer_0.position += int_7;
      int int_32 = buffer_0.position;
      buffer_0.position += int_14;
      int int_33 = buffer_0.position;
      buffer_0.position += int_16;
      int int_34 = buffer_0.position;
      buffer_0.position += int_18;
      int int_35 = buffer_0.position;
      buffer_0.position += int_5 + int_6 + int_9;
      int int_36 = buffer_0.position;
      buffer_0.position += int_5;
      int int_37 = buffer_0.position;
      buffer_0.position += int_25;
      int int_38 = buffer_0.position;
      buffer_0.position += int_6;
      int int_39 = buffer_0.position;
      buffer_0.position += int_15;
      int int_40 = buffer_0.position;
      buffer_0.position += int_17;
      int int_41 = buffer_0.position;
      buffer_0.position += int_19;
      int int_42 = buffer_0.position;
      buffer_0.position += int_10;
      int int_43 = buffer_0.position;
      buffer_0.position += int_7;
      int int_44 = buffer_0.position;
      buffer_0.position += int_20;
      int int_45 = buffer_0.position;
      buffer_0.position += int_21;
      int int_46 = buffer_0.position;
      buffer_0.position += int_22;
      int int_47 = buffer_0.position;
      buffer_0.position += int_23;
      int int_48 = buffer_0.position;
      buffer_0.position += int_3 * 3;
      this.aByteArray17 = new byte[int_2];
      Buffer buffer_1 = new Buffer(this.aByteArray17);
      buffer_1.putInt(1297377380);
      buffer_1.putInt(6);
      buffer_1.putShort(int_0 > 1 ? 1 : 0);
      buffer_1.putShort(int_0);
      buffer_1.putShort(int_1);
      buffer_0.position = int_11;
      int int_49 = 0;
      int int_50 = 0;
      int int_51 = 0;
      int int_52 = 0;
      int int_53 = 0;
      int int_54 = 0;
      int int_55 = 0;
      int[] ints_0 = new int[128];
      int_26 = 0;

      label220:
      for (int int_56 = 0; int_56 < int_0; int_56++) {
         buffer_1.putInt(1297379947);
         buffer_1.position += 4;
         int int_57 = buffer_1.position;
         int int_58 = -1;

         while (true) {
            while (true) {
               int int_59 = buffer_0.readVarInt();
               buffer_1.putVarInt(int_59);
               int int_60 = buffer_0.buffer[int_27++] & 0xFF;
               boolean bool_0 = int_60 != int_58;
               int_58 = int_60 & 0xF;
               if (int_60 == 7) {
                  if (bool_0) {
                     buffer_1.putByte(255);
                  }

                  buffer_1.putByte(47);
                  buffer_1.putByte(0);
                  buffer_1.putLengthInt(buffer_1.position - int_57);
                  continue label220;
               }

               if (int_60 == 23) {
                  if (bool_0) {
                     buffer_1.putByte(255);
                  }

                  buffer_1.putByte(81);
                  buffer_1.putByte(3);
                  buffer_1.putByte(buffer_0.buffer[int_48++]);
                  buffer_1.putByte(buffer_0.buffer[int_48++]);
                  buffer_1.putByte(buffer_0.buffer[int_48++]);
               } else {
                  int_49 ^= int_60 >> 4;
                  if (int_58 == 0) {
                     if (bool_0) {
                        buffer_1.putByte(int_49 + 144);
                     }

                     int_50 += buffer_0.buffer[int_35++];
                     int_51 += buffer_0.buffer[int_36++];
                     buffer_1.putByte(int_50 & 0x7F);
                     buffer_1.putByte(int_51 & 0x7F);
                  } else if (int_58 == 1) {
                     if (bool_0) {
                        buffer_1.putByte(int_49 + 128);
                     }

                     int_50 += buffer_0.buffer[int_35++];
                     int_52 += buffer_0.buffer[int_38++];
                     buffer_1.putByte(int_50 & 0x7F);
                     buffer_1.putByte(int_52 & 0x7F);
                  } else if (int_58 == 2) {
                     if (bool_0) {
                        buffer_1.putByte(int_49 + 176);
                     }

                     int_26 = int_26 + buffer_0.buffer[int_13++] & 0x7F;
                     buffer_1.putByte(int_26);
                     byte byte_0;
                     if (int_26 != 0 && int_26 != 32) {
                        if (int_26 == 1) {
                           byte_0 = buffer_0.buffer[int_32++];
                        } else if (int_26 == 33) {
                           byte_0 = buffer_0.buffer[int_39++];
                        } else if (int_26 == 7) {
                           byte_0 = buffer_0.buffer[int_33++];
                        } else if (int_26 == 39) {
                           byte_0 = buffer_0.buffer[int_40++];
                        } else if (int_26 == 10) {
                           byte_0 = buffer_0.buffer[int_34++];
                        } else if (int_26 == 42) {
                           byte_0 = buffer_0.buffer[int_41++];
                        } else if (int_26 == 99) {
                           byte_0 = buffer_0.buffer[int_44++];
                        } else if (int_26 == 98) {
                           byte_0 = buffer_0.buffer[int_45++];
                        } else if (int_26 == 101) {
                           byte_0 = buffer_0.buffer[int_46++];
                        } else if (int_26 == 100) {
                           byte_0 = buffer_0.buffer[int_47++];
                        } else if (int_26 != 64 && int_26 != 65 && int_26 != 120 && int_26 != 121 && int_26 != 123) {
                           byte_0 = buffer_0.buffer[int_37++];
                        } else {
                           byte_0 = buffer_0.buffer[int_28++];
                        }
                     } else {
                        byte_0 = buffer_0.buffer[int_42++];
                     }

                     int int_61 = byte_0 + ints_0[int_26];
                     ints_0[int_26] = int_61;
                     buffer_1.putByte(int_61 & 0x7F);
                  } else if (int_58 == 3) {
                     if (bool_0) {
                        buffer_1.putByte(int_49 + 224);
                     }

                     int_53 += buffer_0.buffer[int_43++];
                     int_53 += buffer_0.buffer[int_31++] << 7;
                     buffer_1.putByte(int_53 & 0x7F);
                     buffer_1.putByte(int_53 >> 7 & 0x7F);
                  } else if (int_58 == 4) {
                     if (bool_0) {
                        buffer_1.putByte(int_49 + 208);
                     }

                     int_54 += buffer_0.buffer[int_30++];
                     buffer_1.putByte(int_54 & 0x7F);
                  } else if (int_58 == 5) {
                     if (bool_0) {
                        buffer_1.putByte(int_49 + 160);
                     }

                     int_50 += buffer_0.buffer[int_35++];
                     int_55 += buffer_0.buffer[int_29++];
                     buffer_1.putByte(int_50 & 0x7F);
                     buffer_1.putByte(int_55 & 0x7F);
                  } else {
                     if (int_58 != 6) {
                        throw new RuntimeException();
                     }

                     if (bool_0) {
                        buffer_1.putByte(int_49 + 192);
                     }

                     buffer_1.putByte(buffer_0.buffer[int_42++]);
                  }
               }
            }
         }
      }

   }

   void method739() {
      if (this.aHashTable7 == null) {
         this.aHashTable7 = new HashTable(16);
         int[] ints_0 = new int[16];
         int[] ints_1 = new int[16];
         ints_1[9] = 128;
         ints_0[9] = 128;
         Class82 class82_0 = new Class82(this.aByteArray17);
         int int_0 = class82_0.method483();

         int int_1;
         for (int_1 = 0; int_1 < int_0; int_1++) {
            class82_0.method481(int_1);
            class82_0.method485(int_1);
            class82_0.method489(int_1);
         }

         label53:
         do {
            while (true) {
               int_1 = class82_0.method482();
               int int_2 = class82_0.anIntArray43[int_1];

               while (int_2 == class82_0.anIntArray43[int_1]) {
                  class82_0.method481(int_1);
                  int int_3 = class82_0.method484(int_1);
                  if (int_3 == 1) {
                     class82_0.method488();
                     class82_0.method489(int_1);
                     continue label53;
                  }

                  int int_4 = int_3 & 0xF0;
                  int int_5;
                  int int_6;
                  int int_7;
                  if (int_4 == 176) {
                     int_5 = int_3 & 0xF;
                     int_6 = int_3 >> 8 & 0x7F;
                     int_7 = int_3 >> 16 & 0x7F;
                     if (int_6 == 0) {
                        ints_0[int_5] = (int_7 << 14) + (ints_0[int_5] & 0xFFE03FFF);
                     }

                     if (int_6 == 32) {
                        ints_0[int_5] = (ints_0[int_5] & 0xFFFFC07F) + (int_7 << 7);
                     }
                  }

                  if (int_4 == 192) {
                     int_5 = int_3 & 0xF;
                     int_6 = int_3 >> 8 & 0x7F;
                     ints_1[int_5] = int_6 + ints_0[int_5];
                  }

                  if (int_4 == 144) {
                     int_5 = int_3 & 0xF;
                     int_6 = int_3 >> 8 & 0x7F;
                     int_7 = int_3 >> 16 & 0x7F;
                     if (int_7 > 0) {
                        int int_8 = ints_1[int_5];
                        Node_Sub3 node_sub3_0 = (Node_Sub3) this.aHashTable7.get((long)int_8);
                        if (node_sub3_0 == null) {
                           node_sub3_0 = new Node_Sub3(new byte[128]);
                           this.aHashTable7.put(node_sub3_0, (long)int_8);
                        }

                        node_sub3_0.aByteArray13[int_6] = 1;
                     }
                  }

                  class82_0.method485(int_1);
                  class82_0.method489(int_1);
               }
            }
         } while (!class82_0.method490());

      }
   }

   void method740() {
      this.aHashTable7 = null;
   }

   public static Track1 getMusicFile(IndexDataBase indexdatabase_0, int int_0, int int_1) {
      byte[] bytes_0 = indexdatabase_0.getConfigData(int_0, int_1);
      return bytes_0 == null ? null : new Track1(new Buffer(bytes_0));
   }

}
