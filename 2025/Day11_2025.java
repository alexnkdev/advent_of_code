import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Day11_2025 {

  static Map<String, List<String>> graph;
  static Map<String, Long> cache;

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("input.txt"));
    graph = new HashMap<>();
    while (sc.hasNext()) {
      String line = sc.nextLine();
      String[] tokens = line.split(" ");
      String from = tokens[0].substring(0, tokens[0].length() - 1);
      for (int i = 1; i < tokens.length; i++) {
        String to = tokens[i];
        if (graph.get(from) == null) {
          graph.put(from, new ArrayList<>());
        }
        graph.get(from).add(to);
      }
    }
    cache = new HashMap<>();
    long res = rec("svr", false, false);
    System.out.println(res);
    sc.close();
  }

  static long rec(String current, boolean dacVisited, boolean fftVisited) {
    String key = current + "_" + dacVisited + "_" + fftVisited;
    if (cache.get(key) != null) {
      return cache.get(key);
    }
    if (current.equals("out")) {
      if (dacVisited && fftVisited) {
        return 1L;
      } else {
        return 0L;
      }
    } else {
      long cnt = 0;
      boolean newDacVisited = current.equals("dac") || dacVisited;
      boolean newFftVisited = current.equals("fft") || fftVisited;
      for (String other : graph.get(current)) {
        cnt += rec(other, newDacVisited, newFftVisited);
      }
      cache.put(key, cnt);
      return cnt;
    }
  }

}
