package practice


fun main(){
    val nos=listOf("one", "two", "three")
    println("Number of elements are ${nos.size}")
    println("Third element is ${nos.get(2)}")
    println("Index of element \"two\" is ${nos.indexOf("two")}")

    val bob = Person("Bob", 31)
    val people = listOf(Person("Adam", 20), bob, bob)
    val people2 = listOf(Person("Adam", 20), Person("Bob", 31), bob)
    println(people == people2) //true
    bob.age = 32
    println(people == people2) //false



    val numbers = setOf(1, 2, 3, 4)
    println("Number of elements: ${numbers.size}")
    if (numbers.contains(1)) println("1 is in the set")
    val numbersBackwards = setOf(4, 3, 2, 1)
    println("The sets are equal: ${numbers == numbersBackwards}")

    println(numbers.last())
    println(numbers.first())


    //Map
    val map1 = mapOf("key 1" to 1, "key 2" to 2, "key 3" to 3)
    println("All keys: ${map1.keys}")
    println("All values: ${map1.values}")
    println(map1["key 2"])
    println(1 in map1.values)
    println(map1.containsValue(1))

}

data class Person(var name: String, var age: Int)