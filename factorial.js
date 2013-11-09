var memo = {}

function facRecursive(n) {
  if (memo[n]) return memo[n]
  
  if (n == 0) return 1

  var f = fac(n-1);

  memo[n-1] = f
  memo[n] = n * memo[n-1]

  return memo[n]
}

function facLoop(n) {
  var f = 1

  while (n > 1) {
    f *= n--
  }

  return f
}