package lectures.part3fp

object HOFsCurries extends App {

  //HOF are which takes a function as a parameter or returns a function
  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null

  // function that applies a function n times over a value x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x)) = f(f(f(x)))
  // nTimes(f, n, x) = f(f(...f(x))) = nTimes(f, n-1, f(x))

  def nTimes(F:Int=> Int, n:Int, x:Int) : Int = {
    if(n<=0) x
    else nTimes(F,n-1,F(x))
  }
  val plusOne = (x:Int) => x+1
  println(nTimes(plusOne,10,1))

  def nTimesBetter(f:Int => Int, n:Int) :(Int =>Int) = {
    if (n <= 0) (x:Int) => x
    else (x:Int)=>nTimesBetter(f,n-1)(f(x))
  }

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(7))

    // curried functions with multiple parameters

  def curriedFormatter (c:String)(x:Double):String = c.format(x)

  val standardFormatter: (Double => String) = curriedFormatter("%3.4f")
  println(standardFormatter(Math.PI))

}
