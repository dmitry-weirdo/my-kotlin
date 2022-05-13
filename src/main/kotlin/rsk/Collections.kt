package rsk

fun main() {
    val ints = listOf(1, 2, 3, 4, 5)

    val greaterThanThree = { v: Int -> v > 3 } // type of "v" must be specified

    val allLargeInts = ints.all(greaterThanThree) // boolean
    println("All large ints: $allLargeInts")

    val anyLargeInts = ints.any(greaterThanThree) // boolean
    println("Any large ints: $anyLargeInts")

    val numberOfLargeInts = ints.count(greaterThanThree) // Int
    println("Count: $numberOfLargeInts")

    val found = ints.find(greaterThanThree) // is findFirst, it is Int?
    println("found: $found")

    val notFound = ints.find { it > 666 } // is findFirst, it is Int? It will be null if not found.
    println("notFound: $notFound")

    val smallInts = ints
        .filter { it < 4 }

    println()
    println("Small ints:")
    for (i: Int in smallInts)
        println(i)

    val squareInts = ints
        .map { it * it }

    println()
    println("Squares:")
    for (i: Int in squareInts)
        println(i)

    val smallSquaredInts = ints
        .filter { it < 5 }
        .map { it * it }

    println()
    println("Small squares:")
    for (i: Int in smallSquaredInts)
        println(i)

    val meetings = listOf(
        SimpleMeeting(1, "Board Meeting"),
        SimpleMeeting(2, "Committee Meeting"),
    )

    val titles = meetings.map { it.title }

    println()
    println("Meeting titles: ")
    for (title in titles) // type of "title" is auto-calculated
        println(title)
}

class SimpleMeeting(val id: Int, val title: String)