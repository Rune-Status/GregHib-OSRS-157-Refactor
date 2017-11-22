public class MachineInfo extends Node {

   String aString21;
   int[] anIntArray80;
   int osType;
   String aString22;
   boolean os64Bit;
   int osVersionType;
   String aString23;
   int javaVendorType;
   int javaVersionMajor;
   String aString24;
   int javaVersionMinor;
   String aString25;
   int javaVersionPatch;
   boolean aBool55;
   String aString26;
   int maxMemoryMB;
   int anInt373;
   int anInt374;
   int anInt375;
   int anInt376;
   int anInt377;
   int anInt378;
   int anInt379;
   int anInt380;

   public MachineInfo(boolean bool_0) {
      this.anIntArray80 = new int[3];
      if (Class31.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if (Class31.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if (Class31.osNameLC.startsWith("linux")) {
         this.osType = 3;
      } else {
         this.osType = 4;
      }

      String string_0;
      try {
         string_0 = System.getProperty("os.arch").toLowerCase();
      } catch (Exception exception_0) {
         string_0 = "";
      }

      String string_1;
      try {
         string_1 = System.getProperty("os.version").toLowerCase();
      } catch (Exception exception_1) {
         string_1 = "";
      }

      String string_2 = "Unknown";
      String string_3 = "1.1";

      try {
         string_2 = System.getProperty("java.vendor");
         string_3 = System.getProperty("java.version");
      } catch (Exception exception_2) {
         ;
      }

      if (!string_0.startsWith("amd64") && !string_0.startsWith("x86_64")) {
         this.os64Bit = false;
      } else {
         this.os64Bit = true;
      }

      if (this.osType == 1) {
         if (string_1.indexOf("4.0") != -1) {
            this.osVersionType = 1;
         } else if (string_1.indexOf("4.1") != -1) {
            this.osVersionType = 2;
         } else if (string_1.indexOf("4.9") != -1) {
            this.osVersionType = 3;
         } else if (string_1.indexOf("5.0") != -1) {
            this.osVersionType = 4;
         } else if (string_1.indexOf("5.1") != -1) {
            this.osVersionType = 5;
         } else if (string_1.indexOf("5.2") != -1) {
            this.osVersionType = 8;
         } else if (string_1.indexOf("6.0") != -1) {
            this.osVersionType = 6;
         } else if (string_1.indexOf("6.1") != -1) {
            this.osVersionType = 7;
         } else if (string_1.indexOf("6.2") != -1) {
            this.osVersionType = 9;
         } else if (string_1.indexOf("6.3") != -1) {
            this.osVersionType = 10;
         } else if (string_1.indexOf("10.0") != -1) {
            this.osVersionType = 11;
         }
      } else if (this.osType == 2) {
         if (string_1.indexOf("10.4") != -1) {
            this.osVersionType = 20;
         } else if (string_1.indexOf("10.5") != -1) {
            this.osVersionType = 21;
         } else if (string_1.indexOf("10.6") != -1) {
            this.osVersionType = 22;
         } else if (string_1.indexOf("10.7") != -1) {
            this.osVersionType = 23;
         } else if (string_1.indexOf("10.8") != -1) {
            this.osVersionType = 24;
         } else if (string_1.indexOf("10.9") != -1) {
            this.osVersionType = 25;
         } else if (string_1.indexOf("10.10") != -1) {
            this.osVersionType = 26;
         } else if (string_1.indexOf("10.11") != -1) {
            this.osVersionType = 27;
         }
      }

      if (string_2.toLowerCase().indexOf("sun") != -1) {
         this.javaVendorType = 1;
      } else if (string_2.toLowerCase().indexOf("microsoft") != -1) {
         this.javaVendorType = 2;
      } else if (string_2.toLowerCase().indexOf("apple") != -1) {
         this.javaVendorType = 3;
      } else if (string_2.toLowerCase().indexOf("oracle") != -1) {
         this.javaVendorType = 5;
      } else {
         this.javaVendorType = 4;
      }

      int int_0 = 2;
      int int_1 = 0;

      char char_0;
      try {
         while (int_0 < string_3.length()) {
            char_0 = string_3.charAt(int_0);
            if (char_0 < 48 || char_0 > 57) {
               break;
            }

            int_1 = char_0 - 48 + int_1 * 10;
            ++int_0;
         }
      } catch (Exception exception_3) {
         ;
      }

      this.javaVersionMajor = int_1;
      int_0 = string_3.indexOf(46, 2) + 1;
      int_1 = 0;

      try {
         while (int_0 < string_3.length()) {
            char_0 = string_3.charAt(int_0);
            if (char_0 < 48 || char_0 > 57) {
               break;
            }

            int_1 = char_0 - 48 + int_1 * 10;
            ++int_0;
         }
      } catch (Exception exception_4) {
         ;
      }

      this.javaVersionMinor = int_1;
      int_0 = string_3.indexOf(95, 4) + 1;
      int_1 = 0;

      try {
         while (int_0 < string_3.length()) {
            char_0 = string_3.charAt(int_0);
            if (char_0 < 48 || char_0 > 57) {
               break;
            }

            int_1 = char_0 - 48 + int_1 * 10;
            ++int_0;
         }
      } catch (Exception exception_5) {
         ;
      }

      this.javaVersionPatch = int_1;
      this.aBool55 = false;
      this.maxMemoryMB = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if (this.javaVersionMajor > 3) {
         this.anInt373 = Runtime.getRuntime().availableProcessors();
      } else {
         this.anInt373 = 0;
      }

      this.anInt374 = 0;
      if (this.aString21 == null) {
         this.aString21 = "";
      }

      if (this.aString22 == null) {
         this.aString22 = "";
      }

      if (this.aString23 == null) {
         this.aString23 = "";
      }

      if (this.aString24 == null) {
         this.aString24 = "";
      }

      if (this.aString25 == null) {
         this.aString25 = "";
      }

      if (this.aString26 == null) {
         this.aString26 = "";
      }

      this.method696();
   }

   void method696() {
      if (this.aString21.length() > 40) {
         this.aString21 = this.aString21.substring(0, 40);
      }

      if (this.aString22.length() > 40) {
         this.aString22 = this.aString22.substring(0, 40);
      }

      if (this.aString23.length() > 10) {
         this.aString23 = this.aString23.substring(0, 10);
      }

      if (this.aString24.length() > 10) {
         this.aString24 = this.aString24.substring(0, 10);
      }

   }

   public int method697() {
      byte byte_0 = 38;
      int int_0 = byte_0 + Class47.method308(this.aString21);
      int_0 += Class47.method308(this.aString22);
      int_0 += Class47.method308(this.aString23);
      int_0 += Class47.method308(this.aString24);
      int_0 += Class47.method308(this.aString25);
      int_0 += Class47.method308(this.aString26);
      return int_0;
   }

   public void method698(Buffer buffer_0) {
      buffer_0.putByte(6);
      buffer_0.putByte(this.osType);
      buffer_0.putByte(this.os64Bit ? 1 : 0);
      buffer_0.putByte(this.osVersionType);
      buffer_0.putByte(this.javaVendorType);
      buffer_0.putByte(this.javaVersionMajor);
      buffer_0.putByte(this.javaVersionMinor);
      buffer_0.putByte(this.javaVersionPatch);
      buffer_0.putByte(this.aBool55 ? 1 : 0);
      buffer_0.putShort(this.maxMemoryMB);
      buffer_0.putByte(this.anInt373);
      buffer_0.put24bitInt(this.anInt374);
      buffer_0.putShort(this.anInt375);
      buffer_0.putJagString(this.aString21);
      buffer_0.putJagString(this.aString22);
      buffer_0.putJagString(this.aString23);
      buffer_0.putJagString(this.aString24);
      buffer_0.putByte(this.anInt376);
      buffer_0.putShort(this.anInt377);
      buffer_0.putJagString(this.aString25);
      buffer_0.putJagString(this.aString26);
      buffer_0.putByte(this.anInt378);
      buffer_0.putByte(this.anInt379);

      for (int int_0 = 0; int_0 < this.anIntArray80.length; int_0++) {
         buffer_0.putInt(this.anIntArray80[int_0]);
      }

      buffer_0.putInt(this.anInt380);
   }

}
