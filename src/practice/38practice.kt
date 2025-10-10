package practice

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>{
    val sqrs = produceSquares()
    sqrs.consumeEach{println(it)}
    println("Done!")
}

fun CoroutineScope.produceSquares() : ReceiveChannel<Int> = produce{
    for (x in 1..5) send(x*x)
}
