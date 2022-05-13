import com.rsk.Person
import com.rsk.Person2

fun main(args: Array<String>) {
    val kevin2 = Person2("Kevin from Constructor")
//    kevin2.name = "Kevin"
//    kevin2.name = "Steve" // if Name is var, it can be re-assignable

//    kevin2 = Person2() // cannot re-assign val

    println("Name (2) is ${kevin2.name}")

    kevin2.display()
    kevin2.displayWithLambda(::printName)


    println("Hello, World 666")

    val kevin = Person("Kevin")
//    kevin.Name = "Kevin"
    println("Name is ${kevin.Name}")

    kevin.Name = "Steve"
    println("Name is ${kevin.Name}")

    kevin.display()

    kevin.displayWithLambda(::printName)

//    kevin = Person() // val cannot be re-assigned
}

fun printName(name: String) {
    println(name)
}