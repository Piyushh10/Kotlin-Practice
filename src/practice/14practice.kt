package practice

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>{
    launch(Dispatchers.Unconfined){
        println("unconfined before delay : ${Thread.currentThread().name}")
        delay(1300L)
        println("unconfined after delay : ${Thread.currentThread().name}")
    }
    launch {
        println("main runBlocking : ${Thread.currentThread().name}")
        delay(2600L)
        println("main runBlocking after delay : ${Thread.currentThread().name}")
    }
}
