package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  // previous factorial function runs stackoverflow error so we write a new one

  def anotherFactorial(n: Int): Int = {
    @tailrec
    def factHelper(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)
    }

    factHelper(n, 1)
  }

  // when you need loops use tail recursion
  /*
  1. A string concatinate function
  2. isPrime using tail recursion
  3. fibo using tail recursion
   */

  def concatString(word: String, n: Int): String = {
    if (n == 1) word
    else word + concatString(word, n - 1)
  }

  @tailrec
  def tailConcatString(word: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else tailConcatString(word, n - 1, word + accumulator)
  }

//  println(tailConcatString("Hiii", 4, ""))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeAux(n: Int, i: Int, b: Boolean):Boolean = {
      if(b) false
      else if(i == 1) true
      else isPrimeAux(n, i-1, n%i == 0)
    }

    isPrimeAux(n,n/2, n%(n/2) == 0)
  }

//  println(isPrime(25))


  def fibo(n: Int) : Int = {

    @tailrec
    def auxFibo(count: Int, n1: Int, n2: Int): Int = {
      if(count > n) n2
      else auxFibo(count +1, n2, n1+n2)
    }

    if( n == 1 || n== 2) 1
    else auxFibo(3,1,1)
  }

  println(fibo(6))
}
