// scala -classpath `pwd`/packages 20-factorial-digit-sum/factorial-digit-sum.scala

import factorial._

val sum = factorial.get(100).toString
  .map((c) => c.toString.toInt)
  .reduce(_+_)

System.out.println(sum)