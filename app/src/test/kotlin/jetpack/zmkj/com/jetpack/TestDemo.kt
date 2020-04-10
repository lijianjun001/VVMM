package jetpack.zmkj.com.jetpack

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

class TestDemo {

    @Test
    fun main() = runBlocking {
        //，因为外部协程（示例中的 runBlocking）直到在其作用域中启动的所有协程都执行完毕后才会结束

        launch {
            delay(200L)
            println("Task from runBlocking")
        }

        coroutineScope {
            //  创建一个协程作用域。它会创建一个协程作用域并且在所有已启动子协程执行完毕之前不会结束。
            launch {
                delay(500L)
                println("Task from nested launch")
            }

            delay(100L)
            println("Task from coroutine scope") // 这一行会在内嵌 launch 之前输出
        }

        //coroutineScope是同步的，只有等待它执行完，才能执行后面的代码，但是前面的线程能执行

        println("Coroutine scope is over") // 这一行在内嵌 launch 执行完毕后才输出
    }
//请注意，当等待内嵌 launch 时，紧挨“Task from coroutine scope”消息之后， 就会执行并输出“Task from runBlocking”，尽管 coroutineScope 尚未结束。
// runBlocking 方法会阻塞当前线程来等待， 而 coroutineScope 只是挂起，会释放底层线程用于其他用途

    suspend fun first() {
        delay(200L)
        println("Task from runBlocking")
    }
}