package rsk

import java.math.BigInteger

fun main() {
    println(
        fib(100000, BigInteger("1"), BigInteger("0"))
    )
}

tailrec fun fib(n: Int, a: BigInteger, b: BigInteger): BigInteger {
    return if (n == 0)
        b
    else
        fib(n - 1, a + b, a)
}

// n is actually going down instead of up
// 10, 1, 0
// 9, 1, 1
// ...
// 1, 55, 34
// 0, 89, 55 -> return 55