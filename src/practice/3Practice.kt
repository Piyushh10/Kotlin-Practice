package practice
import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

//1
suspend fun greet(){
    println("The greet() on the thread: ${Thread.currentThread().name}")
    delay(2.seconds)
}

suspend fun showUserInfo(){
    greet()
    println("User: Piyush")
}

//2
suspend fun main(){
    withContext(Dispatchers.Default){
        //3
        this.launch { greet() }
        this.launch {
            println("The CoroutineScope.launch() on the thread: ${Thread.currentThread().name}")
            delay(2.seconds)
        }
        println("The withContext() on the thread: ${Thread.currentThread().name}")
    }
}

/*
suspend functions can only be called by another suspend function or
a coroutine


to create a coroutine, you need the following-

a suspend function
a coroutine scope (where it will run)
a coroutine builder (to start a coroutine)
a dispatcher (to control which threads it uses)

 */

/*

coroutine builder functions-

1. CoroutineScope.launch()
2. CoroutineScope.async()
3. runBlocking()
4. withContext()
5. coroutineScope()
 */


suspend fun performBackgroundWork() = coroutineScope {
    this.launch {
        delay(100.milliseconds)
        println("Sending notifs in background")
    }
    println("Scope continues")
}

