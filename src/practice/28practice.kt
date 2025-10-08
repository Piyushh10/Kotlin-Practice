package practice

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

fun main()=runBlocking<Unit>{
    val nums28 = (1..3).asFlow()
    val strs28 = flowOf("one", "two", "three")
    nums28.zip(strs28){a,b -> "$a -> $b"}.collect { println(it) }
}