import java.util.*;
import java.io.*;

class Day1_Part2 {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("input_day1_part2.txt"));
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    Map<Integer, Integer> freq = new HashMap<>();
    while (sc.hasNext()) {
      left.add(sc.nextInt());
      int rr = sc.nextInt();
      right.add(rr);
      freq.put(rr, freq.getOrDefault(rr, 0) + 1);
    }
    int ret = 0;
    for (Integer l : left) {
      ret += l * freq.getOrDefault(l, 0);
    }
    System.out.println(ret);
    sc.close();
  }

}
