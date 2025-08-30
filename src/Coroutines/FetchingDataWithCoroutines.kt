package Coroutines

import kotlinx.coroutines.*

suspend fun fetchUserData(): String{
    delay(2000)
    return "Piyush Shivnani"
}

//fun main(){
//    println("Code start: ${Thread.currentThread().name}")
//
//    GlobalScope.launch {
//        val res = fetchUserData()
//        println("User data: $res on ${Thread.currentThread().name}")
//    }
//    println("this UI code is running: ${Thread.currentThread().name}")
//
//    Thread.sleep(3000)
//}

/*
launch does not return a value
async return a value(deferred object).
deferred holds a result that will be available later
you must call .await() to retrieve the result.
 */
fun main()= runBlocking {
//    val launchJob = launch{
//        println("Launch: Start")
//        delay(1000)
//        println("Launch: End")
//    }
//    val asyncJob = async {
//        println("Async: Start")
//        delay(1000)
//        "Async: End"
//    }
//    launchJob.join()
//    println(asyncJob.await())
}

/*
5 main scopes of coroutines-

GlobalScope: independent of lifecycle. they keep running until they complete or application shuts down
it can lead to memory leaks if not managed properly

CoroutineScope: Used to create custom scope that can be controlled explicitly by canceling it.
it is used when you need manual control over coroutine cancellation

 */

//val scope = CoroutineScope(Dispatchers.IO)
//scope.launch{
//    delay(1000)
//    println("Running in CoroutineScope")
//}
//scope.cancel()

/*
LifecycleScope: scope for android activities and fragments.
it is used to launch coroutines that should be cancelled when the lifecycle ends (automatically)

ViewModelScope: used to run coroutines tied to a viewmodel's lifecycle
coroutines are automatically cancelled when the viewmodel is cleared

 */

//class myViewModel : ViewModel(){
//    init{
//        viewModelScope.launch{
//            delay(1000)
//            println("Running in ViewModelScope")
//        }
//    }
//}

/*
supervisorScope: a special scope where child coroutines fails/runs independently(one coroutine fail does not affect others)
 */


/*
Dispatchers tell coroutine which thread it has to run on

1. Dispatchers.IO -> used for i/o operations like database, api, etc

2. Dispatchers.Default -> optimized for cpu intensive tasks, heavy calculations, etc

3. Dispatchers.Main -> runs on main thread, used for updating UI

4. Dispatchers.Unconfined -> starts in current thread but way switch

 */

/*
Asynchronous Flow are a way to handle streams of data asynchronously using Kotlin Flow from courotines
they are useful for handling real time or continuous data streams
such as fetching api updates, observing database changes, processing user inputs.

callBackFlow is used to convert callback based api into a cold flow that emits values asynchronously.
eg firebase, location update, etc


 */