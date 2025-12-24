import java.security.MessageDigest

object Main {

  def main(args: Array[String]): Unit = {
    solvePart1();
    solvePart2();
  }

  def solvePart1(): Unit = {
    println(findPassword("ffykfhsq"))
  }

  def solvePart2(): Unit = {
    println(findPasswordPart2("ffykfhsq"))
  }

  def findPassword(doorId: String): String = {
    Iterator
      .from(0)
      .map(n => md5(s"$doorId$n"))
      .filter(_.startsWith("00000"))
      .take(8)
      .map(_(5)).mkString
  }

  def findPasswordPart2(doorId: String): String = {
    val passMap = Iterator
      .from(0)
      .map(n => md5(s"$doorId$n"))
      .filter(_.startsWith("00000"))
      .filter(hash => hash(5) >= '0' && hash(5) <= '7')
      .scanLeft(Map.empty[Int, Char]) { (acc, hash) =>
        val pos = hash(5).asDigit
        if (!acc.contains(pos)) acc + (pos -> hash(6)) else acc
      }
      .dropWhile(_.size < 8)
      .next()
    (0 until 8).map(passMap).mkString

  }
  
  def md5(s: String): String = {
    val md = MessageDigest.getInstance("MD5")
    val bytes = md.digest(s.getBytes("UTF-8"))
    bytes.map("%02x".format(_)).mkString
  }

}
