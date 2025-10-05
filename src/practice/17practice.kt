package practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun simple_1(): Flow<Int> = flow{
    println("Flow started")
    for(i in 1..3){
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit>{
    println("Calling simple_1 function")
    val flow1 = simple_1()
    println("Calling collect")
    flow1.collect { val1 -> println(val1) }
    println("Calling collect again")
    flow1.collect { val2 -> println(val2) }
}


/*
Flow is cold : means that the code inside the flow builder does not run
until the flow is collected.

Flow started line will only print when collect is called, not when object
is created.
 */