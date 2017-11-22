public final class DecorativeObject {

   public static Buffer aBuffer4;
   public int hash;
   int renderInfoBitPacked;
   int offsetX;
   int x;
   int y;
   int offsetY;
   int floor;
   public Renderable renderable1;
   public Renderable renderable2;
   int renderFlag;
   int rotation;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   static void decodeSprite(byte[] bytes_0) {
      Buffer buffer_0 = new Buffer(bytes_0);
      buffer_0.offset = bytes_0.length - 2;
      Class111.anInt216 = buffer_0.readUnsignedShort();
      Class111.anIntArray54 = new int[Class111.anInt216];
      Class7.offsetsY = new int[Class111.anInt216];
      ItemContainer.anIntArray76 = new int[Class111.anInt216];
      Class6.anIntArray3 = new int[Class111.anInt216];
      Class111.spritePixels = new byte[Class111.anInt216][];
      buffer_0.offset = bytes_0.length - 7 - Class111.anInt216 * 8;
      Class111.anInt214 = buffer_0.readUnsignedShort();
      Class111.anInt215 = buffer_0.readUnsignedShort();
      int int_0 = (buffer_0.readUnsignedByte() & 0xFF) + 1;

      int int_1;
      for (int_1 = 0; int_1 < Class111.anInt216; int_1++) {
         Class111.anIntArray54[int_1] = buffer_0.readUnsignedShort();
      }

      for (int_1 = 0; int_1 < Class111.anInt216; int_1++) {
         Class7.offsetsY[int_1] = buffer_0.readUnsignedShort();
      }

      for (int_1 = 0; int_1 < Class111.anInt216; int_1++) {
         ItemContainer.anIntArray76[int_1] = buffer_0.readUnsignedShort();
      }

      for (int_1 = 0; int_1 < Class111.anInt216; int_1++) {
         Class6.anIntArray3[int_1] = buffer_0.readUnsignedShort();
      }

      buffer_0.offset = bytes_0.length - 7 - Class111.anInt216 * 8 - (int_0 - 1) * 3;
      Class111.anIntArray55 = new int[int_0];

      for (int_1 = 1; int_1 < int_0; int_1++) {
         Class111.anIntArray55[int_1] = buffer_0.read24BitInt();
         if (Class111.anIntArray55[int_1] == 0) {
            Class111.anIntArray55[int_1] = 1;
         }
      }

      buffer_0.offset = 0;

      for (int_1 = 0; int_1 < Class111.anInt216; int_1++) {
         int int_2 = ItemContainer.anIntArray76[int_1];
         int int_3 = Class6.anIntArray3[int_1];
         int int_4 = int_2 * int_3;
         byte[] bytes_1 = new byte[int_4];
         Class111.spritePixels[int_1] = bytes_1;
         int int_5 = buffer_0.readUnsignedByte();
         int int_6;
         if (int_5 == 0) {
            for (int_6 = 0; int_6 < int_4; int_6++) {
               bytes_1[int_6] = buffer_0.readByte();
            }
         } else if (int_5 == 1) {
            for (int_6 = 0; int_6 < int_2; int_6++) {
               for (int int_7 = 0; int_7 < int_3; int_7++) {
                  bytes_1[int_6 + int_2 * int_7] = buffer_0.readByte();
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
