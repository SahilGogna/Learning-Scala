package lectures.part1basics

object StringOps extends App {

  val str:String = "Hello, I am learning scala"

  println(str.charAt(2))
  println(str.substring(4))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  // scala specific : String interpolation

  //s-interpolation

  val name = "David"
  val age = 12
  val greeting = s"Hello my name is $name and I am $age years old"
  val greeting2 = s"We can also change the value of the variable like ${age+2}"
  println(greeting)
  println(greeting2)

  // f-interpolation
  val speed = 1.2f
  val myth = f"I can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw interpolator
  println(raw"This newline \n will be ignored")
  val test = "This is a \nnewLine"
  println(raw"$test")

}
