import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

public final class MainBufferProvider extends BufferProvider {

   Image image;
   Component aComponent1;

   MainBufferProvider(int int_0, int int_1, Component component_0) {
      super.width = int_0;
      super.height = int_1;
      super.pixels = new int[int_1 * int_0 + 1];
      DataBufferInt databufferint_0 = new DataBufferInt(super.pixels, super.pixels.length);
      DirectColorModel directcolormodel_0 = new DirectColorModel(32, 16711680, 65280, 255);
      WritableRaster writableraster_0 = Raster.createWritableRaster(directcolormodel_0.createCompatibleSampleModel(super.width, super.height), databufferint_0, (Point) null);
      this.image = new BufferedImage(directcolormodel_0, writableraster_0, false, new Hashtable());
      this.method625(component_0);
      this.setRaster();
   }

   void drawSub(Graphics graphics_0, int int_0, int int_1, int int_2, int int_3) {
      try {
         Shape shape_0 = graphics_0.getClip();
         graphics_0.clipRect(int_0, int_1, int_2, int_3);
         graphics_0.drawImage(this.image, 0, 0, this.aComponent1);
         graphics_0.setClip(shape_0);
      } catch (Exception exception_0) {
         this.aComponent1.repaint();
      }

   }

   void draw(Graphics graphics_0, int int_0, int int_1) {
      try {
         graphics_0.drawImage(this.image, int_0, int_1, this.aComponent1);
      } catch (Exception exception_0) {
         this.aComponent1.repaint();
      }

   }

   void method625(Component component_0) {
      this.aComponent1 = component_0;
   }

   public void method499(int int_0, int int_1) {
      this.draw(this.aComponent1.getGraphics(), int_0, int_1);
   }

   public void method500(int int_0, int int_1, int int_2, int int_3) {
      this.drawSub(this.aComponent1.getGraphics(), int_0, int_1, int_2, int_3);
   }

}
