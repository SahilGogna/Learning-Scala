package lectures.part1basics

object Functions extends App{
  def aFunction(a:String, b:Int): String = {
      a + " " + b
  }

//  println(aFunction("Hello ", 22 ))

  def aParameterLessFunction() = 42
  println(aParameterLessFunction) // note this can be called without the brackets

  def aRepeatedFunction(aString:String, n:Int): String = {
    if(n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }
//  println(aRepeatedFunction("Hello", 3))

  //  WHEN YOU NEED LOOPS USE RECURSION

  def aBigFunction (n:Int) : Int = {
    def aSmallFunction(a:Int, b:Int) : Int = a + b
    aSmallFunction(n,n-1)
  }

  // 1.
  def greeting(name:String, age:Int):String = {
    "Hi my name is $name and I am $age years old"
  }

  // 2. factorial of a number
  def factorial(n:Int) : Int = {
    if(n ==1) 1
    else n * factorial(n-1)
  }

//  println(factorial(6))

  // 3. fibonacci series
  def fibo(n:Int):Int = {
    if( n == 1 | n ==2 ) 1
    else fibo(n-1)+fibo(n-2)
  }
//  println(fibo(15))

  // 4. test if a number is prime or not

  def isPrime(n:Int, i: Int) : Boolean = {
    if( i == 1) true
    else if (n%i == 0) false
    else isPrime(n,i-1)
  }

  def isPrime2(n: Int) : Boolean = {
    def isPrimeAux(n: Int, i: Int): Boolean ={
      if( i == 1) true
      else if (n%i == 0) false
      else isPrimeAux(n,i-1)
    }
    isPrimeAux(n,n/2)
  }

  println(isPrime2(13))
}
