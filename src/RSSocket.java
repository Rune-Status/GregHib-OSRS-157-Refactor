import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public final class RSSocket implements Runnable {

   int streamOffset;
   boolean closed;
   int outbufLen;
   boolean throwException;
   InputStream inputStream;
   byte[] outbuffer;
   Task socketThread;
   final int anInt223;
   OutputStream outputStream;
   Signlink manager;
   Socket socket;
   final int anInt224;

   public RSSocket(Socket socket_0, Signlink signlink_0, int int_0) throws IOException {
      this.closed = false;
      this.streamOffset = 0;
      this.outbufLen = 0;
      this.throwException = false;
      this.manager = signlink_0;
      this.socket = socket_0;
      this.anInt223 = int_0;
      this.anInt224 = int_0 - 100;
      this.socket.setSoTimeout(30000);
      this.socket.setTcpNoDelay(true);
      this.socket.setReceiveBufferSize(65536);
      this.socket.setSendBufferSize(65536);
      this.inputStream = this.socket.getInputStream();
      this.outputStream = this.socket.getOutputStream();
   }

   public void close() {
      if (!this.closed) {
         synchronized(this) {
            this.closed = true;
            this.notifyAll();
         }

         if (this.socketThread != null) {
            while (this.socketThread.status == 0) {
               Class19.method204(1L);
            }

            if (this.socketThread.status == 1) {
               try {
                  ((Thread) this.socketThread.value).join();
               } catch (InterruptedException interruptedexception_0) {
                  ;
               }
            }
         }

         this.socketThread = null;
      }
   }

   public boolean method568(int int_0) throws IOException {
      if (this.closed) {
         return false;
      } else {
         try {
            return this.inputStream.available() >= int_0;
         } catch (IOException ioexception_0) {
            throw new IOException("Error reading from clientstream", ioexception_0);
         }
      }
   }

   public void read(byte[] bytes_0, int int_0, int int_1) throws IOException {
      if (!this.closed) {
         while (int_1 > 0) {
            int int_2 = this.inputStream.read(bytes_0, int_0, int_1);
            if (int_2 <= 0) {
               throw new EOFException();
            }

            int_0 += int_2;
            int_1 -= int_2;
         }

      }
   }

   public void queueForWrite(byte[] bytes_0, int int_0, int int_1) throws IOException {
      if (!this.closed) {
         if (this.throwException) {
            this.throwException = false;
            throw new IOException();
         } else {
            if (this.outbuffer == null) {
               this.outbuffer = new byte[this.anInt223];
            }

            synchronized(this) {
               for (int int_2 = 0; int_2 < int_1; int_2++) {
                  this.outbuffer[this.outbufLen] = bytes_0[int_2 + int_0];
                  this.outbufLen = (this.outbufLen + 1) % this.anInt223;
                  if ((this.streamOffset + this.anInt224) % this.anInt223 == this.outbufLen) {
                     throw new IOException();
                  }
               }

               if (this.socketThread == null) {
                  this.socketThread = this.manager.createRunnable(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   public int available() throws IOException {
      return this.closed ? 0 : this.inputStream.available();
   }

   public int readByte() throws IOException {
      return this.closed ? 0 : this.inputStream.read();
   }

   protected void finalize() {
      this.close();
   }

   public void run() {
      try {
         while (true) {
            int int_0;
            int int_1;
            synchronized(this) {
               if (this.streamOffset == this.outbufLen) {
                  if (this.closed) {
                     break;
                  }

                  try {
                     this.wait();
                  } catch (InterruptedException interruptedexception_0) {
                     ;
                  }
               }

               int_0 = this.streamOffset;
               if (this.outbufLen >= this.streamOffset) {
                  int_1 = this.outbufLen - this.streamOffset;
               } else {
                  int_1 = this.anInt223 - this.streamOffset;
               }
            }

            if (int_1 > 0) {
               try {
                  this.outputStream.write(this.outbuffer, int_0, int_1);
               } catch (IOException ioexception_1) {
                  this.throwException = true;
               }

               this.streamOffset = (int_1 + this.streamOffset) % this.anInt223;

               try {
                  if (this.outbufLen == this.streamOffset) {
                     this.outputStream.flush();
                  }
               } catch (IOException ioexception_2) {
                  this.throwException = true;
               }
            }
         }

         try {
            if (this.inputStream != null) {
               this.inputStream.close();
            }

            if (this.outputStream != null) {
               this.outputStream.close();
            }

            if (this.socket != null) {
               this.socket.close();
            }
         } catch (IOException ioexception_0) {
            ;
         }

         this.outbuffer = null;
      } catch (Exception exception_0) {
         Class13.method168((String) null, exception_0);
      }

   }

}
