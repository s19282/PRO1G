static List apply(List l, Closure c)
{
    List output = []
    l.each {output << c(it)}
    output
}

println apply ([1,2,3]) {it*2}
println apply ([0,1,2,3,4,6,7,8,9]) {if(it>5) it*3 else it }
println apply (['a','b','c']) {it+'D'}