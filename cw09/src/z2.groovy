import groovy.swing.SwingBuilder
import javax.swing.*
import java.awt.*

def colors = [Color.CYAN, Color.MAGENTA, Color.YELLOW, Color.BLACK]
def c = 0

new SwingBuilder().edt {
    frame(title: 'ColoredButton', defaultCloseOperation: JFrame.EXIT_ON_CLOSE, pack: true, show: true) {
        button(text: 'Zmień kolor', actionPerformed: { e ->
            if (c == colors.size())
                c = 0
            e.source.background = colors[c++]
        } )
    }
}