package practice

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

suspend fun main() = withContext(Dispatchers.Default){
    println("Running withContext block on ${Thread.currentThread().name}")
    val one = this.async {
        println("First calculation starting on ${Thread.currentThread().name}")
        val sum = (1L..50_000L).sum()
        delay(200L)
        println("First calculation done on ${Thread.currentThread().name}")
        sum
    }
    val two = this.async{
        println("Second calculation starting on ${Thread.currentThread().name}")
        val sum = (500_001L..1_000_000L).sum()
        println("Second calculation done on ${Thread.currentThread().name}")
        sum
    }
    val oneRes = one.await()
    val twoRes = two.await()
    println("Combined total: ${oneRes+twoRes}")
}