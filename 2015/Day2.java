import java.util.*;
import java.io.*;

class Day2 {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("input.txt"));
    long ret = 0;
    long ribbon = 0;
    while (sc.hasNext()) {
      String line = sc.nextLine();
      String[] tokens = line.split("x");
      long a = Long.parseLong(tokens[0]);
      long b = Long.parseLong(tokens[1]);
      long c = Long.parseLong(tokens[2]);
      ret += 2 * (b * c) + 2 * (a * c) + 2 * (a * b);
      long slack = b * c;
      slack = Math.min(slack, a * c);
      slack = Math.min(slack, a * b);
      ret += slack;

      long rib = 2 * (a + b);
      rib = Math.min(rib, 2 * (a + c));
      rib = Math.min(rib, 2 * (b + c));

      ribbon += rib;
      ribbon += a * b * c;
    }
    System.out.println(ret);
    System.out.println(ribbon);
    sc.close();
  }
}
