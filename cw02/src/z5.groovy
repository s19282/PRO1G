static def eachTuple(def source, Closure c)
{
    def numOfParams =  c.maximumNumberOfParameters
    if(source instanceof String)
    {
        source = source.collect{it.toString()}
        source = source.collate(numOfParams)
    }
    else
        source=source.collate(numOfParams)

    source.each{c(it)}
}


def list = (1..40)

eachTuple(list) { e1, e2, e3, e4 ->
    println "$e1 $e2 $e3 $e4"
}

def s = 'asia ma kota i psa'

def out = new StringBuffer()

eachTuple(s) { a,b ->
    out << b << a
}
println out