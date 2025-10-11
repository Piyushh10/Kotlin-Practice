package Functions

fun main(){
    greet()
    greet("Piyush")
    println(greetUsingReturn("Piyush"))
    printData(10)
    printData("Kya kaam hai?")
    printData(1.69)
    println(greetPaaji("Piyushinder", 20))
    println(greetKar("Piyush Shivnani"){name-> "Hello ajeeb function waale $name"})

    val a = Person("abcd", 31)
    a.introduce()

    val animalObj = Animal()
    animalObj.sound()
    val dogObj = Dog()
    dogObj.sound()

}

fun greet(){
    println("Hello user!")
}
fun greet(name: String){
    println("Hello $name!")
}
fun greetUsingReturn(name: String): String{
    return "Hello $name! (using return)"
}
fun greetUsingUnit():Unit{
    println("Hello user! I'm using Unit return")
}
//unit is equivalent to void, but is actually a type unlike void which
// is a keyword


//single expression function
fun square(n: Int) = n*n
fun greeting() = println("Hello, greetings to you!")

//generic function - it is a function that can work with any type of data
fun <T> printData(data: T){
    println("Data: $data")
}


//lambda function- a function without a name that can be assigned to a variable
val greetPaaji : (String, Int) -> String = {name, age->
    "Hello $name paaji, tussi $age saal ke hunde si?"
}


//higher order function- a function that takes another function as a
//parameter or returns one
fun greetKar(name: String, anotherFunc: (String)->String): String{
    return anotherFunc(name)
}

//member function- a function inside a class
class Person(val name: String, i: Int){
    fun introduce(){
        println("Hello, my name is $name")
    }
    var age = i
}

//overriding function
open class Animal {
    open fun sound() {
        println("Animal makes a sound")
    }
}

class Dog : Animal() {
    override fun sound() {
        println("Dog barks")
    }
}





