package practice
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

interface Repository{
    fun readItem(): Int
}

object MyRepository : Repository{
    override fun readItem(): Int {
        return runBlocking{
            myReadItem()
        }
    }
}

suspend fun myReadItem():Int{
    delay(100.milliseconds)
    return 4
}
