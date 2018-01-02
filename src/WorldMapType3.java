import java.io.File;
import java.io.RandomAccessFile;

public class WorldMapType3 implements WorldMapSectionBase {

   static int anInt232;
   int anInt233;
   int anInt234;
   int anInt235;
   int anInt236;
   int anInt237;
   int anInt238;
   int anInt239;
   int anInt240;
   int anInt241;
   int anInt242;
   int anInt243;
   int anInt244;
   int anInt245;
   int anInt246;

   public boolean method5(int int_0, int int_1) {
      return int_0 >= (this.anInt234 << 6) + (this.anInt235 << 3) && int_0 <= (this.anInt234 << 6) + (this.anInt237 << 3) + 7 && int_1 >= (this.anInt240 << 6) + (this.anInt242 << 3) && int_1 <= (this.anInt240 << 6) + (this.anInt243 << 3) + 7;
   }

   public boolean method6(int int_0, int int_1, int int_2) {
      return int_0 >= this.anInt233 && int_0 < this.anInt236 + this.anInt233 ? int_1 >= (this.anInt239 << 6) + (this.anInt238 << 3) && int_1 <= (this.anInt239 << 6) + (this.anInt241 << 3) + 7 && int_2 >= (this.anInt245 << 6) + (this.anInt244 << 3) && int_2 <= (this.anInt245 << 6) + (this.anInt246 << 3) + 7 : false;
   }

   public void method7(WorldMapData worldmapdata_0) {
      if (worldmapdata_0.anInt109 > this.anInt234) {
         worldmapdata_0.anInt109 = this.anInt234;
      }

      if (worldmapdata_0.anInt107 < this.anInt234) {
         worldmapdata_0.anInt107 = this.anInt234;
      }

      if (worldmapdata_0.anInt110 > this.anInt240) {
         worldmapdata_0.anInt110 = this.anInt240;
      }

      if (worldmapdata_0.anInt108 < this.anInt240) {
         worldmapdata_0.anInt108 = this.anInt240;
      }

   }

   public Coordinates method8(int int_0, int int_1) {
      if (!this.method5(int_0, int_1)) {
         return null;
      } else {
         int int_2 = this.anInt239 * 64 - this.anInt234 * 64 + (this.anInt238 * 8 - this.anInt235 * 8) + int_0;
         int int_3 = this.anInt245 * 64 - this.anInt240 * 64 + int_1 + (this.anInt244 * 8 - this.anInt242 * 8);
         return new Coordinates(this.anInt233, int_2, int_3);
      }
   }

   public int[] method9(int int_0, int int_1, int int_2) {
      if (!this.method6(int_0, int_1, int_2)) {
         return null;
      } else {
         int[] ints_0 = new int[] {this.anInt234 * 64 - this.anInt239 * 64 + int_1 + (this.anInt235 * 8 - this.anInt238 * 8), int_2 + (this.anInt240 * 64 - this.anInt245 * 64) + (this.anInt242 * 8 - this.anInt244 * 8)};
         return ints_0;
      }
   }

   public void method10(Buffer buffer_0) {
      this.anInt233 = buffer_0.getUnsignedByte();
      this.anInt236 = buffer_0.getUnsignedByte();
      this.anInt239 = buffer_0.getUnsignedShort();
      this.anInt238 = buffer_0.getUnsignedByte();
      this.anInt241 = buffer_0.getUnsignedByte();
      this.anInt245 = buffer_0.getUnsignedShort();
      this.anInt244 = buffer_0.getUnsignedByte();
      this.anInt246 = buffer_0.getUnsignedByte();
      this.anInt234 = buffer_0.getUnsignedShort();
      this.anInt235 = buffer_0.getUnsignedByte();
      this.anInt237 = buffer_0.getUnsignedByte();
      this.anInt240 = buffer_0.getUnsignedShort();
      this.anInt242 = buffer_0.getUnsignedByte();
      this.anInt243 = buffer_0.getUnsignedByte();
      this.method573();
   }

   void method573() {
   }

   public static boolean method574(File file_0, boolean bool_0) {
      try {
         RandomAccessFile randomaccessfile_0 = new RandomAccessFile(file_0, "rw");
         int int_0 = randomaccessfile_0.read();
         randomaccessfile_0.seek(0L);
         randomaccessfile_0.write(int_0);
         randomaccessfile_0.seek(0L);
         randomaccessfile_0.close();
         if (bool_0) {
            file_0.delete();
         }

         return true;
      } catch (Exception exception_0) {
         return false;
      }
   }

   static void method575() {
      int localPlayers = Class27.localPlayerIndexCount;
      int[] playerIndices = Class27.localPlayerIndices;

      for (int index = 0; index < localPlayers; index++) {
         if (playerIndices[index] != Client.someSelectedPlayerIndex && playerIndices[index] != Client.localInteractingIndex) {
            Class67.method413(Client.players[playerIndices[index]], true);
         }
      }

   }

   static int method576(int int_0) {
      MessageNode messagenode_0 = (MessageNode) Class34.anIterableHashTable1.get((long)int_0);
      return messagenode_0 == null ? -1 : (messagenode_0.next == Class34.aClass77_1.aCacheableNode3 ? -1 : ((MessageNode) messagenode_0.next).id);
   }

}
