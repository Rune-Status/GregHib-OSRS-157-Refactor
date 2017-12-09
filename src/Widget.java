public class Widget extends Node {

   public static boolean aBool34;
   public static NodeCache aNodeCache2;
   public static NodeCache aNodeCache3;
   public static NodeCache aNodeCache4;
   public static IndexDataBase anIndexDataBase11;
   public static IndexDataBase anIndexDataBase12;
   public static NodeCache aNodeCache5;
   public int anInt267;
   public String[] actions;
   public int parentId;
   public int[] itemIds;
   public boolean hasScript;
   public int loopCycle;
   public int fontId;
   int anInt268;
   public int[] anIntArray64;
   public int spriteId;
   public int modelType;
   public int width;
   int anInt269;
   public int modelId;
   public boolean aBool35;
   public int id;
   public int type;
   public int height;
   public boolean flippedHorizontally;
   public int sprite2;
   public int boundsIndex;
   public int index;
   public int anInt270;
   public boolean flippedVertically;
   public int anInt271;
   public int[] itemQuantities;
   public int anInt272;
   public int originalX;
   public int originalWidth;
   public int borderThickness;
   public int relativeX;
   public int contentType;
   public int buttonType;
   public int anInt273;
   public int originalY;
   public int anInt274;
   public int relativeY;
   public int scrollX;
   public int scrollWidth;
   public boolean isHidden;
   public int anInt275;
   public int anInt276;
   public int anInt277;
   public int anInt278;
   public int[] tableActions;
   public int anInt279;
   public int[] anIntArray65;
   public int[][] dynamicValues;
   public int scrollY;
   public int scrollHeight;
   public int config;
   public Widget[] children;
   public int opacity;
   public int rotationX;
   public int anInt280;
   public int rotationZ;
   public int anInt281;
   public int anInt282;
   public int itemId;
   public Object[] anObjectArray2;
   public int textColor;
   public int anInt283;
   public int anInt284;
   public int anInt285;
   public int anInt286;
   public int anInt287;
   public boolean aBool36;
   public Enum9 anEnum9_1;
   public int anInt288;
   public int anInt289;
   public boolean aBool37;
   public boolean aBool38;
   public int textureId;
   public Object[] anObjectArray3;
   public boolean aBool39;
   public int anInt290;
   public int anInt291;
   public Object[] anObjectArray4;
   public int anInt292;
   public int anInt293;
   public int anInt294;
   public int rotationY;
   public int paddingX;
   public Object[] anObjectArray5;
   public int modelZoom;
   public int anInt295;
   public boolean aBool40;
   public boolean textShadowed;
   public int paddingY;
   public Object[] anObjectArray6;
   public int[] xSprites;
   public boolean aBool41;
   public int[] anIntArray66;
   public int anInt296;
   public String text;
   public String aString15;
   public String[] configActions;
   public Object[] anObjectArray7;
   public int itemQuantity;
   public String name;
   public Widget dragParent;
   public Object[] anObjectArray8;
   public String selectedAction;
   public String aString16;
   public Object[] anObjectArray9;
   public String tooltip;
   public boolean aBool42;
   public boolean aBool43;
   public int anInt297;
   public int anInt298;
   public int anInt299;
   public int anInt300;
   public boolean aBool44;
   public Object[] mouseEnterListener;
   public Object[] mouseExitListener;
   public Object[] anObjectArray10;
   public Object[] configListenerArgs;
   public Object[] anObjectArray11;
   public Object[] scrollListener;
   public Object[] anObjectArray12;
   public Object[] tableListenerArgs;
   public Object[] anObjectArray13;
   public Object[] skillListenerArgs;
   public Object[] renderListener;
   public int[] configTriggers;
   public Object[] anObjectArray14;
   public Object[] mouseHoverListener;
   public int[] tableModTriggers;
   public int[] skillTriggers;
   public Object[] anObjectArray15;
   public Object[] anObjectArray16;
   public Object[] anObjectArray17;
   public Object[] anObjectArray18;
   public Object[] anObjectArray19;
   public Object[] anObjectArray20;
   public Object[] anObjectArray21;

   static {
      aNodeCache2 = new NodeCache(200);
      aNodeCache4 = new NodeCache(50);
      aNodeCache3 = new NodeCache(20);
      aNodeCache5 = new NodeCache(8);
      aBool34 = false;
   }

   public Widget() {
      this.hasScript = false;
      this.id = -1;
      this.index = -1;
      this.anInt272 = 0;
      this.contentType = 0;
      this.anInt270 = 0;
      this.anInt273 = 0;
      this.anInt271 = 0;
      this.buttonType = 0;
      this.originalX = 0;
      this.originalY = 0;
      this.originalWidth = 0;
      this.anInt274 = 0;
      this.relativeX = 0;
      this.relativeY = 0;
      this.width = 0;
      this.height = 0;
      this.anInt275 = 1;
      this.anInt276 = 1;
      this.parentId = -1;
      this.isHidden = false;
      this.scrollX = 0;
      this.scrollY = 0;
      this.scrollWidth = 0;
      this.scrollHeight = 0;
      this.textColor = 0;
      this.anInt283 = 0;
      this.anInt285 = 0;
      this.anInt287 = 0;
      this.aBool36 = false;
      this.anEnum9_1 = Enum9.anEnum9_2;
      this.opacity = 0;
      this.anInt288 = 0;
      this.anInt289 = 1;
      this.aBool37 = false;
      this.spriteId = -1;
      this.anInt267 = -1;
      this.textureId = 0;
      this.aBool39 = false;
      this.borderThickness = 0;
      this.sprite2 = 0;
      this.modelType = 1;
      this.modelId = -1;
      this.anInt268 = 1;
      this.anInt269 = -1;
      this.anInt277 = -1;
      this.anInt278 = -1;
      this.anInt293 = 0;
      this.anInt294 = 0;
      this.rotationX = 0;
      this.rotationZ = 0;
      this.rotationY = 0;
      this.modelZoom = 100;
      this.anInt295 = 0;
      this.anInt279 = 0;
      this.aBool41 = false;
      this.anInt296 = 2;
      this.fontId = -1;
      this.text = "";
      this.aString15 = "";
      this.anInt292 = 0;
      this.anInt290 = 0;
      this.anInt291 = 0;
      this.textShadowed = false;
      this.paddingX = 0;
      this.paddingY = 0;
      this.config = 0;
      this.name = "";
      this.dragParent = null;
      this.anInt284 = 0;
      this.anInt286 = 0;
      this.aBool40 = false;
      this.selectedAction = "";
      this.aBool35 = false;
      this.anInt282 = -1;
      this.aString16 = "";
      this.tooltip = "Ok";
      this.itemId = -1;
      this.itemQuantity = 0;
      this.anInt281 = 0;
      this.anInt280 = 0;
      this.aBool42 = false;
      this.aBool43 = false;
      this.anInt297 = -1;
      this.anInt298 = 0;
      this.anInt299 = 0;
      this.anInt300 = 0;
      this.boundsIndex = -1;
      this.loopCycle = -1;
      this.aBool38 = false;
      this.aBool44 = false;
   }

   public SpritePixels method590(boolean bool_0) {
      aBool34 = false;
      int int_0;
      if (bool_0) {
         int_0 = this.anInt267;
      } else {
         int_0 = this.spriteId;
      }

      if (int_0 == -1) {
         return null;
      } else {
         long long_0 = ((long)this.sprite2 << 40) + ((this.flippedHorizontally ? 1L : 0L) << 39) + ((this.flippedVertically ? 1L : 0L) << 38) + (long)int_0 + ((long)this.borderThickness << 36);
         SpritePixels spritepixels_0 = (SpritePixels) aNodeCache2.get(long_0);
         if (spritepixels_0 != null) {
            return spritepixels_0;
         } else {
            spritepixels_0 = Class38.method254(Enum1.anIndexDataBase13, int_0, 0);
            if (spritepixels_0 == null) {
               aBool34 = true;
               return null;
            } else {
               if (this.flippedVertically) {
                  spritepixels_0.method985();
               }

               if (this.flippedHorizontally) {
                  spritepixels_0.method986();
               }

               if (this.borderThickness > 0) {
                  spritepixels_0.method987(this.borderThickness);
               }

               if (this.borderThickness >= 1) {
                  spritepixels_0.method988(1);
               }

               if (this.borderThickness >= 2) {
                  spritepixels_0.method988(16777215);
               }

               if (this.sprite2 != 0) {
                  spritepixels_0.method989(this.sprite2);
               }

               aNodeCache2.put(spritepixels_0, long_0);
               return spritepixels_0;
            }
         }
      }
   }

   void decode(Buffer buffer_0) {
      this.hasScript = false;
      this.type = buffer_0.getUnsignedByte();
      this.anInt272 = buffer_0.getUnsignedByte();
      this.contentType = buffer_0.getUnsignedShort();
      this.originalX = buffer_0.readShort();
      this.originalY = buffer_0.readShort();
      this.originalWidth = buffer_0.getUnsignedShort();
      this.anInt274 = buffer_0.getUnsignedShort();
      this.opacity = buffer_0.getUnsignedByte();
      this.parentId = buffer_0.getUnsignedShort();
      if (this.parentId == 65535) {
         this.parentId = -1;
      } else {
         this.parentId += this.id & 0xFFFF0000;
      }

      this.anInt282 = buffer_0.getUnsignedShort();
      if (this.anInt282 == 65535) {
         this.anInt282 = -1;
      }

      int int_0 = buffer_0.getUnsignedByte();
      int int_1;
      if (int_0 > 0) {
         this.tableActions = new int[int_0];
         this.anIntArray65 = new int[int_0];

         for (int_1 = 0; int_1 < int_0; int_1++) {
            this.tableActions[int_1] = buffer_0.getUnsignedByte();
            this.anIntArray65[int_1] = buffer_0.getUnsignedShort();
         }
      }

      int_1 = buffer_0.getUnsignedByte();
      int int_2;
      int int_3;
      int int_4;
      if (int_1 > 0) {
         this.dynamicValues = new int[int_1][];

         for (int_2 = 0; int_2 < int_1; int_2++) {
            int_3 = buffer_0.getUnsignedShort();
            this.dynamicValues[int_2] = new int[int_3];

            for (int_4 = 0; int_4 < int_3; int_4++) {
               this.dynamicValues[int_2][int_4] = buffer_0.getUnsignedShort();
               if (this.dynamicValues[int_2][int_4] == 65535) {
                  this.dynamicValues[int_2][int_4] = -1;
               }
            }
         }
      }

      if (this.type == 0) {
         this.scrollHeight = buffer_0.getUnsignedShort();
         this.isHidden = buffer_0.getUnsignedByte() == 1;
      }

      if (this.type == 1) {
         buffer_0.getUnsignedShort();
         buffer_0.getUnsignedByte();
      }

      if (this.type == 2) {
         this.itemIds = new int[this.originalWidth * this.anInt274];
         this.itemQuantities = new int[this.originalWidth * this.anInt274];
         int_2 = buffer_0.getUnsignedByte();
         if (int_2 == 1) {
            this.config |= 0x10000000;
         }

         int_3 = buffer_0.getUnsignedByte();
         if (int_3 == 1) {
            this.config |= 0x40000000;
         }

         int_4 = buffer_0.getUnsignedByte();
         if (int_4 == 1) {
            this.config |= 0x80000000;
         }

         int int_5 = buffer_0.getUnsignedByte();
         if (int_5 == 1) {
            this.config |= 0x20000000;
         }

         this.paddingX = buffer_0.getUnsignedByte();
         this.paddingY = buffer_0.getUnsignedByte();
         this.xSprites = new int[20];
         this.anIntArray66 = new int[20];
         this.anIntArray64 = new int[20];

         int int_6;
         for (int_6 = 0; int_6 < 20; int_6++) {
            int int_7 = buffer_0.getUnsignedByte();
            if (int_7 == 1) {
               this.xSprites[int_6] = buffer_0.readShort();
               this.anIntArray66[int_6] = buffer_0.readShort();
               this.anIntArray64[int_6] = buffer_0.readInt();
            } else {
               this.anIntArray64[int_6] = -1;
            }
         }

         this.configActions = new String[5];

         for (int_6 = 0; int_6 < 5; int_6++) {
            String string_0 = buffer_0.readString();
            if (string_0.length() > 0) {
               this.configActions[int_6] = string_0;
               this.config |= 1 << int_6 + 23;
            }
         }
      }

      if (this.type == 3) {
         this.aBool36 = buffer_0.getUnsignedByte() == 1;
      }

      if (this.type == 4 || this.type == 1) {
         this.anInt290 = buffer_0.getUnsignedByte();
         this.anInt291 = buffer_0.getUnsignedByte();
         this.anInt292 = buffer_0.getUnsignedByte();
         this.fontId = buffer_0.getUnsignedShort();
         if (this.fontId == 65535) {
            this.fontId = -1;
         }

         this.textShadowed = buffer_0.getUnsignedByte() == 1;
      }

      if (this.type == 4) {
         this.text = buffer_0.readString();
         this.aString15 = buffer_0.readString();
      }

      if (this.type == 1 || this.type == 3 || this.type == 4) {
         this.textColor = buffer_0.readInt();
      }

      if (this.type == 3 || this.type == 4) {
         this.anInt283 = buffer_0.readInt();
         this.anInt285 = buffer_0.readInt();
         this.anInt287 = buffer_0.readInt();
      }

      if (this.type == 5) {
         this.spriteId = buffer_0.readInt();
         this.anInt267 = buffer_0.readInt();
      }

      if (this.type == 6) {
         this.modelType = 1;
         this.modelId = buffer_0.getUnsignedShort();
         if (this.modelId == 65535) {
            this.modelId = -1;
         }

         this.anInt268 = 1;
         this.anInt269 = buffer_0.getUnsignedShort();
         if (this.anInt269 == 65535) {
            this.anInt269 = -1;
         }

         this.anInt277 = buffer_0.getUnsignedShort();
         if (this.anInt277 == 65535) {
            this.anInt277 = -1;
         }

         this.anInt278 = buffer_0.getUnsignedShort();
         if (this.anInt278 == 65535) {
            this.anInt278 = -1;
         }

         this.modelZoom = buffer_0.getUnsignedShort();
         this.rotationX = buffer_0.getUnsignedShort();
         this.rotationZ = buffer_0.getUnsignedShort();
      }

      if (this.type == 7) {
         this.itemIds = new int[this.originalWidth * this.anInt274];
         this.itemQuantities = new int[this.originalWidth * this.anInt274];
         this.anInt290 = buffer_0.getUnsignedByte();
         this.fontId = buffer_0.getUnsignedShort();
         if (this.fontId == 65535) {
            this.fontId = -1;
         }

         this.textShadowed = buffer_0.getUnsignedByte() == 1;
         this.textColor = buffer_0.readInt();
         this.paddingX = buffer_0.readShort();
         this.paddingY = buffer_0.readShort();
         int_2 = buffer_0.getUnsignedByte();
         if (int_2 == 1) {
            this.config |= 0x40000000;
         }

         this.configActions = new String[5];

         for (int_3 = 0; int_3 < 5; int_3++) {
            String string_1 = buffer_0.readString();
            if (string_1.length() > 0) {
               this.configActions[int_3] = string_1;
               this.config |= 1 << int_3 + 23;
            }
         }
      }

      if (this.type == 8) {
         this.text = buffer_0.readString();
      }

      if (this.anInt272 == 2 || this.type == 2) {
         this.selectedAction = buffer_0.readString();
         this.aString16 = buffer_0.readString();
         int_2 = buffer_0.getUnsignedShort() & 0x3F;
         this.config |= int_2 << 11;
      }

      if (this.anInt272 == 1 || this.anInt272 == 4 || this.anInt272 == 5 || this.anInt272 == 6) {
         this.tooltip = buffer_0.readString();
         if (this.tooltip.length() == 0) {
            if (this.anInt272 == 1) {
               this.tooltip = "Ok";
            }

            if (this.anInt272 == 4) {
               this.tooltip = "Select";
            }

            if (this.anInt272 == 5) {
               this.tooltip = "Select";
            }

            if (this.anInt272 == 6) {
               this.tooltip = "Continue";
            }
         }
      }

      if (this.anInt272 == 1 || this.anInt272 == 4 || this.anInt272 == 5) {
         this.config |= 0x400000;
      }

      if (this.anInt272 == 6) {
         this.config |= 0x1;
      }

   }

   void decodeActive(Buffer buffer_0) {
      buffer_0.getUnsignedByte();
      this.hasScript = true;
      this.type = buffer_0.getUnsignedByte();
      this.contentType = buffer_0.getUnsignedShort();
      this.originalX = buffer_0.readShort();
      this.originalY = buffer_0.readShort();
      this.originalWidth = buffer_0.getUnsignedShort();
      if (this.type == 9) {
         this.anInt274 = buffer_0.readShort();
      } else {
         this.anInt274 = buffer_0.getUnsignedShort();
      }

      this.anInt271 = buffer_0.readByte();
      this.buttonType = buffer_0.readByte();
      this.anInt270 = buffer_0.readByte();
      this.anInt273 = buffer_0.readByte();
      this.parentId = buffer_0.getUnsignedShort();
      if (this.parentId == 65535) {
         this.parentId = -1;
      } else {
         this.parentId += this.id & 0xFFFF0000;
      }

      this.isHidden = buffer_0.getUnsignedByte() == 1;
      if (this.type == 0) {
         this.scrollWidth = buffer_0.getUnsignedShort();
         this.scrollHeight = buffer_0.getUnsignedShort();
         this.aBool38 = buffer_0.getUnsignedByte() == 1;
      }

      if (this.type == 5) {
         this.spriteId = buffer_0.readInt();
         this.textureId = buffer_0.getUnsignedShort();
         this.aBool39 = buffer_0.getUnsignedByte() == 1;
         this.opacity = buffer_0.getUnsignedByte();
         this.borderThickness = buffer_0.getUnsignedByte();
         this.sprite2 = buffer_0.readInt();
         this.flippedVertically = buffer_0.getUnsignedByte() == 1;
         this.flippedHorizontally = buffer_0.getUnsignedByte() == 1;
      }

      if (this.type == 6) {
         this.modelType = 1;
         this.modelId = buffer_0.getUnsignedShort();
         if (this.modelId == 65535) {
            this.modelId = -1;
         }

         this.anInt293 = buffer_0.readShort();
         this.anInt294 = buffer_0.readShort();
         this.rotationX = buffer_0.getUnsignedShort();
         this.rotationZ = buffer_0.getUnsignedShort();
         this.rotationY = buffer_0.getUnsignedShort();
         this.modelZoom = buffer_0.getUnsignedShort();
         this.anInt277 = buffer_0.getUnsignedShort();
         if (this.anInt277 == 65535) {
            this.anInt277 = -1;
         }

         this.aBool41 = buffer_0.getUnsignedByte() == 1;
         buffer_0.getUnsignedShort();
         if (this.anInt271 != 0) {
            this.anInt295 = buffer_0.getUnsignedShort();
         }

         if (this.buttonType != 0) {
            buffer_0.getUnsignedShort();
         }
      }

      if (this.type == 4) {
         this.fontId = buffer_0.getUnsignedShort();
         if (this.fontId == 65535) {
            this.fontId = -1;
         }

         this.text = buffer_0.readString();
         this.anInt292 = buffer_0.getUnsignedByte();
         this.anInt290 = buffer_0.getUnsignedByte();
         this.anInt291 = buffer_0.getUnsignedByte();
         this.textShadowed = buffer_0.getUnsignedByte() == 1;
         this.textColor = buffer_0.readInt();
      }

      if (this.type == 3) {
         this.textColor = buffer_0.readInt();
         this.aBool36 = buffer_0.getUnsignedByte() == 1;
         this.opacity = buffer_0.getUnsignedByte();
      }

      if (this.type == 9) {
         this.anInt289 = buffer_0.getUnsignedByte();
         this.textColor = buffer_0.readInt();
         this.aBool37 = buffer_0.getUnsignedByte() == 1;
      }

      this.config = buffer_0.read24BitInt();
      this.name = buffer_0.readString();
      int int_0 = buffer_0.getUnsignedByte();
      if (int_0 > 0) {
         this.actions = new String[int_0];

         for (int int_1 = 0; int_1 < int_0; int_1++) {
            this.actions[int_1] = buffer_0.readString();
         }
      }

      this.anInt284 = buffer_0.getUnsignedByte();
      this.anInt286 = buffer_0.getUnsignedByte();
      this.aBool40 = buffer_0.getUnsignedByte() == 1;
      this.selectedAction = buffer_0.readString();
      this.anObjectArray6 = this.method595(buffer_0);
      this.mouseEnterListener = this.method595(buffer_0);
      this.mouseExitListener = this.method595(buffer_0);
      this.anObjectArray8 = this.method595(buffer_0);
      this.anObjectArray9 = this.method595(buffer_0);
      this.configListenerArgs = this.method595(buffer_0);
      this.tableListenerArgs = this.method595(buffer_0);
      this.skillListenerArgs = this.method595(buffer_0);
      this.renderListener = this.method595(buffer_0);
      this.anObjectArray10 = this.method595(buffer_0);
      this.mouseHoverListener = this.method595(buffer_0);
      this.anObjectArray11 = this.method595(buffer_0);
      this.anObjectArray14 = this.method595(buffer_0);
      this.anObjectArray13 = this.method595(buffer_0);
      this.anObjectArray12 = this.method595(buffer_0);
      this.anObjectArray3 = this.method595(buffer_0);
      this.anObjectArray4 = this.method595(buffer_0);
      this.scrollListener = this.method595(buffer_0);
      this.configTriggers = this.method598(buffer_0);
      this.tableModTriggers = this.method598(buffer_0);
      this.skillTriggers = this.method598(buffer_0);
   }

   public CacheableNode_Sub1 method591(boolean bool_0) {
      if (this.anInt267 == -1) {
         bool_0 = false;
      }

      int int_0 = bool_0 ? this.anInt267 : this.spriteId;
      if (int_0 == -1) {
         return null;
      } else {
         long long_0 = ((this.flippedHorizontally ? 1L : 0L) << 39) + ((this.flippedVertically ? 1L : 0L) << 38) + ((long)this.borderThickness << 36) + (long)int_0 + ((long)this.sprite2 << 40);
         CacheableNode_Sub1 cacheablenode_sub1_0 = (CacheableNode_Sub1) aNodeCache5.get(long_0);
         if (cacheablenode_sub1_0 != null) {
            return cacheablenode_sub1_0;
         } else {
            SpritePixels spritepixels_0 = this.method590(bool_0);
            if (spritepixels_0 == null) {
               return null;
            } else {
               SpritePixels spritepixels_1 = spritepixels_0.copy();
               int[] ints_0 = new int[spritepixels_1.height];
               int[] ints_1 = new int[spritepixels_1.height];

               for (int int_1 = 0; int_1 < spritepixels_1.height; int_1++) {
                  int int_2 = 0;
                  int int_3 = spritepixels_1.width;

                  int int_4;
                  for (int_4 = 0; int_4 < spritepixels_1.width; int_4++) {
                     if (spritepixels_1.pixels[int_4 + int_1 * spritepixels_1.width] == 0) {
                        int_2 = int_4;
                        break;
                     }
                  }

                  for (int_4 = spritepixels_1.width - 1; int_4 >= int_2; --int_4) {
                     if (spritepixels_1.pixels[int_4 + int_1 * spritepixels_1.width] == 0) {
                        int_3 = int_4 + 1;
                        break;
                     }
                  }

                  ints_0[int_1] = int_2;
                  ints_1[int_1] = int_3 - int_2;
               }

               cacheablenode_sub1_0 = new CacheableNode_Sub1(spritepixels_1.width, spritepixels_1.height, ints_1, ints_0, int_0);
               aNodeCache5.put(cacheablenode_sub1_0, long_0);
               return cacheablenode_sub1_0;
            }
         }
      }
   }

   public Font method592() {
      aBool34 = false;
      if (this.fontId == -1) {
         return null;
      } else {
         Font font_0 = (Font) aNodeCache3.get((long)this.fontId);
         if (font_0 != null) {
            return font_0;
         } else {
            font_0 = Class89.method496(Enum1.anIndexDataBase13, anIndexDataBase11, this.fontId, 0);
            if (font_0 != null) {
               aNodeCache3.put(font_0, (long)this.fontId);
            } else {
               aBool34 = true;
            }

            return font_0;
         }
      }
   }

   public Model method593(Sequence sequence_0, int int_0, boolean bool_0, PlayerComposition playercomposition_0) {
      aBool34 = false;
      int int_1;
      int int_2;
      if (bool_0) {
         int_1 = this.anInt268;
         int_2 = this.anInt269;
      } else {
         int_1 = this.modelType;
         int_2 = this.modelId;
      }

      if (int_1 == 0) {
         return null;
      } else if (int_1 == 1 && int_2 == -1) {
         return null;
      } else {
         Model model_0 = (Model) aNodeCache4.get((long)(int_2 + (int_1 << 16)));
         if (model_0 == null) {
            ModelHeader modeldata_0;
            if (int_1 == 1) {
               modeldata_0 = ModelHeader.getModel(anIndexDataBase12, int_2, 0);
               if (modeldata_0 == null) {
                  aBool34 = true;
                  return null;
               }

               model_0 = modeldata_0.applyLighting(64, 768, -50, -10, -50);
            }

            if (int_1 == 2) {
               modeldata_0 = Class27.getNpcDefinition(int_2).method899();
               if (modeldata_0 == null) {
                  aBool34 = true;
                  return null;
               }

               model_0 = modeldata_0.applyLighting(64, 768, -50, -10, -50);
            }

            if (int_1 == 3) {
               if (playercomposition_0 == null) {
                  return null;
               }

               modeldata_0 = playercomposition_0.method506();
               if (modeldata_0 == null) {
                  aBool34 = true;
                  return null;
               }

               model_0 = modeldata_0.applyLighting(64, 768, -50, -10, -50);
            }

            if (int_1 == 4) {
               ItemComposition itemcomposition_0 = CacheableNode_Sub2.getItemDefinition(int_2);
               modeldata_0 = itemcomposition_0.method934(10);
               if (modeldata_0 == null) {
                  aBool34 = true;
                  return null;
               }

               model_0 = modeldata_0.applyLighting(itemcomposition_0.ambient + 64, itemcomposition_0.contrast + 768, -50, -10, -50);
            }

            aNodeCache4.put(model_0, (long)(int_2 + (int_1 << 16)));
         }

         if (sequence_0 != null) {
            model_0 = sequence_0.method917(model_0, int_0);
         }

         return model_0;
      }
   }

   public SpritePixels method594(int int_0) {
      aBool34 = false;
      if (int_0 >= 0 && int_0 < this.anIntArray64.length) {
         int int_1 = this.anIntArray64[int_0];
         if (int_1 == -1) {
            return null;
         } else {
            SpritePixels spritepixels_0 = (SpritePixels) aNodeCache2.get((long)int_1);
            if (spritepixels_0 != null) {
               return spritepixels_0;
            } else {
               spritepixels_0 = Class38.method254(Enum1.anIndexDataBase13, int_1, 0);
               if (spritepixels_0 != null) {
                  aNodeCache2.put(spritepixels_0, (long)int_1);
               } else {
                  aBool34 = true;
               }

               return spritepixels_0;
            }
         }
      } else {
         return null;
      }
   }

   Object[] method595(Buffer buffer_0) {
      int int_0 = buffer_0.getUnsignedByte();
      if (int_0 == 0) {
         return null;
      } else {
         Object[] objects_0 = new Object[int_0];

         for (int int_1 = 0; int_1 < int_0; int_1++) {
            int int_2 = buffer_0.getUnsignedByte();
            if (int_2 == 0) {
               objects_0[int_1] = new Integer(buffer_0.readInt());
            } else if (int_2 == 1) {
               objects_0[int_1] = buffer_0.readString();
            }
         }

         this.aBool35 = true;
         return objects_0;
      }
   }

   public void method596(int int_0, int int_1) {
      int int_2 = this.itemIds[int_1];
      this.itemIds[int_1] = this.itemIds[int_0];
      this.itemIds[int_0] = int_2;
      int_2 = this.itemQuantities[int_1];
      this.itemQuantities[int_1] = this.itemQuantities[int_0];
      this.itemQuantities[int_0] = int_2;
   }

   public void method597(int int_0, String string_0) {
      if (this.actions == null || this.actions.length <= int_0) {
         String[] strings_0 = new String[int_0 + 1];
         if (this.actions != null) {
            for (int int_1 = 0; int_1 < this.actions.length; int_1++) {
               strings_0[int_1] = this.actions[int_1];
            }
         }

         this.actions = strings_0;
      }

      this.actions[int_0] = string_0;
   }

   int[] method598(Buffer buffer_0) {
      int int_0 = buffer_0.getUnsignedByte();
      if (int_0 == 0) {
         return null;
      } else {
         int[] ints_0 = new int[int_0];

         for (int int_1 = 0; int_1 < int_0; int_1++) {
            ints_0[int_1] = buffer_0.readInt();
         }

         return ints_0;
      }
   }

}
