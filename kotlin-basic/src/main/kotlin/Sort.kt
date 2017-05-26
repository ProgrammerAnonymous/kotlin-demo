/**
 * Created by gemhuang on 2017/5/20.
 */

fun bubbleSort(instances: Array<Int>): Array<Int> {  // 註 11
    for (i in 0..instances.size - 2) {
        for (j in i + 1..instances.size - 1) ascend(instances, i, j)
    }

    return instances
}

fun ascend(instances: Array<Int>, pre: Int, nxt: Int) {
    if (instances[pre] > instances[nxt]) {
        val temp = instances[pre]  // 註 12
        instances[pre] = instances[nxt]
        instances[nxt] = temp
    }
}
