public class Area extends CacheableNode {

   public static Area[] anAreaArray1;
   public static NodeCache skeletonsIndex;
   public static IndexDataBase anIndexDataBase17;
   public static int anInt442;
   public int spriteId;
   int[] anIntArray83;
   public final int anInt443;
   public String name;
   public Enum8 anEnum8_4;
   int anInt444;
   public int anInt445;
   int anInt446;
   public int anInt447;
   public Enum5 anEnum5_4;
   public String[] aStringArray4;
   int anInt448;
   public int anInt449;
   int anInt450;
   public String aString29;
   int anInt451;
   int[] anIntArray84;
   byte[] aByteArray19;

   static {
      skeletonsIndex = new NodeCache(256);
   }

   public Area(int int_0) {
      this.spriteId = -1;
      this.anInt444 = -1;
      this.anInt447 = 0;
      this.aStringArray4 = new String[5];
      this.anInt446 = Integer.MAX_VALUE;
      this.anInt450 = Integer.MAX_VALUE;
      this.anInt448 = Integer.MIN_VALUE;
      this.anInt451 = Integer.MIN_VALUE;
      this.anEnum8_4 = Enum8.anEnum8_2;
      this.anEnum5_4 = Enum5.anEnum5_2;
      this.anInt449 = -1;
      this.anInt443 = int_0;
   }

   public SpritePixels method809(boolean bool_0) {
      int int_0 = this.spriteId;
      return this.method810(int_0);
   }

   SpritePixels method810(int int_0) {
      if (int_0 < 0) {
         return null;
      } else {
         SpritePixels spritepixels_0 = (SpritePixels) skeletonsIndex.get((long)int_0);
         if (spritepixels_0 != null) {
            return spritepixels_0;
         } else {
            spritepixels_0 = Class38.method254(anIndexDataBase17, int_0, 0);
            if (spritepixels_0 != null) {
               skeletonsIndex.put(spritepixels_0, (long)int_0);
            }

            return spritepixels_0;
         }
      }
   }

   void method811(Buffer buffer_0, int int_0) {
      if (int_0 == 1) {
         this.spriteId = buffer_0.method703();
      } else if (int_0 == 2) {
         this.anInt444 = buffer_0.method703();
      } else if (int_0 == 3) {
         this.name = buffer_0.readString();
      } else if (int_0 == 4) {
         this.anInt445 = buffer_0.read24BitInt();
      } else if (int_0 == 5) {
         buffer_0.read24BitInt();
      } else if (int_0 == 6) {
         this.anInt447 = buffer_0.readUnsignedByte();
      } else {
         int int_1;
         if (int_0 == 7) {
            int_1 = buffer_0.readUnsignedByte();
            if ((int_1 & 0x1) == 0) {
               ;
            }

            if ((int_1 & 0x2) == 2) {
               ;
            }
         } else if (int_0 == 8) {
            buffer_0.readUnsignedByte();
         } else if (int_0 >= 10 && int_0 <= 14) {
            this.aStringArray4[int_0 - 10] = buffer_0.readString();
         } else if (int_0 == 15) {
            int_1 = buffer_0.readUnsignedByte();
            this.anIntArray83 = new int[int_1 * 2];

            int int_2;
            for (int_2 = 0; int_2 < int_1 * 2; int_2++) {
               this.anIntArray83[int_2] = buffer_0.readShort();
            }

            buffer_0.readInt();
            int_2 = buffer_0.readUnsignedByte();
            this.anIntArray84 = new int[int_2];

            int int_3;
            for (int_3 = 0; int_3 < this.anIntArray84.length; int_3++) {
               this.anIntArray84[int_3] = buffer_0.readInt();
            }

            this.aByteArray19 = new byte[int_1];

            for (int_3 = 0; int_3 < int_1; int_3++) {
               this.aByteArray19[int_3] = buffer_0.readByte();
            }
         } else if (int_0 != 16) {
            if (int_0 == 17) {
               this.aString29 = buffer_0.readString();
            } else if (int_0 == 18) {
               buffer_0.method703();
            } else if (int_0 == 19) {
               this.anInt449 = buffer_0.readUnsignedShort();
            } else if (int_0 == 21) {
               buffer_0.readInt();
            } else if (int_0 == 22) {
               buffer_0.readInt();
            } else if (int_0 == 23) {
               buffer_0.readUnsignedByte();
               buffer_0.readUnsignedByte();
               buffer_0.readUnsignedByte();
            } else if (int_0 == 24) {
               buffer_0.readShort();
               buffer_0.readShort();
            } else if (int_0 == 25) {
               buffer_0.method703();
            } else if (int_0 == 28) {
               buffer_0.readUnsignedByte();
            } else if (int_0 == 29) {
               Enum8[] enum8s_0 = new Enum8[] {Enum8.anEnum8_1, Enum8.anEnum8_3, Enum8.anEnum8_2};
               this.anEnum8_4 = (Enum8) Class1.forOrdinal(enum8s_0, buffer_0.readUnsignedByte());
            } else if (int_0 == 30) {
               this.anEnum5_4 = (Enum5) Class1.forOrdinal(DecorativeObject.method461(), buffer_0.readUnsignedByte());
            }
         }
      }

   }

   public int method812() {
      return this.anInt443;
   }

   public void method813(Buffer buffer_0) {
      while (true) {
         int int_0 = buffer_0.readUnsignedByte();
         if (int_0 == 0) {
            return;
         }

         this.method811(buffer_0, int_0);
      }
   }

   public void method814() {
      if (this.anIntArray83 != null) {
         for (int int_0 = 0; int_0 < this.anIntArray83.length; int_0 += 2) {
            if (this.anIntArray83[int_0] < this.anInt446) {
               this.anInt446 = this.anIntArray83[int_0];
            } else if (this.anIntArray83[int_0] > this.anInt448) {
               this.anInt448 = this.anIntArray83[int_0];
            }

            if (this.anIntArray83[int_0 + 1] < this.anInt450) {
               this.anInt450 = this.anIntArray83[int_0 + 1];
            } else if (this.anIntArray83[int_0 + 1] > this.anInt451) {
               this.anInt451 = this.anIntArray83[int_0 + 1];
            }
         }
      }

   }

}
