import java.io.EOFException;
import java.io.IOException;

public final class IndexFile {

   static byte[] aByteArray1;
   CacheFile dataFile;
   CacheFile indexFile;
   int maxSize;
   int index;

   static {
      aByteArray1 = new byte[520];
   }

   public IndexFile(int int_0, CacheFile cachefile_0, CacheFile cachefile_1, int int_1) {
      this.dataFile = null;
      this.indexFile = null;
      this.maxSize = 65000;
      this.index = int_0;
      this.dataFile = cachefile_0;
      this.indexFile = cachefile_1;
      this.maxSize = int_1;
   }

   boolean method70(int int_0, byte[] bytes_0, int int_1, boolean bool_0) {
      CacheFile cachefile_0 = this.dataFile;
      synchronized(cachefile_0) {
         try {
            int int_2;
            boolean bool_1;
            if (bool_0) {
               if (this.indexFile.method561() < (long)(int_0 * 6 + 6)) {
                  bool_1 = false;
                  return bool_1;
               }

               this.indexFile.seek((long)(int_0 * 6));
               this.indexFile.method559(aByteArray1, 0, 6);
               int_2 = (aByteArray1[5] & 0xFF) + ((aByteArray1[3] & 0xFF) << 16) + ((aByteArray1[4] & 0xFF) << 8);
               if (int_2 <= 0 || (long)int_2 > this.dataFile.method561() / 520L) {
                  bool_1 = false;
                  return bool_1;
               }
            } else {
               int_2 = (int)((this.dataFile.method561() + 519L) / 520L);
               if (int_2 == 0) {
                  int_2 = 1;
               }
            }

            aByteArray1[0] = (byte)(int_1 >> 16);
            aByteArray1[1] = (byte)(int_1 >> 8);
            aByteArray1[2] = (byte)int_1;
            aByteArray1[3] = (byte)(int_2 >> 16);
            aByteArray1[4] = (byte)(int_2 >> 8);
            aByteArray1[5] = (byte)int_2;
            this.indexFile.seek((long)(int_0 * 6));
            this.indexFile.write(aByteArray1, 0, 6);
            int int_3 = 0;
            int int_4 = 0;

            while (true) {
               if (int_3 < int_1) {
                  label146: {
                     int int_5 = 0;
                     int int_6;
                     if (bool_0) {
                        this.dataFile.seek((long)(int_2 * 520));

                        try {
                           this.dataFile.method559(aByteArray1, 0, 8);
                        } catch (EOFException eofexception_0) {
                           break label146;
                        }

                        int_6 = (aByteArray1[1] & 0xFF) + ((aByteArray1[0] & 0xFF) << 8);
                        int int_7 = (aByteArray1[3] & 0xFF) + ((aByteArray1[2] & 0xFF) << 8);
                        int_5 = ((aByteArray1[5] & 0xFF) << 8) + ((aByteArray1[4] & 0xFF) << 16) + (aByteArray1[6] & 0xFF);
                        int int_8 = aByteArray1[7] & 0xFF;
                        if (int_6 != int_0 || int_7 != int_4 || int_8 != this.index) {
                           bool_1 = false;
                           return bool_1;
                        }

                        if (int_5 < 0 || (long)int_5 > this.dataFile.method561() / 520L) {
                           bool_1 = false;
                           return bool_1;
                        }
                     }

                     if (int_5 == 0) {
                        bool_0 = false;
                        int_5 = (int)((this.dataFile.method561() + 519L) / 520L);
                        if (int_5 == 0) {
                           ++int_5;
                        }

                        if (int_2 == int_5) {
                           ++int_5;
                        }
                     }

                     if (int_1 - int_3 <= 512) {
                        int_5 = 0;
                     }

                     aByteArray1[0] = (byte)(int_0 >> 8);
                     aByteArray1[1] = (byte)int_0;
                     aByteArray1[2] = (byte)(int_4 >> 8);
                     aByteArray1[3] = (byte)int_4;
                     aByteArray1[4] = (byte)(int_5 >> 16);
                     aByteArray1[5] = (byte)(int_5 >> 8);
                     aByteArray1[6] = (byte)int_5;
                     aByteArray1[7] = (byte)this.index;
                     this.dataFile.seek((long)(int_2 * 520));
                     this.dataFile.write(aByteArray1, 0, 8);
                     int_6 = int_1 - int_3;
                     if (int_6 > 512) {
                        int_6 = 512;
                     }

                     this.dataFile.write(bytes_0, int_3, int_6);
                     int_3 += int_6;
                     int_2 = int_5;
                     ++int_4;
                     continue;
                  }
               }

               bool_1 = true;
               return bool_1;
            }
         } catch (IOException ioexception_0) {
            return false;
         }
      }
   }

   public boolean method71(int int_0, byte[] bytes_0, int int_1) {
      CacheFile cachefile_0 = this.dataFile;
      synchronized(cachefile_0) {
         if (int_1 >= 0 && int_1 <= this.maxSize) {
            boolean bool_0 = this.method70(int_0, bytes_0, int_1, true);
            if (!bool_0) {
               bool_0 = this.method70(int_0, bytes_0, int_1, false);
            }

            return bool_0;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   public byte[] method72(int int_0) {
      CacheFile cachefile_0 = this.dataFile;
      synchronized(cachefile_0) {
         Object object_0;
         try {
            if (this.indexFile.method561() >= (long)(int_0 * 6 + 6)) {
               this.indexFile.seek((long)(int_0 * 6));
               this.indexFile.method559(aByteArray1, 0, 6);
               int int_1 = ((aByteArray1[0] & 0xFF) << 16) + (aByteArray1[2] & 0xFF) + ((aByteArray1[1] & 0xFF) << 8);
               int int_2 = (aByteArray1[5] & 0xFF) + ((aByteArray1[3] & 0xFF) << 16) + ((aByteArray1[4] & 0xFF) << 8);
               if (int_1 >= 0 && int_1 <= this.maxSize) {
                  if (int_2 > 0 && (long)int_2 <= this.dataFile.method561() / 520L) {
                     byte[] bytes_0 = new byte[int_1];
                     int int_3 = 0;
                     int int_4 = 0;

                     while (int_3 < int_1) {
                        if (int_2 == 0) {
                           object_0 = null;
                           return (byte[]) object_0;
                        }

                        this.dataFile.seek((long)(int_2 * 520));
                        int int_5 = int_1 - int_3;
                        if (int_5 > 512) {
                           int_5 = 512;
                        }

                        this.dataFile.method559(aByteArray1, 0, int_5 + 8);
                        int int_6 = (aByteArray1[1] & 0xFF) + ((aByteArray1[0] & 0xFF) << 8);
                        int int_7 = (aByteArray1[3] & 0xFF) + ((aByteArray1[2] & 0xFF) << 8);
                        int int_8 = ((aByteArray1[5] & 0xFF) << 8) + ((aByteArray1[4] & 0xFF) << 16) + (aByteArray1[6] & 0xFF);
                        int int_9 = aByteArray1[7] & 0xFF;
                        if (int_6 == int_0 && int_4 == int_7 && int_9 == this.index) {
                           if (int_8 >= 0 && (long)int_8 <= this.dataFile.method561() / 520L) {
                              for (int int_10 = 0; int_10 < int_5; int_10++) {
                                 bytes_0[int_3++] = aByteArray1[int_10 + 8];
                              }

                              int_2 = int_8;
                              ++int_4;
                              continue;
                           }

                           object_0 = null;
                           return (byte[]) object_0;
                        }

                        object_0 = null;
                        return (byte[]) object_0;
                     }

                     byte[] bytes_1 = bytes_0;
                     return bytes_1;
                  }

                  object_0 = null;
                  return (byte[]) object_0;
               }

               object_0 = null;
               return (byte[]) object_0;
            }

            object_0 = null;
         } catch (IOException ioexception_0) {
            return null;
         }

         return (byte[]) object_0;
      }
   }

   public static String method73(Buffer buffer_0) {
      String string_1;
      try {
         int int_0 = buffer_0.getUSmart();
         if (int_0 > 32767) {
            int_0 = 32767;
         }

         byte[] bytes_0 = new byte[int_0];
         buffer_0.position += Class99.aHuffman1.decompress(buffer_0.buffer, buffer_0.position, bytes_0, 0, int_0);
         String string_0 = Class13.getString(bytes_0, 0, int_0);
         string_1 = string_0;
      } catch (Exception exception_0) {
         string_1 = "Cabbage";
      }

      return string_1;
   }

}
