package practice

fun printAll(strings: Collection<String>){
    for(s in strings) print("$s ")
    println()
}

fun main(){
    val stringList = listOf("one", "two", "three")
    printAll(stringList)

    val stringSet = setOf("one", "two", "three")
    printAll(stringSet)


    val words = "A long time ago in a galaxy far far away".split(" ")
    val shortWords = mutableListOf<String>()
    words.getShortWordsTo(shortWords, 3)
    println(shortWords)
}

fun List<String>.getShortWordsTo(shortWords: MutableList<String>, maxLength: Int){
    this.filterTo(shortWords){it.length <= maxLength}
    val articles = setOf("a", "A", "an", "An", "the", "The")
    shortWords -= articles
}
