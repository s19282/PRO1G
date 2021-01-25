import groovy.swing.SwingBuilder

import javax.swing.JFrame
import java.awt.BorderLayout
import java.awt.Dimension

new SwingBuilder().edt {
    frame(title: 'Prosty edytor', preferredSize: new Dimension(640,480), defaultCloseOperation: JFrame.EXIT_ON_CLOSE,pack: true, show:  true) {
        def ta = textArea(constraints: BorderLayout.CENTER)

    }

}

