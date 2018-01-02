import java.util.Iterator;
import java.util.LinkedList;

public class WorldMapData {

   String aString8;
   int anInt105;
   boolean aBool19;
   int fileId;
   String aString9;
   int anInt106;
   Coordinates aCoordinates8;
   LinkedList aLinkedList2;
   int anInt107;
   int anInt108;
   int anInt109;
   int anInt110;

   public WorldMapData() {
      this.fileId = -1;
      this.anInt105 = -1;
      this.anInt106 = -1;
      this.aCoordinates8 = null;
      this.anInt109 = Integer.MAX_VALUE;
      this.anInt107 = 0;
      this.anInt110 = Integer.MAX_VALUE;
      this.anInt108 = 0;
      this.aBool19 = false;
   }

   public void loadMapData(Buffer buffer_0, int int_0) {
      this.fileId = int_0;
      this.aString9 = buffer_0.readString();
      this.aString8 = buffer_0.readString();
      this.aCoordinates8 = new Coordinates(buffer_0.readInt());
      this.anInt105 = buffer_0.readInt();
      buffer_0.getUnsignedByte();
      this.aBool19 = buffer_0.getUnsignedByte() == 1;
      this.anInt106 = buffer_0.getUnsignedByte();
      int int_1 = buffer_0.getUnsignedByte();
      this.aLinkedList2 = new LinkedList();

      for (int int_2 = 0; int_2 < int_1; int_2++) {
         this.aLinkedList2.add(this.method298(buffer_0));
      }

      this.method297();
   }

   public String method285() {
      return this.aString9;
   }

   public boolean method286(int int_0, int int_1) {
      int int_2 = int_0 / 64;
      int int_3 = int_1 / 64;
      if (int_2 >= this.anInt109 && int_2 <= this.anInt107) {
         if (int_3 >= this.anInt110 && int_3 <= this.anInt108) {
            Iterator iterator_0 = this.aLinkedList2.iterator();

            WorldMapSectionBase worldmapsectionbase_0;
            do {
               if (!iterator_0.hasNext()) {
                  return false;
               }

               worldmapsectionbase_0 = (WorldMapSectionBase) iterator_0.next();
            } while (!worldmapsectionbase_0.method5(int_0, int_1));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public int[] method287(int int_0, int int_1, int int_2) {
      Iterator iterator_0 = this.aLinkedList2.iterator();

      WorldMapSectionBase worldmapsectionbase_0;
      do {
         if (!iterator_0.hasNext()) {
            return null;
         }

         worldmapsectionbase_0 = (WorldMapSectionBase) iterator_0.next();
      } while (!worldmapsectionbase_0.method6(int_0, int_1, int_2));

      return worldmapsectionbase_0.method9(int_0, int_1, int_2);
   }

   public int method288() {
      return this.fileId;
   }

   public int method289() {
      return this.anInt109;
   }

   public int method290() {
      return this.anInt110;
   }

   public boolean method291(int int_0, int int_1, int int_2) {
      Iterator iterator_0 = this.aLinkedList2.iterator();

      WorldMapSectionBase worldmapsectionbase_0;
      do {
         if (!iterator_0.hasNext()) {
            return false;
         }

         worldmapsectionbase_0 = (WorldMapSectionBase) iterator_0.next();
      } while (!worldmapsectionbase_0.method6(int_0, int_1, int_2));

      return true;
   }

   public Coordinates method292(int int_0, int int_1) {
      Iterator iterator_0 = this.aLinkedList2.iterator();

      WorldMapSectionBase worldmapsectionbase_0;
      do {
         if (!iterator_0.hasNext()) {
            return null;
         }

         worldmapsectionbase_0 = (WorldMapSectionBase) iterator_0.next();
      } while (!worldmapsectionbase_0.method5(int_0, int_1));

      return worldmapsectionbase_0.method8(int_0, int_1);
   }

   public int method293() {
      return this.aCoordinates8.plane;
   }

   public int method294() {
      return this.aCoordinates8.worldX;
   }

   public int method295() {
      return this.aCoordinates8.worldY;
   }

   public int method296() {
      return this.anInt106;
   }

   void method297() {
      Iterator iterator_0 = this.aLinkedList2.iterator();

      while (iterator_0.hasNext()) {
         WorldMapSectionBase worldmapsectionbase_0 = (WorldMapSectionBase) iterator_0.next();
         worldmapsectionbase_0.method7(this);
      }

   }

   WorldMapSectionBase method298(Buffer buffer_0) {
      int int_0 = buffer_0.getUnsignedByte();
      Enum1[] enum1s_0 = new Enum1[] {Enum1.anEnum1_1, Enum1.anEnum1_4, Enum1.anEnum1_3, Enum1.anEnum1_2};
      Enum1 enum1_0 = (Enum1) Class1.forOrdinal(enum1s_0, int_0);
      Object object_0 = null;
      switch(enum1_0.anInt304) {
      case 0:
         object_0 = new Class4();
         break;
      case 1:
         object_0 = new WorldMapType2();
         break;
      case 2:
         object_0 = new WorldMapType3();
         break;
      case 3:
         object_0 = new WorldMapType1();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase) object_0).method10(buffer_0);
      return (WorldMapSectionBase) object_0;
   }

   public boolean method299() {
      return this.aBool19;
   }

   public int method300() {
      return this.anInt107;
   }

   public int method301() {
      return this.anInt108;
   }

   int method302() {
      return this.anInt105;
   }

   public String method303() {
      return this.aString8;
   }

   public Coordinates method304() {
      return new Coordinates(this.aCoordinates8);
   }

   static void method305(Widget widget) {
      if (widget.loopCycle == Client.anInt611) {
         Client.aBoolArray8[widget.boundsIndex] = true;
      }
   }

   static void characterToScreen(Actor actor_0, int int_0) {
      Class35.method245(actor_0.x, actor_0.y, int_0);
   }

   static void isOnTutorialIsland() {
      Client.onTutorialIsland = 0;
      int tileX = (Class4.localPlayer.x >> 7) + Client.regionBaseX;
      int tileY = (Class4.localPlayer.y >> 7) + Client.regionBaseY;
      if (tileX >= 3053 && tileX <= 3156 && tileY >= 3056 && tileY <= 3136) {
         Client.onTutorialIsland = 1;
      }

      if (tileX >= 3072 && tileX <= 3118 && tileY >= 9492 && tileY <= 9535) {
         Client.onTutorialIsland = 1;
      }

      if (Client.onTutorialIsland == 1 && tileX >= 3139 && tileX <= 3199 && tileY >= 3008 && tileY <= 3062) {
         Client.onTutorialIsland = 0;
      }

   }

}
