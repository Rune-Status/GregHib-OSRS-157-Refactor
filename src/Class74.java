import java.util.Calendar;
import java.util.TimeZone;

public class Class74 {

   static final String[][] aStringArrayArray1;
   static final String[] aStringArray3;
   static Calendar aCalendar2;

   static {
      aStringArrayArray1 = new String[][] {{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      aStringArray3 = new String[] {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      aCalendar2 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   static void method445(int int_0, IndexFile indexfile_0, IndexData indexdata_0) {
      byte[] bytes_0 = null;
      Deque deque_0 = Class91.aDeque1;
      synchronized(deque_0) {
         for (FileSystem filesystem_0 = (FileSystem) Class91.aDeque1.getFront(); filesystem_0 != null; filesystem_0 = (FileSystem) Class91.aDeque1.getNext()) {
            if (filesystem_0.hash == (long)int_0 && indexfile_0 == filesystem_0.index && filesystem_0.anInt341 == 0) {
               bytes_0 = filesystem_0.aByteArray12;
               break;
            }
         }
      }

      if (bytes_0 != null) {
         indexdata_0.method614(indexfile_0, int_0, bytes_0, true);
      } else {
         byte[] bytes_1 = indexfile_0.method72(int_0);
         indexdata_0.method614(indexfile_0, int_0, bytes_1, true);
      }
   }

   static void drawMenuOptions() {
      int x = CacheFile.menuX;
      int y = AClass1_Sub1.menuY;
      int width = Class93.menuWidth;
      int height = Class42.menuHeight;
      int colour = 6116423;
      Rasterizer2D.fillRect(x, y, width, height, colour);
      Rasterizer2D.fillRect(x + 1, y + 1, width - 2, 16, 0);
      Rasterizer2D.drawRectangle(x + 1, y + 18, width - 2, height - 19, 0);
      Class50.boldFont.drawString("Choose Option", x + 3, y + 14, colour, -1);
      int mouseX = MouseInput.mouseEventX;
      int mouseY = MouseInput.mouseEventY;

      for (int int_7 = 0; int_7 < Client.menuOptionCount; int_7++) {
         int textY = (Client.menuOptionCount - 1 - int_7) * 15 + y + 31;
         int textColour = 16777215;
         if (mouseX > x && mouseX < width + x && mouseY > textY - 13 && mouseY < textY + 3) {
            textColour = 16776960;
         }

         Class50.boldFont.drawString(Class38.getOptionCount(int_7), x + 3, textY, textColour, 0);
      }

      Class71.method423(CacheFile.menuX, AClass1_Sub1.menuY, Class93.menuWidth, Class42.menuHeight);
   }

   public static Widget method447(int int_0, int int_1) {
      Widget widget_0 = Client.getWidget(int_0);
      return int_1 == -1 ? widget_0 : (widget_0 != null && widget_0.children != null && int_1 < widget_0.children.length ? widget_0.children[int_1] : null);
   }

   static int method448(int int_0, Script script_0, boolean bool_0) {
      int int_1;
      int int_2;
      if (int_0 == 4000) {
         Class23.intStackSize -= 2;
         int_1 = Class39.intStack[Class23.intStackSize];
         int_2 = Class39.intStack[Class23.intStackSize + 1];
         Class39.intStack[++Class23.intStackSize - 1] = int_1 + int_2;
         return 1;
      } else if (int_0 == 4001) {
         Class23.intStackSize -= 2;
         int_1 = Class39.intStack[Class23.intStackSize];
         int_2 = Class39.intStack[Class23.intStackSize + 1];
         Class39.intStack[++Class23.intStackSize - 1] = int_1 - int_2;
         return 1;
      } else if (int_0 == 4002) {
         Class23.intStackSize -= 2;
         int_1 = Class39.intStack[Class23.intStackSize];
         int_2 = Class39.intStack[Class23.intStackSize + 1];
         Class39.intStack[++Class23.intStackSize - 1] = int_1 * int_2;
         return 1;
      } else if (int_0 == 4003) {
         Class23.intStackSize -= 2;
         int_1 = Class39.intStack[Class23.intStackSize];
         int_2 = Class39.intStack[Class23.intStackSize + 1];
         Class39.intStack[++Class23.intStackSize - 1] = int_1 / int_2;
         return 1;
      } else if (int_0 == 4004) {
         int_1 = Class39.intStack[--Class23.intStackSize];
         Class39.intStack[++Class23.intStackSize - 1] = (int)(Math.random() * (double)int_1);
         return 1;
      } else if (int_0 == 4005) {
         int_1 = Class39.intStack[--Class23.intStackSize];
         Class39.intStack[++Class23.intStackSize - 1] = (int)(Math.random() * (double)(int_1 + 1));
         return 1;
      } else if (int_0 == 4006) {
         Class23.intStackSize -= 5;
         int_1 = Class39.intStack[Class23.intStackSize];
         int_2 = Class39.intStack[Class23.intStackSize + 1];
         int int_3 = Class39.intStack[Class23.intStackSize + 2];
         int int_4 = Class39.intStack[Class23.intStackSize + 3];
         int int_5 = Class39.intStack[Class23.intStackSize + 4];
         Class39.intStack[++Class23.intStackSize - 1] = int_1 + (int_5 - int_3) * (int_2 - int_1) / (int_4 - int_3);
         return 1;
      } else if (int_0 == 4007) {
         Class23.intStackSize -= 2;
         int_1 = Class39.intStack[Class23.intStackSize];
         int_2 = Class39.intStack[Class23.intStackSize + 1];
         Class39.intStack[++Class23.intStackSize - 1] = int_1 + int_1 * int_2 / 100;
         return 1;
      } else if (int_0 == 4008) {
         Class23.intStackSize -= 2;
         int_1 = Class39.intStack[Class23.intStackSize];
         int_2 = Class39.intStack[Class23.intStackSize + 1];
         Class39.intStack[++Class23.intStackSize - 1] = int_1 | 1 << int_2;
         return 1;
      } else if (int_0 == 4009) {
         Class23.intStackSize -= 2;
         int_1 = Class39.intStack[Class23.intStackSize];
         int_2 = Class39.intStack[Class23.intStackSize + 1];
         Class39.intStack[++Class23.intStackSize - 1] = int_1 & -1 - (1 << int_2);
         return 1;
      } else if (int_0 == 4010) {
         Class23.intStackSize -= 2;
         int_1 = Class39.intStack[Class23.intStackSize];
         int_2 = Class39.intStack[Class23.intStackSize + 1];
         Class39.intStack[++Class23.intStackSize - 1] = (int_1 & 1 << int_2) != 0 ? 1 : 0;
         return 1;
      } else if (int_0 == 4011) {
         Class23.intStackSize -= 2;
         int_1 = Class39.intStack[Class23.intStackSize];
         int_2 = Class39.intStack[Class23.intStackSize + 1];
         Class39.intStack[++Class23.intStackSize - 1] = int_1 % int_2;
         return 1;
      } else if (int_0 == 4012) {
         Class23.intStackSize -= 2;
         int_1 = Class39.intStack[Class23.intStackSize];
         int_2 = Class39.intStack[Class23.intStackSize + 1];
         if (int_1 == 0) {
            Class39.intStack[++Class23.intStackSize - 1] = 0;
         } else {
            Class39.intStack[++Class23.intStackSize - 1] = (int)Math.pow((double)int_1, (double)int_2);
         }

         return 1;
      } else if (int_0 == 4013) {
         Class23.intStackSize -= 2;
         int_1 = Class39.intStack[Class23.intStackSize];
         int_2 = Class39.intStack[Class23.intStackSize + 1];
         if (int_1 == 0) {
            Class39.intStack[++Class23.intStackSize - 1] = 0;
            return 1;
         } else {
            switch(int_2) {
            case 0:
               Class39.intStack[++Class23.intStackSize - 1] = Integer.MAX_VALUE;
               break;
            case 1:
               Class39.intStack[++Class23.intStackSize - 1] = int_1;
               break;
            case 2:
               Class39.intStack[++Class23.intStackSize - 1] = (int)Math.sqrt((double)int_1);
               break;
            case 3:
               Class39.intStack[++Class23.intStackSize - 1] = (int)Math.cbrt((double)int_1);
               break;
            case 4:
               Class39.intStack[++Class23.intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)int_1));
               break;
            default:
               Class39.intStack[++Class23.intStackSize - 1] = (int)Math.pow((double)int_1, 1.0D / (double)int_2);
            }

            return 1;
         }
      } else if (int_0 == 4014) {
         Class23.intStackSize -= 2;
         int_1 = Class39.intStack[Class23.intStackSize];
         int_2 = Class39.intStack[Class23.intStackSize + 1];
         Class39.intStack[++Class23.intStackSize - 1] = int_1 & int_2;
         return 1;
      } else if (int_0 == 4015) {
         Class23.intStackSize -= 2;
         int_1 = Class39.intStack[Class23.intStackSize];
         int_2 = Class39.intStack[Class23.intStackSize + 1];
         Class39.intStack[++Class23.intStackSize - 1] = int_1 | int_2;
         return 1;
      } else if (int_0 == 4018) {
         Class23.intStackSize -= 3;
         long long_0 = (long)Class39.intStack[Class23.intStackSize];
         long long_1 = (long)Class39.intStack[Class23.intStackSize + 1];
         long long_2 = (long)Class39.intStack[Class23.intStackSize + 2];
         Class39.intStack[++Class23.intStackSize - 1] = (int)(long_2 * long_0 / long_1);
         return 1;
      } else {
         return 2;
      }
   }

}
