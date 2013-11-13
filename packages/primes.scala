package primes

object primes {
  import math.sqrt

  val memo: scala.collection.mutable.Map[Double, Double] = scala.collection.mutable.Map(0.0->0.0, 1.0->2.0)

  def generate(n: Double): List[Double] = {
    if (n == 0) throw new Error("Argument must be an integer >= 1")

    var primeList: List[Double] = List(2.0)
    var num = 3.0
    var isPrime = true

    while (primeList.length < n) {
      // do we have the prime we're about to calculate?
      if (memo.getOrElse(primeList.length + 1, 0) != 0) {
        primeList = primeList :+ memo.get(primeList.length + 1).get
        num = memo.get(primeList.length).get
      } else {
        val root = sqrt(num)

        isPrime = true

        for (p <- primeList if p <= root) {
          isPrime = num % p != 0
        }

        if (isPrime) {
          primeList = primeList :+ num

          if (primeList.length > 1 && memo.getOrElse(primeList.length, 0) == 0) {
            memo(primeList.length) = num
          }
        }
      }

      num = num + 2
    }

    primeList
  }

  def get(n: Double): Double = {
    generate(n).last
  }

  def factorize(n: Double): List[Double] = {
    var factors: List[Double] = List()
    var done = false
    var num = n
    var primeNum = 0.0

    while (!done) {
      var i = 1 // first prime number, 2

      primeNum = get(i)

      if (primeNum >= num) {
        done = true
      } else {
        while (num % primeNum != 0) {
          i = i+1
          primeNum = get(i)
        }

        factors = factors :+ primeNum
        num = num/primeNum
      }
    }

    factors
  }

  def countDivisors(n: Double, primes: List[Double]): Int = {
    var count = 1
    var exponent = 1
    var remain = n

    var done = false

    for (p <- primes if !done; i <- 0 until primes.length if !done) {
      if (p * p > n) {
        count = count * 2
        done = true
      } else {
        exponent = 1

        while (remain % p == 0) {
          exponent = exponent + 1
          remain = remain / p
        }

        count = count * exponent

        if (remain == 1) {
          done = true
        }
      }
    }

    count
  }
}