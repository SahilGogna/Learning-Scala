package lectures.part2oop

object MethodNotations extends App {

  class Person(val name:String, favouriteMovie:String){
    def likes(movie:String): Boolean = movie == this.favouriteMovie
    def +(person:Person):String = s"${this.name} hangs out with ${person.name}"
  }

  val mary = new Person("Mary","Inception")
  val tom = new Person("Tom", "Fight Club")

  println(mary.likes("Inception"))
  // is equivalent to
  println(mary likes "Inception")
  // this is called infix notation

  //"operators in scala"

  println(mary + tom)
  println(mary.+(tom))

  // ALL OPERATORS ARE METHODS
  println(1+2)
  println(1.+(2))
}
