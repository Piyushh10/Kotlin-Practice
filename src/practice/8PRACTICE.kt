package practice

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{
//    val deferred : List<Deferred<Int>> = (1..3).map{
//        async {
//            delay(1000L * it)
//            println("Loading $it")
//            it
//        }
//    }
//    val sum = deferred.awaitAll().sum()
//    println("$sum")

    val job = launch{
        repeat(1000){i->
            println("job: I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L)
    println("main: I', tired of waiting!")
    job.cancel()
    job.join()
    println("main: Now I can quit.")

}