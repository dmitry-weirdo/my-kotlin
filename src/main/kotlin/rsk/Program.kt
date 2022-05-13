@file:JvmName("DisplayFunctions")

package rsk

fun main(args: Array<String>) {
    display("Hello, World!")
    log("Hello, World Log!")

    log(logLevel = 2, message = "Hello, Wooorld!")
    log(message = "Hello, Wooorld!", 22)

    println(max(2, 666))
}

fun display(message: String): Boolean {
    println(message)
    return true
}

// function expression. Notice no "return" keywords!
//fun max(a: Int, b: Int): Int = 666
fun max(a: Int, b: Int): Int =
    if (a > b) a // if is an expression
    else b

@JvmOverloads
fun log(message: String, logLevel: Int = 1) { // default param value
    println("$message $logLevel")
}