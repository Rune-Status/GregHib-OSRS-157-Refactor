public class KitDefinition extends CacheableNode {

    static java.awt.Font aFont4;
    public static int count;
    static NodeCache identKits;
    public static IndexDataBase anIndexDataBase15;
    public static IndexDataBase identKit_ref;
    int[] modelIds;
    int[] models;
    public int bodyPartId;
    short[] recolorToFind;
    public boolean nonSelectable;
    short[] retextureToFind;
    short[] recolorToReplace;
    short[] retextureToReplace;

    static {
        identKits = new NodeCache(64);
    }

    KitDefinition() {
        this.bodyPartId = -1;
        this.models = new int[]{-1, -1, -1, -1, -1};
        this.nonSelectable = false;
    }

    void readValues(Buffer buffer, int opcode) {
        if (opcode == 1) {
            this.bodyPartId = buffer.getUnsignedByte();
        } else {
            int int_1;
            int int_2;
            if (opcode == 2) {
                int_1 = buffer.getUnsignedByte();
                this.modelIds = new int[int_1];

                for (int_2 = 0; int_2 < int_1; int_2++) {
                    this.modelIds[int_2] = buffer.getUnsignedShort();
                }
            } else if (opcode == 3) {
                this.nonSelectable = true;
            } else if (opcode == 40) {
                int_1 = buffer.getUnsignedByte();
                this.recolorToFind = new short[int_1];
                this.recolorToReplace = new short[int_1];

                for (int_2 = 0; int_2 < int_1; int_2++) {
                    this.recolorToFind[int_2] = (short) buffer.getUnsignedShort();
                    this.recolorToReplace[int_2] = (short) buffer.getUnsignedShort();
                }
            } else if (opcode == 41) {
                int_1 = buffer.getUnsignedByte();
                this.retextureToFind = new short[int_1];
                this.retextureToReplace = new short[int_1];

                for (int_2 = 0; int_2 < int_1; int_2++) {
                    this.retextureToFind[int_2] = (short) buffer.getUnsignedShort();
                    this.retextureToReplace[int_2] = (short) buffer.getUnsignedShort();
                }
            } else if (opcode >= 60 && opcode < 70) {
                this.models[opcode - 60] = buffer.getUnsignedShort();
            }
        }

    }

    public boolean method806() {
        boolean bool_0 = true;

        for (int int_0 = 0; int_0 < 5; int_0++) {
            if (this.models[int_0] != -1 && !anIndexDataBase15.modelExists(this.models[int_0], 0)) {
                bool_0 = false;
            }
        }

        return bool_0;
    }

    public ModelHeader method807() {
        ModelHeader[] modeldatas_0 = new ModelHeader[5];
        int int_0 = 0;

        for (int int_1 = 0; int_1 < 5; int_1++) {
            if (this.models[int_1] != -1) {
                modeldatas_0[int_0++] = ModelHeader.getModel(anIndexDataBase15, this.models[int_1], 0);
            }
        }

        ModelHeader modeldata_0 = new ModelHeader(modeldatas_0, int_0);
        int int_2;
        if (this.recolorToFind != null) {
            for (int_2 = 0; int_2 < this.recolorToFind.length; int_2++) {
                modeldata_0.recolor(this.recolorToFind[int_2], this.recolorToReplace[int_2]);
            }
        }

        if (this.retextureToFind != null) {
            for (int_2 = 0; int_2 < this.retextureToFind.length; int_2++) {
                modeldata_0.retexture(this.retextureToFind[int_2], this.retextureToReplace[int_2]);
            }
        }

        return modeldata_0;
    }

    public boolean ready() {
        if (this.modelIds == null) {
            return true;
        } else {
            boolean bool_0 = true;

            for (int int_0 = 0; int_0 < this.modelIds.length; int_0++) {
                if (!anIndexDataBase15.modelExists(this.modelIds[int_0], 0)) {
                    bool_0 = false;
                }
            }

            return bool_0;
        }
    }

    void decode(Buffer buffer) {
        while (true) {
            int opcode = buffer.getUnsignedByte();

            if (opcode == 0) {
                return;
            }

            this.readValues(buffer, opcode);
        }
    }

    public ModelHeader getModelData() {
        if (this.modelIds == null) {
            return null;
        } else {
            ModelHeader[] modeldatas_0 = new ModelHeader[this.modelIds.length];

            for (int int_0 = 0; int_0 < this.modelIds.length; int_0++) {
                modeldatas_0[int_0] = ModelHeader.getModel(anIndexDataBase15, this.modelIds[int_0], 0);
            }

            ModelHeader modeldata_0;
            if (modeldatas_0.length == 1) {
                modeldata_0 = modeldatas_0[0];
            } else {
                modeldata_0 = new ModelHeader(modeldatas_0, modeldatas_0.length);
            }

            int int_1;
            if (this.recolorToFind != null) {
                for (int_1 = 0; int_1 < this.recolorToFind.length; int_1++) {
                    modeldata_0.recolor(this.recolorToFind[int_1], this.recolorToReplace[int_1]);
                }
            }

            if (this.retextureToFind != null) {
                for (int_1 = 0; int_1 < this.retextureToFind.length; int_1++) {
                    modeldata_0.retexture(this.retextureToFind[int_1], this.retextureToReplace[int_1]);
                }
            }

            return modeldata_0;
        }
    }

}
