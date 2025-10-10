package practice

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>{
    val nos39 = produceNos()
    val sqrs39 = square(nos39)
    repeat(5){
        println(sqrs39.receive())
    }
    println("Done!")
    coroutineContext.cancelChildren()
}

fun CoroutineScope.produceNos() = produce<Int>{
    var x = 1
    while (true) send(x++)
}

fun CoroutineScope.square(numbers: ReceiveChannel<Int>): ReceiveChannel<Int> = produce {
    for (x in numbers) send(x * x)
}