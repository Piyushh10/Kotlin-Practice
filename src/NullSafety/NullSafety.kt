package NullSafety

fun main(){
    //null safety handling
    //1. (?.) is called safe call operator
    var name : String? = null
    println(name?.length)
    name = "Piyush"
    println(name.length)

    //2. Elvis operator (?:)
    var funny: String? = null
    val length = funny?.length ?: 1
    println(length)

    //3. Not Null Operator (!!) -> makes nullable variable to be not nullable
    val naam : String? = null
//    println(naam!!.length) // will give nullpointerexception

    //4. Safe Cast Operator (as?) -> used to safely cast a variable to a target type
    val obj : Any = 42
    val str: String? = obj as? String // safe, returns null if casting fails
    println(str)

    //let - it is a function which is used to execute a block of code only
    //if the variable is non null. It is often used with nullable types to
    //avoid null pointer exceptions.

    var naam_ek : String? = "readln()"
    naam_ek?.let{
        println("Name is $it")
    }
    naam_ek = null
    naam_ek?.let{
        println("Name is $it")
    }
}