import scala.io.Source;

object Main {
  def main(args: Array[String]): Unit = {
    solvePart1();
  }

  def solvePart1(): Unit = {
    val source = Source.fromFile("Day3_input.txt");
    val ret = source.getLines()
      .map {
        _.trim.split("\\s+").map(_.toInt)
      }
        .count{ 
          case Array(a, b, c) =>
          a < b + c && b < a + c && c < a + b
        }
    println(ret);
    source.close();
  }
}
