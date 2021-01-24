import groovy.json.JsonSlurper


def text = "Test 99 PLN TEST 7.54 PLN TESTSETEST"
def url = new URL('https://api.nbp.pl/api/exchangerates/rates/a/eur/?format=json')
def rate = new JsonSlurper().parse(url)

def matcher_ = text=~ "(-?\\d+(.\\d+)?)"
matcher_.each {println(it[0].toString()+"\n---------")}

def matcher = text=~ "(\\d+(.\\d+)?) PLN"
matcher.each {
    text=text.replace(it[0].toString(),((it[1] as BigDecimal)/rate.rates[0].mid).round(2)+" "+rate.code)
}

println text