import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Day7_2025 {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("input.txt"));
    List<String> lines = new ArrayList<>();
    while (sc.hasNext()) {
      String line = sc.nextLine();
      lines.add(line);
    }
    int n = lines.size();
    int m = lines.get(0).length();
    long[][] cnt = new long[n][m];
    for (int i = 0; i < m; i++) {
      if (lines.get(0).charAt(i) == 'S') {
        cnt[0][i] = 1;
      }
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (cnt[i - 1][j] > 0) {
          char c = lines.get(i).charAt(j);
          if (c == '^') {
            if (j - 1 >= 0) {
              cnt[i][j - 1] += cnt[i - 1][j];
            }
            if (j + 1 < m) {
              cnt[i][j + 1] += cnt[i - 1][j];
            }
          } else {
            cnt[i][j] += cnt[i - 1][j];
          }
        }
      }
    }
    long ret = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(cnt[i][j] + " ");

        if (i == n - 1) {
          ret+= cnt[i][j];
        }
      }
      System.out.println();
   }
    System.out.println(ret);
    sc.close();
  }


}
