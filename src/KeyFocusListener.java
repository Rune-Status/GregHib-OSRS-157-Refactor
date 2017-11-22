import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class KeyFocusListener implements KeyListener, FocusListener {

   static KeyFocusListener keyboard;
   static int anInt122;
   static int[] anIntArray28;
   public static boolean[] aBoolArray3;
   static int[] anIntArray29;
   static int anInt123;
   static int anInt124;
   static char[] aCharArray1;
   static int anInt125;
   static int[] anIntArray30;
   public static int[] anIntArray31;
   public static int anInt126;
   static int anInt127;
   static volatile int keyboardIdleTicks;
   static int anInt128;

   static {
      keyboard = new KeyFocusListener();
      aBoolArray3 = new boolean[112];
      anIntArray29 = new int[128];
      anInt123 = 0;
      anInt122 = 0;
      aCharArray1 = new char[128];
      anIntArray30 = new int[128];
      anIntArray31 = new int[128];
      anInt126 = 0;
      anInt125 = 0;
      anInt124 = 0;
      anInt127 = 0;
      keyboardIdleTicks = 0;
      anIntArray28 = new int[] {-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }

   public void focusGained(FocusEvent focusevent_0) {
   }

   public synchronized void keyPressed(KeyEvent keyevent_0) {
      if (keyboard != null) {
         int int_0 = keyevent_0.getKeyCode();
         if (int_0 >= 0 && int_0 < anIntArray28.length) {
            int_0 = anIntArray28[int_0];
            if ((int_0 & 0x80) != 0) {
               int_0 = -1;
            }
         } else {
            int_0 = -1;
         }

         if (anInt122 >= 0 && int_0 >= 0) {
            anIntArray29[anInt122] = int_0;
            anInt122 = anInt122 + 1 & 0x7F;
            if (anInt123 == anInt122) {
               anInt122 = -1;
            }
         }

         int int_1;
         if (int_0 >= 0) {
            int_1 = anInt124 + 1 & 0x7F;
            if (int_1 != anInt125) {
               anIntArray30[anInt124] = int_0;
               aCharArray1[anInt124] = 0;
               anInt124 = int_1;
            }
         }

         int_1 = keyevent_0.getModifiers();
         if ((int_1 & 0xA) != 0 || int_0 == 85 || int_0 == 10) {
            keyevent_0.consume();
         }
      }

   }

   public synchronized void keyReleased(KeyEvent keyevent_0) {
      if (keyboard != null) {
         int int_0 = keyevent_0.getKeyCode();
         if (int_0 >= 0 && int_0 < anIntArray28.length) {
            int_0 = anIntArray28[int_0] & 0xFFFFFF7F;
         } else {
            int_0 = -1;
         }

         if (anInt122 >= 0 && int_0 >= 0) {
            anIntArray29[anInt122] = ~int_0;
            anInt122 = anInt122 + 1 & 0x7F;
            if (anInt122 == anInt123) {
               anInt122 = -1;
            }
         }
      }

      keyevent_0.consume();
   }

   public void keyTyped(KeyEvent keyevent_0) {
      if (keyboard != null) {
         char char_0 = keyevent_0.getKeyChar();
         if (char_0 != 0 && char_0 != 65535) {
            boolean bool_0;
            if (char_0 > 0 && char_0 < 128 || char_0 >= 160 && char_0 <= 255) {
               bool_0 = true;
            } else {
               label58: {
                  if (char_0 != 0) {
                     char[] chars_0 = Class103.aCharArray6;

                     for (int int_1 = 0; int_1 < chars_0.length; int_1++) {
                        char char_1 = chars_0[int_1];
                        if (char_1 == char_0) {
                           bool_0 = true;
                           break label58;
                        }
                     }
                  }

                  bool_0 = false;
               }
            }

            if (bool_0) {
               int int_0 = anInt124 + 1 & 0x7F;
               if (int_0 != anInt125) {
                  anIntArray30[anInt124] = -1;
                  aCharArray1[anInt124] = char_0;
                  anInt124 = int_0;
               }
            }
         }
      }

      keyevent_0.consume();
   }

   public synchronized void focusLost(FocusEvent focusevent_0) {
      if (keyboard != null) {
         anInt122 = -1;
      }

   }

   public static int method321(CharSequence charsequence_0, int int_0, int int_1, byte[] bytes_0, int int_2) {
      int int_3 = int_1 - int_0;

      for (int int_4 = 0; int_4 < int_3; int_4++) {
         char char_0 = charsequence_0.charAt(int_4 + int_0);
         if (char_0 > 0 && char_0 < 128 || char_0 >= 160 && char_0 <= 255) {
            bytes_0[int_4 + int_2] = (byte)char_0;
         } else if (char_0 == 8364) {
            bytes_0[int_4 + int_2] = -128;
         } else if (char_0 == 8218) {
            bytes_0[int_4 + int_2] = -126;
         } else if (char_0 == 402) {
            bytes_0[int_4 + int_2] = -125;
         } else if (char_0 == 8222) {
            bytes_0[int_4 + int_2] = -124;
         } else if (char_0 == 8230) {
            bytes_0[int_4 + int_2] = -123;
         } else if (char_0 == 8224) {
            bytes_0[int_4 + int_2] = -122;
         } else if (char_0 == 8225) {
            bytes_0[int_4 + int_2] = -121;
         } else if (char_0 == 710) {
            bytes_0[int_4 + int_2] = -120;
         } else if (char_0 == 8240) {
            bytes_0[int_4 + int_2] = -119;
         } else if (char_0 == 352) {
            bytes_0[int_4 + int_2] = -118;
         } else if (char_0 == 8249) {
            bytes_0[int_4 + int_2] = -117;
         } else if (char_0 == 338) {
            bytes_0[int_4 + int_2] = -116;
         } else if (char_0 == 381) {
            bytes_0[int_4 + int_2] = -114;
         } else if (char_0 == 8216) {
            bytes_0[int_4 + int_2] = -111;
         } else if (char_0 == 8217) {
            bytes_0[int_4 + int_2] = -110;
         } else if (char_0 == 8220) {
            bytes_0[int_4 + int_2] = -109;
         } else if (char_0 == 8221) {
            bytes_0[int_4 + int_2] = -108;
         } else if (char_0 == 8226) {
            bytes_0[int_4 + int_2] = -107;
         } else if (char_0 == 8211) {
            bytes_0[int_4 + int_2] = -106;
         } else if (char_0 == 8212) {
            bytes_0[int_4 + int_2] = -105;
         } else if (char_0 == 732) {
            bytes_0[int_4 + int_2] = -104;
         } else if (char_0 == 8482) {
            bytes_0[int_4 + int_2] = -103;
         } else if (char_0 == 353) {
            bytes_0[int_4 + int_2] = -102;
         } else if (char_0 == 8250) {
            bytes_0[int_4 + int_2] = -101;
         } else if (char_0 == 339) {
            bytes_0[int_4 + int_2] = -100;
         } else if (char_0 == 382) {
            bytes_0[int_4 + int_2] = -98;
         } else if (char_0 == 376) {
            bytes_0[int_4 + int_2] = -97;
         } else {
            bytes_0[int_4 + int_2] = 63;
         }
      }

      return int_3;
   }

   public static boolean method322(CharSequence charsequence_0, int int_0, boolean bool_0) {
      if (int_0 >= 2 && int_0 <= 36) {
         boolean bool_1 = false;
         boolean bool_2 = false;
         int int_1 = 0;
         int int_2 = charsequence_0.length();

         for (int int_3 = 0; int_3 < int_2; int_3++) {
            char char_0 = charsequence_0.charAt(int_3);
            if (int_3 == 0) {
               if (char_0 == 45) {
                  bool_1 = true;
                  continue;
               }

               if (char_0 == 43) {
                  continue;
               }
            }

            int int_5;
            if (char_0 >= 48 && char_0 <= 57) {
               int_5 = char_0 - 48;
            } else if (char_0 >= 65 && char_0 <= 90) {
               int_5 = char_0 - 55;
            } else {
               if (char_0 < 97 || char_0 > 122) {
                  return false;
               }

               int_5 = char_0 - 87;
            }

            if (int_5 >= int_0) {
               return false;
            }

            if (bool_1) {
               int_5 = -int_5;
            }

            int int_4 = int_1 * int_0 + int_5;
            if (int_4 / int_0 != int_1) {
               return false;
            }

            int_1 = int_4;
            bool_2 = true;
         }

         return bool_2;
      } else {
         throw new IllegalArgumentException("");
      }
   }

}
