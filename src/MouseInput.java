import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {

   public static MouseInput mouse;
   public static volatile int anInt257;
   public static volatile int mouseIdleTicks;
   public static volatile int mouseX;
   public static volatile int anInt258;
   public static int anInt259;
   public static volatile int mouseY;
   public static int mouseEventX;
   public static volatile int anInt261;
   public static int mouseEventY;
   public static int anInt263;
   public static int anInt264;
   public static int anInt265;
   public static volatile int anInt266;
   public static volatile long aLong22;
   public static long aLong23;

   static {
      mouse = new MouseInput();
      mouseIdleTicks = 0;
      anInt257 = 0;
      mouseX = -1;
      mouseY = -1;
      anInt263 = 0;
      mouseEventX = 0;
      mouseEventY = 0;
      anInt266 = 0;
      anInt258 = 0;
      anInt261 = 0;
      aLong22 = 0L;
      anInt259 = 0;
      anInt264 = 0;
      anInt265 = 0;
      aLong23 = 0L;
   }

   int method582(MouseEvent mouseevent_0) {
      int int_0 = mouseevent_0.getButton();
      return !mouseevent_0.isAltDown() && int_0 != 2 ? (!mouseevent_0.isMetaDown() && int_0 != 3 ? 1 : 2) : 4;
   }

   public synchronized void mouseDragged(MouseEvent mouseevent_0) {
      if (mouse != null) {
         mouseIdleTicks = 0;
         mouseX = mouseevent_0.getX();
         mouseY = mouseevent_0.getY();
      }

   }

   public synchronized void mousePressed(MouseEvent mouseevent_0) {
      if (mouse != null) {
         mouseIdleTicks = 0;
         anInt258 = mouseevent_0.getX();
         anInt261 = mouseevent_0.getY();
         aLong22 = Class97.currentTimeMs();
         anInt266 = this.method582(mouseevent_0);
         if (anInt266 != 0) {
            anInt257 = anInt266;
         }
      }

      if (mouseevent_0.isPopupTrigger()) {
         mouseevent_0.consume();
      }

   }

   public synchronized void mouseReleased(MouseEvent mouseevent_0) {
      if (mouse != null) {
         mouseIdleTicks = 0;
         anInt257 = 0;
      }

      if (mouseevent_0.isPopupTrigger()) {
         mouseevent_0.consume();
      }

   }

   public synchronized void mouseEntered(MouseEvent mouseevent_0) {
      if (mouse != null) {
         mouseIdleTicks = 0;
         mouseX = mouseevent_0.getX();
         mouseY = mouseevent_0.getY();
      }

   }

   public synchronized void mouseExited(MouseEvent mouseevent_0) {
      if (mouse != null) {
         mouseIdleTicks = 0;
         mouseX = -1;
         mouseY = -1;
      }

   }

   public synchronized void mouseMoved(MouseEvent mouseevent_0) {
      if (mouse != null) {
         mouseIdleTicks = 0;
         mouseX = mouseevent_0.getX();
         mouseY = mouseevent_0.getY();
      }

   }

   public void focusGained(FocusEvent focusevent_0) {
   }

   public void mouseClicked(MouseEvent mouseevent_0) {
      if (mouseevent_0.isPopupTrigger()) {
         mouseevent_0.consume();
      }

   }

   public synchronized void focusLost(FocusEvent focusevent_0) {
      if (mouse != null) {
         anInt257 = 0;
      }

   }

   static void method583() {
      for (GraphicsObject graphicsobject_0 = (GraphicsObject) Client.graphicsObjectDeque.getFront(); graphicsobject_0 != null; graphicsobject_0 = (GraphicsObject) Client.graphicsObjectDeque.getNext()) {
         if (graphicsobject_0.level == Ignore.plane && !graphicsobject_0.finished) {
            if (Client.gameCycle >= graphicsobject_0.startCycle) {
               graphicsobject_0.method956(Client.anInt625);
               if (graphicsobject_0.finished) {
                  graphicsobject_0.unlink();
               } else {
                  Class23.sceneGraph.method377(graphicsobject_0.level, graphicsobject_0.x, graphicsobject_0.y, graphicsobject_0.height, 60, graphicsobject_0, 0, -1, false);
               }
            }
         } else {
            graphicsobject_0.unlink();
         }
      }

   }

}
