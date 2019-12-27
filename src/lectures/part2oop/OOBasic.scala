package lectures.part2oop

object OOBasic extends App {

  val person  = new Person("John", 25)
  println(person.x)
  person.greetings("Jass")

  val author = new Writer("Charles","Dickens",1812)
  val novel = new Novel("Random thoughts", 1890, author)
  println(novel.authorAge)
  println(novel.isWrittenBy(author))

  val count = new Counter()
  println(count.inc.count)
  println(count.inc.inc.count)

}

class Person(name:String, val age:Int){
  val x = 2
  println(x+1)

  //method
  def greetings(name:String):Unit = println(s"${this.name} says Hi $name")

  // method overloding is applied
  def greetings():Unit = println("Something useless")
}

class Writer(firstName:String, surname:String, val year:Int){
  def fullName: String = firstName + " "+ surname
}

class Novel(name:String, year:Int,author:Writer){
  def authorAge = year - author.year
  def isWrittenBy(author:Writer) = author == this.author
  def copy(newYear:Int): Novel = new Novel(name,newYear,author)
}

/*
counter class
  - receives an int value
  - method for current count
  - method to increment/decrement => new counter
  - overload inc/dec to receive an amount
 */

class Counter(val count:Int = 0){
  def inc = new Counter(count+1)
  def dec = new Counter(count-1)

  def inc(n:Int):Counter = {
    if(n<=0) this
    else inc.inc(n-1)
  }
}