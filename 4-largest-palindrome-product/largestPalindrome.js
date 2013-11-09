function largestPalindrome(numLength) {
  var min, max, product, palindrome = 0

  min = Math.pow(10, numLength - 1)
  max = Math.pow(10, numLength)

  for (var i = min; i < max; i++) {
    for (var k = i; k < max; k++) {
      product = i * k

      if (product > palindrome && isPalindrome(product)) {
        palindrome = product
      }
    }
  }

  return palindrome
}

// determine is `n` is a palindrome number
function isPalindrome (n) {
  n = n.toString()

  var parts = split(n)

  return parts[0] === reverse(parts[1])
}

// split string `str` into two parts,
// omitting the middle if `str` length is odd
function split (str) {
  var left, right

  if (str.length % 2 == 0) {
    left = str.substr(0, str.length/2)
    right = str.substr(str.length/2)
  } else {
    left = str.substr(0, str.length/2)
    right = str.substr(str.length/2 + 1)
  }

  return [left, right]
}

// reverse string `str`
function reverse (str) {
  var reversed = ''

  for (var i = str.length-1; i >= 0; i--) {
    reversed += str[i]
  }

  return reversed
}