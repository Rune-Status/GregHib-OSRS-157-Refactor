import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Preferences {

   static int anInt169;
   static int[] anIntArray39;
   static IndexedSprite anIndexedSprite5;
   int screenType;
   String aString10;
   boolean hideRoofs;
   boolean aBool26;
   LinkedHashMap preferences;
   boolean muted;

   static {
      anInt169 = 6;
   }

   Preferences() {
      this.screenType = 1;
      this.aString10 = null;
      this.aBool26 = false;
      this.preferences = new LinkedHashMap();
      this.method416(true);
   }

   Preferences(Buffer buffer_0) {
      this.screenType = 1;
      this.aString10 = null;
      this.aBool26 = false;
      this.preferences = new LinkedHashMap();
      if (buffer_0 != null && buffer_0.payload != null) {
         int int_0 = buffer_0.readUnsignedByte();
         if (int_0 >= 0 && int_0 <= anInt169) {
            if (buffer_0.readUnsignedByte() == 1) {
               this.hideRoofs = true;
            }

            if (int_0 > 1) {
               this.muted = buffer_0.readUnsignedByte() == 1;
            }

            if (int_0 > 3) {
               this.screenType = buffer_0.readUnsignedByte();
            }

            if (int_0 > 2) {
               int int_1 = buffer_0.readUnsignedByte();

               for (int int_2 = 0; int_2 < int_1; int_2++) {
                  int int_3 = buffer_0.readInt();
                  int int_4 = buffer_0.readInt();
                  this.preferences.put(Integer.valueOf(int_3), Integer.valueOf(int_4));
               }
            }

            if (int_0 > 4) {
               this.aString10 = buffer_0.getNullString();
            }

            if (int_0 > 5) {
               this.aBool26 = buffer_0.method705();
            }
         } else {
            this.method416(true);
         }
      } else {
         this.method416(true);
      }

   }

   void method416(boolean bool_0) {
   }

   Buffer serialize() {
      Buffer buffer_0 = new Buffer(100);
      buffer_0.putByte(anInt169);
      buffer_0.putByte(this.hideRoofs ? 1 : 0);
      buffer_0.putByte(this.muted ? 1 : 0);
      buffer_0.putByte(this.screenType);
      buffer_0.putByte(this.preferences.size());
      Iterator iterator_0 = this.preferences.entrySet().iterator();

      while (iterator_0.hasNext()) {
         Entry map$entry_0 = (Entry) iterator_0.next();
         buffer_0.putInt(((Integer) map$entry_0.getKey()).intValue());
         buffer_0.putInt(((Integer) map$entry_0.getValue()).intValue());
      }

      buffer_0.putString(this.aString10 != null ? this.aString10 : "");
      buffer_0.method704(this.aBool26);
      return buffer_0;
   }

   static int getWidgetConfig(Widget widget_0) {
      IntegerNode integernode_0 = (IntegerNode) Client.widgetFlags.get((long)widget_0.index + ((long)widget_0.id << 32));
      return integernode_0 != null ? integernode_0.value : widget_0.config;
   }

   static int method417(int int_0, int int_1, int int_2) {
      if (int_2 > 179) {
         int_1 /= 2;
      }

      if (int_2 > 192) {
         int_1 /= 2;
      }

      if (int_2 > 217) {
         int_1 /= 2;
      }

      if (int_2 > 243) {
         int_1 /= 2;
      }

      int int_3 = (int_1 / 32 << 7) + (int_0 / 4 << 10) + int_2 / 2;
      return int_3;
   }

   static void method418(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8) {
      PendingSpawn pendingspawn_0 = null;

      for (PendingSpawn pendingspawn_1 = (PendingSpawn) Client.pendingSpawns.getFront(); pendingspawn_1 != null; pendingspawn_1 = (PendingSpawn) Client.pendingSpawns.getNext()) {
         if (int_0 == pendingspawn_1.level && pendingspawn_1.x == int_1 && int_2 == pendingspawn_1.y && int_3 == pendingspawn_1.type) {
            pendingspawn_0 = pendingspawn_1;
            break;
         }
      }

      if (pendingspawn_0 == null) {
         pendingspawn_0 = new PendingSpawn();
         pendingspawn_0.level = int_0;
         pendingspawn_0.type = int_3;
         pendingspawn_0.anInt347 = int_1;
         pendingspawn_0.y = int_2;
         Coordinates.method516(pendingspawn_0);
         Client.pendingSpawns.addFront(pendingspawn_0);
      }

      pendingspawn_0.id = int_4;
      pendingspawn_0.anInt344 = int_5;
      pendingspawn_0.orientation = int_6;
      pendingspawn_0.delay = int_7;
      pendingspawn_0.hitpoints = int_8;
   }

   public static String method419(long long_0) {
      if (long_0 > 0L && long_0 < 6582952005840035281L) {
         if (long_0 % 37L == 0L) {
            return null;
         } else {
            int int_0 = 0;

            for (long long_1 = long_0; long_1 != 0L; long_1 /= 37L) {
               ++int_0;
            }

            StringBuilder stringbuilder_0;
            char char_0;
            for (stringbuilder_0 = new StringBuilder(int_0); long_0 != 0L; stringbuilder_0.append(char_0)) {
               long long_2 = long_0;
               long_0 /= 37L;
               char_0 = Class105.aCharArray7[(int)(long_2 - long_0 * 37L)];
               if (char_0 == 95) {
                  int int_1 = stringbuilder_0.length() - 1;
                  stringbuilder_0.setCharAt(int_1, Character.toUpperCase(stringbuilder_0.charAt(int_1)));
                  char_0 = 160;
               }
            }

            stringbuilder_0.reverse();
            stringbuilder_0.setCharAt(0, Character.toUpperCase(stringbuilder_0.charAt(0)));
            return stringbuilder_0.toString();
         }
      } else {
         return null;
      }
   }

}
