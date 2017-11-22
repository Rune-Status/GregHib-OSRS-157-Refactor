public class SoundTask implements Runnable {

   volatile AbstractSoundSystem[] systems;

   SoundTask() {
      this.systems = new AbstractSoundSystem[2];
   }

   public void run() {
      try {
         for (int int_0 = 0; int_0 < 2; int_0++) {
            AbstractSoundSystem abstractsoundsystem_0 = this.systems[int_0];
            if (abstractsoundsystem_0 != null) {
               abstractsoundsystem_0.method339();
            }
         }
      } catch (Exception exception_0) {
         Class13.method168((String) null, exception_0);
      }

   }

   public static boolean method320(int int_0) {
      return int_0 >= Enum4.anEnum4_1.anInt382 && int_0 <= Enum4.anEnum4_4.anInt382 || int_0 == Enum4.anEnum4_5.anInt382;
   }

}
