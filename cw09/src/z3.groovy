import groovy.swing.SwingBuilder
import javax.swing.*
import java.awt.*
import static javax.swing.JOptionPane.*

def buttonNames = 'Przycisk 1=Przycisk 2=Przycisk 3=Przycisk 4=Przycisk 5'.tokenize("=")

LayoutManager[] lm = new LayoutManager[3]

lm[0] = new FlowLayout()
lm[1] = new BorderLayout()
lm[2] = new GridLayout(3,2)

def chosenLayout = ""

while (!chosenLayout.isInteger() || !(Integer.parseInt(chosenLayout) in (1..3))) {
    chosenLayout = showInputDialog('Wybierz layout(1-3)' +
            '\n1 => FlowLayout' +
            '\n2 => BorderLayout' +
            '\n3 => GridLayout 3x2')
}

new SwingBuilder().edt {
    frame(title: 'Buttons', defaultCloseOperation: JFrame.EXIT_ON_CLOSE, pack: true, show: true, layout: lm[(chosenLayout as Integer) - 1]) {
        button(text: buttonNames[0], constraints: BorderLayout.CENTER)
        button(text: buttonNames[1], constraints: BorderLayout.EAST)
        button(text: buttonNames[2], constraints: BorderLayout.WEST)
        button(text: buttonNames[3], constraints: BorderLayout.NORTH)
        button(text: buttonNames[4], constraints: BorderLayout.SOUTH)
    }
}
