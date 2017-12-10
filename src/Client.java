import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

import netscape.javascript.JSObject;

public final class Client extends GameEngine {

    static boolean aBool84;
    static int anInt608;
    static int rights;
    static int widgetRoot;
    static Widget aWidget9;
    static int menuOptionCount;
    static int gameCycle;
    static int gameState;
    public static final Class46 aClass46_1;
    static int world;
    static int anInt609;
    static int anInt610;
    static int anInt611;
    static long aLong30;
    static int anInt612;
    static int js5State;
    static int anInt613;
    static int flags;
    static int[] menuTypes;
    static boolean[] aBoolArray8;
    static int anInt614;
    static int loginState;
    static boolean[] aBoolArray9;
    static int socketType;
    static boolean isMenuOpen;
    static Class100 aClass100_1;
    static boolean[] aBoolArray10;
    static int anInt615;
    static boolean[] aBoolArray11;
    static String[] menuTargets;
    static boolean aBool85;
    public static boolean isMembers;
    static boolean socketError;
    static int anInt616;
    static boolean lowMemory;
    static String[] menuOptions;
    static boolean isResized;
    static int languageId;
    static int anInt617;
    static boolean aBool86;
    static boolean aBool87;
    static int anInt618;
    static boolean aBool88;
    static int anInt619;
    static boolean aBool89;
    static int[] menuActionParams0;
    static int anInt620;
    static long aLong31;
    static int[] menuActionParams1;
    static int anInt621;
    static int anInt622;
    static int anInt623;
    static HashTable widgetFlags;
    static int anInt624;
    static Widget aWidget10;
    static boolean aBool90;
    static int[] menuIdentifiers;
    static int gameDrawingMode;
    static int[] widgetPositionX;
    static boolean displayFps;
    static boolean aBool91;
    static int[] widgetBoundsWidth;
    static int anInt625;
    static int anInt626;
    static int anInt627;
    static int itemSelectionState;
    static HashTable componentTable;
    static int hintArrowTargetType;
    static boolean spellSelected;
    static int hintArrowNpcTargetIdx;
    static Widget aWidget11;
    static int[] boostedSkillLevels;
    static int hintArrowPlayerTargetIdx;
    static int anInt628;
    static int[] widgetBoundsHeight;
    static int anInt629;
    static int anInt630;
    static int hintArrowX;
    static int[] widgetPositionY;
    static final TileStrategy routeStrategy;
    static int anInt631;
    static int hintArrowY;
    static int[] realSkillLevels;
    static int anInt632;
    static String aString34;
    static String aString35;
    static int anInt633;
    static int hintArrowType;
    static int anInt634;
    static int anInt635;
    static String aString36;
    static int[] skillExperiences;
    static int hintArrowOffsetX;
    static int anInt636;
    static int hintArrowOffsetY;
    static int anInt637;
    static boolean[] aBoolArray12;
    static Enum3 anEnum3_5;
    static int[] anIntArray142;
    static int anInt638;
    static Enum2 anEnum2_5;
    static int loadingStage;
    static int[] anIntArray143;
    static int weight;
    static int anInt639;
    static Player[] players;
    static int[] anIntArray144;
    static int cycleCntr;
    static CollisionData[] collisionMaps;
    static Enum2 anEnum2_6;
    static int anInt640;
    static int anInt641;
    static int[] anIntArray145;
    static boolean aBool92;
    static int[] tileQueueX;
    static int anInt642;
    static int[] tileQueueY;
    static int anInt643;
    static int cursorState;
    static int anInt644;
    static Deque aDeque7;
    static int anInt645;
    static int destinationX;
    static int anInt646;
    static int anInt647;
    static final int[] OBJECT_GROUPS;
    static int destinationY;
    static int[] anIntArray149;
    static boolean aBool93;
    static Widget aWidget12;
    static int[] anIntArray150;
    static int[] anIntArray151;
    static int anInt648;
    static int anInt649;
    static int energy;
    static int anInt650;
    static int[] anIntArray152;
    static Deque pendingSpawns;
    static int anInt651;
    static byte[] aByteArray28;
    static int anInt652;
    static SoundEffect[] audioEffects;
    static NPC[] cachedNPCs;
    static int[] anIntArray153;
    static int npcIndexesCount;
    static HashMap aHashMap9;
    static int[] npcIndices;
    static boolean aBool94;
    static int pendingNpcFlagsCount;
    static Deque[][][] groundItemDeque;
    static int[] pendingNpcFlagsIndices;
    static int anInt653;
    static int anInt654;
    static Deque graphicsObjectDeque;
    static RenderOverview renderOverview;
    static PlayerComposition aPlayerComposition1;
    static int anInt655;
    static int anInt656;
    static int[] anIntArray154;
    static int anInt657;
    static Widget aWidget13;
    static int anInt658;
    static int anInt659;
    static int friendCount;
    static long aLong32;
    static Friend[] friends;
    static boolean isDynamicRegion;
    static int anInt660;
    static int anInt661;
    static int anInt662;
    static int mapAngle;
    static int ignoreCount;
    static Ignore[] ignores;
    static int[] interfaceItemTriggers;
    static int[][][] localRegions;
    static int anInt663;
    static SpritePixels[] mapIcons;
    static int localInteractingIndex;
    static Deque projectiles;
    static int anInt664;
    static int[] anIntArray155;
    static Class72 aClass72_1;
    static int anInt665;
    static int[] anIntArray156;
    static GrandExchangeOffer[] grandExchangeOffers;
    static int anInt666;
    static int anInt667;
    static int anInt668;
    static int anInt669;
    static boolean aBool95;
    static int anInt670;
    static int anInt671;
    static int anInt672;
    static int[] anIntArray157;
    static int anInt673;
    static int anInt674;
    static int anInt675;
    static boolean aBool96;
    static int anInt676;
    static int anInt677;
    static int anInt678;
    static int anInt679;
    static int anInt680;
    static int viewportHeight;
    static int viewportWidth;
    static int anInt681;
    static int anInt682;
    static int anInt683;
    static int anInt684;
    static int anInt685;
    static int anInt686;
    static int anInt687;
    static int anInt688;
    static int[][] anIntArrayArray21;
    static int[] anIntArray158;
    static int anInt689;
    static int anInt690;
    static int anInt691;
    static int anInt692;
    static int[] anIntArray159;
    static int[] anIntArray160;
    static int[] anIntArray161;
    static short aShort3;
    static short aShort4;
    static int[] anIntArray162;
    static int[] anIntArray163;
    static int[] anIntArray164;
    static short aShort5;
    static int[] anIntArray165;
    static short aShort6;
    static int[] anIntArray166;
    static String clanChatOwner;
    static int[] anIntArray167;
    static short aShort7;
    static short aShort8;
    static Deque aDeque8;
    static short aShort9;
    static short aShort10;
    static String[] aStringArray6;
    static Deque aDeque9;
    static boolean aBool97;
    static int scale;
    static int clanChatCount;
    static int screenY;
    static int screenX;
    static boolean aBool98;
    static String clanChatName;
    static Class20 aClass20_1;
    static int anInt693;
    static int onTutorialIsland;
    static long[] aLongArray4;
    static int anInt695;
    static String[] playerOptions;
    static int anInt696;
    static boolean[] playerOptionsPriorities;
    static final int[] playerMenuTypes;
    static int anInt697;
    static boolean aBool99;
    static String aString37;
    static int chatCycle;
    static int[] anIntArray168;

    static {
        aBool84 = true;
        world = 1;
        flags = 0;
        socketType = 0;
        isMembers = false;
        lowMemory = false;
        languageId = 0;
        gameState = 0;
        aBool88 = true;
        gameCycle = 0;
        aLong31 = -1L;
        anInt622 = -1;
        anInt623 = -1;
        anInt624 = -1;
        aBool90 = true;
        displayFps = false;
        anInt608 = 0;
        hintArrowTargetType = 0;
        hintArrowNpcTargetIdx = 0;
        hintArrowPlayerTargetIdx = 0;
        hintArrowX = 0;
        hintArrowY = 0;
        hintArrowType = 0;
        hintArrowOffsetX = 0;
        hintArrowOffsetY = 0;
        anEnum2_5 = Enum2.anEnum2_4;
        anEnum2_6 = Enum2.anEnum2_4;
        loadingStage = 0;
        js5State = 0;
        anInt612 = 0;
        anInt617 = 0;
        loginState = 0;
        anInt618 = 0;
        anInt614 = 0;
        anInt648 = 0;
        anEnum3_5 = Enum3.anEnum3_3;
        aByteArray28 = null;
        cachedNPCs = new NPC[32768];
        npcIndexesCount = 0;
        npcIndices = new int[32768];
        pendingNpcFlagsCount = 0;
        pendingNpcFlagsIndices = new int[250];
        aClass46_1 = new Class46();
        anInt609 = 0;
        socketError = false;
        aClass100_1 = new Class100();
        aHashMap9 = new HashMap();
        anInt631 = 0;
        anInt632 = 1;
        anInt633 = 0;
        anInt634 = 1;
        anInt630 = 0;
        collisionMaps = new CollisionData[4];
        isDynamicRegion = false;
        localRegions = new int[4][13][13];
        OBJECT_GROUPS = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        anInt625 = 0;
        anInt671 = 2301979;
        anInt673 = 5063219;
        anInt674 = 3353893;
        anInt675 = 7759444;
        aBool96 = false;
        anInt677 = 0;
        anInt661 = 128;
        mapAngle = 0;
        anInt681 = 0;
        anInt684 = 0;
        anInt685 = 0;
        anInt687 = 0;
        anInt688 = 50;
        anInt637 = 0;
        aBool92 = false;
        anInt690 = 0;
        anInt691 = 0;
        anInt692 = 50;
        anIntArray159 = new int[anInt692];
        anIntArray160 = new int[anInt692];
        anIntArray161 = new int[anInt692];
        anIntArray162 = new int[anInt692];
        anIntArray163 = new int[anInt692];
        anIntArray165 = new int[anInt692];
        anIntArray167 = new int[anInt692];
        aStringArray6 = new String[anInt692];
        anIntArrayArray21 = new int[104][104];
        anInt664 = 0;
        screenY = -1;
        screenX = -1;
        anInt641 = 0;
        anInt642 = 0;
        anInt645 = 0;
        cursorState = 0;
        anInt651 = 0;
        anInt653 = 0;
        anInt635 = 0;
        anInt628 = 0;
        anInt629 = 0;
        anInt693 = 0;
        aBool91 = false;
        anInt627 = 0;
        onTutorialIsland = 0;
        players = new Player[2048];
        localInteractingIndex = -1;
        anInt678 = 0;
        anInt666 = 0;
        anIntArray157 = new int[1000];
        playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
        playerOptions = new String[8];
        playerOptionsPriorities = new boolean[8];
        anIntArray158 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
        anInt667 = -1;
        groundItemDeque = new Deque[4][104][104];
        pendingSpawns = new Deque();
        projectiles = new Deque();
        graphicsObjectDeque = new Deque();
        boostedSkillLevels = new int[25];
        realSkillLevels = new int[25];
        skillExperiences = new int[25];
        anInt613 = 0;
        isMenuOpen = false;
        menuOptionCount = 0;
        menuActionParams0 = new int[500];
        menuActionParams1 = new int[500];
        menuTypes = new int[500];
        menuIdentifiers = new int[500];
        menuOptions = new String[500];
        menuTargets = new String[500];
        aBoolArray9 = new boolean[500];
        aBool98 = false;
        aBool97 = false;
        anInt615 = -1;
        anInt616 = -1;
        anInt670 = 0;
        anInt668 = 50;
        itemSelectionState = 0;
        aString35 = null;
        spellSelected = false;
        anInt656 = -1;
        anInt676 = -1;
        aString34 = null;
        aString36 = null;
        widgetRoot = -1;
        componentTable = new HashTable(8);
        anInt665 = 0;
        anInt672 = 0;
        aWidget12 = null;
        energy = 0;
        weight = 0;
        rights = 0;
        anInt682 = -1;
        aBool95 = false;
        aBool89 = false;
        aBool99 = false;
        aWidget11 = null;
        aWidget9 = null;
        aWidget10 = null;
        anInt619 = 0;
        anInt620 = 0;
        aWidget13 = null;
        aBool86 = false;
        anInt621 = -1;
        anInt626 = -1;
        aBool85 = false;
        anInt638 = -1;
        anInt639 = -1;
        aBool93 = false;
        cycleCntr = 1;
        anIntArray151 = new int[32];
        anInt649 = 0;
        interfaceItemTriggers = new int[32];
        anInt663 = 0;
        anIntArray154 = new int[32];
        anInt659 = 0;
        chatCycle = 0;
        anInt658 = 0;
        anInt697 = 0;
        anInt669 = 0;
        anInt695 = 0;
        anInt640 = 0;
        anInt636 = 0;
        aDeque7 = new Deque();
        aDeque8 = new Deque();
        aDeque9 = new Deque();
        widgetFlags = new HashTable(512);
        anInt610 = 0;
        anInt611 = -2;
        aBoolArray8 = new boolean[100];
        aBoolArray11 = new boolean[100];
        aBoolArray10 = new boolean[100];
        widgetPositionX = new int[100];
        widgetPositionY = new int[100];
        widgetBoundsWidth = new int[100];
        widgetBoundsHeight = new int[100];
        gameDrawingMode = 0;
        aLong30 = 0L;
        isResized = true;
        anIntArray168 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
        anInt683 = 0;
        anInt686 = 0;
        aString37 = "";
        aLongArray4 = new long[100];
        anInt696 = 0;
        anInt689 = 0;
        anIntArray166 = new int[128];
        anIntArray164 = new int[128];
        aLong32 = -1L;
        clanChatOwner = null;
        clanChatName = null;
        anInt652 = -1;
        anInt660 = 0;
        anIntArray155 = new int[1000];
        anIntArray156 = new int[1000];
        mapIcons = new SpritePixels[1000];
        destinationX = 0;
        destinationY = 0;
        anInt650 = 0;
        anInt662 = 255;
        anInt643 = -1;
        aBool87 = false;
        anInt644 = 127;
        anInt646 = 127;
        anInt647 = 0;
        anIntArray149 = new int[50];
        anIntArray150 = new int[50];
        anIntArray152 = new int[50];
        anIntArray153 = new int[50];
        audioEffects = new SoundEffect[50];
        aBool94 = false;
        aBoolArray12 = new boolean[5];
        anIntArray142 = new int[5];
        anIntArray143 = new int[5];
        anIntArray144 = new int[5];
        anIntArray145 = new int[5];
        aShort4 = 256;
        aShort3 = 205;
        aShort9 = 256;
        aShort8 = 320;
        aShort10 = 1;
        aShort7 = 32767;
        aShort5 = 1;
        aShort6 = 32767;
        anInt679 = 0;
        anInt680 = 0;
        viewportHeight = 0;
        viewportWidth = 0;
        scale = 0;
        friendCount = 0;
        anInt655 = 0;
        friends = new Friend[400];
        aClass72_1 = new Class72();
        ignoreCount = 0;
        ignores = new Ignore[400];
        aPlayerComposition1 = new PlayerComposition();
        anInt654 = -1;
        anInt657 = -1;
        grandExchangeOffers = new GrandExchangeOffer[8];
        aClass20_1 = new Class20();
        routeStrategy = new TileStrategy();
        tileQueueX = new int[50];
        tileQueueY = new int[50];
    }

    void processJS5Connection() {
        if (gameState != 1000) {
            boolean bool_0 = Class40.method258();
            if (!bool_0) {
                this.method1102();
            }

        }
    }

    void method1097() {
        int int_0 = Tile.canvasWidth;
        int int_1 = Class29.canvasHeight;
        if (super.anInt589 < int_0) {
            int_0 = super.anInt589;
        }

        if (super.anInt591 < int_1) {
            int_1 = super.anInt591;
        }

        if (Buffer.preferences != null) {
            try {
                Client client_1 = AClass3.clientInstance;
                int int_2 = isResized ? 2 : 1;
                Object[] objects_0 = new Object[]{Integer.valueOf(int_2)};
                JSObject.getWindow(client_1).call("resize", objects_0);
            } catch (Throwable throwable_0) {
                ;
            }
        }

    }

    protected void method1072() {
        if (Class40.chatMessages.changed()) {
            Class40.chatMessages.serialize();
        }

        if (Class48.aClass18_1 != null) {
            Class48.aClass18_1.aBool7 = false;
        }

        Class48.aClass18_1 = null;
        aClass46_1.method278();
        PacketNode.method679();
        if (MouseInput.mouse != null) {
            MouseInput mouseinput_0 = MouseInput.mouse;
            synchronized (mouseinput_0) {
                MouseInput.mouse = null;
            }
        }

        Class23.anInterface4_1 = null;
        if (Class35.soundSystem0 != null) {
            Class35.soundSystem0.method344();
        }

        if (Class47.soundSystem1 != null) {
            Class47.soundSystem1.method344();
        }

        Class39.method256();
        Object object_0 = Class91.anObject2;
        synchronized (object_0) {
            if (Class91.anInt191 != 0) {
                Class91.anInt191 = 1;

                try {
                    Class91.anObject2.wait();
                } catch (InterruptedException interruptedexception_0) {
                    ;
                }
            }
        }

        if (BuildType.aClass55_1 != null) {
            BuildType.aClass55_1.method352();
            BuildType.aClass55_1 = null;
        }

        try {
            Class64.aCacheFile2.method563();

            for (int int_0 = 0; int_0 < Class64.anInt167; int_0++) {
                Class64.aCacheFileArray1[int_0].method563();
            }

            Class64.aCacheFile3.method563();
            Class64.aCacheFile1.method563();
        } catch (Exception exception_0) {
            ;
        }

    }

    protected void method1073() {
        GameObject.method564(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
        DynamicObject.anInt577 = socketType == 0 ? 43594 : world + 40000;
        MessageNode.anInt509 = socketType == 0 ? 443 : world + 50000;
        AClass3.myWorldPort = DynamicObject.anInt577;
        PlayerComposition.colorsToFind = Class88.aShortArray3;
        PlayerComposition.colorsToReplace = Class88.aShortArrayArray1;
        Class26.aShortArray2 = Class88.aShortArray4;
        Class104.aShortArrayArray3 = Class88.aShortArrayArray2;
        BuildType.aClass55_1 = new Class55();
        this.method1080();
        this.method1081();
        Class23.anInterface4_1 = this.method1082();
        MilliTimer.anIndexFile3 = new IndexFile(255, Class64.aCacheFile2, Class64.aCacheFile3, 500000);
        Buffer.preferences = Class36.method248();
        this.method1084();
        String string_0 = BaseVarType.aString19;
        Class23.anApplet1 = this;
        Class23.aString3 = string_0;
        if (socketType != 0) {
            displayFps = true;
        }

        Class43.method266(Buffer.preferences.screenType);
    }

    void method1098(boolean bool_0) {
        int int_0 = widgetRoot;
        int int_1 = Tile.canvasWidth;
        int int_2 = Class29.canvasHeight;
        if (CombatInfoListHolder.loadWidget(int_0)) {
            Timer.method586(Class91.widgets[int_0], -1, int_1, int_2, bool_0);
        }

    }

    void error(int int_0) {
        Class3.socket = null;
        Class88.rssocket = null;
        js5State = 0;
        if (DynamicObject.anInt577 == AClass3.myWorldPort) {
            AClass3.myWorldPort = MessageNode.anInt509;
        } else {
            AClass3.myWorldPort = DynamicObject.anInt577;
        }

        ++anInt617;
        if (anInt617 >= 2 && (int_0 == 7 || int_0 == 9)) {
            if (gameState <= 5) {
                this.error("js5connect_full");
                gameState = 1000;
            } else {
                anInt612 = 3000;
            }
        } else if (anInt617 >= 2 && int_0 == 6) {
            this.error("js5connect_outofdate");
            gameState = 1000;
        } else if (anInt617 >= 4) {
            if (gameState <= 5) {
                this.error("js5connect");
                gameState = 1000;
            } else {
                anInt612 = 3000;
            }
        }

    }

    boolean method1099() {
        int int_0 = menuOptionCount - 1;
        if (menuOptionCount > 2) {
            if (anInt613 != 1 || aBoolArray9[int_0]) {
                boolean bool_0;
                if (int_0 < 0) {
                    bool_0 = false;
                } else {
                    int int_1 = menuTypes[int_0];
                    if (int_1 >= 2000) {
                        int_1 -= 2000;
                    }

                    if (int_1 == 1007) {
                        bool_0 = true;
                    } else {
                        bool_0 = false;
                    }
                }

                if (!bool_0) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    protected void method1075() {
    }

    boolean method1100(Class46 class46_0) {
        RSSocket rssocket_0 = class46_0.createSocket();
        PacketBuffer packetbuffer_0 = class46_0.aPacketBuffer1;
        if (rssocket_0 == null) {
            return false;
        } else {
            int int_2;
            String string_1;
            try {
                int int_0;
                if (class46_0.serverPacket == null) {
                    if (class46_0.aBool18) {
                        if (!rssocket_0.method568(1)) {
                            return false;
                        }

                        rssocket_0.read(class46_0.aPacketBuffer1.buffer, 0, 1);
                        class46_0.anInt103 = 0;
                        class46_0.aBool18 = false;
                    }

                    packetbuffer_0.position = 0;
                    if (packetbuffer_0.method904()) {
                        if (!rssocket_0.method568(1)) {
                            return false;
                        }

                        rssocket_0.read(class46_0.aPacketBuffer1.buffer, 1, 1);
                        class46_0.anInt103 = 0;
                    }

                    class46_0.aBool18 = true;
                    ServerPacket[] serverpackets_0 = DecorativeObject.method460();
                    int_0 = packetbuffer_0.method906();
                    if (int_0 < 0 || int_0 >= serverpackets_0.length) {
                        throw new IOException(int_0 + " " + packetbuffer_0.position);
                    }

                    class46_0.serverPacket = serverpackets_0[int_0];
                    class46_0.packetLength = class46_0.serverPacket.packetLength;
                }

                if (class46_0.packetLength == -1) {
                    if (!rssocket_0.method568(1)) {
                        return false;
                    }

                    class46_0.createSocket().read(packetbuffer_0.buffer, 0, 1);
                    class46_0.packetLength = packetbuffer_0.buffer[0] & 0xFF;
                }

                if (class46_0.packetLength == -2) {
                    if (!rssocket_0.method568(2)) {
                        return false;
                    }

                    class46_0.createSocket().read(packetbuffer_0.buffer, 0, 2);
                    packetbuffer_0.position = 0;
                    class46_0.packetLength = packetbuffer_0.getUnsignedShort();
                }

                if (!rssocket_0.method568(class46_0.packetLength)) {
                    return false;
                }

                packetbuffer_0.position = 0;
                rssocket_0.read(packetbuffer_0.buffer, 0, class46_0.packetLength);
                class46_0.anInt103 = 0;
                aClass100_1.method527();
                class46_0.aServerPacket2 = class46_0.aServerPacket1;
                class46_0.aServerPacket1 = class46_0.aServerPacket3;
                class46_0.aServerPacket3 = class46_0.serverPacket;
                int int_1;
                Widget widget_1;
                if (ServerPacket.aServerPacket14 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.readUnsignedShortOb1();
                    int_0 = packetbuffer_0.method706();
                    widget_1 = Junk.method671(int_0);
                    if (widget_1 != null && widget_1.type == 0) {
                        if (int_1 > widget_1.scrollHeight - widget_1.height) {
                            int_1 = widget_1.scrollHeight - widget_1.height;
                        }

                        if (int_1 < 0) {
                            int_1 = 0;
                        }

                        if (int_1 != widget_1.scrollY) {
                            widget_1.scrollY = int_1;
                            WorldMapData.method305(widget_1);
                        }
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                int int_11;
                if (ServerPacket.aServerPacket17 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.getUnsignedByte();
                    int_0 = packetbuffer_0.getUnsignedByte();
                    int_2 = packetbuffer_0.getUnsignedByte();
                    int_11 = packetbuffer_0.getUnsignedByte();
                    aBoolArray12[int_1] = true;
                    anIntArray142[int_1] = int_0;
                    anIntArray143[int_1] = int_2;
                    anIntArray144[int_1] = int_11;
                    anIntArray145[int_1] = 0;
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket19 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.method707();
                    int_0 = packetbuffer_0.readInt();
                    widget_1 = Junk.method671(int_0);
                    if (int_1 != widget_1.anInt277 || int_1 == -1) {
                        widget_1.anInt277 = int_1;
                        widget_1.anInt281 = 0;
                        widget_1.anInt280 = 0;
                        WorldMapData.method305(widget_1);
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.setWeightPacket == class46_0.serverPacket) {
                    Class12.method165();
                    weight = packetbuffer_0.readShort();
                    anInt640 = cycleCntr;
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket24 == class46_0.serverPacket) {
                    for (int_1 = 0; int_1 < Settings.widgetSettings.length; int_1++) {
                        if (Settings.widgetSettings[int_1] != Settings.settings[int_1]) {
                            Settings.widgetSettings[int_1] = Settings.settings[int_1];
                            DynamicObject.method1064(int_1);
                            anIntArray151[++anInt649 - 1 & 0x1F] = int_1;
                        }
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket15 == class46_0.serverPacket) {
                    ScriptVarType.method468(Class59.aClass59_3);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.soundEffectPacket == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.getUnsignedShort();
                    int_0 = packetbuffer_0.getUnsignedByte();
                    int_2 = packetbuffer_0.getUnsignedShort();
                    if (anInt644 != 0 && int_0 != 0 && anInt647 < 50) {
                        anIntArray149[anInt647] = int_1;
                        anIntArray150[anInt647] = int_0;
                        anIntArray152[anInt647] = int_2;
                        audioEffects[anInt647] = null;
                        anIntArray153[anInt647] = 0;
                        ++anInt647;
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.itemOnInterfacePacket == class46_0.serverPacket) {
                    hintArrowTargetType = packetbuffer_0.getUnsignedByte();
                    if (hintArrowTargetType == 1) {
                        hintArrowNpcTargetIdx = packetbuffer_0.getUnsignedShort();
                    }

                    if (hintArrowTargetType >= 2 && hintArrowTargetType <= 6) {
                        if (hintArrowTargetType == 2) {
                            hintArrowOffsetX = 64;
                            hintArrowOffsetY = 64;
                        }

                        if (hintArrowTargetType == 3) {
                            hintArrowOffsetX = 0;
                            hintArrowOffsetY = 64;
                        }

                        if (hintArrowTargetType == 4) {
                            hintArrowOffsetX = 128;
                            hintArrowOffsetY = 64;
                        }

                        if (hintArrowTargetType == 5) {
                            hintArrowOffsetX = 64;
                            hintArrowOffsetY = 0;
                        }

                        if (hintArrowTargetType == 6) {
                            hintArrowOffsetX = 64;
                            hintArrowOffsetY = 128;
                        }

                        hintArrowTargetType = 2;
                        hintArrowX = packetbuffer_0.getUnsignedShort();
                        hintArrowY = packetbuffer_0.getUnsignedShort();
                        hintArrowType = packetbuffer_0.getUnsignedByte();
                    }

                    if (hintArrowTargetType == 10) {
                        hintArrowPlayerTargetIdx = packetbuffer_0.getUnsignedShort();
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                WidgetNode widgetnode_1;
                if (ServerPacket.aServerPacket33 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.readNegUByte();
                    int_0 = packetbuffer_0.getUnsignedShortInverse();
                    int_2 = packetbuffer_0.method714();
                    widgetnode_1 = (WidgetNode) componentTable.get((long) int_2);
                    if (widgetnode_1 != null) {
                        Frames.method873(widgetnode_1, int_0 != widgetnode_1.id);
                    }

                    Class33.method241(int_2, int_0, int_1);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket23 == class46_0.serverPacket) {
                    ScriptVarType.method468(Class59.aClass59_8);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.resetVarpPacket == class46_0.serverPacket) {
                    for (int_1 = 0; int_1 < VarPlayerType.anInt508; int_1++) {
                        VarPlayerType varplayertype_0 = ClanMember.method677(int_1);
                        if (varplayertype_0 != null) {
                            Settings.settings[int_1] = 0;
                            Settings.widgetSettings[int_1] = 0;
                        }
                    }

                    Class12.method165();
                    anInt649 += 32;
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket39 == class46_0.serverPacket) {
                    anInt650 = packetbuffer_0.getUnsignedByte();
                    class46_0.serverPacket = null;
                    return true;
                }

                boolean bool_5;
                if (ServerPacket.aServerPacket42 == class46_0.serverPacket) {
                    bool_5 = packetbuffer_0.getUnsignedByteS() == 1;
                    int_0 = packetbuffer_0.method714();
                    widget_1 = Junk.method671(int_0);
                    if (bool_5 != widget_1.isHidden) {
                        widget_1.isHidden = bool_5;
                        WorldMapData.method305(widget_1);
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.skillLvlPacket == class46_0.serverPacket) {
                    Class12.method165();
                    int_1 = packetbuffer_0.method706();
                    int_0 = packetbuffer_0.getUnsignedByteC();
                    int_2 = packetbuffer_0.getUnsignedByte();
                    skillExperiences[int_0] = int_1;
                    boostedSkillLevels[int_0] = int_2;
                    realSkillLevels[int_0] = 1;

                    for (int_11 = 0; int_11 < 98; int_11++) {
                        if (int_1 >= Class85.anIntArray45[int_11]) {
                            realSkillLevels[int_0] = int_11 + 2;
                        }
                    }

                    anIntArray154[++anInt659 - 1 & 0x1F] = int_0;
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.varpSmallPacket == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.getUnsignedShortInverse();
                    byte byte_2 = packetbuffer_0.getByteA();
                    Settings.settings[int_1] = byte_2;
                    if (Settings.widgetSettings[int_1] != byte_2) {
                        Settings.widgetSettings[int_1] = byte_2;
                    }

                    DynamicObject.method1064(int_1);
                    anIntArray151[++anInt649 - 1 & 0x1F] = int_1;
                    class46_0.serverPacket = null;
                    return true;
                }

                int int_3;
                int int_4;
                int int_12;
                if (ServerPacket.aServerPacket48 == class46_0.serverPacket) {
                    aBool94 = true;
                    Class9.anInt42 = packetbuffer_0.getUnsignedByte();
                    Class17.anInt69 = packetbuffer_0.getUnsignedByte();
                    CombatInfo1.anInt351 = packetbuffer_0.getUnsignedShort();
                    TextureProvider.anInt225 = packetbuffer_0.getUnsignedByte();
                    AClass3_Sub1.anInt402 = packetbuffer_0.getUnsignedByte();
                    if (AClass3_Sub1.anInt402 >= 100) {
                        int_1 = Class9.anInt42 * 128 + 64;
                        int_0 = Class17.anInt69 * 128 + 64;
                        int_2 = Class18.getTileHeight(int_1, int_0, Ignore.plane) - CombatInfo1.anInt351;
                        int_11 = int_1 - Class2.cameraX;
                        int_12 = int_2 - Class18.cameraZ;
                        int_3 = int_0 - Player.cameraY;
                        int_4 = (int) Math.sqrt((double) (int_11 * int_11 + int_3 * int_3));
                        AClass1.cameraPitch = (int) (Math.atan2((double) int_12, (double) int_4) * 325.949D) & 0x7FF;
                        Enum4.cameraYaw = (int) (Math.atan2((double) int_11, (double) int_3) * -325.949D) & 0x7FF;
                        if (AClass1.cameraPitch < 128) {
                            AClass1.cameraPitch = 128;
                        }

                        if (AClass1.cameraPitch > 383) {
                            AClass1.cameraPitch = 383;
                        }
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                Widget widget_2;
                if (ServerPacket.aServerPacket49 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.readInt();
                    widget_2 = Junk.method671(int_1);

                    for (int_2 = 0; int_2 < widget_2.itemIds.length; int_2++) {
                        widget_2.itemIds[int_2] = -1;
                        widget_2.itemIds[int_2] = 0;
                    }

                    WorldMapData.method305(widget_2);
                    class46_0.serverPacket = null;
                    return true;
                }

                String string_0;
                boolean bool_0;
                boolean bool_6;
                int int_13;
                boolean bool_8;
                if (ServerPacket.aServerPacket52 == class46_0.serverPacket) {
                    while (packetbuffer_0.position < class46_0.packetLength) {
                        bool_5 = packetbuffer_0.getUnsignedByte() == 1;
                        string_1 = packetbuffer_0.readString();
                        string_0 = packetbuffer_0.readString();
                        int_11 = packetbuffer_0.getUnsignedShort();
                        int_12 = packetbuffer_0.getUnsignedByte();
                        int_3 = packetbuffer_0.getUnsignedByte();
                        boolean bool_7 = (int_3 & 0x2) != 0;
                        bool_6 = (int_3 & 0x1) != 0;
                        if (int_11 > 0) {
                            packetbuffer_0.readString();
                            packetbuffer_0.getUnsignedByte();
                            packetbuffer_0.readInt();
                        }

                        packetbuffer_0.readString();

                        for (int_13 = 0; int_13 < friendCount; int_13++) {
                            Friend friend_0 = friends[int_13];
                            if (!bool_5) {
                                if (string_1.equals(friend_0.name)) {
                                    if (int_11 != friend_0.world) {
                                        bool_8 = true;

                                        for (Class68_Sub1 class68_sub1_0 = (Class68_Sub1) aClass72_1.method441(); class68_sub1_0 != null; class68_sub1_0 = (Class68_Sub1) aClass72_1.method443()) {
                                            if (class68_sub1_0.aString17.equals(string_1)) {
                                                if (int_11 != 0 && class68_sub1_0.aShort1 == 0) {
                                                    class68_sub1_0.method415();
                                                    bool_8 = false;
                                                } else if (int_11 == 0 && class68_sub1_0.aShort1 != 0) {
                                                    class68_sub1_0.method415();
                                                    bool_8 = false;
                                                }
                                            }
                                        }

                                        if (bool_8) {
                                            aClass72_1.method442(new Class68_Sub1(string_1, int_11));
                                        }

                                        friend_0.world = int_11;
                                    }

                                    friend_0.previousName = string_0;
                                    friend_0.rank = int_12;
                                    friend_0.aBool31 = bool_7;
                                    friend_0.aBool32 = bool_6;
                                    string_1 = null;
                                    break;
                                }
                            } else if (string_0.equals(friend_0.name)) {
                                friend_0.name = string_1;
                                friend_0.previousName = string_0;
                                string_1 = null;
                                break;
                            }
                        }

                        if (string_1 != null && friendCount < 400) {
                            Friend friend_2 = new Friend();
                            friends[friendCount] = friend_2;
                            friend_2.name = string_1;
                            friend_2.previousName = string_0;
                            friend_2.world = int_11;
                            friend_2.rank = int_12;
                            friend_2.aBool31 = bool_7;
                            friend_2.aBool32 = bool_6;
                            ++friendCount;
                        }
                    }

                    anInt655 = 2;
                    anInt658 = cycleCntr;
                    bool_5 = false;
                    int_0 = friendCount;

                    while (int_0 > 0) {
                        bool_5 = true;
                        --int_0;

                        for (int_2 = 0; int_2 < int_0; int_2++) {
                            bool_0 = false;
                            Friend friend_3 = friends[int_2];
                            Friend friend_1 = friends[int_2 + 1];
                            if (friend_3.world != world && friend_1.world == world) {
                                bool_0 = true;
                            }

                            if (!bool_0 && friend_3.world == 0 && friend_1.world != 0) {
                                bool_0 = true;
                            }

                            if (!bool_0 && !friend_3.aBool31 && friend_1.aBool31) {
                                bool_0 = true;
                            }

                            if (!bool_0 && !friend_3.aBool32 && friend_1.aBool32) {
                                bool_0 = true;
                            }

                            if (bool_0) {
                                Friend friend_4 = friends[int_2];
                                friends[int_2] = friends[int_2 + 1];
                                friends[int_2 + 1] = friend_4;
                                bool_5 = false;
                            }
                        }

                        if (bool_5) {
                            break;
                        }
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket54 == class46_0.serverPacket) {
                    if (widgetRoot != -1) {
                        int_1 = widgetRoot;
                        if (CombatInfoListHolder.loadWidget(int_1)) {
                            Class63.method399(Class91.widgets[int_1], 0);
                        }
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                String string_4;
                if (ServerPacket.aServerPacket56 == class46_0.serverPacket) {
                    string_4 = packetbuffer_0.readString();
                    string_1 = FontTypeFace.appendTags(ObjectDefinition.method830(IndexFile.method73(packetbuffer_0)));
                    Class34.sendGameMessage(6, string_4, string_1);
                    class46_0.serverPacket = null;
                    return true;
                }

                boolean bool_4;
                if (ServerPacket.addIgnorePacket == class46_0.serverPacket) {
                    while (packetbuffer_0.position < class46_0.packetLength) {
                        int_1 = packetbuffer_0.getUnsignedByte();
                        bool_4 = (int_1 & 0x1) == 1;
                        string_0 = packetbuffer_0.readString();
                        String string_5 = packetbuffer_0.readString();
                        packetbuffer_0.readString();

                        for (int_12 = 0; int_12 < ignoreCount; int_12++) {
                            Ignore ignore_0 = ignores[int_12];
                            if (bool_4) {
                                if (string_5.equals(ignore_0.name)) {
                                    ignore_0.name = string_0;
                                    ignore_0.previousName = string_5;
                                    string_0 = null;
                                    break;
                                }
                            } else if (string_0.equals(ignore_0.name)) {
                                ignore_0.name = string_0;
                                ignore_0.previousName = string_5;
                                string_0 = null;
                                break;
                            }
                        }

                        if (string_0 != null && ignoreCount < 400) {
                            Ignore ignore_1 = new Ignore();
                            ignores[ignoreCount] = ignore_1;
                            ignore_1.name = string_0;
                            ignore_1.previousName = string_5;
                            ++ignoreCount;
                        }
                    }

                    anInt658 = cycleCntr;
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.playerUpdatePacket == class46_0.serverPacket) {
                    Class39.synchronizePlayers(packetbuffer_0, class46_0.packetLength);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket63 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.readInt();
                    int_0 = packetbuffer_0.getUnsignedShort();
                    if (int_1 < -70000) {
                        int_0 += 32768;
                    }

                    if (int_1 >= 0) {
                        widget_1 = Junk.method671(int_1);
                    } else {
                        widget_1 = null;
                    }

                    for (; packetbuffer_0.position < class46_0.packetLength; AClass3_Sub2.setItemTableSlot(int_0, int_11, int_12 - 1, int_3)) {
                        int_11 = packetbuffer_0.getUSmart();
                        int_12 = packetbuffer_0.getUnsignedShort();
                        int_3 = 0;
                        if (int_12 != 0) {
                            int_3 = packetbuffer_0.getUnsignedByte();
                            if (int_3 == 255) {
                                int_3 = packetbuffer_0.readInt();
                            }
                        }

                        if (widget_1 != null && int_11 >= 0 && int_11 < widget_1.itemIds.length) {
                            widget_1.itemIds[int_11] = int_12;
                            widget_1.itemQuantities[int_11] = int_3;
                        }
                    }

                    if (widget_1 != null) {
                        WorldMapData.method305(widget_1);
                    }

                    Class12.method165();
                    interfaceItemTriggers[++anInt663 - 1 & 0x1F] = int_0 & 0x7FFF;
                    class46_0.serverPacket = null;
                    return true;
                }

                Widget widget_0;
                if (ServerPacket.aServerPacket47 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.method724();
                    int_0 = packetbuffer_0.method707();
                    int_2 = packetbuffer_0.readInt();
                    widget_0 = Junk.method671(int_2);
                    if (int_0 != widget_0.originalX || int_1 != widget_0.originalY || widget_0.anInt270 != 0 || widget_0.anInt273 != 0) {
                        widget_0.originalX = int_0;
                        widget_0.originalY = int_1;
                        widget_0.anInt270 = 0;
                        widget_0.anInt273 = 0;
                        WorldMapData.method305(widget_0);
                        this.method1106(widget_0);
                        if (widget_0.type == 0) {
                            AClass1_Sub2.method637(Class91.widgets[int_2 >> 16], widget_0, false);
                        }
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket66 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.getUnsignedShortAInverse();
                    ItemContainer itemcontainer_0 = (ItemContainer) ItemContainer.itemContainers.get((long) int_1);
                    if (itemcontainer_0 != null) {
                        itemcontainer_0.unlink();
                    }

                    interfaceItemTriggers[++anInt663 - 1 & 0x1F] = int_1 & 0x7FFF;
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket41 == class46_0.serverPacket) {
                    Class27.localPlayerIndexCount = 0;

                    for (int_1 = 0; int_1 < 2048; int_1++) {
                        Class27.playerSynchronizationBuffers[int_1] = null;
                        Class27.aByteArray3[int_1] = 1;
                    }

                    for (int_1 = 0; int_1 < 2048; int_1++) {
                        players[int_1] = null;
                    }

                    Class85.initializeGPI(packetbuffer_0);
                    class46_0.serverPacket = null;
                    return true;
                }

                int int_5;
                long long_0;
                if (ServerPacket.aServerPacket34 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.position + class46_0.packetLength;
                    int_0 = packetbuffer_0.getUnsignedShort();
                    int_2 = packetbuffer_0.getUnsignedShort();
                    if (int_0 != widgetRoot) {
                        widgetRoot = int_0;
                        this.method1098(false);
                        PlayerComposition.method512(widgetRoot);
                        Class2.method77(widgetRoot);

                        for (int_11 = 0; int_11 < 100; int_11++) {
                            aBoolArray8[int_11] = true;
                        }
                    }

                    WidgetNode widgetnode_3;
                    for (; int_2-- > 0; widgetnode_3.aBool54 = true) {
                        int_11 = packetbuffer_0.readInt();
                        int_12 = packetbuffer_0.getUnsignedShort();
                        int_3 = packetbuffer_0.getUnsignedByte();
                        widgetnode_3 = (WidgetNode) componentTable.get((long) int_11);
                        if (widgetnode_3 != null && int_12 != widgetnode_3.id) {
                            Frames.method873(widgetnode_3, true);
                            widgetnode_3 = null;
                        }

                        if (widgetnode_3 == null) {
                            widgetnode_3 = Class33.method241(int_11, int_12, int_3);
                        }
                    }

                    for (widgetnode_1 = (WidgetNode) componentTable.method67(); widgetnode_1 != null; widgetnode_1 = (WidgetNode) componentTable.method68()) {
                        if (widgetnode_1.aBool54) {
                            widgetnode_1.aBool54 = false;
                        } else {
                            Frames.method873(widgetnode_1, true);
                        }
                    }

                    widgetFlags = new HashTable(512);

                    while (packetbuffer_0.position < int_1) {
                        int_11 = packetbuffer_0.readInt();
                        int_12 = packetbuffer_0.getUnsignedShort();
                        int_3 = packetbuffer_0.getUnsignedShort();
                        int_4 = packetbuffer_0.readInt();

                        for (int_5 = int_12; int_5 <= int_3; int_5++) {
                            long_0 = (long) int_5 + ((long) int_11 << 32);
                            widgetFlags.put(new IntegerNode(int_4), long_0);
                        }
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket12 == class46_0.serverPacket) {
                    ScriptVarType.method468(Class59.aClass59_1);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket50 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.readInt();
                    int_0 = packetbuffer_0.getUnsignedShortInverse();
                    if (int_0 == 65535) {
                        int_0 = -1;
                    }

                    int_2 = packetbuffer_0.method727();
                    widget_0 = Junk.method671(int_1);
                    ItemDefinition itemcomposition_0;
                    if (!widget_0.hasScript) {
                        if (int_0 == -1) {
                            widget_0.modelType = 0;
                            class46_0.serverPacket = null;
                            return true;
                        }

                        itemcomposition_0 = ItemDefinition.getDefinition(int_0);
                        widget_0.modelType = 4;
                        widget_0.modelId = int_0;
                        widget_0.rotationX = itemcomposition_0.modelInventoryRotationY;
                        widget_0.rotationZ = itemcomposition_0.modelInventoryRotationX;
                        widget_0.modelZoom = itemcomposition_0.modelInventoryZoom * 100 / int_2;
                        WorldMapData.method305(widget_0);
                    } else {
                        widget_0.itemId = int_0;
                        widget_0.itemQuantity = int_2;
                        itemcomposition_0 = ItemDefinition.getDefinition(int_0);
                        widget_0.rotationX = itemcomposition_0.modelInventoryRotationY;
                        widget_0.rotationZ = itemcomposition_0.modelInventoryRotationX;
                        widget_0.rotationY = itemcomposition_0.diagonalRotation;
                        widget_0.anInt293 = itemcomposition_0.spriteTranslateX;
                        widget_0.anInt294 = itemcomposition_0.spriteTranslateY;
                        widget_0.modelZoom = itemcomposition_0.modelInventoryZoom;
                        if (itemcomposition_0.isStackable == 1) {
                            widget_0.anInt296 = 1;
                        } else {
                            widget_0.anInt296 = 2;
                        }

                        if (widget_0.anInt295 > 0) {
                            widget_0.modelZoom = widget_0.modelZoom * 32 / widget_0.anInt295;
                        } else if (widget_0.originalWidth > 0) {
                            widget_0.modelZoom = widget_0.modelZoom * 32 / widget_0.originalWidth;
                        }

                        WorldMapData.method305(widget_0);
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket51 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.getUnsignedByte();
                    if (packetbuffer_0.getUnsignedByte() == 0) {
                        grandExchangeOffers[int_1] = new GrandExchangeOffer();
                        packetbuffer_0.position += 18;
                    } else {
                        --packetbuffer_0.position;
                        grandExchangeOffers[int_1] = new GrandExchangeOffer(packetbuffer_0, false);
                    }

                    anInt669 = cycleCntr;
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket57 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.method727();
                    widget_2 = Junk.method671(int_1);
                    widget_2.modelType = 3;
                    widget_2.modelId = Class4.localPlayer.composition.method507();
                    WorldMapData.method305(widget_2);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.npcUpdatePacket == class46_0.serverPacket) {
                    Class14.method188(true, packetbuffer_0);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket73 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.readInt();
                    int_0 = packetbuffer_0.getUnsignedShort();
                    if (int_1 < -70000) {
                        int_0 += 32768;
                    }

                    if (int_1 >= 0) {
                        widget_1 = Junk.method671(int_1);
                    } else {
                        widget_1 = null;
                    }

                    if (widget_1 != null) {
                        for (int_11 = 0; int_11 < widget_1.itemIds.length; int_11++) {
                            widget_1.itemIds[int_11] = 0;
                            widget_1.itemQuantities[int_11] = 0;
                        }
                    }

                    Class7.method103(int_0);
                    int_11 = packetbuffer_0.getUnsignedShort();

                    for (int_12 = 0; int_12 < int_11; int_12++) {
                        int_3 = packetbuffer_0.getUnsignedShortInverse();
                        int_4 = packetbuffer_0.getUnsignedByteS();
                        if (int_4 == 255) {
                            int_4 = packetbuffer_0.method714();
                        }

                        if (widget_1 != null && int_12 < widget_1.itemIds.length) {
                            widget_1.itemIds[int_12] = int_3;
                            widget_1.itemQuantities[int_12] = int_4;
                        }

                        AClass3_Sub2.setItemTableSlot(int_0, int_12, int_3 - 1, int_4);
                    }

                    if (widget_1 != null) {
                        WorldMapData.method305(widget_1);
                    }

                    Class12.method165();
                    interfaceItemTriggers[++anInt663 - 1 & 0x1F] = int_0 & 0x7FFF;
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket31 == class46_0.serverPacket) {
                    Class23.anInt75 = packetbuffer_0.getUnsignedByte();
                    GameObject.anInt222 = packetbuffer_0.getUnsignedByteS();
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket77 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.getUnsignedShort();
                    if (int_1 == 65535) {
                        int_1 = -1;
                    }

                    Class47.method310(int_1);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.playSongPacket == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.read24BitInt();
                    int_0 = packetbuffer_0.getUnsignedShort();
                    if (int_0 == 65535) {
                        int_0 = -1;
                    }

                    if (anInt662 != 0 && int_0 != -1) {
                        Class71.method424(Class92.indexTrack2, int_0, 0, anInt662, false);
                        aBool87 = true;
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket16 == class46_0.serverPacket) {
                    ScriptVarType.method468(Class59.aClass59_4);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.cs2ScriptPacket == class46_0.serverPacket) {
                    string_4 = packetbuffer_0.readString();
                    Object[] objects_0 = new Object[string_4.length() + 1];

                    for (int_2 = string_4.length() - 1; int_2 >= 0; --int_2) {
                        if (string_4.charAt(int_2) == 115) {
                            objects_0[int_2 + 1] = packetbuffer_0.readString();
                        } else {
                            objects_0[int_2 + 1] = new Integer(packetbuffer_0.readInt());
                        }
                    }

                    objects_0[0] = new Integer(packetbuffer_0.readInt());
                    ScriptEvent scriptevent_0 = new ScriptEvent();
                    scriptevent_0.anObjectArray22 = objects_0;
                    Class52.method335(scriptevent_0);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket53 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.getUnsignedShortInverse();
                    int_0 = packetbuffer_0.method727();
                    int_2 = int_1 >> 10 & 0x1F;
                    int_11 = int_1 >> 5 & 0x1F;
                    int_12 = int_1 & 0x1F;
                    int_3 = (int_11 << 11) + (int_2 << 19) + (int_12 << 3);
                    Widget widget_4 = Junk.method671(int_0);
                    if (int_3 != widget_4.textColor) {
                        widget_4.textColor = int_3;
                        WorldMapData.method305(widget_4);
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                Widget widget_3;
                if (ServerPacket.aServerPacket32 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.method714();
                    int_0 = packetbuffer_0.method714();
                    WidgetNode widgetnode_0 = (WidgetNode) componentTable.get((long) int_0);
                    widgetnode_1 = (WidgetNode) componentTable.get((long) int_1);
                    if (widgetnode_1 != null) {
                        Frames.method873(widgetnode_1, widgetnode_0 == null || widgetnode_0.id != widgetnode_1.id);
                    }

                    if (widgetnode_0 != null) {
                        widgetnode_0.unlink();
                        componentTable.put(widgetnode_0, (long) int_1);
                    }

                    widget_3 = Junk.method671(int_0);
                    if (widget_3 != null) {
                        WorldMapData.method305(widget_3);
                    }

                    widget_3 = Junk.method671(int_1);
                    if (widget_3 != null) {
                        WorldMapData.method305(widget_3);
                        AClass1_Sub2.method637(Class91.widgets[widget_3.id >>> 16], widget_3, true);
                    }

                    if (widgetRoot != -1) {
                        int_3 = widgetRoot;
                        if (CombatInfoListHolder.loadWidget(int_3)) {
                            Class63.method399(Class91.widgets[int_3], 1);
                        }
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket76 == class46_0.serverPacket) {
                    destinationX = packetbuffer_0.getUnsignedByte();
                    if (destinationX == 255) {
                        destinationX = 0;
                    }

                    destinationY = packetbuffer_0.getUnsignedByte();
                    if (destinationY == 255) {
                        destinationY = 0;
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket81 == class46_0.serverPacket) {
                    anInt683 = packetbuffer_0.getUnsignedByteS();
                    anInt686 = packetbuffer_0.getUnsignedByteC();
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket35 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.readInt();
                    WidgetNode widgetnode_2 = (WidgetNode) componentTable.get((long) int_1);
                    if (widgetnode_2 != null) {
                        Frames.method873(widgetnode_2, true);
                    }

                    if (aWidget12 != null) {
                        WorldMapData.method305(aWidget12);
                        aWidget12 = null;
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.regionUpdatePacket == class46_0.serverPacket) {
                    WallObject.xteaChanged(false, class46_0.aPacketBuffer1);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.rootInterfacePacket == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.readUnsignedShortOb1();
                    widgetRoot = int_1;
                    this.method1098(false);
                    PlayerComposition.method512(int_1);
                    Class2.method77(widgetRoot);

                    for (int_0 = 0; int_0 < 100; int_0++) {
                        aBoolArray8[int_0] = true;
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.energyPacket == class46_0.serverPacket) {
                    Class12.method165();
                    energy = packetbuffer_0.getUnsignedByte();
                    anInt640 = cycleCntr;
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.varpLargePacket == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.readUnsignedShortOb1();
                    int_0 = packetbuffer_0.method714();
                    Settings.settings[int_1] = int_0;
                    if (Settings.widgetSettings[int_1] != int_0) {
                        Settings.widgetSettings[int_1] = int_0;
                    }

                    DynamicObject.method1064(int_1);
                    anIntArray151[++anInt649 - 1 & 0x1F] = int_1;
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket25 == class46_0.serverPacket) {
                    ScriptVarType.method468(Class59.aClass59_9);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket7 == class46_0.serverPacket) {
                    Class62.method396();
                    class46_0.serverPacket = null;
                    return false;
                }

                if (ServerPacket.aServerPacket9 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.readInt();
                    FileSystem.aTask2 = GameEngine.taskManager.createHost(int_1);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket10 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.readInt();
                    int_0 = packetbuffer_0.readInt();
                    int_2 = Renderable.method744();
                    PacketNode packetnode_0 = Actor.method953(ClientPacket.aClientPacket12, aClass46_1.cipher);
                    packetnode_0.packetBuffer.putByteInverse(GameEngine.FPS);
                    packetnode_0.packetBuffer.putByteS(int_2);
                    packetnode_0.packetBuffer.method725(int_1);
                    packetnode_0.packetBuffer.method726(int_0);
                    aClass46_1.method282(packetnode_0);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket45 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.method714();
                    int_0 = packetbuffer_0.getUnsignedShortAInverse();
                    int_2 = packetbuffer_0.getUnsignedShortInverse();
                    int_11 = packetbuffer_0.readUnsignedShortOb1();
                    widget_3 = Junk.method671(int_1);
                    if (int_2 != widget_3.rotationX || int_0 != widget_3.rotationZ || int_11 != widget_3.modelZoom) {
                        widget_3.rotationX = int_2;
                        widget_3.rotationZ = int_0;
                        widget_3.modelZoom = int_11;
                        WorldMapData.method305(widget_3);
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                long long_1;
                long long_2;
                long long_3;
                int int_6;
                int int_7;
                String string_3;
                if (ServerPacket.aServerPacket70 == class46_0.serverPacket) {
                    string_4 = packetbuffer_0.readString();
                    long_1 = packetbuffer_0.readLong();
                    long_2 = (long) packetbuffer_0.getUnsignedShort();
                    long_3 = (long) packetbuffer_0.read24BitInt();
                    Permission permission_1 = (Permission) Class1.forOrdinal(Class44.method272(), packetbuffer_0.getUnsignedByte());
                    long_0 = long_3 + (long_2 << 32);
                    bool_8 = false;

                    for (int_6 = 0; int_6 < 100; int_6++) {
                        if (long_0 == aLongArray4[int_6]) {
                            bool_8 = true;
                            break;
                        }
                    }

                    if (permission_1.aBool46 && Tile.isIgnored(string_4)) {
                        bool_8 = true;
                    }

                    if (!bool_8 && onTutorialIsland == 0) {
                        aLongArray4[anInt696] = long_0;
                        anInt696 = (anInt696 + 1) % 100;
                        String string_6 = FontTypeFace.appendTags(ObjectDefinition.method830(IndexFile.method73(packetbuffer_0)));
                        if (permission_1.iconSpriteId != -1) {
                            int_7 = permission_1.iconSpriteId;
                            string_3 = "<img=" + int_7 + ">";
                            DynamicObject.addChatMessage(9, string_3 + string_4, string_6, Preferences.method419(long_1));
                        } else {
                            DynamicObject.addChatMessage(9, string_4, string_6, Preferences.method419(long_1));
                        }
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket29 == class46_0.serverPacket) {
                    Class23.anInt75 = packetbuffer_0.getUnsignedByteS();
                    GameObject.anInt222 = packetbuffer_0.getUnsignedByteS();

                    for (int_1 = Class23.anInt75; int_1 < Class23.anInt75 + 8; int_1++) {
                        for (int_0 = GameObject.anInt222; int_0 < GameObject.anInt222 + 8; int_0++) {
                            if (groundItemDeque[Ignore.plane][int_1][int_0] != null) {
                                groundItemDeque[Ignore.plane][int_1][int_0] = null;
                                Enum1.groundItemSpawned(int_1, int_0);
                            }
                        }
                    }

                    for (SceneSpawnNode pendingspawn_0 = (SceneSpawnNode) pendingSpawns.getFront(); pendingspawn_0 != null; pendingspawn_0 = (SceneSpawnNode) pendingSpawns.getNext()) {
                        if (pendingspawn_0.x >= Class23.anInt75 && pendingspawn_0.objectFace < Class23.anInt75 + 8 && pendingspawn_0.y >= GameObject.anInt222 && pendingspawn_0.y < GameObject.anInt222 + 8 && pendingspawn_0.plane == Ignore.plane) {
                            pendingspawn_0.timeLeftTillSpawn = 0;
                        }
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket18 == class46_0.serverPacket) {
                    ScriptVarType.method468(Class59.aClass59_5);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket71 == class46_0.serverPacket) {
                    Class47.method312(packetbuffer_0.readString());
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket6 == class46_0.serverPacket) {
                    World world_0 = new World();
                    world_0.address = packetbuffer_0.readString();
                    world_0.id = packetbuffer_0.getUnsignedShort();
                    int_0 = packetbuffer_0.readInt();
                    world_0.mask = int_0;
                    Class110.setGameState(45);
                    rssocket_0.close();
                    rssocket_0 = null;
                    Class20.method207(world_0);
                    class46_0.serverPacket = null;
                    return false;
                }

                if (ServerPacket.aServerPacket43 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.getUnsignedShortInverse();
                    int_0 = packetbuffer_0.readUnsignedShortOb1();
                    int_2 = packetbuffer_0.method727();
                    widget_0 = Junk.method671(int_2);
                    widget_0.anInt279 = int_0 + (int_1 << 16);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket67 == class46_0.serverPacket) {
                    aBool94 = true;
                    Class73.anInt171 = packetbuffer_0.getUnsignedByte();
                    Class42.anInt101 = packetbuffer_0.getUnsignedByte();
                    Class26.anInt88 = packetbuffer_0.getUnsignedShort();
                    Class41.anInt99 = packetbuffer_0.getUnsignedByte();
                    Class50.anInt112 = packetbuffer_0.getUnsignedByte();
                    if (Class50.anInt112 >= 100) {
                        Class2.cameraX = Class73.anInt171 * 128 + 64;
                        Player.cameraY = Class42.anInt101 * 128 + 64;
                        Class18.cameraZ = Class18.getTileHeight(Class2.cameraX, Player.cameraY, Ignore.plane) - Class26.anInt88;
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.interfaceSettingsPacket == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.readUnsignedShortOb1();
                    if (int_1 == 65535) {
                        int_1 = -1;
                    }

                    int_0 = packetbuffer_0.getUnsignedShort();
                    if (int_0 == 65535) {
                        int_0 = -1;
                    }

                    int_2 = packetbuffer_0.method706();
                    int_11 = packetbuffer_0.method727();

                    for (int_12 = int_1; int_12 <= int_0; int_12++) {
                        long_3 = ((long) int_2 << 32) + (long) int_12;
                        Node node_0 = widgetFlags.get(long_3);
                        if (node_0 != null) {
                            node_0.unlink();
                        }

                        widgetFlags.put(new IntegerNode(int_11), long_3);
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket61 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.getUnsignedShortAInverse();
                    int_0 = packetbuffer_0.method706();
                    widget_1 = Junk.method671(int_0);
                    if (widget_1.modelType != 1 || int_1 != widget_1.modelId) {
                        widget_1.modelType = 1;
                        widget_1.modelId = int_1;
                        WorldMapData.method305(widget_1);
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket85 == class46_0.serverPacket) {
                    Class14.method188(false, packetbuffer_0);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket20 == class46_0.serverPacket) {
                    ScriptVarType.method468(Class59.aClass59_6);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.resetCameraPacket == class46_0.serverPacket) {
                    aBool94 = false;

                    for (int_1 = 0; int_1 < 5; int_1++) {
                        aBoolArray12[int_1] = false;
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket27 == class46_0.serverPacket) {
                    Class23.anInt75 = packetbuffer_0.getUnsignedByteS();
                    GameObject.anInt222 = packetbuffer_0.getUnsignedByteS();

                    while (packetbuffer_0.position < class46_0.packetLength) {
                        int_1 = packetbuffer_0.getUnsignedByte();
                        Class59 class59_0 = Script.method911()[int_1];
                        ScriptVarType.method468(class59_0);
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket74 == class46_0.serverPacket) {
                    anInt655 = 1;
                    anInt658 = cycleCntr;
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket55 == class46_0.serverPacket) {
                    bool_5 = packetbuffer_0.getUnsignedByte() == 1;
                    if (bool_5) {
                        Class19.aLong1 = Class97.currentTimeMs() - packetbuffer_0.readLong();
                        Class65.aClass47_1 = new Class47(packetbuffer_0, true);
                    } else {
                        Class65.aClass47_1 = null;
                    }

                    anInt695 = cycleCntr;
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.resetAnimationPacket == class46_0.serverPacket) {
                    for (int_1 = 0; int_1 < players.length; int_1++) {
                        if (players[int_1] != null) {
                            players[int_1].animation = -1;
                        }
                    }

                    for (int_1 = 0; int_1 < cachedNPCs.length; int_1++) {
                        if (cachedNPCs[int_1] != null) {
                            cachedNPCs[int_1].animation = -1;
                        }
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                String string_7;
                if (ServerPacket.serverMessagePacket == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.getUSmart();
                    bool_4 = packetbuffer_0.getUnsignedByte() == 1;
                    string_0 = "";
                    bool_0 = false;
                    if (bool_4) {
                        string_0 = packetbuffer_0.readString();
                        if (Tile.isIgnored(string_0)) {
                            bool_0 = true;
                        }
                    }

                    string_7 = packetbuffer_0.readString();
                    if (!bool_0) {
                        Class34.sendGameMessage(int_1, string_0, string_7);
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.updateUidPacket == class46_0.serverPacket) {
                    packetbuffer_0.position += 28;
                    if (packetbuffer_0.checkCrc()) {
                        int_1 = packetbuffer_0.position - 28;
                        byte[] bytes_0 = packetbuffer_0.buffer;
                        if (aByteArray28 == null) {
                            aByteArray28 = new byte[24];
                        }

                        Class76.method450(bytes_0, int_1, aByteArray28, 0, 24);
                        if (Class64.aCacheFile1 != null) {
                            try {
                                Class64.aCacheFile1.seek(0L);
                                Class64.aCacheFile1.write(packetbuffer_0.buffer, int_1, 24);
                            } catch (Exception exception_2) {
                                ;
                            }
                        }
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                int int_14;
                if (ServerPacket.aServerPacket11 == class46_0.serverPacket) {
                    int_1 = class46_0.packetLength;
                    ClassInfo classinfo_0 = new ClassInfo();
                    classinfo_0.count = packetbuffer_0.getUnsignedByte();
                    classinfo_0.anInt371 = packetbuffer_0.readInt();
                    classinfo_0.type = new int[classinfo_0.count];
                    classinfo_0.errorIdentifiers = new int[classinfo_0.count];
                    classinfo_0.fields = new Field[classinfo_0.count];
                    classinfo_0.anIntArray78 = new int[classinfo_0.count];
                    classinfo_0.methods = new Method[classinfo_0.count];
                    classinfo_0.args = new byte[classinfo_0.count][][];

                    for (int_2 = 0; int_2 < classinfo_0.count; int_2++) {
                        try {
                            int_11 = packetbuffer_0.getUnsignedByte();
                            String string_8;
                            if (int_11 != 0 && int_11 != 1 && int_11 != 2) {
                                if (int_11 == 3 || int_11 == 4) {
                                    string_7 = packetbuffer_0.readString();
                                    string_8 = packetbuffer_0.readString();
                                    int_4 = packetbuffer_0.getUnsignedByte();
                                    String[] strings_0 = new String[int_4];

                                    for (int_13 = 0; int_13 < int_4; int_13++) {
                                        strings_0[int_13] = packetbuffer_0.readString();
                                    }

                                    String string_9 = packetbuffer_0.readString();
                                    byte[][] bytes_1 = new byte[int_4][];
                                    if (int_11 == 3) {
                                        for (int_14 = 0; int_14 < int_4; int_14++) {
                                            int_6 = packetbuffer_0.readInt();
                                            bytes_1[int_14] = new byte[int_6];
                                            packetbuffer_0.readBytes(bytes_1[int_14], 0, int_6);
                                        }
                                    }

                                    classinfo_0.type[int_2] = int_11;
                                    Class[] classs_0 = new Class[int_4];

                                    for (int_6 = 0; int_6 < int_4; int_6++) {
                                        classs_0[int_6] = WidgetNode.method686(strings_0[int_6]);
                                    }

                                    Class class_0 = WidgetNode.method686(string_9);
                                    if (WidgetNode.method686(string_7).getClassLoader() == null) {
                                        throw new SecurityException();
                                    }

                                    Method[] methods_1 = WidgetNode.method686(string_7).getDeclaredMethods();
                                    Method[] methods_0 = methods_1;

                                    for (int int_8 = 0; int_8 < methods_0.length; int_8++) {
                                        Method method_0 = methods_0[int_8];
                                        if (method_0.getName().equals(string_8)) {
                                            Class[] classs_1 = method_0.getParameterTypes();
                                            if (classs_0.length == classs_1.length) {
                                                boolean bool_3 = true;

                                                for (int int_9 = 0; int_9 < classs_0.length; int_9++) {
                                                    if (classs_0[int_9] != classs_1[int_9]) {
                                                        bool_3 = false;
                                                        break;
                                                    }
                                                }

                                                if (bool_3 && class_0 == method_0.getReturnType()) {
                                                    classinfo_0.methods[int_2] = method_0;
                                                }
                                            }
                                        }
                                    }

                                    classinfo_0.args[int_2] = bytes_1;
                                }
                            } else {
                                string_7 = packetbuffer_0.readString();
                                string_8 = packetbuffer_0.readString();
                                int_4 = 0;
                                if (int_11 == 1) {
                                    int_4 = packetbuffer_0.readInt();
                                }

                                classinfo_0.type[int_2] = int_11;
                                classinfo_0.anIntArray78[int_2] = int_4;
                                if (WidgetNode.method686(string_7).getClassLoader() == null) {
                                    throw new SecurityException();
                                }

                                classinfo_0.fields[int_2] = WidgetNode.method686(string_7).getDeclaredField(string_8);
                            }
                        } catch (ClassNotFoundException classnotfoundexception_0) {
                            classinfo_0.errorIdentifiers[int_2] = -1;
                        } catch (SecurityException securityexception_0) {
                            classinfo_0.errorIdentifiers[int_2] = -2;
                        } catch (NullPointerException nullpointerexception_0) {
                            classinfo_0.errorIdentifiers[int_2] = -3;
                        } catch (Exception exception_1) {
                            classinfo_0.errorIdentifiers[int_2] = -4;
                        } catch (Throwable throwable_0) {
                            classinfo_0.errorIdentifiers[int_2] = -5;
                        }
                    }

                    Class108.aCombatInfoList4.method455(classinfo_0);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket21 == class46_0.serverPacket) {
                    ScriptVarType.method468(Class59.aClass59_7);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.interfaceTextPacket == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.method714();
                    string_1 = packetbuffer_0.readString();
                    widget_1 = Junk.method671(int_1);
                    if (!string_1.equals(widget_1.text)) {
                        widget_1.text = string_1;
                        WorldMapData.method305(widget_1);
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket59 == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.getUnsignedShortAInverse();
                    int_0 = packetbuffer_0.method706();
                    widget_1 = Junk.method671(int_0);
                    if (widget_1.modelType != 2 || int_1 != widget_1.modelId) {
                        widget_1.modelType = 2;
                        widget_1.modelId = int_1;
                        WorldMapData.method305(widget_1);
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.playerOptionsPacket == class46_0.serverPacket) {
                    int_1 = packetbuffer_0.getUnsignedByteC();
                    int_0 = packetbuffer_0.getUnsignedByteC();
                    string_0 = packetbuffer_0.readString();
                    if (int_0 >= 1 && int_0 <= 8) {
                        if (string_0.equalsIgnoreCase("null")) {
                            string_0 = null;
                        }

                        playerOptions[int_0 - 1] = string_0;
                        playerOptionsPriorities[int_0 - 1] = int_1 == 0;
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                long long_5;
                int int_10;
                if (ServerPacket.aServerPacket69 == class46_0.serverPacket) {
                    anInt697 = cycleCntr;
                    if (class46_0.packetLength == 0) {
                        clanChatOwner = null;
                        clanChatName = null;
                        clanChatCount = 0;
                        DynamicObject.clanMembers = null;
                        class46_0.serverPacket = null;
                        return true;
                    }

                    clanChatName = packetbuffer_0.readString();
                    long long_4 = packetbuffer_0.readLong();
                    long_2 = long_4;
                    if (long_4 > 0L && long_4 < 6582952005840035281L) {
                        if (long_4 % 37L == 0L) {
                            string_0 = null;
                        } else {
                            int_3 = 0;

                            for (long_5 = long_4; long_5 != 0L; long_5 /= 37L) {
                                ++int_3;
                            }

                            StringBuilder stringbuilder_0 = new StringBuilder(int_3);

                            while (long_2 != 0L) {
                                long long_6 = long_2;
                                long_2 /= 37L;
                                stringbuilder_0.append(Class105.aCharArray7[(int) (long_6 - long_2 * 37L)]);
                            }

                            string_0 = stringbuilder_0.reverse().toString();
                        }
                    } else {
                        string_0 = null;
                    }

                    clanChatOwner = string_0;
                    Class18.aByte1 = packetbuffer_0.readByte();
                    int_3 = packetbuffer_0.getUnsignedByte();
                    if (int_3 == 255) {
                        class46_0.serverPacket = null;
                        return true;
                    }

                    clanChatCount = int_3;
                    ClanMember[] clanmembers_0 = new ClanMember[100];

                    for (int_5 = 0; int_5 < clanChatCount; int_5++) {
                        clanmembers_0[int_5] = new ClanMember();
                        clanmembers_0[int_5].username = packetbuffer_0.readString();
                        clanmembers_0[int_5].aString20 = PacketBuffer.method908(clanmembers_0[int_5].username, Class24.aClass109_1);
                        clanmembers_0[int_5].world = packetbuffer_0.getUnsignedShort();
                        clanmembers_0[int_5].rank = packetbuffer_0.readByte();
                        packetbuffer_0.readString();
                        if (clanmembers_0[int_5].username.equals(Class4.localPlayer.name)) {
                            AClass3.clanChatRank = clanmembers_0[int_5].rank;
                        }
                    }

                    bool_6 = false;
                    int_10 = clanChatCount;

                    while (int_10 > 0) {
                        bool_6 = true;
                        --int_10;

                        for (int_14 = 0; int_14 < int_10; int_14++) {
                            if (clanmembers_0[int_14].aString20.compareTo(clanmembers_0[int_14 + 1].aString20) > 0) {
                                ClanMember clanmember_1 = clanmembers_0[int_14];
                                clanmembers_0[int_14] = clanmembers_0[int_14 + 1];
                                clanmembers_0[int_14 + 1] = clanmember_1;
                                bool_6 = false;
                            }
                        }

                        if (bool_6) {
                            break;
                        }
                    }

                    DynamicObject.clanMembers = clanmembers_0;
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.addClanMemberPacket == class46_0.serverPacket) {
                    string_4 = packetbuffer_0.readString();
                    int_0 = packetbuffer_0.getUnsignedShort();
                    byte byte_1 = packetbuffer_0.readByte();
                    bool_0 = false;
                    if (byte_1 == -128) {
                        bool_0 = true;
                    }

                    if (bool_0) {
                        if (clanChatCount == 0) {
                            class46_0.serverPacket = null;
                            return true;
                        }

                        boolean bool_1 = false;

                        for (int_12 = 0; int_12 < clanChatCount && (!DynamicObject.clanMembers[int_12].username.equals(string_4) || int_0 != DynamicObject.clanMembers[int_12].world); int_12++) {
                            ;
                        }

                        if (int_12 < clanChatCount) {
                            while (int_12 < clanChatCount - 1) {
                                DynamicObject.clanMembers[int_12] = DynamicObject.clanMembers[int_12 + 1];
                                ++int_12;
                            }

                            --clanChatCount;
                            DynamicObject.clanMembers[clanChatCount] = null;
                        }
                    } else {
                        packetbuffer_0.readString();
                        ClanMember clanmember_0 = new ClanMember();
                        clanmember_0.username = string_4;
                        clanmember_0.aString20 = PacketBuffer.method908(clanmember_0.username, Class24.aClass109_1);
                        clanmember_0.world = int_0;
                        clanmember_0.rank = byte_1;

                        for (int_3 = clanChatCount - 1; int_3 >= 0; --int_3) {
                            int_4 = DynamicObject.clanMembers[int_3].aString20.compareTo(clanmember_0.aString20);
                            if (int_4 == 0) {
                                DynamicObject.clanMembers[int_3].world = int_0;
                                DynamicObject.clanMembers[int_3].rank = byte_1;
                                if (string_4.equals(Class4.localPlayer.name)) {
                                    AClass3.clanChatRank = byte_1;
                                }

                                anInt697 = cycleCntr;
                                class46_0.serverPacket = null;
                                return true;
                            }

                            if (int_4 < 0) {
                                break;
                            }
                        }

                        if (clanChatCount >= DynamicObject.clanMembers.length) {
                            class46_0.serverPacket = null;
                            return true;
                        }

                        for (int_4 = clanChatCount - 1; int_4 > int_3; --int_4) {
                            DynamicObject.clanMembers[int_4 + 1] = DynamicObject.clanMembers[int_4];
                        }

                        if (clanChatCount == 0) {
                            DynamicObject.clanMembers = new ClanMember[100];
                        }

                        DynamicObject.clanMembers[int_3 + 1] = clanmember_0;
                        ++clanChatCount;
                        if (string_4.equals(Class4.localPlayer.name)) {
                            AClass3.clanChatRank = byte_1;
                        }
                    }

                    anInt697 = cycleCntr;
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.dynamicRegionPacket == class46_0.serverPacket) {
                    WallObject.xteaChanged(true, class46_0.aPacketBuffer1);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket13 == class46_0.serverPacket) {
                    ScriptVarType.method468(Class59.aClass59_2);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket83 == class46_0.serverPacket) {
                    Huffman.aClass106_4 = VarPlayerType.method945(packetbuffer_0.getUnsignedByte());
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket82 == class46_0.serverPacket) {
                    string_4 = packetbuffer_0.readString();
                    long_1 = (long) packetbuffer_0.getUnsignedShort();
                    long_2 = (long) packetbuffer_0.read24BitInt();
                    Permission permission_0 = (Permission) Class1.forOrdinal(Class44.method272(), packetbuffer_0.getUnsignedByte());
                    long_5 = (long_1 << 32) + long_2;
                    boolean bool_2 = false;

                    for (int_10 = 0; int_10 < 100; int_10++) {
                        if (long_5 == aLongArray4[int_10]) {
                            bool_2 = true;
                            break;
                        }
                    }

                    if (Tile.isIgnored(string_4)) {
                        bool_2 = true;
                    }

                    if (!bool_2 && onTutorialIsland == 0) {
                        aLongArray4[anInt696] = long_5;
                        anInt696 = (anInt696 + 1) % 100;
                        String string_2 = FontTypeFace.appendTags(ObjectDefinition.method830(IndexFile.method73(packetbuffer_0)));
                        byte byte_0;
                        if (permission_0.aBool45) {
                            byte_0 = 7;
                        } else {
                            byte_0 = 3;
                        }

                        if (permission_0.iconSpriteId != -1) {
                            int_7 = permission_0.iconSpriteId;
                            string_3 = "<img=" + int_7 + ">";
                            Class34.sendGameMessage(byte_0, string_3 + string_4, string_2);
                        } else {
                            Class34.sendGameMessage(byte_0, string_4, string_2);
                        }
                    }

                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket26 == class46_0.serverPacket) {
                    ScriptVarType.method468(Class59.aClass59_10);
                    class46_0.serverPacket = null;
                    return true;
                }

                if (ServerPacket.aServerPacket8 == class46_0.serverPacket) {
                    anInt608 = packetbuffer_0.readUnsignedShortOb1() * 30;
                    anInt640 = cycleCntr;
                    class46_0.serverPacket = null;
                    return true;
                }

                Class13.method168("" + (class46_0.serverPacket != null ? class46_0.serverPacket.packetId : -1) + "," + (class46_0.aServerPacket1 != null ? class46_0.aServerPacket1.packetId : -1) + "," + (class46_0.aServerPacket2 != null ? class46_0.aServerPacket2.packetId : -1) + "," + class46_0.packetLength, (Throwable) null);
                Class62.method396();
            } catch (IOException ioexception_0) {
                WidgetNode.method684();
            } catch (Exception exception_0) {
                string_1 = "" + (class46_0.serverPacket != null ? class46_0.serverPacket.packetId : -1) + "," + (class46_0.aServerPacket1 != null ? class46_0.aServerPacket1.packetId : -1) + "," + (class46_0.aServerPacket2 != null ? class46_0.aServerPacket2.packetId : -1) + "," + class46_0.packetLength + "," + (Class4.localPlayer.pathX[0] + ItemLayer.baseX) + "," + (Class4.localPlayer.pathY[0] + ItemLayer.baseY) + ",";

                for (int_2 = 0; int_2 < class46_0.packetLength && int_2 < 50; int_2++) {
                    string_1 = string_1 + packetbuffer_0.buffer[int_2] + ",";
                }

                Class13.method168(string_1, exception_0);
                Class62.method396();
            }

            return true;
        }
    }

    void method1101(int int_0, int int_1) {
        int int_2 = Class50.aFont3.method1030("Choose Option");

        int int_3;
        int int_4;
        for (int_3 = 0; int_3 < menuOptionCount; int_3++) {
            int_4 = Class50.aFont3.method1030(Class38.method253(int_3));
            if (int_4 > int_2) {
                int_2 = int_4;
            }
        }

        int_2 += 8;
        int_3 = menuOptionCount * 15 + 22;
        int_4 = int_0 - int_2 / 2;
        if (int_2 + int_4 > Tile.canvasWidth) {
            int_4 = Tile.canvasWidth - int_2;
        }

        if (int_4 < 0) {
            int_4 = 0;
        }

        int int_5 = int_1;
        if (int_3 + int_1 > Class29.canvasHeight) {
            int_5 = Class29.canvasHeight - int_3;
        }

        if (int_5 < 0) {
            int_5 = 0;
        }

        Class23.region.method359(Ignore.plane, int_0, int_1, false);
        isMenuOpen = true;
        CacheFile.menuX = int_4;
        AClass1_Sub1.menuY = int_5;
        Class93.menuWidth = int_2;
        Class42.menuHeight = menuOptionCount * 15 + 22;
    }

    protected void packetHandler() {
        ++gameCycle;
        this.processJS5Connection();

        while (true) {
            Deque deque_0 = Class91.aDeque1;
            FileSystem filesystem_0;
            synchronized (deque_0) {
                filesystem_0 = (FileSystem) Class91.aDeque2.popFront();
            }

            if (filesystem_0 == null) {
                Class7.method101();
                Enum2.method642();
                Class5.method96();
                MouseInput mouseinput_0 = MouseInput.mouse;
                synchronized (mouseinput_0) {
                    MouseInput.anInt263 = MouseInput.anInt257;
                    MouseInput.anInt260 = MouseInput.mouseX;
                    MouseInput.anInt262 = MouseInput.mouseY;
                    MouseInput.anInt259 = MouseInput.anInt266;
                    MouseInput.anInt264 = MouseInput.anInt258;
                    MouseInput.anInt265 = MouseInput.anInt261;
                    MouseInput.aLong23 = MouseInput.aLong22;
                    MouseInput.anInt266 = 0;
                }

                int int_0;
                if (Class23.anInterface4_1 != null) {
                    int_0 = Class23.anInterface4_1.method4();
                    anInt636 = int_0;
                }

                if (gameState == 0) {
                    Class46.load();
                    GameEngine.timer.method585();

                    for (int_0 = 0; int_0 < 32; int_0++) {
                        GameEngine.aLongArray3[int_0] = 0L;
                    }

                    for (int_0 = 0; int_0 < 32; int_0++) {
                        GameEngine.aLongArray2[int_0] = 0L;
                    }

                    AClass3.anInt326 = 0;
                } else if (gameState == 5) {
                    Frames.method872(this);
                    Class46.load();
                    GameEngine.timer.method585();

                    for (int_0 = 0; int_0 < 32; int_0++) {
                        GameEngine.aLongArray3[int_0] = 0L;
                    }

                    for (int_0 = 0; int_0 < 32; int_0++) {
                        GameEngine.aLongArray2[int_0] = 0L;
                    }

                    AClass3.anInt326 = 0;
                } else if (gameState != 10 && gameState != 11) {
                    if (gameState == 20) {
                        Frames.method872(this);
                        this.handleLoginState();
                    } else if (gameState == 25) {
                        DynamicObject.method1065();
                    }
                } else {
                    Frames.method872(this);
                }

                if (gameState == 30) {
                    this.method1104();
                } else if (gameState == 40 || gameState == 45) {
                    this.handleLoginState();
                }

                return;
            }

            filesystem_0.data.method614(filesystem_0.index, (int) filesystem_0.hash, filesystem_0.aByteArray12, false);
        }
    }

    void method1102() {
        if (Class95.anInt194 >= 4) {
            this.error("js5crc");
            gameState = 1000;
        } else {
            if (Class95.anInt196 >= 4) {
                if (gameState <= 5) {
                    this.error("js5io");
                    gameState = 1000;
                    return;
                }

                anInt612 = 3000;
                Class95.anInt196 = 3;
            }

            if (--anInt612 + 1 <= 0) {
                try {
                    if (js5State == 0) {
                        Class3.socket = GameEngine.taskManager.createSocket(MilliTimer.host, AClass3.myWorldPort);
                        ++js5State;
                    }

                    if (js5State == 1) {
                        if (Class3.socket.status == 2) {
                            this.error(-1);
                            return;
                        }

                        if (Class3.socket.status == 1) {
                            ++js5State;
                        }
                    }

                    if (js5State == 2) {
                        Class88.rssocket = new RSSocket((Socket) Class3.socket.value, GameEngine.taskManager, 5000);
                        Buffer buffer_0 = new Buffer(5);
                        buffer_0.putByte(15);
                        buffer_0.putInt(157);
                        Class88.rssocket.queueForWrite(buffer_0.buffer, 0, 5);
                        ++js5State;
                        Class44.aLong3 = Class97.currentTimeMs();
                    }

                    if (js5State == 3) {
                        if (gameState > 5 && Class88.rssocket.available() <= 0) {
                            if (Class97.currentTimeMs() - Class44.aLong3 > 30000L) {
                                this.error(-2);
                                return;
                            }
                        } else {
                            int int_0 = Class88.rssocket.readByte();
                            if (int_0 != 0) {
                                this.error(int_0);
                                return;
                            }

                            ++js5State;
                        }
                    }

                    if (js5State == 4) {
                        RSSocket rssocket_0 = Class88.rssocket;
                        boolean bool_0 = gameState > 20;
                        if (Class95.aRSSocket1 != null) {
                            try {
                                Class95.aRSSocket1.close();
                            } catch (Exception exception_0) {
                                ;
                            }

                            Class95.aRSSocket1 = null;
                        }

                        Class95.aRSSocket1 = rssocket_0;
                        Class2.sendConInfo(bool_0);
                        Class95.aBuffer6.position = 0;
                        Class56.currentRequest = null;
                        DecorativeObject.aBuffer4 = null;
                        Class95.anInt201 = 0;

                        while (true) {
                            FileRequest filerequest_0 = (FileRequest) Class95.aHashTable5.method67();
                            if (filerequest_0 == null) {
                                while (true) {
                                    filerequest_0 = (FileRequest) Class95.aHashTable6.method67();
                                    if (filerequest_0 == null) {
                                        if (Class95.aByte2 != 0) {
                                            try {
                                                Buffer buffer_1 = new Buffer(4);
                                                buffer_1.putByte(4);
                                                buffer_1.putByte(Class95.aByte2);
                                                buffer_1.putShort(0);
                                                Class95.aRSSocket1.queueForWrite(buffer_1.buffer, 0, 4);
                                            } catch (IOException ioexception_1) {
                                                try {
                                                    Class95.aRSSocket1.close();
                                                } catch (Exception exception_1) {
                                                    ;
                                                }

                                                ++Class95.anInt196;
                                                Class95.aRSSocket1 = null;
                                            }
                                        }

                                        Class95.anInt195 = 0;
                                        Class95.aLong11 = Class97.currentTimeMs();
                                        Class3.socket = null;
                                        Class88.rssocket = null;
                                        js5State = 0;
                                        anInt617 = 0;
                                        return;
                                    }

                                    Class95.aNode2LinkedList1.setHead(filerequest_0);
                                    Class95.aHashTable3.put(filerequest_0, filerequest_0.hash);
                                    ++Class95.anInt199;
                                    --Class95.anInt200;
                                }
                            }

                            Class95.aHashTable4.put(filerequest_0, filerequest_0.hash);
                            ++Class95.anInt197;
                            --Class95.anInt198;
                        }
                    }
                } catch (IOException ioexception_0) {
                    this.error(-3);
                }

            }
        }
    }

    void method1103() {
        int int_0;
        if (widgetRoot != -1) {
            int_0 = widgetRoot;
            if (CombatInfoListHolder.loadWidget(int_0)) {
                Class49.method314(Class91.widgets[int_0], -1);
            }
        }

        for (int_0 = 0; int_0 < anInt610; int_0++) {
            if (aBoolArray8[int_0]) {
                aBoolArray11[int_0] = true;
            }

            aBoolArray10[int_0] = aBoolArray8[int_0];
            aBoolArray8[int_0] = false;
        }

        anInt611 = gameCycle;
        anInt615 = -1;
        anInt616 = -1;
        Class52.aWidget2 = null;
        if (widgetRoot != -1) {
            anInt610 = 0;
            Class47.method309(widgetRoot, 0, 0, Tile.canvasWidth, Class29.canvasHeight, 0, 0, -1);
        }

        Rasterizer2D.noClip();
        if (!isMenuOpen) {
            if (anInt615 != -1) {
                int_0 = anInt615;
                int int_1 = anInt616;
                if (menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) {
                    int int_2 = menuOptionCount - 1;
                    String string_0;
                    if (itemSelectionState == 1 && menuOptionCount < 2) {
                        string_0 = "Use" + " " + aString35 + " " + "->";
                    } else if (spellSelected && menuOptionCount < 2) {
                        string_0 = aString34 + " " + aString36 + " " + "->";
                    } else {
                        string_0 = Class38.method253(int_2);
                    }

                    if (menuOptionCount > 2) {
                        string_0 = string_0 + WallObject.getColTags(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
                    }

                    Class50.aFont3.drawRandomizedMouseoverText(string_0, int_0 + 4, int_1 + 15, 16777215, 0, gameCycle / 1000);
                }
            }
        } else {
            Class74.method446();
        }

        if (gameDrawingMode == 3) {
            for (int_0 = 0; int_0 < anInt610; int_0++) {
                if (aBoolArray10[int_0]) {
                    Rasterizer2D.fillRectangle(widgetPositionX[int_0], widgetPositionY[int_0], widgetBoundsWidth[int_0], widgetBoundsHeight[int_0], 16711935, 128);
                } else if (aBoolArray11[int_0]) {
                    Rasterizer2D.fillRectangle(widgetPositionX[int_0], widgetPositionY[int_0], widgetBoundsWidth[int_0], widgetBoundsHeight[int_0], 16711680, 128);
                }
            }
        }

        Class27.method226(Ignore.plane, Class4.localPlayer.x, Class4.localPlayer.y, anInt625);
        anInt625 = 0;
    }

    protected void method1085() {
        aLong30 = Class97.currentTimeMs() + 500L;
        this.method1097();
        if (widgetRoot != -1) {
            this.method1098(true);
        }

    }

    void method1104() {
        if (anInt608 > 1) {
            --anInt608;
        }

        if (anInt609 > 0) {
            --anInt609;
        }

        if (socketError) {
            socketError = false;
            WidgetNode.method684();
        } else {
            if (!isMenuOpen) {
                Class9.method147();
                menuOptions[0] = "Cancel";
                menuTargets[0] = "";
                menuTypes[0] = 1006;
                aBoolArray9[0] = false;
                menuOptionCount = 1;
            }

            for (int int_0 = 0; int_0 < 100 && this.method1100(aClass46_1); int_0++) {
                ;
            }

            if (gameState == 30) {
                while (true) {
                    ClassInfo classinfo_0 = (ClassInfo) Class108.aCombatInfoList4.method454();
                    boolean bool_0;
                    if (classinfo_0 == null) {
                        bool_0 = false;
                    } else {
                        bool_0 = true;
                    }

                    int int_2;
                    PacketNode packetnode_3;
                    if (!bool_0) {
                        PacketNode packetnode_0;
                        int int_1;
                        if (aClass100_1.aBool30) {
                            packetnode_0 = Actor.method953(ClientPacket.aClientPacket10, aClass46_1.cipher);
                            packetnode_0.packetBuffer.putByte(0);
                            int_1 = packetnode_0.packetBuffer.position;
                            aClass100_1.method529(packetnode_0.packetBuffer);
                            packetnode_0.packetBuffer.method708(packetnode_0.packetBuffer.position - int_1);
                            aClass46_1.method282(packetnode_0);
                            aClass100_1.method530();
                        }

                        Object object_0 = Class48.aClass18_1.anObject1;
                        int int_3;
                        int int_4;
                        int int_5;
                        int int_6;
                        int int_7;
                        synchronized (object_0) {
                            if (!aBool84) {
                                Class48.aClass18_1.anInt71 = 0;
                            } else if (MouseInput.anInt259 != 0 || Class48.aClass18_1.anInt71 >= 40) {
                                packetnode_3 = Actor.method953(ClientPacket.aClientPacket5, aClass46_1.cipher);
                                packetnode_3.packetBuffer.putByte(0);
                                int_2 = packetnode_3.packetBuffer.position;
                                int_3 = 0;

                                for (int_4 = 0; int_4 < Class48.aClass18_1.anInt71 && packetnode_3.packetBuffer.position - int_2 < 240; int_4++) {
                                    ++int_3;
                                    int_5 = Class48.aClass18_1.anIntArray6[int_4];
                                    if (int_5 < 0) {
                                        int_5 = 0;
                                    } else if (int_5 > 502) {
                                        int_5 = 502;
                                    }

                                    int_6 = Class48.aClass18_1.anIntArray5[int_4];
                                    if (int_6 < 0) {
                                        int_6 = 0;
                                    } else if (int_6 > 764) {
                                        int_6 = 764;
                                    }

                                    int_7 = int_5 * 765 + int_6;
                                    if (Class48.aClass18_1.anIntArray6[int_4] == -1 && Class48.aClass18_1.anIntArray5[int_4] == -1) {
                                        int_6 = -1;
                                        int_5 = -1;
                                        int_7 = 524287;
                                    }

                                    if (int_6 == anInt622 && int_5 == anInt623) {
                                        if (anInt624 < 2047) {
                                            ++anInt624;
                                        }
                                    } else {
                                        int int_8 = int_6 - anInt622;
                                        anInt622 = int_6;
                                        int int_9 = int_5 - anInt623;
                                        anInt623 = int_5;
                                        if (anInt624 < 8 && int_8 >= -32 && int_8 <= 31 && int_9 >= -32 && int_9 <= 31) {
                                            int_8 += 32;
                                            int_9 += 32;
                                            packetnode_3.packetBuffer.putShort(int_9 + (anInt624 << 12) + (int_8 << 6));
                                            anInt624 = 0;
                                        } else if (anInt624 < 8) {
                                            packetnode_3.packetBuffer.put24bitInt((anInt624 << 19) + int_7 + 8388608);
                                            anInt624 = 0;
                                        } else {
                                            packetnode_3.packetBuffer.putInt((anInt624 << 19) + int_7 + -1073741824);
                                            anInt624 = 0;
                                        }
                                    }
                                }

                                packetnode_3.packetBuffer.method708(packetnode_3.packetBuffer.position - int_2);
                                aClass46_1.method282(packetnode_3);
                                if (int_3 >= Class48.aClass18_1.anInt71) {
                                    Class48.aClass18_1.anInt71 = 0;
                                } else {
                                    Class48.aClass18_1.anInt71 -= int_3;

                                    for (int_4 = 0; int_4 < Class48.aClass18_1.anInt71; int_4++) {
                                        Class48.aClass18_1.anIntArray5[int_4] = Class48.aClass18_1.anIntArray5[int_3 + int_4];
                                        Class48.aClass18_1.anIntArray6[int_4] = Class48.aClass18_1.anIntArray6[int_3 + int_4];
                                    }
                                }
                            }
                        }

                        PacketNode packetnode_1;
                        if (MouseInput.anInt259 == 1 || !Item.aBool73 && MouseInput.anInt259 == 4 || MouseInput.anInt259 == 2) {
                            long long_0 = (MouseInput.aLong23 - aLong31) / 50L;
                            if (long_0 > 4095L) {
                                long_0 = 4095L;
                            }

                            aLong31 = MouseInput.aLong23;
                            int_2 = MouseInput.anInt265;
                            if (int_2 < 0) {
                                int_2 = 0;
                            } else if (int_2 > Class29.canvasHeight) {
                                int_2 = Class29.canvasHeight;
                            }

                            int_3 = MouseInput.anInt264;
                            if (int_3 < 0) {
                                int_3 = 0;
                            } else if (int_3 > Tile.canvasWidth) {
                                int_3 = Tile.canvasWidth;
                            }

                            int_4 = (int) long_0;
                            packetnode_1 = Actor.method953(ClientPacket.aClientPacket4, aClass46_1.cipher);
                            packetnode_1.packetBuffer.putShort((MouseInput.anInt259 == 2 ? 1 : 0) + (int_4 << 1));
                            packetnode_1.packetBuffer.putShort(int_3);
                            packetnode_1.packetBuffer.putShort(int_2);
                            aClass46_1.method282(packetnode_1);
                        }

                        if (KeyFocusListener.anInt126 > 0) {
                            packetnode_0 = Actor.method953(ClientPacket.aClientPacket2, aClass46_1.cipher);
                            packetnode_0.packetBuffer.putShort(0);
                            int_1 = packetnode_0.packetBuffer.position;
                            long long_1 = Class97.currentTimeMs();

                            for (int_4 = 0; int_4 < KeyFocusListener.anInt126; int_4++) {
                                long long_2 = long_1 - aLong32;
                                if (long_2 > 16777215L) {
                                    long_2 = 16777215L;
                                }

                                aLong32 = long_1;
                                packetnode_0.packetBuffer.method723((int) long_2);
                                packetnode_0.packetBuffer.putByteInverse(KeyFocusListener.anIntArray31[int_4]);
                            }

                            packetnode_0.packetBuffer.method722(packetnode_0.packetBuffer.position - int_1);
                            aClass46_1.method282(packetnode_0);
                        }

                        if (anInt637 > 0) {
                            --anInt637;
                        }

                        if (KeyFocusListener.aBoolArray3[96] || KeyFocusListener.aBoolArray3[97] || KeyFocusListener.aBoolArray3[98] || KeyFocusListener.aBoolArray3[99]) {
                            aBool92 = true;
                        }

                        if (aBool92 && anInt637 <= 0) {
                            anInt637 = 20;
                            aBool92 = false;
                            packetnode_0 = Actor.method953(ClientPacket.aClientPacket7, aClass46_1.cipher);
                            packetnode_0.packetBuffer.method719(anInt661);
                            packetnode_0.packetBuffer.putShortS(mapAngle);
                            aClass46_1.method282(packetnode_0);
                        }

                        if (Class12.aBool3 && !aBool90) {
                            aBool90 = true;
                            packetnode_0 = Actor.method953(ClientPacket.aClientPacket6, aClass46_1.cipher);
                            packetnode_0.packetBuffer.putByte(1);
                            aClass46_1.method282(packetnode_0);
                        }

                        if (!Class12.aBool3 && aBool90) {
                            aBool90 = false;
                            packetnode_0 = Actor.method953(ClientPacket.aClientPacket6, aClass46_1.cipher);
                            packetnode_0.packetBuffer.putByte(0);
                            aClass46_1.method282(packetnode_0);
                        }

                        RSCanvas.method748();
                        if (gameState != 30) {
                            return;
                        }

                        for (SceneSpawnNode pendingspawn_0 = (SceneSpawnNode) pendingSpawns.getFront(); pendingspawn_0 != null; pendingspawn_0 = (SceneSpawnNode) pendingSpawns.getNext()) {
                            if (pendingspawn_0.timeLeftTillSpawn > 0) {
                                --pendingspawn_0.timeLeftTillSpawn;
                            }

                            if (pendingspawn_0.timeLeftTillSpawn == 0) {
                                if (pendingspawn_0.objectId < 0 || method1110(pendingspawn_0.objectId, pendingspawn_0.objectType)) {
                                    Class10.method154(pendingspawn_0.plane, pendingspawn_0.spawnType, pendingspawn_0.x, pendingspawn_0.y, pendingspawn_0.objectId, pendingspawn_0.objectFace, pendingspawn_0.objectType);
                                    pendingspawn_0.unlink();
                                }
                            } else {
                                if (pendingspawn_0.updateCycle > 0) {
                                    --pendingspawn_0.updateCycle;
                                }

                                if (pendingspawn_0.updateCycle == 0 && pendingspawn_0.x >= 1 && pendingspawn_0.y >= 1 && pendingspawn_0.x <= 102 && pendingspawn_0.y <= 102 && (pendingspawn_0.id < 0 || method1110(pendingspawn_0.id, pendingspawn_0.objectType2))) {
                                    Class10.method154(pendingspawn_0.plane, pendingspawn_0.spawnType, pendingspawn_0.x, pendingspawn_0.y, pendingspawn_0.id, pendingspawn_0.orientation, pendingspawn_0.objectType2);
                                    pendingspawn_0.updateCycle = -1;
                                    if (pendingspawn_0.objectId == pendingspawn_0.id && pendingspawn_0.objectId == -1) {
                                        pendingspawn_0.unlink();
                                    } else if (pendingspawn_0.objectId == pendingspawn_0.id && pendingspawn_0.objectFace == pendingspawn_0.orientation && pendingspawn_0.objectType == pendingspawn_0.objectType2) {
                                        pendingspawn_0.unlink();
                                    }
                                }
                            }
                        }

                        Class24.method216();
                        ++aClass46_1.anInt103;
                        if (aClass46_1.anInt103 > 750) {
                            WidgetNode.method684();
                            return;
                        }

                        Class86.method494();
                        AClass6_Sub3.method864();
                        int[] ints_0 = Class27.localPlayerIndices;

                        for (int_1 = 0; int_1 < Class27.localPlayerIndexCount; int_1++) {
                            Player player_0 = players[ints_0[int_1]];
                            if (player_0 != null && player_0.textCycle > 0) {
                                --player_0.textCycle;
                                if (player_0.textCycle == 0) {
                                    player_0.overhead = null;
                                }
                            }
                        }

                        for (int_1 = 0; int_1 < npcIndexesCount; int_1++) {
                            int_2 = npcIndices[int_1];
                            NPC npc_0 = cachedNPCs[int_2];
                            if (npc_0 != null && npc_0.textCycle > 0) {
                                --npc_0.textCycle;
                                if (npc_0.textCycle == 0) {
                                    npc_0.overhead = null;
                                }
                            }
                        }

                        ++anInt625;
                        if (cursorState != 0) {
                            anInt645 += 20;
                            if (anInt645 >= 400) {
                                cursorState = 0;
                            }
                        }

                        if (Class59.aWidget3 != null) {
                            ++anInt651;
                            if (anInt651 >= 15) {
                                WorldMapData.method305(Class59.aWidget3);
                                Class59.aWidget3 = null;
                            }
                        }

                        Widget widget_1 = ItemContainer.aWidget6;
                        Widget widget_0 = Class47.aWidget1;
                        ItemContainer.aWidget6 = null;
                        Class47.aWidget1 = null;
                        aWidget13 = null;
                        aBool85 = false;
                        aBool86 = false;
                        anInt689 = 0;

                        while (Class11.method163() && anInt689 < 128) {
                            if (rights >= 2 && KeyFocusListener.aBoolArray3[82] && CombatInfoListHolder.anInt329 == 66) {
                                String string_0 = "";

                                MessageNode messagenode_0;
                                for (Iterator iterator_0 = Class34.anIterableHashTable1.iterator(); iterator_0.hasNext(); string_0 = string_0 + messagenode_0.name + ':' + messagenode_0.value + '\n') {
                                    messagenode_0 = (MessageNode) iterator_0.next();
                                }

                                AClass3.clientInstance.method1090(string_0);
                            } else {
                                anIntArray164[anInt689] = CombatInfoListHolder.anInt329;
                                anIntArray166[anInt689] = Class106.aChar1;
                                ++anInt689;
                            }
                        }

                        if (WorldMapData_Sub1.method602() && KeyFocusListener.aBoolArray3[82] && KeyFocusListener.aBoolArray3[81] && anInt636 != 0) {
                            int_2 = Class4.localPlayer.currentPlane - anInt636;
                            if (int_2 < 0) {
                                int_2 = 0;
                            } else if (int_2 > 3) {
                                int_2 = 3;
                            }

                            if (int_2 != Class4.localPlayer.currentPlane) {
                                int_3 = Class4.localPlayer.pathX[0] + ItemLayer.baseX;
                                int_4 = Class4.localPlayer.pathY[0] + ItemLayer.baseY;
                                packetnode_1 = Actor.method953(ClientPacket.aClientPacket18, aClass46_1.cipher);
                                packetnode_1.packetBuffer.putShort(int_4);
                                packetnode_1.packetBuffer.putShortS(int_3);
                                packetnode_1.packetBuffer.putByte(int_2);
                                aClass46_1.method282(packetnode_1);
                            }

                            anInt636 = 0;
                        }

                        if (widgetRoot != -1) {
                            GameEngine.method1092(widgetRoot, 0, 0, Tile.canvasWidth, Class29.canvasHeight, 0, 0);
                        }

                        ++cycleCntr;

                        while (true) {
                            ScriptEvent scriptevent_0;
                            Widget widget_3;
                            Widget widget_4;
                            do {
                                scriptevent_0 = (ScriptEvent) aDeque8.popFront();
                                if (scriptevent_0 == null) {
                                    while (true) {
                                        do {
                                            scriptevent_0 = (ScriptEvent) aDeque9.popFront();
                                            if (scriptevent_0 == null) {
                                                while (true) {
                                                    do {
                                                        scriptevent_0 = (ScriptEvent) aDeque7.popFront();
                                                        if (scriptevent_0 == null) {
                                                            this.method1107();
                                                            if (renderOverview != null) {
                                                                renderOverview.method36(Ignore.plane, (Class4.localPlayer.x >> 7) + ItemLayer.baseX, (Class4.localPlayer.y >> 7) + ItemLayer.baseY, false);
                                                                renderOverview.method37();
                                                            }

                                                            if (aWidget9 != null) {
                                                                this.method1108();
                                                            }

                                                            if (ClanMember.aWidget7 != null) {
                                                                WorldMapData.method305(ClanMember.aWidget7);
                                                                ++anInt627;
                                                                if (MouseInput.anInt263 == 0) {
                                                                    if (aBool91) {
                                                                        if (ClanMember.aWidget7 == Class52.aWidget2 && anInt635 != anInt693) {
                                                                            Widget widget_2 = ClanMember.aWidget7;
                                                                            byte byte_0 = 0;
                                                                            if (anInt672 == 1 && widget_2.contentType == 206) {
                                                                                byte_0 = 1;
                                                                            }

                                                                            if (widget_2.itemIds[anInt693] <= 0) {
                                                                                byte_0 = 0;
                                                                            }

                                                                            int_5 = Preferences.getWidgetConfig(widget_2);
                                                                            boolean bool_1 = (int_5 >> 29 & 0x1) != 0;
                                                                            if (bool_1) {
                                                                                int_6 = anInt635;
                                                                                int_7 = anInt693;
                                                                                widget_2.itemIds[int_7] = widget_2.itemIds[int_6];
                                                                                widget_2.itemQuantities[int_7] = widget_2.itemQuantities[int_6];
                                                                                widget_2.itemIds[int_6] = -1;
                                                                                widget_2.itemQuantities[int_6] = 0;
                                                                            } else if (byte_0 == 1) {
                                                                                int_6 = anInt635;
                                                                                int_7 = anInt693;

                                                                                while (int_6 != int_7) {
                                                                                    if (int_6 > int_7) {
                                                                                        widget_2.method596(int_6 - 1, int_6);
                                                                                        --int_6;
                                                                                    } else if (int_6 < int_7) {
                                                                                        widget_2.method596(int_6 + 1, int_6);
                                                                                        ++int_6;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                widget_2.method596(anInt693, anInt635);
                                                                            }

                                                                            PacketNode packetnode_2 = Actor.method953(ClientPacket.aClientPacket84, aClass46_1.cipher);
                                                                            packetnode_2.packetBuffer.method725(ClanMember.aWidget7.id);
                                                                            packetnode_2.packetBuffer.putByteS(byte_0);
                                                                            packetnode_2.packetBuffer.method719(anInt693);
                                                                            packetnode_2.packetBuffer.putShortS(anInt635);
                                                                            aClass46_1.method282(packetnode_2);
                                                                        }
                                                                    } else if (this.method1099()) {
                                                                        this.method1101(anInt628, anInt629);
                                                                    } else if (menuOptionCount > 0) {
                                                                        int_2 = anInt628;
                                                                        int_3 = anInt629;
                                                                        ContextMenuRow contextmenurow_0 = WorldMapData_Sub1.topContextMenuRow;
                                                                        Ignore.menuAction(contextmenurow_0.param0, contextmenurow_0.param1, contextmenurow_0.type, contextmenurow_0.identifier, contextmenurow_0.option, contextmenurow_0.option, int_2, int_3);
                                                                        WorldMapData_Sub1.topContextMenuRow = null;
                                                                    }

                                                                    anInt651 = 10;
                                                                    MouseInput.anInt259 = 0;
                                                                    ClanMember.aWidget7 = null;
                                                                } else if (anInt627 >= 5 && (MouseInput.anInt260 > anInt628 + 5 || MouseInput.anInt260 < anInt628 - 5 || MouseInput.anInt262 > anInt629 + 5 || MouseInput.anInt262 < anInt629 - 5)) {
                                                                    aBool91 = true;
                                                                }
                                                            }

                                                            if (Region.method381()) {
                                                                int_2 = Region.selectedRegionTileX;
                                                                int_3 = Region.selectedRegionTileY;
                                                                PacketNode packetnode_4 = Actor.method953(ClientPacket.aClientPacket82, aClass46_1.cipher);
                                                                packetnode_4.packetBuffer.putByte(5);
                                                                packetnode_4.packetBuffer.putShortS(int_3 + ItemLayer.baseY);
                                                                packetnode_4.packetBuffer.putShortS(int_2 + ItemLayer.baseX);
                                                                packetnode_4.packetBuffer.putByteA(KeyFocusListener.aBoolArray3[82] ? (KeyFocusListener.aBoolArray3[81] ? 2 : 1) : 0);
                                                                aClass46_1.method282(packetnode_4);
                                                                Region.method386();
                                                                anInt641 = MouseInput.anInt264;
                                                                anInt642 = MouseInput.anInt265;
                                                                cursorState = 1;
                                                                anInt645 = 0;
                                                                destinationX = int_2;
                                                                destinationY = int_3;
                                                            }

                                                            if (widget_1 != ItemContainer.aWidget6) {
                                                                if (widget_1 != null) {
                                                                    WorldMapData.method305(widget_1);
                                                                }

                                                                if (ItemContainer.aWidget6 != null) {
                                                                    WorldMapData.method305(ItemContainer.aWidget6);
                                                                }
                                                            }

                                                            if (widget_0 != Class47.aWidget1 && anInt670 == anInt668) {
                                                                if (widget_0 != null) {
                                                                    WorldMapData.method305(widget_0);
                                                                }

                                                                if (Class47.aWidget1 != null) {
                                                                    WorldMapData.method305(Class47.aWidget1);
                                                                }
                                                            }

                                                            if (Class47.aWidget1 != null) {
                                                                if (anInt670 < anInt668) {
                                                                    ++anInt670;
                                                                    if (anInt670 == anInt668) {
                                                                        WorldMapData.method305(Class47.aWidget1);
                                                                    }
                                                                }
                                                            } else if (anInt670 > 0) {
                                                                --anInt670;
                                                            }

                                                            Class78.method465();
                                                            if (aBool94) {
                                                                AClass1_Sub2.method639();
                                                            }

                                                            for (int_2 = 0; int_2 < 5; int_2++) {
                                                                ++anIntArray145[int_2];
                                                            }

                                                            Class40.chatMessages.process();
                                                            int_2 = ++MouseInput.mouseIdleTicks - 1;
                                                            int_4 = AClass1_Sub2.method640();
                                                            if (int_2 > 15000 && int_4 > 15000) {
                                                                anInt609 = 250;
                                                                MouseInput.mouseIdleTicks = 14500;
                                                                packetnode_1 = Actor.method953(ClientPacket.aClientPacket3, aClass46_1.cipher);
                                                                aClass46_1.method282(packetnode_1);
                                                            }

                                                            for (Class68_Sub1 class68_sub1_0 = (Class68_Sub1) aClass72_1.method441(); class68_sub1_0 != null; class68_sub1_0 = (Class68_Sub1) aClass72_1.method443()) {
                                                                if ((long) class68_sub1_0.anInt311 < Class97.currentTimeMs() / 1000L - 5L) {
                                                                    if (class68_sub1_0.aShort1 > 0) {
                                                                        Class34.sendGameMessage(5, "", class68_sub1_0.aString17 + " has logged in.");
                                                                    }

                                                                    if (class68_sub1_0.aShort1 == 0) {
                                                                        Class34.sendGameMessage(5, "", class68_sub1_0.aString17 + " has logged out.");
                                                                    }

                                                                    class68_sub1_0.method415();
                                                                }
                                                            }

                                                            ++aClass46_1.anInt104;
                                                            if (aClass46_1.anInt104 > 50) {
                                                                packetnode_1 = Actor.method953(ClientPacket.aClientPacket1, aClass46_1.cipher);
                                                                aClass46_1.method282(packetnode_1);
                                                            }

                                                            try {
                                                                aClass46_1.method283();
                                                            } catch (IOException ioexception_0) {
                                                                WidgetNode.method684();
                                                            }

                                                            return;
                                                        }

                                                        widget_3 = scriptevent_0.widget;
                                                        if (widget_3.index < 0) {
                                                            break;
                                                        }

                                                        widget_4 = Junk.method671(widget_3.parentId);
                                                    }
                                                    while (widget_4 == null || widget_4.children == null || widget_3.index >= widget_4.children.length || widget_3 != widget_4.children[widget_3.index]);

                                                    Class52.method335(scriptevent_0);
                                                }
                                            }

                                            widget_3 = scriptevent_0.widget;
                                            if (widget_3.index < 0) {
                                                break;
                                            }

                                            widget_4 = Junk.method671(widget_3.parentId);
                                        }
                                        while (widget_4 == null || widget_4.children == null || widget_3.index >= widget_4.children.length || widget_3 != widget_4.children[widget_3.index]);

                                        Class52.method335(scriptevent_0);
                                    }
                                }

                                widget_3 = scriptevent_0.widget;
                                if (widget_3.index < 0) {
                                    break;
                                }

                                widget_4 = Junk.method671(widget_3.parentId);
                            }
                            while (widget_4 == null || widget_4.children == null || widget_3.index >= widget_4.children.length || widget_3 != widget_4.children[widget_3.index]);

                            Class52.method335(scriptevent_0);
                        }
                    }

                    packetnode_3 = Actor.method953(ClientPacket.aClientPacket8, aClass46_1.cipher);
                    packetnode_3.packetBuffer.putByte(0);
                    int_2 = packetnode_3.packetBuffer.position;
                    World.encodeClassVerifier(packetnode_3.packetBuffer);
                    packetnode_3.packetBuffer.method708(packetnode_3.packetBuffer.position - int_2);
                    aClass46_1.method282(packetnode_3);
                }
            }
        }
    }

    void handleLoginState() {
        RSSocket socket = aClass46_1.createSocket();
        PacketBuffer buffer = aClass46_1.aPacketBuffer1;

        try {
            if (loginState == 0) {
                if (socket != null) {
                    socket.close();
                    socket = null;
                }

                BaseVarType.aTask1 = null;
                socketError = false;
                anInt618 = 0;
                loginState = 1;
            }

            if (loginState == 1) {
                if (BaseVarType.aTask1 == null) {
                    BaseVarType.aTask1 = GameEngine.taskManager.createSocket(MilliTimer.host, AClass3.myWorldPort);
                }

                if (BaseVarType.aTask1.status == 2) {
                    throw new IOException();
                }

                if (BaseVarType.aTask1.status == 1) {
                    aClass46_1.method281(new RSSocket((Socket) BaseVarType.aTask1.value, GameEngine.taskManager, 5000));
                    socket = aClass46_1.createSocket();
                    BaseVarType.aTask1 = null;
                    loginState = 2;
                }
            }

            if (loginState == 2) {
                aClass46_1.method280();
                PacketNode packetnode_0 = Class26.method222();
                packetnode_0.clientPacket = null;
                packetnode_0.anInt350 = 0;
                packetnode_0.packetBuffer = new PacketBuffer(5000);
                packetnode_0.packetBuffer.putByte(Class60.aClass60_1.anInt157);
                aClass46_1.method282(packetnode_0);
                aClass46_1.method283();
                buffer.position = 0;
                loginState = 3;
            }

            int int_0;
            if (loginState == 3) {
                if (Class35.soundSystem0 != null) {
                    Class35.soundSystem0.method343();
                }

                if (Class47.soundSystem1 != null) {
                    Class47.soundSystem1.method343();
                }

                int_0 = socket.readByte();
                if (Class35.soundSystem0 != null) {
                    Class35.soundSystem0.method343();
                }

                if (Class47.soundSystem1 != null) {
                    Class47.soundSystem1.method343();
                }

                if (int_0 != 0) {
                    WorldMapType1.method578(int_0);
                    return;
                }

                buffer.position = 0;
                loginState = 4;
            }

            if (loginState == 4) {
                if (buffer.position < 8) {
                    int_0 = socket.available();
                    if (int_0 > 8 - buffer.position) {
                        int_0 = 8 - buffer.position;
                    }

                    if (int_0 > 0) {
                        socket.read(buffer.buffer, buffer.position, int_0);
                        buffer.position += int_0;
                    }
                }

                if (buffer.position == 8) {
                    buffer.position = 0;
                    ScriptState.aLong21 = buffer.readLong();
                    loginState = 5;
                }
            }

            if (loginState == 5) {
                aClass46_1.aPacketBuffer1.position = 0;
                aClass46_1.method280();
                PacketBuffer outgoing = new PacketBuffer(500);
                int[] seed = new int[]{(int) (Math.random() * 9.9999999E7D), (int) (Math.random() * 9.9999999E7D), (int) (ScriptState.aLong21 >> 32), (int) (ScriptState.aLong21 & 0xFFFFFFFFFFFFFFFFL)};
                outgoing.position = 0;
                outgoing.putByte(1);
                outgoing.putByte(anEnum3_5.rsOrdinal());//Id?
                outgoing.putInt(seed[0]);
                outgoing.putInt(seed[1]);
                outgoing.putInt(seed[2]);
                outgoing.putInt(seed[3]);
                switch (anEnum3_5.anInt343) {
                    case 0:
                    case 3:
                        outgoing.put24bitInt(Class34.playerPin);
                        outgoing.position += 5;
                        break;
                    case 1:
                        outgoing.putInt(((Integer) Buffer.preferences.preferences.get(Integer.valueOf(AClass6_Sub4.method867(Class25.username)))).intValue());
                        outgoing.position += 4;
                        break;
                    case 2:
                        outgoing.position += 8;
                }

                outgoing.putString(Class25.password);
                outgoing.encryptRsa(Class29.RSA_EXPONENT, Class29.RSA_MODULUS);
                PacketNode login = Class26.method222();
                login.clientPacket = null;
                login.anInt350 = 0;
                login.packetBuffer = new PacketBuffer(5000);
                login.packetBuffer.position = 0;
                if (gameState == 40) {//Reconnecting?
                    login.packetBuffer.putByte(Class60.aClass60_4.anInt157);
                } else {
                    login.packetBuffer.putByte(Class60.aClass60_3.anInt157);
                }

                login.packetBuffer.putShort(0);
                int int_1 = login.packetBuffer.position;
                login.packetBuffer.putInt(157);
                login.packetBuffer.putBytes(outgoing.buffer, 0, outgoing.position);
                int int_2 = login.packetBuffer.position;
                login.packetBuffer.putString(Class25.username);
                login.packetBuffer.putByte((isResized ? 1 : 0) << 1 | (lowMemory ? 1 : 0));
                login.packetBuffer.putShort(Tile.canvasWidth);
                login.packetBuffer.putShort(Class29.canvasHeight);
                Node_Sub5.method695(login.packetBuffer);
                login.packetBuffer.putString(Class16.sessionToken);
                login.packetBuffer.putInt(Class10.anInt48);
                Buffer buffer_0 = new Buffer(CombatInfo1.aMachineInfo1.method697());
                CombatInfo1.aMachineInfo1.method698(buffer_0);
                login.packetBuffer.putBytes(buffer_0.buffer, 0, buffer_0.buffer.length);
                login.packetBuffer.putByte(Class65.anInt168);
                login.packetBuffer.putInt(0);
                login.packetBuffer.putInt(Varcs.indexInterfaces.crc);
                login.packetBuffer.putInt(Class6.indexSoundEffects.crc);
                login.packetBuffer.putInt(GrandExchangeOffer.configsIndex.crc);
                login.packetBuffer.putInt(Class56.anIndexData2.crc);
                login.packetBuffer.putInt(Tile.anIndexData5.crc);
                login.packetBuffer.putInt(Class23.indexMaps.crc);
                login.packetBuffer.putInt(Class38.indexTrack1.crc);
                login.packetBuffer.putInt(Class4.indexModels.crc);
                login.packetBuffer.putInt(Class34.indexSprites.crc);
                login.packetBuffer.putInt(Class49.indexTextures.crc);
                login.packetBuffer.putInt(AbstractSoundSystem.anIndexData1.crc);
                login.packetBuffer.putInt(Class92.indexTrack2.crc);
                login.packetBuffer.putInt(Class3.indexScripts.crc);
                login.packetBuffer.putInt(Enum1.anIndexData4.crc);
                login.packetBuffer.putInt(WorldMapType2.vorbisIndex.crc);
                login.packetBuffer.putInt(Class61.anIndexData3.crc);
                login.packetBuffer.putInt(RSCanvas.indexWorldMap.crc);
                login.packetBuffer.encryptXtea(seed, int_2, login.packetBuffer.position);
                login.packetBuffer.method722(login.packetBuffer.position - int_1);
                aClass46_1.method282(login);
                aClass46_1.method283();
                aClass46_1.cipher = new IsaacCipher(seed);

                for (int index = 0; index < 4; index++) {
                    seed[index] += 50;
                }

                buffer.seed(seed);
                loginState = 6;
            }

            if (loginState == 6 && socket.available() > 0) {
                int_0 = socket.readByte();
                if (int_0 == 21 && gameState == 20) {
                    loginState = 7;
                } else if (int_0 == 2) {
                    loginState = 9;
                } else if (int_0 == 15 && gameState == 40) {
                    aClass46_1.packetLength = -1;
                    loginState = 13;
                } else if (int_0 == 23 && anInt614 < 1) {
                    ++anInt614;
                    loginState = 0;
                } else {
                    if (int_0 != 29) {
                        WorldMapType1.method578(int_0);
                        return;
                    }

                    loginState = 11;
                }
            }

            if (loginState == 7 && socket.available() > 0) {
                anInt648 = (socket.readByte() + 3) * 60;
                loginState = 8;
            }

            if (loginState == 8) {
                anInt618 = 0;
                AClass3_Sub1.method750("You have only just left another world.", "Your profile will be transferred in:", anInt648 / 60 + " seconds.");
                if (--anInt648 <= 0) {
                    loginState = 0;
                }

            } else {
                //Login
                boolean bool_0;
                int int_4;
                int int_6;
                if (loginState == 9 && socket.available() >= 13) {
                    boolean bool_1 = socket.readByte() == 1;
                    socket.read(buffer.buffer, 0, 4);
                    buffer.position = 0;
                    bool_0 = false;
                    if (bool_1) {
                        int_6 = buffer.readOpcode() << 24;
                        int_6 |= buffer.readOpcode() << 16;
                        int_6 |= buffer.readOpcode() << 8;
                        int_6 |= buffer.readOpcode();
                        int_4 = AClass6_Sub4.method867(Class25.username);
                        if (Buffer.preferences.preferences.size() >= 10 && !Buffer.preferences.preferences.containsKey(Integer.valueOf(int_4))) {
                            Iterator iterator_0 = Buffer.preferences.preferences.entrySet().iterator();
                            iterator_0.next();
                            iterator_0.remove();
                        }

                        Buffer.preferences.preferences.put(Integer.valueOf(int_4), Integer.valueOf(int_6));
                    }

                    if (Class25.aBool9) {
                        Buffer.preferences.aString10 = Class25.username;
                    } else {
                        Buffer.preferences.aString10 = null;
                    }

                    Class59.method390();
                    rights = socket.readByte();
                    aBool95 = socket.readByte() == 1;
                    localInteractingIndex = socket.readByte();
                    localInteractingIndex <<= 8;
                    localInteractingIndex += socket.readByte();
                    anInt678 = socket.readByte();
                    socket.read(buffer.buffer, 0, 1);
                    buffer.position = 0;
                    ServerPacket[] packets = DecorativeObject.method460();
                    int int_5 = buffer.method906();
                    if (int_5 < 0 || int_5 >= packets.length) {
                        throw new IOException(int_5 + " " + buffer.position);
                    }

                    aClass46_1.serverPacket = packets[int_5];
                    aClass46_1.packetLength = aClass46_1.serverPacket.packetLength;
                    socket.read(buffer.buffer, 0, 2);
                    buffer.position = 0;
                    aClass46_1.packetLength = buffer.getUnsignedShort();

                    try {
                        Class22.method214(AClass3.clientInstance, "zap");
                    } catch (Throwable throwable_0) {
                        ;
                    }

                    loginState = 10;
                }

                if (loginState == 10) {
                    if (socket.available() >= aClass46_1.packetLength) {
                        buffer.position = 0;
                        socket.read(buffer.buffer, 0, aClass46_1.packetLength);
                        aClass100_1.method525();
                        aLong31 = -1L;
                        anInt624 = -1;
                        Class48.aClass18_1.anInt71 = 0;
                        Class12.aBool3 = true;
                        aBool90 = true;
                        aLong32 = -1L;
                        Class93.method502();
                        aClass46_1.method280();
                        aClass46_1.aPacketBuffer1.position = 0;
                        aClass46_1.serverPacket = null;
                        aClass46_1.aServerPacket3 = null;
                        aClass46_1.aServerPacket1 = null;
                        aClass46_1.aServerPacket2 = null;
                        aClass46_1.packetLength = 0;
                        aClass46_1.anInt103 = 0;
                        anInt608 = 0;
                        anInt609 = 0;
                        hintArrowTargetType = 0;
                        Class9.method147();
                        MouseInput.mouseIdleTicks = 0;
                        Class34.chatLineMap.clear();
                        Class34.anIterableHashTable1.clear();
                        Class34.aClass77_1.method463();
                        Class34.anInt94 = 0;
                        itemSelectionState = 0;
                        spellSelected = false;
                        anInt647 = 0;
                        mapAngle = 0;
                        anInt650 = 0;
                        anInt652 = -1;
                        destinationX = 0;
                        destinationY = 0;
                        anEnum2_5 = Enum2.anEnum2_4;
                        anEnum2_6 = Enum2.anEnum2_4;
                        npcIndexesCount = 0;
                        Class27.localPlayerIndexCount = 0;

                        for (int_0 = 0; int_0 < 2048; int_0++) {
                            Class27.playerSynchronizationBuffers[int_0] = null;
                            Class27.aByteArray3[int_0] = 1;
                        }

                        for (int_0 = 0; int_0 < 2048; int_0++) {
                            players[int_0] = null;
                        }

                        for (int_0 = 0; int_0 < 32768; int_0++) {
                            cachedNPCs[int_0] = null;
                        }

                        anInt667 = -1;
                        projectiles.clear();
                        graphicsObjectDeque.clear();

                        for (int plane = 0; plane < 4; plane++) {
                            for (int x = 0; x < 104; x++) {
                                for (int y = 0; y < 104; y++) {
                                    groundItemDeque[plane][x][y] = null;
                                }
                            }
                        }

                        pendingSpawns = new Deque();
                        anInt655 = 0;
                        friendCount = 0;
                        ignoreCount = 0;

                        for (int_0 = 0; int_0 < VarPlayerType.anInt508; int_0++) {
                            VarPlayerType varplayertype_0 = ClanMember.method677(int_0);
                            if (varplayertype_0 != null) {
                                Settings.settings[int_0] = 0;
                                Settings.widgetSettings[int_0] = 0;
                            }
                        }

                        Class40.chatMessages.reset();
                        anInt682 = -1;
                        if (widgetRoot != -1) {
                            int_0 = widgetRoot;
                            if (int_0 != -1 && AClass3_Sub1.validInterfaces[int_0]) {
                                Class5.widgetIndex.method438(int_0);
                                if (Class91.widgets[int_0] != null) {
                                    bool_0 = true;

                                    for (int_4 = 0; int_4 < Class91.widgets[int_0].length; int_4++) {
                                        if (Class91.widgets[int_0][int_4] != null) {
                                            if (Class91.widgets[int_0][int_4].type != 2) {
                                                Class91.widgets[int_0][int_4] = null;
                                            } else {
                                                bool_0 = false;
                                            }
                                        }
                                    }

                                    if (bool_0) {
                                        Class91.widgets[int_0] = null;
                                    }

                                    AClass3_Sub1.validInterfaces[int_0] = false;
                                }
                            }
                        }

                        for (WidgetNode widgetnode_0 = (WidgetNode) componentTable.method67(); widgetnode_0 != null; widgetnode_0 = (WidgetNode) componentTable.method68()) {
                            Frames.method873(widgetnode_0, true);
                        }

                        widgetRoot = -1;
                        componentTable = new HashTable(8);
                        aWidget12 = null;
                        Class9.method147();
                        aPlayerComposition1.updateAppearance((int[]) null, new int[]{0, 0, 0, 0, 0}, false, -1);

                        for (int_0 = 0; int_0 < 8; int_0++) {
                            playerOptions[int_0] = null;
                            playerOptionsPriorities[int_0] = false;
                        }

                        Class21.method213();
                        aBool88 = true;

                        for (int_0 = 0; int_0 < 100; int_0++) {
                            aBoolArray8[int_0] = true;
                        }

                        ScriptVarType.method469();
                        clanChatOwner = null;
                        clanChatCount = 0;
                        DynamicObject.clanMembers = null;

                        for (int_0 = 0; int_0 < 8; int_0++) {
                            grandExchangeOffers[int_0] = new GrandExchangeOffer();
                        }

                        Class65.aClass47_1 = null;
                        Class85.initializeGPI(buffer);
                        Class87.anInt189 = -1;
                        WallObject.xteaChanged(false, buffer);
                        aClass46_1.serverPacket = null;
                    }

                } else {
                    if (loginState == 11 && socket.available() >= 2) {
                        buffer.position = 0;
                        socket.read(buffer.buffer, 0, 2);
                        buffer.position = 0;
                        Class4.anInt25 = buffer.getUnsignedShort();
                        loginState = 12;
                    }

                    if (loginState == 12 && socket.available() >= Class4.anInt25) {
                        buffer.position = 0;
                        socket.read(buffer.buffer, 0, Class4.anInt25);
                        buffer.position = 0;
                        String string_1 = buffer.readString();
                        String string_0 = buffer.readString();
                        String string_2 = buffer.readString();
                        AClass3_Sub1.method750(string_1, string_0, string_2);
                        Class110.setGameState(10);
                    }

                    if (loginState != 13) {
                        ++anInt618;
                        if (anInt618 > 2000) {
                            if (anInt614 < 1) {
                                if (AClass3.myWorldPort == DynamicObject.anInt577) {
                                    AClass3.myWorldPort = MessageNode.anInt509;
                                } else {
                                    AClass3.myWorldPort = DynamicObject.anInt577;
                                }

                                ++anInt614;
                                loginState = 0;
                            } else {
                                WorldMapType1.method578(-3);
                            }
                        }
                    } else {
                        if (aClass46_1.packetLength == -1) {
                            if (socket.available() < 2) {
                                return;
                            }

                            socket.read(buffer.buffer, 0, 2);
                            buffer.position = 0;
                            aClass46_1.packetLength = buffer.getUnsignedShort();
                        }

                        if (socket.available() >= aClass46_1.packetLength) {
                            socket.read(buffer.buffer, 0, aClass46_1.packetLength);
                            buffer.position = 0;
                            int_0 = aClass46_1.packetLength;
                            aClass100_1.method531();
                            aClass46_1.method280();
                            aClass46_1.aPacketBuffer1.position = 0;
                            aClass46_1.serverPacket = null;
                            aClass46_1.aServerPacket3 = null;
                            aClass46_1.aServerPacket1 = null;
                            aClass46_1.aServerPacket2 = null;
                            aClass46_1.packetLength = 0;
                            aClass46_1.anInt103 = 0;
                            anInt608 = 0;
                            Class9.method147();
                            anInt650 = 0;
                            destinationX = 0;

                            for (int_6 = 0; int_6 < 2048; int_6++) {
                                players[int_6] = null;
                            }

                            Class4.localPlayer = null;

                            for (int_6 = 0; int_6 < cachedNPCs.length; int_6++) {
                                NPC npc_0 = cachedNPCs[int_6];
                                if (npc_0 != null) {
                                    npc_0.interacting = -1;
                                    npc_0.aBool70 = false;
                                }
                            }

                            Class21.method213();
                            Class110.setGameState(30);

                            for (int_6 = 0; int_6 < 100; int_6++) {
                                aBoolArray8[int_6] = true;
                            }

                            ScriptVarType.method469();
                            Class85.initializeGPI(buffer);
                            if (int_0 != buffer.position) {
                                throw new RuntimeException();
                            }
                        }
                    }
                }
            }
        } catch (IOException ioexception_0) {
            if (anInt614 < 1) {
                if (AClass3.myWorldPort == DynamicObject.anInt577) {
                    AClass3.myWorldPort = MessageNode.anInt509;
                } else {
                    AClass3.myWorldPort = DynamicObject.anInt577;
                }

                ++anInt614;
                loginState = 0;
            } else {
                WorldMapType1.method578(-2);
            }
        }
    }

    protected void method1088(boolean bool_0) {
        boolean bool_1;
        label175:
        {
            try {
                if (Class78.anInt172 == 2) {
                    if (Class78.aTrack1_1 == null) {
                        Class78.aTrack1_1 = Track1.getMusicFile(Class70.anIndexDataBase3, Class78.anInt173, Class78.anInt174);
                        if (Class78.aTrack1_1 == null) {
                            bool_1 = false;
                            break label175;
                        }
                    }

                    if (Class3.aClass52_1 == null) {
                        Class3.aClass52_1 = new Class52(Class78.anIndexDataBase4, Class108.anIndexDataBase10);
                    }

                    if (Class78.anAClass6_Sub3_1.method845(Class78.aTrack1_1, Class78.anIndexDataBase5, Class3.aClass52_1, 22050)) {
                        Class78.anAClass6_Sub3_1.method849();
                        Class78.anAClass6_Sub3_1.method853(Class7.anInt40);
                        Class78.anAClass6_Sub3_1.method855(Class78.aTrack1_1, Class78.aBool29);
                        Class78.anInt172 = 0;
                        Class78.aTrack1_1 = null;
                        Class3.aClass52_1 = null;
                        Class70.anIndexDataBase3 = null;
                        bool_1 = true;
                        break label175;
                    }
                }
            } catch (Exception exception_0) {
                exception_0.printStackTrace();
                Class78.anAClass6_Sub3_1.method836();
                Class78.anInt172 = 0;
                Class78.aTrack1_1 = null;
                Class3.aClass52_1 = null;
                Class70.anIndexDataBase3 = null;
            }

            bool_1 = false;
        }

        if (bool_1 && aBool87 && Class35.soundSystem0 != null) {
            Class35.soundSystem0.method340();
        }

        int int_0;
        if ((gameState == 10 || gameState == 20 || gameState == 30) && aLong30 != 0L && Class97.currentTimeMs() > aLong30) {
            int_0 = isResized ? 2 : 1;
            Class43.method266(int_0);
        }

        if (bool_0) {
            for (int_0 = 0; int_0 < 100; int_0++) {
                aBoolArray8[int_0] = true;
            }
        }

        if (gameState == 0) {
            this.drawLoadingScreen(Class25.loadingBarPercentage, Class25.loadingText, bool_0);
        } else if (gameState == 5) {
            FileOnDisk.drawLoginScreen(Class50.aFont3, Class1.aFont2, Class4.font_p12full, bool_0);
        } else if (gameState != 10 && gameState != 11) {
            if (gameState == 20) {
                FileOnDisk.drawLoginScreen(Class50.aFont3, Class1.aFont2, Class4.font_p12full, bool_0);
            } else if (gameState == 25) {
                if (anInt630 == 1) {
                    if (anInt631 > anInt632) {
                        anInt632 = anInt631;
                    }

                    int_0 = (anInt632 * 50 - anInt631 * 50) / anInt632;
                    Class68_Sub1.drawStatusBox("Loading - please wait." + "<br>" + " (" + int_0 + "%" + ")", false);
                } else if (anInt630 == 2) {
                    if (anInt633 > anInt634) {
                        anInt634 = anInt633;
                    }

                    int_0 = (anInt634 * 50 - anInt633 * 50) / anInt634 + 50;
                    Class68_Sub1.drawStatusBox("Loading - please wait." + "<br>" + " (" + int_0 + "%" + ")", false);
                } else {
                    Class68_Sub1.drawStatusBox("Loading - please wait.", false);
                }
            } else if (gameState == 30) {
                this.method1103();
            } else if (gameState == 40) {
                Class68_Sub1.drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
            } else if (gameState == 45) {
                Class68_Sub1.drawStatusBox("Please wait...", false);
            }
        } else {
            FileOnDisk.drawLoginScreen(Class50.aFont3, Class1.aFont2, Class4.font_p12full, bool_0);
        }

        if (gameState == 30 && gameDrawingMode == 0 && !bool_0 && !isResized) {
            for (int_0 = 0; int_0 < anInt610; int_0++) {
                if (aBoolArray11[int_0]) {
                    Class68_Sub1.aBufferProvider1.method500(widgetPositionX[int_0], widgetPositionY[int_0], widgetBoundsWidth[int_0], widgetBoundsHeight[int_0]);
                    aBoolArray11[int_0] = false;
                }
            }
        } else if (gameState > 0) {
            Class68_Sub1.aBufferProvider1.method499(0, 0);

            for (int_0 = 0; int_0 < anInt610; int_0++) {
                aBoolArray11[int_0] = false;
            }
        }

    }

    void method1106(Widget widget_0) {
        Widget widget_1 = widget_0.parentId == -1 ? null : Junk.method671(widget_0.parentId);
        int int_0;
        int int_1;
        if (widget_1 == null) {
            int_0 = Tile.canvasWidth;
            int_1 = Class29.canvasHeight;
        } else {
            int_0 = widget_1.width;
            int_1 = widget_1.height;
        }

        MilliTimer.method742(widget_0, int_0, int_1, false);
        Class44.method269(widget_0, int_0, int_1);
    }

    void method1107() {
        boolean bool_0 = false;

        int int_0;
        int int_1;
        while (!bool_0) {
            bool_0 = true;

            for (int_0 = 0; int_0 < menuOptionCount - 1; int_0++) {
                if (menuTypes[int_0] < 1000 && menuTypes[int_0 + 1] > 1000) {
                    String string_0 = menuTargets[int_0];
                    menuTargets[int_0] = menuTargets[int_0 + 1];
                    menuTargets[int_0 + 1] = string_0;
                    String string_1 = menuOptions[int_0];
                    menuOptions[int_0] = menuOptions[int_0 + 1];
                    menuOptions[int_0 + 1] = string_1;
                    int_1 = menuTypes[int_0];
                    menuTypes[int_0] = menuTypes[int_0 + 1];
                    menuTypes[int_0 + 1] = int_1;
                    int_1 = menuActionParams0[int_0];
                    menuActionParams0[int_0] = menuActionParams0[int_0 + 1];
                    menuActionParams0[int_0 + 1] = int_1;
                    int_1 = menuActionParams1[int_0];
                    menuActionParams1[int_0] = menuActionParams1[int_0 + 1];
                    menuActionParams1[int_0 + 1] = int_1;
                    int_1 = menuIdentifiers[int_0];
                    menuIdentifiers[int_0] = menuIdentifiers[int_0 + 1];
                    menuIdentifiers[int_0 + 1] = int_1;
                    boolean bool_1 = aBoolArray9[int_0];
                    aBoolArray9[int_0] = aBoolArray9[int_0 + 1];
                    aBoolArray9[int_0 + 1] = bool_1;
                    bool_0 = false;
                }
            }
        }

        if (ClanMember.aWidget7 == null) {
            if (aWidget9 == null) {
                int int_6;
                int int_8;
                label279:
                {
                    int int_7 = MouseInput.anInt259;
                    int int_3;
                    int int_5;
                    if (isMenuOpen) {
                        int int_2;
                        if (int_7 != 1 && (Item.aBool73 || int_7 != 4)) {
                            int_0 = MouseInput.anInt260;
                            int_2 = MouseInput.anInt262;
                            if (int_0 < CacheFile.menuX - 10 || int_0 > Class93.menuWidth + CacheFile.menuX + 10 || int_2 < AClass1_Sub1.menuY - 10 || int_2 > AClass1_Sub1.menuY + Class42.menuHeight + 10) {
                                isMenuOpen = false;
                                AClass1_Sub2.method636(CacheFile.menuX, AClass1_Sub1.menuY, Class93.menuWidth, Class42.menuHeight);
                            }
                        }

                        if (int_7 == 1 || !Item.aBool73 && int_7 == 4) {
                            int_0 = CacheFile.menuX;
                            int_2 = AClass1_Sub1.menuY;
                            int_3 = Class93.menuWidth;
                            int_1 = MouseInput.anInt264;
                            int_8 = MouseInput.anInt265;
                            int int_4 = -1;

                            for (int int_9 = 0; int_9 < menuOptionCount; int_9++) {
                                int_5 = (menuOptionCount - 1 - int_9) * 15 + int_2 + 31;
                                if (int_1 > int_0 && int_1 < int_3 + int_0 && int_8 > int_5 - 13 && int_8 < int_5 + 3) {
                                    int_4 = int_9;
                                }
                            }

                            if (int_4 != -1) {
                                RouteStrategy.method394(int_4);
                            }

                            isMenuOpen = false;
                            AClass1_Sub2.method636(CacheFile.menuX, AClass1_Sub1.menuY, Class93.menuWidth, Class42.menuHeight);
                        }
                    } else {
                        int_0 = menuOptionCount - 1;
                        if ((int_7 == 1 || !Item.aBool73 && int_7 == 4) && int_0 >= 0) {
                            int_3 = menuTypes[int_0];
                            if (int_3 == 39 || int_3 == 40 || int_3 == 41 || int_3 == 42 || int_3 == 43 || int_3 == 33 || int_3 == 34 || int_3 == 35 || int_3 == 36 || int_3 == 37 || int_3 == 38 || int_3 == 1005) {
                                int_1 = menuActionParams0[int_0];
                                int_8 = menuActionParams1[int_0];
                                Widget widget_0 = Junk.method671(int_8);
                                int_5 = Preferences.getWidgetConfig(widget_0);
                                boolean bool_2 = (int_5 >> 28 & 0x1) != 0;
                                if (bool_2) {
                                    break label279;
                                }

                                int_6 = Preferences.getWidgetConfig(widget_0);
                                boolean bool_3 = (int_6 >> 29 & 0x1) != 0;
                                if (bool_3) {
                                    break label279;
                                }
                            }
                        }

                        if ((int_7 == 1 || !Item.aBool73 && int_7 == 4) && this.method1099()) {
                            int_7 = 2;
                        }

                        if ((int_7 == 1 || !Item.aBool73 && int_7 == 4) && menuOptionCount > 0) {
                            RouteStrategy.method394(int_0);
                        }

                        if (int_7 == 2 && menuOptionCount > 0) {
                            this.method1101(MouseInput.anInt264, MouseInput.anInt265);
                        }
                    }

                    return;
                }

                if (ClanMember.aWidget7 != null && !aBool91 && menuOptionCount > 0 && !this.method1099()) {
                    int int_10 = anInt628;
                    int_6 = anInt629;
                    ContextMenuRow contextmenurow_0 = WorldMapData_Sub1.topContextMenuRow;
                    Ignore.menuAction(contextmenurow_0.param0, contextmenurow_0.param1, contextmenurow_0.type, contextmenurow_0.identifier, contextmenurow_0.option, contextmenurow_0.option, int_10, int_6);
                    WorldMapData_Sub1.topContextMenuRow = null;
                }

                aBool91 = false;
                anInt627 = 0;
                if (ClanMember.aWidget7 != null) {
                    WorldMapData.method305(ClanMember.aWidget7);
                }

                ClanMember.aWidget7 = Junk.method671(int_8);
                anInt635 = int_1;
                anInt628 = MouseInput.anInt264;
                anInt629 = MouseInput.anInt265;
                if (int_0 >= 0) {
                    Class21.method212(int_0);
                }

                WorldMapData.method305(ClanMember.aWidget7);
            }
        }
    }

    void method1108() {
        WorldMapData.method305(aWidget9);
        ++ScriptVarType.anInt175;
        if (aBool85 && aBool86) {
            int int_0 = MouseInput.anInt260;
            int int_1 = MouseInput.anInt262;
            int_0 -= anInt619;
            int_1 -= anInt620;
            if (int_0 < anInt621) {
                int_0 = anInt621;
            }

            if (int_0 + aWidget9.width > anInt621 + aWidget10.width) {
                int_0 = anInt621 + aWidget10.width - aWidget9.width;
            }

            if (int_1 < anInt626) {
                int_1 = anInt626;
            }

            if (int_1 + aWidget9.height > anInt626 + aWidget10.height) {
                int_1 = anInt626 + aWidget10.height - aWidget9.height;
            }

            int int_2 = int_0 - anInt638;
            int int_3 = int_1 - anInt639;
            int int_4 = aWidget9.anInt284;
            if (ScriptVarType.anInt175 > aWidget9.anInt286 && (int_2 > int_4 || int_2 < -int_4 || int_3 > int_4 || int_3 < -int_4)) {
                aBool93 = true;
            }

            int int_5 = int_0 - anInt621 + aWidget10.scrollX;
            int int_6 = int_1 - anInt626 + aWidget10.scrollY;
            ScriptEvent scriptevent_0;
            if (aWidget9.anObjectArray3 != null && aBool93) {
                scriptevent_0 = new ScriptEvent();
                scriptevent_0.widget = aWidget9;
                scriptevent_0.anInt393 = int_5;
                scriptevent_0.anInt394 = int_6;
                scriptevent_0.anObjectArray22 = aWidget9.anObjectArray3;
                Class52.method335(scriptevent_0);
            }

            if (MouseInput.anInt263 == 0) {
                if (aBool93) {
                    if (aWidget9.anObjectArray4 != null) {
                        scriptevent_0 = new ScriptEvent();
                        scriptevent_0.widget = aWidget9;
                        scriptevent_0.anInt393 = int_5;
                        scriptevent_0.anInt394 = int_6;
                        scriptevent_0.aWidget8 = aWidget13;
                        scriptevent_0.anObjectArray22 = aWidget9.anObjectArray4;
                        Class52.method335(scriptevent_0);
                    }

                    if (aWidget13 != null) {
                        Widget widget_0 = aWidget9;
                        int int_7 = Preferences.getWidgetConfig(widget_0);
                        int int_8 = int_7 >> 17 & 0x7;
                        int int_9 = int_8;
                        Widget widget_1;
                        if (int_8 == 0) {
                            widget_1 = null;
                        } else {
                            int int_10 = 0;

                            while (true) {
                                if (int_10 >= int_9) {
                                    widget_1 = widget_0;
                                    break;
                                }

                                widget_0 = Junk.method671(widget_0.parentId);
                                if (widget_0 == null) {
                                    widget_1 = null;
                                    break;
                                }

                                ++int_10;
                            }
                        }

                        if (widget_1 != null) {
                            PacketNode packetnode_0 = Actor.method953(ClientPacket.aClientPacket13, aClass46_1.cipher);
                            packetnode_0.packetBuffer.method719(aWidget13.itemId);
                            packetnode_0.packetBuffer.method726(aWidget13.id);
                            packetnode_0.packetBuffer.putShortLEA(aWidget9.itemId);
                            packetnode_0.packetBuffer.method719(aWidget13.index);
                            packetnode_0.packetBuffer.putInt(aWidget9.id);
                            packetnode_0.packetBuffer.putShortLEA(aWidget9.index);
                            aClass46_1.method282(packetnode_0);
                        }
                    }
                } else if (this.method1099()) {
                    this.method1101(anInt619 + anInt638, anInt639 + anInt620);
                } else if (menuOptionCount > 0) {
                    int int_11 = anInt619 + anInt638;
                    int int_12 = anInt639 + anInt620;
                    ContextMenuRow contextmenurow_0 = WorldMapData_Sub1.topContextMenuRow;
                    Ignore.menuAction(contextmenurow_0.param0, contextmenurow_0.param1, contextmenurow_0.type, contextmenurow_0.identifier, contextmenurow_0.option, contextmenurow_0.option, int_11, int_12);
                    WorldMapData_Sub1.topContextMenuRow = null;
                }

                aWidget9 = null;
            }

        } else {
            if (ScriptVarType.anInt175 > 1) {
                aWidget9 = null;
            }

        }
    }

    public void init() {
        if (this.isValidHost()) {
            Parameters[] parameterss_0 = new Parameters[]{Parameters.aParameters2, Parameters.aParameters3, Parameters.aParameters4, Parameters.aParameters1, Parameters.aParameters5, Parameters.aParameters6, Parameters.aParameters7, Parameters.aParameters8, Parameters.aParameters9, Parameters.aParameters10, Parameters.aParameters12, Parameters.aParameters13, Parameters.aParameters14, Parameters.aParameters15, Parameters.aParameters11};
            Parameters[] parameterss_1 = parameterss_0;

            int int_0;
            for (int_0 = 0; int_0 < parameterss_1.length; int_0++) {
                Parameters parameters_0 = parameterss_1[int_0];
                String string_0 = this.getParameter(parameters_0.key);
                if (string_0 != null) {
                    switch (Integer.parseInt(parameters_0.key)) {
                        case 1:
                            if (string_0.equalsIgnoreCase("true")) {
                                isMembers = true;
                            } else {
                                isMembers = false;
                            }
                            break;
                        case 2:
                            socketType = Integer.parseInt(string_0);
                            break;
                        case 3:
                            Class10.anInt48 = Integer.parseInt(string_0);
                            break;
                        case 4:
                            TileStrategy.aString18 = string_0;
                        case 5:
                        case 13:
                        case 14:
                        default:
                            break;
                        case 6:
                            Class14.anEnum6_1 = (Enum6) Class1.forOrdinal(Class52.method336(), Integer.parseInt(string_0));
                            if (Enum6.anEnum6_7 == Class14.anEnum6_1) {
                                Class24.aClass109_1 = Class109.aClass109_2;
                            } else {
                                Class24.aClass109_1 = Class109.aClass109_10;
                            }
                            break;
                        case 7:
                            Class16.sessionToken = string_0;
                            break;
                        case 8:
                            languageId = Integer.parseInt(string_0);
                            break;
                        case 9:
                            flags = Integer.parseInt(string_0);
                            break;
                        case 10:
                            Class65.anInt168 = Integer.parseInt(string_0);
                            break;
                        case 11:
                            if (string_0.equalsIgnoreCase("true")) {
                                ;
                            }
                            break;
                        case 12:
                            world = Integer.parseInt(string_0);
                            break;
                        case 15:
                            GameEngine.aBuildType1 = Class88.method495(Integer.parseInt(string_0));
                    }
                }
            }

            TileStrategy.method630();
            MilliTimer.host = this.getCodeBase().getHost();
            String string_1 = GameEngine.aBuildType1.identifier;
            byte byte_0 = 0;

            try {
                Class64.anInt167 = 17;
                VarPlayerType.anInt507 = byte_0;

                try {
                    Class97.osName = System.getProperty("os.name");
                } catch (Exception exception_1) {
                    Class97.osName = "Unknown";
                }

                Class31.osNameLC = Class97.osName.toLowerCase();

                try {
                    Class51.userHome = System.getProperty("user.home");
                    if (Class51.userHome != null) {
                        Class51.userHome = Class51.userHome + "/";
                    }
                } catch (Exception exception_2) {
                    ;
                }

                try {
                    if (Class31.osNameLC.startsWith("win")) {
                        if (Class51.userHome == null) {
                            Class51.userHome = System.getenv("USERPROFILE");
                        }
                    } else if (Class51.userHome == null) {
                        Class51.userHome = System.getenv("HOME");
                    }

                    if (Class51.userHome != null) {
                        Class51.userHome = Class51.userHome + "/";
                    }
                } catch (Exception exception_3) {
                    ;
                }

                if (Class51.userHome == null) {
                    Class51.userHome = "~/";
                }

                WorldMapData_Sub1.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", Class51.userHome, "/tmp/", ""};
                Class64.aStringArray2 = new String[]{".jagex_cache_" + VarPlayerType.anInt507, ".file_store_" + VarPlayerType.anInt507};

                label118:
                for (int_0 = 0; int_0 < 4; int_0++) {
                    Class50.aFile1 = Class32.method239("oldschool", string_1, int_0);
                    if (!Class50.aFile1.exists()) {
                        Class50.aFile1.mkdirs();
                    }

                    File[] files_0 = Class50.aFile1.listFiles();
                    if (files_0 == null) {
                        break;
                    }

                    File[] files_1 = files_0;
                    int int_1 = 0;

                    while (true) {
                        if (int_1 >= files_1.length) {
                            break label118;
                        }

                        File file_0 = files_1[int_1];
                        if (!WorldMapType3.method574(file_0, false)) {
                            break;
                        }

                        ++int_1;
                    }
                }

                File file_1 = Class50.aFile1;
                Class63.aFile2 = file_1;
                if (!Class63.aFile2.exists()) {
                    throw new RuntimeException("");
                }

                Class63.aBool25 = true;
                WorldMapData_Sub1.method604();
                Class64.aCacheFile2 = new CacheFile(new FileOnDisk(Class81.method473("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
                Class64.aCacheFile3 = new CacheFile(new FileOnDisk(Class81.method473("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
                Class64.aCacheFileArray1 = new CacheFile[Class64.anInt167];

                for (int int_2 = 0; int_2 < Class64.anInt167; int_2++) {
                    Class64.aCacheFileArray1[int_2] = new CacheFile(new FileOnDisk(Class81.method473("main_file_cache.idx" + int_2), "rw", 1048576L), 6000, 0);
                }
            } catch (Exception exception_0) {
                Class13.method168((String) null, exception_0);
            }

            AClass3.clientInstance = this;
            this.initialize(765, 503, 157);
        }
    }

    public static void method1109() {
        ItemDefinition.items.reset();
        ItemDefinition.itemModelCache.reset();
        ItemDefinition.itemSpriteCache.reset();
    }

    static boolean method1110(int int_0, int int_1) {
        ObjectDefinition objectcomposition_0 = ObjectDefinition.getDefinition(int_0);
        if (int_1 == 11) {
            int_1 = 10;
        }

        if (int_1 >= 5 && int_1 <= 8) {
            int_1 = 4;
        }

        return objectcomposition_0.method824(int_1);
    }

    static void method1111(byte[] bytes_0, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, CollisionData[] collisiondatas_0) {
        int int_8;
        for (int int_7 = 0; int_7 < 8; int_7++) {
            for (int_8 = 0; int_8 < 8; int_8++) {
                if (int_7 + int_1 > 0 && int_7 + int_1 < 103 && int_2 + int_8 > 0 && int_2 + int_8 < 103) {
                    collisiondatas_0[int_0].flags[int_7 + int_1][int_2 + int_8] &= 0xFEFFFFFF;
                }
            }
        }

        Buffer buffer_0 = new Buffer(bytes_0);

        for (int_8 = 0; int_8 < 4; int_8++) {
            for (int int_9 = 0; int_9 < 64; int_9++) {
                for (int int_10 = 0; int_10 < 64; int_10++) {
                    if (int_8 == int_3 && int_9 >= int_4 && int_9 < int_4 + 8 && int_10 >= int_5 && int_10 < int_5 + 8) {
                        int int_11 = int_1 + WidgetNode.method685(int_9 & 0x7, int_10 & 0x7, int_6);
                        int int_12 = int_9 & 0x7;
                        int int_13 = int_10 & 0x7;
                        int int_14 = int_6 & 0x3;
                        int int_15;
                        if (int_14 == 0) {
                            int_15 = int_13;
                        } else if (int_14 == 1) {
                            int_15 = 7 - int_12;
                        } else if (int_14 == 2) {
                            int_15 = 7 - int_13;
                        } else {
                            int_15 = int_12;
                        }

                        CombatInfoListHolder.loadTerrain(buffer_0, int_0, int_11, int_2 + int_15, 0, 0, int_6);
                    } else {
                        CombatInfoListHolder.loadTerrain(buffer_0, 0, -1, -1, 0, 0, 0);
                    }
                }
            }
        }

    }

    static boolean isFriended(String string_0, boolean bool_0) {
        if (string_0 == null) {
            return false;
        } else {
            String string_1 = PacketBuffer.method908(string_0, Class24.aClass109_1);

            for (int int_0 = 0; int_0 < friendCount; int_0++) {
                if (string_1.equalsIgnoreCase(PacketBuffer.method908(friends[int_0].name, Class24.aClass109_1)) && (!bool_0 || friends[int_0].world != 0)) {
                    return true;
                }
            }

            if (string_1.equalsIgnoreCase(PacketBuffer.method908(Class4.localPlayer.name, Class24.aClass109_1))) {
                return true;
            } else {
                return false;
            }
        }
    }

}
