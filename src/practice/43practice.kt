package practice

import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

val counterContext43 = newSingleThreadContext("CounterContext")
var counter43 = 0

fun main() = runBlocking{
    withContext(counterContext43){
        massiveRun {
            counter43++
        }
    }
    print("Counter: $counter43")
}