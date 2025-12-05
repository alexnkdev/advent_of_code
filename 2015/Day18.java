import java.util.*;
import java.io.*;

class Solution {

  public static void main(String[] args) throws Exception {
    int n = 100;
    int m = 100;
    Scanner sc = new Scanner(new File("input.txt"));
    boolean[][] map = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      String line = sc.nextLine();
      for (int j = 0; j < m; j++) {
        if (line.charAt(j) == '#') {
          map[i][j] = true;
        } else {
          map[i][j] = false;
        }
        //if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
        //  map[i][j] = true;
        //}
      }
    }
    int[] di = new int[] { 0, -1, -1, -1, 0, 1, 1, 1 };
    int[] dj = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
    boolean[][] current = map;
    for (int step = 0; step < 100; step++) {
      boolean[][] newMap = new boolean[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          int neigbors = 0;
          for (int k = 0; k < 8; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            if (ni >= 0 && nj >= 0 && ni < n && nj < m) {
              if (current[ni][nj]) {
                neigbors++;
              }
            }
          }
          boolean corner = i == 0 || j == 0 || i == n - 1 || j == m - 1;

          if (current[i][j]) {
            newMap[i][j] = neigbors == 2 || neigbors == 3 || corner;
          } else {
            newMap[i][j] = neigbors == 3;
          }
          
        }
      }
      current = newMap;
      //current[0][0] = true;
      //current[n - 1][0] = true;
      //current[0][m - 1] = true;
      //current[n - 1][m - 1] = true;
    }
    int total = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (current[i][j]) {
          total++;
        }
      }
    }
    System.out.println(total);
  }
}
