package exercises

abstract class MyList[+A] {

  /*
     head = first element of  the  list
     tail = remainder of the list
     isEmpty = is this list empty
     add(int) => new list with this element added
     toString => a string representation of the list
   */

  def head : A
  def tail : MyList[A]
  def isEmpty : Boolean
  def add[B>:A](element: B) : MyList[B]
  def printElements: String
  override def toString : String = "[" + printElements + "]"
//  def toString: String

  def map[B](transformer: MyTransformer[A,B]):MyList[B]
//  def flatMap[B](transformer: MyTransformer[A,MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]):MyList[A]

  // hofs
  def foreach(f: A => Unit):Unit

}

object Empty extends MyList[Nothing] {
  def head : Nothing = throw new NoSuchElementException
  def tail : MyList[Nothing] = throw new NoSuchElementException
  def isEmpty : Boolean = true
  def add[B>: Nothing](element: B) : MyList[B ] = new Cons(element,Empty)
  override def printElements: String = ""
  def map[B](transformer: MyTransformer[Nothing,B]):MyList[B] = Empty
//  def flatMap[B](transformer: MyTransformer[Nothing,MyList[B]]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]):MyList[Nothing] = Empty

  //hofs
  override def foreach(f: Nothing => Unit): Unit = ()
}

class Cons[+A](h:A , t:MyList[A]) extends MyList[A]{
  def head : A = h
  def tail : MyList[A] = t
  def isEmpty : Boolean = false
  def add[B>: A](element: B) : MyList[B] = new Cons(element,this)
  override def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements

  def filter(predicate: MyPredicate[A]):MyList[A] = {
  if(predicate.test(h)) new Cons(h,t.filter(predicate))
  else t.filter(predicate)
  }

  def map[B](transformer: MyTransformer[A,B]):MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }

  //hofs
  override def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }
}

trait MyPredicate[-T]{
  def test(element:T) : Boolean
}

trait MyTransformer[-A,B]{
  def transform(elem:A) : B
}

object ListTest extends App{
  val list:MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val list2:MyList[String] = new Cons("Hey", new Cons("THere", new Cons("Test", Empty)))
//  println(list.tail.tail.head)
//  println(list.add(4))

//  println(list.toString)
//  println(list2.toString)

//  println(list.map(new MyTransformer[Int,Int] {
//    override def transform(elem: Int): Int = elem*2
//  }))

  list.foreach(println)
}


/*
1.  Generic trait MyPredicate[-T] with a little method test(T) => Boolean
2.  Generic trait MyTransformer[-A, B] with a method transform(A) => B
3.  MyList:
    - map(transformer) => MyList
    - filter(predicate) => MyList
    - flatMap(transformer from A to MyList[B]) => MyList[B]
    class EvenPredicate extends MyPredicate[Int]
    class StringToIntTransformer extends MyTransformer[String, Int]
    [1,2,3].map(n * 2) = [2,4,6]
    [1,2,3,4].filter(n % 2) = [2,4]
    [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
*/
