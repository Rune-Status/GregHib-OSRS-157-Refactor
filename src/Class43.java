public class Class43 {

   static void method266(int int_0) {
      Client.aLong30 = 0L;
      if (int_0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      int int_1 = Client.isResized ? 2 : 1;
      if (int_1 == 1) {
         AClass3.clientInstance.method1083(765, 503);
      } else {
         AClass3.clientInstance.method1083(7680, 2160);
      }

      if (Client.gameState >= 25) {
         ScriptVarType.method469();
      }

   }

   static void method267() {
      if (Class25.username == null || Class25.username.length() <= 0) {
         if (Buffer.preferences.aString10 != null) {
            Class25.username = Buffer.preferences.aString10;
            Class25.aBool9 = true;
         } else {
            Class25.aBool9 = false;
         }

      }
   }

}
