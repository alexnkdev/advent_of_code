import java.util.*;
import java.io.*;

class Solution {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("input.txt"));
    String line = sc.nextLine();
    Set<Point> pt = new HashSet<>();
    int santa_i = 0;
    int santa_j = 0;
    int robo_i = 0;
    int robo_j = 0;
    pt.add(new Point(0, 0));
    for (int k = 0; k < line.length(); k++) {
      char c = line.charAt(k);
      if (k % 2 == 0) {
        if (c == '^') {
          santa_i--;
        } else if (c == '>') {
          santa_j++;
        } else if (c == '<') {
          santa_j--;
        } else if (c == 'v') {
          santa_i++;
        }
      } else {
        if (c == '^') {
          robo_i--;
        } else if (c == '>') {
          robo_j++;
        } else if (c == '<') {
          robo_j--;
        } else if (c == 'v') {
          robo_i++;
        }
      }
      pt.add(new Point(santa_i, santa_j));
      pt.add(new Point(robo_i, robo_j));
    }
    System.out.println(pt.size());
  }

  static class Point {
    public int i;
    public int j;
    public Point(int i, int j) {
      this.i = i;
      this.j = j;
    }

    public boolean equals(Object o) {
      Point other = (Point) o;
      return other.i == this.i && other.j == this.j;
    }

    public int hashCode() {
      return 31 * i + j;
    }

  }

}
