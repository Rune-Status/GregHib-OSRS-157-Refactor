import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;

public class Class55 implements Runnable {

   static byte[][] localRegionMapData;
   volatile boolean aBool23;
   Queue aQueue1;
   final Thread aThread1;

   public Class55() {
      this.aQueue1 = new LinkedList();
      this.aThread1 = new Thread(this);
      this.aThread1.setPriority(1);
      this.aThread1.start();
   }

   public void method352() {
      this.aBool23 = true;

      try {
         synchronized(this) {
            this.notify();
         }

         this.aThread1.join();
      } catch (InterruptedException interruptedexception_0) {
         ;
      }

   }

   public Class56 method353(URL url_0) {
      Class56 class56_0 = new Class56(url_0);
      synchronized(this) {
         this.aQueue1.add(class56_0);
         this.notify();
         return class56_0;
      }
   }

   public void run() {
      while (!this.aBool23) {
         try {
            Class56 class56_0;
            synchronized(this) {
               class56_0 = (Class56) this.aQueue1.poll();
               if (class56_0 == null) {
                  try {
                     this.wait();
                  } catch (InterruptedException interruptedexception_0) {
                     ;
                  }
                  continue;
               }
            }

            DataInputStream datainputstream_0 = null;
            URLConnection urlconnection_0 = null;

            try {
               urlconnection_0 = class56_0.anURL1.openConnection();
               urlconnection_0.setConnectTimeout(5000);
               urlconnection_0.setReadTimeout(5000);
               urlconnection_0.setUseCaches(false);
               urlconnection_0.setRequestProperty("Connection", "close");
               int int_0 = urlconnection_0.getContentLength();
               if (int_0 >= 0) {
                  byte[] bytes_0 = new byte[int_0];
                  datainputstream_0 = new DataInputStream(urlconnection_0.getInputStream());
                  datainputstream_0.readFully(bytes_0);
                  class56_0.aByteArray7 = bytes_0;
               }

               class56_0.aBool24 = true;
            } catch (IOException ioexception_0) {
               class56_0.aBool24 = true;
            } finally {
               if (datainputstream_0 != null) {
                  datainputstream_0.close();
               }

               if (urlconnection_0 != null && urlconnection_0 instanceof HttpURLConnection) {
                  ((HttpURLConnection) urlconnection_0).disconnect();
               }

            }
         } catch (Exception exception_0) {
            Class13.method168((String) null, exception_0);
         }
      }

   }

   public static boolean method354(int int_0) {
      return int_0 == Enum4.anEnum4_23.anInt382;
   }

}
