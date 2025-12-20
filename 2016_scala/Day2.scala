import scala.io.Source;

object Main {
  def main(args: Array[String]): Unit = {
    // solvePart1();
    solvePart2();
  }

  def solvePart1(): Unit = {
    val source = Source.fromFile("Day2_input.txt");
    val instructions = source.getLines();
    val keys: Array[Array[Int]] = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9)
    );
    val di: Map[Char, Int] = Map('U' -> -1, 'L' -> 0, 'D' -> 1, 'R' -> 0);
    val dj: Map[Char, Int] = Map('U' -> 0, 'L' -> -1, 'D' -> 0, 'R' -> 1);
    instructions.foreach(instruction => {
      var ci = 1;
      var cj = 1;
      instruction.foreach { c => 
        ci = ci + di(c);
        cj = cj + dj(c);
        ci = Math.min(ci, keys.length - 1);
        cj = Math.min(cj, keys.length - 1);
        ci = Math.max(ci, 0);
        cj = Math.max(cj, 0);
      };
      print(keys(ci)(cj));
    })
    println();
    source.close();
  }

  def solvePart2(): Unit = {
    val source = Source.fromFile("Day2_input.txt");
    val instructions = source.getLines();
    val keys: Array[Array[Char]] = Array(
      Array('0', '0', '1', '0', '0'),
      Array('0', '2', '3', '4', '0'),
      Array('5', '6', '7', '8', '9'),
      Array('0', 'A', 'B', 'C', '0'),
      Array('0', '0', 'D', '0', '0')
    );
    val di: Map[Char, Int] = Map('U' -> -1, 'L' -> 0, 'D' -> 1, 'R' -> 0);
    val dj: Map[Char, Int] = Map('U' -> 0, 'L' -> -1, 'D' -> 0, 'R' -> 1);
    instructions.foreach(instruction => {
      var ci = 1;
      var cj = 1;
      instruction.foreach { c => 
        val ni = ci + di(c);
        val nj = cj + dj(c);
        if (ni >= 0 && nj >= 0 && ni < keys.length && nj < keys(0).length && keys(ni)(nj) != '0') {
          ci = ni;
          cj = nj;
        }
      };
      print(keys(ci)(cj));
    })
    println();
    source.close();
  }

}
