public class AClass6_Sub2 extends AClass6 {

   int anInt427;
   int anInt428;
   int anInt429;
   int anInt430;
   int anInt431;
   int anInt432;
   int anInt433;
   int anInt434;
   int anInt435;
   int anInt436;
   int anInt437;
   int anInt438;
   int anInt439;
   boolean aBool58;
   int anInt440;

   AClass6_Sub2(AClass4_Sub1 aclass4_sub1_0, int int_0, int int_1, int int_2) {
      this.anAClass4_1 = aclass4_sub1_0;
      this.anInt435 = aclass4_sub1_0.anInt418;
      this.anInt437 = aclass4_sub1_0.anInt419;
      this.aBool58 = aclass4_sub1_0.aBool57;
      this.anInt432 = int_0;
      this.anInt428 = int_1;
      this.anInt427 = int_2;
      this.anInt433 = 0;
      this.method769();
   }

   AClass6_Sub2(AClass4_Sub1 aclass4_sub1_0, int int_0, int int_1) {
      this.anAClass4_1 = aclass4_sub1_0;
      this.anInt435 = aclass4_sub1_0.anInt418;
      this.anInt437 = aclass4_sub1_0.anInt419;
      this.aBool58 = aclass4_sub1_0.aBool57;
      this.anInt432 = int_0;
      this.anInt428 = int_1;
      this.anInt427 = 8192;
      this.anInt433 = 0;
      this.method769();
   }

   public synchronized int method765() {
      return this.anInt427 < 0 ? -1 : this.anInt427;
   }

   synchronized void method766(int int_0) {
      this.method767(int_0, this.method765());
   }

   synchronized void method767(int int_0, int int_1) {
      this.anInt428 = int_0;
      this.anInt427 = int_1;
      this.anInt431 = 0;
      this.method769();
   }

   public synchronized void method768(int int_0, int int_1, int int_2) {
      if (int_0 == 0) {
         this.method767(int_1, int_2);
      } else {
         int int_3 = method785(int_1, int_2);
         int int_4 = method786(int_1, int_2);
         if (int_3 == this.anInt434 && int_4 == this.anInt436) {
            this.anInt431 = 0;
         } else {
            int int_5 = int_1 - this.anInt429;
            if (this.anInt429 - int_1 > int_5) {
               int_5 = this.anInt429 - int_1;
            }

            if (int_3 - this.anInt434 > int_5) {
               int_5 = int_3 - this.anInt434;
            }

            if (this.anInt434 - int_3 > int_5) {
               int_5 = this.anInt434 - int_3;
            }

            if (int_4 - this.anInt436 > int_5) {
               int_5 = int_4 - this.anInt436;
            }

            if (this.anInt436 - int_4 > int_5) {
               int_5 = this.anInt436 - int_4;
            }

            if (int_0 > int_5) {
               int_0 = int_5;
            }

            this.anInt431 = int_0;
            this.anInt428 = int_1;
            this.anInt427 = int_2;
            this.anInt438 = (int_1 - this.anInt429) / int_0;
            this.anInt439 = (int_3 - this.anInt434) / int_0;
            this.anInt440 = (int_4 - this.anInt436) / int_0;
         }
      }
   }

   public synchronized void method656(int[] ints_0, int int_0, int int_1) {
      if (this.anInt428 == 0 && this.anInt431 == 0) {
         this.method657(int_1);
      } else {
         AClass4_Sub1 aclass4_sub1_0 = (AClass4_Sub1) this.anAClass4_1;
         int int_2 = this.anInt435 << 8;
         int int_3 = this.anInt437 << 8;
         int int_4 = aclass4_sub1_0.aByteArray18.length << 8;
         int int_5 = int_3 - int_2;
         if (int_5 <= 0) {
            this.anInt430 = 0;
         }

         int int_6 = int_0;
         int_1 += int_0;
         if (this.anInt433 < 0) {
            if (this.anInt432 <= 0) {
               this.method774();
               this.unlink();
               return;
            }

            this.anInt433 = 0;
         }

         if (this.anInt433 >= int_4) {
            if (this.anInt432 >= 0) {
               this.method774();
               this.unlink();
               return;
            }

            this.anInt433 = int_4 - 1;
         }

         if (this.anInt430 < 0) {
            if (this.aBool58) {
               if (this.anInt432 < 0) {
                  int_6 = this.method777(ints_0, int_0, int_2, int_1, aclass4_sub1_0.aByteArray18[this.anInt435]);
                  if (this.anInt433 >= int_2) {
                     return;
                  }

                  this.anInt433 = int_2 + int_2 - 1 - this.anInt433;
                  this.anInt432 = -this.anInt432;
               }

               while (true) {
                  int_6 = this.method780(ints_0, int_6, int_3, int_1, aclass4_sub1_0.aByteArray18[this.anInt437 - 1]);
                  if (this.anInt433 < int_3) {
                     return;
                  }

                  this.anInt433 = int_3 + int_3 - 1 - this.anInt433;
                  this.anInt432 = -this.anInt432;
                  int_6 = this.method777(ints_0, int_6, int_2, int_1, aclass4_sub1_0.aByteArray18[this.anInt435]);
                  if (this.anInt433 >= int_2) {
                     return;
                  }

                  this.anInt433 = int_2 + int_2 - 1 - this.anInt433;
                  this.anInt432 = -this.anInt432;
               }
            } else if (this.anInt432 < 0) {
               while (true) {
                  int_6 = this.method777(ints_0, int_6, int_2, int_1, aclass4_sub1_0.aByteArray18[this.anInt437 - 1]);
                  if (this.anInt433 >= int_2) {
                     return;
                  }

                  this.anInt433 = int_3 - 1 - (int_3 - 1 - this.anInt433) % int_5;
               }
            } else {
               while (true) {
                  int_6 = this.method780(ints_0, int_6, int_3, int_1, aclass4_sub1_0.aByteArray18[this.anInt435]);
                  if (this.anInt433 < int_3) {
                     return;
                  }

                  this.anInt433 = int_2 + (this.anInt433 - int_2) % int_5;
               }
            }
         } else {
            if (this.anInt430 > 0) {
               if (this.aBool58) {
                  label134: {
                     if (this.anInt432 < 0) {
                        int_6 = this.method777(ints_0, int_0, int_2, int_1, aclass4_sub1_0.aByteArray18[this.anInt435]);
                        if (this.anInt433 >= int_2) {
                           return;
                        }

                        this.anInt433 = int_2 + int_2 - 1 - this.anInt433;
                        this.anInt432 = -this.anInt432;
                        if (--this.anInt430 == 0) {
                           break label134;
                        }
                     }

                     do {
                        int_6 = this.method780(ints_0, int_6, int_3, int_1, aclass4_sub1_0.aByteArray18[this.anInt437 - 1]);
                        if (this.anInt433 < int_3) {
                           return;
                        }

                        this.anInt433 = int_3 + int_3 - 1 - this.anInt433;
                        this.anInt432 = -this.anInt432;
                        if (--this.anInt430 == 0) {
                           break;
                        }

                        int_6 = this.method777(ints_0, int_6, int_2, int_1, aclass4_sub1_0.aByteArray18[this.anInt435]);
                        if (this.anInt433 >= int_2) {
                           return;
                        }

                        this.anInt433 = int_2 + int_2 - 1 - this.anInt433;
                        this.anInt432 = -this.anInt432;
                     } while (--this.anInt430 != 0);
                  }
               } else {
                  int int_7;
                  if (this.anInt432 < 0) {
                     while (true) {
                        int_6 = this.method777(ints_0, int_6, int_2, int_1, aclass4_sub1_0.aByteArray18[this.anInt437 - 1]);
                        if (this.anInt433 >= int_2) {
                           return;
                        }

                        int_7 = (int_3 - 1 - this.anInt433) / int_5;
                        if (int_7 >= this.anInt430) {
                           this.anInt433 += int_5 * this.anInt430;
                           this.anInt430 = 0;
                           break;
                        }

                        this.anInt433 += int_5 * int_7;
                        this.anInt430 -= int_7;
                     }
                  } else {
                     while (true) {
                        int_6 = this.method780(ints_0, int_6, int_3, int_1, aclass4_sub1_0.aByteArray18[this.anInt435]);
                        if (this.anInt433 < int_3) {
                           return;
                        }

                        int_7 = (this.anInt433 - int_2) / int_5;
                        if (int_7 >= this.anInt430) {
                           this.anInt433 -= int_5 * this.anInt430;
                           this.anInt430 = 0;
                           break;
                        }

                        this.anInt433 -= int_5 * int_7;
                        this.anInt430 -= int_7;
                     }
                  }
               }
            }

            if (this.anInt432 < 0) {
               this.method777(ints_0, int_6, 0, int_1, 0);
               if (this.anInt433 < 0) {
                  this.anInt433 = -1;
                  this.method774();
                  this.unlink();
               }
            } else {
               this.method780(ints_0, int_6, int_4, int_1, 0);
               if (this.anInt433 >= int_4) {
                  this.anInt433 = int_4;
                  this.method774();
                  this.unlink();
               }
            }

         }
      }
   }

   public synchronized void method657(int int_0) {
      if (this.anInt431 > 0) {
         if (int_0 >= this.anInt431) {
            if (this.anInt428 == Integer.MIN_VALUE) {
               this.anInt428 = 0;
               this.anInt436 = 0;
               this.anInt434 = 0;
               this.anInt429 = 0;
               this.unlink();
               int_0 = this.anInt431;
            }

            this.anInt431 = 0;
            this.method769();
         } else {
            this.anInt429 += this.anInt438 * int_0;
            this.anInt434 += this.anInt439 * int_0;
            this.anInt436 += this.anInt440 * int_0;
            this.anInt431 -= int_0;
         }
      }

      AClass4_Sub1 aclass4_sub1_0 = (AClass4_Sub1) this.anAClass4_1;
      int int_1 = this.anInt435 << 8;
      int int_2 = this.anInt437 << 8;
      int int_3 = aclass4_sub1_0.aByteArray18.length << 8;
      int int_4 = int_2 - int_1;
      if (int_4 <= 0) {
         this.anInt430 = 0;
      }

      if (this.anInt433 < 0) {
         if (this.anInt432 <= 0) {
            this.method774();
            this.unlink();
            return;
         }

         this.anInt433 = 0;
      }

      if (this.anInt433 >= int_3) {
         if (this.anInt432 >= 0) {
            this.method774();
            this.unlink();
            return;
         }

         this.anInt433 = int_3 - 1;
      }

      this.anInt433 += this.anInt432 * int_0;
      if (this.anInt430 < 0) {
         if (!this.aBool58) {
            if (this.anInt432 < 0) {
               if (this.anInt433 >= int_1) {
                  return;
               }

               this.anInt433 = int_2 - 1 - (int_2 - 1 - this.anInt433) % int_4;
            } else {
               if (this.anInt433 < int_2) {
                  return;
               }

               this.anInt433 = int_1 + (this.anInt433 - int_1) % int_4;
            }

         } else {
            if (this.anInt432 < 0) {
               if (this.anInt433 >= int_1) {
                  return;
               }

               this.anInt433 = int_1 + int_1 - 1 - this.anInt433;
               this.anInt432 = -this.anInt432;
            }

            while (this.anInt433 >= int_2) {
               this.anInt433 = int_2 + int_2 - 1 - this.anInt433;
               this.anInt432 = -this.anInt432;
               if (this.anInt433 >= int_1) {
                  return;
               }

               this.anInt433 = int_1 + int_1 - 1 - this.anInt433;
               this.anInt432 = -this.anInt432;
            }

         }
      } else {
         if (this.anInt430 > 0) {
            if (this.aBool58) {
               label123: {
                  if (this.anInt432 < 0) {
                     if (this.anInt433 >= int_1) {
                        return;
                     }

                     this.anInt433 = int_1 + int_1 - 1 - this.anInt433;
                     this.anInt432 = -this.anInt432;
                     if (--this.anInt430 == 0) {
                        break label123;
                     }
                  }

                  do {
                     if (this.anInt433 < int_2) {
                        return;
                     }

                     this.anInt433 = int_2 + int_2 - 1 - this.anInt433;
                     this.anInt432 = -this.anInt432;
                     if (--this.anInt430 == 0) {
                        break;
                     }

                     if (this.anInt433 >= int_1) {
                        return;
                     }

                     this.anInt433 = int_1 + int_1 - 1 - this.anInt433;
                     this.anInt432 = -this.anInt432;
                  } while (--this.anInt430 != 0);
               }
            } else {
               label155: {
                  int int_5;
                  if (this.anInt432 < 0) {
                     if (this.anInt433 >= int_1) {
                        return;
                     }

                     int_5 = (int_2 - 1 - this.anInt433) / int_4;
                     if (int_5 >= this.anInt430) {
                        this.anInt433 += int_4 * this.anInt430;
                        this.anInt430 = 0;
                        break label155;
                     }

                     this.anInt433 += int_4 * int_5;
                     this.anInt430 -= int_5;
                  } else {
                     if (this.anInt433 < int_2) {
                        return;
                     }

                     int_5 = (this.anInt433 - int_1) / int_4;
                     if (int_5 >= this.anInt430) {
                        this.anInt433 -= int_4 * this.anInt430;
                        this.anInt430 = 0;
                        break label155;
                     }

                     this.anInt433 -= int_4 * int_5;
                     this.anInt430 -= int_5;
                  }

                  return;
               }
            }
         }

         if (this.anInt432 < 0) {
            if (this.anInt433 < 0) {
               this.anInt433 = -1;
               this.method774();
               this.unlink();
            }
         } else if (this.anInt433 >= int_3) {
            this.anInt433 = int_3;
            this.method774();
            this.unlink();
         }

      }
   }

   void method769() {
      this.anInt429 = this.anInt428;
      this.anInt434 = method785(this.anInt428, this.anInt427);
      this.anInt436 = method786(this.anInt428, this.anInt427);
   }

   public synchronized void method770(int int_0) {
      int int_1 = ((AClass4_Sub1) this.anAClass4_1).aByteArray18.length << 8;
      if (int_0 < -1) {
         int_0 = -1;
      }

      if (int_0 > int_1) {
         int_0 = int_1;
      }

      this.anInt433 = int_0;
   }

   protected AClass6 method659() {
      return null;
   }

   public boolean method771() {
      return this.anInt433 < 0 || this.anInt433 >= ((AClass4_Sub1) this.anAClass4_1).aByteArray18.length << 8;
   }

   public synchronized void method772(int int_0) {
      if (this.anInt432 < 0) {
         this.anInt432 = -int_0;
      } else {
         this.anInt432 = int_0;
      }

   }

   public synchronized void method773(int int_0) {
      if (int_0 == 0) {
         this.method766(0);
         this.unlink();
      } else if (this.anInt434 == 0 && this.anInt436 == 0) {
         this.anInt431 = 0;
         this.anInt428 = 0;
         this.anInt429 = 0;
         this.unlink();
      } else {
         int int_1 = -this.anInt429;
         if (this.anInt429 > int_1) {
            int_1 = this.anInt429;
         }

         if (-this.anInt434 > int_1) {
            int_1 = -this.anInt434;
         }

         if (this.anInt434 > int_1) {
            int_1 = this.anInt434;
         }

         if (-this.anInt436 > int_1) {
            int_1 = -this.anInt436;
         }

         if (this.anInt436 > int_1) {
            int_1 = this.anInt436;
         }

         if (int_0 > int_1) {
            int_0 = int_1;
         }

         this.anInt431 = int_0;
         this.anInt428 = Integer.MIN_VALUE;
         this.anInt438 = -this.anInt429 / int_0;
         this.anInt439 = -this.anInt434 / int_0;
         this.anInt440 = -this.anInt436 / int_0;
      }
   }

   void method774() {
      if (this.anInt431 != 0) {
         if (this.anInt428 == Integer.MIN_VALUE) {
            this.anInt428 = 0;
         }

         this.anInt431 = 0;
         this.method769();
      }

   }

   public boolean method775() {
      return this.anInt431 != 0;
   }

   public synchronized void method776() {
      this.anInt432 = (this.anInt432 ^ this.anInt432 >> 31) + (this.anInt432 >>> 31);
      this.anInt432 = -this.anInt432;
   }

   protected AClass6 method660() {
      return null;
   }

   int method661() {
      int int_0 = this.anInt429 * 3 >> 6;
      int_0 = (int_0 ^ int_0 >> 31) + (int_0 >>> 31);
      if (this.anInt430 == 0) {
         int_0 -= int_0 * this.anInt433 / (((AClass4_Sub1) this.anAClass4_1).aByteArray18.length << 8);
      } else if (this.anInt430 >= 0) {
         int_0 -= int_0 * this.anInt435 / ((AClass4_Sub1) this.anAClass4_1).aByteArray18.length;
      }

      return int_0 > 255 ? 255 : int_0;
   }

   int method777(int[] ints_0, int int_0, int int_1, int int_2, int int_3) {
      while (true) {
         if (this.anInt431 > 0) {
            int int_4 = int_0 + this.anInt431;
            if (int_4 > int_2) {
               int_4 = int_2;
            }

            this.anInt431 += int_0;
            if (this.anInt432 == -256 && (this.anInt433 & 0xFF) == 0) {
               if (AbstractSoundSystem.highMemory) {
                  int_0 = method802(0, ((AClass4_Sub1) this.anAClass4_1).aByteArray18, ints_0, this.anInt433, int_0, this.anInt434, this.anInt436, this.anInt439, this.anInt440, 0, int_4, int_1, this);
               } else {
                  int_0 = method798(((AClass4_Sub1) this.anAClass4_1).aByteArray18, ints_0, this.anInt433, int_0, this.anInt429, this.anInt438, 0, int_4, int_1, this);
               }
            } else if (AbstractSoundSystem.highMemory) {
               int_0 = method800(0, 0, ((AClass4_Sub1) this.anAClass4_1).aByteArray18, ints_0, this.anInt433, int_0, this.anInt434, this.anInt436, this.anInt439, this.anInt440, 0, int_4, int_1, this, this.anInt432, int_3);
            } else {
               int_0 = method796(0, 0, ((AClass4_Sub1) this.anAClass4_1).aByteArray18, ints_0, this.anInt433, int_0, this.anInt429, this.anInt438, 0, int_4, int_1, this, this.anInt432, int_3);
            }

            this.anInt431 -= int_0;
            if (this.anInt431 != 0) {
               return int_0;
            }

            if (!this.method779()) {
               continue;
            }

            return int_2;
         }

         if (this.anInt432 == -256 && (this.anInt433 & 0xFF) == 0) {
            if (AbstractSoundSystem.highMemory) {
               return method794(0, ((AClass4_Sub1) this.anAClass4_1).aByteArray18, ints_0, this.anInt433, int_0, this.anInt434, this.anInt436, 0, int_2, int_1, this);
            }

            return method791(((AClass4_Sub1) this.anAClass4_1).aByteArray18, ints_0, this.anInt433, int_0, this.anInt429, 0, int_2, int_1, this);
         }

         if (AbstractSoundSystem.highMemory) {
            return method792(0, 0, ((AClass4_Sub1) this.anAClass4_1).aByteArray18, ints_0, this.anInt433, int_0, this.anInt434, this.anInt436, 0, int_2, int_1, this, this.anInt432, int_3);
         }

         return method788(0, 0, ((AClass4_Sub1) this.anAClass4_1).aByteArray18, ints_0, this.anInt433, int_0, this.anInt429, 0, int_2, int_1, this, this.anInt432, int_3);
      }
   }

   public synchronized int method778() {
      return this.anInt432 < 0 ? -this.anInt432 : this.anInt432;
   }

   boolean method779() {
      int int_0 = this.anInt428;
      int int_1;
      int int_2;
      if (int_0 == Integer.MIN_VALUE) {
         int_1 = 0;
         int_2 = 0;
         int_0 = 0;
      } else {
         int_2 = method785(int_0, this.anInt427);
         int_1 = method786(int_0, this.anInt427);
      }

      if (int_0 == this.anInt429 && int_2 == this.anInt434 && int_1 == this.anInt436) {
         if (this.anInt428 == Integer.MIN_VALUE) {
            this.anInt428 = 0;
            this.anInt436 = 0;
            this.anInt434 = 0;
            this.anInt429 = 0;
            this.unlink();
            return true;
         } else {
            this.method769();
            return false;
         }
      } else {
         if (this.anInt429 < int_0) {
            this.anInt438 = 1;
            this.anInt431 = int_0 - this.anInt429;
         } else if (this.anInt429 > int_0) {
            this.anInt438 = -1;
            this.anInt431 = this.anInt429 - int_0;
         } else {
            this.anInt438 = 0;
         }

         if (this.anInt434 < int_2) {
            this.anInt439 = 1;
            if (this.anInt431 == 0 || this.anInt431 > int_2 - this.anInt434) {
               this.anInt431 = int_2 - this.anInt434;
            }
         } else if (this.anInt434 > int_2) {
            this.anInt439 = -1;
            if (this.anInt431 == 0 || this.anInt431 > this.anInt434 - int_2) {
               this.anInt431 = this.anInt434 - int_2;
            }
         } else {
            this.anInt439 = 0;
         }

         if (this.anInt436 < int_1) {
            this.anInt440 = 1;
            if (this.anInt431 == 0 || this.anInt431 > int_1 - this.anInt436) {
               this.anInt431 = int_1 - this.anInt436;
            }
         } else if (this.anInt436 > int_1) {
            this.anInt440 = -1;
            if (this.anInt431 == 0 || this.anInt431 > this.anInt436 - int_1) {
               this.anInt431 = this.anInt436 - int_1;
            }
         } else {
            this.anInt440 = 0;
         }

         return false;
      }
   }

   int method780(int[] ints_0, int int_0, int int_1, int int_2, int int_3) {
      while (true) {
         if (this.anInt431 > 0) {
            int int_4 = int_0 + this.anInt431;
            if (int_4 > int_2) {
               int_4 = int_2;
            }

            this.anInt431 += int_0;
            if (this.anInt432 == 256 && (this.anInt433 & 0xFF) == 0) {
               if (AbstractSoundSystem.highMemory) {
                  int_0 = method801(0, ((AClass4_Sub1) this.anAClass4_1).aByteArray18, ints_0, this.anInt433, int_0, this.anInt434, this.anInt436, this.anInt439, this.anInt440, 0, int_4, int_1, this);
               } else {
                  int_0 = method797(((AClass4_Sub1) this.anAClass4_1).aByteArray18, ints_0, this.anInt433, int_0, this.anInt429, this.anInt438, 0, int_4, int_1, this);
               }
            } else if (AbstractSoundSystem.highMemory) {
               int_0 = method799(0, 0, ((AClass4_Sub1) this.anAClass4_1).aByteArray18, ints_0, this.anInt433, int_0, this.anInt434, this.anInt436, this.anInt439, this.anInt440, 0, int_4, int_1, this, this.anInt432, int_3);
            } else {
               int_0 = method795(0, 0, ((AClass4_Sub1) this.anAClass4_1).aByteArray18, ints_0, this.anInt433, int_0, this.anInt429, this.anInt438, 0, int_4, int_1, this, this.anInt432, int_3);
            }

            this.anInt431 -= int_0;
            if (this.anInt431 != 0) {
               return int_0;
            }

            if (!this.method779()) {
               continue;
            }

            return int_2;
         }

         if (this.anInt432 == 256 && (this.anInt433 & 0xFF) == 0) {
            if (AbstractSoundSystem.highMemory) {
               return method793(0, ((AClass4_Sub1) this.anAClass4_1).aByteArray18, ints_0, this.anInt433, int_0, this.anInt434, this.anInt436, 0, int_2, int_1, this);
            }

            return method789(((AClass4_Sub1) this.anAClass4_1).aByteArray18, ints_0, this.anInt433, int_0, this.anInt429, 0, int_2, int_1, this);
         }

         if (AbstractSoundSystem.highMemory) {
            return method790(0, 0, ((AClass4_Sub1) this.anAClass4_1).aByteArray18, ints_0, this.anInt433, int_0, this.anInt434, this.anInt436, 0, int_2, int_1, this, this.anInt432, int_3);
         }

         return method787(0, 0, ((AClass4_Sub1) this.anAClass4_1).aByteArray18, ints_0, this.anInt433, int_0, this.anInt429, 0, int_2, int_1, this, this.anInt432, int_3);
      }
   }

   public synchronized int method781() {
      return this.anInt428 == Integer.MIN_VALUE ? 0 : this.anInt428;
   }

   public synchronized void method782(int int_0) {
      this.anInt430 = int_0;
   }

   protected int method662() {
      return this.anInt428 == 0 && this.anInt431 == 0 ? 0 : 1;
   }

   public synchronized void method783(int int_0, int int_1) {
      this.method768(int_0, int_1, this.method765());
   }

   public synchronized void method784(int int_0) {
      this.method767(int_0 << 6, this.method765());
   }

   static int method785(int int_0, int int_1) {
      return int_1 < 0 ? int_0 : (int)((double)int_0 * Math.sqrt((double)(16384 - int_1) * 1.220703125E-4D) + 0.5D);
   }

   static int method786(int int_0, int int_1) {
      return int_1 < 0 ? -int_0 : (int)((double)int_0 * Math.sqrt((double)int_1 * 1.220703125E-4D) + 0.5D);
   }

   static int method787(int int_0, int int_1, byte[] bytes_0, int[] ints_0, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, AClass6_Sub2 aclass6_sub2_0, int int_8, int int_9) {
      if (int_8 == 0 || (int_5 = int_3 + (int_8 + (int_7 - int_2) - 257) / int_8) > int_6) {
         int_5 = int_6;
      }

      byte byte_0;
      int int_10;
      while (int_3 < int_5) {
         int_1 = int_2 >> 8;
         byte_0 = bytes_0[int_1];
         int_10 = int_3++;
         ints_0[int_10] += ((byte_0 << 8) + (bytes_0[int_1 + 1] - byte_0) * (int_2 & 0xFF)) * int_4 >> 6;
         int_2 += int_8;
      }

      if (int_8 == 0 || (int_5 = int_3 + (int_8 + (int_7 - int_2) - 1) / int_8) > int_6) {
         int_5 = int_6;
      }

      for (int_1 = int_9; int_3 < int_5; int_2 += int_8) {
         byte_0 = bytes_0[int_2 >> 8];
         int_10 = int_3++;
         ints_0[int_10] += ((byte_0 << 8) + (int_1 - byte_0) * (int_2 & 0xFF)) * int_4 >> 6;
      }

      aclass6_sub2_0.anInt433 = int_2;
      return int_3;
   }

   static int method788(int int_0, int int_1, byte[] bytes_0, int[] ints_0, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, AClass6_Sub2 aclass6_sub2_0, int int_8, int int_9) {
      if (int_8 == 0 || (int_5 = int_3 + (int_8 + (int_7 + 256 - int_2)) / int_8) > int_6) {
         int_5 = int_6;
      }

      int int_10;
      while (int_3 < int_5) {
         int_1 = int_2 >> 8;
         byte byte_0 = bytes_0[int_1 - 1];
         int_10 = int_3++;
         ints_0[int_10] += ((byte_0 << 8) + (bytes_0[int_1] - byte_0) * (int_2 & 0xFF)) * int_4 >> 6;
         int_2 += int_8;
      }

      if (int_8 == 0 || (int_5 = int_3 + (int_8 + (int_7 - int_2)) / int_8) > int_6) {
         int_5 = int_6;
      }

      int_0 = int_9;

      for (int_1 = int_8; int_3 < int_5; int_2 += int_1) {
         int_10 = int_3++;
         ints_0[int_10] += ((int_0 << 8) + (bytes_0[int_2 >> 8] - int_0) * (int_2 & 0xFF)) * int_4 >> 6;
      }

      aclass6_sub2_0.anInt433 = int_2;
      return int_3;
   }

   static int method789(byte[] bytes_0, int[] ints_0, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, AClass6_Sub2 aclass6_sub2_0) {
      int_0 >>= 8;
      int_5 >>= 8;
      int_2 <<= 2;
      if ((int_3 = int_1 + int_5 - int_0) > int_4) {
         int_3 = int_4;
      }

      int int_6;
      for (int_3 -= 3; int_1 < int_3; ints_0[int_6] += bytes_0[int_0++] * int_2) {
         int_6 = int_1++;
         ints_0[int_6] += bytes_0[int_0++] * int_2;
         int_6 = int_1++;
         ints_0[int_6] += bytes_0[int_0++] * int_2;
         int_6 = int_1++;
         ints_0[int_6] += bytes_0[int_0++] * int_2;
         int_6 = int_1++;
      }

      for (int_3 += 3; int_1 < int_3; ints_0[int_6] += bytes_0[int_0++] * int_2) {
         int_6 = int_1++;
      }

      aclass6_sub2_0.anInt433 = int_0 << 8;
      return int_1;
   }

   static int method790(int int_0, int int_1, byte[] bytes_0, int[] ints_0, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8, AClass6_Sub2 aclass6_sub2_0, int int_9, int int_10) {
      if (int_9 == 0 || (int_6 = int_3 + (int_8 - int_2 + int_9 - 257) / int_9) > int_7) {
         int_6 = int_7;
      }

      int_3 <<= 1;

      byte byte_0;
      int int_11;
      for (int_6 <<= 1; int_3 < int_6; int_2 += int_9) {
         int_1 = int_2 >> 8;
         byte_0 = bytes_0[int_1];
         int_0 = (byte_0 << 8) + (int_2 & 0xFF) * (bytes_0[int_1 + 1] - byte_0);
         int_11 = int_3++;
         ints_0[int_11] += int_0 * int_4 >> 6;
         int_11 = int_3++;
         ints_0[int_11] += int_0 * int_5 >> 6;
      }

      if (int_9 == 0 || (int_6 = (int_3 >> 1) + (int_8 - int_2 + int_9 - 1) / int_9) > int_7) {
         int_6 = int_7;
      }

      int_6 <<= 1;

      for (int_1 = int_10; int_3 < int_6; int_2 += int_9) {
         byte_0 = bytes_0[int_2 >> 8];
         int_0 = (byte_0 << 8) + (int_1 - byte_0) * (int_2 & 0xFF);
         int_11 = int_3++;
         ints_0[int_11] += int_0 * int_4 >> 6;
         int_11 = int_3++;
         ints_0[int_11] += int_0 * int_5 >> 6;
      }

      aclass6_sub2_0.anInt433 = int_2;
      return int_3 >> 1;
   }

   static int method791(byte[] bytes_0, int[] ints_0, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, AClass6_Sub2 aclass6_sub2_0) {
      int_0 >>= 8;
      int_5 >>= 8;
      int_2 <<= 2;
      if ((int_3 = int_1 + int_0 - (int_5 - 1)) > int_4) {
         int_3 = int_4;
      }

      int int_6;
      for (int_3 -= 3; int_1 < int_3; ints_0[int_6] += bytes_0[int_0--] * int_2) {
         int_6 = int_1++;
         ints_0[int_6] += bytes_0[int_0--] * int_2;
         int_6 = int_1++;
         ints_0[int_6] += bytes_0[int_0--] * int_2;
         int_6 = int_1++;
         ints_0[int_6] += bytes_0[int_0--] * int_2;
         int_6 = int_1++;
      }

      for (int_3 += 3; int_1 < int_3; ints_0[int_6] += bytes_0[int_0--] * int_2) {
         int_6 = int_1++;
      }

      aclass6_sub2_0.anInt433 = int_0 << 8;
      return int_1;
   }

   static int method792(int int_0, int int_1, byte[] bytes_0, int[] ints_0, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8, AClass6_Sub2 aclass6_sub2_0, int int_9, int int_10) {
      if (int_9 == 0 || (int_6 = int_3 + (int_8 + 256 - int_2 + int_9) / int_9) > int_7) {
         int_6 = int_7;
      }

      int_3 <<= 1;

      int int_11;
      for (int_6 <<= 1; int_3 < int_6; int_2 += int_9) {
         int_1 = int_2 >> 8;
         byte byte_0 = bytes_0[int_1 - 1];
         int_0 = (bytes_0[int_1] - byte_0) * (int_2 & 0xFF) + (byte_0 << 8);
         int_11 = int_3++;
         ints_0[int_11] += int_0 * int_4 >> 6;
         int_11 = int_3++;
         ints_0[int_11] += int_0 * int_5 >> 6;
      }

      if (int_9 == 0 || (int_6 = (int_3 >> 1) + (int_8 - int_2 + int_9) / int_9) > int_7) {
         int_6 = int_7;
      }

      int_6 <<= 1;

      for (int_1 = int_10; int_3 < int_6; int_2 += int_9) {
         int_0 = (int_1 << 8) + (int_2 & 0xFF) * (bytes_0[int_2 >> 8] - int_1);
         int_11 = int_3++;
         ints_0[int_11] += int_0 * int_4 >> 6;
         int_11 = int_3++;
         ints_0[int_11] += int_0 * int_5 >> 6;
      }

      aclass6_sub2_0.anInt433 = int_2;
      return int_3 >> 1;
   }

   static int method793(int int_0, byte[] bytes_0, int[] ints_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, AClass6_Sub2 aclass6_sub2_0) {
      int_1 >>= 8;
      int_7 >>= 8;
      int_3 <<= 2;
      int_4 <<= 2;
      if ((int_5 = int_2 + int_7 - int_1) > int_6) {
         int_5 = int_6;
      }

      int_2 <<= 1;
      int_5 <<= 1;

      int int_8;
      byte byte_0;
      for (int_5 -= 6; int_2 < int_5; ints_0[int_8] += byte_0 * int_4) {
         byte_0 = bytes_0[int_1++];
         int_8 = int_2++;
         ints_0[int_8] += byte_0 * int_3;
         int_8 = int_2++;
         ints_0[int_8] += byte_0 * int_4;
         byte_0 = bytes_0[int_1++];
         int_8 = int_2++;
         ints_0[int_8] += byte_0 * int_3;
         int_8 = int_2++;
         ints_0[int_8] += byte_0 * int_4;
         byte_0 = bytes_0[int_1++];
         int_8 = int_2++;
         ints_0[int_8] += byte_0 * int_3;
         int_8 = int_2++;
         ints_0[int_8] += byte_0 * int_4;
         byte_0 = bytes_0[int_1++];
         int_8 = int_2++;
         ints_0[int_8] += byte_0 * int_3;
         int_8 = int_2++;
      }

      for (int_5 += 6; int_2 < int_5; ints_0[int_8] += byte_0 * int_4) {
         byte_0 = bytes_0[int_1++];
         int_8 = int_2++;
         ints_0[int_8] += byte_0 * int_3;
         int_8 = int_2++;
      }

      aclass6_sub2_0.anInt433 = int_1 << 8;
      return int_2 >> 1;
   }

   static int method794(int int_0, byte[] bytes_0, int[] ints_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, AClass6_Sub2 aclass6_sub2_0) {
      int_1 >>= 8;
      int_7 >>= 8;
      int_3 <<= 2;
      int_4 <<= 2;
      if ((int_5 = int_1 + int_2 - (int_7 - 1)) > int_6) {
         int_5 = int_6;
      }

      int_2 <<= 1;
      int_5 <<= 1;

      int int_8;
      byte byte_0;
      for (int_5 -= 6; int_2 < int_5; ints_0[int_8] += byte_0 * int_4) {
         byte_0 = bytes_0[int_1--];
         int_8 = int_2++;
         ints_0[int_8] += byte_0 * int_3;
         int_8 = int_2++;
         ints_0[int_8] += byte_0 * int_4;
         byte_0 = bytes_0[int_1--];
         int_8 = int_2++;
         ints_0[int_8] += byte_0 * int_3;
         int_8 = int_2++;
         ints_0[int_8] += byte_0 * int_4;
         byte_0 = bytes_0[int_1--];
         int_8 = int_2++;
         ints_0[int_8] += byte_0 * int_3;
         int_8 = int_2++;
         ints_0[int_8] += byte_0 * int_4;
         byte_0 = bytes_0[int_1--];
         int_8 = int_2++;
         ints_0[int_8] += byte_0 * int_3;
         int_8 = int_2++;
      }

      for (int_5 += 6; int_2 < int_5; ints_0[int_8] += byte_0 * int_4) {
         byte_0 = bytes_0[int_1--];
         int_8 = int_2++;
         ints_0[int_8] += byte_0 * int_3;
         int_8 = int_2++;
      }

      aclass6_sub2_0.anInt433 = int_1 << 8;
      return int_2 >> 1;
   }

   static int method795(int int_0, int int_1, byte[] bytes_0, int[] ints_0, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8, AClass6_Sub2 aclass6_sub2_0, int int_9, int int_10) {
      aclass6_sub2_0.anInt434 -= aclass6_sub2_0.anInt439 * int_3;
      aclass6_sub2_0.anInt436 -= aclass6_sub2_0.anInt440 * int_3;
      if (int_9 == 0 || (int_6 = int_3 + (int_8 - int_2 + int_9 - 257) / int_9) > int_7) {
         int_6 = int_7;
      }

      byte byte_0;
      int int_11;
      while (int_3 < int_6) {
         int_1 = int_2 >> 8;
         byte_0 = bytes_0[int_1];
         int_11 = int_3++;
         ints_0[int_11] += ((byte_0 << 8) + (bytes_0[int_1 + 1] - byte_0) * (int_2 & 0xFF)) * int_4 >> 6;
         int_4 += int_5;
         int_2 += int_9;
      }

      if (int_9 == 0 || (int_6 = int_3 + (int_8 - int_2 + int_9 - 1) / int_9) > int_7) {
         int_6 = int_7;
      }

      for (int_1 = int_10; int_3 < int_6; int_2 += int_9) {
         byte_0 = bytes_0[int_2 >> 8];
         int_11 = int_3++;
         ints_0[int_11] += ((byte_0 << 8) + (int_1 - byte_0) * (int_2 & 0xFF)) * int_4 >> 6;
         int_4 += int_5;
      }

      aclass6_sub2_0.anInt434 += aclass6_sub2_0.anInt439 * int_3;
      aclass6_sub2_0.anInt436 += aclass6_sub2_0.anInt440 * int_3;
      aclass6_sub2_0.anInt429 = int_4;
      aclass6_sub2_0.anInt433 = int_2;
      return int_3;
   }

   static int method796(int int_0, int int_1, byte[] bytes_0, int[] ints_0, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8, AClass6_Sub2 aclass6_sub2_0, int int_9, int int_10) {
      aclass6_sub2_0.anInt434 -= aclass6_sub2_0.anInt439 * int_3;
      aclass6_sub2_0.anInt436 -= aclass6_sub2_0.anInt440 * int_3;
      if (int_9 == 0 || (int_6 = int_3 + (int_8 + 256 - int_2 + int_9) / int_9) > int_7) {
         int_6 = int_7;
      }

      int int_11;
      while (int_3 < int_6) {
         int_1 = int_2 >> 8;
         byte byte_0 = bytes_0[int_1 - 1];
         int_11 = int_3++;
         ints_0[int_11] += ((byte_0 << 8) + (bytes_0[int_1] - byte_0) * (int_2 & 0xFF)) * int_4 >> 6;
         int_4 += int_5;
         int_2 += int_9;
      }

      if (int_9 == 0 || (int_6 = int_3 + (int_8 - int_2 + int_9) / int_9) > int_7) {
         int_6 = int_7;
      }

      int_0 = int_10;

      for (int_1 = int_9; int_3 < int_6; int_2 += int_1) {
         int_11 = int_3++;
         ints_0[int_11] += ((int_0 << 8) + (bytes_0[int_2 >> 8] - int_0) * (int_2 & 0xFF)) * int_4 >> 6;
         int_4 += int_5;
      }

      aclass6_sub2_0.anInt434 += aclass6_sub2_0.anInt439 * int_3;
      aclass6_sub2_0.anInt436 += aclass6_sub2_0.anInt440 * int_3;
      aclass6_sub2_0.anInt429 = int_4;
      aclass6_sub2_0.anInt433 = int_2;
      return int_3;
   }

   static int method797(byte[] bytes_0, int[] ints_0, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, AClass6_Sub2 aclass6_sub2_0) {
      int_0 >>= 8;
      int_6 >>= 8;
      int_2 <<= 2;
      int_3 <<= 2;
      if ((int_4 = int_1 + int_6 - int_0) > int_5) {
         int_4 = int_5;
      }

      aclass6_sub2_0.anInt434 += aclass6_sub2_0.anInt439 * (int_4 - int_1);
      aclass6_sub2_0.anInt436 += aclass6_sub2_0.anInt440 * (int_4 - int_1);

      int int_7;
      for (int_4 -= 3; int_1 < int_4; int_2 += int_3) {
         int_7 = int_1++;
         ints_0[int_7] += bytes_0[int_0++] * int_2;
         int_2 += int_3;
         int_7 = int_1++;
         ints_0[int_7] += bytes_0[int_0++] * int_2;
         int_2 += int_3;
         int_7 = int_1++;
         ints_0[int_7] += bytes_0[int_0++] * int_2;
         int_2 += int_3;
         int_7 = int_1++;
         ints_0[int_7] += bytes_0[int_0++] * int_2;
      }

      for (int_4 += 3; int_1 < int_4; int_2 += int_3) {
         int_7 = int_1++;
         ints_0[int_7] += bytes_0[int_0++] * int_2;
      }

      aclass6_sub2_0.anInt429 = int_2 >> 2;
      aclass6_sub2_0.anInt433 = int_0 << 8;
      return int_1;
   }

   static int method798(byte[] bytes_0, int[] ints_0, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, AClass6_Sub2 aclass6_sub2_0) {
      int_0 >>= 8;
      int_6 >>= 8;
      int_2 <<= 2;
      int_3 <<= 2;
      if ((int_4 = int_1 + int_0 - (int_6 - 1)) > int_5) {
         int_4 = int_5;
      }

      aclass6_sub2_0.anInt434 += aclass6_sub2_0.anInt439 * (int_4 - int_1);
      aclass6_sub2_0.anInt436 += aclass6_sub2_0.anInt440 * (int_4 - int_1);

      int int_7;
      for (int_4 -= 3; int_1 < int_4; int_2 += int_3) {
         int_7 = int_1++;
         ints_0[int_7] += bytes_0[int_0--] * int_2;
         int_2 += int_3;
         int_7 = int_1++;
         ints_0[int_7] += bytes_0[int_0--] * int_2;
         int_2 += int_3;
         int_7 = int_1++;
         ints_0[int_7] += bytes_0[int_0--] * int_2;
         int_2 += int_3;
         int_7 = int_1++;
         ints_0[int_7] += bytes_0[int_0--] * int_2;
      }

      for (int_4 += 3; int_1 < int_4; int_2 += int_3) {
         int_7 = int_1++;
         ints_0[int_7] += bytes_0[int_0--] * int_2;
      }

      aclass6_sub2_0.anInt429 = int_2 >> 2;
      aclass6_sub2_0.anInt433 = int_0 << 8;
      return int_1;
   }

   static int method799(int int_0, int int_1, byte[] bytes_0, int[] ints_0, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8, int int_9, int int_10, AClass6_Sub2 aclass6_sub2_0, int int_11, int int_12) {
      aclass6_sub2_0.anInt429 -= int_3 * aclass6_sub2_0.anInt438;
      if (int_11 == 0 || (int_8 = int_3 + (int_10 - int_2 + int_11 - 257) / int_11) > int_9) {
         int_8 = int_9;
      }

      int_3 <<= 1;

      byte byte_0;
      int int_13;
      for (int_8 <<= 1; int_3 < int_8; int_2 += int_11) {
         int_1 = int_2 >> 8;
         byte_0 = bytes_0[int_1];
         int_0 = (byte_0 << 8) + (int_2 & 0xFF) * (bytes_0[int_1 + 1] - byte_0);
         int_13 = int_3++;
         ints_0[int_13] += int_0 * int_4 >> 6;
         int_4 += int_6;
         int_13 = int_3++;
         ints_0[int_13] += int_0 * int_5 >> 6;
         int_5 += int_7;
      }

      if (int_11 == 0 || (int_8 = (int_3 >> 1) + (int_10 - int_2 + int_11 - 1) / int_11) > int_9) {
         int_8 = int_9;
      }

      int_8 <<= 1;

      for (int_1 = int_12; int_3 < int_8; int_2 += int_11) {
         byte_0 = bytes_0[int_2 >> 8];
         int_0 = (byte_0 << 8) + (int_1 - byte_0) * (int_2 & 0xFF);
         int_13 = int_3++;
         ints_0[int_13] += int_0 * int_4 >> 6;
         int_4 += int_6;
         int_13 = int_3++;
         ints_0[int_13] += int_0 * int_5 >> 6;
         int_5 += int_7;
      }

      int_3 >>= 1;
      aclass6_sub2_0.anInt429 += aclass6_sub2_0.anInt438 * int_3;
      aclass6_sub2_0.anInt434 = int_4;
      aclass6_sub2_0.anInt436 = int_5;
      aclass6_sub2_0.anInt433 = int_2;
      return int_3;
   }

   static int method800(int int_0, int int_1, byte[] bytes_0, int[] ints_0, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8, int int_9, int int_10, AClass6_Sub2 aclass6_sub2_0, int int_11, int int_12) {
      aclass6_sub2_0.anInt429 -= int_3 * aclass6_sub2_0.anInt438;
      if (int_11 == 0 || (int_8 = int_3 + (int_10 + 256 - int_2 + int_11) / int_11) > int_9) {
         int_8 = int_9;
      }

      int_3 <<= 1;

      int int_13;
      for (int_8 <<= 1; int_3 < int_8; int_2 += int_11) {
         int_1 = int_2 >> 8;
         byte byte_0 = bytes_0[int_1 - 1];
         int_0 = (bytes_0[int_1] - byte_0) * (int_2 & 0xFF) + (byte_0 << 8);
         int_13 = int_3++;
         ints_0[int_13] += int_0 * int_4 >> 6;
         int_4 += int_6;
         int_13 = int_3++;
         ints_0[int_13] += int_0 * int_5 >> 6;
         int_5 += int_7;
      }

      if (int_11 == 0 || (int_8 = (int_3 >> 1) + (int_10 - int_2 + int_11) / int_11) > int_9) {
         int_8 = int_9;
      }

      int_8 <<= 1;

      for (int_1 = int_12; int_3 < int_8; int_2 += int_11) {
         int_0 = (int_1 << 8) + (int_2 & 0xFF) * (bytes_0[int_2 >> 8] - int_1);
         int_13 = int_3++;
         ints_0[int_13] += int_0 * int_4 >> 6;
         int_4 += int_6;
         int_13 = int_3++;
         ints_0[int_13] += int_0 * int_5 >> 6;
         int_5 += int_7;
      }

      int_3 >>= 1;
      aclass6_sub2_0.anInt429 += aclass6_sub2_0.anInt438 * int_3;
      aclass6_sub2_0.anInt434 = int_4;
      aclass6_sub2_0.anInt436 = int_5;
      aclass6_sub2_0.anInt433 = int_2;
      return int_3;
   }

   static int method801(int int_0, byte[] bytes_0, int[] ints_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8, int int_9, AClass6_Sub2 aclass6_sub2_0) {
      int_1 >>= 8;
      int_9 >>= 8;
      int_3 <<= 2;
      int_4 <<= 2;
      int_5 <<= 2;
      int_6 <<= 2;
      if ((int_7 = int_9 + int_2 - int_1) > int_8) {
         int_7 = int_8;
      }

      aclass6_sub2_0.anInt429 += aclass6_sub2_0.anInt438 * (int_7 - int_2);
      int_2 <<= 1;
      int_7 <<= 1;

      byte byte_0;
      int int_10;
      for (int_7 -= 6; int_2 < int_7; int_4 += int_6) {
         byte_0 = bytes_0[int_1++];
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_3;
         int_3 += int_5;
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_4;
         int_4 += int_6;
         byte_0 = bytes_0[int_1++];
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_3;
         int_3 += int_5;
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_4;
         int_4 += int_6;
         byte_0 = bytes_0[int_1++];
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_3;
         int_3 += int_5;
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_4;
         int_4 += int_6;
         byte_0 = bytes_0[int_1++];
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_3;
         int_3 += int_5;
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_4;
      }

      for (int_7 += 6; int_2 < int_7; int_4 += int_6) {
         byte_0 = bytes_0[int_1++];
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_3;
         int_3 += int_5;
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_4;
      }

      aclass6_sub2_0.anInt434 = int_3 >> 2;
      aclass6_sub2_0.anInt436 = int_4 >> 2;
      aclass6_sub2_0.anInt433 = int_1 << 8;
      return int_2 >> 1;
   }

   static int method802(int int_0, byte[] bytes_0, int[] ints_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8, int int_9, AClass6_Sub2 aclass6_sub2_0) {
      int_1 >>= 8;
      int_9 >>= 8;
      int_3 <<= 2;
      int_4 <<= 2;
      int_5 <<= 2;
      int_6 <<= 2;
      if ((int_7 = int_1 + int_2 - (int_9 - 1)) > int_8) {
         int_7 = int_8;
      }

      aclass6_sub2_0.anInt429 += aclass6_sub2_0.anInt438 * (int_7 - int_2);
      int_2 <<= 1;
      int_7 <<= 1;

      byte byte_0;
      int int_10;
      for (int_7 -= 6; int_2 < int_7; int_4 += int_6) {
         byte_0 = bytes_0[int_1--];
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_3;
         int_3 += int_5;
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_4;
         int_4 += int_6;
         byte_0 = bytes_0[int_1--];
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_3;
         int_3 += int_5;
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_4;
         int_4 += int_6;
         byte_0 = bytes_0[int_1--];
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_3;
         int_3 += int_5;
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_4;
         int_4 += int_6;
         byte_0 = bytes_0[int_1--];
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_3;
         int_3 += int_5;
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_4;
      }

      for (int_7 += 6; int_2 < int_7; int_4 += int_6) {
         byte_0 = bytes_0[int_1--];
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_3;
         int_3 += int_5;
         int_10 = int_2++;
         ints_0[int_10] += byte_0 * int_4;
      }

      aclass6_sub2_0.anInt434 = int_3 >> 2;
      aclass6_sub2_0.anInt436 = int_4 >> 2;
      aclass6_sub2_0.anInt433 = int_1 << 8;
      return int_2 >> 1;
   }

   public static AClass6_Sub2 method803(AClass4_Sub1 aclass4_sub1_0, int int_0, int int_1, int int_2) {
      return aclass4_sub1_0.aByteArray18 != null && aclass4_sub1_0.aByteArray18.length != 0 ? new AClass6_Sub2(aclass4_sub1_0, int_0, int_1, int_2) : null;
   }

   public static AClass6_Sub2 method804(AClass4_Sub1 aclass4_sub1_0, int int_0, int int_1) {
      return aclass4_sub1_0.aByteArray18 != null && aclass4_sub1_0.aByteArray18.length != 0 ? new AClass6_Sub2(aclass4_sub1_0, (int)((long)aclass4_sub1_0.anInt417 * 256L * (long)int_0 / (long)(AbstractSoundSystem.sampleRate * 100)), int_1 << 6) : null;
   }

}
