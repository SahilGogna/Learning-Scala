package exercises

import scala.annotation.tailrec

object SelfTest extends App {

  // write a string concatination function, it takes string and number of times it should be repeated

  def stringRepeator(s:String, times:Int):String = {
    if (times <= 0) "Invalid input"
    else if(times == 1) s
    else s + stringRepeator(s, times-1)
  }

  println(stringRepeator("Test", 3))

  // write a function to check if the number is prime or not
  def isPrime(n:Int): Boolean = {
    def isPrimeUntil(t:Int) : Boolean = {
      if (t<=1) true
      else n%t != 0 && isPrimeUntil(t-1)
    }
    isPrimeUntil(n/2)
  }

//  println(isPrime(10))
//  println(isPrime(23))
//  println(isPrime(599))
//  println(isPrime(601))

  def Fact(number:Int): Int = {
    if(number == 1) 1
    else Fact(number * Fact(number-1))
  }

  // use tail recursion for factorial
  @tailrec
  def tailFact(number:BigInt, temp : BigInt): BigInt = {
    if(number == 1) temp
    else tailFact(number-1, number*temp)
  }

//  println(tailFact(5,1))

//  println(tailFact(5000,1))

  // concatinate strings using tail recursion

  @tailrec
  def concatTail(times:Int, word:String, helper:String):String = {
    if(times <= 0) helper
    else concatTail(times - 1, word, word+helper)
  }

//  println(concatTail(4,"Sirji",""))

  // isPrime using tail recursion

  // fibo using tail recursion

  def fiboTail(number: Int) : Int = {
    def fiboTailHelper(i:Int, last:Int, secondLast:Int):Int = {
      if(i>=number) last
      else fiboTailHelper(i+1,last+secondLast , last)
    }
    if (number <= 2) 1
    else fiboTailHelper(2, 1, 1)
  }

  println(fiboTail(8))
}
