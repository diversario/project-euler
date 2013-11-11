package fibonacci

object fibonacci {
  // Tail-recursive, no memo
  def get(n: Int): BigInt = {
    def _f(_n: Int, a: BigInt, b: BigInt): BigInt = _n match {
      case `n` => a
      case _ => _f(_n+1, b, a+b)
    }

    _f(1, 1, 1)
  }
}

// Not used
// object fibonacci_rec {
//   var memo = scala.collection.mutable.HashMap[Int, Int]()

//   // Recursive with memo
//   def get(n: Int): Int = {
//     if (n == 0 || n == 1) n
//     else {
//       if (memo.getOrElse(n-2, -1) == -1) memo(n-2) = get(n-2)
//       if (memo.getOrElse(n-1, -1) == -1) memo(n-1) = get(n-1)

//       memo.get(n-2).get + memo.get(n-1).get
//     }
//   }
// }