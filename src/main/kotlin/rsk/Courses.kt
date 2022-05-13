package rsk

class Course(val id: Int, val title: String) {
}

object Courses {
    val allCourses = arrayListOf<Course>()

    fun initialize() { // NOT a constructor
        allCourses.add(Course(1, "Kotlin Fundamentals"))
    }
}