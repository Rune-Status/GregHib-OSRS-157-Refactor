public class Class38 {

   static IndexData songsIndex;
   static int[][] xteaKeys;

   static String getOptionCount(int amount) {
      return amount < 0 ? "" : (Client.menuTargets[amount].length() > 0 ? Client.menuOptions[amount] + " " + Client.menuTargets[amount] : Client.menuOptions[amount]);
   }

}
