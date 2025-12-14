import scala.io.Source

def rotateLeft90(dir: (Int, Int)): (Int, Int) = (-dir._2, dir._1)
def rotateRight90(dir: (Int, Int)): (Int, Int) = (dir._2, -dir._1)

case class State(pos: (Int, Int), dir: (Int, Int))

object Main {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("Day1_input.txt")
    val instructions = source.getLines().next().split(", ").toList
    var direction: (Int, Int) = (-1, 0)
    var position: (Int, Int) = (0, 0)
    

    val result = instructions.
      foldLeft((State((0,0), (-1,0)), Set[(Int, Int)]((0, 0)), Option.empty[(Int, Int)])) {
        case ((state, visited, firstRevisit), instr) =>
          firstRevisit match {
            case Some(_) => (state, visited, firstRevisit)
            case None =>
              val turn = instr.head
              val steps = instr.tail.toInt
              val newDir = if (turn == 'L') rotateLeft90(state.dir) else rotateRight90(state.dir)

              val positions = (1 to steps).scanLeft(state.pos) {
                case (pos, _) => (pos._1 + newDir._1, pos._2 + newDir._2)
              }.tail

              val revisit = positions.find(visited.contains)
              val newVisited = visited ++ positions
              val newState = State(positions.last, newDir)
              (newState, newVisited, revisit)

          }
      }

    result._3 match {
      case Some(pos) => println(Math.abs(pos._1) + Math.abs(pos._2))
      case None => println("No solution")
    }

    source.close()

  }
}
