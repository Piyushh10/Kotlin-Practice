package practice

object practice51 {
    val pi = 3.14

}


fun main(){
    val circ2 = Circle.randomCircle()
    println(circ2.area())
    val parallelo1 = object : Shape("Parallelogram", 3.0, 4.0, 2.0){
        override fun area(): Double {
            TODO("Not yet implemented")
        }

        override fun perimeter(): Double {
            TODO("Not yet implemented")
        }

    }


}
