import javax.swing.JOptionPane as JOP

input = JOP.showInputDialog('Oddziel elementy spacjami').tokenize(' ')*.toInteger().sort()
println input

def lessThan0 = input.findAll{it<0}
println lessThan0