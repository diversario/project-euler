import primes._

def findFactors(n: Int): List[Int] = {
  val primeFactors = primes.factorize(n)
  var factors: List[Int] = List(1)

  def multiply(l: List[Int]): Unit = l match {
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