public class CombatInfo2 extends CacheableNode {

   public static NodeCache aNodeCache7;
   static NodeCache spriteCache;
   public static IndexDataBase anIndexDataBase18;
   static IndexDataBase anIndexDataBase19;
   int anInt452;
   int anInt453;
   public int anInt454;
   public int anInt455;
   public int anInt456;
   public int anInt457;
   public int anInt458;
   public int anInt459;
   public int healthScale;
   public int anInt460;

   static {
      aNodeCache7 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   public CombatInfo2() {
      this.anInt454 = 255;
      this.anInt456 = 255;
      this.anInt455 = -1;
      this.anInt458 = 1;
      this.anInt457 = 70;
      this.anInt452 = -1;
      this.anInt453 = -1;
      this.healthScale = 30;
      this.anInt460 = 0;
   }

   void method816(Buffer buffer_0, int int_0) {
      if (int_0 == 1) {
         buffer_0.getUnsignedShort();
      } else if (int_0 == 2) {
         this.anInt454 = buffer_0.getUnsignedByte();
      } else if (int_0 == 3) {
         this.anInt456 = buffer_0.getUnsignedByte();
      } else if (int_0 == 4) {
         this.anInt455 = 0;
      } else if (int_0 == 5) {
         this.anInt457 = buffer_0.getUnsignedShort();
      } else if (int_0 == 6) {
         buffer_0.getUnsignedByte();
      } else if (int_0 == 7) {
         this.anInt452 = buffer_0.getBigSmart();
      } else if (int_0 == 8) {
         this.anInt453 = buffer_0.getBigSmart();
      } else if (int_0 == 11) {
         this.anInt455 = buffer_0.getUnsignedShort();
      } else if (int_0 == 14) {
         this.healthScale = buffer_0.getUnsignedByte();
      } else if (int_0 == 15) {
         this.anInt460 = buffer_0.getUnsignedByte();
      }

   }

   public void method817(Buffer buffer_0) {
      while (true) {
         int int_0 = buffer_0.getUnsignedByte();
         if (int_0 == 0) {
            return;
         }

         this.method816(buffer_0, int_0);
      }
   }

   public SpritePixels method818() {
      if (this.anInt453 < 0) {
         return null;
      } else {
         SpritePixels spritepixels_0 = (SpritePixels) spriteCache.get((long)this.anInt453);
         if (spritepixels_0 != null) {
            return spritepixels_0;
         } else {
            spritepixels_0 = Class38.decodeSpritePixels(anIndexDataBase19, this.anInt453, 0);
            if (spritepixels_0 != null) {
               spriteCache.put(spritepixels_0, (long)this.anInt453);
            }

            return spritepixels_0;
         }
      }
   }

   public SpritePixels method819() {
      if (this.anInt452 < 0) {
         return null;
      } else {
         SpritePixels spritepixels_0 = (SpritePixels) spriteCache.get((long)this.anInt452);
         if (spritepixels_0 != null) {
            return spritepixels_0;
         } else {
            spritepixels_0 = Class38.decodeSpritePixels(anIndexDataBase19, this.anInt452, 0);
            if (spritepixels_0 != null) {
               spriteCache.put(spritepixels_0, (long)this.anInt452);
            }

            return spritepixels_0;
         }
      }
   }

   static void method820() {
      for (Node_Sub1 node_sub1_0 = (Node_Sub1) Node_Sub1.aDeque3.getFront(); node_sub1_0 != null; node_sub1_0 = (Node_Sub1) Node_Sub1.aDeque3.getNext()) {
         if (node_sub1_0.anAClass6_Sub2_1 != null) {
            Class97.anAClass6_Sub1_1.method758(node_sub1_0.anAClass6_Sub2_1);
            node_sub1_0.anAClass6_Sub2_1 = null;
         }

         if (node_sub1_0.anAClass6_Sub2_2 != null) {
            Class97.anAClass6_Sub1_1.method758(node_sub1_0.anAClass6_Sub2_2);
            node_sub1_0.anAClass6_Sub2_2 = null;
         }
      }

      Node_Sub1.aDeque3.clear();
   }

}
