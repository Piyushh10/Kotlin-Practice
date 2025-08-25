package Coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun fetchUserData(): String{
    delay(2000)
    return "Piyush Shivnani"
}

//fun main(){
//    println("Code start: ${Thread.currentThread().name}")
//
//    GlobalScope.launch {
//        val res = fetchUserData()
//        println("User data: $res on ${Thread.currentThread().name}")
//    }
//    println("this UI code is running: ${Thread.currentThread().name}")
//
//    Thread.sleep(3000)
//}

/*
launch does not return a value
async return a value(deferred object).
deferred holds a result that will be available later
you must call .await() to retrieve the result.
 */

