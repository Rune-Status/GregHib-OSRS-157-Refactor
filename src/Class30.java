import java.util.Comparator;

final class Class30 implements Comparator {

   int method236(Class36 class36_0, Class36 class36_1) {
      return class36_0.aLong2 < class36_1.aLong2 ? -1 : (class36_0.aLong2 == class36_1.aLong2 ? 0 : 1);
   }

   public int compare(Object object_0, Object object_1) {
      return this.method236((Class36) object_0, (Class36) object_1);
   }

   public boolean equals(Object object_0) {
      return super.equals(object_0);
   }

}
