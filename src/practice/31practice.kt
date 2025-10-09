package practice

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking<Unit>{
    val startTime31 = System.currentTimeMillis()
    (1..3).asFlow().onEach{delay(100)}
        .flatMapMerge { requestFlow(it) }
        .collect{val31 ->
            println("$val31 at ${System.currentTimeMillis()-startTime31} ms from the start")
        }
}

/*
it concurrently collects all the incoming flows and merge their values
into a single flow sp that values are emitted as soon as possible.
It is implemented by flatMapMerge and flattenMerge operators. They both
accept an optional concurrency parameter that limits the number of concurrent
flows that are collected at the same time ( it is equal to DEFAULT_CONCURRENCY
by default.
 */
