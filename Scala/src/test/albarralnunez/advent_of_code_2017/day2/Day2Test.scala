package albarralnunez.advent_of_code_2017.day2

import org.scalatest._


class Day2Test extends FlatSpec with Matchers with BeforeAndAfter {

  var day: Day2 = _

  before {
    day = new Day2
  }

  it should "calculate the correct checksum for problem 1" in {
    day.calculateChecksum(
      List(
        List(5, 1, 9, 5),
        List(7, 5, 3),
        List(2, 4, 6, 8)
      ), day.differenceMaxMin) should be (18)
  }

  it should "calculate the correct checksum for problem 2" in {
    day.calculateChecksum(
      List(
        List(5, 9, 2, 8),
        List(9, 4, 7, 3),
        List(3, 8, 6, 5)
      ), day.divideFirstDivisible) should be (9)
  }
}
