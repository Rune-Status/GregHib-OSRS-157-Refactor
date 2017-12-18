import java.io.File;
import java.io.IOException;

public class Class36 {

   String aString6;
   String aString7;
   public final long aLong2;
   public final int anInt96;
   public final GrandExchangeOffer aGrandExchangeOffer1;

   Class36(Buffer buffer_0, byte byte_0, int int_0) {
      this.aString7 = buffer_0.readString();
      this.aString6 = buffer_0.readString();
      this.anInt96 = buffer_0.getUnsignedShort();
      this.aLong2 = buffer_0.readLong();
      int int_1 = buffer_0.readInt();
      int int_2 = buffer_0.readInt();
      this.aGrandExchangeOffer1 = new GrandExchangeOffer();
      this.aGrandExchangeOffer1.method170(2);
      this.aGrandExchangeOffer1.method171(byte_0);
      this.aGrandExchangeOffer1.price = int_1;
      this.aGrandExchangeOffer1.totalQuantity = int_2;
      this.aGrandExchangeOffer1.quantitySold = 0;
      this.aGrandExchangeOffer1.spent = 0;
      this.aGrandExchangeOffer1.itemId = int_0;
   }

   public String method246() {
      return this.aString7;
   }

   public String method247() {
      return this.aString6;
   }

   static Preferences method248() {
      FileOnDisk fileondisk_0 = null;
      Preferences preferences_0 = new Preferences();

      try {
         fileondisk_0 = Varcs.getPreferencesFile("", Class14.anEnum6_1.aString27, false);
         byte[] bytes_0 = new byte[(int)fileondisk_0.length()];

         int int_1;
         for (int int_0 = 0; int_0 < bytes_0.length; int_0 += int_1) {
            int_1 = fileondisk_0.read(bytes_0, int_0, bytes_0.length - int_0);
            if (int_1 == -1) {
               throw new IOException();
            }
         }

         preferences_0 = new Preferences(new Buffer(bytes_0));
      } catch (Exception exception_0) {
         ;
      }

      try {
         if (fileondisk_0 != null) {
            fileondisk_0.close();
         }
      } catch (Exception exception_1) {
         ;
      }

      return preferences_0;
   }

   static void method249(File from, File file_1) {
      try {
         FileOnDisk disk = new FileOnDisk(WidgetNode.aFile3, "rw", 10000L);
         Buffer buffer = new Buffer(500);
         buffer.putByte(3);
         buffer.putByte(file_1 != null ? 1 : 0);
         buffer.putCESU8(from.getPath());
         if (file_1 != null) {
            buffer.putCESU8("");
         }

         disk.write(buffer.buffer, 0, buffer.position);
         disk.close();
      } catch (IOException ioexception_0) {
         ioexception_0.printStackTrace();
      }

   }

   static int method250(int int_0, Script script_0, boolean bool_0) {
      int int_1;
      if (int_0 == 6600) {
         int_1 = Ignore.plane;
         int int_6 = (Class4.localPlayer.x >> 7) + Client.regionBaseX;
         int int_2 = (Class4.localPlayer.y >> 7) + Client.regionBaseY;
         BaseVarType.method647().method36(int_1, int_6, int_2, true);
         return 1;
      } else {
         WorldMapData worldmapdata_0;
         if (int_0 == 6601) {
            int_1 = Class39.intStack[--Class23.intStackSize];
            String string_0 = "";
            worldmapdata_0 = BaseVarType.method647().method18(int_1);
            if (worldmapdata_0 != null) {
               string_0 = worldmapdata_0.method303();
            }

            Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = string_0;
            return 1;
         } else if (int_0 == 6602) {
            int_1 = Class39.intStack[--Class23.intStackSize];
            BaseVarType.method647().method40(int_1);
            return 1;
         } else if (int_0 == 6603) {
            Class39.intStack[++Class23.intStackSize - 1] = BaseVarType.method647().method41();
            return 1;
         } else if (int_0 == 6604) {
            int_1 = Class39.intStack[--Class23.intStackSize];
            BaseVarType.method647().method43(int_1);
            return 1;
         } else if (int_0 == 6605) {
            Class39.intStack[++Class23.intStackSize - 1] = BaseVarType.method647().method44() ? 1 : 0;
            return 1;
         } else {
            Coordinates coordinates_3;
            if (int_0 == 6606) {
               coordinates_3 = new Coordinates(Class39.intStack[--Class23.intStackSize]);
               BaseVarType.method647().method28(coordinates_3.worldX, coordinates_3.worldY);
               return 1;
            } else if (int_0 == 6607) {
               coordinates_3 = new Coordinates(Class39.intStack[--Class23.intStackSize]);
               BaseVarType.method647().method27(coordinates_3.worldX, coordinates_3.worldY);
               return 1;
            } else if (int_0 == 6608) {
               coordinates_3 = new Coordinates(Class39.intStack[--Class23.intStackSize]);
               BaseVarType.method647().method46(coordinates_3.plane, coordinates_3.worldX, coordinates_3.worldY);
               return 1;
            } else if (int_0 == 6609) {
               coordinates_3 = new Coordinates(Class39.intStack[--Class23.intStackSize]);
               BaseVarType.method647().method47(coordinates_3.plane, coordinates_3.worldX, coordinates_3.worldY);
               return 1;
            } else if (int_0 == 6610) {
               Class39.intStack[++Class23.intStackSize - 1] = BaseVarType.method647().method20();
               Class39.intStack[++Class23.intStackSize - 1] = BaseVarType.method647().method25();
               return 1;
            } else {
               WorldMapData worldmapdata_1;
               if (int_0 == 6611) {
                  int_1 = Class39.intStack[--Class23.intStackSize];
                  worldmapdata_1 = BaseVarType.method647().method18(int_1);
                  if (worldmapdata_1 == null) {
                     Class39.intStack[++Class23.intStackSize - 1] = 0;
                  } else {
                     Class39.intStack[++Class23.intStackSize - 1] = worldmapdata_1.method304().method513();
                  }

                  return 1;
               } else if (int_0 == 6612) {
                  int_1 = Class39.intStack[--Class23.intStackSize];
                  worldmapdata_1 = BaseVarType.method647().method18(int_1);
                  if (worldmapdata_1 == null) {
                     Class39.intStack[++Class23.intStackSize - 1] = 0;
                     Class39.intStack[++Class23.intStackSize - 1] = 0;
                  } else {
                     Class39.intStack[++Class23.intStackSize - 1] = (worldmapdata_1.method300() - worldmapdata_1.method289() + 1) * 64;
                     Class39.intStack[++Class23.intStackSize - 1] = (worldmapdata_1.method301() - worldmapdata_1.method290() + 1) * 64;
                  }

                  return 1;
               } else if (int_0 == 6613) {
                  int_1 = Class39.intStack[--Class23.intStackSize];
                  worldmapdata_1 = BaseVarType.method647().method18(int_1);
                  if (worldmapdata_1 == null) {
                     Class39.intStack[++Class23.intStackSize - 1] = 0;
                     Class39.intStack[++Class23.intStackSize - 1] = 0;
                     Class39.intStack[++Class23.intStackSize - 1] = 0;
                     Class39.intStack[++Class23.intStackSize - 1] = 0;
                  } else {
                     Class39.intStack[++Class23.intStackSize - 1] = worldmapdata_1.method289() * 64;
                     Class39.intStack[++Class23.intStackSize - 1] = worldmapdata_1.method290() * 64;
                     Class39.intStack[++Class23.intStackSize - 1] = worldmapdata_1.method300() * 64 + 64 - 1;
                     Class39.intStack[++Class23.intStackSize - 1] = worldmapdata_1.method301() * 64 + 64 - 1;
                  }

                  return 1;
               } else if (int_0 == 6614) {
                  int_1 = Class39.intStack[--Class23.intStackSize];
                  worldmapdata_1 = BaseVarType.method647().method18(int_1);
                  if (worldmapdata_1 == null) {
                     Class39.intStack[++Class23.intStackSize - 1] = -1;
                  } else {
                     Class39.intStack[++Class23.intStackSize - 1] = worldmapdata_1.method296();
                  }

                  return 1;
               } else if (int_0 == 6615) {
                  coordinates_3 = BaseVarType.method647().method45();
                  if (coordinates_3 == null) {
                     Class39.intStack[++Class23.intStackSize - 1] = -1;
                     Class39.intStack[++Class23.intStackSize - 1] = -1;
                  } else {
                     Class39.intStack[++Class23.intStackSize - 1] = coordinates_3.worldX;
                     Class39.intStack[++Class23.intStackSize - 1] = coordinates_3.worldY;
                  }

                  return 1;
               } else if (int_0 == 6616) {
                  Class39.intStack[++Class23.intStackSize - 1] = BaseVarType.method647().method48();
                  return 1;
               } else if (int_0 == 6617) {
                  coordinates_3 = new Coordinates(Class39.intStack[--Class23.intStackSize]);
                  worldmapdata_1 = BaseVarType.method647().method50();
                  if (worldmapdata_1 == null) {
                     Class39.intStack[++Class23.intStackSize - 1] = -1;
                     Class39.intStack[++Class23.intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] ints_0 = worldmapdata_1.method287(coordinates_3.plane, coordinates_3.worldX, coordinates_3.worldY);
                     if (ints_0 == null) {
                        Class39.intStack[++Class23.intStackSize - 1] = -1;
                        Class39.intStack[++Class23.intStackSize - 1] = -1;
                     } else {
                        Class39.intStack[++Class23.intStackSize - 1] = ints_0[0];
                        Class39.intStack[++Class23.intStackSize - 1] = ints_0[1];
                     }

                     return 1;
                  }
               } else {
                  Coordinates coordinates_0;
                  if (int_0 == 6618) {
                     coordinates_3 = new Coordinates(Class39.intStack[--Class23.intStackSize]);
                     worldmapdata_1 = BaseVarType.method647().method50();
                     if (worldmapdata_1 == null) {
                        Class39.intStack[++Class23.intStackSize - 1] = -1;
                        Class39.intStack[++Class23.intStackSize - 1] = -1;
                        return 1;
                     } else {
                        coordinates_0 = worldmapdata_1.method292(coordinates_3.worldX, coordinates_3.worldY);
                        if (coordinates_0 == null) {
                           Class39.intStack[++Class23.intStackSize - 1] = -1;
                        } else {
                           Class39.intStack[++Class23.intStackSize - 1] = coordinates_0.method513();
                        }

                        return 1;
                     }
                  } else {
                     Coordinates coordinates_2;
                     if (int_0 == 6619) {
                        Class23.intStackSize -= 2;
                        int_1 = Class39.intStack[Class23.intStackSize];
                        coordinates_2 = new Coordinates(Class39.intStack[Class23.intStackSize + 1]);
                        Class96.method519(int_1, coordinates_2, false);
                        return 1;
                     } else if (int_0 == 6620) {
                        Class23.intStackSize -= 2;
                        int_1 = Class39.intStack[Class23.intStackSize];
                        coordinates_2 = new Coordinates(Class39.intStack[Class23.intStackSize + 1]);
                        worldmapdata_0 = BaseVarType.method647().method18(int_1);
                        int int_3 = Class4.localPlayer.currentPlane;
                        int int_4 = (Class4.localPlayer.x >> 7) + Client.regionBaseX;
                        int int_5 = (Class4.localPlayer.y >> 7) + Client.regionBaseY;
                        Coordinates coordinates_1 = new Coordinates(int_3, int_4, int_5);
                        BaseVarType.method647().method64(worldmapdata_0, coordinates_1, coordinates_2, true);
                        return 1;
                     } else if (int_0 == 6621) {
                        Class23.intStackSize -= 2;
                        int_1 = Class39.intStack[Class23.intStackSize];
                        coordinates_2 = new Coordinates(Class39.intStack[Class23.intStackSize + 1]);
                        worldmapdata_0 = BaseVarType.method647().method18(int_1);
                        if (worldmapdata_0 == null) {
                           Class39.intStack[++Class23.intStackSize - 1] = 0;
                           return 1;
                        } else {
                           Class39.intStack[++Class23.intStackSize - 1] = worldmapdata_0.method291(coordinates_2.plane, coordinates_2.worldX, coordinates_2.worldY) ? 1 : 0;
                           return 1;
                        }
                     } else if (int_0 == 6622) {
                        Class39.intStack[++Class23.intStackSize - 1] = BaseVarType.method647().method29();
                        Class39.intStack[++Class23.intStackSize - 1] = BaseVarType.method647().method30();
                        return 1;
                     } else if (int_0 == 6623) {
                        coordinates_3 = new Coordinates(Class39.intStack[--Class23.intStackSize]);
                        worldmapdata_1 = BaseVarType.method647().method16(coordinates_3.plane, coordinates_3.worldX, coordinates_3.worldY);
                        if (worldmapdata_1 == null) {
                           Class39.intStack[++Class23.intStackSize - 1] = -1;
                        } else {
                           Class39.intStack[++Class23.intStackSize - 1] = worldmapdata_1.method288();
                        }

                        return 1;
                     } else if (int_0 == 6624) {
                        BaseVarType.method647().method52(Class39.intStack[--Class23.intStackSize]);
                        return 1;
                     } else if (int_0 == 6625) {
                        BaseVarType.method647().method49();
                        return 1;
                     } else if (int_0 == 6626) {
                        BaseVarType.method647().method54(Class39.intStack[--Class23.intStackSize]);
                        return 1;
                     } else if (int_0 == 6627) {
                        BaseVarType.method647().method51();
                        return 1;
                     } else {
                        boolean bool_2;
                        if (int_0 == 6628) {
                           bool_2 = Class39.intStack[--Class23.intStackSize] == 1;
                           BaseVarType.method647().method56(bool_2);
                           return 1;
                        } else if (int_0 == 6629) {
                           int_1 = Class39.intStack[--Class23.intStackSize];
                           BaseVarType.method647().method55(int_1);
                           return 1;
                        } else if (int_0 == 6630) {
                           int_1 = Class39.intStack[--Class23.intStackSize];
                           BaseVarType.method647().method57(int_1);
                           return 1;
                        } else if (int_0 == 6631) {
                           BaseVarType.method647().method53();
                           return 1;
                        } else if (int_0 == 6632) {
                           bool_2 = Class39.intStack[--Class23.intStackSize] == 1;
                           BaseVarType.method647().method59(bool_2);
                           return 1;
                        } else {
                           boolean bool_1;
                           if (int_0 == 6633) {
                              Class23.intStackSize -= 2;
                              int_1 = Class39.intStack[Class23.intStackSize];
                              bool_1 = Class39.intStack[Class23.intStackSize + 1] == 1;
                              BaseVarType.method647().method61(int_1, bool_1);
                              return 1;
                           } else if (int_0 == 6634) {
                              Class23.intStackSize -= 2;
                              int_1 = Class39.intStack[Class23.intStackSize];
                              bool_1 = Class39.intStack[Class23.intStackSize + 1] == 1;
                              BaseVarType.method647().method62(int_1, bool_1);
                              return 1;
                           } else if (int_0 == 6635) {
                              Class39.intStack[++Class23.intStackSize - 1] = BaseVarType.method647().method60() ? 1 : 0;
                              return 1;
                           } else if (int_0 == 6636) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              Class39.intStack[++Class23.intStackSize - 1] = BaseVarType.method647().method63(int_1) ? 1 : 0;
                              return 1;
                           } else if (int_0 == 6637) {
                              int_1 = Class39.intStack[--Class23.intStackSize];
                              Class39.intStack[++Class23.intStackSize - 1] = BaseVarType.method647().method65(int_1) ? 1 : 0;
                              return 1;
                           } else if (int_0 == 6638) {
                              Class23.intStackSize -= 2;
                              int_1 = Class39.intStack[Class23.intStackSize];
                              coordinates_2 = new Coordinates(Class39.intStack[Class23.intStackSize + 1]);
                              coordinates_0 = BaseVarType.method647().method66(int_1, coordinates_2);
                              if (coordinates_0 == null) {
                                 Class39.intStack[++Class23.intStackSize - 1] = -1;
                              } else {
                                 Class39.intStack[++Class23.intStackSize - 1] = coordinates_0.method513();
                              }

                              return 1;
                           } else {
                              Class15 class15_0;
                              if (int_0 == 6639) {
                                 class15_0 = BaseVarType.method647().method58();
                                 if (class15_0 == null) {
                                    Class39.intStack[++Class23.intStackSize - 1] = -1;
                                    Class39.intStack[++Class23.intStackSize - 1] = -1;
                                 } else {
                                    Class39.intStack[++Class23.intStackSize - 1] = class15_0.anInt64;
                                    Class39.intStack[++Class23.intStackSize - 1] = class15_0.aCoordinates6.method513();
                                 }

                                 return 1;
                              } else if (int_0 == 6640) {
                                 class15_0 = BaseVarType.method647().method31();
                                 if (class15_0 == null) {
                                    Class39.intStack[++Class23.intStackSize - 1] = -1;
                                    Class39.intStack[++Class23.intStackSize - 1] = -1;
                                 } else {
                                    Class39.intStack[++Class23.intStackSize - 1] = class15_0.anInt64;
                                    Class39.intStack[++Class23.intStackSize - 1] = class15_0.aCoordinates6.method513();
                                 }

                                 return 1;
                              } else {
                                 Area area_0;
                                 if (int_0 == 6693) {
                                    int_1 = Class39.intStack[--Class23.intStackSize];
                                    area_0 = Area.anAreaArray1[int_1];
                                    if (area_0.name == null) {
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = "";
                                    } else {
                                       Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = area_0.name;
                                    }

                                    return 1;
                                 } else if (int_0 == 6694) {
                                    int_1 = Class39.intStack[--Class23.intStackSize];
                                    area_0 = Area.anAreaArray1[int_1];
                                    Class39.intStack[++Class23.intStackSize - 1] = area_0.anInt447;
                                    return 1;
                                 } else if (int_0 == 6695) {
                                    int_1 = Class39.intStack[--Class23.intStackSize];
                                    area_0 = Area.anAreaArray1[int_1];
                                    if (area_0 == null) {
                                       Class39.intStack[++Class23.intStackSize - 1] = -1;
                                    } else {
                                       Class39.intStack[++Class23.intStackSize - 1] = area_0.anInt449;
                                    }

                                    return 1;
                                 } else if (int_0 == 6696) {
                                    int_1 = Class39.intStack[--Class23.intStackSize];
                                    area_0 = Area.anAreaArray1[int_1];
                                    if (area_0 == null) {
                                       Class39.intStack[++Class23.intStackSize - 1] = -1;
                                    } else {
                                       Class39.intStack[++Class23.intStackSize - 1] = area_0.spriteId;
                                    }

                                    return 1;
                                 } else if (int_0 == 6697) {
                                    Class39.intStack[++Class23.intStackSize - 1] = Class4.aClass1_1.anInt17;
                                    return 1;
                                 } else if (int_0 == 6698) {
                                    Class39.intStack[++Class23.intStackSize - 1] = Class4.aClass1_1.aCoordinates2.method513();
                                    return 1;
                                 } else if (int_0 == 6699) {
                                    Class39.intStack[++Class23.intStackSize - 1] = Class4.aClass1_1.aCoordinates3.method513();
                                    return 1;
                                 } else {
                                    return 2;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   static void method251(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5) {
      int int_6 = 2048 - int_3 & 0x7FF;
      int int_7 = 2048 - int_4 & 0x7FF;
      int int_8 = 0;
      int int_9 = 0;
      int int_10 = int_5;
      int int_11;
      int int_12;
      int int_13;
      if (int_6 != 0) {
         int_11 = Graphics3D.SINE[int_6];
         int_12 = Graphics3D.COSINE[int_6];
         int_13 = int_9 * int_12 - int_11 * int_5 >> 16;
         int_10 = int_11 * int_9 + int_5 * int_12 >> 16;
         int_9 = int_13;
      }

      if (int_7 != 0) {
         int_11 = Graphics3D.SINE[int_7];
         int_12 = Graphics3D.COSINE[int_7];
         int_13 = int_11 * int_10 + int_8 * int_12 >> 16;
         int_10 = int_10 * int_12 - int_8 * int_11 >> 16;
         int_8 = int_13;
      }

      Class2.cameraX = int_0 - int_8;
      Class18.cameraZ = int_1 - int_9;
      Player.cameraY = int_2 - int_10;
      AClass1.cameraPitch = int_3;
      Enum4.cameraYaw = int_4;
   }

   static int method252(World world_0, World world_1, int int_0, boolean bool_0) {
      if (int_0 == 1) {
         int int_1 = world_0.playerCount;
         int int_2 = world_1.playerCount;
         if (!bool_0) {
            if (int_1 == -1) {
               int_1 = 2001;
            }

            if (int_2 == -1) {
               int_2 = 2001;
            }
         }

         return int_1 - int_2;
      } else {
         return int_0 == 2 ? world_0.location - world_1.location : (int_0 == 3 ? (world_0.activity.equals("-") ? (world_1.activity.equals("-") ? 0 : (bool_0 ? -1 : 1)) : (world_1.activity.equals("-") ? (bool_0 ? 1 : -1) : world_0.activity.compareTo(world_1.activity))) : (int_0 == 4 ? (world_0.method555() ? (world_1.method555() ? 0 : 1) : (world_1.method555() ? -1 : 0)) : (int_0 == 5 ? (world_0.method556() ? (world_1.method556() ? 0 : 1) : (world_1.method556() ? -1 : 0)) : (int_0 == 6 ? (world_0.method554() ? (world_1.method554() ? 0 : 1) : (world_1.method554() ? -1 : 0)) : (int_0 == 7 ? (world_0.method551() ? (world_1.method551() ? 0 : 1) : (world_1.method551() ? -1 : 0)) : world_0.id - world_1.id)))));
      }
   }

}
