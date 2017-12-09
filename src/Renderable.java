import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;

public abstract class Renderable extends CacheableNode {

   public int modelHeight;

   protected Renderable() {
      this.modelHeight = 1000;
   }

   protected Model getModel() {
      return null;
   }

   void draw(int int_0, int int_1, int yCurveCosine, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8) {
      Model model = this.getModel();
      if (model != null) {
         this.modelHeight = model.modelHeight;
         model.draw(int_0, int_1, yCurveCosine, int_3, int_4, int_5, int_6, int_7, int_8);
      }
   }

   protected static int method744() {
      int int_0 = 0;
      if (CombatInfoListHolder.aGarbageCollectorMXBean1 == null || !CombatInfoListHolder.aGarbageCollectorMXBean1.isValid()) {
         try {
            Iterator iterator_0 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

            while (iterator_0.hasNext()) {
               GarbageCollectorMXBean garbagecollectormxbean_0 = (GarbageCollectorMXBean) iterator_0.next();
               if (garbagecollectormxbean_0.isValid()) {
                  CombatInfoListHolder.aGarbageCollectorMXBean1 = garbagecollectormxbean_0;
                  GameEngine.aLong28 = -1L;
                  GameEngine.aLong27 = -1L;
               }
            }
         } catch (Throwable throwable_0) {
            ;
         }
      }

      if (CombatInfoListHolder.aGarbageCollectorMXBean1 != null) {
         long long_0 = Class97.currentTimeMs();
         long long_1 = CombatInfoListHolder.aGarbageCollectorMXBean1.getCollectionTime();
         if (GameEngine.aLong27 != -1L) {
            long long_2 = long_1 - GameEngine.aLong27;
            long long_3 = long_0 - GameEngine.aLong28;
            if (long_3 != 0L) {
               int_0 = (int)(100L * long_2 / long_3);
            }
         }

         GameEngine.aLong27 = long_1;
         GameEngine.aLong28 = long_0;
      }

      return int_0;
   }

}
