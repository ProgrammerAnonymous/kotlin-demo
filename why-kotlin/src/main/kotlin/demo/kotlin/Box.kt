package demo.kotlin

/**
 * Created by gemhuang on 2017/7/15.
 */

class Box<T>(t: T){
    var value = t
}

// declared
val box: Box<Int> = Box<Int>(1)

// inferenced
val boxI = Box(2)
