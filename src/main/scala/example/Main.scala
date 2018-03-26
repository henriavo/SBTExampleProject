package example

object Main extends App {
  // http://docs.scala-lang.org/tour/basics.html
  // Contents.Basics

  val ages = Seq(42, 61, 29, 64)
  println(s"The oldest person is ${ages.max}")

  // EXPRESSIONS ----------------------------------

  println(1) // 1
  println(1 + 1) // 2
  println("Hello!") // Hello!
  println("Hello," + " world!") // Hello, world!

  // cannot re assign vals
  val x: Int = 300
  println(x)
  val y: Int = 500
  println(x + y)

  var a = 900
  var b = 300

  println( a + b)
  // re- assigning vars
  a = a -100
  b = b -100
  println(a + b)

  // explicit type
  var c: Int = 1400
  println(c)

  // BLOCKS ----------------------------------

  println({
    var a = 200
    a + 400
  })

  // FUNCTIONS ----------------------------------

  // anonymous function (no name function)
  (x: Int) => x + 1

  // naming functions
  val addOne = (x:Int) => x + 1
  println( addOne(250))

  // multiple parameters
  val addThem = (x:Int, y:Int) => x + y
  println( addThem(20, 30))

  // no parameters
  val noParam = () => 42
  println( noParam())

  // METHODS -------------------------------------

  def add(x:Int, y:Int): Int = x + y
  println( add(400,2000))

  // multiple parameters lists
  def addThenMultiply(x:Int, y:Int)(multiplier:Int): Int = (x + y) * multiplier
  println( addThenMultiply(2000, 2000)(3))

  // no parameters at all
  def name(): String = System.getProperty("user.name")
  println("my name is: " + name())

  // parenthesis optional
  def name2: String = System.getProperty("user.name")
  println("my name is: " + name)

  // multi-line expressions
  def getSquaredString(input: Double): String = {
    val square = input * input
    square.toString()
  }

  println(getSquaredString(33))

  // CLASSES -------------------------------------

  class GreeterA(prefix:String, suffix:String) {
    // method
    // 'Unit' is similar to java's 'Void'
    def greet(name:String): Unit = {
      println( prefix + name + suffix)
    }
  }

  val greeterA = new GreeterA("hello ", "!")
  greeterA.greet("Henri")

  // CASE CLASSES -----------------------------------
  // are supposed to be amazingly cool

  case class Point(x:Int, y:Int)

  val point = new Point(3,2)
  val anotherPoint = new Point(3,2)
  val yetAnotherPoint = new Point(3,3)

  if(point == anotherPoint) {
    println( point + " and " + anotherPoint + " are the same. ")
  }
  else {
    println(point + " and " + anotherPoint + " are not the same. ")
  }

  if(point == yetAnotherPoint) {
    println( point + " and " + yetAnotherPoint + " are the same. ")
  }
  else {
    println(point + " and " + yetAnotherPoint + " are not the same. ")
  }


  // OBJECTS --------------------------------------------
  // are singletons of their own classes

  object IdFactory {
    private var counter = 0

    def create(): Int = {
      counter += 1
      counter
    }

  }

    // use
    val newId = IdFactory.create()
    val newId2 = IdFactory.create()

    println( newId) // 1
    println( newId2) //2

    println( IdFactory.create()) // 3
    println( IdFactory.create()) // 4
    println( IdFactory.create()) // 5
    println( IdFactory.create()) // 6


  //TRAITS -----------------------------------------------
  // are types containing certain fields and methods. multiple traits can be combined.

  trait Greeter {
    def greet(name:String): Unit
  }

  // with default implementation
  trait Greeter2 {
    def greet (name:String): Unit = println("Hello " + name + "!")
  }

  // extend with 'extends'.
  // abstract
  abstract class DefaultGreeter extends Greeter

  // non-abstract
  class DefaultGreeter2 extends Greeter2

  class CustomizableGreeter2(prefix:String, postfix:String) extends Greeter2 {
    override def greet(name: String): Unit = {
      println(prefix + name + postfix)
    }
  }

  val greeter = new DefaultGreeter2()
  greeter.greet("Mark Wahlberg")

  val customGreeter = new CustomizableGreeter2("whats up ", ", you good?")
  customGreeter.greet("Mark")

  //MAIN METHOD ------------------------------------

  // cannot have two mains
//  object Main {
//    def main(args:Array[String]): Unit =
//      println("Hello scala developer!")
//  }



}
