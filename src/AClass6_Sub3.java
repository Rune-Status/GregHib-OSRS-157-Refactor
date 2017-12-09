public class AClass6_Sub3 extends AClass6 {

    int[] anIntArray88;
    int anInt469;
    int anInt470;
    HashTable aHashTable8;
    int[] anIntArray89;
    int[] anIntArray90;
    int[] anIntArray91;
    int[] anIntArray92;
    Node_Sub4[][] aNode_Sub4ArrayArray1;
    int[] anIntArray93;
    Class82 aClass82_1;
    AClass6_Sub4 anAClass6_Sub4_1;
    int anInt471;
    int[] anIntArray94;
    int[] anIntArray95;
    int[] anIntArray96;
    int[] anIntArray97;
    long aLong24;
    int[] anIntArray98;
    int anInt472;
    boolean aBool62;
    Node_Sub4[][] aNode_Sub4ArrayArray2;
    int[] anIntArray99;
    int[] anIntArray100;
    long aLong25;
    int[] anIntArray101;
    int[] anIntArray102;

    public AClass6_Sub3() {
        this.anInt470 = 256;
        this.anInt472 = 1000000;
        this.anIntArray95 = new int[16];
        this.anIntArray90 = new int[16];
        this.anIntArray94 = new int[16];
        this.anIntArray92 = new int[16];
        this.anIntArray91 = new int[16];
        this.anIntArray97 = new int[16];
        this.anIntArray89 = new int[16];
        this.anIntArray101 = new int[16];
        this.anIntArray100 = new int[16];
        this.anIntArray93 = new int[16];
        this.anIntArray102 = new int[16];
        this.anIntArray99 = new int[16];
        this.anIntArray98 = new int[16];
        this.anIntArray88 = new int[16];
        this.anIntArray96 = new int[16];
        this.aNode_Sub4ArrayArray1 = new Node_Sub4[16][128];
        this.aNode_Sub4ArrayArray2 = new Node_Sub4[16][128];
        this.aClass82_1 = new Class82();
        this.anAClass6_Sub4_1 = new AClass6_Sub4(this);
        this.aHashTable8 = new HashTable(128);
        this.method840();
    }

    void method833(int int_0, int int_1) {
        this.anIntArray92[int_0] = int_1;
        this.anIntArray97[int_0] = int_1 & 0xFFFFFF80;
        this.method841(int_0, int_1);
    }

    void method834(int int_0, int int_1) {
        Node_Sub4 node_sub4_0 = this.aNode_Sub4ArrayArray1[int_0][int_1];
        if (node_sub4_0 != null) {
            this.aNode_Sub4ArrayArray1[int_0][int_1] = null;
            if ((this.anIntArray93[int_0] & 0x2) != 0) {
                for (Node_Sub4 node_sub4_1 = (Node_Sub4) this.anAClass6_Sub4_1.aDeque6.getFront(); node_sub4_1 != null; node_sub4_1 = (Node_Sub4) this.anAClass6_Sub4_1.aDeque6.getNext()) {
                    if (node_sub4_1.anInt356 == node_sub4_0.anInt356 && node_sub4_1.anInt358 < 0 && node_sub4_1 != node_sub4_0) {
                        node_sub4_0.anInt358 = 0;
                        break;
                    }
                }
            } else {
                node_sub4_0.anInt358 = 0;
            }

        }
    }

    void method835(int int_0) {
        for (Node_Sub4 node_sub4_0 = (Node_Sub4) this.anAClass6_Sub4_1.aDeque6.getFront(); node_sub4_0 != null; node_sub4_0 = (Node_Sub4) this.anAClass6_Sub4_1.aDeque6.getNext()) {
            if (int_0 < 0 || node_sub4_0.anInt356 == int_0) {
                if (node_sub4_0.anAClass6_Sub2_3 != null) {
                    node_sub4_0.anAClass6_Sub2_3.method773(AbstractSoundSystem.sampleRate / 100);
                    if (node_sub4_0.anAClass6_Sub2_3.method775()) {
                        this.anAClass6_Sub4_1.anAClass6_Sub1_2.method757(node_sub4_0.anAClass6_Sub2_3);
                    }

                    node_sub4_0.method688();
                }

                if (node_sub4_0.anInt358 < 0) {
                    this.aNode_Sub4ArrayArray1[node_sub4_0.anInt356][node_sub4_0.anInt364] = null;
                }

                node_sub4_0.unlink();
            }
        }

    }

    public synchronized void method836() {
        this.aClass82_1.method478();
        this.method840();
    }

    void method837(int int_0) {
        if (int_0 >= 0) {
            this.anIntArray95[int_0] = 12800;
            this.anIntArray90[int_0] = 8192;
            this.anIntArray94[int_0] = 16383;
            this.anIntArray89[int_0] = 8192;
            this.anIntArray101[int_0] = 0;
            this.anIntArray100[int_0] = 8192;
            this.method847(int_0);
            this.method850(int_0);
            this.anIntArray93[int_0] = 0;
            this.anIntArray102[int_0] = 32767;
            this.anIntArray99[int_0] = 256;
            this.anIntArray98[int_0] = 0;
            this.method857(int_0, 8192);
        } else {
            for (int_0 = 0; int_0 < 16; int_0++) {
                this.method837(int_0);
            }

        }
    }

    void method838(int int_0, int int_1, int int_2) {
        this.method834(int_0, int_1);
        if ((this.anIntArray93[int_0] & 0x2) != 0) {
            for (Node_Sub4 node_sub4_0 = (Node_Sub4) this.anAClass6_Sub4_1.aDeque6.getTail(); node_sub4_0 != null; node_sub4_0 = (Node_Sub4) this.anAClass6_Sub4_1.aDeque6.getPrevious()) {
                if (node_sub4_0.anInt356 == int_0 && node_sub4_0.anInt358 < 0) {
                    this.aNode_Sub4ArrayArray1[int_0][node_sub4_0.anInt364] = null;
                    this.aNode_Sub4ArrayArray1[int_0][int_1] = node_sub4_0;
                    int int_3 = (node_sub4_0.anInt357 * node_sub4_0.anInt355 >> 12) + node_sub4_0.anInt354;
                    node_sub4_0.anInt354 += int_1 - node_sub4_0.anInt364 << 8;
                    node_sub4_0.anInt355 = int_3 - node_sub4_0.anInt354;
                    node_sub4_0.anInt357 = 4096;
                    node_sub4_0.anInt364 = int_1;
                    return;
                }
            }
        }

        Node_Sub5 node_sub5_0 = (Node_Sub5) this.aHashTable8.get((long) this.anIntArray91[int_0]);
        if (node_sub5_0 != null) {
            AClass4_Sub1 aclass4_sub1_0 = node_sub5_0.anAClass4_Sub1Array1[int_1];
            if (aclass4_sub1_0 != null) {
                Node_Sub4 node_sub4_1 = new Node_Sub4();
                node_sub4_1.anInt356 = int_0;
                node_sub4_1.aNode_Sub5_1 = node_sub5_0;
                node_sub4_1.anAClass4_Sub1_1 = aclass4_sub1_0;
                node_sub4_1.aClass84_1 = node_sub5_0.aClass84Array1[int_1];
                node_sub4_1.anInt361 = node_sub5_0.aByteArray16[int_1];
                node_sub4_1.anInt364 = int_1;
                node_sub4_1.anInt362 = int_2 * int_2 * node_sub5_0.aByteArray14[int_1] * node_sub5_0.anInt372 + 1024 >> 11;
                node_sub4_1.anInt360 = node_sub5_0.aByteArray15[int_1] & 0xFF;
                node_sub4_1.anInt354 = (int_1 << 8) - (node_sub5_0.aShortArray5[int_1] & 0x7FFF);
                node_sub4_1.anInt366 = 0;
                node_sub4_1.anInt368 = 0;
                node_sub4_1.anInt369 = 0;
                node_sub4_1.anInt358 = -1;
                node_sub4_1.anInt370 = 0;
                if (this.anIntArray98[int_0] == 0) {
                    node_sub4_1.anAClass6_Sub2_3 = AClass6_Sub2.method803(aclass4_sub1_0, this.method844(node_sub4_1), this.method860(node_sub4_1), this.method861(node_sub4_1));
                } else {
                    node_sub4_1.anAClass6_Sub2_3 = AClass6_Sub2.method803(aclass4_sub1_0, this.method844(node_sub4_1), 0, this.method861(node_sub4_1));
                    this.method859(node_sub4_1, node_sub5_0.aShortArray5[int_1] < 0);
                }

                if (node_sub5_0.aShortArray5[int_1] < 0) {
                    node_sub4_1.anAClass6_Sub2_3.method782(-1);
                }

                if (node_sub4_1.anInt361 >= 0) {
                    Node_Sub4 node_sub4_2 = this.aNode_Sub4ArrayArray2[int_0][node_sub4_1.anInt361];
                    if (node_sub4_2 != null && node_sub4_2.anInt358 < 0) {
                        this.aNode_Sub4ArrayArray1[int_0][node_sub4_2.anInt364] = null;
                        node_sub4_2.anInt358 = 0;
                    }

                    this.aNode_Sub4ArrayArray2[int_0][node_sub4_1.anInt361] = node_sub4_1;
                }

                this.anAClass6_Sub4_1.aDeque6.addFront(node_sub4_1);
                this.aNode_Sub4ArrayArray1[int_0][int_1] = node_sub4_1;
            }
        }
    }

    void method839() {
    }

    void method840() {
        this.method835(-1);
        this.method837(-1);

        int int_0;
        for (int_0 = 0; int_0 < 16; int_0++) {
            this.anIntArray91[int_0] = this.anIntArray92[int_0];
        }

        for (int_0 = 0; int_0 < 16; int_0++) {
            this.anIntArray97[int_0] = this.anIntArray92[int_0] & 0xFFFFFF80;
        }

    }

    void method841(int int_0, int int_1) {
        if (int_1 != this.anIntArray91[int_0]) {
            this.anIntArray91[int_0] = int_1;

            for (int int_2 = 0; int_2 < 128; int_2++) {
                this.aNode_Sub4ArrayArray2[int_0][int_2] = null;
            }
        }

    }

    protected synchronized void method656(int[] ints_0, int int_0, int int_1) {
        if (this.aClass82_1.method479()) {
            int int_2 = this.aClass82_1.anInt180 * this.anInt472 / AbstractSoundSystem.sampleRate;

            do {
                long long_0 = this.aLong25 + (long) int_1 * (long) int_2;
                if (this.aLong24 - long_0 >= 0L) {
                    this.aLong25 = long_0;
                    break;
                }

                int int_3 = (int) ((this.aLong24 - this.aLong25 + (long) int_2 - 1L) / (long) int_2);
                this.aLong25 += (long) int_3 * (long) int_2;
                this.anAClass6_Sub4_1.method656(ints_0, int_0, int_3);
                int_0 += int_3;
                int_1 -= int_3;
                this.method858();
            } while (this.aClass82_1.method479());
        }

        this.anAClass6_Sub4_1.method656(ints_0, int_0, int_1);
    }

    protected synchronized void method657(int int_0) {
        if (this.aClass82_1.method479()) {
            int int_1 = this.aClass82_1.anInt180 * this.anInt472 / AbstractSoundSystem.sampleRate;

            do {
                long long_0 = this.aLong25 + (long) int_0 * (long) int_1;
                if (this.aLong24 - long_0 >= 0L) {
                    this.aLong25 = long_0;
                    break;
                }

                int int_2 = (int) (((long) int_1 + (this.aLong24 - this.aLong25) - 1L) / (long) int_1);
                this.aLong25 += (long) int_1 * (long) int_2;
                this.anAClass6_Sub4_1.method657(int_2);
                int_0 -= int_2;
                this.method858();
            } while (this.aClass82_1.method479());
        }

        this.anAClass6_Sub4_1.method657(int_0);
    }

    void method842() {
    }

    void method843(int int_0, int int_1) {
        this.anIntArray89[int_0] = int_1;
    }

    int method844(Node_Sub4 node_sub4_0) {
        int int_0 = (node_sub4_0.anInt355 * node_sub4_0.anInt357 >> 12) + node_sub4_0.anInt354;
        int_0 += (this.anIntArray89[node_sub4_0.anInt356] - 8192) * this.anIntArray99[node_sub4_0.anInt356] >> 12;
        Class84 class84_0 = node_sub4_0.aClass84_1;
        int int_1;
        if (class84_0.anInt182 > 0 && (class84_0.anInt184 > 0 || this.anIntArray101[node_sub4_0.anInt356] > 0)) {
            int_1 = class84_0.anInt184 << 2;
            int int_2 = class84_0.anInt185 << 1;
            if (node_sub4_0.anInt365 < int_2) {
                int_1 = int_1 * node_sub4_0.anInt365 / int_2;
            }

            int_1 += this.anIntArray101[node_sub4_0.anInt356] >> 7;
            double double_0 = Math.sin(0.01227184630308513D * (double) (node_sub4_0.anInt367 & 0x1FF));
            int_0 += (int) (double_0 * (double) int_1);
        }

        int_1 = (int) ((double) (node_sub4_0.anAClass4_Sub1_1.anInt417 * 256) * Math.pow(2.0D, (double) int_0 * 3.255208333333333E-4D) / (double) AbstractSoundSystem.sampleRate + 0.5D);
        return int_1 < 1 ? 1 : int_1;
    }

    protected synchronized AClass6 method659() {
        return null;
    }

    public synchronized boolean method845(Track1 track1_0, IndexDataBase indexdatabase_0, Class52 class52_0, int int_0) {
        track1_0.method739();
        boolean bool_0 = true;
        int[] ints_0 = null;
        if (int_0 > 0) {
            ints_0 = new int[]{int_0};
        }

        for (Node_Sub3 node_sub3_0 = (Node_Sub3) track1_0.aHashTable7.method67(); node_sub3_0 != null; node_sub3_0 = (Node_Sub3) track1_0.aHashTable7.method68()) {
            int int_1 = (int) node_sub3_0.hash;
            Node_Sub5 node_sub5_0 = (Node_Sub5) this.aHashTable8.get((long) int_1);
            if (node_sub5_0 == null) {
                byte[] bytes_0 = indexdatabase_0.method432(int_1);
                Node_Sub5 node_sub5_1;
                if (bytes_0 == null) {
                    node_sub5_1 = null;
                } else {
                    node_sub5_1 = new Node_Sub5(bytes_0);
                }

                node_sub5_0 = node_sub5_1;
                if (node_sub5_1 == null) {
                    bool_0 = false;
                    continue;
                }

                this.aHashTable8.put(node_sub5_1, (long) int_1);
            }

            if (!node_sub5_0.method693(class52_0, node_sub3_0.aByteArray13, ints_0)) {
                bool_0 = false;
            }
        }

        if (bool_0) {
            track1_0.method740();
        }

        return bool_0;
    }

    boolean method846(Node_Sub4 node_sub4_0) {
        if (node_sub4_0.anAClass6_Sub2_3 == null) {
            if (node_sub4_0.anInt358 >= 0) {
                node_sub4_0.unlink();
                if (node_sub4_0.anInt361 > 0 && node_sub4_0 == this.aNode_Sub4ArrayArray2[node_sub4_0.anInt356][node_sub4_0.anInt361]) {
                    this.aNode_Sub4ArrayArray2[node_sub4_0.anInt356][node_sub4_0.anInt361] = null;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    void method847(int int_0) {
        if ((this.anIntArray93[int_0] & 0x2) != 0) {
            for (Node_Sub4 node_sub4_0 = (Node_Sub4) this.anAClass6_Sub4_1.aDeque6.getFront(); node_sub4_0 != null; node_sub4_0 = (Node_Sub4) this.anAClass6_Sub4_1.aDeque6.getNext()) {
                if (node_sub4_0.anInt356 == int_0 && this.aNode_Sub4ArrayArray1[int_0][node_sub4_0.anInt364] == null && node_sub4_0.anInt358 < 0) {
                    node_sub4_0.anInt358 = 0;
                }
            }
        }

    }

    int method848() {
        return this.anInt470;
    }

    public synchronized void method849() {
        for (Node_Sub5 node_sub5_0 = (Node_Sub5) this.aHashTable8.method67(); node_sub5_0 != null; node_sub5_0 = (Node_Sub5) this.aHashTable8.method68()) {
            node_sub5_0.method692();
        }

    }

    void method850(int int_0) {
        if ((this.anIntArray93[int_0] & 0x4) != 0) {
            for (Node_Sub4 node_sub4_0 = (Node_Sub4) this.anAClass6_Sub4_1.aDeque6.getFront(); node_sub4_0 != null; node_sub4_0 = (Node_Sub4) this.anAClass6_Sub4_1.aDeque6.getNext()) {
                if (node_sub4_0.anInt356 == int_0) {
                    node_sub4_0.anInt363 = 0;
                }
            }
        }

    }

    void method851(int int_0) {
        int int_1 = int_0 & 0xF0;
        int int_2;
        int int_3;
        int int_4;
        if (int_1 == 128) {
            int_2 = int_0 & 0xF;
            int_3 = int_0 >> 8 & 0x7F;
            int_4 = int_0 >> 16 & 0x7F;
            this.method834(int_2, int_3);
        } else if (int_1 == 144) {
            int_2 = int_0 & 0xF;
            int_3 = int_0 >> 8 & 0x7F;
            int_4 = int_0 >> 16 & 0x7F;
            if (int_4 > 0) {
                this.method838(int_2, int_3, int_4);
            } else {
                this.method834(int_2, int_3);
            }

        } else if (int_1 == 160) {
            int_2 = int_0 & 0xF;
            int_3 = int_0 >> 8 & 0x7F;
            int_4 = int_0 >> 16 & 0x7F;
            this.method839();
        } else if (int_1 == 176) {
            int_2 = int_0 & 0xF;
            int_3 = int_0 >> 8 & 0x7F;
            int_4 = int_0 >> 16 & 0x7F;
            if (int_3 == 0) {
                this.anIntArray97[int_2] = (int_4 << 14) + (this.anIntArray97[int_2] & 0xFFE03FFF);
            }

            if (int_3 == 32) {
                this.anIntArray97[int_2] = (int_4 << 7) + (this.anIntArray97[int_2] & 0xFFFFC07F);
            }

            if (int_3 == 1) {
                this.anIntArray101[int_2] = (int_4 << 7) + (this.anIntArray101[int_2] & 0xFFFFC07F);
            }

            if (int_3 == 33) {
                this.anIntArray101[int_2] = int_4 + (this.anIntArray101[int_2] & 0xFFFFFF80);
            }

            if (int_3 == 5) {
                this.anIntArray100[int_2] = (int_4 << 7) + (this.anIntArray100[int_2] & 0xFFFFC07F);
            }

            if (int_3 == 37) {
                this.anIntArray100[int_2] = int_4 + (this.anIntArray100[int_2] & 0xFFFFFF80);
            }

            if (int_3 == 7) {
                this.anIntArray95[int_2] = (int_4 << 7) + (this.anIntArray95[int_2] & 0xFFFFC07F);
            }

            if (int_3 == 39) {
                this.anIntArray95[int_2] = int_4 + (this.anIntArray95[int_2] & 0xFFFFFF80);
            }

            if (int_3 == 10) {
                this.anIntArray90[int_2] = (int_4 << 7) + (this.anIntArray90[int_2] & 0xFFFFC07F);
            }

            if (int_3 == 42) {
                this.anIntArray90[int_2] = int_4 + (this.anIntArray90[int_2] & 0xFFFFFF80);
            }

            if (int_3 == 11) {
                this.anIntArray94[int_2] = (int_4 << 7) + (this.anIntArray94[int_2] & 0xFFFFC07F);
            }

            if (int_3 == 43) {
                this.anIntArray94[int_2] = int_4 + (this.anIntArray94[int_2] & 0xFFFFFF80);
            }

            if (int_3 == 64) {
                if (int_4 >= 64) {
                    this.anIntArray93[int_2] |= 0x1;
                } else {
                    this.anIntArray93[int_2] &= 0xFFFFFFFE;
                }
            }

            if (int_3 == 65) {
                if (int_4 >= 64) {
                    this.anIntArray93[int_2] |= 0x2;
                } else {
                    this.method847(int_2);
                    this.anIntArray93[int_2] &= 0xFFFFFFFD;
                }
            }

            if (int_3 == 99) {
                this.anIntArray102[int_2] = (int_4 << 7) + (this.anIntArray102[int_2] & 0x7F);
            }

            if (int_3 == 98) {
                this.anIntArray102[int_2] = (this.anIntArray102[int_2] & 0x3F80) + int_4;
            }

            if (int_3 == 101) {
                this.anIntArray102[int_2] = (int_4 << 7) + (this.anIntArray102[int_2] & 0x7F) + 16384;
            }

            if (int_3 == 100) {
                this.anIntArray102[int_2] = (this.anIntArray102[int_2] & 0x3F80) + int_4 + 16384;
            }

            if (int_3 == 120) {
                this.method835(int_2);
            }

            if (int_3 == 121) {
                this.method837(int_2);
            }

            if (int_3 == 123) {
                this.method863(int_2);
            }

            int int_5;
            if (int_3 == 6) {
                int_5 = this.anIntArray102[int_2];
                if (int_5 == 16384) {
                    this.anIntArray99[int_2] = (int_4 << 7) + (this.anIntArray99[int_2] & 0xFFFFC07F);
                }
            }

            if (int_3 == 38) {
                int_5 = this.anIntArray102[int_2];
                if (int_5 == 16384) {
                    this.anIntArray99[int_2] = int_4 + (this.anIntArray99[int_2] & 0xFFFFFF80);
                }
            }

            if (int_3 == 16) {
                this.anIntArray98[int_2] = (int_4 << 7) + (this.anIntArray98[int_2] & 0xFFFFC07F);
            }

            if (int_3 == 48) {
                this.anIntArray98[int_2] = int_4 + (this.anIntArray98[int_2] & 0xFFFFFF80);
            }

            if (int_3 == 81) {
                if (int_4 >= 64) {
                    this.anIntArray93[int_2] |= 0x4;
                } else {
                    this.method850(int_2);
                    this.anIntArray93[int_2] &= 0xFFFFFFFB;
                }
            }

            if (int_3 == 17) {
                this.method857(int_2, (int_4 << 7) + (this.anIntArray88[int_2] & 0xFFFFC07F));
            }

            if (int_3 == 49) {
                this.method857(int_2, int_4 + (this.anIntArray88[int_2] & 0xFFFFFF80));
            }

        } else if (int_1 == 192) {
            int_2 = int_0 & 0xF;
            int_3 = int_0 >> 8 & 0x7F;
            this.method841(int_2, int_3 + this.anIntArray97[int_2]);
        } else if (int_1 == 208) {
            int_2 = int_0 & 0xF;
            int_3 = int_0 >> 8 & 0x7F;
            this.method842();
        } else if (int_1 == 224) {
            int_2 = int_0 & 0xF;
            int_3 = (int_0 >> 8 & 0x7F) + (int_0 >> 9 & 0x3F80);
            this.method843(int_2, int_3);
        } else {
            int_1 = int_0 & 0xFF;
            if (int_1 == 255) {
                this.method840();
            }
        }
    }

    public synchronized boolean method852() {
        return this.aClass82_1.method479();
    }

    public synchronized void method853(int int_0) {
        this.anInt470 = int_0;
    }

    synchronized void method854() {
        for (Node_Sub5 node_sub5_0 = (Node_Sub5) this.aHashTable8.method67(); node_sub5_0 != null; node_sub5_0 = (Node_Sub5) this.aHashTable8.method68()) {
            node_sub5_0.unlink();
        }

    }

    public synchronized void method855(Track1 track1_0, boolean bool_0) {
        this.method836();
        this.aClass82_1.method480(track1_0.aByteArray17);
        this.aBool62 = bool_0;
        this.aLong25 = 0L;
        int int_0 = this.aClass82_1.method483();

        for (int int_1 = 0; int_1 < int_0; int_1++) {
            this.aClass82_1.method481(int_1);
            this.aClass82_1.method485(int_1);
            this.aClass82_1.method489(int_1);
        }

        this.anInt469 = this.aClass82_1.method482();
        this.anInt471 = this.aClass82_1.anIntArray43[this.anInt469];
        this.aLong24 = this.aClass82_1.method487(this.anInt471);
    }

    boolean method856(Node_Sub4 node_sub4_0, int[] ints_0, int int_0, int int_1) {
        node_sub4_0.anInt359 = AbstractSoundSystem.sampleRate / 100;
        if (node_sub4_0.anInt358 < 0 || node_sub4_0.anAClass6_Sub2_3 != null && !node_sub4_0.anAClass6_Sub2_3.method771()) {
            int int_2 = node_sub4_0.anInt357;
            if (int_2 > 0) {
                int_2 -= (int) (16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double) this.anIntArray100[node_sub4_0.anInt356]) + 0.5D);
                if (int_2 < 0) {
                    int_2 = 0;
                }

                node_sub4_0.anInt357 = int_2;
            }

            node_sub4_0.anAClass6_Sub2_3.method772(this.method844(node_sub4_0));
            Class84 class84_0 = node_sub4_0.aClass84_1;
            boolean bool_0 = false;
            ++node_sub4_0.anInt365;
            node_sub4_0.anInt367 += class84_0.anInt182;
            double double_0 = 5.086263020833333E-6D * (double) ((node_sub4_0.anInt364 - 60 << 8) + (node_sub4_0.anInt355 * node_sub4_0.anInt357 >> 12));
            if (class84_0.anInt183 > 0) {
                if (class84_0.anInt186 > 0) {
                    node_sub4_0.anInt366 += (int) (128.0D * Math.pow(2.0D, double_0 * (double) class84_0.anInt186) + 0.5D);
                } else {
                    node_sub4_0.anInt366 += 128;
                }
            }

            if (class84_0.aByteArray9 != null) {
                if (class84_0.anInt187 > 0) {
                    node_sub4_0.anInt368 += (int) (128.0D * Math.pow(2.0D, double_0 * (double) class84_0.anInt187) + 0.5D);
                } else {
                    node_sub4_0.anInt368 += 128;
                }

                while (node_sub4_0.anInt369 < class84_0.aByteArray9.length - 2 && node_sub4_0.anInt368 > (class84_0.aByteArray9[node_sub4_0.anInt369 + 2] & 0xFF) << 8) {
                    node_sub4_0.anInt369 += 2;
                }

                if (class84_0.aByteArray9.length - 2 == node_sub4_0.anInt369 && class84_0.aByteArray9[node_sub4_0.anInt369 + 1] == 0) {
                    bool_0 = true;
                }
            }

            if (node_sub4_0.anInt358 >= 0 && class84_0.aByteArray10 != null && (this.anIntArray93[node_sub4_0.anInt356] & 0x1) == 0 && (node_sub4_0.anInt361 < 0 || node_sub4_0 != this.aNode_Sub4ArrayArray2[node_sub4_0.anInt356][node_sub4_0.anInt361])) {
                if (class84_0.anInt188 > 0) {
                    node_sub4_0.anInt358 += (int) (128.0D * Math.pow(2.0D, double_0 * (double) class84_0.anInt188) + 0.5D);
                } else {
                    node_sub4_0.anInt358 += 128;
                }

                while (node_sub4_0.anInt370 < class84_0.aByteArray10.length - 2 && node_sub4_0.anInt358 > (class84_0.aByteArray10[node_sub4_0.anInt370 + 2] & 0xFF) << 8) {
                    node_sub4_0.anInt370 += 2;
                }

                if (class84_0.aByteArray10.length - 2 == node_sub4_0.anInt370) {
                    bool_0 = true;
                }
            }

            if (bool_0) {
                node_sub4_0.anAClass6_Sub2_3.method773(node_sub4_0.anInt359);
                if (ints_0 != null) {
                    node_sub4_0.anAClass6_Sub2_3.method656(ints_0, int_0, int_1);
                } else {
                    node_sub4_0.anAClass6_Sub2_3.method657(int_1);
                }

                if (node_sub4_0.anAClass6_Sub2_3.method775()) {
                    this.anAClass6_Sub4_1.anAClass6_Sub1_2.method757(node_sub4_0.anAClass6_Sub2_3);
                }

                node_sub4_0.method688();
                if (node_sub4_0.anInt358 >= 0) {
                    node_sub4_0.unlink();
                    if (node_sub4_0.anInt361 > 0 && node_sub4_0 == this.aNode_Sub4ArrayArray2[node_sub4_0.anInt356][node_sub4_0.anInt361]) {
                        this.aNode_Sub4ArrayArray2[node_sub4_0.anInt356][node_sub4_0.anInt361] = null;
                    }
                }

                return true;
            } else {
                node_sub4_0.anAClass6_Sub2_3.method768(node_sub4_0.anInt359, this.method860(node_sub4_0), this.method861(node_sub4_0));
                return false;
            }
        } else {
            node_sub4_0.method688();
            node_sub4_0.unlink();
            if (node_sub4_0.anInt361 > 0 && node_sub4_0 == this.aNode_Sub4ArrayArray2[node_sub4_0.anInt356][node_sub4_0.anInt361]) {
                this.aNode_Sub4ArrayArray2[node_sub4_0.anInt356][node_sub4_0.anInt361] = null;
            }

            return true;
        }
    }

    void method857(int int_0, int int_1) {
        this.anIntArray88[int_0] = int_1;
        this.anIntArray96[int_0] = (int) (2097152.0D * Math.pow(2.0D, (double) int_1 * 5.4931640625E-4D) + 0.5D);
    }

    protected synchronized AClass6 method660() {
        return this.anAClass6_Sub4_1;
    }

    void method858() {
        int int_0 = this.anInt469;
        int int_1 = this.anInt471;

        long long_0;
        for (long_0 = this.aLong24; int_1 == this.anInt471; long_0 = this.aClass82_1.method487(int_1)) {
            while (int_1 == this.aClass82_1.anIntArray43[int_0]) {
                this.aClass82_1.method481(int_0);
                int int_2 = this.aClass82_1.method484(int_0);
                if (int_2 == 1) {
                    this.aClass82_1.method488();
                    this.aClass82_1.method489(int_0);
                    if (this.aClass82_1.method490()) {
                        if (!this.aBool62 || int_1 == 0) {
                            this.method840();
                            this.aClass82_1.method478();
                            return;
                        }

                        this.aClass82_1.method491(long_0);
                    }
                    break;
                }

                if ((int_2 & 0x80) != 0) {
                    this.method851(int_2);
                }

                this.aClass82_1.method485(int_0);
                this.aClass82_1.method489(int_0);
            }

            int_0 = this.aClass82_1.method482();
            int_1 = this.aClass82_1.anIntArray43[int_0];
        }

        this.anInt469 = int_0;
        this.anInt471 = int_1;
        this.aLong24 = long_0;
    }

    void method859(Node_Sub4 node_sub4_0, boolean bool_0) {
        int int_0 = node_sub4_0.anAClass4_Sub1_1.aByteArray18.length;
        int int_2;
        if (bool_0 && node_sub4_0.anAClass4_Sub1_1.aBool57) {
            int int_1 = int_0 + int_0 - node_sub4_0.anAClass4_Sub1_1.anInt418;
            int_2 = (int) ((long) this.anIntArray98[node_sub4_0.anInt356] * (long) int_1 >> 6);
            int_0 <<= 8;
            if (int_2 >= int_0) {
                int_2 = int_0 + int_0 - 1 - int_2;
                node_sub4_0.anAClass6_Sub2_3.method776();
            }
        } else {
            int_2 = (int) ((long) int_0 * (long) this.anIntArray98[node_sub4_0.anInt356] >> 6);
        }

        node_sub4_0.anAClass6_Sub2_3.method770(int_2);
    }

    protected synchronized int method662() {
        return 0;
    }

    int method860(Node_Sub4 node_sub4_0) {
        Class84 class84_0 = node_sub4_0.aClass84_1;
        int int_0 = this.anIntArray94[node_sub4_0.anInt356] * this.anIntArray95[node_sub4_0.anInt356] + 4096 >> 13;
        int_0 = int_0 * int_0 + 16384 >> 15;
        int_0 = int_0 * node_sub4_0.anInt362 + 16384 >> 15;
        int_0 = int_0 * this.anInt470 + 128 >> 8;
        if (class84_0.anInt183 > 0) {
            int_0 = (int) ((double) int_0 * Math.pow(0.5D, (double) class84_0.anInt183 * (double) node_sub4_0.anInt366 * 1.953125E-5D) + 0.5D);
        }

        int int_1;
        int int_2;
        int int_3;
        int int_4;
        if (class84_0.aByteArray9 != null) {
            int_1 = node_sub4_0.anInt368;
            int_2 = class84_0.aByteArray9[node_sub4_0.anInt369 + 1];
            if (node_sub4_0.anInt369 < class84_0.aByteArray9.length - 2) {
                int_3 = (class84_0.aByteArray9[node_sub4_0.anInt369] & 0xFF) << 8;
                int_4 = (class84_0.aByteArray9[node_sub4_0.anInt369 + 2] & 0xFF) << 8;
                int_2 += (int_1 - int_3) * (class84_0.aByteArray9[node_sub4_0.anInt369 + 3] - int_2) / (int_4 - int_3);
            }

            int_0 = int_0 * int_2 + 32 >> 6;
        }

        if (node_sub4_0.anInt358 > 0 && class84_0.aByteArray10 != null) {
            int_1 = node_sub4_0.anInt358;
            int_2 = class84_0.aByteArray10[node_sub4_0.anInt370 + 1];
            if (node_sub4_0.anInt370 < class84_0.aByteArray10.length - 2) {
                int_3 = (class84_0.aByteArray10[node_sub4_0.anInt370] & 0xFF) << 8;
                int_4 = (class84_0.aByteArray10[node_sub4_0.anInt370 + 2] & 0xFF) << 8;
                int_2 += (int_1 - int_3) * (class84_0.aByteArray10[node_sub4_0.anInt370 + 3] - int_2) / (int_4 - int_3);
            }

            int_0 = int_2 * int_0 + 32 >> 6;
        }

        return int_0;
    }

    int method861(Node_Sub4 node_sub4_0) {
        int int_0 = this.anIntArray90[node_sub4_0.anInt356];
        return int_0 < 8192 ? int_0 * node_sub4_0.anInt360 + 32 >> 6 : 16384 - ((128 - node_sub4_0.anInt360) * (16384 - int_0) + 32 >> 6);
    }

    public synchronized void method862(int int_0, int int_1) {
        this.method833(int_0, int_1);
    }

    void method863(int int_0) {
        for (Node_Sub4 node_sub4_0 = (Node_Sub4) this.anAClass6_Sub4_1.aDeque6.getFront(); node_sub4_0 != null; node_sub4_0 = (Node_Sub4) this.anAClass6_Sub4_1.aDeque6.getNext()) {
            if ((int_0 < 0 || node_sub4_0.anInt356 == int_0) && node_sub4_0.anInt358 < 0) {
                this.aNode_Sub4ArrayArray1[node_sub4_0.anInt356][node_sub4_0.anInt364] = null;
                node_sub4_0.anInt358 = 0;
            }
        }

    }

    static void method864() {
        for (int index = 0; index < Client.npcIndexesCount; index++) {
            int npcIndex = Client.npcIndices[index];
            NPC npc = Client.cachedNPCs[npcIndex];
            if (npc != null) {
                int int_2 = npc.composition.boundaryDimension;
                ServerPacket.method355(npc);
            }
        }
    }

}
