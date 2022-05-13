package rsk

fun main() {
    val h1 = Header("H1")
    val h2 = Header("H2")

    val h3 = h1.plus(h2) // extension
    val h4 = h1 plus h2 // as infix function
    val h5 = h1 + h2 // as infix function
    println("Combined header name (extension): ${h3.name}")
    println("Combined header name (infix): ${h4.name}")
    println("Combined header name (operator): ${h5.name}")
}

class Header(var name: String) // class can have empty body!

infix operator fun Header.plus(other: Header): Header {
    return Header("${this.name} ${other.name}")
}