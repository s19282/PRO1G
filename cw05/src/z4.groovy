import javax.swing.JOptionPane as OP

def map = [:].withDefault {0}
def input

while (input = OP.showInputDialog('pozycja=koszt'))
{
    input = input.tokenize("=")
    try
    {
        if(input.size()!=2) throw new Exception('Incorrect format exception')
        map.(input.first()) += input.last().toBigDecimal()
    }
    catch (Exception ignored){}
}
println(map)