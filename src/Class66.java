public final class Class66 {

   static DState state;

   static {
      state = new DState();
   }

   public static int method404(byte[] bytes_0, int int_0, byte[] bytes_1, int int_1, int int_2) {
      DState dstate_0 = state;
      synchronized(dstate_0) {
         state.strm = bytes_1;
         state.next_in = int_2;
         state.out = bytes_0;
         state.next_out = 0;
         state.anInt119 = int_0;
         state.total_in_lo32 = 0;
         state.total_in_hi32 = 0;
         state.total_out_lo32 = 0;
         state.total_out_hi32 = 0;
         method405(state);
         int_0 -= state.anInt119;
         state.strm = null;
         state.out = null;
         return int_0;
      }
   }

   static void method405(DState dstate_0) {
      boolean bool_0 = false;
      boolean bool_1 = false;
      boolean bool_2 = false;
      boolean bool_3 = false;
      boolean bool_4 = false;
      boolean bool_5 = false;
      boolean bool_6 = false;
      boolean bool_7 = false;
      boolean bool_8 = false;
      boolean bool_9 = false;
      boolean bool_10 = false;
      boolean bool_11 = false;
      boolean bool_12 = false;
      boolean bool_13 = false;
      boolean bool_14 = false;
      boolean bool_15 = false;
      boolean bool_16 = false;
      boolean bool_17 = false;
      int int_0 = 0;
      int[] ints_0 = null;
      int[] ints_1 = null;
      int[] ints_2 = null;
      dstate_0.blockSize100k = 1;
      if (Class1.tt == null) {
         Class1.tt = new int[dstate_0.blockSize100k * 100000];
      }

      boolean bool_18 = true;

      while (true) {
         while (bool_18) {
            byte byte_0 = method406(dstate_0);
            if (byte_0 == 23) {
               return;
            }

            byte_0 = method406(dstate_0);
            byte_0 = method406(dstate_0);
            byte_0 = method406(dstate_0);
            byte_0 = method406(dstate_0);
            byte_0 = method406(dstate_0);
            byte_0 = method406(dstate_0);
            byte_0 = method406(dstate_0);
            byte_0 = method406(dstate_0);
            byte_0 = method406(dstate_0);
            byte_0 = method408(dstate_0);
            if (byte_0 != 0) {
               ;
            }

            dstate_0.anInt120 = 0;
            byte_0 = method406(dstate_0);
            dstate_0.anInt120 = dstate_0.anInt120 << 8 | byte_0 & 0xFF;
            byte_0 = method406(dstate_0);
            dstate_0.anInt120 = dstate_0.anInt120 << 8 | byte_0 & 0xFF;
            byte_0 = method406(dstate_0);
            dstate_0.anInt120 = dstate_0.anInt120 << 8 | byte_0 & 0xFF;

            int int_7;
            for (int_7 = 0; int_7 < 16; int_7++) {
               byte_0 = method408(dstate_0);
               if (byte_0 == 1) {
                  dstate_0.aBoolArray2[int_7] = true;
               } else {
                  dstate_0.aBoolArray2[int_7] = false;
               }
            }

            for (int_7 = 0; int_7 < 256; int_7++) {
               dstate_0.inUse[int_7] = false;
            }

            int int_8;
            for (int_7 = 0; int_7 < 16; int_7++) {
               if (dstate_0.aBoolArray2[int_7]) {
                  for (int_8 = 0; int_8 < 16; int_8++) {
                     byte_0 = method408(dstate_0);
                     if (byte_0 == 1) {
                        dstate_0.inUse[int_8 + int_7 * 16] = true;
                     }
                  }
               }
            }

            method409(dstate_0);
            int int_10 = dstate_0.nInUse + 2;
            int int_11 = method407(3, dstate_0);
            int int_12 = method407(15, dstate_0);

            for (int_7 = 0; int_7 < int_12; int_7++) {
               int_8 = 0;

               while (true) {
                  byte_0 = method408(dstate_0);
                  if (byte_0 == 0) {
                     dstate_0.aByteArray6[int_7] = (byte)int_8;
                     break;
                  }

                  ++int_8;
               }
            }

            byte[] bytes_0 = new byte[6];

            byte byte_1;
            for (byte_1 = 0; byte_1 < int_11; bytes_0[byte_1] = byte_1++) {
               ;
            }

            for (int_7 = 0; int_7 < int_12; int_7++) {
               byte_1 = dstate_0.aByteArray6[int_7];

               byte byte_2;
               for (byte_2 = bytes_0[byte_1]; byte_1 > 0; --byte_1) {
                  bytes_0[byte_1] = bytes_0[byte_1 - 1];
               }

               bytes_0[0] = byte_2;
               dstate_0.aByteArray5[int_7] = byte_2;
            }

            int int_9;
            for (int_9 = 0; int_9 < int_11; int_9++) {
               int int_20 = method407(5, dstate_0);

               for (int_7 = 0; int_7 < int_10; int_7++) {
                  while (true) {
                     byte_0 = method408(dstate_0);
                     if (byte_0 == 0) {
                        dstate_0.aByteArrayArray2[int_9][int_7] = (byte)int_20;
                        break;
                     }

                     byte_0 = method408(dstate_0);
                     if (byte_0 == 0) {
                        ++int_20;
                     } else {
                        --int_20;
                     }
                  }
               }
            }

            for (int_9 = 0; int_9 < int_11; int_9++) {
               byte byte_3 = 32;
               byte byte_4 = 0;

               for (int_7 = 0; int_7 < int_10; int_7++) {
                  if (dstate_0.aByteArrayArray2[int_9][int_7] > byte_4) {
                     byte_4 = dstate_0.aByteArrayArray2[int_9][int_7];
                  }

                  if (dstate_0.aByteArrayArray2[int_9][int_7] < byte_3) {
                     byte_3 = dstate_0.aByteArrayArray2[int_9][int_7];
                  }
               }

               method410(dstate_0.anIntArrayArray6[int_9], dstate_0.anIntArrayArray7[int_9], dstate_0.anIntArrayArray8[int_9], dstate_0.aByteArrayArray2[int_9], byte_3, byte_4, int_10);
               dstate_0.anIntArray27[int_9] = byte_3;
            }

            int int_13 = dstate_0.nInUse + 1;
            int int_14 = -1;
            byte byte_5 = 0;

            for (int_7 = 0; int_7 <= 255; int_7++) {
               dstate_0.anIntArray24[int_7] = 0;
            }

            int int_23 = 4095;

            int int_1;
            int int_24;
            for (int_1 = 15; int_1 >= 0; --int_1) {
               for (int_24 = 15; int_24 >= 0; --int_24) {
                  dstate_0.aByteArray4[int_23] = (byte)(int_24 + int_1 * 16);
                  --int_23;
               }

               dstate_0.anIntArray26[int_1] = int_23 + 1;
            }

            int int_17 = 0;
            byte byte_7;
            if (byte_5 == 0) {
               ++int_14;
               byte_5 = 50;
               byte_7 = dstate_0.aByteArray5[int_14];
               int_0 = dstate_0.anIntArray27[byte_7];
               ints_0 = dstate_0.anIntArrayArray6[byte_7];
               ints_2 = dstate_0.anIntArrayArray8[byte_7];
               ints_1 = dstate_0.anIntArrayArray7[byte_7];
            }

            int int_15 = byte_5 - 1;
            int int_21 = int_0;

            int int_22;
            byte byte_6;
            for (int_22 = method407(int_0, dstate_0); int_22 > ints_0[int_21]; int_22 = int_22 << 1 | byte_6) {
               ++int_21;
               byte_6 = method408(dstate_0);
            }

            int int_16 = ints_2[int_22 - ints_1[int_21]];

            while (true) {
               while (int_16 != int_13) {
                  if (int_16 != 0 && int_16 != 1) {
                     int int_2 = int_16 - 1;
                     int int_3;
                     if (int_2 < 16) {
                        int_3 = dstate_0.anIntArray26[0];

                        for (byte_0 = dstate_0.aByteArray4[int_3 + int_2]; int_2 > 3; int_2 -= 4) {
                           int int_4 = int_3 + int_2;
                           dstate_0.aByteArray4[int_4] = dstate_0.aByteArray4[int_4 - 1];
                           dstate_0.aByteArray4[int_4 - 1] = dstate_0.aByteArray4[int_4 - 2];
                           dstate_0.aByteArray4[int_4 - 2] = dstate_0.aByteArray4[int_4 - 3];
                           dstate_0.aByteArray4[int_4 - 3] = dstate_0.aByteArray4[int_4 - 4];
                        }

                        while (int_2 > 0) {
                           dstate_0.aByteArray4[int_3 + int_2] = dstate_0.aByteArray4[int_3 + int_2 - 1];
                           --int_2;
                        }

                        dstate_0.aByteArray4[int_3] = byte_0;
                     } else {
                        int int_5 = int_2 / 16;
                        int int_6 = int_2 % 16;
                        int_3 = dstate_0.anIntArray26[int_5] + int_6;

                        for (byte_0 = dstate_0.aByteArray4[int_3]; int_3 > dstate_0.anIntArray26[int_5]; --int_3) {
                           dstate_0.aByteArray4[int_3] = dstate_0.aByteArray4[int_3 - 1];
                        }

                        ++dstate_0.anIntArray26[int_5];

                        while (int_5 > 0) {
                           --dstate_0.anIntArray26[int_5];
                           dstate_0.aByteArray4[dstate_0.anIntArray26[int_5]] = dstate_0.aByteArray4[dstate_0.anIntArray26[int_5 - 1] + 16 - 1];
                           --int_5;
                        }

                        --dstate_0.anIntArray26[0];
                        dstate_0.aByteArray4[dstate_0.anIntArray26[0]] = byte_0;
                        if (dstate_0.anIntArray26[0] == 0) {
                           int_23 = 4095;

                           for (int_1 = 15; int_1 >= 0; --int_1) {
                              for (int_24 = 15; int_24 >= 0; --int_24) {
                                 dstate_0.aByteArray4[int_23] = dstate_0.aByteArray4[dstate_0.anIntArray26[int_1] + int_24];
                                 --int_23;
                              }

                              dstate_0.anIntArray26[int_1] = int_23 + 1;
                           }
                        }
                     }

                     ++dstate_0.anIntArray24[dstate_0.seqToUnseq[byte_0 & 0xFF] & 0xFF];
                     Class1.tt[int_17] = dstate_0.seqToUnseq[byte_0 & 0xFF] & 0xFF;
                     ++int_17;
                     if (int_15 == 0) {
                        ++int_14;
                        int_15 = 50;
                        byte_7 = dstate_0.aByteArray5[int_14];
                        int_0 = dstate_0.anIntArray27[byte_7];
                        ints_0 = dstate_0.anIntArrayArray6[byte_7];
                        ints_2 = dstate_0.anIntArrayArray8[byte_7];
                        ints_1 = dstate_0.anIntArrayArray7[byte_7];
                     }

                     --int_15;
                     int_21 = int_0;

                     for (int_22 = method407(int_0, dstate_0); int_22 > ints_0[int_21]; int_22 = int_22 << 1 | byte_6) {
                        ++int_21;
                        byte_6 = method408(dstate_0);
                     }

                     int_16 = ints_2[int_22 - ints_1[int_21]];
                  } else {
                     int int_18 = -1;
                     int int_19 = 1;

                     do {
                        if (int_16 == 0) {
                           int_18 += int_19;
                        } else if (int_16 == 1) {
                           int_18 += int_19 * 2;
                        }

                        int_19 *= 2;
                        if (int_15 == 0) {
                           ++int_14;
                           int_15 = 50;
                           byte_7 = dstate_0.aByteArray5[int_14];
                           int_0 = dstate_0.anIntArray27[byte_7];
                           ints_0 = dstate_0.anIntArrayArray6[byte_7];
                           ints_2 = dstate_0.anIntArrayArray8[byte_7];
                           ints_1 = dstate_0.anIntArrayArray7[byte_7];
                        }

                        --int_15;
                        int_21 = int_0;

                        for (int_22 = method407(int_0, dstate_0); int_22 > ints_0[int_21]; int_22 = int_22 << 1 | byte_6) {
                           ++int_21;
                           byte_6 = method408(dstate_0);
                        }

                        int_16 = ints_2[int_22 - ints_1[int_21]];
                     } while (int_16 == 0 || int_16 == 1);

                     ++int_18;
                     byte_0 = dstate_0.seqToUnseq[dstate_0.aByteArray4[dstate_0.anIntArray26[0]] & 0xFF];

                     for (dstate_0.anIntArray24[byte_0 & 0xFF] += int_18; int_18 > 0; --int_18) {
                        Class1.tt[int_17] = byte_0 & 0xFF;
                        ++int_17;
                     }
                  }
               }

               dstate_0.out_len = 0;
               dstate_0.out_ch = 0;
               dstate_0.anIntArray25[0] = 0;

               for (int_7 = 1; int_7 <= 256; int_7++) {
                  dstate_0.anIntArray25[int_7] = dstate_0.anIntArray24[int_7 - 1];
               }

               for (int_7 = 1; int_7 <= 256; int_7++) {
                  dstate_0.anIntArray25[int_7] += dstate_0.anIntArray25[int_7 - 1];
               }

               for (int_7 = 0; int_7 < int_17; int_7++) {
                  byte_0 = (byte)(Class1.tt[int_7] & 0xFF);
                  Class1.tt[dstate_0.anIntArray25[byte_0 & 0xFF]] |= int_7 << 8;
                  ++dstate_0.anIntArray25[byte_0 & 0xFF];
               }

               dstate_0.tPos = Class1.tt[dstate_0.anInt120] >> 8;
               dstate_0.nblock_used = 0;
               dstate_0.tPos = Class1.tt[dstate_0.tPos];
               dstate_0.k0 = (byte)(dstate_0.tPos & 0xFF);
               dstate_0.tPos >>= 8;
               ++dstate_0.nblock_used;
               dstate_0.anInt121 = int_17;
               method411(dstate_0);
               if (dstate_0.anInt121 + 1 == dstate_0.nblock_used && dstate_0.out_len == 0) {
                  bool_18 = true;
                  break;
               }

               bool_18 = false;
               break;
            }
         }

         return;
      }
   }

   static byte method406(DState dstate_0) {
      return (byte)method407(8, dstate_0);
   }

   static int method407(int int_0, DState dstate_0) {
      while (dstate_0.total_in_lo32 < int_0) {
         dstate_0.total_in_hi32 = dstate_0.total_in_hi32 << 8 | dstate_0.strm[dstate_0.next_in] & 0xFF;
         dstate_0.total_in_lo32 += 8;
         ++dstate_0.next_in;
         ++dstate_0.total_out_lo32;
         if (dstate_0.total_out_lo32 == 0) {
            ;
         }
      }

      int int_1 = dstate_0.total_in_hi32 >> dstate_0.total_in_lo32 - int_0 & (1 << int_0) - 1;
      dstate_0.total_in_lo32 -= int_0;
      return int_1;
   }

   static byte method408(DState dstate_0) {
      return (byte)method407(1, dstate_0);
   }

   static void method409(DState dstate_0) {
      dstate_0.nInUse = 0;

      for (int int_0 = 0; int_0 < 256; int_0++) {
         if (dstate_0.inUse[int_0]) {
            dstate_0.seqToUnseq[dstate_0.nInUse] = (byte)int_0;
            ++dstate_0.nInUse;
         }
      }

   }

   static void method410(int[] ints_0, int[] ints_1, int[] ints_2, byte[] bytes_0, int int_0, int int_1, int int_2) {
      int int_3 = 0;

      int int_4;
      for (int_4 = int_0; int_4 <= int_1; int_4++) {
         for (int int_5 = 0; int_5 < int_2; int_5++) {
            if (int_4 == bytes_0[int_5]) {
               ints_2[int_3] = int_5;
               ++int_3;
            }
         }
      }

      for (int_4 = 0; int_4 < 23; int_4++) {
         ints_1[int_4] = 0;
      }

      for (int_4 = 0; int_4 < int_2; int_4++) {
         ++ints_1[bytes_0[int_4] + 1];
      }

      for (int_4 = 1; int_4 < 23; int_4++) {
         ints_1[int_4] += ints_1[int_4 - 1];
      }

      for (int_4 = 0; int_4 < 23; int_4++) {
         ints_0[int_4] = 0;
      }

      int int_6 = 0;

      for (int_4 = int_0; int_4 <= int_1; int_4++) {
         int_6 += ints_1[int_4 + 1] - ints_1[int_4];
         ints_0[int_4] = int_6 - 1;
         int_6 <<= 1;
      }

      for (int_4 = int_0 + 1; int_4 <= int_1; int_4++) {
         ints_1[int_4] = (ints_0[int_4 - 1] + 1 << 1) - ints_1[int_4];
      }

   }

   static void method411(DState dstate_0) {
      byte byte_0 = dstate_0.out_ch;
      int int_0 = dstate_0.out_len;
      int int_1 = dstate_0.nblock_used;
      int int_2 = dstate_0.k0;
      int[] ints_0 = Class1.tt;
      int int_3 = dstate_0.tPos;
      byte[] bytes_0 = dstate_0.out;
      int int_4 = dstate_0.next_out;
      int int_5 = dstate_0.anInt119;
      int int_6 = dstate_0.anInt121 + 1;

      label65:
      while (true) {
         if (int_0 > 0) {
            while (true) {
               if (int_5 == 0) {
                  break label65;
               }

               if (int_0 == 1) {
                  if (int_5 == 0) {
                     int_0 = 1;
                     break label65;
                  }

                  bytes_0[int_4] = byte_0;
                  ++int_4;
                  --int_5;
                  break;
               }

               bytes_0[int_4] = byte_0;
               --int_0;
               ++int_4;
               --int_5;
            }
         }

         boolean bool_0 = true;

         byte byte_1;
         while (bool_0) {
            bool_0 = false;
            if (int_1 == int_6) {
               int_0 = 0;
               break label65;
            }

            byte_0 = (byte)int_2;
            int_3 = ints_0[int_3];
            byte_1 = (byte)(int_3 & 0xFF);
            int_3 >>= 8;
            ++int_1;
            if (byte_1 != int_2) {
               int_2 = byte_1;
               if (int_5 == 0) {
                  int_0 = 1;
                  break label65;
               }

               bytes_0[int_4] = byte_0;
               ++int_4;
               --int_5;
               bool_0 = true;
            } else if (int_1 == int_6) {
               if (int_5 == 0) {
                  int_0 = 1;
                  break label65;
               }

               bytes_0[int_4] = byte_0;
               ++int_4;
               --int_5;
               bool_0 = true;
            }
         }

         int_0 = 2;
         int_3 = ints_0[int_3];
         byte_1 = (byte)(int_3 & 0xFF);
         int_3 >>= 8;
         ++int_1;
         if (int_1 != int_6) {
            if (byte_1 != int_2) {
               int_2 = byte_1;
            } else {
               int_0 = 3;
               int_3 = ints_0[int_3];
               byte_1 = (byte)(int_3 & 0xFF);
               int_3 >>= 8;
               ++int_1;
               if (int_1 != int_6) {
                  if (byte_1 != int_2) {
                     int_2 = byte_1;
                  } else {
                     int_3 = ints_0[int_3];
                     byte_1 = (byte)(int_3 & 0xFF);
                     int_3 >>= 8;
                     ++int_1;
                     int_0 = (byte_1 & 0xFF) + 4;
                     int_3 = ints_0[int_3];
                     int_2 = (byte)(int_3 & 0xFF);
                     int_3 >>= 8;
                     ++int_1;
                  }
               }
            }
         }
      }

      int int_7 = dstate_0.total_out_hi32;
      dstate_0.total_out_hi32 += int_5 - int_5;
      if (dstate_0.total_out_hi32 < int_7) {
         ;
      }

      dstate_0.out_ch = byte_0;
      dstate_0.out_len = int_0;
      dstate_0.nblock_used = int_1;
      dstate_0.k0 = int_2;
      Class1.tt = ints_0;
      dstate_0.tPos = int_3;
      dstate_0.out = bytes_0;
      dstate_0.next_out = int_4;
      dstate_0.anInt119 = int_5;
   }

}
