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

def generateTriangleNumbers(n: Int): Int = {
  var s = 0
  for (x <- 0 to n) s = s + x
  s
}

def triangleNumberOverXDivisors(limit: Int): Int = {
  var i = 1

  while (findFactors(generateTriangleNumbers(i)).length < limit) {
    i = i + 1
  } 
  i
}