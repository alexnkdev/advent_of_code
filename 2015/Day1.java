import java.util.*;
import java.io.*;

class Day1 {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("input.txt"));
    String line = sc.nextLine();
    int floor = 0;
    for (int i = 0; i < line.length(); i++) {
      char c = line.charAt(i);
      if (c == '(') {
        floor++;
      } else {
        floor--;
      }
      if (floor == -1) {
        System.out.println(i + 1);
        break;
      }
    }
    System.out.println(floor);
    sc.close();
  }
}
