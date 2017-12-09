import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.net.URL;

public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {

   static volatile boolean focused;
   static Image anImage1;
   static GameEngine shell;
   static boolean aBool77;
   static int shellCount;
   static long aLong26;
   static int anInt580;
   protected static long[] aLongArray2;
   static int anInt581;
   static int anInt582;
   protected static Timer timer;
   protected static Signlink taskManager;
   protected static long[] aLongArray3;
   static int anInt583;
   protected static int FPS;
   static int anInt584;
   static long aLong27;
   static long aLong28;
   static BuildType aBuildType1;
   static int selectedItemIndex;
    static java.awt.Font aFont4;
    Clipboard aClipboard1;
   final EventQueue anEventQueue1;
   boolean aBool78;
   int anInt585;
   Class8 aClass8_1;
   int anInt586;
   boolean aBool79;
   java.awt.Frame aFrame1;
   Canvas canvas;
   int anInt587;
   int anInt588;
   protected int anInt589;
   volatile boolean aBool80;
   int anInt590;
   protected int anInt591;
   int anInt592;
   volatile long aLong29;
   volatile boolean aBool81;

   static {
      shell = null;
      shellCount = 0;
      aLong26 = 0L;
      aBool77 = false;
      anInt580 = 20;
      anInt581 = 1;
      FPS = 0;
      aLongArray3 = new long[32];
      aLongArray2 = new long[32];
      anInt584 = 500;
      focused = true;
      aLong27 = -1L;
      aLong28 = -1L;
   }

   protected GameEngine() {
      this.aBool79 = false;
      this.anInt586 = 0;
      this.anInt587 = 0;
      this.aBool80 = true;
      this.aBool78 = false;
      this.aBool81 = false;
      this.aLong29 = 0L;
      EventQueue eventqueue_0 = null;

      try {
         eventqueue_0 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable throwable_0) {
         ;
      }

      this.anEventQueue1 = eventqueue_0;
      Class11 class11_0 = new Class11();
      AbstractSoundSystem.anInterface2_1 = class11_0;
   }

   public synchronized void paint(Graphics graphics_0) {
      if (this == shell && !aBool77) {
         this.aBool80 = true;
         if (Class97.currentTimeMs() - this.aLong29 > 1000L) {
            Rectangle rectangle_0 = graphics_0.getClipBounds();
            if (rectangle_0 == null || rectangle_0.width >= Tile.canvasWidth && rectangle_0.height >= Class29.canvasHeight) {
               this.aBool81 = true;
            }
         }

      }
   }

   protected boolean isValidHost() {
      String string_0 = this.getDocumentBase().getHost().toLowerCase();
      if (!string_0.equals("jagex.com") && !string_0.endsWith(".jagex.com")) {
         if (!string_0.equals("runescape.com") && !string_0.endsWith(".runescape.com")) {
            if (string_0.endsWith("127.0.0.1")) {
               return true;
            } else {
               while (string_0.length() > 0 && string_0.charAt(string_0.length() - 1) >= 48 && string_0.charAt(string_0.length() - 1) <= 57) {
                  string_0 = string_0.substring(0, string_0.length() - 1);
               }

               if (string_0.endsWith("192.168.1.")) {
                  return true;
               } else {
                  this.error("invalidhost");
                  return false;
               }
            }
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   public void destroy() {
      if (this == shell && !aBool77) {
         aLong26 = Class97.currentTimeMs();
         Class19.method204(5000L);
         this.method1071();
      }
   }

   Class110 method1068() {
      Container container_0 = this.container();
      int int_0 = Math.max(container_0.getWidth(), this.anInt590);
      int int_1 = Math.max(container_0.getHeight(), this.anInt592);
      if (this.aFrame1 != null) {
         Insets insets_0 = this.aFrame1.getInsets();
         int_0 -= insets_0.right + insets_0.left;
         int_1 -= insets_0.top + insets_0.bottom;
      }

      return new Class110(int_0, int_1);
   }

   Container container() {
      return (Container) (this.aFrame1 != null ? this.aFrame1 : this) ;
   }

   protected void error(String string_0) {
      if (!this.aBool79) {
         this.aBool79 = true;
         System.out.println("error_game_" + string_0);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + string_0 + ".ws"), "_self");
         } catch (Exception exception_0) {
            ;
         }

      }
   }

   void method1069() {
      this.aBool78 = true;
   }

   synchronized void method1070() {
      Container container_0 = this.container();
      if (this.canvas != null) {
         this.canvas.removeFocusListener(this);
         container_0.remove(this.canvas);
      }

      Tile.canvasWidth = Math.max(container_0.getWidth(), this.anInt590);
      Class29.canvasHeight = Math.max(container_0.getHeight(), this.anInt592);
      Insets insets_0;
      if (this.aFrame1 != null) {
         insets_0 = this.aFrame1.getInsets();
         Tile.canvasWidth -= insets_0.right + insets_0.left;
         Class29.canvasHeight -= insets_0.top + insets_0.bottom;
      }

      this.canvas = new RSCanvas(this);
      container_0.add(this.canvas);
      this.canvas.setSize(Tile.canvasWidth, Class29.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if (container_0 == this.aFrame1) {
         insets_0 = this.aFrame1.getInsets();
         this.canvas.setLocation(insets_0.left + this.anInt586, this.anInt587 + insets_0.top);
      } else {
         this.canvas.setLocation(this.anInt586, this.anInt587);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.aBool80 = true;
      if (Class68_Sub1.aBufferProvider1 != null && Tile.canvasWidth == Class68_Sub1.aBufferProvider1.width && Class29.canvasHeight == Class68_Sub1.aBufferProvider1.height) {
         ((MainBufferProvider) Class68_Sub1.aBufferProvider1).method625(this.canvas);
         Class68_Sub1.aBufferProvider1.method499(0, 0);
      } else {
         Class68_Sub1.aBufferProvider1 = new MainBufferProvider(Tile.canvasWidth, Class29.canvasHeight, this.canvas);
      }

      this.aBool81 = false;
      this.aLong29 = Class97.currentTimeMs();
   }

   synchronized void method1071() {
      if (!aBool77) {
         aBool77 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception exception_0) {
            ;
         }

         try {
            this.method1072();
         } catch (Exception exception_1) {
            ;
         }

         if (this.aFrame1 != null) {
            try {
               System.exit(0);
            } catch (Throwable throwable_0) {
               ;
            }
         }

         if (taskManager != null) {
            try {
               taskManager.join();
            } catch (Exception exception_2) {
               ;
            }
         }

         this.method1075();
      }
   }

   protected abstract void method1072();

   protected abstract void method1073();

   void method1074() {
      Container container_0 = this.container();
      if (container_0 != null) {
         Class110 class110_0 = this.method1068();
         this.anInt589 = Math.max(class110_0.anInt212, this.anInt590);
         this.anInt591 = Math.max(class110_0.anInt213, this.anInt592);
         if (this.anInt589 <= 0) {
            this.anInt589 = 1;
         }

         if (this.anInt591 <= 0) {
            this.anInt591 = 1;
         }

         Tile.canvasWidth = Math.min(this.anInt589, this.anInt585);
         Class29.canvasHeight = Math.min(this.anInt591, this.anInt588);
         this.anInt586 = (this.anInt589 - Tile.canvasWidth) / 2;
         this.anInt587 = 0;
         this.canvas.setSize(Tile.canvasWidth, Class29.canvasHeight);
         Class68_Sub1.aBufferProvider1 = new MainBufferProvider(Tile.canvasWidth, Class29.canvasHeight, this.canvas);
         if (container_0 == this.aFrame1) {
            Insets insets_0 = this.aFrame1.getInsets();
            this.canvas.setLocation(insets_0.left + this.anInt586, this.anInt587 + insets_0.top);
         } else {
            this.canvas.setLocation(this.anInt586, this.anInt587);
         }

         this.aBool80 = true;
         this.method1085();
      }
   }

   protected abstract void method1075();

   protected void method1076() {
      anImage1 = null;
      aFont4 = null;
      Class93.aFontMetrics1 = null;
   }

   void method1077() {
      long long_0 = Class97.currentTimeMs();
      long long_1 = aLongArray2[anInt582];
      aLongArray2[anInt582] = long_0;
      anInt582 = anInt582 + 1 & 0x1F;
      if (long_1 != 0L && long_0 > long_1) {
         ;
      }

      synchronized(this) {
         Class12.aBool3 = focused;
      }

      this.packetHandler();
   }

   protected abstract void packetHandler();

   protected void drawLoadingScreen(int int_0, String string_0, boolean bool_0) {
      try {
         Graphics graphics_0 = this.canvas.getGraphics();
         if (aFont4 == null) {
            aFont4 = new java.awt.Font("Helvetica", 1, 13);
            Class93.aFontMetrics1 = this.canvas.getFontMetrics(aFont4);
         }

         if (bool_0) {
            graphics_0.setColor(Color.black);
            graphics_0.fillRect(0, 0, Tile.canvasWidth, Class29.canvasHeight);
         }

         Color color_0 = new Color(140, 17, 17);

         try {
            if (anImage1 == null) {
               anImage1 = this.canvas.createImage(304, 34);
            }

            Graphics graphics_1 = anImage1.getGraphics();
            graphics_1.setColor(color_0);
            graphics_1.drawRect(0, 0, 303, 33);
            graphics_1.fillRect(2, 2, int_0 * 3, 30);
            graphics_1.setColor(Color.black);
            graphics_1.drawRect(1, 1, 301, 31);
            graphics_1.fillRect(int_0 * 3 + 2, 2, 300 - int_0 * 3, 30);
            graphics_1.setFont(aFont4);
            graphics_1.setColor(Color.white);
            graphics_1.drawString(string_0, (304 - Class93.aFontMetrics1.stringWidth(string_0)) / 2, 22);
            graphics_0.drawImage(anImage1, Tile.canvasWidth / 2 - 152, Class29.canvasHeight / 2 - 18, (ImageObserver) null);
         } catch (Exception exception_1) {
            int int_1 = Tile.canvasWidth / 2 - 152;
            int int_2 = Class29.canvasHeight / 2 - 18;
            graphics_0.setColor(color_0);
            graphics_0.drawRect(int_1, int_2, 303, 33);
            graphics_0.fillRect(int_1 + 2, int_2 + 2, int_0 * 3, 30);
            graphics_0.setColor(Color.black);
            graphics_0.drawRect(int_1 + 1, int_2 + 1, 301, 31);
            graphics_0.fillRect(int_0 * 3 + int_1 + 2, int_2 + 2, 300 - int_0 * 3, 30);
            graphics_0.setFont(aFont4);
            graphics_0.setColor(Color.white);
            graphics_0.drawString(string_0, int_1 + (304 - Class93.aFontMetrics1.stringWidth(string_0)) / 2, int_2 + 22);
         }
      } catch (Exception exception_0) {
         this.canvas.repaint();
      }

   }

   void method1078() {
      Container container_0 = this.container();
      long long_0 = Class97.currentTimeMs();
      long long_1 = aLongArray3[anInt583];
      aLongArray3[anInt583] = long_0;
      anInt583 = anInt583 + 1 & 0x1F;
      if (long_1 != 0L && long_0 > long_1) {
         int int_0 = (int)(long_0 - long_1);
         FPS = ((int_0 >> 1) + 32000) / int_0;
      }

      if (++anInt584 - 1 > 50) {
         anInt584 -= 50;
         this.aBool80 = true;
         this.canvas.setSize(Tile.canvasWidth, Class29.canvasHeight);
         this.canvas.setVisible(true);
         if (container_0 == this.aFrame1) {
            Insets insets_0 = this.aFrame1.getInsets();
            this.canvas.setLocation(insets_0.left + this.anInt586, insets_0.top + this.anInt587);
         } else {
            this.canvas.setLocation(this.anInt586, this.anInt587);
         }
      }

      if (this.aBool81) {
         this.method1086();
      }

      this.method1087();
      this.method1088(this.aBool80);
      if (this.aBool80) {
         this.method1089();
      }

      this.aBool80 = false;
   }

   void method1079(Object object_0) {
      if (this.anEventQueue1 != null) {
         for (int int_0 = 0; int_0 < 50 && this.anEventQueue1.peekEvent() != null; int_0++) {
            Class19.method204(1L);
         }

         if (object_0 != null) {
            this.anEventQueue1.postEvent(new ActionEvent(object_0, 1001, "dummy"));
         }

      }
   }

   protected void method1080() {
      if (Signlink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         KeyFocusListener.anIntArray28[186] = 57;
         KeyFocusListener.anIntArray28[187] = 27;
         KeyFocusListener.anIntArray28[188] = 71;
         KeyFocusListener.anIntArray28[189] = 26;
         KeyFocusListener.anIntArray28[190] = 72;
         KeyFocusListener.anIntArray28[191] = 73;
         KeyFocusListener.anIntArray28[192] = 58;
         KeyFocusListener.anIntArray28[219] = 42;
         KeyFocusListener.anIntArray28[220] = 74;
         KeyFocusListener.anIntArray28[221] = 43;
         KeyFocusListener.anIntArray28[222] = 59;
         KeyFocusListener.anIntArray28[223] = 28;
      } else {
         KeyFocusListener.anIntArray28[44] = 71;
         KeyFocusListener.anIntArray28[45] = 26;
         KeyFocusListener.anIntArray28[46] = 72;
         KeyFocusListener.anIntArray28[47] = 73;
         KeyFocusListener.anIntArray28[59] = 57;
         KeyFocusListener.anIntArray28[61] = 27;
         KeyFocusListener.anIntArray28[91] = 42;
         KeyFocusListener.anIntArray28[92] = 74;
         KeyFocusListener.anIntArray28[93] = 43;
         KeyFocusListener.anIntArray28[192] = 28;
         KeyFocusListener.anIntArray28[222] = 58;
         KeyFocusListener.anIntArray28[520] = 59;
      }

      Canvas canvas_0 = this.canvas;
      canvas_0.setFocusTraversalKeysEnabled(false);
      canvas_0.addKeyListener(KeyFocusListener.keyboard);
      canvas_0.addFocusListener(KeyFocusListener.keyboard);
   }

   protected void method1081() {
      Class6.method97(this.canvas);
   }

   protected Interface4 method1082() {
      if (this.aClass8_1 == null) {
         this.aClass8_1 = new Class8();
         this.aClass8_1.method104(this.canvas);
      }

      return this.aClass8_1;
   }

   protected void method1083(int int_0, int int_1) {
      if (this.anInt585 != int_0 || int_1 != this.anInt588) {
         this.method1069();
      }

      this.anInt585 = int_0;
      this.anInt588 = int_1;
   }

   protected void method1084() {
      this.aClipboard1 = this.getToolkit().getSystemClipboard();
   }

   protected abstract void method1085();

   void method1086() {
      Canvas canvas_0 = this.canvas;
      canvas_0.removeKeyListener(KeyFocusListener.keyboard);
      canvas_0.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.anInt122 = -1;
      Class21.method210(this.canvas);
      if (this.aClass8_1 != null) {
         this.aClass8_1.method105(this.canvas);
      }

      this.method1070();
      Canvas canvas_1 = this.canvas;
      canvas_1.setFocusTraversalKeysEnabled(false);
      canvas_1.addKeyListener(KeyFocusListener.keyboard);
      canvas_1.addFocusListener(KeyFocusListener.keyboard);
      Class6.method97(this.canvas);
      if (this.aClass8_1 != null) {
         this.aClass8_1.method104(this.canvas);
      }

      this.method1069();
   }

   void method1087() {
      Class110 class110_0 = this.method1068();
      if (class110_0.anInt212 != this.anInt589 || class110_0.anInt213 != this.anInt591 || this.aBool78) {
         this.method1074();
         this.aBool78 = false;
      }

   }

   protected abstract void method1088(boolean var1);

   protected void initialize(int int_0, int int_1, int int_2) {
      try {
         if (shell != null) {
            ++shellCount;
            if (shellCount >= 3) {
               this.error("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         shell = this;
         Tile.canvasWidth = int_0;
         Class29.canvasHeight = int_1;
         RuntimeException_Sub1.revision = int_2;
         RuntimeException_Sub1.anApplet2 = this;
         if (taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception exception_0) {
         Class13.method168((String) null, exception_0);
         this.error("crash");
      }

   }

   void method1089() {
      int int_0 = this.anInt586;
      int int_1 = this.anInt587;
      int int_2 = this.anInt589 - Tile.canvasWidth - int_0;
      int int_3 = this.anInt591 - Class29.canvasHeight - int_1;
      if (int_0 > 0 || int_2 > 0 || int_1 > 0 || int_3 > 0) {
         try {
            Container container_0 = this.container();
            int int_4 = 0;
            int int_5 = 0;
            if (container_0 == this.aFrame1) {
               Insets insets_0 = this.aFrame1.getInsets();
               int_4 = insets_0.left;
               int_5 = insets_0.top;
            }

            Graphics graphics_0 = container_0.getGraphics();
            graphics_0.setColor(Color.black);
            if (int_0 > 0) {
               graphics_0.fillRect(int_4, int_5, int_0, this.anInt591);
            }

            if (int_1 > 0) {
               graphics_0.fillRect(int_4, int_5, this.anInt589, int_1);
            }

            if (int_2 > 0) {
               graphics_0.fillRect(int_4 + this.anInt589 - int_2, int_5, int_2, this.anInt591);
            }

            if (int_3 > 0) {
               graphics_0.fillRect(int_4, int_5 + this.anInt591 - int_3, this.anInt589, int_3);
            }
         } catch (Exception exception_0) {
            ;
         }
      }

   }

   protected void method1090(String string_0) {
      this.aClipboard1.setContents(new StringSelection(string_0), (ClipboardOwner) null);
   }

   protected boolean method1091() {
      return this.aFrame1 != null;
   }

   public void run() {
      try {
         if (Signlink.javaVendor != null) {
            String string_0 = Signlink.javaVendor.toLowerCase();
            if (string_0.indexOf("sun") != -1 || string_0.indexOf("apple") != -1) {
               String string_1 = Signlink.javaVersion;
               if (string_1.equals("1.1") || string_1.startsWith("1.1.") || string_1.equals("1.2") || string_1.startsWith("1.2.") || string_1.equals("1.3") || string_1.startsWith("1.3.") || string_1.equals("1.4") || string_1.startsWith("1.4.") || string_1.equals("1.5") || string_1.startsWith("1.5.") || string_1.equals("1.6.0")) {
                  this.error("wrongjava");
                  return;
               }

               if (string_1.startsWith("1.6.0_")) {
                  int int_0;
                  for (int_0 = 6; int_0 < string_1.length() && Actor.method954(string_1.charAt(int_0)); int_0++) {
                     ;
                  }

                  String string_2 = string_1.substring(6, int_0);
                  boolean bool_0 = KeyFocusListener.method322(string_2, 10, true);
                  if (bool_0 && Class27.method225(string_2) < 10) {
                     this.error("wrongjava");
                     return;
                  }
               }

               anInt581 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method1070();
         this.method1073();

         Object object_0;
         try {
            object_0 = new NanoTimer();
         } catch (Throwable throwable_0) {
            object_0 = new MilliTimer();
         }

         timer = (Timer) object_0;

         while (aLong26 == 0L || Class97.currentTimeMs() < aLong26) {
            AClass3.anInt326 = timer.method584(anInt580, anInt581);

            for (int int_1 = 0; int_1 < AClass3.anInt326; int_1++) {
               this.method1077();
            }

            this.method1078();
            this.method1079(this.canvas);
         }
      } catch (Exception exception_0) {
         Class13.method168((String) null, exception_0);
         this.error("crash");
      }

      this.method1071();
   }

   public void start() {
      if (this == shell && !aBool77) {
         aLong26 = 0L;
      }
   }

   public void focusLost(FocusEvent focusevent_0) {
      focused = false;
   }

   public void windowActivated(WindowEvent windowevent_0) {
   }

   public void windowClosed(WindowEvent windowevent_0) {
   }

   public void focusGained(FocusEvent focusevent_0) {
      focused = true;
      this.aBool80 = true;
   }

   public void windowDeactivated(WindowEvent windowevent_0) {
   }

   public void windowOpened(WindowEvent windowevent_0) {
   }

   public abstract void init();

   public void update(Graphics graphics_0) {
      this.paint(graphics_0);
   }

   public void windowDeiconified(WindowEvent windowevent_0) {
   }

   public void windowClosing(WindowEvent windowevent_0) {
      this.destroy();
   }

   public void stop() {
      if (this == shell && !aBool77) {
         aLong26 = Class97.currentTimeMs() + 4000L;
      }
   }

   public void windowIconified(WindowEvent windowevent_0) {
   }

   static void method1092(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6) {
      if (CombatInfoListHolder.loadWidget(int_0)) {
         ItemContainer.method675(Class91.widgets[int_0], -1, int_1, int_2, int_3, int_4, int_5, int_6);
      }
   }

}
