package rsk

fun main() {
    val kevin3 = Student3(1, "Kevin")
    val jones3 = Student3(1, "Kevin")

    println(kevin3)

    if (kevin3 == jones3) {
        println("Equal")
    }
    else {
        println("Not equal")
    }

    val kevin4 = Student4(1, "Kevin")
    val jones4 = Student4(1, "Kevin")

    println(kevin4) // nice toString auto-implemented in the data class

    if (kevin4 == jones4) { // equals will be auto-implemented in the data class
        println("Equal")
    }
    else {
        println("Not equal")
    }

    // data class provides copy
    val newKevin = kevin4.copy(name = "Robert") // can override the fields
    println(newKevin)
}

class Student3(val id: Int, val name: String)

data class Student4(val id: Int, val name: String) // will implement equals, hashCode, toString
