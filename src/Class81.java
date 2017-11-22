import java.io.File;
import java.io.RandomAccessFile;

public class Class81 {

   public static SpritePixels method472(IndexDataBase indexdatabase_0, String string_0, String string_1) {
      int int_0 = indexdatabase_0.getFile(string_0);
      int int_1 = indexdatabase_0.getChild(int_0, string_1);
      return Class38.method254(indexdatabase_0, int_0, int_1);
   }

   public static File method473(String string_0) {
      if (!Class63.aBool25) {
         throw new RuntimeException("");
      } else {
         File file_0 = (File) Class63.aHashtable1.get(string_0);
         if (file_0 != null) {
            return file_0;
         } else {
            File file_1 = new File(Class63.aFile2, string_0);
            RandomAccessFile randomaccessfile_0 = null;

            try {
               File file_2 = new File(file_1.getParent());
               if (!file_2.exists()) {
                  throw new RuntimeException("");
               } else {
                  randomaccessfile_0 = new RandomAccessFile(file_1, "rw");
                  int int_0 = randomaccessfile_0.read();
                  randomaccessfile_0.seek(0L);
                  randomaccessfile_0.write(int_0);
                  randomaccessfile_0.seek(0L);
                  randomaccessfile_0.close();
                  Class63.aHashtable1.put(string_0, file_1);
                  return file_1;
               }
            } catch (Exception exception_0) {
               try {
                  if (randomaccessfile_0 != null) {
                     randomaccessfile_0.close();
                     randomaccessfile_0 = null;
                  }
               } catch (Exception exception_1) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   public static String method474(int int_0, int int_1, boolean bool_0) {
      if (int_1 >= 2 && int_1 <= 36) {
         if (int_0 < 0) {
            return Integer.toString(int_0, int_1);
         } else {
            int int_2 = 2;

            for (int int_3 = int_0 / int_1; int_3 != 0; int_2++) {
               int_3 /= int_1;
            }

            char[] chars_0 = new char[int_2];
            chars_0[0] = 43;

            for (int int_4 = int_2 - 1; int_4 > 0; --int_4) {
               int int_5 = int_0;
               int_0 /= int_1;
               int int_6 = int_5 - int_0 * int_1;
               if (int_6 >= 10) {
                  chars_0[int_4] = (char)(int_6 + 87);
               } else {
                  chars_0[int_4] = (char)(int_6 + 48);
               }
            }

            return new String(chars_0);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

}
