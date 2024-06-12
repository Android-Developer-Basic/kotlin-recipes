package ru.otus.homework.patterns

fun main() {
    val user = User.Builder(
        firstName = "John",
        lastName = "Doe",
        age = 30,
        email = "john.doe@example.com")
        .build()

    println("User: ${user.firstName} ${user.lastName}, Age: ${user.age}, Email: ${user.email}")
}

class User private constructor(
    var firstName: String,
    val lastName: String,
    val age: Int,
    val email: String
) {
    data class Builder(
        var firstName: String = "",
        var lastName: String = "",
        var age: Int = 0,
        var email: String = ""
    ) {
        fun build(): User {
            return User(firstName, lastName, age, email)
        }
    }
}