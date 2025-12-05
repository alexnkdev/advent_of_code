import java.util.*;
import java.io.*;

class Day10 {

  public static void main(String[] args) {
    String line = "1113122113";
    for (int step = 0; step < 50; step++) {
      line = apply(line);
      System.out.println(step + " done");
    }
    System.out.println(line.length());
  }

  public static String apply(String line) {
    int i = 0;
    StringBuilder ret = new StringBuilder();
    while (i < line.length()) {
      char c = line.charAt(i);
      int cnt = 1;
      while (i < line.length() - 1 && line.charAt(i + 1) == c) {
        cnt++;
        i++;
      }
      ret.append("" + cnt);
      ret.append(c);
      i++;
    }
    return ret.toString();
  }

}
