package practice

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun simple33(): Flow<Int> = flow{
    for(i in 1..3){
        println("Emitting $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit>{
    try{
        simple33().collect { val33->
            println(val33)
            check(val33<=1){"Collected $val33"}
        }
    }catch (e: Throwable){
        println("Caught $e")
    }
}