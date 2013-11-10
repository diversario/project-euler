import fibonacci._

var n = 0

do {
  n=n+1
} while (fibonacci.get(n).toString.length < 1000)

System.out.println(n)