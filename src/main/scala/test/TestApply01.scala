package test

class TestApply01 {

  private var name="world";

  def this(name:String){

    this()

    this.name=name

  }

  def info(){

    TestApply01.say();

    println(name)

  }

}
object TestApply01{

  def apply(name: String): TestApply01 = {

    println("hello world!")

    new TestApply01(name)
  }

  def say(){println("hello")}

}
object MyTest{

  def main(args: Array[String]): Unit = {

    val temp1=TestApply01("world");

    val temp2=TestApply01("world");

    temp1.info();

    temp2.info();

  }
}