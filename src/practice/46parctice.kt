package practice

import java.util.LinkedList

fun main() {
    val deque = ArrayDeque(listOf(1, 2, 3))

    deque.addFirst(0)
    deque.addLast(4)
    println(deque) // [0, 1, 2, 3, 4]

    println(deque.first()) // 0
    println(deque.last()) // 4

    deque.removeFirst()
    deque.removeLast()
    println(deque) // [1, 2, 3]



    //3 ways to create a map, first one being more effective. Second one creates objects of Pair class
    val numbersMap1 = mutableMapOf<String, String>().apply { this["one"] = "1"; this["two"] = "2" }
    val numbersMap2 = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)
    val map46 = buildMap{
        put("a", 1)
        put("b", 2)
    }

    //empty collection
    val empty = emptyList<String>()

    val doubled = List(3, {it*2})
    println(doubled)
    val linkedList = LinkedList<Int>(listOf(1,2,3))
    val presizedSet = HashSet<Int>(32)

}