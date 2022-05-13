package rsk

open class Person { // open -> non-final
    var firstName = "" // type inheritance works!
    var lastName = "" // type inheritance works!

    open fun getName() = "$firstName $lastName" // type inheritance works!
}

abstract class AbsPerson {
    var firstName = "" // type inheritance works!
    var lastName = "" // type inheritance works!

    open fun getName() = "$firstName $lastName" // type inheritance works!

//    abstract fun getAddress() // void (actually returns Unit)
    abstract fun getAddress(): String // void
}

class Student : Person() { // call default constructor
    override fun getName() = "123" // works if is "open" in the parent class
//    override fun getName() = 666 // won't work - different return type
}

class AbsStudent: AbsPerson() {
    override fun getAddress(): String {
        return "My Address from AbsStudent"
    }
}