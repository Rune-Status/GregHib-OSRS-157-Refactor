import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public final class Class8 implements Interface4, MouseWheelListener {

   int anInt41;

   Class8() {
      this.anInt41 = 0;
   }

   void method104(Component component_0) {
      component_0.addMouseWheelListener(this);
   }

   void method105(Component component_0) {
      component_0.removeMouseWheelListener(this);
   }

   public synchronized int method4() {
      int int_0 = this.anInt41;
      this.anInt41 = 0;
      return int_0;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent mousewheelevent_0) {
      this.anInt41 += mousewheelevent_0.getWheelRotation();
   }

}
