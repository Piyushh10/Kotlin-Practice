package practice

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking


fun main()=runBlocking<Unit>{
    val nums27 = (1..3).asFlow()
    val strs27 = flowOf("one", "two", "three")
    nums27.zip(strs27){a,b -> "$a -> $b"}.collect { println(it) }
}


//combine two flows into one using zip operator