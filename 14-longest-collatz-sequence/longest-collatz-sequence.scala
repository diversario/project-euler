def even(n: Double): Double = n/2
def odd(n: Double): Double = 3*n + 1
def next(n: Double): Double = n match {
  case n if n % 2 == 0 => even(n)
  case _ => odd(n)
}

def collatzSeq(start: Int): List[Double] = {
  def cs (seq: List[Double]): List[Double] = seq match {
    case _ :+ 1 => seq
    case _ :+ last => cs(seq ++ List(next(last)))
    case _ => throw new Error("What is going on?!")
  }
  
  cs(List(start))
}

def collatzSeqLength(start: Int): Int = {
  def cs (seq: Double, _length: Int): Int = seq match {
    case 1 => _length
    case m => cs(next(m), _length + 1)
  }
  
  cs(start, 1)
}


def longestChain(limit: Int): Int = {
  var maxLength = 0
  var maxN = 1
  var n = 1

  while (n < limit) {
    val l = collatzSeqLength(n)

    if (l > maxLength) {
      maxLength = l
      maxN = n
    }

    n = n + 1
  }

  maxN
}

longestChain(1000000)