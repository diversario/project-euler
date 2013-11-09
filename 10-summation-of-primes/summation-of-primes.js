var prime = require('../3-largest-prime-factor/largestPrime').prime

var total = 0
  , p = 0, n = 1

while ((p = prime(n)) < 2000000) {
  total += p
  n++
}

console.log(total)