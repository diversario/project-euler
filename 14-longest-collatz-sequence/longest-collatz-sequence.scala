def even(n: Int): Int = n/2
def odd(n: Int): Int = 3*n + 1
def next(n: Int): Int = n match {
  case n if n % 2 == 0 => even(n)
  case _ => odd(n)
}

def collatzSeq(start: Int): List[Int] = {
  def cs (seq: List[Int]): List[Int] = seq match {
    case _ :+ 1 => seq
    case _ :+ last => cs(seq ++ List(next(last)))
    case _ => throw new Error("What is going on?!")
  }
  
  cs(List(start))
}