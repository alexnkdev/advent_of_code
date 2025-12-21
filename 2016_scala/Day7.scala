import scala.io.Source;

object Main {

  def main(args: Array[String]): Unit = {
    solvePart1()
  }

  def solvePart1(): Unit = {
    val source = Source.fromFile("Day7_input.txt")
    val ret = source.getLines().count {
      isSupportsTLS(_)
    }
    println(ret);
    source.close()
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
