import java.util.*;
import java.io.File;

class Day1 {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("input.txt"));
    List<Integer> l = new ArrayList<>();
    List<Integer> r = new ArrayList<>();
    while (sc.hasNext()) {
      int left = sc.nextInt();
      int right = sc.nextInt();
      l.add(left);
      r.add(right);
    }
    Collections.sort(l);
    Collections.sort(r);
    int ret = 0;
    for (int i = 0; i < l.size(); i++) {
      ret += Math.abs(l.get(i) - r.get(i));
    }
    sc.close();
    System.out.println(ret);
  }
}
