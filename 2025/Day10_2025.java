import java.io.File;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Day9_2025 {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("input.txt"));
    List<Long> is = new ArrayList<>();
    List<Long> js = new ArrayList<>();
    while (sc.hasNext()) {
      String line = sc.nextLine();
      String[] tokens = line.split(",");
      is.add(Long.parseLong(tokens[0]));
      js.add(Long.parseLong(tokens[1]));
    }
    int n = is.size();
    Long area = null;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        Long a = Math.abs(is.get(i) - is.get(j)) * Math.abs(js.get(i) - js.get(j));
        if (area == null) {
          area = a;
        } else {
          area = Math.max(area, a);
        }
      }
    }
    System.out.println(area);
    sc.close();
  }


}
