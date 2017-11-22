public class ClanMember extends Node {

   static Widget aWidget7;
   static int[] anIntArray77;
   String username;
   int world;
   byte rank;
   String aString20;

   static void method676(IndexData indexdata_0, int int_0, int int_1, int int_2, byte byte_0, boolean bool_0) {
      long long_0 = (long)((int_0 << 16) + int_1);
      FileRequest filerequest_0 = (FileRequest) Class95.aHashTable4.get(long_0);
      if (filerequest_0 == null) {
         filerequest_0 = (FileRequest) Class95.aHashTable5.get(long_0);
         if (filerequest_0 == null) {
            filerequest_0 = (FileRequest) Class95.aHashTable3.get(long_0);
            if (filerequest_0 != null) {
               if (bool_0) {
                  filerequest_0.unlinkDual();
                  Class95.aHashTable4.put(filerequest_0, long_0);
                  --Class95.anInt199;
                  ++Class95.anInt197;
               }

            } else {
               if (!bool_0) {
                  filerequest_0 = (FileRequest) Class95.aHashTable6.get(long_0);
                  if (filerequest_0 != null) {
                     return;
                  }
               }

               filerequest_0 = new FileRequest();
               filerequest_0.index = indexdata_0;
               filerequest_0.crc = int_2;
               filerequest_0.padding = byte_0;
               if (bool_0) {
                  Class95.aHashTable4.put(filerequest_0, long_0);
                  ++Class95.anInt197;
               } else {
                  Class95.aNode2LinkedList1.push(filerequest_0);
                  Class95.aHashTable3.put(filerequest_0, long_0);
                  ++Class95.anInt199;
               }

            }
         }
      }
   }

   public static VarPlayerType method677(int int_0) {
      VarPlayerType varplayertype_0 = (VarPlayerType) VarPlayerType.varplayers.get((long)int_0);
      if (varplayertype_0 != null) {
         return varplayertype_0;
      } else {
         byte[] bytes_0 = Class11.varplayer_ref.getConfigData(16, int_0);
         varplayertype_0 = new VarPlayerType();
         if (bytes_0 != null) {
            varplayertype_0.decode(new Buffer(bytes_0));
         }

         VarPlayerType.varplayers.put(varplayertype_0, (long)int_0);
         return varplayertype_0;
      }
   }

}
