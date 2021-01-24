static String reverseChars_v1(String s)
{
    s.reverse()
}

static String reverseChars_v2(String s)
{
    s[-1..0]
}

println reverseChars_v1("piesek")
println reverseChars_v2("piesek")

