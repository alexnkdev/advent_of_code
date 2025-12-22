import scala.io.Source;

object Main {

  def main(args: Array[String]): Unit = {
    solvePart1()
    solvePart2()
  }

  def solvePart1(): Unit = {
    val source = Source.fromFile("Day7_input.txt")
    val ret = source.getLines().count { isSupportsTLS(_) }
    println(ret);
    source.close()
  }

  def solvePart2(): Unit = {
    val source = Source.fromFile("Day7_input.txt")
    val ret = source.getLines().count { isSupportsSSL(_) }
    println(ret)
    source.close()
  }

  def isSupportsSSL(str: String): Boolean = {
    val (_, superSet, hyperSet) =
      str.sliding(3).foldLeft((false, Set.empty[String], Set.empty[String])) {
        case ((_, a, b), w) if w(0) == '[' =>
          (true, a, b)
        case ((_, a, b), w) if w(0) == ']' =>
          (false, a, b)
        case ((in, a, b), w)
          if w(0) == w(2) && w(0) != w(1) =>
            if (in)
              (in, a, b + s"${w(0)}${w(1)}${w(0)}")
            else
              (in, a + s"${w(1)}${w(0)}${w(1)}", b)
        case (state, _) => state
      }
    superSet.exists(hyperSet.contains)
  }

  def isSupportsTLS(str: String): Boolean = {
    val (_,_,isInvalid, supports) = str.foldLeft(("", false, false, false)) {
      case ((currentStr, inBrackets, isInvalid, supports), ch) =>
        if (inBrackets) {
          if (ch == ']') {
            ("", false, isInvalid, supports)
          } else {
            val newStr = currentStr + ch
            val newInvalid = isInvalid || isGood(newStr)
            (newStr, true, newInvalid, supports)
          }
        } else {
          if (ch == '[') {
            ("", true, isInvalid, supports)
          } else {
            val newStr = currentStr + ch
            val newSupports = supports || (newStr.length >= 4 && isGood(newStr))
            (newStr, false, isInvalid, newSupports)
          }
        }
    }
    supports && !isInvalid
  }

  def isGood(str: String): Boolean = {
    str.length >= 4 && str.sliding(4).exists { sub =>
      val chars = sub.toCharArray
      chars(0) != chars(1) && chars(0) == chars(3) && chars(1) == chars(2)
    }
  }

}
