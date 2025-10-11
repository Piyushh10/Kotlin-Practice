package practice

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

suspend fun massiveRun(action: suspend() -> Unit){
    val n=100
    val k=1000
    val time= measureTimeMillis {
        coroutineScope{
            repeat(n){
                launch{
                    repeat(k){action()}
                }
            }
        }
    }
    println("Completed ${n*k} actions in $time ms")
}

//@Volatile
//var counter = 0
val counter = AtomicInteger()

fun main() = runBlocking{
    withContext(Dispatchers.Default){
        massiveRun {
            counter.incrementAndGet()
        }
    }
    println("Counter: $counter")
}

//its not returning 100000 in the counter even after volatile annotation
//but works with AtomicInteger because it is thread safe
//there is one more way to do it, its in the next file