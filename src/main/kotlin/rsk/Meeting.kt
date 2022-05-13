package rsk

import java.util.*

class Meeting {
    var title: String = ""
    var date: Date = Date()
    var who = mutableListOf<String>()

    fun create() {}
}

fun main() {
    val meeting = Meeting()

    meeting.title = "Board Meeting"
    meeting.date = Date(2017, 12, 30)
    meeting.who.add("Kevin")

    with (meeting) { // inline function defined in Standard.kt
        title = "Board Meeting from with"
        date = Date(2021, 3, 10)
        who.add("Kevin from with")
    }

    // "apply| is used e.g. for a Builder pattern
    meeting.apply { // inline function defined in Standard.kt
        title = "Board Meeting from with"
        date = Date(2021, 3, 10)
        who.add("Kevin from with")
    }.create()
}