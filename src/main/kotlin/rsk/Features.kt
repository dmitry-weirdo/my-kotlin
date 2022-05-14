package rsk

fun main() {
    val pair = 1 to "one moment" // Pair<Int, String>
    println("Pair<Int, String>: $pair")

    val x = 666
    val d: Int // deferred initialization, MUST declare the variable type in this case
    if (x > 500) {
        d = -1
    }
    else {
        d = 42
    }

    println(d)

    whenCheck(1)
    whenCheck(10)
    whenCheck(10L) // Long
    whenCheck("Hello!")

    val operation = getOperation() // type is (Int) -> Int
    println("Operation resul: ${operation(25)}")

    val uppercase: (String) -> String = String::uppercase
//    val uppercase2: = String::uppercase // won't compile without type declaration since there are multiple argument/return types for String::uppercase

    val listWithNull = listOf(null, 1, 2, 3, 1, 3) // List<Int?>, minOrNull won't work
    val listOfInts = listOf(1, 2, 3, 1, 3) // List<Int>
    println("Min or null: ${listOfInts.minOrNull()}")
    println("Max or null: ${listOfInts.maxOrNull()}")

    // test groupBy and associateBy
    val employees = listOf(
        Employee("John", "Boston", "+1-888-123456"),
        Employee("Sarah", "Munich", "+49-777-789123"),
        Employee("Svyatoslav", "Saint-Petersburg", "+7-999-456789"),
        Employee("Vasilisa", "Saint-Petersburg", "+7-999-123456")
    )

    val lastEmployeesByCity = employees.associateBy(Employee::city) // Map<String, Employee>, last by key will be used
    val lastNamesByCity = employees.associateBy(Employee::city, Employee::name) // Map<String, String>, last by key will be used. Values are String

    val groupEmployeesByCity = employees.groupBy(Employee::city) // Map<String, List<Employee>>
    val groupNamesByCity = employees.groupBy(Employee::city, Employee::name) // Map<String, List<String>>, values are String

    println("Last employees by city: $lastEmployeesByCity")
    println("Last employee names by city: $lastNamesByCity")
    println("Group employees by city: $groupEmployeesByCity")
    println("Group employee names by city: $groupNamesByCity")

    val list = listOf(1, 2, 3, 4)
    val (one, _, three) = list
    println("one (destructured from list): $one")
    println("three (destructured from list): $three")
}

fun whenCheck(obj: Any) {
    when (obj) {
        1 -> println("Object $obj is one")
        is Int -> println("Object $obj is Int")
        is Long -> println ("Object $obj is Long")
        else -> println("Unknown object: $obj")
    }
}

fun getOperation(): (Int) -> Int = { it * it }

data class Employee(val name: String, val city: String, val phone: String)