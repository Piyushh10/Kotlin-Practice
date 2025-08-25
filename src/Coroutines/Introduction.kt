package Coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
They are lightweight threads that allow you to write asynchronous,
non-blocking code in a more readable and structured way.
Unlike traditional threads, coroutines do not create new system threads, instead
they run within a single thread and can be suspended and resumed efficiently

They work on top of threads
Used for asynchronous programming and non-blocking code

Coroutines avoid creating multiple threads, reducing memory and CPU usage
make it easier to manage bg tasks without callback hell


 */

//fun main()= runBlocking{
//    launch{
//         delay(1000L)
//        println("World")
//    }
//    println("Hello")
//}

suspend fun network(){
    delay(1000L)
    println("World")
}
fun main()= runBlocking{
    launch{
        network()
    }
    println("Hello")
}