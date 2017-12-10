public class Sequence extends CacheableNode {

   public static NodeCache skeletons;
   public static NodeCache sequences;
   public static IndexDataBase skel_ref;
   public static IndexDataBase skin_ref;
   public int precedenceAnimating;
   public int[] frameIDs;
   int[] interleaveLeave;
   public int priority;
   public int frameStep;
   public int[] frameLenghts;
   public boolean stretches;
   public int leftHandItem;
   public int forcedPriority;
   public int rightHandItem;
   int[] anIntArray107;
   public int maxLoops;
   public int replyMode;
   public int[] anIntArray108;

   static {
      sequences = new NodeCache(64);
      skeletons = new NodeCache(100);
   }

   Sequence() {
      this.frameStep = -1;
      this.stretches = false;
      this.forcedPriority = 5;
      this.leftHandItem = -1;
      this.rightHandItem = -1;
      this.maxLoops = 99;
      this.precedenceAnimating = -1;
      this.priority = -1;
      this.replyMode = 2;
   }

   void method912(Buffer buffer_0, int int_0) {
      int int_1;
      int int_2;
      if (int_0 == 1) {
         int_1 = buffer_0.getUnsignedShort();
         this.frameLenghts = new int[int_1];

         for (int_2 = 0; int_2 < int_1; int_2++) {
            this.frameLenghts[int_2] = buffer_0.getUnsignedShort();
         }

         this.frameIDs = new int[int_1];

         for (int_2 = 0; int_2 < int_1; int_2++) {
            this.frameIDs[int_2] = buffer_0.getUnsignedShort();
         }

         for (int_2 = 0; int_2 < int_1; int_2++) {
            this.frameIDs[int_2] += buffer_0.getUnsignedShort() << 16;
         }
      } else if (int_0 == 2) {
         this.frameStep = buffer_0.getUnsignedShort();
      } else if (int_0 == 3) {
         int_1 = buffer_0.getUnsignedByte();
         this.interleaveLeave = new int[int_1 + 1];

         for (int_2 = 0; int_2 < int_1; int_2++) {
            this.interleaveLeave[int_2] = buffer_0.getUnsignedByte();
         }

         this.interleaveLeave[int_1] = 9999999;
      } else if (int_0 == 4) {
         this.stretches = true;
      } else if (int_0 == 5) {
         this.forcedPriority = buffer_0.getUnsignedByte();
      } else if (int_0 == 6) {
         this.leftHandItem = buffer_0.getUnsignedShort();
      } else if (int_0 == 7) {
         this.rightHandItem = buffer_0.getUnsignedShort();
      } else if (int_0 == 8) {
         this.maxLoops = buffer_0.getUnsignedByte();
      } else if (int_0 == 9) {
         this.precedenceAnimating = buffer_0.getUnsignedByte();
      } else if (int_0 == 10) {
         this.priority = buffer_0.getUnsignedByte();
      } else if (int_0 == 11) {
         this.replyMode = buffer_0.getUnsignedByte();
      } else if (int_0 == 12) {
         int_1 = buffer_0.getUnsignedByte();
         this.anIntArray107 = new int[int_1];

         for (int_2 = 0; int_2 < int_1; int_2++) {
            this.anIntArray107[int_2] = buffer_0.getUnsignedShort();
         }

         for (int_2 = 0; int_2 < int_1; int_2++) {
            this.anIntArray107[int_2] += buffer_0.getUnsignedShort() << 16;
         }
      } else if (int_0 == 13) {
         int_1 = buffer_0.getUnsignedByte();
         this.anIntArray108 = new int[int_1];

         for (int_2 = 0; int_2 < int_1; int_2++) {
            this.anIntArray108[int_2] = buffer_0.read24BitInt();
         }
      }

   }

   public Model method913(Model model, int index) {
      index = this.frameIDs[index];
      Frames frame = ScriptVarType.getFrames(index >> 16);
      index &= 0xFFFF;
      if (frame == null) {
         return model.method1013(true);
      } else {
         Model model_1 = model.method1013(!frame.method871(index));
         model_1.method1008(frame, index);
         return model_1;
      }
   }

   public Model method914(Model model_0, int int_0, Sequence sequence_1, int int_1) {
      int_0 = this.frameIDs[int_0];
      Frames frames_0 = ScriptVarType.getFrames(int_0 >> 16);
      int_0 &= 0xFFFF;
      if (frames_0 == null) {
         return sequence_1.method913(model_0, int_1);
      } else {
         int_1 = sequence_1.frameIDs[int_1];
         Frames frames_1 = ScriptVarType.getFrames(int_1 >> 16);
         int_1 &= 0xFFFF;
         Model model_1;
         if (frames_1 == null) {
            model_1 = model_0.method1013(!frames_0.method871(int_0));
            model_1.method1008(frames_0, int_0);
            return model_1;
         } else {
            model_1 = model_0.method1013(!frames_0.method871(int_0) & !frames_1.method871(int_1));
            model_1.method1022(frames_0, int_0, frames_1, int_1, this.interleaveLeave);
            return model_1;
         }
      }
   }

   Model method915(Model model_0, int int_0, int int_1) {
      int_0 = this.frameIDs[int_0];
      Frames frames_0 = ScriptVarType.getFrames(int_0 >> 16);
      int_0 &= 0xFFFF;
      if (frames_0 == null) {
         return model_0.method1013(true);
      } else {
         Model model_1 = model_0.method1013(!frames_0.method871(int_0));
         int_1 &= 0x3;
         if (int_1 == 1) {
            model_1.method1018();
         } else if (int_1 == 2) {
            model_1.method1020();
         } else if (int_1 == 3) {
            model_1.rotate90Degrees();
         }

         model_1.method1008(frames_0, int_0);
         if (int_1 == 1) {
            model_1.rotate90Degrees();
         } else if (int_1 == 2) {
            model_1.method1020();
         } else if (int_1 == 3) {
            model_1.method1018();
         }

         return model_1;
      }
   }

   Model method916(Model model_0, int int_0) {
      int_0 = this.frameIDs[int_0];
      Frames frames_0 = ScriptVarType.getFrames(int_0 >> 16);
      int_0 &= 0xFFFF;
      if (frames_0 == null) {
         return model_0.method1015(true);
      } else {
         Model model_1 = model_0.method1015(!frames_0.method871(int_0));
         model_1.method1008(frames_0, int_0);
         return model_1;
      }
   }

   public Model method917(Model model_0, int int_0) {
      int int_1 = this.frameIDs[int_0];
      Frames frames_0 = ScriptVarType.getFrames(int_1 >> 16);
      int_1 &= 0xFFFF;
      if (frames_0 == null) {
         return model_0.method1013(true);
      } else {
         Frames frames_1 = null;
         int int_2 = 0;
         if (this.anIntArray107 != null && int_0 < this.anIntArray107.length) {
            int_2 = this.anIntArray107[int_0];
            frames_1 = ScriptVarType.getFrames(int_2 >> 16);
            int_2 &= 0xFFFF;
         }

         Model model_1;
         if (frames_1 != null && int_2 != 65535) {
            model_1 = model_0.method1013(!frames_0.method871(int_1) & !frames_1.method871(int_2));
            model_1.method1008(frames_0, int_1);
            model_1.method1008(frames_1, int_2);
            return model_1;
         } else {
            model_1 = model_0.method1013(!frames_0.method871(int_1));
            model_1.method1008(frames_0, int_1);
            return model_1;
         }
      }
   }

   void post() {
      if (this.precedenceAnimating == -1) {
         if (this.interleaveLeave != null) {
            this.precedenceAnimating = 2;
         } else {
            this.precedenceAnimating = 0;
         }
      }

      if (this.priority == -1) {
         if (this.interleaveLeave != null) {
            this.priority = 2;
         } else {
            this.priority = 0;
         }
      }

   }

   void decode(Buffer buffer_0) {
      while (true) {
         int int_0 = buffer_0.getUnsignedByte();
         if (int_0 == 0) {
            return;
         }

         this.method912(buffer_0, int_0);
      }
   }

}
