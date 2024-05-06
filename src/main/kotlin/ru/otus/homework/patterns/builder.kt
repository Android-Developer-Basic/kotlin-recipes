package ru.otus.homework.patterns

fun main () {
    val myperson = Person.Builder()
        .withSurname("Петров").withName("Петя").withBirthPlace("Рим").build()
    println(myperson.toString())

    val myperson2 = Person.Builder()
        .withSurname("Иванов").withAge(35).build()
    println(myperson2.toString())
}

class Person private constructor(
    private val name: String?,
    private val surname: String?,
    private val age: Int?,
    private val birthPlace: String?
){
    data class Builder (
        var name: String? = null,
        var surname: String? = null,
        var age: Int? = null,
        var birthPlace: String? = null
    ) {
        fun withName(name: String) = apply { this.name = name }
        fun withSurname(surname: String) = apply { this.surname = surname }
        fun withAge(age: Int) = apply {this.age = age}
        fun withBirthPlace(birthPlace: String) = apply {this.birthPlace = birthPlace}
        fun build ():Person = Person(name,surname,age,birthPlace)
    }
    override fun toString(): String {
        var result = ""
        if (name != null) result += "Имя: $name "
        if (surname != null) result += "Фамилия: $surname "
        if (age != null) result += "Возраст: $age "
        if (birthPlace != null) result += "Место рождения: $birthPlace "
        return result
    }
}