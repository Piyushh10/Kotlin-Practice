fun main(){

}

//class FilledRectangle{
//    fun draw(){
//        val filler = Filler()
//        filler.drawAndFill()
//    }
//
//    inner class Filler{
//        fun fill(){println("Filling")}
//        fun drawAndFill(){
//            super@FilledRectangle.draw()
//            fill()
//        }
//
//    }
//}


abstract class Polygon{
    abstract fun draw()
}

class Rectangle : Polygon(){
    override fun draw() {
        TODO("Not yet implemented")
    }
}
