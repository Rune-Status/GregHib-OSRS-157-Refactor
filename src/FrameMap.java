import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FrameMap extends Node {

   int id;
   int count;
   int[] types;
   int[][] list;

   FrameMap(int int_0, byte[] bytes_0) {
      this.id = int_0;
      Buffer buffer_0 = new Buffer(bytes_0);
      this.count = buffer_0.getUnsignedByte();
      this.types = new int[this.count];
      this.list = new int[this.count][];

      int int_1;
      for (int_1 = 0; int_1 < this.count; int_1++) {
         this.types[int_1] = buffer_0.getUnsignedByte();
      }

      for (int_1 = 0; int_1 < this.count; int_1++) {
         this.list[int_1] = new int[buffer_0.getUnsignedByte()];
      }

      for (int_1 = 0; int_1 < this.count; int_1++) {
         for (int int_2 = 0; int_2 < this.list[int_1].length; int_2++) {
            this.list[int_1][int_2] = buffer_0.getUnsignedByte();
         }
      }

   }

   public static AbstractSoundSystem method689(Signlink signlink_0, int int_0, int int_1) {
      if (AbstractSoundSystem.sampleRate == 0) {
         throw new IllegalStateException();
      } else if (int_0 >= 0 && int_0 < 2) {
         if (int_1 < 256) {
            int_1 = 256;
         }

         try {
            AbstractSoundSystem abstractsoundsystem_0 = AbstractSoundSystem.anInterface2_1.method3();
            abstractsoundsystem_0.samples = new int[(AbstractSoundSystem.highMemory ? 2 : 1) * 256];
            abstractsoundsystem_0.anInt137 = int_1;
            abstractsoundsystem_0.method347();
            abstractsoundsystem_0.offset = (int_1 & 0xFFFFFC00) + 1024;
            if (abstractsoundsystem_0.offset > 16384) {
               abstractsoundsystem_0.offset = 16384;
            }

            abstractsoundsystem_0.create(abstractsoundsystem_0.offset);
            if (AbstractSoundSystem.priority > 0 && AbstractSoundSystem.task == null) {
               AbstractSoundSystem.task = new SoundTask();
               AbstractSoundSystem.aScheduledExecutorService1 = Executors.newScheduledThreadPool(1);
               AbstractSoundSystem.aScheduledExecutorService1.scheduleAtFixedRate(AbstractSoundSystem.task, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if (AbstractSoundSystem.task != null) {
               if (AbstractSoundSystem.task.systems[int_0] != null) {
                  throw new IllegalArgumentException();
               }

               AbstractSoundSystem.task.systems[int_0] = abstractsoundsystem_0;
            }

            return abstractsoundsystem_0;
         } catch (Throwable throwable_0) {
            return new AbstractSoundSystem();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   static int method690(int int_0, Script script_0, boolean bool_0) {
      Widget widget_0 = bool_0 ? Class106.aWidget4 : Friend.aWidget5;
      if (int_0 == 1800) {
         Class39.intStack[++Class23.intStackSize - 1] = GraphicsObject.method957(Preferences.getWidgetConfig(widget_0));
         return 1;
      } else if (int_0 != 1801) {
         if (int_0 == 1802) {
            if (widget_0.name == null) {
               Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
            } else {
               Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = widget_0.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int int_1 = Class39.intStack[--Class23.intStackSize];
         --int_1;
         if (widget_0.actions != null && int_1 < widget_0.actions.length && widget_0.actions[int_1] != null) {
            Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = widget_0.actions[int_1];
         } else {
            Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }

   public static boolean method691(int int_0) {
      return (int_0 >> 20 & 0x1) != 0;
   }

}
