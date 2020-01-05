package exercises

import java.util.NoSuchElementException

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

// testing list

//  val list = new SLinkedList(1,EmptyList)
//  println(s"List ${list.head}")

  val list : MyListN[Int] = new SLinkedList(1,new SLinkedList(2,new SLinkedList(3,EmptyList)))
  val list2 : MyListN[String] = new SLinkedList("hi",new SLinkedList("hello",new SLinkedList("hi",EmptyList)))
  //  println(s"List ${list.head}")
  println(list.printList(list))
  println(list2.printList(list2))



}

/*
Counter class
  - receives an int value
  - method current count
  - method to increment/decrement => new Counter
  - overload inc/dec to receive an amount
*/

class Counter(val count:Int = 0) {
  def inc:Counter = {
    new Counter(count+1)
  }

  def dec: Counter = {
    new Counter(count-1)
  }

  def inc(n:Int):Counter = {
    if(n <= 0) this
    else inc.inc(n-1)
  }

  def dec(n:Int):Counter = {
    if(n <= 0) this
    else dec.dec(n-1)
  }
}

abstract class MyListN[+A]{
  /*
   head = first element of  the  list
   tail = remainder of the list
   isEmpty = is this list empty
   add(int) => new list with this element added
   toString => a string representation of the list
 */

  def head:A
  def tail : MyListN[A]
  def isEmpty : Boolean
  def add[B >: A](e:B) : MyListN[B]
  def printList[B >: A] (list:MyListN[B]) : String
}

object EmptyList extends MyListN[Nothing] {

  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyListN[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](e: B): MyListN[B] = new SLinkedList(e, EmptyList)

  override def printList[B >: Nothing](list: MyListN[B]): String = " "
}

class SLinkedList[+A](h:A, t:MyListN[A]) extends MyListN[A] {

  override def head: A = h

  override def tail: MyListN[A] = t

  override def isEmpty: Boolean = false

  override def add[ B >: A](e: B): MyListN[B] = new SLinkedList(e,this)

  override def printList[B >: A](list: MyListN[B]): String = {
    def printHelper[B >: A] (list: MyListN[B], helper : String):String = {
      if (list.isEmpty == true) helper
      else printHelper(list.tail,helper+list.head+" ")
    }
    printHelper(list,"")
  }

}
