
def projects = new File('../files/Projekty.txt')
def bigProjects = new File('../files/ProjektyDuze.txt')
def programmers = new File('../files/Programisci.txt')
programmers.delete()
bigProjects.delete()
def employees = [:].withDefault {[]}

projects.each {
    if(it.tokenize('\t').size()>4)
    {
        bigProjects.append(it)
        bigProjects.append('\n')
    }

    it = it.tokenize('\t')
    for(def i = 1; i<it.size(); i++)
        employees.(it[i]) += it[0]
}

employees.each {
    programmers.append(it.key)
    programmers.append('\t')
    programmers.append(it.value.join('\t'))
    programmers.append('\n')
}
println("Done!")