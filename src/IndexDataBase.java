public abstract class IndexDataBase {

   static GZipDecompressor gzip;
   static int anInt170;
   int[][] archiveFileIds;
   int[] archiveIds;
   Object[] anObjectArray1;
   Object[][] childs;
   boolean aBool27;
   Identifiers[] childIdentifiers;
   Identifiers identifiers;
   public int crc;
   int[] archiveRevisions;
   int[] archiveNumberOfFiles;
   boolean aBool28;
   int[] archiveCrcs;
   int validArchivesCount;
   int[] archiveNames;
   int[][] archiveFileNames;

   static {
      gzip = new GZipDecompressor();
      anInt170 = 0;
   }

   IndexDataBase(boolean bool_0, boolean bool_1) {
      this.aBool27 = bool_0;
      this.aBool28 = bool_1;
   }

   public byte[] getConfigData(int archive, int file, int[] keys) {
      if (archive >= 0 && archive < this.childs.length && this.childs[archive] != null && file >= 0 && file < this.childs[archive].length) {
         if (this.childs[archive][file] == null) {
            boolean bool_0 = this.method435(archive, keys);
            if (!bool_0) {
               this.method425(archive);
               bool_0 = this.method435(archive, keys);
               if (!bool_0) {
                  return null;
               }
            }
         }

         byte[] bytes_0 = Class56.toByteArray(this.childs[archive][file], false);
         if (this.aBool28) {
            this.childs[archive][file] = null;
         }

         return bytes_0;
      } else {
         return null;
      }
   }

   public int size() {
      return this.childs.length;
   }

   public byte[] getChild(int int_0, int int_1) {
      if (int_0 >= 0 && int_0 < this.childs.length && this.childs[int_0] != null && int_1 >= 0 && int_1 < this.childs[int_0].length) {
         if (this.childs[int_0][int_1] == null) {
            boolean bool_0 = this.method435(int_0, (int[]) null);
            if (!bool_0) {
               this.method425(int_0);
               bool_0 = this.method435(int_0, (int[]) null);
               if (!bool_0) {
                  return null;
               }
            }
         }

         byte[] bytes_0 = Class56.toByteArray(this.childs[int_0][int_1], false);
         return bytes_0;
      } else {
         return null;
      }
   }

   public byte[] getConfigData(int archiveId, int fileId) {
      return this.getConfigData(archiveId, fileId, (int[]) null);
   }

   void method425(int int_0) {
   }

   public byte[] method426(int int_0) {
      if (this.childs.length == 1) {
         return this.getChild(0, int_0);
      } else if (this.childs[int_0].length == 1) {
         return this.getChild(int_0, 0);
      } else {
         throw new RuntimeException();
      }
   }

   public int fileCount(int int_0) {
      return this.childs[int_0].length;
   }

   void method427(byte[] bytes_0) {
      int int_0 = bytes_0.length;
      int int_1 = -1;

      int int_2;
      for (int_2 = 0; int_2 < int_0; int_2++) {
         int_1 = int_1 >>> 8 ^ Buffer.crc32Table[(int_1 ^ bytes_0[int_2]) & 0xFF];
      }

      int_1 = ~int_1;
      this.crc = int_1;
      Buffer buffer_0 = new Buffer(DynamicObject.decodeContainer(bytes_0));
      int_1 = buffer_0.getUnsignedByte();
      if (int_1 >= 5 && int_1 <= 7) {
         if (int_1 >= 6) {
            buffer_0.readInt();
         }

         int_2 = buffer_0.getUnsignedByte();
         if (int_1 >= 7) {
            this.validArchivesCount = buffer_0.getLargeSmart();
         } else {
            this.validArchivesCount = buffer_0.getUnsignedShort();
         }

         int int_3 = 0;
         int int_4 = -1;
         this.archiveIds = new int[this.validArchivesCount];
         int int_5;
         if (int_1 >= 7) {
            for (int_5 = 0; int_5 < this.validArchivesCount; int_5++) {
               this.archiveIds[int_5] = int_3 += buffer_0.getLargeSmart();
               if (this.archiveIds[int_5] > int_4) {
                  int_4 = this.archiveIds[int_5];
               }
            }
         } else {
            for (int_5 = 0; int_5 < this.validArchivesCount; int_5++) {
               this.archiveIds[int_5] = int_3 += buffer_0.getUnsignedShort();
               if (this.archiveIds[int_5] > int_4) {
                  int_4 = this.archiveIds[int_5];
               }
            }
         }

         this.archiveCrcs = new int[int_4 + 1];
         this.archiveRevisions = new int[int_4 + 1];
         this.archiveNumberOfFiles = new int[int_4 + 1];
         this.archiveFileIds = new int[int_4 + 1][];
         this.anObjectArray1 = new Object[int_4 + 1];
         this.childs = new Object[int_4 + 1][];
         if (int_2 != 0) {
            this.archiveNames = new int[int_4 + 1];

            for (int_5 = 0; int_5 < this.validArchivesCount; int_5++) {
               this.archiveNames[this.archiveIds[int_5]] = buffer_0.readInt();
            }

            this.identifiers = new Identifiers(this.archiveNames);
         }

         for (int_5 = 0; int_5 < this.validArchivesCount; int_5++) {
            this.archiveCrcs[this.archiveIds[int_5]] = buffer_0.readInt();
         }

         for (int_5 = 0; int_5 < this.validArchivesCount; int_5++) {
            this.archiveRevisions[this.archiveIds[int_5]] = buffer_0.readInt();
         }

         for (int_5 = 0; int_5 < this.validArchivesCount; int_5++) {
            this.archiveNumberOfFiles[this.archiveIds[int_5]] = buffer_0.getUnsignedShort();
         }

         int int_6;
         int int_7;
         int int_8;
         int int_9;
         int int_10;
         if (int_1 >= 7) {
            for (int_5 = 0; int_5 < this.validArchivesCount; int_5++) {
               int_6 = this.archiveIds[int_5];
               int_7 = this.archiveNumberOfFiles[int_6];
               int_3 = 0;
               int_8 = -1;
               this.archiveFileIds[int_6] = new int[int_7];

               for (int_9 = 0; int_9 < int_7; int_9++) {
                  int_10 = this.archiveFileIds[int_6][int_9] = int_3 += buffer_0.getLargeSmart();
                  if (int_10 > int_8) {
                     int_8 = int_10;
                  }
               }

               this.childs[int_6] = new Object[int_8 + 1];
            }
         } else {
            for (int_5 = 0; int_5 < this.validArchivesCount; int_5++) {
               int_6 = this.archiveIds[int_5];
               int_7 = this.archiveNumberOfFiles[int_6];
               int_3 = 0;
               int_8 = -1;
               this.archiveFileIds[int_6] = new int[int_7];

               for (int_9 = 0; int_9 < int_7; int_9++) {
                  int_10 = this.archiveFileIds[int_6][int_9] = int_3 += buffer_0.getUnsignedShort();
                  if (int_10 > int_8) {
                     int_8 = int_10;
                  }
               }

               this.childs[int_6] = new Object[int_8 + 1];
            }
         }

         if (int_2 != 0) {
            this.archiveFileNames = new int[int_4 + 1][];
            this.childIdentifiers = new Identifiers[int_4 + 1];

            for (int_5 = 0; int_5 < this.validArchivesCount; int_5++) {
               int_6 = this.archiveIds[int_5];
               int_7 = this.archiveNumberOfFiles[int_6];
               this.archiveFileNames[int_6] = new int[this.childs[int_6].length];

               for (int_8 = 0; int_8 < int_7; int_8++) {
                  this.archiveFileNames[int_6][this.archiveFileIds[int_6][int_8]] = buffer_0.readInt();
               }

               this.childIdentifiers[int_6] = new Identifiers(this.archiveFileNames[int_6]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   int method428(int int_0) {
      return this.anObjectArray1[int_0] != null ? 100 : 0;
   }

   public boolean method429(String string_0, String string_1) {
      string_0 = string_0.toLowerCase();
      string_1 = string_1.toLowerCase();
      int int_0 = this.identifiers.getFile(CacheableNode_Sub5.djb2Hash(string_0));
      int int_1 = this.childIdentifiers[int_0].getFile(CacheableNode_Sub5.djb2Hash(string_1));
      return this.modelExists(int_0, int_1);
   }

   void method430(int int_0) {
   }

   public boolean containsFile(int int_0) {
      if (this.anObjectArray1[int_0] != null) {
         return true;
      } else {
         this.method425(int_0);
         return this.anObjectArray1[int_0] != null;
      }
   }

   public boolean modelExists(int archive, int file) {
      if (archive >= 0 && archive < this.childs.length && this.childs[archive] != null && file >= 0 && file < this.childs[archive].length) {
         if (this.childs[archive][file] != null) {
            return true;
         } else if (this.anObjectArray1[archive] != null) {
            return true;
         } else {
            this.method425(archive);
            return this.anObjectArray1[archive] != null;
         }
      } else {
         return false;
      }
   }

   public byte[] method432(int int_0) {
      if (this.childs.length == 1) {
         return this.getConfigData(0, int_0);
      } else if (this.childs[int_0].length == 1) {
         return this.getConfigData(int_0, 0);
      } else {
         throw new RuntimeException();
      }
   }

   public int[] getChilds(int int_0) {
      return this.archiveFileIds[int_0];
   }

   public int getFile(String string_0) {
      string_0 = string_0.toLowerCase();
      return this.identifiers.getFile(CacheableNode_Sub5.djb2Hash(string_0));
   }

   public boolean method433(String string_0, String string_1) {
      string_0 = string_0.toLowerCase();
      string_1 = string_1.toLowerCase();
      int int_0 = this.identifiers.getFile(CacheableNode_Sub5.djb2Hash(string_0));
      if (int_0 < 0) {
         return false;
      } else {
         int int_1 = this.childIdentifiers[int_0].getFile(CacheableNode_Sub5.djb2Hash(string_1));
         return int_1 >= 0;
      }
   }

   public int getChild(int int_0, String string_0) {
      string_0 = string_0.toLowerCase();
      return this.childIdentifiers[int_0].getFile(CacheableNode_Sub5.djb2Hash(string_0));
   }

   public int method434(String string_0) {
      string_0 = string_0.toLowerCase();
      int int_0 = this.identifiers.getFile(CacheableNode_Sub5.djb2Hash(string_0));
      return this.method428(int_0);
   }

   boolean method435(int int_0, int[] ints_0) {
      if (this.anObjectArray1[int_0] == null) {
         return false;
      } else {
         int int_1 = this.archiveNumberOfFiles[int_0];
         int[] ints_1 = this.archiveFileIds[int_0];
         Object[] objects_0 = this.childs[int_0];
         boolean bool_0 = true;

         for (int int_2 = 0; int_2 < int_1; int_2++) {
            if (objects_0[ints_1[int_2]] == null) {
               bool_0 = false;
               break;
            }
         }

         if (bool_0) {
            return true;
         } else {
            byte[] bytes_0;
            if (ints_0 == null || ints_0[0] == 0 && ints_0[1] == 0 && ints_0[2] == 0 && ints_0[3] == 0) {
               bytes_0 = Class56.toByteArray(this.anObjectArray1[int_0], false);
            } else {
               bytes_0 = Class56.toByteArray(this.anObjectArray1[int_0], true);
               Buffer buffer_0 = new Buffer(bytes_0);
               buffer_0.decryptXtea(ints_0, 5, buffer_0.buffer.length);
            }

            byte[] bytes_2 = DynamicObject.decodeContainer(bytes_0);
            if (this.aBool27) {
               this.anObjectArray1[int_0] = null;
            }

            if (int_1 > 1) {
               int int_3 = bytes_2.length;
               --int_3;
               int int_4 = bytes_2[int_3] & 0xFF;
               int_3 -= int_4 * int_1 * 4;
               Buffer buffer_1 = new Buffer(bytes_2);
               int[] ints_2 = new int[int_1];
               buffer_1.position = int_3;

               int int_6;
               int int_7;
               for (int int_5 = 0; int_5 < int_4; int_5++) {
                  int_6 = 0;

                  for (int_7 = 0; int_7 < int_1; int_7++) {
                     int_6 += buffer_1.readInt();
                     ints_2[int_7] += int_6;
                  }
               }

               byte[][] bytes_1 = new byte[int_1][];

               for (int_6 = 0; int_6 < int_1; int_6++) {
                  bytes_1[int_6] = new byte[ints_2[int_6]];
                  ints_2[int_6] = 0;
               }

               buffer_1.position = int_3;
               int_6 = 0;

               for (int_7 = 0; int_7 < int_4; int_7++) {
                  int int_8 = 0;

                  for (int int_9 = 0; int_9 < int_1; int_9++) {
                     int_8 += buffer_1.readInt();
                     System.arraycopy(bytes_2, int_6, bytes_1[int_9], ints_2[int_9], int_8);
                     ints_2[int_9] += int_8;
                     int_6 += int_8;
                  }
               }

               for (int_7 = 0; int_7 < int_1; int_7++) {
                  if (!this.aBool28) {
                     objects_0[ints_1[int_7]] = Class71.method422(bytes_1[int_7], false);
                  } else {
                     objects_0[ints_1[int_7]] = bytes_1[int_7];
                  }
               }
            } else if (!this.aBool28) {
               objects_0[ints_1[0]] = Class71.method422(bytes_2, false);
            } else {
               objects_0[ints_1[0]] = bytes_2;
            }

            return true;
         }
      }
   }

   public byte[] method436(String string_0, String string_1) {
      string_0 = string_0.toLowerCase();
      string_1 = string_1.toLowerCase();
      int int_0 = this.identifiers.getFile(CacheableNode_Sub5.djb2Hash(string_0));
      int int_1 = this.childIdentifiers[int_0].getFile(CacheableNode_Sub5.djb2Hash(string_1));
      return this.getConfigData(int_0, int_1);
   }

   public boolean method437() {
      boolean bool_0 = true;

      for (int int_0 = 0; int_0 < this.archiveIds.length; int_0++) {
         int int_1 = this.archiveIds[int_0];
         if (this.anObjectArray1[int_1] == null) {
            this.method425(int_1);
            if (this.anObjectArray1[int_1] == null) {
               bool_0 = false;
            }
         }
      }

      return bool_0;
   }

   public void method438(int int_0) {
      for (int int_1 = 0; int_1 < this.childs[int_0].length; int_1++) {
         this.childs[int_0][int_1] = null;
      }

   }

   public boolean method439(String string_0) {
      string_0 = string_0.toLowerCase();
      int int_0 = this.identifiers.getFile(CacheableNode_Sub5.djb2Hash(string_0));
      return this.containsFile(int_0);
   }

   public void reset() {
      for (int int_0 = 0; int_0 < this.childs.length; int_0++) {
         if (this.childs[int_0] != null) {
            for (int int_1 = 0; int_1 < this.childs[int_0].length; int_1++) {
               this.childs[int_0][int_1] = null;
            }
         }
      }

   }

   public void method440(String string_0) {
      string_0 = string_0.toLowerCase();
      int int_0 = this.identifiers.getFile(CacheableNode_Sub5.djb2Hash(string_0));
      if (int_0 >= 0) {
         this.method430(int_0);
      }
   }

}
