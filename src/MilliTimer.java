public class MilliTimer extends Timer {

   static String host;
   static IndexFile anIndexFile3;
   int anInt399;
   int sleepTime;
   long[] aLongArray1;
   int anInt400;
   long milliTime;
   int anInt401;

   public MilliTimer() {
      this.aLongArray1 = new long[10];
      this.anInt399 = 256;
      this.sleepTime = 1;
      this.anInt400 = 0;
      this.milliTime = Class97.currentTimeMs();

      for (int int_0 = 0; int_0 < 10; int_0++) {
         this.aLongArray1[int_0] = this.milliTime;
      }

   }

   public int method584(int int_0, int int_1) {
      int int_2 = this.anInt399;
      int int_3 = this.sleepTime;
      this.anInt399 = 300;
      this.sleepTime = 1;
      this.milliTime = Class97.currentTimeMs();
      if (this.aLongArray1[this.anInt401] == 0L) {
         this.anInt399 = int_2;
         this.sleepTime = int_3;
      } else if (this.milliTime > this.aLongArray1[this.anInt401]) {
         this.anInt399 = (int)((long)(int_0 * 2560) / (this.milliTime - this.aLongArray1[this.anInt401]));
      }

      if (this.anInt399 < 25) {
         this.anInt399 = 25;
      }

      if (this.anInt399 > 256) {
         this.anInt399 = 256;
         this.sleepTime = (int)((long)int_0 - (this.milliTime - this.aLongArray1[this.anInt401]) / 10L);
      }

      if (this.sleepTime > int_0) {
         this.sleepTime = int_0;
      }

      this.aLongArray1[this.anInt401] = this.milliTime;
      this.anInt401 = (this.anInt401 + 1) % 10;
      int int_4;
      if (this.sleepTime > 1) {
         for (int_4 = 0; int_4 < 10; int_4++) {
            if (this.aLongArray1[int_4] != 0L) {
               this.aLongArray1[int_4] += (long)this.sleepTime;
            }
         }
      }

      if (this.sleepTime < int_1) {
         this.sleepTime = int_1;
      }

      Class19.method204((long)this.sleepTime);

      for (int_4 = 0; this.anInt400 < 256; this.anInt400 += this.anInt399) {
         ++int_4;
      }

      this.anInt400 &= 0xFF;
      return int_4;
   }

   public void method585() {
      for (int int_0 = 0; int_0 < 10; int_0++) {
         this.aLongArray1[int_0] = 0L;
      }

   }

   public static int method741(int int_0, int int_1) {
      int int_2;
      if (int_1 > int_0) {
         int_2 = int_0;
         int_0 = int_1;
         int_1 = int_2;
      }

      while (int_1 != 0) {
         int_2 = int_0 % int_1;
         int_0 = int_1;
         int_1 = int_2;
      }

      return int_0;
   }

   static void method742(Widget widget_0, int int_0, int int_1, boolean bool_0) {
      int int_2 = widget_0.width;
      int int_3 = widget_0.height;
      if (widget_0.anInt271 == 0) {
         widget_0.width = widget_0.originalWidth;
      } else if (widget_0.anInt271 == 1) {
         widget_0.width = int_0 - widget_0.originalWidth;
      } else if (widget_0.anInt271 == 2) {
         widget_0.width = widget_0.originalWidth * int_0 >> 14;
      }

      if (widget_0.buttonType == 0) {
         widget_0.height = widget_0.anInt274;
      } else if (widget_0.buttonType == 1) {
         widget_0.height = int_1 - widget_0.anInt274;
      } else if (widget_0.buttonType == 2) {
         widget_0.height = int_1 * widget_0.anInt274 >> 14;
      }

      if (widget_0.anInt271 == 4) {
         widget_0.width = widget_0.height * widget_0.anInt275 / widget_0.anInt276;
      }

      if (widget_0.buttonType == 4) {
         widget_0.height = widget_0.anInt276 * widget_0.width / widget_0.anInt275;
      }

      if (Client.aBool89 && widget_0.type == 0) {
         if (widget_0.height < 5 && widget_0.width < 5) {
            widget_0.height = 5;
            widget_0.width = 5;
         } else {
            if (widget_0.height <= 0) {
               widget_0.height = 5;
            }

            if (widget_0.width <= 0) {
               widget_0.width = 5;
            }
         }
      }

      if (widget_0.contentType == 1337) {
         Client.aWidget11 = widget_0;
      }

      if (bool_0 && widget_0.anObjectArray2 != null && (int_2 != widget_0.width || int_3 != widget_0.height)) {
         ScriptEvent scriptevent_0 = new ScriptEvent();
         scriptevent_0.widget = widget_0;
         scriptevent_0.anObjectArray22 = widget_0.anObjectArray2;
         Client.aDeque7.addFront(scriptevent_0);
      }

   }

   static char method743(char char_0) {
      switch(char_0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return char_0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(char_0);
      }
   }

}
