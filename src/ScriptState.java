public class ScriptState {

   static long aLong21;
   int invokedFromPc;
   Script invokedFromScript;
   int[] savedLocalInts;
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }

}
