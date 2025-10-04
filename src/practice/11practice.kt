package practice

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

fun main() = runBlocking{
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY){ doSomethingOne()}
        val two = async(start = CoroutineStart.LAZY){ doSomethingTwo()}
        one.start()
        two.start()
        println("The answer is ${one.await()+two.await()}")
    }
    println("Completed in $time ms")
}

suspend fun doSomethingOne(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingTwo(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}