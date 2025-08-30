fun main(){
//    val a = readln()
//    println(a)
//    var x: Int = 5
//    val c = 6
//
//    val rect = Rectangle(2.0, 1.0)
//    println("The perimeter is ${rect.perimeter}")
//
//    var a1 = 1
//    val s1 = "a is $a"
//    a1 = 2
//    val s2 = "${s1.replace("is", "was")}, but now it is $a1"
//
//    val fruits = listOf("Apple", "Kela", "Santra")
//    for(ind in fruits.indices){
//        println("item at $ind is ${fruits[ind]}")
//    }
//
//    var i = 0
//    while(i < fruits.size){
//        println(fruits[i])
//        i++
//    }
//
//    val j = readln()
//    when(j){
//        "0" -> println("Zero")
//        "1" -> println("One")
//        else -> println("Please enter either 1 or 0")
//    }
//
//    val x1 = 10
//    val y = 9
//    if (x1 in 1..y+1) {
//        println("fits in range")
//    } //.. is inclusive of both ends
//
//    for(x in 1..5){
//        print(x)
//    }
//    println()
//
//    when{
//        "Santra" in fruits -> println("Raseela")
//        "Apple"  in fruits -> println("Raseela")
//    }
//
//    fruits.filter { it.startsWith("A") }
//        .sortedBy { it }
//        .map { it.uppercase() }
//        .forEach{ println(it) }

//    var Kuch = Customer("Piyush", "piyush@hotmail.com")
//    println(Kuch.toString())
//    println(Kuch.equals(Kuch))
//    var KuchToHuaHai = Kuch.copy()


//    val list = listOf(-10, -11, -12, 10, 11, 12)
//    val positives = list.filter { it > 0 }
//    println(positives)

//    var a = readln().toIntOrNull()
//    println(a)
//    a = readln().toIntOrNull()
//    println(a)
//
//    val a1 = readln().first()
//    println(a1::class.simpleName)

//    for (i in 1..100) { println(i) }  // closed-ended range: includes 100
//    for (i in 1..<100) { println(i) } // open-ended range: does not include 100
//    for (x in 2..10 step 2) { println(x) }
//    for (x in 10 downTo 1) { println(x) }
//    (1..10).forEach { println(it) }

//    val p : String by lazy {
//        "Piyush"
//    }
//
//    println(p) //because of lazy, it is only computed on the first access

//    fun String.isEmail() : Boolean{
//        return this.contains("@")
//    }
//
//    val myEmail : String = "piyushATgmail.com"
//    println(myEmail.isEmail())
//
//    val naam = SingletonExample.name
//    //use of object keyword, showing the use of singleton
//
//    val naam2 = SingletonExample.name

//val myObj = object : myAbs(){
//    override fun doSomething() {
//        println("Did something")
//    }
//}
//    myObj.doSomething()

//    val emails = listOf("me@gmail.com", "you@gmail.com")
//    println(emails.firstOrNull())

    //execute if not null
//    val value = null
//    value?.let{
//        println("not null")
//    }

//    println(transform("Orange"))
//    println(transform("Red"))

//    println(myName())

//    val myTurt = Turtle()
//    with(myTurt){
//        penDown()
//        for(i in 1..4){
//            forward(100.0)
//            turn(90.0)
//        }
//        penUp()
//    }


    //swapping 2 variabes
//    var pehla = 1
//    var doosra = 2
//    println("the value of pehla is $pehla and the value of doosra is $doosra")
//    pehla = doosra.also { doosra = pehla }
//    println("the value of pehla is $pehla and the value of doosra is $doosra")


    //equivalent of stringbuilder
//    val countDown = buildString {
//        for(i in 5 downTo 1){
//            append("$i is the value")
//            appendLine()
//        }
//    }
//    println(countDown)

//    val numbers1 = listOf(1,2,3,4,5,6)
//    val oddnos = numbers1.filter { it%2 == 0 }.joinToString("; ")
//    {"${-it}"}
//    println(oddnos)
//    println(oddnos::class.simpleName)


    //string ops
//    val input = "##my name is piyush##"
//    val result = input.removeSurrounding("##")
//    println(result)




    //java
    // Java
    //System.out.println(Arrays.toString("Sometimes.text.should.be.split".split("\\.")));
//    println("Sometimes.text.should.be.split".split("."))


//    val inp = "What is the answer of 2+2? 4"
//    println(inp.substringAfter("?"))

    //you can also check the last occurance
//    val inp = "what is 1+1? 2 What is 2+2? 4"
//    println(inp.substringAfterLast("?"))

//    println("Hello I am Piyush".contains("Piyush"))

//    println("Piyush" in "Hello i am Piyush")
    println("Hello".count())
    println("Hello".length)


} //funmain

fun printKaro(a: Int, b: Int){
    println(a+b)
}

open class Shape

class Rectangle(val height: Double, val length: Double): Shape(){
    var perimeter = (height + length) * 2
}


fun findMax(a: Int, b: Int): Int{
    if(a>b){
        return a
    }
    return b
}

fun maxNikaal(a: Int, b: Int) = if(a>b) a else b

fun getStrLen(obj : Any): Int?{
    if(obj is String && obj.length > 0){
        return obj.length
    }
    return null
}


data class Customer(val name: String, val email: String)



//val and var are keywords


/*
    A singleton is a design pattern that ensures a class has only one
    instance throughout the application's lifecycle, and provides a global
    point of access to that instance.
    In Kotlin, you typically create a singleton using the object keyword
    why used?
    To manage resources that should only have one instance
     (e.g., network clients, databases, shared preferences, repositories).

     passing constructor is not allowed in object classes since it can
     only have 1 instance, but constructor allows multiple.
     */

object SingletonExample{
    val name = "ekHeInstanceBanaPaayaLmaoXD"
}

abstract class myAbs{
    abstract fun doSomething()
}

fun transform(color : String): Int{
    return when(color){
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }
}

fun myName() = "Piyush Shivnani"
/*
This is equivalent to

fun theAnswer(): Int {
    return 42
}
 */

//class Turtle{
//    fun penDown()
//    fun penUp()
//    fun turn(degree : Double)
//    fun forward(pixels : Double)
//}

