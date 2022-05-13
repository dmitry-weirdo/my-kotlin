import java.io.FileReader
import java.io.IOException
import java.net.URI
import java.util.*

fun main(args: Array<String>) {
    // try-with-resources also exists in Kotlin
    try {
        val reader = FileReader("filename")
        val read = reader.read()
    }
    catch (e: IOException) {
        println("Oops. File not read!")
    }
    finally {
        println("F*cking finally! ©")
    }

    println("Hello, World 777")

//    val q = Question2() // non-nullable
    var q: Question2? = Question2()
//    q = Question2() // val is immutable, var is mutable

//    q = null

//    q?.answer = "bad42"
    q?.answer = "42"

//    q.question = "Cannot change"

    q?.display() // safe operator

    println("The answer to the question ${q?.question} is ${q?.answer}") // will evaluate to null if q is null

    val message = if (q?.answer == q?.correctAnswer) { // if is a value
        "You were correct"
    } else {
        "Incorrect answer. Try again?"
    }

    q?.printResult()

//    q.answer = null
/*
    if (q.answer != null) {

    }
*/

    println(message)

//    val number = Integer.parseInt(q?.answer)

    // try is a statement
    val number: Int? = try {
        Integer.parseInt(q?.answer)
    } catch (e: NumberFormatException) { // also works with Kotlin's NFE
        null
    }

    println("Number is $number")

    // while and do-while are same as in Java
//    while (true) {
//
//    }
//
//    do {
//
//    } while (true)


    val myValues = 1..10

    println("From 1 to 10 (Range: $myValues)")
    for (i in myValues step 3) {
        println(i)
    }

    println("From 10 to 1")
    for (i in 10 downTo 1 step 2) {
        println(i)
    }

    println("From 1 until 10") // 1 <= i < 10
    for (i in 1 until 10) {
        println(i)
    }

    println("Iterate a list")
    val numbers = listOf(1, 22, 3333, 4, 55)
    for (i in numbers) {
        println(i)
    }

    val ages = TreeMap<String, Int>()
    ages["Kevin"] = 55
    ages["Sam"] = 24
    ages["Alex"] = 24
    ages["Harry"] = 26

    for ((name, age) in ages) { // iterate Map
        println("$name is $age years old.")
    }

    for ((index, element) in numbers.withIndex()) {
        print("index $index, element: $element")
    }

    val rangeChars = 'a'..'z'
    for (s in rangeChars.reversed()) { // you can use .reversed() over the existing range
        println("Char (from ${rangeChars.first} to ${rangeChars.last}): $s")
    }

    val rangeStrings = "aaa".."bbb"
//    for (s in rangeStrings) { // will not work: iterator not defined
//        println("String: ")
//    }


    println(
        (1..10)
            .filter { it % 2 == 0 }
    ) // can filter while Progression is iterable


/*

//    val q: Question? = Question() // no type, no "new"
    val q: Question? = null

//    val q2: Question = null // will not compile


//    var q: Question = Question() // no type, no "new"

//    q = Question()

    // use generated java getter and setter

//    q.Answer = null
//    if (q.Answer != null) {
//
//    }

    q?.Answer = "42"
//    q.Question = "" // val cannot be re-assigned

    q?.rsk.display()

    println("The answer is $q.Answer") // without ${}, will output Question@asb546.Answer
    println("The answer to the question \"${q?.Question}\" is \"${q?.Answer}\"")

    val message = if (q?.Answer == q?.CorrectAnswer) {
        "You were correct"
    }
    else {
        "Try again!"
    }

    println(message)

    q?.printResult()
*/
}

fun connect(addr: URI): Boolean {
    return false
}

fun voidFunction() {

}

class Question {
    //    var Answer: String = ""
    var Answer: String? = null // ? means nullable
    val CorrectAnswer = "42"
    val Question: String = "What is the answer to life, the universe and everything?"

    fun display() {
        println("You said $Answer")
    }

    fun printResult() {
        when (Answer) { // switch analogue
            CorrectAnswer -> println("You were correct")
            else -> println("Try again?")
        }
    }
}

class Question2 {
    var answer: String? = null
    val question: String = "What is the answer to life, the universe and everything?"
    val correctAnswer = "42"

    fun display() {
        println("You said $answer");
    }

    fun printResult() {
        if (answer == correctAnswer) {
            println("You were correct")
        } else {
            println("Try again?")
        }

        when (answer) {
            correctAnswer -> println("You were correct (WHEN)")
            else -> println("Try again (WHEN)")
        }
    }
}
