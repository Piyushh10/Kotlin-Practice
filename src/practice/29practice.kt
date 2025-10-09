package practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>{
    val nums29 = (1..3).asFlow().onEach{ delay(300) }
    val strs29 = flowOf("one", "two", "three").onEach{ delay(400) }
    val startTime29 = System.currentTimeMillis()
    nums29.combine(strs29){a,b-> "$a -> $b"}
        .collect { val29 ->
            println("$val29 at ${System.currentTimeMillis()-startTime29} ms from start")
        }
}