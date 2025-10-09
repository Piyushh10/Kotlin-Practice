package practice

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>{
//    simple33().catch { e-> println("Caught: $e") }
//        .collect { val34->
//            check(val34<=1){"Collected $val34"}
//            println(val34)
//        }
    simple33().onEach{val34->
        check(val34<=1){"Collected $val34"}
        println(val34)
    }.catch { e-> println("Caught $e") }.collect()
}
