import primes._

def findFactors(n: Double): List[Double] = {
  val primeFactors = primes.factorize(n)
  var factors: List[Double] = List(1)

  def multiply(l: List[Double]): Unit = l match {
    case head :: tail => {
      var i = 1

      while (i <= tail.length) {
        val p = head * tail.take(i).product
        factors = factors :+ p
        i = i + 1
      }

      multiply(tail)
    }
    case list if list.length == 0 => Unit
  }

  multiply(primeFactors)
  (factors ::: primeFactors).distinct.sorted
}

def generateTriangleNumbers(n: Double) = n * (n + 1) / 2

def triangleNumberOverXDivisors(limit: Double): Double = {
  var i: Double = 1
  var done = false
  var max = 0
  var m = 0.0

  while (!done) {
    val n = generateTriangleNumbers(i)
    val factors = findFactors(n)
    val length = factors.length

    if (length > max) {
      max = length
      m = i
      System.out.printf(f"$m -> $max\n")
    }

    if (length >= limit) done = true
    else i = i + 1
  } 
  i
}

System.out.println(triangleNumberOverXDivisors(500))