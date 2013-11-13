package factorial

object factorial {

  // Tail-recursive factorial calculator
  def get(n: Int): BigInt = {
    def _f(_n: Int, acc: BigInt): BigInt = _n match {
      case 1 => acc
      case _ => _f(_n - 1, acc * _n)
    }

    _f(n, 1)
  }

}
