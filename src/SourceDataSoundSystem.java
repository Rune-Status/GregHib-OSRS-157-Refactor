import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;

public class SourceDataSoundSystem extends AbstractSoundSystem {

   AudioFormat anAudioFormat1;
   int size;
   SourceDataLine source;
   byte[] bytes;

   protected void method338() {
      this.source.flush();
   }

   protected void close() {
      if (this.source != null) {
         this.source.close();
         this.source = null;
      }

   }

   protected int size() {
      return this.size - (this.source.available() >> (AbstractSoundSystem.highMemory ? 2 : 1));
   }

   protected void create(int int_0) throws LineUnavailableException {
      try {
         Info dataline$info_0 = new Info(SourceDataLine.class, this.anAudioFormat1, int_0 << (AbstractSoundSystem.highMemory ? 2 : 1));
         this.source = (SourceDataLine) AudioSystem.getLine(dataline$info_0);
         this.source.open();
         this.source.start();
         this.size = int_0;
      } catch (LineUnavailableException lineunavailableexception_0) {
         int int_1 = (int_0 >>> 1 & 0x55555555) + (int_0 & 0x55555555);
         int_1 = (int_1 >>> 2 & 0x33333333) + (int_1 & 0x33333333);
         int_1 = (int_1 >>> 4) + int_1 & 0xF0F0F0F;
         int_1 += int_1 >>> 8;
         int_1 += int_1 >>> 16;
         int int_2 = int_1 & 0xFF;
         if (int_2 != 1) {
            this.create(Class58.method389(int_0));
         } else {
            this.source = null;
            throw lineunavailableexception_0;
         }
      }
   }

   protected void write() {
      int int_0 = 256;
      if (AbstractSoundSystem.highMemory) {
         int_0 <<= 1;
      }

      for (int int_1 = 0; int_1 < int_0; int_1++) {
         int int_2 = super.samples[int_1];
         if ((int_2 + 8388608 & 0xFF000000) != 0) {
            int_2 = 0x7FFFFF ^ int_2 >> 31;
         }

         this.bytes[int_1 * 2] = (byte)(int_2 >> 8);
         this.bytes[int_1 * 2 + 1] = (byte)(int_2 >> 16);
      }

      this.source.write(this.bytes, 0, int_0 << 1);
   }

   protected void method347() {
      this.anAudioFormat1 = new AudioFormat((float)AbstractSoundSystem.sampleRate, 16, AbstractSoundSystem.highMemory ? 2 : 1, true, false);
      this.bytes = new byte[256 << (AbstractSoundSystem.highMemory ? 2 : 1)];
   }

}
