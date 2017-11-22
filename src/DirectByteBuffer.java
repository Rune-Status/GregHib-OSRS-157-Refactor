import java.nio.ByteBuffer;

public class DirectByteBuffer extends AbstractByteBuffer {

   ByteBuffer buffer;

   byte[] get() {
      byte[] bytes_0 = new byte[this.buffer.capacity()];
      this.buffer.position(0);
      this.buffer.get(bytes_0);
      return bytes_0;
   }

   void put(byte[] bytes_0) {
      this.buffer = ByteBuffer.allocateDirect(bytes_0.length);
      this.buffer.position(0);
      this.buffer.put(bytes_0);
   }

}
