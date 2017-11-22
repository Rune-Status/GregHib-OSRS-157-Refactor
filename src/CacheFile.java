import java.io.EOFException;
import java.io.IOException;

public class CacheFile {

   static int menuX;
   static SpritePixels[] headIconsPk;
   long aLong17;
   int anInt220;
   long aLong18;
   long aLong19;
   long position;
   long aLong20;
   FileOnDisk aFileOnDisk1;
   int anInt221;
   byte[] writePayload;
   byte[] readPayload;
   long length;

   public CacheFile(FileOnDisk fileondisk_0, int int_0, int int_1) throws IOException {
      this.aLong20 = -1L;
      this.aLong19 = -1L;
      this.anInt221 = 0;
      this.aFileOnDisk1 = fileondisk_0;
      this.aLong17 = this.length = fileondisk_0.length();
      this.readPayload = new byte[int_0];
      this.writePayload = new byte[int_1];
      this.position = 0L;
   }

   public void method559(byte[] bytes_0, int int_0, int int_1) throws IOException {
      try {
         if (int_1 + int_0 > bytes_0.length) {
            throw new ArrayIndexOutOfBoundsException(int_1 + int_0 - bytes_0.length);
         }

         if (this.aLong19 != -1L && this.position >= this.aLong19 && (long)int_1 + this.position <= this.aLong19 + (long)this.anInt221) {
            System.arraycopy(this.writePayload, (int)(this.position - this.aLong19), bytes_0, int_0, int_1);
            this.position += (long)int_1;
            return;
         }

         long long_0 = this.position;
         int int_2 = int_1;
         int int_3;
         if (this.position >= this.aLong20 && this.position < this.aLong20 + (long)this.anInt220) {
            int_3 = (int)((long)this.anInt220 - (this.position - this.aLong20));
            if (int_3 > int_1) {
               int_3 = int_1;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.aLong20), bytes_0, int_0, int_3);
            this.position += (long)int_3;
            int_0 += int_3;
            int_1 -= int_3;
         }

         if (int_1 > this.readPayload.length) {
            this.aFileOnDisk1.seek(this.position);

            for (this.aLong18 = this.position; int_1 > 0; int_1 -= int_3) {
               int_3 = this.aFileOnDisk1.read(bytes_0, int_0, int_1);
               if (int_3 == -1) {
                  break;
               }

               this.aLong18 += (long)int_3;
               this.position += (long)int_3;
               int_0 += int_3;
            }
         } else if (int_1 > 0) {
            this.method562();
            int_3 = int_1;
            if (int_1 > this.anInt220) {
               int_3 = this.anInt220;
            }

            System.arraycopy(this.readPayload, 0, bytes_0, int_0, int_3);
            int_0 += int_3;
            int_1 -= int_3;
            this.position += (long)int_3;
         }

         if (this.aLong19 != -1L) {
            if (this.aLong19 > this.position && int_1 > 0) {
               int_3 = int_0 + (int)(this.aLong19 - this.position);
               if (int_3 > int_1 + int_0) {
                  int_3 = int_1 + int_0;
               }

               while (int_0 < int_3) {
                  bytes_0[int_0++] = 0;
                  --int_1;
                  ++this.position;
               }
            }

            long long_1 = -1L;
            long long_2 = -1L;
            if (this.aLong19 >= long_0 && this.aLong19 < long_0 + (long)int_2) {
               long_1 = this.aLong19;
            } else if (long_0 >= this.aLong19 && long_0 < (long)this.anInt221 + this.aLong19) {
               long_1 = long_0;
            }

            if (this.aLong19 + (long)this.anInt221 > long_0 && this.aLong19 + (long)this.anInt221 <= (long)int_2 + long_0) {
               long_2 = (long)this.anInt221 + this.aLong19;
            } else if (long_0 + (long)int_2 > this.aLong19 && long_0 + (long)int_2 <= this.aLong19 + (long)this.anInt221) {
               long_2 = long_0 + (long)int_2;
            }

            if (long_1 > -1L && long_2 > long_1) {
               int int_4 = (int)(long_2 - long_1);
               System.arraycopy(this.writePayload, (int)(long_1 - this.aLong19), bytes_0, (int)(long_1 - long_0) + int_0, int_4);
               if (long_2 > this.position) {
                  int_1 = (int)((long)int_1 - (long_2 - this.position));
                  this.position = long_2;
               }
            }
         }
      } catch (IOException ioexception_0) {
         this.aLong18 = -1L;
         throw ioexception_0;
      }

      if (int_1 > 0) {
         throw new EOFException();
      }
   }

   void method560() throws IOException {
      if (this.aLong19 != -1L) {
         if (this.aLong19 != this.aLong18) {
            this.aFileOnDisk1.seek(this.aLong19);
            this.aLong18 = this.aLong19;
         }

         this.aFileOnDisk1.write(this.writePayload, 0, this.anInt221);
         this.aLong18 += (long)(this.anInt221 * -600847225) * -1098434249L;
         if (this.aLong18 > this.length) {
            this.length = this.aLong18;
         }

         long long_0 = -1L;
         long long_1 = -1L;
         if (this.aLong19 >= this.aLong20 && this.aLong19 < (long)this.anInt220 + this.aLong20) {
            long_0 = this.aLong19;
         } else if (this.aLong20 >= this.aLong19 && this.aLong20 < (long)this.anInt221 + this.aLong19) {
            long_0 = this.aLong20;
         }

         if (this.aLong19 + (long)this.anInt221 > this.aLong20 && (long)this.anInt221 + this.aLong19 <= this.aLong20 + (long)this.anInt220) {
            long_1 = this.aLong19 + (long)this.anInt221;
         } else if ((long)this.anInt220 + this.aLong20 > this.aLong19 && (long)this.anInt220 + this.aLong20 <= (long)this.anInt221 + this.aLong19) {
            long_1 = this.aLong20 + (long)this.anInt220;
         }

         if (long_0 > -1L && long_1 > long_0) {
            int int_0 = (int)(long_1 - long_0);
            System.arraycopy(this.writePayload, (int)(long_0 - this.aLong19), this.readPayload, (int)(long_0 - this.aLong20), int_0);
         }

         this.aLong19 = -1L;
         this.anInt221 = 0;
      }

   }

   public long method561() {
      return this.aLong17;
   }

   public void seek(long long_0) throws IOException {
      if (long_0 < 0L) {
         throw new IOException("");
      } else {
         this.position = long_0;
      }
   }

   public void write(byte[] bytes_0, int int_0, int int_1) throws IOException {
      try {
         if ((long)int_1 + this.position > this.aLong17) {
            this.aLong17 = this.position + (long)int_1;
         }

         if (this.aLong19 != -1L && (this.position < this.aLong19 || this.position > this.aLong19 + (long)this.anInt221)) {
            this.method560();
         }

         if (this.aLong19 != -1L && this.position + (long)int_1 > (long)this.writePayload.length + this.aLong19) {
            int int_2 = (int)((long)this.writePayload.length - (this.position - this.aLong19));
            System.arraycopy(bytes_0, int_0, this.writePayload, (int)(this.position - this.aLong19), int_2);
            this.position += (long)int_2;
            int_0 += int_2;
            int_1 -= int_2;
            this.anInt221 = this.writePayload.length;
            this.method560();
         }

         if (int_1 <= this.writePayload.length) {
            if (int_1 > 0) {
               if (this.aLong19 == -1L) {
                  this.aLong19 = this.position;
               }

               System.arraycopy(bytes_0, int_0, this.writePayload, (int)(this.position - this.aLong19), int_1);
               this.position += (long)int_1;
               if (this.position - this.aLong19 > (long)this.anInt221) {
                  this.anInt221 = (int)(this.position - this.aLong19);
               }

            }
         } else {
            if (this.position != this.aLong18) {
               this.aFileOnDisk1.seek(this.position);
               this.aLong18 = this.position;
            }

            this.aFileOnDisk1.write(bytes_0, int_0, int_1);
            this.aLong18 += (long)int_1;
            if (this.aLong18 > this.length) {
               this.length = this.aLong18;
            }

            long long_0 = -1L;
            long long_1 = -1L;
            if (this.position >= this.aLong20 && this.position < this.aLong20 + (long)this.anInt220) {
               long_0 = this.position;
            } else if (this.aLong20 >= this.position && this.aLong20 < this.position + (long)int_1) {
               long_0 = this.aLong20;
            }

            if (this.position + (long)int_1 > this.aLong20 && this.position + (long)int_1 <= this.aLong20 + (long)this.anInt220) {
               long_1 = (long)int_1 + this.position;
            } else if ((long)this.anInt220 + this.aLong20 > this.position && this.aLong20 + (long)this.anInt220 <= this.position + (long)int_1) {
               long_1 = this.aLong20 + (long)this.anInt220;
            }

            if (long_0 > -1L && long_1 > long_0) {
               int int_3 = (int)(long_1 - long_0);
               System.arraycopy(bytes_0, (int)(long_0 + (long)int_0 - this.position), this.readPayload, (int)(long_0 - this.aLong20), int_3);
            }

            this.position += (long)int_1;
         }
      } catch (IOException ioexception_0) {
         this.aLong18 = -1L;
         throw ioexception_0;
      }
   }

   void method562() throws IOException {
      this.anInt220 = 0;
      if (this.aLong18 != this.position) {
         this.aFileOnDisk1.seek(this.position);
         this.aLong18 = this.position;
      }

      int int_0;
      for (this.aLong20 = this.position; this.anInt220 < this.readPayload.length; this.anInt220 += int_0) {
         int_0 = this.aFileOnDisk1.read(this.readPayload, this.anInt220, this.readPayload.length - this.anInt220);
         if (int_0 == -1) {
            break;
         }

         this.aLong18 += (long)int_0;
      }

   }

   public void method563() throws IOException {
      this.method560();
      this.aFileOnDisk1.close();
   }

   public void read(byte[] bytes_0) throws IOException {
      this.method559(bytes_0, 0, bytes_0.length);
   }

}
