package example

object AnotherMain extends App {

  // CLASSES

  // defining a class
  // notice it already has a default constructor
  class User
  val user1 = new User


  // a class with an explicit constructor and class body
  // notice the constructor is in the class signature below
  class Point(var x:Int, var y:Int) {

    def move(dx:Int, dy:Int): Unit ={
      x = x + dx
      y = y + dy
    }

    override def toString: String =
      s"($x, $y)"

  } // end of point class

  val point1 = new Point(2,3)
  println(point1.x) // prints 2
  println(point1) // prints (2, 3)

  // CONSTRUCTORS

  class PointTwo(var x:Int=0, var y:Int=0)

  val origin = new PointTwo
  println(origin.x)
  println(origin.y)

  val point2 = new PointTwo(4,6)
  println(point2.x)
  println(point2.y)

  // explicitly setting on of the two optional parameters in the constructor of PointTwo
  val point3 = new PointTwo(y=8)
  println(point3.x)
  println(point3.y)

  // PRIVATE MEMBERS AND GETTER/SETTER SYNTAX
  // all members are public by default, adding explicit 'private' makes it private
  class PointThree {
    private var _x = 0
    private var _y = 0
    private val bound = 100

    // methods for accessing private members:
    def x = _x
    def y = _y


    // somehow these are called!? its smart enought to call this when setting values to x or y?
    def x_= (newVal:Int): Unit = {
      if (newVal < bound) _x = newVal else printWarning
    }
    def y_= (newVal:Int): Unit = {
      if(newVal < bound) _y = newVal else printWarning
    }

    private def printWarning(): Unit = println("WARNING: out of bounds!")
  }

  val point4 = new PointThree
  point4.x = 80
  point4.y = 101



  class PointFour(val x:Int, val y:Int)
  val point5 = new PointFour(3,5)
  // below won't compile because you are trying to modify a VAL type
  // point5.x = 10



  class PointFive(x:Int, y:Int)
  val point6 = new PointFive(7, 8)
  // below wont compile, because parameters in constructor without 'val' or 'val' are private members
  // point6.x
}
