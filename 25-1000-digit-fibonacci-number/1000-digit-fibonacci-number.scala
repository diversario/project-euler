def fibTail(n: BigInt): BigInt = {
  def _f(_n: Int, a: BigInt, b: BigInt): BigInt = _n match {
    case `n` => a
    case _ => _f(_n+1, b, a+b)
  }

  _f(1, 1, 1)
}

var n = 1

while (fibTail(n).toString().length != 1000) n = n+1

System.out.println(n)