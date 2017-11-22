import java.util.Calendar;

public class Class39 {

   static int[] anIntArray22;
   static int[][] SHAPE_VERTICES;
   static int[] intStack;
   static String[] scriptStringStack;
   static int scriptStackCount;
   static ScriptState[] scriptStack;
   static Calendar aCalendar1;
   static final String[] aStringArray1;
   static int anInt97;
   static int[] scriptLocalInts;
   static String[] scriptLocalStrings;
   static IndexedSprite anIndexedSprite3;

   static {
      anIntArray22 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      aCalendar1 = Calendar.getInstance();
      aStringArray1 = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      anInt97 = 0;
   }

   public static Overlay method255(int int_0) {
      Overlay overlay_0 = (Overlay) Overlay.overlays.get((long)int_0);
      if (overlay_0 != null) {
         return overlay_0;
      } else {
         byte[] bytes_0 = Overlay.overlay_ref.getConfigData(4, int_0);
         overlay_0 = new Overlay();
         if (bytes_0 != null) {
            overlay_0.decode(new Buffer(bytes_0), int_0);
         }

         overlay_0.post();
         Overlay.overlays.put(overlay_0, (long)int_0);
         return overlay_0;
      }
   }

   public static void method256() {
      if (Class95.aRSSocket1 != null) {
         Class95.aRSSocket1.close();
      }

   }

   static void synchronizePlayers(PacketBuffer buffer, int int_0) {
      int int_1 = buffer.offset;
      Class27.playerCount = 0;
      Class6.method99(buffer);

      for (int i = 0; i < Class27.playerCount; i++) {
         int playerIndex = Class27.playerIndexes[i];
         Player player_0 = Client.cachedPlayers[playerIndex];
         int maskSize = buffer.readUnsignedByte();
         if ((maskSize & 0x1) != 0) {
            maskSize += buffer.readUnsignedByte() << 8;
         }
         WorldMapData_Sub1.parsePlayerSynchronizationMask(buffer, playerIndex, player_0, maskSize);
      }

      if (buffer.offset - int_1 != int_0) {
         throw new RuntimeException(buffer.offset - int_1 + " " + int_0);
      }
   }

}
