public class VertexNormal {

   int x;
   int y;
   int z;
   int magnitude;

   VertexNormal() {
   }

   VertexNormal(VertexNormal vertexnormal_1) {
      this.x = vertexnormal_1.x;
      this.y = vertexnormal_1.y;
      this.z = vertexnormal_1.z;
      this.magnitude = vertexnormal_1.magnitude;
   }

   static String method492(IterableHashTable iterablehashtable_0, int int_0, String string_0) {
      if (iterablehashtable_0 == null) {
         return string_0;
      } else {
         ObjectNode objectnode_0 = (ObjectNode) iterablehashtable_0.get((long)int_0);
         return objectnode_0 == null ? string_0 : (String) objectnode_0.value;
      }
   }

}
