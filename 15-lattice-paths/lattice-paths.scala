import factorial._
import math._

val gridSize = 20

def centralBinomialCoeff(n: Int): Double = {
  factorial.get(2*n).toDouble/math.pow(factorial.get(n).toDouble, 2)
}

System.out.println(centralBinomialCoeff(gridSize))