import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class FaceNormal {

   static int[] anIntArray59;
   int x;
   int y;
   int z;

   static long method567() {
      try {
         URL url_0 = new URL(Class28.method230("services", false) + "m=accountappeal/login.ws");
         URLConnection urlconnection_0 = url_0.openConnection();
         urlconnection_0.setRequestProperty("connection", "close");
         urlconnection_0.setDoInput(true);
         urlconnection_0.setDoOutput(true);
         urlconnection_0.setConnectTimeout(5000);
         OutputStreamWriter outputstreamwriter_0 = new OutputStreamWriter(urlconnection_0.getOutputStream());
         outputstreamwriter_0.write("data1=req");
         outputstreamwriter_0.flush();
         InputStream inputstream_0 = urlconnection_0.getInputStream();
         Buffer buffer_0 = new Buffer(new byte[1000]);

         do {
            int int_0 = inputstream_0.read(buffer_0.payload, buffer_0.offset, 1000 - buffer_0.offset);
            if (int_0 == -1) {
               buffer_0.offset = 0;
               long long_0 = buffer_0.readLong();
               return long_0;
            }

            buffer_0.offset += int_0;
         } while (buffer_0.offset < 1000);

         return 0L;
      } catch (Exception exception_0) {
         return 0L;
      }
   }

}
