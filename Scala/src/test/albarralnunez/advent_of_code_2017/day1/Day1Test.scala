package albarralnunez.advent_of_code_2017.day1

import org.scalatest._


class Day1Test extends FlatSpec with Matchers with BeforeAndAfter {

  var day1: Day1 = _

  before {
    day1 = new Day1
  }

  it should "solve the problem 1" in {
    day1.problem1("1122") should be (3)
    day1.problem1("1111") should be (4)
    day1.problem1("1234") should be (0)
    day1.problem1("91212129") should be (9)
  }

  it should "solve the problem 2" in {
    day1.problem2("1212") should be (6)
    day1.problem2("1221") should be (0)
    day1.problem2("123425") should be (4)
    day1.problem2("123123") should be (12)
    day1.problem2("12131415") should be (4)
  }

}
