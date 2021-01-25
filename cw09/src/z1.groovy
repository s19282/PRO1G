import groovy.swing.SwingBuilder

import javax.swing.JColorChooser
import javax.swing.JFrame
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.font.TextAttribute

new SwingBuilder().edt {
    frame(title: 'Prosty edytor', preferredSize: new Dimension(640,480), defaultCloseOperation: JFrame.EXIT_ON_CLOSE,pack: true, show:  true) {
        def ta = textArea(constraints: BorderLayout.CENTER)
        menuBar()
        {
            menu("Rozmiar czcionki")
            {
                for (def i=8; i<=40; i+=2)
                {
                    def fontSize = menuItem(text: i.toString())
                    fontSize.addActionListener( e ->
                        ta.setFont(ta.getFont().deriveFont(fontSize.text as Float)))
                }
            }
            menu("Rodzaj pisma")
            {
                Map<TextAttribute, Integer> underline = new HashMap<TextAttribute, Integer>();
                underline.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);

                Map<TextAttribute, Integer> revertUnderline = new HashMap<TextAttribute, Integer>();
                revertUnderline.put(TextAttribute.UNDERLINE, -1);

                def c = menuItem(text: "Zwykłe")
                c.addActionListener(e->
                    ta.setFont(ta.getFont().deriveFont(Font.PLAIN).deriveFont(revertUnderline)))
                def b = menuItem(text: "Pogrubione")
                b.addActionListener(e->
                    ta.setFont(ta.getFont().deriveFont(Font.BOLD)))
                def u = menuItem(text: "Podkreślone")
                u.addActionListener(e->
                        ta.setFont(ta.getFont().deriveFont(underline)))
                def i = menuItem(text: "Kursywa")
                i.addActionListener(e->
                        ta.setFont(ta.getFont().deriveFont(Font.ITALIC)))
            }
            menuItem("Kolor tła", actionPerformed: { e ->
                JColorChooser cc = new JColorChooser()
                Color bgColor = cc.showDialog(null, "Wybierz kolor tła:", null)
                if (bgColor != null)
                    ta.background = bgColor
            })
            menuItem("Kolor czcionki", actionPerformed: { e ->
                JColorChooser cc = new JColorChooser()
                Color fgColor = cc.showDialog(null, "Wybierz kolor pisma:", null)
                if (fgColor != null)
                    ta.foreground = fgColor
            })
        }
    }

}

