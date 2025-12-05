import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Day5_2025 {

  static int START = 0;
  static int END = 1;

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("input.txt"));
    List<Event> events = new ArrayList<>();
    long ret = 0;
    while (sc.hasNext()) {
      String line = sc.nextLine();
      if (line.contains("-")) {
        String[] tokens = line.split("-");
        long from = Long.parseLong(tokens[0]);
        long to = Long.parseLong(tokens[1]);
        events.add(new Event(from, START));
        events.add(new Event(to, END));
      } else {
        //  noop
      }
    }
    Collections.sort(events, new Comparator<Event>() {
      @Override
      public int compare(Event event1, Event event2) {
        if (event1.val < event2.val) {
          return -1;
        } else if (event1.val > event2.val) {
          return 1;
        } else {
          if (event1.eventType == START) {
            return -1;
          } else if (event2.eventType == START) {
            return 1;
          }
          return 0;
        }
      }
    });
    int level = 0;
    long currentStart = 0;
    for (Event event : events) {
      if (event.eventType == START) {
        level++;
        if (level == 1) {
          currentStart = event.val;
        }
      } else if (event.eventType == END) {
        level--;
        if (level == 0) {
          ret += (event.val - currentStart + 1);
        }
      }
    }
    System.out.println(ret);
    sc.close();
  }

  static class Event {
    public long val;
    public int eventType;

    public Event(long val, int eventType) {
      this.val = val;
      this.eventType = eventType;
    }
  }

}
