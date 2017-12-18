public class CollisionData {

   int width;
   int x;
   public int[][] adjacency;
   int height;
   int y;

   public CollisionData(int int_0, int int_1) {
      this.x = 0;
      this.y = 0;
      this.width = int_0;
      this.height = int_1;
      this.adjacency = new int[this.width][this.height];
      this.reset();
   }

   void remove(int x, int y, int flag) {
      this.adjacency[x][y] &= ~flag;
   }

   void add(int int_0, int int_1, int int_2) {
      this.adjacency[int_0][int_1] |= int_2;
   }

   public void reset() {
      for (int int_0 = 0; int_0 < this.width; int_0++) {
         for (int int_1 = 0; int_1 < this.height; int_1++) {
            if (int_0 != 0 && int_1 != 0 && int_0 < this.width - 5 && int_1 < this.height - 5) {
               this.adjacency[int_0][int_1] = 16777216;
            } else {
               this.adjacency[int_0][int_1] = 16777215;
            }
         }
      }

   }

   public void removeWall(int x, int y, int position, int orientation, boolean projectileClipped) {
      x -= this.x;
      y -= this.y;
      if (position == 0) {
         if (orientation == 0) {
            this.remove(x, y, 128);
            this.remove(x - 1, y, 8);
         }

         if (orientation == 1) {
            this.remove(x, y, 2);
            this.remove(x, y + 1, 32);
         }

         if (orientation == 2) {
            this.remove(x, y, 8);
            this.remove(x + 1, y, 128);
         }

         if (orientation == 3) {
            this.remove(x, y, 32);
            this.remove(x, y - 1, 2);
         }
      }

      if (position == 1 || position == 3) {
         if (orientation == 0) {
            this.remove(x, y, 1);
            this.remove(x - 1, y + 1, 16);
         }

         if (orientation == 1) {
            this.remove(x, y, 4);
            this.remove(x + 1, y + 1, 64);
         }

         if (orientation == 2) {
            this.remove(x, y, 16);
            this.remove(x + 1, y - 1, 1);
         }

         if (orientation == 3) {
            this.remove(x, y, 64);
            this.remove(x - 1, y - 1, 4);
         }
      }

      if (position == 2) {
         if (orientation == 0) {
            this.remove(x, y, 130);
            this.remove(x - 1, y, 8);
            this.remove(x, y + 1, 32);
         }

         if (orientation == 1) {
            this.remove(x, y, 10);
            this.remove(x, y + 1, 32);
            this.remove(x + 1, y, 128);
         }

         if (orientation == 2) {
            this.remove(x, y, 40);
            this.remove(x + 1, y, 128);
            this.remove(x, y - 1, 2);
         }

         if (orientation == 3) {
            this.remove(x, y, 160);
            this.remove(x, y - 1, 2);
            this.remove(x - 1, y, 8);
         }
      }

      if (projectileClipped) {
         if (position == 0) {
            if (orientation == 0) {
               this.remove(x, y, 65536);
               this.remove(x - 1, y, 4096);
            }

            if (orientation == 1) {
               this.remove(x, y, 1024);
               this.remove(x, y + 1, 16384);
            }

            if (orientation == 2) {
               this.remove(x, y, 4096);
               this.remove(x + 1, y, 65536);
            }

            if (orientation == 3) {
               this.remove(x, y, 16384);
               this.remove(x, y - 1, 1024);
            }
         }

         if (position == 1 || position == 3) {
            if (orientation == 0) {
               this.remove(x, y, 512);
               this.remove(x - 1, y + 1, 8192);
            }

            if (orientation == 1) {
               this.remove(x, y, 2048);
               this.remove(x + 1, y + 1, 32768);
            }

            if (orientation == 2) {
               this.remove(x, y, 8192);
               this.remove(x + 1, y - 1, 512);
            }

            if (orientation == 3) {
               this.remove(x, y, 32768);
               this.remove(x - 1, y - 1, 2048);
            }
         }

         if (position == 2) {
            if (orientation == 0) {
               this.remove(x, y, 66560);
               this.remove(x - 1, y, 4096);
               this.remove(x, y + 1, 16384);
            }

            if (orientation == 1) {
               this.remove(x, y, 5120);
               this.remove(x, y + 1, 16384);
               this.remove(x + 1, y, 65536);
            }

            if (orientation == 2) {
               this.remove(x, y, 20480);
               this.remove(x + 1, y, 65536);
               this.remove(x, y - 1, 1024);
            }

            if (orientation == 3) {
               this.remove(x, y, 81920);
               this.remove(x, y - 1, 1024);
               this.remove(x - 1, y, 4096);
            }
         }
      }

   }

   public void unblock(int x, int y) {
      x -= this.x;
      y -= this.y;
      this.adjacency[x][y] &= 0xFFFBFFFF;
   }

   public void removeObject(int int_0, int int_1, int int_2, int int_3, int int_4, boolean bool_0) {
      int int_5 = 256;
      if (bool_0) {
         int_5 += 131072;
      }

      int_0 -= this.x;
      int_1 -= this.y;
      int int_6;
      if (int_4 == 1 || int_4 == 3) {
         int_6 = int_2;
         int_2 = int_3;
         int_3 = int_6;
      }

      for (int_6 = int_0; int_6 < int_2 + int_0; int_6++) {
         if (int_6 >= 0 && int_6 < this.width) {
            for (int int_7 = int_1; int_7 < int_1 + int_3; int_7++) {
               if (int_7 >= 0 && int_7 < this.height) {
                  this.remove(int_6, int_7, int_5);
               }
            }
         }
      }

   }

   public void block(int int_0, int int_1) {
      int_0 -= this.x;
      int_1 -= this.y;
      this.adjacency[int_0][int_1] |= 0x40000;
   }

   public void addObject(int int_0, int int_1, int int_2, int int_3, boolean bool_0) {
      int int_4 = 256;
      if (bool_0) {
         int_4 += 131072;
      }

      int_0 -= this.x;
      int_1 -= this.y;

      for (int int_5 = int_0; int_5 < int_2 + int_0; int_5++) {
         if (int_5 >= 0 && int_5 < this.width) {
            for (int int_6 = int_1; int_6 < int_1 + int_3; int_6++) {
               if (int_6 >= 0 && int_6 < this.height) {
                  this.add(int_5, int_6, int_4);
               }
            }
         }
      }

   }

   public void addWall(int int_0, int int_1, int int_2, int int_3, boolean bool_0) {
      int_0 -= this.x;
      int_1 -= this.y;
      if (int_2 == 0) {
         if (int_3 == 0) {
            this.add(int_0, int_1, 128);
            this.add(int_0 - 1, int_1, 8);
         }

         if (int_3 == 1) {
            this.add(int_0, int_1, 2);
            this.add(int_0, int_1 + 1, 32);
         }

         if (int_3 == 2) {
            this.add(int_0, int_1, 8);
            this.add(int_0 + 1, int_1, 128);
         }

         if (int_3 == 3) {
            this.add(int_0, int_1, 32);
            this.add(int_0, int_1 - 1, 2);
         }
      }

      if (int_2 == 1 || int_2 == 3) {
         if (int_3 == 0) {
            this.add(int_0, int_1, 1);
            this.add(int_0 - 1, int_1 + 1, 16);
         }

         if (int_3 == 1) {
            this.add(int_0, int_1, 4);
            this.add(int_0 + 1, int_1 + 1, 64);
         }

         if (int_3 == 2) {
            this.add(int_0, int_1, 16);
            this.add(int_0 + 1, int_1 - 1, 1);
         }

         if (int_3 == 3) {
            this.add(int_0, int_1, 64);
            this.add(int_0 - 1, int_1 - 1, 4);
         }
      }

      if (int_2 == 2) {
         if (int_3 == 0) {
            this.add(int_0, int_1, 130);
            this.add(int_0 - 1, int_1, 8);
            this.add(int_0, int_1 + 1, 32);
         }

         if (int_3 == 1) {
            this.add(int_0, int_1, 10);
            this.add(int_0, int_1 + 1, 32);
            this.add(int_0 + 1, int_1, 128);
         }

         if (int_3 == 2) {
            this.add(int_0, int_1, 40);
            this.add(int_0 + 1, int_1, 128);
            this.add(int_0, int_1 - 1, 2);
         }

         if (int_3 == 3) {
            this.add(int_0, int_1, 160);
            this.add(int_0, int_1 - 1, 2);
            this.add(int_0 - 1, int_1, 8);
         }
      }

      if (bool_0) {
         if (int_2 == 0) {
            if (int_3 == 0) {
               this.add(int_0, int_1, 65536);
               this.add(int_0 - 1, int_1, 4096);
            }

            if (int_3 == 1) {
               this.add(int_0, int_1, 1024);
               this.add(int_0, int_1 + 1, 16384);
            }

            if (int_3 == 2) {
               this.add(int_0, int_1, 4096);
               this.add(int_0 + 1, int_1, 65536);
            }

            if (int_3 == 3) {
               this.add(int_0, int_1, 16384);
               this.add(int_0, int_1 - 1, 1024);
            }
         }

         if (int_2 == 1 || int_2 == 3) {
            if (int_3 == 0) {
               this.add(int_0, int_1, 512);
               this.add(int_0 - 1, int_1 + 1, 8192);
            }

            if (int_3 == 1) {
               this.add(int_0, int_1, 2048);
               this.add(int_0 + 1, int_1 + 1, 32768);
            }

            if (int_3 == 2) {
               this.add(int_0, int_1, 8192);
               this.add(int_0 + 1, int_1 - 1, 512);
            }

            if (int_3 == 3) {
               this.add(int_0, int_1, 32768);
               this.add(int_0 - 1, int_1 - 1, 2048);
            }
         }

         if (int_2 == 2) {
            if (int_3 == 0) {
               this.add(int_0, int_1, 66560);
               this.add(int_0 - 1, int_1, 4096);
               this.add(int_0, int_1 + 1, 16384);
            }

            if (int_3 == 1) {
               this.add(int_0, int_1, 5120);
               this.add(int_0, int_1 + 1, 16384);
               this.add(int_0 + 1, int_1, 65536);
            }

            if (int_3 == 2) {
               this.add(int_0, int_1, 20480);
               this.add(int_0 + 1, int_1, 65536);
               this.add(int_0, int_1 - 1, 1024);
            }

            if (int_3 == 3) {
               this.add(int_0, int_1, 81920);
               this.add(int_0, int_1 - 1, 1024);
               this.add(int_0 - 1, int_1, 4096);
            }
         }
      }

   }

   public void method581(int int_0, int int_1) {
      int_0 -= this.x;
      int_1 -= this.y;
      this.adjacency[int_0][int_1] |= 0x200000;
   }

}
