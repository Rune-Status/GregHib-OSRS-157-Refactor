import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

public class World {

   static int worldCount;
   static int anInt219;
   static int[] anIntArray57;
   static int[] anIntArray58;
   int mask;
   int index;
   int playerCount;
   String address;
   int id;
   String activity;
   int location;

   static {
      worldCount = 0;
      anInt219 = 0;
      anIntArray57 = new int[] {1, 1, 1, 1};
      anIntArray58 = new int[] {0, 1, 2, 3};
   }

   boolean method551() {
      return (0x1 & this.mask) != 0;
   }

   boolean method552() {
      return (0x2000000 & this.mask) != 0;
   }

   boolean method553() {
      return (0x20000000 & this.mask) != 0;
   }

   boolean method554() {
      return (0x4 & this.mask) != 0;
   }

   boolean method555() {
      return (0x8 & this.mask) != 0;
   }

   boolean method556() {
      return (0x2 & this.mask) != 0;
   }

   static void method557() {
      Overlay.overlays.reset();
      Class94.method518();
      Node_Sub5.method694();
      ObjectDefinition.objects.reset();
      ObjectDefinition.modelCache.reset();
      ObjectDefinition.cachedModels.reset();
      ObjectDefinition.objectDefinitionCache.reset();
      NPCDefinition.npcs.reset();
      NPCDefinition.npcModelCache.reset();
      Client.method1109();
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
      Spotanim.spotanims.reset();
      Spotanim.aNodeCache6.reset();
      CombatInfoListHolder.method651();
      VarPlayerType.varPlayerCache.reset();
      CacheableNode_Sub6.aNodeCache16.reset();
      CacheableNode_Sub6.spritePixelsCache.reset();
      CacheableNode_Sub6.fontIndexCache.reset();
      Class41.method261();
      Class62.method398();
      CacheableNode_Sub5.aNodeCache14.reset();
      Area.skeletonsIndex.reset();
      PlayerComposition.aNodeCache1.reset();
      Widget.spritePixelsCache.reset();
      Widget.widgetModelCache.reset();
      Widget.fontCache.reset();
      Widget.spriteCache.reset();
      ((TextureProvider) Rasterizer3D.textureLoader).reset();
      Script.aNodeCache18.reset();
      Varcs.interfacesIndex.reset();
      Class6.skinsIndex.reset();
      Class56.interfaceDataIndex.reset();
      Tile.soundEffectsIndex.reset();
      Class23.mapsIndex.reset();
      Class38.songsIndex.reset();
      Class4.modelsIndex.reset();
      Class34.spritesIndex.reset();
      Class49.texturesIndex.reset();
      AbstractSoundSystem.wordPackIndex.reset();
      Class92.musicConfigIndex.reset();
      Class3.interfaceScriptDataIndex.reset();
   }

   public static void encodeClassVerifier(PacketBuffer packetbuffer_0) {
      ClassInfo classinfo_0 = (ClassInfo) Class108.aCombatInfoList4.method454();
      if (classinfo_0 != null) {
         int int_0 = packetbuffer_0.position;
         packetbuffer_0.putInt(classinfo_0.anInt371);

         for (int int_1 = 0; int_1 < classinfo_0.count; int_1++) {
            if (classinfo_0.errorIdentifiers[int_1] != 0) {
               packetbuffer_0.putByte(classinfo_0.errorIdentifiers[int_1]);
            } else {
               try {
                  int int_2 = classinfo_0.type[int_1];
                  Field field_0;
                  int int_3;
                  if (int_2 == 0) {
                     field_0 = classinfo_0.fields[int_1];
                     int_3 = field_0.getInt((Object) null);
                     packetbuffer_0.putByte(0);
                     packetbuffer_0.putInt(int_3);
                  } else if (int_2 == 1) {
                     field_0 = classinfo_0.fields[int_1];
                     field_0.setInt((Object) null, classinfo_0.anIntArray78[int_1]);
                     packetbuffer_0.putByte(0);
                  } else if (int_2 == 2) {
                     field_0 = classinfo_0.fields[int_1];
                     int_3 = field_0.getModifiers();
                     packetbuffer_0.putByte(0);
                     packetbuffer_0.putInt(int_3);
                  }

                  Method method_0;
                  if (int_2 != 3) {
                     if (int_2 == 4) {
                        method_0 = classinfo_0.methods[int_1];
                        int_3 = method_0.getModifiers();
                        packetbuffer_0.putByte(0);
                        packetbuffer_0.putInt(int_3);
                     }
                  } else {
                     method_0 = classinfo_0.methods[int_1];
                     byte[][] bytes_0 = classinfo_0.args[int_1];
                     Object[] objects_0 = new Object[bytes_0.length];

                     for (int int_4 = 0; int_4 < bytes_0.length; int_4++) {
                        ObjectInputStream objectinputstream_0 = new ObjectInputStream(new ByteArrayInputStream(bytes_0[int_4]));
                        objects_0[int_4] = objectinputstream_0.readObject();
                     }

                     Object object_0 = method_0.invoke((Object) null, objects_0);
                     if (object_0 == null) {
                        packetbuffer_0.putByte(0);
                     } else if (object_0 instanceof Number) {
                        packetbuffer_0.putByte(1);
                        packetbuffer_0.putLong(((Number) object_0).longValue());
                     } else if (object_0 instanceof String) {
                        packetbuffer_0.putByte(2);
                        packetbuffer_0.putString((String) object_0);
                     } else {
                        packetbuffer_0.putByte(4);
                     }
                  }
               } catch (ClassNotFoundException classnotfoundexception_0) {
                  packetbuffer_0.putByte(-10);
               } catch (InvalidClassException invalidclassexception_0) {
                  packetbuffer_0.putByte(-11);
               } catch (StreamCorruptedException streamcorruptedexception_0) {
                  packetbuffer_0.putByte(-12);
               } catch (OptionalDataException optionaldataexception_0) {
                  packetbuffer_0.putByte(-13);
               } catch (IllegalAccessException illegalaccessexception_0) {
                  packetbuffer_0.putByte(-14);
               } catch (IllegalArgumentException illegalargumentexception_0) {
                  packetbuffer_0.putByte(-15);
               } catch (InvocationTargetException invocationtargetexception_0) {
                  packetbuffer_0.putByte(-16);
               } catch (SecurityException securityexception_0) {
                  packetbuffer_0.putByte(-17);
               } catch (IOException ioexception_0) {
                  packetbuffer_0.putByte(-18);
               } catch (NullPointerException nullpointerexception_0) {
                  packetbuffer_0.putByte(-19);
               } catch (Exception exception_0) {
                  packetbuffer_0.putByte(-20);
               } catch (Throwable throwable_0) {
                  packetbuffer_0.putByte(-21);
               }
            }
         }

         packetbuffer_0.putCrc(int_0);
         classinfo_0.unlink();
      }
   }

   static boolean method558(String string_0, int int_0, String string_1) {
      if (int_0 == 0) {
         try {
            if (!Class23.aString3.startsWith("win")) {
               throw new Exception();
            } else if (!string_0.startsWith("http://") && !string_0.startsWith("https://")) {
               throw new Exception();
            } else {
               String string_2 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for (int int_1 = 0; int_1 < string_0.length(); int_1++) {
                  if (string_2.indexOf(string_0.charAt(int_1)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + string_0 + "\"");
               return true;
            }
         } catch (Throwable throwable_0) {
            return false;
         }
      } else if (int_0 == 1) {
         try {
            Object object_0 = Class22.method215(Class23.anApplet1, string_1, new Object[] {(new URL(Class23.anApplet1.getCodeBase(), string_0)).toString()});
            return object_0 != null;
         } catch (Throwable throwable_1) {
            return false;
         }
      } else if (int_0 == 2) {
         try {
            Class23.anApplet1.getAppletContext().showDocument(new URL(Class23.anApplet1.getCodeBase(), string_0), "_blank");
            return true;
         } catch (Exception exception_0) {
            return false;
         }
      } else if (int_0 == 3) {
         try {
            Class22.method214(Class23.anApplet1, "loggedout");
         } catch (Throwable throwable_2) {
            ;
         }

         try {
            Class23.anApplet1.getAppletContext().showDocument(new URL(Class23.anApplet1.getCodeBase(), string_0), "_top");
            return true;
         } catch (Exception exception_1) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

}
