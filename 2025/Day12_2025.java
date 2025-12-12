import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day12_2025 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("input.txt"));
        int cnt = 0;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            String size = tokens[0].substring(0, tokens[0].length() - 1);
            int n = Integer.parseInt(size.split("x")[0]);
            int m = Integer.parseInt(size.split("x")[1]);
            List<Integer> others = new ArrayList<>();
            int totalRequiredSize = 0;
            for (int i = 1; i < tokens.length; i++) {
                others.add(Integer.parseInt(tokens[i]));
                totalRequiredSize += Integer.parseInt(tokens[i]) * 9;
            }
            if (totalRequiredSize <= n * m) {
                cnt++;
            }
        }
        System.out.println(cnt);
        sc.close();
    }

}
