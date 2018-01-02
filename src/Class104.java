public class Class104 {

   public static short[][] aShortArrayArray3;

   public static Font loadFont(IndexDataBase cacheIndex, IndexDataBase secondIndex, String fileName, String childName) {
      int fileId = cacheIndex.getFile(fileName);
      int childId = cacheIndex.getChild(fileId, childName);
      return Class89.decodeFont(cacheIndex, secondIndex, fileId, childId);
   }

}
