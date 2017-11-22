public class ChatLineBuffer {

   static int[] anIntArray1;
   MessageNode[] lines;
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   MessageNode addMessage(int int_0, String string_0, String string_1, String string_2) {
      MessageNode messagenode_0 = this.lines[99];

      for (int int_1 = this.length; int_1 > 0; --int_1) {
         if (int_1 != 100) {
            this.lines[int_1] = this.lines[int_1 - 1];
         }
      }

      if (messagenode_0 == null) {
         messagenode_0 = new MessageNode(int_0, string_0, string_2, string_1);
      } else {
         messagenode_0.unlink();
         messagenode_0.unlinkDual();
         messagenode_0.setMessage(int_0, string_0, string_2, string_1);
      }

      this.lines[0] = messagenode_0;
      if (this.length < 100) {
         ++this.length;
      }

      return messagenode_0;
   }

   MessageNode method11(int int_0) {
      return int_0 >= 0 && int_0 < this.length ? this.lines[int_0] : null;
   }

   int method12() {
      return this.length;
   }

   public static boolean method13(int int_0) {
      return (int_0 & 0x1) != 0;
   }

}
