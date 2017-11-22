public class Class70 {

    public static IndexDataBase anIndexDataBase3;

    public static KitDefinition getKitDefinition(int id) {
        KitDefinition kit = (KitDefinition) KitDefinition.identKits.get((long) id);
        if (kit != null) {
            return kit;
        } else {
            byte[] data = KitDefinition.identKit_ref.getConfigData(3, id);
            kit = new KitDefinition();
            if (data != null) {
                kit.decode(new Buffer(data));
            }

            KitDefinition.identKits.put(kit, (long) id);
            return kit;
        }
    }

    static char method420(char char_0) {
        return (char) (char_0 == 198 ? 'E' : (char_0 == 230 ? 'e' : (char_0 == 223 ? 's' : (char_0 == 338 ? 'E' : (char_0 == 339 ? 'e' : '\u0000')))));
    }

}
