import java.io.IOException;

public final class Class2 {

   static SpritePixels[] aSpritePixelsArray1;
   static int cameraX;
   // $FF: synthetic field
   final Class14 this$0;
   int anInt18;
   int anInt19;
   int anInt20;
   int anInt21;

   Class2(Class14 class14_0) {
      this.this$0 = class14_0;
   }

   public static void sendConInfo(boolean bool_0) {
      if (Class95.aRSSocket1 != null) {
         try {
            Buffer buffer_0 = new Buffer(4);
            buffer_0.putByte(bool_0 ? 2 : 3);
            buffer_0.put24bitInt(0);
            Class95.aRSSocket1.queueForWrite(buffer_0.buffer, 0, 4);
         } catch (IOException ioexception_0) {
            try {
               Class95.aRSSocket1.close();
            } catch (Exception exception_0) {
               ;
            }

            ++Class95.anInt196;
            Class95.aRSSocket1 = null;
         }

      }
   }

   static void method77(int int_0) {
      if (int_0 != -1) {
         if (CombatInfoListHolder.loadWidget(int_0)) {
            Widget[] widgets_0 = Class91.widgets[int_0];

            for (int int_1 = 0; int_1 < widgets_0.length; int_1++) {
               Widget widget_0 = widgets_0[int_1];
               if (widget_0.anObjectArray6 != null) {
                  ScriptEvent scriptevent_0 = new ScriptEvent();
                  scriptevent_0.widget = widget_0;
                  scriptevent_0.anObjectArray22 = widget_0.anObjectArray6;
                  Class17.method200(scriptevent_0, 2000000);
               }
            }

         }
      }
   }

   static void method78(Actor actor_0) {
      if (actor_0.anInt535 == Client.gameCycle || actor_0.animation == -1 || actor_0.actionAnimationDisable != 0 || actor_0.anInt528 + 1 > ItemLayer.getAnimation(actor_0.animation).frameLenghts[actor_0.actionFrame]) {
         int int_0 = actor_0.anInt535 - actor_0.anInt534;
         int int_1 = Client.gameCycle - actor_0.anInt534;
         int int_2 = actor_0.anInt536 * 128 + actor_0.anInt513 * 64;
         int int_3 = actor_0.anInt537 * 128 + actor_0.anInt513 * 64;
         int int_4 = actor_0.anInt538 * 128 + actor_0.anInt513 * 64;
         int int_5 = actor_0.anInt539 * 128 + actor_0.anInt513 * 64;
         actor_0.x = (int_1 * int_4 + int_2 * (int_0 - int_1)) / int_0;
         actor_0.y = (int_1 * int_5 + int_3 * (int_0 - int_1)) / int_0;
      }

      actor_0.anInt512 = 0;
      actor_0.orientation = actor_0.anInt540;
      actor_0.angle = actor_0.orientation;
   }

}
