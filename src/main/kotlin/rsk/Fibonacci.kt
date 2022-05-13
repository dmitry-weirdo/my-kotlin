package rsk

fun main() {
    val fibonacci = Fibonacci()
//    fibonacci.fibonacci(8)

    val action = object : Process { // anonymous class
        override fun execute(value: Int) {
            println("execute: $value")
        }
    }

    fibonacci.fibonacci(8, action) // anonymous class (interface implementation)

    fibonacci.fibonacci(
        8,
        { n -> println("lambda $n")}
    )

    fibonacci.fibonacci(8) { n -> println("lambda out $n") } // after the parenthesis!

    fibonacci.fibonacci(8, { println("lambda out $it") }) // use it as the default arg name

    fibonacci.fibonacci(8, ::println) // just pass the method name

    var total = 0
    fibonacci.fibonacci(8) { total += it } // no need to declare (it) as the first argument, it is an implicit default name
    println(total)
}

interface Process {
    fun execute(value: Int)
}

class Fibonacci {

    // 1, 1, 2, 3, 5, 8, 13, 21, ...

    fun fibonacci(limit: Int, action: (Int) -> Unit) {
        var prev = 0
        var prevPrev = 0
        var current = 1

        for (i: Int in 1..limit) {
            action(current) // just call a function

            val temp = current
            prevPrev = prev
            prev = temp
            current = prev + prevPrev
        }
    }

    fun fibonacci(limit: Int, action: Process) {
        var prev = 0
        var prevPrev = 0
        var current = 1

        for (i: Int in 1..limit) {
            action.execute(current) // strategy, defines the action

            val temp = current
            prevPrev = prev
            prev = temp
            current = prev + prevPrev
        }
    }

    fun fibonacci(limit: Int) {
        var prev = 0
        var prevPrev = 0
        var current = 1

        for (i: Int in 1..limit) {
            println(current)

            val temp = current
            prevPrev = prev
            prev = temp
            current = prev + prevPrev
        }
    }
}