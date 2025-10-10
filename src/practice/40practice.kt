package practice

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun CoroutineScope.numbersFrom(start: Int) = produce<Int>{
    var x = start
    while (true) send(x++)
}
fun CoroutineScope.filter(numbers: ReceiveChannel<Int>, prime: Int) = produce<Int> {
    for (x in numbers) if (x % prime != 0) send(x)
}

fun main() = runBlocking{
    var cur = numbersFrom(2)
    repeat(10){
        val prime = cur.receive()
        println(prime)
        cur = filter(cur, prime)
    }
}

/*
Note that you can build the same pipeline using iterator coroutine builder
from the standard library. Replace produce with iterator, send with yield,
receive with next, ReceiveChannel with Iterator, and get rid of the
coroutine scope. You will not need runBlocking either. However, the
benefit of a pipeline that uses channels as shown above is that it can
actually use multiple CPU cores if you run it in Dispatchers.Default
context.


Anyway, this is an extremely impractical way to find prime numbers.
In practice, pipelines do involve some other suspending invocations
(like asynchronous calls to remote services) and these pipelines cannot
be built using sequence/iterator, because they do not allow arbitrary
suspension, unlike produce, which is fully asynchronous.
 */