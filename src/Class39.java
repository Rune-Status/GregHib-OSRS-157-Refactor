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
        aStringArray1 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        anInt97 = 0;
    }

    public static Overlay getOverlay(int id) {
        Overlay overlay = (Overlay) Overlay.overlays.get((long) id);
        if (overlay != null) {
            return overlay;
        } else {
            byte[] data = Overlay.overlay_ref.getConfigData(4, id);
            overlay = new Overlay();
            if (data != null) {
                overlay.decode(new Buffer(data));
            }

            overlay.post();
            Overlay.overlays.put(overlay, (long) id);
            return overlay;
        }
    }

    public static void method256() {
        if (Class95.aRSSocket1 != null) {
            Class95.aRSSocket1.close();
        }
    }

    static void synchronizePlayers(PacketBuffer buffer, int length) {
        int offset = buffer.offset;
        Class27.playerCount = 0;
        Class6.synchronizePlayers(buffer);

        for (int i = 0; i < Class27.playerCount; i++) {
            int playerIndex = Class27.playersAwaitingUpdate[i];
            Player player_0 = Client.players[playerIndex];
            int mask = buffer.readUnsignedByte();
            if ((mask & 0x1) != 0) {
                mask += buffer.readUnsignedByte() << 8;
            }
            WorldMapData_Sub1.parsePlayerSynchronizationMask(buffer, playerIndex, player_0, mask);
        }

        if (buffer.offset - offset != length) {
            throw new RuntimeException(buffer.offset - offset + " " + length);
        }
    }

}
