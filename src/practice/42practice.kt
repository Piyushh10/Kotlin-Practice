package practice

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

@OptIn(DelicateCoroutinesApi::class, ExperimentalCoroutinesApi::class)
val counterContext = newSingleThreadContext("CounterContext")
var counter42 = 0

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking{
    withContext(Dispatchers.Default){
        massiveRun {
            withContext(counterContext){
                counter42++
            }
        }
    }
    println("Counter: $counter42")
}

//it performs all operations in a single thread, so the value doesn't
// get lost.

/*
This code works very slowly, because it does fine-grained
thread-confinement. Each individual increment switches from multi-threaded
Dispatchers.Default context to the single-threaded context using
withContext(counterContext) block.
 */

//THIS IS KNOWN AS THREAD CONFINEMENT FINE GRAINED
