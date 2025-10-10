package practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>{
    events().onEach{event -> println("Event: $event")}
        .collect()
    println("Done!")
}

fun events() : Flow<Int> = (1..3).asFlow().onEach { delay(100) }

/*
the launchIn terminal operator comes in handy here. By replacing collect
with launchIn(this), we can launch a collection of the flow in a
separate coroutine, so that execution of further code immediately continues

The required parameter to launchIn must specify a CoroutineScope in
which the coroutine to collect the flow is launched.

Then the OP will be-
Done
Event: 1
Event: 2
Event: 3
 */