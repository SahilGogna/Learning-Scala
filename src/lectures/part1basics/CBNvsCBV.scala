package lectures.part1basics

object CBNvsCBV extends App {

  def callByValue(x:Long):Unit = {
      println("By Value: "+x)
      println("By Value: "+x)
  }

  def callByName(x: => Long):Unit = {
    println("By Name: "+x)
    println("By Name: "+x)
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())


}
