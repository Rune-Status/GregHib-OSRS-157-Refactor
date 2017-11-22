import java.util.zip.Inflater;

public class GZipDecompressor {

   Inflater inflator;

   GZipDecompressor(int int_0, int int_1, int int_2) {
   }

   public GZipDecompressor() {
      this(-1, 1000000, 1000000);
   }

   public void decompress(Buffer buffer_0, byte[] bytes_0) {
      if (buffer_0.payload[buffer_0.offset] == 31 && buffer_0.payload[buffer_0.offset + 1] == -117) {
         if (this.inflator == null) {
            this.inflator = new Inflater(true);
         }

         try {
            this.inflator.setInput(buffer_0.payload, buffer_0.offset + 10, buffer_0.payload.length - (buffer_0.offset + 8 + 10));
            this.inflator.inflate(bytes_0);
         } catch (Exception exception_0) {
            this.inflator.reset();
            throw new RuntimeException("");
         }

         this.inflator.reset();
      } else {
         throw new RuntimeException("");
      }
   }

}
