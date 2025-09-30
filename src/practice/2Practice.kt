package practice

fun main(){
    val bool1 : Boolean = true
    val nullBool : Boolean? = null

    val char1 = '1'
    val string1 = "One"
//    println('\uFF00')
//
//    for(s in string1){
//        println(s)
//    }
//
//    println("Hello\nPiyush")

    val text = """
        ()for(c in "foo")
            ()print(c)
    """.trimMargin("()")
    println(text)

    println(text.length)
}
