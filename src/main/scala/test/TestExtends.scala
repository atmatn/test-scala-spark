package test

abstract class Car {

  var name:String;

  def info();

  def greeting(){println("is Car!")}

}
class BWMCar extends Car with getCar {
  override var name: String = "BWM"

  override def info(): Unit ={

    println("is BWM")

  }

  override def info2(): Unit = {}
}
class BYDCar extends Car{

  override var name: String = "BYD"

  override def info(): Unit ={

    println("is BYD")

  }
}
trait getCar{
  var name:String ;

  def info2();
}