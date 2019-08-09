import scala.util.control.Breaks

object TestSort {

  def main(args: Array[String]): Unit = {

    val arr = Array(1, 3, 6, 7, 5, 10, 9, 8, 4, 2);

    //bubbleSort(arr)

    //selectSort(arr, 0)

    //insertSort(arr)

    //shellSort(arr)

    //quickSort(arr,0,arr.length-1)
    
    mergeSort(arr,0,arr.length-1)

    arr.foreach[Unit] { (x: Int) => print(x + "\t") }

    println()

  }

  def bubbleSort(arr: Array[Int]): Unit = {

    val loop = Breaks;

    var flag = 0

    for (i: Int <- 0 to arr.length - 1) {

      loop.breakable {

        if (i + 1 == 10) {
          loop.break()
        }

        if (arr(i + 1) <= arr(i)) {

          val temp = arr(i)

          arr(i) = arr(i + 1)

          arr(i + 1) = temp

        } else {

          loop.break()

        }

        flag = i

      }

    }

    if (flag != 0) {

      bubbleSort(arr)

    }

  }

  def selectSort(arr: Array[Int], index: Int): Unit = {

    val loop = Breaks

    for (i <- index to arr.length - 1) {

      loop.breakable {

        if (i + 1 == 10) {
          loop.break()
        }

        if (arr(i + 1) <= arr(index)) {

          val temp = arr(index)

          arr(index) = arr(i + 1)

          arr(i + 1) = temp

        } else {

          loop.break()

        }

      }

    }

    if (index <= arr.length - 1) {

      selectSort(arr, index + 1)

    }

  }

  def insertSort(arr: Array[Int]): Unit = {

    val loop = Breaks

    //数组第一个元素作为有序数组
    for (i <- 1 to arr.length - 1) {

      for (j <- 0 to i - 1) {

        loop.breakable {

          if (arr(i) <= arr(j)) {

            val temp = arr(i)

            arr(i) = arr(j)

            arr(j) = temp

          } else {

            loop.break()

          }

        }

      }

    }

  }

  def shellSort(arr: Array[Int]): Unit = {

    var incrame = arr.length / 2 //设置间隔为1/2的数组长度

    val loop = Breaks

    while (incrame >= 1) {

      for (i <- 1 to arr.length - 1 by incrame) {

        for (j <- 0 to i by incrame) {

          loop.breakable {

            if (arr(j) >= arr(i)) {

              val temp = arr(i)

              arr(i) = arr(j)

              arr(j) = temp

            } else {

              loop.break()

            }

          }

        }

      }

      incrame -= 1

    }

  }

  def quickSort(arr:Array[Int],leftIndex:Int,rightIndex:Int):Unit={

    var a=leftIndex
    var b=rightIndex
    val key=arr(leftIndex)//选择第一个元素作为基准
    while(a<b){

      while(a<b&&arr(b) > key){

        b-=1

      }

      if(a<b){

        val temp =arr(a)

        arr(a)=arr(b)

        arr(b)=temp

      }

      while(leftIndex<rightIndex&&arr(a) < key){

        a+=1

      }

      if(a<b){

        val temp =arr(a)

        arr(a)=arr(b)

        arr(b)=temp

      }

    }

    if(a>leftIndex){

      quickSort(arr,leftIndex,a-1)

    }

    if(b<rightIndex){

      quickSort(arr,a+1,rightIndex)

    }

  }

  def mergeSort(arr: Array[Int],leftIndex:Int,rightIndex:Int):Unit={

    if(leftIndex>=rightIndex)return;

    val mid=(leftIndex+rightIndex)/2

    mergeSort(arr,leftIndex,mid)

    mergeSort(arr,mid+1,rightIndex)

    merge(arr,leftIndex,mid+1,rightIndex)

  }

  def merge(arr: Array[Int],leftIndex:Int,midIndex:Int,rightIndex:Int):Unit={

    //创建两个临时数组并初始化
    val left=new Array[Int](midIndex-leftIndex)

    val right=new Array[Int](rightIndex-midIndex)

    for(i<-0 to left.length-1){

      left(i)=arr(i)

    }

    for(i<-midIndex to right.length-1){

      right(i-midIndex)=arr(i)

    }

    var l=0

    var r=0

    var target=leftIndex //从arr的第一个元素开始，把比较的结果写入

    //进行比较
    while(l<left.length&&r<right.length) {

      if (left(l) > right(r)) {

        arr(target) = right(r)

        r += 1

        target += 1

      }else{

        arr(target) = right(l)

        l+=1

        target+=1

      }

    }
    while (l < left.length) {

      arr(target) = left(l);

      l+=1;

      target+=1;

    }

    while (r < right.length) {

      arr(target) = right(r);

      r+=1;

      target+=1;

    }

  }

}
