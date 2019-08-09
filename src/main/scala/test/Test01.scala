import scala.io.Source
import scala.collection.mutable.Set

object Test01 {

  def main(args: Array[String]): Unit = {

    val inputFile = Source.fromFile("src/data/weather.txt");
//
//    while (inputFile.getLines().iterator.hasNext) {
//
//      println(inputFile.getLines().iterator.next())
//
//    }

//    val a = 10;
//
//    val b = if (a == 10) 1 else -1;
//
//    println(b);

    val temp = for (i <- 1 to 10 if i % 2 == 0) yield i

    println(temp)

    var list00 = 1 :: 2 :: Nil;

    var list01 = List(1, 2, 3, 4);

    var list02 = 0 :: list01;

    var list03 = list01 ::: list02;

    //println(list03.sum);

    list03 foreach print

    val tuple01 = ("hello", 2, 2.3);

    println(tuple01._1)

    var set01 = Set("hello");

    set01 += "world";

    val set02 = Set(1)

    set02 += 3;

    print(set02)

    val map01 = Map("1" -> "hello", 2 -> "world")

    val map01_01 = map01 filter(kv => kv._2.contains("ld"))

    println(map01.get(2))

    println(map01.contains(3))

    for ((k, v) <- map01) {
      println(k + "," + v)
    }

    //var value:Int =1;

    val counter: Int => Int = { (value) => value + 1 }

    //val say: Unit => Unit = { () => println("hello") }

    println(counter(1))

    val more="world";

    val say = (name:String) => name+","+more

    val testSay=()=>{println("test!")}

    println(say("hello"));

    testSay();

    //高阶函数

    //def sum(a:Int,b:Int):Int={

      //if(a>b) 0 else pre(a)+sum(a+1,b)

    //}

    //println(sum(1,3))

    //flatMap

    val testMap02=List("10","11","12")

    testMap02.flatMap(s=>s.toList) foreach print

    println()

    //闭包和柯里化
    def getSum(more:Int):Int=>Int=(x:Int)=>x+more

    var a=getSum(10)

    var b=getSum(10)

    println(a(2))

    println(b(9))

    def testKeli(a:Int)=(b:Int)=>a+b

    println(testKeli(1)(2))
  }

}