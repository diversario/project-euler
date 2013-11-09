function sumFizzBuzz (n) {
  var sum = 0

  while (n-- > 0) {
    if (n%3 == 0 || n%5 == 0) sum += n
  }

  return sum
}

console.log(sumFizzBuzz(1000))