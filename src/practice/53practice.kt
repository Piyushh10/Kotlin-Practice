package practice

fun main(){
    var list = (1..20).toList()
    println(list)
    list = list.filter {
        it%2==0
    }
    println(list)

    list = list.customFilter { it % 2 == 0 }
    println(list)
}

fun List<Int>.customFilter(filterFunction: (Int)->(Boolean)) : List<Int>{
    var list1=mutableListOf<Int>()
    for(item in this){
        if(filterFunction(item)){
            list1.add(item)
        }
    }
    return list1
}