import java.io.EOFException;
import java.io.File;
import java.io.IOException;

public class Varcs {

   public static int anInt507;
   static IndexData interfacesIndex;
   static int anInt209;
   boolean changed;
   String[] varcstrings;
   int[] varcs;
   long lastSerialize;
   boolean[] varcSerials;
   boolean[] varcstringSerials;

   Varcs() {
      this.changed = false;
      this.varcs = new int[GrandExchangeOffer.configsIndex.fileCount(19)];
      this.varcstrings = new String[GrandExchangeOffer.configsIndex.fileCount(15)];
      this.varcSerials = new boolean[this.varcs.length];

      int int_0;
      for (int_0 = 0; int_0 < this.varcs.length; int_0++) {
         CacheableNode_Sub2 cacheablenode_sub2_0 = Class9.method148(int_0);
         this.varcSerials[int_0] = cacheablenode_sub2_0.aBool63;
      }

      this.varcstringSerials = new boolean[this.varcstrings.length];

      for (int_0 = 0; int_0 < this.varcstrings.length; int_0++) {
         CacheableNode_Sub4 cacheablenode_sub4_0 = Class57.method387(int_0);
         this.varcstringSerials[int_0] = cacheablenode_sub4_0.aBool64;
      }

      for (int_0 = 0; int_0 < this.varcs.length; int_0++) {
         this.varcs[int_0] = -1;
      }

      this.deserialize();
   }

   public static FileOnDisk getPreferencesFile(String string_0, String string_1, boolean bool_0) {
      File file_0 = new File(Class50.aFile1, "preferences" + string_0 + ".dat");
      if (file_0.exists()) {
         try {
            FileOnDisk fileondisk_1 = new FileOnDisk(file_0, "rw", 10000L);
            return fileondisk_1;
         } catch (IOException ioexception_1) {
            ;
         }
      }

      String string_2 = "";
      if (anInt507 == 33) {
         string_2 = "_rc";
      } else if (anInt507 == 34) {
         string_2 = "_wip";
      }

      File file_1 = new File(Class51.userHome, "jagex_" + string_1 + "_preferences" + string_0 + string_2 + ".dat");
      FileOnDisk fileondisk_0;
      if (!bool_0 && file_1.exists()) {
         try {
            fileondisk_0 = new FileOnDisk(file_1, "rw", 10000L);
            return fileondisk_0;
         } catch (IOException ioexception_2) {
            ;
         }
      }

      try {
         fileondisk_0 = new FileOnDisk(file_0, "rw", 10000L);
         return fileondisk_0;
      } catch (IOException ioexception_0) {
         throw new RuntimeException();
      }
   }

   FileOnDisk getVarPrefs(boolean bool_0) {
      return getPreferencesFile("2", Class14.anGameType_1.name, bool_0);
   }

   boolean changed() {
      return this.changed;
   }

   void serialize() {
      FileOnDisk fileondisk_0 = this.getVarPrefs(true);

      try {
         int int_0 = 3;
         int int_1 = 0;

         int int_2;
         for (int_2 = 0; int_2 < this.varcs.length; int_2++) {
            if (this.varcSerials[int_2] && this.varcs[int_2] != -1) {
               int_0 += 6;
               ++int_1;
            }
         }

         int_0 += 2;
         int_2 = 0;

         for (int int_3 = 0; int_3 < this.varcstrings.length; int_3++) {
            if (this.varcstringSerials[int_3] && this.varcstrings[int_3] != null) {
               int_0 += 2 + Projectile.getLength(this.varcstrings[int_3]);
               ++int_2;
            }
         }

         Buffer buffer_0 = new Buffer(int_0);
         buffer_0.putByte(1);
         buffer_0.putShort(int_1);

         int int_4;
         for (int_4 = 0; int_4 < this.varcs.length; int_4++) {
            if (this.varcSerials[int_4] && this.varcs[int_4] != -1) {
               buffer_0.putShort(int_4);
               buffer_0.putInt(this.varcs[int_4]);
            }
         }

         buffer_0.putShort(int_2);

         for (int_4 = 0; int_4 < this.varcstrings.length; int_4++) {
            if (this.varcstringSerials[int_4] && this.varcstrings[int_4] != null) {
               buffer_0.putShort(int_4);
               buffer_0.putString(this.varcstrings[int_4]);
            }
         }

         fileondisk_0.write(buffer_0.buffer, 0, buffer_0.position);
      } catch (Exception exception_0) {
         ;
      } finally {
         try {
            fileondisk_0.close();
         } catch (Exception exception_1) {
            ;
         }

      }

      this.changed = false;
      this.lastSerialize = Class97.currentTimeMs();
   }

   void deserialize() {
      FileOnDisk fileondisk_0 = this.getVarPrefs(false);

      label186: {
         try {
            byte[] bytes_0 = new byte[(int)fileondisk_0.length()];

            int int_1;
            for (int int_0 = 0; int_0 < bytes_0.length; int_0 += int_1) {
               int_1 = fileondisk_0.read(bytes_0, int_0, bytes_0.length - int_0);
               if (int_1 == -1) {
                  throw new EOFException();
               }
            }

            Buffer buffer_0 = new Buffer(bytes_0);
            if (buffer_0.buffer.length - buffer_0.position >= 1) {
               int int_2 = buffer_0.getUnsignedByte();
               if (int_2 < 0 || int_2 > 1) {
                  return;
               }

               int int_3 = buffer_0.getUnsignedShort();

               int int_4;
               int int_5;
               int int_6;
               for (int_4 = 0; int_4 < int_3; int_4++) {
                  int_5 = buffer_0.getUnsignedShort();
                  int_6 = buffer_0.readInt();
                  if (this.varcSerials[int_5]) {
                     this.varcs[int_5] = int_6;
                  }
               }

               int_4 = buffer_0.getUnsignedShort();
               int_5 = 0;

               while (true) {
                  if (int_5 >= int_4) {
                     break label186;
                  }

                  int_6 = buffer_0.getUnsignedShort();
                  String string_0 = buffer_0.readString();
                  if (this.varcstringSerials[int_6]) {
                     this.varcstrings[int_6] = string_0;
                  }

                  ++int_5;
               }
            }
         } catch (Exception exception_0) {
            break label186;
         } finally {
            try {
               fileondisk_0.close();
            } catch (Exception exception_1) {
               ;
            }

         }

         return;
      }

      this.changed = false;
   }

   String getVarcString(int int_0) {
      return this.varcstrings[int_0];
   }

   int getVarc(int int_0) {
      return this.varcs[int_0];
   }

   void putVarc(int int_0, int int_1) {
      this.varcs[int_0] = int_1;
      if (this.varcSerials[int_0]) {
         this.changed = true;
      }

   }

   void putVarcString(int int_0, String string_0) {
      this.varcstrings[int_0] = string_0;
      if (this.varcstringSerials[int_0]) {
         this.changed = true;
      }

   }

   void reset() {
      int int_0;
      for (int_0 = 0; int_0 < this.varcs.length; int_0++) {
         if (!this.varcSerials[int_0]) {
            this.varcs[int_0] = -1;
         }
      }

      for (int_0 = 0; int_0 < this.varcstrings.length; int_0++) {
         if (!this.varcstringSerials[int_0]) {
            this.varcstrings[int_0] = null;
         }
      }

   }

   void process() {
      if (this.changed && this.lastSerialize < Class97.currentTimeMs() - 60000L) {
         this.serialize();
      }

   }

   static void method543() {
      if (!Class54.aBool22) {
         int int_0 = SceneGraph.pitchSin;
         int int_1 = SceneGraph.pitchCos;
         int int_2 = SceneGraph.yawSin;
         int int_3 = SceneGraph.yawCos;
         byte byte_0 = 50;
         short short_0 = 3500;
         int int_4 = (Class54.anInt138 - Rasterizer3D.centerX) * byte_0 / Rasterizer3D.anInt543;
         int int_5 = (Class54.anInt139 - Rasterizer3D.centerY) * byte_0 / Rasterizer3D.anInt543;
         int int_6 = (Class54.anInt138 - Rasterizer3D.centerX) * short_0 / Rasterizer3D.anInt543;
         int int_7 = (Class54.anInt139 - Rasterizer3D.centerY) * short_0 / Rasterizer3D.anInt543;
         int int_8 = Rasterizer3D.method964(int_5, byte_0, int_1, int_0);
         int int_9 = Rasterizer3D.method966(int_5, byte_0, int_1, int_0);
         int_5 = int_8;
         int_8 = Rasterizer3D.method964(int_7, short_0, int_1, int_0);
         int int_10 = Rasterizer3D.method966(int_7, short_0, int_1, int_0);
         int_7 = int_8;
         int_8 = Rasterizer3D.method968(int_4, int_9, int_3, int_2);
         int_9 = Rasterizer3D.method969(int_4, int_9, int_3, int_2);
         int_4 = int_8;
         int_8 = Rasterizer3D.method968(int_6, int_10, int_3, int_2);
         int_10 = Rasterizer3D.method969(int_6, int_10, int_3, int_2);
         Class54.anInt141 = (int_8 + int_4) / 2;
         Class54.anInt142 = (int_7 + int_5) / 2;
         Class12.anInt56 = (int_10 + int_9) / 2;
         Class54.anInt145 = (int_8 - int_4) / 2;
         CacheableNode_Sub5.anInt473 = (int_7 - int_5) / 2;
         Class54.anInt144 = (int_10 - int_9) / 2;
         anInt209 = Math.abs(Class54.anInt145);
         Class54.anInt143 = Math.abs(CacheableNode_Sub5.anInt473);
         GameType.anInt385 = Math.abs(Class54.anInt144);
      }
   }

   static void method544() {
      PacketNode packetnode_0 = Actor.method953(ClientPacket.aClientPacket86, Client.aClass46_1.cipher);
      packetnode_0.packetBuffer.putByte(0);
      Client.aClass46_1.method282(packetnode_0);
   }

}
