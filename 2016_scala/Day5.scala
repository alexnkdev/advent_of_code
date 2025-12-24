import java.security.MessageDigest

object Main {

  def main(args: Array[String]): Unit = {
    solvePart1();
  }

  def solvePart1(): Unit = {
    println(findPassword("ffykfhsq"))
  }

  def findPassword(doorId: String): String = {
    Iterator
      .from(0)
      .map(n => md5(s"$doorId$n"))
      .filter(_.startsWith("00000"))
      .take(8)
      .map(_(5)).mkString
  }
  
  def md5(s: String): String = {
    val md = MessageDigest.getInstance("MD5")
    val bytes = md.digest(s.getBytes("UTF-8"))
    bytes.map("%02x".format(_)).mkString
  }

}
