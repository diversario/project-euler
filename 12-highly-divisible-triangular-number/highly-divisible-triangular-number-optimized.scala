import primes._

def triangleNumberOverXDivisors(limit: Double): Double = {
  val number = 1
  var i = 2
  var count = 0
  var lastCount = count
  var Dn1 = 2
  var Dn = 2
  val primeList = primes.generate(1000)

  while (count < limit) {
    if (i % 2 == 0) {
      Dn = primes.countDivisors(i + 1, primeList)
      count = Dn * Dn1
    } else {
      Dn1 = primes.countDivisors((i + 1)/2, primeList)
      count = Dn * Dn1
    }

    if (count > lastCount) {
      lastCount = count
      System.out.printf(f"$i -> $count\n")
    }

    i = i + 1
  }

  i * (i - 1) / 2
}

System.out.println(triangleNumberOverXDivisors(500))