def pmap = [ Groovy: [ 'Asia', 'Jan' ],
             Grails: [ 'Asia', 'Jan', 'Stefan', 'Mirek' ],
             Java: [ 'Asia', 'Stefan', 'Mirek' ],
             JEE: [ 'Slawek', 'Stefan', 'Janusz' ]]

pmap.each {k,v -> println("${k}:${v.size()}")}
println("-------")
pmap.each {k,v -> if(v.size()>2) println("${k}")}
println("-------")

def employees = [:].withDefault {[]}
pmap.each{k,v ->
    v.each {
        employees.(it) +=k
    }
}
println employees

