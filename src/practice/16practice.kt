package practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun simple(): Flow<Int> = flow{
    for(i in 1..3){
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit>{
    launch{
        for(k in 1..3){
            println("I am not blocked $k")
            delay(100)
        }
    }
    simple().collect { value -> println(value) }
}


/*
flow uses emit and collect
 */
