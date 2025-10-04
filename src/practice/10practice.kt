package practice

import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

//fun main()=runBlocking{
//    val job = launch{
//        try{
//            repeat(1000){i->
//                println("job: I am sleeping ${i}...")
//                delay(500L)
//            }
//        }finally {
//            println("job: I am running finally")
//        }
//    }
//    delay(1300L)
//    println("main: I am tired of waiting!")
//    job.cancelAndJoin()
//    println("main: Now I can quit.")
//}

fun main()=runBlocking{
    val job = launch{
        try{
            repeat(1000){i->
                println("job: I am sleeping ${i}...")
                delay(500L)
            }
        }finally {
            withContext(NonCancellable){
                println("job: I am running finally")
                delay(1000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }
    delay(1300L)
    println("main: I am tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")
}
