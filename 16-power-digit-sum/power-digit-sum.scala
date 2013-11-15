// wrote this before discovering BigInt.pow
def power(n: BigInt, pow: Double): BigInt = {
  def p(_pow: Double, acc: BigInt): BigInt = _pow match {
    case 1 => acc
    case _ => p(_pow-1, acc * n)
  }

  p(pow, n)
}

val base: BigInt = 2

val sum = base.pow(1000)
            .toString
            .map(_.toString.toInt)
            .toList
            .sum

System.out.println(sum)