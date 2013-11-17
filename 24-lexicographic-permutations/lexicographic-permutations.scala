val s = List(0,1,2,3,4,5,6,7,8,9)

val answer = s.permutations
              .drop(999999)
              .next
              .mkString

System.out.println(answer)