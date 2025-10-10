package practice

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>{
    val channel30 = Channel<Int>()
    launch{
        for (x in 1..5) channel30.send(x*x)
        channel30.close() //done sending
    }
    for (y in channel30) println(y)
    println("Done!")
}