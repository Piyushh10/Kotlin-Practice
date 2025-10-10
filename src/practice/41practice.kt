package practice

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
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

@Volatile
var counter = 0

fun main() = runBlocking{
    withContext(Dispatchers.Default){
        massiveRun {
            counter++
        }
    }
    println("Counter: $counter")
}