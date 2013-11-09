function smallestDivisible (divisors) {
  divisors.sort()

  // we start at the double of the max divisor
  var n = divisors[divisors.length - 1] * 2

  while(!isDivisible(n, divisors)) n++

  return n
}

function isDivisible (n, divisors) {
  return divisors.every(function(divisor) {
    return n % divisor === 0
  })
}

smallestDivisible([1,2,3,4,5,6,7,8,9,10])