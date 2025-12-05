import java.util.*;
import java.io.*;

class Day3_2025 {

  static Long[][] memo;

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("input.txt"));
    long ret = 0;
  
    while (sc.hasNext()) {
      String line = sc.nextLine();
      memo = new Long[line.length() + 1][13];
      long sol =  solve(line, 0, 12);
      ret += sol;
      System.out.println("Sol = " + sol);
    }
    System.out.println(ret);
    sc.close();
  }

  static Long solve(String line, int current, int rem) {
    if (rem == 0) {
      return 0L;
    }
    if (current == line.length()) {
      return null;
    }
    if (memo[current][rem] != null) {
      return memo[current][rem];
    }
    int digit = (int)(line.charAt(current) - '0');
    
    Long option1 = solve(line, current + 1, rem - 1);
    Long option2 = solve(line, current + 1, rem);
    
    long dd = digit;
    for (int i = 0; i < rem - 1; i++) {
      dd *= 10;
    }
    Long ret = null;
    if (option1 != null) {
      ret = dd + option1;
    }
    if (option2 != null) {
      ret = Math.max(ret, option2);
    }
    memo[current][rem] = ret;
    return ret;
  }
}
