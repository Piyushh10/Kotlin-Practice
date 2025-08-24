package Interfaces

interface Engine{
    fun start(){
        println("Vehicle starts.....")
    }
    fun name(){
        println("Engine")
    }
}

interface Wheels{
    fun roll(){
        println("Wheels are rolling")
    }
    fun name(){
        println("Wheels")
    }
}

class car: Engine, Wheels{
    override fun name(){
        super<Wheels>.name()
    }
}

fun main(){
    val myCar = car()
    myCar.start()
    myCar.roll()
}

//conflicts- if 2 interfaces have same method, then we have to
//explicitly override it in the implementation class to avoid conflict
// for that we use super keyword
//see name() in the above example
