package practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun simple24(): Flow<Int> = flow{
    for(i in 1..3){
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit>{
    val time = measureTimeMillis {
        simple24().buffer().collect { val24 ->
            delay(300)
            println(val24)
        }
    }
    println(time)
}