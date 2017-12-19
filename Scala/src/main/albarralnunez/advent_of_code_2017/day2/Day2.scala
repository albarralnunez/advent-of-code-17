package albarralnunez.advent_of_code_2017.day2

import scala.io._

final class Day2 {

  type Line = List[Int]
  type Spreadsheet = List[Line]

  def parseInput(filePath: String): Spreadsheet = {
    val source: BufferedSource = Source.fromFile( filePath )
    val linesList: List[String] = source.getLines.toList
    val splitLinesByTab: List[List[Int]] = linesList.map( _.split( "\t" ).map( _.toInt ).toList )
    splitLinesByTab
  }

  def differenceMaxMin(list: Line): Int = list.max - list.min

  def divideFirstDivisible(line: Line): Int = {
    val combinationsOfTwo = line.combinations(2).toList
    val dividePairsFirstDivSecond = combinationsOfTwo.map { case List(x, y) => (x / y toDouble, x % y) }
    val dividePairsSecondDivFirst = combinationsOfTwo.map { case List(x, y) => (y / x toDouble, y % x) }
    val dividePairs = dividePairsFirstDivSecond ++ dividePairsSecondDivFirst
    val firstValid = dividePairs.dropWhile { case (x, y) => y != 0 || x == 1 }
    val (result: Double, _) = firstValid.head
    result.toInt
  }

  def calculateChecksum(spreadsheet: Spreadsheet, evaluator: Line => Int) =
    spreadsheet.map(evaluator).sum

  def problem1() = {
    calculateChecksum(parseInput("../inputs/day2_p1.txt"), differenceMaxMin)
  }

  def problem2() = {
    calculateChecksum(parseInput("../inputs/day2_p2.txt"), divideFirstDivisible)
  }
}
