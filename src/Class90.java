public class Class90 implements Interface5 {

   public static final Class90 aClass90_1;
   public static final Class90 aClass90_2;
   public static final Class90 aClass90_3;
   public static final Class90 aClass90_4;
   public static final Class90 aClass90_5;
   public static final Class90 aClass90_6;
   public static final Class90 aClass90_7;
   public static final Class90 aClass90_8;
   public static final Class90 aClass90_9;
   static final Class90 aClass90_10;
   public final int anInt190;

   static {
      aClass90_1 = new Class90("", 10);
      aClass90_3 = new Class90("", 11);
      aClass90_5 = new Class90("", 12);
      aClass90_4 = new Class90("", 13);
      aClass90_6 = new Class90("", 14);
      aClass90_7 = new Class90("", 15, new ScriptVarType[] {ScriptVarType.aScriptVarType1, ScriptVarType.aScriptVarType1}, (ScriptVarType[]) null);
      aClass90_8 = new Class90("", 16, new ScriptVarType[] {ScriptVarType.aScriptVarType1, ScriptVarType.aScriptVarType1}, (ScriptVarType[]) null);
      aClass90_9 = new Class90("", 17, new ScriptVarType[] {ScriptVarType.aScriptVarType1, ScriptVarType.aScriptVarType1}, (ScriptVarType[]) null);
      aClass90_10 = new Class90("", 73, true, true);
      aClass90_2 = new Class90("", 76, true, false);
   }

   Class90(String string_0, int int_0) {
      this(string_0, int_0, false, (ScriptVarType[]) null, false, (ScriptVarType[]) null);
   }

   Class90(String string_0, int int_0, boolean bool_0, ScriptVarType[] scriptvartypes_0, boolean bool_1, ScriptVarType[] scriptvartypes_1) {
      this.anInt190 = int_0;
   }

   Class90(String string_0, int int_0, ScriptVarType[] scriptvartypes_0, ScriptVarType[] scriptvartypes_1) {
      this(string_0, int_0, scriptvartypes_0 != null, scriptvartypes_0, scriptvartypes_1 != null, scriptvartypes_1);
   }

   Class90(String string_0, int int_0, boolean bool_0, boolean bool_1) {
      this(string_0, int_0, bool_0, (ScriptVarType[]) null, bool_1, (ScriptVarType[]) null);
   }

   public int rsOrdinal() {
      return this.anInt190;
   }

   static String method498(int int_0) {
      String string_0 = Integer.toString(int_0);

      for (int int_1 = string_0.length() - 3; int_1 > 0; int_1 -= 3) {
         string_0 = string_0.substring(0, int_1) + "," + string_0.substring(int_1);
      }

      return string_0.length() > 9 ? " " + Wall.getColTags(65408) + string_0.substring(0, string_0.length() - 8) + "M" + " " + " (" + string_0 + ")" + "</col>" : (string_0.length() > 6 ? " " + Wall.getColTags(16777215) + string_0.substring(0, string_0.length() - 4) + "K" + " " + " (" + string_0 + ")" + "</col>" : " " + Wall.getColTags(16776960) + string_0 + "</col>");
   }

}
