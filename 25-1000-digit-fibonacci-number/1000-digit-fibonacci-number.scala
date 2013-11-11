// scala -classpath `pwd`/packages 25-1000-digit-fibonacci-number/1000-digit-fibonacci-number.scala

import fibonacci._

var n = 0

do {
  n=n+1
} while (fibonacci.get(n).toString.length < 1000)

System.out.println(n)