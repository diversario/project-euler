var memo = [undefined, 2]

function generatePrimes(n) {
  if (!n) throw new Error('Argument must be an integer >= 1')

  var primeList = [2]
    , num = 3
    , isPrime = true

  while (primeList.length < n) {
    // do we have the prime we're about to calculate?
    if (memo[primeList.length + 1]) {
      primeList.push(memo[primeList.length + 1])
      isPrime = true
      // since we just pushed to primeList `num` is being set to that pushed number
      num = memo[primeList.length]
    } else {
      var root = Math.sqrt(num)
      primeList.some(function (prime) {
        if (num % prime == 0) {
          isPrime = false
          return true
        }

        if (prime > root) return true
      })

      if (isPrime) {
        primeList.push(num)

        if (primeList.length > 1 && !memo[primeList.length]) {
          memo[primeList.length] = num  
        }
      } else {
        isPrime = true
      }
    }

    num += 2
  }

  return primeList
}

function prime(n) {
  return generatePrimes(n)[n-1]
}

function primeFactorize(n) {
  var factors = []
    , done = false
    , num = n
    , primeNum

  while (!done) {
    var i = 1 // first prime number, 2

    primeNum = prime(i)

    if (primeNum >= num) {
      done = true
      break;
    }

    while (num % primeNum !== 0) {
      i++
    }

    factors.push(primeNum)
    num = num/primeNum
  }

  return factors
}

function largestPrimeFactor(n) {
  var factors = primeFactorize(n)
  return factors[factors.length-1]
}

exports.prime = prime
exports.generatePrimes = generatePrimes
exports.primeFactorize = primeFactorize
exports.largestPrimeFactor = largestPrimeFactor

//console.log(largestPrimeFactor(600851475143))