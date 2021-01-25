import java.text.Collator
import javax.swing.JOptionPane as JOP

def words = new URL('http://wiki.puzzlers.org/pub/wordlists/unixdict.txt').getText('UTF-8').tokenize()
def anagrams = new TreeMap<String,TreeSet<String>>(Collator.getInstance(new Locale('EN')))

words.each {
    def key = it.toCharArray().toList().sort().join()
    if(anagrams.containsKey(key))
        anagrams.get(key).add(it)
    else
    {
        def set = new TreeSet<String>()
        set.add(it)
        anagrams.put(key,set)
    }
}

anagrams = anagrams.findAll {it.value.size()>1}
anagrams = anagrams.sort({a, b ->b.value.size()-a.value.size()})

anagrams.each {println(it.value)}
println("----------")

while (inputDialog  = JOP.showInputDialog('Podaj słowo')) {
    def key = inputDialog.toCharArray().toList().sort().join()
    println anagrams.get(key)
}