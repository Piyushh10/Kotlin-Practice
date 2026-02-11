package practice

fun main(){
    val nos47 = listOf(1,2,3,4,5)
    val nosIterator47 = nos47.iterator()
    while(nosIterator47.hasNext()){
        println(nosIterator47.next())
    }

    for(item in nos47){
        println(item)
    }

    nos47.forEach {
        println(it)
    }


}