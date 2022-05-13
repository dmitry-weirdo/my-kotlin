package com.rsk

class Person(var Name: String) { // public is default

    fun display() { // public is default
        println("Display: $Name")
    }

    fun displayWithLambda(func: (s: String) -> Unit) { // Unit is void
        func(Name)
    }
}

class Person2(var name: String) {

    fun display() {
        println("Display: $name")
    }

    fun displayWithLambda(func: (s: String) -> Unit) { // Unit is void
        func(name)
    }
}