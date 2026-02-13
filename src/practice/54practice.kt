package practice

fun<T> List<T>.customFilter2(filterFunction: (T)->(Boolean)) : List<T>{
    var list1=mutableListOf<T>()
    for(item in this){
        if(filterFunction(item)){
            list1.add(item)
        }
    }
    return list1
}

fun main(){
//    var strings = listOf<String>("a", "b", "c", "d", "e")
//    strings=strings.customFilter2 { it> "c" }
//    var integers = listOf<Int>(1,2,3,4,5,6)
//    integers=integers.customFilter2 { it > 3 }
//    println(strings)
//    println(integers)
    var customTriple = CustomTriple<Int, Boolean, String>(1, true, "Hello")
}

class CustomTriple<A : Any, B : Any, C: Any>(
    val first: A,
    val second: B,
    val third: C
){
    init{
        println("Type of first: ${first::class}")
        println("Type of second: ${second::class}")
        println("Type of third: ${third::class}")
    }
}