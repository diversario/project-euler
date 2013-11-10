var memo = scala.collection.mutable.HashMap[Int, Int]()

// Recursive with memo
def fib(n: Int): Int = {
  if (n == 0 || n == 1) n
  else {
    if (memo.getOrElse(n-2, -1) == -1) memo(n-2) = fib(n-2)
    if (memo.getOrElse(n-1, -1) == -1) memo(n-1) = fib(n-1)

    memo.get(n-2).get + memo.get(n-1).get
  }
}

// Tail-recursive, no memo
def fibTail(n: BigInt): BigInt = {
  def _f(_n: Int, a: BigInt, b: BigInt): BigInt = _n match {
    case `n` => a
    case _ => _f(_n+1, b, a+b)
  }

  _f(0, 1, 1)
}

def sumEvenFib(limit: Int): Int = {
  var sum = 0
  var fSeq = 0
  var i = 0

  while (fSeq < limit) {
    if (fSeq % 2 == 0) sum = sum + fSeq
    i = i + 1
    fSeq = fibTail(i)
  }

  sum
}

System.out.println(sumEvenFib(4000000))