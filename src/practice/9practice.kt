package practice

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()= runBlocking{
    val startTime = System.currentTimeMillis()
    println(startTime)
    val job = launch(Dispatchers.Default){
        var nextPrimeTIme = startTime
        var i = 0
        while (isActive){
            if(System.currentTimeMillis() >= nextPrimeTIme){
                println("job: I am sleeping ${i++}...")
                nextPrimeTIme += 500L
            }
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")
}