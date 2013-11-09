function sumOfSquares(n) {  
  return Math.round(Math.pow(n, 3)/3 + Math.pow(n, 2)/2 + n/6)
}

function sumOfFirstN (n) {
  return (n * (n+1))/2
}

function sumSquareDifference (n) {
  return Math.abs(sumOfSquares(n) - Math.pow(sumOfFirstN(n), 2))
}

console.log(sumSquareDifference(100))