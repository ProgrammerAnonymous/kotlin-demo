package demo.kotlin

import java.io.File
import java.io.FileInputStream

/**
 * Created by gemhuang on 2017/7/16.
 */

fun main(args: Array<String>){
    val file: File = File(args[0])

    val fis: FileInputStream = FileInputStream(file)
}