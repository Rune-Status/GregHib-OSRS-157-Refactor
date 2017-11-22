public class Class52 {

   static Widget aWidget2;
   IndexDataBase vorbis_index;
   IndexDataBase sfx_index;
   HashTable aHashTable1;
   HashTable aHashTable2;

   public Class52(IndexDataBase indexdatabase_0, IndexDataBase indexdatabase_1) {
      this.aHashTable2 = new HashTable(256);
      this.aHashTable1 = new HashTable(256);
      this.sfx_index = indexdatabase_0;
      this.vorbis_index = indexdatabase_1;
   }

   AClass4_Sub1 method331(int int_0, int int_1, int[] ints_0) {
      int int_2 = int_1 ^ (int_0 << 4 & 0xFFFF | int_0 >>> 12);
      int_2 |= int_0 << 16;
      long long_0 = (long)int_2;
      AClass4_Sub1 aclass4_sub1_0 = (AClass4_Sub1) this.aHashTable1.get(long_0);
      if (aclass4_sub1_0 != null) {
         return aclass4_sub1_0;
      } else if (ints_0 != null && ints_0[0] <= 0) {
         return null;
      } else {
         SoundEffect soundeffect_0 = SoundEffect.getTrack(this.sfx_index, int_0, int_1);
         if (soundeffect_0 == null) {
            return null;
         } else {
            aclass4_sub1_0 = soundeffect_0.method421();
            this.aHashTable1.put(aclass4_sub1_0, long_0);
            if (ints_0 != null) {
               ints_0[0] -= aclass4_sub1_0.aByteArray18.length;
            }

            return aclass4_sub1_0;
         }
      }
   }

   AClass4_Sub1 method332(int int_0, int int_1, int[] ints_0) {
      int int_2 = int_1 ^ (int_0 << 4 & 0xFFFF | int_0 >>> 12);
      int_2 |= int_0 << 16;
      long long_0 = (long)int_2 ^ 0x100000000L;
      AClass4_Sub1 aclass4_sub1_0 = (AClass4_Sub1) this.aHashTable1.get(long_0);
      if (aclass4_sub1_0 != null) {
         return aclass4_sub1_0;
      } else if (ints_0 != null && ints_0[0] <= 0) {
         return null;
      } else {
         Node_Sub2 node_sub2_0 = (Node_Sub2) this.aHashTable2.get(long_0);
         if (node_sub2_0 == null) {
            node_sub2_0 = Node_Sub2.method667(this.vorbis_index, int_0, int_1);
            if (node_sub2_0 == null) {
               return null;
            }

            this.aHashTable2.put(node_sub2_0, long_0);
         }

         aclass4_sub1_0 = node_sub2_0.method664(ints_0);
         if (aclass4_sub1_0 == null) {
            return null;
         } else {
            node_sub2_0.unlink();
            this.aHashTable1.put(aclass4_sub1_0, long_0);
            return aclass4_sub1_0;
         }
      }
   }

   public AClass4_Sub1 method333(int int_0, int[] ints_0) {
      if (this.sfx_index.size() == 1) {
         return this.method331(0, int_0, ints_0);
      } else if (this.sfx_index.fileCount(int_0) == 1) {
         return this.method331(int_0, 0, ints_0);
      } else {
         throw new RuntimeException();
      }
   }

   public AClass4_Sub1 method334(int int_0, int[] ints_0) {
      if (this.vorbis_index.size() == 1) {
         return this.method332(0, int_0, ints_0);
      } else if (this.vorbis_index.fileCount(int_0) == 1) {
         return this.method332(int_0, 0, ints_0);
      } else {
         throw new RuntimeException();
      }
   }

   public static void method335(ScriptEvent scriptevent_0) {
      Class17.method200(scriptevent_0, 200000);
   }

   public static Enum6[] method336() {
      return new Enum6[] {Enum6.anEnum6_7, Enum6.anEnum6_5, Enum6.anEnum6_4, Enum6.anEnum6_3, Enum6.anEnum6_2, Enum6.anEnum6_6};
   }

   static String method337(String string_0, Widget widget_0) {
      if (string_0.indexOf("%") != -1) {
         int int_0;
         for (int_0 = 1; int_0 <= 5; int_0++) {
            while (true) {
               int int_1 = string_0.indexOf("%" + int_0);
               if (int_1 == -1) {
                  break;
               }

               string_0 = string_0.substring(0, int_1) + Class34.method243(Class49.method315(widget_0, int_0 - 1)) + string_0.substring(int_1 + 2);
            }
         }

         while (true) {
            int_0 = string_0.indexOf("%dns");
            if (int_0 == -1) {
               break;
            }

            String string_1 = "";
            if (FileSystem.aTask2 != null) {
               string_1 = SceneTilePaint.method330(FileSystem.aTask2.anInt217);
               if (FileSystem.aTask2.value != null) {
                  string_1 = (String) FileSystem.aTask2.value;
               }
            }

            string_0 = string_0.substring(0, int_0) + string_1 + string_0.substring(int_0 + 4);
         }
      }

      return string_0;
   }

}
