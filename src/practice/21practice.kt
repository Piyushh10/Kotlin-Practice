package practice

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val sum = (1..5).asFlow()
        .map { it * it }
        .reduce { a,b -> a+b}
    println(sum)
}