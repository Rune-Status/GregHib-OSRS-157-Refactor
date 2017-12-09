public class IdentityKitDefinition extends CacheableNode {

    public static int count;
    static NodeCache identityKitCache;
    public static IndexDataBase identityKitModelCacheIndex;
    public static IndexDataBase identityKitCacheIndex;
    int[] modelIds;
    int[] headModels;
    public int bodyPartId;
    short[] recolorToFind;
    public boolean interfaceDisplayed;
    short[] retextureToFind;
    short[] recolorToReplace;
    short[] retextureToReplace;

    static {
        identityKitCache = new NodeCache(64);
    }

    IdentityKitDefinition() {
        this.bodyPartId = -1;
        this.headModels = new int[]{-1, -1, -1, -1, -1};
        this.interfaceDisplayed = false;
    }

    public static IdentityKitDefinition getDefinition(int id) {
        IdentityKitDefinition definition = (IdentityKitDefinition) identityKitCache.get((long) id);
        if (definition != null) {
            return definition;
        } else {
            byte[] data = identityKitCacheIndex.getConfigData(3, id);
            definition = new IdentityKitDefinition();
            if (data != null) {
                definition.decode(new Buffer(data));
            }

            identityKitCache.put(definition, (long) id);
            return definition;
        }
    }

    void readValues(Buffer buffer, int opcode) {
        if (opcode == 1) {
            this.bodyPartId = buffer.getUnsignedByte();
        } else {
            int size;
            int index;
            if (opcode == 2) {
                size = buffer.getUnsignedByte();
                this.modelIds = new int[size];

                for (index = 0; index < size; index++) {
                    this.modelIds[index] = buffer.getUnsignedShort();
                }
            } else if (opcode == 3) {
                this.interfaceDisplayed = true;
            } else if (opcode == 40) {
                size = buffer.getUnsignedByte();
                this.recolorToFind = new short[size];
                this.recolorToReplace = new short[size];

                for (index = 0; index < size; index++) {
                    this.recolorToFind[index] = (short) buffer.getUnsignedShort();
                    this.recolorToReplace[index] = (short) buffer.getUnsignedShort();
                }
            } else if (opcode == 41) {
                size = buffer.getUnsignedByte();
                this.retextureToFind = new short[size];
                this.retextureToReplace = new short[size];

                for (index = 0; index < size; index++) {
                    this.retextureToFind[index] = (short) buffer.getUnsignedShort();
                    this.retextureToReplace[index] = (short) buffer.getUnsignedShort();
                }
            } else if (opcode >= 60 && opcode < 70) {
                this.headModels[opcode - 60] = buffer.getUnsignedShort();
            }
        }

    }

    public boolean headModelExists() {
        boolean exists = true;

        for (int index = 0; index < 5; index++) {
            if (this.headModels[index] != -1 && !identityKitModelCacheIndex.modelExists(this.headModels[index], 0)) {
                exists = false;
            }
        }

        return exists;
    }

    public ModelHeader getHeadModel() {
        ModelHeader[] models = new ModelHeader[5];
        int count = 0;

        for (int model = 0; model < 5; model++) {
            if (this.headModels[model] != -1) {
                models[count++] = ModelHeader.getModel(identityKitModelCacheIndex, this.headModels[model], 0);
            }
        }

        ModelHeader model = new ModelHeader(models, count);
        int colour;
        if (this.recolorToFind != null) {
            for (colour = 0; colour < this.recolorToFind.length; colour++) {
                model.recolor(this.recolorToFind[colour], this.recolorToReplace[colour]);
            }
        }

        if (this.retextureToFind != null) {
            for (colour = 0; colour < this.retextureToFind.length; colour++) {
                model.retexture(this.retextureToFind[colour], this.retextureToReplace[colour]);
            }
        }

        return model;
    }

    public boolean ready() {
        if (this.modelIds == null) {
            return true;
        } else {
            boolean exists = true;

            for (int model = 0; model < this.modelIds.length; model++) {
                if (!identityKitModelCacheIndex.modelExists(this.modelIds[model], 0)) {
                    exists = false;
                }
            }

            return exists;
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

    public ModelHeader getModel() {
        if (this.modelIds == null) {
            return null;
        } else {
            ModelHeader[] models = new ModelHeader[this.modelIds.length];

            for (int model = 0; model < this.modelIds.length; model++) {
                models[model] = ModelHeader.getModel(identityKitModelCacheIndex, this.modelIds[model], 0);
            }

            ModelHeader model;
            if (models.length == 1) {
                model = models[0];
            } else {
                model = new ModelHeader(models, models.length);
            }

            int colour;
            if (this.recolorToFind != null) {
                for (colour = 0; colour < this.recolorToFind.length; colour++) {
                    model.recolor(this.recolorToFind[colour], this.recolorToReplace[colour]);
                }
            }

            if (this.retextureToFind != null) {
                for (colour = 0; colour < this.retextureToFind.length; colour++) {
                    model.retexture(this.retextureToFind[colour], this.retextureToReplace[colour]);
                }
            }

            return model;
        }
    }

}
