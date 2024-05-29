package ru.otus.homework.patterns

fun main() {
    println("Hello, singleton!")
    println("Create first DB and add entry to it.")
    val db1 = DatabaseObject
    db1.add(0, "first")
    println("Create second DB and add entry to it.")
    val db2 = DatabaseObject
    db2.add(1, "second")
    println("Print result as a single DB object: ${DatabaseObject.view()}")
}

object DatabaseObject {
    private var map = mutableMapOf<Int, String>()

    fun add(key: Int, value: String) {
        map[key] = value
    }

    fun view(): String = map.toString()
}