package lectures.part2oop

object MethodNotations extends App {

  class Person(val name:String, val favouriteMovie:String, val age:Int = 0){
    def likes(movie:String): Boolean = movie == this.favouriteMovie
    def +(person:Person):String = s"${this.name} hangs out with ${person.name}"
    def +(nickName:String):Person = new Person(s"$name ($nickName)",favouriteMovie)
    def unary_+ : Person = new Person(name,favouriteMovie,age+1)
    def learns(thing: String) = s"$name is learning $thing"
    def learnsScala = this learns "Scala"
  }

  val mary = new Person("Mary","Inception")
  val tom = new Person("Tom", "Fight Club")

  println(mary.likes("Inception"))
  // is equivalent to
  println(mary likes "Inception")
  // this is called infix notation syntactical sugar

  //"operators in scala"

  println(mary + tom)
  println(mary.+(tom))

  // ALL OPERATORS ARE METHODS
  println(1+2)
  println(1.+(2))

  //prefix notations, postfix notations - learn if needed

  /*
    1.  Overload the + operator
        mary + "the rockstar" => new person "Mary (the rockstar)"
    2.  Add an age to the Person class
        Add a unary + operator => new person with the age + 1
        +mary => mary with the age incrementer
    3.  Add a "learns" method in the Person class => "Mary learns Scala"
        Add a learnsScala method, calls learns method with "Scala".
        Use it in postfix notation.
    4.  Overload the apply method
        mary.apply(2) => "Mary watched Inception 2 times"
   */

  println(mary + "theRockstar")
  println((+mary).age)

}
