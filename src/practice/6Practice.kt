package practice

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

suspend fun printPeriods() = coroutineScope {
    repeat(50_000){
        this.launch {
            delay(5.seconds)
            print(".")
        }
    }
}