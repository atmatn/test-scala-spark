package test

import scala.io.Source

object TestWordCount {

  def main(args: Array[String]): Unit = {

    val targetFile=Source.fromFile("src/data/wordcount.txt")

    val lines=targetFile.getLines();

    var myMap=scala.collection.mutable.Map[String,Int]();

    lines.foreach(s=>{

      s.split("[ ]+").foreach(i =>

        if(myMap.contains(i)){

          myMap(i)+=1

        }else {

          myMap+=(i->1)

        }
      )

    })

    myMap foreach println

  }

}
