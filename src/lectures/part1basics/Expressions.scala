package lectures.part1basics

object Expressions extends App{

  val x = 1+2 // Expression something which evaluates to something, has a type
  println(x)

  //Instructions (we tell compiler to do something) vs Expressions (evaluates to a value)
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 9
  println(aConditionedValue)

  //everything in scala is an expression
  // side effects are something that returns unit === void in other languages
  // eg: printing something to the console, while loops, reassigning a value

  var aVariable = 5
  val  awieredNumber = (aVariable = 10)

  //code blocks
  // the are expressions, last expression is the return value, scope of variables is just inside the block
  val aCodeBlock = {
    val k = 3
    val i = k+4
    if (k>6) "Good" else "Bad"
  }

  //Questions
  //1. What's the difference bw "Hello" vs println("Hello")

  //2. What's the value of

  val someVal = {
    2>3
  }
  // someval = false

  val anotherVal = {
    if (someVal) 3 else 2
    4
  }
  //anotherval = 4

}
