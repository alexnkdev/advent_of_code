import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Day4 {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("input.txt"));
    long ret = 0;

    List<String> lines = new ArrayList<>();

    while (sc.hasNext()) {
      String line = sc.nextLine();
      lines.add(line);
    }

    int n = lines.size();
    int m = lines.get(0).length();

    boolean[][] removed = new boolean[n][m];

    int[] di = new int[] { 0, -1, -1, -1, 0, 1, 1, 1 };
    int[] dj = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };

    while (true) {
      boolean hasRemoved = false;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          char c = lines.get(i).charAt(j);
          if (c == '@' && !removed[i][j]) {
            int cnt = 0;
            for (int k = 0; k < 8; k++) {
              int ni = i + di[k];
              int nj = j + dj[k];
              if (ni >= 0 && nj >= 0 && ni < n && nj < m) {
                if (lines.get(ni).charAt(nj) == '@' && !removed[ni][nj]) {
                  cnt++;
                }
              }
            }
            if (cnt < 4) {
              removed[i][j] = true;
              hasRemoved = true;
              ret++;
            }
          }
        }
      }
      if (!hasRemoved) {
        break;
      }
    }

    System.out.println(ret);

    System.out.println(ret);
    sc.close();
  }

}
