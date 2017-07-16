/**
 * Created by gemhuang on 2017/6/30.
 */


fun main(args: Array<String>){
    val ar: Array<Int> = arrayOf(1, 2, 3)

    // failed when anyAr: Array<Any>, because arrays is invariant in Kotlin
    // val anyAr: Array<Any> = ar

    // val cannot be reassigned.
    // ar = arrayOf(3, 4, 5)

    // but elements can be modified.
    ar[0] = 9

    println(ar.asList().toString())

    val ar2: IntArray = intArrayOf(1, 2, 3)

    ar2[0] = 9

    println(ar2.asList().toString())
}
