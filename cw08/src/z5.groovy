import java.text.Collator

def words = new File('../files/countWords.txt')
def map = new TreeMap(Collator.getInstance(new Locale('PL'))).withDefault {0}

words.text.tokenize(' \n\r\t!,;,.?:').each {map[it]++}
println map.sort()
