package practice

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking<Unit>{
    val startTime32 = System.currentTimeMillis()
    (1..3).asFlow().onEach{delay(100)}.flatMapLatest { requestFlow(it) }.collect { val32->
        println("$val32 from ${System.currentTimeMillis()-startTime32} ms from the start")
    }
}

/*
In a similar way to the collectLatest operator, that was described in
the section "Processing the latest value", there is the corresponding
"Latest" flattening mode where the collection of the previous flow is
cancelled as soon as new flow is emitted. It is implemented by the
flatMapLatest operator.
 */