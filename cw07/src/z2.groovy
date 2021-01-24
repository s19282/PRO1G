import groovy.json.JsonSlurper

def url = new URL('https://api.nbp.pl/api/exchangerates/rates/a/eur/?format=json')
def rate = new JsonSlurper().parse(url)

def menuPL = new File('../files/MenuPl.txt')
def menuEUR = new File('../files/MenuEUR.txt')
menuEUR.delete()

menuPL.each {
    it = it.tokenize(' ')
    menuEUR.append(it.first())
    menuEUR.append(' ')
    menuEUR.append(((it.last() as BigDecimal)/rate.rates[0].mid).round(2))
    menuEUR.append('\n')
}

println("Done!")