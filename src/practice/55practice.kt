package practice

import java.io.File
import java.time.ZonedDateTime

fun main(){
    val file = File("session.txt")
    val s1 = SessionStorage(file)
    val s2 = SessionStorage(file)
    println(s1==s2) //prints false because they are different objects in memory

    val p1 = Person1("Piyush", "Dec", "p@gmail.com")
    val p2 = Person1("Piyush", "Dec", "p@gmail.com")
    println(p1==p2) //prints true because they contain same data
    val p3 = p1.copy()
    val p4=p2.copy(email = "shivnanip815@gmail.com")

    println(DateUtil.format(ZonedDateTime.now()))

    val response = HttpStatus.NOT_FOUND
    println(response.toResponseString())

    HttpStatus.entries.forEach{
        println(it.name)
    }
}

class SessionStorage(
    private val file: File
){
    var counter = 0
    fun save(value: String){

    }
}

data class Person1(
    val name : String,
    val birthDate : String,
    val email : String
)


/*
data classes should not interact with files, databases or network,
they should only hold data and provide useful methods for working with
that data.

and unlike normal classes, data classes return true if 2 instances contain
same data, but normal classes return false if 2 instances are different
objects in memory, even if they contain same data.
 */

object DateUtil{
    fun format(dateTime : ZonedDateTime) : String{
        return "..."
    }
}

data object DateUtil2{
    fun format(dateTime : ZonedDateTime) : String{
        return "..."
    }
}

//same diff as a normal class and a data class, but it is a singleton,
//so it can only have one instance in the entire program


enum class Colors{
    RED, GREEN, BLUE
}

//you can also give properties and methods to enum classes, but they dont
// have special functions like a data class, so they are not used to hold
// data, but to represent a fixed set of constants

enum class HttpStatus(val code : Int, val message : String){
    OK(200, "OK"),
    BAD_REQUEST(400, "Bad Request"),
    NOT_FOUND(404, "Not Found");

    fun toResponseString() : String{
        return "Error: $code, Message: $message"
    }
}


sealed class NetworkResult{
    data class Success(val data : String) : NetworkResult()
    data class Error(val errorMessage : String) : NetworkResult()
    data object Loading : NetworkResult()
}

/*
sealed classes can have a constructor, but if it doesnt require one,
then we can use sealed interface instead.
 */

sealed interface NetworkResult2{
    data class Success(val data : String) : NetworkResult()
    data class Error(val errorMessage : String) : NetworkResult()
    data object Loading : NetworkResult()
}

abstract class Sensor{
    abstract val name : String
    abstract fun startListening(onNewValue : (Float) -> Unit)
}
//you already know about abstract classes, same as Java

@JvmInline
value class Email(val email : String){
    init{
        if(!email.contains("@")){
            throw IllegalArgumentException("Invalid email address")
        }
    }
}
//it will be treated as a String at runtime, but it provides type
// safety at compile time, so you cant accidentally pass a normal
// string where an Email is expected, and it also allows you to add
// validation logic in the init block to ensure that only valid email
// addresses are created.
// So it provides the benefits of a normal class, but without the
// overhead of creating an object in memory, since it will be treated
// as a String at runtime.


@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.CONSTRUCTOR
)
annotation class DeprecatedClass

//eg
@DeprecatedClass
class xyz @DeprecatedClass constructor(){}

//inner class is class inside a class, where you can access everything
// of the parent class, which will not work if "inner" keyword is not
// used.