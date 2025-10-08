package practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main()=runBlocking<Unit>{
    val time = measureTimeMillis {
        simple25()
            .collectLatest { value -> // cancel & restart on the latest value
                println("Collecting $value")
                delay(300)
                println("Done $value")
            }
    }
    println("Collected in $time ms")
}


//similar to conflation