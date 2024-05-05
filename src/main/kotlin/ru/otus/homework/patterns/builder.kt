package ru.otus.homework.patterns

fun main () {
    val myperson = PersonBuilder()
    myperson.withSurname("Петров").withName("Петя").withBirthPlace("Рим")
    println(myperson.toString())

    val myperson2 = PersonBuilder()
    myperson2.withSurname("Иванов").withAge(35)
    println(myperson2.toString())
}

class PersonBuilder {
    private var name = ""
    private var surname = ""
    private var age = 0
    private var birthPlace = ""

    fun withName (name: String): PersonBuilder {
        this.name = name
        return this
    }

    fun withSurname (surname: String): PersonBuilder {
        this.surname = surname
        return this
    }

    fun withAge (age: Int): PersonBuilder {
        this.age = age
        return this
    }

    fun withBirthPlace (birthPlace: String): PersonBuilder {
        this.birthPlace = birthPlace
        return this
    }

    override fun toString(): String {
        var result = ""
        if (name != "") result += "Имя: $name "
        if (surname != "") result += "Фамилия: $surname "
        if (age != 0) result += "Возраст: $age "
        if (birthPlace != "") result += "Место рождения: $birthPlace "
        return result
    }
}