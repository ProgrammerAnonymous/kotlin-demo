package demo.kotlin

/**
 * Created by gemhuang on 2017/7/16.
 */

fun run(func: () -> Unit) {
    func()

    // same as func()
    func.invoke()
}

fun sayHi() {
    println("Hi, this is in Kotlin.")
}

fun main(args: Array<String>) {
    run(::sayHi)
}