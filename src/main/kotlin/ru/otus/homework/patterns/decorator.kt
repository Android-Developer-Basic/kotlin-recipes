package ru.otus.homework.patterns

fun main() {
    val person = Sweater(Human())
    val dressedPerson = person.dressUp()
    println(dressedPerson)
}

interface Person {
    fun dressUp(): String
}

class Human : Person {
    override fun dressUp() = "Person"
}

class Sweater(private val person: Person) : Person by person {
    override fun dressUp(): String {
        return person.dressUp() + putOnSweater()
    }

    private fun putOnSweater(): String {
        return " wearing sweater"
    }
}