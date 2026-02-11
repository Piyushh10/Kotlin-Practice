package practice

import kotlin.math.sqrt


abstract class Shape(
    var name : String
){
    init {
        println("I am the super class!")
    }
    constructor(name : String, vararg others : Double): this(name)
    abstract fun area(): Double
    abstract fun perimeter(): Double
    fun changeName(newName : String){
        name=newName
    }
}

class Rectangle(
    private val a : Double,
    private val b : Double
) : Shape("Rectangle"){
   init{
       println("$name with sides $a and $b has been created")
   }
    constructor(a : Double): this(a,a)
    override fun area(): Double{
        return a*b
    }
    override fun perimeter() = 2*(a+b)
    fun isSquare()= a==b
}

fun main(){
//    val rect1 = Rectangle(3.0, 4.0)
//    println(rect1.area())
//    println(rect1.perimeter())
//    println(rect1.isSquare())
//    println(sqrt(9.0))
    val myRect = Rectangle(6.0,7.0)
    println(myRect.name)
    myRect.changeName("My Rectangle")
    println(myRect.name)

}


