import java.net.URL;

public class Class56 {

   public static FileRequest currentRequest;
   static IndexData anIndexData2;
   volatile byte[] aByteArray7;
   volatile boolean aBool24;
   final URL anURL1;

   Class56(URL url_0) {
      this.anURL1 = url_0;
   }

   public boolean method356() {
      return this.aBool24;
   }

   public byte[] method357() {
      return this.aByteArray7;
   }

   public static byte[] toByteArray(Object object_0, boolean bool_0) {
      if (object_0 == null) {
         return null;
      } else if (object_0 instanceof byte[]) {
         byte[] bytes_0 = (byte[]) ((byte[]) object_0);
         return bool_0 ? Class29.method233(bytes_0) : bytes_0;
      } else if (object_0 instanceof AbstractByteBuffer) {
         AbstractByteBuffer abstractbytebuffer_0 = (AbstractByteBuffer) object_0;
         return abstractbytebuffer_0.get();
      } else {
         throw new IllegalArgumentException();
      }
   }

}
