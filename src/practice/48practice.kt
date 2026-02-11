package practice


const val a = "hello"
fun main(){
//    var  a1 = 5f
//    var b1 = 2
//    println(a1/b1)
//
//
//    val m = "madam"
//    println(m == m.reversed())
//
//    val name = readln().toString()
//    val age = readln().toInt()
//    println("My name is $name and I am $age years old.")

    val arr = intArrayOf(69,79,89)
    println(getMax(1,2,3,4,5,6,7,8, 9, *arr))
    println("madam".isPalindrome())
}

fun getMax(vararg numbers : Int):Int{
    var max = numbers[0]
    for(num in numbers){
        if(num>max){
            max=num
        }
    }
    return max
}

fun String.isPalindrome(): Boolean{
    return this == this.reversed()
}

fun Int.isEven(): Boolean{
    return this % 2 == 0
}