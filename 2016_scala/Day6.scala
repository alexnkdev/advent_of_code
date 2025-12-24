import scala.io.Source
import scala.collection.immutable.TreeMap

object Main {
  def main(args: Array[String]): Unit = {
    solvePart1()
    solvePart2()
  }

  def solvePart1(): Unit = {
    val source = Source.fromFile("Day6_input.txt")
    val message = source
      .getLines()
      .foldLeft(TreeMap.empty[Int, List[Char]]) { (acc, line) =>
        line.zipWithIndex.foldLeft(acc) {
          case (m, (ch, i)) =>
            m.updatedWith(i) {
              case Some(chars) => Some(chars :+ ch)
              case None => Some(List(ch))
            }
        } 
      }
      .map {
        case (k, list) =>
          list
            .groupBy(identity)
            .maxBy { case (_, freq) => freq.size }
            ._1

      }.mkString
    println(message)
    source.close()
  }

  def solvePart2(): Unit = {
    val source = Source.fromFile("Day6_input.txt")
    val message = source
      .getLines()
      .foldLeft(TreeMap.empty[Int, List[Char]]) { (acc, line) =>
        line.zipWithIndex.foldLeft(acc) {
          case (m, (ch, i)) =>
            m.updatedWith(i) {
              case Some(chars) => Some(chars :+ ch)
              case None => Some(List(ch))
            }
        } 
      }
      .map {
        case (k, list) =>
          list
            .groupBy(identity)
            .minBy { case (_, freq) => freq.size }
            ._1

      }.mkString
    println(message)
    source.close()
  }

}
