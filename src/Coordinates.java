public class Coordinates {

   static World[] worldList;
   public int plane;
   public int worldY;
   public int worldX;

   public Coordinates() {
      this.plane = -1;
   }

   public Coordinates(Coordinates coordinates_1) {
      this.plane = coordinates_1.plane;
      this.worldX = coordinates_1.worldX;
      this.worldY = coordinates_1.worldY;
   }

   public Coordinates(int int_0, int int_1, int int_2) {
      this.plane = int_0;
      this.worldX = int_1;
      this.worldY = int_2;
   }

   public Coordinates(int int_0) {
      if (int_0 == -1) {
         this.plane = -1;
      } else {
         this.plane = int_0 >> 28 & 0x3;
         this.worldX = int_0 >> 14 & 0x3FFF;
         this.worldY = int_0 & 0x3FFF;
      }

   }

   public int method513() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   public void method514(int int_0, int int_1, int int_2) {
      this.plane = int_0;
      this.worldX = int_1;
      this.worldY = int_2;
   }

   boolean method515(Coordinates coordinates_1) {
      return this.plane != coordinates_1.plane ? false : (this.worldX != coordinates_1.worldX ? false : this.worldY == coordinates_1.worldY);
   }

   public String toString() {
      return this.plane + "," + (this.worldX >> 6) + "," + (this.worldY >> 6) + "," + (this.worldX & 0x3F) + "," + (this.worldY & 0x3F);
   }

   public int hashCode() {
      return this.method513();
   }

   public boolean equals(Object object_0) {
      return this == object_0 ? true : (!(object_0 instanceof Coordinates) ? false : this.method515((Coordinates) object_0));
   }

   static void processUIDs(SceneSpawnNode node) {
      int objectUID = 0;
      int objId = -1;
      int type = 0;
      int face = 0;
      if (node.spawnType == 0) {
         objectUID = Class23.sceneGraph.getWallObjectUID(node.plane, node.x, node.y);
      }

      if (node.spawnType == 1) {
         objectUID = Class23.sceneGraph.getWallDecorationUID(node.plane, node.x, node.y);
      }

      if (node.spawnType == 2) {
         objectUID = Class23.sceneGraph.getInteractableObjectUID(node.plane, node.x, node.y);
      }

      if (node.spawnType == 3) {
         objectUID = Class23.sceneGraph.getGroundDecorationUID(node.plane, node.x, node.y);
      }

      if (objectUID != 0) {
         int configId = Class23.sceneGraph.getObjectConfig(node.plane, node.x, node.y, objectUID);
         objId = objectUID >> 14 & 0x7FFF;
         type = configId & 0x1F;
         face = configId >> 6 & 0x3;
      }

      node.objectId = objId;
      node.objectType = type;
      node.objectFace = face;
   }

   public static Varbit method517(int int_0) {
      Varbit varbit_0 = (Varbit) Varbit.varbits.get((long)int_0);
      if (varbit_0 != null) {
         return varbit_0;
      } else {
         byte[] bytes_0 = Class49.varbit_ref.getConfigData(14, int_0);
         varbit_0 = new Varbit();
         if (bytes_0 != null) {
            varbit_0.decode(new Buffer(bytes_0));
         }

         Varbit.varbits.put(varbit_0, (long)int_0);
         return varbit_0;
      }
   }

}
