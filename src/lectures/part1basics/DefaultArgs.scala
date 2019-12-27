package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def factHelper(x:Int, accumulator:Int = 10):Int = {
    if (x <= 1) accumulator
    else factHelper(x-1,x*accumulator)
  }

  val fat10 = factHelper(10)

  def savePicture(format:String = "jpg",width:Int = 800,height:Int= 1200):Unit = println("Something useless")
  savePicture(height = 800)
}
