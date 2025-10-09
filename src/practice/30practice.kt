package practice

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking<Unit>{
    val startTime30 = System.currentTimeMillis()
    (1..3).asFlow().onEach{delay(100)}
        .flatMapConcat{requestFlow(it)}
        .collect { val30 ->
            println("$val30 at ${System.currentTimeMillis()-startTime30} ms from start")
        }
}

fun requestFlow(i: Int): Flow<String> = flow {
    emit("$i: First")
    delay(500)
    emit("$i: Second")
}


/*
Processes each inner flow one after the other,
in order. Waits for one to finish before starting the next.
 */