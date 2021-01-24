import javax.swing.JOptionPane as OP

static List getData(Class aClass = String, Closure... c)
{
    def input = OP.showInputDialog("Wprowadź dane").tokenize()
    List output = []

    input.each {
        try{
            it = it.asType(aClass)
            if(c.length==0)
                output<<it
            if(c.length==1)
                output<<c[0](it)
        }
        catch (Exception ignored){}

    }
    output
}

println getData(Integer) { it > 0 }
println getData() { it.size() > 3 }
println getData()
println getData(BigDecimal)