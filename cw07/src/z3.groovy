def dir = new File(System.getProperty("user.home") + "/Desktop")

int counter = 1
dir.traverse(filter: {it.name.endsWith(".html")}) {
    println counter+" "+it
    counter++
}