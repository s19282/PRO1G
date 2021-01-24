import javax.swing.JOptionPane as OP

List getInts()
{
    List input = null

    while (!input)
    {
        inputD = OP.showInputDialog("Wpisz szereg liczb całkowitych")
        try{
            input = inputD.tokenize() as int[]
        }
        catch (NumberFormatException ignored)
        {
            OP.showMessageDialog(null,"Błędne dane wejściowe! Spróbuj ponownie")
        }
    }
    input
}

println getInts()