public class AClass6_Sub4 extends AClass6 {

   AClass6_Sub1 anAClass6_Sub1_2;
   AClass6_Sub3 anAClass6_Sub3_2;
   Deque aDeque6;

   AClass6_Sub4(AClass6_Sub3 aclass6_sub3_0) {
      this.aDeque6 = new Deque();
      this.anAClass6_Sub1_2 = new AClass6_Sub1();
      this.anAClass6_Sub3_2 = aclass6_sub3_0;
   }

   protected void method656(int[] ints_0, int int_0, int int_1) {
      this.anAClass6_Sub1_2.method656(ints_0, int_0, int_1);

      for (Node_Sub4 node_sub4_0 = (Node_Sub4) this.aDeque6.getFront(); node_sub4_0 != null; node_sub4_0 = (Node_Sub4) this.aDeque6.getNext()) {
         if (!this.anAClass6_Sub3_2.method846(node_sub4_0)) {
            int int_2 = int_0;
            int int_3 = int_1;

            do {
               if (int_3 <= node_sub4_0.anInt359) {
                  this.method866(node_sub4_0, ints_0, int_2, int_3, int_3 + int_2);
                  node_sub4_0.anInt359 -= int_3;
                  break;
               }

               this.method866(node_sub4_0, ints_0, int_2, node_sub4_0.anInt359, int_2 + int_3);
               int_2 += node_sub4_0.anInt359;
               int_3 -= node_sub4_0.anInt359;
            } while (!this.anAClass6_Sub3_2.method856(node_sub4_0, ints_0, int_2, int_3));
         }
      }

   }

   protected void method657(int int_0) {
      this.anAClass6_Sub1_2.method657(int_0);

      for (Node_Sub4 node_sub4_0 = (Node_Sub4) this.aDeque6.getFront(); node_sub4_0 != null; node_sub4_0 = (Node_Sub4) this.aDeque6.getNext()) {
         if (!this.anAClass6_Sub3_2.method846(node_sub4_0)) {
            int int_1 = int_0;

            do {
               if (int_1 <= node_sub4_0.anInt359) {
                  this.method865(node_sub4_0, int_1);
                  node_sub4_0.anInt359 -= int_1;
                  break;
               }

               this.method865(node_sub4_0, node_sub4_0.anInt359);
               int_1 -= node_sub4_0.anInt359;
            } while (!this.anAClass6_Sub3_2.method856(node_sub4_0, (int[]) null, 0, int_1));
         }
      }

   }

   protected AClass6 method659() {
      Node_Sub4 node_sub4_0;
      do {
         node_sub4_0 = (Node_Sub4) this.aDeque6.getNext();
         if (node_sub4_0 == null) {
            return null;
         }
      } while (node_sub4_0.anAClass6_Sub2_3 == null);

      return node_sub4_0.anAClass6_Sub2_3;
   }

   void method865(Node_Sub4 node_sub4_0, int int_0) {
      if ((this.anAClass6_Sub3_2.anIntArray93[node_sub4_0.anInt356] & 0x4) != 0 && node_sub4_0.anInt358 < 0) {
         int int_1 = this.anAClass6_Sub3_2.anIntArray96[node_sub4_0.anInt356] / AbstractSoundSystem.sampleRate;
         int int_2 = (int_1 + 1048575 - node_sub4_0.anInt363) / int_1;
         node_sub4_0.anInt363 = int_1 * int_0 + node_sub4_0.anInt363 & 0xFFFFF;
         if (int_2 <= int_0) {
            if (this.anAClass6_Sub3_2.anIntArray98[node_sub4_0.anInt356] == 0) {
               node_sub4_0.anAClass6_Sub2_3 = AClass6_Sub2.method803(node_sub4_0.anAClass4_Sub1_1, node_sub4_0.anAClass6_Sub2_3.method778(), node_sub4_0.anAClass6_Sub2_3.method781(), node_sub4_0.anAClass6_Sub2_3.method765());
            } else {
               node_sub4_0.anAClass6_Sub2_3 = AClass6_Sub2.method803(node_sub4_0.anAClass4_Sub1_1, node_sub4_0.anAClass6_Sub2_3.method778(), 0, node_sub4_0.anAClass6_Sub2_3.method765());
               this.anAClass6_Sub3_2.method859(node_sub4_0, node_sub4_0.aNode_Sub5_1.aShortArray5[node_sub4_0.anInt364] < 0);
            }

            if (node_sub4_0.aNode_Sub5_1.aShortArray5[node_sub4_0.anInt364] < 0) {
               node_sub4_0.anAClass6_Sub2_3.method782(-1);
            }

            int_0 = node_sub4_0.anInt363 / int_1;
         }
      }

      node_sub4_0.anAClass6_Sub2_3.method657(int_0);
   }

   void method866(Node_Sub4 node_sub4_0, int[] ints_0, int int_0, int int_1, int int_2) {
      if ((this.anAClass6_Sub3_2.anIntArray93[node_sub4_0.anInt356] & 0x4) != 0 && node_sub4_0.anInt358 < 0) {
         int int_3 = this.anAClass6_Sub3_2.anIntArray96[node_sub4_0.anInt356] / AbstractSoundSystem.sampleRate;

         while (true) {
            int int_4 = (int_3 + 1048575 - node_sub4_0.anInt363) / int_3;
            if (int_4 > int_1) {
               node_sub4_0.anInt363 += int_1 * int_3;
               break;
            }

            node_sub4_0.anAClass6_Sub2_3.method656(ints_0, int_0, int_4);
            int_0 += int_4;
            int_1 -= int_4;
            node_sub4_0.anInt363 += int_3 * int_4 - 1048576;
            int int_5 = AbstractSoundSystem.sampleRate / 100;
            int int_6 = 262144 / int_3;
            if (int_6 < int_5) {
               int_5 = int_6;
            }

            AClass6_Sub2 aclass6_sub2_0 = node_sub4_0.anAClass6_Sub2_3;
            if (this.anAClass6_Sub3_2.anIntArray98[node_sub4_0.anInt356] == 0) {
               node_sub4_0.anAClass6_Sub2_3 = AClass6_Sub2.method803(node_sub4_0.anAClass4_Sub1_1, aclass6_sub2_0.method778(), aclass6_sub2_0.method781(), aclass6_sub2_0.method765());
            } else {
               node_sub4_0.anAClass6_Sub2_3 = AClass6_Sub2.method803(node_sub4_0.anAClass4_Sub1_1, aclass6_sub2_0.method778(), 0, aclass6_sub2_0.method765());
               this.anAClass6_Sub3_2.method859(node_sub4_0, node_sub4_0.aNode_Sub5_1.aShortArray5[node_sub4_0.anInt364] < 0);
               node_sub4_0.anAClass6_Sub2_3.method783(int_5, aclass6_sub2_0.method781());
            }

            if (node_sub4_0.aNode_Sub5_1.aShortArray5[node_sub4_0.anInt364] < 0) {
               node_sub4_0.anAClass6_Sub2_3.method782(-1);
            }

            aclass6_sub2_0.method773(int_5);
            aclass6_sub2_0.method656(ints_0, int_0, int_2 - int_0);
            if (aclass6_sub2_0.method775()) {
               this.anAClass6_Sub1_2.method757(aclass6_sub2_0);
            }
         }
      }

      node_sub4_0.anAClass6_Sub2_3.method656(ints_0, int_0, int_1);
   }

   protected AClass6 method660() {
      Node_Sub4 node_sub4_0 = (Node_Sub4) this.aDeque6.getFront();
      return (AClass6) (node_sub4_0 == null ? null : (node_sub4_0.anAClass6_Sub2_3 != null ? node_sub4_0.anAClass6_Sub2_3 : this.method659())) ;
   }

   protected int method662() {
      return 0;
   }

   public static int method867(CharSequence charsequence_0) {
      int int_0 = charsequence_0.length();
      int int_1 = 0;

      for (int int_2 = 0; int_2 < int_0; int_2++) {
         int_1 = (int_1 << 5) - int_1 + charsequence_0.charAt(int_2);
      }

      return int_1;
   }

   static int method868(int int_0, Script script_0, boolean bool_0) {
      Widget widget_0;
      if (int_0 >= 2000) {
         int_0 -= 1000;
         widget_0 = Junk.method671(Class39.intStack[--Class23.intStackSize]);
      } else {
         widget_0 = bool_0 ? Class106.aWidget4 : Friend.aWidget5;
      }

      if (int_0 == 1927) {
         if (Class39.anInt97 >= 10) {
            throw new RuntimeException();
         } else if (widget_0.anObjectArray2 == null) {
            return 0;
         } else {
            ScriptEvent scriptevent_0 = new ScriptEvent();
            scriptevent_0.widget = widget_0;
            scriptevent_0.anObjectArray22 = widget_0.anObjectArray2;
            scriptevent_0.anInt395 = Class39.anInt97 + 1;
            Client.aDeque7.addFront(scriptevent_0);
            return 1;
         }
      } else {
         return 2;
      }
   }

}
