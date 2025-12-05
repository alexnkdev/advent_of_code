import java.util.*;
import java.io.*;

class Day1_2025 {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("input.txt"));
    int current = 50;
    int ret= 0;
    while (sc.hasNext()) {
      String line = sc.nextLine();
      if (line.startsWith("L")) {
        int amount = Integer.parseInt(line.substring(1));
        for (int k = 0; k < amount; k++) {
          current--;
          if (current < 0) {
            current = 99;
          }
          if (current == 0) {
            ret++;
          }
        }
      } else if (line.startsWith("R")) {
        int amount = Integer.parseInt(line.substring(1));
        for (int k = 0; k < amount; k++) {
          current++;
          if (current == 100) {
            current = 0;
          
          }
          if (current == 0) {
            ret++;
          }
        }
      }
    }
    System.out.println(ret);
    sc.close();
  }
}
