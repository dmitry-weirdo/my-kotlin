package rsk

fun main() {
    val kevin = Student(123666, "Kevin", "Jones")
//    val kevin2 = Student("Kevin", "Jones", 789, "Test tutor") // overloaded constructor, different params order
    val kevin2 = Student(789, "Kevin", "Jones", "Test tutor")

    println("Id: ${kevin.id}")
    println("Tutor: ${kevin2.tutor}")

    // companion object - called as static methods
    Student.createPostgraduate("Simon")
    Student.createUndergraduate("Kevin")
}

class Program {
    companion object {
        @JvmStatic // must be declared to make static for java, i.e. mark main() an executable method
        fun main(args: Array<String>) {
            val kevin = Student(123666, "Kevin", "Jones")
            print(kevin.id)
        }
    }
}

open class Person(var firstName: String, var lastName: String) { // open -> non-final
//    var firstName = "" // type inheritance works!
//    var lastName = "" // type inheritance works!

    open fun getName() = "$firstName $lastName" // type inheritance works!
}

abstract class AbsPerson {
    var firstName = "" // type inheritance works!
    var lastName = "" // type inheritance works!

    open fun getName() = "$firstName $lastName" // type inheritance works!

    //    abstract fun getAddress() // void (actually returns Unit)
    abstract fun getAddress(): String // void
}

open class Student(_id: Int, firstName: String, lastName: String, var tutor: String = "") : Person(firstName, lastName) { // call default constructor
    override fun getName() = "123" // works if is "open" in the parent class
//    override fun getName() = 666 // won't work - different return type

    val id : Int
//    var tutor : String

    init {
        println("Constructor, before the id assignment"); // cannot use id here, not yet initialized
//        _id = _id + 1 // defaults to val
        id = _id
//        id = 666

//        tutor = "";
    }

/*
    // constructor overload
    constructor(
        firstName: String,
        lastName: String,
        _id: Int,
        tutor: String
    ) : this(_id, firstName, lastName) { // must call the "primary" constructor of "this". "super(firstName, lastName)" won't work.
        this.tutor = tutor;
    }
*/

    fun enroll(courseName: String) {
        val course = Courses
            .allCourses
            .filter { it.title == courseName }
            .firstOrNull()
    }

    companion object : XmlSerializer<Student> { // companion object can implement interfaces
        fun createUndergraduate(name: String): Undergraduate {
            return Undergraduate(name)
        }

        fun createPostgraduate(name: String): Postgraduate {
            return Postgraduate(name)
        }

        override fun toXml(item: Student) { // implement the interface method

        }
    }
}

class Undergraduate(firstName: String) : Student(1, firstName, "")

class Postgraduate(firstName: String) : Student(2, firstName, "Postgraduate lastName")

/*
class Student2(_id: Int) : Person() { // _id defaults to "val"
}
*/

class AbsStudent : AbsPerson() {
    override fun getAddress(): String {
        return "My Address from AbsStudent"
    }
}

interface XmlSerializer<T> {
    fun toXml(item: T)
}