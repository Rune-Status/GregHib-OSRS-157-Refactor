import java.util.zip.CRC32;

public class IndexData extends IndexDataBase {

   static CRC32 crc32;
   IndexFile anIndexFile1;
   IndexFile anIndexFile2;
   int crcValue;
   volatile boolean aBool47;
   int index;
   volatile boolean[] aBoolArray5;
   int anInt305;
   int anInt306;
   boolean aBool48;

   static {
      crc32 = new CRC32();
   }

   public IndexData(IndexFile indexfile_0, IndexFile indexfile_1, int int_0, boolean bool_0, boolean bool_1, boolean bool_2) {
      super(bool_0, bool_1);
      this.aBool47 = false;
      this.aBool48 = false;
      this.anInt306 = -1;
      this.anIndexFile2 = indexfile_0;
      this.anIndexFile1 = indexfile_1;
      this.index = int_0;
      this.aBool48 = bool_2;
      Enum1.method610(this, this.index);
   }

   void method425(int int_0) {
      if (this.anIndexFile2 != null && this.aBoolArray5 != null && this.aBoolArray5[int_0]) {
         Class74.method445(int_0, this.anIndexFile2, this);
      } else {
         ClanMember.method676(this, this.index, int_0, super.archiveCrcs[int_0], (byte) 2, true);
      }

   }

   int method428(int int_0) {
      return super.anObjectArray1[int_0] != null ? 100 : (this.aBoolArray5[int_0] ? 100 : Class53.method349(this.index, int_0));
   }

   void method613() {
      this.aBoolArray5 = new boolean[super.anObjectArray1.length];

      int int_0;
      for (int_0 = 0; int_0 < this.aBoolArray5.length; int_0++) {
         this.aBoolArray5[int_0] = false;
      }

      if (this.anIndexFile2 == null) {
         this.aBool47 = true;
      } else {
         this.anInt306 = -1;

         for (int_0 = 0; int_0 < this.aBoolArray5.length; int_0++) {
            if (super.archiveNumberOfFiles[int_0] > 0) {
               Enum4.method699(int_0, this.anIndexFile2, this);
               this.anInt306 = int_0;
            }
         }

         if (this.anInt306 == -1) {
            this.aBool47 = true;
         }

      }
   }

   void method430(int int_0) {
      int int_1 = this.index;
      long long_0 = (long)((int_1 << 16) + int_0);
      FileRequest filerequest_0 = (FileRequest) Class95.aHashTable3.get(long_0);
      if (filerequest_0 != null) {
         Class95.aNode2LinkedList1.setHead(filerequest_0);
      }

   }

   public void method614(IndexFile indexfile_0, int int_0, byte[] bytes_0, boolean bool_0) {
      int int_1;
      if (indexfile_0 == this.anIndexFile1) {
         if (this.aBool47) {
            throw new RuntimeException();
         }

         if (bytes_0 == null) {
            ClanMember.method676(this, 255, this.index, this.crcValue, (byte) 0, true);
            return;
         }

         crc32.reset();
         crc32.update(bytes_0, 0, bytes_0.length);
         int_1 = (int)crc32.getValue();
         Buffer buffer_0 = new Buffer(DynamicObject.decodeContainer(bytes_0));
         int int_3 = buffer_0.readUnsignedByte();
         if (int_3 != 5 && int_3 != 6) {
            throw new RuntimeException(int_3 + "," + this.index + "," + int_0);
         }

         int int_4 = 0;
         if (int_3 >= 6) {
            int_4 = buffer_0.readInt();
         }

         if (int_1 != this.crcValue || int_4 != this.anInt305) {
            ClanMember.method676(this, 255, this.index, this.crcValue, (byte) 0, true);
            return;
         }

         this.method427(bytes_0);
         this.method613();
      } else {
         if (!bool_0 && int_0 == this.anInt306) {
            this.aBool47 = true;
         }

         if (bytes_0 == null || bytes_0.length <= 2) {
            this.aBoolArray5[int_0] = false;
            if (this.aBool48 || bool_0) {
               ClanMember.method676(this, this.index, int_0, super.archiveCrcs[int_0], (byte) 2, bool_0);
            }

            return;
         }

         crc32.reset();
         crc32.update(bytes_0, 0, bytes_0.length - 2);
         int_1 = (int)crc32.getValue();
         int int_2 = ((bytes_0[bytes_0.length - 2] & 0xFF) << 8) + (bytes_0[bytes_0.length - 1] & 0xFF);
         if (int_1 != super.archiveCrcs[int_0] || int_2 != super.archiveRevisions[int_0]) {
            this.aBoolArray5[int_0] = false;
            if (this.aBool48 || bool_0) {
               ClanMember.method676(this, this.index, int_0, super.archiveCrcs[int_0], (byte) 2, bool_0);
            }

            return;
         }

         this.aBoolArray5[int_0] = true;
         if (bool_0) {
            super.anObjectArray1[int_0] = Class71.method422(bytes_0, false);
         }
      }

   }

   void setInformation(int int_0, int int_1) {
      this.crcValue = int_0;
      this.anInt305 = int_1;
      if (this.anIndexFile1 != null) {
         Class74.method445(this.index, this.anIndexFile1, this);
      } else {
         ClanMember.method676(this, 255, this.index, this.crcValue, (byte) 0, true);
      }

   }

   public int percentage() {
      if (this.aBool47) {
         return 100;
      } else if (super.anObjectArray1 != null) {
         return 99;
      } else {
         int int_0 = Class53.method349(255, this.index);
         if (int_0 >= 100) {
            int_0 = 99;
         }

         return int_0;
      }
   }

   public int method615() {
      int int_0 = 0;
      int int_1 = 0;

      int int_2;
      for (int_2 = 0; int_2 < super.anObjectArray1.length; int_2++) {
         if (super.archiveNumberOfFiles[int_2] > 0) {
            int_0 += 100;
            int_1 += this.method428(int_2);
         }
      }

      if (int_0 == 0) {
         return 100;
      } else {
         int_2 = int_1 * 100 / int_0;
         return int_2;
      }
   }

   void method616(int int_0, byte[] bytes_0, boolean bool_0, boolean bool_1) {
      if (bool_0) {
         if (this.aBool47) {
            throw new RuntimeException();
         }

         if (this.anIndexFile1 != null) {
            Class10.method153(this.index, bytes_0, this.anIndexFile1);
         }

         this.method427(bytes_0);
         this.method613();
      } else {
         bytes_0[bytes_0.length - 2] = (byte)(super.archiveRevisions[int_0] >> 8);
         bytes_0[bytes_0.length - 1] = (byte)super.archiveRevisions[int_0];
         if (this.anIndexFile2 != null) {
            Class10.method153(int_0, bytes_0, this.anIndexFile2);
            this.aBoolArray5[int_0] = true;
         }

         if (bool_1) {
            super.anObjectArray1[int_0] = Class71.method422(bytes_0, false);
         }
      }

   }

}
