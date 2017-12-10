public final class SceneSpawnNode extends Node {

   int updateCycle;
   int timeLeftTillSpawn;
   int plane;
   int x;
   int y;
   int spawnType;
   int id;
   int objectType2;
   int orientation;
   int objectId;
   int objectType;
   int objectFace;

   SceneSpawnNode() {
      this.updateCycle = 0;
      this.timeLeftTillSpawn = -1;
   }

}
