package Interfaces

interface Animal{
    fun sound()
    fun name()
    fun eat(){
        println("Nom Nom.....")
    }
    fun walk()
}

//blueprint for a class, so that the class can implement this interface

class Dog : Animal{
    override fun sound(){
        println("bhau bhau!")
    }
    override fun name(){
        println("Doggie")
    }
    override fun walk(){
        println("Chap chap chap chap....")
    }
}

fun main(){
    val dog = Dog()
    dog.sound()
    dog.eat()
}
