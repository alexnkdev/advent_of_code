import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day6 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        int n = 1000;
        int[][] map = new int[n][n];
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.startsWith("toggle")) {
                s = s.replaceAll("toggle ", "");
                String[] tokens = s.split(" through ");
                toggle(map, parse(tokens[0]), parse(tokens[1]));
            } else if (s.startsWith("turn on")) {
                s = s.replaceAll("turn on ", "");
                String[] tokens = s.split(" through ");
                turnOn(map, parse(tokens[0]), parse(tokens[1]));
            } else if (s.startsWith("turn off")) {
                s = s.replaceAll("turn off ", "");
                String[] tokens = s.split(" through ");
                turnOff(map, parse(tokens[0]), parse(tokens[1]));
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret += map[i][j];
            }
        }
        System.out.println(ret);
        sc.close();
    }

    static void toggle(int[][] map, Point from, Point to) {
        for (int i = from.i; i <= to.i; i++) {
            for (int j = from.j; j <= to.j; j++) {
                map[i][j] += 2;
            }
        }
    }

    static void turnOn(int[][] map, Point from, Point to) {
        for (int i = from.i; i <= to.i; i++) {
            for (int j = from.j; j <= to.j; j++) {
                map[i][j] += 1;
            }
        }
    }

    static void turnOff(int[][] map, Point from, Point to) {
        for (int i = from.i; i <= to.i; i++) {
            for (int j = from.j; j <= to.j; j++) {
                map[i][j] = Math.max(0, map[i][j] - 1);
            }
        }
    }

    static Point parse(String x) {
        String[] tokens = x.split(",");
        return new Point(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
    }

    static class Point {
        int i;
        int j;
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
