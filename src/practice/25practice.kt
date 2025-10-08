package practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main() = runBlocking<Unit>{
    val time = measureTimeMillis {
        simple25()
            .conflate()
            .collect { value ->
                delay(300)
                println(value)
            }
    }
    println("Collected in $time ms")
}

fun simple25(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

/*
Conflation is one way to speed up processing when both the emitter
and collector are slow.


it skips the intermediate values and only collects the lastest ones
so here in this case, it will skip 2 and collect 3 after 1 since
when 1 was being processed, 2 and 3 were emitted already alongside it
so the latest value after 1 was 3, hence 2 got skipped
 */