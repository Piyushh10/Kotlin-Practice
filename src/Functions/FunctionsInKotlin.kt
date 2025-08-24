package Functions

fun main(){
    greet()
    greet("Piyush")
    println(greetUsingReturn("Piyush"))
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
