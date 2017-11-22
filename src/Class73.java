public class Class73 {

   static int anInt171;

   static void method444(String string_0, String string_1, int int_0, int int_1, int int_2, int int_3, boolean bool_0) {
      if (!Client.isMenuOpen) {
         if (Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = string_0;
            Client.menuTargets[Client.menuOptionCount] = string_1;
            Client.menuTypes[Client.menuOptionCount] = int_0;
            Client.menuIdentifiers[Client.menuOptionCount] = int_1;
            Client.menuActionParams0[Client.menuOptionCount] = int_2;
            Client.menuActionParams1[Client.menuOptionCount] = int_3;
            Client.aBoolArray9[Client.menuOptionCount] = bool_0;
            ++Client.menuOptionCount;
         }

      }
   }

}
