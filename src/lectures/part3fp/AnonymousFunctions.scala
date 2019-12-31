package lectures.part3fp

object AnonymousFunctions extends App{

//  Anonymous  function lambda
  var doubler:(Int)=>Int = (x:Int) => x * 2
// multiple params in lambda
  var adder:(Int,Int)=>Int = (a:Int,b:Int) => a+b
// no parameter
  var doSomething:()=>Int = () => 41111

  println(doubler(3))
  println(adder(2,3))
  println(doSomething())

  // More syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a,b) => a + b


  val specialAdder = (x:Int) => (y:Int) => x+y

}
