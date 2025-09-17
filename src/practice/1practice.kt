package practice

fun sum(a : Int, b : Int): Int{
    return a+b
}

fun sum2(a : Int, b: Int): Int = a+b //mentioning return type is optional

fun printSum(a: Int, b: Int){
    println("${a+b}")
} // Unit return type

fun sumOfAll(vararg num : Int): Int{
//    var ans = 0
//    for(n in num){
//        ans += n
//    }
//    return ans
    return num.sum()
}

/*
Infix funs: Functions marked with the infix keyword. They must be member
functions or extension functions. They must have a single parameter.
The parameter must not accept varargs and must have no default value.
 */

infix fun Int.divByNum(x: Int): Boolean{
    if(this % x==0) return true
    return false
}



//member func is a func that is defined inside a class or object
class Sample{
    fun foo(){println("Foo")}
}
//member func are called with . notation. See main() for example, for eg



//generic functions can work with any datatype
fun <T> printThat(item : T){
    println(item)
}

fun maxOf(a: Int, b: Int) = if(a > b) a else b

fun getStringLength(obj : Any): Int?{
    if(obj is String)
        return obj.length
    return null
}




fun main(){
    println(sum(60,9))
    println(sum2(60,9))
    printSum(60, 9)
    println(sumOfAll(59,1,4,2,2,1))

    val a1 : Int = 16
    val a2 : Int = 17
    println(a1.divByNum(4))
    println(a2.divByNum(2))
    println(10 divByNum 2)

    Sample().foo()

    printThat(1)
    printThat("Ek")
    printThat(1.0)
    printThat('1')

}




