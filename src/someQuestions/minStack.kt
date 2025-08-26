package someQuestions

import kotlin.math.min

class minStack() {
    private val stack = mutableListOf<Int>()
    private val Minstack = mutableListOf<Int>()

    fun push(x: Int){
        stack.add(x)
        if(Minstack.isEmpty() || x <=Minstack.last())
            Minstack.add(x)
    }
    fun pop(){
        if(stack.removeAt(stack.lastIndex) == Minstack.last())
            Minstack.removeAt(Minstack.lastIndex)
    }

    fun top(): Int = stack.last()
    fun getMin():Int = Minstack.last()
}

fun reverseString(s: String): String{
    return s.reversed()
}

fun isPal(s: String): Boolean{
    val clean = s.filter { it.isLetterOrDigit() }.lowercase()
    return clean == clean.reversed()
}

fun longSubS(s: String): Int{
    val set = mutableSetOf<Char>()
    var left = 0
    var maxL=0
    for(right in s.indices){
        while (s[right] in set){
            set.remove(s[left])
            left++
        }
        set.add(s[right])
        maxL = maxOf(maxL, right-left+1)
    }
    return maxL
}