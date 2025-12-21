import scala.io.Source;

object Main {

  def main(args: Array[String]): Unit = {
    solvePart1();
    solvePart2();
  }

  def solvePart1(): Unit = {
    val source = Source.fromFile("Day4_input.txt");
    val ret = source.getLines()
        .map {
          line =>
            val tokens = line.split("-");
            val idToken = tokens.last;
            val id = idToken.split("\\[")(0)
            val checkSum = idToken.split("\\[").last.dropRight(1)

            val freq = tokens.dropRight(1).mkString.foldLeft(Map.empty[Char, Int]) { (m, ch) => 
              m.updated(ch, m.getOrElse(ch, 0) + 1)
            }
            
            val top5 = freq.toSeq
              .sortBy { case (k, v) => (-v, k) }
              .take(5)
              .map(_._1)


            Array(top5.mkString, checkSum, id)
            
            }.map { case Array(checksum, expectedChecksum, id) => if (checksum == expectedChecksum) id.toInt else 0 }
        .sum
    println(ret);
  }

  def solvePart2(): Unit = {
    val source = Source.fromFile("Day4_input.txt");
    val ret = source.getLines()
      .flatMap {
        line =>
          val tokens = line.split("-");
          val idToken = tokens.last;
          val id = idToken.split("\\[")(0).toInt
          val encrypted = tokens.dropRight(1).mkString(" ")

          val decrypted = encrypted.map {
            case ' ' => ' '
            case ch => ('a' + (ch - 'a' + id) % 26).toChar
          }

          if (decrypted.contains("northpole")) Some(id) else None

      }.find {
        _ => true
      }
    println(ret);
  }

}
