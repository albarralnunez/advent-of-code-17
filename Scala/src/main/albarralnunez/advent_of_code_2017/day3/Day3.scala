package albarralnunez.advent_of_code_2017.day3


final class Day3 {

  def parserGarbage(
    stream: List[Char], depth: Int,
    groupScore: Int, garbageCollected: Int
  ): (Int, Int) =
    stream match {
      case '>'::tail =>
        parserGroup (tail, depth, groupScore, garbageCollected)
      case '!'::_::tail =>
        parserGarbage (tail, depth, groupScore, garbageCollected)
      case _::tail =>
        parserGarbage (tail, depth, groupScore, garbageCollected+1)
      case Nil =>
        (groupScore, garbageCollected)
    }

  def parserGroup(
    stream: List[Char], depth: Int,
    groupScore: Int, garbageCollected: Int
  ): (Int, Int) =
    stream match {
      case '{'::tail => 
        parserGroup (tail, depth+1, groupScore, garbageCollected)
      case '}'::tail =>
        parserGroup (tail, depth-1, groupScore+depth, garbageCollected)
      case '<'::tail =>
        parserGarbage (tail, depth, groupScore, garbageCollected)
      case '!'::_::tail =>
        parserGroup (tail, depth, groupScore, garbageCollected)
      case _::tail =>
        parserGroup (tail, depth, groupScore, garbageCollected)
      case Nil => (groupScore, garbageCollected)
    }


  def parser(stream: String): (Int, Int) =
    parserGroup (stream.toList, 0, 0, 0)

  def solution(): (Int, Int) = 
    parser (scala.io.Source.fromFile ("../inputs/day3.txt").mkString)

}

