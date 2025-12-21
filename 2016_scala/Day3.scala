import scala.io.Source;

object Main {
  def main(args: Array[String]): Unit = {
    solvePart2();
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

  def solvePart2(): Unit = {
    val source = Source.fromFile("Day3_input.txt");
    val ret = source.getLines().grouped(3)
      .flatMap { lines => 
        val rows = lines.map(_.trim.split("\\s+").map(_.toInt)).toArray
        
        val Array(a1, a2, a3) = rows(0)
        val Array(b1, b2, b3) = rows(1)
        val Array(c1, c2, c3) = rows(2)

        Seq(
          Array(a1, b1, c1),
          Array(a2, b2, c2),
          Array(a3, b3, c3)
        )
      }.count {
        case Array(a, b, c) => a < b + c && b < a +c && c < a + b
      }
    println(ret);  
  }

}
