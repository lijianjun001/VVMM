package jetpack.zmkj.com.jetpack

import kotlinx.coroutines.runBlocking
import org.junit.Test

class NumUtil {


    @Test
    fun main() = runBlocking {

        var intArray = arrayOf(1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6, 7, 7, 8, 8)


        var result = findSingleNum2(intArray)
        println(result)


        var result2 = findSingleNum(intArray)

        println(result2)

    }


    /**
     * 有序查找
     */
    private suspend fun findSingleNum(array: Array<Int>): Int {


        val middleIndex = array.size / 2 + 1
        val beforeIndex: Int

        beforeIndex = if (middleIndex == 1) {
            1
        } else {
            middleIndex - 1
        }

        val afterIndex: Int
        afterIndex = if (middleIndex == 2) {
            2
        } else {
            middleIndex + 1
        }
        val middleValue = array[middleIndex]


        var tempArray = emptyArray<Int>()

        when (middleValue) {
            array[middleIndex - 1] -> {//说明在前面

                tempArray = Array(beforeIndex) { 0 }
                for (i in tempArray.withIndex()) {
                    tempArray[i.index] = array[i.index]
                }

            }
            array[afterIndex] -> {
                tempArray = Array(middleIndex - 1) { 0 }
                for (i in tempArray.withIndex()) {
                    tempArray[i.index] = array[array.size - middleIndex + 1 + i.index]
                }
            }
            else -> {
                tempArray = Array(1) { 0 }
                tempArray[0] = middleValue
                println(middleValue)
            }
        }

        if (tempArray.size == 1) {
            return tempArray[0]
        }
        return findSingleNum(tempArray)

    }

    /**
     * 无序查找
     */
    private fun findSingleNum2(array: Array<Int>): Int {

        var result = 0

        for (i in array) {
            result = result xor i
        }
        return result

    }
}