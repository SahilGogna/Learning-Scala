package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  //  println(x.length)
  //  this ^^ will crash with a NPE

  // 1. throwing exceptions
  //  val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    // code that might throw
    getInt(true)
  } catch {
    case e: RuntimeException => 43
  } finally {
    // code that will get executed NO MATTER WHAT
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects
    println("finally")
  }

  println(potentialFail)

  /*
  1.  Crash your program with an OutOfMemoryError
  2.  Crash with SOError
  3.  PocketCalculator
      - add(x,y)
      - subtract(x,y)
      - multiply(x,y)
      - divide(x,y)
      Throw
        - OverflowException if add(x,y) exceeds Int.MAX_VALUE
        - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
        - MathCalculationException for division by 0
 */

//  val array = Array.ofDim(Int.MaxValue)

  //  def infinite: Int = 1 + infinite
  //  val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException

  object pocketCalculator{

    def add(x:Int, y:Int):Int ={
      val result = x + y
      // we actually cannot check if the result exceeds the max value, but when value exceeds max value the result turns to a negative value
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int):Int = {
      val result = x - y
      // means we are adding 2 +ve nos
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int):Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int):Int = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }



  }


}
