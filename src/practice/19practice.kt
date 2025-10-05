package practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

/*
The flow { ... } builder from the previous examples is the
most basic one. There are other builders that allow flows to be declared:

The flowOf builder defines a flow that emits a fixed set of values.

Various collections and sequences can be converted to
flows using the .asFlow() extension function.
*/

fun main()=runBlocking<Unit>{
//    (1..3).asFlow().collect { val3 -> println(val3) }
    (1..3).asFlow()
        .map { request -> performReq(request) }
        .collect{res -> println(res)}

    //transform operator
    (1..4).asFlow()
        .transform { req1 ->
            emit("Making request $req1")
            emit(performReq(req1))
        }
        .collect { resp -> println(resp) }

}

suspend fun performReq(req: Int): String{
    delay(1000)
    return "response $req"
}


//usage of map and collect