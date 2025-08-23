package KotlinBasics

import java.util.*
import kotlin.reflect.typeOf

fun main(){
    val byteVal : Byte = 127
    val shortVal : Short = 32000
    val intVal : Int = 100000
    val longVal : Long = 10000000000L
    println("1. Numeric data types -> Byte: $byteVal, Short: $shortVal, Int: $intVal, Long: $longVal")

    val floatVal : Float = 3.14f
    val doubleVal : Double = 2.71828

    println("Float: $floatVal, Double: $doubleVal")

    val charVal : Char = 'a'
    val stringVal : String = "A for apple"

    println("2. Character & String data types -> Char: $charVal, String: $stringVal")

    val booleanVal : Boolean = true

    val nums : Array<Int> = arrayOf(1,2,3,4)
    val mixedArray = arrayOf("Hello", 6, 9, 'P', 3.14)

    println("First number: ${nums[0]}, Mixed Array: ${mixedArray.joinToString()}")

    /*
    there are nullable data types in kotlin
    that can store null inside them, use '?' to add nullability
     */
    var name : String? = null
    println("Value of name variable is: $name")
    name = "hello"


    // Standard input in Kotlin
//    var name1 = readln()
//    println(name1)
//
//    val sc = Scanner(System.`in`)
//    val a = sc.nextInt()
//    val b = sc.nextLine()

    /*

    Collections are used to store groups of data
    There are 2 types of collections:
    1. Immutable collections-
    List<T> : ordered collection with duplicates allowed
    Set<T> : unordered collection with unique elements
    Map<K, V> : key value pairs with unique keys only

    2. Mutable collections-
    MutableList<T>
    MutableSet<T>
    MutableMap<K, V>
    They all have modification functions (All means mutable only)

     */

    val fruits = mutableListOf("Apple", "Banana", "Cherry", "Apple", "Orange")
    println(fruits)
    println(fruits.size)
    println(fruits[0])

    val map = mutableMapOf("One" to 1, "Two" to 2, "Three" to 3)
    println(map)
    println(map["One"])
    println(map.get("One"))
    map.remove("Two")
    println(map)




}

