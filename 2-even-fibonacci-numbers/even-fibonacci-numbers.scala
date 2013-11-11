// run from the root directory:
// scala -classpath `pwd`/packages 2-even-fibonacci-numbers/2.scala

import fibonacci._

def sumEvenFib(limit: Int): Int = {
  var sum = 0
  var fSeq = 0
  var i = 0

  while (fSeq < limit) {
    if (fSeq % 2 == 0) sum = sum + fSeq
    i = i + 1
    fSeq = fibonacci.get(i)
  }

  sum
}

System.out.println(sumEvenFib(4000000))