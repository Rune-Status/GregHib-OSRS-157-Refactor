import java.net.URL;

public final class AClass3_Sub1 extends AClass3 {

   public static boolean[] validInterfaces;
   static SpritePixels[] mapDots;
   static int anInt402;
   final int anInt403;
   final int anInt404;
   final int anInt405;
   final int anInt406;
   final int anInt407;

   AClass3_Sub1(int int_0, int int_1, int int_2, int int_3, int int_4) {
      this.anInt403 = int_0;
      this.anInt404 = int_1;
      this.anInt405 = int_2;
      this.anInt406 = int_3;
      this.anInt407 = int_4;
   }

   void method643() {
      Rasterizer2D.drawRectangle(this.anInt403 + Rasterizer2D.draw_region_x, this.anInt404 + Rasterizer2D.drawingAreaTop, this.anInt405 - this.anInt403, this.anInt406 - this.anInt404, this.anInt407);
   }

   static void method750(String string_0, String string_1, String string_2) {
      Class25.loginMessage1 = string_0;
      Class25.loginMessage2 = string_1;
      Class25.loginMessage3 = string_2;
   }

   static boolean loadWorlds() {
      try {
         if (AClass2_Sub1.listFetcher == null) {
            AClass2_Sub1.listFetcher = BuildType.aClass55_1.method353(new URL(AClass2_Sub1.aString18));
         } else if (AClass2_Sub1.listFetcher.method356()) {
            byte[] bytes_0 = AClass2_Sub1.listFetcher.method357();
            Buffer buffer_0 = new Buffer(bytes_0);
            buffer_0.readInt();
            World.worldCount = buffer_0.readUnsignedShort();
            Coordinates.worldList = new World[World.worldCount];

            World world_0;
            for (int int_0 = 0; int_0 < World.worldCount; world_0.index = int_0++) {
               world_0 = Coordinates.worldList[int_0] = new World();
               world_0.id = buffer_0.readUnsignedShort();
               world_0.mask = buffer_0.readInt();
               world_0.address = buffer_0.readString();
               world_0.activity = buffer_0.readString();
               world_0.location = buffer_0.readUnsignedByte();
               world_0.playerCount = buffer_0.readShort();
            }

            Class68_Sub1.method623(Coordinates.worldList, 0, Coordinates.worldList.length - 1, World.anIntArray58, World.anIntArray57);
            AClass2_Sub1.listFetcher = null;
            return true;
         }
      } catch (Exception exception_0) {
         exception_0.printStackTrace();
         AClass2_Sub1.listFetcher = null;
      }

      return false;
   }

   static int method751(int int_0, Script script_0, boolean bool_0) {
      if (int_0 == 5000) {
         Class39.intStack[++Class23.intStackSize - 1] = Client.anInt683;
         return 1;
      } else if (int_0 == 5001) {
         Class23.intStackSize -= 3;
         Client.anInt683 = Class39.intStack[Class23.intStackSize];
         Huffman.aClass106_4 = VarPlayerType.method945(Class39.intStack[Class23.intStackSize + 1]);
         if (Huffman.aClass106_4 == null) {
            Huffman.aClass106_4 = Class106.aClass106_2;
         }

         Client.anInt686 = Class39.intStack[Class23.intStackSize + 2];
         PacketNode packetnode_3 = Actor.method953(ClientPacket.aClientPacket95, Client.aClass46_1.cipher);
         packetnode_3.packetBuffer.putByte(Client.anInt683);
         packetnode_3.packetBuffer.putByte(Huffman.aClass106_4.anInt207);
         packetnode_3.packetBuffer.putByte(Client.anInt686);
         Client.aClass46_1.method282(packetnode_3);
         return 1;
      } else {
         String string_0;
         int int_1;
         int int_2;
         if (int_0 == 5002) {
            string_0 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
            Class23.intStackSize -= 2;
            int_1 = Class39.intStack[Class23.intStackSize];
            int_2 = Class39.intStack[Class23.intStackSize + 1];
            PacketNode packetnode_2 = Actor.method953(ClientPacket.aClientPacket89, Client.aClass46_1.cipher);
            packetnode_2.packetBuffer.putByte(Projectile.getLength(string_0) + 2);
            packetnode_2.packetBuffer.putString(string_0);
            packetnode_2.packetBuffer.putByte(int_1 - 1);
            packetnode_2.packetBuffer.putByte(int_2);
            Client.aClass46_1.method282(packetnode_2);
            return 1;
         } else {
            int int_3;
            if (int_0 == 5003) {
               Class23.intStackSize -= 2;
               int_3 = Class39.intStack[Class23.intStackSize];
               int_1 = Class39.intStack[Class23.intStackSize + 1];
               ChatLineBuffer chatlinebuffer_0 = (ChatLineBuffer) Class34.chatLineMap.get(Integer.valueOf(int_3));
               MessageNode messagenode_1 = chatlinebuffer_0.method11(int_1);
               if (messagenode_1 != null) {
                  Class39.intStack[++Class23.intStackSize - 1] = messagenode_1.id;
                  Class39.intStack[++Class23.intStackSize - 1] = messagenode_1.tick;
                  Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = messagenode_1.name != null ? messagenode_1.name : "";
                  Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = messagenode_1.sender != null ? messagenode_1.sender : "";
                  Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = messagenode_1.value != null ? messagenode_1.value : "";
               } else {
                  Class39.intStack[++Class23.intStackSize - 1] = -1;
                  Class39.intStack[++Class23.intStackSize - 1] = 0;
                  Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                  Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                  Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if (int_0 == 5004) {
               int_3 = Class39.intStack[--Class23.intStackSize];
               MessageNode messagenode_2 = (MessageNode) Class34.anIterableHashTable1.get((long)int_3);
               if (messagenode_2 != null) {
                  Class39.intStack[++Class23.intStackSize - 1] = messagenode_2.type;
                  Class39.intStack[++Class23.intStackSize - 1] = messagenode_2.tick;
                  Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = messagenode_2.name != null ? messagenode_2.name : "";
                  Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = messagenode_2.sender != null ? messagenode_2.sender : "";
                  Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = messagenode_2.value != null ? messagenode_2.value : "";
               } else {
                  Class39.intStack[++Class23.intStackSize - 1] = -1;
                  Class39.intStack[++Class23.intStackSize - 1] = 0;
                  Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                  Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                  Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if (int_0 == 5005) {
               if (Huffman.aClass106_4 == null) {
                  Class39.intStack[++Class23.intStackSize - 1] = -1;
               } else {
                  Class39.intStack[++Class23.intStackSize - 1] = Huffman.aClass106_4.anInt207;
               }

               return 1;
            } else if (int_0 == 5008) {
               string_0 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
               int_1 = Class39.intStack[--Class23.intStackSize];
               String string_1 = string_0.toLowerCase();
               byte byte_1 = 0;
               if (string_1.startsWith("yellow:")) {
                  byte_1 = 0;
                  string_0 = string_0.substring("yellow:".length());
               } else if (string_1.startsWith("red:")) {
                  byte_1 = 1;
                  string_0 = string_0.substring("red:".length());
               } else if (string_1.startsWith("green:")) {
                  byte_1 = 2;
                  string_0 = string_0.substring("green:".length());
               } else if (string_1.startsWith("cyan:")) {
                  byte_1 = 3;
                  string_0 = string_0.substring("cyan:".length());
               } else if (string_1.startsWith("purple:")) {
                  byte_1 = 4;
                  string_0 = string_0.substring("purple:".length());
               } else if (string_1.startsWith("white:")) {
                  byte_1 = 5;
                  string_0 = string_0.substring("white:".length());
               } else if (string_1.startsWith("flash1:")) {
                  byte_1 = 6;
                  string_0 = string_0.substring("flash1:".length());
               } else if (string_1.startsWith("flash2:")) {
                  byte_1 = 7;
                  string_0 = string_0.substring("flash2:".length());
               } else if (string_1.startsWith("flash3:")) {
                  byte_1 = 8;
                  string_0 = string_0.substring("flash3:".length());
               } else if (string_1.startsWith("glow1:")) {
                  byte_1 = 9;
                  string_0 = string_0.substring("glow1:".length());
               } else if (string_1.startsWith("glow2:")) {
                  byte_1 = 10;
                  string_0 = string_0.substring("glow2:".length());
               } else if (string_1.startsWith("glow3:")) {
                  byte_1 = 11;
                  string_0 = string_0.substring("glow3:".length());
               } else if (Client.languageId != 0) {
                  if (string_1.startsWith("yellow:")) {
                     byte_1 = 0;
                     string_0 = string_0.substring("yellow:".length());
                  } else if (string_1.startsWith("red:")) {
                     byte_1 = 1;
                     string_0 = string_0.substring("red:".length());
                  } else if (string_1.startsWith("green:")) {
                     byte_1 = 2;
                     string_0 = string_0.substring("green:".length());
                  } else if (string_1.startsWith("cyan:")) {
                     byte_1 = 3;
                     string_0 = string_0.substring("cyan:".length());
                  } else if (string_1.startsWith("purple:")) {
                     byte_1 = 4;
                     string_0 = string_0.substring("purple:".length());
                  } else if (string_1.startsWith("white:")) {
                     byte_1 = 5;
                     string_0 = string_0.substring("white:".length());
                  } else if (string_1.startsWith("flash1:")) {
                     byte_1 = 6;
                     string_0 = string_0.substring("flash1:".length());
                  } else if (string_1.startsWith("flash2:")) {
                     byte_1 = 7;
                     string_0 = string_0.substring("flash2:".length());
                  } else if (string_1.startsWith("flash3:")) {
                     byte_1 = 8;
                     string_0 = string_0.substring("flash3:".length());
                  } else if (string_1.startsWith("glow1:")) {
                     byte_1 = 9;
                     string_0 = string_0.substring("glow1:".length());
                  } else if (string_1.startsWith("glow2:")) {
                     byte_1 = 10;
                     string_0 = string_0.substring("glow2:".length());
                  } else if (string_1.startsWith("glow3:")) {
                     byte_1 = 11;
                     string_0 = string_0.substring("glow3:".length());
                  }
               }

               string_1 = string_0.toLowerCase();
               byte byte_0 = 0;
               if (string_1.startsWith("wave:")) {
                  byte_0 = 1;
                  string_0 = string_0.substring("wave:".length());
               } else if (string_1.startsWith("wave2:")) {
                  byte_0 = 2;
                  string_0 = string_0.substring("wave2:".length());
               } else if (string_1.startsWith("shake:")) {
                  byte_0 = 3;
                  string_0 = string_0.substring("shake:".length());
               } else if (string_1.startsWith("scroll:")) {
                  byte_0 = 4;
                  string_0 = string_0.substring("scroll:".length());
               } else if (string_1.startsWith("slide:")) {
                  byte_0 = 5;
                  string_0 = string_0.substring("slide:".length());
               } else if (Client.languageId != 0) {
                  if (string_1.startsWith("wave:")) {
                     byte_0 = 1;
                     string_0 = string_0.substring("wave:".length());
                  } else if (string_1.startsWith("wave2:")) {
                     byte_0 = 2;
                     string_0 = string_0.substring("wave2:".length());
                  } else if (string_1.startsWith("shake:")) {
                     byte_0 = 3;
                     string_0 = string_0.substring("shake:".length());
                  } else if (string_1.startsWith("scroll:")) {
                     byte_0 = 4;
                     string_0 = string_0.substring("scroll:".length());
                  } else if (string_1.startsWith("slide:")) {
                     byte_0 = 5;
                     string_0 = string_0.substring("slide:".length());
                  }
               }

               PacketNode packetnode_1 = Actor.method953(ClientPacket.aClientPacket91, Client.aClass46_1.cipher);
               packetnode_1.packetBuffer.putByte(0);
               int int_5 = packetnode_1.packetBuffer.offset;
               packetnode_1.packetBuffer.putByte(int_1);
               packetnode_1.packetBuffer.putByte(byte_1);
               packetnode_1.packetBuffer.putByte(byte_0);
               PacketBuffer packetbuffer_0 = packetnode_1.packetBuffer;
               int int_6 = packetbuffer_0.offset;
               int int_11 = string_0.length();
               byte[] bytes_0 = new byte[int_11];

               for (int int_7 = 0; int_7 < int_11; int_7++) {
                  char char_1 = string_0.charAt(int_7);
                  if ((char_1 <= 0 || char_1 >= 128) && (char_1 < 160 || char_1 > 255)) {
                     if (char_1 == 8364) {
                        bytes_0[int_7] = -128;
                     } else if (char_1 == 8218) {
                        bytes_0[int_7] = -126;
                     } else if (char_1 == 402) {
                        bytes_0[int_7] = -125;
                     } else if (char_1 == 8222) {
                        bytes_0[int_7] = -124;
                     } else if (char_1 == 8230) {
                        bytes_0[int_7] = -123;
                     } else if (char_1 == 8224) {
                        bytes_0[int_7] = -122;
                     } else if (char_1 == 8225) {
                        bytes_0[int_7] = -121;
                     } else if (char_1 == 710) {
                        bytes_0[int_7] = -120;
                     } else if (char_1 == 8240) {
                        bytes_0[int_7] = -119;
                     } else if (char_1 == 352) {
                        bytes_0[int_7] = -118;
                     } else if (char_1 == 8249) {
                        bytes_0[int_7] = -117;
                     } else if (char_1 == 338) {
                        bytes_0[int_7] = -116;
                     } else if (char_1 == 381) {
                        bytes_0[int_7] = -114;
                     } else if (char_1 == 8216) {
                        bytes_0[int_7] = -111;
                     } else if (char_1 == 8217) {
                        bytes_0[int_7] = -110;
                     } else if (char_1 == 8220) {
                        bytes_0[int_7] = -109;
                     } else if (char_1 == 8221) {
                        bytes_0[int_7] = -108;
                     } else if (char_1 == 8226) {
                        bytes_0[int_7] = -107;
                     } else if (char_1 == 8211) {
                        bytes_0[int_7] = -106;
                     } else if (char_1 == 8212) {
                        bytes_0[int_7] = -105;
                     } else if (char_1 == 732) {
                        bytes_0[int_7] = -104;
                     } else if (char_1 == 8482) {
                        bytes_0[int_7] = -103;
                     } else if (char_1 == 353) {
                        bytes_0[int_7] = -102;
                     } else if (char_1 == 8250) {
                        bytes_0[int_7] = -101;
                     } else if (char_1 == 339) {
                        bytes_0[int_7] = -100;
                     } else if (char_1 == 382) {
                        bytes_0[int_7] = -98;
                     } else if (char_1 == 376) {
                        bytes_0[int_7] = -97;
                     } else {
                        bytes_0[int_7] = 63;
                     }
                  } else {
                     bytes_0[int_7] = (byte)char_1;
                  }
               }

               packetbuffer_0.putShortSmart(bytes_0.length);
               packetbuffer_0.offset += Class99.aHuffman1.compress(bytes_0, 0, bytes_0.length, packetbuffer_0.payload, packetbuffer_0.offset);
               packetnode_1.packetBuffer.method708(packetnode_1.packetBuffer.offset - int_5);
               Client.aClass46_1.method282(packetnode_1);
               return 1;
            } else {
               int int_4;
               if (int_0 == 5009) {
                  Class28.scriptStringStackSize -= 2;
                  string_0 = Class39.scriptStringStack[Class28.scriptStringStackSize];
                  String string_2 = Class39.scriptStringStack[Class28.scriptStringStackSize + 1];
                  PacketNode packetnode_0 = Actor.method953(ClientPacket.aClientPacket88, Client.aClass46_1.cipher);
                  packetnode_0.packetBuffer.putShort(0);
                  int_4 = packetnode_0.packetBuffer.offset;
                  packetnode_0.packetBuffer.putString(string_0);
                  PacketBuffer packetbuffer_1 = packetnode_0.packetBuffer;
                  int int_8 = packetbuffer_1.offset;
                  int int_9 = string_2.length();
                  byte[] bytes_1 = new byte[int_9];

                  for (int int_10 = 0; int_10 < int_9; int_10++) {
                     char char_0 = string_2.charAt(int_10);
                     if ((char_0 <= 0 || char_0 >= 128) && (char_0 < 160 || char_0 > 255)) {
                        if (char_0 == 8364) {
                           bytes_1[int_10] = -128;
                        } else if (char_0 == 8218) {
                           bytes_1[int_10] = -126;
                        } else if (char_0 == 402) {
                           bytes_1[int_10] = -125;
                        } else if (char_0 == 8222) {
                           bytes_1[int_10] = -124;
                        } else if (char_0 == 8230) {
                           bytes_1[int_10] = -123;
                        } else if (char_0 == 8224) {
                           bytes_1[int_10] = -122;
                        } else if (char_0 == 8225) {
                           bytes_1[int_10] = -121;
                        } else if (char_0 == 710) {
                           bytes_1[int_10] = -120;
                        } else if (char_0 == 8240) {
                           bytes_1[int_10] = -119;
                        } else if (char_0 == 352) {
                           bytes_1[int_10] = -118;
                        } else if (char_0 == 8249) {
                           bytes_1[int_10] = -117;
                        } else if (char_0 == 338) {
                           bytes_1[int_10] = -116;
                        } else if (char_0 == 381) {
                           bytes_1[int_10] = -114;
                        } else if (char_0 == 8216) {
                           bytes_1[int_10] = -111;
                        } else if (char_0 == 8217) {
                           bytes_1[int_10] = -110;
                        } else if (char_0 == 8220) {
                           bytes_1[int_10] = -109;
                        } else if (char_0 == 8221) {
                           bytes_1[int_10] = -108;
                        } else if (char_0 == 8226) {
                           bytes_1[int_10] = -107;
                        } else if (char_0 == 8211) {
                           bytes_1[int_10] = -106;
                        } else if (char_0 == 8212) {
                           bytes_1[int_10] = -105;
                        } else if (char_0 == 732) {
                           bytes_1[int_10] = -104;
                        } else if (char_0 == 8482) {
                           bytes_1[int_10] = -103;
                        } else if (char_0 == 353) {
                           bytes_1[int_10] = -102;
                        } else if (char_0 == 8250) {
                           bytes_1[int_10] = -101;
                        } else if (char_0 == 339) {
                           bytes_1[int_10] = -100;
                        } else if (char_0 == 382) {
                           bytes_1[int_10] = -98;
                        } else if (char_0 == 376) {
                           bytes_1[int_10] = -97;
                        } else {
                           bytes_1[int_10] = 63;
                        }
                     } else {
                        bytes_1[int_10] = (byte)char_0;
                     }
                  }

                  packetbuffer_1.putShortSmart(bytes_1.length);
                  packetbuffer_1.offset += Class99.aHuffman1.compress(bytes_1, 0, bytes_1.length, packetbuffer_1.payload, packetbuffer_1.offset);
                  packetnode_0.packetBuffer.method722(packetnode_0.packetBuffer.offset - int_4);
                  Client.aClass46_1.method282(packetnode_0);
                  return 1;
               } else if (int_0 != 5015) {
                  if (int_0 == 5016) {
                     Class39.intStack[++Class23.intStackSize - 1] = Client.anInt686;
                     return 1;
                  } else if (int_0 == 5017) {
                     int_3 = Class39.intStack[--Class23.intStackSize];
                     Class39.intStack[++Class23.intStackSize - 1] = DecorativeObject.method462(int_3);
                     return 1;
                  } else if (int_0 == 5018) {
                     int_3 = Class39.intStack[--Class23.intStackSize];
                     int[] ints_0 = Class39.intStack;
                     int_2 = ++Class23.intStackSize - 1;
                     MessageNode messagenode_0 = (MessageNode) Class34.anIterableHashTable1.get((long)int_3);
                     if (messagenode_0 == null) {
                        int_4 = -1;
                     } else if (messagenode_0.previous == Class34.aClass77_1.aCacheableNode3) {
                        int_4 = -1;
                     } else {
                        int_4 = ((MessageNode) messagenode_0.previous).id;
                     }

                     ints_0[int_2] = int_4;
                     return 1;
                  } else if (int_0 == 5019) {
                     int_3 = Class39.intStack[--Class23.intStackSize];
                     Class39.intStack[++Class23.intStackSize - 1] = WorldMapType3.method576(int_3);
                     return 1;
                  } else if (int_0 == 5020) {
                     string_0 = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                     Class97.method521(string_0);
                     return 1;
                  } else if (int_0 == 5021) {
                     Client.aString37 = Class39.scriptStringStack[--Class28.scriptStringStackSize].toLowerCase().trim();
                     return 1;
                  } else if (int_0 == 5022) {
                     Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = Client.aString37;
                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  if (Class4.localPlayer != null && Class4.localPlayer.name != null) {
                     string_0 = Class4.localPlayer.name;
                  } else {
                     string_0 = "";
                  }

                  Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = string_0;
                  return 1;
               }
            }
         }
      }
   }

   static void method752(String string_0) {
      if (DynamicObject.clanMembers != null) {
         PacketNode packetnode_0 = Actor.method953(ClientPacket.aClientPacket87, Client.aClass46_1.cipher);
         packetnode_0.packetBuffer.putByte(Projectile.getLength(string_0));
         packetnode_0.packetBuffer.putString(string_0);
         Client.aClass46_1.method282(packetnode_0);
      }
   }

}
