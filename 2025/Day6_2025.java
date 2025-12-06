import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Day6_2025 {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("input.txt"));

    List<List<String>> rawRows = new ArrayList<>();

    while (sc.hasNext()) {
      String line = sc.nextLine();
      String[] tokens = line.split(" ");
      List<String> rawRow = new ArrayList<>();
      for (String token : tokens) {
        if (token.trim().length() > 0) {
          rawRow.add(token);
        }
      }
      rawRows.add(rawRow);
    }
    int columns = rawRows.get(0).size();
    int rows = rawRows.size() - 1;
    int[] colSize = new int[columns];
    for (int i = 0; i < columns; i++) {
      int maxSize = 0;
      for (int j = 0; j < rows; j++) {
        maxSize = Math.max(maxSize, rawRows.get(j).get(i).length());
      }
      colSize[i] = maxSize;
    }

    sc.close();

    sc = new Scanner(new File("input.txt"));
    List<List<String>> cleanRows = new ArrayList<>();
    while (sc.hasNext()) {
      String line = sc.nextLine();
      if (line.contains("+") || line.contains("*")) {
        break;
      }
      int current = 0;
      List<String> rowCells = new ArrayList<>();
      for (int i = 0; i < columns; i++) {
        String val = "";
        for (int j = 0; j < colSize[i]; j++) {
          val += line.charAt(current++);
        }
        rowCells.add(val);
        current++;
      }
      cleanRows.add(rowCells);
    }
    long ret = 0;
    for (int i = 0; i < columns; i++) {
      String operator = rawRows.get(rawRows.size() - 1).get(i).trim();
      List<String> column = new ArrayList<>();
      for (int j = 0; j < cleanRows.size(); j++) {
        column.add(cleanRows.get(j).get(i));
      }
      long val;
      if (operator.equals("+")) {
        val = addColumn(column, colSize[i]);
      } else {
        val = multColumn(column, colSize[i]);
      }
      ret += val;
    }
    System.out.println(ret);
    sc.close();
  }

  static long addColumn(List<String> column, int colSize) {
    long ret = 0;
    for (int i = colSize - 1; i >= 0; i--) {
      long val = 0;
      for (int j = 0; j < column.size(); j++) {
        char c = column.get(j).charAt(i);
        if (c != ' ') {
          int digit = (int)(c - '0');
          val = 10L * val + digit;
        }
      }
      ret += val;
    }
    return ret;
  }

  static long multColumn(List<String> column, int colSize) {
    long ret = 1;
    for (int i = colSize - 1; i >= 0; i--) {
      long val = 0;
      for (int j = 0; j < column.size(); j++) {
        char c = column.get(j).charAt(i);
        if (c != ' ') {
          int digit = (int)(c - '0');
          val = 10L * val + digit;
        }
      }
      ret *= val;
    }
    return ret;
  }

}
