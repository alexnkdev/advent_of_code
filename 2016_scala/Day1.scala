import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("Day1_input.txt")
    val lines = source.getLines().toList
    var direction: (Int, Int) = (-1, 0)
    var position: (Int, Int) = (0, 0)

    def rotateLeft90(dir: (Int, Int)): (Int, Int) = (-dir._2, dir._1)
    def rotateRight90(dir: (Int, Int)): (Int, Int) = (dir._2, -dir._1)

    var visited: Set[(Int, Int)] = Set()
    // visited += position
    var found = false;

    for (line <- lines) {
      val steps = line.split(", ").map { instruction => 
        val turn = instruction.charAt(0)
        val stepLength = instruction.tail.toInt

        direction = if (turn == 'L') rotateLeft90(direction) else rotateRight90(direction);
        
        for (_ <- 1 to stepLength) {
          position = (position._1 + direction._1, position._2 + direction._2)
          if (!found && visited.contains(position)) {
            println(Math.abs(position._1) + Math.abs(position._2));
            found = true;
          }
          visited += position
        }


      }
    }
    source.close()

  }
}
