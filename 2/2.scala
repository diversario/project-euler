var memo = scala.collection.mutable.HashMap[Int, Int]()

def fib(n: Int): Int = {
  if (n == 0 || n == 1) n
  else {
    if (memo.getOrElse(n-2, -1) == -1) memo(n-2) = fib(n-2)
    if (memo.getOrElse(n-1, -1) == -1) memo(n-1) = fib(n-1)

    memo.get(n-2).get + memo.get(n-1).get
  }
}

def sumEvenFib(limit: Int): Int = {
  var sum = 0
  var fSeq = 0
  var i = 0

  while (fSeq < limit) {
    if (fSeq % 2 == 0) sum = sum + fSeq
    i = i + 1
    fSeq = fib(i)
  }

  sum
}

System.out.println(sumEvenFib(4000000))