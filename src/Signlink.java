import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class Signlink implements Runnable {

   public static String javaVendor;
   public static String javaVersion;
   boolean closed;
   Task currentTask;
   Thread sysEventQueue;
   Task cachedTask;

   public Signlink() {
      this.currentTask = null;
      this.cachedTask = null;
      this.closed = false;
      javaVendor = "Unknown";
      javaVersion = "1.6";

      try {
         javaVendor = System.getProperty("java.vendor");
         javaVersion = System.getProperty("java.version");
      } catch (Exception exception_0) {
         ;
      }

      this.closed = false;
      this.sysEventQueue = new Thread(this);
      this.sysEventQueue.setPriority(10);
      this.sysEventQueue.setDaemon(true);
      this.sysEventQueue.start();
   }

   Task method503(int int_0, int int_1, int int_2, Object object_0) {
      Task task_0 = new Task();
      task_0.type = int_0;
      task_0.anInt217 = int_1;
      task_0.anObject3 = object_0;
      synchronized(this) {
         if (this.cachedTask != null) {
            this.cachedTask.task = task_0;
            this.cachedTask = task_0;
         } else {
            this.cachedTask = this.currentTask = task_0;
         }

         this.notify();
         return task_0;
      }
   }

   public Task createRunnable(Runnable runnable_0, int int_0) {
      return this.method503(2, int_0, 0, runnable_0);
   }

   public void join() {
      synchronized(this) {
         this.closed = true;
         this.notifyAll();
      }

      try {
         this.sysEventQueue.join();
      } catch (InterruptedException interruptedexception_0) {
         ;
      }

   }

   public Task createSocket(String string_0, int int_0) {
      return this.method503(1, int_0, 0, string_0);
   }

   public Task createHost(int int_0) {
      return this.method503(3, int_0, 0, (Object) null);
   }

   public void run() {
      while (true) {
         Task task_0;
         synchronized(this) {
            while (true) {
               if (this.closed) {
                  return;
               }

               if (this.currentTask != null) {
                  task_0 = this.currentTask;
                  this.currentTask = this.currentTask.task;
                  if (this.currentTask == null) {
                     this.cachedTask = null;
                  }
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException interruptedexception_0) {
                  ;
               }
            }
         }

         try {
            int int_0 = task_0.type;
            if (int_0 == 1) {
               task_0.value = new Socket(InetAddress.getByName((String) task_0.anObject3), task_0.anInt217);
            } else if (int_0 == 2) {
               Thread thread_0 = new Thread((Runnable) task_0.anObject3);
               thread_0.setDaemon(true);
               thread_0.start();
               thread_0.setPriority(task_0.anInt217);
               task_0.value = thread_0;
            } else if (int_0 == 4) {
               task_0.value = new DataInputStream(((URL) task_0.anObject3).openStream());
            } else if (int_0 == 3) {
               String string_0 = (task_0.anInt217 >> 24 & 0xFF) + "." + (task_0.anInt217 >> 16 & 0xFF) + "." + (task_0.anInt217 >> 8 & 0xFF) + "." + (task_0.anInt217 & 0xFF);
               task_0.value = InetAddress.getByName(string_0).getHostName();
            }

            task_0.status = 1;
         } catch (ThreadDeath threaddeath_0) {
            throw threaddeath_0;
         } catch (Throwable throwable_0) {
            task_0.status = 2;
         }
      }
   }

}
