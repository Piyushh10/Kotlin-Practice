package practice

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>{
    launch{
        println("main runBlocking : ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined){
        println("Unconfined : ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default){
        println("Default : ${Thread.currentThread().name}")
    }
    launch(newSingleThreadContext("MyOwnThread")){
        println("my own thread : ${Thread.currentThread().name}")
    }
}