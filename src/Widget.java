public class Widget extends Node {

   public static boolean missingData;
   public static NodeCache spritePixelsCache;
   public static NodeCache fontCache;
   public static NodeCache widgetModelCache;
   public static IndexDataBase anIndexDataBase11;
   public static IndexDataBase modelCacheIndex;
   public static NodeCache spriteCache;
   public int enabledImage;
   public String[] actions;
   public int parentId;
   public int[] itemIds;
   public boolean hasScript;
   public int loopCycle;
   public int fontId;
   int enabledMediaType;
   public int[] images;
   public int disabledImage;
   public int disabledMediaType;
   public int width;
   int enabledMediaId;
   public int disabledMediaId;
   public boolean parametersLoaded;
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
   public int actionType;
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
   public int disabledAnimation;
   public int enabledAnimation;
   public int[] tableActions;
   public int anInt279;
   public int[] anIntArray65;
   public int[][] dynamicValues;
   public int scrollY;
   public int scrollHeight;
   public int config;
   public Widget[] children;
   public int opacity;
   public int modelRotationX;
   public int anInt280;
   public int modelRotationZ;
   public int anInt281;
   public int anInt282;
   public int itemId;
   public Object[] anObjectArray2;
   public int disabledColour;
   public int enabledColour;
   public int anInt284;
   public int disabledHoverColour;
   public int anInt286;
   public int enabledHoverColour;
   public boolean rectFilled;
   public Enum9 anEnum9_1;
   public int anInt288;
   public int anInt289;
   public boolean aBool37;
   public boolean aBool38;
   public int textureId;
   public Object[] anObjectArray3;
   public boolean aBool39;
   public int textCentered;
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
   public int[] imageX;
   public boolean aBool41;
   public int[] imageY;
   public int anInt296;
   public String disabledText;
   public String enabledText;
   public String[] configActions;
   public Object[] anObjectArray7;
   public int itemQuantity;
   public String name;
   public Widget dragParent;
   public Object[] anObjectArray8;
   public String selectedAction;
   public String spellName;
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
      spritePixelsCache = new NodeCache(200);
      widgetModelCache = new NodeCache(50);
      fontCache = new NodeCache(20);
      spriteCache = new NodeCache(8);
      missingData = false;
   }

   public Widget() {
      this.hasScript = false;
      this.id = -1;
      this.index = -1;
      this.actionType = 0;
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
      this.disabledColour = 0;
      this.enabledColour = 0;
      this.disabledHoverColour = 0;
      this.enabledHoverColour = 0;
      this.rectFilled = false;
      this.anEnum9_1 = Enum9.anEnum9_2;
      this.opacity = 0;
      this.anInt288 = 0;
      this.anInt289 = 1;
      this.aBool37 = false;
      this.disabledImage = -1;
      this.enabledImage = -1;
      this.textureId = 0;
      this.aBool39 = false;
      this.borderThickness = 0;
      this.sprite2 = 0;
      this.disabledMediaType = 1;
      this.disabledMediaId = -1;
      this.enabledMediaType = 1;
      this.enabledMediaId = -1;
      this.disabledAnimation = -1;
      this.enabledAnimation = -1;
      this.anInt293 = 0;
      this.anInt294 = 0;
      this.modelRotationX = 0;
      this.modelRotationZ = 0;
      this.rotationY = 0;
      this.modelZoom = 100;
      this.anInt295 = 0;
      this.anInt279 = 0;
      this.aBool41 = false;
      this.anInt296 = 2;
      this.fontId = -1;
      this.disabledText = "";
      this.enabledText = "";
      this.anInt292 = 0;
      this.textCentered = 0;
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
      this.parametersLoaded = false;
      this.anInt282 = -1;
      this.spellName = "";
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

   public SpritePixels getRotatedPixels(boolean enabled) {
      missingData = false;
      int spriteId;
      if (enabled) {
         spriteId = this.enabledImage;
      } else {
         spriteId = this.disabledImage;
      }

      if (spriteId == -1) {
         return null;
      } else {
         long key = ((long)this.sprite2 << 40) + ((this.flippedHorizontally ? 1L : 0L) << 39) + ((this.flippedVertically ? 1L : 0L) << 38) + (long)spriteId + ((long)this.borderThickness << 36);
         SpritePixels pixels = (SpritePixels) spritePixelsCache.get(key);
         if (pixels != null) {
            return pixels;
         } else {
            pixels = Class38.decodeSpritePixels(Enum1.spriteCacheIndex, spriteId, 0);
            if (pixels == null) {
               missingData = true;
               return null;
            } else {
               if (this.flippedVertically) {
                  pixels.flipVertical();
               }

               if (this.flippedHorizontally) {
                  pixels.flipHorizontal();
               }

               if (this.borderThickness > 0) {
                  pixels.setBorder(this.borderThickness);
               }

               if (this.borderThickness >= 1) {
                  pixels.setTransparentPixel(1);
               }

               if (this.borderThickness >= 2) {
                  pixels.setTransparentPixel(16777215);
               }

               if (this.sprite2 != 0) {
                  pixels.setSecondarySprite(this.sprite2);
               }

               spritePixelsCache.put(pixels, key);
               return pixels;
            }
         }
      }
   }

   void decode(Buffer buffer) {
      this.hasScript = false;
      this.type = buffer.getUnsignedByte();
      this.actionType = buffer.getUnsignedByte();
      this.contentType = buffer.getUnsignedShort();
      this.originalX = buffer.readShort();
      this.originalY = buffer.readShort();
      this.originalWidth = buffer.getUnsignedShort();
      this.anInt274 = buffer.getUnsignedShort();
      this.opacity = buffer.getUnsignedByte();
      this.parentId = buffer.getUnsignedShort();
      if (this.parentId == 65535) {
         this.parentId = -1;
      } else {
         this.parentId += this.id & 0xFFFF0000;
      }

      this.anInt282 = buffer.getUnsignedShort();
      if (this.anInt282 == 65535) {
         this.anInt282 = -1;
      }

      int conditionCount = buffer.getUnsignedByte();
      int length;
      if (conditionCount > 0) {
         this.tableActions = new int[conditionCount];
         this.anIntArray65 = new int[conditionCount];

         for (length = 0; length < conditionCount; length++) {
            this.tableActions[length] = buffer.getUnsignedByte();
            this.anIntArray65[length] = buffer.getUnsignedShort();
         }
      }

      length = buffer.getUnsignedByte();
      int config;
      int size;
      int index;
      if (length > 0) {
         this.dynamicValues = new int[length][];

         for (config = 0; config < length; config++) {
            size = buffer.getUnsignedShort();
            this.dynamicValues[config] = new int[size];

            for (index = 0; index < size; index++) {
               this.dynamicValues[config][index] = buffer.getUnsignedShort();
               if (this.dynamicValues[config][index] == 65535) {
                  this.dynamicValues[config][index] = -1;
               }
            }
         }
      }

      if (this.type == 0) {
         this.scrollHeight = buffer.getUnsignedShort();
         this.isHidden = buffer.getUnsignedByte() == 1;
      }

      if (this.type == 1) {
         buffer.getUnsignedShort();
         buffer.getUnsignedByte();
      }

      if (this.type == 2) {
         this.itemIds = new int[this.originalWidth * this.anInt274];
         this.itemQuantities = new int[this.originalWidth * this.anInt274];
         config = buffer.getUnsignedByte();
         if (config == 1) {
            this.config |= 0x10000000;
         }

         size = buffer.getUnsignedByte();
         if (size == 1) {
            this.config |= 0x40000000;
         }

         index = buffer.getUnsignedByte();
         if (index == 1) {
            this.config |= 0x80000000;
         }

         int info = buffer.getUnsignedByte();
         if (info == 1) {
            this.config |= 0x20000000;
         }

         this.paddingX = buffer.getUnsignedByte();
         this.paddingY = buffer.getUnsignedByte();
         this.imageX = new int[20];
         this.imageY = new int[20];
         this.images = new int[20];

         int spriteIndex;
         for (spriteIndex = 0; spriteIndex < 20; spriteIndex++) {
            int int_7 = buffer.getUnsignedByte();
            if (int_7 == 1) {
               this.imageX[spriteIndex] = buffer.readShort();
               this.imageY[spriteIndex] = buffer.readShort();
               this.images[spriteIndex] = buffer.readInt();
            } else {
               this.images[spriteIndex] = -1;
            }
         }

         this.configActions = new String[5];

         for (spriteIndex = 0; spriteIndex < 5; spriteIndex++) {
            String string_0 = buffer.readString();
            if (string_0.length() > 0) {
               this.configActions[spriteIndex] = string_0;
               this.config |= 1 << spriteIndex + 23;
            }
         }
      }

      if (this.type == 3) {
         this.rectFilled = buffer.getUnsignedByte() == 1;
      }

      if (this.type == 4 || this.type == 1) {
         this.textCentered = buffer.getUnsignedByte();
         this.anInt291 = buffer.getUnsignedByte();
         this.anInt292 = buffer.getUnsignedByte();
         this.fontId = buffer.getUnsignedShort();
         if (this.fontId == 65535) {
            this.fontId = -1;
         }

         this.textShadowed = buffer.getUnsignedByte() == 1;
      }

      if (this.type == 4) {
         this.disabledText = buffer.readString();
         this.enabledText = buffer.readString();
      }

      if (this.type == 1 || this.type == 3 || this.type == 4) {
         this.disabledColour = buffer.readInt();
      }

      if (this.type == 3 || this.type == 4) {
         this.enabledColour = buffer.readInt();
         this.disabledHoverColour = buffer.readInt();
         this.enabledHoverColour = buffer.readInt();
      }

      if (this.type == 5) {
         this.disabledImage = buffer.readInt();
         this.enabledImage = buffer.readInt();
      }

      if (this.type == 6) {
         this.disabledMediaType = 1;
         this.disabledMediaId = buffer.getUnsignedShort();
         if (this.disabledMediaId == 65535) {
            this.disabledMediaId = -1;
         }

         this.enabledMediaType = 1;
         this.enabledMediaId = buffer.getUnsignedShort();
         if (this.enabledMediaId == 65535) {
            this.enabledMediaId = -1;
         }

         this.disabledAnimation = buffer.getUnsignedShort();
         if (this.disabledAnimation == 65535) {
            this.disabledAnimation = -1;
         }

         this.enabledAnimation = buffer.getUnsignedShort();
         if (this.enabledAnimation == 65535) {
            this.enabledAnimation = -1;
         }

         this.modelZoom = buffer.getUnsignedShort();
         this.modelRotationX = buffer.getUnsignedShort();
         this.modelRotationZ = buffer.getUnsignedShort();
      }

      if (this.type == 7) {
         this.itemIds = new int[this.originalWidth * this.anInt274];
         this.itemQuantities = new int[this.originalWidth * this.anInt274];
         this.textCentered = buffer.getUnsignedByte();
         this.fontId = buffer.getUnsignedShort();
         if (this.fontId == 65535) {
            this.fontId = -1;
         }

         this.textShadowed = buffer.getUnsignedByte() == 1;
         this.disabledColour = buffer.readInt();
         this.paddingX = buffer.readShort();
         this.paddingY = buffer.readShort();
         config = buffer.getUnsignedByte();
         if (config == 1) {
            this.config |= 0x40000000;
         }

         this.configActions = new String[5];

         for (size = 0; size < 5; size++) {
            String string_1 = buffer.readString();
            if (string_1.length() > 0) {
               this.configActions[size] = string_1;
               this.config |= 1 << size + 23;
            }
         }
      }

      if (this.type == 8) {
         this.disabledText = buffer.readString();
      }

      if (this.actionType == 2 || this.type == 2) {
         this.selectedAction = buffer.readString();
         this.spellName = buffer.readString();
         config = buffer.getUnsignedShort() & 0x3F;
         this.config |= config << 11;
      }

      if (this.actionType == 1 || this.actionType == 4 || this.actionType == 5 || this.actionType == 6) {
         this.tooltip = buffer.readString();
         if (this.tooltip.length() == 0) {
            if (this.actionType == 1) {
               this.tooltip = "Ok";
            }

            if (this.actionType == 4) {
               this.tooltip = "Select";
            }

            if (this.actionType == 5) {
               this.tooltip = "Select";
            }

            if (this.actionType == 6) {
               this.tooltip = "Continue";
            }
         }
      }

      if (this.actionType == 1 || this.actionType == 4 || this.actionType == 5) {
         this.config |= 0x400000;
      }

      if (this.actionType == 6) {
         this.config |= 0x1;
      }

   }

   void decodeActive(Buffer buffer) {
      buffer.getUnsignedByte();
      this.hasScript = true;
      this.type = buffer.getUnsignedByte();
      this.contentType = buffer.getUnsignedShort();
      this.originalX = buffer.readShort();
      this.originalY = buffer.readShort();
      this.originalWidth = buffer.getUnsignedShort();
      if (this.type == 9) {
         this.anInt274 = buffer.readShort();
      } else {
         this.anInt274 = buffer.getUnsignedShort();
      }

      this.anInt271 = buffer.readByte();
      this.buttonType = buffer.readByte();
      this.anInt270 = buffer.readByte();
      this.anInt273 = buffer.readByte();
      this.parentId = buffer.getUnsignedShort();
      if (this.parentId == 65535) {
         this.parentId = -1;
      } else {
         this.parentId += this.id & 0xFFFF0000;
      }

      this.isHidden = buffer.getUnsignedByte() == 1;
      if (this.type == 0) {
         this.scrollWidth = buffer.getUnsignedShort();
         this.scrollHeight = buffer.getUnsignedShort();
         this.aBool38 = buffer.getUnsignedByte() == 1;
      }

      if (this.type == 5) {
         this.disabledImage = buffer.readInt();
         this.textureId = buffer.getUnsignedShort();
         this.aBool39 = buffer.getUnsignedByte() == 1;
         this.opacity = buffer.getUnsignedByte();
         this.borderThickness = buffer.getUnsignedByte();
         this.sprite2 = buffer.readInt();
         this.flippedVertically = buffer.getUnsignedByte() == 1;
         this.flippedHorizontally = buffer.getUnsignedByte() == 1;
      }

      if (this.type == 6) {
         this.disabledMediaType = 1;
         this.disabledMediaId = buffer.getUnsignedShort();
         if (this.disabledMediaId == 65535) {
            this.disabledMediaId = -1;
         }

         this.anInt293 = buffer.readShort();
         this.anInt294 = buffer.readShort();
         this.modelRotationX = buffer.getUnsignedShort();
         this.modelRotationZ = buffer.getUnsignedShort();
         this.rotationY = buffer.getUnsignedShort();
         this.modelZoom = buffer.getUnsignedShort();
         this.disabledAnimation = buffer.getUnsignedShort();
         if (this.disabledAnimation == 65535) {
            this.disabledAnimation = -1;
         }

         this.aBool41 = buffer.getUnsignedByte() == 1;
         buffer.getUnsignedShort();
         if (this.anInt271 != 0) {
            this.anInt295 = buffer.getUnsignedShort();
         }

         if (this.buttonType != 0) {
            buffer.getUnsignedShort();
         }
      }

      if (this.type == 4) {
         this.fontId = buffer.getUnsignedShort();
         if (this.fontId == 65535) {
            this.fontId = -1;
         }

         this.disabledText = buffer.readString();
         this.anInt292 = buffer.getUnsignedByte();
         this.textCentered = buffer.getUnsignedByte();
         this.anInt291 = buffer.getUnsignedByte();
         this.textShadowed = buffer.getUnsignedByte() == 1;
         this.disabledColour = buffer.readInt();
      }

      if (this.type == 3) {
         this.disabledColour = buffer.readInt();
         this.rectFilled = buffer.getUnsignedByte() == 1;
         this.opacity = buffer.getUnsignedByte();
      }

      if (this.type == 9) {
         this.anInt289 = buffer.getUnsignedByte();
         this.disabledColour = buffer.readInt();
         this.aBool37 = buffer.getUnsignedByte() == 1;
      }

      this.config = buffer.read24BitInt();
      this.name = buffer.readString();
      int int_0 = buffer.getUnsignedByte();
      if (int_0 > 0) {
         this.actions = new String[int_0];

         for (int int_1 = 0; int_1 < int_0; int_1++) {
            this.actions[int_1] = buffer.readString();
         }
      }

      this.anInt284 = buffer.getUnsignedByte();
      this.anInt286 = buffer.getUnsignedByte();
      this.aBool40 = buffer.getUnsignedByte() == 1;
      this.selectedAction = buffer.readString();
      this.anObjectArray6 = this.decodeWidgetParameters(buffer);
      this.mouseEnterListener = this.decodeWidgetParameters(buffer);
      this.mouseExitListener = this.decodeWidgetParameters(buffer);
      this.anObjectArray8 = this.decodeWidgetParameters(buffer);
      this.anObjectArray9 = this.decodeWidgetParameters(buffer);
      this.configListenerArgs = this.decodeWidgetParameters(buffer);
      this.tableListenerArgs = this.decodeWidgetParameters(buffer);
      this.skillListenerArgs = this.decodeWidgetParameters(buffer);
      this.renderListener = this.decodeWidgetParameters(buffer);
      this.anObjectArray10 = this.decodeWidgetParameters(buffer);
      this.mouseHoverListener = this.decodeWidgetParameters(buffer);
      this.anObjectArray11 = this.decodeWidgetParameters(buffer);
      this.anObjectArray14 = this.decodeWidgetParameters(buffer);
      this.anObjectArray13 = this.decodeWidgetParameters(buffer);
      this.anObjectArray12 = this.decodeWidgetParameters(buffer);
      this.anObjectArray3 = this.decodeWidgetParameters(buffer);
      this.anObjectArray4 = this.decodeWidgetParameters(buffer);
      this.scrollListener = this.decodeWidgetParameters(buffer);
      this.configTriggers = this.decodeArray(buffer);
      this.tableModTriggers = this.decodeArray(buffer);
      this.skillTriggers = this.decodeArray(buffer);
   }

   public CachedSprite method591(boolean enabled) {
      if (this.enabledImage == -1) {
         enabled = false;
      }

      int spriteId = enabled ? this.enabledImage : this.disabledImage;
      if (spriteId == -1) {
         return null;
      } else {
         long key = ((this.flippedHorizontally ? 1L : 0L) << 39) + ((this.flippedVertically ? 1L : 0L) << 38) + ((long)this.borderThickness << 36) + (long)spriteId + ((long)this.sprite2 << 40);
         CachedSprite cachedSprite = (CachedSprite) spriteCache.get(key);
         if (cachedSprite != null) {
            return cachedSprite;
         } else {
            SpritePixels sprite = this.getRotatedPixels(enabled);
            if (sprite == null) {
               return null;
            } else {
               SpritePixels pixels = sprite.copy();
               int[] xPixels = new int[pixels.height];
               int[] yPixels = new int[pixels.height];

               for (int pixel = 0; pixel < pixels.height; pixel++) {
                  int height = 0;
                  int width = pixels.width;

                  int index;
                  for (index = 0; index < pixels.width; index++) {
                     if (pixels.pixels[index + pixel * pixels.width] == 0) {
                        height = index;
                        break;
                     }
                  }

                  for (index = pixels.width - 1; index >= height; --index) {
                     if (pixels.pixels[index + pixel * pixels.width] == 0) {
                        width = index + 1;
                        break;
                     }
                  }

                  xPixels[pixel] = height;
                  yPixels[pixel] = width - height;
               }

               cachedSprite = new CachedSprite(pixels.width, pixels.height, yPixels, xPixels, spriteId);
               spriteCache.put(cachedSprite, key);
               return cachedSprite;
            }
         }
      }
   }

   public Font getFont() {
      missingData = false;
      if (this.fontId == -1) {
         return null;
      } else {
         Font font = (Font) fontCache.get((long)this.fontId);
         if (font != null) {
            return font;
         } else {
            font = Class89.decodeFont(Enum1.spriteCacheIndex, anIndexDataBase11, this.fontId, 0);
            if (font != null) {
               fontCache.put(font, (long)this.fontId);
            } else {
               missingData = true;
            }

            return font;
         }
      }
   }

   public Model method593(Sequence sequence, int frameIndex, boolean enabled, PlayerComposition player) {
      missingData = false;
      int type;
      int mediaId;
      if (enabled) {
         type = this.enabledMediaType;
         mediaId = this.enabledMediaId;
      } else {
         type = this.disabledMediaType;
         mediaId = this.disabledMediaId;
      }

      if (type == 0) {
         return null;
      } else if (type == 1 && mediaId == -1) {
         return null;
      } else {
         Model model = (Model) widgetModelCache.get((long)(mediaId + (type << 16)));
         if (model == null) {
            ModelHeader header;
            if (type == 1) {
               header = ModelHeader.getModel(modelCacheIndex, mediaId, 0);
               if (header == null) {
                  missingData = true;
                  return null;
               }

               model = header.applyLighting(64, 768, -50, -10, -50);
            }

            if (type == 2) {
               header = NPCDefinition.getNpcDefinition(mediaId).getChildHeader();
               if (header == null) {
                  missingData = true;
                  return null;
               }

               model = header.applyLighting(64, 768, -50, -10, -50);
            }

            if (type == 3) {
               if (player == null) {
                  return null;
               }

               header = player.method506();
               if (header == null) {
                  missingData = true;
                  return null;
               }

               model = header.applyLighting(64, 768, -50, -10, -50);
            }

            if (type == 4) {
               ItemDefinition definition = ItemDefinition.getDefinition(mediaId);
               header = definition.getAmountModel(10);
               if (header == null) {
                  missingData = true;
                  return null;
               }

               model = header.applyLighting(definition.lightModifier + 64, definition.shadowModifier + 768, -50, -10, -50);
            }

            widgetModelCache.put(model, (long)(mediaId + (type << 16)));
         }

         if (sequence != null) {
            model = sequence.applyFrame(model, frameIndex);
         }

         return model;
      }
   }

   public SpritePixels getImagePixels(int imageIndex) {
      missingData = false;
      if (imageIndex >= 0 && imageIndex < this.images.length) {
         int key = this.images[imageIndex];
         if (key == -1) {
            return null;
         } else {
            SpritePixels pixels = (SpritePixels) spritePixelsCache.get((long)key);
            if (pixels != null) {
               return pixels;
            } else {
               pixels = Class38.decodeSpritePixels(Enum1.spriteCacheIndex, key, 0);
               if (pixels != null) {
                  spritePixelsCache.put(pixels, (long)key);
               } else {
                  missingData = true;
               }

               return pixels;
            }
         }
      } else {
         return null;
      }
   }

   Object[] decodeWidgetParameters(Buffer buffer) {
      int size = buffer.getUnsignedByte();
      if (size == 0) {
         return null;
      } else {
         Object[] objects = new Object[size];

         for (int index = 0; index < size; index++) {
            int type = buffer.getUnsignedByte();
            if (type == 0) {
               objects[index] = new Integer(buffer.readInt());
            } else if (type == 1) {
               objects[index] = buffer.readString();
            }
         }

         this.parametersLoaded = true;
         return objects;
      }
   }

   public void swapItems(int newSlot, int originalSlot) {
      int temp = this.itemIds[originalSlot];
      this.itemIds[originalSlot] = this.itemIds[newSlot];
      this.itemIds[newSlot] = temp;
      temp = this.itemQuantities[originalSlot];
      this.itemQuantities[originalSlot] = this.itemQuantities[newSlot];
      this.itemQuantities[newSlot] = temp;
   }

   public void insertAction(int index, String newAction) {
      if (this.actions == null || this.actions.length <= index) {
         String[] blankActions = new String[index + 1];
         if (this.actions != null) {
            for (int action = 0; action < this.actions.length; action++) {
               blankActions[action] = this.actions[action];
            }
         }

         this.actions = blankActions;
      }

      this.actions[index] = newAction;
   }

   int[] decodeArray(Buffer buffer) {
      int size = buffer.getUnsignedByte();
      if (size == 0) {
         return null;
      } else {
         int[] array = new int[size];

         for (int index = 0; index < size; index++) {
            array[index] = buffer.readInt();
         }

         return array;
      }
   }

}
