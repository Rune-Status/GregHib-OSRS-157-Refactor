public class ChatLineBuffer {

   static int[] anIntArray1;
   MessageNode[] lines;
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   MessageNode addMessage(int type, String name, String text, String sender) {
      MessageNode message = this.lines[99];

      for (int index = this.length; index > 0; --index) {
         if (index != 100) {
            this.lines[index] = this.lines[index - 1];
         }
      }

      if (message == null) {
         message = new MessageNode(type, name, sender, text);
      } else {
         message.unlink();
         message.unlinkDual();
         message.setMessage(type, name, sender, text);
      }

      this.lines[0] = message;
      if (this.length < 100) {
         ++this.length;
      }

      return message;
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
