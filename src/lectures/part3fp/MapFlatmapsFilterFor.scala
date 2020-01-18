package lectures.part3fp

object MapFlatmapsFilterFor extends App {

  val list = List(1,2,3,4,5,6,7,8)
  println(list)
  //map
//  map() takes some function as a parameter.
//  map() applies the function to every element of the source collection.
//  map() returns a new collection of the same type as the source collection.
  def square(number:Int) : Int = number*number

  println(list.map(square))
  println(list.map(x => x*x))
  println(list.map(_ + " is a member"))

  // filter
  // takes a function as parameter and this function should return a boolean
  // applies the function to every element of the source collection.
  // returns a new collection of the elements which returned true when the function was applied on them
  def even(number:Int):Boolean = number%2 == 0
  println(list.filter(even))

  // flatmap
  val stringList = List("Sahil","Gogna")
  val res1 = stringList.map(_.toLowerCase())
  println(res1)
  println(res1.flatten)

  // print all combinations between lists
  // in other programming languages this would have been implemented using loops but here we use flat maps and maps
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colors = List("black", "white")

  //iterating
  val comb1 = numbers.flatMap(number => chars.flatMap(char => colors.map( color => "" + number+"-"+char+"-"+color)))
  println(comb1)

  // for comprehension
  val comb2 = for{
    n <- numbers
    c <- chars
    co <- colors
  } yield "" + n+"-"+c+"-"+co
  println(comb2)

  // we can also filter results
  val comb3 = for{
    n <- numbers if n%2 == 0
    c <- chars
    co <- colors
  } yield "" + n+"-"+c+"-"+co
  println(comb3)

  // how to do this using filter function
  val comb4 = numbers.filter(_%2 == 0).flatMap(number => chars.flatMap(char => colors.map( color => "" + number+"-"+char+"-"+color)))
  println(comb4)


}
