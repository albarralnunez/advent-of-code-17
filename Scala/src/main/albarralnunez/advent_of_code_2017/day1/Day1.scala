package albarralnunez.advent_of_code_2017.day1

final class Day1 {

  private def validatePair(numbers: List[Int]): Int = 
    (numbers (0) - numbers (1)) match {
      case 0 => numbers (1)
      case _ => 0
    }

  private def toListOfDigits(code: String): List[Int] = 
    code.toList map (_.asDigit)

  private def packCircle(numbers: List[Int], distance: Int): List[List[Int]]= {
    val length = numbers.length
    val circleNumbers: List[Int] =
      numbers.slice (length-distance, length) ++ numbers
    val enumerateNumbers: List[(Int, Int)] =
      circleNumbers.zipWithIndex.slice (0, length)
    enumerateNumbers.map { case (x, y) => List(x, circleNumbers (y+distance)) }
  }

  private def sumValidPairs(
    pairs: List[List[Int]], validator: List[Int] => Int
  ): Int =
    pairs.map (validator(_)).sum

  def problem1(code: String): Int = {
    val numbersOfTheCode: List[Int] = toListOfDigits (code)
    val pairs: List[List[Int]] = packCircle (numbersOfTheCode, 1)
    sumValidPairs(pairs, validatePair)
  }

  def problem2(code: String): Int = {
    val numbersOfTheCode: List[Int] = code.toList.map (_.asDigit)
    val pairs: List[List[Int]] =
      packCircle (numbersOfTheCode, numbersOfTheCode.length/2)
    sumValidPairs (pairs, validatePair)
  }

}
