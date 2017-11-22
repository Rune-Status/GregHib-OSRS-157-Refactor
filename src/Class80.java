import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Class80 {

   public static SpritePixels method470(byte[] bytes_0) {
      BufferedImage bufferedimage_0 = null;

      try {
         bufferedimage_0 = ImageIO.read(new ByteArrayInputStream(bytes_0));
         int int_0 = bufferedimage_0.getWidth();
         int int_1 = bufferedimage_0.getHeight();
         int[] ints_0 = new int[int_0 * int_1];
         PixelGrabber pixelgrabber_0 = new PixelGrabber(bufferedimage_0, 0, 0, int_0, int_1, ints_0, 0, int_0);
         pixelgrabber_0.grabPixels();
         return new SpritePixels(ints_0, int_0, int_1);
      } catch (IOException ioexception_0) {
         ;
      } catch (InterruptedException interruptedexception_0) {
         ;
      }

      return new SpritePixels(0, 0);
   }

   public static void method471(IndexDataBase indexdatabase_0) {
      Class86.anIndexDataBase6 = indexdatabase_0;
   }

}
