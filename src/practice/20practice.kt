package practice

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

fun numbers(): Flow<Int> = flow{
    try{
        emit(1)
        emit(2)
        println("This line will not execute")
        emit(3)
    } finally{
        println("Finally in numbers")
    }
}

fun main() = runBlocking<Unit>{
    numbers()
        .take(2)
        .collect { val3 -> println(val3) }
}

//this will only take 2 emitted values and then cancel the flow
//so finally block will execute
