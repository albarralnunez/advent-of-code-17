package albarralnunez.advent_of_code_2017.day3

import org.scalatest._


class Day3Test extends FlatSpec with Matchers with BeforeAndAfter {

		var day: Day3 = _

		before {
			day = new Day3
		}

  it should "<> parser for problem 1" in {
    day.parser("<>")._1 should be (0)
  }
  it should "<random characters> parser for problem 1" in {
    day.parser("<random characters>")._1 should be (0)
  }
  it should "<<<<> parser for problem 1" in {
    day.parser("<<<<>")._1 should be (0)
  }
  it should "<{!>}> parser for problem 1" in {
    day.parser("<{!>}>")._1 should be (0)
  }
  it should "<!!> parser for problem 1" in {
    day.parser("<!!>")._1 should be (0)
  }
  it should "<!!!>> parser for problem 1" in {
    day.parser("<!!!>>")._1 should be (0)
  }
  it should "<{o\"i!a,<{i<a> parser for problem 1" in {
    day.parser("<{o\"i!a,<{i<a>")._1 should be (0)
  } 
  it should "{} parser for problem 1" in {
    day.parser("{}")._1 should be (1)
  }
  it should "{{{}}} parser for problem 1" in {
    day.parser("{{{}}}")._1 should be (6)
  }
  it should "{{}, {}} parser for problem 1" in {
    day.parser("{{}, {}}")._1 should be (5)
  }
  it should "{<{},{},{{}}>} parser for problem 1" in {
    day.parser("{<{},{},{{}}>}")._1 should be (1)
  }
  it should "{<a>,<a>,<a>,<a>} parser for problem 1" in {
    day.parser("{<a>,<a>,<a>,<a>}")._1 should be (1)
  }
  it should "{{<!>},{<!>},{<!>},{<a>}} parser for problem 1" in {
    day.parser("{{<!>},{<!>},{<!>},{<a>}}")._1 should be (3)
  }
  it should "{{{},{},{{}}}} parser for problem 1" in {
    day.parser("{{{},{},{{}}}}")._1 should be (16)
  }
  it should "{{<!!>},{<!!>},{<!!>},{<!!>}} parser for problem 1" in {
    day.parser("{{<!!>},{<!!>},{<!!>},{<!!>}}")._1 should be (9)
  }
  it should "{{<ab>},{<ab>},{<ab>},{<ab>}} parser for problem 1" in {
    day.parser("{{<ab>},{<ab>},{<ab>},{<ab>}}")._1 should be (9)
  }
  it should "{{<a!>},{<a!>},{<a!>},{<ab>}} parser for problem 1" in {
    day.parser("{{<a!>},{<a!>},{<a!>},{<ab>}}")._1 should be (3)
  }
  it should "<> parser for problem 2" in {
    day.parser("<>")._2 should be (0)
  }
  it should "<random characters> parser for problem 2" in {
    day.parser("<random characters>")._2 should be (17)
  }
  it should "<<<<> parser for problem 2" in {
    day.parser("<<<<>")._2 should be (3)
  }
  it should "<{!>}> parser for problem 2" in {
    day.parser("<{!>}>")._2 should be (2)
  }
  it should "<!!> parser for problem 2" in {
    day.parser("<!!>")._2 should be (0)
  }
  it should "<!!!>> parser for problem 2" in {
    day.parser("<!!!>>")._2 should be (0)
  }
  it should "<{o\"i!a,<{i<a> parser for problem 2" in {
    day.parser("<{o\"i!a,<{i<a>")._2 should be (10)
  }
}
