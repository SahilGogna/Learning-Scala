package lectures.part2oop

object Objects extends App{

  // SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITIES like java has static keyword
  // SCALA HAS SOMETHING SIMILAR
  //Objects do not receive parameters

  object Person{
    val N_EYES = 2
    def canFly : Boolean = false
  }
  println(Person.N_EYES)

  //scala object is singleton instance
  // writing objects and classes with same name and in same scope is called companions
  class Person{
    // instance level
  }

    //scala applications

}
