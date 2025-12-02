import java.util.*;
import java.io.*;

class Solution {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(new File("input.txt"));
    int ret = 0;
    while (sc.hasNext()) {
      String l = sc.nextLine();
      if (isNice(l)) {
        ret++;
      }
    }
    System.out.println(ret);
    sc.close();
  }

  public static boolean isNice(String line) {
    boolean hasPair = false;
    for (int i = 0; i < line.length() - 1; i++) {
      for (int j = i + 2; j < line.length() - 1; j++) {
        String s1 = line.substring(i, i + 2);
        String s2 = line.substring(j, j + 2);
        if (s1.equals(s2)) {
          hasPair = true;
          break;
        }
      }
    }
    if (!hasPair) {
      return false;
    }

    boolean hasTriple = false;
    for (int i = 0; i < line.length() - 2; i++) {
      char c1 = line.charAt(i);
      char m = line.charAt(i + 1);
      char c2 = line.charAt(i + 2);
      if (c1 == c2) {
        hasTriple = true;
        break;
      }
    }
    if (!hasTriple) {
      return false;
    }
    return true;
  }
}
