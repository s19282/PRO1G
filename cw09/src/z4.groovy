import groovy.swing.SwingBuilder
import javax.swing.JFrame
import java.awt.BorderLayout
import javax.swing.JOptionPane

import static javax.swing.JOptionPane.showMessageDialog

def path = null

while (!path)
    path = JOptionPane.showInputDialog(null, 'Podaj ścieżkę:', "../img")


try
{
    def dir
    def photos = []
    def counter = 0

    dir = new File(path)
    dir.traverse(filter: { it.name.endsWith('.jpg') || it.name.endsWith('.png') }) { photos << it }

    new SwingBuilder().edt {
        frame(title: 'Photos', defaultCloseOperation: JFrame.EXIT_ON_CLOSE, pack: true, show: true) {
            def photoLabel = label(icon: imageIcon(photos[counter].toString()))
            button(text:'Następne zdjęcie', constraints: BorderLayout.SOUTH, actionPerformed: { e ->
                if (counter == photos.size())
                    counter = 0
                photoLabel.icon = imageIcon(photos[counter++].toString())
            })
        }
    }
}
catch(FileNotFoundException ignored)
{
    showMessageDialog(null, "Nie prawidłowe dane wejściowe")
}