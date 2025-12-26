import scala.io.Source;

object Day9 extends App {


  def transform(s: List[Char]): String = s match {
    case Nil => ""
    case '(' :: t => "y" + transform(t)
    case x :: t => x.toString + transform(t)
  }

  def solvePart1(): Unit = {
    val source = Source.fromFile("Day9_input.txt")
    val decompressed = source
      .getLines()
      .map { s => transform(s.toList) } 
      .mkString
    println(decompressed)
    source.close()
  }


  def solvePart2(): Unit = {
    val source = Source.fromFile("Day9_input.txt")

    source.close()
  }


  solvePart1()
  // solvePart2()

}
