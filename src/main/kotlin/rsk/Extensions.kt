package rsk;

fun main(args: Array<String>) {
    val text = "With      multiple  \t      whitespaces"

    println("    ".isBlank())
    println(null.isNullOrBlank())
    println("".isBlank())
    println(" \t \t ".isBlank())
    println(" a ".isBlank())

    println(text)
    println(replaceMultipleWhiteSpace(text))
    println(text.replaceMultipleWhiteSpaceEx()) // call an extension function
}

fun replaceMultipleWhiteSpace(value: String): String {
    val regex = Regex("\\s+")
    return regex.replace(value, " ");
}

fun String.replaceMultipleWhiteSpaceEx(): String { // extension function
    val regex = Regex("\\s+")
    return regex.replace(this, " "); // extension receives this
}