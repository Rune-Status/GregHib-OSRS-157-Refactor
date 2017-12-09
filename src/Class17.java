public class Class17 {

   static int anInt69;

   static void method200(ScriptEvent scriptevent_0, int int_0) {
      Object[] objects_0 = scriptevent_0.anObjectArray22;
      Script script_0;
      int int_1;
      if (method201(scriptevent_0.aClass90_11)) {
         Class4.aClass1_1 = (Class1) objects_0[0];
         Area area_0 = Area.anAreaArray1[Class4.aClass1_1.anInt17];
         script_0 = GameObject.method565(scriptevent_0.aClass90_11, area_0.anInt443, area_0.anInt449);
      } else {
         int_1 = ((Integer) objects_0[0]).intValue();
         Script script_2 = (Script) Script.aNodeCache18.get((long)int_1);
         Script script_1;
         if (script_2 != null) {
            script_1 = script_2;
         } else {
            byte[] bytes_1 = Class3.indexScripts.getConfigData(int_1, 0);
            if (bytes_1 == null) {
               script_1 = null;
            } else {
               script_2 = Class64.method401(bytes_1);
               Script.aNodeCache18.put(script_2, (long)int_1);
               script_1 = script_2;
            }
         }

         script_0 = script_1;
      }

      if (script_0 != null) {
         Class23.intStackSize = 0;
         Class28.scriptStringStackSize = 0;
         int_1 = -1;
         int[] ints_0 = script_0.instructions;
         int[] ints_1 = script_0.intOperands;
         byte byte_0 = -1;
         Class39.scriptStackCount = 0;

         int int_4;
         try {
            Class39.scriptLocalInts = new int[script_0.localIntCount];
            int int_2 = 0;
            Class39.scriptLocalStrings = new String[script_0.localStringCount];
            int int_3 = 0;

            int int_5;
            String string_0;
            for (int_4 = 1; int_4 < objects_0.length; int_4++) {
               if (objects_0[int_4] instanceof Integer) {
                  int_5 = ((Integer) objects_0[int_4]).intValue();
                  if (int_5 == -2147483647) {
                     int_5 = scriptevent_0.anInt393;
                  }

                  if (int_5 == -2147483646) {
                     int_5 = scriptevent_0.anInt394;
                  }

                  if (int_5 == -2147483645) {
                     int_5 = scriptevent_0.widget != null ? scriptevent_0.widget.id : -1;
                  }

                  if (int_5 == -2147483644) {
                     int_5 = scriptevent_0.anInt396;
                  }

                  if (int_5 == -2147483643) {
                     int_5 = scriptevent_0.widget != null ? scriptevent_0.widget.index : -1;
                  }

                  if (int_5 == -2147483642) {
                     int_5 = scriptevent_0.aWidget8 != null ? scriptevent_0.aWidget8.id : -1;
                  }

                  if (int_5 == -2147483641) {
                     int_5 = scriptevent_0.aWidget8 != null ? scriptevent_0.aWidget8.index : -1;
                  }

                  if (int_5 == -2147483640) {
                     int_5 = scriptevent_0.anInt397;
                  }

                  if (int_5 == -2147483639) {
                     int_5 = scriptevent_0.anInt398;
                  }

                  Class39.scriptLocalInts[int_2++] = int_5;
               } else if (objects_0[int_4] instanceof String) {
                  string_0 = (String) objects_0[int_4];
                  if (string_0.equals("event_opbase")) {
                     string_0 = scriptevent_0.aString28;
                  }

                  Class39.scriptLocalStrings[int_3++] = string_0;
               }
            }

            int_4 = 0;
            Class39.anInt97 = scriptevent_0.anInt395;

            while (true) {
               while (true) {
                  while (true) {
                     while (true) {
                        while (true) {
                           while (true) {
                              while (true) {
                                 while (true) {
                                    while (true) {
                                       while (true) {
                                          while (true) {
                                             while (true) {
                                                while (true) {
                                                   while (true) {
                                                      while (true) {
                                                         while (true) {
                                                            while (true) {
                                                               while (true) {
                                                                  while (true) {
                                                                     while (true) {
                                                                        while (true) {
                                                                           while (true) {
                                                                              while (true) {
                                                                                 while (true) {
                                                                                    while (true) {
                                                                                       label335:
                                                                                       while (true) {
                                                                                          ++int_4;
                                                                                          if (int_4 > int_0) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++int_1;
                                                                                          int int_13 = ints_0[int_1];
                                                                                          int int_6;
                                                                                          if (int_13 < 100) {
                                                                                             if (int_13 != 0) {
                                                                                                if (int_13 != 1) {
                                                                                                   if (int_13 != 2) {
                                                                                                      if (int_13 != 3) {
                                                                                                         if (int_13 != 6) {
                                                                                                            if (int_13 != 7) {
                                                                                                               if (int_13 != 8) {
                                                                                                                  if (int_13 != 9) {
                                                                                                                     if (int_13 != 10) {
                                                                                                                        if (int_13 != 21) {
                                                                                                                           if (int_13 != 25) {
                                                                                                                              if (int_13 != 27) {
                                                                                                                                 if (int_13 != 31) {
                                                                                                                                    if (int_13 != 32) {
                                                                                                                                       if (int_13 != 33) {
                                                                                                                                          if (int_13 != 34) {
                                                                                                                                             if (int_13 != 35) {
                                                                                                                                                if (int_13 != 36) {
                                                                                                                                                   int int_8;
                                                                                                                                                   int int_9;
                                                                                                                                                   if (int_13 != 37) {
                                                                                                                                                      if (int_13 != 38) {
                                                                                                                                                         if (int_13 != 39) {
                                                                                                                                                            if (int_13 != 40) {
                                                                                                                                                               if (int_13 != 42) {
                                                                                                                                                                  if (int_13 != 43) {
                                                                                                                                                                     if (int_13 == 44) {
                                                                                                                                                                        int_5 = ints_1[int_1] >> 16;
                                                                                                                                                                        int_6 = ints_1[int_1] & 0xFFFF;
                                                                                                                                                                        int int_12 = Class39.intStack[--Class23.intStackSize];
                                                                                                                                                                        if (int_12 >= 0 && int_12 <= 5000) {
                                                                                                                                                                           Class39.anIntArray22[int_5] = int_12;
                                                                                                                                                                           byte byte_1 = -1;
                                                                                                                                                                           if (int_6 == 105) {
                                                                                                                                                                              byte_1 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           int_8 = 0;

                                                                                                                                                                           while (true) {
                                                                                                                                                                              if (int_8 >= int_12) {
                                                                                                                                                                                 continue label335;
                                                                                                                                                                              }

                                                                                                                                                                              Class39.SHAPE_VERTICES[int_5][int_8] = byte_1;
                                                                                                                                                                              ++int_8;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if (int_13 == 45) {
                                                                                                                                                                        int_5 = ints_1[int_1];
                                                                                                                                                                        int_6 = Class39.intStack[--Class23.intStackSize];
                                                                                                                                                                        if (int_6 < 0 || int_6 >= Class39.anIntArray22[int_5]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        Class39.intStack[++Class23.intStackSize - 1] = Class39.SHAPE_VERTICES[int_5][int_6];
                                                                                                                                                                     } else if (int_13 == 46) {
                                                                                                                                                                        int_5 = ints_1[int_1];
                                                                                                                                                                        Class23.intStackSize -= 2;
                                                                                                                                                                        int_6 = Class39.intStack[Class23.intStackSize];
                                                                                                                                                                        if (int_6 < 0 || int_6 >= Class39.anIntArray22[int_5]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        Class39.SHAPE_VERTICES[int_5][int_6] = Class39.intStack[Class23.intStackSize + 1];
                                                                                                                                                                     } else if (int_13 == 47) {
                                                                                                                                                                        string_0 = Class40.chatMessages.getVarcString(ints_1[int_1]);
                                                                                                                                                                        if (string_0 == null) {
                                                                                                                                                                           string_0 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = string_0;
                                                                                                                                                                     } else if (int_13 == 48) {
                                                                                                                                                                        Class40.chatMessages.putVarcString(ints_1[int_1], Class39.scriptStringStack[--Class28.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if (int_13 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable iterablehashtable_0 = script_0.switches[ints_1[int_1]];
                                                                                                                                                                        IntegerNode integernode_0 = (IntegerNode) iterablehashtable_0.get((long)Class39.intStack[--Class23.intStackSize]);
                                                                                                                                                                        if (integernode_0 != null) {
                                                                                                                                                                           int_1 += integernode_0.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     Class40.chatMessages.putVarc(ints_1[int_1], Class39.intStack[--Class23.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  Class39.intStack[++Class23.intStackSize - 1] = Class40.chatMessages.getVarc(ints_1[int_1]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               int_5 = ints_1[int_1];
                                                                                                                                                               Script script_3 = (Script) Script.aNodeCache18.get((long)int_5);
                                                                                                                                                               Script script_4;
                                                                                                                                                               if (script_3 != null) {
                                                                                                                                                                  script_4 = script_3;
                                                                                                                                                               } else {
                                                                                                                                                                  byte[] bytes_0 = Class3.indexScripts.getConfigData(int_5, 0);
                                                                                                                                                                  if (bytes_0 == null) {
                                                                                                                                                                     script_4 = null;
                                                                                                                                                                  } else {
                                                                                                                                                                     script_3 = Class64.method401(bytes_0);
                                                                                                                                                                     Script.aNodeCache18.put(script_3, (long)int_5);
                                                                                                                                                                     script_4 = script_3;
                                                                                                                                                                  }
                                                                                                                                                               }

                                                                                                                                                               script_3 = script_4;
                                                                                                                                                               int[] ints_2 = new int[script_4.localIntCount];
                                                                                                                                                               String[] strings_1 = new String[script_4.localStringCount];

                                                                                                                                                               for (int_9 = 0; int_9 < script_3.intStackCount; int_9++) {
                                                                                                                                                                  ints_2[int_9] = Class39.intStack[int_9 + (Class23.intStackSize - script_3.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for (int_9 = 0; int_9 < script_3.stringStackCount; int_9++) {
                                                                                                                                                                  strings_1[int_9] = Class39.scriptStringStack[int_9 + (Class28.scriptStringStackSize - script_3.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               Class23.intStackSize -= script_3.intStackCount;
                                                                                                                                                               Class28.scriptStringStackSize -= script_3.stringStackCount;
                                                                                                                                                               ScriptState scriptstate_0 = new ScriptState();
                                                                                                                                                               scriptstate_0.invokedFromScript = script_0;
                                                                                                                                                               scriptstate_0.invokedFromPc = int_1;
                                                                                                                                                               scriptstate_0.savedLocalInts = Class39.scriptLocalInts;
                                                                                                                                                               scriptstate_0.savedLocalStrings = Class39.scriptLocalStrings;
                                                                                                                                                               Class39.scriptStack[++Class39.scriptStackCount - 1] = scriptstate_0;
                                                                                                                                                               script_0 = script_3;
                                                                                                                                                               ints_0 = script_3.instructions;
                                                                                                                                                               ints_1 = script_3.intOperands;
                                                                                                                                                               int_1 = -1;
                                                                                                                                                               Class39.scriptLocalInts = ints_2;
                                                                                                                                                               Class39.scriptLocalStrings = strings_1;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --Class28.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --Class23.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      int_5 = ints_1[int_1];
                                                                                                                                                      Class28.scriptStringStackSize -= int_5;
                                                                                                                                                      String[] strings_0 = Class39.scriptStringStack;
                                                                                                                                                      int int_7 = Class28.scriptStringStackSize;
                                                                                                                                                      String string_1;
                                                                                                                                                      if (int_5 == 0) {
                                                                                                                                                         string_1 = "";
                                                                                                                                                      } else if (int_5 == 1) {
                                                                                                                                                         String string_2 = strings_0[int_7];
                                                                                                                                                         if (string_2 == null) {
                                                                                                                                                            string_1 = "null";
                                                                                                                                                         } else {
                                                                                                                                                            string_1 = string_2.toString();
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         int_8 = int_5 + int_7;
                                                                                                                                                         int_9 = 0;

                                                                                                                                                         for (int int_10 = int_7; int_10 < int_8; int_10++) {
                                                                                                                                                            String string_3 = strings_0[int_10];
                                                                                                                                                            if (string_3 == null) {
                                                                                                                                                               int_9 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               int_9 += string_3.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         StringBuilder stringbuilder_0 = new StringBuilder(int_9);

                                                                                                                                                         for (int int_11 = int_7; int_11 < int_8; int_11++) {
                                                                                                                                                            String string_4 = strings_0[int_11];
                                                                                                                                                            if (string_4 == null) {
                                                                                                                                                               stringbuilder_0.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               stringbuilder_0.append(string_4);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         string_1 = stringbuilder_0.toString();
                                                                                                                                                      }

                                                                                                                                                      Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = string_1;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   Class39.scriptLocalStrings[ints_1[int_1]] = Class39.scriptStringStack[--Class28.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = Class39.scriptLocalStrings[ints_1[int_1]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             Class39.scriptLocalInts[ints_1[int_1]] = Class39.intStack[--Class23.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          Class39.intStack[++Class23.intStackSize - 1] = Class39.scriptLocalInts[ints_1[int_1]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       Class23.intStackSize -= 2;
                                                                                                                                       if (Class39.intStack[Class23.intStackSize] >= Class39.intStack[Class23.intStackSize + 1]) {
                                                                                                                                          int_1 += ints_1[int_1];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    Class23.intStackSize -= 2;
                                                                                                                                    if (Class39.intStack[Class23.intStackSize] <= Class39.intStack[Class23.intStackSize + 1]) {
                                                                                                                                       int_1 += ints_1[int_1];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 int_5 = ints_1[int_1];
                                                                                                                                 TextureProvider.method570(int_5, Class39.intStack[--Class23.intStackSize]);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              int_5 = ints_1[int_1];
                                                                                                                              Class39.intStack[++Class23.intStackSize - 1] = Item.method973(int_5);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if (Class39.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState scriptstate_1 = Class39.scriptStack[--Class39.scriptStackCount];
                                                                                                                           script_0 = scriptstate_1.invokedFromScript;
                                                                                                                           ints_0 = script_0.instructions;
                                                                                                                           ints_1 = script_0.intOperands;
                                                                                                                           int_1 = scriptstate_1.invokedFromPc;
                                                                                                                           Class39.scriptLocalInts = scriptstate_1.savedLocalInts;
                                                                                                                           Class39.scriptLocalStrings = scriptstate_1.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        Class23.intStackSize -= 2;
                                                                                                                        if (Class39.intStack[Class23.intStackSize] > Class39.intStack[Class23.intStackSize + 1]) {
                                                                                                                           int_1 += ints_1[int_1];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     Class23.intStackSize -= 2;
                                                                                                                     if (Class39.intStack[Class23.intStackSize] < Class39.intStack[Class23.intStackSize + 1]) {
                                                                                                                        int_1 += ints_1[int_1];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  Class23.intStackSize -= 2;
                                                                                                                  if (Class39.intStack[Class23.intStackSize] == Class39.intStack[Class23.intStackSize + 1]) {
                                                                                                                     int_1 += ints_1[int_1];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               Class23.intStackSize -= 2;
                                                                                                               if (Class39.intStack[Class23.intStackSize] != Class39.intStack[Class23.intStackSize + 1]) {
                                                                                                                  int_1 += ints_1[int_1];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            int_1 += ints_1[int_1];
                                                                                                         }
                                                                                                      } else {
                                                                                                         Class39.scriptStringStack[++Class28.scriptStringStackSize - 1] = script_0.stringOperands[int_1];
                                                                                                      }
                                                                                                   } else {
                                                                                                      int_5 = ints_1[int_1];
                                                                                                      Settings.widgetSettings[int_5] = Class39.intStack[--Class23.intStackSize];
                                                                                                      DynamicObject.method1064(int_5);
                                                                                                   }
                                                                                                } else {
                                                                                                   int_5 = ints_1[int_1];
                                                                                                   Class39.intStack[++Class23.intStackSize - 1] = Settings.widgetSettings[int_5];
                                                                                                }
                                                                                             } else {
                                                                                                Class39.intStack[++Class23.intStackSize - 1] = ints_1[int_1];
                                                                                             }
                                                                                          } else {
                                                                                             boolean bool_0;
                                                                                             if (script_0.intOperands[int_1] == 1) {
                                                                                                bool_0 = true;
                                                                                             } else {
                                                                                                bool_0 = false;
                                                                                             }

                                                                                             int_6 = Class20.method208(int_13, script_0, bool_0);
                                                                                             switch(int_6) {
                                                                                             case 0:
                                                                                                return;
                                                                                             case 1:
                                                                                             default:
                                                                                                break;
                                                                                             case 2:
                                                                                                throw new IllegalStateException();
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
                           }
                        }
                     }
                  }
               }
            }
         } catch (Exception exception_0) {
            StringBuilder stringbuilder_1 = new StringBuilder(30);
            stringbuilder_1.append("").append(script_0.hash).append(" ");

            for (int_4 = Class39.scriptStackCount - 1; int_4 >= 0; --int_4) {
               stringbuilder_1.append("").append(Class39.scriptStack[int_4].invokedFromScript.hash).append(" ");
            }

            stringbuilder_1.append("").append(byte_0);
            Class13.method168(stringbuilder_1.toString(), exception_0);
         }
      }
   }

   public static boolean method201(Class90 class90_0) {
      return Class90.aClass90_1 == class90_0 || Class90.aClass90_3 == class90_0 || Class90.aClass90_5 == class90_0 || Class90.aClass90_4 == class90_0 || Class90.aClass90_6 == class90_0 || Class90.aClass90_7 == class90_0 || Class90.aClass90_8 == class90_0 || Class90.aClass90_9 == class90_0;
   }

   static void method202(IndexedSprite indexedsprite_0) {
      short short_0 = 256;

      int int_0;
      for (int_0 = 0; int_0 < Permission.anIntArray67.length; int_0++) {
         Permission.anIntArray67[int_0] = 0;
      }

      int int_1;
      for (int_0 = 0; int_0 < 5000; int_0++) {
         int_1 = (int)(Math.random() * 128.0D * (double)short_0);
         Permission.anIntArray67[int_1] = (int)(Math.random() * 256.0D);
      }

      int int_2;
      int int_3;
      for (int_0 = 0; int_0 < 20; int_0++) {
         for (int_1 = 1; int_1 < short_0 - 1; int_1++) {
            for (int_2 = 1; int_2 < 127; int_2++) {
               int_3 = int_2 + (int_1 << 7);
               Class9.anIntArray4[int_3] = (Permission.anIntArray67[int_3 - 128] + Permission.anIntArray67[int_3 + 1] + Permission.anIntArray67[int_3 + 128] + Permission.anIntArray67[int_3 - 1]) / 4;
            }
         }

         int[] ints_0 = Permission.anIntArray67;
         Permission.anIntArray67 = Class9.anIntArray4;
         Class9.anIntArray4 = ints_0;
      }

      if (indexedsprite_0 != null) {
         int_0 = 0;

         for (int_1 = 0; int_1 < indexedsprite_0.height; int_1++) {
            for (int_2 = 0; int_2 < indexedsprite_0.originalWidth; int_2++) {
               if (indexedsprite_0.pixels[int_0++] != 0) {
                  int_3 = int_2 + indexedsprite_0.offsetX + 16;
                  int int_4 = int_1 + indexedsprite_0.offsetY + 16;
                  int int_5 = int_3 + (int_4 << 7);
                  Permission.anIntArray67[int_5] = 0;
               }
            }
         }
      }

   }

}
