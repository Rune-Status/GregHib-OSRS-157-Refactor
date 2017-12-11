public class CacheableNode_Sub6 extends CacheableNode {

   public static NodeCache aNodeCache15;
   public static NodeCache aNodeCache16;
   public static NodeCache aNodeCache17;
   static IndexDataBase anIndexDataBase25;
   static IndexDataBase anIndexDataBase26;
   static IndexDataBase anIndexDataBase27;
   String aString31;
   int anInt475;
   int anInt476;
   int anInt477;
   int anInt478;
   int anInt479;
   int anInt480;
   int anInt481;
   public int anInt482;
   public int anInt483;
   public int anInt484;
   public int[] anIntArray103;
   public int anInt485;
   public int anInt486;
   public int anInt487;
   public int anInt488;

   static {
      aNodeCache16 = new NodeCache(64);
      aNodeCache17 = new NodeCache(64);
      aNodeCache15 = new NodeCache(20);
   }

   CacheableNode_Sub6() {
      this.anInt478 = -1;
      this.anInt483 = 16777215;
      this.anInt484 = 70;
      this.anInt476 = -1;
      this.anInt479 = -1;
      this.anInt480 = -1;
      this.anInt477 = -1;
      this.anInt485 = 0;
      this.anInt487 = 0;
      this.anInt486 = -1;
      this.aString31 = "";
      this.anInt482 = -1;
      this.anInt488 = 0;
      this.anInt475 = -1;
      this.anInt481 = -1;
   }

   void method888(Buffer buffer_0, int int_0) {
      if (int_0 == 1) {
         this.anInt478 = buffer_0.getBigSmart();
      } else if (int_0 == 2) {
         this.anInt483 = buffer_0.read24BitInt();
      } else if (int_0 == 3) {
         this.anInt476 = buffer_0.getBigSmart();
      } else if (int_0 == 4) {
         this.anInt480 = buffer_0.getBigSmart();
      } else if (int_0 == 5) {
         this.anInt479 = buffer_0.getBigSmart();
      } else if (int_0 == 6) {
         this.anInt477 = buffer_0.getBigSmart();
      } else if (int_0 == 7) {
         this.anInt485 = buffer_0.readShort();
      } else if (int_0 == 8) {
         this.aString31 = buffer_0.getJagString();
      } else if (int_0 == 9) {
         this.anInt484 = buffer_0.getUnsignedShort();
      } else if (int_0 == 10) {
         this.anInt487 = buffer_0.readShort();
      } else if (int_0 == 11) {
         this.anInt486 = 0;
      } else if (int_0 == 12) {
         this.anInt482 = buffer_0.getUnsignedByte();
      } else if (int_0 == 13) {
         this.anInt488 = buffer_0.readShort();
      } else if (int_0 == 14) {
         this.anInt486 = buffer_0.getUnsignedShort();
      } else if (int_0 == 17 || int_0 == 18) {
         this.anInt475 = buffer_0.getUnsignedShort();
         if (this.anInt475 == 65535) {
            this.anInt475 = -1;
         }

         this.anInt481 = buffer_0.getUnsignedShort();
         if (this.anInt481 == 65535) {
            this.anInt481 = -1;
         }

         int int_1 = -1;
         if (int_0 == 18) {
            int_1 = buffer_0.getUnsignedShort();
            if (int_1 == 65535) {
               int_1 = -1;
            }
         }

         int int_2 = buffer_0.getUnsignedByte();
         this.anIntArray103 = new int[int_2 + 2];

         for (int int_3 = 0; int_3 <= int_2; int_3++) {
            this.anIntArray103[int_3] = buffer_0.getUnsignedShort();
            if (this.anIntArray103[int_3] == 65535) {
               this.anIntArray103[int_3] = -1;
            }
         }

         this.anIntArray103[int_2 + 1] = int_1;
      }

   }

   void method889(Buffer buffer_0) {
      while (true) {
         int int_0 = buffer_0.getUnsignedByte();
         if (int_0 == 0) {
            return;
         }

         this.method888(buffer_0, int_0);
      }
   }

   public CacheableNode_Sub6 method890() {
      int int_0 = -1;
      if (this.anInt475 != -1) {
         int_0 = Varbit.getVarbit(this.anInt475);
      } else if (this.anInt481 != -1) {
         int_0 = Settings.widgetSettings[this.anInt481];
      }

      int int_1;
      if (int_0 >= 0 && int_0 < this.anIntArray103.length - 1) {
         int_1 = this.anIntArray103[int_0];
      } else {
         int_1 = this.anIntArray103[this.anIntArray103.length - 1];
      }

      return int_1 != -1 ? AClass3_Sub2.method753(int_1) : null;
   }

   public SpritePixels method891() {
      if (this.anInt476 < 0) {
         return null;
      } else {
         SpritePixels spritepixels_0 = (SpritePixels) aNodeCache17.get((long)this.anInt476);
         if (spritepixels_0 != null) {
            return spritepixels_0;
         } else {
            spritepixels_0 = Class38.decodeSpritePixels(anIndexDataBase26, this.anInt476, 0);
            if (spritepixels_0 != null) {
               aNodeCache17.put(spritepixels_0, (long)this.anInt476);
            }

            return spritepixels_0;
         }
      }
   }

   public SpritePixels method892() {
      if (this.anInt479 < 0) {
         return null;
      } else {
         SpritePixels spritepixels_0 = (SpritePixels) aNodeCache17.get((long)this.anInt479);
         if (spritepixels_0 != null) {
            return spritepixels_0;
         } else {
            spritepixels_0 = Class38.decodeSpritePixels(anIndexDataBase26, this.anInt479, 0);
            if (spritepixels_0 != null) {
               aNodeCache17.put(spritepixels_0, (long)this.anInt479);
            }

            return spritepixels_0;
         }
      }
   }

   public SpritePixels method893() {
      if (this.anInt480 < 0) {
         return null;
      } else {
         SpritePixels spritepixels_0 = (SpritePixels) aNodeCache17.get((long)this.anInt480);
         if (spritepixels_0 != null) {
            return spritepixels_0;
         } else {
            spritepixels_0 = Class38.decodeSpritePixels(anIndexDataBase26, this.anInt480, 0);
            if (spritepixels_0 != null) {
               aNodeCache17.put(spritepixels_0, (long)this.anInt480);
            }

            return spritepixels_0;
         }
      }
   }

   public SpritePixels method894() {
      if (this.anInt477 < 0) {
         return null;
      } else {
         SpritePixels spritepixels_0 = (SpritePixels) aNodeCache17.get((long)this.anInt477);
         if (spritepixels_0 != null) {
            return spritepixels_0;
         } else {
            spritepixels_0 = Class38.decodeSpritePixels(anIndexDataBase26, this.anInt477, 0);
            if (spritepixels_0 != null) {
               aNodeCache17.put(spritepixels_0, (long)this.anInt477);
            }

            return spritepixels_0;
         }
      }
   }

   public Font method895() {
      if (this.anInt478 == -1) {
         return null;
      } else {
         Font font_0 = (Font) aNodeCache15.get((long)this.anInt478);
         if (font_0 != null) {
            return font_0;
         } else {
            font_0 = Class89.decodeFont(anIndexDataBase26, anIndexDataBase27, this.anInt478, 0);
            if (font_0 != null) {
               aNodeCache15.put(font_0, (long)this.anInt478);
            }

            return font_0;
         }
      }
   }

   public String method896(int int_0) {
      String string_0 = this.aString31;

      while (true) {
         int int_1 = string_0.indexOf("%1");
         if (int_1 < 0) {
            return string_0;
         }

         String string_1 = string_0.substring(0, int_1);
         String string_2 = Integer.toString(int_0);
         string_0 = string_1 + string_2 + string_0.substring(int_1 + 2);
      }
   }

}
