package Loops

fun main(){
    //for loop
    println("using ..")
    for(j in 1..5){
        println(j)
    }
    println("using step")
    for(i in 1..10 step 2){
        println(i)
    }
    println("backwards using downTo")
    for (k in 10 downTo 1){
        println(k)
    }
    println("using until")
    for (l in 1 until 5){
        println(l)
    }
    println("using for each")
    val nums1 = listOf(1, 2, 3, 4)
    nums1.forEach { println(it) }

    println("using for each with index")
    val nums2 = listOf(10, 20, 30)
    nums2.forEachIndexed { index, value ->
        println("Index $index has $value")
    }

    println("using for in list")
    val fruits1 = listOf("Apple", "Banana", "Mango")
    for (fruit in fruits1) {
        println(fruit)
    }

    println("using for in list with index")
    val fruits2 = listOf("Apple", "Banana", "Mango")
    for ((index, fruit) in fruits2.withIndex()) {
        println("$index -> $fruit")
    }

    println("using for in a map")
    val map = mapOf(1 to "One", 2 to "Two", 3 to "Three")
    for ((key, value) in map) {
        println("$key = $value")
    }
}

