package lectures.part3fp

object WhatsAFunction extends App {

  val doubler = new MyFunction[Int,Int] {
    override def apply(element: Int): Int = element*2
  }

  println(doubler(3))

  val stringToIntConverter = new Function1[String,Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("23" )+ 2)

  val adder:(Int,Int) => Int = new Function2[Int,Int,Int] {
    override def apply(a: Int, b: Int): Int = a+b
  }

  println(adder(2,3))


  trait MyFunction[A,B] {
    def apply(element:A):B
  }

  //ALL SCALA FUNCTIONS ARE OBJECTS

  /*
   1.  a function which takes 2 strings and concatenates them
   2.  transform the MyPredicate and MyTransformer into function types
   3.  define a function which takes an int and returns another function which takes an int and returns an int
       - what's the type of this function
       - how to do it
  */

  def joinStrings : (String,String) => String = new Function2[String,String,String] {
    override def apply(v1: String, v2: String): String = s"$v1$v2"
  }

  println(joinStrings("Hello","Scala"))

  val newAdder :Function1[Int,Function1[Int,Int]] = new Function1[Int,Function1[Int,Int]]{
    override def apply(a: Int): Function1[Int,Int] = new Function1[Int,Int]{
      override def apply(b: Int): Int = {
        a+b
      }
    }
  }

  val adder3 = newAdder(7)
  println(newAdder(31)(4)) // curried function
  println(adder3(2))
}
