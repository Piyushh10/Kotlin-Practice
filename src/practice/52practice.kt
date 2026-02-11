package practice

fun main(){
//    while(true){
////        val intInput = readln().toIntOrNull()
////        println(intInput)
//    }
    val division = try{
        divide(5.0, 0.0)
    }catch (e: DivByZeroException){
        0.0
    }
    println(division)
}

class DivByZeroException : Exception ("You can't divide by zero")
fun divide(a : Double, b : Double) : Double{
    if(b==0.0){
        throw DivByZeroException()
    }
    return a/b
}