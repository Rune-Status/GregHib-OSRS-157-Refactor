public class CollisionMap {

   int width;
   int x;
   public int[][] adjacency;
   int height;
   int y;

   public CollisionMap(int width, int height) {
      this.x = 0;
      this.y = 0;
      this.width = width;
      this.height = height;
      this.adjacency = new int[this.width][this.height];
      this.reset();
   }

   void remove(int x, int y, int flag) {
      this.adjacency[x][y] &= ~flag;
   }

   void add(int x, int y, int flag) {
      this.adjacency[x][y] |= flag;
   }

   public void reset() {
      for (int x = 0; x < this.width; x++) {
         for (int y = 0; y < this.height; y++) {
            if (x != 0 && y != 0 && x < this.width - 5 && y < this.height - 5) {
               this.adjacency[x][y] = 16777216;
            } else {
               this.adjacency[x][y] = 16777215;
            }
         }
      }

   }

   public void removeWall(int x, int y, int position, int orientation, boolean impenetrable) {
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

      if (impenetrable) {
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

   public void removeObject(int x, int y, int width, int height, int orientation, boolean impenetrable) {
      int occupied = 256;
      if (impenetrable) {
         occupied += 131072;
      }

      x -= this.x;
      y -= this.y;
      int dx;
      if (orientation == 1 || orientation == 3) {
         dx = width;
         width = height;
         height = dx;
      }

      for (dx = x; dx < width + x; dx++) {
         if (dx >= 0 && dx < this.width) {
            for (int dy = y; dy < y + height; dy++) {
               if (dy >= 0 && dy < this.height) {
                  this.remove(dx, dy, occupied);
               }
            }
         }
      }
   }

   public void block(int x, int y) {
      x -= this.x;
      y -= this.y;
      this.adjacency[x][y] |= 0x40000;
   }

   public void addObject(int x, int y, int int_2, int int_3, boolean impenetrable) {
      int occupied = 256;
      if (impenetrable) {
         occupied += 131072;
      }

      x -= this.x;
      y -= this.y;

      for (int width = x; width < int_2 + x; width++) {
         if (width >= 0 && width < this.width) {
            for (int height = y; height < y + int_3; height++) {
               if (height >= 0 && height < this.height) {
                  this.add(width, height, occupied);
               }
            }
         }
      }

   }

   public void addWall(int x, int y, int position, int orientation, boolean impenetrable) {
      x -= this.x;
      y -= this.y;
      if (position == 0) {
         if (orientation == 0) {
            this.add(x, y, 128);
            this.add(x - 1, y, 8);
         }

         if (orientation == 1) {
            this.add(x, y, 2);
            this.add(x, y + 1, 32);
         }

         if (orientation == 2) {
            this.add(x, y, 8);
            this.add(x + 1, y, 128);
         }

         if (orientation == 3) {
            this.add(x, y, 32);
            this.add(x, y - 1, 2);
         }
      }

      if (position == 1 || position == 3) {
         if (orientation == 0) {
            this.add(x, y, 1);
            this.add(x - 1, y + 1, 16);
         }

         if (orientation == 1) {
            this.add(x, y, 4);
            this.add(x + 1, y + 1, 64);
         }

         if (orientation == 2) {
            this.add(x, y, 16);
            this.add(x + 1, y - 1, 1);
         }

         if (orientation == 3) {
            this.add(x, y, 64);
            this.add(x - 1, y - 1, 4);
         }
      }

      if (position == 2) {
         if (orientation == 0) {
            this.add(x, y, 130);
            this.add(x - 1, y, 8);
            this.add(x, y + 1, 32);
         }

         if (orientation == 1) {
            this.add(x, y, 10);
            this.add(x, y + 1, 32);
            this.add(x + 1, y, 128);
         }

         if (orientation == 2) {
            this.add(x, y, 40);
            this.add(x + 1, y, 128);
            this.add(x, y - 1, 2);
         }

         if (orientation == 3) {
            this.add(x, y, 160);
            this.add(x, y - 1, 2);
            this.add(x - 1, y, 8);
         }
      }

      if (impenetrable) {
         if (position == 0) {
            if (orientation == 0) {
               this.add(x, y, 65536);
               this.add(x - 1, y, 4096);
            }

            if (orientation == 1) {
               this.add(x, y, 1024);
               this.add(x, y + 1, 16384);
            }

            if (orientation == 2) {
               this.add(x, y, 4096);
               this.add(x + 1, y, 65536);
            }

            if (orientation == 3) {
               this.add(x, y, 16384);
               this.add(x, y - 1, 1024);
            }
         }

         if (position == 1 || position == 3) {
            if (orientation == 0) {
               this.add(x, y, 512);
               this.add(x - 1, y + 1, 8192);
            }

            if (orientation == 1) {
               this.add(x, y, 2048);
               this.add(x + 1, y + 1, 32768);
            }

            if (orientation == 2) {
               this.add(x, y, 8192);
               this.add(x + 1, y - 1, 512);
            }

            if (orientation == 3) {
               this.add(x, y, 32768);
               this.add(x - 1, y - 1, 2048);
            }
         }

         if (position == 2) {
            if (orientation == 0) {
               this.add(x, y, 66560);
               this.add(x - 1, y, 4096);
               this.add(x, y + 1, 16384);
            }

            if (orientation == 1) {
               this.add(x, y, 5120);
               this.add(x, y + 1, 16384);
               this.add(x + 1, y, 65536);
            }

            if (orientation == 2) {
               this.add(x, y, 20480);
               this.add(x + 1, y, 65536);
               this.add(x, y - 1, 1024);
            }

            if (orientation == 3) {
               this.add(x, y, 81920);
               this.add(x, y - 1, 1024);
               this.add(x - 1, y, 4096);
            }
         }
      }

   }

   public void addBlocked(int x, int y) {
      x -= this.x;
      y -= this.y;
      this.adjacency[x][y] |= 0x200000;
   }

}
