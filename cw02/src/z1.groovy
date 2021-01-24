    static def maximum(list)
    {
        def maxVal = list.max()
        def maxIndexes = []
        list.eachWithIndex{ element, index -> if(element == maxVal) maxIndexes << index  }
        
        [maxVal,maxIndexes]
    }

    (maxVal, indList) = maximum( [5, 3, 5, 5, 1, 5] )
    println "Maximum: $maxVal"
    println "Indexes: $indList"

    (maxVal, indList) = maximum(['a', 'c', 'c', 'c', 'b'])
    println "Maximum: $maxVal"
    println "Indexes: $indList"
