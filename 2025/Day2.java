import java.util.*;
import java.io.*;

class Day2_2025 {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("input.txt"));
    String line = sc.nextLine();
    String[] tokens = line.split(",");
    long ret = 0L;
    for (String range : tokens) {
      String left = range.split("-")[0];
      String right = range.split("-")[1];
      Long ll = Long.parseLong(left);
      Long rr = Long.parseLong(right);
      for (long k = ll; k <= rr; k++) {
        if (isInvalid(k)) {
          ret += k;
        }
      }
    }
    System.out.println(ret);
    sc.close();
  }

  static boolean isInvalid(long k) {
    String str = Long.toString(k);
    int n = str.length();
    for (int len = 1; len < n; len++) {
      if (n % len == 0) {
        boolean invalid = true;
        String first = str.substring(0, len);
        for (int partn = 0; partn < (n / len); partn++) {
          String part = str.substring(partn * len, partn * len + len);
          if (!part.equals(first)) {
            invalid = false;
          }
        }
        if (invalid) {
          return true;
        }
      }

    }
    return false;
  }

}
