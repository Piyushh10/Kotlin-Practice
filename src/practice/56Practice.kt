package practice

/*
Scope functions-
Let
Also
Apply
Run
With
 */

fun main(){
   val x1 = number?.let{
        val no2 = it+1
        no2
   } ?: 0
    // let is used to execute a block of code on an object and return
// the result of the block. It is often used for null safety checks and
// transformations.
    //also is same as let, but it returns the original object instead of
// the result of the block. It is often used for performing additional
// operations on an object.

    fun getSquared() = (i*i).also{i++}

    // apply is used to configure an object and return the object itself.
// It is often used for initializing objects or performing multiple
// operations on an object in a concise way.

    /*
    let, also -> provide it
apply, run, with -> provide this
Return values: let / run / with return the lambda result;
apply / also return the original receiver.
     */

    val list = mutableListOf(1, 2).apply {
        add(3)
        remove(1)
    }
    println(list)

    //run is same as apply, but it returns the result instead of the
    //original object.

    val a1 : Int = 1.run{
        this+99
    }
    println(a1)

    val a2 : Int = with(1){
        this+99
    }
    val a3 : Int = run{
        val a = 1
        a+99
    }

    //with is same as run, but it is called with the object as an
// argument instead of being called on the object.

}
private val number : Int? = null
private var i = 0