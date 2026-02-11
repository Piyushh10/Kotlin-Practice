package practice

import kotlin.math.PI
import kotlin.random.Random

fun main(){
    val rect2 = Rectangle(2.0)
    val pi2 = practice51.pi
}
/*
A class can only be inherited if its declared open, sealed or abstract or if
its an interface. BY default, all classes in Kotlin are final and cannot be
inherited.
 */

class Circle(
    private val r: Double
): Shape("Circle"){
    companion object{
        fun randomCircle():Circle{
            val rad = Random.nextDouble(1.0, 10.0)
            return Circle(rad)
        }
    }
    override fun area(): Double {
        return PI*r*r
    }

    override fun perimeter(): Double {
        return 2*PI*r
    }
}

