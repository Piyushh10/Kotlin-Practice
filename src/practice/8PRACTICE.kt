package practice

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{
    val deferred : List<Deferred<Int>> = (1..3).map{
        async {
            delay(1000L * it)
            println("Loading $it")
            it
        }
    }
    val sum = deferred.awaitAll().sum()
    println("$sum")
}