public final class DState {

   final int anInt113;
   final int anInt114;
   final int anInt115;
   final int anInt116;
   final int anInt117;
   final int anInt118;
   int next_in;
   int next_out;
   int[] anIntArray24;
   int[] anIntArray25;
   boolean[] inUse;
   boolean[] aBoolArray2;
   byte[] seqToUnseq;
   byte[] aByteArray4;
   byte[] strm;
   int[] anIntArray26;
   byte[] aByteArray5;
   byte[] aByteArray6;
   byte[] out;
   byte[][] aByteArrayArray2;
   int[][] anIntArrayArray6;
   int[][] anIntArrayArray7;
   int[][] anIntArrayArray8;
   int anInt119;
   int[] anIntArray27;
   int total_in_lo32;
   int total_in_hi32;
   int total_out_lo32;
   int total_out_hi32;
   int blockSize100k;
   int anInt120;
   int nInUse;
   int out_len;
   byte out_ch;
   int tPos;
   int nblock_used;
   int k0;
   int anInt121;

   DState() {
      this.anInt113 = 4096;
      this.anInt114 = 16;
      this.anInt115 = 258;
      this.anInt116 = 6;
      this.anInt117 = 50;
      this.anInt118 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.anIntArray24 = new int[256];
      this.anIntArray25 = new int[257];
      this.inUse = new boolean[256];
      this.aBoolArray2 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.aByteArray4 = new byte[4096];
      this.anIntArray26 = new int[16];
      this.aByteArray5 = new byte[18002];
      this.aByteArray6 = new byte[18002];
      this.aByteArrayArray2 = new byte[6][258];
      this.anIntArrayArray6 = new int[6][258];
      this.anIntArrayArray7 = new int[6][258];
      this.anIntArrayArray8 = new int[6][258];
      this.anIntArray27 = new int[6];
   }

}
