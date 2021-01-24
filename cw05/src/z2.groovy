static String reverseWords(String s)
{
    s.tokenize().reverse().join(' ')
}

println reverseWords("ala ma kota")

