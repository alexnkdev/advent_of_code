import java.io.File;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Day8_2025 {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("input.txt"));
    List<Long> xs = new ArrayList<>();
    List<Long> ys = new ArrayList<>();
    List<Long> zs = new ArrayList<>();
    while (sc.hasNext()) {
      String line = sc.nextLine();
      String[] tokens = line.split(",");
      xs.add(Long.parseLong(tokens[0]));
      ys.add(Long.parseLong(tokens[1]));
      zs.add(Long.parseLong(tokens[2]));
    }
    int n = xs.size();
    int[] circuit = new int[n];
    for (int i = 0; i < n; i++) {
      circuit[i] = i;
    }
    int cnt = 0;
    int circuit_idx = n;
    boolean[][] connected = new boolean[n][n];
    PriorityQueue<Pair> pairs = new PriorityQueue<Pair>(new Comparator<Pair>() {
      @Override
      public int compare(Pair o1, Pair o2) {
        return Double.compare(o1.dist, o2.dist);
      }
    });
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        double d = dist(xs.get(i), ys.get(i), zs.get(i), xs.get(j), ys.get(j), zs.get(j));
        pairs.add(new Pair(i, j, d));
      }
    }
    long lastRes = 0;
    while (true) {
      cnt++;
      Pair minPair = pairs.poll();
      if (minPair == null) {
        break;
      }
      int smallest_i = minPair.i;
      int smallest_j = minPair.j;
      lastRes = xs.get(smallest_i) * xs.get(smallest_j);
      int[] newCircuit = new int[n];
      for (int i = 0; i < n; i++) {
        if (circuit[i] == circuit[smallest_i] || circuit[i] == circuit[smallest_j]) {
          newCircuit[i] = circuit_idx;
        } else {
          newCircuit[i] = circuit[i];
        }
      }
      circuit = newCircuit;
      boolean good = true;
      for (int i = 1; i < circuit.length; i++) {
        if (circuit[i] != circuit[0]) {
          good = false;
        }
      }
      if (good) {
        lastRes = xs.get(smallest_j) * xs.get(smallest_i);
        break;
      }
      circuit_idx++;
    }
    System.out.println("last res = " + lastRes);
    sc.close();
  }

  static double dist(double x1, double y1, double z1, double x2, double y2, double z2) {
    return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
  }

  static class Pair {
    int i;
    int j;
    double dist;
    public Pair(int i, int j, double dist) {
      this.i = i;
      this.j = j;
      this.dist = dist;
    }
  }
}
