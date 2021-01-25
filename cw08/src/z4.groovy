def words = new File('../files/words.txt')
List list = []
words.each {list.addAll(it.tokenize())}

def set = new TreeSet(new Comparator<String>() {
    @Override
    int compare(String o1, String o2) {
       if(o1.length()==o2.length())
           return o2 <=> o1
        else
           return o2.length()-o1.length()
    }
})

list.each { set << it}

println(set)