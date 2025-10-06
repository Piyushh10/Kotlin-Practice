package practice


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking
import java.rmi.server.LogStream.log
import kotlin.math.log

fun main() = runBlocking<Unit>{
    simpler().collect {
        value10 -> println(value10)
        log("Collected $value10")
    }
}

fun simpler(): Flow<Int> = flow{
    for(i in 1..3){
        Thread.sleep(100)
        log("Emitting $i")
        emit(i)
    }
}.flowOn(Dispatchers.Default)