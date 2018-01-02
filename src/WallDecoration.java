public final class WallDecoration {

   public static Buffer aBuffer4;
   public int hash;
   int objectConfig;
   int offsetX;
   int x;
   int y;
   int offsetY;
   int floor;
   public Renderable primaryRenderable;
   public Renderable secondaryRenderable;
   int primaryOrientation;
   int secondaryOrientation;

   WallDecoration() {
      this.hash = 0;
      this.objectConfig = 0;
   }

   static void decodeSprite(byte[] data) {
      Buffer buffer = new Buffer(data);
      buffer.position = data.length - 2;
      Class111.loadedSpriteSize = buffer.getUnsignedShort();
      Class111.loadedHorizontalOffsets = new int[Class111.loadedSpriteSize];
      Class7.loadedVerticalOffsets = new int[Class111.loadedSpriteSize];
      ItemContainer.loadedWidths = new int[Class111.loadedSpriteSize];
      Class6.loadedHeights = new int[Class111.loadedSpriteSize];
      Class111.spritePixels = new byte[Class111.loadedSpriteSize][];
      buffer.position = data.length - 7 - Class111.loadedSpriteSize * 8;
      Class111.loadedMaxWidth = buffer.getUnsignedShort();
      Class111.loadedMaxHeight = buffer.getUnsignedShort();
      int size = (buffer.getUnsignedByte() & 0xFF) + 1;

      int index;
      for (index = 0; index < Class111.loadedSpriteSize; index++) {
         Class111.loadedHorizontalOffsets[index] = buffer.getUnsignedShort();
      }

      for (index = 0; index < Class111.loadedSpriteSize; index++) {
         Class7.loadedVerticalOffsets[index] = buffer.getUnsignedShort();
      }

      for (index = 0; index < Class111.loadedSpriteSize; index++) {
         ItemContainer.loadedWidths[index] = buffer.getUnsignedShort();
      }

      for (index = 0; index < Class111.loadedSpriteSize; index++) {
         Class6.loadedHeights[index] = buffer.getUnsignedShort();
      }

      buffer.position = data.length - 7 - Class111.loadedSpriteSize * 8 - (size - 1) * 3;
      Class111.loadedPixels = new int[size];

      for (index = 1; index < size; index++) {
         Class111.loadedPixels[index] = buffer.read24BitInt();
         if (Class111.loadedPixels[index] == 0) {
            Class111.loadedPixels[index] = 1;
         }
      }

      buffer.position = 0;

      for (index = 0; index < Class111.loadedSpriteSize; index++) {
         int width = ItemContainer.loadedWidths[index];
         int height = Class6.loadedHeights[index];
         int length = width * height;
         byte[] pixelData = new byte[length];
         Class111.spritePixels[index] = pixelData;
         int type = buffer.getUnsignedByte();
         int i;
         if (type == 0) {
            for (i = 0; i < length; i++) {
               pixelData[i] = buffer.readByte();
            }
         } else if (type == 1) {
            for (i = 0; i < width; i++) {
               for (int int_7 = 0; int_7 < height; int_7++) {
                  pixelData[i + width * int_7] = buffer.readByte();
               }
            }
         }
      }

   }

   public static ServerPacket[] method460() {
      return new ServerPacket[] {ServerPacket.regionUpdatePacket, ServerPacket.dynamicRegionPacket, ServerPacket.aServerPacket6, ServerPacket.aServerPacket7, ServerPacket.aServerPacket8, ServerPacket.aServerPacket9, ServerPacket.aServerPacket10, ServerPacket.aServerPacket11, ServerPacket.aServerPacket12, ServerPacket.aServerPacket13, ServerPacket.aServerPacket15, ServerPacket.aServerPacket16, ServerPacket.aServerPacket18, ServerPacket.aServerPacket20, ServerPacket.aServerPacket21, ServerPacket.aServerPacket23, ServerPacket.aServerPacket25, ServerPacket.aServerPacket26, ServerPacket.aServerPacket27, ServerPacket.aServerPacket29, ServerPacket.aServerPacket31, ServerPacket.aServerPacket32, ServerPacket.aServerPacket34, ServerPacket.aServerPacket35, ServerPacket.aServerPacket33, ServerPacket.rootInterfacePacket, ServerPacket.cs2ScriptPacket, ServerPacket.interfaceSettingsPacket, ServerPacket.aServerPacket41, ServerPacket.aServerPacket43, ServerPacket.aServerPacket45, ServerPacket.aServerPacket14, ServerPacket.aServerPacket47, ServerPacket.aServerPacket49, ServerPacket.aServerPacket50, ServerPacket.aServerPacket51, ServerPacket.aServerPacket42, ServerPacket.aServerPacket53, ServerPacket.aServerPacket55, ServerPacket.aServerPacket57, ServerPacket.aServerPacket59, ServerPacket.aServerPacket19, ServerPacket.aServerPacket61, ServerPacket.interfaceTextPacket, ServerPacket.updateUidPacket, ServerPacket.resetCameraPacket, ServerPacket.aServerPacket17, ServerPacket.aServerPacket48, ServerPacket.aServerPacket67, ServerPacket.aServerPacket54, ServerPacket.addClanMemberPacket, ServerPacket.aServerPacket69, ServerPacket.aServerPacket70, ServerPacket.aServerPacket71, ServerPacket.aServerPacket66, ServerPacket.aServerPacket56, ServerPacket.resetVarpPacket, ServerPacket.aServerPacket39, ServerPacket.aServerPacket74, ServerPacket.playerOptionsPacket, ServerPacket.itemOnInterfacePacket, ServerPacket.aServerPacket76, ServerPacket.aServerPacket24, ServerPacket.soundEffectPacket, ServerPacket.setWeightPacket, ServerPacket.energyPacket, ServerPacket.resetAnimationPacket, ServerPacket.addIgnorePacket, ServerPacket.aServerPacket81, ServerPacket.aServerPacket82, ServerPacket.aServerPacket83, ServerPacket.playSongPacket, ServerPacket.aServerPacket77, ServerPacket.varpLargePacket, ServerPacket.varpSmallPacket, ServerPacket.aServerPacket85, ServerPacket.aServerPacket73, ServerPacket.aServerPacket63, ServerPacket.npcUpdatePacket, ServerPacket.skillLvlPacket, ServerPacket.aServerPacket52, ServerPacket.serverMessagePacket, ServerPacket.playerUpdatePacket};
   }

   static Enum5[] method461() {
      return new Enum5[] {Enum5.anEnum5_1, Enum5.anEnum5_3, Enum5.anEnum5_2};
   }

   static int method462(int int_0) {
      ChatLineBuffer chatlinebuffer_0 = (ChatLineBuffer) Class34.chatLineMap.get(Integer.valueOf(int_0));
      return chatlinebuffer_0 == null ? 0 : chatlinebuffer_0.method12();
   }

}
