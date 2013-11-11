package factorial

object factorial {

  // Tail-recursive factorial calculator
  def get(n: Int): BigInt = {
    def _f(_n: Int, z: BigInt): BigInt = _n match {
      case 0 => 1
      case `n` => z
      case _ => _f(_n + 1, z * (_n + 1))
    }

    _f(1, 1)
  }

}