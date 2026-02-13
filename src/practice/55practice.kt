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