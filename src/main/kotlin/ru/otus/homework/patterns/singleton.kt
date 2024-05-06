package ru.otus.homework.patterns

fun main() {
    println("Hello, singleton!")
    println("First call:")
    val db1 = Database.getDBInstance()
    println(db1.data)
    println("Second call:")
    val db2 = Database.getDBInstance()
    println(db2.data)

    println("db1 === db2: ${db1 === db2}")
}

class Database private constructor(val data: Map<String, String>) {
    companion object {
        private val instance: Database by lazy {
            println("Initializing database...")
            Database(mapOf(
                "1" to "One",
                "2" to "Two",
                "3" to "Three"))
        }

        fun getDBInstance(): Database {
            return instance
        }
    }
}