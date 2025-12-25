import scala.io.Source;

object Day8 extends App {

    val W = 50
    val H = 6

    val source = Source.fromFile("Day8_input.txt")
    
    val start: Array[Array[Char]] = Array.fill(H, W)('.')

    def rect(map: Array[Array[Char]], w: Int, h: Int): Array[Array[Char]] = {
      for {
        y <- 0 until h
        x <- 0 until w
      } map(y)(x) = '#'
      map
    }

    def rotateRow(map: Array[Array[Char]], row: Int, n: Int): Array[Array[Char]] = {
      val copy = map(row).clone()
      for { x <- 0 until W }
        map(row)((x + n) % W) = copy(x)
      map
    }

    def rotateColumn(map: Array[Array[Char]], col: Int, n: Int): Array[Array[Char]] = {
      val copy = map.map(_(col))
      for { y <- 0 until H }
        map((y + n) % H)(col) = copy(y)
      map
    }

    val map = source
      .getLines()
      .foldLeft(start) { (acc, line) => 
        line match {
          case s"rect ${w}x${h}" =>
            rect(acc, w.toInt, h.toInt)
          case s"rotate row y=${row} by ${n}" =>
            rotateRow(acc, row.toInt, n.toInt)
          case s"rotate column x=${col} by ${n}" =>
            rotateColumn(acc, col.toInt, n.toInt)
          case _ =>
              acc
        }        
      }

    val ret = map.flatten.count { v => v == '#' }

    println(s"Part1: ${ret}")

    println("Part2:")
    map.foreach(row => 
      println(row.mkString)
    )

    source.close()

}
