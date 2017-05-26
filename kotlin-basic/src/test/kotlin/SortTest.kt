import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Created by gemhuang on 2017/5/20.
 */
const val MAX: Int = 10240  // 註 1
const val SIZE: Int = 1000

class SortTest {  // 註 2

    @Test  // 註 3
    fun testBubbleSort() {  // 註 4
        var instances = prepareInstances()  // 註 5

        instances = bubbleSort(instances)  // 註 6

        verifySortedInstances(instances)
    }

    private fun prepareInstances(): Array<Int> = Array(SIZE, { Random().nextInt(MAX) })  // 註 7

    private fun verifySortedInstances(instances: Array<Int>) {  // 註 8
        var less = instances[0]  // 註 9

        for (i in 1..instances.size - 1) {  // 註 10
            var larger = instances[i]

            Assert.assertTrue(less <= larger)

            less = larger
        }
    }
}