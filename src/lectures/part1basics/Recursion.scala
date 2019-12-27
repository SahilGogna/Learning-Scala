package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  // previous factorial function runs stackoverflow error so we write a new one

  def anotherFactorial(n:Int):Int = {
    @tailrec
    def factHelper(x:Int, accumulator:Int):Int = {
      if (x <= 1) accumulator
      else factHelper(x-1,x*accumulator)
    }
    factHelper(n,1)
  }

  // when you need loops use tail recursion
  /*
  1. A string concatinate function
  2. isPrime using tail recursion
  3. fibo using tail recursion
   */

  def concatString(word:String,n:Int):String = {
    if(n ==1) word
    else word + concatString(word,n-1)
  }

  @tailrec
  def tailConcatString(word:String,n:Int,accumulator:String):String = {
    if(n <= 0) accumulator
    else tailConcatString(word,n-1,word+accumulator)
  }

  println(tailConcatString("Hiii",4,""))

}
