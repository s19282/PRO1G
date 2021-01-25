def counter = 1
def fib
fib = { n ->
    counter++
    if (n < 2) n
    else
        fib(n - 1) + fib(n - 2)
}
assert fib(15)
println "Bez użycia memoize(): $counter"

counter = 1
fib = { n ->
    counter++
    if (n < 2) n
    else
        fib(n - 1) + fib(n - 2)
}.memoize()

assert fib(25)

println "Z użyciem memoize(): $counter"