public abstract class BufferProvider {

   public int[] pixels;
   public int width;
   public int height;

   public void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   public abstract void method499(int var1, int var2);

   public abstract void method500(int var1, int var2, int var3, int var4);

}
