package primes

import math.sqrt

object primes {
  val memo: scala.collection.mutable.Map[Int, Int] = scala.collection.mutable.Map(0->0, 1->2)

  def generate(n: Int): List[Int] = {
    if (n == 0) throw new Error("Argument must be an integer >= 1")

    var primeList: List[Int] = List(2)
    var num = 3
    var isPrime = true

    while (primeList.length < n) {
      // do we have the prime we're about to calculate?
      if (memo.getOrElse(primeList.length + 1, 0) != 0) {
        primeList = primeList :+ memo.get(primeList.length + 1).get
        isPrime = true
        num = memo.get(primeList.length).get
      } else {
        val root = sqrt(num)

        isPrime = true

        // how do I break the loop?..
        for (p <- primeList) {
          if (num % p == 0) {
            isPrime = false
          }
          
          if (isPrime && p > root) {
            isPrime = true
          }
        }

        if (isPrime) {
          primeList = primeList :+ num

          if (primeList.length > 1 && memo.getOrElse(primeList.length, 0) == 0) {
            memo(primeList.length) = num
          }
        } else {
          isPrime = true
        }
      }

      num = num + 2
    }

    primeList
  }
}