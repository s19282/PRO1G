import javax.swing.JOptionPane as OP

class z4 {
    static void main(String[] args) {
        def words = 'zero jeden dwa trzy cztery pięć sześć siedem osiem dziewięć'.tokenize()
        def map = [ '-' : 'minus'].withDefault {'NaN'}

        map << ((0..<words.size()).collectEntries { i -> [i.toString(), words[i]] } as Map<String, String>)

        def out = OP.showInputDialog('Podaj liczbę')
        .collect{map[it]}.join('-')

        println out
    }
}
