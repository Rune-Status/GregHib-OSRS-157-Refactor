public class AudioEnvelope {

   int ticks;
   int max;
   int segments;
   int form;
   int phaseIndex;
   int[] durations;
   int[] phases;
   int amplitude;
   int step;
   int start;
   int end;

   AudioEnvelope() {
      this.segments = 2;
      this.durations = new int[2];
      this.phases = new int[2];
      this.durations[0] = 0;
      this.durations[1] = 65535;
      this.phases[0] = 0;
      this.phases[1] = 65535;
   }

   void decode(Buffer buffer_0) {
      this.form = buffer_0.readUnsignedByte();
      this.start = buffer_0.readInt();
      this.end = buffer_0.readInt();
      this.decodeSegments(buffer_0);
   }

   void reset() {
      this.ticks = 0;
      this.phaseIndex = 0;
      this.step = 0;
      this.amplitude = 0;
      this.max = 0;
   }

   void decodeSegments(Buffer buffer_0) {
      this.segments = buffer_0.readUnsignedByte();
      this.durations = new int[this.segments];
      this.phases = new int[this.segments];

      for (int int_0 = 0; int_0 < this.segments; int_0++) {
         this.durations[int_0] = buffer_0.readUnsignedShort();
         this.phases[int_0] = buffer_0.readUnsignedShort();
      }

   }

   int step(int int_0) {
      if (this.max >= this.ticks) {
         this.amplitude = this.phases[this.phaseIndex++] << 15;
         if (this.phaseIndex >= this.segments) {
            this.phaseIndex = this.segments - 1;
         }

         this.ticks = (int)((double)this.durations[this.phaseIndex] / 65536.0D * (double)int_0);
         if (this.ticks > this.max) {
            this.step = ((this.phases[this.phaseIndex] << 15) - this.amplitude) / (this.ticks - this.max);
         }
      }

      this.amplitude += this.step;
      ++this.max;
      return this.amplitude - this.step >> 15;
   }

}
